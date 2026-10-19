package com.yd.android_brand_mvp.landscape.reserve;

import android.os.Bundle;
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
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.necer.calendar.BaseCalendar;
import com.necer.enumeration.DateChangeBehavior;
import com.necer.listener.OnCalendarChangedListener;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.GeneralAdapter3;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentHomeReservation36Binding;
import com.yd.android_brand_mvp.databinding.ItemYyLayoutBinding;
import com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservation36ViewModel;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yyide.facepass.AppExtKt;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import org.joda.time.LocalDate;

/* JADX INFO: compiled from: HomeReservation36Fragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0007\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0016\u0010\u001a\u001a\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cH\u0002J\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\u001a\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0017H\u0002J\u001f\u0010&\u001a\u00020\u00172\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0017H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/reserve/HomeReservation36Fragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentHomeReservation36Binding;", "()V", "generalAdapter", "Lcom/yd/android_brand_mvp/adapter/GeneralAdapter3;", "mAdapter", "com/yd/android_brand_mvp/landscape/reserve/HomeReservation36Fragment$mAdapter$2$1", "getMAdapter", "()Lcom/yd/android_brand_mvp/landscape/reserve/HomeReservation36Fragment$mAdapter$2$1;", "mAdapter$delegate", "Lkotlin/Lazy;", "mReservationListAll", "", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "showItem", "showReservationList", "viewModel", "Lcom/yd/android_brand_mvp/landscape/reserve/viemodel/HomeReservation36ViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/reserve/viemodel/HomeReservation36ViewModel;", "viewModel$delegate", "UpdataEvent", "", "id", "", "getHighLightIndex", TUIKitConstants.Selection.LIST, "", "getNextIndex", "initView", "initViewModel", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "setHighItem", "sortList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setShowReservation", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomeReservation36Fragment extends KTBaseFragment<FragmentHomeReservation36Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private GeneralAdapter3 generalAdapter;

    /* JADX INFO: renamed from: mAdapter$delegate, reason: from kotlin metadata */
    private final Lazy mAdapter;
    private final List<ReservationRecordBean> mReservationListAll;
    private ReservationRecordBean showItem;
    private final List<ReservationRecordBean> showReservationList;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomeReservation36Fragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentHomeReservation36Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentHomeReservation36Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentHomeReservation36Binding;", 0);
        }

        public final FragmentHomeReservation36Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentHomeReservation36Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentHomeReservation36Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public HomeReservation36Fragment() {
        super(AnonymousClass1.INSTANCE);
        final HomeReservation36Fragment homeReservation36Fragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return homeReservation36Fragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(homeReservation36Fragment, Reflection.getOrCreateKotlinClass(HomeReservation36ViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = homeReservation36Fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.showReservationList = new ArrayList();
        this.mReservationListAll = new ArrayList();
        this.mAdapter = LazyKt.lazy(new Function0<HomeReservation36Fragment$mAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment$mAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment$mAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final HomeReservation36Fragment homeReservation36Fragment2 = this.this$0;
                return new BaseBindingAdapter<ItemYyLayoutBinding, ReservationRecordBean>() { // from class: com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment$mAdapter$2.1
                    {
                        super(null, 1, null);
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, ReservationRecordBean reservationRecordBean) {
                        convertPlus2((VBViewHolder<ItemYyLayoutBinding>) vBViewHolder, reservationRecordBean);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemYyLayoutBinding> holder, ReservationRecordBean item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemYyLayoutBinding itemYyLayoutBinding = (ItemYyLayoutBinding) holder.getBinding();
                        if (itemYyLayoutBinding != null) {
                            HomeReservation36Fragment homeReservation36Fragment3 = homeReservation36Fragment2;
                            ReservationRecordBean reservationRecordBean = homeReservation36Fragment3.showItem;
                            if (Intrinsics.areEqual(reservationRecordBean != null ? reservationRecordBean.getId() : null, item.getId())) {
                                itemYyLayoutBinding.name.setTextColor(-1);
                                itemYyLayoutBinding.time.setTextColor(-1);
                                itemYyLayoutBinding.layoutContent.setBackgroundDrawable(homeReservation36Fragment3.getResources().getDrawable(R.drawable.bg_10dp_blue));
                            } else {
                                itemYyLayoutBinding.name.setTextColor(homeReservation36Fragment3.getResources().getColor(R.color.color_999999));
                                itemYyLayoutBinding.time.setTextColor(homeReservation36Fragment3.getResources().getColor(R.color.text_333333));
                                itemYyLayoutBinding.layoutContent.setBackgroundDrawable(homeReservation36Fragment3.getResources().getDrawable(R.drawable.bg_10dp_gray1));
                            }
                            itemYyLayoutBinding.name.setText(item.getName());
                            itemYyLayoutBinding.time.setText(new Regex("\\s+").split(item.getBookingTime(), 0).get(1));
                            int siteBookingTypeCode = item.getSiteBookingTypeCode();
                            if (siteBookingTypeCode == 1) {
                                itemYyLayoutBinding.img.setImageResource(R.drawable.icon_meeting);
                                return;
                            }
                            if (siteBookingTypeCode == 2) {
                                itemYyLayoutBinding.img.setImageResource(R.drawable.icon_item_table);
                            } else if (siteBookingTypeCode == 3) {
                                itemYyLayoutBinding.img.setImageResource(R.drawable.icon_active);
                            } else {
                                itemYyLayoutBinding.img.setImageResource(R.drawable.icon_custom);
                            }
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemYyLayoutBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemYyLayoutBinding itemYyLayoutBindingInflate = ItemYyLayoutBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemYyLayoutBindingInflate, "inflate(inflater, parent, false)");
                        return itemYyLayoutBindingInflate;
                    }
                };
            }
        });
    }

    public static final /* synthetic */ FragmentHomeReservation36Binding access$getBinding(HomeReservation36Fragment homeReservation36Fragment) {
        return homeReservation36Fragment.getBinding();
    }

    /* JADX INFO: compiled from: HomeReservation36Fragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/reserve/HomeReservation36Fragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/reserve/HomeReservation36Fragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HomeReservation36Fragment newInstance() {
            return new HomeReservation36Fragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeReservation36ViewModel getViewModel() {
        return (HomeReservation36ViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity));
        getBinding().recyclerView.setAdapter(getMAdapter());
        getMAdapter().setEmptyView(R.layout.item_nc_null_layout44_36);
        this.generalAdapter = new GeneralAdapter3();
        getBinding().calendar.setCalendarAdapter(this.generalAdapter);
        getBinding().calendar.setScrollEnable(false);
        setShowReservation();
        initViewModel();
        request();
        getBinding().calendar.setOnCalendarChangedListener(new OnCalendarChangedListener() { // from class: com.yd.android_brand_mvp.landscape.reserve.-$$Lambda$HomeReservation36Fragment$2rN9xbP-mmFitnuKAqXeQPFkP94
            @Override // com.necer.listener.OnCalendarChangedListener
            public final void onCalendarChange(BaseCalendar baseCalendar, int i, int i2, LocalDate localDate, DateChangeBehavior dateChangeBehavior) {
                HomeReservation36Fragment.initView$lambda$1(this.f$0, baseCalendar, i, i2, localDate, dateChangeBehavior);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(HomeReservation36Fragment this$0, BaseCalendar baseCalendar, int i, int i2, LocalDate localDate, DateChangeBehavior dateChangeBehavior) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (localDate != null) {
            GeneralAdapter3 generalAdapter3 = this$0.generalAdapter;
            Intrinsics.checkNotNull(generalAdapter3);
            generalAdapter3.setIndex(localDate.toString());
        }
        String date = DateUtils.getDate(localDate.toDate(), "yyyy-MM-dd");
        if (Intrinsics.areEqual(date, DateUtils.getDate(System.currentTimeMillis(), "yyyy-MM-dd"))) {
            this$0.getMAdapter().setList(this$0.showReservationList);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ReservationRecordBean reservationRecordBean : this$0.mReservationListAll) {
            if (Intrinsics.areEqual(date, DateUtils.getDate(TimeUtil.gettime(reservationRecordBean.getStartTimeStr()), "yyyy-MM-dd"))) {
                arrayList.add(reservationRecordBean);
            }
        }
        this$0.getMAdapter().setList(arrayList);
    }

    private final void request() {
        String siteId = SpData.getSiteId();
        if (siteId == null) {
            siteId = "-1";
        }
        if (Intrinsics.areEqual(siteId, "-1")) {
            return;
        }
        getViewModel().getTodayReservationList(siteId);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (MinaConstants.CODE_RESERVE == id) {
            request();
        }
    }

    private final void initViewModel() {
        LiveData<Result<BasePageResponse<List<ReservationRecordBean>>>> reservationList = getViewModel().getReservationList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends BasePageResponse<List<? extends ReservationRecordBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<? extends ReservationRecordBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment.initViewModel.1
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
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                BasePageResponse basePageResponse = (BasePageResponse) value;
                if (basePageResponse == null) {
                    return;
                }
                Collection collection = (Collection) basePageResponse.getList();
                if (collection == null || collection.isEmpty()) {
                    return;
                }
                HomeReservation36Fragment.this.mReservationListAll.addAll((Collection) basePageResponse.getList());
                ArrayList arrayList = new ArrayList();
                Iterable<ReservationRecordBean> iterable = (Iterable) basePageResponse.getList();
                HomeReservation36Fragment homeReservation36Fragment = HomeReservation36Fragment.this;
                for (ReservationRecordBean reservationRecordBean : iterable) {
                    String date = DateUtils.getDate(System.currentTimeMillis(), "yyyy-MM-dd");
                    String date2 = DateUtils.getDate(TimeUtil.gettime(reservationRecordBean.getStartTimeStr()), "yyyy-MM-dd");
                    AppExtKt.logd(homeReservation36Fragment, date + "==" + date2);
                    if (Intrinsics.areEqual(date, date2)) {
                        String json = GsonUtils.toJson(reservationRecordBean);
                        Intrinsics.checkNotNullExpressionValue(json, "toJson(it)");
                        AppExtKt.logd(homeReservation36Fragment, json);
                        arrayList.add(reservationRecordBean);
                    }
                }
                List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment$initViewModel$1$invoke$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((ReservationRecordBean) t).getStartTimeStr(), ((ReservationRecordBean) t2).getStartTimeStr());
                    }
                });
                int highLightIndex = HomeReservation36Fragment.this.getHighLightIndex(listSortedWith);
                GeneralAdapter3 generalAdapter3 = HomeReservation36Fragment.this.generalAdapter;
                Intrinsics.checkNotNull(generalAdapter3);
                generalAdapter3.notydata(HomeReservation36Fragment.this.mReservationListAll);
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(HomeReservation36Fragment.this), null, null, new AnonymousClass2(HomeReservation36Fragment.this, listSortedWith, null), 3, null);
                HomeReservation36Fragment.this.showReservationList.clear();
                List list = listSortedWith;
                HomeReservation36Fragment.this.showReservationList.addAll(list);
                HomeReservation36Fragment.this.getMAdapter().setList(list);
                if (highLightIndex > -1) {
                    HomeReservation36Fragment.this.showItem = (ReservationRecordBean) listSortedWith.get(highLightIndex);
                    HomeReservation36Fragment.access$getBinding(HomeReservation36Fragment.this).recyclerView.smoothScrollToPosition(highLightIndex);
                }
            }

            /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment$initViewModel$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: HomeReservation36Fragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment$initViewModel$1$2", f = "HomeReservation36Fragment.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ List<ReservationRecordBean> $sortList;
                int label;
                final /* synthetic */ HomeReservation36Fragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(HomeReservation36Fragment homeReservation36Fragment, List<ReservationRecordBean> list, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.this$0 = homeReservation36Fragment;
                    this.$sortList = list;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.this$0, this.$sortList, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (this.this$0.setHighItem(this.$sortList, this) == coroutine_suspended) {
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
        reservationList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.reserve.-$$Lambda$HomeReservation36Fragment$Eex4XKSD8lO8BaNDvHupEwj3ePk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeReservation36Fragment.initViewModel$lambda$2(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object setHighItem(List<ReservationRecordBean> list, Continuation<? super Unit> continuation) {
        ReservationRecordBean nextIndex = getNextIndex(list);
        long timestamp = (DateUtils.getTimestamp(nextIndex != null ? nextIndex.getStartTimeStr() : null, TimeUtil.notSecondFormat) - System.currentTimeMillis()) + ((long) 5000);
        AppExtKt.logd(this, "nextTimeInterval = " + timestamp);
        if (timestamp > 0) {
            Object objStartTimer = getViewModel().startTimer(timestamp, continuation);
            return objStartTimer == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objStartTimer : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment$setShowReservation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeReservation36Fragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment$setShowReservation$1", f = "HomeReservation36Fragment.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
    static final class C05041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C05041(Continuation<? super C05041> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C05041 c05041 = HomeReservation36Fragment.this.new C05041(continuation);
            c05041.L$0 = obj;
            return c05041;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment$setShowReservation$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: HomeReservation36Fragment.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "", "emit", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class C01811<T> implements FlowCollector {
            final /* synthetic */ CoroutineScope $$this$launch;
            final /* synthetic */ HomeReservation36Fragment this$0;

            C01811(CoroutineScope coroutineScope, HomeReservation36Fragment homeReservation36Fragment) {
                this.$$this$launch = coroutineScope;
                this.this$0 = homeReservation36Fragment;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((String) obj, (Continuation<? super Unit>) continuation);
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            public final Object emit(String str, Continuation<? super Unit> continuation) {
                HomeReservation36Fragment$setShowReservation$1$1$emit$1 homeReservation36Fragment$setShowReservation$1$1$emit$1;
                C01811<T> c01811;
                int i;
                if (continuation instanceof HomeReservation36Fragment$setShowReservation$1$1$emit$1) {
                    homeReservation36Fragment$setShowReservation$1$1$emit$1 = (HomeReservation36Fragment$setShowReservation$1$1$emit$1) continuation;
                    if ((homeReservation36Fragment$setShowReservation$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                        homeReservation36Fragment$setShowReservation$1$1$emit$1.label -= Integer.MIN_VALUE;
                    } else {
                        homeReservation36Fragment$setShowReservation$1$1$emit$1 = new HomeReservation36Fragment$setShowReservation$1$1$emit$1(this, continuation);
                    }
                } else {
                    homeReservation36Fragment$setShowReservation$1$1$emit$1 = new HomeReservation36Fragment$setShowReservation$1$1$emit$1(this, continuation);
                }
                Object obj = homeReservation36Fragment$setShowReservation$1$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = homeReservation36Fragment$setShowReservation$1$1$emit$1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    AppExtKt.logd(this.$$this$launch, "36 更新下一个预约");
                    HomeReservation36Fragment homeReservation36Fragment = this.this$0;
                    int highLightIndex = homeReservation36Fragment.getHighLightIndex(homeReservation36Fragment.showReservationList);
                    if (highLightIndex == -1) {
                        this.this$0.getMAdapter().setList(null);
                        return Unit.INSTANCE;
                    }
                    HomeReservation36Fragment homeReservation36Fragment2 = this.this$0;
                    homeReservation36Fragment2.showItem = (ReservationRecordBean) homeReservation36Fragment2.showReservationList.get(highLightIndex);
                    HomeReservation36Fragment homeReservation36Fragment3 = this.this$0;
                    List list = homeReservation36Fragment3.showReservationList;
                    homeReservation36Fragment$setShowReservation$1$1$emit$1.L$0 = this;
                    homeReservation36Fragment$setShowReservation$1$1$emit$1.I$0 = highLightIndex;
                    homeReservation36Fragment$setShowReservation$1$1$emit$1.label = 1;
                    if (homeReservation36Fragment3.setHighItem(list, homeReservation36Fragment$setShowReservation$1$1$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c01811 = this;
                    i = highLightIndex;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = homeReservation36Fragment$setShowReservation$1$1$emit$1.I$0;
                    c01811 = (C01811) homeReservation36Fragment$setShowReservation$1$1$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (i == CollectionsKt.getLastIndex(c01811.this$0.showReservationList)) {
                    c01811.this$0.getMAdapter().setList(null);
                } else {
                    c01811.this$0.getMAdapter().setList(c01811.this$0.showReservationList);
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                this.label = 1;
                if (HomeReservation36Fragment.this.getViewModel().getTimeSharedFlow().collect(new C01811(coroutineScope, HomeReservation36Fragment.this), this) == coroutine_suspended) {
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
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C05041(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getHighLightIndex(List<ReservationRecordBean> list) {
        int i = 0;
        for (ReservationRecordBean reservationRecordBean : list) {
            int i2 = i + 1;
            if ((reservationRecordBean.getStartTimeStr().length() > 0) && DateUtils.isTiming(reservationRecordBean.getStartTimeStr(), reservationRecordBean.getEndTimeStr(), TimeUtil.notSecondFormat)) {
                return i;
            }
            i = i2;
        }
        return -1;
    }

    private final ReservationRecordBean getNextIndex(List<ReservationRecordBean> list) {
        for (ReservationRecordBean reservationRecordBean : list) {
            if ((reservationRecordBean.getStartTimeStr().length() > 0) && DateUtils.isNextTime(reservationRecordBean.getStartTimeStr(), TimeUtil.notSecondFormat)) {
                return reservationRecordBean;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeReservation36Fragment$mAdapter$2.AnonymousClass1 getMAdapter() {
        return (HomeReservation36Fragment$mAdapter$2.AnonymousClass1) this.mAdapter.getValue();
    }
}
