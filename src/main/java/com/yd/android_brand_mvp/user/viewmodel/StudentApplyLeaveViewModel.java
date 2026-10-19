package com.yd.android_brand_mvp.user.viewmodel;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.userspace.FlowElementListItem;
import com.yd.android_brand_mvp.model.userspace.LeaveFormBean;
import com.yd.android_brand_mvp.model.userspace.LeaveProcessBean;
import com.yd.android_brand_mvp.model.userspace.LeaveTypeBean;
import com.yd.android_brand_mvp.network.userspace.UserSpaceNetWork;
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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: StudentApplyLeaveViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010'\u001a\u00020(J.\u0010\f\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000bJ\u001e\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000bJ\u0006\u00101\u001a\u00020(J4\u00102\u001a\u00020(2\u0006\u0010/\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\f\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00112\u0006\u0010)\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u000fX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R&\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\n0\tø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR#\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\n0\u000fX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R+\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\nX\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR)\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\n0\tX\u0086\u000eø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u001eR\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\n0\u000fX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\n0\tø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\rR\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\n0\u000fX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\rR\u001d\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u000fX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00067"}, d2 = {"Lcom/yd/android_brand_mvp/user/viewmodel/StudentApplyLeaveViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "componentFragmentList", "", "Landroidx/fragment/app/Fragment;", "getComponentFragmentList", "()Ljava/util/List;", "leaveLength", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "", "getLeaveLength", "()Landroidx/lifecycle/LiveData;", "leaveLengthLiveData", "Landroidx/lifecycle/MutableLiveData;", "leaveTypeList", "", "Lcom/yd/android_brand_mvp/model/userspace/LeaveTypeBean;", "getLeaveTypeList", "leaveTypeListLiveData", "mLeaveFormBean", "Lcom/yd/android_brand_mvp/model/userspace/LeaveFormBean;", "getMLeaveFormBean-xLWZpok", "()Lkotlin/Result;", "setMLeaveFormBean", "(Lkotlin/Result;)V", "studentLeaveForm", "getStudentLeaveForm", "setStudentLeaveForm", "(Landroidx/lifecycle/LiveData;)V", "studentLeaveFormLiveData", "studentLeaveProcess", "Lcom/yd/android_brand_mvp/model/userspace/LeaveProcessBean;", "getStudentLeaveProcess", "studentLeaveProcessLiveData", "submitResult", "getSubmitResult", "submitResultLiveData", "getLeaveFormDetail", "", CommentsHomeFragment.TYPE_ID, "startTime", "endTime", "durationType", "durationWay", "getLeaveProcess", "key", "jsonStr", "getLeaveTypeOption", "submitLeave", "jsonItems", "flowList", "Lcom/yd/android_brand_mvp/model/userspace/FlowElementListItem;", "studentName", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StudentApplyLeaveViewModel extends ViewModel {
    private final List<Fragment> componentFragmentList;
    private final LiveData<Result<String>> leaveLength;
    private final MutableLiveData<Result<String>> leaveLengthLiveData;
    private final LiveData<Result<List<LeaveTypeBean>>> leaveTypeList;
    private final MutableLiveData<Result<List<LeaveTypeBean>>> leaveTypeListLiveData;
    private Result<LeaveFormBean> mLeaveFormBean;
    private LiveData<Result<LeaveFormBean>> studentLeaveForm;
    private final MutableLiveData<Result<LeaveFormBean>> studentLeaveFormLiveData;
    private final LiveData<Result<LeaveProcessBean>> studentLeaveProcess;
    private final MutableLiveData<Result<LeaveProcessBean>> studentLeaveProcessLiveData;
    private final LiveData<Result<String>> submitResult;
    private final MutableLiveData<Result<String>> submitResultLiveData;

    public StudentApplyLeaveViewModel() {
        MutableLiveData<Result<LeaveFormBean>> mutableLiveData = new MutableLiveData<>();
        this.studentLeaveFormLiveData = mutableLiveData;
        this.studentLeaveForm = mutableLiveData;
        MutableLiveData<Result<LeaveProcessBean>> mutableLiveData2 = new MutableLiveData<>();
        this.studentLeaveProcessLiveData = mutableLiveData2;
        this.studentLeaveProcess = mutableLiveData2;
        MutableLiveData<Result<String>> mutableLiveData3 = new MutableLiveData<>();
        this.submitResultLiveData = mutableLiveData3;
        this.submitResult = mutableLiveData3;
        MutableLiveData<Result<List<LeaveTypeBean>>> mutableLiveData4 = new MutableLiveData<>();
        this.leaveTypeListLiveData = mutableLiveData4;
        this.leaveTypeList = mutableLiveData4;
        MutableLiveData<Result<String>> mutableLiveData5 = new MutableLiveData<>();
        this.leaveLengthLiveData = mutableLiveData5;
        this.leaveLength = mutableLiveData5;
        this.componentFragmentList = new ArrayList();
    }

    public final LiveData<Result<LeaveFormBean>> getStudentLeaveForm() {
        return this.studentLeaveForm;
    }

    public final void setStudentLeaveForm(LiveData<Result<LeaveFormBean>> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.studentLeaveForm = liveData;
    }

    /* JADX INFO: renamed from: getMLeaveFormBean-xLWZpok, reason: not valid java name */
    public final Result<LeaveFormBean> m570getMLeaveFormBeanxLWZpok() {
        return this.mLeaveFormBean;
    }

    public final void setMLeaveFormBean(Result<LeaveFormBean> result) {
        this.mLeaveFormBean = result;
    }

    public final LiveData<Result<LeaveProcessBean>> getStudentLeaveProcess() {
        return this.studentLeaveProcess;
    }

    public final LiveData<Result<String>> getSubmitResult() {
        return this.submitResult;
    }

    public final LiveData<Result<List<LeaveTypeBean>>> getLeaveTypeList() {
        return this.leaveTypeList;
    }

    public final LiveData<Result<String>> getLeaveLength() {
        return this.leaveLength;
    }

    public final List<Fragment> getComponentFragmentList() {
        return this.componentFragmentList;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.user.viewmodel.StudentApplyLeaveViewModel$getLeaveFormDetail$1, reason: invalid class name */
    /* JADX INFO: compiled from: StudentApplyLeaveViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.user.viewmodel.StudentApplyLeaveViewModel$getLeaveFormDetail$1", f = "StudentApplyLeaveViewModel.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StudentApplyLeaveViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData2 = StudentApplyLeaveViewModel.this.studentLeaveFormLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objM548getStudentLeaveFormIoAF18A = UserSpaceNetWork.INSTANCE.m548getStudentLeaveFormIoAF18A(this);
                if (objM548getStudentLeaveFormIoAF18A == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                value = objM548getStudentLeaveFormIoAF18A;
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

    public final void getLeaveFormDetail() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.user.viewmodel.StudentApplyLeaveViewModel$getLeaveProcess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StudentApplyLeaveViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.user.viewmodel.StudentApplyLeaveViewModel$getLeaveProcess$1", f = "StudentApplyLeaveViewModel.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
    static final class C05601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $jsonStr;
        final /* synthetic */ String $key;
        final /* synthetic */ String $studentId;
        Object L$0;
        int label;
        final /* synthetic */ StudentApplyLeaveViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05601(String str, String str2, String str3, StudentApplyLeaveViewModel studentApplyLeaveViewModel, Continuation<? super C05601> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$studentId = str2;
            this.$jsonStr = str3;
            this.this$0 = studentApplyLeaveViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05601(this.$key, this.$studentId, this.$jsonStr, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                map2.put(CommentsHomeFragment.TYPE_ID, this.$studentId);
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

    public final void getLeaveProcess(String key, String studentId, String jsonStr) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05601(key, studentId, jsonStr, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.user.viewmodel.StudentApplyLeaveViewModel$submitLeave$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StudentApplyLeaveViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.user.viewmodel.StudentApplyLeaveViewModel$submitLeave$1", f = "StudentApplyLeaveViewModel.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    static final class C05621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<FlowElementListItem> $flowList;
        final /* synthetic */ String $jsonItems;
        final /* synthetic */ String $key;
        final /* synthetic */ String $studentId;
        final /* synthetic */ String $studentName;
        Object L$0;
        int label;
        final /* synthetic */ StudentApplyLeaveViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05621(String str, String str2, String str3, String str4, List<FlowElementListItem> list, StudentApplyLeaveViewModel studentApplyLeaveViewModel, Continuation<? super C05621> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$jsonItems = str2;
            this.$studentId = str3;
            this.$studentName = str4;
            this.$flowList = list;
            this.this$0 = studentApplyLeaveViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05621(this.$key, this.$jsonItems, this.$studentId, this.$studentName, this.$flowList, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

    public final void submitLeave(String key, String jsonItems, List<FlowElementListItem> flowList, String studentId, String studentName) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(jsonItems, "jsonItems");
        Intrinsics.checkNotNullParameter(flowList, "flowList");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(studentName, "studentName");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05621(key, jsonItems, studentId, studentName, flowList, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.user.viewmodel.StudentApplyLeaveViewModel$getLeaveTypeOption$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StudentApplyLeaveViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.user.viewmodel.StudentApplyLeaveViewModel$getLeaveTypeOption$1", f = "StudentApplyLeaveViewModel.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
    static final class C05611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C05611(Continuation<? super C05611> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StudentApplyLeaveViewModel.this.new C05611(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData2 = StudentApplyLeaveViewModel.this.leaveTypeListLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objM544getLeaveTypeOptionsIoAF18A = UserSpaceNetWork.INSTANCE.m544getLeaveTypeOptionsIoAF18A(this);
                if (objM544getLeaveTypeOptionsIoAF18A == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                value = objM544getLeaveTypeOptionsIoAF18A;
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

    public final void getLeaveTypeOption() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05611(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.user.viewmodel.StudentApplyLeaveViewModel$getLeaveLength$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StudentApplyLeaveViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.user.viewmodel.StudentApplyLeaveViewModel$getLeaveLength$1", f = "StudentApplyLeaveViewModel.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
    static final class C05591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $durationType;
        final /* synthetic */ String $durationWay;
        final /* synthetic */ String $endTime;
        final /* synthetic */ String $startTime;
        final /* synthetic */ String $studentId;
        Object L$0;
        int label;
        final /* synthetic */ StudentApplyLeaveViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05591(String str, String str2, String str3, String str4, String str5, StudentApplyLeaveViewModel studentApplyLeaveViewModel, Continuation<? super C05591> continuation) {
            super(2, continuation);
            this.$startTime = str;
            this.$endTime = str2;
            this.$durationType = str3;
            this.$durationWay = str4;
            this.$studentId = str5;
            this.this$0 = studentApplyLeaveViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05591(this.$startTime, this.$endTime, this.$durationType, this.$durationWay, this.$studentId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM542getLeaveLengthgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("startTime", this.$startTime);
                map2.put("endTime", this.$endTime);
                map2.put("durationType", this.$durationType);
                map2.put("durationWay", this.$durationWay);
                map2.put("userId", this.$studentId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.leaveLengthLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM542getLeaveLengthgIAlus = UserSpaceNetWork.INSTANCE.m542getLeaveLengthgIAlus(requestBodyCreate, this);
                if (objM542getLeaveLengthgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM542getLeaveLengthgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM542getLeaveLengthgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getLeaveLength(String studentId, String startTime, String endTime, String durationType, String durationWay) {
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(durationType, "durationType");
        Intrinsics.checkNotNullParameter(durationWay, "durationWay");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05591(startTime, endTime, durationType, durationWay, studentId, this, null), 3, null);
    }
}
