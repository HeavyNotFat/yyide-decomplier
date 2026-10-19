package com.yd.android_brand_mvp.network.dormitory;

import com.yd.android_brand_mvp.model.dormitory.DormitoryDetailsBean;
import com.yd.android_brand_mvp.model.dormitory.DormitoryEducationBean;
import com.yd.android_brand_mvp.network.base.BaseNetworkApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: compiled from: DormitoryNetwork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/yd/android_brand_mvp/network/dormitory/DormitoryNetwork;", "Lcom/yd/android_brand_mvp/network/base/BaseNetworkApi;", "Lcom/yd/android_brand_mvp/network/dormitory/IDormitoryService;", "()V", "getHomeDormitoryDetail", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/dormitory/DormitoryDetailsBean;", "id", "", "getHomeDormitoryDetail-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHomeDormitoryEducation", "Lcom/yd/android_brand_mvp/model/dormitory/DormitoryEducationBean;", "classId", "schoolId", "getHomeDormitoryEducation-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DormitoryNetwork extends BaseNetworkApi<IDormitoryService> {
    public static final DormitoryNetwork INSTANCE = new DormitoryNetwork();

    private DormitoryNetwork() {
        super("https://api.yyide.com");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getHomeDormitoryEducation-0E7RQCE, reason: not valid java name */
    public final Object m497getHomeDormitoryEducation0E7RQCE(String str, String str2, Continuation<? super Result<DormitoryEducationBean>> continuation) {
        DormitoryNetwork$getHomeDormitoryEducation$1 dormitoryNetwork$getHomeDormitoryEducation$1;
        if (continuation instanceof DormitoryNetwork$getHomeDormitoryEducation$1) {
            dormitoryNetwork$getHomeDormitoryEducation$1 = (DormitoryNetwork$getHomeDormitoryEducation$1) continuation;
            if ((dormitoryNetwork$getHomeDormitoryEducation$1.label & Integer.MIN_VALUE) != 0) {
                dormitoryNetwork$getHomeDormitoryEducation$1.label -= Integer.MIN_VALUE;
            } else {
                dormitoryNetwork$getHomeDormitoryEducation$1 = new DormitoryNetwork$getHomeDormitoryEducation$1(this, continuation);
            }
        } else {
            dormitoryNetwork$getHomeDormitoryEducation$1 = new DormitoryNetwork$getHomeDormitoryEducation$1(this, continuation);
        }
        Object obj = dormitoryNetwork$getHomeDormitoryEducation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = dormitoryNetwork$getHomeDormitoryEducation$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        DormitoryNetwork$getHomeDormitoryEducation$2 dormitoryNetwork$getHomeDormitoryEducation$2 = new DormitoryNetwork$getHomeDormitoryEducation$2(str2, str, null);
        dormitoryNetwork$getHomeDormitoryEducation$1.label = 1;
        Object obj2 = m485getResultgIAlus(dormitoryNetwork$getHomeDormitoryEducation$2, dormitoryNetwork$getHomeDormitoryEducation$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getHomeDormitoryDetail-gIAlu-s, reason: not valid java name */
    public final Object m496getHomeDormitoryDetailgIAlus(String str, Continuation<? super Result<DormitoryDetailsBean>> continuation) {
        DormitoryNetwork$getHomeDormitoryDetail$1 dormitoryNetwork$getHomeDormitoryDetail$1;
        if (continuation instanceof DormitoryNetwork$getHomeDormitoryDetail$1) {
            dormitoryNetwork$getHomeDormitoryDetail$1 = (DormitoryNetwork$getHomeDormitoryDetail$1) continuation;
            if ((dormitoryNetwork$getHomeDormitoryDetail$1.label & Integer.MIN_VALUE) != 0) {
                dormitoryNetwork$getHomeDormitoryDetail$1.label -= Integer.MIN_VALUE;
            } else {
                dormitoryNetwork$getHomeDormitoryDetail$1 = new DormitoryNetwork$getHomeDormitoryDetail$1(this, continuation);
            }
        } else {
            dormitoryNetwork$getHomeDormitoryDetail$1 = new DormitoryNetwork$getHomeDormitoryDetail$1(this, continuation);
        }
        Object obj = dormitoryNetwork$getHomeDormitoryDetail$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = dormitoryNetwork$getHomeDormitoryDetail$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        DormitoryNetwork$getHomeDormitoryDetail$2 dormitoryNetwork$getHomeDormitoryDetail$2 = new DormitoryNetwork$getHomeDormitoryDetail$2(str, null);
        dormitoryNetwork$getHomeDormitoryDetail$1.label = 1;
        Object obj2 = m485getResultgIAlus(dormitoryNetwork$getHomeDormitoryDetail$2, dormitoryNetwork$getHomeDormitoryDetail$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }
}
