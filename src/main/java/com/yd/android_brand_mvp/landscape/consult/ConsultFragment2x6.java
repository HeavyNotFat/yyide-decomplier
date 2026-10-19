package com.yd.android_brand_mvp.landscape.consult;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.consult.Consult2x6Adapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.FragmentConsult2x6Binding;
import com.yd.android_brand_mvp.dialog.ConsultDetailsDialog;
import com.yd.android_brand_mvp.dialog.ConsultListHeadDialog;
import com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
import com.yd.android_brand_mvp.model.reservation.ReservationSignListItemBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: compiled from: ConsultFragment2x6.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\u001a\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/yd/android_brand_mvp/landscape/consult/ConsultFragment2x6;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentConsult2x6Binding;", "()V", "bannerAdapter", "Lcom/yd/android_brand_mvp/adapter/consult/Consult2x6Adapter;", "showReservationList", "", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/reserve/viemodel/HomeReservationViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/reserve/viemodel/HomeReservationViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "UpdataEvent", "", "id", "", "getReservationList", "", TUIKitConstants.Selection.LIST, "initView", "initViewModel", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "setShowReservation", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConsultFragment2x6 extends KTBaseFragment<FragmentConsult2x6Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Consult2x6Adapter bannerAdapter;
    private final List<ReservationRecordBean> showReservationList;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.consult.ConsultFragment2x6$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConsultFragment2x6.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentConsult2x6Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentConsult2x6Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentConsult2x6Binding;", 0);
        }

        public final FragmentConsult2x6Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentConsult2x6Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentConsult2x6Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public ConsultFragment2x6() {
        super(AnonymousClass1.INSTANCE);
        final ConsultFragment2x6 consultFragment2x6 = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment2x6$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return consultFragment2x6;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment2x6$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function0.invoke();
            }
        });
        final Function0 function1 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(consultFragment2x6, Reflection.getOrCreateKotlinClass(HomeReservationViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment2x6$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "owner.viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment2x6$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function2 = function1;
                if (function2 != null && (creationExtras = (CreationExtras) function2.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM19viewModels$lambda1 = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM19viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM19viewModels$lambda1 : null;
                CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment2x6$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                ViewModelStoreOwner viewModelStoreOwnerM19viewModels$lambda1 = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM19viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM19viewModels$lambda1 : null;
                if (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) {
                    defaultViewModelProviderFactory = consultFragment2x6.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.bannerAdapter = new Consult2x6Adapter();
        this.showReservationList = new ArrayList();
    }

    public static final /* synthetic */ FragmentConsult2x6Binding access$getBinding(ConsultFragment2x6 consultFragment2x6) {
        return consultFragment2x6.getBinding();
    }

    /* JADX INFO: compiled from: ConsultFragment2x6.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/consult/ConsultFragment2x6$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/consult/ConsultFragment2x6;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConsultFragment2x6 newInstance() {
            return new ConsultFragment2x6();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeReservationViewModel getViewModel() {
        return (HomeReservationViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().mu.setViewState(2);
        initView();
        initViewModel();
    }

    private final void initView() {
        Banner startPosition;
        Banner adapter;
        Banner bannerIsAutoLoop;
        Banner loopTime;
        Banner indicator;
        Banner indicatorGravity;
        Banner indicatorSpace;
        Banner indicatorNormalColor;
        Banner indicatorSelectedColor;
        Banner indicatorWidth;
        Banner bannerAddBannerLifecycleObserver = getBinding().banner.addBannerLifecycleObserver(this);
        if (bannerAddBannerLifecycleObserver != null && (startPosition = bannerAddBannerLifecycleObserver.setStartPosition(1)) != null && (adapter = startPosition.setAdapter(this.bannerAdapter)) != null && (bannerIsAutoLoop = adapter.isAutoLoop(false)) != null && (loopTime = bannerIsAutoLoop.setLoopTime(5000L)) != null && (indicator = loopTime.setIndicator(new CircleIndicator(requireContext()))) != null && (indicatorGravity = indicator.setIndicatorGravity(1)) != null && (indicatorSpace = indicatorGravity.setIndicatorSpace(BannerUtils.dp2px(10.0f))) != null && (indicatorNormalColor = indicatorSpace.setIndicatorNormalColor(SimpleUtilsKt.asColor(R.color.gray))) != null && (indicatorSelectedColor = indicatorNormalColor.setIndicatorSelectedColor(SimpleUtilsKt.asColor(R.color.blue3))) != null && (indicatorWidth = indicatorSelectedColor.setIndicatorWidth(BannerUtils.dp2px(10.0f), BannerUtils.dp2px(10.0f))) != null) {
            indicatorWidth.setIndicatorHeight(BannerUtils.dp2px(10.0f));
        }
        getBinding().banner.setOnBannerListener(new OnBannerListener() { // from class: com.yd.android_brand_mvp.landscape.consult.-$$Lambda$ConsultFragment2x6$fDE8iFaz1xQS83I5ChOwbxm3UCo
            @Override // com.youth.banner.listener.OnBannerListener
            public final void OnBannerClick(Object obj, int i) {
                ConsultFragment2x6.initView$lambda$0(this.f$0, obj, i);
            }
        });
        this.bannerAdapter.setOnItemClickCallback(new Consult2x6Adapter.OnItemClickCallback() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment2x6.initView.2
            @Override // com.yd.android_brand_mvp.adapter.consult.Consult2x6Adapter.OnItemClickCallback
            public void itemClick(ReservationRecordBean data, List<ReservationSignListItemBean> list) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(list, "list");
                ConsultListHeadDialog consultListHeadDialog = new ConsultListHeadDialog(data, list);
                final ConsultFragment2x6 consultFragment2x6 = ConsultFragment2x6.this;
                consultListHeadDialog.setCallBack(new ConsultListHeadDialog.CallBack() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment2x6$initView$2$itemClick$1
                    @Override // com.yd.android_brand_mvp.dialog.ConsultListHeadDialog.CallBack
                    public void clickSubmit(ReservationRecordBean data2, ReservationSignListItemBean item) {
                        Intrinsics.checkNotNullParameter(data2, "data");
                        Intrinsics.checkNotNullParameter(item, "item");
                        new ConsultDetailsDialog(item.getUserId()).show(consultFragment2x6.getParentFragmentManager(), "ConsultListHeadDialog");
                    }
                });
                consultListHeadDialog.show(ConsultFragment2x6.this.getParentFragmentManager(), "ConsultListHeadDialog");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(ConsultFragment2x6 this$0, Object obj, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReservationRecordBean item = this$0.bannerAdapter.getData(i);
        ConsultSignDetailsActivity.Companion companion = ConsultSignDetailsActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        Intrinsics.checkNotNullExpressionValue(item, "item");
        companion.startGo(contextRequireContext, item);
    }

    private final void request() {
        String siteId = SpData.getSiteId();
        if (siteId == null) {
            siteId = "-1";
        }
        if (Intrinsics.areEqual(siteId, "-1")) {
            return;
        }
        HomeReservationViewModel.getReservationList$default(getViewModel(), 0, 0, 3, null);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (MinaConstants.CODE_RESERVE == id) {
            request();
        }
    }

    private final void initViewModel() {
        LiveData<Result<BasePageResponse<List<ReservationRecordBean>>>> reservationListAll = getViewModel().getReservationListAll();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends BasePageResponse<List<? extends ReservationRecordBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<? extends ReservationRecordBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment2x6.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<? extends ReservationRecordBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<? extends ReservationRecordBean>>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    BasePageResponse basePageResponse = (BasePageResponse) value;
                    List list = basePageResponse != null ? (List) basePageResponse.getList() : null;
                    if (list == null) {
                        ConsultFragment2x6.access$getBinding(ConsultFragment2x6.this).mu.setViewState(2);
                        return;
                    }
                    List listSortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment2x6$initViewModel$1$invoke$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(((ReservationRecordBean) t).getStartTimeStr(), ((ReservationRecordBean) t2).getStartTimeStr());
                        }
                    });
                    ConsultFragment2x6.this.showReservationList.clear();
                    ConsultFragment2x6.this.showReservationList.addAll(ConsultFragment2x6.this.getReservationList(listSortedWith));
                    if (ConsultFragment2x6.this.showReservationList.size() > 0) {
                        ConsultFragment2x6.access$getBinding(ConsultFragment2x6.this).mu.setViewState(0);
                        ConsultFragment2x6.access$getBinding(ConsultFragment2x6.this).banner.setDatas(ConsultFragment2x6.this.showReservationList);
                        Ref.IntRef intRef = new Ref.IntRef();
                        intRef.element = ConsultFragment2x6.this.getViewModel().getHighLightIndex(ConsultFragment2x6.this.showReservationList);
                        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                        if (intRef.element == -1) {
                            booleanRef.element = true;
                            intRef.element = ConsultFragment2x6.this.getViewModel().getNextHighLightIndex(ConsultFragment2x6.this.showReservationList);
                        }
                        if (intRef.element == -1) {
                            return;
                        }
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ConsultFragment2x6.this), null, null, new C01731(ConsultFragment2x6.this, intRef, booleanRef, null), 3, null);
                        return;
                    }
                    ConsultFragment2x6.access$getBinding(ConsultFragment2x6.this).mu.setViewState(2);
                }
            }

            /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.consult.ConsultFragment2x6$initViewModel$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: ConsultFragment2x6.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.consult.ConsultFragment2x6$initViewModel$1$1", f = "ConsultFragment2x6.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
            static final class C01731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Ref.IntRef $index;
                final /* synthetic */ Ref.BooleanRef $isNext;
                int label;
                final /* synthetic */ ConsultFragment2x6 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01731(ConsultFragment2x6 consultFragment2x6, Ref.IntRef intRef, Ref.BooleanRef booleanRef, Continuation<? super C01731> continuation) {
                    super(2, continuation);
                    this.this$0 = consultFragment2x6;
                    this.$index = intRef;
                    this.$isNext = booleanRef;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C01731(this.this$0, this.$index, this.$isNext, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C01731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        List unused = this.this$0.showReservationList;
                        ConsultFragment2x6 consultFragment2x6 = this.this$0;
                        Ref.IntRef intRef = this.$index;
                        Ref.BooleanRef booleanRef = this.$isNext;
                        ReservationRecordBean reservationRecordBean = (ReservationRecordBean) consultFragment2x6.showReservationList.get(intRef.element);
                        String endTimeStr = reservationRecordBean.getEndTimeStr();
                        if (booleanRef.element) {
                            endTimeStr = reservationRecordBean.getStartTimeStr();
                        }
                        long timestamp = (DateUtils.getTimestamp(endTimeStr, TimeUtil.notSecondFormat) - System.currentTimeMillis()) + ((long) 10000);
                        Log.d("setDataTime", "nextTimeInterval = " + timestamp);
                        HomeReservationViewModel viewModel = consultFragment2x6.getViewModel();
                        this.label = 1;
                        if (viewModel.startTimer(timestamp, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        };
        reservationListAll.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.consult.-$$Lambda$ConsultFragment2x6$CUEweQOVOkVjdA-T4FdWXntMQk0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ConsultFragment2x6.initViewModel$lambda$1(function1, obj);
            }
        });
        request();
        setShowReservation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.consult.ConsultFragment2x6$setShowReservation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConsultFragment2x6.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.consult.ConsultFragment2x6$setShowReservation$1", f = "ConsultFragment2x6.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
    static final class C04211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C04211(Continuation<? super C04211> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConsultFragment2x6.this.new C04211(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow<String> timeSharedFlow = ConsultFragment2x6.this.getViewModel().getTimeSharedFlow();
                final ConsultFragment2x6 consultFragment2x6 = ConsultFragment2x6.this;
                this.label = 1;
                if (timeSharedFlow.collect(new FlowCollector() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment2x6.setShowReservation.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((String) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(String str, Continuation<? super Unit> continuation) {
                        Log.d("setDataTime", "更新最新的三条预约记录");
                        ConsultFragment2x6 consultFragment2x7 = consultFragment2x6;
                        List reservationList = consultFragment2x7.getReservationList(consultFragment2x7.showReservationList);
                        boolean z = true;
                        if (!reservationList.isEmpty()) {
                            ConsultFragment2x6.access$getBinding(consultFragment2x6).mu.setViewState(0);
                            ConsultFragment2x6.access$getBinding(consultFragment2x6).banner.setDatas(consultFragment2x6.showReservationList);
                        } else {
                            ConsultFragment2x6.access$getBinding(consultFragment2x6).mu.setViewState(2);
                        }
                        consultFragment2x6.showReservationList.clear();
                        consultFragment2x6.showReservationList.addAll(reservationList);
                        if (consultFragment2x6.showReservationList.size() > 0) {
                            ConsultFragment2x6.access$getBinding(consultFragment2x6).mu.setViewState(0);
                            ConsultFragment2x6.access$getBinding(consultFragment2x6).banner.setDatas(consultFragment2x6.showReservationList);
                            int highLightIndex = consultFragment2x6.getViewModel().getHighLightIndex(consultFragment2x6.showReservationList);
                            if (highLightIndex == -1) {
                                highLightIndex = consultFragment2x6.getViewModel().getNextHighLightIndex(consultFragment2x6.showReservationList);
                            } else {
                                z = false;
                            }
                            if (highLightIndex != -1) {
                                ReservationRecordBean reservationRecordBean = (ReservationRecordBean) consultFragment2x6.showReservationList.get(highLightIndex);
                                String endTimeStr = reservationRecordBean.getEndTimeStr();
                                if (z) {
                                    endTimeStr = reservationRecordBean.getStartTimeStr();
                                }
                                long timestamp = (DateUtils.getTimestamp(endTimeStr, TimeUtil.notSecondFormat) - System.currentTimeMillis()) + ((long) 10000);
                                Log.d("setDataTime", "nextTimeInterval = " + timestamp);
                                Object objStartTimer = consultFragment2x6.getViewModel().startTimer(timestamp, continuation);
                                return objStartTimer == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objStartTimer : Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        }
                        ConsultFragment2x6.access$getBinding(consultFragment2x6).mu.setViewState(2);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    private final void setShowReservation() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C04211(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ReservationRecordBean> getReservationList(List<ReservationRecordBean> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (ReservationRecordBean reservationRecordBean : list) {
            if ((reservationRecordBean.getEndTimeStr().length() > 0) && DateUtils.isNextTime(reservationRecordBean.getEndTimeStr(), TimeUtil.notSecondFormat) && i < 3) {
                i++;
                arrayList.add(reservationRecordBean);
            }
        }
        return arrayList;
    }
}
