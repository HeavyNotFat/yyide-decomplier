package com.yd.android_brand_mvp.verfity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.UserIcCardBean;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
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

/* JADX INFO: compiled from: AllCheckViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0006R \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/verfity/AllCheckViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "pauschCard", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", "", "getPauschCard", "()Landroidx/lifecycle/MutableLiveData;", "pauschCardViewModel", "selectStudent", "Lcom/yd/android_brand_mvp/model/selectNewStudentByIcCardRsp$DataBean;", "selectStudentRsp", "getSelectStudentRsp", "selectUser", "Lcom/yd/android_brand_mvp/model/UserIcCardBean$DataBean;", "selectUserRsp", "getSelectUserRsp", "checkStudent", "", "CardNoOrFaceId", "checkUser", "cardNumber", "userId", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AllCheckViewModel extends ViewModel {
    private final MutableLiveData<Result<String>> pauschCard;
    private final MutableLiveData<Result<String>> pauschCardViewModel;
    private final MutableLiveData<Result<selectNewStudentByIcCardRsp.DataBean>> selectStudent;
    private final MutableLiveData<Result<selectNewStudentByIcCardRsp.DataBean>> selectStudentRsp;
    private final MutableLiveData<Result<UserIcCardBean.DataBean>> selectUser;
    private final MutableLiveData<Result<UserIcCardBean.DataBean>> selectUserRsp;

    public AllCheckViewModel() {
        MutableLiveData<Result<selectNewStudentByIcCardRsp.DataBean>> mutableLiveData = new MutableLiveData<>();
        this.selectStudent = mutableLiveData;
        this.selectStudentRsp = mutableLiveData;
        MutableLiveData<Result<UserIcCardBean.DataBean>> mutableLiveData2 = new MutableLiveData<>();
        this.selectUser = mutableLiveData2;
        this.selectUserRsp = mutableLiveData2;
        MutableLiveData<Result<String>> mutableLiveData3 = new MutableLiveData<>();
        this.pauschCardViewModel = mutableLiveData3;
        this.pauschCard = mutableLiveData3;
    }

    public final MutableLiveData<Result<selectNewStudentByIcCardRsp.DataBean>> getSelectStudentRsp() {
        return this.selectStudentRsp;
    }

    public final MutableLiveData<Result<UserIcCardBean.DataBean>> getSelectUserRsp() {
        return this.selectUserRsp;
    }

    public final MutableLiveData<Result<String>> getPauschCard() {
        return this.pauschCard;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.verfity.AllCheckViewModel$checkStudent$1, reason: invalid class name */
    /* JADX INFO: compiled from: AllCheckViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.verfity.AllCheckViewModel$checkStudent$1", f = "AllCheckViewModel.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $CardNoOrFaceId;
        Object L$0;
        int label;
        final /* synthetic */ AllCheckViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, AllCheckViewModel allCheckViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$CardNoOrFaceId = str;
            this.this$0 = allCheckViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$CardNoOrFaceId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM416checkStudentgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("icCardNo", this.$CardNoOrFaceId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.selectStudent;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM416checkStudentgIAlus = NetworkApi.INSTANCE.m416checkStudentgIAlus(requestBodyCreate, this);
                if (objM416checkStudentgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM416checkStudentgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM416checkStudentgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void checkStudent(String CardNoOrFaceId) {
        Intrinsics.checkNotNullParameter(CardNoOrFaceId, "CardNoOrFaceId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(CardNoOrFaceId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.verfity.AllCheckViewModel$checkUser$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AllCheckViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.verfity.AllCheckViewModel$checkUser$1", f = "AllCheckViewModel.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    static final class C05661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $cardNumber;
        Object L$0;
        int label;
        final /* synthetic */ AllCheckViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05661(String str, AllCheckViewModel allCheckViewModel, Continuation<? super C05661> continuation) {
            super(2, continuation);
            this.$cardNumber = str;
            this.this$0 = allCheckViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05661(this.$cardNumber, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM418checkUsergIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("icCardNo", this.$cardNumber);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.selectUser;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM418checkUsergIAlus = NetworkApi.INSTANCE.m418checkUsergIAlus(requestBodyCreate, this);
                if (objM418checkUsergIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM418checkUsergIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM418checkUsergIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void checkUser(String cardNumber) {
        Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05661(cardNumber, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.verfity.AllCheckViewModel$pauschCard$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AllCheckViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.verfity.AllCheckViewModel$pauschCard$1", f = "AllCheckViewModel.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
    static final class C05671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $userId;
        Object L$0;
        int label;
        final /* synthetic */ AllCheckViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05671(String str, AllCheckViewModel allCheckViewModel, Continuation<? super C05671> continuation) {
            super(2, continuation);
            this.$userId = str;
            this.this$0 = allCheckViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05671(this.$userId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM440pauschCardgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(CommentsHomeFragment.TYPE_ID, this.$userId);
                String siteId = SpData.getSiteId();
                Intrinsics.checkNotNullExpressionValue(siteId, "getSiteId()");
                linkedHashMap.put("siteId", siteId);
                String currentTime2 = TimeUtil.getCurrentTime2();
                Intrinsics.checkNotNullExpressionValue(currentTime2, "getCurrentTime2()");
                linkedHashMap.put("signinTime", currentTime2);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.pauschCardViewModel;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM440pauschCardgIAlus = NetworkApi.INSTANCE.m440pauschCardgIAlus(requestBodyCreate, this);
                if (objM440pauschCardgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM440pauschCardgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM440pauschCardgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void pauschCard(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05671(userId, this, null), 3, null);
    }
}
