package com.yd.android_brand_mvp.landscape.university.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.TableDataBean;
import com.yd.android_brand_mvp.utils.SpData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: UniversityMusicTableViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/viewmodel/UniversityMusicTableViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "kbRspData", "Landroidx/lifecycle/LiveData;", "Lcom/yd/android_brand_mvp/model/TableDataBean;", "getKbRspData", "()Landroidx/lifecycle/LiveData;", "kbRspLiveData", "Landroidx/lifecycle/MutableLiveData;", "getKbData", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UniversityMusicTableViewModel extends ViewModel {
    private final LiveData<TableDataBean> kbRspData;
    private final MutableLiveData<TableDataBean> kbRspLiveData;

    public UniversityMusicTableViewModel() {
        MutableLiveData<TableDataBean> mutableLiveData = new MutableLiveData<>();
        this.kbRspLiveData = mutableLiveData;
        this.kbRspData = mutableLiveData;
    }

    public final LiveData<TableDataBean> getKbRspData() {
        return this.kbRspData;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityMusicTableViewModel$getKbData$1, reason: invalid class name */
    /* JADX INFO: compiled from: UniversityMusicTableViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityMusicTableViewModel$getKbData$1", f = "UniversityMusicTableViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UniversityMusicTableViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TableDataBean tableDataBean = new TableDataBean(0, null, 3, null);
            KBRsp2 siteKBData = SpData.getSiteKBData();
            if (siteKBData == null && (siteKBData = SpData.KBData()) != null) {
                tableDataBean.setType(2);
            }
            if (siteKBData != null) {
                tableDataBean.setData(siteKBData);
                UniversityMusicTableViewModel.this.kbRspLiveData.postValue(tableDataBean);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getKbData() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }
}
