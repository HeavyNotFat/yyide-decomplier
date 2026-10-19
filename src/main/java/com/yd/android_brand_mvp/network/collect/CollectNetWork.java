package com.yd.android_brand_mvp.network.collect;

import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.collect.CollectListBean;
import com.yd.android_brand_mvp.model.collect.CollectSituationBean;
import com.yd.android_brand_mvp.model.collect.DeptListBean;
import com.yd.android_brand_mvp.model.collect.FormDetailBean;
import com.yd.android_brand_mvp.model.collect.HomeCollectBean;
import com.yd.android_brand_mvp.model.collect.StudentClassesBean;
import com.yd.android_brand_mvp.network.base.BaseNetworkApi;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: CollectNetWork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J6\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u00052\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\fJ*\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0012\u0010\fJ6\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00070\u00060\u00052\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0015\u0010\fJ*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ8\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00070\u00052\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0019H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b \u0010!J*\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00052\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b$\u0010\f\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lcom/yd/android_brand_mvp/network/collect/CollectNetWork;", "Lcom/yd/android_brand_mvp/network/base/BaseNetworkApi;", "Lcom/yd/android_brand_mvp/network/collect/ICollectService;", "()V", "getCollectList", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/collect/CollectListBean;", "requestBody", "Lokhttp3/RequestBody;", "getCollectList-gIAlu-s", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCollectSituation", "Lcom/yd/android_brand_mvp/model/collect/CollectSituationBean;", "getCollectSituation-gIAlu-s", "getFormDetail", "Lcom/yd/android_brand_mvp/model/collect/FormDetailBean;", "getFormDetail-gIAlu-s", "getHomeCollect", "Lcom/yd/android_brand_mvp/model/collect/HomeCollectBean;", "getHomeCollect-gIAlu-s", "getStudentClasses", "Lcom/yd/android_brand_mvp/model/collect/StudentClassesBean;", CommentsHomeFragment.TYPE_ID, "", "getStudentClasses-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTeacherDeptList", "Lcom/yd/android_brand_mvp/model/collect/DeptListBean;", "schoolId", "employeeId", "getTeacherDeptList-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitFormContent", "", "submitFormContent-gIAlu-s", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CollectNetWork extends BaseNetworkApi<ICollectService> {
    public static final CollectNetWork INSTANCE = new CollectNetWork();

    private CollectNetWork() {
        super("https://api.yyide.com");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getHomeCollect-gIAlu-s, reason: not valid java name */
    public final Object m489getHomeCollectgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<HomeCollectBean>>>> continuation) {
        CollectNetWork$getHomeCollect$1 collectNetWork$getHomeCollect$1;
        if (continuation instanceof CollectNetWork$getHomeCollect$1) {
            collectNetWork$getHomeCollect$1 = (CollectNetWork$getHomeCollect$1) continuation;
            if ((collectNetWork$getHomeCollect$1.label & Integer.MIN_VALUE) != 0) {
                collectNetWork$getHomeCollect$1.label -= Integer.MIN_VALUE;
            } else {
                collectNetWork$getHomeCollect$1 = new CollectNetWork$getHomeCollect$1(this, continuation);
            }
        } else {
            collectNetWork$getHomeCollect$1 = new CollectNetWork$getHomeCollect$1(this, continuation);
        }
        Object obj = collectNetWork$getHomeCollect$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = collectNetWork$getHomeCollect$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        CollectNetWork$getHomeCollect$2 collectNetWork$getHomeCollect$2 = new CollectNetWork$getHomeCollect$2(requestBody, null);
        collectNetWork$getHomeCollect$1.label = 1;
        Object obj2 = m485getResultgIAlus(collectNetWork$getHomeCollect$2, collectNetWork$getHomeCollect$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getCollectList-gIAlu-s, reason: not valid java name */
    public final Object m486getCollectListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<CollectListBean>>>> continuation) {
        CollectNetWork$getCollectList$1 collectNetWork$getCollectList$1;
        if (continuation instanceof CollectNetWork$getCollectList$1) {
            collectNetWork$getCollectList$1 = (CollectNetWork$getCollectList$1) continuation;
            if ((collectNetWork$getCollectList$1.label & Integer.MIN_VALUE) != 0) {
                collectNetWork$getCollectList$1.label -= Integer.MIN_VALUE;
            } else {
                collectNetWork$getCollectList$1 = new CollectNetWork$getCollectList$1(this, continuation);
            }
        } else {
            collectNetWork$getCollectList$1 = new CollectNetWork$getCollectList$1(this, continuation);
        }
        Object obj = collectNetWork$getCollectList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = collectNetWork$getCollectList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        CollectNetWork$getCollectList$2 collectNetWork$getCollectList$2 = new CollectNetWork$getCollectList$2(requestBody, null);
        collectNetWork$getCollectList$1.label = 1;
        Object obj2 = m485getResultgIAlus(collectNetWork$getCollectList$2, collectNetWork$getCollectList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getCollectSituation-gIAlu-s, reason: not valid java name */
    public final Object m487getCollectSituationgIAlus(RequestBody requestBody, Continuation<? super Result<CollectSituationBean>> continuation) {
        CollectNetWork$getCollectSituation$1 collectNetWork$getCollectSituation$1;
        if (continuation instanceof CollectNetWork$getCollectSituation$1) {
            collectNetWork$getCollectSituation$1 = (CollectNetWork$getCollectSituation$1) continuation;
            if ((collectNetWork$getCollectSituation$1.label & Integer.MIN_VALUE) != 0) {
                collectNetWork$getCollectSituation$1.label -= Integer.MIN_VALUE;
            } else {
                collectNetWork$getCollectSituation$1 = new CollectNetWork$getCollectSituation$1(this, continuation);
            }
        } else {
            collectNetWork$getCollectSituation$1 = new CollectNetWork$getCollectSituation$1(this, continuation);
        }
        Object obj = collectNetWork$getCollectSituation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = collectNetWork$getCollectSituation$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        CollectNetWork$getCollectSituation$2 collectNetWork$getCollectSituation$2 = new CollectNetWork$getCollectSituation$2(requestBody, null);
        collectNetWork$getCollectSituation$1.label = 1;
        Object obj2 = m485getResultgIAlus(collectNetWork$getCollectSituation$2, collectNetWork$getCollectSituation$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: submitFormContent-gIAlu-s, reason: not valid java name */
    public final Object m492submitFormContentgIAlus(RequestBody requestBody, Continuation<? super Result<Boolean>> continuation) {
        CollectNetWork$submitFormContent$1 collectNetWork$submitFormContent$1;
        if (continuation instanceof CollectNetWork$submitFormContent$1) {
            collectNetWork$submitFormContent$1 = (CollectNetWork$submitFormContent$1) continuation;
            if ((collectNetWork$submitFormContent$1.label & Integer.MIN_VALUE) != 0) {
                collectNetWork$submitFormContent$1.label -= Integer.MIN_VALUE;
            } else {
                collectNetWork$submitFormContent$1 = new CollectNetWork$submitFormContent$1(this, continuation);
            }
        } else {
            collectNetWork$submitFormContent$1 = new CollectNetWork$submitFormContent$1(this, continuation);
        }
        Object obj = collectNetWork$submitFormContent$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = collectNetWork$submitFormContent$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        CollectNetWork$submitFormContent$2 collectNetWork$submitFormContent$2 = new CollectNetWork$submitFormContent$2(requestBody, null);
        collectNetWork$submitFormContent$1.label = 1;
        Object obj2 = m485getResultgIAlus(collectNetWork$submitFormContent$2, collectNetWork$submitFormContent$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getFormDetail-gIAlu-s, reason: not valid java name */
    public final Object m488getFormDetailgIAlus(RequestBody requestBody, Continuation<? super Result<FormDetailBean>> continuation) {
        CollectNetWork$getFormDetail$1 collectNetWork$getFormDetail$1;
        if (continuation instanceof CollectNetWork$getFormDetail$1) {
            collectNetWork$getFormDetail$1 = (CollectNetWork$getFormDetail$1) continuation;
            if ((collectNetWork$getFormDetail$1.label & Integer.MIN_VALUE) != 0) {
                collectNetWork$getFormDetail$1.label -= Integer.MIN_VALUE;
            } else {
                collectNetWork$getFormDetail$1 = new CollectNetWork$getFormDetail$1(this, continuation);
            }
        } else {
            collectNetWork$getFormDetail$1 = new CollectNetWork$getFormDetail$1(this, continuation);
        }
        Object obj = collectNetWork$getFormDetail$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = collectNetWork$getFormDetail$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        CollectNetWork$getFormDetail$2 collectNetWork$getFormDetail$2 = new CollectNetWork$getFormDetail$2(requestBody, null);
        collectNetWork$getFormDetail$1.label = 1;
        Object obj2 = m485getResultgIAlus(collectNetWork$getFormDetail$2, collectNetWork$getFormDetail$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getTeacherDeptList-0E7RQCE, reason: not valid java name */
    public final Object m491getTeacherDeptList0E7RQCE(String str, String str2, Continuation<? super Result<? extends List<DeptListBean>>> continuation) {
        CollectNetWork$getTeacherDeptList$1 collectNetWork$getTeacherDeptList$1;
        if (continuation instanceof CollectNetWork$getTeacherDeptList$1) {
            collectNetWork$getTeacherDeptList$1 = (CollectNetWork$getTeacherDeptList$1) continuation;
            if ((collectNetWork$getTeacherDeptList$1.label & Integer.MIN_VALUE) != 0) {
                collectNetWork$getTeacherDeptList$1.label -= Integer.MIN_VALUE;
            } else {
                collectNetWork$getTeacherDeptList$1 = new CollectNetWork$getTeacherDeptList$1(this, continuation);
            }
        } else {
            collectNetWork$getTeacherDeptList$1 = new CollectNetWork$getTeacherDeptList$1(this, continuation);
        }
        Object obj = collectNetWork$getTeacherDeptList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = collectNetWork$getTeacherDeptList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        CollectNetWork$getTeacherDeptList$2 collectNetWork$getTeacherDeptList$2 = new CollectNetWork$getTeacherDeptList$2(str, str2, null);
        collectNetWork$getTeacherDeptList$1.label = 1;
        Object obj2 = m485getResultgIAlus(collectNetWork$getTeacherDeptList$2, collectNetWork$getTeacherDeptList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getStudentClasses-gIAlu-s, reason: not valid java name */
    public final Object m490getStudentClassesgIAlus(String str, Continuation<? super Result<StudentClassesBean>> continuation) {
        CollectNetWork$getStudentClasses$1 collectNetWork$getStudentClasses$1;
        if (continuation instanceof CollectNetWork$getStudentClasses$1) {
            collectNetWork$getStudentClasses$1 = (CollectNetWork$getStudentClasses$1) continuation;
            if ((collectNetWork$getStudentClasses$1.label & Integer.MIN_VALUE) != 0) {
                collectNetWork$getStudentClasses$1.label -= Integer.MIN_VALUE;
            } else {
                collectNetWork$getStudentClasses$1 = new CollectNetWork$getStudentClasses$1(this, continuation);
            }
        } else {
            collectNetWork$getStudentClasses$1 = new CollectNetWork$getStudentClasses$1(this, continuation);
        }
        Object obj = collectNetWork$getStudentClasses$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = collectNetWork$getStudentClasses$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        CollectNetWork$getStudentClasses$2 collectNetWork$getStudentClasses$2 = new CollectNetWork$getStudentClasses$2(str, null);
        collectNetWork$getStudentClasses$1.label = 1;
        Object obj2 = m485getResultgIAlus(collectNetWork$getStudentClasses$2, collectNetWork$getStudentClasses$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }
}
