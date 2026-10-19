package com.yd.android_brand_mvp.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.adapter.attence.AttendancePeople;
import com.yd.android_brand_mvp.adapter.attence.PostAttenceBean;
import com.yd.android_brand_mvp.adapter.attence.RuleUtils;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.db.DataBaseInstance;
import com.yd.android_brand_mvp.db.User;
import com.yd.android_brand_mvp.db.UserDao;
import com.yd.android_brand_mvp.model.GeneralBean;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.verfity.FaceMsg;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: compiled from: AttendanceUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J\u0016\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/utils/AttendanceUtils;", "", "()V", "CARD_TYPE", "", "FACE_TYPE", "listAll", "", "Lcom/yd/android_brand_mvp/db/User;", "addAttendance", "", PushConstants.INTENT_ACTIVITY_NAME, "Landroid/app/Activity;", "attendancePeople", "Lcom/yd/android_brand_mvp/adapter/attence/AttendancePeople;", "attendance", "userIdOrCardNo", "", "type", "isHave", "", "faceId", "pushAttendanceSubmit", "callback", "Lcom/yd/android_brand_mvp/utils/AttendanceUtils$OnPushAttendanceData;", "saveDataDB", "bean", "updateAttendancePeople", "id", "", "OnPushAttendanceData", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AttendanceUtils {
    public static final int CARD_TYPE = 2;
    public static final int FACE_TYPE = 1;
    public static final AttendanceUtils INSTANCE = new AttendanceUtils();
    private static List<? extends User> listAll = new ArrayList();

    /* JADX INFO: compiled from: AttendanceUtils.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/utils/AttendanceUtils$OnPushAttendanceData;", "", "callbackData", "", "data", "", "Lcom/yd/android_brand_mvp/adapter/attence/PostAttenceBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnPushAttendanceData {
        void callbackData(List<PostAttenceBean> data);
    }

    private AttendanceUtils() {
    }

    public final void attendance(Activity activity, String userIdOrCardNo, int type) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userIdOrCardNo, "userIdOrCardNo");
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("考勤类型 = ");
        sb.append(type == 1 ? "人脸" : "刷卡");
        objArr[0] = sb.toString();
        LogUtils.i(objArr);
        if (SpData.getAttenceRule2() == null) {
            ToastUtil.showView(activity, "未查询到考勤规则");
        }
        AttendancePeople attendancePeople = RuleUtils.getInstance().getAttendancePeople(userIdOrCardNo);
        if (attendancePeople == null || TextUtils.isEmpty(attendancePeople.name)) {
            attendancePeople = RuleUtils.getInstance().IsTeacherByCard(userIdOrCardNo);
        }
        if (attendancePeople == null || TextUtils.isEmpty(attendancePeople.name)) {
            attendancePeople = RuleUtils.getInstance().getSiteTeacher(userIdOrCardNo);
        }
        if (attendancePeople != null && !TextUtils.isEmpty(attendancePeople.name)) {
            addAttendance(activity, attendancePeople);
        } else {
            ToastUtil.showView(activity, "非考勤人员");
        }
    }

    private final void addAttendance(Activity activity, AttendancePeople attendancePeople) {
        if (isHave("" + attendancePeople.id)) {
            ToastUtil.showView(activity, FaceMsg.FaceMore);
            return;
        }
        KBRsp2.DataDTO.TimetableListDTO timetableListDTOIsTable = RuleUtils.getInstance().isTable();
        KBRsp2.DataDTO.TimetableListDTO timetableListDTOIsSiteTable = RuleUtils.getInstance().isSiteTable();
        if (timetableListDTOIsTable != null) {
            if (!TextUtils.isEmpty(timetableListDTOIsTable.subjectName)) {
                attendancePeople.setAttenceName(timetableListDTOIsTable.subjectName);
                attendancePeople.setListCouseId(timetableListDTOIsTable.id);
                if (timetableListDTOIsSiteTable != null) {
                    attendancePeople.setSiteTimetableId(timetableListDTOIsSiteTable.id);
                }
                attendancePeople.setStatus("0");
                attendancePeople.setTime(TimeUtil.stampToDate9(System.currentTimeMillis()));
            }
        } else if (timetableListDTOIsSiteTable != null) {
            attendancePeople.setAttenceName(timetableListDTOIsSiteTable.subjectName);
            attendancePeople.setSiteTimetableId(timetableListDTOIsSiteTable.id);
            attendancePeople.setStatus("0");
            attendancePeople.setTime(TimeUtil.stampToDate9(System.currentTimeMillis()));
        }
        if (!TextUtils.isEmpty(attendancePeople.getName())) {
            AttendancePeople peopleBean = RuleUtils.getInstance().IsTime(attendancePeople);
            if (timetableListDTOIsSiteTable != null) {
                peopleBean.setSiteTimetableId(timetableListDTOIsSiteTable.id);
            }
            if (!TextUtils.isEmpty(peopleBean.getTime())) {
                LogUtils.i("考勤人员= " + GsonUtils.toJson(peopleBean));
                Intrinsics.checkNotNullExpressionValue(peopleBean, "peopleBean");
                saveDataDB(activity, peopleBean);
                return;
            }
            LogUtils.i("非考勤时间" + GsonUtils.toJson(peopleBean));
            ToastUtil.showView(activity, "非考勤时间");
            return;
        }
        LogUtils.i("非考勤人员" + GsonUtils.toJson(attendancePeople));
        ToastUtil.showView(activity, "非考勤人员");
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.utils.AttendanceUtils$saveDataDB$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AttendanceUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.utils.AttendanceUtils$saveDataDB$1", f = "AttendanceUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C05631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ AttendancePeople $bean;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05631(Activity activity, AttendancePeople attendancePeople, Continuation<? super C05631> continuation) {
            super(2, continuation);
            this.$activity = activity;
            this.$bean = attendancePeople;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05631(this.$activity, this.$bean, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            UserDao userDao = DataBaseInstance.getInstance(this.$activity).userDao();
            User user = new User();
            user.userId = this.$bean.getId();
            user.name = this.$bean.getName();
            user.time = this.$bean.getTime();
            user.AttenceId = this.$bean.getAttenceId();
            user.siteTimetableId = this.$bean.getSiteTimetableId();
            user.type = this.$bean.getType();
            user.Timeid = this.$bean.getTimeid();
            user.classesId = this.$bean.getClassesId();
            user.identy = this.$bean.getIdenty();
            user.ispost = false;
            user.isCard = "";
            user.listAttenceId = this.$bean.getAttenceIdList();
            user.listCouseId = this.$bean.getListCouseId();
            userDao.insertAll(user);
            AttendanceUtils attendanceUtils = AttendanceUtils.INSTANCE;
            List<User> all = userDao.getAll();
            Intrinsics.checkNotNullExpressionValue(all, "userDao.getAll()");
            AttendanceUtils.listAll = all;
            GeneralBean.DataBean dataBean = new GeneralBean.DataBean();
            dataBean.peopleName = user.name;
            dataBean.attendanceName = user.AttenceName;
            dataBean.createdDateTime = user.time;
            dataBean.message = "打卡成功";
            ToastUtil.showView(this.$activity, dataBean, "");
            EventBus.getDefault().post("db");
            MinaEventManager.getInstance().notifyObserver(MinaConstants.PostFace);
            userDao.deleteUsersBefore(TimeUtil.stampToDate9(System.currentTimeMillis() - ((long) 864000000)));
            return Unit.INSTANCE;
        }
    }

    private final void saveDataDB(Activity activity, AttendancePeople bean) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C05631(activity, bean, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.utils.AttendanceUtils$pushAttendanceSubmit$1, reason: invalid class name */
    /* JADX INFO: compiled from: AttendanceUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.utils.AttendanceUtils$pushAttendanceSubmit$1", f = "AttendanceUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ OnPushAttendanceData $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Activity activity, OnPushAttendanceData onPushAttendanceData, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activity = activity;
            this.$callback = onPushAttendanceData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$activity, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Log.i("postData", "pushAttendanceSubmit: 考勤打卡");
            List<User> all = DataBaseInstance.getInstance(this.$activity).userDao().getAll();
            ArrayList arrayList = new ArrayList();
            for (User user : all) {
                if (!user.ispost) {
                    PostAttenceBean postAttenceBean = new PostAttenceBean();
                    postAttenceBean.studentId = String.valueOf(user.userId);
                    postAttenceBean.signInTime = user.time.toString();
                    postAttenceBean.attendanceIds = user.listAttenceId;
                    postAttenceBean.timetableId = user.listCouseId;
                    postAttenceBean.siteTimetableId = user.siteTimetableId;
                    postAttenceBean.deviceNo = BaseApplication.getInstance().getMac();
                    if (SpData.NewUser().data != null) {
                        postAttenceBean.deviceName = SpData.NewUser().data.brandName;
                        postAttenceBean.siteName = SpData.getSiteName();
                        postAttenceBean.siteId = SpData.getSiteId();
                    }
                    String str = "0";
                    if (!TextUtils.isEmpty(user.listAttenceId) && (!TextUtils.isEmpty(user.listCouseId) || !TextUtils.isEmpty(user.siteTimetableId))) {
                        str = "2";
                    } else if (!TextUtils.isEmpty(user.listAttenceId)) {
                        str = "1";
                    } else if (TextUtils.isEmpty(user.listCouseId)) {
                        TextUtils.isEmpty(user.siteTimetableId);
                    }
                    Log.e("Type", str);
                    postAttenceBean.type = str;
                    arrayList.add(postAttenceBean);
                }
            }
            Log.i("attendanceInfo_list", "上报考勤人员 = " + GsonUtils.toJson(arrayList));
            if (arrayList.size() > 0) {
                this.$callback.callbackData(arrayList);
            }
            return Unit.INSTANCE;
        }
    }

    public final void pushAttendanceSubmit(Activity activity, OnPushAttendanceData callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(activity, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.utils.AttendanceUtils$updateAttendancePeople$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AttendanceUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.utils.AttendanceUtils$updateAttendancePeople$1", f = "AttendanceUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C05641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ long $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05641(Activity activity, long j, Continuation<? super C05641> continuation) {
            super(2, continuation);
            this.$activity = activity;
            this.$id = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05641(this.$activity, this.$id, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05641) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            UserDao userDao = DataBaseInstance.getInstance(this.$activity).userDao();
            List<User> listFindById = userDao.findById(this.$id);
            Intrinsics.checkNotNullExpressionValue(listFindById, "userDao.findById(id)");
            for (User user : listFindById) {
                long j = 1000;
                if ((System.currentTimeMillis() / j) - (TimeUtil.gettime999(user.time) / j) > 1800) {
                    userDao.delete(user);
                    Log.e("TAG", "user==: " + JSON.toJSONString(user));
                } else {
                    user.ispost = true;
                    userDao.update(user);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void updateAttendancePeople(Activity activity, long id) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C05641(activity, id, null), 3, null);
    }

    private final boolean isHave(String faceId) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Log.e("NOWtIME", "nowTime:" + jCurrentTimeMillis);
        boolean z = false;
        for (User user : listAll) {
            long j = TimeUtil.gettime999(user.time);
            if (Intrinsics.areEqual(faceId, user.userId + "") && jCurrentTimeMillis - j <= 60000) {
                z = true;
            }
        }
        return z;
    }
}
