package com.yd.android_brand_mvp.p000enum;

import kotlin.Metadata;

/* JADX INFO: compiled from: ThemeTStyleEnum.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/enum/ThemeTStyleEnum;", "", "id", "", "key", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getId", "()I", "getKey", "()Ljava/lang/String;", "SKYWORTH", "ANIMATION", "NORMAL", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum ThemeTStyleEnum {
    SKYWORTH(1, "创维"),
    ANIMATION(2, "卡通"),
    NORMAL(3, "通用");

    private final int id;
    private final String key;

    ThemeTStyleEnum(int i, String str) {
        this.id = i;
        this.key = str;
    }

    public final int getId() {
        return this.id;
    }

    public final String getKey() {
        return this.key;
    }
}
