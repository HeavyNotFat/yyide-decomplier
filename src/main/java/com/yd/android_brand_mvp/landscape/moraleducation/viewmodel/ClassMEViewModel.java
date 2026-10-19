package com.yd.android_brand_mvp.landscape.moraleducation.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.blankj.utilcode.util.LogUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.landscape.moraleducation.model.AppraisalScoreParamModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CheckSecurityModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.FirstIndicatorModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.IndexClassMEModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.ScoringDetailCycleModel;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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

/* JADX INFO: compiled from: ClassMEViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0019J$\u0010\u001f\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010 \u001a\u0004\u0018\u00010\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u001bJ\u001e\u0010\"\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001bJ\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%R \u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR&\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00070\u0006ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR&\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000f0\u00070\u0006ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00070\u0006ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/viewmodel/ClassMEViewModel;", "Landroidx/lifecycle/AndroidViewModel;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "(Landroid/app/Application;)V", "mCheckSecurityModelLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CheckSecurityModel;", "getMCheckSecurityModelLiveData", "()Landroidx/lifecycle/MutableLiveData;", "mClassMEModelLiveData", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/IndexClassMEModel;", "getMClassMEModelLiveData", "mIndicatorModelLiveData", "", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/FirstIndicatorModel;", "getMIndicatorModelLiveData", "mScoringDetailCycleModelLiveData", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/ScoringDetailCycleModel;", "getMScoringDetailCycleModelLiveData", "mSubmitScoreModelLiveData", "", "getMSubmitScoreModelLiveData", "getDailyScoreDetails", "", "activityId", "", "cycleId", "", "getRanking", "getScoringRubric", "teacherId", CommentsHomeFragment.TYPE_ID, "securityCheck", "submitScore", "appraisalScoreParamModel", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/AppraisalScoreParamModel;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClassMEViewModel extends AndroidViewModel {
    private final MutableLiveData<Result<CheckSecurityModel>> mCheckSecurityModelLiveData;
    private final MutableLiveData<Result<IndexClassMEModel>> mClassMEModelLiveData;
    private final MutableLiveData<Result<List<FirstIndicatorModel>>> mIndicatorModelLiveData;
    private final MutableLiveData<Result<List<ScoringDetailCycleModel>>> mScoringDetailCycleModelLiveData;
    private final MutableLiveData<Result<Float>> mSubmitScoreModelLiveData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassMEViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.mClassMEModelLiveData = new MutableLiveData<>();
        this.mScoringDetailCycleModelLiveData = new MutableLiveData<>();
        this.mIndicatorModelLiveData = new MutableLiveData<>();
        this.mSubmitScoreModelLiveData = new MutableLiveData<>();
        this.mCheckSecurityModelLiveData = new MutableLiveData<>();
    }

    public final MutableLiveData<Result<IndexClassMEModel>> getMClassMEModelLiveData() {
        return this.mClassMEModelLiveData;
    }

    public final MutableLiveData<Result<List<ScoringDetailCycleModel>>> getMScoringDetailCycleModelLiveData() {
        return this.mScoringDetailCycleModelLiveData;
    }

    public final MutableLiveData<Result<List<FirstIndicatorModel>>> getMIndicatorModelLiveData() {
        return this.mIndicatorModelLiveData;
    }

    public final MutableLiveData<Result<Float>> getMSubmitScoreModelLiveData() {
        return this.mSubmitScoreModelLiveData;
    }

    public final MutableLiveData<Result<CheckSecurityModel>> getMCheckSecurityModelLiveData() {
        return this.mCheckSecurityModelLiveData;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.viewmodel.ClassMEViewModel$getRanking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ClassMEViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.moraleducation.viewmodel.ClassMEViewModel$getRanking$1", f = "ClassMEViewModel.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    static final class C04991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C04991(Continuation<? super C04991> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClassMEViewModel.this.new C04991(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04991) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM448requestClassMegIAlus;
            MutableLiveData<Result<IndexClassMEModel>> mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Map mapEmptyMap = MapsKt.emptyMap();
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(mapEmptyMap);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData<Result<IndexClassMEModel>> mClassMEModelLiveData = ClassMEViewModel.this.getMClassMEModelLiveData();
                this.L$0 = mClassMEModelLiveData;
                this.label = 1;
                objM448requestClassMegIAlus = NetworkApi.INSTANCE.m448requestClassMegIAlus(requestBodyCreate, this);
                if (objM448requestClassMegIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mClassMEModelLiveData;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM448requestClassMegIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM448requestClassMegIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getRanking() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04991(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.viewmodel.ClassMEViewModel$getDailyScoreDetails$1, reason: invalid class name */
    /* JADX INFO: compiled from: ClassMEViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.moraleducation.viewmodel.ClassMEViewModel$getDailyScoreDetails$1", f = "ClassMEViewModel.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $activityId;
        final /* synthetic */ long $cycleId;
        Object L$0;
        int label;
        final /* synthetic */ ClassMEViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, long j, ClassMEViewModel classMEViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activityId = str;
            this.$cycleId = j;
            this.this$0 = classMEViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$activityId, this.$cycleId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM454requestDailyScoreDetailsgIAlus;
            MutableLiveData<Result<List<ScoringDetailCycleModel>>> mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("activityId", this.$activityId), TuplesKt.to("cycleId", Boxing.boxLong(this.$cycleId)));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(mapMapOf);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData<Result<List<ScoringDetailCycleModel>>> mScoringDetailCycleModelLiveData = this.this$0.getMScoringDetailCycleModelLiveData();
                this.L$0 = mScoringDetailCycleModelLiveData;
                this.label = 1;
                objM454requestDailyScoreDetailsgIAlus = NetworkApi.INSTANCE.m454requestDailyScoreDetailsgIAlus(requestBodyCreate, this);
                if (objM454requestDailyScoreDetailsgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mScoringDetailCycleModelLiveData;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM454requestDailyScoreDetailsgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM454requestDailyScoreDetailsgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getDailyScoreDetails(String activityId, long cycleId) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(activityId, cycleId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.viewmodel.ClassMEViewModel$getScoringRubric$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ClassMEViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.moraleducation.viewmodel.ClassMEViewModel$getScoringRubric$1", f = "ClassMEViewModel.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
    static final class C05001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $activityId;
        final /* synthetic */ String $studentId;
        final /* synthetic */ String $teacherId;
        Object L$0;
        int label;
        final /* synthetic */ ClassMEViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05001(String str, String str2, String str3, ClassMEViewModel classMEViewModel, Continuation<? super C05001> continuation) {
            super(2, continuation);
            this.$activityId = str;
            this.$teacherId = str2;
            this.$studentId = str3;
            this.this$0 = classMEViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05001(this.$activityId, this.$teacherId, this.$studentId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05001) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM466requestScoringRubricgIAlus;
            MutableLiveData<Result<List<FirstIndicatorModel>>> mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("activityId", this.$activityId);
                if (!TextUtils.isEmpty(this.$teacherId)) {
                    linkedHashMap.put("teacherId", this.$teacherId);
                }
                if (!TextUtils.isEmpty(this.$studentId)) {
                    linkedHashMap.put(CommentsHomeFragment.TYPE_ID, this.$studentId);
                }
                LogUtils.i("getScoringRubric..." + GsonUtils.toJson(linkedHashMap));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData<Result<List<FirstIndicatorModel>>> mIndicatorModelLiveData = this.this$0.getMIndicatorModelLiveData();
                this.L$0 = mIndicatorModelLiveData;
                this.label = 1;
                objM466requestScoringRubricgIAlus = NetworkApi.INSTANCE.m466requestScoringRubricgIAlus(requestBodyCreate, this);
                if (objM466requestScoringRubricgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mIndicatorModelLiveData;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM466requestScoringRubricgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM466requestScoringRubricgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getScoringRubric(String activityId, String teacherId, String studentId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05001(activityId, teacherId, studentId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.viewmodel.ClassMEViewModel$submitScore$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ClassMEViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.moraleducation.viewmodel.ClassMEViewModel$submitScore$1", f = "ClassMEViewModel.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    static final class C05021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppraisalScoreParamModel $appraisalScoreParamModel;
        Object L$0;
        int label;
        final /* synthetic */ ClassMEViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05021(AppraisalScoreParamModel appraisalScoreParamModel, ClassMEViewModel classMEViewModel, Continuation<? super C05021> continuation) {
            super(2, continuation);
            this.$appraisalScoreParamModel = appraisalScoreParamModel;
            this.this$0 = classMEViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05021(this.$appraisalScoreParamModel, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM437gotoScoregIAlus;
            MutableLiveData<Result<Float>> mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(this.$appraisalScoreParamModel);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(appraisalScoreParamModel)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData<Result<Float>> mSubmitScoreModelLiveData = this.this$0.getMSubmitScoreModelLiveData();
                this.L$0 = mSubmitScoreModelLiveData;
                this.label = 1;
                objM437gotoScoregIAlus = NetworkApi.INSTANCE.m437gotoScoregIAlus(requestBodyCreate, this);
                if (objM437gotoScoregIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mSubmitScoreModelLiveData;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM437gotoScoregIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM437gotoScoregIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void submitScore(AppraisalScoreParamModel appraisalScoreParamModel) {
        Intrinsics.checkNotNullParameter(appraisalScoreParamModel, "appraisalScoreParamModel");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05021(appraisalScoreParamModel, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.viewmodel.ClassMEViewModel$securityCheck$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ClassMEViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.moraleducation.viewmodel.ClassMEViewModel$securityCheck$1", f = "ClassMEViewModel.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    static final class C05011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $activityId;
        final /* synthetic */ String $studentId;
        final /* synthetic */ String $teacherId;
        Object L$0;
        int label;
        final /* synthetic */ ClassMEViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05011(String str, String str2, String str3, ClassMEViewModel classMEViewModel, Continuation<? super C05011> continuation) {
            super(2, continuation);
            this.$activityId = str;
            this.$teacherId = str2;
            this.$studentId = str3;
            this.this$0 = classMEViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05011(this.$activityId, this.$teacherId, this.$studentId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM472securityCheckgIAlus;
            MutableLiveData<Result<CheckSecurityModel>> mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("activityId", this.$activityId);
                if (!TextUtils.isEmpty(this.$teacherId)) {
                    linkedHashMap.put("teacherId", this.$teacherId);
                }
                if (!TextUtils.isEmpty(this.$studentId)) {
                    linkedHashMap.put(CommentsHomeFragment.TYPE_ID, this.$studentId);
                }
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData<Result<CheckSecurityModel>> mCheckSecurityModelLiveData = this.this$0.getMCheckSecurityModelLiveData();
                this.L$0 = mCheckSecurityModelLiveData;
                this.label = 1;
                objM472securityCheckgIAlus = NetworkApi.INSTANCE.m472securityCheckgIAlus(requestBodyCreate, this);
                if (objM472securityCheckgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mCheckSecurityModelLiveData;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM472securityCheckgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM472securityCheckgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void securityCheck(String activityId, String teacherId, String studentId) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(teacherId, "teacherId");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05011(activityId, teacherId, studentId, this, null), 3, null);
    }
}
