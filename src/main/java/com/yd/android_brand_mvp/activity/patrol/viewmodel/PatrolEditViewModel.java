package com.yd.android_brand_mvp.activity.patrol.viewmodel;

import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.patrol.PatrolDetailBean;
import com.yd.android_brand_mvp.network.patrol.PatrolNetWork;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: PatrolEditViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u0016\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0014\u0010\"\u001a\u00020\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u001e\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020!R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\fø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0012X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00140\fø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00140\u0012X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/yd/android_brand_mvp/activity/patrol/viewmodel/PatrolEditViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "componentFragmentList", "", "Landroidx/fragment/app/Fragment;", "getComponentFragmentList", "()Ljava/util/List;", "componentFrameView", "Landroid/widget/FrameLayout;", "getComponentFrameView", "componentList", "Landroidx/lifecycle/LiveData;", "", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "getComponentList", "()Landroidx/lifecycle/LiveData;", "componentListLiveData", "Landroidx/lifecycle/MutableLiveData;", "patrolDetail", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/patrol/PatrolDetailBean;", "getPatrolDetail", "patrolDetailLiveData", "submitResult", "", "getSubmitResult", "submitResultLiveData", "getComponentData", "sort", "", "", "taskId", "", "setComponentData", "data", "submitPatrolTask", "formJsonStr", "userId", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PatrolEditViewModel extends ViewModel {
    private final List<Fragment> componentFragmentList = new ArrayList();
    private final List<FrameLayout> componentFrameView = new ArrayList();
    private final LiveData<List<FormBaseBean>> componentList;
    private final MutableLiveData<List<FormBaseBean>> componentListLiveData;
    private final LiveData<Result<PatrolDetailBean>> patrolDetail;
    private final MutableLiveData<Result<PatrolDetailBean>> patrolDetailLiveData;
    private final LiveData<Result<Boolean>> submitResult;
    private final MutableLiveData<Result<Boolean>> submitResultLiveData;

    public PatrolEditViewModel() {
        MutableLiveData<List<FormBaseBean>> mutableLiveData = new MutableLiveData<>();
        this.componentListLiveData = mutableLiveData;
        this.componentList = mutableLiveData;
        MutableLiveData<Result<PatrolDetailBean>> mutableLiveData2 = new MutableLiveData<>();
        this.patrolDetailLiveData = mutableLiveData2;
        this.patrolDetail = mutableLiveData2;
        MutableLiveData<Result<Boolean>> mutableLiveData3 = new MutableLiveData<>();
        this.submitResultLiveData = mutableLiveData3;
        this.submitResult = mutableLiveData3;
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

    public final LiveData<Result<PatrolDetailBean>> getPatrolDetail() {
        return this.patrolDetail;
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

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.patrol.viewmodel.PatrolEditViewModel$getPatrolDetail$1, reason: invalid class name */
    /* JADX INFO: compiled from: PatrolEditViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.patrol.viewmodel.PatrolEditViewModel$getPatrolDetail$1", f = "PatrolEditViewModel.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $taskId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$taskId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PatrolEditViewModel.this.new AnonymousClass1(this.$taskId, continuation);
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
                MutableLiveData mutableLiveData2 = PatrolEditViewModel.this.patrolDetailLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objM520getPatrolDetailgIAlus = PatrolNetWork.INSTANCE.m520getPatrolDetailgIAlus(this.$taskId, this);
                if (objM520getPatrolDetailgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                value = objM520getPatrolDetailgIAlus;
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

    public final void getPatrolDetail(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(taskId, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.patrol.viewmodel.PatrolEditViewModel$submitPatrolTask$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PatrolEditViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.patrol.viewmodel.PatrolEditViewModel$submitPatrolTask$1", f = "PatrolEditViewModel.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    static final class C03621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $formJsonStr;
        final /* synthetic */ String $taskId;
        final /* synthetic */ String $userId;
        Object L$0;
        int label;
        final /* synthetic */ PatrolEditViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03621(String str, String str2, String str3, PatrolEditViewModel patrolEditViewModel, Continuation<? super C03621> continuation) {
            super(2, continuation);
            this.$taskId = str;
            this.$formJsonStr = str2;
            this.$userId = str3;
            this.this$0 = patrolEditViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03621(this.$taskId, this.$formJsonStr, this.$userId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM524submitPatrolTaskgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("id", this.$taskId);
                linkedHashMap.put("formJson", this.$formJsonStr);
                linkedHashMap.put("userId", this.$userId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(map)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.submitResultLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM524submitPatrolTaskgIAlus = PatrolNetWork.INSTANCE.m524submitPatrolTaskgIAlus(requestBodyCreate, this);
                if (objM524submitPatrolTaskgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM524submitPatrolTaskgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM524submitPatrolTaskgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void submitPatrolTask(String taskId, String formJsonStr, String userId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(formJsonStr, "formJsonStr");
        Intrinsics.checkNotNullParameter(userId, "userId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03621(taskId, formJsonStr, userId, this, null), 3, null);
    }
}
