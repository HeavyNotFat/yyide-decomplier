package com.yd.android_brand_mvp.queue;

import android.content.Context;
import com.alibaba.fastjson.TypeReference;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.model.FaceBean;
import com.yd.android_brand_mvp.mqtt.MQTTClient;
import com.yd.android_brand_mvp.mqtt.MQTTEventBean;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yyide.facepass.FaceManager;
import com.yyide.facepass.OnFaceAddCallBack;
import com.yyide.facepass.bean.FaceAddBean;
import com.yyide.facepass.bean.ResultBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import mcv.facepass.FacePassException;

/* JADX INFO: compiled from: FaceQueueThread.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.queue.FaceQueueThread$run$1$1", f = "FaceQueueThread.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FaceQueueThread$run$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MQTTEventBean $bean;
    final /* synthetic */ Ref.ObjectRef<ResultBean> $mResultBean;
    int label;
    final /* synthetic */ FaceQueueThread this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FaceQueueThread$run$1$1(MQTTEventBean mQTTEventBean, Ref.ObjectRef<ResultBean> objectRef, FaceQueueThread faceQueueThread, Continuation<? super FaceQueueThread$run$1$1> continuation) {
        super(2, continuation);
        this.$bean = mQTTEventBean;
        this.$mResultBean = objectRef;
        this.this$0 = faceQueueThread;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FaceQueueThread$run$1$1(this.$bean, this.$mResultBean, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FaceQueueThread$run$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws FacePassException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        for (FaceBean faceBean : (List) GsonUtils.fromJson(this.$bean.getParam(), new TypeReference<List<? extends FaceBean>>() { // from class: com.yd.android_brand_mvp.queue.FaceQueueThread$run$1$1$faceList$1
        }.getType())) {
            FaceManager faceManager = FaceManager.INSTANCE;
            Context applicationContext = BaseApplication.getInstance().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getInstance().applicationContext");
            FaceAddBean faceImageInfo = faceBean.getFaceImageInfo();
            final Ref.ObjectRef<ResultBean> objectRef = this.$mResultBean;
            faceManager.addFace(applicationContext, faceImageInfo, new OnFaceAddCallBack() { // from class: com.yd.android_brand_mvp.queue.FaceQueueThread$run$1$1.1
                @Override // com.yyide.facepass.OnFaceAddCallBack
                public void onFaceAddSuccess(FaceAddBean data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                }

                /* JADX WARN: Type inference failed for: r1v0, types: [T, com.yyide.facepass.bean.ResultBean] */
                @Override // com.yyide.facepass.OnFaceAddCallBack
                public void onFaceAddFailed(String msg) {
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    objectRef.element = new ResultBean(-1, msg);
                }
            });
        }
        if (this.$mResultBean.element != null) {
            MQTTClient.INSTANCE.publishFail(this.$bean.getId(), "添加失败：" + GsonUtils.toJson(this.$mResultBean.element));
        } else {
            MQTTClient.INSTANCE.publishSuccess(this.$bean.getId(), "添加人脸成功");
        }
        this.this$0.isProcess = true;
        return Unit.INSTANCE;
    }
}
