package com.yd.android_brand_mvp.landscape.dormitory.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.model.dormitory.DormitoryDetailsBean;
import com.yd.android_brand_mvp.model.dormitory.DormitoryEducationBean;
import com.yd.android_brand_mvp.network.dormitory.DormitoryNetwork;
import com.yd.android_brand_mvp.utils.SpData;
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
import org.bouncycastle.i18n.ErrorBundle;

/* JADX INFO: compiled from: DormitoryViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fR \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/dormitory/viewmodel/DormitoryViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", ErrorBundle.DETAIL_ENTRY, "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/dormitory/DormitoryDetailsBean;", "getDetails", "()Landroidx/lifecycle/MutableLiveData;", "detailsLiveData", "educationRanking", "Lcom/yd/android_brand_mvp/model/dormitory/DormitoryEducationBean;", "getEducationRanking", "educationRankingLiveData", "getDormitoryDetail", "", "getDormitoryEducationRanking", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DormitoryViewModel extends ViewModel {
    private final MutableLiveData<Result<DormitoryDetailsBean>> details;
    private final MutableLiveData<Result<DormitoryDetailsBean>> detailsLiveData;
    private final MutableLiveData<Result<DormitoryEducationBean>> educationRanking;
    private final MutableLiveData<Result<DormitoryEducationBean>> educationRankingLiveData;

    public DormitoryViewModel() {
        MutableLiveData<Result<DormitoryEducationBean>> mutableLiveData = new MutableLiveData<>();
        this.educationRankingLiveData = mutableLiveData;
        this.educationRanking = mutableLiveData;
        MutableLiveData<Result<DormitoryDetailsBean>> mutableLiveData2 = new MutableLiveData<>();
        this.detailsLiveData = mutableLiveData2;
        this.details = mutableLiveData2;
    }

    public final MutableLiveData<Result<DormitoryEducationBean>> getEducationRanking() {
        return this.educationRanking;
    }

    public final MutableLiveData<Result<DormitoryDetailsBean>> getDetails() {
        return this.details;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.dormitory.viewmodel.DormitoryViewModel$getDormitoryEducationRanking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DormitoryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.dormitory.viewmodel.DormitoryViewModel$getDormitoryEducationRanking$1", f = "DormitoryViewModel.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    static final class C04401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C04401(Continuation<? super C04401> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DormitoryViewModel.this.new C04401(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData2 = DormitoryViewModel.this.educationRankingLiveData;
                DormitoryNetwork dormitoryNetwork = DormitoryNetwork.INSTANCE;
                String classesId = SpData.getClassesId();
                Intrinsics.checkNotNullExpressionValue(classesId, "getClassesId()");
                String schoolId = SpData.getSchoolId();
                Intrinsics.checkNotNullExpressionValue(schoolId, "getSchoolId()");
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objM497getHomeDormitoryEducation0E7RQCE = dormitoryNetwork.m497getHomeDormitoryEducation0E7RQCE(classesId, schoolId, this);
                if (objM497getHomeDormitoryEducation0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                value = objM497getHomeDormitoryEducation0E7RQCE;
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

    public final void getDormitoryEducationRanking() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04401(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.dormitory.viewmodel.DormitoryViewModel$getDormitoryDetail$1, reason: invalid class name */
    /* JADX INFO: compiled from: DormitoryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.dormitory.viewmodel.DormitoryViewModel$getDormitoryDetail$1", f = "DormitoryViewModel.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DormitoryViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData2 = DormitoryViewModel.this.detailsLiveData;
                DormitoryNetwork dormitoryNetwork = DormitoryNetwork.INSTANCE;
                String siteId = SpData.getSiteId();
                Intrinsics.checkNotNullExpressionValue(siteId, "getSiteId()");
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objM496getHomeDormitoryDetailgIAlus = dormitoryNetwork.m496getHomeDormitoryDetailgIAlus(siteId, this);
                if (objM496getHomeDormitoryDetailgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                value = objM496getHomeDormitoryDetailgIAlus;
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

    public final void getDormitoryDetail() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }
}
