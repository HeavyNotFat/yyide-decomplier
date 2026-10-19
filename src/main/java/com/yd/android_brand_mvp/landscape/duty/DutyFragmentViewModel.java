package com.yd.android_brand_mvp.landscape.duty;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.duty.DutyModel;
import com.yd.android_brand_mvp.model.duty.DutyStudent;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.utils.TimeUtil;
import java.util.ArrayList;
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

/* JADX INFO: compiled from: DutyFragmentViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ(\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0012R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/duty/DutyFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "dutyListLiveData", "Landroidx/lifecycle/LiveData;", "", "Lcom/yd/android_brand_mvp/model/duty/DutyModel;", "getDutyListLiveData", "()Landroidx/lifecycle/LiveData;", "mDutyListLiveData", "Landroidx/lifecycle/MutableLiveData;", "getDutyWeekList", "", "splitList", "", "Lcom/yd/android_brand_mvp/model/duty/DutyStudent;", TUIKitConstants.Selection.LIST, "groupSize", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DutyFragmentViewModel extends ViewModel {
    private final LiveData<List<DutyModel>> dutyListLiveData;
    private final MutableLiveData<List<DutyModel>> mDutyListLiveData;

    public DutyFragmentViewModel() {
        MutableLiveData<List<DutyModel>> mutableLiveData = new MutableLiveData<>();
        this.mDutyListLiveData = mutableLiveData;
        this.dutyListLiveData = mutableLiveData;
    }

    public final LiveData<List<DutyModel>> getDutyListLiveData() {
        return this.dutyListLiveData;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.duty.DutyFragmentViewModel$getDutyWeekList$1, reason: invalid class name */
    /* JADX INFO: compiled from: DutyFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.duty.DutyFragmentViewModel$getDutyWeekList$1", f = "DutyFragmentViewModel.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DutyFragmentViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM429getDutyWeekListgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                map.put("week", TimeUtil.getWeek2(System.currentTimeMillis()));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(map);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                this.label = 1;
                objM429getDutyWeekListgIAlus = NetworkApi.INSTANCE.m429getDutyWeekListgIAlus(requestBodyCreate, this);
                if (objM429getDutyWeekListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM429getDutyWeekListgIAlus = ((Result) obj).getValue();
            }
            MutableLiveData mutableLiveData = DutyFragmentViewModel.this.mDutyListLiveData;
            if (Result.m597isFailureimpl(objM429getDutyWeekListgIAlus)) {
                objM429getDutyWeekListgIAlus = null;
            }
            mutableLiveData.setValue(objM429getDutyWeekListgIAlus);
            return Unit.INSTANCE;
        }
    }

    public final void getDutyWeekList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final List<List<DutyStudent>> splitList(List<DutyStudent> list, int groupSize) {
        Intrinsics.checkNotNullParameter(list, "list");
        int size = list.size();
        int i = ((size + groupSize) - 1) / groupSize;
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 * groupSize;
            i2++;
            arrayList.add(list.subList(i3, Math.min(i2 * groupSize, size)));
        }
        return arrayList;
    }
}
