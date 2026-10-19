package com.yd.android_brand_mvp.activity.collect.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.room.RoomDatabase;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.collect.CollectListBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.collect.CollectNetWork;
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

/* JADX INFO: compiled from: CollectFormListViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u000bR\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/viewmodel/CollectFormListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "formList", "Landroidx/lifecycle/LiveData;", "", "Lcom/yd/android_brand_mvp/model/collect/CollectListBean;", "getFormList", "()Landroidx/lifecycle/LiveData;", "formListLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CollectFormListViewModel extends ViewModel {
    private final LiveData<List<CollectListBean>> formList;
    private final MutableLiveData<List<CollectListBean>> formListLiveData;

    public CollectFormListViewModel() {
        MutableLiveData<List<CollectListBean>> mutableLiveData = new MutableLiveData<>();
        this.formListLiveData = mutableLiveData;
        this.formList = mutableLiveData;
    }

    public final LiveData<List<CollectListBean>> getFormList() {
        return this.formList;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.viewmodel.CollectFormListViewModel$getFormList$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollectFormListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.collect.viewmodel.CollectFormListViewModel$getFormList$1", f = "CollectFormListViewModel.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CollectFormListViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM486getCollectListgIAlus;
            List listEmptyList;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("pageNo", Boxing.boxInt(1));
                map2.put("pageSize", Boxing.boxInt(RoomDatabase.MAX_BIND_PARAMETER_CNT));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                this.label = 1;
                objM486getCollectListgIAlus = CollectNetWork.INSTANCE.m486getCollectListgIAlus(requestBodyCreate, this);
                if (objM486getCollectListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM486getCollectListgIAlus = ((Result) obj).getValue();
            }
            if (!Result.m598isSuccessimpl(objM486getCollectListgIAlus)) {
                CollectFormListViewModel.this.formListLiveData.setValue(CollectionsKt.emptyList());
            } else {
                if (Result.m597isFailureimpl(objM486getCollectListgIAlus)) {
                    objM486getCollectListgIAlus = null;
                }
                BasePageResponse basePageResponse = (BasePageResponse) objM486getCollectListgIAlus;
                MutableLiveData mutableLiveData = CollectFormListViewModel.this.formListLiveData;
                if (basePageResponse == null || (listEmptyList = (List) basePageResponse.getList()) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                mutableLiveData.setValue(listEmptyList);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: getFormList, reason: collision with other method in class */
    public final void m201getFormList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }
}
