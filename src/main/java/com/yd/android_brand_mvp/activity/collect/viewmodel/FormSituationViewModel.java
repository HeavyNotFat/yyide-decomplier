package com.yd.android_brand_mvp.activity.collect.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.collect.CollectSituationBean;
import com.yd.android_brand_mvp.network.collect.CollectNetWork;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.HashMap;
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

/* JADX INFO: compiled from: FormSituationViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/viewmodel/FormSituationViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "reportSituation", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/collect/CollectSituationBean;", "getReportSituation", "()Landroidx/lifecycle/LiveData;", "reportSituationLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "formId", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormSituationViewModel extends ViewModel {
    private final LiveData<Result<CollectSituationBean>> reportSituation;
    private final MutableLiveData<Result<CollectSituationBean>> reportSituationLiveData;

    public FormSituationViewModel() {
        MutableLiveData<Result<CollectSituationBean>> mutableLiveData = new MutableLiveData<>();
        this.reportSituationLiveData = mutableLiveData;
        this.reportSituation = mutableLiveData;
    }

    public final LiveData<Result<CollectSituationBean>> getReportSituation() {
        return this.reportSituation;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.viewmodel.FormSituationViewModel$getReportSituation$1, reason: invalid class name */
    /* JADX INFO: compiled from: FormSituationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.collect.viewmodel.FormSituationViewModel$getReportSituation$1", f = "FormSituationViewModel.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $formId;
        Object L$0;
        int label;
        final /* synthetic */ FormSituationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, FormSituationViewModel formSituationViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$formId = str;
            this.this$0 = formSituationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$formId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM487getCollectSituationgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                map.put("id", this.$formId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.reportSituationLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM487getCollectSituationgIAlus = CollectNetWork.INSTANCE.m487getCollectSituationgIAlus(requestBodyCreate, this);
                if (objM487getCollectSituationgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM487getCollectSituationgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM487getCollectSituationgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getReportSituation(String formId) {
        Intrinsics.checkNotNullParameter(formId, "formId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(formId, this, null), 3, null);
    }
}
