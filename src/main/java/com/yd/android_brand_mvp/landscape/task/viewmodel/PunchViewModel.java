package com.yd.android_brand_mvp.landscape.task.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.task.MyTaskListItem;
import com.yd.android_brand_mvp.network.task.TaskSignNetwork;
import java.util.LinkedHashMap;
import java.util.List;
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

/* JADX INFO: compiled from: PunchViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012R&\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u000bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/task/viewmodel/PunchViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "homeTaskList", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "", "Lcom/yd/android_brand_mvp/model/task/MyTaskListItem;", "getHomeTaskList", "()Landroidx/lifecycle/LiveData;", "homeTaskListLiveData", "Landroidx/lifecycle/MutableLiveData;", "getHomeList", "", "classId", "", "schoolId", "count", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PunchViewModel extends ViewModel {
    private final LiveData<Result<List<MyTaskListItem>>> homeTaskList;
    private final MutableLiveData<Result<List<MyTaskListItem>>> homeTaskListLiveData;

    public PunchViewModel() {
        MutableLiveData<Result<List<MyTaskListItem>>> mutableLiveData = new MutableLiveData<>();
        this.homeTaskListLiveData = mutableLiveData;
        this.homeTaskList = mutableLiveData;
    }

    public final LiveData<Result<List<MyTaskListItem>>> getHomeTaskList() {
        return this.homeTaskList;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.task.viewmodel.PunchViewModel$getHomeList$1, reason: invalid class name */
    /* JADX INFO: compiled from: PunchViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.task.viewmodel.PunchViewModel$getHomeList$1", f = "PunchViewModel.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $classId;
        final /* synthetic */ int $count;
        final /* synthetic */ String $schoolId;
        int label;
        final /* synthetic */ PunchViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, String str, String str2, PunchViewModel punchViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$count = i;
            this.$classId = str;
            this.$schoolId = str2;
            this.this$0 = punchViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$count, this.$classId, this.$schoolId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM538getTaskListgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("count", Boxing.boxInt(this.$count));
                String str = this.$classId;
                if (str == null) {
                    str = "";
                }
                linkedHashMap.put("classId", str);
                String str2 = this.$schoolId;
                linkedHashMap.put("schoolId", str2 != null ? str2 : "");
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                this.label = 1;
                objM538getTaskListgIAlus = TaskSignNetwork.INSTANCE.m538getTaskListgIAlus(requestBodyCreate, this);
                if (objM538getTaskListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM538getTaskListgIAlus = ((Result) obj).getValue();
            }
            this.this$0.homeTaskListLiveData.setValue(Result.m590boximpl(objM538getTaskListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void getHomeList$default(PunchViewModel punchViewModel, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 5;
        }
        punchViewModel.getHomeList(str, str2, i);
    }

    public final void getHomeList(String classId, String schoolId, int count) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(count, classId, schoolId, this, null), 3, null);
    }
}
