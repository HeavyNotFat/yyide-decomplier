package com.yd.android_brand_mvp.network.exam;

import com.yd.android_brand_mvp.model.BrandConfigBean;
import com.yd.android_brand_mvp.model.exam.ExamArrangementBean;
import com.yd.android_brand_mvp.model.exam.ExamPersonSeatBean;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
import com.yd.android_brand_mvp.network.base.BaseNetworkApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: ExamManageNetwork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u000e\u0010\nJ0\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\f0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0010\u0010\nJ0\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\f0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0012\u0010\nJ0\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0015\u0010\nJ*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ*\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001e\u0010\n\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/network/exam/ExamManageNetwork;", "Lcom/yd/android_brand_mvp/network/base/BaseNetworkApi;", "Lcom/yd/android_brand_mvp/network/exam/IExamManageService;", "()V", "getExamDetail", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "requestBody", "Lokhttp3/RequestBody;", "getExamDetail-gIAlu-s", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExamSeat", "", "Lcom/yd/android_brand_mvp/model/exam/ExamPersonSeatBean;", "getExamSeat-gIAlu-s", "getTodayExam", "getTodayExam-gIAlu-s", "getUserExamList", "getUserExamList-gIAlu-s", "getWeekExam", "Lcom/yd/android_brand_mvp/model/exam/ExamArrangementBean;", "getWeekExam-gIAlu-s", "requestDeviceConfig", "Lcom/yd/android_brand_mvp/model/BrandConfigBean;", "deviceNo", "", "requestDeviceConfig-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signInExam", "", "signInExam-gIAlu-s", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExamManageNetwork extends BaseNetworkApi<IExamManageService> {
    public static final ExamManageNetwork INSTANCE = new ExamManageNetwork();

    private ExamManageNetwork() {
        super("https://api.yyide.com");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getTodayExam-gIAlu-s, reason: not valid java name */
    public final Object m508getTodayExamgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<ExamPlanItem>>> continuation) {
        ExamManageNetwork$getTodayExam$1 examManageNetwork$getTodayExam$1;
        if (continuation instanceof ExamManageNetwork$getTodayExam$1) {
            examManageNetwork$getTodayExam$1 = (ExamManageNetwork$getTodayExam$1) continuation;
            if ((examManageNetwork$getTodayExam$1.label & Integer.MIN_VALUE) != 0) {
                examManageNetwork$getTodayExam$1.label -= Integer.MIN_VALUE;
            } else {
                examManageNetwork$getTodayExam$1 = new ExamManageNetwork$getTodayExam$1(this, continuation);
            }
        } else {
            examManageNetwork$getTodayExam$1 = new ExamManageNetwork$getTodayExam$1(this, continuation);
        }
        Object obj = examManageNetwork$getTodayExam$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = examManageNetwork$getTodayExam$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        ExamManageNetwork$getTodayExam$2 examManageNetwork$getTodayExam$2 = new ExamManageNetwork$getTodayExam$2(requestBody, null);
        examManageNetwork$getTodayExam$1.label = 1;
        Object obj2 = m485getResultgIAlus(examManageNetwork$getTodayExam$2, examManageNetwork$getTodayExam$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getWeekExam-gIAlu-s, reason: not valid java name */
    public final Object m510getWeekExamgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<ExamArrangementBean>>> continuation) {
        ExamManageNetwork$getWeekExam$1 examManageNetwork$getWeekExam$1;
        if (continuation instanceof ExamManageNetwork$getWeekExam$1) {
            examManageNetwork$getWeekExam$1 = (ExamManageNetwork$getWeekExam$1) continuation;
            if ((examManageNetwork$getWeekExam$1.label & Integer.MIN_VALUE) != 0) {
                examManageNetwork$getWeekExam$1.label -= Integer.MIN_VALUE;
            } else {
                examManageNetwork$getWeekExam$1 = new ExamManageNetwork$getWeekExam$1(this, continuation);
            }
        } else {
            examManageNetwork$getWeekExam$1 = new ExamManageNetwork$getWeekExam$1(this, continuation);
        }
        Object obj = examManageNetwork$getWeekExam$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = examManageNetwork$getWeekExam$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        ExamManageNetwork$getWeekExam$2 examManageNetwork$getWeekExam$2 = new ExamManageNetwork$getWeekExam$2(requestBody, null);
        examManageNetwork$getWeekExam$1.label = 1;
        Object obj2 = m485getResultgIAlus(examManageNetwork$getWeekExam$2, examManageNetwork$getWeekExam$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getExamSeat-gIAlu-s, reason: not valid java name */
    public final Object m507getExamSeatgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<ExamPersonSeatBean>>> continuation) {
        ExamManageNetwork$getExamSeat$1 examManageNetwork$getExamSeat$1;
        if (continuation instanceof ExamManageNetwork$getExamSeat$1) {
            examManageNetwork$getExamSeat$1 = (ExamManageNetwork$getExamSeat$1) continuation;
            if ((examManageNetwork$getExamSeat$1.label & Integer.MIN_VALUE) != 0) {
                examManageNetwork$getExamSeat$1.label -= Integer.MIN_VALUE;
            } else {
                examManageNetwork$getExamSeat$1 = new ExamManageNetwork$getExamSeat$1(this, continuation);
            }
        } else {
            examManageNetwork$getExamSeat$1 = new ExamManageNetwork$getExamSeat$1(this, continuation);
        }
        Object obj = examManageNetwork$getExamSeat$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = examManageNetwork$getExamSeat$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        ExamManageNetwork$getExamSeat$2 examManageNetwork$getExamSeat$2 = new ExamManageNetwork$getExamSeat$2(requestBody, null);
        examManageNetwork$getExamSeat$1.label = 1;
        Object obj2 = m485getResultgIAlus(examManageNetwork$getExamSeat$2, examManageNetwork$getExamSeat$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getExamDetail-gIAlu-s, reason: not valid java name */
    public final Object m506getExamDetailgIAlus(RequestBody requestBody, Continuation<? super Result<ExamPlanItem>> continuation) {
        ExamManageNetwork$getExamDetail$1 examManageNetwork$getExamDetail$1;
        if (continuation instanceof ExamManageNetwork$getExamDetail$1) {
            examManageNetwork$getExamDetail$1 = (ExamManageNetwork$getExamDetail$1) continuation;
            if ((examManageNetwork$getExamDetail$1.label & Integer.MIN_VALUE) != 0) {
                examManageNetwork$getExamDetail$1.label -= Integer.MIN_VALUE;
            } else {
                examManageNetwork$getExamDetail$1 = new ExamManageNetwork$getExamDetail$1(this, continuation);
            }
        } else {
            examManageNetwork$getExamDetail$1 = new ExamManageNetwork$getExamDetail$1(this, continuation);
        }
        Object obj = examManageNetwork$getExamDetail$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = examManageNetwork$getExamDetail$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        ExamManageNetwork$getExamDetail$2 examManageNetwork$getExamDetail$2 = new ExamManageNetwork$getExamDetail$2(requestBody, null);
        examManageNetwork$getExamDetail$1.label = 1;
        Object obj2 = m485getResultgIAlus(examManageNetwork$getExamDetail$2, examManageNetwork$getExamDetail$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getUserExamList-gIAlu-s, reason: not valid java name */
    public final Object m509getUserExamListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<ExamPlanItem>>> continuation) {
        ExamManageNetwork$getUserExamList$1 examManageNetwork$getUserExamList$1;
        if (continuation instanceof ExamManageNetwork$getUserExamList$1) {
            examManageNetwork$getUserExamList$1 = (ExamManageNetwork$getUserExamList$1) continuation;
            if ((examManageNetwork$getUserExamList$1.label & Integer.MIN_VALUE) != 0) {
                examManageNetwork$getUserExamList$1.label -= Integer.MIN_VALUE;
            } else {
                examManageNetwork$getUserExamList$1 = new ExamManageNetwork$getUserExamList$1(this, continuation);
            }
        } else {
            examManageNetwork$getUserExamList$1 = new ExamManageNetwork$getUserExamList$1(this, continuation);
        }
        Object obj = examManageNetwork$getUserExamList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = examManageNetwork$getUserExamList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        ExamManageNetwork$getUserExamList$2 examManageNetwork$getUserExamList$2 = new ExamManageNetwork$getUserExamList$2(requestBody, null);
        examManageNetwork$getUserExamList$1.label = 1;
        Object obj2 = m485getResultgIAlus(examManageNetwork$getUserExamList$2, examManageNetwork$getUserExamList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: signInExam-gIAlu-s, reason: not valid java name */
    public final Object m512signInExamgIAlus(RequestBody requestBody, Continuation<? super Result<Boolean>> continuation) {
        ExamManageNetwork$signInExam$1 examManageNetwork$signInExam$1;
        if (continuation instanceof ExamManageNetwork$signInExam$1) {
            examManageNetwork$signInExam$1 = (ExamManageNetwork$signInExam$1) continuation;
            if ((examManageNetwork$signInExam$1.label & Integer.MIN_VALUE) != 0) {
                examManageNetwork$signInExam$1.label -= Integer.MIN_VALUE;
            } else {
                examManageNetwork$signInExam$1 = new ExamManageNetwork$signInExam$1(this, continuation);
            }
        } else {
            examManageNetwork$signInExam$1 = new ExamManageNetwork$signInExam$1(this, continuation);
        }
        Object obj = examManageNetwork$signInExam$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = examManageNetwork$signInExam$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        ExamManageNetwork$signInExam$2 examManageNetwork$signInExam$2 = new ExamManageNetwork$signInExam$2(requestBody, null);
        examManageNetwork$signInExam$1.label = 1;
        Object obj2 = m485getResultgIAlus(examManageNetwork$signInExam$2, examManageNetwork$signInExam$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestDeviceConfig-gIAlu-s, reason: not valid java name */
    public final Object m511requestDeviceConfiggIAlus(String str, Continuation<? super Result<BrandConfigBean>> continuation) {
        ExamManageNetwork$requestDeviceConfig$1 examManageNetwork$requestDeviceConfig$1;
        if (continuation instanceof ExamManageNetwork$requestDeviceConfig$1) {
            examManageNetwork$requestDeviceConfig$1 = (ExamManageNetwork$requestDeviceConfig$1) continuation;
            if ((examManageNetwork$requestDeviceConfig$1.label & Integer.MIN_VALUE) != 0) {
                examManageNetwork$requestDeviceConfig$1.label -= Integer.MIN_VALUE;
            } else {
                examManageNetwork$requestDeviceConfig$1 = new ExamManageNetwork$requestDeviceConfig$1(this, continuation);
            }
        } else {
            examManageNetwork$requestDeviceConfig$1 = new ExamManageNetwork$requestDeviceConfig$1(this, continuation);
        }
        Object obj = examManageNetwork$requestDeviceConfig$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = examManageNetwork$requestDeviceConfig$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        ExamManageNetwork$requestDeviceConfig$2 examManageNetwork$requestDeviceConfig$2 = new ExamManageNetwork$requestDeviceConfig$2(str, null);
        examManageNetwork$requestDeviceConfig$1.label = 1;
        Object obj2 = m485getResultgIAlus(examManageNetwork$requestDeviceConfig$2, examManageNetwork$requestDeviceConfig$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }
}
