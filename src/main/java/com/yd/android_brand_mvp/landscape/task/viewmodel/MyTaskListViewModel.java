package com.yd.android_brand_mvp.landscape.task.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.task.MyTaskListBean;
import com.yd.android_brand_mvp.network.task.TaskSignNetwork;
import java.util.LinkedHashMap;
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

/* JADX INFO: compiled from: MyTaskListViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u000f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013R \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/task/viewmodel/MyTaskListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "endList", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/task/MyTaskListBean;", "getEndList", "()Landroidx/lifecycle/LiveData;", "endListLiveData", "Landroidx/lifecycle/MutableLiveData;", "ingList", "getIngList", "ingListLiveData", "noStartList", "getNoStartList", "noStartListLiveData", "", "status", "", "no", "", InnerConstant.Db.size, CommentsHomeFragment.TYPE_ID, "schoolId", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MyTaskListViewModel extends ViewModel {
    private final LiveData<Result<MyTaskListBean>> endList;
    private final MutableLiveData<Result<MyTaskListBean>> endListLiveData;
    private final LiveData<Result<MyTaskListBean>> ingList;
    private final MutableLiveData<Result<MyTaskListBean>> ingListLiveData;
    private final LiveData<Result<MyTaskListBean>> noStartList;
    private final MutableLiveData<Result<MyTaskListBean>> noStartListLiveData;

    public MyTaskListViewModel() {
        MutableLiveData<Result<MyTaskListBean>> mutableLiveData = new MutableLiveData<>();
        this.noStartListLiveData = mutableLiveData;
        this.noStartList = mutableLiveData;
        MutableLiveData<Result<MyTaskListBean>> mutableLiveData2 = new MutableLiveData<>();
        this.ingListLiveData = mutableLiveData2;
        this.ingList = mutableLiveData2;
        MutableLiveData<Result<MyTaskListBean>> mutableLiveData3 = new MutableLiveData<>();
        this.endListLiveData = mutableLiveData3;
        this.endList = mutableLiveData3;
    }

    public final LiveData<Result<MyTaskListBean>> getNoStartList() {
        return this.noStartList;
    }

    public final LiveData<Result<MyTaskListBean>> getIngList() {
        return this.ingList;
    }

    public final LiveData<Result<MyTaskListBean>> getEndList() {
        return this.endList;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.task.viewmodel.MyTaskListViewModel$getNoStartList$1, reason: invalid class name */
    /* JADX INFO: compiled from: MyTaskListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.task.viewmodel.MyTaskListViewModel$getNoStartList$1", f = "MyTaskListViewModel.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $no;
        final /* synthetic */ String $schoolId;
        final /* synthetic */ int $size;
        final /* synthetic */ String $status;
        final /* synthetic */ String $studentId;
        int label;
        final /* synthetic */ MyTaskListViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, int i, int i2, String str2, String str3, MyTaskListViewModel myTaskListViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$status = str;
            this.$no = i;
            this.$size = i2;
            this.$studentId = str2;
            this.$schoolId = str3;
            this.this$0 = myTaskListViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$status, this.$no, this.$size, this.$studentId, this.$schoolId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM536getMyTaskListgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("status", this.$status);
                linkedHashMap.put("pageNo", Boxing.boxInt(this.$no));
                linkedHashMap.put("pageSize", Boxing.boxInt(this.$size));
                linkedHashMap.put(CommentsHomeFragment.TYPE_ID, this.$studentId);
                linkedHashMap.put("schoolId", this.$schoolId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                this.label = 1;
                objM536getMyTaskListgIAlus = TaskSignNetwork.INSTANCE.m536getMyTaskListgIAlus(requestBodyCreate, this);
                if (objM536getMyTaskListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM536getMyTaskListgIAlus = ((Result) obj).getValue();
            }
            String str = this.$status;
            int iHashCode = str.hashCode();
            if (iHashCode != -753541113) {
                if (iHashCode != 100571) {
                    if (iHashCode == 1627662326 && str.equals("not_start")) {
                        this.this$0.noStartListLiveData.setValue(Result.m590boximpl(objM536getMyTaskListgIAlus));
                    }
                } else if (str.equals("end")) {
                    this.this$0.endListLiveData.setValue(Result.m590boximpl(objM536getMyTaskListgIAlus));
                }
            } else if (str.equals("in_progress")) {
                this.this$0.ingListLiveData.setValue(Result.m590boximpl(objM536getMyTaskListgIAlus));
            }
            return Unit.INSTANCE;
        }
    }

    public final void getNoStartList(String status, int no2, int size, String studentId, String schoolId) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(status, no2, size, studentId, schoolId, this, null), 3, null);
    }
}
