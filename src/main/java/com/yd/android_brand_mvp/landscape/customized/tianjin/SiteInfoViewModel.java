package com.yd.android_brand_mvp.landscape.customized.tianjin;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.customized.CustomSensorBean;
import com.yd.android_brand_mvp.model.customized.CustomSiteInfoBean;
import com.yd.android_brand_mvp.network.customized.CustomizedNetWork;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.HashMap;
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

/* JADX INFO: compiled from: SiteInfoViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\f\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012R \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/customized/tianjin/SiteInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "customSensor", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/customized/CustomSensorBean;", "getCustomSensor", "()Landroidx/lifecycle/MutableLiveData;", "customSensorLiveData", "customSiteInfo", "Lcom/yd/android_brand_mvp/model/customized/CustomSiteInfoBean;", "getCustomSiteInfo", "customSiteInfoLiveData", "customWarning", "getCustomWarning", "customWarningLiveData", "getCustomSensorList", "", "getCustomWarningList", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SiteInfoViewModel extends ViewModel {
    private final MutableLiveData<Result<CustomSensorBean>> customSensor;
    private final MutableLiveData<Result<CustomSensorBean>> customSensorLiveData;
    private final MutableLiveData<Result<CustomSiteInfoBean>> customSiteInfo;
    private final MutableLiveData<Result<CustomSiteInfoBean>> customSiteInfoLiveData;
    private final MutableLiveData<Result<CustomSiteInfoBean>> customWarning;
    private final MutableLiveData<Result<CustomSiteInfoBean>> customWarningLiveData;

    public SiteInfoViewModel() {
        MutableLiveData<Result<CustomSiteInfoBean>> mutableLiveData = new MutableLiveData<>();
        this.customSiteInfoLiveData = mutableLiveData;
        this.customSiteInfo = mutableLiveData;
        MutableLiveData<Result<CustomSiteInfoBean>> mutableLiveData2 = new MutableLiveData<>();
        this.customWarningLiveData = mutableLiveData2;
        this.customWarning = mutableLiveData2;
        MutableLiveData<Result<CustomSensorBean>> mutableLiveData3 = new MutableLiveData<>();
        this.customSensorLiveData = mutableLiveData3;
        this.customSensor = mutableLiveData3;
    }

    public final MutableLiveData<Result<CustomSiteInfoBean>> getCustomSiteInfo() {
        return this.customSiteInfo;
    }

    public final MutableLiveData<Result<CustomSiteInfoBean>> getCustomWarning() {
        return this.customWarning;
    }

    public final MutableLiveData<Result<CustomSensorBean>> getCustomSensor() {
        return this.customSensor;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.customized.tianjin.SiteInfoViewModel$getCustomSiteInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SiteInfoViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.customized.tianjin.SiteInfoViewModel$getCustomSiteInfo$1", f = "SiteInfoViewModel.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
    static final class C04341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C04341(Continuation<? super C04341> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SiteInfoViewModel.this.new C04341(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM494requestSiteInfogIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                String siteId = SpData.getSiteId();
                Intrinsics.checkNotNullExpressionValue(siteId, "getSiteId()");
                map.put("siteId", siteId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = SiteInfoViewModel.this.customSiteInfoLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM494requestSiteInfogIAlus = CustomizedNetWork.INSTANCE.m494requestSiteInfogIAlus(requestBodyCreate, this);
                if (objM494requestSiteInfogIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM494requestSiteInfogIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM494requestSiteInfogIAlus));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: getCustomSiteInfo, reason: collision with other method in class */
    public final void m319getCustomSiteInfo() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04341(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.customized.tianjin.SiteInfoViewModel$getCustomWarningList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SiteInfoViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.customized.tianjin.SiteInfoViewModel$getCustomWarningList$1", f = "SiteInfoViewModel.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    static final class C04351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C04351(Continuation<? super C04351> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SiteInfoViewModel.this.new C04351(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM495requestWarningInfoListgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                String siteId = SpData.getSiteId();
                Intrinsics.checkNotNullExpressionValue(siteId, "getSiteId()");
                map.put("siteId", siteId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = SiteInfoViewModel.this.customWarningLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM495requestWarningInfoListgIAlus = CustomizedNetWork.INSTANCE.m495requestWarningInfoListgIAlus(requestBodyCreate, this);
                if (objM495requestWarningInfoListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM495requestWarningInfoListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM495requestWarningInfoListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getCustomWarningList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04351(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.customized.tianjin.SiteInfoViewModel$getCustomSensorList$1, reason: invalid class name */
    /* JADX INFO: compiled from: SiteInfoViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.customized.tianjin.SiteInfoViewModel$getCustomSensorList$1", f = "SiteInfoViewModel.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SiteInfoViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM493requestSensorInfoListgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                String siteId = SpData.getSiteId();
                Intrinsics.checkNotNullExpressionValue(siteId, "getSiteId()");
                map.put("siteId", siteId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = SiteInfoViewModel.this.customSensorLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM493requestSensorInfoListgIAlus = CustomizedNetWork.INSTANCE.m493requestSensorInfoListgIAlus(requestBodyCreate, this);
                if (objM493requestSensorInfoListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM493requestSensorInfoListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM493requestSensorInfoListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getCustomSensorList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }
}
