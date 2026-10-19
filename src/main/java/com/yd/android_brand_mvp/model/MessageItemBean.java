package com.yd.android_brand_mvp.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yd.android_brand_mvp.model.message.DocumentBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.cms.CMSAttributeTableGenerator;
import org.bouncycastle.i18n.ErrorBundle;

/* JADX INFO: compiled from: MessageListBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BÕ\u0001\b\u0007\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0007\u001a\u00020\b\u0012\b\b\u0003\u0010\t\u001a\u00020\u0005\u0012\u0010\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\b\u0003\u0010\r\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u000f\u001a\u00020\b\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0003\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0016\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b¢\u0006\u0002\u0010\u001dJ\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0012HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0012HÆ\u0003J\u000f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000bHÆ\u0003J\t\u0010R\u001a\u00020\bHÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\bHÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\u0011\u0010V\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\bHÆ\u0003J\t\u0010Z\u001a\u00020\u0005HÆ\u0003J×\u0001\u0010[\u001a\u00020\u00002\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\u00052\u0010\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0003\u0010\r\u001a\u00020\u00052\b\b\u0003\u0010\u000e\u001a\u00020\u00052\b\b\u0003\u0010\u000f\u001a\u00020\b2\b\b\u0003\u0010\u0010\u001a\u00020\u00052\b\b\u0003\u0010\u0011\u001a\u00020\u00122\b\b\u0003\u0010\u0013\u001a\u00020\u00052\b\b\u0003\u0010\u0014\u001a\u00020\u00052\b\b\u0003\u0010\u0015\u001a\u00020\u00052\b\b\u0003\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00122\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\bHÆ\u0001J\t\u0010\\\u001a\u00020\bHÖ\u0001J\u0013\u0010]\u001a\u00020\u00122\b\u0010^\u001a\u0004\u0018\u00010_HÖ\u0003J\t\u0010`\u001a\u00020\bHÖ\u0001J\t\u0010a\u001a\u00020\u0005HÖ\u0001J\u0019\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\bHÖ\u0001R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010#\"\u0004\b2\u0010%R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010#\"\u0004\b6\u0010%R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010#\"\u0004\b8\u0010%R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u00109\"\u0004\b:\u0010;R\u001a\u0010\u0019\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u00109\"\u0004\b<\u0010;R\u0014\u0010\u001c\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010*R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010#\"\u0004\b?\u0010%R\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010*\"\u0004\bA\u0010,R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010#\"\u0004\bC\u0010%R\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010#\"\u0004\bE\u0010%R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010#\"\u0004\bG\u0010%¨\u0006g"}, d2 = {"Lcom/yd/android_brand_mvp/model/MessageItemBean;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "author", "", "content", CMSAttributeTableGenerator.CONTENT_TYPE, "", "coverImg", ErrorBundle.DETAIL_ENTRY, "", "Lcom/yd/android_brand_mvp/model/MessageDetail;", "id", "identityUserName", "messType", FirebaseAnalytics.Param.SOURCE, "isDominateScreen", "", "dominateStartTime", "dominateEndTime", "timerDate", "title", "messJson", "contentImg", "isTop", "attachments", "Lcom/yd/android_brand_mvp/model/message/DocumentBean;", "itemType", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;I)V", "getAttachments", "()Ljava/util/List;", "setAttachments", "(Ljava/util/List;)V", "getAuthor", "()Ljava/lang/String;", "setAuthor", "(Ljava/lang/String;)V", "getContent", "setContent", "getContentImg", "getContentType", "()I", "setContentType", "(I)V", "getCoverImg", "setCoverImg", "getDetails", "setDetails", "getDominateEndTime", "setDominateEndTime", "getDominateStartTime", "setDominateStartTime", "getId", "setId", "getIdentityUserName", "setIdentityUserName", "()Z", "setDominateScreen", "(Z)V", "setTop", "getItemType", "getMessJson", "setMessJson", "getMessType", "setMessType", "getSource", "setSource", "getTimerDate", "setTimerDate", "getTitle", "setTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MessageItemBean implements Serializable, Parcelable, MultiItemEntity {
    public static final Parcelable.Creator<MessageItemBean> CREATOR = new Creator();
    private List<DocumentBean> attachments;
    private String author;
    private String content;
    private final String contentImg;
    private int contentType;
    private String coverImg;
    private List<MessageDetail> details;
    private String dominateEndTime;
    private String dominateStartTime;
    private String id;
    private String identityUserName;
    private boolean isDominateScreen;
    private boolean isTop;
    private final int itemType;
    private String messJson;
    private int messType;
    private String source;
    private String timerDate;
    private String title;

    /* JADX INFO: compiled from: MessageListBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MessageItemBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MessageItemBean createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i = parcel.readInt();
            String string3 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i2);
                for (int i3 = 0; i3 != i2; i3++) {
                    arrayList2.add(parcel.readSerializable());
                }
                arrayList = arrayList2;
            }
            ArrayList arrayList3 = arrayList;
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            int i4 = parcel.readInt();
            String string6 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            String string9 = parcel.readString();
            String string10 = parcel.readString();
            String string11 = parcel.readString();
            String string12 = parcel.readString();
            boolean z2 = parcel.readInt() != 0;
            int i5 = parcel.readInt();
            ArrayList arrayList4 = new ArrayList(i5);
            int i6 = 0;
            while (i6 != i5) {
                arrayList4.add(DocumentBean.CREATOR.createFromParcel(parcel));
                i6++;
                i5 = i5;
            }
            return new MessageItemBean(string, string2, i, string3, arrayList3, string4, string5, i4, string6, z, string7, string8, string9, string10, string11, string12, z2, arrayList4, parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MessageItemBean[] newArray(int i) {
            return new MessageItemBean[i];
        }
    }

    public MessageItemBean() {
        this(null, null, 0, null, null, null, null, 0, null, false, null, null, null, null, null, null, false, null, 0, 524287, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageItemBean(@JSONField(name = "author") String author) {
        this(author, null, 0, null, null, null, null, 0, null, false, null, null, null, null, null, null, false, null, 0, 524286, null);
        Intrinsics.checkNotNullParameter(author, "author");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageItemBean(@JSONField(name = "author") String author, @JSONField(name = "content") String content) {
        this(author, content, 0, null, null, null, null, 0, null, false, null, null, null, null, null, null, false, null, 0, 524284, null);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageItemBean(@JSONField(name = "author") String author, @JSONField(name = "content") String content, @JSONField(name = CMSAttributeTableGenerator.CONTENT_TYPE) int i) {
        this(author, content, i, null, null, null, null, 0, null, false, null, null, null, null, null, null, false, null, 0, 524280, null);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageItemBean(@JSONField(name = "author") String author, @JSONField(name = "content") String content, @JSONField(name = CMSAttributeTableGenerator.CONTENT_TYPE) int i, @JSONField(name = "coverImg") String coverImg) {
        this(author, content, i, coverImg, null, null, null, 0, null, false, null, null, null, null, null, null, false, null, 0, 524272, null);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageItemBean(@JSONField(name = "author") String author, @JSONField(name = "content") String content, @JSONField(name = CMSAttributeTableGenerator.CONTENT_TYPE) int i, @JSONField(name = "coverImg") String coverImg, @JSONField(name = ErrorBundle.DETAIL_ENTRY) List<MessageDetail> list) {
        this(author, content, i, coverImg, list, null, null, 0, null, false, null, null, null, null, null, null, false, null, 0, 524256, null);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageItemBean(@JSONField(name = "author") String author, @JSONField(name = "content") String content, @JSONField(name = CMSAttributeTableGenerator.CONTENT_TYPE) int i, @JSONField(name = "coverImg") String coverImg, @JSONField(name = ErrorBundle.DETAIL_ENTRY) List<MessageDetail> list, @JSONField(name = "id") String id) {
        this(author, content, i, coverImg, list, id, null, 0, null, false, null, null, null, null, null, null, false, null, 0, 524224, null);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(id, "id");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageItemBean(@JSONField(name = "author") String author, @JSONField(name = "content") String content, @JSONField(name = CMSAttributeTableGenerator.CONTENT_TYPE) int i, @JSONField(name = "coverImg") String coverImg, @JSONField(name = ErrorBundle.DETAIL_ENTRY) List<MessageDetail> list, @JSONField(name = "id") String id, @JSONField(name = "identityUserName") String identityUserName) {
        this(author, content, i, coverImg, list, id, identityUserName, 0, null, false, null, null, null, null, null, null, false, null, 0, 524160, null);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identityUserName, "identityUserName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageItemBean(@JSONField(name = "author") String author, @JSONField(name = "content") String content, @JSONField(name = CMSAttributeTableGenerator.CONTENT_TYPE) int i, @JSONField(name = "coverImg") String coverImg, @JSONField(name = ErrorBundle.DETAIL_ENTRY) List<MessageDetail> list, @JSONField(name = "id") String id, @JSONField(name = "identityUserName") String identityUserName, @JSONField(name = "messType") int i2) {
        this(author, content, i, coverImg, list, id, identityUserName, i2, null, false, null, null, null, null, null, null, false, null, 0, 524032, null);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identityUserName, "identityUserName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageItemBean(@JSONField(name = "author") String author, @JSONField(name = "content") String content, @JSONField(name = CMSAttributeTableGenerator.CONTENT_TYPE) int i, @JSONField(name = "coverImg") String coverImg, @JSONField(name = ErrorBundle.DETAIL_ENTRY) List<MessageDetail> list, @JSONField(name = "id") String id, @JSONField(name = "identityUserName") String identityUserName, @JSONField(name = "messType") int i2, @JSONField(name = FirebaseAnalytics.Param.SOURCE) String source) {
        this(author, content, i, coverImg, list, id, identityUserName, i2, source, false, null, null, null, null, null, null, false, null, 0, 523776, null);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identityUserName, "identityUserName");
        Intrinsics.checkNotNullParameter(source, "source");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageItemBean(@JSONField(name = "author") String author, @JSONField(name = "content") String content, @JSONField(name = CMSAttributeTableGenerator.CONTENT_TYPE) int i, @JSONField(name = "coverImg") String coverImg, @JSONField(name = ErrorBundle.DETAIL_ENTRY) List<MessageDetail> list, @JSONField(name = "id") String id, @JSONField(name = "identityUserName") String identityUserName, @JSONField(name = "messType") int i2, @JSONField(name = FirebaseAnalytics.Param.SOURCE) String source, @JSONField(name = "isDominateScreen") boolean z) {
        this(author, content, i, coverImg, list, id, identityUserName, i2, source, z, null, null, null, null, null, null, false, null, 0, 523264, null);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identityUserName, "identityUserName");
        Intrinsics.checkNotNullParameter(source, "source");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageItemBean(@JSONField(name = "author") String author, @JSONField(name = "content") String content, @JSONField(name = CMSAttributeTableGenerator.CONTENT_TYPE) int i, @JSONField(name = "coverImg") String coverImg, @JSONField(name = ErrorBundle.DETAIL_ENTRY) List<MessageDetail> list, @JSONField(name = "id") String id, @JSONField(name = "identityUserName") String identityUserName, @JSONField(name = "messType") int i2, @JSONField(name = FirebaseAnalytics.Param.SOURCE) String source, @JSONField(name = "isDominateScreen") boolean z, @JSONField(name = "dominateStartTime") String dominateStartTime) {
        this(author, content, i, coverImg, list, id, identityUserName, i2, source, z, dominateStartTime, null, null, null, null, null, false, null, 0, 522240, null);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identityUserName, "identityUserName");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dominateStartTime, "dominateStartTime");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageItemBean(@JSONField(name = "author") String author, @JSONField(name = "content") String content, @JSONField(name = CMSAttributeTableGenerator.CONTENT_TYPE) int i, @JSONField(name = "coverImg") String coverImg, @JSONField(name = ErrorBundle.DETAIL_ENTRY) List<MessageDetail> list, @JSONField(name = "id") String id, @JSONField(name = "identityUserName") String identityUserName, @JSONField(name = "messType") int i2, @JSONField(name = FirebaseAnalytics.Param.SOURCE) String source, @JSONField(name = "isDominateScreen") boolean z, @JSONField(name = "dominateStartTime") String dominateStartTime, @JSONField(name = "dominateEndTime") String dominateEndTime) {
        this(author, content, i, coverImg, list, id, identityUserName, i2, source, z, dominateStartTime, dominateEndTime, null, null, null, null, false, null, 0, 520192, null);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identityUserName, "identityUserName");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dominateStartTime, "dominateStartTime");
        Intrinsics.checkNotNullParameter(dominateEndTime, "dominateEndTime");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageItemBean(@JSONField(name = "author") String author, @JSONField(name = "content") String content, @JSONField(name = CMSAttributeTableGenerator.CONTENT_TYPE) int i, @JSONField(name = "coverImg") String coverImg, @JSONField(name = ErrorBundle.DETAIL_ENTRY) List<MessageDetail> list, @JSONField(name = "id") String id, @JSONField(name = "identityUserName") String identityUserName, @JSONField(name = "messType") int i2, @JSONField(name = FirebaseAnalytics.Param.SOURCE) String source, @JSONField(name = "isDominateScreen") boolean z, @JSONField(name = "dominateStartTime") String dominateStartTime, @JSONField(name = "dominateEndTime") String dominateEndTime, @JSONField(name = "timerDate") String timerDate) {
        this(author, content, i, coverImg, list, id, identityUserName, i2, source, z, dominateStartTime, dominateEndTime, timerDate, null, null, null, false, null, 0, 516096, null);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identityUserName, "identityUserName");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dominateStartTime, "dominateStartTime");
        Intrinsics.checkNotNullParameter(dominateEndTime, "dominateEndTime");
        Intrinsics.checkNotNullParameter(timerDate, "timerDate");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageItemBean(@JSONField(name = "author") String author, @JSONField(name = "content") String content, @JSONField(name = CMSAttributeTableGenerator.CONTENT_TYPE) int i, @JSONField(name = "coverImg") String coverImg, @JSONField(name = ErrorBundle.DETAIL_ENTRY) List<MessageDetail> list, @JSONField(name = "id") String id, @JSONField(name = "identityUserName") String identityUserName, @JSONField(name = "messType") int i2, @JSONField(name = FirebaseAnalytics.Param.SOURCE) String source, @JSONField(name = "isDominateScreen") boolean z, @JSONField(name = "dominateStartTime") String dominateStartTime, @JSONField(name = "dominateEndTime") String dominateEndTime, @JSONField(name = "timerDate") String timerDate, @JSONField(name = "title") String title) {
        this(author, content, i, coverImg, list, id, identityUserName, i2, source, z, dominateStartTime, dominateEndTime, timerDate, title, null, null, false, null, 0, 507904, null);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identityUserName, "identityUserName");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dominateStartTime, "dominateStartTime");
        Intrinsics.checkNotNullParameter(dominateEndTime, "dominateEndTime");
        Intrinsics.checkNotNullParameter(timerDate, "timerDate");
        Intrinsics.checkNotNullParameter(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageItemBean(@JSONField(name = "author") String author, @JSONField(name = "content") String content, @JSONField(name = CMSAttributeTableGenerator.CONTENT_TYPE) int i, @JSONField(name = "coverImg") String coverImg, @JSONField(name = ErrorBundle.DETAIL_ENTRY) List<MessageDetail> list, @JSONField(name = "id") String id, @JSONField(name = "identityUserName") String identityUserName, @JSONField(name = "messType") int i2, @JSONField(name = FirebaseAnalytics.Param.SOURCE) String source, @JSONField(name = "isDominateScreen") boolean z, @JSONField(name = "dominateStartTime") String dominateStartTime, @JSONField(name = "dominateEndTime") String dominateEndTime, @JSONField(name = "timerDate") String timerDate, @JSONField(name = "title") String title, String str) {
        this(author, content, i, coverImg, list, id, identityUserName, i2, source, z, dominateStartTime, dominateEndTime, timerDate, title, str, null, false, null, 0, 491520, null);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identityUserName, "identityUserName");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dominateStartTime, "dominateStartTime");
        Intrinsics.checkNotNullParameter(dominateEndTime, "dominateEndTime");
        Intrinsics.checkNotNullParameter(timerDate, "timerDate");
        Intrinsics.checkNotNullParameter(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageItemBean(@JSONField(name = "author") String author, @JSONField(name = "content") String content, @JSONField(name = CMSAttributeTableGenerator.CONTENT_TYPE) int i, @JSONField(name = "coverImg") String coverImg, @JSONField(name = ErrorBundle.DETAIL_ENTRY) List<MessageDetail> list, @JSONField(name = "id") String id, @JSONField(name = "identityUserName") String identityUserName, @JSONField(name = "messType") int i2, @JSONField(name = FirebaseAnalytics.Param.SOURCE) String source, @JSONField(name = "isDominateScreen") boolean z, @JSONField(name = "dominateStartTime") String dominateStartTime, @JSONField(name = "dominateEndTime") String dominateEndTime, @JSONField(name = "timerDate") String timerDate, @JSONField(name = "title") String title, String str, String contentImg) {
        this(author, content, i, coverImg, list, id, identityUserName, i2, source, z, dominateStartTime, dominateEndTime, timerDate, title, str, contentImg, false, null, 0, 458752, null);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identityUserName, "identityUserName");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dominateStartTime, "dominateStartTime");
        Intrinsics.checkNotNullParameter(dominateEndTime, "dominateEndTime");
        Intrinsics.checkNotNullParameter(timerDate, "timerDate");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(contentImg, "contentImg");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageItemBean(@JSONField(name = "author") String author, @JSONField(name = "content") String content, @JSONField(name = CMSAttributeTableGenerator.CONTENT_TYPE) int i, @JSONField(name = "coverImg") String coverImg, @JSONField(name = ErrorBundle.DETAIL_ENTRY) List<MessageDetail> list, @JSONField(name = "id") String id, @JSONField(name = "identityUserName") String identityUserName, @JSONField(name = "messType") int i2, @JSONField(name = FirebaseAnalytics.Param.SOURCE) String source, @JSONField(name = "isDominateScreen") boolean z, @JSONField(name = "dominateStartTime") String dominateStartTime, @JSONField(name = "dominateEndTime") String dominateEndTime, @JSONField(name = "timerDate") String timerDate, @JSONField(name = "title") String title, String str, String contentImg, boolean z2) {
        this(author, content, i, coverImg, list, id, identityUserName, i2, source, z, dominateStartTime, dominateEndTime, timerDate, title, str, contentImg, z2, null, 0, 393216, null);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identityUserName, "identityUserName");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dominateStartTime, "dominateStartTime");
        Intrinsics.checkNotNullParameter(dominateEndTime, "dominateEndTime");
        Intrinsics.checkNotNullParameter(timerDate, "timerDate");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(contentImg, "contentImg");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageItemBean(@JSONField(name = "author") String author, @JSONField(name = "content") String content, @JSONField(name = CMSAttributeTableGenerator.CONTENT_TYPE) int i, @JSONField(name = "coverImg") String coverImg, @JSONField(name = ErrorBundle.DETAIL_ENTRY) List<MessageDetail> list, @JSONField(name = "id") String id, @JSONField(name = "identityUserName") String identityUserName, @JSONField(name = "messType") int i2, @JSONField(name = FirebaseAnalytics.Param.SOURCE) String source, @JSONField(name = "isDominateScreen") boolean z, @JSONField(name = "dominateStartTime") String dominateStartTime, @JSONField(name = "dominateEndTime") String dominateEndTime, @JSONField(name = "timerDate") String timerDate, @JSONField(name = "title") String title, String str, String contentImg, boolean z2, List<DocumentBean> attachments) {
        this(author, content, i, coverImg, list, id, identityUserName, i2, source, z, dominateStartTime, dominateEndTime, timerDate, title, str, contentImg, z2, attachments, 0, 262144, null);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identityUserName, "identityUserName");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dominateStartTime, "dominateStartTime");
        Intrinsics.checkNotNullParameter(dominateEndTime, "dominateEndTime");
        Intrinsics.checkNotNullParameter(timerDate, "timerDate");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(contentImg, "contentImg");
        Intrinsics.checkNotNullParameter(attachments, "attachments");
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAuthor() {
        return this.author;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsDominateScreen() {
        return this.isDominateScreen;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getDominateStartTime() {
        return this.dominateStartTime;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getDominateEndTime() {
        return this.dominateEndTime;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getTimerDate() {
        return this.timerDate;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getMessJson() {
        return this.messJson;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getContentImg() {
        return this.contentImg;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final boolean getIsTop() {
        return this.isTop;
    }

    public final List<DocumentBean> component18() {
        return this.attachments;
    }

    public final int component19() {
        return getItemType();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getContentType() {
        return this.contentType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCoverImg() {
        return this.coverImg;
    }

    public final List<MessageDetail> component5() {
        return this.details;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getIdentityUserName() {
        return this.identityUserName;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getMessType() {
        return this.messType;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    public final MessageItemBean copy(@JSONField(name = "author") String author, @JSONField(name = "content") String content, @JSONField(name = CMSAttributeTableGenerator.CONTENT_TYPE) int contentType, @JSONField(name = "coverImg") String coverImg, @JSONField(name = ErrorBundle.DETAIL_ENTRY) List<MessageDetail> details, @JSONField(name = "id") String id, @JSONField(name = "identityUserName") String identityUserName, @JSONField(name = "messType") int messType, @JSONField(name = FirebaseAnalytics.Param.SOURCE) String source, @JSONField(name = "isDominateScreen") boolean isDominateScreen, @JSONField(name = "dominateStartTime") String dominateStartTime, @JSONField(name = "dominateEndTime") String dominateEndTime, @JSONField(name = "timerDate") String timerDate, @JSONField(name = "title") String title, String messJson, String contentImg, boolean isTop, List<DocumentBean> attachments, int itemType) {
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identityUserName, "identityUserName");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dominateStartTime, "dominateStartTime");
        Intrinsics.checkNotNullParameter(dominateEndTime, "dominateEndTime");
        Intrinsics.checkNotNullParameter(timerDate, "timerDate");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(contentImg, "contentImg");
        Intrinsics.checkNotNullParameter(attachments, "attachments");
        return new MessageItemBean(author, content, contentType, coverImg, details, id, identityUserName, messType, source, isDominateScreen, dominateStartTime, dominateEndTime, timerDate, title, messJson, contentImg, isTop, attachments, itemType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageItemBean)) {
            return false;
        }
        MessageItemBean messageItemBean = (MessageItemBean) other;
        return Intrinsics.areEqual(this.author, messageItemBean.author) && Intrinsics.areEqual(this.content, messageItemBean.content) && this.contentType == messageItemBean.contentType && Intrinsics.areEqual(this.coverImg, messageItemBean.coverImg) && Intrinsics.areEqual(this.details, messageItemBean.details) && Intrinsics.areEqual(this.id, messageItemBean.id) && Intrinsics.areEqual(this.identityUserName, messageItemBean.identityUserName) && this.messType == messageItemBean.messType && Intrinsics.areEqual(this.source, messageItemBean.source) && this.isDominateScreen == messageItemBean.isDominateScreen && Intrinsics.areEqual(this.dominateStartTime, messageItemBean.dominateStartTime) && Intrinsics.areEqual(this.dominateEndTime, messageItemBean.dominateEndTime) && Intrinsics.areEqual(this.timerDate, messageItemBean.timerDate) && Intrinsics.areEqual(this.title, messageItemBean.title) && Intrinsics.areEqual(this.messJson, messageItemBean.messJson) && Intrinsics.areEqual(this.contentImg, messageItemBean.contentImg) && this.isTop == messageItemBean.isTop && Intrinsics.areEqual(this.attachments, messageItemBean.attachments) && getItemType() == messageItemBean.getItemType();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iHashCode = ((((((this.author.hashCode() * 31) + this.content.hashCode()) * 31) + this.contentType) * 31) + this.coverImg.hashCode()) * 31;
        List<MessageDetail> list = this.details;
        int iHashCode2 = (((((((((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + this.id.hashCode()) * 31) + this.identityUserName.hashCode()) * 31) + this.messType) * 31) + this.source.hashCode()) * 31;
        boolean z = this.isDominateScreen;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode3 = (((((((((iHashCode2 + r1) * 31) + this.dominateStartTime.hashCode()) * 31) + this.dominateEndTime.hashCode()) * 31) + this.timerDate.hashCode()) * 31) + this.title.hashCode()) * 31;
        String str = this.messJson;
        int iHashCode4 = (((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + this.contentImg.hashCode()) * 31;
        boolean z2 = this.isTop;
        return ((((iHashCode4 + (z2 ? 1 : z2)) * 31) + this.attachments.hashCode()) * 31) + getItemType();
    }

    public String toString() {
        return "MessageItemBean(author=" + this.author + ", content=" + this.content + ", contentType=" + this.contentType + ", coverImg=" + this.coverImg + ", details=" + this.details + ", id=" + this.id + ", identityUserName=" + this.identityUserName + ", messType=" + this.messType + ", source=" + this.source + ", isDominateScreen=" + this.isDominateScreen + ", dominateStartTime=" + this.dominateStartTime + ", dominateEndTime=" + this.dominateEndTime + ", timerDate=" + this.timerDate + ", title=" + this.title + ", messJson=" + this.messJson + ", contentImg=" + this.contentImg + ", isTop=" + this.isTop + ", attachments=" + this.attachments + ", itemType=" + getItemType() + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.author);
        parcel.writeString(this.content);
        parcel.writeInt(this.contentType);
        parcel.writeString(this.coverImg);
        List<MessageDetail> list = this.details;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<MessageDetail> it2 = list.iterator();
            while (it2.hasNext()) {
                parcel.writeSerializable(it2.next());
            }
        }
        parcel.writeString(this.id);
        parcel.writeString(this.identityUserName);
        parcel.writeInt(this.messType);
        parcel.writeString(this.source);
        parcel.writeInt(this.isDominateScreen ? 1 : 0);
        parcel.writeString(this.dominateStartTime);
        parcel.writeString(this.dominateEndTime);
        parcel.writeString(this.timerDate);
        parcel.writeString(this.title);
        parcel.writeString(this.messJson);
        parcel.writeString(this.contentImg);
        parcel.writeInt(this.isTop ? 1 : 0);
        List<DocumentBean> list2 = this.attachments;
        parcel.writeInt(list2.size());
        Iterator<DocumentBean> it3 = list2.iterator();
        while (it3.hasNext()) {
            it3.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.itemType);
    }

    public MessageItemBean(@JSONField(name = "author") String author, @JSONField(name = "content") String content, @JSONField(name = CMSAttributeTableGenerator.CONTENT_TYPE) int i, @JSONField(name = "coverImg") String coverImg, @JSONField(name = ErrorBundle.DETAIL_ENTRY) List<MessageDetail> list, @JSONField(name = "id") String id, @JSONField(name = "identityUserName") String identityUserName, @JSONField(name = "messType") int i2, @JSONField(name = FirebaseAnalytics.Param.SOURCE) String source, @JSONField(name = "isDominateScreen") boolean z, @JSONField(name = "dominateStartTime") String dominateStartTime, @JSONField(name = "dominateEndTime") String dominateEndTime, @JSONField(name = "timerDate") String timerDate, @JSONField(name = "title") String title, String str, String contentImg, boolean z2, List<DocumentBean> attachments, int i3) {
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identityUserName, "identityUserName");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dominateStartTime, "dominateStartTime");
        Intrinsics.checkNotNullParameter(dominateEndTime, "dominateEndTime");
        Intrinsics.checkNotNullParameter(timerDate, "timerDate");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(contentImg, "contentImg");
        Intrinsics.checkNotNullParameter(attachments, "attachments");
        this.author = author;
        this.content = content;
        this.contentType = i;
        this.coverImg = coverImg;
        this.details = list;
        this.id = id;
        this.identityUserName = identityUserName;
        this.messType = i2;
        this.source = source;
        this.isDominateScreen = z;
        this.dominateStartTime = dominateStartTime;
        this.dominateEndTime = dominateEndTime;
        this.timerDate = timerDate;
        this.title = title;
        this.messJson = str;
        this.contentImg = contentImg;
        this.isTop = z2;
        this.attachments = attachments;
        this.itemType = i3;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final void setAuthor(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.author = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final int getContentType() {
        return this.contentType;
    }

    public final void setContentType(int i) {
        this.contentType = i;
    }

    public final String getCoverImg() {
        return this.coverImg;
    }

    public final void setCoverImg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverImg = str;
    }

    public final List<MessageDetail> getDetails() {
        return this.details;
    }

    public final void setDetails(List<MessageDetail> list) {
        this.details = list;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getIdentityUserName() {
        return this.identityUserName;
    }

    public final void setIdentityUserName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.identityUserName = str;
    }

    public final int getMessType() {
        return this.messType;
    }

    public final void setMessType(int i) {
        this.messType = i;
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.source = str;
    }

    public final boolean isDominateScreen() {
        return this.isDominateScreen;
    }

    public final void setDominateScreen(boolean z) {
        this.isDominateScreen = z;
    }

    public final String getDominateStartTime() {
        return this.dominateStartTime;
    }

    public final void setDominateStartTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dominateStartTime = str;
    }

    public final String getDominateEndTime() {
        return this.dominateEndTime;
    }

    public final void setDominateEndTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dominateEndTime = str;
    }

    public final String getTimerDate() {
        return this.timerDate;
    }

    public final void setTimerDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timerDate = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getMessJson() {
        return this.messJson;
    }

    public final void setMessJson(String str) {
        this.messJson = str;
    }

    public final String getContentImg() {
        return this.contentImg;
    }

    public final boolean isTop() {
        return this.isTop;
    }

    public final void setTop(boolean z) {
        this.isTop = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MessageItemBean(String str, String str2, int i, String str3, List list, String str4, String str5, int i2, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, String str12, boolean z2, List list2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        String str13 = (i4 & 1) != 0 ? "" : str;
        String str14 = (i4 & 2) != 0 ? "" : str2;
        int i5 = (i4 & 4) != 0 ? 0 : i;
        String str15 = (i4 & 8) != 0 ? "" : str3;
        List list3 = (i4 & 16) != 0 ? null : list;
        String str16 = (i4 & 32) != 0 ? "" : str4;
        String str17 = (i4 & 64) != 0 ? "" : str5;
        int i6 = (i4 & 128) != 0 ? 0 : i2;
        this(str13, str14, i5, str15, list3, str16, str17, i6, (i4 & 256) != 0 ? "" : str6, (i4 & 512) != 0 ? false : z, (i4 & 1024) != 0 ? "" : str7, (i4 & 2048) != 0 ? "" : str8, (i4 & 4096) != 0 ? "" : str9, (i4 & 8192) != 0 ? "" : str10, (i4 & 16384) != 0 ? null : str11, (i4 & 32768) != 0 ? "" : str12, (i4 & 65536) != 0 ? false : z2, (i4 & 131072) != 0 ? new ArrayList() : list2, (i4 & 262144) != 0 ? (i6 == 2 || i6 == 5) ? 2 : 1 : i3);
    }

    public final List<DocumentBean> getAttachments() {
        return this.attachments;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.itemType;
    }

    public final void setAttachments(List<DocumentBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.attachments = list;
    }
}
