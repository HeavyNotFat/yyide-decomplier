package com.yd.android_brand_mvp.activity.fragment.model;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.honor.HonorActiveDetailBean;
import com.yd.android_brand_mvp.model.honor.HonorGoCommentBean;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import java.util.LinkedHashMap;
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

/* JADX INFO: compiled from: HonorActiveDetailViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ.\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fR \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/model/HonorActiveDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "honorActiveDetailLiveData", "Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/honor/HonorActiveDetailBean;", "getHonorActiveDetailLiveData", "()Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "honorGoCommentLiveData", "Lcom/yd/android_brand_mvp/model/honor/HonorGoCommentBean;", "getHonorGoCommentLiveData", "requestActiveDetail", "", "id", "", "requestGoToScore", "activityId", "schoolId", "classId", "identityId", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorActiveDetailViewModel extends ViewModel {
    private final SingleLiveEvent<Result<HonorGoCommentBean>> honorGoCommentLiveData = new SingleLiveEvent<>();
    private final SingleLiveEvent<Result<HonorActiveDetailBean>> honorActiveDetailLiveData = new SingleLiveEvent<>();

    public final SingleLiveEvent<Result<HonorGoCommentBean>> getHonorGoCommentLiveData() {
        return this.honorGoCommentLiveData;
    }

    public final SingleLiveEvent<Result<HonorActiveDetailBean>> getHonorActiveDetailLiveData() {
        return this.honorActiveDetailLiveData;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.fragment.model.HonorActiveDetailViewModel$requestGoToScore$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HonorActiveDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.fragment.model.HonorActiveDetailViewModel$requestGoToScore$1", f = "HonorActiveDetailViewModel.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
    static final class C03401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $activityId;
        final /* synthetic */ String $classId;
        final /* synthetic */ String $identityId;
        final /* synthetic */ String $schoolId;
        Object L$0;
        int label;
        final /* synthetic */ HonorActiveDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03401(String str, String str2, String str3, String str4, HonorActiveDetailViewModel honorActiveDetailViewModel, Continuation<? super C03401> continuation) {
            super(2, continuation);
            this.$activityId = str;
            this.$schoolId = str2;
            this.$classId = str3;
            this.$identityId = str4;
            this.this$0 = honorActiveDetailViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03401(this.$activityId, this.$schoolId, this.$classId, this.$identityId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM456requestGoToScoregIAlus;
            SingleLiveEvent<Result<HonorGoCommentBean>> singleLiveEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String str = this.$activityId;
                if (str == null) {
                    str = "";
                }
                linkedHashMap.put("activityId", str);
                String str2 = this.$schoolId;
                if (str2 == null) {
                    str2 = "";
                }
                linkedHashMap.put("schoolId", str2);
                String str3 = this.$classId;
                if (str3 == null) {
                    str3 = "";
                }
                linkedHashMap.put("classId", str3);
                String str4 = this.$identityId;
                linkedHashMap.put("identityId", str4 != null ? str4 : "");
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                SingleLiveEvent<Result<HonorGoCommentBean>> honorGoCommentLiveData = this.this$0.getHonorGoCommentLiveData();
                this.L$0 = honorGoCommentLiveData;
                this.label = 1;
                objM456requestGoToScoregIAlus = NetworkApi.INSTANCE.m456requestGoToScoregIAlus(requestBodyCreate, this);
                if (objM456requestGoToScoregIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = honorGoCommentLiveData;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                singleLiveEvent = (SingleLiveEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM456requestGoToScoregIAlus = ((Result) obj).getValue();
            }
            singleLiveEvent.setValue(Result.m590boximpl(objM456requestGoToScoregIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void requestGoToScore(String activityId, String schoolId, String classId, String identityId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03401(activityId, schoolId, classId, identityId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.fragment.model.HonorActiveDetailViewModel$requestActiveDetail$1, reason: invalid class name */
    /* JADX INFO: compiled from: HonorActiveDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.fragment.model.HonorActiveDetailViewModel$requestActiveDetail$1", f = "HonorActiveDetailViewModel.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        Object L$0;
        int label;
        final /* synthetic */ HonorActiveDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, HonorActiveDetailViewModel honorActiveDetailViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$id = str;
            this.this$0 = honorActiveDetailViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$id, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM441requestActiveDetailgIAlus;
            SingleLiveEvent<Result<HonorActiveDetailBean>> singleLiveEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String str = this.$id;
                if (str == null) {
                    str = "";
                }
                linkedHashMap.put("activityId", str);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                SingleLiveEvent<Result<HonorActiveDetailBean>> honorActiveDetailLiveData = this.this$0.getHonorActiveDetailLiveData();
                this.L$0 = honorActiveDetailLiveData;
                this.label = 1;
                objM441requestActiveDetailgIAlus = NetworkApi.INSTANCE.m441requestActiveDetailgIAlus(requestBodyCreate, this);
                if (objM441requestActiveDetailgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = honorActiveDetailLiveData;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                singleLiveEvent = (SingleLiveEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM441requestActiveDetailgIAlus = ((Result) obj).getValue();
            }
            singleLiveEvent.setValue(Result.m590boximpl(objM441requestActiveDetailgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void requestActiveDetail(String id) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(id, this, null), 3, null);
    }
}
