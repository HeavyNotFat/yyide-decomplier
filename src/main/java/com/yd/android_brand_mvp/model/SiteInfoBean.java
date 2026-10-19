package com.yd.android_brand_mvp.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SiteInfoBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\bJ\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\b\u0012\b\b\u0003\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0003\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0003\u0010\r\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u000e\u001a\u00020\b\u0012\b\b\u0003\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0013\u001a\u00020\b\u0012\b\b\u0003\u0010\u0014\u001a\u00020\b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003¢\u0006\u0002\u0010\u0018J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\bHÆ\u0003J\t\u0010I\u001a\u00020\bHÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\bHÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\u000f\u0010R\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\bHÆ\u0003JÃ\u0001\u0010U\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\u00032\u000e\b\u0003\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0003\u0010\r\u001a\u00020\u00032\b\b\u0003\u0010\u000e\u001a\u00020\b2\b\b\u0003\u0010\u000f\u001a\u00020\u00032\b\b\u0003\u0010\u0010\u001a\u00020\u00032\b\b\u0003\u0010\u0011\u001a\u00020\u00032\b\b\u0003\u0010\u0012\u001a\u00020\u00032\b\b\u0003\u0010\u0013\u001a\u00020\b2\b\b\u0003\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u0003HÆ\u0001J\u0013\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Y\u001a\u00020\bHÖ\u0001J\t\u0010Z\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001cR\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001cR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001cR\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001a\"\u0004\b6\u0010\u001cR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001a\"\u0004\b8\u0010\u001cR\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001a\"\u0004\b:\u0010\u001cR\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001a\"\u0004\b<\u0010\u001cR\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001a\"\u0004\b>\u0010\u001cR\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010&\"\u0004\b@\u0010(R\u001a\u0010\u0014\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010&\"\u0004\bB\u0010(¨\u0006["}, d2 = {"Lcom/yd/android_brand_mvp/model/SiteInfoBean;", "", "buildingId", "", "buildingName", CommentsHomeFragment.TYPE_CLASSESID, "classesName", "floor", "", "id", TUIKitConstants.Selection.LIST, "", "Lcom/yd/android_brand_mvp/model/SiteTeacherBean;", AppMeasurementSdk.ConditionalUserProperty.NAME, "peppleNum", "roomNum", "schoolId", "siteTypeId", "siteTypeName", "space", "versionStamp", "describe", "imgPaths", "qrCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuildingId", "()Ljava/lang/String;", "setBuildingId", "(Ljava/lang/String;)V", "getBuildingName", "setBuildingName", "getClassesId", "setClassesId", "getClassesName", "setClassesName", "getDescribe", "setDescribe", "getFloor", "()I", "setFloor", "(I)V", "getId", "setId", "getImgPaths", "setImgPaths", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getName", "setName", "getPeppleNum", "setPeppleNum", "getQrCode", "setQrCode", "getRoomNum", "setRoomNum", "getSchoolId", "setSchoolId", "getSiteTypeId", "setSiteTypeId", "getSiteTypeName", "setSiteTypeName", "getSpace", "setSpace", "getVersionStamp", "setVersionStamp", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SiteInfoBean {
    private String buildingId;
    private String buildingName;
    private String classesId;
    private String classesName;
    private String describe;
    private int floor;
    private String id;
    private String imgPaths;
    private List<SiteTeacherBean> list;
    private String name;
    private int peppleNum;
    private String qrCode;
    private String roomNum;
    private String schoolId;
    private String siteTypeId;
    private String siteTypeName;
    private int space;
    private int versionStamp;

    public SiteInfoBean() {
        this(null, null, null, null, 0, null, null, null, 0, null, null, null, null, 0, 0, null, null, null, 262143, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBuildingId() {
        return this.buildingId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getRoomNum() {
        return this.roomNum;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getSiteTypeId() {
        return this.siteTypeId;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSiteTypeName() {
        return this.siteTypeName;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getSpace() {
        return this.space;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getVersionStamp() {
        return this.versionStamp;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getDescribe() {
        return this.describe;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getImgPaths() {
        return this.imgPaths;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getQrCode() {
        return this.qrCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBuildingName() {
        return this.buildingName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getClassesId() {
        return this.classesId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getClassesName() {
        return this.classesName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getFloor() {
        return this.floor;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<SiteTeacherBean> component7() {
        return this.list;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getPeppleNum() {
        return this.peppleNum;
    }

    public final SiteInfoBean copy(@JSONField(name = "buildingId") String buildingId, @JSONField(name = "buildingName") String buildingName, @JSONField(name = CommentsHomeFragment.TYPE_CLASSESID) String classesId, @JSONField(name = "classesName") String classesName, @JSONField(name = "floor") int floor, @JSONField(name = "id") String id, @JSONField(name = TUIKitConstants.Selection.LIST) List<SiteTeacherBean> list, @JSONField(name = AppMeasurementSdk.ConditionalUserProperty.NAME) String name, @JSONField(name = "peppleNum") int peppleNum, @JSONField(name = "roomNum") String roomNum, @JSONField(name = "schoolId") String schoolId, @JSONField(name = "siteTypeId") String siteTypeId, @JSONField(name = "siteTypeName") String siteTypeName, @JSONField(name = "space") int space, @JSONField(name = "versionStamp") int versionStamp, String describe, String imgPaths, String qrCode) {
        Intrinsics.checkNotNullParameter(buildingId, "buildingId");
        Intrinsics.checkNotNullParameter(buildingName, "buildingName");
        Intrinsics.checkNotNullParameter(classesId, "classesId");
        Intrinsics.checkNotNullParameter(classesName, "classesName");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(roomNum, "roomNum");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(siteTypeId, "siteTypeId");
        Intrinsics.checkNotNullParameter(siteTypeName, "siteTypeName");
        Intrinsics.checkNotNullParameter(describe, "describe");
        Intrinsics.checkNotNullParameter(imgPaths, "imgPaths");
        Intrinsics.checkNotNullParameter(qrCode, "qrCode");
        return new SiteInfoBean(buildingId, buildingName, classesId, classesName, floor, id, list, name, peppleNum, roomNum, schoolId, siteTypeId, siteTypeName, space, versionStamp, describe, imgPaths, qrCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SiteInfoBean)) {
            return false;
        }
        SiteInfoBean siteInfoBean = (SiteInfoBean) other;
        return Intrinsics.areEqual(this.buildingId, siteInfoBean.buildingId) && Intrinsics.areEqual(this.buildingName, siteInfoBean.buildingName) && Intrinsics.areEqual(this.classesId, siteInfoBean.classesId) && Intrinsics.areEqual(this.classesName, siteInfoBean.classesName) && this.floor == siteInfoBean.floor && Intrinsics.areEqual(this.id, siteInfoBean.id) && Intrinsics.areEqual(this.list, siteInfoBean.list) && Intrinsics.areEqual(this.name, siteInfoBean.name) && this.peppleNum == siteInfoBean.peppleNum && Intrinsics.areEqual(this.roomNum, siteInfoBean.roomNum) && Intrinsics.areEqual(this.schoolId, siteInfoBean.schoolId) && Intrinsics.areEqual(this.siteTypeId, siteInfoBean.siteTypeId) && Intrinsics.areEqual(this.siteTypeName, siteInfoBean.siteTypeName) && this.space == siteInfoBean.space && this.versionStamp == siteInfoBean.versionStamp && Intrinsics.areEqual(this.describe, siteInfoBean.describe) && Intrinsics.areEqual(this.imgPaths, siteInfoBean.imgPaths) && Intrinsics.areEqual(this.qrCode, siteInfoBean.qrCode);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((this.buildingId.hashCode() * 31) + this.buildingName.hashCode()) * 31) + this.classesId.hashCode()) * 31) + this.classesName.hashCode()) * 31) + this.floor) * 31) + this.id.hashCode()) * 31) + this.list.hashCode()) * 31) + this.name.hashCode()) * 31) + this.peppleNum) * 31) + this.roomNum.hashCode()) * 31) + this.schoolId.hashCode()) * 31) + this.siteTypeId.hashCode()) * 31) + this.siteTypeName.hashCode()) * 31) + this.space) * 31) + this.versionStamp) * 31) + this.describe.hashCode()) * 31) + this.imgPaths.hashCode()) * 31) + this.qrCode.hashCode();
    }

    public String toString() {
        return "SiteInfoBean(buildingId=" + this.buildingId + ", buildingName=" + this.buildingName + ", classesId=" + this.classesId + ", classesName=" + this.classesName + ", floor=" + this.floor + ", id=" + this.id + ", list=" + this.list + ", name=" + this.name + ", peppleNum=" + this.peppleNum + ", roomNum=" + this.roomNum + ", schoolId=" + this.schoolId + ", siteTypeId=" + this.siteTypeId + ", siteTypeName=" + this.siteTypeName + ", space=" + this.space + ", versionStamp=" + this.versionStamp + ", describe=" + this.describe + ", imgPaths=" + this.imgPaths + ", qrCode=" + this.qrCode + ')';
    }

    public SiteInfoBean(@JSONField(name = "buildingId") String buildingId, @JSONField(name = "buildingName") String buildingName, @JSONField(name = CommentsHomeFragment.TYPE_CLASSESID) String classesId, @JSONField(name = "classesName") String classesName, @JSONField(name = "floor") int i, @JSONField(name = "id") String id, @JSONField(name = TUIKitConstants.Selection.LIST) List<SiteTeacherBean> list, @JSONField(name = AppMeasurementSdk.ConditionalUserProperty.NAME) String name, @JSONField(name = "peppleNum") int i2, @JSONField(name = "roomNum") String roomNum, @JSONField(name = "schoolId") String schoolId, @JSONField(name = "siteTypeId") String siteTypeId, @JSONField(name = "siteTypeName") String siteTypeName, @JSONField(name = "space") int i3, @JSONField(name = "versionStamp") int i4, String describe, String imgPaths, String qrCode) {
        Intrinsics.checkNotNullParameter(buildingId, "buildingId");
        Intrinsics.checkNotNullParameter(buildingName, "buildingName");
        Intrinsics.checkNotNullParameter(classesId, "classesId");
        Intrinsics.checkNotNullParameter(classesName, "classesName");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(roomNum, "roomNum");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(siteTypeId, "siteTypeId");
        Intrinsics.checkNotNullParameter(siteTypeName, "siteTypeName");
        Intrinsics.checkNotNullParameter(describe, "describe");
        Intrinsics.checkNotNullParameter(imgPaths, "imgPaths");
        Intrinsics.checkNotNullParameter(qrCode, "qrCode");
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.classesId = classesId;
        this.classesName = classesName;
        this.floor = i;
        this.id = id;
        this.list = list;
        this.name = name;
        this.peppleNum = i2;
        this.roomNum = roomNum;
        this.schoolId = schoolId;
        this.siteTypeId = siteTypeId;
        this.siteTypeName = siteTypeName;
        this.space = i3;
        this.versionStamp = i4;
        this.describe = describe;
        this.imgPaths = imgPaths;
        this.qrCode = qrCode;
    }

    public final String getBuildingId() {
        return this.buildingId;
    }

    public final void setBuildingId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.buildingId = str;
    }

    public final String getBuildingName() {
        return this.buildingName;
    }

    public final void setBuildingName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.buildingName = str;
    }

    public final String getClassesId() {
        return this.classesId;
    }

    public final void setClassesId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.classesId = str;
    }

    public final String getClassesName() {
        return this.classesName;
    }

    public final void setClassesName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.classesName = str;
    }

    public final int getFloor() {
        return this.floor;
    }

    public final void setFloor(int i) {
        this.floor = i;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public /* synthetic */ SiteInfoBean(String str, String str2, String str3, String str4, int i, String str5, List list, String str6, int i2, String str7, String str8, String str9, String str10, int i3, int i4, String str11, String str12, String str13, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? "" : str, (i5 & 2) != 0 ? "" : str2, (i5 & 4) != 0 ? "" : str3, (i5 & 8) != 0 ? "" : str4, (i5 & 16) != 0 ? 0 : i, (i5 & 32) != 0 ? "" : str5, (i5 & 64) != 0 ? new ArrayList() : list, (i5 & 128) != 0 ? "" : str6, (i5 & 256) != 0 ? 0 : i2, (i5 & 512) != 0 ? "" : str7, (i5 & 1024) != 0 ? "" : str8, (i5 & 2048) != 0 ? "" : str9, (i5 & 4096) != 0 ? "" : str10, (i5 & 8192) != 0 ? 0 : i3, (i5 & 16384) != 0 ? 0 : i4, (i5 & 32768) != 0 ? "" : str11, (i5 & 65536) != 0 ? "" : str12, (i5 & 131072) != 0 ? "" : str13);
    }

    public final List<SiteTeacherBean> getList() {
        return this.list;
    }

    public final void setList(List<SiteTeacherBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.list = list;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final int getPeppleNum() {
        return this.peppleNum;
    }

    public final void setPeppleNum(int i) {
        this.peppleNum = i;
    }

    public final String getRoomNum() {
        return this.roomNum;
    }

    public final void setRoomNum(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.roomNum = str;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final void setSchoolId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.schoolId = str;
    }

    public final String getSiteTypeId() {
        return this.siteTypeId;
    }

    public final void setSiteTypeId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.siteTypeId = str;
    }

    public final String getSiteTypeName() {
        return this.siteTypeName;
    }

    public final void setSiteTypeName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.siteTypeName = str;
    }

    public final int getSpace() {
        return this.space;
    }

    public final void setSpace(int i) {
        this.space = i;
    }

    public final int getVersionStamp() {
        return this.versionStamp;
    }

    public final void setVersionStamp(int i) {
        this.versionStamp = i;
    }

    public final String getDescribe() {
        return this.describe;
    }

    public final void setDescribe(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.describe = str;
    }

    public final String getImgPaths() {
        return this.imgPaths;
    }

    public final void setImgPaths(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imgPaths = str;
    }

    public final String getQrCode() {
        return this.qrCode;
    }

    public final void setQrCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qrCode = str;
    }
}
