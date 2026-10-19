package com.yd.android_brand_mvp.landscape.customized.tianjin;

import com.tencent.mmkv.MMKV;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.model.MessageCaptionBean;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: CustomHomeFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.landscape.customized.tianjin.CustomHomeFragment$setNoticeData$1$1", f = "CustomHomeFragment.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
final class CustomHomeFragment$setNoticeData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MessageCaptionBean $rollTextBean;
    int label;
    final /* synthetic */ CustomHomeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CustomHomeFragment$setNoticeData$1$1(MessageCaptionBean messageCaptionBean, CustomHomeFragment customHomeFragment, Continuation<? super CustomHomeFragment$setNoticeData$1$1> continuation) {
        super(2, continuation);
        this.$rollTextBean = messageCaptionBean;
        this.this$0 = customHomeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CustomHomeFragment$setNoticeData$1$1(this.$rollTextBean, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CustomHomeFragment$setNoticeData$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay((int) (((long) this.$rollTextBean.getIntervalTime()) * 1000), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$rollTextBean.setPlaySuccess(true);
        this.this$0.getBinding().tvNotice.setPauseScroll(true);
        MMKV.defaultMMKV().putString(MMKVConstant.HOME_MARQUEE_TEXT, GsonUtils.toJson(this.$rollTextBean));
        return Unit.INSTANCE;
    }
}
