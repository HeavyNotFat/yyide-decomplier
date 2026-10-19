package com.yd.android_brand_mvp.activity.patrol.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.SiteInfoBean;
import com.yd.android_brand_mvp.model.patrol.PatrolListBean;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.patrol.PatrolNetWork;
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

/* JADX INFO: compiled from: PatrolListViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\t\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016J\u000e\u0010\u000f\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013R,\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR)\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u00050\fX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\fX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/activity/patrol/viewmodel/PatrolListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "patrolList", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/patrol/PatrolListBean;", "getPatrolList", "()Landroidx/lifecycle/LiveData;", "patrolListLiveData", "Landroidx/lifecycle/MutableLiveData;", "siteInfo", "Lcom/yd/android_brand_mvp/model/SiteInfoBean;", "getSiteInfo", "siteInfoLiveData", "", "userId", "", "siteId", "status", "", "patrolType", "pageNo", "pageSize", "id", "updatePatrolPunch", "businessId", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PatrolListViewModel extends ViewModel {
    private final LiveData<Result<BasePageResponse<List<PatrolListBean>>>> patrolList;
    private final MutableLiveData<Result<BasePageResponse<List<PatrolListBean>>>> patrolListLiveData;
    private final LiveData<Result<SiteInfoBean>> siteInfo;
    private final MutableLiveData<Result<SiteInfoBean>> siteInfoLiveData;

    public PatrolListViewModel() {
        MutableLiveData<Result<SiteInfoBean>> mutableLiveData = new MutableLiveData<>();
        this.siteInfoLiveData = mutableLiveData;
        this.siteInfo = mutableLiveData;
        MutableLiveData<Result<BasePageResponse<List<PatrolListBean>>>> mutableLiveData2 = new MutableLiveData<>();
        this.patrolListLiveData = mutableLiveData2;
        this.patrolList = mutableLiveData2;
    }

    public final LiveData<Result<SiteInfoBean>> getSiteInfo() {
        return this.siteInfo;
    }

    public final LiveData<Result<BasePageResponse<List<PatrolListBean>>>> getPatrolList() {
        return this.patrolList;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.patrol.viewmodel.PatrolListViewModel$getSiteInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PatrolListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.patrol.viewmodel.PatrolListViewModel$getSiteInfo$1", f = "PatrolListViewModel.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
    static final class C03631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03631(String str, Continuation<? super C03631> continuation) {
            super(2, continuation);
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PatrolListViewModel.this.new C03631(this.$id, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData2 = PatrolListViewModel.this.siteInfoLiveData;
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
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03631(id, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.patrol.viewmodel.PatrolListViewModel$getPatrolList$1, reason: invalid class name */
    /* JADX INFO: compiled from: PatrolListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.patrol.viewmodel.PatrolListViewModel$getPatrolList$1", f = "PatrolListViewModel.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $pageNo;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ int $patrolType;
        final /* synthetic */ String $siteId;
        final /* synthetic */ int $status;
        final /* synthetic */ String $userId;
        Object L$0;
        int label;
        final /* synthetic */ PatrolListViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, int i, int i2, int i3, int i4, PatrolListViewModel patrolListViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$userId = str;
            this.$siteId = str2;
            this.$status = i;
            this.$patrolType = i2;
            this.$pageNo = i3;
            this.$pageSize = i4;
            this.this$0 = patrolListViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$userId, this.$siteId, this.$status, this.$patrolType, this.$pageNo, this.$pageSize, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM521getPatrolListgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("userId", this.$userId);
                map2.put("siteId", this.$siteId);
                map2.put("status", Boxing.boxInt(this.$status));
                map2.put("patrolType", Boxing.boxInt(this.$patrolType));
                map2.put("pageNo", Boxing.boxInt(this.$pageNo));
                map2.put("pageSize", Boxing.boxInt(this.$pageSize));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.patrolListLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM521getPatrolListgIAlus = PatrolNetWork.INSTANCE.m521getPatrolListgIAlus(requestBodyCreate, this);
                if (objM521getPatrolListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM521getPatrolListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM521getPatrolListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getPatrolList(String userId, String siteId, int status, int patrolType, int pageNo, int pageSize) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(userId, siteId, status, patrolType, pageNo, pageSize, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.patrol.viewmodel.PatrolListViewModel$updatePatrolPunch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PatrolListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.patrol.viewmodel.PatrolListViewModel$updatePatrolPunch$1", f = "PatrolListViewModel.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    static final class C03641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $businessId;
        final /* synthetic */ String $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03641(String str, String str2, Continuation<? super C03641> continuation) {
            super(2, continuation);
            this.$userId = str;
            this.$businessId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03641(this.$userId, this.$businessId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03641) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("userId", this.$userId);
                map2.put("businessId", this.$businessId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                this.label = 1;
                if (PatrolNetWork.INSTANCE.m525updatePatrolPunchgIAlus(requestBodyCreate, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ((Result) obj).getValue();
            }
            return Unit.INSTANCE;
        }
    }

    public final void updatePatrolPunch(String userId, String businessId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03641(userId, businessId, null), 3, null);
    }
}
