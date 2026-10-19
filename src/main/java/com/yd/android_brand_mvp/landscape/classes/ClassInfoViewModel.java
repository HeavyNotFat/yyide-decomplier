package com.yd.android_brand_mvp.landscape.classes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.NewClassInfoRsp;
import com.yd.android_brand_mvp.model.NewWatchWordRsp;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.HashMap;
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

/* JADX INFO: compiled from: ClassInfoViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013R \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/classes/ClassInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "classInfoLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/NewClassInfoRsp$DataDTO;", "getClassInfoLiveData", "()Landroidx/lifecycle/MutableLiveData;", "mClassInfoLiveData", "mWatchWordLiveData", "", "Lcom/yd/android_brand_mvp/model/NewWatchWordRsp$DataDTO;", "watchWordLiveData", "getWatchWordLiveData", "getClassesInfo", "", "getWatchWord", CommentsHomeFragment.TYPE_CLASSESID, "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClassInfoViewModel extends ViewModel {
    private final MutableLiveData<Result<NewClassInfoRsp.DataDTO>> classInfoLiveData;
    private final MutableLiveData<Result<NewClassInfoRsp.DataDTO>> mClassInfoLiveData;
    private final MutableLiveData<Result<List<NewWatchWordRsp.DataDTO>>> mWatchWordLiveData;
    private final MutableLiveData<Result<List<NewWatchWordRsp.DataDTO>>> watchWordLiveData;

    public ClassInfoViewModel() {
        MutableLiveData<Result<NewClassInfoRsp.DataDTO>> mutableLiveData = new MutableLiveData<>();
        this.mClassInfoLiveData = mutableLiveData;
        this.classInfoLiveData = mutableLiveData;
        MutableLiveData<Result<List<NewWatchWordRsp.DataDTO>>> mutableLiveData2 = new MutableLiveData<>();
        this.mWatchWordLiveData = mutableLiveData2;
        this.watchWordLiveData = mutableLiveData2;
    }

    public final MutableLiveData<Result<NewClassInfoRsp.DataDTO>> getClassInfoLiveData() {
        return this.classInfoLiveData;
    }

    public final MutableLiveData<Result<List<NewWatchWordRsp.DataDTO>>> getWatchWordLiveData() {
        return this.watchWordLiveData;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.classes.ClassInfoViewModel$getClassesInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: ClassInfoViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.classes.ClassInfoViewModel$getClassesInfo$1", f = "ClassInfoViewModel.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClassInfoViewModel.this.new AnonymousClass1(continuation);
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
                MutableLiveData mutableLiveData2 = ClassInfoViewModel.this.mClassInfoLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objM424getClassesInfoIoAF18A = NetworkApi.INSTANCE.m424getClassesInfoIoAF18A(this);
                if (objM424getClassesInfoIoAF18A == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                value = objM424getClassesInfoIoAF18A;
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

    public final void getClassesInfo() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.classes.ClassInfoViewModel$getWatchWord$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ClassInfoViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.classes.ClassInfoViewModel$getWatchWord$1", f = "ClassInfoViewModel.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
    static final class C04191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $classesId;
        Object L$0;
        int label;
        final /* synthetic */ ClassInfoViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04191(String str, ClassInfoViewModel classInfoViewModel, Continuation<? super C04191> continuation) {
            super(2, continuation);
            this.$classesId = str;
            this.this$0 = classInfoViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04191(this.$classesId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04191) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM436getWatchWordgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                map.put(CommentsHomeFragment.TYPE_CLASSESID, this.$classesId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(map)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.mWatchWordLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM436getWatchWordgIAlus = NetworkApi.INSTANCE.m436getWatchWordgIAlus(requestBodyCreate, this);
                if (objM436getWatchWordgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM436getWatchWordgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM436getWatchWordgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getWatchWord(String classesId) {
        Intrinsics.checkNotNullParameter(classesId, "classesId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04191(classesId, this, null), 3, null);
    }
}
