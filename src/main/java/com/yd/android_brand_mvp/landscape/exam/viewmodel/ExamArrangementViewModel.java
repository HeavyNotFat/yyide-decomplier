package com.yd.android_brand_mvp.landscape.exam.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.exam.ExamArrangementBean;
import com.yd.android_brand_mvp.model.exam.ExamPersonSeatBean;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
import com.yd.android_brand_mvp.network.exam.ExamManageNetwork;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yyide.facepass.AppExtKt;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: ExamArrangementViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010(\u001a\u00020)J\u001e\u0010\r\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001cJ\u001e\u0010-\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001cJ\u0006\u0010.\u001a\u00020)J\u0006\u0010\"\u001a\u00020)J\u0006\u0010&\u001a\u00020)J\b\u0010/\u001a\u00020)H\u0014J&\u0010\u0016\u001a\u00020)2\u0006\u00100\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001cJ\u0019\u00101\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0086@ø\u0001\u0000¢\u0006\u0002\u00104R&\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u000bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00050\u000bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR#\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00060\u00050\u000bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00050\u000bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\tR#\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u000bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R&\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\tR#\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00060\u00050\u000bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/viewmodel/ExamArrangementViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "bannerExam", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "getBannerExam", "()Landroidx/lifecycle/LiveData;", "bannerExamLiveData", "Landroidx/lifecycle/MutableLiveData;", "examDetail", "getExamDetail", "examDetailLiveData", "homeExamList", "getHomeExamList", "homeExamListLiveData", "seatInExam", "Lcom/yd/android_brand_mvp/model/exam/ExamPersonSeatBean;", "getSeatInExam", "seatInExamLiveData", "signInExam", "", "getSignInExam", "signInExamLiveData", "timeSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "getTimeSharedFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "timerFlow", "Lkotlinx/coroutines/Job;", "todayExam", "getTodayExam", "todayExamLiveData", "weekExam", "Lcom/yd/android_brand_mvp/model/exam/ExamArrangementBean;", "getWeekExam", "weekExamLiveData", "getBannerExamList", "", "siteId", "subjectId", "examinationId", "getExamSeat", "getHomeExamListData", "onCleared", CommentsHomeFragment.TYPE_ID, "startTimer", "seconds", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExamArrangementViewModel extends ViewModel {
    private final LiveData<Result<List<ExamPlanItem>>> bannerExam;
    private final MutableLiveData<Result<List<ExamPlanItem>>> bannerExamLiveData;
    private final LiveData<Result<ExamPlanItem>> examDetail;
    private final MutableLiveData<Result<ExamPlanItem>> examDetailLiveData;
    private final LiveData<List<ExamPlanItem>> homeExamList;
    private final MutableLiveData<List<ExamPlanItem>> homeExamListLiveData;
    private final LiveData<Result<List<ExamPersonSeatBean>>> seatInExam;
    private final MutableLiveData<Result<List<ExamPersonSeatBean>>> seatInExamLiveData;
    private final LiveData<Result<Boolean>> signInExam;
    private final MutableLiveData<Result<Boolean>> signInExamLiveData;
    private final MutableSharedFlow<String> timeSharedFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    private Job timerFlow;
    private final LiveData<Result<List<ExamPlanItem>>> todayExam;
    private final MutableLiveData<Result<List<ExamPlanItem>>> todayExamLiveData;
    private final LiveData<Result<List<ExamArrangementBean>>> weekExam;
    private final MutableLiveData<Result<List<ExamArrangementBean>>> weekExamLiveData;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$startTimer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExamArrangementViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel", f = "ExamArrangementViewModel.kt", i = {0, 0}, l = {65}, m = "startTimer", n = {"this", "seconds"}, s = {"L$0", "I$0"})
    static final class C04721 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04721(Continuation<? super C04721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExamArrangementViewModel.this.startTimer(0, this);
        }
    }

    public ExamArrangementViewModel() {
        MutableLiveData<Result<List<ExamPlanItem>>> mutableLiveData = new MutableLiveData<>();
        this.todayExamLiveData = mutableLiveData;
        this.todayExam = mutableLiveData;
        MutableLiveData<Result<List<ExamPlanItem>>> mutableLiveData2 = new MutableLiveData<>();
        this.bannerExamLiveData = mutableLiveData2;
        this.bannerExam = mutableLiveData2;
        MutableLiveData<List<ExamPlanItem>> mutableLiveData3 = new MutableLiveData<>();
        this.homeExamListLiveData = mutableLiveData3;
        this.homeExamList = mutableLiveData3;
        MutableLiveData<Result<List<ExamArrangementBean>>> mutableLiveData4 = new MutableLiveData<>();
        this.weekExamLiveData = mutableLiveData4;
        this.weekExam = mutableLiveData4;
        MutableLiveData<Result<ExamPlanItem>> mutableLiveData5 = new MutableLiveData<>();
        this.examDetailLiveData = mutableLiveData5;
        this.examDetail = mutableLiveData5;
        MutableLiveData<Result<List<ExamPersonSeatBean>>> mutableLiveData6 = new MutableLiveData<>();
        this.seatInExamLiveData = mutableLiveData6;
        this.seatInExam = mutableLiveData6;
        MutableLiveData<Result<Boolean>> mutableLiveData7 = new MutableLiveData<>();
        this.signInExamLiveData = mutableLiveData7;
        this.signInExam = mutableLiveData7;
    }

    public final MutableSharedFlow<String> getTimeSharedFlow() {
        return this.timeSharedFlow;
    }

    public final LiveData<Result<List<ExamPlanItem>>> getTodayExam() {
        return this.todayExam;
    }

    public final LiveData<Result<List<ExamPlanItem>>> getBannerExam() {
        return this.bannerExam;
    }

    public final LiveData<List<ExamPlanItem>> getHomeExamList() {
        return this.homeExamList;
    }

    public final LiveData<Result<List<ExamArrangementBean>>> getWeekExam() {
        return this.weekExam;
    }

    public final LiveData<Result<ExamPlanItem>> getExamDetail() {
        return this.examDetail;
    }

    public final LiveData<Result<List<ExamPersonSeatBean>>> getSeatInExam() {
        return this.seatInExam;
    }

    public final LiveData<Result<Boolean>> getSignInExam() {
        return this.signInExam;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object startTimer(int i, Continuation<? super Unit> continuation) {
        C04721 c04721;
        ExamArrangementViewModel examArrangementViewModel;
        if (continuation instanceof C04721) {
            c04721 = (C04721) continuation;
            if ((c04721.label & Integer.MIN_VALUE) != 0) {
                c04721.label -= Integer.MIN_VALUE;
            } else {
                c04721 = new C04721(continuation);
            }
        } else {
            c04721 = new C04721(continuation);
        }
        Object obj = c04721.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c04721.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.timerFlow != null) {
                AppExtKt.logd(this, "ExamArrangementViewModel 重置timerFlow");
                Job job = this.timerFlow;
                if (job != null) {
                    c04721.L$0 = this;
                    c04721.I$0 = i;
                    c04721.label = 1;
                    if (JobKt.cancelAndJoin(job, c04721) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                examArrangementViewModel = this;
            } else {
                examArrangementViewModel = this;
            }
            examArrangementViewModel.timerFlow = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(examArrangementViewModel), null, null, new AnonymousClass2(i, examArrangementViewModel, null), 3, null);
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i = c04721.I$0;
        examArrangementViewModel = (ExamArrangementViewModel) c04721.L$0;
        ResultKt.throwOnFailure(obj);
        examArrangementViewModel.timerFlow = null;
        examArrangementViewModel.timerFlow = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(examArrangementViewModel), null, null, new AnonymousClass2(i, examArrangementViewModel, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$startTimer$2, reason: invalid class name */
    /* JADX INFO: compiled from: ExamArrangementViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$startTimer$2", f = "ExamArrangementViewModel.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $seconds;
        int label;
        final /* synthetic */ ExamArrangementViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i, ExamArrangementViewModel examArrangementViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$seconds = i;
            this.this$0 = examArrangementViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$seconds, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$startTimer$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ExamArrangementViewModel.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$startTimer$2$1", f = "ExamArrangementViewModel.kt", i = {0, 1}, l = {71, 72}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super String>, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $seconds;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(int i, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$seconds = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$seconds, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(FlowCollector<? super String> flowCollector, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:14:0x003b  */
            /* JADX WARN: Code duplicated, block: B:16:0x004a A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:19:0x005d A[RETURN] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x005b -> B:12:0x0031). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:16:0x004a
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r7.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L29
                    if (r1 == r3) goto L1f
                    if (r1 != r2) goto L17
                    java.lang.Object r1 = r7.L$0
                    kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                    kotlin.ResultKt.throwOnFailure(r8)
                    r8 = r1
                    goto L30
                L17:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L1f:
                    java.lang.Object r1 = r7.L$0
                    kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                    kotlin.ResultKt.throwOnFailure(r8)
                    r8 = r1
                    r1 = r7
                    goto L4b
                L29:
                    kotlin.ResultKt.throwOnFailure(r8)
                    java.lang.Object r8 = r7.L$0
                    kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                L30:
                    r1 = r7
                L31:
                    kotlin.coroutines.CoroutineContext r4 = r1.get$context()
                    boolean r4 = kotlinx.coroutines.JobKt.isActive(r4)
                    if (r4 == 0) goto L5e
                    r4 = r1
                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                    r1.L$0 = r8
                    r1.label = r3
                    java.lang.String r5 = "1"
                    java.lang.Object r4 = r8.emit(r5, r4)
                    if (r4 != r0) goto L4b
                    return r0
                L4b:
                    int r4 = r1.$seconds
                    int r4 = r4 * 1000
                    long r4 = (long) r4
                    r6 = r1
                    kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                    r1.L$0 = r8
                    r1.label = r2
                    java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r4, r6)
                    if (r4 != r0) goto L31
                    return r0
                L5e:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowM2121catch = FlowKt.m2121catch(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(this.$seconds, null)), Dispatchers.getIO()), new C01792(this.this$0, null));
                final ExamArrangementViewModel examArrangementViewModel = this.this$0;
                this.label = 1;
                if (flowM2121catch.collect(new FlowCollector() { // from class: com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel.startTimer.2.3
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((String) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(String str, Continuation<? super Unit> continuation) {
                        Object objEmit = examArrangementViewModel.getTimeSharedFlow().emit(str, continuation);
                        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$startTimer$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ExamArrangementViewModel.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$startTimer$2$2", f = "ExamArrangementViewModel.kt", i = {0}, l = {76}, m = "invokeSuspend", n = {"$this$catch"}, s = {"L$0"})
        static final class C01792 extends SuspendLambda implements Function3<FlowCollector<? super String>, Throwable, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ExamArrangementViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01792(ExamArrangementViewModel examArrangementViewModel, Continuation<? super C01792> continuation) {
                super(3, continuation);
                this.this$0 = examArrangementViewModel;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super String> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                C01792 c01792 = new C01792(this.this$0, continuation);
                c01792.L$0 = flowCollector;
                return c01792.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                FlowCollector flowCollector;
                FlowCollector flowCollector2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    flowCollector = (FlowCollector) this.L$0;
                    Job job = this.this$0.timerFlow;
                    if (job != null) {
                        this.L$0 = flowCollector;
                        this.label = 1;
                        if (JobKt.cancelAndJoin(job, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowCollector2 = flowCollector;
                    }
                    AppExtKt.logd(flowCollector, "ExamArrangementViewModel 定时器出错");
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                flowCollector = flowCollector2;
                AppExtKt.logd(flowCollector, "ExamArrangementViewModel 定时器出错");
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$getHomeExamListData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExamArrangementViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$getHomeExamListData$1", f = "ExamArrangementViewModel.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
    static final class C04671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C04671(Continuation<? super C04671> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ExamArrangementViewModel.this.new C04671(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM508getTodayExamgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                map.put(TUIKitConstants.Selection.LIMIT, Boxing.boxInt(10));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                this.label = 1;
                objM508getTodayExamgIAlus = ExamManageNetwork.INSTANCE.m508getTodayExamgIAlus(requestBodyCreate, this);
                if (objM508getTodayExamgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM508getTodayExamgIAlus = ((Result) obj).getValue();
            }
            if (Result.m598isSuccessimpl(objM508getTodayExamgIAlus)) {
                MutableLiveData mutableLiveData = ExamArrangementViewModel.this.homeExamListLiveData;
                if (Result.m597isFailureimpl(objM508getTodayExamgIAlus)) {
                    objM508getTodayExamgIAlus = null;
                }
                List listEmptyList = (List) objM508getTodayExamgIAlus;
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                mutableLiveData.setValue(listEmptyList);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getHomeExamListData() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04671(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$getTodayExam$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExamArrangementViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$getTodayExam$1", f = "ExamArrangementViewModel.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
    static final class C04681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C04681(Continuation<? super C04681> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ExamArrangementViewModel.this.new C04681(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM508getTodayExamgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("examStartTime", DateUtils.getTodayStr("") + " 00:00:00");
                map2.put("examEndTime", DateUtils.getTodayStr("") + " 23:59:59");
                map2.put(TUIKitConstants.Selection.LIMIT, Boxing.boxInt(10));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = ExamArrangementViewModel.this.todayExamLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM508getTodayExamgIAlus = ExamManageNetwork.INSTANCE.m508getTodayExamgIAlus(requestBodyCreate, this);
                if (objM508getTodayExamgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM508getTodayExamgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM508getTodayExamgIAlus));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: getTodayExam, reason: collision with other method in class */
    public final void m338getTodayExam() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04681(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$getBannerExamList$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExamArrangementViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$getBannerExamList$1", f = "ExamArrangementViewModel.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ExamArrangementViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM508getTodayExamgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = ExamArrangementViewModel.this.bannerExamLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM508getTodayExamgIAlus = ExamManageNetwork.INSTANCE.m508getTodayExamgIAlus(requestBodyCreate, this);
                if (objM508getTodayExamgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM508getTodayExamgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM508getTodayExamgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getBannerExamList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$getWeekExam$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExamArrangementViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$getWeekExam$1", f = "ExamArrangementViewModel.kt", i = {}, l = {133}, m = "invokeSuspend", n = {}, s = {})
    static final class C04691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C04691(Continuation<? super C04691> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ExamArrangementViewModel.this.new C04691(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM510getWeekExamgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = ExamArrangementViewModel.this.weekExamLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM510getWeekExamgIAlus = ExamManageNetwork.INSTANCE.m510getWeekExamgIAlus(requestBodyCreate, this);
                if (objM510getWeekExamgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM510getWeekExamgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM510getWeekExamgIAlus));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: getWeekExam, reason: collision with other method in class */
    public final void m339getWeekExam() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04691(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$getExamDetail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExamArrangementViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$getExamDetail$1", f = "ExamArrangementViewModel.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
    static final class C04651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $examinationId;
        final /* synthetic */ String $siteId;
        final /* synthetic */ String $subjectId;
        Object L$0;
        int label;
        final /* synthetic */ ExamArrangementViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04651(String str, String str2, String str3, ExamArrangementViewModel examArrangementViewModel, Continuation<? super C04651> continuation) {
            super(2, continuation);
            this.$siteId = str;
            this.$subjectId = str2;
            this.$examinationId = str3;
            this.this$0 = examArrangementViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04651(this.$siteId, this.$subjectId, this.$examinationId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM506getExamDetailgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("siteId", this.$siteId);
                map2.put("subjectId", this.$subjectId);
                map2.put("examinationId", this.$examinationId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.examDetailLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM506getExamDetailgIAlus = ExamManageNetwork.INSTANCE.m506getExamDetailgIAlus(requestBodyCreate, this);
                if (objM506getExamDetailgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM506getExamDetailgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM506getExamDetailgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getExamDetail(String siteId, String subjectId, String examinationId) {
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(examinationId, "examinationId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04651(siteId, subjectId, examinationId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$getExamSeat$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExamArrangementViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$getExamSeat$1", f = "ExamArrangementViewModel.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
    static final class C04661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $examinationId;
        final /* synthetic */ String $siteId;
        final /* synthetic */ String $subjectId;
        Object L$0;
        int label;
        final /* synthetic */ ExamArrangementViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04661(String str, String str2, String str3, ExamArrangementViewModel examArrangementViewModel, Continuation<? super C04661> continuation) {
            super(2, continuation);
            this.$siteId = str;
            this.$subjectId = str2;
            this.$examinationId = str3;
            this.this$0 = examArrangementViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04661(this.$siteId, this.$subjectId, this.$examinationId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM507getExamSeatgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("siteId", this.$siteId);
                map2.put("subjectId", this.$subjectId);
                map2.put("examinationId", this.$examinationId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.seatInExamLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM507getExamSeatgIAlus = ExamManageNetwork.INSTANCE.m507getExamSeatgIAlus(requestBodyCreate, this);
                if (objM507getExamSeatgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM507getExamSeatgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM507getExamSeatgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getExamSeat(String siteId, String subjectId, String examinationId) {
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(examinationId, "examinationId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04661(siteId, subjectId, examinationId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$signInExam$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExamArrangementViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$signInExam$1", f = "ExamArrangementViewModel.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
    static final class C04711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $examinationId;
        final /* synthetic */ String $siteId;
        final /* synthetic */ String $studentId;
        final /* synthetic */ String $subjectId;
        Object L$0;
        int label;
        final /* synthetic */ ExamArrangementViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04711(String str, String str2, String str3, String str4, ExamArrangementViewModel examArrangementViewModel, Continuation<? super C04711> continuation) {
            super(2, continuation);
            this.$studentId = str;
            this.$siteId = str2;
            this.$subjectId = str3;
            this.$examinationId = str4;
            this.this$0 = examArrangementViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04711(this.$studentId, this.$siteId, this.$subjectId, this.$examinationId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM512signInExamgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put(CommentsHomeFragment.TYPE_ID, this.$studentId);
                map2.put("siteId", this.$siteId);
                map2.put("subjectId", this.$subjectId);
                map2.put("examinationId", this.$examinationId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.signInExamLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM512signInExamgIAlus = ExamManageNetwork.INSTANCE.m512signInExamgIAlus(requestBodyCreate, this);
                if (objM512signInExamgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM512signInExamgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM512signInExamgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void signInExam(String studentId, String siteId, String subjectId, String examinationId) {
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(examinationId, "examinationId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04711(studentId, siteId, subjectId, examinationId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$onCleared$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExamArrangementViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel$onCleared$1", f = "ExamArrangementViewModel.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
    static final class C04701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C04701(Continuation<? super C04701> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04701 c04701 = ExamArrangementViewModel.this.new C04701(continuation);
            c04701.L$0 = obj;
            return c04701;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AppExtKt.logd((CoroutineScope) this.L$0, "clear timer");
                Job job = ExamArrangementViewModel.this.timerFlow;
                if (job != null) {
                    this.label = 1;
                    if (JobKt.cancelAndJoin(job, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ExamArrangementViewModel.this.timerFlow = null;
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04701(null), 3, null);
    }
}
