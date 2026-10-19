package com.yd.android_brand_mvp.activity.reserve.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.db.reservation.ReservationSignBean;
import com.yd.android_brand_mvp.model.UserIcCardBean;
import com.yd.android_brand_mvp.model.reservation.ReservationDetailBean;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.network.reservation.ReservationNetwork;
import com.yd.android_brand_mvp.repository.ReservationDaoRepository;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.HashMap;
import java.util.Iterator;
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
import kotlinx.coroutines.Dispatchers;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: ReservationViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u0006\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bJ\u001e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bJ\u0016\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bR\u0019\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\tX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R \u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00100\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0007R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00100\tX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/yd/android_brand_mvp/activity/reserve/viewmodel/ReservationViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "reservationDetail", "Landroidx/lifecycle/LiveData;", "Lcom/yd/android_brand_mvp/model/reservation/ReservationDetailBean;", "getReservationDetail", "()Landroidx/lifecycle/LiveData;", "reservationDetailLiveData", "Landroidx/lifecycle/MutableLiveData;", "reservationList", "", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "getReservationList", "reservationListLiveData", "selectStudent", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/UserIcCardBean$DataBean;", "selectStudentRsp", "getSelectStudentRsp", "signInResult", "", "getSignInResult", "signInResultLiveData", "checkUserInfo", "", "cardNo", "", "id", "insertReservationSignDataToDao", "bookId", "userId", "time", "signInRecord", "user", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ReservationViewModel extends ViewModel {
    private final LiveData<ReservationDetailBean> reservationDetail;
    private final MutableLiveData<ReservationDetailBean> reservationDetailLiveData;
    private final LiveData<List<ReservationRecordBean>> reservationList;
    private final MutableLiveData<List<ReservationRecordBean>> reservationListLiveData;
    private final MutableLiveData<Result<UserIcCardBean.DataBean>> selectStudent;
    private final LiveData<Result<UserIcCardBean.DataBean>> selectStudentRsp;
    private final LiveData<Result<Boolean>> signInResult;
    private final MutableLiveData<Result<Boolean>> signInResultLiveData;

    public ReservationViewModel() {
        MutableLiveData<ReservationDetailBean> mutableLiveData = new MutableLiveData<>();
        this.reservationDetailLiveData = mutableLiveData;
        this.reservationDetail = mutableLiveData;
        MutableLiveData<Result<Boolean>> mutableLiveData2 = new MutableLiveData<>();
        this.signInResultLiveData = mutableLiveData2;
        this.signInResult = mutableLiveData2;
        MutableLiveData<Result<UserIcCardBean.DataBean>> mutableLiveData3 = new MutableLiveData<>();
        this.selectStudent = mutableLiveData3;
        this.selectStudentRsp = mutableLiveData3;
        MutableLiveData<List<ReservationRecordBean>> mutableLiveData4 = new MutableLiveData<>();
        this.reservationListLiveData = mutableLiveData4;
        this.reservationList = mutableLiveData4;
    }

    public final LiveData<ReservationDetailBean> getReservationDetail() {
        return this.reservationDetail;
    }

    public final LiveData<Result<Boolean>> getSignInResult() {
        return this.signInResult;
    }

    public final LiveData<Result<UserIcCardBean.DataBean>> getSelectStudentRsp() {
        return this.selectStudentRsp;
    }

    public final LiveData<List<ReservationRecordBean>> getReservationList() {
        return this.reservationList;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.reserve.viewmodel.ReservationViewModel$getReservationDetail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReservationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.reserve.viewmodel.ReservationViewModel$getReservationDetail$1", f = "ReservationViewModel.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    static final class C03731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        int label;
        final /* synthetic */ ReservationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03731(String str, ReservationViewModel reservationViewModel, Continuation<? super C03731> continuation) {
            super(2, continuation);
            this.$id = str;
            this.this$0 = reservationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03731(this.$id, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM528getReservationDetailgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                objM528getReservationDetailgIAlus = ReservationNetwork.INSTANCE.m528getReservationDetailgIAlus(this.$id, this);
                if (objM528getReservationDetailgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM528getReservationDetailgIAlus = ((Result) obj).getValue();
            }
            MutableLiveData mutableLiveData = this.this$0.reservationDetailLiveData;
            if (Result.m597isFailureimpl(objM528getReservationDetailgIAlus)) {
                objM528getReservationDetailgIAlus = null;
            }
            mutableLiveData.setValue(objM528getReservationDetailgIAlus);
            return Unit.INSTANCE;
        }
    }

    public final void getReservationDetail(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03731(id, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.reserve.viewmodel.ReservationViewModel$signInRecord$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReservationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.reserve.viewmodel.ReservationViewModel$signInRecord$1", f = "ReservationViewModel.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    static final class C03751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $bookId;
        final /* synthetic */ String $user;
        int label;
        final /* synthetic */ ReservationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03751(String str, String str2, ReservationViewModel reservationViewModel, Continuation<? super C03751> continuation) {
            super(2, continuation);
            this.$bookId = str;
            this.$user = str2;
            this.this$0 = reservationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03751(this.$bookId, this.$user, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM531signInReservationgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("siteBookingId", this.$bookId);
                map2.put("userId", this.$user);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                this.label = 1;
                objM531signInReservationgIAlus = ReservationNetwork.INSTANCE.m531signInReservationgIAlus(requestBodyCreate, this);
                if (objM531signInReservationgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM531signInReservationgIAlus = ((Result) obj).getValue();
            }
            if (Result.m598isSuccessimpl(objM531signInReservationgIAlus)) {
                this.this$0.signInResultLiveData.setValue(Result.m590boximpl(objM531signInReservationgIAlus));
            }
            return Unit.INSTANCE;
        }
    }

    public final void signInRecord(String user, String bookId) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03751(bookId, user, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.reserve.viewmodel.ReservationViewModel$insertReservationSignDataToDao$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReservationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.reserve.viewmodel.ReservationViewModel$insertReservationSignDataToDao$1", f = "ReservationViewModel.kt", i = {0}, l = {67, 75}, m = "invokeSuspend", n = {"daoSignData"}, s = {"L$0"})
    static final class C03741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $bookId;
        final /* synthetic */ String $time;
        final /* synthetic */ String $userId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03741(String str, String str2, String str3, Continuation<? super C03741> continuation) {
            super(2, continuation);
            this.$userId = str;
            this.$time = str2;
            this.$bookId = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03741(this.$userId, this.$time, this.$bookId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03741) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ReservationSignBean reservationSignBean;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                reservationSignBean = new ReservationSignBean(this.$userId, this.$time, this.$bookId);
                this.L$0 = reservationSignBean;
                this.label = 1;
                obj = ReservationDaoRepository.INSTANCE.getUserIdSignData(this.$userId, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i == 1) {
                    reservationSignBean = (ReservationSignBean) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            List list = (List) obj;
            if (true ^ list.isEmpty()) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    if (Intrinsics.areEqual(((ReservationSignBean) it2.next()).getSiteBookingId(), this.$bookId)) {
                        return Unit.INSTANCE;
                    }
                }
            }
            this.L$0 = null;
            this.label = 2;
            if (ReservationDaoRepository.INSTANCE.addSignData(reservationSignBean, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    public final void insertReservationSignDataToDao(String bookId, String userId, String time) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(time, "time");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03741(userId, time, bookId, null), 2, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.reserve.viewmodel.ReservationViewModel$checkUserInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: ReservationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.reserve.viewmodel.ReservationViewModel$checkUserInfo$1", f = "ReservationViewModel.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $cardNo;
        Object L$0;
        int label;
        final /* synthetic */ ReservationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, ReservationViewModel reservationViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$cardNo = str;
            this.this$0 = reservationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$cardNo, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM418checkUsergIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("icCardNo", this.$cardNo);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.selectStudent;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM418checkUsergIAlus = NetworkApi.INSTANCE.m418checkUsergIAlus(requestBodyCreate, this);
                if (objM418checkUsergIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM418checkUsergIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM418checkUsergIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void checkUserInfo(String cardNo) {
        Intrinsics.checkNotNullParameter(cardNo, "cardNo");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(cardNo, this, null), 3, null);
    }
}
