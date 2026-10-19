package com.yd.android_brand_mvp.landscape.areover;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.ClassesOverInfoBean;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
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

/* JADX INFO: compiled from: ClassesOverViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/areover/ClassesOverViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "classesOverInfoBeanLiveData", "Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/ClassesOverInfoBean;", "infoLiveData", "getInfoLiveData", "()Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "overSchool", "", "getOverSchool", "overSchoolLiveData", "requestClassesOverInfo", "", "requestOver", "optId", "", "optName", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClassesOverViewModel extends ViewModel {
    private final SingleLiveEvent<Result<ClassesOverInfoBean>> classesOverInfoBeanLiveData;
    private final SingleLiveEvent<Result<ClassesOverInfoBean>> infoLiveData;
    private final SingleLiveEvent<Result<Boolean>> overSchool;
    private final SingleLiveEvent<Result<Boolean>> overSchoolLiveData;

    public ClassesOverViewModel() {
        SingleLiveEvent<Result<ClassesOverInfoBean>> singleLiveEvent = new SingleLiveEvent<>();
        this.classesOverInfoBeanLiveData = singleLiveEvent;
        this.infoLiveData = singleLiveEvent;
        SingleLiveEvent<Result<Boolean>> singleLiveEvent2 = new SingleLiveEvent<>();
        this.overSchoolLiveData = singleLiveEvent2;
        this.overSchool = singleLiveEvent2;
    }

    public final SingleLiveEvent<Result<ClassesOverInfoBean>> getInfoLiveData() {
        return this.infoLiveData;
    }

    public final SingleLiveEvent<Result<Boolean>> getOverSchool() {
        return this.overSchool;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.areover.ClassesOverViewModel$requestClassesOverInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: ClassesOverViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.areover.ClassesOverViewModel$requestClassesOverInfo$1", f = "ClassesOverViewModel.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClassesOverViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SingleLiveEvent singleLiveEvent;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SingleLiveEvent singleLiveEvent2 = ClassesOverViewModel.this.classesOverInfoBeanLiveData;
                this.L$0 = singleLiveEvent2;
                this.label = 1;
                Object objM419classesOverInfoIoAF18A = NetworkApi.INSTANCE.m419classesOverInfoIoAF18A(this);
                if (objM419classesOverInfoIoAF18A == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = singleLiveEvent2;
                value = objM419classesOverInfoIoAF18A;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                singleLiveEvent = (SingleLiveEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                value = ((Result) obj).getValue();
            }
            singleLiveEvent.setValue(Result.m590boximpl(value));
            return Unit.INSTANCE;
        }
    }

    public final void requestClassesOverInfo() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.areover.ClassesOverViewModel$requestOver$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ClassesOverViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.areover.ClassesOverViewModel$requestOver$1", f = "ClassesOverViewModel.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    static final class C03991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $optId;
        final /* synthetic */ String $optName;
        Object L$0;
        int label;
        final /* synthetic */ ClassesOverViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03991(String str, String str2, ClassesOverViewModel classesOverViewModel, Continuation<? super C03991> continuation) {
            super(2, continuation);
            this.$optId = str;
            this.$optName = str2;
            this.this$0 = classesOverViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03991(this.$optId, this.$optName, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03991) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM439oneKeySchoolgIAlus;
            SingleLiveEvent singleLiveEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("optId", this.$optId);
                map2.put("optName", this.$optName);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                SingleLiveEvent singleLiveEvent2 = this.this$0.overSchoolLiveData;
                this.L$0 = singleLiveEvent2;
                this.label = 1;
                objM439oneKeySchoolgIAlus = NetworkApi.INSTANCE.m439oneKeySchoolgIAlus(requestBodyCreate, this);
                if (objM439oneKeySchoolgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = singleLiveEvent2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                singleLiveEvent = (SingleLiveEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM439oneKeySchoolgIAlus = ((Result) obj).getValue();
            }
            singleLiveEvent.setValue(Result.m590boximpl(objM439oneKeySchoolgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void requestOver(String optId, String optName) {
        Intrinsics.checkNotNullParameter(optId, "optId");
        Intrinsics.checkNotNullParameter(optName, "optName");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03991(optId, optName, this, null), 3, null);
    }
}
