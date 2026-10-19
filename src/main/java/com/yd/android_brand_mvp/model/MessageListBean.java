package com.yd.android_brand_mvp.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageListBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bs\b\u0007\u0012\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003Ju\u0010\u001f\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006("}, d2 = {"Lcom/yd/android_brand_mvp/model/MessageListBean;", "Ljava/io/Serializable;", "announcementList", "", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "articleList", "campusStyleList", "newsList", "posterList", "receiveList", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAnnouncementList", "()Ljava/util/List;", "setAnnouncementList", "(Ljava/util/List;)V", "getArticleList", "setArticleList", "getCampusStyleList", "setCampusStyleList", "getNewsList", "setNewsList", "getPosterList", "setPosterList", "getReceiveList", "setReceiveList", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MessageListBean implements Serializable {
    private List<MessageItemBean> announcementList;
    private List<MessageItemBean> articleList;
    private List<MessageItemBean> campusStyleList;
    private List<MessageItemBean> newsList;
    private List<MessageItemBean> posterList;
    private List<MessageItemBean> receiveList;

    public MessageListBean() {
        this(null, null, null, null, null, null, 63, null);
    }

    public MessageListBean(@JSONField(name = "announcementList") List<MessageItemBean> list) {
        this(list, null, null, null, null, null, 62, null);
    }

    public MessageListBean(@JSONField(name = "announcementList") List<MessageItemBean> list, @JSONField(name = "articleList") List<MessageItemBean> list2) {
        this(list, list2, null, null, null, null, 60, null);
    }

    public MessageListBean(@JSONField(name = "announcementList") List<MessageItemBean> list, @JSONField(name = "articleList") List<MessageItemBean> list2, @JSONField(name = "campusStyleList") List<MessageItemBean> list3) {
        this(list, list2, list3, null, null, null, 56, null);
    }

    public MessageListBean(@JSONField(name = "announcementList") List<MessageItemBean> list, @JSONField(name = "articleList") List<MessageItemBean> list2, @JSONField(name = "campusStyleList") List<MessageItemBean> list3, @JSONField(name = "newsList") List<MessageItemBean> list4) {
        this(list, list2, list3, list4, null, null, 48, null);
    }

    public MessageListBean(@JSONField(name = "announcementList") List<MessageItemBean> list, @JSONField(name = "articleList") List<MessageItemBean> list2, @JSONField(name = "campusStyleList") List<MessageItemBean> list3, @JSONField(name = "newsList") List<MessageItemBean> list4, @JSONField(name = "posterList") List<MessageItemBean> list5) {
        this(list, list2, list3, list4, list5, null, 32, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageListBean copy$default(MessageListBean messageListBean, List list, List list2, List list3, List list4, List list5, List list6, int i, Object obj) {
        if ((i & 1) != 0) {
            list = messageListBean.announcementList;
        }
        if ((i & 2) != 0) {
            list2 = messageListBean.articleList;
        }
        List list7 = list2;
        if ((i & 4) != 0) {
            list3 = messageListBean.campusStyleList;
        }
        List list8 = list3;
        if ((i & 8) != 0) {
            list4 = messageListBean.newsList;
        }
        List list9 = list4;
        if ((i & 16) != 0) {
            list5 = messageListBean.posterList;
        }
        List list10 = list5;
        if ((i & 32) != 0) {
            list6 = messageListBean.receiveList;
        }
        return messageListBean.copy(list, list7, list8, list9, list10, list6);
    }

    public final List<MessageItemBean> component1() {
        return this.announcementList;
    }

    public final List<MessageItemBean> component2() {
        return this.articleList;
    }

    public final List<MessageItemBean> component3() {
        return this.campusStyleList;
    }

    public final List<MessageItemBean> component4() {
        return this.newsList;
    }

    public final List<MessageItemBean> component5() {
        return this.posterList;
    }

    public final List<MessageItemBean> component6() {
        return this.receiveList;
    }

    public final MessageListBean copy(@JSONField(name = "announcementList") List<MessageItemBean> announcementList, @JSONField(name = "articleList") List<MessageItemBean> articleList, @JSONField(name = "campusStyleList") List<MessageItemBean> campusStyleList, @JSONField(name = "newsList") List<MessageItemBean> newsList, @JSONField(name = "posterList") List<MessageItemBean> posterList, @JSONField(name = "receiveList") List<MessageItemBean> receiveList) {
        return new MessageListBean(announcementList, articleList, campusStyleList, newsList, posterList, receiveList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageListBean)) {
            return false;
        }
        MessageListBean messageListBean = (MessageListBean) other;
        return Intrinsics.areEqual(this.announcementList, messageListBean.announcementList) && Intrinsics.areEqual(this.articleList, messageListBean.articleList) && Intrinsics.areEqual(this.campusStyleList, messageListBean.campusStyleList) && Intrinsics.areEqual(this.newsList, messageListBean.newsList) && Intrinsics.areEqual(this.posterList, messageListBean.posterList) && Intrinsics.areEqual(this.receiveList, messageListBean.receiveList);
    }

    public int hashCode() {
        List<MessageItemBean> list = this.announcementList;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<MessageItemBean> list2 = this.articleList;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<MessageItemBean> list3 = this.campusStyleList;
        int iHashCode3 = (iHashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<MessageItemBean> list4 = this.newsList;
        int iHashCode4 = (iHashCode3 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<MessageItemBean> list5 = this.posterList;
        int iHashCode5 = (iHashCode4 + (list5 == null ? 0 : list5.hashCode())) * 31;
        List<MessageItemBean> list6 = this.receiveList;
        return iHashCode5 + (list6 != null ? list6.hashCode() : 0);
    }

    public String toString() {
        return "MessageListBean(announcementList=" + this.announcementList + ", articleList=" + this.articleList + ", campusStyleList=" + this.campusStyleList + ", newsList=" + this.newsList + ", posterList=" + this.posterList + ", receiveList=" + this.receiveList + ')';
    }

    public MessageListBean(@JSONField(name = "announcementList") List<MessageItemBean> list, @JSONField(name = "articleList") List<MessageItemBean> list2, @JSONField(name = "campusStyleList") List<MessageItemBean> list3, @JSONField(name = "newsList") List<MessageItemBean> list4, @JSONField(name = "posterList") List<MessageItemBean> list5, @JSONField(name = "receiveList") List<MessageItemBean> list6) {
        this.announcementList = list;
        this.articleList = list2;
        this.campusStyleList = list3;
        this.newsList = list4;
        this.posterList = list5;
        this.receiveList = list6;
    }

    public /* synthetic */ MessageListBean(List list, List list2, List list3, List list4, List list5, List list6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3, (i & 8) != 0 ? null : list4, (i & 16) != 0 ? null : list5, (i & 32) != 0 ? null : list6);
    }

    public final List<MessageItemBean> getAnnouncementList() {
        return this.announcementList;
    }

    public final void setAnnouncementList(List<MessageItemBean> list) {
        this.announcementList = list;
    }

    public final List<MessageItemBean> getArticleList() {
        return this.articleList;
    }

    public final void setArticleList(List<MessageItemBean> list) {
        this.articleList = list;
    }

    public final List<MessageItemBean> getCampusStyleList() {
        return this.campusStyleList;
    }

    public final void setCampusStyleList(List<MessageItemBean> list) {
        this.campusStyleList = list;
    }

    public final List<MessageItemBean> getNewsList() {
        return this.newsList;
    }

    public final void setNewsList(List<MessageItemBean> list) {
        this.newsList = list;
    }

    public final List<MessageItemBean> getPosterList() {
        return this.posterList;
    }

    public final void setPosterList(List<MessageItemBean> list) {
        this.posterList = list;
    }

    public final List<MessageItemBean> getReceiveList() {
        return this.receiveList;
    }

    public final void setReceiveList(List<MessageItemBean> list) {
        this.receiveList = list;
    }
}
