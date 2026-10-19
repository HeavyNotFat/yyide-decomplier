package com.yd.android_brand_mvp.portrait.fragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.model.getUserSigByUserIdRsp;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.utils.SpData;
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

/* JADX INFO: compiled from: UserCenterFragmentViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rR-\u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0006R\u00020\u00070\u00050\u0004X\u0086\u000eø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/portrait/fragment/UserCenterFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "userSigLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/getUserSigByUserIdRsp$DataBean;", "Lcom/yd/android_brand_mvp/model/getUserSigByUserIdRsp;", "getUserSigLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setUserSigLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "getUserSig", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UserCenterFragmentViewModel extends ViewModel {
    private MutableLiveData<Result<getUserSigByUserIdRsp.DataBean>> userSigLiveData = new MutableLiveData<>();

    public final MutableLiveData<Result<getUserSigByUserIdRsp.DataBean>> getUserSigLiveData() {
        return this.userSigLiveData;
    }

    public final void setUserSigLiveData(MutableLiveData<Result<getUserSigByUserIdRsp.DataBean>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.userSigLiveData = mutableLiveData;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.portrait.fragment.UserCenterFragmentViewModel$getUserSig$1, reason: invalid class name */
    /* JADX INFO: compiled from: UserCenterFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.portrait.fragment.UserCenterFragmentViewModel$getUserSig$1", f = "UserCenterFragmentViewModel.kt", i = {}, l = {16}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UserCenterFragmentViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData<Result<getUserSigByUserIdRsp.DataBean>> mutableLiveData;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData<Result<getUserSigByUserIdRsp.DataBean>> userSigLiveData = UserCenterFragmentViewModel.this.getUserSigLiveData();
                NetworkApi networkApi = NetworkApi.INSTANCE;
                String str = SpData.USERCENTINFO2().data.id;
                Intrinsics.checkNotNullExpressionValue(str, "USERCENTINFO2().data.id");
                this.L$0 = userSigLiveData;
                this.label = 1;
                Object objM435getUserSiggIAlus = networkApi.m435getUserSiggIAlus(str, this);
                if (objM435getUserSiggIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = userSigLiveData;
                value = objM435getUserSiggIAlus;
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

    public final void getUserSig() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }
}
