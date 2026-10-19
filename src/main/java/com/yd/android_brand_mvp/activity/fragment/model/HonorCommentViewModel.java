package com.yd.android_brand_mvp.activity.fragment.model;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.vivo.push.PushClientConstants;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.honor.HonorScoreListBean;
import com.yd.android_brand_mvp.model.honor.RuleOptionBean;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import java.util.ArrayList;
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
import okhttp3.RequestBody;

/* JADX INFO: compiled from: HonorCommentViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002Jf\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018J$\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006Jz\u0010\u001b\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018R \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/model/HonorCommentViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "commentListLiveData", "Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "Lkotlin/Result;", "", "getCommentListLiveData", "()Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "optionListLiveData", "", "Lcom/yd/android_brand_mvp/model/honor/HonorScoreListBean;", "getOptionListLiveData", "requestClassScoreComment", "", "schoolId", "identityId", "identityName", "activityId", "classId", PushClientConstants.TAG_CLASS_NAME, "gradeId", "gradeName", "detailList", "Ljava/util/ArrayList;", "Lcom/yd/android_brand_mvp/model/honor/RuleOptionBean;", "requestClassScoreResult", "requestStudentScoreComment", CommentsHomeFragment.TYPE_ID, "studentName", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorCommentViewModel extends ViewModel {
    private final SingleLiveEvent<Result<String>> commentListLiveData = new SingleLiveEvent<>();
    private final SingleLiveEvent<Result<List<HonorScoreListBean>>> optionListLiveData = new SingleLiveEvent<>();

    public final SingleLiveEvent<Result<String>> getCommentListLiveData() {
        return this.commentListLiveData;
    }

    public final SingleLiveEvent<Result<List<HonorScoreListBean>>> getOptionListLiveData() {
        return this.optionListLiveData;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.fragment.model.HonorCommentViewModel$requestClassScoreResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HonorCommentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.fragment.model.HonorCommentViewModel$requestClassScoreResult$1", f = "HonorCommentViewModel.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
    static final class C03421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $activityId;
        final /* synthetic */ String $classId;
        final /* synthetic */ String $identityId;
        Object L$0;
        int label;
        final /* synthetic */ HonorCommentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03421(String str, String str2, String str3, HonorCommentViewModel honorCommentViewModel, Continuation<? super C03421> continuation) {
            super(2, continuation);
            this.$activityId = str;
            this.$classId = str2;
            this.$identityId = str3;
            this.this$0 = honorCommentViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03421(this.$activityId, this.$classId, this.$identityId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM450requestClassScoreResultgIAlus;
            SingleLiveEvent<Result<List<HonorScoreListBean>>> singleLiveEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String str = this.$activityId;
                if (str == null) {
                    str = "";
                }
                linkedHashMap.put("activityId", str);
                String str2 = this.$classId;
                if (str2 == null) {
                    str2 = "";
                }
                linkedHashMap.put("classId", str2);
                String str3 = this.$identityId;
                linkedHashMap.put("identityId", str3 != null ? str3 : "");
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                SingleLiveEvent<Result<List<HonorScoreListBean>>> optionListLiveData = this.this$0.getOptionListLiveData();
                this.L$0 = optionListLiveData;
                this.label = 1;
                objM450requestClassScoreResultgIAlus = NetworkApi.INSTANCE.m450requestClassScoreResultgIAlus(requestBodyCreate, this);
                if (objM450requestClassScoreResultgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = optionListLiveData;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                singleLiveEvent = (SingleLiveEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM450requestClassScoreResultgIAlus = ((Result) obj).getValue();
            }
            singleLiveEvent.setValue(Result.m590boximpl(objM450requestClassScoreResultgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void requestClassScoreResult(String activityId, String classId, String identityId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03421(activityId, classId, identityId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.fragment.model.HonorCommentViewModel$requestStudentScoreComment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HonorCommentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.fragment.model.HonorCommentViewModel$requestStudentScoreComment$1", f = "HonorCommentViewModel.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    static final class C03431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $activityId;
        final /* synthetic */ String $classId;
        final /* synthetic */ String $className;
        final /* synthetic */ ArrayList<RuleOptionBean> $detailList;
        final /* synthetic */ String $gradeId;
        final /* synthetic */ String $gradeName;
        final /* synthetic */ String $identityId;
        final /* synthetic */ String $identityName;
        final /* synthetic */ String $schoolId;
        final /* synthetic */ String $studentId;
        final /* synthetic */ String $studentName;
        Object L$0;
        int label;
        final /* synthetic */ HonorCommentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03431(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, ArrayList<RuleOptionBean> arrayList, HonorCommentViewModel honorCommentViewModel, Continuation<? super C03431> continuation) {
            super(2, continuation);
            this.$schoolId = str;
            this.$identityId = str2;
            this.$identityName = str3;
            this.$activityId = str4;
            this.$studentId = str5;
            this.$studentName = str6;
            this.$classId = str7;
            this.$className = str8;
            this.$gradeId = str9;
            this.$gradeName = str10;
            this.$detailList = arrayList;
            this.this$0 = honorCommentViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03431(this.$schoolId, this.$identityId, this.$identityName, this.$activityId, this.$studentId, this.$studentName, this.$classId, this.$className, this.$gradeId, this.$gradeName, this.$detailList, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM469requestStudentScoreCommentgIAlus;
            SingleLiveEvent<Result<String>> singleLiveEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String str = this.$schoolId;
                if (str == null) {
                    str = "";
                }
                linkedHashMap.put("schoolId", str);
                String str2 = this.$identityId;
                if (str2 == null) {
                    str2 = "";
                }
                linkedHashMap.put("identityId", str2);
                String str3 = this.$identityName;
                if (str3 == null) {
                    str3 = "";
                }
                linkedHashMap.put("identityName", str3);
                String str4 = this.$activityId;
                if (str4 == null) {
                    str4 = "";
                }
                linkedHashMap.put("activityId", str4);
                String str5 = this.$studentId;
                if (str5 == null) {
                    str5 = "";
                }
                linkedHashMap.put(CommentsHomeFragment.TYPE_ID, str5);
                String str6 = this.$studentName;
                if (str6 == null) {
                    str6 = "";
                }
                linkedHashMap.put("studentName", str6);
                String str7 = this.$classId;
                if (str7 == null) {
                    str7 = "";
                }
                linkedHashMap.put("classId", str7);
                String str8 = this.$className;
                if (str8 == null) {
                    str8 = "";
                }
                linkedHashMap.put(PushClientConstants.TAG_CLASS_NAME, str8);
                String str9 = this.$gradeId;
                if (str9 == null) {
                    str9 = "";
                }
                linkedHashMap.put("gradeId", str9);
                String str10 = this.$gradeName;
                linkedHashMap.put("gradeName", str10 != null ? str10 : "");
                ArrayList<RuleOptionBean> arrayList = this.$detailList;
                if (arrayList != null) {
                    linkedHashMap.put("detailList", arrayList);
                }
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                SingleLiveEvent<Result<String>> commentListLiveData = this.this$0.getCommentListLiveData();
                this.L$0 = commentListLiveData;
                this.label = 1;
                objM469requestStudentScoreCommentgIAlus = NetworkApi.INSTANCE.m469requestStudentScoreCommentgIAlus(requestBodyCreate, this);
                if (objM469requestStudentScoreCommentgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = commentListLiveData;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                singleLiveEvent = (SingleLiveEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM469requestStudentScoreCommentgIAlus = ((Result) obj).getValue();
            }
            singleLiveEvent.setValue(Result.m590boximpl(objM469requestStudentScoreCommentgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void requestStudentScoreComment(String schoolId, String identityId, String identityName, String activityId, String studentId, String studentName, String classId, String className, String gradeId, String gradeName, ArrayList<RuleOptionBean> detailList) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03431(schoolId, identityId, identityName, activityId, studentId, studentName, classId, className, gradeId, gradeName, detailList, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.fragment.model.HonorCommentViewModel$requestClassScoreComment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HonorCommentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.fragment.model.HonorCommentViewModel$requestClassScoreComment$1", f = "HonorCommentViewModel.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $activityId;
        final /* synthetic */ String $classId;
        final /* synthetic */ String $className;
        final /* synthetic */ ArrayList<RuleOptionBean> $detailList;
        final /* synthetic */ String $gradeId;
        final /* synthetic */ String $gradeName;
        final /* synthetic */ String $identityId;
        final /* synthetic */ String $identityName;
        final /* synthetic */ String $schoolId;
        Object L$0;
        int label;
        final /* synthetic */ HonorCommentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, ArrayList<RuleOptionBean> arrayList, HonorCommentViewModel honorCommentViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$schoolId = str;
            this.$identityId = str2;
            this.$identityName = str3;
            this.$activityId = str4;
            this.$classId = str5;
            this.$className = str6;
            this.$gradeId = str7;
            this.$gradeName = str8;
            this.$detailList = arrayList;
            this.this$0 = honorCommentViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$schoolId, this.$identityId, this.$identityName, this.$activityId, this.$classId, this.$className, this.$gradeId, this.$gradeName, this.$detailList, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM449requestClassScoreCommentgIAlus;
            SingleLiveEvent<Result<String>> singleLiveEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String str = this.$schoolId;
                if (str == null) {
                    str = "";
                }
                linkedHashMap.put("schoolId", str);
                String str2 = this.$identityId;
                if (str2 == null) {
                    str2 = "";
                }
                linkedHashMap.put("identityId", str2);
                String str3 = this.$identityName;
                if (str3 == null) {
                    str3 = "";
                }
                linkedHashMap.put("identityName", str3);
                String str4 = this.$activityId;
                if (str4 == null) {
                    str4 = "";
                }
                linkedHashMap.put("activityId", str4);
                String str5 = this.$classId;
                if (str5 == null) {
                    str5 = "";
                }
                linkedHashMap.put("classId", str5);
                String str6 = this.$className;
                if (str6 == null) {
                    str6 = "";
                }
                linkedHashMap.put(PushClientConstants.TAG_CLASS_NAME, str6);
                String str7 = this.$gradeId;
                if (str7 == null) {
                    str7 = "";
                }
                linkedHashMap.put("gradeId", str7);
                String str8 = this.$gradeName;
                linkedHashMap.put("gradeName", str8 != null ? str8 : "");
                ArrayList<RuleOptionBean> arrayList = this.$detailList;
                if (arrayList != null) {
                    linkedHashMap.put("detailList", arrayList);
                }
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jSONString = JSON.toJSONString(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
                RequestBody requestBodyCreate = companion.create(jSONString, BaseConstant.JSON);
                SingleLiveEvent<Result<String>> commentListLiveData = this.this$0.getCommentListLiveData();
                this.L$0 = commentListLiveData;
                this.label = 1;
                objM449requestClassScoreCommentgIAlus = NetworkApi.INSTANCE.m449requestClassScoreCommentgIAlus(requestBodyCreate, this);
                if (objM449requestClassScoreCommentgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                singleLiveEvent = commentListLiveData;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                singleLiveEvent = (SingleLiveEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM449requestClassScoreCommentgIAlus = ((Result) obj).getValue();
            }
            singleLiveEvent.setValue(Result.m590boximpl(objM449requestClassScoreCommentgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void requestClassScoreComment(String schoolId, String identityId, String identityName, String activityId, String classId, String className, String gradeId, String gradeName, ArrayList<RuleOptionBean> detailList) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(schoolId, identityId, identityName, activityId, classId, className, gradeId, gradeName, detailList, this, null), 3, null);
    }
}
