package com.yd.android_brand_mvp.activity.fragment.model;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.honor.HonorActiveBean;
import com.yd.android_brand_mvp.model.honor.HonorActiveDetailBean;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
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

/* JADX INFO: compiled from: HonorActiveListViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J&\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016R \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR,\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/model/HonorActiveListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "honorActiveDetailLiveData", "Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/honor/HonorActiveDetailBean;", "getHonorActiveDetailLiveData", "()Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "honorActiveListLiveData", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/honor/HonorActiveBean;", "getHonorActiveListLiveData", "requestActiveDetail", "", "activityId", "", "requestActiveHonorList", "schoolId", "classId", "pageSize", "", "pageNo", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorActiveListViewModel extends ViewModel {
    private final SingleLiveEvent<Result<BasePageResponse<List<HonorActiveBean>>>> honorActiveListLiveData = new SingleLiveEvent<>();
    private final SingleLiveEvent<Result<HonorActiveDetailBean>> honorActiveDetailLiveData = new SingleLiveEvent<>();

    public final SingleLiveEvent<Result<BasePageResponse<List<HonorActiveBean>>>> getHonorActiveListLiveData() {
        return this.honorActiveListLiveData;
    }

    public final SingleLiveEvent<Result<HonorActiveDetailBean>> getHonorActiveDetailLiveData() {
        return this.honorActiveDetailLiveData;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.fragment.model.HonorActiveListViewModel$requestActiveHonorList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HonorActiveListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.fragment.model.HonorActiveListViewModel$requestActiveHonorList$1", f = "HonorActiveListViewModel.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    static final class C03411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $classId;
        final /* synthetic */ int $pageNo;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ String $schoolId;
        Object L$0;
        int label;
        final /* synthetic */ HonorActiveListViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03411(String str, String str2, int i, int i2, HonorActiveListViewModel honorActiveListViewModel, Continuation<? super C03411> continuation) {
            super(2, continuation);
            this.$schoolId = str;
            this.$classId = str2;
            this.$pageNo = i;
            this.$pageSize = i2;
            this.this$0 = honorActiveListViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03411(this.$schoolId, this.$classId, this.$pageNo, this.$pageSize, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM442requestActiveHonorListgIAlus;
            SingleLiveEvent<Result<BasePageResponse<List<HonorActiveBean>>>> singleLiveEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("schoolId", this.$schoolId);
                linkedHashMap.put("classId", this.$classId);
                linkedHashMap.put("pageNo", Boxing.boxInt(this.$pageNo));
                linkedHashMap.put("pageSize", Boxing.boxInt(this.$pageSize));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                SingleLiveEvent<Result<BasePageResponse<List<HonorActiveBean>>>> honorActiveListLiveData = this.this$0.getHonorActiveListLiveData();
                this.L$0 = honorActiveListLiveData;
                this.label = 1;
                objM442requestActiveHonorListgIAlus = NetworkApi.INSTANCE.m442requestActiveHonorListgIAlus(requestBodyCreate, this);
                if (objM442requestActiveHonorListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = honorActiveListLiveData;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                singleLiveEvent = (SingleLiveEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM442requestActiveHonorListgIAlus = ((Result) obj).getValue();
            }
            singleLiveEvent.setValue(Result.m590boximpl(objM442requestActiveHonorListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void requestActiveHonorList(String schoolId, String classId, int pageSize, int pageNo) {
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(classId, "classId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03411(schoolId, classId, pageNo, pageSize, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.fragment.model.HonorActiveListViewModel$requestActiveDetail$1, reason: invalid class name */
    /* JADX INFO: compiled from: HonorActiveListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.fragment.model.HonorActiveListViewModel$requestActiveDetail$1", f = "HonorActiveListViewModel.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $activityId;
        Object L$0;
        int label;
        final /* synthetic */ HonorActiveListViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, HonorActiveListViewModel honorActiveListViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activityId = str;
            this.this$0 = honorActiveListViewModel;
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
            Object objM441requestActiveDetailgIAlus;
            SingleLiveEvent<Result<HonorActiveDetailBean>> singleLiveEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String str = this.$activityId;
                if (str == null) {
                    str = "";
                }
                linkedHashMap.put("activityId", str);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                SingleLiveEvent<Result<HonorActiveDetailBean>> honorActiveDetailLiveData = this.this$0.getHonorActiveDetailLiveData();
                this.L$0 = honorActiveDetailLiveData;
                this.label = 1;
                objM441requestActiveDetailgIAlus = NetworkApi.INSTANCE.m441requestActiveDetailgIAlus(requestBodyCreate, this);
                if (objM441requestActiveDetailgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = honorActiveDetailLiveData;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                singleLiveEvent = (SingleLiveEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM441requestActiveDetailgIAlus = ((Result) obj).getValue();
            }
            singleLiveEvent.setValue(Result.m590boximpl(objM441requestActiveDetailgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void requestActiveDetail(String activityId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(activityId, this, null), 3, null);
    }
}
