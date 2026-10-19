package com.yd.android_brand_mvp.activity.vote.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.vote.VoteBrandInfoBean;
import com.yd.android_brand_mvp.model.vote.VoteDetailBean;
import com.yd.android_brand_mvp.model.vote.VoteSubmitInfoBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.vote.VoteNetWork;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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

/* JADX INFO: compiled from: VoteViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u0011\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 J&\u0010\u0015\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ,\u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0005R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\f0\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\f0\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R,\u0010\u0013\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00140\f0\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\bR)\u0010\u0016\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00140\f0\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/yd/android_brand_mvp/activity/vote/viewmodel/VoteViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "homeVoteList", "Landroidx/lifecycle/LiveData;", "", "Lcom/yd/android_brand_mvp/model/vote/VoteDetailBean;", "getHomeVoteList", "()Landroidx/lifecycle/LiveData;", "homeVoteListLiveData", "Landroidx/lifecycle/MutableLiveData;", "submitResult", "Lkotlin/Result;", "", "getSubmitResult", "submitResultLiveData", "voteDetail", "getVoteDetail", "voteDetailLiveData", "voteList", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "getVoteList", "voteListLiveData", "", "pageNo", "", "pageSize", "status", CommentsHomeFragment.TYPE_CLASSESID, "", "id", "brandInfo", "Lcom/yd/android_brand_mvp/model/vote/VoteBrandInfoBean;", "submitVoteResult", "checkId", "checkName", "optionIds", "Lcom/yd/android_brand_mvp/model/vote/VoteSubmitInfoBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VoteViewModel extends ViewModel {
    private final LiveData<List<VoteDetailBean>> homeVoteList;
    private final MutableLiveData<List<VoteDetailBean>> homeVoteListLiveData;
    private final LiveData<Result<Boolean>> submitResult;
    private final MutableLiveData<Result<Boolean>> submitResultLiveData;
    private final LiveData<Result<VoteDetailBean>> voteDetail;
    private final MutableLiveData<Result<VoteDetailBean>> voteDetailLiveData;
    private final LiveData<Result<BasePageResponse<List<VoteDetailBean>>>> voteList;
    private final MutableLiveData<Result<BasePageResponse<List<VoteDetailBean>>>> voteListLiveData;

    public VoteViewModel() {
        MutableLiveData<Result<VoteDetailBean>> mutableLiveData = new MutableLiveData<>();
        this.voteDetailLiveData = mutableLiveData;
        this.voteDetail = mutableLiveData;
        MutableLiveData<Result<Boolean>> mutableLiveData2 = new MutableLiveData<>();
        this.submitResultLiveData = mutableLiveData2;
        this.submitResult = mutableLiveData2;
        MutableLiveData<List<VoteDetailBean>> mutableLiveData3 = new MutableLiveData<>();
        this.homeVoteListLiveData = mutableLiveData3;
        this.homeVoteList = mutableLiveData3;
        MutableLiveData<Result<BasePageResponse<List<VoteDetailBean>>>> mutableLiveData4 = new MutableLiveData<>();
        this.voteListLiveData = mutableLiveData4;
        this.voteList = mutableLiveData4;
    }

    public final LiveData<Result<VoteDetailBean>> getVoteDetail() {
        return this.voteDetail;
    }

    public final LiveData<Result<Boolean>> getSubmitResult() {
        return this.submitResult;
    }

    public final LiveData<List<VoteDetailBean>> getHomeVoteList() {
        return this.homeVoteList;
    }

    public final LiveData<Result<BasePageResponse<List<VoteDetailBean>>>> getVoteList() {
        return this.voteList;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.vote.viewmodel.VoteViewModel$getHomeVoteList$1, reason: invalid class name */
    /* JADX INFO: compiled from: VoteViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.vote.viewmodel.VoteViewModel$getHomeVoteList$1", f = "VoteViewModel.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $classesId;
        final /* synthetic */ int $pageNo;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ int $status;
        int label;
        final /* synthetic */ VoteViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, int i2, String str, int i3, VoteViewModel voteViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$pageNo = i;
            this.$pageSize = i2;
            this.$classesId = str;
            this.$status = i3;
            this.this$0 = voteViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$pageNo, this.$pageSize, this.$classesId, this.$status, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM554getHomeVoteListgIAlus;
            List listEmptyList;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("pageNo", Boxing.boxInt(this.$pageNo));
                map2.put("pageSize", Boxing.boxInt(this.$pageSize));
                map2.put(CommentsHomeFragment.TYPE_CLASSESID, this.$classesId);
                map2.put("status", Boxing.boxInt(this.$status));
                map2.put("showAll", Boxing.boxBoolean(false));
                map2.put("isHave", Boxing.boxBoolean(true));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                this.label = 1;
                objM554getHomeVoteListgIAlus = VoteNetWork.INSTANCE.m554getHomeVoteListgIAlus(requestBodyCreate, this);
                if (objM554getHomeVoteListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM554getHomeVoteListgIAlus = ((Result) obj).getValue();
            }
            if (!Result.m598isSuccessimpl(objM554getHomeVoteListgIAlus)) {
                this.this$0.homeVoteListLiveData.setValue(CollectionsKt.emptyList());
            } else {
                if (Result.m597isFailureimpl(objM554getHomeVoteListgIAlus)) {
                    objM554getHomeVoteListgIAlus = null;
                }
                BasePageResponse basePageResponse = (BasePageResponse) objM554getHomeVoteListgIAlus;
                MutableLiveData mutableLiveData = this.this$0.homeVoteListLiveData;
                if (basePageResponse == null || (listEmptyList = (List) basePageResponse.getList()) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                mutableLiveData.setValue(listEmptyList);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getHomeVoteList(int pageNo, int pageSize, int status, String classesId) {
        Intrinsics.checkNotNullParameter(classesId, "classesId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(pageNo, pageSize, classesId, status, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.vote.viewmodel.VoteViewModel$getVoteList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: VoteViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.vote.viewmodel.VoteViewModel$getVoteList$1", f = "VoteViewModel.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
    static final class C03781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $classesId;
        final /* synthetic */ int $pageNo;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ int $status;
        Object L$0;
        int label;
        final /* synthetic */ VoteViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03781(int i, int i2, String str, int i3, VoteViewModel voteViewModel, Continuation<? super C03781> continuation) {
            super(2, continuation);
            this.$pageNo = i;
            this.$pageSize = i2;
            this.$classesId = str;
            this.$status = i3;
            this.this$0 = voteViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03781(this.$pageNo, this.$pageSize, this.$classesId, this.$status, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM554getHomeVoteListgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("pageNo", Boxing.boxInt(this.$pageNo));
                map2.put("pageSize", Boxing.boxInt(this.$pageSize));
                map2.put(CommentsHomeFragment.TYPE_CLASSESID, this.$classesId);
                map2.put("status", Boxing.boxInt(this.$status));
                map2.put("showAll", Boxing.boxBoolean(false));
                map2.put("isHave", Boxing.boxBoolean(true));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.voteListLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM554getHomeVoteListgIAlus = VoteNetWork.INSTANCE.m554getHomeVoteListgIAlus(requestBodyCreate, this);
                if (objM554getHomeVoteListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM554getHomeVoteListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM554getHomeVoteListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getVoteList(int pageNo, int pageSize, int status, String classesId) {
        Intrinsics.checkNotNullParameter(classesId, "classesId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03781(pageNo, pageSize, classesId, status, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.vote.viewmodel.VoteViewModel$getVoteDetail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: VoteViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.vote.viewmodel.VoteViewModel$getVoteDetail$1", f = "VoteViewModel.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    static final class C03771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ VoteBrandInfoBean $brandInfo;
        final /* synthetic */ String $id;
        Object L$0;
        int label;
        final /* synthetic */ VoteViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03771(String str, VoteBrandInfoBean voteBrandInfoBean, VoteViewModel voteViewModel, Continuation<? super C03771> continuation) {
            super(2, continuation);
            this.$id = str;
            this.$brandInfo = voteBrandInfoBean;
            this.this$0 = voteViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03771(this.$id, this.$brandInfo, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM555getVoteDetailgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("voteId", this.$id);
                map2.put("brandStudentInfo", this.$brandInfo);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.voteDetailLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM555getVoteDetailgIAlus = VoteNetWork.INSTANCE.m555getVoteDetailgIAlus(requestBodyCreate, this);
                if (objM555getVoteDetailgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM555getVoteDetailgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM555getVoteDetailgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getVoteDetail(String id, VoteBrandInfoBean brandInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(brandInfo, "brandInfo");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03771(id, brandInfo, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.vote.viewmodel.VoteViewModel$submitVoteResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: VoteViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.vote.viewmodel.VoteViewModel$submitVoteResult$1", f = "VoteViewModel.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
    static final class C03791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $checkId;
        final /* synthetic */ String $checkName;
        final /* synthetic */ String $id;
        final /* synthetic */ List<VoteSubmitInfoBean> $optionIds;
        Object L$0;
        int label;
        final /* synthetic */ VoteViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03791(String str, String str2, String str3, List<VoteSubmitInfoBean> list, VoteViewModel voteViewModel, Continuation<? super C03791> continuation) {
            super(2, continuation);
            this.$id = str;
            this.$checkId = str2;
            this.$checkName = str3;
            this.$optionIds = list;
            this.this$0 = voteViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03791(this.$id, this.$checkId, this.$checkName, this.$optionIds, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03791) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM556submitVotegIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("voteId", this.$id);
                map2.put("isBrandStudent", Boxing.boxBoolean(true));
                map2.put("userId", this.$checkId);
                map2.put("userName", this.$checkName);
                map2.put("voteDetails", this.$optionIds);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.submitResultLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM556submitVotegIAlus = VoteNetWork.INSTANCE.m556submitVotegIAlus(requestBodyCreate, this);
                if (objM556submitVotegIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM556submitVotegIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM556submitVotegIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void submitVoteResult(String id, String checkId, String checkName, List<VoteSubmitInfoBean> optionIds) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(checkId, "checkId");
        Intrinsics.checkNotNullParameter(checkName, "checkName");
        Intrinsics.checkNotNullParameter(optionIds, "optionIds");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03791(id, checkId, checkName, optionIds, this, null), 3, null);
    }
}
