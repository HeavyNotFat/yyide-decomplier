package com.yd.android_brand_mvp.mqtt;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

/* JADX INFO: compiled from: SSLUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J,\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/yd/android_brand_mvp/mqtt/SSLUtils;", "", "()V", "getSingleSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "caCrtFileInputStream", "Ljava/io/InputStream;", "getSocketFactory", "caCrtFile", "crtFile", "keyFile", "password", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SSLUtils {
    public static final SSLUtils INSTANCE = new SSLUtils();

    private SSLUtils() {
    }

    public final SSLSocketFactory getSingleSocketFactory(InputStream caCrtFileInputStream) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        BufferedInputStream bufferedInputStream = new BufferedInputStream(caCrtFileInputStream);
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        X509Certificate x509Certificate = null;
        while (bufferedInputStream.available() > 0) {
            Certificate certificateGenerateCertificate = certificateFactory.generateCertificate(bufferedInputStream);
            Intrinsics.checkNotNull(certificateGenerateCertificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            x509Certificate = (X509Certificate) certificateGenerateCertificate;
        }
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        keyStore.setCertificateEntry("cert-certificate", x509Certificate);
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
        sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        Intrinsics.checkNotNullExpressionValue(socketFactory, "sslContext.socketFactory");
        return socketFactory;
    }

    public final SSLSocketFactory getSocketFactory(InputStream caCrtFile, InputStream crtFile, InputStream keyFile, String password) throws Exception {
        Intrinsics.checkNotNullParameter(password, "password");
        Security.addProvider(new BouncyCastleProvider());
        BufferedInputStream bufferedInputStream = new BufferedInputStream(caCrtFile);
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        X509Certificate x509Certificate = null;
        while (bufferedInputStream.available() > 0) {
            Certificate certificateGenerateCertificate = certificateFactory.generateCertificate(bufferedInputStream);
            Intrinsics.checkNotNull(certificateGenerateCertificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            x509Certificate = (X509Certificate) certificateGenerateCertificate;
        }
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(crtFile);
        X509Certificate x509Certificate2 = null;
        while (bufferedInputStream2.available() > 0) {
            Certificate certificateGenerateCertificate2 = certificateFactory.generateCertificate(bufferedInputStream2);
            Intrinsics.checkNotNull(certificateGenerateCertificate2, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            x509Certificate2 = (X509Certificate) certificateGenerateCertificate2;
        }
        Object object = new PEMParser(new InputStreamReader(keyFile)).readObject();
        Intrinsics.checkNotNullExpressionValue(object, "pemParser.readObject()");
        JcaPEMKeyConverter provider = new JcaPEMKeyConverter().setProvider(BouncyCastleProvider.PROVIDER_NAME);
        Intrinsics.checkNotNullExpressionValue(provider, "JcaPEMKeyConverter().setProvider(\"BC\")");
        KeyPair keyPair = provider.getKeyPair((PEMKeyPair) object);
        Intrinsics.checkNotNullExpressionValue(keyPair, "converter.getKeyPair(`object` as PEMKeyPair)");
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        keyStore.setCertificateEntry("cert-certificate", x509Certificate);
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        KeyStore keyStore2 = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore2.load(null, null);
        X509Certificate x509Certificate3 = x509Certificate2;
        keyStore2.setCertificateEntry("certificate", x509Certificate3);
        PrivateKey privateKey = keyPair.getPrivate();
        char[] charArray = password.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        keyStore2.setKeyEntry("private-cert", privateKey, charArray, new Certificate[]{x509Certificate3});
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        char[] charArray2 = password.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray2, "this as java.lang.String).toCharArray()");
        keyManagerFactory.init(keyStore2, charArray2);
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
        sSLContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        Intrinsics.checkNotNullExpressionValue(socketFactory, "context.socketFactory");
        return socketFactory;
    }
}
