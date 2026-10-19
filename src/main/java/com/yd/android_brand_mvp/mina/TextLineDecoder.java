package com.yd.android_brand_mvp.mina;

import androidx.work.Data;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderException;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.RecoverableProtocolDecoderException;
import org.apache.mina.filter.codec.textline.LineDelimiter;

/* JADX INFO: loaded from: classes4.dex */
public class TextLineDecoder implements ProtocolDecoder {
    private final AttributeKey CONTEXT;
    private int bufferLength;
    private final Charset charset;
    private IoBuffer delimBuf;
    private final LineDelimiter delimiter;
    private int maxLineLength;

    @Override // org.apache.mina.filter.codec.ProtocolDecoder
    public void finishDecode(IoSession ioSession, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {
    }

    public TextLineDecoder() {
        this(LineDelimiter.AUTO);
    }

    public TextLineDecoder(String str) {
        this(new LineDelimiter(str));
    }

    public TextLineDecoder(LineDelimiter lineDelimiter) {
        this(Charset.defaultCharset(), lineDelimiter);
    }

    public TextLineDecoder(Charset charset) {
        this(charset, LineDelimiter.AUTO);
    }

    public TextLineDecoder(Charset charset, String str) {
        this(charset, new LineDelimiter(str));
    }

    public TextLineDecoder(Charset charset, LineDelimiter lineDelimiter) {
        this.CONTEXT = new AttributeKey(getClass(), "context");
        this.maxLineLength = Data.MAX_DATA_BYTES;
        this.bufferLength = 128;
        if (charset == null) {
            throw new IllegalArgumentException("charset parameter shuld not be null");
        }
        if (lineDelimiter == null) {
            throw new IllegalArgumentException("delimiter parameter should not be null");
        }
        this.charset = charset;
        this.delimiter = lineDelimiter;
        if (this.delimBuf == null) {
            IoBuffer autoExpand = IoBuffer.allocate(2).setAutoExpand(true);
            try {
                autoExpand.putString(lineDelimiter.getValue(), charset.newEncoder());
            } catch (CharacterCodingException unused) {
            }
            autoExpand.flip();
            this.delimBuf = autoExpand;
        }
    }

    public int getMaxLineLength() {
        return this.maxLineLength;
    }

    public void setMaxLineLength(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxLineLength (" + i + ") should be a positive value");
        }
        this.maxLineLength = i;
    }

