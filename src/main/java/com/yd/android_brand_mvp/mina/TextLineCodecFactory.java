package com.yd.android_brand_mvp.mina;

import java.nio.charset.Charset;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.textline.LineDelimiter;

/* JADX INFO: loaded from: classes4.dex */
public class TextLineCodecFactory implements ProtocolCodecFactory {
    private final TextLineDecoder decoder;
    private final TextLineEncoder encoder;

    public TextLineCodecFactory() {
        this(Charset.defaultCharset());
    }

    public TextLineCodecFactory(Charset charset) {
        this.encoder = new TextLineEncoder(charset, LineDelimiter.UNIX);
        this.decoder = new TextLineDecoder(charset, LineDelimiter.AUTO);
    }

    public TextLineCodecFactory(Charset charset, String str, String str2) {
        this.encoder = new TextLineEncoder(charset, str);
        this.decoder = new TextLineDecoder(charset, str2);
    }

    public TextLineCodecFactory(Charset charset, LineDelimiter lineDelimiter, LineDelimiter lineDelimiter2) {
        this.encoder = new TextLineEncoder(charset, lineDelimiter);
        this.decoder = new TextLineDecoder(charset, lineDelimiter2);
    }

    @Override // org.apache.mina.filter.codec.ProtocolCodecFactory
    public ProtocolEncoder getEncoder(IoSession ioSession) {
        return this.encoder;
    }

    @Override // org.apache.mina.filter.codec.ProtocolCodecFactory
    public ProtocolDecoder getDecoder(IoSession ioSession) {
        return this.decoder;
    }

    public int getEncoderMaxLineLength() {
        return this.encoder.getMaxLineLength();
    }

    public void setEncoderMaxLineLength(int i) {
        this.encoder.setMaxLineLength(i);
    }

    public int getDecoderMaxLineLength() {
        return this.decoder.getMaxLineLength();
    }

    public void setDecoderMaxLineLength(int i) {
        this.decoder.setMaxLineLength(i);
    }
}
