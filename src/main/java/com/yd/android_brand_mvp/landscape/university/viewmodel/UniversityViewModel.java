package com.yd.android_brand_mvp.landscape.university.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.yd.android_brand_mvp.adapter.attence.RuleUtils;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.db.reservation.ReservationSignBean;
import com.yd.android_brand_mvp.model.AttenceNewListBean;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.TableDataBean;
import com.yd.android_brand_mvp.model.reservation.ReservationDetailBean;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import com.yd.android_brand_mvp.network.reservation.ReservationNetwork;
import com.yd.android_brand_mvp.repository.ReservationDaoRepository;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yyide.facepass.AppExtKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: UniversityViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010%\u001a\u00020&J\u000e\u0010\u0013\u001a\u00020&2\u0006\u0010'\u001a\u00020 J\u0010\u0010(\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010 J\u001e\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020 J\u000e\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020 J\u0016\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020 2\u0006\u0010+\u001a\u00020 J\u0019\u00102\u001a\u00020&2\u0006\u00103\u001a\u000204H\u0086@ø\u0001\u0000¢\u0006\u0002\u00105R&\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00050\u000bø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000eR\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00050\u0010X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/viewmodel/UniversityViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "attendanceResultList", "Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "Lkotlin/Result;", "", "Lcom/yd/android_brand_mvp/model/AttenceNewListBean$DataDTO;", "getAttendanceResultList", "()Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "kbRspData", "Landroidx/lifecycle/LiveData;", "Lcom/yd/android_brand_mvp/model/TableDataBean;", "getKbRspData", "()Landroidx/lifecycle/LiveData;", "kbRspLiveData", "Landroidx/lifecycle/MutableLiveData;", "reservationDetail", "Lcom/yd/android_brand_mvp/model/reservation/ReservationDetailBean;", "getReservationDetail", "reservationDetailLiveData", "reservationList", "", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "getReservationList", "reservationListLiveData", "signInResult", "", "getSignInResult", "signInResultLiveData", "timeSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "getTimeSharedFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "timerFlow", "Lkotlinx/coroutines/Job;", "getKbData", "", "id", "getTodayReservationList", "siteId", "insertReservationSignDataToDao", "bookId", "userId", "time", "requestActivityCycle", "tableId", "signInRecord", "user", "startTimer", "millSeconds", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UniversityViewModel extends ViewModel {
    private final SingleLiveEvent<Result<List<AttenceNewListBean.DataDTO>>> attendanceResultList = new SingleLiveEvent<>();
    private final LiveData<TableDataBean> kbRspData;
    private final MutableLiveData<TableDataBean> kbRspLiveData;
    private final LiveData<ReservationDetailBean> reservationDetail;
    private final MutableLiveData<ReservationDetailBean> reservationDetailLiveData;
    private final LiveData<List<ReservationRecordBean>> reservationList;
    private final MutableLiveData<List<ReservationRecordBean>> reservationListLiveData;
    private final LiveData<Result<Boolean>> signInResult;
    private final MutableLiveData<Result<Boolean>> signInResultLiveData;
    private final MutableSharedFlow<String> timeSharedFlow;
    private Job timerFlow;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$startTimer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UniversityViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel", f = "UniversityViewModel.kt", i = {0, 0}, l = {57}, m = "startTimer", n = {"this", "millSeconds"}, s = {"L$0", "J$0"})
    static final class C05441 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05441(Continuation<? super C05441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UniversityViewModel.this.startTimer(0L, this);
        }
    }

    public UniversityViewModel() {
        MutableLiveData<List<ReservationRecordBean>> mutableLiveData = new MutableLiveData<>();
        this.reservationListLiveData = mutableLiveData;
        this.reservationList = mutableLiveData;
        MutableLiveData<TableDataBean> mutableLiveData2 = new MutableLiveData<>();
        this.kbRspLiveData = mutableLiveData2;
        this.kbRspData = mutableLiveData2;
        MutableLiveData<Result<Boolean>> mutableLiveData3 = new MutableLiveData<>();
        this.signInResultLiveData = mutableLiveData3;
        this.signInResult = mutableLiveData3;
        MutableLiveData<ReservationDetailBean> mutableLiveData4 = new MutableLiveData<>();
        this.reservationDetailLiveData = mutableLiveData4;
        this.reservationDetail = mutableLiveData4;
        this.timeSharedFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public final SingleLiveEvent<Result<List<AttenceNewListBean.DataDTO>>> getAttendanceResultList() {
        return this.attendanceResultList;
    }

    public final LiveData<List<ReservationRecordBean>> getReservationList() {
        return this.reservationList;
    }

    public final LiveData<TableDataBean> getKbRspData() {
        return this.kbRspData;
    }

    public final LiveData<Result<Boolean>> getSignInResult() {
        return this.signInResult;
    }

    public final LiveData<ReservationDetailBean> getReservationDetail() {
        return this.reservationDetail;
    }

    public final MutableSharedFlow<String> getTimeSharedFlow() {
        return this.timeSharedFlow;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object startTimer(long j, Continuation<? super Unit> continuation) {
        C05441 c05441;
        UniversityViewModel universityViewModel;
        if (continuation instanceof C05441) {
            c05441 = (C05441) continuation;
            if ((c05441.label & Integer.MIN_VALUE) != 0) {
                c05441.label -= Integer.MIN_VALUE;
            } else {
                c05441 = new C05441(continuation);
            }
        } else {
            c05441 = new C05441(continuation);
        }
        Object obj = c05441.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05441.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.timerFlow != null) {
                AppExtKt.logd(this, "重置timerFlow");
                Job job = this.timerFlow;
                if (job != null) {
                    c05441.L$0 = this;
                    c05441.J$0 = j;
                    c05441.label = 1;
                    if (JobKt.cancelAndJoin(job, c05441) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                universityViewModel = this;
            } else {
                universityViewModel = this;
            }
            universityViewModel.timerFlow = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(universityViewModel), null, null, new AnonymousClass2(j, universityViewModel, null), 3, null);
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j = c05441.J$0;
        universityViewModel = (UniversityViewModel) c05441.L$0;
        ResultKt.throwOnFailure(obj);
        universityViewModel.timerFlow = null;
        universityViewModel.timerFlow = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(universityViewModel), null, null, new AnonymousClass2(j, universityViewModel, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$startTimer$2, reason: invalid class name */
    /* JADX INFO: compiled from: UniversityViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$startTimer$2", f = "UniversityViewModel.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $millSeconds;
        int label;
        final /* synthetic */ UniversityViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(long j, UniversityViewModel universityViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$millSeconds = j;
            this.this$0 = universityViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$millSeconds, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$startTimer$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: UniversityViewModel.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$startTimer$2$1", f = "UniversityViewModel.kt", i = {0}, l = {62, 63}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super String>, Continuation<? super Unit>, Object> {
            final /* synthetic */ long $millSeconds;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(long j, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$millSeconds = j;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$millSeconds, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(FlowCollector<? super String> flowCollector, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                FlowCollector flowCollector;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    flowCollector = (FlowCollector) this.L$0;
                    this.L$0 = flowCollector;
                    this.label = 1;
                    if (DelayKt.delay(this.$millSeconds, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i == 1) {
                        flowCollector = (FlowCollector) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                this.L$0 = null;
                this.label = 2;
                if (flowCollector.emit("1", this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowM2121catch = FlowKt.m2121catch(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(this.$millSeconds, null)), Dispatchers.getIO()), new C01872(this.this$0, null));
                final UniversityViewModel universityViewModel = this.this$0;
                this.label = 1;
                if (flowM2121catch.collect(new FlowCollector() { // from class: com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel.startTimer.2.3
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((String) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(String str, Continuation<? super Unit> continuation) {
                        Object objEmit = universityViewModel.getTimeSharedFlow().emit(str, continuation);
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

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$startTimer$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: UniversityViewModel.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$startTimer$2$2", f = "UniversityViewModel.kt", i = {0}, l = {66}, m = "invokeSuspend", n = {"$this$catch"}, s = {"L$0"})
        static final class C01872 extends SuspendLambda implements Function3<FlowCollector<? super String>, Throwable, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ UniversityViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01872(UniversityViewModel universityViewModel, Continuation<? super C01872> continuation) {
                super(3, continuation);
                this.this$0 = universityViewModel;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super String> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                C01872 c01872 = new C01872(this.this$0, continuation);
                c01872.L$0 = flowCollector;
                return c01872.invokeSuspend(Unit.INSTANCE);
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
                    AppExtKt.logd(flowCollector, "倒计时出错");
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                flowCollector = flowCollector2;
                AppExtKt.logd(flowCollector, "倒计时出错");
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$requestActivityCycle$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UniversityViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$requestActivityCycle$1", f = "UniversityViewModel.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
    static final class C05421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $tableId;
        Object L$0;
        int label;
        final /* synthetic */ UniversityViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05421(String str, UniversityViewModel universityViewModel, Continuation<? super C05421> continuation) {
            super(2, continuation);
            this.$tableId = str;
            this.this$0 = universityViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05421(this.$tableId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM446requestAttendancegIAlus;
            SingleLiveEvent<Result<List<AttenceNewListBean.DataDTO>>> singleLiveEvent;
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
                SingleLiveEvent<Result<List<AttenceNewListBean.DataDTO>>> attendanceResultList = this.this$0.getAttendanceResultList();
                this.L$0 = attendanceResultList;
                this.label = 1;
                objM446requestAttendancegIAlus = NetworkApi.INSTANCE.m446requestAttendancegIAlus(requestBodyCreate, this);
                if (objM446requestAttendancegIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = attendanceResultList;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                singleLiveEvent = (SingleLiveEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM446requestAttendancegIAlus = ((Result) obj).getValue();
            }
            singleLiveEvent.setValue(Result.m590boximpl(objM446requestAttendancegIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void requestActivityCycle(String tableId) {
        Intrinsics.checkNotNullParameter(tableId, "tableId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05421(tableId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$getTodayReservationList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UniversityViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$getTodayReservationList$1", f = "UniversityViewModel.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
    static final class C05401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $siteId;
        int label;
        final /* synthetic */ UniversityViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05401(String str, UniversityViewModel universityViewModel, Continuation<? super C05401> continuation) {
            super(2, continuation);
            this.$siteId = str;
            this.this$0 = universityViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05401(this.$siteId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM529getReservationRecordListgIAlus;
            List arrayList;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("pageNo", Boxing.boxInt(1));
                map2.put("pageSize", Boxing.boxInt(100));
                String todayStr = DateUtils.getTodayStr("");
                Intrinsics.checkNotNullExpressionValue(todayStr, "getTodayStr(\"\")");
                map2.put("startTime", todayStr);
                String todayStr2 = DateUtils.getTodayStr("");
                Intrinsics.checkNotNullExpressionValue(todayStr2, "getTodayStr(\"\")");
                map2.put("endTime", todayStr2);
                map2.put("siteId", this.$siteId);
                map2.put("status", Boxing.boxInt(2));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                this.label = 1;
                objM529getReservationRecordListgIAlus = ReservationNetwork.INSTANCE.m529getReservationRecordListgIAlus(requestBodyCreate, this);
                if (objM529getReservationRecordListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM529getReservationRecordListgIAlus = ((Result) obj).getValue();
            }
            if (Result.m598isSuccessimpl(objM529getReservationRecordListgIAlus)) {
                if (Result.m597isFailureimpl(objM529getReservationRecordListgIAlus)) {
                    objM529getReservationRecordListgIAlus = null;
                }
                BasePageResponse basePageResponse = (BasePageResponse) objM529getReservationRecordListgIAlus;
                if (basePageResponse == null) {
                    return Unit.INSTANCE;
                }
                List list = (List) basePageResponse.getList();
                if (list == null || (arrayList = CollectionsKt.sortedWith(list, new Comparator() { // from class: com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$getTodayReservationList$1$invokeSuspend$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((ReservationRecordBean) t).getStartTimeStr(), ((ReservationRecordBean) t2).getStartTimeStr());
                    }
                })) == null) {
                    arrayList = new ArrayList();
                }
                this.this$0.reservationListLiveData.setValue(arrayList);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getTodayReservationList(String siteId) {
        if (siteId == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05401(siteId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$getKbData$1, reason: invalid class name */
    /* JADX INFO: compiled from: UniversityViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$getKbData$1", f = "UniversityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UniversityViewModel.this.new AnonymousClass1(continuation);
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
            TableDataBean tableDataBean = new TableDataBean(0, null, 3, null);
            KBRsp2 siteKBData = SpData.getSiteKBData();
            if (siteKBData == null && (siteKBData = SpData.KBData()) != null) {
                tableDataBean.setType(2);
            }
            if (siteKBData != null) {
                tableDataBean.setData(siteKBData);
                UniversityViewModel.this.kbRspLiveData.postValue(tableDataBean);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getKbData() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$insertReservationSignDataToDao$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UniversityViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$insertReservationSignDataToDao$1", f = "UniversityViewModel.kt", i = {0}, l = {131, 139}, m = "invokeSuspend", n = {"daoSignData"}, s = {"L$0"})
    static final class C05411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $bookId;
        final /* synthetic */ String $time;
        final /* synthetic */ String $userId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05411(String str, String str2, String str3, Continuation<? super C05411> continuation) {
            super(2, continuation);
            this.$userId = str;
            this.$time = str2;
            this.$bookId = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05411(this.$userId, this.$time, this.$bookId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ReservationSignBean reservationSignBean;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                reservationSignBean = new ReservationSignBean(this.$userId, this.$time, this.$bookId);
                this.L$0 = reservationSignBean;
                this.label = 1;
                obj = ReservationDaoRepository.INSTANCE.getUserIdSignData(this.$userId, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i == 1) {
                    reservationSignBean = (ReservationSignBean) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            List list = (List) obj;
            if (true ^ list.isEmpty()) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    if (Intrinsics.areEqual(((ReservationSignBean) it2.next()).getSiteBookingId(), this.$bookId)) {
                        return Unit.INSTANCE;
                    }
                }
            }
            this.L$0 = null;
            this.label = 2;
            if (ReservationDaoRepository.INSTANCE.addSignData(reservationSignBean, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    public final void insertReservationSignDataToDao(String bookId, String userId, String time) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(time, "time");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C05411(userId, time, bookId, null), 2, null);
    }

    public final void getReservationDetail(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        if (id.length() == 0) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05391(id, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$getReservationDetail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UniversityViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$getReservationDetail$1", f = "UniversityViewModel.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
    static final class C05391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        int label;
        final /* synthetic */ UniversityViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05391(String str, UniversityViewModel universityViewModel, Continuation<? super C05391> continuation) {
            super(2, continuation);
            this.$id = str;
            this.this$0 = universityViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05391(this.$id, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM528getReservationDetailgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                objM528getReservationDetailgIAlus = ReservationNetwork.INSTANCE.m528getReservationDetailgIAlus(this.$id, this);
                if (objM528getReservationDetailgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM528getReservationDetailgIAlus = ((Result) obj).getValue();
            }
            if (Result.m598isSuccessimpl(objM528getReservationDetailgIAlus)) {
                MutableLiveData mutableLiveData = this.this$0.reservationDetailLiveData;
                if (Result.m597isFailureimpl(objM528getReservationDetailgIAlus)) {
                    objM528getReservationDetailgIAlus = null;
                }
                mutableLiveData.setValue(objM528getReservationDetailgIAlus);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$signInRecord$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UniversityViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel$signInRecord$1", f = "UniversityViewModel.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
    static final class C05431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $bookId;
        final /* synthetic */ String $user;
        int label;
        final /* synthetic */ UniversityViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05431(String str, String str2, UniversityViewModel universityViewModel, Continuation<? super C05431> continuation) {
            super(2, continuation);
            this.$bookId = str;
            this.$user = str2;
            this.this$0 = universityViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05431(this.$bookId, this.$user, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM531signInReservationgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("siteBookingId", this.$bookId);
                map2.put("userId", this.$user);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                this.label = 1;
                objM531signInReservationgIAlus = ReservationNetwork.INSTANCE.m531signInReservationgIAlus(requestBodyCreate, this);
                if (objM531signInReservationgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM531signInReservationgIAlus = ((Result) obj).getValue();
            }
            if (Result.m598isSuccessimpl(objM531signInReservationgIAlus)) {
                this.this$0.signInResultLiveData.setValue(Result.m590boximpl(objM531signInReservationgIAlus));
            }
            return Unit.INSTANCE;
        }
    }

    public final void signInRecord(String user, String bookId) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05431(bookId, user, this, null), 3, null);
    }
}
