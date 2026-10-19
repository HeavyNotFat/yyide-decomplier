package com.yd.android_brand_mvp.mina;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.textline.LineDelimiter;

/* JADX INFO: loaded from: classes4.dex */
public class TextLineEncoder extends ProtocolEncoderAdapter {
    private static final AttributeKey ENCODER = new AttributeKey(TextLineEncoder.class, "encoder");
    private final Charset charset;
    private final LineDelimiter delimiter;
    private int maxLineLength;

    public void dispose() throws Exception {
    }

    public TextLineEncoder() {
        this(Charset.defaultCharset(), LineDelimiter.UNIX);
    }

    public TextLineEncoder(String str) {
        this(new LineDelimiter(str));
    }

    public TextLineEncoder(LineDelimiter lineDelimiter) {
        this(Charset.defaultCharset(), lineDelimiter);
    }

    public TextLineEncoder(Charset charset) {
        this(charset, LineDelimiter.UNIX);
    }

    public TextLineEncoder(Charset charset, String str) {
        this(charset, new LineDelimiter(str));
    }

    public TextLineEncoder(Charset charset, LineDelimiter lineDelimiter) {
        this.maxLineLength = Integer.MAX_VALUE;
        if (charset == null) {
            throw new IllegalArgumentException("charset");
        }
        if (lineDelimiter == null) {
            throw new IllegalArgumentException(TtmlNode.RUBY_DELIMITER);
        }
        if (LineDelimiter.AUTO.equals(lineDelimiter)) {
            throw new IllegalArgumentException("AUTO delimiter is not allowed for encoder.");
        }
        this.charset = charset;
        this.delimiter = lineDelimiter;
    }

    public int getMaxLineLength() {
        return this.maxLineLength;
    }

    public void setMaxLineLength(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxLineLength: " + i);
        }
        this.maxLineLength = i;
    }

    @Override // org.apache.mina.filter.codec.ProtocolEncoder
    public void encode(IoSession ioSession, Object obj, ProtocolEncoderOutput protocolEncoderOutput) throws Exception {
        CharsetEncoder charsetEncoderNewEncoder = (CharsetEncoder) ioSession.getAttribute(ENCODER);
        if (charsetEncoderNewEncoder == null) {
            charsetEncoderNewEncoder = this.charset.newEncoder();
            ioSession.setAttribute(ENCODER, charsetEncoderNewEncoder);
        }
        String string = obj == null ? "" : obj.toString();
        IoBuffer autoExpand = IoBuffer.allocate(string.length()).setAutoExpand(true);
        autoExpand.putString(string, charsetEncoderNewEncoder);
        if (autoExpand.position() > this.maxLineLength) {
            throw new IllegalArgumentException("Line length: " + autoExpand.position());
        }
        autoExpand.putString(this.delimiter.getValue(), charsetEncoderNewEncoder);
        autoExpand.flip();
        protocolEncoderOutput.write(autoExpand);
    }
}
