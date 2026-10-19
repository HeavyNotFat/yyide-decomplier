package com.yd.android_brand_mvp.activity.honor.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.honor.HonorScoreCycleBean;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import com.yyide.chatim_pro.model.honor.HonorScoreDetailBean;
import java.util.LinkedHashMap;
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

/* JADX INFO: compiled from: HonorScoreListViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J.\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016R,\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/activity/honor/viewmodel/HonorScoreListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "activeResultList", "Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yyide/chatim_pro/model/honor/HonorScoreDetailBean;", "getActiveResultList", "()Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "activityCycle", "Lcom/yd/android_brand_mvp/model/honor/HonorScoreCycleBean;", "getActivityCycle", "requestActivityCycle", "", "activityId", "", "requestIdentityDetail", "cycleId", "identityID", "pageNo", "", "pageSize", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorScoreListViewModel extends ViewModel {
    private final SingleLiveEvent<Result<BasePageResponse<List<HonorScoreDetailBean>>>> activeResultList = new SingleLiveEvent<>();
    private final SingleLiveEvent<Result<List<HonorScoreCycleBean>>> activityCycle = new SingleLiveEvent<>();

    public final SingleLiveEvent<Result<BasePageResponse<List<HonorScoreDetailBean>>>> getActiveResultList() {
        return this.activeResultList;
    }

    public final SingleLiveEvent<Result<List<HonorScoreCycleBean>>> getActivityCycle() {
        return this.activityCycle;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.honor.viewmodel.HonorScoreListViewModel$requestIdentityDetail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HonorScoreListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.honor.viewmodel.HonorScoreListViewModel$requestIdentityDetail$1", f = "HonorScoreListViewModel.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
    static final class C03561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $activityId;
        final /* synthetic */ String $cycleId;
        final /* synthetic */ String $identityID;
        final /* synthetic */ int $pageNo;
        final /* synthetic */ int $pageSize;
        Object L$0;
        int label;
        final /* synthetic */ HonorScoreListViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03561(String str, String str2, String str3, int i, int i2, HonorScoreListViewModel honorScoreListViewModel, Continuation<? super C03561> continuation) {
            super(2, continuation);
            this.$activityId = str;
            this.$cycleId = str2;
            this.$identityID = str3;
            this.$pageNo = i;
            this.$pageSize = i2;
            this.this$0 = honorScoreListViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03561(this.$activityId, this.$cycleId, this.$identityID, this.$pageNo, this.$pageSize, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM458requestIdentityDetailgIAlus;
            SingleLiveEvent<Result<BasePageResponse<List<HonorScoreDetailBean>>>> singleLiveEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("activityId", this.$activityId);
                linkedHashMap.put("cycleId", this.$cycleId);
                linkedHashMap.put("identityId", this.$identityID);
                linkedHashMap.put("pageNo", Boxing.boxInt(this.$pageNo));
                linkedHashMap.put("pageSize", Boxing.boxInt(this.$pageSize));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                SingleLiveEvent<Result<BasePageResponse<List<HonorScoreDetailBean>>>> activeResultList = this.this$0.getActiveResultList();
                this.L$0 = activeResultList;
                this.label = 1;
                objM458requestIdentityDetailgIAlus = NetworkApi.INSTANCE.m458requestIdentityDetailgIAlus(requestBodyCreate, this);
                if (objM458requestIdentityDetailgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = activeResultList;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                singleLiveEvent = (SingleLiveEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM458requestIdentityDetailgIAlus = ((Result) obj).getValue();
            }
            singleLiveEvent.setValue(Result.m590boximpl(objM458requestIdentityDetailgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void requestIdentityDetail(String activityId, String cycleId, String identityID, int pageNo, int pageSize) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(cycleId, "cycleId");
        Intrinsics.checkNotNullParameter(identityID, "identityID");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03561(activityId, cycleId, identityID, pageNo, pageSize, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.honor.viewmodel.HonorScoreListViewModel$requestActivityCycle$1, reason: invalid class name */
    /* JADX INFO: compiled from: HonorScoreListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.honor.viewmodel.HonorScoreListViewModel$requestActivityCycle$1", f = "HonorScoreListViewModel.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $activityId;
        Object L$0;
        int label;
        final /* synthetic */ HonorScoreListViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, HonorScoreListViewModel honorScoreListViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activityId = str;
            this.this$0 = honorScoreListViewModel;
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
            Object objM444requestActivityCyclegIAlus;
            SingleLiveEvent<Result<List<HonorScoreCycleBean>>> singleLiveEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("activityId", this.$activityId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                SingleLiveEvent<Result<List<HonorScoreCycleBean>>> activityCycle = this.this$0.getActivityCycle();
                this.L$0 = activityCycle;
                this.label = 1;
                objM444requestActivityCyclegIAlus = NetworkApi.INSTANCE.m444requestActivityCyclegIAlus(requestBodyCreate, this);
                if (objM444requestActivityCyclegIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = activityCycle;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                singleLiveEvent = (SingleLiveEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM444requestActivityCyclegIAlus = ((Result) obj).getValue();
            }
            singleLiveEvent.setValue(Result.m590boximpl(objM444requestActivityCyclegIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void requestActivityCycle(String activityId) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(activityId, this, null), 3, null);
    }
}
