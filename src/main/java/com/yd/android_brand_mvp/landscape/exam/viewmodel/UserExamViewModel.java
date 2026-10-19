package com.yd.android_brand_mvp.landscape.exam.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
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

/* JADX INFO: compiled from: UserExamViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR&\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u000bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/viewmodel/UserExamViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "studentExam", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "getStudentExam", "()Landroidx/lifecycle/LiveData;", "studentExamLiveData", "Landroidx/lifecycle/MutableLiveData;", "getStudentExamList", "", CommentsHomeFragment.TYPE_ID, "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UserExamViewModel extends ViewModel {
    private final LiveData<Result<List<ExamPlanItem>>> studentExam;
    private final MutableLiveData<Result<List<ExamPlanItem>>> studentExamLiveData;

    public UserExamViewModel() {
        MutableLiveData<Result<List<ExamPlanItem>>> mutableLiveData = new MutableLiveData<>();
        this.studentExamLiveData = mutableLiveData;
        this.studentExam = mutableLiveData;
    }

    public final LiveData<Result<List<ExamPlanItem>>> getStudentExam() {
        return this.studentExam;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.viewmodel.UserExamViewModel$getStudentExamList$1, reason: invalid class name */
    /* JADX INFO: compiled from: UserExamViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.viewmodel.UserExamViewModel$getStudentExamList$1", f = "UserExamViewModel.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $studentId;
        Object L$0;
        int label;
        final /* synthetic */ UserExamViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, UserExamViewModel userExamViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$studentId = str;
            this.this$0 = userExamViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$studentId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM509getUserExamListgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                map.put(CommentsHomeFragment.TYPE_ID, this.$studentId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.studentExamLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM509getUserExamListgIAlus = ExamManageNetwork.INSTANCE.m509getUserExamListgIAlus(requestBodyCreate, this);
                if (objM509getUserExamListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM509getUserExamListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM509getUserExamListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getStudentExamList(String studentId) {
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(studentId, this, null), 3, null);
    }
}
