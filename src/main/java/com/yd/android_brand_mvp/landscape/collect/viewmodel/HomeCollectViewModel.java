package com.yd.android_brand_mvp.landscape.collect.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.collect.HomeCollectBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.collect.CollectNetWork;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: HomeCollectViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rR\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/collect/viewmodel/HomeCollectViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "homeCollectList", "Landroidx/lifecycle/LiveData;", "", "Lcom/yd/android_brand_mvp/model/collect/HomeCollectBean;", "getHomeCollectList", "()Landroidx/lifecycle/LiveData;", "homeCollectListLiveData", "Landroidx/lifecycle/MutableLiveData;", "", InnerConstant.Db.size, "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomeCollectViewModel extends ViewModel {
    private final LiveData<List<HomeCollectBean>> homeCollectList;
    private final MutableLiveData<List<HomeCollectBean>> homeCollectListLiveData;

    public HomeCollectViewModel() {
        MutableLiveData<List<HomeCollectBean>> mutableLiveData = new MutableLiveData<>();
        this.homeCollectListLiveData = mutableLiveData;
        this.homeCollectList = mutableLiveData;
    }

    public final LiveData<List<HomeCollectBean>> getHomeCollectList() {
        return this.homeCollectList;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.collect.viewmodel.HomeCollectViewModel$getHomeCollectList$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomeCollectViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.collect.viewmodel.HomeCollectViewModel$getHomeCollectList$1", f = "HomeCollectViewModel.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $size;
        int label;
        final /* synthetic */ HomeCollectViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, HomeCollectViewModel homeCollectViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$size = i;
            this.this$0 = homeCollectViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$size, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM489getHomeCollectgIAlus;
            List listEmptyList;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                String schoolId = SpData.getSchoolId();
                Intrinsics.checkNotNullExpressionValue(schoolId, "getSchoolId()");
                map2.put("schoolId", schoolId);
                String classesId = SpData.getClassesId();
                Intrinsics.checkNotNullExpressionValue(classesId, "getClassesId()");
                map2.put(CommentsHomeFragment.TYPE_CLASSESID, classesId);
                map2.put("pageNo", Boxing.boxInt(1));
                map2.put("pageSize", Boxing.boxInt(this.$size));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                this.label = 1;
                objM489getHomeCollectgIAlus = CollectNetWork.INSTANCE.m489getHomeCollectgIAlus(requestBodyCreate, this);
                if (objM489getHomeCollectgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM489getHomeCollectgIAlus = ((Result) obj).getValue();
            }
            if (!Result.m598isSuccessimpl(objM489getHomeCollectgIAlus)) {
                this.this$0.homeCollectListLiveData.setValue(CollectionsKt.emptyList());
            } else {
                if (Result.m597isFailureimpl(objM489getHomeCollectgIAlus)) {
                    objM489getHomeCollectgIAlus = null;
                }
                BasePageResponse basePageResponse = (BasePageResponse) objM489getHomeCollectgIAlus;
                MutableLiveData mutableLiveData = this.this$0.homeCollectListLiveData;
                if (basePageResponse == null || (listEmptyList = (List) basePageResponse.getList()) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                mutableLiveData.setValue(listEmptyList);
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void getHomeCollectList$default(HomeCollectViewModel homeCollectViewModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 99;
        }
        homeCollectViewModel.getHomeCollectList(i);
    }

    public final void getHomeCollectList(int size) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(size, this, null), 3, null);
    }
}
