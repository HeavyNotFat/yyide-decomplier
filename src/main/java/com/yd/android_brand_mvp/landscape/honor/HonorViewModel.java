package com.yd.android_brand_mvp.landscape.honor;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.honor.HonorClassBean;
import com.yd.android_brand_mvp.model.honor.HonorStudentBean;
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

/* JADX INFO: compiled from: HonorViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u001e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013R,\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR,\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/honor/HonorViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "honorClassListLiveData", "Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/honor/HonorClassBean;", "getHonorClassListLiveData", "()Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "honorStudentListLiveData", "Lcom/yd/android_brand_mvp/model/honor/HonorStudentBean;", "getHonorStudentListLiveData", "requestHonorClassList", "", "classId", "", "pageSize", "", "pageNo", "requestStudentHonorList", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorViewModel extends ViewModel {
    private final SingleLiveEvent<Result<BasePageResponse<List<HonorClassBean>>>> honorClassListLiveData = new SingleLiveEvent<>();
    private final SingleLiveEvent<Result<BasePageResponse<List<HonorStudentBean>>>> honorStudentListLiveData = new SingleLiveEvent<>();

    public final SingleLiveEvent<Result<BasePageResponse<List<HonorClassBean>>>> getHonorClassListLiveData() {
        return this.honorClassListLiveData;
    }

    public final SingleLiveEvent<Result<BasePageResponse<List<HonorStudentBean>>>> getHonorStudentListLiveData() {
        return this.honorStudentListLiveData;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.honor.HonorViewModel$requestHonorClassList$1, reason: invalid class name */
    /* JADX INFO: compiled from: HonorViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.honor.HonorViewModel$requestHonorClassList$1", f = "HonorViewModel.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $classId;
        final /* synthetic */ int $pageNo;
        final /* synthetic */ int $pageSize;
        Object L$0;
        int label;
        final /* synthetic */ HonorViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, int i, int i2, HonorViewModel honorViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$classId = str;
            this.$pageNo = i;
            this.$pageSize = i2;
            this.this$0 = honorViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$classId, this.$pageNo, this.$pageSize, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM447requestClassHonorListgIAlus;
            SingleLiveEvent<Result<BasePageResponse<List<HonorClassBean>>>> singleLiveEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("classId", this.$classId);
                linkedHashMap.put("pageNo", Boxing.boxInt(this.$pageNo));
                linkedHashMap.put("pageSize", Boxing.boxInt(this.$pageSize));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                SingleLiveEvent<Result<BasePageResponse<List<HonorClassBean>>>> honorClassListLiveData = this.this$0.getHonorClassListLiveData();
                this.L$0 = honorClassListLiveData;
                this.label = 1;
                objM447requestClassHonorListgIAlus = NetworkApi.INSTANCE.m447requestClassHonorListgIAlus(requestBodyCreate, this);
                if (objM447requestClassHonorListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = honorClassListLiveData;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                singleLiveEvent = (SingleLiveEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM447requestClassHonorListgIAlus = ((Result) obj).getValue();
            }
            singleLiveEvent.setValue(Result.m590boximpl(objM447requestClassHonorListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void requestHonorClassList(String classId, int pageSize, int pageNo) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(classId, pageNo, pageSize, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.honor.HonorViewModel$requestStudentHonorList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HonorViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.honor.HonorViewModel$requestStudentHonorList$1", f = "HonorViewModel.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
    static final class C04751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $classId;
        final /* synthetic */ int $pageNo;
        final /* synthetic */ int $pageSize;
        Object L$0;
        int label;
        final /* synthetic */ HonorViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04751(String str, int i, int i2, HonorViewModel honorViewModel, Continuation<? super C04751> continuation) {
            super(2, continuation);
            this.$classId = str;
            this.$pageNo = i;
            this.$pageSize = i2;
            this.this$0 = honorViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04751(this.$classId, this.$pageNo, this.$pageSize, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM468requestStudentHonorListgIAlus;
            SingleLiveEvent<Result<BasePageResponse<List<HonorStudentBean>>>> singleLiveEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("classId", this.$classId);
                linkedHashMap.put("pageNo", Boxing.boxInt(this.$pageNo));
                linkedHashMap.put("pageSize", Boxing.boxInt(this.$pageSize));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                SingleLiveEvent<Result<BasePageResponse<List<HonorStudentBean>>>> honorStudentListLiveData = this.this$0.getHonorStudentListLiveData();
                this.L$0 = honorStudentListLiveData;
                this.label = 1;
                objM468requestStudentHonorListgIAlus = NetworkApi.INSTANCE.m468requestStudentHonorListgIAlus(requestBodyCreate, this);
                if (objM468requestStudentHonorListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = honorStudentListLiveData;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                singleLiveEvent = (SingleLiveEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM468requestStudentHonorListgIAlus = ((Result) obj).getValue();
            }
            singleLiveEvent.setValue(Result.m590boximpl(objM468requestStudentHonorListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void requestStudentHonorList(String classId, int pageSize, int pageNo) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04751(classId, pageNo, pageSize, this, null), 3, null);
    }
}
