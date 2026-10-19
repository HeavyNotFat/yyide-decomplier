package com.yd.android_brand_mvp.activity.home.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.android.dx.io.Opcodes;
import com.blankj.utilcode.util.LogUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.tencent.smtt.sdk.TbsListener;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.db.reservation.ReservationSignBean;
import com.yd.android_brand_mvp.model.BrandConfigBean;
import com.yd.android_brand_mvp.model.DominateDetailLevelBean;
import com.yd.android_brand_mvp.model.FaceActiveConfigBean;
import com.yd.android_brand_mvp.model.MessageCaptionBean;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
import com.yd.android_brand_mvp.model.home.DominateCustomBean;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.exam.ExamManageNetwork;
import com.yd.android_brand_mvp.network.reservation.ReservationNetwork;
import com.yd.android_brand_mvp.repository.ReservationDaoRepository;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.MMKVUtil;
import com.yd.android_brand_mvp.utils.MMKVUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yyide.facepass.AppExtKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
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
import kotlinx.coroutines.BuildersKt;
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

/* JADX INFO: compiled from: HomeViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u00107\u001a\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u00020-0\u0005J\u0006\u0010:\u001a\u000208J\u0006\u0010;\u001a\u000208J\u0006\u0010<\u001a\u000208J\u0006\u0010=\u001a\u000208J\u0006\u0010>\u001a\u000208J\u0006\u0010?\u001a\u000208J\u0010\u0010@\u001a\u0002082\b\u0010A\u001a\u0004\u0018\u000102J\b\u0010B\u001a\u000208H\u0014J\u0006\u0010C\u001a\u000208J\u0019\u0010D\u001a\u0002082\u0006\u0010E\u001a\u00020FH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010GJ\u0014\u0010H\u001a\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u00020-0\u0005R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00050\u00140\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR#\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00050\u00140\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\bR\u0016\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\bR\u001a\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\bR\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020%0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\bR\u001a\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\bR\u001a\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020201¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006I"}, d2 = {"Lcom/yd/android_brand_mvp/activity/home/viewmodel/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "dominateCustomData", "Landroidx/lifecycle/LiveData;", "", "Lcom/yd/android_brand_mvp/model/home/DominateCustomBean;", "getDominateCustomData", "()Landroidx/lifecycle/LiveData;", "dominateCustomDataLiveData", "Landroidx/lifecycle/MutableLiveData;", "dominateCustomDataResult", "", "getDominateCustomDataResult", "()Landroidx/lifecycle/MutableLiveData;", "dominateLevel", "Lcom/yd/android_brand_mvp/model/DominateDetailLevelBean;", "getDominateLevel", "dominateLevelLiveData", "dominateMessageList", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "getDominateMessageList", "dominateMessageListLiveData", "faceActiveConfig", "Lcom/yd/android_brand_mvp/model/FaceActiveConfigBean;", "getFaceActiveConfig", "faceActiveConfigLiveData", "homeDeviceConfig", "Lcom/yd/android_brand_mvp/model/BrandConfigBean;", "getHomeDeviceConfig", "homeDeviceLiveData", "homeExamList", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "getHomeExamList", "homeExamListLiveData", "messageCaption", "Lcom/yd/android_brand_mvp/model/MessageCaptionBean;", "getMessageCaption", "messageCaptionLiveData", "reservationList", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "getReservationList", "reservationListLiveData", "reservationSignList", "Lcom/yd/android_brand_mvp/db/reservation/ReservationSignBean;", "getReservationSignList", "reservationSignListLiveData", "timeSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "getTimeSharedFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "timerFlow", "Lkotlinx/coroutines/Job;", "deleteUploadSuccessSignData", "", TUIKitConstants.Selection.LIST, "getCustomDominateData", "getDeviceConfig", "getFaceConfig", "getHomeExamListData", "getMessagePublishData", "getNotUploadReservationSignData", "getTodayReservationList", "siteId", "onCleared", "requestDominateLevel", "startTimer", "millSeconds", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadReservationData", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomeViewModel extends ViewModel {
    private final LiveData<List<DominateCustomBean>> dominateCustomData;
    private final MutableLiveData<List<DominateCustomBean>> dominateCustomDataLiveData;
    private final MutableLiveData<Boolean> dominateCustomDataResult;
    private final LiveData<List<DominateDetailLevelBean>> dominateLevel;
    private final MutableLiveData<List<DominateDetailLevelBean>> dominateLevelLiveData;
    private final LiveData<Result<List<MessageItemBean>>> dominateMessageList;
    private final MutableLiveData<Result<List<MessageItemBean>>> dominateMessageListLiveData;
    private final LiveData<FaceActiveConfigBean> faceActiveConfig;
    private final MutableLiveData<FaceActiveConfigBean> faceActiveConfigLiveData;
    private final LiveData<BrandConfigBean> homeDeviceConfig;
    private final MutableLiveData<BrandConfigBean> homeDeviceLiveData;
    private final LiveData<List<ExamPlanItem>> homeExamList;
    private final MutableLiveData<List<ExamPlanItem>> homeExamListLiveData;
    private final LiveData<MessageCaptionBean> messageCaption;
    private final MutableLiveData<MessageCaptionBean> messageCaptionLiveData;
    private final LiveData<List<ReservationRecordBean>> reservationList;
    private final MutableLiveData<List<ReservationRecordBean>> reservationListLiveData;
    private final LiveData<List<ReservationSignBean>> reservationSignList;
    private final MutableLiveData<List<ReservationSignBean>> reservationSignListLiveData;
    private final MutableSharedFlow<String> timeSharedFlow;
    private Job timerFlow;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$startTimer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel", f = "HomeViewModel.kt", i = {0, 0}, l = {85}, m = "startTimer", n = {"this", "millSeconds"}, s = {"L$0", "J$0"})
    static final class C03531 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C03531(Continuation<? super C03531> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomeViewModel.this.startTimer(0L, this);
        }
    }

    public HomeViewModel() {
        MutableLiveData<BrandConfigBean> mutableLiveData = new MutableLiveData<>();
        this.homeDeviceLiveData = mutableLiveData;
        this.homeDeviceConfig = mutableLiveData;
        MutableLiveData<List<ExamPlanItem>> mutableLiveData2 = new MutableLiveData<>();
        this.homeExamListLiveData = mutableLiveData2;
        this.homeExamList = mutableLiveData2;
        MutableLiveData<List<ReservationRecordBean>> mutableLiveData3 = new MutableLiveData<>();
        this.reservationListLiveData = mutableLiveData3;
        this.reservationList = mutableLiveData3;
        MutableLiveData<List<ReservationSignBean>> mutableLiveData4 = new MutableLiveData<>();
        this.reservationSignListLiveData = mutableLiveData4;
        this.reservationSignList = mutableLiveData4;
        MutableLiveData<List<DominateCustomBean>> mutableLiveData5 = new MutableLiveData<>();
        this.dominateCustomDataLiveData = mutableLiveData5;
        this.dominateCustomData = mutableLiveData5;
        this.dominateCustomDataResult = new MutableLiveData<>();
        MutableLiveData<Result<List<MessageItemBean>>> mutableLiveData6 = new MutableLiveData<>();
        this.dominateMessageListLiveData = mutableLiveData6;
        this.dominateMessageList = mutableLiveData6;
        MutableLiveData<List<DominateDetailLevelBean>> mutableLiveData7 = new MutableLiveData<>();
        this.dominateLevelLiveData = mutableLiveData7;
        this.dominateLevel = mutableLiveData7;
        MutableLiveData<MessageCaptionBean> mutableLiveData8 = new MutableLiveData<>();
        this.messageCaptionLiveData = mutableLiveData8;
        this.messageCaption = mutableLiveData8;
        MutableLiveData<FaceActiveConfigBean> mutableLiveData9 = new MutableLiveData<>();
        this.faceActiveConfigLiveData = mutableLiveData9;
        this.faceActiveConfig = mutableLiveData9;
        this.timeSharedFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public final LiveData<BrandConfigBean> getHomeDeviceConfig() {
        return this.homeDeviceConfig;
    }

    public final LiveData<List<ExamPlanItem>> getHomeExamList() {
        return this.homeExamList;
    }

    public final LiveData<List<ReservationRecordBean>> getReservationList() {
        return this.reservationList;
    }

    public final LiveData<List<ReservationSignBean>> getReservationSignList() {
        return this.reservationSignList;
    }

    public final LiveData<List<DominateCustomBean>> getDominateCustomData() {
        return this.dominateCustomData;
    }

    public final MutableLiveData<Boolean> getDominateCustomDataResult() {
        return this.dominateCustomDataResult;
    }

    public final LiveData<Result<List<MessageItemBean>>> getDominateMessageList() {
        return this.dominateMessageList;
    }

    public final LiveData<List<DominateDetailLevelBean>> getDominateLevel() {
        return this.dominateLevel;
    }

    public final LiveData<MessageCaptionBean> getMessageCaption() {
        return this.messageCaption;
    }

    public final LiveData<FaceActiveConfigBean> getFaceActiveConfig() {
        return this.faceActiveConfig;
    }

    public final MutableSharedFlow<String> getTimeSharedFlow() {
        return this.timeSharedFlow;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object startTimer(long j, Continuation<? super Unit> continuation) {
        C03531 c03531;
        HomeViewModel homeViewModel;
        if (continuation instanceof C03531) {
            c03531 = (C03531) continuation;
            if ((c03531.label & Integer.MIN_VALUE) != 0) {
                c03531.label -= Integer.MIN_VALUE;
            } else {
                c03531 = new C03531(continuation);
            }
        } else {
            c03531 = new C03531(continuation);
        }
        Object obj = c03531.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c03531.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Job job = this.timerFlow;
            if (job != null) {
                if (job != null) {
                    c03531.L$0 = this;
                    c03531.J$0 = j;
                    c03531.label = 1;
                    if (JobKt.cancelAndJoin(job, c03531) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                homeViewModel = this;
            } else {
                homeViewModel = this;
            }
            homeViewModel.timerFlow = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(homeViewModel), null, null, new AnonymousClass2(j, homeViewModel, null), 3, null);
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j = c03531.J$0;
        homeViewModel = (HomeViewModel) c03531.L$0;
        ResultKt.throwOnFailure(obj);
        homeViewModel.timerFlow = null;
        homeViewModel.timerFlow = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(homeViewModel), null, null, new AnonymousClass2(j, homeViewModel, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$startTimer$2, reason: invalid class name */
    /* JADX INFO: compiled from: HomeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$startTimer$2", f = "HomeViewModel.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $millSeconds;
        int label;
        final /* synthetic */ HomeViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(long j, HomeViewModel homeViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$millSeconds = j;
            this.this$0 = homeViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$millSeconds, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$startTimer$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: HomeViewModel.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$startTimer$2$1", f = "HomeViewModel.kt", i = {0, 1}, l = {91, 92}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
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

            /* JADX WARN: Code duplicated, block: B:14:0x003a  */
            /* JADX WARN: Code duplicated, block: B:16:0x0049 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:17:0x004a  */
            /* JADX WARN: Code duplicated, block: B:20:0x005c A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:21:0x005d  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005d -> B:12:0x0030). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                /*
                    r8 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r8.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L28
                    if (r1 == r3) goto L1f
                    if (r1 != r2) goto L17
                    java.lang.Object r1 = r8.L$0
                    kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                    kotlin.ResultKt.throwOnFailure(r9)
                    r9 = r1
                    goto L2f
                L17:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r0)
                    throw r9
                L1f:
                    java.lang.Object r1 = r8.L$0
                    kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                    kotlin.ResultKt.throwOnFailure(r9)
                    r9 = r8
                    goto L4d
                L28:
                    kotlin.ResultKt.throwOnFailure(r9)
                    java.lang.Object r9 = r8.L$0
                    kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
                L2f:
                    r1 = r8
                L30:
                    kotlin.coroutines.CoroutineContext r4 = r1.get$context()
                    boolean r4 = kotlinx.coroutines.JobKt.isActive(r4)
                    if (r4 == 0) goto L61
                    long r4 = r1.$millSeconds
                    r6 = r1
                    kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                    r1.L$0 = r9
                    r1.label = r3
                    java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r4, r6)
                    if (r4 != r0) goto L4a
                    return r0
                L4a:
                    r7 = r1
                    r1 = r9
                    r9 = r7
                L4d:
                    r4 = r9
                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                    r9.L$0 = r1
                    r9.label = r2
                    java.lang.String r5 = "1"
                    java.lang.Object r4 = r1.emit(r5, r4)
                    if (r4 != r0) goto L5d
                    return r0
                L5d:
                    r7 = r1
                    r1 = r9
                    r9 = r7
                    goto L30
                L61:
                    kotlin.Unit r9 = kotlin.Unit.INSTANCE
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowM2121catch = FlowKt.m2121catch(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(this.$millSeconds, null)), Dispatchers.getIO()), new C01672(this.this$0, null));
                final HomeViewModel homeViewModel = this.this$0;
                this.label = 1;
                if (flowM2121catch.collect(new FlowCollector() { // from class: com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel.startTimer.2.3
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((String) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(String str, Continuation<? super Unit> continuation) {
                        Object objEmit = homeViewModel.getTimeSharedFlow().emit(str, continuation);
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

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$startTimer$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: HomeViewModel.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$startTimer$2$2", f = "HomeViewModel.kt", i = {0}, l = {95}, m = "invokeSuspend", n = {"$this$catch"}, s = {"L$0"})
        static final class C01672 extends SuspendLambda implements Function3<FlowCollector<? super String>, Throwable, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ HomeViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01672(HomeViewModel homeViewModel, Continuation<? super C01672> continuation) {
                super(3, continuation);
                this.this$0 = homeViewModel;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super String> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                C01672 c01672 = new C01672(this.this$0, continuation);
                c01672.L$0 = flowCollector;
                return c01672.invokeSuspend(Unit.INSTANCE);
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
                    AppExtKt.logd(flowCollector, "定时器出错");
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                flowCollector = flowCollector2;
                AppExtKt.logd(flowCollector, "定时器出错");
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$getDeviceConfig$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$getDeviceConfig$1", f = "HomeViewModel.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
    static final class C03451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03451(Continuation<? super C03451> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeViewModel.this.new C03451(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03451) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM511requestDeviceConfiggIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ExamManageNetwork examManageNetwork = ExamManageNetwork.INSTANCE;
                String mac = BaseApplication.getInstance().getMac();
                Intrinsics.checkNotNullExpressionValue(mac, "getInstance().mac");
                this.label = 1;
                objM511requestDeviceConfiggIAlus = examManageNetwork.m511requestDeviceConfiggIAlus(mac, this);
                if (objM511requestDeviceConfiggIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM511requestDeviceConfiggIAlus = ((Result) obj).getValue();
            }
            BrandConfigBean brandConfigBean = null;
            if (Result.m598isSuccessimpl(objM511requestDeviceConfiggIAlus)) {
                if (Result.m597isFailureimpl(objM511requestDeviceConfiggIAlus)) {
                    objM511requestDeviceConfiggIAlus = null;
                }
                brandConfigBean = (BrandConfigBean) objM511requestDeviceConfiggIAlus;
                MMKVUtils.INSTANCE.put(MMKVConstant.BRAND, GsonUtils.toJson(brandConfigBean));
            }
            HomeViewModel.this.homeDeviceLiveData.setValue(brandConfigBean);
            return Unit.INSTANCE;
        }
    }

    public final void getDeviceConfig() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03451(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$getHomeExamListData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$getHomeExamListData$1", f = "HomeViewModel.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
    static final class C03471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03471(Continuation<? super C03471> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeViewModel.this.new C03471(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            if (!Result.m598isSuccessimpl(objM508getTodayExamgIAlus)) {
                HomeViewModel.this.homeExamListLiveData.setValue(CollectionsKt.emptyList());
            } else {
                if (Result.m597isFailureimpl(objM508getTodayExamgIAlus)) {
                    objM508getTodayExamgIAlus = null;
                }
                List listEmptyList = (List) objM508getTodayExamgIAlus;
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                String jsonStr = GsonUtils.toJson(listEmptyList);
                MMKVUtil mMKVUtil = MMKVUtil.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(jsonStr, "jsonStr");
                mMKVUtil.saveDominateScreenData(jsonStr, MMKVUtil.DOMINATE_EXAM_DATA);
                HomeViewModel.this.homeExamListLiveData.setValue(listEmptyList);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getHomeExamListData() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03471(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$getTodayReservationList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$getTodayReservationList$1", f = "HomeViewModel.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
    static final class C03501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $siteId;
        int label;
        final /* synthetic */ HomeViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03501(String str, HomeViewModel homeViewModel, Continuation<? super C03501> continuation) {
            super(2, continuation);
            this.$siteId = str;
            this.this$0 = homeViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03501(this.$siteId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM529getReservationRecordListgIAlus;
            ArrayList arrayList;
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
            if (!Result.m598isSuccessimpl(objM529getReservationRecordListgIAlus)) {
                this.this$0.reservationListLiveData.setValue(CollectionsKt.emptyList());
            } else {
                if (Result.m597isFailureimpl(objM529getReservationRecordListgIAlus)) {
                    objM529getReservationRecordListgIAlus = null;
                }
                BasePageResponse basePageResponse = (BasePageResponse) objM529getReservationRecordListgIAlus;
                if (basePageResponse == null) {
                    return Unit.INSTANCE;
                }
                List list = (List) basePageResponse.getList();
                if (list == null || (arrayList = CollectionsKt.sortedWith(list, new Comparator() { // from class: com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$getTodayReservationList$1$invokeSuspend$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((ReservationRecordBean) t).getStartTimeStr(), ((ReservationRecordBean) t2).getStartTimeStr());
                    }
                })) == null) {
                    arrayList = new ArrayList();
                }
                String jsonStr = GsonUtils.toJson(arrayList);
                MMKVUtil mMKVUtil = MMKVUtil.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(jsonStr, "jsonStr");
                mMKVUtil.saveDominateScreenData(jsonStr, MMKVUtil.DOMINATE_RESERVATION_DATA);
                this.this$0.reservationListLiveData.setValue(arrayList);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getTodayReservationList(String siteId) {
        if (siteId == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03501(siteId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$getFaceConfig$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$getFaceConfig$1", f = "HomeViewModel.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {})
    static final class C03461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03461(Continuation<? super C03461> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeViewModel.this.new C03461(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03461) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM455requestFaceConfiggIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "megvii_legacy_cert");
                String mac = BaseApplication.getInstance().getMac();
                Intrinsics.checkNotNullExpressionValue(mac, "getInstance().mac");
                map2.put("deviceNo", mac);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                this.label = 1;
                objM455requestFaceConfiggIAlus = NetworkApi.INSTANCE.m455requestFaceConfiggIAlus(requestBodyCreate, this);
                if (objM455requestFaceConfiggIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM455requestFaceConfiggIAlus = ((Result) obj).getValue();
            }
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("获取人脸激活配置 = ");
            sb.append(GsonUtils.toJson(Result.m597isFailureimpl(objM455requestFaceConfiggIAlus) ? null : objM455requestFaceConfiggIAlus));
            objArr[0] = sb.toString();
            LogUtils.i(objArr);
            if (!Result.m598isSuccessimpl(objM455requestFaceConfiggIAlus)) {
                HomeViewModel.this.faceActiveConfigLiveData.setValue(null);
            } else {
                if (Result.m597isFailureimpl(objM455requestFaceConfiggIAlus)) {
                    objM455requestFaceConfiggIAlus = null;
                }
                FaceActiveConfigBean faceActiveConfigBean = (FaceActiveConfigBean) objM455requestFaceConfiggIAlus;
                MMKVUtils.INSTANCE.put(MMKVConstant.FACE_ACTIVE_CONFIG, GsonUtils.toJson(faceActiveConfigBean));
                HomeViewModel.this.faceActiveConfigLiveData.setValue(faceActiveConfigBean);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getFaceConfig() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03461(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$getNotUploadReservationSignData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$getNotUploadReservationSignData$1", f = "HomeViewModel.kt", i = {0}, l = {184}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class C03491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C03491(Continuation<? super C03491> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03491 c03491 = HomeViewModel.this.new C03491(continuation);
            c03491.L$0 = obj;
            return c03491;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                this.L$0 = coroutineScope2;
                this.label = 1;
                Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new HomeViewModel$getNotUploadReservationSignData$1$uploadSignList$1(null), this);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope2;
                obj = objWithContext;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            List list = (List) obj;
            AppExtKt.logd(coroutineScope, "getNotUploadReservationSignSize = " + list.size() + ",data = " + list);
            if (!list.isEmpty()) {
                HomeViewModel.this.reservationSignListLiveData.setValue(list);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getNotUploadReservationSignData() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03491(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$uploadReservationData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$uploadReservationData$1", f = "HomeViewModel.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
    static final class C03541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ReservationSignBean> $list;
        int label;
        final /* synthetic */ HomeViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03541(List<ReservationSignBean> list, HomeViewModel homeViewModel, Continuation<? super C03541> continuation) {
            super(2, continuation);
            this.$list = list;
            this.this$0 = homeViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03541(this.$list, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM530offlineSignInReservationgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                map.put(TUIKitConstants.Selection.LIST, this.$list);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                this.label = 1;
                objM530offlineSignInReservationgIAlus = ReservationNetwork.INSTANCE.m530offlineSignInReservationgIAlus(requestBodyCreate, this);
                if (objM530offlineSignInReservationgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM530offlineSignInReservationgIAlus = ((Result) obj).getValue();
            }
            if (Result.m598isSuccessimpl(objM530offlineSignInReservationgIAlus)) {
                this.this$0.deleteUploadSuccessSignData(this.$list);
            }
            return Unit.INSTANCE;
        }
    }

    public final void uploadReservationData(List<ReservationSignBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03541(list, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$deleteUploadSuccessSignData$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$deleteUploadSuccessSignData$1", f = "HomeViewModel.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ReservationSignBean> $list;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<ReservationSignBean> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$list = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$list, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReservationDaoRepository.INSTANCE.delSignListData(this.$list, this) == coroutine_suspended) {
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

    public final void deleteUploadSuccessSignData(List<ReservationSignBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(list, null), 2, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$getCustomDominateData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$getCustomDominateData$1", f = "HomeViewModel.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
    static final class C03441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03441(Continuation<? super C03441> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeViewModel.this.new C03441(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM426getDominateCustomListgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String brandId = SpData.getBrandId();
                NetworkApi networkApi = NetworkApi.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(brandId, "brandId");
                this.label = 1;
                objM426getDominateCustomListgIAlus = networkApi.m426getDominateCustomListgIAlus(brandId, this);
                if (objM426getDominateCustomListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM426getDominateCustomListgIAlus = ((Result) obj).getValue();
            }
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("获取霸屏列表 = ");
            sb.append(GsonUtils.toJson(Result.m597isFailureimpl(objM426getDominateCustomListgIAlus) ? null : objM426getDominateCustomListgIAlus));
            objArr[0] = sb.toString();
            LogUtils.i(objArr);
            if (!Result.m598isSuccessimpl(objM426getDominateCustomListgIAlus)) {
                HomeViewModel.this.dominateCustomDataLiveData.setValue(CollectionsKt.emptyList());
            } else {
                if (Result.m597isFailureimpl(objM426getDominateCustomListgIAlus)) {
                    objM426getDominateCustomListgIAlus = null;
                }
                List listEmptyList = (List) objM426getDominateCustomListgIAlus;
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                String jsonStr = GsonUtils.toJson(listEmptyList);
                MMKVUtil mMKVUtil = MMKVUtil.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(jsonStr, "jsonStr");
                mMKVUtil.saveDominateScreenData(jsonStr, MMKVUtil.DOMINATE_CUSTOM_DATA);
                HomeViewModel.this.dominateCustomDataLiveData.setValue(listEmptyList);
                HomeViewModel.this.getDominateCustomDataResult().setValue(Boxing.boxBoolean(true));
            }
            return Unit.INSTANCE;
        }
    }

    public final void getCustomDominateData() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03441(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$getMessagePublishData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$getMessagePublishData$1", f = "HomeViewModel.kt", i = {}, l = {TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS}, m = "invokeSuspend", n = {}, s = {})
    static final class C03481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C03481(Continuation<? super C03481> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeViewModel.this.new C03481(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM427getDominateMessagePublishListgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                String brandId = SpData.getBrandId();
                Intrinsics.checkNotNullExpressionValue(brandId, "getBrandId()");
                map.put("brandId", brandId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = HomeViewModel.this.dominateMessageListLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM427getDominateMessagePublishListgIAlus = NetworkApi.INSTANCE.m427getDominateMessagePublishListgIAlus(requestBodyCreate, this);
                if (objM427getDominateMessagePublishListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM427getDominateMessagePublishListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM427getDominateMessagePublishListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getMessagePublishData() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C03481(null), 2, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$requestDominateLevel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$requestDominateLevel$1", f = "HomeViewModel.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
    static final class C03521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03521(Continuation<? super C03521> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeViewModel.this.new C03521(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM428getDominateScreenLevelIoAF18A;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                objM428getDominateScreenLevelIoAF18A = NetworkApi.INSTANCE.m428getDominateScreenLevelIoAF18A(this);
                if (objM428getDominateScreenLevelIoAF18A == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM428getDominateScreenLevelIoAF18A = ((Result) obj).getValue();
            }
            if (Result.m598isSuccessimpl(objM428getDominateScreenLevelIoAF18A)) {
                MutableLiveData mutableLiveData = HomeViewModel.this.dominateLevelLiveData;
                if (Result.m597isFailureimpl(objM428getDominateScreenLevelIoAF18A)) {
                    objM428getDominateScreenLevelIoAF18A = null;
                }
                List listEmptyList = (List) objM428getDominateScreenLevelIoAF18A;
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                mutableLiveData.setValue(listEmptyList);
            }
            return Unit.INSTANCE;
        }
    }

    public final void requestDominateLevel() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03521(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$onCleared$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$onCleared$1", f = "HomeViewModel.kt", i = {}, l = {Opcodes.INVOKE_POLYMORPHIC_RANGE}, m = "invokeSuspend", n = {}, s = {})
    static final class C03511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C03511(Continuation<? super C03511> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03511 c03511 = HomeViewModel.this.new C03511(continuation);
            c03511.L$0 = obj;
            return c03511;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AppExtKt.logd((CoroutineScope) this.L$0, "clear timer");
                Job job = HomeViewModel.this.timerFlow;
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
            HomeViewModel.this.timerFlow = null;
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03511(null), 3, null);
    }
}
