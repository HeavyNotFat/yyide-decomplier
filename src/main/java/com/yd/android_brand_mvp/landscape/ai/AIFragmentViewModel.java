package com.yd.android_brand_mvp.landscape.ai;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.ai.AICreateSessionBean;
import com.yd.android_brand_mvp.model.ai.AIIntellectHomeBean;
import com.yd.android_brand_mvp.model.ai.AIModelBean;
import com.yd.android_brand_mvp.model.ai.AIProblemBean;
import com.yd.android_brand_mvp.network.ai.AINetwork;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.ArrayList;
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

/* JADX INFO: compiled from: AIFragmentViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010\u001d\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u0019J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\"2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\"R \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR#\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R&\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR#\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f0\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00050\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/ai/AIFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "aiCreateSession", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/ai/AICreateSessionBean;", "getAiCreateSession", "()Landroidx/lifecycle/LiveData;", "aiCreateSessionLiveData", "Landroidx/lifecycle/MutableLiveData;", "aiHomeList", "", "Lcom/yd/android_brand_mvp/model/ai/AIIntellectHomeBean;", "getAiHomeList", "aiHomeListLiveData", "aiModelLis", "Lcom/yd/android_brand_mvp/model/ai/AIModelBean;", "getAiModelLis", "aiModelListLiveData", "aiProblem", "Lcom/yd/android_brand_mvp/model/ai/AIProblemBean;", "getAiProblem", "aiProblemLiveData", "createSession", "", "assistantId", "", "model", "getAIHomeAgentList", "getAIInfo", "id", "getAIModelList", "getRandomPrompts", "", TUIKitConstants.Selection.LIST, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AIFragmentViewModel extends ViewModel {
    private final LiveData<Result<AICreateSessionBean>> aiCreateSession;
    private final MutableLiveData<Result<AICreateSessionBean>> aiCreateSessionLiveData;
    private final LiveData<Result<List<AIIntellectHomeBean>>> aiHomeList;
    private final MutableLiveData<Result<List<AIIntellectHomeBean>>> aiHomeListLiveData;
    private final LiveData<Result<List<AIModelBean>>> aiModelLis;
    private final MutableLiveData<Result<List<AIModelBean>>> aiModelListLiveData;
    private final LiveData<Result<AIProblemBean>> aiProblem;
    private final MutableLiveData<Result<AIProblemBean>> aiProblemLiveData;

    public AIFragmentViewModel() {
        MutableLiveData<Result<List<AIIntellectHomeBean>>> mutableLiveData = new MutableLiveData<>();
        this.aiHomeListLiveData = mutableLiveData;
        this.aiHomeList = mutableLiveData;
        MutableLiveData<Result<List<AIModelBean>>> mutableLiveData2 = new MutableLiveData<>();
        this.aiModelListLiveData = mutableLiveData2;
        this.aiModelLis = mutableLiveData2;
        MutableLiveData<Result<AICreateSessionBean>> mutableLiveData3 = new MutableLiveData<>();
        this.aiCreateSessionLiveData = mutableLiveData3;
        this.aiCreateSession = mutableLiveData3;
        MutableLiveData<Result<AIProblemBean>> mutableLiveData4 = new MutableLiveData<>();
        this.aiProblemLiveData = mutableLiveData4;
        this.aiProblem = mutableLiveData4;
    }

    public final LiveData<Result<List<AIIntellectHomeBean>>> getAiHomeList() {
        return this.aiHomeList;
    }

    public final LiveData<Result<List<AIModelBean>>> getAiModelLis() {
        return this.aiModelLis;
    }

    public final LiveData<Result<AICreateSessionBean>> getAiCreateSession() {
        return this.aiCreateSession;
    }

    public final LiveData<Result<AIProblemBean>> getAiProblem() {
        return this.aiProblem;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.ai.AIFragmentViewModel$getAIHomeAgentList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AIFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.ai.AIFragmentViewModel$getAIHomeAgentList$1", f = "AIFragmentViewModel.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
    static final class C03951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C03951(Continuation<? super C03951> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIFragmentViewModel.this.new C03951(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03951) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM483requestAIHomeListgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "");
                map2.put("status", "published");
                map2.put("isPublic", Boxing.boxBoolean(true));
                map2.put("ignoreCodeList", CollectionsKt.mutableListOf("sp_aphorism_image", "sp_code_gen", "sp_exam_paper_gen", "ap_homework_assistant"));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = AIFragmentViewModel.this.aiHomeListLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM483requestAIHomeListgIAlus = AINetwork.INSTANCE.m483requestAIHomeListgIAlus(requestBodyCreate, this);
                if (objM483requestAIHomeListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM483requestAIHomeListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM483requestAIHomeListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getAIHomeAgentList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03951(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.ai.AIFragmentViewModel$getAIModelList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AIFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.ai.AIFragmentViewModel$getAIModelList$1", f = "AIFragmentViewModel.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
    static final class C03971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C03971(Continuation<? super C03971> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIFragmentViewModel.this.new C03971(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03971) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM484requestAIModelListgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = AIFragmentViewModel.this.aiModelListLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM484requestAIModelListgIAlus = AINetwork.INSTANCE.m484requestAIModelListgIAlus(requestBodyCreate, this);
                if (objM484requestAIModelListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM484requestAIModelListgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM484requestAIModelListgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getAIModelList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03971(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.ai.AIFragmentViewModel$createSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: AIFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.ai.AIFragmentViewModel$createSession$1", f = "AIFragmentViewModel.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $assistantId;
        final /* synthetic */ String $model;
        Object L$0;
        int label;
        final /* synthetic */ AIFragmentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, AIFragmentViewModel aIFragmentViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$assistantId = str;
            this.$model = str2;
            this.this$0 = aIFragmentViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$assistantId, this.$model, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM481requestAICreateSessiongIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("assistantId", this.$assistantId);
                String str = this.$model;
                if (str == null) {
                    str = "";
                }
                map2.put("model", str);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.aiCreateSessionLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM481requestAICreateSessiongIAlus = AINetwork.INSTANCE.m481requestAICreateSessiongIAlus(requestBodyCreate, this);
                if (objM481requestAICreateSessiongIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM481requestAICreateSessiongIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM481requestAICreateSessiongIAlus));
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void createSession$default(AIFragmentViewModel aIFragmentViewModel, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        aIFragmentViewModel.createSession(str, str2);
    }

    public final void createSession(String assistantId, String model) {
        Intrinsics.checkNotNullParameter(assistantId, "assistantId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(assistantId, model, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.ai.AIFragmentViewModel$getAIInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AIFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.ai.AIFragmentViewModel$getAIInfo$1", f = "AIFragmentViewModel.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    static final class C03961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        Object L$0;
        int label;
        final /* synthetic */ AIFragmentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03961(String str, AIFragmentViewModel aIFragmentViewModel, Continuation<? super C03961> continuation) {
            super(2, continuation);
            this.$id = str;
            this.this$0 = aIFragmentViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03961(this.$id, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03961) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM482requestAIGetInfogIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                map.put("id", this.$id);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.aiProblemLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM482requestAIGetInfogIAlus = AINetwork.INSTANCE.m482requestAIGetInfogIAlus(requestBodyCreate, this);
                if (objM482requestAIGetInfogIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM482requestAIGetInfogIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM482requestAIGetInfogIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getAIInfo(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03961(id, this, null), 3, null);
    }

    public final List<String> getRandomPrompts(List<String> list) {
        if (list == null) {
            return new ArrayList();
        }
        return list.size() < 3 ? list : CollectionsKt.take(CollectionsKt.shuffled(list), 3);
    }
}
