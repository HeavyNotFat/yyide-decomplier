package com.yd.android_brand_mvp.landscape.reserve.viemodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.db.reservation.ReservationSignBean;
import com.yd.android_brand_mvp.model.consult.ConsultTeacherBean;
import com.yd.android_brand_mvp.model.reservation.ReservationDetailBean;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.reservation.ReservationNetwork;
import com.yd.android_brand_mvp.repository.ReservationDaoRepository;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yyide.facepass.AppExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
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

/* JADX INFO: compiled from: HomeReservationViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020!J\u0006\u0010\u000e\u001a\u00020'J\u0014\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150\fJ\u0014\u0010,\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150\fJ\u000e\u0010\u0011\u001a\u00020'2\u0006\u0010(\u001a\u00020!J\u001a\u0010\u0016\u001a\u00020'2\b\b\u0002\u0010-\u001a\u00020*2\b\b\u0002\u0010.\u001a\u00020*J\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150\fJ\u000e\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020!J\u001e\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020!2\u0006\u00104\u001a\u00020!J\b\u00105\u001a\u00020'H\u0014J\u0016\u00106\u001a\u00020'2\u0006\u00107\u001a\u00020!2\u0006\u00102\u001a\u00020!J\u0019\u00108\u001a\u00020'2\u0006\u00109\u001a\u00020:H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010;R \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R#\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\f0\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\f0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\nX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0013\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\u00140\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR,\u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\u00140\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR)\u0010\u0019\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\u00140\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R)\u0010\u001a\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\u00140\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\bR\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 ¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006<"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/reserve/viemodel/HomeReservationViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "consultDetails", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/consult/ConsultTeacherBean;", "getConsultDetails", "()Landroidx/lifecycle/LiveData;", "consultDetailsLiveData", "Landroidx/lifecycle/MutableLiveData;", "consultListLiveData", "", "consultTeacherList", "getConsultTeacherList", "reservationDetail", "Lcom/yd/android_brand_mvp/model/reservation/ReservationDetailBean;", "getReservationDetail", "reservationDetailLiveData", "reservationList", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "getReservationList", "reservationListAll", "getReservationListAll", "reservationListAllLiveData", "reservationListLiveData", "signInResult", "", "getSignInResult", "signInResultLiveData", "timeSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "getTimeSharedFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "timerFlow", "Lkotlinx/coroutines/Job;", "getConsultTeacherDetails", "", "id", "getHighLightIndex", "", TUIKitConstants.Selection.LIST, "getNextHighLightIndex", "pageNo", "pageSize", "getTodayReservationList", "siteId", "insertReservationSignDataToDao", "bookId", "userId", "time", "onCleared", "signInRecord", "user", "startTimer", "millSeconds", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomeReservationViewModel extends ViewModel {
    private final LiveData<Result<ConsultTeacherBean>> consultDetails;
    private final MutableLiveData<Result<ConsultTeacherBean>> consultDetailsLiveData;
    private final MutableLiveData<Result<List<ConsultTeacherBean>>> consultListLiveData;
    private final LiveData<Result<List<ConsultTeacherBean>>> consultTeacherList;
    private final LiveData<ReservationDetailBean> reservationDetail;
    private final MutableLiveData<ReservationDetailBean> reservationDetailLiveData;
    private final LiveData<Result<BasePageResponse<List<ReservationRecordBean>>>> reservationList;
    private final LiveData<Result<BasePageResponse<List<ReservationRecordBean>>>> reservationListAll;
    private final MutableLiveData<Result<BasePageResponse<List<ReservationRecordBean>>>> reservationListAllLiveData;
    private final MutableLiveData<Result<BasePageResponse<List<ReservationRecordBean>>>> reservationListLiveData;
    private final LiveData<Result<Boolean>> signInResult;
    private final MutableLiveData<Result<Boolean>> signInResultLiveData;
    private final MutableSharedFlow<String> timeSharedFlow;
    private Job timerFlow;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$startTimer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeReservationViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel", f = "HomeReservationViewModel.kt", i = {0, 0}, l = {62}, m = "startTimer", n = {"this", "millSeconds"}, s = {"L$0", "J$0"})
    static final class C05151 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05151(Continuation<? super C05151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomeReservationViewModel.this.startTimer(0L, this);
        }
    }

    public HomeReservationViewModel() {
        MutableLiveData<Result<BasePageResponse<List<ReservationRecordBean>>>> mutableLiveData = new MutableLiveData<>();
        this.reservationListLiveData = mutableLiveData;
        this.reservationList = mutableLiveData;
        MutableLiveData<Result<BasePageResponse<List<ReservationRecordBean>>>> mutableLiveData2 = new MutableLiveData<>();
        this.reservationListAllLiveData = mutableLiveData2;
        this.reservationListAll = mutableLiveData2;
        MutableLiveData<Result<Boolean>> mutableLiveData3 = new MutableLiveData<>();
        this.signInResultLiveData = mutableLiveData3;
        this.signInResult = mutableLiveData3;
        MutableLiveData<ReservationDetailBean> mutableLiveData4 = new MutableLiveData<>();
        this.reservationDetailLiveData = mutableLiveData4;
        this.reservationDetail = mutableLiveData4;
        MutableLiveData<Result<List<ConsultTeacherBean>>> mutableLiveData5 = new MutableLiveData<>();
        this.consultListLiveData = mutableLiveData5;
        this.consultTeacherList = mutableLiveData5;
        MutableLiveData<Result<ConsultTeacherBean>> mutableLiveData6 = new MutableLiveData<>();
        this.consultDetailsLiveData = mutableLiveData6;
        this.consultDetails = mutableLiveData6;
        this.timeSharedFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public final LiveData<Result<BasePageResponse<List<ReservationRecordBean>>>> getReservationList() {
        return this.reservationList;
    }

    public final LiveData<Result<BasePageResponse<List<ReservationRecordBean>>>> getReservationListAll() {
        return this.reservationListAll;
    }

    public final LiveData<Result<Boolean>> getSignInResult() {
        return this.signInResult;
    }

    public final LiveData<ReservationDetailBean> getReservationDetail() {
        return this.reservationDetail;
    }

    public final LiveData<Result<List<ConsultTeacherBean>>> getConsultTeacherList() {
        return this.consultTeacherList;
    }

    public final LiveData<Result<ConsultTeacherBean>> getConsultDetails() {
        return this.consultDetails;
    }

    public final MutableSharedFlow<String> getTimeSharedFlow() {
        return this.timeSharedFlow;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object startTimer(long j, Continuation<? super Unit> continuation) {
        C05151 c05151;
        HomeReservationViewModel homeReservationViewModel;
        if (continuation instanceof C05151) {
            c05151 = (C05151) continuation;
            if ((c05151.label & Integer.MIN_VALUE) != 0) {
                c05151.label -= Integer.MIN_VALUE;
            } else {
                c05151 = new C05151(continuation);
            }
        } else {
            c05151 = new C05151(continuation);
        }
        Object obj = c05151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05151.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.timerFlow != null) {
                AppExtKt.logd(this, "重置timerFlow");
                Job job = this.timerFlow;
                if (job != null) {
                    c05151.L$0 = this;
                    c05151.J$0 = j;
                    c05151.label = 1;
                    if (JobKt.cancelAndJoin(job, c05151) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                homeReservationViewModel = this;
            } else {
                homeReservationViewModel = this;
            }
            homeReservationViewModel.timerFlow = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(homeReservationViewModel), null, null, new AnonymousClass2(j, homeReservationViewModel, null), 3, null);
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j = c05151.J$0;
        homeReservationViewModel = (HomeReservationViewModel) c05151.L$0;
        ResultKt.throwOnFailure(obj);
        homeReservationViewModel.timerFlow = null;
        homeReservationViewModel.timerFlow = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(homeReservationViewModel), null, null, new AnonymousClass2(j, homeReservationViewModel, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$startTimer$2, reason: invalid class name */
    /* JADX INFO: compiled from: HomeReservationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$startTimer$2", f = "HomeReservationViewModel.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $millSeconds;
        int label;
        final /* synthetic */ HomeReservationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(long j, HomeReservationViewModel homeReservationViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$millSeconds = j;
            this.this$0 = homeReservationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$millSeconds, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$startTimer$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: HomeReservationViewModel.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$startTimer$2$1", f = "HomeReservationViewModel.kt", i = {0}, l = {67, 68}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
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
                Flow flowM2121catch = FlowKt.m2121catch(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(this.$millSeconds, null)), Dispatchers.getIO()), new C01852(this.this$0, null));
                final HomeReservationViewModel homeReservationViewModel = this.this$0;
                this.label = 1;
                if (flowM2121catch.collect(new FlowCollector() { // from class: com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel.startTimer.2.3
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((String) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(String str, Continuation<? super Unit> continuation) {
                        Object objEmit = homeReservationViewModel.getTimeSharedFlow().emit(str, continuation);
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

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$startTimer$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: HomeReservationViewModel.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$startTimer$2$2", f = "HomeReservationViewModel.kt", i = {0}, l = {70}, m = "invokeSuspend", n = {"$this$catch"}, s = {"L$0"})
        static final class C01852 extends SuspendLambda implements Function3<FlowCollector<? super String>, Throwable, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ HomeReservationViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01852(HomeReservationViewModel homeReservationViewModel, Continuation<? super C01852> continuation) {
                super(3, continuation);
                this.this$0 = homeReservationViewModel;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super String> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                C01852 c01852 = new C01852(this.this$0, continuation);
                c01852.L$0 = flowCollector;
                return c01852.invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$getTodayReservationList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeReservationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$getTodayReservationList$1", f = "HomeReservationViewModel.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    static final class C05111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $siteId;
        Object L$0;
        int label;
        final /* synthetic */ HomeReservationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05111(String str, HomeReservationViewModel homeReservationViewModel, Continuation<? super C05111> continuation) {
            super(2, continuation);
            this.$siteId = str;
            this.this$0 = homeReservationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05111(this.$siteId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM529getReservationRecordListgIAlus;
            MutableLiveData mutableLiveData;
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
                MutableLiveData mutableLiveData2 = this.this$0.reservationListLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM529getReservationRecordListgIAlus = ReservationNetwork.INSTANCE.m529getReservationRecordListgIAlus(requestBodyCreate, this);
                if (objM529getReservationRecordListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM529getReservationRecordListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM529getReservationRecordListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getTodayReservationList(String siteId) {
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05111(siteId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$getReservationList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeReservationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$getReservationList$1", f = "HomeReservationViewModel.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
    static final class C05101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $pageNo;
        final /* synthetic */ int $pageSize;
        Object L$0;
        int label;
        final /* synthetic */ HomeReservationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05101(int i, int i2, HomeReservationViewModel homeReservationViewModel, Continuation<? super C05101> continuation) {
            super(2, continuation);
            this.$pageNo = i;
            this.$pageSize = i2;
            this.this$0 = homeReservationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05101(this.$pageNo, this.$pageSize, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM529getReservationRecordListgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("pageNo", Boxing.boxInt(this.$pageNo));
                map2.put("pageSize", Boxing.boxInt(this.$pageSize));
                String siteId = SpData.getSiteId();
                Intrinsics.checkNotNullExpressionValue(siteId, "getSiteId()");
                map2.put("siteId", siteId);
                String todayStr = DateUtils.getTodayStr("");
                Intrinsics.checkNotNullExpressionValue(todayStr, "getTodayStr(\"\")");
                map2.put("startTime", todayStr);
                String oldDate = DateUtils.getOldDate(7);
                Intrinsics.checkNotNullExpressionValue(oldDate, "getOldDate(7)");
                map2.put("endTime", oldDate);
                map2.put("status", Boxing.boxInt(2));
                map2.put("siteBookingType", Boxing.boxInt(4));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.reservationListAllLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM529getReservationRecordListgIAlus = ReservationNetwork.INSTANCE.m529getReservationRecordListgIAlus(requestBodyCreate, this);
                if (objM529getReservationRecordListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM529getReservationRecordListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM529getReservationRecordListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void getReservationList$default(HomeReservationViewModel homeReservationViewModel, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 1;
        }
        if ((i3 & 2) != 0) {
            i2 = 20;
        }
        homeReservationViewModel.getReservationList(i, i2);
    }

    public final void getReservationList(int pageNo, int pageSize) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05101(pageNo, pageSize, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$getConsultTeacherList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeReservationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$getConsultTeacherList$1", f = "HomeReservationViewModel.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
    static final class C05081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C05081(Continuation<? super C05081> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeReservationViewModel.this.new C05081(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05081) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM527getConsultTeacherListgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                map.put("labelKey", "consultant");
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = HomeReservationViewModel.this.consultListLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM527getConsultTeacherListgIAlus = ReservationNetwork.INSTANCE.m527getConsultTeacherListgIAlus(requestBodyCreate, this);
                if (objM527getConsultTeacherListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM527getConsultTeacherListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM527getConsultTeacherListgIAlus));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: getConsultTeacherList, reason: collision with other method in class */
    public final void m396getConsultTeacherList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05081(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$getConsultTeacherDetails$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomeReservationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$getConsultTeacherDetails$1", f = "HomeReservationViewModel.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeReservationViewModel.this.new AnonymousClass1(this.$id, continuation);
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
                MutableLiveData mutableLiveData2 = HomeReservationViewModel.this.consultDetailsLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objM526getConsultTeacherDetailsgIAlus = ReservationNetwork.INSTANCE.m526getConsultTeacherDetailsgIAlus(this.$id, this);
                if (objM526getConsultTeacherDetailsgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                value = objM526getConsultTeacherDetailsgIAlus;
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

    public final void getConsultTeacherDetails(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(id, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$getReservationDetail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeReservationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$getReservationDetail$1", f = "HomeReservationViewModel.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    static final class C05091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        int label;
        final /* synthetic */ HomeReservationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05091(String str, HomeReservationViewModel homeReservationViewModel, Continuation<? super C05091> continuation) {
            super(2, continuation);
            this.$id = str;
            this.this$0 = homeReservationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05091(this.$id, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

    public final void getReservationDetail(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05091(id, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$signInRecord$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeReservationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$signInRecord$1", f = "HomeReservationViewModel.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
    static final class C05141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $bookId;
        final /* synthetic */ String $user;
        int label;
        final /* synthetic */ HomeReservationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05141(String str, String str2, HomeReservationViewModel homeReservationViewModel, Continuation<? super C05141> continuation) {
            super(2, continuation);
            this.$bookId = str;
            this.$user = str2;
            this.this$0 = homeReservationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05141(this.$bookId, this.$user, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05141(bookId, user, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$insertReservationSignDataToDao$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeReservationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$insertReservationSignDataToDao$1", f = "HomeReservationViewModel.kt", i = {0}, l = {158, 166}, m = "invokeSuspend", n = {"daoSignData"}, s = {"L$0"})
    static final class C05121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $bookId;
        final /* synthetic */ String $time;
        final /* synthetic */ String $userId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05121(String str, String str2, String str3, Continuation<? super C05121> continuation) {
            super(2, continuation);
            this.$userId = str;
            this.$time = str2;
            this.$bookId = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05121(this.$userId, this.$time, this.$bookId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C05121(userId, time, bookId, null), 2, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$onCleared$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeReservationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel$onCleared$1", f = "HomeReservationViewModel.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
    static final class C05131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C05131(Continuation<? super C05131> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C05131 c05131 = HomeReservationViewModel.this.new C05131(continuation);
            c05131.L$0 = obj;
            return c05131;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AppExtKt.logd((CoroutineScope) this.L$0, "clear timer");
                Job job = HomeReservationViewModel.this.timerFlow;
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
            HomeReservationViewModel.this.timerFlow = null;
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05131(null), 3, null);
    }

    public final List<ReservationRecordBean> getReservationList(List<ReservationRecordBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList arrayList = new ArrayList();
        for (ReservationRecordBean reservationRecordBean : list) {
            if ((reservationRecordBean.getEndTimeStr().length() > 0) && DateUtils.isNextTime(reservationRecordBean.getEndTimeStr(), TimeUtil.notSecondFormat)) {
                arrayList.add(reservationRecordBean);
            }
        }
        return arrayList;
    }

    public final int getHighLightIndex(List<ReservationRecordBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        int i = 0;
        for (ReservationRecordBean reservationRecordBean : list) {
            int i2 = i + 1;
            if (TimeUtil.isTime(reservationRecordBean.getStartTimeStr(), reservationRecordBean.getEndTimeStr())) {
                return i;
            }
            i = i2;
        }
        return -1;
    }

    public final int getNextHighLightIndex(List<ReservationRecordBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        int i = 0;
        for (ReservationRecordBean reservationRecordBean : list) {
            int i2 = i + 1;
            if ((reservationRecordBean.getStartTimeStr().length() > 0) && DateUtils.isNextTime(reservationRecordBean.getStartTimeStr(), TimeUtil.notSecondFormat)) {
                return i;
            }
            i = i2;
        }
        return -1;
    }
}
