package com.yd.android_brand_mvp.landscape.message.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.model.MessageListBean;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MessageHomeViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/viewmodel/MessageHomeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "messageHomeLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/MessageListBean;", "getMessageHomeLiveData", "()Landroidx/lifecycle/MutableLiveData;", "requestMessageHome", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageHomeViewModel extends ViewModel {
    private final MutableLiveData<Result<MessageListBean>> messageHomeLiveData = new MutableLiveData<>();

    public final MutableLiveData<Result<MessageListBean>> getMessageHomeLiveData() {
        return this.messageHomeLiveData;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.message.viewmodel.MessageHomeViewModel$requestMessageHome$1, reason: invalid class name */
    /* JADX INFO: compiled from: MessageHomeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.message.viewmodel.MessageHomeViewModel$requestMessageHome$1", f = "MessageHomeViewModel.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MessageHomeViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData<Result<MessageListBean>> mutableLiveData;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData<Result<MessageListBean>> messageHomeLiveData = MessageHomeViewModel.this.getMessageHomeLiveData();
                this.L$0 = messageHomeLiveData;
                this.label = 1;
                Object objM461requestMessageHomeIoAF18A = NetworkApi.INSTANCE.m461requestMessageHomeIoAF18A(this);
                if (objM461requestMessageHomeIoAF18A == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = messageHomeLiveData;
                value = objM461requestMessageHomeIoAF18A;
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

    public final void requestMessageHome() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }
}
