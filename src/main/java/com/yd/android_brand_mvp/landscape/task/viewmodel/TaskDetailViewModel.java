package com.yd.android_brand_mvp.landscape.task.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.task.AddressBookBean;
import com.yd.android_brand_mvp.model.task.TaskDetailBean;
import com.yd.android_brand_mvp.network.task.TaskSignNetwork;
import java.util.LinkedHashMap;
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

/* JADX INFO: compiled from: TaskDetailViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011J(\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011J\u001e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011R&\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u000bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u000bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u000bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/task/viewmodel/TaskDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "addressDetail", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "", "Lcom/yd/android_brand_mvp/model/task/AddressBookBean;", "getAddressDetail", "()Landroidx/lifecycle/LiveData;", "addressListLiveData", "Landroidx/lifecycle/MutableLiveData;", "detail", "Lcom/yd/android_brand_mvp/model/task/TaskDetailBean;", "getDetail", "detailLiveData", "signResult", "", "getSignResult", "signResultLiveData", "getAddressBookList", "", CommentsHomeFragment.TYPE_ID, "getTaskDetail", "id", "schoolId", "classId", "signTask", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TaskDetailViewModel extends ViewModel {
    private final LiveData<Result<List<AddressBookBean>>> addressDetail;
    private final MutableLiveData<Result<List<AddressBookBean>>> addressListLiveData;
    private final LiveData<Result<TaskDetailBean>> detail;
    private final MutableLiveData<Result<TaskDetailBean>> detailLiveData;
    private final LiveData<Result<String>> signResult;
    private final MutableLiveData<Result<String>> signResultLiveData;

    public TaskDetailViewModel() {
        MutableLiveData<Result<String>> mutableLiveData = new MutableLiveData<>();
        this.signResultLiveData = mutableLiveData;
        this.signResult = mutableLiveData;
        MutableLiveData<Result<TaskDetailBean>> mutableLiveData2 = new MutableLiveData<>();
        this.detailLiveData = mutableLiveData2;
        this.detail = mutableLiveData2;
        MutableLiveData<Result<List<AddressBookBean>>> mutableLiveData3 = new MutableLiveData<>();
        this.addressListLiveData = mutableLiveData3;
        this.addressDetail = mutableLiveData3;
    }

    public final LiveData<Result<String>> getSignResult() {
        return this.signResult;
    }

    public final LiveData<Result<TaskDetailBean>> getDetail() {
        return this.detail;
    }

    public final LiveData<Result<List<AddressBookBean>>> getAddressDetail() {
        return this.addressDetail;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.task.viewmodel.TaskDetailViewModel$getTaskDetail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TaskDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.task.viewmodel.TaskDetailViewModel$getTaskDetail$1", f = "TaskDetailViewModel.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    static final class C05261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $classId;
        final /* synthetic */ String $id;
        final /* synthetic */ String $schoolId;
        final /* synthetic */ String $studentId;
        Object L$0;
        int label;
        final /* synthetic */ TaskDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05261(String str, String str2, String str3, String str4, TaskDetailViewModel taskDetailViewModel, Continuation<? super C05261> continuation) {
            super(2, continuation);
            this.$id = str;
            this.$studentId = str2;
            this.$schoolId = str3;
            this.$classId = str4;
            this.this$0 = taskDetailViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05261(this.$id, this.$studentId, this.$schoolId, this.$classId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05261) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM537getTaskDetailgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("signTaskId", this.$id);
                linkedHashMap.put(CommentsHomeFragment.TYPE_ID, this.$studentId);
                linkedHashMap.put("schoolId", this.$schoolId);
                String str = this.$classId;
                if (str == null) {
                    str = "";
                }
                linkedHashMap.put("classId", str);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.detailLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM537getTaskDetailgIAlus = TaskSignNetwork.INSTANCE.m537getTaskDetailgIAlus(requestBodyCreate, this);
                if (objM537getTaskDetailgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM537getTaskDetailgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM537getTaskDetailgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getTaskDetail(String id, String studentId, String schoolId, String classId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05261(id, studentId, schoolId, classId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.task.viewmodel.TaskDetailViewModel$signTask$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TaskDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.task.viewmodel.TaskDetailViewModel$signTask$1", f = "TaskDetailViewModel.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
    static final class C05271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        final /* synthetic */ String $schoolId;
        final /* synthetic */ String $studentId;
        Object L$0;
        int label;
        final /* synthetic */ TaskDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05271(String str, String str2, String str3, TaskDetailViewModel taskDetailViewModel, Continuation<? super C05271> continuation) {
            super(2, continuation);
            this.$id = str;
            this.$studentId = str2;
            this.$schoolId = str3;
            this.this$0 = taskDetailViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05271(this.$id, this.$studentId, this.$schoolId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM539signTaskgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("signTaskId", this.$id);
                linkedHashMap.put(CommentsHomeFragment.TYPE_ID, this.$studentId);
                linkedHashMap.put("schoolId", this.$schoolId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.signResultLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM539signTaskgIAlus = TaskSignNetwork.INSTANCE.m539signTaskgIAlus(requestBodyCreate, this);
                if (objM539signTaskgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM539signTaskgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM539signTaskgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void signTask(String id, String studentId, String schoolId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05271(id, studentId, schoolId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.task.viewmodel.TaskDetailViewModel$getAddressBookList$1, reason: invalid class name */
    /* JADX INFO: compiled from: TaskDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.task.viewmodel.TaskDetailViewModel$getAddressBookList$1", f = "TaskDetailViewModel.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
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
            return TaskDetailViewModel.this.new AnonymousClass1(this.$studentId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Result resultM590boximpl;
            MutableLiveData mutableLiveData2;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutableLiveData = TaskDetailViewModel.this.addressListLiveData;
                String str = this.$studentId;
                if (str != null) {
                    TaskSignNetwork taskSignNetwork = TaskSignNetwork.INSTANCE;
                    this.L$0 = mutableLiveData;
                    this.label = 1;
                    Object objM535getAddressBookgIAlus = taskSignNetwork.m535getAddressBookgIAlus(str, this);
                    if (objM535getAddressBookgIAlus == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableLiveData2 = mutableLiveData;
                    value = objM535getAddressBookgIAlus;
                } else {
                    resultM590boximpl = null;
                }
                mutableLiveData.setValue(resultM590boximpl);
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableLiveData2 = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
            value = ((Result) obj).getValue();
            MutableLiveData mutableLiveData3 = mutableLiveData2;
            resultM590boximpl = Result.m590boximpl(value);
            mutableLiveData = mutableLiveData3;
            mutableLiveData.setValue(resultM590boximpl);
            return Unit.INSTANCE;
        }
    }

    public final void getAddressBookList(String studentId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(studentId, null), 3, null);
    }
}
