package com.yd.android_brand_mvp.activity.collect.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.collect.StudentClassesBean;
import com.yd.android_brand_mvp.network.collect.CollectNetWork;
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

/* JADX INFO: compiled from: FormStudentViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/viewmodel/FormStudentViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "studentClasses", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/collect/StudentClassesBean;", "getStudentClasses", "()Landroidx/lifecycle/LiveData;", "studentClassesLiveData", "Landroidx/lifecycle/MutableLiveData;", "", CommentsHomeFragment.TYPE_ID, "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormStudentViewModel extends ViewModel {
    private final LiveData<Result<StudentClassesBean>> studentClasses;
    private final MutableLiveData<Result<StudentClassesBean>> studentClassesLiveData;

    public FormStudentViewModel() {
        MutableLiveData<Result<StudentClassesBean>> mutableLiveData = new MutableLiveData<>();
        this.studentClassesLiveData = mutableLiveData;
        this.studentClasses = mutableLiveData;
    }

    public final LiveData<Result<StudentClassesBean>> getStudentClasses() {
        return this.studentClasses;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.viewmodel.FormStudentViewModel$getStudentClasses$1, reason: invalid class name */
    /* JADX INFO: compiled from: FormStudentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.collect.viewmodel.FormStudentViewModel$getStudentClasses$1", f = "FormStudentViewModel.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $studentId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$studentId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FormStudentViewModel.this.new AnonymousClass1(this.$studentId, continuation);
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
                MutableLiveData mutableLiveData2 = FormStudentViewModel.this.studentClassesLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objM490getStudentClassesgIAlus = CollectNetWork.INSTANCE.m490getStudentClassesgIAlus(this.$studentId, this);
                if (objM490getStudentClassesgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                value = objM490getStudentClassesgIAlus;
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

    public final void getStudentClasses(String studentId) {
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(studentId, null), 3, null);
    }
}
