package com.yd.android_brand_mvp.landscape.chemistry.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.yd.android_brand_mvp.adapter.attence.RuleUtils;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.AttenceNewListBean;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.SiteInfoBean;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yyide.facepass.AppExtKt;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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

/* JADX INFO: compiled from: HomeChemistryViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u001b\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u000e\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016J\u000e\u0010\u0012\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0016J\b\u0010#\u001a\u00020\u001cH\u0014J\u000e\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u0016J\u0019\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010(R&\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u000bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u000bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u000bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/chemistry/viewmodel/HomeChemistryViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "attendanceResultList", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "", "Lcom/yd/android_brand_mvp/model/AttenceNewListBean$DataDTO;", "getAttendanceResultList", "()Landroidx/lifecycle/LiveData;", "attendanceResultListLiveData", "Landroidx/lifecycle/MutableLiveData;", "courseList", "Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO;", "getCourseList", "courseListLiveData", "siteInfo", "Lcom/yd/android_brand_mvp/model/SiteInfoBean;", "getSiteInfo", "siteInfoLiveData", "timeSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "getTimeSharedFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "timerFlow", "Lkotlinx/coroutines/Job;", "cancelTimer", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "typeId", "weekTime", "", "type", "id", "onCleared", "requestActivityCycle", "tableId", "startTimer", "seconds", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomeChemistryViewModel extends ViewModel {
    private final LiveData<Result<List<AttenceNewListBean.DataDTO>>> attendanceResultList;
    private final MutableLiveData<Result<List<AttenceNewListBean.DataDTO>>> attendanceResultListLiveData;
    private final LiveData<Result<KBRsp2.DataDTO>> courseList;
    private final MutableLiveData<Result<KBRsp2.DataDTO>> courseListLiveData;
    private final LiveData<Result<SiteInfoBean>> siteInfo;
    private final MutableLiveData<Result<SiteInfoBean>> siteInfoLiveData;
    private final MutableSharedFlow<String> timeSharedFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    private Job timerFlow;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel$cancelTimer$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomeChemistryViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel", f = "HomeChemistryViewModel.kt", i = {0}, l = {70}, m = "cancelTimer", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomeChemistryViewModel.this.cancelTimer(this);
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel$startTimer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeChemistryViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel", f = "HomeChemistryViewModel.kt", i = {0, 0}, l = {51}, m = "startTimer", n = {"this", "seconds"}, s = {"L$0", "I$0"})
    static final class C04161 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04161(Continuation<? super C04161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomeChemistryViewModel.this.startTimer(0, this);
        }
    }

    public HomeChemistryViewModel() {
        MutableLiveData<Result<KBRsp2.DataDTO>> mutableLiveData = new MutableLiveData<>();
        this.courseListLiveData = mutableLiveData;
        this.courseList = mutableLiveData;
        MutableLiveData<Result<SiteInfoBean>> mutableLiveData2 = new MutableLiveData<>();
        this.siteInfoLiveData = mutableLiveData2;
        this.siteInfo = mutableLiveData2;
        MutableLiveData<Result<List<AttenceNewListBean.DataDTO>>> mutableLiveData3 = new MutableLiveData<>();
        this.attendanceResultListLiveData = mutableLiveData3;
        this.attendanceResultList = mutableLiveData3;
    }

    public final MutableSharedFlow<String> getTimeSharedFlow() {
        return this.timeSharedFlow;
    }

    public final LiveData<Result<KBRsp2.DataDTO>> getCourseList() {
        return this.courseList;
    }

    public final LiveData<Result<SiteInfoBean>> getSiteInfo() {
        return this.siteInfo;
    }

    public final LiveData<Result<List<AttenceNewListBean.DataDTO>>> getAttendanceResultList() {
        return this.attendanceResultList;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object startTimer(int i, Continuation<? super Unit> continuation) {
        C04161 c04161;
        HomeChemistryViewModel homeChemistryViewModel;
        if (continuation instanceof C04161) {
            c04161 = (C04161) continuation;
            if ((c04161.label & Integer.MIN_VALUE) != 0) {
                c04161.label -= Integer.MIN_VALUE;
            } else {
                c04161 = new C04161(continuation);
            }
        } else {
            c04161 = new C04161(continuation);
        }
        Object obj = c04161.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c04161.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c04161.L$0 = this;
            c04161.I$0 = i;
            c04161.label = 1;
            if (cancelTimer(c04161) == coroutine_suspended) {
                return coroutine_suspended;
            }
            homeChemistryViewModel = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = c04161.I$0;
            homeChemistryViewModel = (HomeChemistryViewModel) c04161.L$0;
            ResultKt.throwOnFailure(obj);
        }
        homeChemistryViewModel.timerFlow = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(homeChemistryViewModel), null, null, new AnonymousClass2(i, homeChemistryViewModel, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel$startTimer$2, reason: invalid class name */
    /* JADX INFO: compiled from: HomeChemistryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel$startTimer$2", f = "HomeChemistryViewModel.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $seconds;
        int label;
        final /* synthetic */ HomeChemistryViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i, HomeChemistryViewModel homeChemistryViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$seconds = i;
            this.this$0 = homeChemistryViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$seconds, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel$startTimer$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: HomeChemistryViewModel.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel$startTimer$2$1", f = "HomeChemistryViewModel.kt", i = {0, 1}, l = {55, 56}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
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
                throw new UnsupportedOperationException("Method not decompiled: com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowM2121catch = FlowKt.m2121catch(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(this.$seconds, null)), Dispatchers.getIO()), new C01722(this.this$0, null));
                final HomeChemistryViewModel homeChemistryViewModel = this.this$0;
                this.label = 1;
                if (flowM2121catch.collect(new FlowCollector() { // from class: com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel.startTimer.2.3
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((String) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(String str, Continuation<? super Unit> continuation) {
                        Object objEmit = homeChemistryViewModel.getTimeSharedFlow().emit(str, continuation);
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

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel$startTimer$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: HomeChemistryViewModel.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel$startTimer$2$2", f = "HomeChemistryViewModel.kt", i = {0}, l = {60}, m = "invokeSuspend", n = {"$this$catch"}, s = {"L$0"})
        static final class C01722 extends SuspendLambda implements Function3<FlowCollector<? super String>, Throwable, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ HomeChemistryViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01722(HomeChemistryViewModel homeChemistryViewModel, Continuation<? super C01722> continuation) {
                super(3, continuation);
                this.this$0 = homeChemistryViewModel;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super String> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                C01722 c01722 = new C01722(this.this$0, continuation);
                c01722.L$0 = flowCollector;
                return c01722.invokeSuspend(Unit.INSTANCE);
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
                    AppExtKt.logd(flowCollector, "HomeChemistryViewModel 定时器出错");
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                flowCollector = flowCollector2;
                AppExtKt.logd(flowCollector, "HomeChemistryViewModel 定时器出错");
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object cancelTimer(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        HomeChemistryViewModel homeChemistryViewModel;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Job job = this.timerFlow;
            if (job != null) {
                if (job != null) {
                    anonymousClass1.L$0 = this;
                    anonymousClass1.label = 1;
                    if (JobKt.cancelAndJoin(job, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                homeChemistryViewModel = this;
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        homeChemistryViewModel = (HomeChemistryViewModel) anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj);
        homeChemistryViewModel.timerFlow = null;
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel$getSiteInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeChemistryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel$getSiteInfo$1", f = "HomeChemistryViewModel.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    static final class C04131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04131(String str, Continuation<? super C04131> continuation) {
            super(2, continuation);
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeChemistryViewModel.this.new C04131(this.$id, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData2 = HomeChemistryViewModel.this.siteInfoLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objM467requestSiteInfogIAlus = NetworkApi.INSTANCE.m467requestSiteInfogIAlus(this.$id, this);
                if (objM467requestSiteInfogIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                value = objM467requestSiteInfogIAlus;
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

    public final void getSiteInfo(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04131(id, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel$getCourseList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeChemistryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel$getCourseList$1", f = "HomeChemistryViewModel.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
    static final class C04121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $type;
        final /* synthetic */ String $typeId;
        final /* synthetic */ int $weekTime;
        Object L$0;
        int label;
        final /* synthetic */ HomeChemistryViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04121(int i, String str, String str2, HomeChemistryViewModel homeChemistryViewModel, Continuation<? super C04121> continuation) {
            super(2, continuation);
            this.$weekTime = i;
            this.$type = str;
            this.$typeId = str2;
            this.this$0 = homeChemistryViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04121(this.$weekTime, this.$type, this.$typeId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM425getCourseListDatagIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                int i2 = this.$weekTime;
                String strValueOf = i2 == -1 ? "" : String.valueOf(i2);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("type", this.$type);
                map2.put("typeId", this.$typeId);
                map2.put("weekTime", strValueOf);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.courseListLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM425getCourseListDatagIAlus = NetworkApi.INSTANCE.m425getCourseListDatagIAlus(requestBodyCreate, this);
                if (objM425getCourseListDatagIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM425getCourseListDatagIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM425getCourseListDatagIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getCourseList(String typeId, int weekTime, String type) {
        Intrinsics.checkNotNullParameter(typeId, "typeId");
        Intrinsics.checkNotNullParameter(type, "type");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04121(weekTime, type, typeId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel$requestActivityCycle$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeChemistryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel$requestActivityCycle$1", f = "HomeChemistryViewModel.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
    static final class C04151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $tableId;
        Object L$0;
        int label;
        final /* synthetic */ HomeChemistryViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04151(String str, HomeChemistryViewModel homeChemistryViewModel, Continuation<? super C04151> continuation) {
            super(2, continuation);
            this.$tableId = str;
            this.this$0 = homeChemistryViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04151(this.$tableId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM446requestAttendancegIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                List<String> attendanceIds = RuleUtils.getInstance().getAttendanceIds();
                if (attendanceIds != null) {
                    map.put("attendanceTimeIds", attendanceIds);
                }
                if (!TextUtils.isEmpty(this.$tableId)) {
                    map.put("siteTimetableId", this.$tableId);
                }
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(map);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.attendanceResultListLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM446requestAttendancegIAlus = NetworkApi.INSTANCE.m446requestAttendancegIAlus(requestBodyCreate, this);
                if (objM446requestAttendancegIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM446requestAttendancegIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM446requestAttendancegIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void requestActivityCycle(String tableId) {
        Intrinsics.checkNotNullParameter(tableId, "tableId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04151(tableId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel$onCleared$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeChemistryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel$onCleared$1", f = "HomeChemistryViewModel.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
    static final class C04141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C04141(Continuation<? super C04141> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeChemistryViewModel.this.new C04141(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (HomeChemistryViewModel.this.cancelTimer(this) == coroutine_suspended) {
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
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04141(null), 3, null);
    }
}
