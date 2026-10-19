package com.yd.android_brand_mvp.verfity.fragment;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.model.ScanQrCodeBean;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
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

/* JADX INFO: compiled from: ScanCodeLoginViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000eR \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/verfity/fragment/ScanCodeLoginViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "qrCodeCheckLiveData", "Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/ScanQrCodeBean;", "getQrCodeCheckLiveData", "()Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "qrCodeLiveData", "getQrCodeLiveData", "requestQrCode", "", "type", "", "schoolId", "requestQrCodeCheck", "random", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScanCodeLoginViewModel extends ViewModel {
    private final SingleLiveEvent<Result<ScanQrCodeBean>> qrCodeLiveData = new SingleLiveEvent<>();
    private final SingleLiveEvent<Result<ScanQrCodeBean>> qrCodeCheckLiveData = new SingleLiveEvent<>();

    public final SingleLiveEvent<Result<ScanQrCodeBean>> getQrCodeLiveData() {
        return this.qrCodeLiveData;
    }

    public final SingleLiveEvent<Result<ScanQrCodeBean>> getQrCodeCheckLiveData() {
        return this.qrCodeCheckLiveData;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.verfity.fragment.ScanCodeLoginViewModel$requestQrCode$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScanCodeLoginViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.verfity.fragment.ScanCodeLoginViewModel$requestQrCode$1", f = "ScanCodeLoginViewModel.kt", i = {}, l = {17}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $schoolId;
        final /* synthetic */ String $type;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$type = str;
            this.$schoolId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ScanCodeLoginViewModel.this.new AnonymousClass1(this.$type, this.$schoolId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SingleLiveEvent<Result<ScanQrCodeBean>> singleLiveEvent;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SingleLiveEvent<Result<ScanQrCodeBean>> qrCodeLiveData = ScanCodeLoginViewModel.this.getQrCodeLiveData();
                this.L$0 = qrCodeLiveData;
                this.label = 1;
                Object objM463requestQrCode0E7RQCE = NetworkApi.INSTANCE.m463requestQrCode0E7RQCE(this.$type, this.$schoolId, this);
                if (objM463requestQrCode0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = qrCodeLiveData;
                value = objM463requestQrCode0E7RQCE;
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

    public final void requestQrCode(String type, String schoolId) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(type, schoolId, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.verfity.fragment.ScanCodeLoginViewModel$requestQrCodeCheck$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScanCodeLoginViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.verfity.fragment.ScanCodeLoginViewModel$requestQrCodeCheck$1", f = "ScanCodeLoginViewModel.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
    static final class C05711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $random;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05711(String str, Continuation<? super C05711> continuation) {
            super(2, continuation);
            this.$random = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ScanCodeLoginViewModel.this.new C05711(this.$random, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SingleLiveEvent<Result<ScanQrCodeBean>> singleLiveEvent;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SingleLiveEvent<Result<ScanQrCodeBean>> qrCodeCheckLiveData = ScanCodeLoginViewModel.this.getQrCodeCheckLiveData();
                this.L$0 = qrCodeCheckLiveData;
                this.label = 1;
                Object objM464requestQrCodeCheckgIAlus = NetworkApi.INSTANCE.m464requestQrCodeCheckgIAlus(this.$random, this);
                if (objM464requestQrCodeCheckgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = qrCodeCheckLiveData;
                value = objM464requestQrCodeCheckgIAlus;
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

    public final void requestQrCodeCheck(String random) {
        Intrinsics.checkNotNullParameter(random, "random");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05711(random, null), 3, null);
    }
}
