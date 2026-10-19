package com.yd.android_brand_mvp.landscape.active.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.active.ActiveDetailsBean;
import com.yd.android_brand_mvp.model.active.ActiveMyRegistrationBean;
import com.yd.android_brand_mvp.model.active.ActiveRegistrationBean;
import com.yd.android_brand_mvp.model.active.ActiveSuccessBean;
import com.yd.android_brand_mvp.network.active.ActiveApplyNetwork;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
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

/* JADX INFO: compiled from: ActiveApplyFragmentViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u000e\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cJ\u001e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001aJ&\u0010\u0016\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aJ,\u0010\"\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001a2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0\fR \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R,\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR)\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R,\u0010\u0014\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\u000b0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR)\u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\u000b0\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/active/viewModel/ActiveApplyFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "activeDetails", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/active/ActiveDetailsBean;", "getActiveDetails", "()Landroidx/lifecycle/MutableLiveData;", "activeDetailsLiveData", "activeList", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/active/ActiveRegistrationBean;", "getActiveList", "activeListLiveData", "activeRegistration", "Lcom/yd/android_brand_mvp/model/active/ActiveSuccessBean;", "getActiveRegistration", "activeRegistrationLiveData", "myRegistrationList", "Lcom/yd/android_brand_mvp/model/active/ActiveMyRegistrationBean;", "getMyRegistrationList", "myRegistrationLiveData", "", "activityId", "", "pageNo", "", "pageSize", "getLoginActiveDetails", "userId", "identifyType", "activityName", "pushActivity", "subIds", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActiveApplyFragmentViewModel extends ViewModel {
    private final MutableLiveData<Result<ActiveDetailsBean>> activeDetails;
    private final MutableLiveData<Result<ActiveDetailsBean>> activeDetailsLiveData;
    private final MutableLiveData<Result<BasePageResponse<List<ActiveRegistrationBean>>>> activeList;
    private final MutableLiveData<Result<BasePageResponse<List<ActiveRegistrationBean>>>> activeListLiveData;
    private final MutableLiveData<Result<ActiveSuccessBean>> activeRegistration;
    private final MutableLiveData<Result<ActiveSuccessBean>> activeRegistrationLiveData;
    private final MutableLiveData<Result<BasePageResponse<List<ActiveMyRegistrationBean>>>> myRegistrationList;
    private final MutableLiveData<Result<BasePageResponse<List<ActiveMyRegistrationBean>>>> myRegistrationLiveData;

    public ActiveApplyFragmentViewModel() {
        MutableLiveData<Result<BasePageResponse<List<ActiveRegistrationBean>>>> mutableLiveData = new MutableLiveData<>();
        this.activeListLiveData = mutableLiveData;
        this.activeList = mutableLiveData;
        MutableLiveData<Result<BasePageResponse<List<ActiveMyRegistrationBean>>>> mutableLiveData2 = new MutableLiveData<>();
        this.myRegistrationLiveData = mutableLiveData2;
        this.myRegistrationList = mutableLiveData2;
        MutableLiveData<Result<ActiveDetailsBean>> mutableLiveData3 = new MutableLiveData<>();
        this.activeDetailsLiveData = mutableLiveData3;
        this.activeDetails = mutableLiveData3;
        MutableLiveData<Result<ActiveSuccessBean>> mutableLiveData4 = new MutableLiveData<>();
        this.activeRegistrationLiveData = mutableLiveData4;
        this.activeRegistration = mutableLiveData4;
    }

    public final MutableLiveData<Result<BasePageResponse<List<ActiveRegistrationBean>>>> getActiveList() {
        return this.activeList;
    }

    public final MutableLiveData<Result<BasePageResponse<List<ActiveMyRegistrationBean>>>> getMyRegistrationList() {
        return this.myRegistrationList;
    }

    public final MutableLiveData<Result<ActiveDetailsBean>> getActiveDetails() {
        return this.activeDetails;
    }

    public final MutableLiveData<Result<ActiveSuccessBean>> getActiveRegistration() {
        return this.activeRegistration;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.active.viewModel.ActiveApplyFragmentViewModel$getActiveList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ActiveApplyFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.active.viewModel.ActiveApplyFragmentViewModel$getActiveList$1", f = "ActiveApplyFragmentViewModel.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    static final class C03911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $pageNo;
        final /* synthetic */ int $pageSize;
        Object L$0;
        int label;
        final /* synthetic */ ActiveApplyFragmentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03911(int i, int i2, ActiveApplyFragmentViewModel activeApplyFragmentViewModel, Continuation<? super C03911> continuation) {
            super(2, continuation);
            this.$pageNo = i;
            this.$pageSize = i2;
            this.this$0 = activeApplyFragmentViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03911(this.$pageNo, this.$pageSize, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM477requestActiveListgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("pageNo", Boxing.boxInt(this.$pageNo));
                map2.put("pageSize", Boxing.boxInt(this.$pageSize));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.activeListLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM477requestActiveListgIAlus = ActiveApplyNetwork.INSTANCE.m477requestActiveListgIAlus(requestBodyCreate, this);
                if (objM477requestActiveListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM477requestActiveListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM477requestActiveListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getActiveList(int pageNo, int pageSize) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03911(pageNo, pageSize, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.active.viewModel.ActiveApplyFragmentViewModel$getActiveDetails$1, reason: invalid class name */
    /* JADX INFO: compiled from: ActiveApplyFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.active.viewModel.ActiveApplyFragmentViewModel$getActiveDetails$1", f = "ActiveApplyFragmentViewModel.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $activityId;
        int label;
        final /* synthetic */ ActiveApplyFragmentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, ActiveApplyFragmentViewModel activeApplyFragmentViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activityId = str;
            this.this$0 = activeApplyFragmentViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$activityId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM476requestActiveDetailsgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                map.put("activityId", this.$activityId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                this.label = 1;
                objM476requestActiveDetailsgIAlus = ActiveApplyNetwork.INSTANCE.m476requestActiveDetailsgIAlus(requestBodyCreate, this);
                if (objM476requestActiveDetailsgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM476requestActiveDetailsgIAlus = ((Result) obj).getValue();
            }
            this.this$0.activeDetailsLiveData.setValue(Result.m590boximpl(objM476requestActiveDetailsgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getActiveDetails(String activityId) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(activityId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.active.viewModel.ActiveApplyFragmentViewModel$getLoginActiveDetails$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ActiveApplyFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.active.viewModel.ActiveApplyFragmentViewModel$getLoginActiveDetails$1", f = "ActiveApplyFragmentViewModel.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
    static final class C03921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $activityId;
        final /* synthetic */ String $identifyType;
        final /* synthetic */ String $userId;
        int label;
        final /* synthetic */ ActiveApplyFragmentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03921(String str, String str2, String str3, ActiveApplyFragmentViewModel activeApplyFragmentViewModel, Continuation<? super C03921> continuation) {
            super(2, continuation);
            this.$activityId = str;
            this.$userId = str2;
            this.$identifyType = str3;
            this.this$0 = activeApplyFragmentViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03921(this.$activityId, this.$userId, this.$identifyType, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03921) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM479requestLoginActiveDetailsgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("activityId", this.$activityId);
                map2.put("userId", this.$userId);
                map2.put("identifyType", this.$identifyType);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                this.label = 1;
                objM479requestLoginActiveDetailsgIAlus = ActiveApplyNetwork.INSTANCE.m479requestLoginActiveDetailsgIAlus(requestBodyCreate, this);
                if (objM479requestLoginActiveDetailsgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM479requestLoginActiveDetailsgIAlus = ((Result) obj).getValue();
            }
            this.this$0.activeDetailsLiveData.setValue(Result.m590boximpl(objM479requestLoginActiveDetailsgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getLoginActiveDetails(String activityId, String userId, String identifyType) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(identifyType, "identifyType");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03921(activityId, userId, identifyType, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.active.viewModel.ActiveApplyFragmentViewModel$getMyRegistrationList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ActiveApplyFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.active.viewModel.ActiveApplyFragmentViewModel$getMyRegistrationList$1", f = "ActiveApplyFragmentViewModel.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
    static final class C03931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $activityName;
        final /* synthetic */ int $pageNo;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ String $userId;
        Object L$0;
        int label;
        final /* synthetic */ ActiveApplyFragmentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03931(int i, int i2, String str, String str2, ActiveApplyFragmentViewModel activeApplyFragmentViewModel, Continuation<? super C03931> continuation) {
            super(2, continuation);
            this.$pageNo = i;
            this.$pageSize = i2;
            this.$userId = str;
            this.$activityName = str2;
            this.this$0 = activeApplyFragmentViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03931(this.$pageNo, this.$pageSize, this.$userId, this.$activityName, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03931) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM480requestMyRegistrationListgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("pageNo", Boxing.boxInt(this.$pageNo));
                map2.put("pageSize", Boxing.boxInt(this.$pageSize));
                map2.put("userId", this.$userId);
                map2.put("activityName", this.$activityName);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.myRegistrationLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM480requestMyRegistrationListgIAlus = ActiveApplyNetwork.INSTANCE.m480requestMyRegistrationListgIAlus(requestBodyCreate, this);
                if (objM480requestMyRegistrationListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM480requestMyRegistrationListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM480requestMyRegistrationListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getMyRegistrationList(int pageNo, int pageSize, String activityName, String userId) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(userId, "userId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03931(pageNo, pageSize, userId, activityName, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.active.viewModel.ActiveApplyFragmentViewModel$pushActivity$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ActiveApplyFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.active.viewModel.ActiveApplyFragmentViewModel$pushActivity$1", f = "ActiveApplyFragmentViewModel.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
    static final class C03941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $activityId;
        final /* synthetic */ String $identifyType;
        final /* synthetic */ List<String> $subIds;
        final /* synthetic */ String $userId;
        Object L$0;
        int label;
        final /* synthetic */ ActiveApplyFragmentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03941(String str, String str2, String str3, List<String> list, ActiveApplyFragmentViewModel activeApplyFragmentViewModel, Continuation<? super C03941> continuation) {
            super(2, continuation);
            this.$activityId = str;
            this.$userId = str2;
            this.$identifyType = str3;
            this.$subIds = list;
            this.this$0 = activeApplyFragmentViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03941(this.$activityId, this.$userId, this.$identifyType, this.$subIds, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM478requestActiveRegistrationgIAlus;
            MutableLiveData<Result<ActiveSuccessBean>> mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("activityId", this.$activityId);
                map2.put("userId", this.$userId);
                map2.put("identifyType", this.$identifyType);
                map2.put("activitySubIds", this.$subIds);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData<Result<ActiveSuccessBean>> activeRegistration = this.this$0.getActiveRegistration();
                this.L$0 = activeRegistration;
                this.label = 1;
                objM478requestActiveRegistrationgIAlus = ActiveApplyNetwork.INSTANCE.m478requestActiveRegistrationgIAlus(requestBodyCreate, this);
                if (objM478requestActiveRegistrationgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = activeRegistration;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM478requestActiveRegistrationgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM478requestActiveRegistrationgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void pushActivity(String activityId, String userId, String identifyType, List<String> subIds) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(identifyType, "identifyType");
        Intrinsics.checkNotNullParameter(subIds, "subIds");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03941(activityId, userId, identifyType, subIds, this, null), 3, null);
    }
}
