package com.yd.android_brand_mvp.landscape.evaluation;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.evaluation.EvaluationBean;
import com.yd.android_brand_mvp.model.evaluation.EvaluationMedalBean;
import com.yd.android_brand_mvp.model.evaluation.EvaluationMedalTypeBean;
import com.yd.android_brand_mvp.model.evaluation.EvaluationPointBean;
import com.yd.android_brand_mvp.model.evaluation.EvaluationPointCardBean;
import com.yd.android_brand_mvp.model.evaluation.EvaluationPointCardCancelBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.evaluation.EvaluationNetwork;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.HashMap;
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

/* JADX INFO: compiled from: EvaluationViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+J\u0016\u0010\f\u001a\u00020'2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)J*\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020+2\b\u00101\u001a\u0004\u0018\u00010)2\b\u00102\u001a\u0004\u0018\u00010)J\u0006\u00103\u001a\u00020'J\u000e\u0010\u001b\u001a\u00020'2\u0006\u0010,\u001a\u00020)J0\u00104\u001a\u00020'2\u0006\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020+2\b\u00101\u001a\u0004\u0018\u00010)2\u0006\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020)J4\u00107\u001a\u00020'2\u0006\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010)2\b\u00105\u001a\u0004\u0018\u00010)2\b\u00106\u001a\u0004\u0018\u00010)J\u000e\u0010\u001d\u001a\u00020'2\u0006\u0010,\u001a\u00020)R&\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR,\u0010\r\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u000e0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR&\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR,\u0010\u0013\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u000e0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR,\u0010\u0016\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00060\u000e0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\tR \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\tR#\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004X\u0082\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u0004X\u0082\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R)\u0010 \u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u000e0\u00050\u0004X\u0082\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R#\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00060\u00050\u0004X\u0082\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00050\u0004X\u0082\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R)\u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00060\u000e0\u00050\u0004X\u0082\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R)\u0010$\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u000e0\u00050\u0004X\u0082\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00050\u0004X\u0082\u000eø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "evaluationListLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", "", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationBean;", "getEvaluationListLiveData", "()Landroidx/lifecycle/MutableLiveData;", "evaluationMedalDetails", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationMedalBean;", "getEvaluationMedalDetails", "evaluationMedalListLiveData", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "getEvaluationMedalListLiveData", "evaluationMedalType", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationMedalTypeBean;", "getEvaluationMedalType", "evaluationPoint", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationPointBean;", "getEvaluationPoint", "evaluationPointCard", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationPointCardBean;", "getEvaluationPointCard", "evaluationPointCardDetails", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationPointCardCancelBean;", "getEvaluationPointCardDetails", "evaluationPointUse", "getEvaluationPointUse", "mEvaluationListLiveData", "mEvaluationMedalDetailsLiveData", "mEvaluationMedalListLiveData", "mEvaluationMedalTypeLiveData", "mEvaluationPointCardDetailsLiveData", "mEvaluationPointCardListLiveData", "mEvaluationPointListLiveData", "mEvaluationPointUseLiveData", "getEvaluationList", "", "classId", "", "sortField", "", "personId", "medalCode", "getEvaluationMedalList", "pageNo", "pageSize", "parentId", "evalTypeId", "getEvaluationMedalTypeList", "getEvaluationPointCardPageList", "startTime", "endTime", "getEvaluationPointPageList", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EvaluationViewModel extends ViewModel {
    private final MutableLiveData<Result<List<EvaluationBean>>> evaluationListLiveData;
    private final MutableLiveData<Result<EvaluationMedalBean>> evaluationMedalDetails;
    private final MutableLiveData<Result<BasePageResponse<List<EvaluationMedalBean>>>> evaluationMedalListLiveData;
    private final MutableLiveData<Result<List<EvaluationMedalTypeBean>>> evaluationMedalType;
    private final MutableLiveData<Result<BasePageResponse<List<EvaluationPointBean>>>> evaluationPoint;
    private final MutableLiveData<Result<BasePageResponse<List<EvaluationPointCardBean>>>> evaluationPointCard;
    private final MutableLiveData<Result<EvaluationPointCardCancelBean>> evaluationPointCardDetails;
    private final MutableLiveData<Result<EvaluationPointBean>> evaluationPointUse;
    private MutableLiveData<Result<List<EvaluationBean>>> mEvaluationListLiveData;
    private MutableLiveData<Result<EvaluationMedalBean>> mEvaluationMedalDetailsLiveData;
    private MutableLiveData<Result<BasePageResponse<List<EvaluationMedalBean>>>> mEvaluationMedalListLiveData;
    private MutableLiveData<Result<List<EvaluationMedalTypeBean>>> mEvaluationMedalTypeLiveData;
    private MutableLiveData<Result<EvaluationPointCardCancelBean>> mEvaluationPointCardDetailsLiveData;
    private MutableLiveData<Result<BasePageResponse<List<EvaluationPointCardBean>>>> mEvaluationPointCardListLiveData;
    private MutableLiveData<Result<BasePageResponse<List<EvaluationPointBean>>>> mEvaluationPointListLiveData;
    private MutableLiveData<Result<EvaluationPointBean>> mEvaluationPointUseLiveData;

    public EvaluationViewModel() {
        MutableLiveData<Result<List<EvaluationBean>>> mutableLiveData = new MutableLiveData<>();
        this.mEvaluationListLiveData = mutableLiveData;
        this.evaluationListLiveData = mutableLiveData;
        MutableLiveData<Result<BasePageResponse<List<EvaluationMedalBean>>>> mutableLiveData2 = new MutableLiveData<>();
        this.mEvaluationMedalListLiveData = mutableLiveData2;
        this.evaluationMedalListLiveData = mutableLiveData2;
        MutableLiveData<Result<EvaluationMedalBean>> mutableLiveData3 = new MutableLiveData<>();
        this.mEvaluationMedalDetailsLiveData = mutableLiveData3;
        this.evaluationMedalDetails = mutableLiveData3;
        MutableLiveData<Result<BasePageResponse<List<EvaluationPointCardBean>>>> mutableLiveData4 = new MutableLiveData<>();
        this.mEvaluationPointCardListLiveData = mutableLiveData4;
        this.evaluationPointCard = mutableLiveData4;
        MutableLiveData<Result<EvaluationPointCardCancelBean>> mutableLiveData5 = new MutableLiveData<>();
        this.mEvaluationPointCardDetailsLiveData = mutableLiveData5;
        this.evaluationPointCardDetails = mutableLiveData5;
        MutableLiveData<Result<BasePageResponse<List<EvaluationPointBean>>>> mutableLiveData6 = new MutableLiveData<>();
        this.mEvaluationPointListLiveData = mutableLiveData6;
        this.evaluationPoint = mutableLiveData6;
        MutableLiveData<Result<EvaluationPointBean>> mutableLiveData7 = new MutableLiveData<>();
        this.mEvaluationPointUseLiveData = mutableLiveData7;
        this.evaluationPointUse = mutableLiveData7;
        MutableLiveData<Result<List<EvaluationMedalTypeBean>>> mutableLiveData8 = new MutableLiveData<>();
        this.mEvaluationMedalTypeLiveData = mutableLiveData8;
        this.evaluationMedalType = mutableLiveData8;
    }

    public final MutableLiveData<Result<List<EvaluationBean>>> getEvaluationListLiveData() {
        return this.evaluationListLiveData;
    }

    public final MutableLiveData<Result<BasePageResponse<List<EvaluationMedalBean>>>> getEvaluationMedalListLiveData() {
        return this.evaluationMedalListLiveData;
    }

    public final MutableLiveData<Result<EvaluationMedalBean>> getEvaluationMedalDetails() {
        return this.evaluationMedalDetails;
    }

    public final MutableLiveData<Result<BasePageResponse<List<EvaluationPointCardBean>>>> getEvaluationPointCard() {
        return this.evaluationPointCard;
    }

    public final MutableLiveData<Result<EvaluationPointCardCancelBean>> getEvaluationPointCardDetails() {
        return this.evaluationPointCardDetails;
    }

    public final MutableLiveData<Result<BasePageResponse<List<EvaluationPointBean>>>> getEvaluationPoint() {
        return this.evaluationPoint;
    }

    public final MutableLiveData<Result<EvaluationPointBean>> getEvaluationPointUse() {
        return this.evaluationPointUse;
    }

    public final MutableLiveData<Result<List<EvaluationMedalTypeBean>>> getEvaluationMedalType() {
        return this.evaluationMedalType;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.evaluation.EvaluationViewModel$getEvaluationList$1, reason: invalid class name */
    /* JADX INFO: compiled from: EvaluationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.evaluation.EvaluationViewModel$getEvaluationList$1", f = "EvaluationViewModel.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $classId;
        final /* synthetic */ int $sortField;
        Object L$0;
        int label;
        final /* synthetic */ EvaluationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, int i, EvaluationViewModel evaluationViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$classId = str;
            this.$sortField = i;
            this.this$0 = evaluationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$classId, this.$sortField, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM498getEvaluationListgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("classId", this.$classId);
                map2.put("sortField", Boxing.boxInt(this.$sortField));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.mEvaluationListLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM498getEvaluationListgIAlus = EvaluationNetwork.INSTANCE.m498getEvaluationListgIAlus(requestBodyCreate, this);
                if (objM498getEvaluationListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM498getEvaluationListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM498getEvaluationListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getEvaluationList(String classId, int sortField) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(classId, sortField, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.evaluation.EvaluationViewModel$getEvaluationMedalList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EvaluationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.evaluation.EvaluationViewModel$getEvaluationMedalList$1", f = "EvaluationViewModel.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
    static final class C04521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $evalTypeId;
        final /* synthetic */ int $pageNo;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ String $parentId;
        Object L$0;
        int label;
        final /* synthetic */ EvaluationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04521(int i, int i2, String str, String str2, EvaluationViewModel evaluationViewModel, Continuation<? super C04521> continuation) {
            super(2, continuation);
            this.$pageNo = i;
            this.$pageSize = i2;
            this.$parentId = str;
            this.$evalTypeId = str2;
            this.this$0 = evaluationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04521(this.$pageNo, this.$pageSize, this.$parentId, this.$evalTypeId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM500getEvaluationMedalListgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("pageNo", Boxing.boxInt(this.$pageNo));
                map2.put("pageSize", Boxing.boxInt(this.$pageSize));
                map2.put("identity", Boxing.boxInt(0));
                String str = this.$parentId;
                if (str == null) {
                    str = "";
                }
                map2.put("personId", str);
                if (!TextUtils.isEmpty(this.$evalTypeId)) {
                    String str2 = this.$evalTypeId;
                    map2.put("evalTypeId", str2 != null ? str2 : "");
                }
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.mEvaluationMedalListLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM500getEvaluationMedalListgIAlus = EvaluationNetwork.INSTANCE.m500getEvaluationMedalListgIAlus(requestBodyCreate, this);
                if (objM500getEvaluationMedalListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM500getEvaluationMedalListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM500getEvaluationMedalListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getEvaluationMedalList(int pageNo, int pageSize, String parentId, String evalTypeId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04521(pageNo, pageSize, parentId, evalTypeId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.evaluation.EvaluationViewModel$getEvaluationMedalDetails$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EvaluationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.evaluation.EvaluationViewModel$getEvaluationMedalDetails$1", f = "EvaluationViewModel.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    static final class C04511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $medalCode;
        final /* synthetic */ String $personId;
        Object L$0;
        int label;
        final /* synthetic */ EvaluationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04511(String str, String str2, EvaluationViewModel evaluationViewModel, Continuation<? super C04511> continuation) {
            super(2, continuation);
            this.$personId = str;
            this.$medalCode = str2;
            this.this$0 = evaluationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04511(this.$personId, this.$medalCode, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM499getEvaluationMedalDetailsgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("identity", Boxing.boxInt(0));
                map2.put("personId", this.$personId);
                map2.put("medalCode", this.$medalCode);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.mEvaluationMedalDetailsLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM499getEvaluationMedalDetailsgIAlus = EvaluationNetwork.INSTANCE.m499getEvaluationMedalDetailsgIAlus(requestBodyCreate, this);
                if (objM499getEvaluationMedalDetailsgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM499getEvaluationMedalDetailsgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM499getEvaluationMedalDetailsgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getEvaluationMedalDetails(String personId, String medalCode) {
        Intrinsics.checkNotNullParameter(personId, "personId");
        Intrinsics.checkNotNullParameter(medalCode, "medalCode");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04511(personId, medalCode, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.evaluation.EvaluationViewModel$getEvaluationPointCardPageList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EvaluationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.evaluation.EvaluationViewModel$getEvaluationPointCardPageList$1", f = "EvaluationViewModel.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
    static final class C04551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $endTime;
        final /* synthetic */ int $pageNo;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ String $parentId;
        final /* synthetic */ String $startTime;
        Object L$0;
        int label;
        final /* synthetic */ EvaluationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04551(int i, int i2, String str, String str2, String str3, EvaluationViewModel evaluationViewModel, Continuation<? super C04551> continuation) {
            super(2, continuation);
            this.$pageNo = i;
            this.$pageSize = i2;
            this.$parentId = str;
            this.$startTime = str2;
            this.$endTime = str3;
            this.this$0 = evaluationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04551(this.$pageNo, this.$pageSize, this.$parentId, this.$startTime, this.$endTime, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM503getEvaluationPointCardPageListgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("pageNo", Boxing.boxInt(this.$pageNo));
                map2.put("pageSize", Boxing.boxInt(this.$pageSize));
                map2.put("identity", Boxing.boxInt(0));
                String str = this.$parentId;
                if (str == null) {
                    str = "";
                }
                map2.put("personId", str);
                map2.put("writeOffStartTime", this.$startTime);
                map2.put("writeOffEndTime", this.$endTime);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.mEvaluationPointCardListLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM503getEvaluationPointCardPageListgIAlus = EvaluationNetwork.INSTANCE.m503getEvaluationPointCardPageListgIAlus(requestBodyCreate, this);
                if (objM503getEvaluationPointCardPageListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM503getEvaluationPointCardPageListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM503getEvaluationPointCardPageListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getEvaluationPointCardPageList(int pageNo, int pageSize, String parentId, String startTime, String endTime) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04551(pageNo, pageSize, parentId, startTime, endTime, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.evaluation.EvaluationViewModel$getEvaluationPointCardDetails$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EvaluationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.evaluation.EvaluationViewModel$getEvaluationPointCardDetails$1", f = "EvaluationViewModel.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
    static final class C04541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $personId;
        Object L$0;
        int label;
        final /* synthetic */ EvaluationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04541(String str, EvaluationViewModel evaluationViewModel, Continuation<? super C04541> continuation) {
            super(2, continuation);
            this.$personId = str;
            this.this$0 = evaluationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04541(this.$personId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM502getEvaluationPointCardDetailsgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("identity", Boxing.boxInt(0));
                map2.put("personId", this.$personId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.mEvaluationPointCardDetailsLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM502getEvaluationPointCardDetailsgIAlus = EvaluationNetwork.INSTANCE.m502getEvaluationPointCardDetailsgIAlus(requestBodyCreate, this);
                if (objM502getEvaluationPointCardDetailsgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM502getEvaluationPointCardDetailsgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM502getEvaluationPointCardDetailsgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getEvaluationPointCardDetails(String personId) {
        Intrinsics.checkNotNullParameter(personId, "personId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04541(personId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.evaluation.EvaluationViewModel$getEvaluationPointPageList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EvaluationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.evaluation.EvaluationViewModel$getEvaluationPointPageList$1", f = "EvaluationViewModel.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {})
    static final class C04561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $endTime;
        final /* synthetic */ int $pageNo;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ String $personId;
        final /* synthetic */ String $startTime;
        Object L$0;
        int label;
        final /* synthetic */ EvaluationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04561(int i, int i2, String str, String str2, String str3, EvaluationViewModel evaluationViewModel, Continuation<? super C04561> continuation) {
            super(2, continuation);
            this.$pageNo = i;
            this.$pageSize = i2;
            this.$startTime = str;
            this.$endTime = str2;
            this.$personId = str3;
            this.this$0 = evaluationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04561(this.$pageNo, this.$pageSize, this.$startTime, this.$endTime, this.$personId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM505getEvaluationPointPageListgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("pageNo", Boxing.boxInt(this.$pageNo));
                map2.put("pageSize", Boxing.boxInt(this.$pageSize));
                map2.put("identity", Boxing.boxInt(0));
                String str = this.$startTime;
                if (str == null) {
                    str = "";
                }
                map2.put("scoreStartTime", str);
                String str2 = this.$endTime;
                if (str2 == null) {
                    str2 = "";
                }
                map2.put("scoreEndTime", str2);
                String str3 = this.$personId;
                map2.put("personId", str3 != null ? str3 : "");
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.mEvaluationPointListLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM505getEvaluationPointPageListgIAlus = EvaluationNetwork.INSTANCE.m505getEvaluationPointPageListgIAlus(requestBodyCreate, this);
                if (objM505getEvaluationPointPageListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM505getEvaluationPointPageListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM505getEvaluationPointPageListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getEvaluationPointPageList(int pageNo, int pageSize, String personId, String startTime, String endTime) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04561(pageNo, pageSize, startTime, endTime, personId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.evaluation.EvaluationViewModel$getEvaluationPointUse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EvaluationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.evaluation.EvaluationViewModel$getEvaluationPointUse$1", f = "EvaluationViewModel.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
    static final class C04571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $personId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04571(String str, Continuation<? super C04571> continuation) {
            super(2, continuation);
            this.$personId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EvaluationViewModel.this.new C04571(this.$personId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData2 = EvaluationViewModel.this.mEvaluationPointUseLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objM504getEvaluationPointDetails0E7RQCE = EvaluationNetwork.INSTANCE.m504getEvaluationPointDetails0E7RQCE(this.$personId, "0", this);
                if (objM504getEvaluationPointDetails0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                value = objM504getEvaluationPointDetails0E7RQCE;
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

    public final void getEvaluationPointUse(String personId) {
        Intrinsics.checkNotNullParameter(personId, "personId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04571(personId, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.evaluation.EvaluationViewModel$getEvaluationMedalTypeList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EvaluationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.evaluation.EvaluationViewModel$getEvaluationMedalTypeList$1", f = "EvaluationViewModel.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
    static final class C04531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C04531(Continuation<? super C04531> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EvaluationViewModel.this.new C04531(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData2 = EvaluationViewModel.this.mEvaluationMedalTypeLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objM501getEvaluationMedalTypeListIoAF18A = EvaluationNetwork.INSTANCE.m501getEvaluationMedalTypeListIoAF18A(this);
                if (objM501getEvaluationMedalTypeListIoAF18A == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                value = objM501getEvaluationMedalTypeListIoAF18A;
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

    public final void getEvaluationMedalTypeList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04531(null), 3, null);
    }
}
