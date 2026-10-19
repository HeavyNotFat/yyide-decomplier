package com.yd.android_brand_mvp.network.exception;

import com.heytap.mcssdk.a.a;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlobalException.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000b2\u00060\u0001j\u0002`\u0002:\u0001\u000bB\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0006H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/network/exception/GlobalException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", a.j, "", "message", "", "(ILjava/lang/String;)V", "getCode", "()I", "toString", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GlobalException extends RuntimeException {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int code;

    public /* synthetic */ GlobalException(int i, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str);
    }

    @JvmStatic
    public static final GlobalException of(int i, String str) {
        return INSTANCE.of(i, str);
    }

    private GlobalException(int i, String str) {
        super(str);
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "exception code is " + this.code + " msg is " + getMessage();
    }

    /* JADX INFO: compiled from: GlobalException.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/network/exception/GlobalException$Companion;", "", "()V", "of", "Lcom/yd/android_brand_mvp/network/exception/GlobalException;", a.j, "", "message", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GlobalException of(int code, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new GlobalException(code, message, null);
        }
    }
}
