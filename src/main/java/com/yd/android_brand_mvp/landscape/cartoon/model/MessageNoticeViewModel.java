package com.yd.android_brand_mvp.landscape.cartoon.model;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.model.getNoticeRsp;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import com.yd.android_brand_mvp.utils.SpData;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: MessageNoticeViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/cartoon/model/MessageNoticeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "noticeLiveData", "Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/getNoticeRsp$DataDTO;", "getNoticeLiveData", "()Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "getAnnouncement", "", "showType", "", "pageNo", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageNoticeViewModel extends ViewModel {
    private final SingleLiveEvent<Result<getNoticeRsp.DataDTO>> noticeLiveData = new SingleLiveEvent<>();

    public final SingleLiveEvent<Result<getNoticeRsp.DataDTO>> getNoticeLiveData() {
        return this.noticeLiveData;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.cartoon.model.MessageNoticeViewModel$getAnnouncement$1, reason: invalid class name */
    /* JADX INFO: compiled from: MessageNoticeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.cartoon.model.MessageNoticeViewModel$getAnnouncement$1", f = "MessageNoticeViewModel.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $pageNo;
        final /* synthetic */ String $showType;
        int label;
        final /* synthetic */ MessageNoticeViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, String str, MessageNoticeViewModel messageNoticeViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$pageNo = i;
            this.$showType = str;
            this.this$0 = messageNoticeViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$pageNo, this.$showType, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM460requestMessagegIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.add(5, -7);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(new Date());
                calendar2.add(5, 0);
                String str = simpleDateFormat.format(calendar.getTime()) + " 00:00:00";
                String str2 = simpleDateFormat2.format(calendar2.getTime()) + " 23:59:59";
                HashMap map = new HashMap();
                map.put("pageSize", "18");
                map.put("pageNo", Boxing.boxInt(this.$pageNo));
                String brandId = SpData.getBrandId();
                Intrinsics.checkNotNullExpressionValue(brandId, "getBrandId()");
                map.put("approverId", brandId);
                map.put("identifier", this.$showType);
                map.put("startTime", str);
                map.put("endTime", str2);
                String json = JSON.toJSONString((Object) map, true);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                MediaType mediaType = MediaType.INSTANCE.parse("application/json; charset=utf-8");
                Intrinsics.checkNotNullExpressionValue(json, "json");
                RequestBody requestBodyCreate = companion.create(mediaType, json);
                this.label = 1;
                objM460requestMessagegIAlus = NetworkApi.INSTANCE.m460requestMessagegIAlus(requestBodyCreate, this);
                if (objM460requestMessagegIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM460requestMessagegIAlus = ((Result) obj).getValue();
            }
            this.this$0.getNoticeLiveData().setValue(Result.m590boximpl(objM460requestMessagegIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getAnnouncement(String showType, int pageNo) {
        Intrinsics.checkNotNullParameter(showType, "showType");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(pageNo, showType, this, null), 3, null);
    }
}
