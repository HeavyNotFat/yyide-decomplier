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
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.FragmentConsult4x4Binding;
import com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
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

/* JADX INFO: compiled from: ConsultFragment4x4.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\b\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0016\u0010\u001a\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\u001a\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0018H\u0002J\b\u0010&\u001a\u00020\u0018H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lcom/yd/android_brand_mvp/landscape/consult/ConsultFragment4x4;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentConsult4x4Binding;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "mAdapter", "com/yd/android_brand_mvp/landscape/consult/ConsultFragment4x4$mAdapter$1", "Lcom/yd/android_brand_mvp/landscape/consult/ConsultFragment4x4$mAdapter$1;", "pageNo", "", "pageSize", "showItem", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "showReservationList", "", "viewModel", "Lcom/yd/android_brand_mvp/landscape/reserve/viemodel/HomeReservationViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/reserve/viemodel/HomeReservationViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "UpdataEvent", "", "id", "getHighLightIndex", TUIKitConstants.Selection.LIST, "", "initLoadMore", "initView", "initViewModel", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "setShowReservation", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConsultFragment4x4 extends KTBaseFragment<FragmentConsult4x4Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LAYOUT_TAG = "layoutTag";
    private final String TAG;
    private final ConsultFragment4x4$mAdapter$1 mAdapter;
    private int pageNo;
    private int pageSize;
    private ReservationRecordBean showItem;
    private final List<ReservationRecordBean> showReservationList;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.consult.ConsultFragment4x4$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConsultFragment4x4.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentConsult4x4Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentConsult4x4Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentConsult4x4Binding;", 0);
        }

        public final FragmentConsult4x4Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentConsult4x4Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentConsult4x4Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public ConsultFragment4x4() {
        super(AnonymousClass1.INSTANCE);
        this.TAG = ConsultFragment4x4.class.getSimpleName();
        final ConsultFragment4x4 consultFragment4x4 = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment4x4$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return consultFragment4x4;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment4x4$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(consultFragment4x4, Reflection.getOrCreateKotlinClass(HomeReservationViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment4x4$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment4x4$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment4x4$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = consultFragment4x4.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.showReservationList = new ArrayList();
        this.showItem = new ReservationRecordBean(null, 0, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, 0, null, 134217727, null);
        this.pageNo = 1;
        this.pageSize = 20;
        this.mAdapter = new ConsultFragment4x4$mAdapter$1(this);
    }

    /* JADX INFO: compiled from: ConsultFragment4x4.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/consult/ConsultFragment4x4$Companion;", "", "()V", "LAYOUT_TAG", "", "getLAYOUT_TAG", "()Ljava/lang/String;", "newInstance", "Lcom/yd/android_brand_mvp/landscape/consult/ConsultFragment4x4;", RemoteMessageConst.Notification.TAG, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getLAYOUT_TAG() {
            return ConsultFragment4x4.LAYOUT_TAG;
        }

        public final ConsultFragment4x4 newInstance(String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            ConsultFragment4x4 consultFragment4x4 = new ConsultFragment4x4();
            Bundle bundle = new Bundle();
            bundle.putString(ConsultFragment4x4.INSTANCE.getLAYOUT_TAG(), tag);
            consultFragment4x4.setArguments(bundle);
            return consultFragment4x4;
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
        initView();
        initViewModel();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        if (arguments != null && Intrinsics.areEqual(arguments.getString(LAYOUT_TAG), "sbxlyy4x4")) {
            getBinding().getRoot().getLayoutParams().width = SizeUtils.dp2px(660.0f);
            getBinding().getRoot().getLayoutParams().height = SizeUtils.dp2px(868.0f);
        }
        getBinding().top.title.setText(getString(R.string.counselor_reserved_list_title));
        getBinding().top.ivBack.setBackgroundResource(R.drawable.bg_comment_bt_40_2);
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        this.mAdapter.setEmptyView(R.layout.item_null_layout_4);
        this.mAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.consult.-$$Lambda$ConsultFragment4x4$Gfo3n6-Bz-oMsTadU-6QPPH8O6s
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ConsultFragment4x4.initView$lambda$1(this.f$0, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(ConsultFragment4x4 this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        ReservationRecordBean item = this$0.mAdapter.getItem(i);
        if (TimeUtil.isTime(item.getStartTimeStr(), item.getEndTimeStr())) {
            ConsultSignDetailsActivity.Companion companion = ConsultSignDetailsActivity.INSTANCE;
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.startGo(contextRequireContext, item);
        }
    }

    private final void request() {
        String siteId = SpData.getSiteId();
        if (siteId == null) {
            siteId = "-1";
        }
        if (Intrinsics.areEqual(siteId, "-1")) {
            return;
        }
        getViewModel().getReservationList(this.pageNo, this.pageSize);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (MinaConstants.CODE_RESERVE == id) {
            request();
        }
    }

    private final void initLoadMore() {
        this.mAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.yd.android_brand_mvp.landscape.consult.-$$Lambda$ConsultFragment4x4$2YBIbV20Afx-nTLwMCO2_xcdQvc
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                ConsultFragment4x4.initLoadMore$lambda$2(this.f$0);
            }
        });
        this.mAdapter.getLoadMoreModule().setAutoLoadMore(true);
        this.mAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLoadMore$lambda$2(ConsultFragment4x4 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAdapter.getLoadMoreModule().setEnableLoadMore(true);
        this$0.pageNo++;
        this$0.request();
    }

    private final void initViewModel() {
        LiveData<Result<BasePageResponse<List<ReservationRecordBean>>>> reservationListAll = getViewModel().getReservationListAll();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends BasePageResponse<List<? extends ReservationRecordBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<? extends ReservationRecordBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment4x4.initViewModel.1
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
                    if (list != null) {
                        List<ReservationRecordBean> reservationList = ConsultFragment4x4.this.getViewModel().getReservationList(CollectionsKt.sortedWith(list, new Comparator() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment4x4$initViewModel$1$invoke$$inlined$sortedBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                return ComparisonsKt.compareValues(((ReservationRecordBean) t).getStartTimeStr(), ((ReservationRecordBean) t2).getStartTimeStr());
                            }
                        }));
                        ConsultFragment4x4.this.mAdapter.setList(reservationList);
                        ConsultFragment4x4.this.showReservationList.clear();
                        ConsultFragment4x4.this.showReservationList.addAll(reservationList);
                        Ref.IntRef intRef = new Ref.IntRef();
                        ConsultFragment4x4 consultFragment4x4 = ConsultFragment4x4.this;
                        intRef.element = consultFragment4x4.getHighLightIndex(consultFragment4x4.showReservationList);
                        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                        if (intRef.element == -1) {
                            booleanRef.element = true;
                            intRef.element = ConsultFragment4x4.this.getViewModel().getNextHighLightIndex(ConsultFragment4x4.this.showReservationList);
                        }
                        if (intRef.element == -1) {
                            return;
                        }
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ConsultFragment4x4.this), null, null, new C01751(ConsultFragment4x4.this, intRef, booleanRef, null), 3, null);
                    }
                }
            }

            /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.consult.ConsultFragment4x4$initViewModel$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: ConsultFragment4x4.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.consult.ConsultFragment4x4$initViewModel$1$1", f = "ConsultFragment4x4.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
            static final class C01751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Ref.IntRef $index;
                final /* synthetic */ Ref.BooleanRef $isNext;
                int label;
                final /* synthetic */ ConsultFragment4x4 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01751(ConsultFragment4x4 consultFragment4x4, Ref.IntRef intRef, Ref.BooleanRef booleanRef, Continuation<? super C01751> continuation) {
                    super(2, continuation);
                    this.this$0 = consultFragment4x4;
                    this.$index = intRef;
                    this.$isNext = booleanRef;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C01751(this.this$0, this.$index, this.$isNext, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C01751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ConsultFragment4x4 consultFragment4x4 = this.this$0;
                        consultFragment4x4.showItem = (ReservationRecordBean) consultFragment4x4.showReservationList.get(this.$index.element);
                        String endTimeStr = this.this$0.showItem.getEndTimeStr();
                        if (this.$isNext.element) {
                            endTimeStr = this.this$0.showItem.getStartTimeStr();
                        }
                        long timestamp = (DateUtils.getTimestamp(endTimeStr, TimeUtil.notSecondFormat) - System.currentTimeMillis()) + ((long) 10000);
                        Log.i(this.this$0.TAG, "nextTimeInterval 4x4 = " + timestamp);
                        this.label = 1;
                        if (this.this$0.getViewModel().startTimer(timestamp, this) == coroutine_suspended) {
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
        reservationListAll.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.consult.-$$Lambda$ConsultFragment4x4$sTjhq-ehl33jwiAkoskyUWujuYo
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ConsultFragment4x4.initViewModel$lambda$3(function1, obj);
            }
        });
        request();
        setShowReservation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.consult.ConsultFragment4x4$setShowReservation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConsultFragment4x4.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.consult.ConsultFragment4x4$setShowReservation$1", f = "ConsultFragment4x4.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
    static final class C04251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C04251(Continuation<? super C04251> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConsultFragment4x4.this.new C04251(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow<String> timeSharedFlow = ConsultFragment4x4.this.getViewModel().getTimeSharedFlow();
                final ConsultFragment4x4 consultFragment4x4 = ConsultFragment4x4.this;
                this.label = 1;
                if (timeSharedFlow.collect(new FlowCollector() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment4x4.setShowReservation.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((String) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(String str, Continuation<? super Unit> continuation) {
                        boolean z;
                        Log.i(consultFragment4x4.TAG, "更新下一个预约");
                        List<ReservationRecordBean> reservationList = consultFragment4x4.getViewModel().getReservationList(consultFragment4x4.showReservationList);
                        consultFragment4x4.mAdapter.setList(reservationList);
                        consultFragment4x4.showReservationList.clear();
                        consultFragment4x4.showReservationList.addAll(reservationList);
                        ConsultFragment4x4 consultFragment4x5 = consultFragment4x4;
                        int highLightIndex = consultFragment4x5.getHighLightIndex(consultFragment4x5.showReservationList);
                        if (highLightIndex == -1) {
                            highLightIndex = consultFragment4x4.getViewModel().getNextHighLightIndex(consultFragment4x4.showReservationList);
                            z = true;
                        } else {
                            z = false;
                        }
                        if (highLightIndex == -1) {
                            return Unit.INSTANCE;
                        }
                        ConsultFragment4x4 consultFragment4x6 = consultFragment4x4;
                        consultFragment4x6.showItem = (ReservationRecordBean) consultFragment4x6.showReservationList.get(highLightIndex);
                        String endTimeStr = consultFragment4x4.showItem.getEndTimeStr();
                        if (z) {
                            endTimeStr = consultFragment4x4.showItem.getStartTimeStr();
                        }
                        long timestamp = (DateUtils.getTimestamp(endTimeStr, TimeUtil.notSecondFormat) - System.currentTimeMillis()) + ((long) 10000);
                        Log.i(consultFragment4x4.TAG, "nextTimeInterval 4x4 = " + timestamp);
                        Object objStartTimer = consultFragment4x4.getViewModel().startTimer(timestamp, continuation);
                        return objStartTimer == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objStartTimer : Unit.INSTANCE;
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
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C04251(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getHighLightIndex(List<ReservationRecordBean> list) {
        int i = 0;
        for (ReservationRecordBean reservationRecordBean : list) {
            int i2 = i + 1;
            if (TimeUtil.isTime(reservationRecordBean.getStartTimeStr(), reservationRecordBean.getEndTimeStr())) {
                return i;
            }
            i = i2;
        }
        return -1;
    }
}