    public void setBufferLength(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("bufferLength (" + this.maxLineLength + ") should be a positive value");
        }
        this.bufferLength = i;
    }

    public int getBufferLength() {
        return this.bufferLength;
    }

    @Override // org.apache.mina.filter.codec.ProtocolDecoder
    public void decode(IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {
        Context context = getContext(ioSession);
        if (LineDelimiter.AUTO.equals(this.delimiter)) {
            decodeAuto(context, ioSession, ioBuffer, protocolDecoderOutput);
        } else {
            decodeNormal(context, ioSession, ioBuffer, protocolDecoderOutput);
        }
    }

    private Context getContext(IoSession ioSession) {
        Context context = (Context) ioSession.getAttribute(this.CONTEXT);
        if (context != null) {
            return context;
        }
        Context context2 = new Context(this.bufferLength);
        ioSession.setAttribute(this.CONTEXT, context2);
        return context2;
    }

    @Override // org.apache.mina.filter.codec.ProtocolDecoder
    public void dispose(IoSession ioSession) throws Exception {
        if (((Context) ioSession.getAttribute(this.CONTEXT)) != null) {
            ioSession.removeAttribute(this.CONTEXT);
        }
    }

    private void decodeAuto(Context context, IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput protocolDecoderOutput) throws CharacterCodingException, ProtocolDecoderException {
        boolean z;
        int matchCount = context.getMatchCount();
        int iPosition = ioBuffer.position();
        int iLimit = ioBuffer.limit();
        while (ioBuffer.hasRemaining()) {
            byte b = ioBuffer.get();
            if (b != 10) {
                matchCount = b != 13 ? 0 : matchCount + 1;
                z = false;
            } else {
                matchCount++;
                z = true;
            }
            if (z) {
                int iPosition2 = ioBuffer.position();
                ioBuffer.limit(iPosition2);
                ioBuffer.position(iPosition);
                context.append(ioBuffer);
                ioBuffer.limit(iLimit);
                ioBuffer.position(iPosition2);
                if (context.getOverflowPosition() == 0) {
                    IoBuffer buffer = context.getBuffer();
                    buffer.flip();
                    buffer.limit(buffer.limit() - matchCount);
                    try {
                        byte[] bArr = new byte[buffer.limit()];
                        buffer.get(bArr);
                        writeText(ioSession, context.getDecoder().decode(ByteBuffer.wrap(bArr)).toString(), protocolDecoderOutput);
                        buffer.clear();
                        iPosition = iPosition2;
                        matchCount = 0;
                    } catch (Throwable th) {
                        buffer.clear();
                        throw th;
                    }
                } else {
                    int overflowPosition = context.getOverflowPosition();
                    context.reset();
                    throw new RecoverableProtocolDecoderException("Line is too long: " + overflowPosition);
                }
            }
        }
        ioBuffer.position(iPosition);
        context.append(ioBuffer);
        context.setMatchCount(matchCount);
    }

    private void decodeNormal(Context context, IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput protocolDecoderOutput) throws CharacterCodingException, ProtocolDecoderException {
        int matchCount = context.getMatchCount();
        int iPosition = ioBuffer.position();
        int iLimit = ioBuffer.limit();
        while (ioBuffer.hasRemaining()) {
            if (this.delimBuf.get(matchCount) == ioBuffer.get()) {
                matchCount++;
                if (matchCount == this.delimBuf.limit()) {
                    int iPosition2 = ioBuffer.position();
                    ioBuffer.limit(iPosition2);
                    ioBuffer.position(iPosition);
                    context.append(ioBuffer);
                    ioBuffer.limit(iLimit);
                    ioBuffer.position(iPosition2);
                    if (context.getOverflowPosition() == 0) {
                        IoBuffer buffer = context.getBuffer();
                        buffer.flip();
                        buffer.limit(buffer.limit() - matchCount);
                        try {
                            writeText(ioSession, buffer.getString(context.getDecoder()), protocolDecoderOutput);
                            buffer.clear();
                            iPosition = iPosition2;
                        } catch (Throwable th) {
                            buffer.clear();
                            throw th;
                        }
                    } else {
                        int overflowPosition = context.getOverflowPosition();
                        context.reset();
                        throw new RecoverableProtocolDecoderException("Line is too long: " + overflowPosition);
                    }
                } else {
                    continue;
                }
            } else {
                ioBuffer.position(Math.max(0, ioBuffer.position() - matchCount));
            }
            matchCount = 0;
        }
        ioBuffer.position(iPosition);
        context.append(ioBuffer);
        context.setMatchCount(matchCount);
    }

    protected void writeText(IoSession ioSession, String str, ProtocolDecoderOutput protocolDecoderOutput) {
        protocolDecoderOutput.write(str);
    }

    private class Context {
        private final IoBuffer buf;
        private final CharsetDecoder decoder;
        private int matchCount;
        private int overflowPosition;

        private Context(int i) {
            this.matchCount = 0;
            this.overflowPosition = 0;
            this.decoder = TextLineDecoder.this.charset.newDecoder();
            this.buf = IoBuffer.allocate(i).setAutoExpand(true);
        }

        public CharsetDecoder getDecoder() {
            return this.decoder;
        }

        public IoBuffer getBuffer() {
            return this.buf;
        }

        public int getOverflowPosition() {
            return this.overflowPosition;
        }

        public int getMatchCount() {
            return this.matchCount;
        }

        public void setMatchCount(int i) {
            this.matchCount = i;
        }

        public void reset() {
            this.overflowPosition = 0;
            this.matchCount = 0;
            this.decoder.reset();
        }

        public void append(IoBuffer ioBuffer) {
            if (this.overflowPosition == 0) {
                if (this.buf.position() > TextLineDecoder.this.maxLineLength - ioBuffer.remaining()) {
                    this.overflowPosition = this.buf.position();
                    this.buf.clear();
                    discard(ioBuffer);
                    return;
                }
                getBuffer().put(ioBuffer);
                return;
            }
            discard(ioBuffer);
        }

        private void discard(IoBuffer ioBuffer) {
            int iRemaining = Integer.MAX_VALUE - ioBuffer.remaining();
            int i = this.overflowPosition;
            if (iRemaining < i) {
                this.overflowPosition = Integer.MAX_VALUE;
            } else {
                this.overflowPosition = i + ioBuffer.remaining();
            }
            ioBuffer.position(ioBuffer.limit());
        }
    }
}
