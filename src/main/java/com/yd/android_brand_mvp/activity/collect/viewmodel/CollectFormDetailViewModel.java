package com.yd.android_brand_mvp.activity.collect.viewmodel;

import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.activity.collect.fragment.BaseCollectFragment;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.collect.FormDetailBean;
import com.yd.android_brand_mvp.model.collect.UpdateFormStatus;
import com.yd.android_brand_mvp.network.collect.CollectNetWork;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yyide.facepass.AppExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: CollectFormDetailViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0010\u0010!\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\"\u001a\u00020#J\u0016\u0010\u0016\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&J\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0006\u0010)\u001a\u00020$J\u0014\u0010*\u001a\u00020$2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0014\u0010,\u001a\u00020$2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0016\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020&R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\fø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0012X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00140\fø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00140\u0012X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/viewmodel/CollectFormDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "componentFragmentList", "", "Landroidx/fragment/app/Fragment;", "getComponentFragmentList", "()Ljava/util/List;", "componentFrameView", "Landroid/widget/FrameLayout;", "getComponentFrameView", "componentList", "Landroidx/lifecycle/LiveData;", "", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "getComponentList", "()Landroidx/lifecycle/LiveData;", "componentListLiveData", "Landroidx/lifecycle/MutableLiveData;", "formDetail", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/collect/FormDetailBean;", "getFormDetail", "formDetailLiveData", "ruleComponentList", "submitResult", "", "getSubmitResult", "submitResultLiveData", "updateSort", "Lcom/yd/android_brand_mvp/model/collect/UpdateFormStatus;", "getUpdateSort", "()Landroidx/lifecycle/MutableLiveData;", "getComponentData", "sort", "", "", "formId", "", "checkId", "getRuleComponentData", "getUpdateComponentListStatus", "setComponentData", "data", "setRuleComponentData", "submitFormContent", "id", CommentsHomeFragment.TYPE_ID, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CollectFormDetailViewModel extends ViewModel {
    private final LiveData<List<FormBaseBean>> componentList;
    private final MutableLiveData<List<FormBaseBean>> componentListLiveData;
    private final LiveData<Result<FormDetailBean>> formDetail;
    private final MutableLiveData<Result<FormDetailBean>> formDetailLiveData;
    private final LiveData<Result<Boolean>> submitResult;
    private final MutableLiveData<Result<Boolean>> submitResultLiveData;
    private final MutableLiveData<UpdateFormStatus> updateSort = new MutableLiveData<>();
    private final List<Fragment> componentFragmentList = new ArrayList();
    private final List<FrameLayout> componentFrameView = new ArrayList();
    private final List<FormBaseBean> ruleComponentList = new ArrayList();

    public CollectFormDetailViewModel() {
        MutableLiveData<List<FormBaseBean>> mutableLiveData = new MutableLiveData<>();
        this.componentListLiveData = mutableLiveData;
        this.componentList = mutableLiveData;
        MutableLiveData<Result<FormDetailBean>> mutableLiveData2 = new MutableLiveData<>();
        this.formDetailLiveData = mutableLiveData2;
        this.formDetail = mutableLiveData2;
        MutableLiveData<Result<Boolean>> mutableLiveData3 = new MutableLiveData<>();
        this.submitResultLiveData = mutableLiveData3;
        this.submitResult = mutableLiveData3;
    }

    public final MutableLiveData<UpdateFormStatus> getUpdateSort() {
        return this.updateSort;
    }

    public final List<Fragment> getComponentFragmentList() {
        return this.componentFragmentList;
    }

    public final List<FrameLayout> getComponentFrameView() {
        return this.componentFrameView;
    }

    public final LiveData<List<FormBaseBean>> getComponentList() {
        return this.componentList;
    }

    public final LiveData<Result<FormDetailBean>> getFormDetail() {
        return this.formDetail;
    }

    public final LiveData<Result<Boolean>> getSubmitResult() {
        return this.submitResult;
    }

    public final void setComponentData(List<FormBaseBean> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.componentListLiveData.setValue(data);
    }

    public final List<FormBaseBean> getComponentData() {
        List<FormBaseBean> value = this.componentList.getValue();
        return value == null ? CollectionsKt.emptyList() : value;
    }

    public final FormBaseBean getComponentData(int sort) {
        List<FormBaseBean> value = this.componentList.getValue();
        if (value == null) {
            value = CollectionsKt.emptyList();
        }
        if (value.isEmpty() || sort < 0 || sort >= value.size()) {
            return null;
        }
        return value.get(sort);
    }

    public final void setRuleComponentData(List<FormBaseBean> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.ruleComponentList.clear();
        this.ruleComponentList.addAll(data);
    }

    public final List<FormBaseBean> getRuleComponentData() {
        return this.ruleComponentList;
    }

    public final void getUpdateComponentListStatus() {
        int i;
        for (FormBaseBean formBaseBean : this.ruleComponentList) {
            Map<String, List<String>> showExpression = formBaseBean.getProps().getShowExpression();
            boolean z = true;
            if (!showExpression.isEmpty()) {
                Set<String> setKeySet = showExpression.keySet();
                AppExtKt.logd(this, "keys = " + setKeySet);
                Iterator<String> it2 = setKeySet.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = false;
                        break;
                    }
                    String next = it2.next();
                    int i2 = Integer.parseInt(next);
                    List list = (List) MapsKt.getValue(showExpression, next);
                    AppExtKt.logd(this, "keyValue = " + list);
                    if (!list.isEmpty() && (i = i2 - 1) < this.componentFragmentList.size()) {
                        Fragment fragment = this.componentFragmentList.get(i);
                        BaseCollectFragment baseCollectFragment = fragment instanceof BaseCollectFragment ? (BaseCollectFragment) fragment : null;
                        List<String> selectList = baseCollectFragment != null ? baseCollectFragment.getSelectList() : null;
                        List<String> list2 = selectList;
                        if (!(list2 == null || list2.isEmpty()) && selectList.containsAll(list)) {
                            break;
                        }
                    }
                }
                this.updateSort.setValue(new UpdateFormStatus(formBaseBean.getSort(), z));
            }
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.viewmodel.CollectFormDetailViewModel$getFormDetail$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollectFormDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.collect.viewmodel.CollectFormDetailViewModel$getFormDetail$1", f = "CollectFormDetailViewModel.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $checkId;
        final /* synthetic */ String $formId;
        Object L$0;
        int label;
        final /* synthetic */ CollectFormDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, CollectFormDetailViewModel collectFormDetailViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$formId = str;
            this.$checkId = str2;
            this.this$0 = collectFormDetailViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$formId, this.$checkId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM488getFormDetailgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("id", this.$formId);
                map2.put(CommentsHomeFragment.TYPE_ID, this.$checkId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.formDetailLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM488getFormDetailgIAlus = CollectNetWork.INSTANCE.m488getFormDetailgIAlus(requestBodyCreate, this);
                if (objM488getFormDetailgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM488getFormDetailgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM488getFormDetailgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getFormDetail(String formId, String checkId) {
        Intrinsics.checkNotNullParameter(formId, "formId");
        Intrinsics.checkNotNullParameter(checkId, "checkId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(formId, checkId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.viewmodel.CollectFormDetailViewModel$submitFormContent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectFormDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.collect.viewmodel.CollectFormDetailViewModel$submitFormContent$1", f = "CollectFormDetailViewModel.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
    static final class C03141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        final /* synthetic */ String $studentId;
        Object L$0;
        int label;
        final /* synthetic */ CollectFormDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03141(String str, CollectFormDetailViewModel collectFormDetailViewModel, String str2, Continuation<? super C03141> continuation) {
            super(2, continuation);
            this.$id = str;
            this.this$0 = collectFormDetailViewModel;
            this.$studentId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03141(this.$id, this.this$0, this.$studentId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM492submitFormContentgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("id", this.$id);
                map2.put("components", this.this$0.getComponentData());
                map2.put(CommentsHomeFragment.TYPE_ID, this.$studentId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.submitResultLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM492submitFormContentgIAlus = CollectNetWork.INSTANCE.m492submitFormContentgIAlus(requestBodyCreate, this);
                if (objM492submitFormContentgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM492submitFormContentgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM492submitFormContentgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void submitFormContent(String id, String studentId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03141(id, this, studentId, null), 3, null);
    }
}
