package com.yd.android_brand_mvp.landscape.message.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import com.yd.android_brand_mvp.utils.SpData;
import java.util.LinkedHashMap;
import java.util.List;
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
import okhttp3.RequestBody;

/* JADX INFO: compiled from: MessageHomeNewViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012J6\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010R,\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR,\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/viewmodel/MessageHomeNewViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "messageHomeLiveData", "Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "getMessageHomeLiveData", "()Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "messageListLiveData", "getMessageListLiveData", "requestMessageHome", "", "type", "", "pageNo", "", "pageSize", FirebaseAnalytics.Event.SEARCH, "showType", "startDate", "endDate", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageHomeNewViewModel extends ViewModel {
    private final SingleLiveEvent<Result<BasePageResponse<List<MessageItemBean>>>> messageHomeLiveData = new SingleLiveEvent<>();
    private final SingleLiveEvent<Result<BasePageResponse<List<MessageItemBean>>>> messageListLiveData = new SingleLiveEvent<>();

    public final SingleLiveEvent<Result<BasePageResponse<List<MessageItemBean>>>> getMessageHomeLiveData() {
        return this.messageHomeLiveData;
    }

    public final SingleLiveEvent<Result<BasePageResponse<List<MessageItemBean>>>> getMessageListLiveData() {
        return this.messageListLiveData;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.message.viewmodel.MessageHomeNewViewModel$requestMessageHome$1, reason: invalid class name */
    /* JADX INFO: compiled from: MessageHomeNewViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.message.viewmodel.MessageHomeNewViewModel$requestMessageHome$1", f = "MessageHomeNewViewModel.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $type;
        Object L$0;
        int label;
        final /* synthetic */ MessageHomeNewViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, MessageHomeNewViewModel messageHomeNewViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$type = str;
            this.this$0 = messageHomeNewViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$type, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM462requestMessageListgIAlus;
            SingleLiveEvent<Result<BasePageResponse<List<MessageItemBean>>>> singleLiveEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("pageSize", Boxing.boxInt(10));
                linkedHashMap.put("pageNo", Boxing.boxInt(1));
                String brandId = SpData.getBrandId();
                Intrinsics.checkNotNullExpressionValue(brandId, "getBrandId()");
                linkedHashMap.put("brandId", brandId);
                linkedHashMap.put("identifier", this.$type);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                SingleLiveEvent<Result<BasePageResponse<List<MessageItemBean>>>> messageHomeLiveData = this.this$0.getMessageHomeLiveData();
                this.L$0 = messageHomeLiveData;
                this.label = 1;
                objM462requestMessageListgIAlus = NetworkApi.INSTANCE.m462requestMessageListgIAlus(requestBodyCreate, this);
                if (objM462requestMessageListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = messageHomeLiveData;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                singleLiveEvent = (SingleLiveEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM462requestMessageListgIAlus = ((Result) obj).getValue();
            }
            singleLiveEvent.setValue(Result.m590boximpl(objM462requestMessageListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void requestMessageHome$default(MessageHomeNewViewModel messageHomeNewViewModel, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 1;
        }
        if ((i3 & 4) != 0) {
            i2 = 10;
        }
        messageHomeNewViewModel.requestMessageHome(str, i, i2);
    }

    public final void requestMessageHome(String type, int pageNo, int pageSize) {
        Intrinsics.checkNotNullParameter(type, "type");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(type, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.message.viewmodel.MessageHomeNewViewModel$requestMessageHome$2, reason: invalid class name */
    /* JADX INFO: compiled from: MessageHomeNewViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.message.viewmodel.MessageHomeNewViewModel$requestMessageHome$2", f = "MessageHomeNewViewModel.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $endDate;
        final /* synthetic */ int $pageNo;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ String $search;
        final /* synthetic */ String $showType;
        final /* synthetic */ String $startDate;
        Object L$0;
        int label;
        final /* synthetic */ MessageHomeNewViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, int i, int i2, String str2, String str3, String str4, MessageHomeNewViewModel messageHomeNewViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$search = str;
            this.$pageNo = i;
            this.$pageSize = i2;
            this.$showType = str2;
            this.$startDate = str3;
            this.$endDate = str4;
            this.this$0 = messageHomeNewViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$search, this.$pageNo, this.$pageSize, this.$showType, this.$startDate, this.$endDate, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM462requestMessageListgIAlus;
            SingleLiveEvent<Result<BasePageResponse<List<MessageItemBean>>>> singleLiveEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("keyWords", this.$search);
                linkedHashMap.put("pageNo", Boxing.boxInt(this.$pageNo));
                linkedHashMap.put("pageSize", Boxing.boxInt(this.$pageSize));
                String brandId = SpData.getBrandId();
                Intrinsics.checkNotNullExpressionValue(brandId, "getBrandId()");
                linkedHashMap.put("brandId", brandId);
                linkedHashMap.put("identifier", this.$showType);
                linkedHashMap.put("startTime", this.$startDate);
                linkedHashMap.put("endTime", this.$endDate);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                SingleLiveEvent<Result<BasePageResponse<List<MessageItemBean>>>> messageListLiveData = this.this$0.getMessageListLiveData();
                this.L$0 = messageListLiveData;
                this.label = 1;
                objM462requestMessageListgIAlus = NetworkApi.INSTANCE.m462requestMessageListgIAlus(requestBodyCreate, this);
                if (objM462requestMessageListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = messageListLiveData;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                singleLiveEvent = (SingleLiveEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM462requestMessageListgIAlus = ((Result) obj).getValue();
            }
            singleLiveEvent.setValue(Result.m590boximpl(objM462requestMessageListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void requestMessageHome(String search, String showType, int pageNo, int pageSize, String startDate, String endDate) {
        Intrinsics.checkNotNullParameter(search, "search");
        Intrinsics.checkNotNullParameter(showType, "showType");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(search, pageNo, pageSize, showType, startDate, endDate, this, null), 3, null);
    }
}
