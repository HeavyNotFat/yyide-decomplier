package com.yd.android_brand_mvp.utils;

import android.app.Activity;
import android.content.Context;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.activity.ClassModeActivity;
import com.yd.android_brand_mvp.activity.CustomDominateActivity;
import com.yd.android_brand_mvp.activity.DominateScreenActivity;
import com.yd.android_brand_mvp.activity.exam.ExamFullScreenActivity;
import com.yd.android_brand_mvp.activity.reserve.ReservationFullActivity;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
import com.yd.android_brand_mvp.model.home.DominateCustomBean;
import com.yd.android_brand_mvp.model.home.DominateScreenBean;
import com.yd.android_brand_mvp.model.home.DominateStartBean;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yyide.facepass.AppExtKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DominateScreenUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004J/\u0010\u0012\u001a\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00162\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0018\"\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016J\u001e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/utils/DominateScreenUtil;", "", "()V", "TYPE_CUSTOM", "", "TYPE_EXAM", "TYPE_GO_CLASSES", "TYPE_MESSAGE_NOTICE", "TYPE_RESERVATION", "dealWithCurrentDominate", "", "targetBean", "Lcom/yd/android_brand_mvp/model/home/DominateStartBean;", "currentBean", "dealWithIsNeedStartGo", "", "itemData", "Lcom/yd/android_brand_mvp/model/home/DominateScreenBean;", "finishTypeActivity", "", "type", "dataList", "", "values", "", "(Ljava/util/List;[Ljava/lang/String;)V", "isNeedStart", "startGoTypeActivity", "context", "Landroid/content/Context;", "itemDataIndex", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DominateScreenUtil {
    public static final DominateScreenUtil INSTANCE = new DominateScreenUtil();
    public static final String TYPE_CUSTOM = "4";
    public static final String TYPE_EXAM = "3";
    public static final String TYPE_GO_CLASSES = "1";
    public static final String TYPE_MESSAGE_NOTICE = "2";
    public static final String TYPE_RESERVATION = "reservation";

    private DominateScreenUtil() {
    }

    public final DominateStartBean isNeedStart(List<DominateScreenBean> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        DominateStartBean dominateStartBean = new DominateStartBean(null, 0, 0, 7, null);
        if (dataList.isEmpty()) {
            return dominateStartBean;
        }
        List<DominateScreenBean> listSortedWith = CollectionsKt.sortedWith(dataList, new Comparator() { // from class: com.yd.android_brand_mvp.utils.DominateScreenUtil$isNeedStart$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((DominateScreenBean) t).getSort()), Integer.valueOf(((DominateScreenBean) t2).getSort()));
            }
        });
        finishTypeActivity(listSortedWith, "1", "2", "3");
        for (DominateScreenBean dominateScreenBean : listSortedWith) {
            AppExtKt.logd(this, dominateScreenBean.getType() + ",sort=" + dominateScreenBean.getSort());
            int iDealWithIsNeedStartGo = dealWithIsNeedStartGo(dominateScreenBean);
            if (iDealWithIsNeedStartGo == -1) {
                finishTypeActivity(dominateScreenBean.getType());
            } else {
                dominateStartBean.setType(dominateScreenBean.getType());
                dominateStartBean.setListIndex(dataList.indexOf(dominateScreenBean));
                dominateStartBean.setItemDataIndex(iDealWithIsNeedStartGo);
                break;
            }
        }
        return dominateStartBean;
    }

    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 int, still in use, count: 1, list:
  (r0v0 int) from 0x000e: IF  (r0v0 int) == (-1563081780 int)  -> B:131:0x0241 A[HIDDEN]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    private final int dealWithIsNeedStartGo(DominateScreenBean itemData) {
        int i;
        String type = itemData.getType();
        if (type.hashCode() == -1563081780) {
            if (!type.equals(TYPE_RESERVATION)) {
                return -1;
            }
            String dominateScreenData = MMKVUtil.INSTANCE.getDominateScreenData(MMKVUtil.DOMINATE_RESERVATION_DATA);
            if (dominateScreenData.length() == 0) {
                return -1;
            }
            i = 0;
            for (ReservationRecordBean reservationRecordBean : (List) GsonUtils.fromJson(dominateScreenData, new TypeToken<List<? extends ReservationRecordBean>>() { // from class: com.yd.android_brand_mvp.utils.DominateScreenUtil$dealWithIsNeedStartGo$dataList$2
            }.getType())) {
                int i2 = i + 1;
                if (!(reservationRecordBean.getStartTimeStr().length() == 0)) {
                    if (!(reservationRecordBean.getEndTimeStr().length() == 0) && DateUtils.isTiming(reservationRecordBean.getStartTimeStr(), reservationRecordBean.getEndTimeStr(), TimeUtil.notSecondFormat)) {
                    }
                }
                i = i2;
            }
            return -1;
        }
        switch (type) {
            case "1":
                KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCLASSKB);
                if (kBRsp2 == null) {
                    kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCDKB);
                }
                if (kBRsp2 == null || kBRsp2.data == null) {
                    return -1;
                }
                List<KBRsp2.DataDTO.TimetableListDTO> list = kBRsp2.data.timetableList;
                List<KBRsp2.DataDTO.TimetableListDTO> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return -1;
                }
                String week2 = Tool.getWeek2(System.currentTimeMillis());
                String str = week2;
                if (str == null || str.length() == 0) {
                    return -1;
                }
                int i3 = 0;
                for (KBRsp2.DataDTO.TimetableListDTO timetableListDTO : list) {
                    int i4 = i3 + 1;
                    String str2 = timetableListDTO.startTime;
                    Intrinsics.checkNotNullExpressionValue(str2, "element.startTime");
                    if (!(str2.length() == 0)) {
                        String str3 = timetableListDTO.endTime;
                        Intrinsics.checkNotNullExpressionValue(str3, "element.endTime");
                        if (!(str3.length() == 0) && Intrinsics.areEqual(week2, String.valueOf(timetableListDTO.week))) {
                            if (DateUtils.isTiming(timetableListDTO.date + ' ' + timetableListDTO.startTime, timetableListDTO.date + ' ' + timetableListDTO.endTime, TimeUtil.notSecondFormat)) {
                                return i3;
                            }
                        }
                    }
                    i3 = i4;
                }
                return -1;
            case "2":
                i = 0;
                for (MessageItemBean messageItemBean : SpData.getMessageDominateList()) {
                    int i5 = i + 1;
                    if (!(messageItemBean.getDominateStartTime().length() == 0)) {
                        if (!(messageItemBean.getDominateEndTime().length() == 0) && DateUtils.isTiming(messageItemBean.getDominateStartTime(), messageItemBean.getDominateEndTime(), TimeUtil.notSecondFormat)) {
                            break;
                        }
                    }
                    i = i5;
                }
                return -1;
            case "3":
                String dominateScreenData2 = MMKVUtil.INSTANCE.getDominateScreenData(MMKVUtil.DOMINATE_EXAM_DATA);
                if (dominateScreenData2.length() == 0) {
                    return -1;
                }
                i = 0;
                for (ExamPlanItem examPlanItem : (List) GsonUtils.fromJson(dominateScreenData2, new TypeToken<List<? extends ExamPlanItem>>() { // from class: com.yd.android_brand_mvp.utils.DominateScreenUtil$dealWithIsNeedStartGo$dataList$1
                }.getType())) {
                    int i6 = i + 1;
                    if (!(examPlanItem.getExamStartTime().length() == 0)) {
                        if (!(examPlanItem.getExamEndTime().length() == 0) && DateUtils.isTiming(examPlanItem.getExamStartTime(), examPlanItem.getExamEndTime(), examPlanItem.getStartMinute(), examPlanItem.getEndMinute())) {
                            break;
                        }
                    }
                    i = i6;
                }
                return -1;
            case "4":
                String dominateScreenData3 = MMKVUtil.INSTANCE.getDominateScreenData(MMKVUtil.DOMINATE_CUSTOM_DATA);
                if (dominateScreenData3.length() == 0) {
                    return -1;
                }
                i = 0;
                for (DominateCustomBean dominateCustomBean : (List) GsonUtils.fromJson(dominateScreenData3, new TypeToken<List<? extends DominateCustomBean>>() { // from class: com.yd.android_brand_mvp.utils.DominateScreenUtil$dealWithIsNeedStartGo$dataList$3
                }.getType())) {
                    int i7 = i + 1;
                    if (!(dominateCustomBean.getStartDate().length() == 0)) {
                        if (!(dominateCustomBean.getEndDate().length() == 0) && DateUtils.isTiming(dominateCustomBean.getStartDate(), dominateCustomBean.getEndDate(), TimeUtil.allTimeFormat)) {
                            break;
                        }
                    }
                    i = i7;
                }
                return -1;
            default:
                return -1;
        }
        return i;
    }

    public final boolean dealWithCurrentDominate(DominateStartBean targetBean, DominateStartBean currentBean) {
        Intrinsics.checkNotNullParameter(targetBean, "targetBean");
        if (currentBean == null) {
            return true;
        }
        if (Intrinsics.areEqual(currentBean.getType(), "2") && Intrinsics.areEqual(targetBean.getType(), "2")) {
            return false;
        }
        if (Intrinsics.areEqual(currentBean.getType(), "1") && Intrinsics.areEqual(targetBean.getType(), "1")) {
            return false;
        }
        if ((Intrinsics.areEqual(currentBean.getType(), "4") && Intrinsics.areEqual(targetBean.getType(), "4")) || Intrinsics.areEqual(targetBean, currentBean)) {
            return false;
        }
        finishTypeActivity(currentBean.getType());
        return true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void startGoTypeActivity(Context context, DominateScreenBean itemData, int itemDataIndex) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        String type = itemData.getType();
        int iHashCode = type.hashCode();
        if (iHashCode == -1563081780) {
            if (type.equals(TYPE_RESERVATION)) {
                String dominateScreenData = MMKVUtil.INSTANCE.getDominateScreenData(MMKVUtil.DOMINATE_RESERVATION_DATA);
                if (dominateScreenData.length() == 0) {
                    return;
                }
                List dataList = (List) GsonUtils.fromJson(dominateScreenData, new TypeToken<List<? extends ReservationRecordBean>>() { // from class: com.yd.android_brand_mvp.utils.DominateScreenUtil$startGoTypeActivity$dataList$2
                }.getType());
                List list = dataList;
                if ((list == null || list.isEmpty()) || itemDataIndex == -1 || itemDataIndex >= dataList.size()) {
                    return;
                }
                ReservationRecordBean reservationRecordBean = (ReservationRecordBean) dataList.get(itemDataIndex);
                AppExtKt.logd(this, "itemDataIndex");
                Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
                if (itemDataIndex == CollectionsKt.getLastIndex(dataList)) {
                    ReservationFullActivity.Companion.startGo$default(ReservationFullActivity.INSTANCE, context, reservationRecordBean, null, null, 8, null);
                    return;
                } else {
                    ReservationFullActivity.INSTANCE.startGo(context, reservationRecordBean, (ReservationRecordBean) dataList.get(itemDataIndex + 1), Boolean.valueOf(itemData.isForceExit()));
                    return;
                }
            }
            return;
        }
        switch (iHashCode) {
            case 49:
                if (type.equals("1")) {
                    KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCLASSKB);
                    if (kBRsp2 == null) {
                        kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCDKB);
                    }
                    List<KBRsp2.DataDTO.TimetableListDTO> list2 = kBRsp2.data.timetableList;
                    if (!(list2 == null || list2.isEmpty()) && itemDataIndex != -1 && itemDataIndex < kBRsp2.data.timetableList.size()) {
                        KBRsp2.DataDTO.TimetableListDTO timeTable = kBRsp2.data.timetableList.get(itemDataIndex);
                        ClassModeActivity.Companion companion = ClassModeActivity.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(timeTable, "timeTable");
                        companion.start(context, timeTable, Boolean.valueOf(itemData.isForceExit()));
                    }
                    break;
                }
                break;
            case 50:
                if (type.equals("2")) {
                    ArrayList<MessageItemBean> arrayList = new ArrayList<>(SpData.getMessageDominateList());
                    ArrayList<MessageItemBean> arrayList2 = new ArrayList<>();
                    for (MessageItemBean messageItemBean : arrayList) {
                        if (DateUtils.isTiming(messageItemBean.getDominateStartTime(), messageItemBean.getDominateEndTime(), TimeUtil.notSecondFormat)) {
                            arrayList2.add(messageItemBean);
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        DominateScreenActivity.INSTANCE.start(context, arrayList, arrayList2, Boolean.valueOf(itemData.isForceExit()));
                    }
                    break;
                }
                break;
            case 51:
                if (type.equals("3")) {
                    String dominateScreenData2 = MMKVUtil.INSTANCE.getDominateScreenData(MMKVUtil.DOMINATE_EXAM_DATA);
                    if (!(dominateScreenData2.length() == 0)) {
                        List list3 = (List) GsonUtils.fromJson(dominateScreenData2, new TypeToken<List<? extends ExamPlanItem>>() { // from class: com.yd.android_brand_mvp.utils.DominateScreenUtil$startGoTypeActivity$dataList$1
                        }.getType());
                        List list4 = list3;
                        if (!(list4 == null || list4.isEmpty()) && itemDataIndex != -1 && itemDataIndex < list3.size()) {
                            ExamFullScreenActivity.INSTANCE.startGo(context, ScreenUtils.isPortrait(), (ExamPlanItem) list3.get(itemDataIndex), Boolean.valueOf(itemData.isForceExit()));
                            break;
                        }
                    }
                }
                break;
            case 52:
                if (type.equals("4")) {
                    String dominateScreenData3 = MMKVUtil.INSTANCE.getDominateScreenData(MMKVUtil.DOMINATE_CUSTOM_DATA);
                    if (!(dominateScreenData3.length() == 0)) {
                        List<DominateCustomBean> list5 = (List) GsonUtils.fromJson(dominateScreenData3, new TypeToken<List<? extends DominateCustomBean>>() { // from class: com.yd.android_brand_mvp.utils.DominateScreenUtil$startGoTypeActivity$dataList$3
                        }.getType());
                        ArrayList<DominateCustomBean> arrayList3 = new ArrayList<>();
                        for (DominateCustomBean dominateCustomBean : list5) {
                            if (DateUtils.isTiming(dominateCustomBean.getStartDate(), dominateCustomBean.getEndDate(), TimeUtil.allTimeFormat)) {
                                arrayList3.add(dominateCustomBean);
                            }
                        }
                        if (!arrayList3.isEmpty()) {
                            CustomDominateActivity.INSTANCE.startGo(context, arrayList3, itemData.isForceExit());
                        }
                        break;
                    }
                }
                break;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void finishTypeActivity(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        int iHashCode = type.hashCode();
        if (iHashCode == -1563081780) {
            if (type.equals(TYPE_RESERVATION)) {
                ActivityUtils.finishActivity((Class<? extends Activity>) ReservationFullActivity.class);
            }
            return;
        }
        switch (iHashCode) {
            case 49:
                if (type.equals("1")) {
                    ActivityUtils.finishActivity((Class<? extends Activity>) ClassModeActivity.class);
                    break;
                }
                break;
            case 50:
                if (type.equals("2")) {
                    ActivityUtils.finishActivity((Class<? extends Activity>) DominateScreenActivity.class);
                    break;
                }
                break;
            case 51:
                if (type.equals("3")) {
                    ActivityUtils.finishActivity((Class<? extends Activity>) ExamFullScreenActivity.class);
                    break;
                }
                break;
            case 52:
                if (type.equals("4")) {
                    ActivityUtils.finishActivity((Class<? extends Activity>) CustomDominateActivity.class);
                    break;
                }
                break;
        }
    }

    private final void finishTypeActivity(List<DominateScreenBean> dataList, String... values) {
        boolean z;
        for (String str : values) {
            Iterator<DominateScreenBean> it2 = dataList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (Intrinsics.areEqual(it2.next().getType(), str)) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                INSTANCE.finishTypeActivity(str);
            }
        }
    }
}
