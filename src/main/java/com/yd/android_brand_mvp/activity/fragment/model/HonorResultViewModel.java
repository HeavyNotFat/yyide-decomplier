package com.yd.android_brand_mvp.activity.fragment.model;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.honor.HonorCommentResultBean;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import java.util.LinkedHashMap;
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

/* JADX INFO: compiled from: HonorResultViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fR \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/model/HonorResultViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "activeResultList", "Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/honor/HonorCommentResultBean;", "getActiveResultList", "()Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "requestActiveResultList", "", "activeId", "", "classId", "pageNo", "", "pageSize", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorResultViewModel extends ViewModel {
    private final SingleLiveEvent<Result<HonorCommentResultBean>> activeResultList = new SingleLiveEvent<>();

    public final SingleLiveEvent<Result<HonorCommentResultBean>> getActiveResultList() {
        return this.activeResultList;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.fragment.model.HonorResultViewModel$requestActiveResultList$1, reason: invalid class name */
    /* JADX INFO: compiled from: HonorResultViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.fragment.model.HonorResultViewModel$requestActiveResultList$1", f = "HonorResultViewModel.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $activeId;
        final /* synthetic */ String $classId;
        final /* synthetic */ int $pageNo;
        final /* synthetic */ int $pageSize;
        Object L$0;
        int label;
        final /* synthetic */ HonorResultViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, int i, int i2, HonorResultViewModel honorResultViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activeId = str;
            this.$classId = str2;
            this.$pageNo = i;
            this.$pageSize = i2;
            this.this$0 = honorResultViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$activeId, this.$classId, this.$pageNo, this.$pageSize, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM443requestActiveResultListgIAlus;
            SingleLiveEvent<Result<HonorCommentResultBean>> singleLiveEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("activityId", this.$activeId);
                linkedHashMap.put("classId", this.$classId);
                linkedHashMap.put("pageNo", Boxing.boxInt(this.$pageNo));
                linkedHashMap.put("pageSize", Boxing.boxInt(this.$pageSize));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                SingleLiveEvent<Result<HonorCommentResultBean>> activeResultList = this.this$0.getActiveResultList();
                this.L$0 = activeResultList;
                this.label = 1;
                objM443requestActiveResultListgIAlus = NetworkApi.INSTANCE.m443requestActiveResultListgIAlus(requestBodyCreate, this);
                if (objM443requestActiveResultListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = activeResultList;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                singleLiveEvent = (SingleLiveEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM443requestActiveResultListgIAlus = ((Result) obj).getValue();
            }
            singleLiveEvent.setValue(Result.m590boximpl(objM443requestActiveResultListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void requestActiveResultList(String activeId, String classId, int pageNo, int pageSize) {
        Intrinsics.checkNotNullParameter(activeId, "activeId");
        Intrinsics.checkNotNullParameter(classId, "classId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(activeId, classId, pageNo, pageSize, this, null), 3, null);
    }
}
