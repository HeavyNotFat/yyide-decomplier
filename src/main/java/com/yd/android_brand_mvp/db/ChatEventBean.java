package com.yd.android_brand_mvp.db;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChatEventBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/db/ChatEventBean;", "", "type", "", "chatType", "id", "", "chatName", "(IILjava/lang/String;Ljava/lang/String;)V", "getChatName", "()Ljava/lang/String;", "getChatType", "()I", "getId", "getType", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ChatEventBean {
    private final String chatName;
    private final int chatType;
    private final String id;
    private final int type;

    public ChatEventBean(int i, int i2, String id, String chatName) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(chatName, "chatName");
        this.type = i;
        this.chatType = i2;
        this.id = id;
        this.chatName = chatName;
    }

    public final String getChatName() {
        return this.chatName;
    }

    public final int getChatType() {
        return this.chatType;
    }

    public final String getId() {
        return this.id;
    }

    public final int getType() {
        return this.type;
    }
}
