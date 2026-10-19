package com.yd.android_brand_mvp.activity.exam.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.exam.ExamArrangementBean;
import com.yd.android_brand_mvp.model.exam.ExamPersonSeatBean;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
import com.yd.android_brand_mvp.network.exam.ExamManageNetwork;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.HashMap;
import java.util.List;
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

/* JADX INFO: compiled from: ExamArrangeViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aJ\u001e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u0016\u001a\u00020\u0018J&\u0010\u0010\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aR \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR#\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR#\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/activity/exam/viewmodel/ExamArrangeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "examDetail", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "getExamDetail", "()Landroidx/lifecycle/LiveData;", "examDetailLiveData", "Landroidx/lifecycle/MutableLiveData;", "seatInExam", "", "Lcom/yd/android_brand_mvp/model/exam/ExamPersonSeatBean;", "getSeatInExam", "seatInExamLiveData", "signInExam", "", "getSignInExam", "signInExamLiveData", "weekExam", "Lcom/yd/android_brand_mvp/model/exam/ExamArrangementBean;", "getWeekExam", "weekExamLiveData", "", "siteId", "", "subjectId", "examinationId", "getExamSeat", CommentsHomeFragment.TYPE_ID, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExamArrangeViewModel extends ViewModel {
    private final LiveData<Result<ExamPlanItem>> examDetail;
    private final MutableLiveData<Result<ExamPlanItem>> examDetailLiveData;
    private final LiveData<Result<List<ExamPersonSeatBean>>> seatInExam;
    private final MutableLiveData<Result<List<ExamPersonSeatBean>>> seatInExamLiveData;
    private final LiveData<Result<Boolean>> signInExam;
    private final MutableLiveData<Result<Boolean>> signInExamLiveData;
    private final LiveData<Result<List<ExamArrangementBean>>> weekExam;
    private final MutableLiveData<Result<List<ExamArrangementBean>>> weekExamLiveData;

    public ExamArrangeViewModel() {
        MutableLiveData<Result<List<ExamArrangementBean>>> mutableLiveData = new MutableLiveData<>();
        this.weekExamLiveData = mutableLiveData;
        this.weekExam = mutableLiveData;
        MutableLiveData<Result<ExamPlanItem>> mutableLiveData2 = new MutableLiveData<>();
        this.examDetailLiveData = mutableLiveData2;
        this.examDetail = mutableLiveData2;
        MutableLiveData<Result<List<ExamPersonSeatBean>>> mutableLiveData3 = new MutableLiveData<>();
        this.seatInExamLiveData = mutableLiveData3;
        this.seatInExam = mutableLiveData3;
        MutableLiveData<Result<Boolean>> mutableLiveData4 = new MutableLiveData<>();
        this.signInExamLiveData = mutableLiveData4;
        this.signInExam = mutableLiveData4;
    }

    public final LiveData<Result<List<ExamArrangementBean>>> getWeekExam() {
        return this.weekExam;
    }

    public final LiveData<Result<ExamPlanItem>> getExamDetail() {
        return this.examDetail;
    }

    public final LiveData<Result<List<ExamPersonSeatBean>>> getSeatInExam() {
        return this.seatInExam;
    }

    public final LiveData<Result<Boolean>> getSignInExam() {
        return this.signInExam;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.exam.viewmodel.ExamArrangeViewModel$getWeekExam$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExamArrangeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.exam.viewmodel.ExamArrangeViewModel$getWeekExam$1", f = "ExamArrangeViewModel.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    static final class C03291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C03291(Continuation<? super C03291> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ExamArrangeViewModel.this.new C03291(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM510getWeekExamgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = ExamArrangeViewModel.this.weekExamLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM510getWeekExamgIAlus = ExamManageNetwork.INSTANCE.m510getWeekExamgIAlus(requestBodyCreate, this);
                if (objM510getWeekExamgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM510getWeekExamgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM510getWeekExamgIAlus));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: getWeekExam, reason: collision with other method in class */
    public final void m214getWeekExam() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03291(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.exam.viewmodel.ExamArrangeViewModel$getExamDetail$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExamArrangeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.exam.viewmodel.ExamArrangeViewModel$getExamDetail$1", f = "ExamArrangeViewModel.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $examinationId;
        final /* synthetic */ String $siteId;
        final /* synthetic */ String $subjectId;
        Object L$0;
        int label;
        final /* synthetic */ ExamArrangeViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, ExamArrangeViewModel examArrangeViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$siteId = str;
            this.$subjectId = str2;
            this.$examinationId = str3;
            this.this$0 = examArrangeViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$siteId, this.$subjectId, this.$examinationId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM506getExamDetailgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("siteId", this.$siteId);
                map2.put("subjectId", this.$subjectId);
                map2.put("examinationId", this.$examinationId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.examDetailLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM506getExamDetailgIAlus = ExamManageNetwork.INSTANCE.m506getExamDetailgIAlus(requestBodyCreate, this);
                if (objM506getExamDetailgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM506getExamDetailgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM506getExamDetailgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getExamDetail(String siteId, String subjectId, String examinationId) {
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(examinationId, "examinationId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(siteId, subjectId, examinationId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.exam.viewmodel.ExamArrangeViewModel$getExamSeat$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExamArrangeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.exam.viewmodel.ExamArrangeViewModel$getExamSeat$1", f = "ExamArrangeViewModel.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
    static final class C03281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $examinationId;
        final /* synthetic */ String $siteId;
        final /* synthetic */ String $subjectId;
        Object L$0;
        int label;
        final /* synthetic */ ExamArrangeViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03281(String str, String str2, String str3, ExamArrangeViewModel examArrangeViewModel, Continuation<? super C03281> continuation) {
            super(2, continuation);
            this.$siteId = str;
            this.$subjectId = str2;
            this.$examinationId = str3;
            this.this$0 = examArrangeViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03281(this.$siteId, this.$subjectId, this.$examinationId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM507getExamSeatgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("siteId", this.$siteId);
                map2.put("subjectId", this.$subjectId);
                map2.put("examinationId", this.$examinationId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.seatInExamLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM507getExamSeatgIAlus = ExamManageNetwork.INSTANCE.m507getExamSeatgIAlus(requestBodyCreate, this);
                if (objM507getExamSeatgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM507getExamSeatgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM507getExamSeatgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getExamSeat(String siteId, String subjectId, String examinationId) {
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(examinationId, "examinationId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03281(siteId, subjectId, examinationId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.exam.viewmodel.ExamArrangeViewModel$signInExam$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExamArrangeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.exam.viewmodel.ExamArrangeViewModel$signInExam$1", f = "ExamArrangeViewModel.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
    static final class C03301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $examinationId;
        final /* synthetic */ String $siteId;
        final /* synthetic */ String $studentId;
        final /* synthetic */ String $subjectId;
        Object L$0;
        int label;
        final /* synthetic */ ExamArrangeViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03301(String str, String str2, String str3, String str4, ExamArrangeViewModel examArrangeViewModel, Continuation<? super C03301> continuation) {
            super(2, continuation);
            this.$studentId = str;
            this.$siteId = str2;
            this.$subjectId = str3;
            this.$examinationId = str4;
            this.this$0 = examArrangeViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03301(this.$studentId, this.$siteId, this.$subjectId, this.$examinationId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM512signInExamgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put(CommentsHomeFragment.TYPE_ID, this.$studentId);
                map2.put("siteId", this.$siteId);
                map2.put("subjectId", this.$subjectId);
                map2.put("examinationId", this.$examinationId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.signInExamLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM512signInExamgIAlus = ExamManageNetwork.INSTANCE.m512signInExamgIAlus(requestBodyCreate, this);
                if (objM512signInExamgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM512signInExamgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM512signInExamgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void signInExam(String studentId, String siteId, String subjectId, String examinationId) {
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(examinationId, "examinationId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03301(studentId, siteId, subjectId, examinationId, this, null), 3, null);
    }
}
