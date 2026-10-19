package com.yd.android_brand_mvp.model;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageCaptionBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b;\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010¢\u0006\u0002\u0010\u0014J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00108\u001a\u00020\bHÆ\u0003J\t\u00109\u001a\u00020\bHÆ\u0003J\t\u0010:\u001a\u00020\u0010HÆ\u0003J\t\u0010;\u001a\u00020\bHÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\t\u0010=\u001a\u00020\u0010HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010A\u001a\u00020\bHÆ\u0003J\t\u0010B\u001a\u00020\bHÆ\u0003J\t\u0010C\u001a\u00020\bHÆ\u0003J\t\u0010D\u001a\u00020\bHÆ\u0003J\t\u0010E\u001a\u00020\bHÆ\u0003J§\u0001\u0010F\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u0010HÆ\u0001J\u0013\u0010G\u001a\u00020\u00102\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020\bHÖ\u0001J\t\u0010J\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001a\u0010\u0013\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010)\"\u0004\b,\u0010+R\u001a\u0010\u0011\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR\u001a\u0010\u0012\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001a\"\u0004\b0\u0010\u001cR\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001cR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018¨\u0006K"}, d2 = {"Lcom/yd/android_brand_mvp/model/MessageCaptionBean;", "", "id", "", "content", "textColor", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "backgroundTransparency", "", "rollSpeed", TtmlNode.ATTR_TTS_FONT_SIZE, "position", "circulationMode", "circulationNumber", "intervalTime", "isShowBtn", "", "playCount", "playTime", "isPlaySuccess", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIIIIZIIZ)V", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "getBackgroundTransparency", "()I", "setBackgroundTransparency", "(I)V", "getCirculationMode", "setCirculationMode", "getCirculationNumber", "setCirculationNumber", "getContent", "setContent", "getFontSize", "setFontSize", "getId", "setId", "getIntervalTime", "setIntervalTime", "()Z", "setPlaySuccess", "(Z)V", "setShowBtn", "getPlayCount", "setPlayCount", "getPlayTime", "setPlayTime", "getPosition", "setPosition", "getRollSpeed", "setRollSpeed", "getTextColor", "setTextColor", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MessageCaptionBean {
    private String backgroundColor;
    private int backgroundTransparency;
    private int circulationMode;
    private int circulationNumber;
    private String content;
    private int fontSize;
    private String id;
    private int intervalTime;
    private boolean isPlaySuccess;
    private boolean isShowBtn;
    private int playCount;
    private int playTime;
    private int position;
    private int rollSpeed;
    private String textColor;

    public MessageCaptionBean() {
        this(null, null, null, null, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, false, 32767, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getCirculationNumber() {
        return this.circulationNumber;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getIntervalTime() {
        return this.intervalTime;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsShowBtn() {
        return this.isShowBtn;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getPlayCount() {
        return this.playCount;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getPlayTime() {
        return this.playTime;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getIsPlaySuccess() {
        return this.isPlaySuccess;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTextColor() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getBackgroundTransparency() {
        return this.backgroundTransparency;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getRollSpeed() {
        return this.rollSpeed;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getFontSize() {
        return this.fontSize;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getCirculationMode() {
        return this.circulationMode;
    }

    public final MessageCaptionBean copy(String id, String content, String textColor, String backgroundColor, int backgroundTransparency, int rollSpeed, int fontSize, int position, int circulationMode, int circulationNumber, int intervalTime, boolean isShowBtn, int playCount, int playTime, boolean isPlaySuccess) {
        return new MessageCaptionBean(id, content, textColor, backgroundColor, backgroundTransparency, rollSpeed, fontSize, position, circulationMode, circulationNumber, intervalTime, isShowBtn, playCount, playTime, isPlaySuccess);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageCaptionBean)) {
            return false;
        }
        MessageCaptionBean messageCaptionBean = (MessageCaptionBean) other;
        return Intrinsics.areEqual(this.id, messageCaptionBean.id) && Intrinsics.areEqual(this.content, messageCaptionBean.content) && Intrinsics.areEqual(this.textColor, messageCaptionBean.textColor) && Intrinsics.areEqual(this.backgroundColor, messageCaptionBean.backgroundColor) && this.backgroundTransparency == messageCaptionBean.backgroundTransparency && this.rollSpeed == messageCaptionBean.rollSpeed && this.fontSize == messageCaptionBean.fontSize && this.position == messageCaptionBean.position && this.circulationMode == messageCaptionBean.circulationMode && this.circulationNumber == messageCaptionBean.circulationNumber && this.intervalTime == messageCaptionBean.intervalTime && this.isShowBtn == messageCaptionBean.isShowBtn && this.playCount == messageCaptionBean.playCount && this.playTime == messageCaptionBean.playTime && this.isPlaySuccess == messageCaptionBean.isPlaySuccess;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.content;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.textColor;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.backgroundColor;
        int iHashCode4 = (((((((((((((((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.backgroundTransparency) * 31) + this.rollSpeed) * 31) + this.fontSize) * 31) + this.position) * 31) + this.circulationMode) * 31) + this.circulationNumber) * 31) + this.intervalTime) * 31;
        boolean z = this.isShowBtn;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (((((iHashCode4 + r1) * 31) + this.playCount) * 31) + this.playTime) * 31;
        boolean z2 = this.isPlaySuccess;
        return i + (z2 ? 1 : z2);
    }

    public String toString() {
        return "MessageCaptionBean(id=" + this.id + ", content=" + this.content + ", textColor=" + this.textColor + ", backgroundColor=" + this.backgroundColor + ", backgroundTransparency=" + this.backgroundTransparency + ", rollSpeed=" + this.rollSpeed + ", fontSize=" + this.fontSize + ", position=" + this.position + ", circulationMode=" + this.circulationMode + ", circulationNumber=" + this.circulationNumber + ", intervalTime=" + this.intervalTime + ", isShowBtn=" + this.isShowBtn + ", playCount=" + this.playCount + ", playTime=" + this.playTime + ", isPlaySuccess=" + this.isPlaySuccess + ')';
    }

    public MessageCaptionBean(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, int i8, int i9, boolean z2) {
        this.id = str;
        this.content = str2;
        this.textColor = str3;
        this.backgroundColor = str4;
        this.backgroundTransparency = i;
        this.rollSpeed = i2;
        this.fontSize = i3;
        this.position = i4;
        this.circulationMode = i5;
        this.circulationNumber = i6;
        this.intervalTime = i7;
        this.isShowBtn = z;
        this.playCount = i8;
        this.playTime = i9;
        this.isPlaySuccess = z2;
    }

    public /* synthetic */ MessageCaptionBean(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, int i8, int i9, boolean z2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) == 0 ? str4 : "", (i10 & 16) != 0 ? 0 : i, (i10 & 32) != 0 ? -1 : i2, (i10 & 64) != 0 ? -1 : i3, (i10 & 128) != 0 ? -1 : i4, (i10 & 256) != 0 ? -1 : i5, (i10 & 512) != 0 ? -1 : i6, (i10 & 1024) != 0 ? -1 : i7, (i10 & 2048) != 0 ? false : z, (i10 & 4096) != 0 ? -1 : i8, (i10 & 8192) == 0 ? i9 : -1, (i10 & 16384) != 0 ? false : z2);
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(String str) {
        this.textColor = str;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(String str) {
        this.backgroundColor = str;
    }

    public final int getBackgroundTransparency() {
        return this.backgroundTransparency;
    }

    public final void setBackgroundTransparency(int i) {
        this.backgroundTransparency = i;
    }

    public final int getRollSpeed() {
        return this.rollSpeed;
    }

    public final void setRollSpeed(int i) {
        this.rollSpeed = i;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final void setFontSize(int i) {
        this.fontSize = i;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final int getCirculationMode() {
        return this.circulationMode;
    }

    public final void setCirculationMode(int i) {
        this.circulationMode = i;
    }

    public final int getCirculationNumber() {
        return this.circulationNumber;
    }

    public final void setCirculationNumber(int i) {
        this.circulationNumber = i;
    }

    public final int getIntervalTime() {
        return this.intervalTime;
    }

    public final void setIntervalTime(int i) {
        this.intervalTime = i;
    }

    public final boolean isShowBtn() {
        return this.isShowBtn;
    }

    public final void setShowBtn(boolean z) {
        this.isShowBtn = z;
    }

    public final int getPlayCount() {
        return this.playCount;
    }

    public final void setPlayCount(int i) {
        this.playCount = i;
    }

    public final int getPlayTime() {
        return this.playTime;
    }

    public final void setPlayTime(int i) {
        this.playTime = i;
    }

    public final boolean isPlaySuccess() {
        return this.isPlaySuccess;
    }

    public final void setPlaySuccess(boolean z) {
        this.isPlaySuccess = z;
    }
}
