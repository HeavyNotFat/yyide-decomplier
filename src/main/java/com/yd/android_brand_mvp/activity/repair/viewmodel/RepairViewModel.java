package com.yd.android_brand_mvp.activity.repair.viewmodel;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.userspace.FlowElementListItem;
import com.yd.android_brand_mvp.model.userspace.LeaveDetailBean;
import com.yd.android_brand_mvp.model.userspace.LeaveFormBean;
import com.yd.android_brand_mvp.model.userspace.LeaveProcessBean;
import com.yd.android_brand_mvp.model.userspace.LeaveRecordBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.userspace.UserSpaceNetWork;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: RepairViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000bJ\u000e\u0010\u0018\u001a\u00020*2\u0006\u0010,\u001a\u00020&J&\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020&2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201J6\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020&2\u0006\u0010+\u001a\u00020\u000b2\u0006\u00107\u001a\u00020&2\u0006\u0010/\u001a\u00020&JL\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020&2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u00122\u0006\u0010=\u001a\u00020&2\u0006\u00106\u001a\u00020&2\u0006\u0010>\u001a\u00020&2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020&J8\u0010?\u001a\u00020*2\u0006\u0010,\u001a\u00020&2\u0006\u0010/\u001a\u00020&2\u0006\u00106\u001a\u00020&2\u0006\u0010@\u001a\u0002012\u0006\u0010A\u001a\u00020&2\b\b\u0002\u0010=\u001a\u00020&J4\u0010B\u001a\u00020*2\u0006\u00104\u001a\u00020&2\u0006\u0010C\u001a\u00020&2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u00122\u0006\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020&R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u000fX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R,\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00110\n0\tø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR)\u0010\u0015\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00110\n0\u000fX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\tø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\rR\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\u000fX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\rR\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u000fX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\n0\tø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\rR\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\n0\u000fX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\n0\tø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\rR\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\n0\u000fX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\n0\tø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\rR\u001d\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\n0\u000fX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006F"}, d2 = {"Lcom/yd/android_brand_mvp/activity/repair/viewmodel/RepairViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "componentFragmentList", "", "Landroidx/fragment/app/Fragment;", "getComponentFragmentList", "()Ljava/util/List;", "modifyResult", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "", "getModifyResult", "()Landroidx/lifecycle/LiveData;", "modifyResultLiveData", "Landroidx/lifecycle/MutableLiveData;", "recordList", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/userspace/LeaveRecordBean;", "getRecordList", "recordLiveData", "repairDetail", "Lcom/yd/android_brand_mvp/model/userspace/LeaveDetailBean;", "getRepairDetail", "repairDetailLiveData", "revokeResult", "getRevokeResult", "revokeResultLiveData", "studentLeaveForm", "Lcom/yd/android_brand_mvp/model/userspace/LeaveFormBean;", "getStudentLeaveForm", "studentLeaveFormLiveData", "studentLeaveProcess", "Lcom/yd/android_brand_mvp/model/userspace/LeaveProcessBean;", "getStudentLeaveProcess", "studentLeaveProcessLiveData", "submitResult", "", "getSubmitResult", "submitResultLiveData", "getFormDetail", "", "isStudent", "id", "getRepairList", "siteId", "schoolId", "pageNo", "", InnerConstant.Db.size, "getRepairProcess", "key", "jsonStr", "userId", "teacherUserId", "modifyForm", "formId", "formContent", "flowList", "Lcom/yd/android_brand_mvp/model/userspace/FlowElementListItem;", "reason", "userName", "revokeLeave", "identityInt", AppMeasurementSdk.ConditionalUserProperty.NAME, "submitRepair", "jsonItems", CommentsHomeFragment.TYPE_ID, "studentName", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RepairViewModel extends ViewModel {
    private final List<Fragment> componentFragmentList;
    private final LiveData<Result<Boolean>> modifyResult;
    private final MutableLiveData<Result<Boolean>> modifyResultLiveData;
    private final LiveData<Result<BasePageResponse<List<LeaveRecordBean>>>> recordList;
    private final MutableLiveData<Result<BasePageResponse<List<LeaveRecordBean>>>> recordLiveData;
    private final LiveData<Result<LeaveDetailBean>> repairDetail;
    private final MutableLiveData<Result<LeaveDetailBean>> repairDetailLiveData;
    private final LiveData<Result<Boolean>> revokeResult;
    private final MutableLiveData<Result<Boolean>> revokeResultLiveData;
    private final LiveData<Result<LeaveFormBean>> studentLeaveForm;
    private final MutableLiveData<Result<LeaveFormBean>> studentLeaveFormLiveData;
    private final LiveData<Result<LeaveProcessBean>> studentLeaveProcess;
    private final MutableLiveData<Result<LeaveProcessBean>> studentLeaveProcessLiveData;
    private final LiveData<Result<String>> submitResult;
    private final MutableLiveData<Result<String>> submitResultLiveData;

    public RepairViewModel() {
        MutableLiveData<Result<LeaveFormBean>> mutableLiveData = new MutableLiveData<>();
        this.studentLeaveFormLiveData = mutableLiveData;
        this.studentLeaveForm = mutableLiveData;
        MutableLiveData<Result<LeaveProcessBean>> mutableLiveData2 = new MutableLiveData<>();
        this.studentLeaveProcessLiveData = mutableLiveData2;
        this.studentLeaveProcess = mutableLiveData2;
        MutableLiveData<Result<String>> mutableLiveData3 = new MutableLiveData<>();
        this.submitResultLiveData = mutableLiveData3;
        this.submitResult = mutableLiveData3;
        MutableLiveData<Result<Boolean>> mutableLiveData4 = new MutableLiveData<>();
        this.modifyResultLiveData = mutableLiveData4;
        this.modifyResult = mutableLiveData4;
        MutableLiveData<Result<BasePageResponse<List<LeaveRecordBean>>>> mutableLiveData5 = new MutableLiveData<>();
        this.recordLiveData = mutableLiveData5;
        this.recordList = mutableLiveData5;
        MutableLiveData<Result<Boolean>> mutableLiveData6 = new MutableLiveData<>();
        this.revokeResultLiveData = mutableLiveData6;
        this.revokeResult = mutableLiveData6;
        MutableLiveData<Result<LeaveDetailBean>> mutableLiveData7 = new MutableLiveData<>();
        this.repairDetailLiveData = mutableLiveData7;
        this.repairDetail = mutableLiveData7;
        this.componentFragmentList = new ArrayList();
    }

    public final LiveData<Result<LeaveFormBean>> getStudentLeaveForm() {
        return this.studentLeaveForm;
    }

    public final LiveData<Result<LeaveProcessBean>> getStudentLeaveProcess() {
        return this.studentLeaveProcess;
    }

    public final LiveData<Result<String>> getSubmitResult() {
        return this.submitResult;
    }

    public final LiveData<Result<Boolean>> getModifyResult() {
        return this.modifyResult;
    }

    public final LiveData<Result<BasePageResponse<List<LeaveRecordBean>>>> getRecordList() {
        return this.recordList;
    }

    public final LiveData<Result<Boolean>> getRevokeResult() {
        return this.revokeResult;
    }

    public final LiveData<Result<LeaveDetailBean>> getRepairDetail() {
        return this.repairDetail;
    }

    public final List<Fragment> getComponentFragmentList() {
        return this.componentFragmentList;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.repair.viewmodel.RepairViewModel$getFormDetail$1, reason: invalid class name */
    /* JADX INFO: compiled from: RepairViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.repair.viewmodel.RepairViewModel$getFormDetail$1", f = "RepairViewModel.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isStudent;
        Object L$0;
        int label;
        final /* synthetic */ RepairViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, RepairViewModel repairViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$isStudent = z;
            this.this$0 = repairViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$isStudent, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            Object objM546getRepairFormgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (Intrinsics.areEqual(SpData.getSchoolType(), "2")) {
                    str = "allDeviceRepair";
                } else {
                    str = this.$isStudent ? "studentDeviceRepair" : "teacherDeviceRepair";
                }
                MutableLiveData mutableLiveData2 = this.this$0.studentLeaveFormLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM546getRepairFormgIAlus = UserSpaceNetWork.INSTANCE.m546getRepairFormgIAlus(str, this);
                if (objM546getRepairFormgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM546getRepairFormgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM546getRepairFormgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getFormDetail(boolean isStudent) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(isStudent, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.repair.viewmodel.RepairViewModel$getRepairProcess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepairViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.repair.viewmodel.RepairViewModel$getRepairProcess$1", f = "RepairViewModel.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
    static final class C03671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isStudent;
        final /* synthetic */ String $jsonStr;
        final /* synthetic */ String $key;
        final /* synthetic */ String $schoolId;
        final /* synthetic */ String $teacherUserId;
        final /* synthetic */ String $userId;
        Object L$0;
        int label;
        final /* synthetic */ RepairViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03671(String str, boolean z, String str2, String str3, String str4, String str5, RepairViewModel repairViewModel, Continuation<? super C03671> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$isStudent = z;
            this.$userId = str2;
            this.$schoolId = str3;
            this.$teacherUserId = str4;
            this.$jsonStr = str5;
            this.this$0 = repairViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03671(this.$key, this.$isStudent, this.$userId, this.$schoolId, this.$teacherUserId, this.$jsonStr, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM549getStudentLeaveProcessgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("fromKey", this.$key);
                if (this.$isStudent) {
                    map2.put(CommentsHomeFragment.TYPE_ID, this.$userId);
                    map2.put("identityUserId", this.$userId);
                    map2.put("identity", Boxing.boxInt(0));
                } else {
                    map2.put("schoolId", this.$schoolId);
                    map2.put("identityUserId", this.$userId);
                    map2.put("identityId", this.$teacherUserId);
                    map2.put("identity", Boxing.boxInt(1));
                }
                map2.put("fromComponent", this.$jsonStr);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.studentLeaveProcessLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM549getStudentLeaveProcessgIAlus = UserSpaceNetWork.INSTANCE.m549getStudentLeaveProcessgIAlus(requestBodyCreate, this);
                if (objM549getStudentLeaveProcessgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM549getStudentLeaveProcessgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM549getStudentLeaveProcessgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getRepairProcess(String key, String jsonStr, String userId, boolean isStudent, String teacherUserId, String schoolId) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(teacherUserId, "teacherUserId");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03671(key, isStudent, userId, schoolId, teacherUserId, jsonStr, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.repair.viewmodel.RepairViewModel$submitRepair$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepairViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.repair.viewmodel.RepairViewModel$submitRepair$1", f = "RepairViewModel.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
    static final class C03701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<FlowElementListItem> $flowList;
        final /* synthetic */ String $jsonItems;
        final /* synthetic */ String $key;
        final /* synthetic */ String $studentId;
        final /* synthetic */ String $studentName;
        Object L$0;
        int label;
        final /* synthetic */ RepairViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03701(String str, String str2, String str3, String str4, List<FlowElementListItem> list, RepairViewModel repairViewModel, Continuation<? super C03701> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$jsonItems = str2;
            this.$studentId = str3;
            this.$studentName = str4;
            this.$flowList = list;
            this.this$0 = repairViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03701(this.$key, this.$jsonItems, this.$studentId, this.$studentName, this.$flowList, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM553submitStudentLeavegIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("fromKey", this.$key);
                map2.put("formItems", this.$jsonItems);
                map2.put("assigneeId", this.$studentId);
                map2.put("assigneeName", this.$studentName);
                map2.put("flowElementList", this.$flowList);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.submitResultLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM553submitStudentLeavegIAlus = UserSpaceNetWork.INSTANCE.m553submitStudentLeavegIAlus(requestBodyCreate, this);
                if (objM553submitStudentLeavegIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM553submitStudentLeavegIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM553submitStudentLeavegIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void submitRepair(String key, String jsonItems, List<FlowElementListItem> flowList, String studentId, String studentName) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(jsonItems, "jsonItems");
        Intrinsics.checkNotNullParameter(flowList, "flowList");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(studentName, "studentName");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03701(key, jsonItems, studentId, studentName, flowList, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.repair.viewmodel.RepairViewModel$modifyForm$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepairViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.repair.viewmodel.RepairViewModel$modifyForm$1", f = "RepairViewModel.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
    static final class C03681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<FlowElementListItem> $flowList;
        final /* synthetic */ String $formContent;
        final /* synthetic */ String $formId;
        final /* synthetic */ boolean $isStudent;
        final /* synthetic */ String $reason;
        final /* synthetic */ String $schoolId;
        final /* synthetic */ String $userId;
        final /* synthetic */ String $userName;
        Object L$0;
        int label;
        final /* synthetic */ RepairViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03681(String str, String str2, String str3, List<FlowElementListItem> list, boolean z, String str4, String str5, String str6, RepairViewModel repairViewModel, Continuation<? super C03681> continuation) {
            super(2, continuation);
            this.$formId = str;
            this.$formContent = str2;
            this.$reason = str3;
            this.$flowList = list;
            this.$isStudent = z;
            this.$schoolId = str4;
            this.$userId = str5;
            this.$userName = str6;
            this.this$0 = repairViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03681(this.$formId, this.$formContent, this.$reason, this.$flowList, this.$isStudent, this.$schoolId, this.$userId, this.$userName, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM550modifyFormgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("actUserApprId", this.$formId);
                map2.put("formItems", this.$formContent);
                map2.put("updateReason", this.$reason);
                map2.put("flowElementList", this.$flowList);
                map2.put("sponsorType", Boxing.boxInt(!this.$isStudent ? 1 : 0));
                map2.put("schoolId", this.$schoolId);
                map2.put("assigneeId", this.$userId);
                map2.put("assigneeName", this.$userName);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.modifyResultLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM550modifyFormgIAlus = UserSpaceNetWork.INSTANCE.m550modifyFormgIAlus(requestBodyCreate, this);
                if (objM550modifyFormgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM550modifyFormgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM550modifyFormgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void modifyForm(String formId, String formContent, List<FlowElementListItem> flowList, String reason, String userId, String userName, boolean isStudent, String schoolId) {
        Intrinsics.checkNotNullParameter(formId, "formId");
        Intrinsics.checkNotNullParameter(formContent, "formContent");
        Intrinsics.checkNotNullParameter(flowList, "flowList");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03681(formId, formContent, reason, flowList, isStudent, schoolId, userId, userName, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.repair.viewmodel.RepairViewModel$getRepairList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepairViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.repair.viewmodel.RepairViewModel$getRepairList$1", f = "RepairViewModel.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
    static final class C03661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $pageNo;
        final /* synthetic */ String $schoolId;
        final /* synthetic */ String $siteId;
        final /* synthetic */ int $size;
        Object L$0;
        int label;
        final /* synthetic */ RepairViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03661(String str, String str2, int i, int i2, RepairViewModel repairViewModel, Continuation<? super C03661> continuation) {
            super(2, continuation);
            this.$siteId = str;
            this.$schoolId = str2;
            this.$pageNo = i;
            this.$size = i2;
            this.this$0 = repairViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03661(this.$siteId, this.$schoolId, this.$pageNo, this.$size, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM547getRepairListgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("siteId", this.$siteId);
                map2.put("schoolId", this.$schoolId);
                map2.put("pageNo", Boxing.boxInt(this.$pageNo));
                map2.put("pageSize", Boxing.boxInt(this.$size));
                map2.put("queryNewStatus", Boxing.boxBoolean(true));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.recordLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM547getRepairListgIAlus = UserSpaceNetWork.INSTANCE.m547getRepairListgIAlus(requestBodyCreate, this);
                if (objM547getRepairListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM547getRepairListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM547getRepairListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getRepairList(String siteId, String schoolId, int pageNo, int size) {
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03661(siteId, schoolId, pageNo, size, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.repair.viewmodel.RepairViewModel$getRepairDetail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepairViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.repair.viewmodel.RepairViewModel$getRepairDetail$1", f = "RepairViewModel.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
    static final class C03651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03651(String str, Continuation<? super C03651> continuation) {
            super(2, continuation);
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RepairViewModel.this.new C03651(this.$id, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData2 = RepairViewModel.this.repairDetailLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objM541getLeaveDetailInfogIAlus = UserSpaceNetWork.INSTANCE.m541getLeaveDetailInfogIAlus(this.$id, this);
                if (objM541getLeaveDetailInfogIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                value = objM541getLeaveDetailInfogIAlus;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                value = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(value));
            return Unit.INSTANCE;
        }
    }

    public final void getRepairDetail(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03651(id, null), 3, null);
    }

    public static /* synthetic */ void revokeLeave$default(RepairViewModel repairViewModel, String str, String str2, String str3, int i, String str4, String str5, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            str5 = "";
        }
        repairViewModel.revokeLeave(str, str2, str3, i, str4, str5);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.repair.viewmodel.RepairViewModel$revokeLeave$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepairViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.repair.viewmodel.RepairViewModel$revokeLeave$1", f = "RepairViewModel.kt", i = {}, l = {183}, m = "invokeSuspend", n = {}, s = {})
    static final class C03691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        final /* synthetic */ int $identityInt;
        final /* synthetic */ String $name;
        final /* synthetic */ String $reason;
        final /* synthetic */ String $schoolId;
        final /* synthetic */ String $userId;
        Object L$0;
        int label;
        final /* synthetic */ RepairViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03691(String str, String str2, String str3, String str4, int i, String str5, RepairViewModel repairViewModel, Continuation<? super C03691> continuation) {
            super(2, continuation);
            this.$id = str;
            this.$reason = str2;
            this.$schoolId = str3;
            this.$userId = str4;
            this.$identityInt = i;
            this.$name = str5;
            this.this$0 = repairViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03691(this.$id, this.$reason, this.$schoolId, this.$userId, this.$identityInt, this.$name, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM551revokeLeavegIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("processInstanceId", this.$id);
                map2.put("deleteReason", this.$reason);
                map2.put("schoolId", this.$schoolId);
                map2.put("assigneeId", this.$userId);
                map2.put("sponsorType", Boxing.boxInt(this.$identityInt));
                map2.put("assigneeName", this.$name);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.revokeResultLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM551revokeLeavegIAlus = UserSpaceNetWork.INSTANCE.m551revokeLeavegIAlus(requestBodyCreate, this);
                if (objM551revokeLeavegIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM551revokeLeavegIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM551revokeLeavegIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void revokeLeave(String id, String schoolId, String userId, int identityInt, String name, String reason) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reason, "reason");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03691(id, reason, schoolId, userId, identityInt, name, this, null), 3, null);
    }
}
