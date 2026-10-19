package com.yd.android_brand_mvp.network.userspace;

import com.yd.android_brand_mvp.model.ApproverInfoRsp;
import com.yd.android_brand_mvp.model.userspace.LeaveDetailBean;
import com.yd.android_brand_mvp.model.userspace.LeaveFormBean;
import com.yd.android_brand_mvp.model.userspace.LeaveProcessBean;
import com.yd.android_brand_mvp.model.userspace.LeaveRecordBean;
import com.yd.android_brand_mvp.model.userspace.LeaveTypeBean;
import com.yd.android_brand_mvp.network.base.BaseNetworkApi;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: UserSpaceNetWork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ6\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00110\u00052\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0014\u0010\u000fJ(\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00120\u0005H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0017\u0010\u0018J*\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001b\u0010\nJ*\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00052\u0006\u0010\u001e\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001f\u0010\nJ6\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00110\u00052\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b!\u0010\u000fJ\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0005H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b#\u0010\u0018J*\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00052\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b&\u0010\u000fJ*\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00052\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b)\u0010\u000fJ*\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\u00052\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b+\u0010\u000fJ*\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b-\u0010\u000fJ*\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b/\u0010\u000f\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, d2 = {"Lcom/yd/android_brand_mvp/network/userspace/UserSpaceNetWork;", "Lcom/yd/android_brand_mvp/network/base/BaseNetworkApi;", "Lcom/yd/android_brand_mvp/network/userspace/IUserSpaceService;", "()V", "getLeaveDetailInfo", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/userspace/LeaveDetailBean;", "id", "", "getLeaveDetailInfo-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLeaveLength", "requestBody", "Lokhttp3/RequestBody;", "getLeaveLength-gIAlu-s", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLeaveRecord", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/userspace/LeaveRecordBean;", "getLeaveRecord-gIAlu-s", "getLeaveTypeOptions", "Lcom/yd/android_brand_mvp/model/userspace/LeaveTypeBean;", "getLeaveTypeOptions-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOldLeaveDetailInfo", "Lcom/yd/android_brand_mvp/model/ApproverInfoRsp$DataDTO;", "getOldLeaveDetailInfo-gIAlu-s", "getRepairForm", "Lcom/yd/android_brand_mvp/model/userspace/LeaveFormBean;", "typeStr", "getRepairForm-gIAlu-s", "getRepairList", "getRepairList-gIAlu-s", "getStudentLeaveForm", "getStudentLeaveForm-IoAF18A", "getStudentLeaveProcess", "Lcom/yd/android_brand_mvp/model/userspace/LeaveProcessBean;", "getStudentLeaveProcess-gIAlu-s", "modifyForm", "", "modifyForm-gIAlu-s", "revokeLeave", "revokeLeave-gIAlu-s", "revokeOldLeave", "revokeOldLeave-gIAlu-s", "submitStudentLeave", "submitStudentLeave-gIAlu-s", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UserSpaceNetWork extends BaseNetworkApi<IUserSpaceService> {
    public static final UserSpaceNetWork INSTANCE = new UserSpaceNetWork();

    private UserSpaceNetWork() {
        super("https://api.yyide.com");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getStudentLeaveForm-IoAF18A, reason: not valid java name */
    public final Object m548getStudentLeaveFormIoAF18A(Continuation<? super Result<LeaveFormBean>> continuation) {
        UserSpaceNetWork$getStudentLeaveForm$1 userSpaceNetWork$getStudentLeaveForm$1;
        if (continuation instanceof UserSpaceNetWork$getStudentLeaveForm$1) {
            userSpaceNetWork$getStudentLeaveForm$1 = (UserSpaceNetWork$getStudentLeaveForm$1) continuation;
            if ((userSpaceNetWork$getStudentLeaveForm$1.label & Integer.MIN_VALUE) != 0) {
                userSpaceNetWork$getStudentLeaveForm$1.label -= Integer.MIN_VALUE;
            } else {
                userSpaceNetWork$getStudentLeaveForm$1 = new UserSpaceNetWork$getStudentLeaveForm$1(this, continuation);
            }
        } else {
            userSpaceNetWork$getStudentLeaveForm$1 = new UserSpaceNetWork$getStudentLeaveForm$1(this, continuation);
        }
        Object obj = userSpaceNetWork$getStudentLeaveForm$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = userSpaceNetWork$getStudentLeaveForm$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        UserSpaceNetWork$getStudentLeaveForm$2 userSpaceNetWork$getStudentLeaveForm$2 = new UserSpaceNetWork$getStudentLeaveForm$2(null);
        userSpaceNetWork$getStudentLeaveForm$1.label = 1;
        Object obj2 = m485getResultgIAlus(userSpaceNetWork$getStudentLeaveForm$2, userSpaceNetWork$getStudentLeaveForm$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getStudentLeaveProcess-gIAlu-s, reason: not valid java name */
    public final Object m549getStudentLeaveProcessgIAlus(RequestBody requestBody, Continuation<? super Result<LeaveProcessBean>> continuation) {
        UserSpaceNetWork$getStudentLeaveProcess$1 userSpaceNetWork$getStudentLeaveProcess$1;
        if (continuation instanceof UserSpaceNetWork$getStudentLeaveProcess$1) {
            userSpaceNetWork$getStudentLeaveProcess$1 = (UserSpaceNetWork$getStudentLeaveProcess$1) continuation;
            if ((userSpaceNetWork$getStudentLeaveProcess$1.label & Integer.MIN_VALUE) != 0) {
                userSpaceNetWork$getStudentLeaveProcess$1.label -= Integer.MIN_VALUE;
            } else {
                userSpaceNetWork$getStudentLeaveProcess$1 = new UserSpaceNetWork$getStudentLeaveProcess$1(this, continuation);
            }
        } else {
            userSpaceNetWork$getStudentLeaveProcess$1 = new UserSpaceNetWork$getStudentLeaveProcess$1(this, continuation);
        }
        Object obj = userSpaceNetWork$getStudentLeaveProcess$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = userSpaceNetWork$getStudentLeaveProcess$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        UserSpaceNetWork$getStudentLeaveProcess$2 userSpaceNetWork$getStudentLeaveProcess$2 = new UserSpaceNetWork$getStudentLeaveProcess$2(requestBody, null);
        userSpaceNetWork$getStudentLeaveProcess$1.label = 1;
        Object obj2 = m485getResultgIAlus(userSpaceNetWork$getStudentLeaveProcess$2, userSpaceNetWork$getStudentLeaveProcess$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: submitStudentLeave-gIAlu-s, reason: not valid java name */
    public final Object m553submitStudentLeavegIAlus(RequestBody requestBody, Continuation<? super Result<String>> continuation) {
        UserSpaceNetWork$submitStudentLeave$1 userSpaceNetWork$submitStudentLeave$1;
        if (continuation instanceof UserSpaceNetWork$submitStudentLeave$1) {
            userSpaceNetWork$submitStudentLeave$1 = (UserSpaceNetWork$submitStudentLeave$1) continuation;
            if ((userSpaceNetWork$submitStudentLeave$1.label & Integer.MIN_VALUE) != 0) {
                userSpaceNetWork$submitStudentLeave$1.label -= Integer.MIN_VALUE;
            } else {
                userSpaceNetWork$submitStudentLeave$1 = new UserSpaceNetWork$submitStudentLeave$1(this, continuation);
            }
        } else {
            userSpaceNetWork$submitStudentLeave$1 = new UserSpaceNetWork$submitStudentLeave$1(this, continuation);
        }
        Object obj = userSpaceNetWork$submitStudentLeave$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = userSpaceNetWork$submitStudentLeave$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        UserSpaceNetWork$submitStudentLeave$2 userSpaceNetWork$submitStudentLeave$2 = new UserSpaceNetWork$submitStudentLeave$2(requestBody, null);
        userSpaceNetWork$submitStudentLeave$1.label = 1;
        Object obj2 = m485getResultgIAlus(userSpaceNetWork$submitStudentLeave$2, userSpaceNetWork$submitStudentLeave$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getLeaveRecord-gIAlu-s, reason: not valid java name */
    public final Object m543getLeaveRecordgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<LeaveRecordBean>>>> continuation) {
        UserSpaceNetWork$getLeaveRecord$1 userSpaceNetWork$getLeaveRecord$1;
        if (continuation instanceof UserSpaceNetWork$getLeaveRecord$1) {
            userSpaceNetWork$getLeaveRecord$1 = (UserSpaceNetWork$getLeaveRecord$1) continuation;
            if ((userSpaceNetWork$getLeaveRecord$1.label & Integer.MIN_VALUE) != 0) {
                userSpaceNetWork$getLeaveRecord$1.label -= Integer.MIN_VALUE;
            } else {
                userSpaceNetWork$getLeaveRecord$1 = new UserSpaceNetWork$getLeaveRecord$1(this, continuation);
            }
        } else {
            userSpaceNetWork$getLeaveRecord$1 = new UserSpaceNetWork$getLeaveRecord$1(this, continuation);
        }
        Object obj = userSpaceNetWork$getLeaveRecord$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = userSpaceNetWork$getLeaveRecord$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        UserSpaceNetWork$getLeaveRecord$2 userSpaceNetWork$getLeaveRecord$2 = new UserSpaceNetWork$getLeaveRecord$2(requestBody, null);
        userSpaceNetWork$getLeaveRecord$1.label = 1;
        Object obj2 = m485getResultgIAlus(userSpaceNetWork$getLeaveRecord$2, userSpaceNetWork$getLeaveRecord$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getLeaveDetailInfo-gIAlu-s, reason: not valid java name */
    public final Object m541getLeaveDetailInfogIAlus(String str, Continuation<? super Result<LeaveDetailBean>> continuation) {
        UserSpaceNetWork$getLeaveDetailInfo$1 userSpaceNetWork$getLeaveDetailInfo$1;
        if (continuation instanceof UserSpaceNetWork$getLeaveDetailInfo$1) {
            userSpaceNetWork$getLeaveDetailInfo$1 = (UserSpaceNetWork$getLeaveDetailInfo$1) continuation;
            if ((userSpaceNetWork$getLeaveDetailInfo$1.label & Integer.MIN_VALUE) != 0) {
                userSpaceNetWork$getLeaveDetailInfo$1.label -= Integer.MIN_VALUE;
            } else {
                userSpaceNetWork$getLeaveDetailInfo$1 = new UserSpaceNetWork$getLeaveDetailInfo$1(this, continuation);
            }
        } else {
            userSpaceNetWork$getLeaveDetailInfo$1 = new UserSpaceNetWork$getLeaveDetailInfo$1(this, continuation);
        }
        Object obj = userSpaceNetWork$getLeaveDetailInfo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = userSpaceNetWork$getLeaveDetailInfo$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        UserSpaceNetWork$getLeaveDetailInfo$2 userSpaceNetWork$getLeaveDetailInfo$2 = new UserSpaceNetWork$getLeaveDetailInfo$2(str, null);
        userSpaceNetWork$getLeaveDetailInfo$1.label = 1;
        Object obj2 = m485getResultgIAlus(userSpaceNetWork$getLeaveDetailInfo$2, userSpaceNetWork$getLeaveDetailInfo$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getOldLeaveDetailInfo-gIAlu-s, reason: not valid java name */
    public final Object m545getOldLeaveDetailInfogIAlus(String str, Continuation<? super Result<? extends ApproverInfoRsp.DataDTO>> continuation) {
        UserSpaceNetWork$getOldLeaveDetailInfo$1 userSpaceNetWork$getOldLeaveDetailInfo$1;
        if (continuation instanceof UserSpaceNetWork$getOldLeaveDetailInfo$1) {
            userSpaceNetWork$getOldLeaveDetailInfo$1 = (UserSpaceNetWork$getOldLeaveDetailInfo$1) continuation;
            if ((userSpaceNetWork$getOldLeaveDetailInfo$1.label & Integer.MIN_VALUE) != 0) {
                userSpaceNetWork$getOldLeaveDetailInfo$1.label -= Integer.MIN_VALUE;
            } else {
                userSpaceNetWork$getOldLeaveDetailInfo$1 = new UserSpaceNetWork$getOldLeaveDetailInfo$1(this, continuation);
            }
        } else {
            userSpaceNetWork$getOldLeaveDetailInfo$1 = new UserSpaceNetWork$getOldLeaveDetailInfo$1(this, continuation);
        }
        Object obj = userSpaceNetWork$getOldLeaveDetailInfo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = userSpaceNetWork$getOldLeaveDetailInfo$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        UserSpaceNetWork$getOldLeaveDetailInfo$2 userSpaceNetWork$getOldLeaveDetailInfo$2 = new UserSpaceNetWork$getOldLeaveDetailInfo$2(str, null);
        userSpaceNetWork$getOldLeaveDetailInfo$1.label = 1;
        Object obj2 = m485getResultgIAlus(userSpaceNetWork$getOldLeaveDetailInfo$2, userSpaceNetWork$getOldLeaveDetailInfo$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: revokeLeave-gIAlu-s, reason: not valid java name */
    public final Object m551revokeLeavegIAlus(RequestBody requestBody, Continuation<? super Result<Boolean>> continuation) {
        UserSpaceNetWork$revokeLeave$1 userSpaceNetWork$revokeLeave$1;
        if (continuation instanceof UserSpaceNetWork$revokeLeave$1) {
            userSpaceNetWork$revokeLeave$1 = (UserSpaceNetWork$revokeLeave$1) continuation;
            if ((userSpaceNetWork$revokeLeave$1.label & Integer.MIN_VALUE) != 0) {
                userSpaceNetWork$revokeLeave$1.label -= Integer.MIN_VALUE;
            } else {
                userSpaceNetWork$revokeLeave$1 = new UserSpaceNetWork$revokeLeave$1(this, continuation);
            }
        } else {
            userSpaceNetWork$revokeLeave$1 = new UserSpaceNetWork$revokeLeave$1(this, continuation);
        }
        Object obj = userSpaceNetWork$revokeLeave$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = userSpaceNetWork$revokeLeave$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        UserSpaceNetWork$revokeLeave$2 userSpaceNetWork$revokeLeave$2 = new UserSpaceNetWork$revokeLeave$2(requestBody, null);
        userSpaceNetWork$revokeLeave$1.label = 1;
        Object obj2 = m485getResultgIAlus(userSpaceNetWork$revokeLeave$2, userSpaceNetWork$revokeLeave$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: revokeOldLeave-gIAlu-s, reason: not valid java name */
    public final Object m552revokeOldLeavegIAlus(RequestBody requestBody, Continuation<? super Result<String>> continuation) {
        UserSpaceNetWork$revokeOldLeave$1 userSpaceNetWork$revokeOldLeave$1;
        if (continuation instanceof UserSpaceNetWork$revokeOldLeave$1) {
            userSpaceNetWork$revokeOldLeave$1 = (UserSpaceNetWork$revokeOldLeave$1) continuation;
            if ((userSpaceNetWork$revokeOldLeave$1.label & Integer.MIN_VALUE) != 0) {
                userSpaceNetWork$revokeOldLeave$1.label -= Integer.MIN_VALUE;
            } else {
                userSpaceNetWork$revokeOldLeave$1 = new UserSpaceNetWork$revokeOldLeave$1(this, continuation);
            }
        } else {
            userSpaceNetWork$revokeOldLeave$1 = new UserSpaceNetWork$revokeOldLeave$1(this, continuation);
        }
        Object obj = userSpaceNetWork$revokeOldLeave$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = userSpaceNetWork$revokeOldLeave$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        UserSpaceNetWork$revokeOldLeave$2 userSpaceNetWork$revokeOldLeave$2 = new UserSpaceNetWork$revokeOldLeave$2(requestBody, null);
        userSpaceNetWork$revokeOldLeave$1.label = 1;
        Object obj2 = m485getResultgIAlus(userSpaceNetWork$revokeOldLeave$2, userSpaceNetWork$revokeOldLeave$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getLeaveTypeOptions-IoAF18A, reason: not valid java name */
    public final Object m544getLeaveTypeOptionsIoAF18A(Continuation<? super Result<? extends List<LeaveTypeBean>>> continuation) {
        UserSpaceNetWork$getLeaveTypeOptions$1 userSpaceNetWork$getLeaveTypeOptions$1;
        if (continuation instanceof UserSpaceNetWork$getLeaveTypeOptions$1) {
            userSpaceNetWork$getLeaveTypeOptions$1 = (UserSpaceNetWork$getLeaveTypeOptions$1) continuation;
            if ((userSpaceNetWork$getLeaveTypeOptions$1.label & Integer.MIN_VALUE) != 0) {
                userSpaceNetWork$getLeaveTypeOptions$1.label -= Integer.MIN_VALUE;
            } else {
                userSpaceNetWork$getLeaveTypeOptions$1 = new UserSpaceNetWork$getLeaveTypeOptions$1(this, continuation);
            }
        } else {
            userSpaceNetWork$getLeaveTypeOptions$1 = new UserSpaceNetWork$getLeaveTypeOptions$1(this, continuation);
        }
        Object obj = userSpaceNetWork$getLeaveTypeOptions$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = userSpaceNetWork$getLeaveTypeOptions$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        UserSpaceNetWork$getLeaveTypeOptions$2 userSpaceNetWork$getLeaveTypeOptions$2 = new UserSpaceNetWork$getLeaveTypeOptions$2(null);
        userSpaceNetWork$getLeaveTypeOptions$1.label = 1;
        Object obj2 = m485getResultgIAlus(userSpaceNetWork$getLeaveTypeOptions$2, userSpaceNetWork$getLeaveTypeOptions$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getLeaveLength-gIAlu-s, reason: not valid java name */
    public final Object m542getLeaveLengthgIAlus(RequestBody requestBody, Continuation<? super Result<String>> continuation) {
        UserSpaceNetWork$getLeaveLength$1 userSpaceNetWork$getLeaveLength$1;
        if (continuation instanceof UserSpaceNetWork$getLeaveLength$1) {
            userSpaceNetWork$getLeaveLength$1 = (UserSpaceNetWork$getLeaveLength$1) continuation;
            if ((userSpaceNetWork$getLeaveLength$1.label & Integer.MIN_VALUE) != 0) {
                userSpaceNetWork$getLeaveLength$1.label -= Integer.MIN_VALUE;
            } else {
                userSpaceNetWork$getLeaveLength$1 = new UserSpaceNetWork$getLeaveLength$1(this, continuation);
            }
        } else {
            userSpaceNetWork$getLeaveLength$1 = new UserSpaceNetWork$getLeaveLength$1(this, continuation);
        }
        Object obj = userSpaceNetWork$getLeaveLength$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = userSpaceNetWork$getLeaveLength$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        UserSpaceNetWork$getLeaveLength$2 userSpaceNetWork$getLeaveLength$2 = new UserSpaceNetWork$getLeaveLength$2(requestBody, null);
        userSpaceNetWork$getLeaveLength$1.label = 1;
        Object obj2 = m485getResultgIAlus(userSpaceNetWork$getLeaveLength$2, userSpaceNetWork$getLeaveLength$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getRepairForm-gIAlu-s, reason: not valid java name */
    public final Object m546getRepairFormgIAlus(String str, Continuation<? super Result<LeaveFormBean>> continuation) {
        UserSpaceNetWork$getRepairForm$1 userSpaceNetWork$getRepairForm$1;
        if (continuation instanceof UserSpaceNetWork$getRepairForm$1) {
            userSpaceNetWork$getRepairForm$1 = (UserSpaceNetWork$getRepairForm$1) continuation;
            if ((userSpaceNetWork$getRepairForm$1.label & Integer.MIN_VALUE) != 0) {
                userSpaceNetWork$getRepairForm$1.label -= Integer.MIN_VALUE;
            } else {
                userSpaceNetWork$getRepairForm$1 = new UserSpaceNetWork$getRepairForm$1(this, continuation);
            }
        } else {
            userSpaceNetWork$getRepairForm$1 = new UserSpaceNetWork$getRepairForm$1(this, continuation);
        }
        Object obj = userSpaceNetWork$getRepairForm$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = userSpaceNetWork$getRepairForm$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        UserSpaceNetWork$getRepairForm$2 userSpaceNetWork$getRepairForm$2 = new UserSpaceNetWork$getRepairForm$2(str, null);
        userSpaceNetWork$getRepairForm$1.label = 1;
        Object obj2 = m485getResultgIAlus(userSpaceNetWork$getRepairForm$2, userSpaceNetWork$getRepairForm$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getRepairList-gIAlu-s, reason: not valid java name */
    public final Object m547getRepairListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<LeaveRecordBean>>>> continuation) {
        UserSpaceNetWork$getRepairList$1 userSpaceNetWork$getRepairList$1;
        if (continuation instanceof UserSpaceNetWork$getRepairList$1) {
            userSpaceNetWork$getRepairList$1 = (UserSpaceNetWork$getRepairList$1) continuation;
            if ((userSpaceNetWork$getRepairList$1.label & Integer.MIN_VALUE) != 0) {
                userSpaceNetWork$getRepairList$1.label -= Integer.MIN_VALUE;
            } else {
                userSpaceNetWork$getRepairList$1 = new UserSpaceNetWork$getRepairList$1(this, continuation);
            }
        } else {
            userSpaceNetWork$getRepairList$1 = new UserSpaceNetWork$getRepairList$1(this, continuation);
        }
        Object obj = userSpaceNetWork$getRepairList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = userSpaceNetWork$getRepairList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        UserSpaceNetWork$getRepairList$2 userSpaceNetWork$getRepairList$2 = new UserSpaceNetWork$getRepairList$2(requestBody, null);
        userSpaceNetWork$getRepairList$1.label = 1;
        Object obj2 = m485getResultgIAlus(userSpaceNetWork$getRepairList$2, userSpaceNetWork$getRepairList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: modifyForm-gIAlu-s, reason: not valid java name */
    public final Object m550modifyFormgIAlus(RequestBody requestBody, Continuation<? super Result<Boolean>> continuation) {
        UserSpaceNetWork$modifyForm$1 userSpaceNetWork$modifyForm$1;
        if (continuation instanceof UserSpaceNetWork$modifyForm$1) {
            userSpaceNetWork$modifyForm$1 = (UserSpaceNetWork$modifyForm$1) continuation;
            if ((userSpaceNetWork$modifyForm$1.label & Integer.MIN_VALUE) != 0) {
                userSpaceNetWork$modifyForm$1.label -= Integer.MIN_VALUE;
            } else {
                userSpaceNetWork$modifyForm$1 = new UserSpaceNetWork$modifyForm$1(this, continuation);
            }
        } else {
            userSpaceNetWork$modifyForm$1 = new UserSpaceNetWork$modifyForm$1(this, continuation);
        }
        Object obj = userSpaceNetWork$modifyForm$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = userSpaceNetWork$modifyForm$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        UserSpaceNetWork$modifyForm$2 userSpaceNetWork$modifyForm$2 = new UserSpaceNetWork$modifyForm$2(requestBody, null);
        userSpaceNetWork$modifyForm$1.label = 1;
        Object obj2 = m485getResultgIAlus(userSpaceNetWork$modifyForm$2, userSpaceNetWork$modifyForm$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }
}
