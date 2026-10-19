package com.yd.android_brand_mvp.landscape.library.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mmkv.MMKV;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.model.library.LibraryBean;
import com.yd.android_brand_mvp.model.library.LibraryCollectBookSituationBean;
import com.yd.android_brand_mvp.model.library.LibraryItemBean;
import com.yd.android_brand_mvp.model.library.LibraryTypeBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.library.LibraryNetwork;
import com.yd.android_brand_mvp.utils.ConversionUtil;
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

/* JADX INFO: compiled from: LibraryFragmentViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010%J\u000e\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020%J\u0006\u0010\r\u001a\u00020#J\u0006\u0010\u0015\u001a\u00020#J\u000e\u0010 \u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u001a\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010%JV\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020%2\u0006\u0010$\u001a\u00020%R\u001f\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\bR\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u001a\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u001c0\u001b0\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\bR)\u0010\u001e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u001c0\u001b0\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\bR\u001a\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/library/viewmodel/LibraryFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "libraryBookSituation", "Landroidx/lifecycle/LiveData;", "", "Lcom/yd/android_brand_mvp/model/library/LibraryCollectBookSituationBean;", "getLibraryBookSituation", "()Landroidx/lifecycle/LiveData;", "libraryBookSituationLiveData", "Landroidx/lifecycle/MutableLiveData;", "libraryClassifyList", "Lcom/yd/android_brand_mvp/model/library/LibraryTypeBean;", "getLibraryClassifyList", "libraryClassifyListLiveData", "libraryHotList", "Lcom/yd/android_brand_mvp/model/library/LibraryItemBean;", "getLibraryHotList", "libraryHotListLiveData", "libraryList", "Lcom/yd/android_brand_mvp/model/library/LibraryBean;", "getLibraryList", "libraryListLiveData", "libraryRecommended", "getLibraryRecommended", "libraryRecommendedLiveData", "librarySearch", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "getLibrarySearch", "librarySearchLiveData", "libraryTypeList", "getLibraryTypeList", "libraryTypeListLiveData", "getHotList", "", "libraryId", "", "date", "categoryId", "getLibraryBookSituationList", "id", "getNewList", FirebaseAnalytics.Event.SEARCH, "pageNo", "", "fullText", "itemTypeId", "title", "firstAuthor", "publisherName", "startTime", "endTime", "order", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LibraryFragmentViewModel extends ViewModel {
    private final LiveData<List<LibraryCollectBookSituationBean>> libraryBookSituation;
    private final MutableLiveData<List<LibraryCollectBookSituationBean>> libraryBookSituationLiveData;
    private final LiveData<List<LibraryTypeBean>> libraryClassifyList;
    private final MutableLiveData<List<LibraryTypeBean>> libraryClassifyListLiveData;
    private final LiveData<List<LibraryItemBean>> libraryHotList;
    private final MutableLiveData<List<LibraryItemBean>> libraryHotListLiveData;
    private final LiveData<List<LibraryBean>> libraryList;
    private final MutableLiveData<List<LibraryBean>> libraryListLiveData;
    private final LiveData<List<LibraryItemBean>> libraryRecommended;
    private final MutableLiveData<List<LibraryItemBean>> libraryRecommendedLiveData;
    private final LiveData<Result<BasePageResponse<List<LibraryItemBean>>>> librarySearch;
    private final MutableLiveData<Result<BasePageResponse<List<LibraryItemBean>>>> librarySearchLiveData;
    private final LiveData<List<LibraryTypeBean>> libraryTypeList;
    private final MutableLiveData<List<LibraryTypeBean>> libraryTypeListLiveData;

    public LibraryFragmentViewModel() {
        MutableLiveData<List<LibraryBean>> mutableLiveData = new MutableLiveData<>();
        this.libraryListLiveData = mutableLiveData;
        this.libraryList = mutableLiveData;
        MutableLiveData<List<LibraryItemBean>> mutableLiveData2 = new MutableLiveData<>();
        this.libraryHotListLiveData = mutableLiveData2;
        this.libraryHotList = mutableLiveData2;
        MutableLiveData<List<LibraryTypeBean>> mutableLiveData3 = new MutableLiveData<>();
        this.libraryTypeListLiveData = mutableLiveData3;
        this.libraryTypeList = mutableLiveData3;
        MutableLiveData<List<LibraryTypeBean>> mutableLiveData4 = new MutableLiveData<>();
        this.libraryClassifyListLiveData = mutableLiveData4;
        this.libraryClassifyList = mutableLiveData4;
        MutableLiveData<List<LibraryItemBean>> mutableLiveData5 = new MutableLiveData<>();
        this.libraryRecommendedLiveData = mutableLiveData5;
        this.libraryRecommended = mutableLiveData5;
        MutableLiveData<List<LibraryCollectBookSituationBean>> mutableLiveData6 = new MutableLiveData<>();
        this.libraryBookSituationLiveData = mutableLiveData6;
        this.libraryBookSituation = mutableLiveData6;
        MutableLiveData<Result<BasePageResponse<List<LibraryItemBean>>>> mutableLiveData7 = new MutableLiveData<>();
        this.librarySearchLiveData = mutableLiveData7;
        this.librarySearch = mutableLiveData7;
    }

    public final LiveData<List<LibraryBean>> getLibraryList() {
        return this.libraryList;
    }

    public final LiveData<List<LibraryItemBean>> getLibraryHotList() {
        return this.libraryHotList;
    }

    public final LiveData<List<LibraryTypeBean>> getLibraryTypeList() {
        return this.libraryTypeList;
    }

    public final LiveData<List<LibraryTypeBean>> getLibraryClassifyList() {
        return this.libraryClassifyList;
    }

    public final LiveData<List<LibraryItemBean>> getLibraryRecommended() {
        return this.libraryRecommended;
    }

    public final LiveData<List<LibraryCollectBookSituationBean>> getLibraryBookSituation() {
        return this.libraryBookSituation;
    }

    public final LiveData<Result<BasePageResponse<List<LibraryItemBean>>>> getLibrarySearch() {
        return this.librarySearch;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.library.viewmodel.LibraryFragmentViewModel$getLibraryList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LibraryFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.library.viewmodel.LibraryFragmentViewModel$getLibraryList$1", f = "LibraryFragmentViewModel.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
    static final class C04831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C04831(Continuation<? super C04831> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LibraryFragmentViewModel.this.new C04831(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM516requestLibraryListgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                this.label = 1;
                objM516requestLibraryListgIAlus = LibraryNetwork.INSTANCE.m516requestLibraryListgIAlus(requestBodyCreate, this);
                if (objM516requestLibraryListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM516requestLibraryListgIAlus = ((Result) obj).getValue();
            }
            LibraryFragmentViewModel.this.libraryListLiveData.setValue(Result.m597isFailureimpl(objM516requestLibraryListgIAlus) ? null : objM516requestLibraryListgIAlus);
            MMKV mmkvDefaultMMKV = MMKV.defaultMMKV();
            if (Result.m597isFailureimpl(objM516requestLibraryListgIAlus)) {
                objM516requestLibraryListgIAlus = null;
            }
            mmkvDefaultMMKV.encode(MMKVConstant.LIBRARY_LIST_KEY, GsonUtils.toJson(objM516requestLibraryListgIAlus));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: getLibraryList, reason: collision with other method in class */
    public final void m356getLibraryList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04831(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.library.viewmodel.LibraryFragmentViewModel$getLibraryTypeList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LibraryFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.library.viewmodel.LibraryFragmentViewModel$getLibraryTypeList$1", f = "LibraryFragmentViewModel.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
    static final class C04841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $libraryId;
        int label;
        final /* synthetic */ LibraryFragmentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04841(String str, LibraryFragmentViewModel libraryFragmentViewModel, Continuation<? super C04841> continuation) {
            super(2, continuation);
            this.$libraryId = str;
            this.this$0 = libraryFragmentViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04841(this.$libraryId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM519requestLibraryTypeListgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                objM519requestLibraryTypeListgIAlus = LibraryNetwork.INSTANCE.m519requestLibraryTypeListgIAlus(this.$libraryId, this);
                if (objM519requestLibraryTypeListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM519requestLibraryTypeListgIAlus = ((Result) obj).getValue();
            }
            MutableLiveData mutableLiveData = this.this$0.libraryTypeListLiveData;
            if (Result.m597isFailureimpl(objM519requestLibraryTypeListgIAlus)) {
                objM519requestLibraryTypeListgIAlus = null;
            }
            mutableLiveData.setValue(objM519requestLibraryTypeListgIAlus);
            return Unit.INSTANCE;
        }
    }

    public final void getLibraryTypeList(String libraryId) {
        Intrinsics.checkNotNullParameter(libraryId, "libraryId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04841(libraryId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.library.viewmodel.LibraryFragmentViewModel$getLibraryClassifyList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LibraryFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.library.viewmodel.LibraryFragmentViewModel$getLibraryClassifyList$1", f = "LibraryFragmentViewModel.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
    static final class C04821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C04821(Continuation<? super C04821> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LibraryFragmentViewModel.this.new C04821(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM515requestLibraryClassifyListgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                this.label = 1;
                objM515requestLibraryClassifyListgIAlus = LibraryNetwork.INSTANCE.m515requestLibraryClassifyListgIAlus(requestBodyCreate, this);
                if (objM515requestLibraryClassifyListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM515requestLibraryClassifyListgIAlus = ((Result) obj).getValue();
            }
            MutableLiveData mutableLiveData = LibraryFragmentViewModel.this.libraryClassifyListLiveData;
            if (Result.m597isFailureimpl(objM515requestLibraryClassifyListgIAlus)) {
                objM515requestLibraryClassifyListgIAlus = null;
            }
            mutableLiveData.setValue(objM515requestLibraryClassifyListgIAlus);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: getLibraryClassifyList, reason: collision with other method in class */
    public final void m355getLibraryClassifyList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04821(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.library.viewmodel.LibraryFragmentViewModel$getHotList$1, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.library.viewmodel.LibraryFragmentViewModel$getHotList$1", f = "LibraryFragmentViewModel.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $categoryId;
        final /* synthetic */ String $date;
        final /* synthetic */ String $libraryId;
        int label;
        final /* synthetic */ LibraryFragmentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, LibraryFragmentViewModel libraryFragmentViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$categoryId = str;
            this.$date = str2;
            this.$libraryId = str3;
            this.this$0 = libraryFragmentViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$categoryId, this.$date, this.$libraryId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM513requestHotListgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                String str = this.$categoryId;
                if (str == null) {
                    str = "";
                }
                map2.put("categoryId", str);
                String str2 = this.$date;
                if (str2 == null) {
                    str2 = ConversionUtil.conditionWithBookType;
                }
                map2.put("day", str2);
                map2.put("libraryId", this.$libraryId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                this.label = 1;
                objM513requestHotListgIAlus = LibraryNetwork.INSTANCE.m513requestHotListgIAlus(requestBodyCreate, this);
                if (objM513requestHotListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM513requestHotListgIAlus = ((Result) obj).getValue();
            }
            if (Result.m598isSuccessimpl(objM513requestHotListgIAlus)) {
                MutableLiveData mutableLiveData = this.this$0.libraryHotListLiveData;
                if (Result.m597isFailureimpl(objM513requestHotListgIAlus)) {
                    objM513requestHotListgIAlus = null;
                }
                mutableLiveData.setValue(objM513requestHotListgIAlus);
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void getHotList$default(LibraryFragmentViewModel libraryFragmentViewModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = ConversionUtil.conditionWithBookType;
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        libraryFragmentViewModel.getHotList(str, str2, str3);
    }

    public final void getHotList(String libraryId, String date, String categoryId) {
        Intrinsics.checkNotNullParameter(libraryId, "libraryId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(categoryId, date, libraryId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.library.viewmodel.LibraryFragmentViewModel$getNewList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LibraryFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.library.viewmodel.LibraryFragmentViewModel$getNewList$1", f = "LibraryFragmentViewModel.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
    static final class C04851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $categoryId;
        final /* synthetic */ String $libraryId;
        int label;
        final /* synthetic */ LibraryFragmentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04851(String str, String str2, LibraryFragmentViewModel libraryFragmentViewModel, Continuation<? super C04851> continuation) {
            super(2, continuation);
            this.$categoryId = str;
            this.$libraryId = str2;
            this.this$0 = libraryFragmentViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04851(this.$categoryId, this.$libraryId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04851) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM517requestLibraryNewRecommendedListgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                String str = this.$categoryId;
                if (str == null) {
                    str = "";
                }
                map2.put("categoryId", str);
                map2.put("libraryId", this.$libraryId);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                this.label = 1;
                objM517requestLibraryNewRecommendedListgIAlus = LibraryNetwork.INSTANCE.m517requestLibraryNewRecommendedListgIAlus(requestBodyCreate, this);
                if (objM517requestLibraryNewRecommendedListgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM517requestLibraryNewRecommendedListgIAlus = ((Result) obj).getValue();
            }
            if (Result.m598isSuccessimpl(objM517requestLibraryNewRecommendedListgIAlus)) {
                MutableLiveData mutableLiveData = this.this$0.libraryRecommendedLiveData;
                if (Result.m597isFailureimpl(objM517requestLibraryNewRecommendedListgIAlus)) {
                    objM517requestLibraryNewRecommendedListgIAlus = null;
                }
                mutableLiveData.setValue(objM517requestLibraryNewRecommendedListgIAlus);
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void getNewList$default(LibraryFragmentViewModel libraryFragmentViewModel, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        libraryFragmentViewModel.getNewList(str, str2);
    }

    public final void getNewList(String libraryId, String categoryId) {
        Intrinsics.checkNotNullParameter(libraryId, "libraryId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04851(categoryId, libraryId, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.library.viewmodel.LibraryFragmentViewModel$getLibraryBookSituationList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LibraryFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.library.viewmodel.LibraryFragmentViewModel$getLibraryBookSituationList$1", f = "LibraryFragmentViewModel.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
    static final class C04811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        int label;
        final /* synthetic */ LibraryFragmentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04811(String str, LibraryFragmentViewModel libraryFragmentViewModel, Continuation<? super C04811> continuation) {
            super(2, continuation);
            this.$id = str;
            this.this$0 = libraryFragmentViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04811(this.$id, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM514requestLibraryBookSituationgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("id", this.$id);
                map2.put("pageNo", Boxing.boxInt(1));
                map2.put("pageSize", Boxing.boxInt(99));
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                this.label = 1;
                objM514requestLibraryBookSituationgIAlus = LibraryNetwork.INSTANCE.m514requestLibraryBookSituationgIAlus(requestBodyCreate, this);
                if (objM514requestLibraryBookSituationgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM514requestLibraryBookSituationgIAlus = ((Result) obj).getValue();
            }
            if (Result.m598isSuccessimpl(objM514requestLibraryBookSituationgIAlus)) {
                if (Result.m597isFailureimpl(objM514requestLibraryBookSituationgIAlus)) {
                    objM514requestLibraryBookSituationgIAlus = null;
                }
                BasePageResponse basePageResponse = (BasePageResponse) objM514requestLibraryBookSituationgIAlus;
                this.this$0.libraryBookSituationLiveData.setValue(basePageResponse != null ? (List) basePageResponse.getList() : null);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getLibraryBookSituationList(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04811(id, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.library.viewmodel.LibraryFragmentViewModel$search$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LibraryFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.library.viewmodel.LibraryFragmentViewModel$search$1", f = "LibraryFragmentViewModel.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
    static final class C04861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $endTime;
        final /* synthetic */ String $firstAuthor;
        final /* synthetic */ String $fullText;
        final /* synthetic */ String $itemTypeId;
        final /* synthetic */ String $libraryId;
        final /* synthetic */ String $order;
        final /* synthetic */ int $pageNo;
        final /* synthetic */ String $publisherName;
        final /* synthetic */ String $startTime;
        final /* synthetic */ String $title;
        Object L$0;
        int label;
        final /* synthetic */ LibraryFragmentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04861(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, LibraryFragmentViewModel libraryFragmentViewModel, Continuation<? super C04861> continuation) {
            super(2, continuation);
            this.$pageNo = i;
            this.$libraryId = str;
            this.$fullText = str2;
            this.$itemTypeId = str3;
            this.$title = str4;
            this.$firstAuthor = str5;
            this.$publisherName = str6;
            this.$startTime = str7;
            this.$endTime = str8;
            this.$order = str9;
            this.this$0 = libraryFragmentViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04861(this.$pageNo, this.$libraryId, this.$fullText, this.$itemTypeId, this.$title, this.$firstAuthor, this.$publisherName, this.$startTime, this.$endTime, this.$order, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04861) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM518requestLibrarySearchgIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("pageNo", Boxing.boxInt(this.$pageNo));
                map2.put("pageSize", Boxing.boxInt(20));
                map2.put("libraryId", this.$libraryId);
                map2.put("fullText", this.$fullText);
                map2.put("type", this.$itemTypeId);
                map2.put("title", this.$title);
                map2.put("firstAuthor", this.$firstAuthor);
                map2.put("publisherName", this.$publisherName);
                map2.put("startPublication", this.$startTime);
                map2.put("endPublication", this.$endTime);
                String str = this.$order;
                if (str == null) {
                    str = "DESC";
                }
                map2.put("order", str);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.librarySearchLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM518requestLibrarySearchgIAlus = LibraryNetwork.INSTANCE.m518requestLibrarySearchgIAlus(requestBodyCreate, this);
                if (objM518requestLibrarySearchgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM518requestLibrarySearchgIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM518requestLibrarySearchgIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void search(int pageNo, String fullText, String itemTypeId, String title, String firstAuthor, String publisherName, String startTime, String endTime, String order, String libraryId) {
        Intrinsics.checkNotNullParameter(fullText, "fullText");
        Intrinsics.checkNotNullParameter(itemTypeId, "itemTypeId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(firstAuthor, "firstAuthor");
        Intrinsics.checkNotNullParameter(publisherName, "publisherName");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(order, "order");
        Intrinsics.checkNotNullParameter(libraryId, "libraryId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04861(pageNo, libraryId, fullText, itemTypeId, title, firstAuthor, publisherName, startTime, endTime, order, this, null), 3, null);
    }
}
