package com.yd.android_brand_mvp.landscape.exam.comments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.comments.CommentsDetailBean;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
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

/* JADX INFO: compiled from: CommentsViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u0007\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0006J>\u0010\u0010\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\tø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\tø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR)\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00120\u00110\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R,\u0010\u0013\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00120\u00110\u00050\tø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\tø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "addCommentsLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", "", "commentsDelete", "commentsDeleteLiveData", "Landroidx/lifecycle/LiveData;", "getCommentsDeleteLiveData", "()Landroidx/lifecycle/LiveData;", "commentsDetail", "Lcom/yd/android_brand_mvp/model/comments/CommentsDetailBean;", "commentsDetailLiveData", "getCommentsDetailLiveData", "commentsList", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "commentsListLiveData", "getCommentsListLiveData", "commentsLiveData", "getCommentsLiveData", "addComments", "", CommentsHomeFragment.TYPE_CLASSESID, "userId", "content", "type", "anonymity", "", "id", "startTime", "endTime", "pageNo", "", "pageSize", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommentsViewModel extends ViewModel {
    private final MutableLiveData<Result<String>> addCommentsLiveData;
    private final MutableLiveData<Result<String>> commentsDelete;
    private final LiveData<Result<String>> commentsDeleteLiveData;
    private final MutableLiveData<Result<CommentsDetailBean>> commentsDetail;
    private final LiveData<Result<CommentsDetailBean>> commentsDetailLiveData;
    private final MutableLiveData<Result<BasePageResponse<List<CommentsDetailBean>>>> commentsList;
    private final LiveData<Result<BasePageResponse<List<CommentsDetailBean>>>> commentsListLiveData;
    private final LiveData<Result<String>> commentsLiveData;

    public CommentsViewModel() {
        MutableLiveData<Result<String>> mutableLiveData = new MutableLiveData<>();
        this.addCommentsLiveData = mutableLiveData;
        this.commentsLiveData = mutableLiveData;
        MutableLiveData<Result<BasePageResponse<List<CommentsDetailBean>>>> mutableLiveData2 = new MutableLiveData<>();
        this.commentsList = mutableLiveData2;
        this.commentsListLiveData = mutableLiveData2;
        MutableLiveData<Result<CommentsDetailBean>> mutableLiveData3 = new MutableLiveData<>();
        this.commentsDetail = mutableLiveData3;
        this.commentsDetailLiveData = mutableLiveData3;
        MutableLiveData<Result<String>> mutableLiveData4 = new MutableLiveData<>();
        this.commentsDelete = mutableLiveData4;
        this.commentsDeleteLiveData = mutableLiveData4;
    }

    public final LiveData<Result<String>> getCommentsLiveData() {
        return this.commentsLiveData;
    }

    public final LiveData<Result<BasePageResponse<List<CommentsDetailBean>>>> getCommentsListLiveData() {
        return this.commentsListLiveData;
    }

    public final LiveData<Result<CommentsDetailBean>> getCommentsDetailLiveData() {
        return this.commentsDetailLiveData;
    }

    public final LiveData<Result<String>> getCommentsDeleteLiveData() {
        return this.commentsDeleteLiveData;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.comments.CommentsViewModel$addComments$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommentsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.comments.CommentsViewModel$addComments$1", f = "CommentsViewModel.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $anonymity;
        final /* synthetic */ String $classesId;
        final /* synthetic */ String $content;
        final /* synthetic */ String $type;
        final /* synthetic */ String $userId;
        Object L$0;
        int label;
        final /* synthetic */ CommentsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, String str4, boolean z, CommentsViewModel commentsViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$classesId = str;
            this.$content = str2;
            this.$userId = str3;
            this.$type = str4;
            this.$anonymity = z;
            this.this$0 = commentsViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$classesId, this.$content, this.$userId, this.$type, this.$anonymity, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM445requestAddCommentsgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(CommentsHomeFragment.TYPE_CLASSESID, this.$classesId);
                linkedHashMap.put("content", this.$content);
                linkedHashMap.put("userId", this.$userId);
                linkedHashMap.put("type", this.$type);
                linkedHashMap.put("anonymity", Boxing.boxBoolean(this.$anonymity));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.addCommentsLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM445requestAddCommentsgIAlus = NetworkApi.INSTANCE.m445requestAddCommentsgIAlus(requestBodyCreate, this);
                if (objM445requestAddCommentsgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM445requestAddCommentsgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM445requestAddCommentsgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void addComments(String classesId, String userId, String content, String type, boolean anonymity) {
        Intrinsics.checkNotNullParameter(classesId, "classesId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(type, "type");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(classesId, content, userId, type, anonymity, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.comments.CommentsViewModel$commentsList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommentsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.comments.CommentsViewModel$commentsList$1", f = "CommentsViewModel.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
    static final class C04631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $classesId;
        final /* synthetic */ String $endTime;
        final /* synthetic */ int $pageNo;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ String $startTime;
        final /* synthetic */ String $type;
        final /* synthetic */ String $userId;
        Object L$0;
        int label;
        final /* synthetic */ CommentsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04631(String str, String str2, String str3, String str4, String str5, int i, int i2, CommentsViewModel commentsViewModel, Continuation<? super C04631> continuation) {
            super(2, continuation);
            this.$classesId = str;
            this.$type = str2;
            this.$userId = str3;
            this.$startTime = str4;
            this.$endTime = str5;
            this.$pageNo = i;
            this.$pageSize = i2;
            this.this$0 = commentsViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04631(this.$classesId, this.$type, this.$userId, this.$startTime, this.$endTime, this.$pageNo, this.$pageSize, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM453requestCommentsListgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(CommentsHomeFragment.TYPE_CLASSESID, this.$classesId);
                linkedHashMap.put("type", this.$type);
                linkedHashMap.put("userId", this.$userId);
                linkedHashMap.put("startTime", this.$startTime);
                linkedHashMap.put("endTime", this.$endTime);
                linkedHashMap.put("pageNo", Boxing.boxInt(this.$pageNo));
                linkedHashMap.put("pageSize", Boxing.boxInt(this.$pageSize));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.commentsList;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM453requestCommentsListgIAlus = NetworkApi.INSTANCE.m453requestCommentsListgIAlus(requestBodyCreate, this);
                if (objM453requestCommentsListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM453requestCommentsListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM453requestCommentsListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void commentsList(String classesId, String type, String userId, String startTime, String endTime, int pageNo, int pageSize) {
        Intrinsics.checkNotNullParameter(classesId, "classesId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04631(classesId, type, userId, startTime, endTime, pageNo, pageSize, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.comments.CommentsViewModel$commentsDetail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommentsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.comments.CommentsViewModel$commentsDetail$1", f = "CommentsViewModel.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
    static final class C04621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04621(String str, Continuation<? super C04621> continuation) {
            super(2, continuation);
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CommentsViewModel.this.new C04621(this.$id, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData2 = CommentsViewModel.this.commentsDetail;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objM452requestCommentsDetailgIAlus = NetworkApi.INSTANCE.m452requestCommentsDetailgIAlus(this.$id, this);
                if (objM452requestCommentsDetailgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                value = objM452requestCommentsDetailgIAlus;
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

    public final void commentsDetail(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04621(id, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.comments.CommentsViewModel$commentsDelete$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommentsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.comments.CommentsViewModel$commentsDelete$1", f = "CommentsViewModel.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
    static final class C04611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04611(String str, Continuation<? super C04611> continuation) {
            super(2, continuation);
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CommentsViewModel.this.new C04611(this.$id, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData2 = CommentsViewModel.this.commentsDelete;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objM451requestCommentsDeletegIAlus = NetworkApi.INSTANCE.m451requestCommentsDeletegIAlus(this.$id, this);
                if (objM451requestCommentsDeletegIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                value = objM451requestCommentsDeletegIAlus;
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

    public final void commentsDelete(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04611(id, null), 3, null);
    }
}
