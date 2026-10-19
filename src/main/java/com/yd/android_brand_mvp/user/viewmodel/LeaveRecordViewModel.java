package com.yd.android_brand_mvp.user.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.ApproverInfoRsp;
import com.yd.android_brand_mvp.model.userspace.LeaveDetailBean;
import com.yd.android_brand_mvp.model.userspace.LeaveRecordBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.userspace.UserSpaceNetWork;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.HashMap;
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

/* JADX INFO: compiled from: LeaveRecordViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016J(\u0010\u000f\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"J\u000e\u0010\u0013\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0016J\u000e\u0010&\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0016J8\u0010&\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\u00162\b\b\u0002\u0010+\u001a\u00020\u0016R \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R,\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR)\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f0\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\bR\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\bR\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\bR\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/yd/android_brand_mvp/user/viewmodel/LeaveRecordViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "leaveDetail", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/userspace/LeaveDetailBean;", "getLeaveDetail", "()Landroidx/lifecycle/LiveData;", "leaveDetailLiveData", "Landroidx/lifecycle/MutableLiveData;", "leaveRecord", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/userspace/LeaveRecordBean;", "getLeaveRecord", "leaveRecordLiveData", "oldLeaveDetail", "Lcom/yd/android_brand_mvp/model/ApproverInfoRsp$DataDTO;", "getOldLeaveDetail", "oldLeaveDetailLiveData", "oldRevokeResult", "", "getOldRevokeResult", "oldRevokeResultLiveData", "revokeResult", "", "getRevokeResult", "revokeResultLiveData", "", "leaveId", CommentsHomeFragment.TYPE_ID, "studentName", "pageNo", "", "pageSize", "oldRevokeLeave", "id", "revokeLeave", "schoolId", "userId", "identityInt", AppMeasurementSdk.ConditionalUserProperty.NAME, "reason", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LeaveRecordViewModel extends ViewModel {
    private final LiveData<Result<LeaveDetailBean>> leaveDetail;
    private final MutableLiveData<Result<LeaveDetailBean>> leaveDetailLiveData;
    private final LiveData<Result<BasePageResponse<List<LeaveRecordBean>>>> leaveRecord;
    private final MutableLiveData<Result<BasePageResponse<List<LeaveRecordBean>>>> leaveRecordLiveData;
    private final LiveData<Result<ApproverInfoRsp.DataDTO>> oldLeaveDetail;
    private final MutableLiveData<Result<ApproverInfoRsp.DataDTO>> oldLeaveDetailLiveData;
    private final LiveData<Result<String>> oldRevokeResult;
    private final MutableLiveData<Result<String>> oldRevokeResultLiveData;
    private final LiveData<Result<Boolean>> revokeResult;
    private final MutableLiveData<Result<Boolean>> revokeResultLiveData;

    public LeaveRecordViewModel() {
        MutableLiveData<Result<BasePageResponse<List<LeaveRecordBean>>>> mutableLiveData = new MutableLiveData<>();
        this.leaveRecordLiveData = mutableLiveData;
        this.leaveRecord = mutableLiveData;
        MutableLiveData<Result<LeaveDetailBean>> mutableLiveData2 = new MutableLiveData<>();
        this.leaveDetailLiveData = mutableLiveData2;
        this.leaveDetail = mutableLiveData2;
        MutableLiveData<Result<ApproverInfoRsp.DataDTO>> mutableLiveData3 = new MutableLiveData<>();
        this.oldLeaveDetailLiveData = mutableLiveData3;
        this.oldLeaveDetail = mutableLiveData3;
        MutableLiveData<Result<Boolean>> mutableLiveData4 = new MutableLiveData<>();
        this.revokeResultLiveData = mutableLiveData4;
        this.revokeResult = mutableLiveData4;
        MutableLiveData<Result<String>> mutableLiveData5 = new MutableLiveData<>();
        this.oldRevokeResultLiveData = mutableLiveData5;
        this.oldRevokeResult = mutableLiveData5;
    }

    public final LiveData<Result<BasePageResponse<List<LeaveRecordBean>>>> getLeaveRecord() {
        return this.leaveRecord;
    }

    public final LiveData<Result<LeaveDetailBean>> getLeaveDetail() {
        return this.leaveDetail;
    }

    public final LiveData<Result<ApproverInfoRsp.DataDTO>> getOldLeaveDetail() {
        return this.oldLeaveDetail;
    }

    public final LiveData<Result<Boolean>> getRevokeResult() {
        return this.revokeResult;
    }

    public final LiveData<Result<String>> getOldRevokeResult() {
        return this.oldRevokeResult;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.user.viewmodel.LeaveRecordViewModel$getLeaveRecord$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LeaveRecordViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.user.viewmodel.LeaveRecordViewModel$getLeaveRecord$1", f = "LeaveRecordViewModel.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    static final class C05551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $pageNo;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ String $studentId;
        Object L$0;
        int label;
        final /* synthetic */ LeaveRecordViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05551(int i, int i2, String str, LeaveRecordViewModel leaveRecordViewModel, Continuation<? super C05551> continuation) {
            super(2, continuation);
            this.$pageNo = i;
            this.$pageSize = i2;
            this.$studentId = str;
            this.this$0 = leaveRecordViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05551(this.$pageNo, this.$pageSize, this.$studentId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM543getLeaveRecordgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("pageNo", Boxing.boxInt(this.$pageNo));
                map2.put("pageSize", Boxing.boxInt(this.$pageSize));
                map2.put("type", Boxing.boxInt(3));
                map2.put("assignee", this.$studentId);
                map2.put("fromKey", "studentLeave_" + SpData.getSchoolId());
                map2.put("queryNewStatus", Boxing.boxBoolean(true));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.leaveRecordLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM543getLeaveRecordgIAlus = UserSpaceNetWork.INSTANCE.m543getLeaveRecordgIAlus(requestBodyCreate, this);
                if (objM543getLeaveRecordgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM543getLeaveRecordgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM543getLeaveRecordgIAlus));
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void getLeaveRecord$default(LeaveRecordViewModel leaveRecordViewModel, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = 20;
        }
        leaveRecordViewModel.getLeaveRecord(str, str2, i, i2);
    }

    public final void getLeaveRecord(String studentId, String studentName, int pageNo, int pageSize) {
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(studentName, "studentName");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05551(pageNo, pageSize, studentId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.user.viewmodel.LeaveRecordViewModel$getLeaveDetail$1, reason: invalid class name */
    /* JADX INFO: compiled from: LeaveRecordViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.user.viewmodel.LeaveRecordViewModel$getLeaveDetail$1", f = "LeaveRecordViewModel.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $leaveId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$leaveId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LeaveRecordViewModel.this.new AnonymousClass1(this.$leaveId, continuation);
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
                MutableLiveData mutableLiveData2 = LeaveRecordViewModel.this.leaveDetailLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objM541getLeaveDetailInfogIAlus = UserSpaceNetWork.INSTANCE.m541getLeaveDetailInfogIAlus(this.$leaveId, this);
                if (objM541getLeaveDetailInfogIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                value = objM541getLeaveDetailInfogIAlus;
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

    public final void getLeaveDetail(String leaveId) {
        Intrinsics.checkNotNullParameter(leaveId, "leaveId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(leaveId, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.user.viewmodel.LeaveRecordViewModel$getOldLeaveDetail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LeaveRecordViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.user.viewmodel.LeaveRecordViewModel$getOldLeaveDetail$1", f = "LeaveRecordViewModel.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
    static final class C05561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $leaveId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05561(String str, Continuation<? super C05561> continuation) {
            super(2, continuation);
            this.$leaveId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LeaveRecordViewModel.this.new C05561(this.$leaveId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData2 = LeaveRecordViewModel.this.oldLeaveDetailLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objM545getOldLeaveDetailInfogIAlus = UserSpaceNetWork.INSTANCE.m545getOldLeaveDetailInfogIAlus(this.$leaveId, this);
                if (objM545getOldLeaveDetailInfogIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                value = objM545getOldLeaveDetailInfogIAlus;
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

    public final void getOldLeaveDetail(String leaveId) {
        Intrinsics.checkNotNullParameter(leaveId, "leaveId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05561(leaveId, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.user.viewmodel.LeaveRecordViewModel$revokeLeave$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LeaveRecordViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.user.viewmodel.LeaveRecordViewModel$revokeLeave$1", f = "LeaveRecordViewModel.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
    static final class C05581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        Object L$0;
        int label;
        final /* synthetic */ LeaveRecordViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05581(String str, LeaveRecordViewModel leaveRecordViewModel, Continuation<? super C05581> continuation) {
            super(2, continuation);
            this.$id = str;
            this.this$0 = leaveRecordViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05581(this.$id, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM551revokeLeavegIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                map.put("processInstanceId", this.$id);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.revokeResultLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM551revokeLeavegIAlus = UserSpaceNetWork.INSTANCE.m551revokeLeavegIAlus(requestBodyCreate, this);
                if (objM551revokeLeavegIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM551revokeLeavegIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM551revokeLeavegIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void revokeLeave(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05581(id, this, null), 3, null);
    }

    public static /* synthetic */ void revokeLeave$default(LeaveRecordViewModel leaveRecordViewModel, String str, String str2, String str3, int i, String str4, String str5, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            str5 = "";
        }
        leaveRecordViewModel.revokeLeave(str, str2, str3, i, str4, str5);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.user.viewmodel.LeaveRecordViewModel$revokeLeave$2, reason: invalid class name */
    /* JADX INFO: compiled from: LeaveRecordViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.user.viewmodel.LeaveRecordViewModel$revokeLeave$2", f = "LeaveRecordViewModel.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        final /* synthetic */ int $identityInt;
        final /* synthetic */ String $name;
        final /* synthetic */ String $schoolId;
        final /* synthetic */ String $userId;
        Object L$0;
        int label;
        final /* synthetic */ LeaveRecordViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, String str2, String str3, int i, String str4, LeaveRecordViewModel leaveRecordViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$id = str;
            this.$schoolId = str2;
            this.$userId = str3;
            this.$identityInt = i;
            this.$name = str4;
            this.this$0 = leaveRecordViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$id, this.$schoolId, this.$userId, this.$identityInt, this.$name, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM551revokeLeavegIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("processInstanceId", this.$id);
                map2.put("schoolId", this.$schoolId);
                map2.put("assigneeId", this.$userId);
                map2.put("sponsorType", Boxing.boxInt(this.$identityInt));
                map2.put("assigneeName", this.$name);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.revokeResultLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM551revokeLeavegIAlus = UserSpaceNetWork.INSTANCE.m551revokeLeavegIAlus(requestBodyCreate, this);
                if (objM551revokeLeavegIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM551revokeLeavegIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM551revokeLeavegIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void revokeLeave(String id, String schoolId, String userId, int identityInt, String name, String reason) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reason, "reason");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(id, schoolId, userId, identityInt, name, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.user.viewmodel.LeaveRecordViewModel$oldRevokeLeave$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LeaveRecordViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.user.viewmodel.LeaveRecordViewModel$oldRevokeLeave$1", f = "LeaveRecordViewModel.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
    static final class C05571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        Object L$0;
        int label;
        final /* synthetic */ LeaveRecordViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05571(String str, LeaveRecordViewModel leaveRecordViewModel, Continuation<? super C05571> continuation) {
            super(2, continuation);
            this.$id = str;
            this.this$0 = leaveRecordViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05571(this.$id, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM552revokeOldLeavegIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("processInstanceId", this.$id);
                map2.put("deleteReason", "");
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.oldRevokeResultLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM552revokeOldLeavegIAlus = UserSpaceNetWork.INSTANCE.m552revokeOldLeavegIAlus(requestBodyCreate, this);
                if (objM552revokeOldLeavegIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM552revokeOldLeavegIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM552revokeOldLeavegIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void oldRevokeLeave(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05571(id, this, null), 3, null);
    }
}
