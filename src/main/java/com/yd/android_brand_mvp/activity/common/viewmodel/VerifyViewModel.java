package com.yd.android_brand_mvp.activity.common.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.SiteInfoBean;
import com.yd.android_brand_mvp.model.UserIcCardBean;
import com.yd.android_brand_mvp.model.VerifyPeopleBean;
import com.yd.android_brand_mvp.model.selectTeacherByIcCardRsp;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.network.patrol.PatrolNetWork;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.LinkedHashMap;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: VerifyViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020 J\u0006\u0010$\u001a\u00020\u001eJ\u000e\u0010\u0011\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020 J\b\u0010&\u001a\u00020\u001eH\u0014J\u000e\u0010\u0003\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0019\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010)R \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\bR\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\bR\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lcom/yd/android_brand_mvp/activity/common/viewmodel/VerifyViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "patrolPunch", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "", "getPatrolPunch", "()Landroidx/lifecycle/LiveData;", "patrolPunchResultLiveData", "Landroidx/lifecycle/MutableLiveData;", "scanQrCodeResult", "Lcom/yd/android_brand_mvp/model/VerifyPeopleBean;", "getScanQrCodeResult", "scanQrCodeResultLiveData", "siteInfo", "Lcom/yd/android_brand_mvp/model/SiteInfoBean;", "getSiteInfo", "siteInfoLiveData", "teacherInfoByFace", "Lcom/yd/android_brand_mvp/model/selectTeacherByIcCardRsp$DataDTO;", "getTeacherInfoByFace", "teacherInfoByFaceLiveData", "timerFlow", "Lkotlinx/coroutines/Job;", "userInfoByCard", "Lcom/yd/android_brand_mvp/model/UserIcCardBean$DataBean;", "getUserInfoByCard", "userInfoByCardLiveData", "checkTeacherInfo", "", "userId", "", "type", "checkUserInfo", "cardNo", "clearRequestQrResult", "id", "onCleared", "startRequestQrCodeResult", "siteId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VerifyViewModel extends ViewModel {
    private final LiveData<Result<Boolean>> patrolPunch;
    private final MutableLiveData<Result<Boolean>> patrolPunchResultLiveData;
    private final LiveData<Result<VerifyPeopleBean>> scanQrCodeResult;
    private final MutableLiveData<Result<VerifyPeopleBean>> scanQrCodeResultLiveData;
    private final LiveData<Result<SiteInfoBean>> siteInfo;
    private final MutableLiveData<Result<SiteInfoBean>> siteInfoLiveData;
    private final LiveData<Result<selectTeacherByIcCardRsp.DataDTO>> teacherInfoByFace;
    private final MutableLiveData<Result<selectTeacherByIcCardRsp.DataDTO>> teacherInfoByFaceLiveData;
    private Job timerFlow;
    private final LiveData<Result<UserIcCardBean.DataBean>> userInfoByCard;
    private final MutableLiveData<Result<UserIcCardBean.DataBean>> userInfoByCardLiveData;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$startRequestQrCodeResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: VerifyViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel", f = "VerifyViewModel.kt", i = {0, 0}, l = {93}, m = "startRequestQrCodeResult", n = {"this", "siteId"}, s = {"L$0", "L$1"})
    static final class C03241 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C03241(Continuation<? super C03241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VerifyViewModel.this.startRequestQrCodeResult(null, this);
        }
    }

    public VerifyViewModel() {
        MutableLiveData<Result<UserIcCardBean.DataBean>> mutableLiveData = new MutableLiveData<>();
        this.userInfoByCardLiveData = mutableLiveData;
        this.userInfoByCard = mutableLiveData;
        MutableLiveData<Result<selectTeacherByIcCardRsp.DataDTO>> mutableLiveData2 = new MutableLiveData<>();
        this.teacherInfoByFaceLiveData = mutableLiveData2;
        this.teacherInfoByFace = mutableLiveData2;
        MutableLiveData<Result<SiteInfoBean>> mutableLiveData3 = new MutableLiveData<>();
        this.siteInfoLiveData = mutableLiveData3;
        this.siteInfo = mutableLiveData3;
        MutableLiveData<Result<VerifyPeopleBean>> mutableLiveData4 = new MutableLiveData<>();
        this.scanQrCodeResultLiveData = mutableLiveData4;
        this.scanQrCodeResult = mutableLiveData4;
        MutableLiveData<Result<Boolean>> mutableLiveData5 = new MutableLiveData<>();
        this.patrolPunchResultLiveData = mutableLiveData5;
        this.patrolPunch = mutableLiveData5;
    }

    public final LiveData<Result<UserIcCardBean.DataBean>> getUserInfoByCard() {
        return this.userInfoByCard;
    }

    public final LiveData<Result<selectTeacherByIcCardRsp.DataDTO>> getTeacherInfoByFace() {
        return this.teacherInfoByFace;
    }

    public final LiveData<Result<SiteInfoBean>> getSiteInfo() {
        return this.siteInfo;
    }

    public final LiveData<Result<VerifyPeopleBean>> getScanQrCodeResult() {
        return this.scanQrCodeResult;
    }

    public final LiveData<Result<Boolean>> getPatrolPunch() {
        return this.patrolPunch;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$getSiteInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: VerifyViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$getSiteInfo$1", f = "VerifyViewModel.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
    static final class C03221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03221(String str, Continuation<? super C03221> continuation) {
            super(2, continuation);
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return VerifyViewModel.this.new C03221(this.$id, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03221) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData2 = VerifyViewModel.this.siteInfoLiveData;
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
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03221(id, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$checkUserInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: VerifyViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$checkUserInfo$1", f = "VerifyViewModel.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
    static final class C03201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $cardNo;
        Object L$0;
        int label;
        final /* synthetic */ VerifyViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03201(String str, VerifyViewModel verifyViewModel, Continuation<? super C03201> continuation) {
            super(2, continuation);
            this.$cardNo = str;
            this.this$0 = verifyViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03201(this.$cardNo, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM418checkUsergIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("icCardNo", this.$cardNo);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(map)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.userInfoByCardLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM418checkUsergIAlus = NetworkApi.INSTANCE.m418checkUsergIAlus(requestBodyCreate, this);
                if (objM418checkUsergIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM418checkUsergIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM418checkUsergIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void checkUserInfo(String cardNo) {
        Intrinsics.checkNotNullParameter(cardNo, "cardNo");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03201(cardNo, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$checkTeacherInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: VerifyViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$checkTeacherInfo$1", f = "VerifyViewModel.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $type;
        final /* synthetic */ String $userId;
        Object L$0;
        int label;
        final /* synthetic */ VerifyViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, VerifyViewModel verifyViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$userId = str;
            this.$type = str2;
            this.this$0 = verifyViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$userId, this.$type, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM417checkTeachergIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("userId", this.$userId);
                linkedHashMap.put("type", this.$type);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(map)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.teacherInfoByFaceLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM417checkTeachergIAlus = NetworkApi.INSTANCE.m417checkTeachergIAlus(requestBodyCreate, this);
                if (objM417checkTeachergIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM417checkTeachergIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM417checkTeachergIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void checkTeacherInfo(String userId, String type) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(type, "type");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(userId, type, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$patrolPunch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: VerifyViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$patrolPunch$1", f = "VerifyViewModel.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
    static final class C03231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $userId;
        Object L$0;
        int label;
        final /* synthetic */ VerifyViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03231(String str, VerifyViewModel verifyViewModel, Continuation<? super C03231> continuation) {
            super(2, continuation);
            this.$userId = str;
            this.this$0 = verifyViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03231(this.$userId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03231) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM523patrolPunchgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("userId", this.$userId);
                String siteId = SpData.getSiteId();
                Intrinsics.checkNotNullExpressionValue(siteId, "getSiteId()");
                linkedHashMap.put("businessId", siteId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(map)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.patrolPunchResultLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM523patrolPunchgIAlus = PatrolNetWork.INSTANCE.m523patrolPunchgIAlus(requestBodyCreate, this);
                if (objM523patrolPunchgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM523patrolPunchgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM523patrolPunchgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void patrolPunch(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03231(userId, this, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object startRequestQrCodeResult(String str, Continuation<? super Unit> continuation) {
        C03241 c03241;
        VerifyViewModel verifyViewModel;
        if (continuation instanceof C03241) {
            c03241 = (C03241) continuation;
            if ((c03241.label & Integer.MIN_VALUE) != 0) {
                c03241.label -= Integer.MIN_VALUE;
            } else {
                c03241 = new C03241(continuation);
            }
        } else {
            c03241 = new C03241(continuation);
        }
        Object obj = c03241.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c03241.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Job job = this.timerFlow;
            if (job != null) {
                if (job != null) {
                    c03241.L$0 = this;
                    c03241.L$1 = str;
                    c03241.label = 1;
                    if (JobKt.cancelAndJoin(job, c03241) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                verifyViewModel = this;
            } else {
                verifyViewModel = this;
            }
            verifyViewModel.timerFlow = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(verifyViewModel), null, null, verifyViewModel.new AnonymousClass2(str, null), 3, null);
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        str = (String) c03241.L$1;
        verifyViewModel = (VerifyViewModel) c03241.L$0;
        ResultKt.throwOnFailure(obj);
        verifyViewModel.timerFlow = null;
        verifyViewModel.timerFlow = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(verifyViewModel), null, null, verifyViewModel.new AnonymousClass2(str, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$startRequestQrCodeResult$2, reason: invalid class name */
    /* JADX INFO: compiled from: VerifyViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$startRequestQrCodeResult$2", f = "VerifyViewModel.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $siteId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$siteId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return VerifyViewModel.this.new AnonymousClass2(this.$siteId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$startRequestQrCodeResult$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: VerifyViewModel.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$startRequestQrCodeResult$2$1", f = "VerifyViewModel.kt", i = {0, 1}, l = {99, 100}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super String>, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
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
                    kotlin.coroutines.CoroutineContext r4 = r1.getContext()
                    boolean r4 = kotlinx.coroutines.JobKt.isActive(r4)
                    if (r4 == 0) goto L61
                    r4 = 2000(0x7d0, double:9.88E-321)
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
                    java.lang.String r5 = "qrCodeTimer"
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
                throw new UnsupportedOperationException("Method not decompiled: com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.m2121catch(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(null)), Dispatchers.getIO()), new C01662(VerifyViewModel.this, null)).collect(new AnonymousClass3(VerifyViewModel.this, this.$siteId), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$startRequestQrCodeResult$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: VerifyViewModel.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$startRequestQrCodeResult$2$2", f = "VerifyViewModel.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
        static final class C01662 extends SuspendLambda implements Function3<FlowCollector<? super String>, Throwable, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ VerifyViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01662(VerifyViewModel verifyViewModel, Continuation<? super C01662> continuation) {
                super(3, continuation);
                this.this$0 = verifyViewModel;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super String> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                return new C01662(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Job job = this.this$0.timerFlow;
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
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$startRequestQrCodeResult$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: VerifyViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "", "emit", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class AnonymousClass3<T> implements FlowCollector {
            final /* synthetic */ String $siteId;
            final /* synthetic */ VerifyViewModel this$0;

            AnonymousClass3(VerifyViewModel verifyViewModel, String str) {
                this.this$0 = verifyViewModel;
                this.$siteId = str;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((String) obj, (Continuation<? super Unit>) continuation);
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            public final Object emit(String str, Continuation<? super Unit> continuation) {
                VerifyViewModel$startRequestQrCodeResult$2$3$emit$1 verifyViewModel$startRequestQrCodeResult$2$3$emit$1;
                Object value;
                MutableLiveData mutableLiveData;
                if (continuation instanceof VerifyViewModel$startRequestQrCodeResult$2$3$emit$1) {
                    verifyViewModel$startRequestQrCodeResult$2$3$emit$1 = (VerifyViewModel$startRequestQrCodeResult$2$3$emit$1) continuation;
                    if ((verifyViewModel$startRequestQrCodeResult$2$3$emit$1.label & Integer.MIN_VALUE) != 0) {
                        verifyViewModel$startRequestQrCodeResult$2$3$emit$1.label -= Integer.MIN_VALUE;
                    } else {
                        verifyViewModel$startRequestQrCodeResult$2$3$emit$1 = new VerifyViewModel$startRequestQrCodeResult$2$3$emit$1(this, continuation);
                    }
                } else {
                    verifyViewModel$startRequestQrCodeResult$2$3$emit$1 = new VerifyViewModel$startRequestQrCodeResult$2$3$emit$1(this, continuation);
                }
                Object obj = verifyViewModel$startRequestQrCodeResult$2$3$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = verifyViewModel$startRequestQrCodeResult$2$3$emit$1.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableLiveData mutableLiveData2 = this.this$0.scanQrCodeResultLiveData;
                    PatrolNetWork patrolNetWork = PatrolNetWork.INSTANCE;
                    String str2 = this.$siteId;
                    verifyViewModel$startRequestQrCodeResult$2$3$emit$1.L$0 = mutableLiveData2;
                    verifyViewModel$startRequestQrCodeResult$2$3$emit$1.label = 1;
                    Object objM522getScanQrCodeResultgIAlus = patrolNetWork.m522getScanQrCodeResultgIAlus(str2, verifyViewModel$startRequestQrCodeResult$2$3$emit$1);
                    if (objM522getScanQrCodeResultgIAlus == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    value = objM522getScanQrCodeResultgIAlus;
                    mutableLiveData = mutableLiveData2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutableLiveData = (MutableLiveData) verifyViewModel$startRequestQrCodeResult$2$3$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    value = ((Result) obj).getValue();
                }
                mutableLiveData.setValue(Result.m590boximpl(value));
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$clearRequestQrResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: VerifyViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$clearRequestQrResult$1", f = "VerifyViewModel.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
    static final class C03211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03211(Continuation<? super C03211> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return VerifyViewModel.this.new C03211(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Job job = VerifyViewModel.this.timerFlow;
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
            VerifyViewModel.this.timerFlow = null;
            return Unit.INSTANCE;
        }
    }

    public final void clearRequestQrResult() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03211(null), 3, null);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        clearRequestQrResult();
    }
}
