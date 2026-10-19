package com.yd.android_brand_mvp.landscape.cctv;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.LayoutListRsp;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: CCTVViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rR\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/cctv/CCTVViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "layoutModelLiveData", "Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/LayoutListRsp$DataBean$LayoutClassSignDetailsEntityListBean;", "mLiveData", "getMLiveData", "()Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "requestRTSPPath", "", "officeModuleId", "", "brandId", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CCTVViewModel extends ViewModel {
    private final SingleLiveEvent<Result<LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean>> layoutModelLiveData;
    private final SingleLiveEvent<Result<LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean>> mLiveData;

    public CCTVViewModel() {
        SingleLiveEvent<Result<LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean>> singleLiveEvent = new SingleLiveEvent<>();
        this.layoutModelLiveData = singleLiveEvent;
        this.mLiveData = singleLiveEvent;
    }

    public final SingleLiveEvent<Result<LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean>> getMLiveData() {
        return this.mLiveData;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.cctv.CCTVViewModel$requestRTSPPath$1, reason: invalid class name */
    /* JADX INFO: compiled from: CCTVViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.cctv.CCTVViewModel$requestRTSPPath$1", f = "CCTVViewModel.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $brandId;
        final /* synthetic */ String $officeModuleId;
        Object L$0;
        int label;
        final /* synthetic */ CCTVViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, CCTVViewModel cCTVViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$officeModuleId = str;
            this.$brandId = str2;
            this.this$0 = cCTVViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$officeModuleId, this.$brandId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM465requestRTSPPathgIAlus;
            SingleLiveEvent singleLiveEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("officeModuleId", this.$officeModuleId);
                linkedHashMap.put("brandId", this.$brandId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                SingleLiveEvent singleLiveEvent2 = this.this$0.layoutModelLiveData;
                this.L$0 = singleLiveEvent2;
                this.label = 1;
                objM465requestRTSPPathgIAlus = NetworkApi.INSTANCE.m465requestRTSPPathgIAlus(requestBodyCreate, this);
                if (objM465requestRTSPPathgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = singleLiveEvent2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                singleLiveEvent = (SingleLiveEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM465requestRTSPPathgIAlus = ((Result) obj).getValue();
            }
            singleLiveEvent.setValue(Result.m590boximpl(objM465requestRTSPPathgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void requestRTSPPath(String officeModuleId, String brandId) {
        Intrinsics.checkNotNullParameter(officeModuleId, "officeModuleId");
        Intrinsics.checkNotNullParameter(brandId, "brandId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(officeModuleId, brandId, this, null), 3, null);
    }
}
