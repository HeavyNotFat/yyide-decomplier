package com.yd.android_brand_mvp.activity.home.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.model.LoginQrCodeBean;
import com.yd.android_brand_mvp.network.NetworkApi;
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

/* JADX INFO: compiled from: LoginViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u000eR\u0019\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/activity/home/viewmodel/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "checkLoginLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/yd/android_brand_mvp/model/LoginQrCodeBean;", "getCheckLoginLiveData", "()Landroidx/lifecycle/LiveData;", "mCheckLoginLiveData", "Landroidx/lifecycle/MutableLiveData;", "mQrCodeLiveData", "qrCodeLiveData", "getQrCodeLiveData", "getCheckLoginQrCode", "", "random", "", "getLoginQrCode", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LoginViewModel extends ViewModel {
    private final LiveData<LoginQrCodeBean> checkLoginLiveData;
    private final MutableLiveData<LoginQrCodeBean> mCheckLoginLiveData;
    private final MutableLiveData<LoginQrCodeBean> mQrCodeLiveData;
    private final LiveData<LoginQrCodeBean> qrCodeLiveData;

    public LoginViewModel() {
        MutableLiveData<LoginQrCodeBean> mutableLiveData = new MutableLiveData<>();
        this.mQrCodeLiveData = mutableLiveData;
        this.qrCodeLiveData = mutableLiveData;
        MutableLiveData<LoginQrCodeBean> mutableLiveData2 = new MutableLiveData<>();
        this.mCheckLoginLiveData = mutableLiveData2;
        this.checkLoginLiveData = mutableLiveData2;
    }

    public final LiveData<LoginQrCodeBean> getQrCodeLiveData() {
        return this.qrCodeLiveData;
    }

    public final LiveData<LoginQrCodeBean> getCheckLoginLiveData() {
        return this.checkLoginLiveData;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.home.viewmodel.LoginViewModel$getLoginQrCode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoginViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.LoginViewModel$getLoginQrCode$1", f = "LoginViewModel.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
    static final class C03551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03551(Continuation<? super C03551> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LoginViewModel.this.new C03551(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM433getLoginQrCodegIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                objM433getLoginQrCodegIAlus = NetworkApi.INSTANCE.m433getLoginQrCodegIAlus("4", this);
                if (objM433getLoginQrCodegIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM433getLoginQrCodegIAlus = ((Result) obj).getValue();
            }
            MutableLiveData mutableLiveData = LoginViewModel.this.mQrCodeLiveData;
            if (Result.m597isFailureimpl(objM433getLoginQrCodegIAlus)) {
                objM433getLoginQrCodegIAlus = null;
            }
            mutableLiveData.setValue(objM433getLoginQrCodegIAlus);
            return Unit.INSTANCE;
        }
    }

    public final void getLoginQrCode() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03551(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.home.viewmodel.LoginViewModel$getCheckLoginQrCode$1, reason: invalid class name */
    /* JADX INFO: compiled from: LoginViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.LoginViewModel$getCheckLoginQrCode$1", f = "LoginViewModel.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $random;
        int label;
        final /* synthetic */ LoginViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, LoginViewModel loginViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$random = str;
            this.this$0 = loginViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$random, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM423getCheckLoginQrCodegIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                objM423getCheckLoginQrCodegIAlus = NetworkApi.INSTANCE.m423getCheckLoginQrCodegIAlus(this.$random, this);
                if (objM423getCheckLoginQrCodegIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM423getCheckLoginQrCodegIAlus = ((Result) obj).getValue();
            }
            MutableLiveData mutableLiveData = this.this$0.mCheckLoginLiveData;
            if (Result.m597isFailureimpl(objM423getCheckLoginQrCodegIAlus)) {
                objM423getCheckLoginQrCodegIAlus = null;
            }
            mutableLiveData.setValue(objM423getCheckLoginQrCodegIAlus);
            return Unit.INSTANCE;
        }
    }

    public final void getCheckLoginQrCode(String random) {
        Intrinsics.checkNotNullParameter(random, "random");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(random, this, null), 3, null);
    }
}
