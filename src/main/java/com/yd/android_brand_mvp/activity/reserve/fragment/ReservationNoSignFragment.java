package com.yd.android_brand_mvp.activity.reserve.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.reserve.viewmodel.ReservationViewModel;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentReservationNoSignDetailBinding;
import com.yd.android_brand_mvp.databinding.ItemReservationSignBinding;
import com.yd.android_brand_mvp.model.reservation.ReservationDetailBean;
import com.yd.android_brand_mvp.model.reservation.ReservationSignListItemBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: ReservationNoSignFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\t\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/yd/android_brand_mvp/activity/reserve/fragment/ReservationNoSignFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentReservationNoSignDetailBinding;", "()V", "id", "", "isPortrait", "", "peopleAdapter", "com/yd/android_brand_mvp/activity/reserve/fragment/ReservationNoSignFragment$peopleAdapter$2$1", "getPeopleAdapter", "()Lcom/yd/android_brand_mvp/activity/reserve/fragment/ReservationNoSignFragment$peopleAdapter$2$1;", "peopleAdapter$delegate", "Lkotlin/Lazy;", "showData", "Lcom/yd/android_brand_mvp/model/reservation/ReservationDetailBean;", "signList", "", "Lcom/yd/android_brand_mvp/model/reservation/ReservationSignListItemBean;", "viewModel", "Lcom/yd/android_brand_mvp/activity/reserve/viewmodel/ReservationViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/reserve/viewmodel/ReservationViewModel;", "viewModel$delegate", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ReservationNoSignFragment extends KTBaseFragment<FragmentReservationNoSignDetailBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String id;
    private boolean isPortrait;

    /* JADX INFO: renamed from: peopleAdapter$delegate, reason: from kotlin metadata */
    private final Lazy peopleAdapter;
    private ReservationDetailBean showData;
    private final List<ReservationSignListItemBean> signList;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.reserve.fragment.ReservationNoSignFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ReservationNoSignFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentReservationNoSignDetailBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentReservationNoSignDetailBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentReservationNoSignDetailBinding;", 0);
        }

        public final FragmentReservationNoSignDetailBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentReservationNoSignDetailBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentReservationNoSignDetailBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public ReservationNoSignFragment() {
        super(AnonymousClass1.INSTANCE);
        final ReservationNoSignFragment reservationNoSignFragment = this;
        final Function0 function0 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(reservationNoSignFragment, Reflection.getOrCreateKotlinClass(ReservationViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.ReservationNoSignFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = reservationNoSignFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.ReservationNoSignFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                if (function1 != null && (creationExtras = (CreationExtras) function1.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = reservationNoSignFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.ReservationNoSignFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = reservationNoSignFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.id = "-1";
        this.signList = new ArrayList();
        this.peopleAdapter = LazyKt.lazy(new Function0<ReservationNoSignFragment$peopleAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.ReservationNoSignFragment$peopleAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.activity.reserve.fragment.ReservationNoSignFragment$peopleAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new BaseBindingAdapter<ItemReservationSignBinding, ReservationSignListItemBean>() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.ReservationNoSignFragment$peopleAdapter$2.1
                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, ReservationSignListItemBean reservationSignListItemBean) {
                        convertPlus2((VBViewHolder<ItemReservationSignBinding>) vBViewHolder, reservationSignListItemBean);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemReservationSignBinding> holder, ReservationSignListItemBean item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemReservationSignBinding itemReservationSignBinding = (ItemReservationSignBinding) holder.getBinding();
                        if (itemReservationSignBinding != null) {
                            GlideUtil.loadCircleImage(getContext(), item.getAvatar(), itemReservationSignBinding.ivItemReservationSignAvatar);
                            itemReservationSignBinding.tvItemReservationSignName.setText(item.getUserName());
                            TextView textView = itemReservationSignBinding.tvItemReservationSignTime;
                            Intrinsics.checkNotNullExpressionValue(textView, "it.tvItemReservationSignTime");
                            SimpleUtilsKt.remove(textView);
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemReservationSignBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemReservationSignBinding itemReservationSignBindingInflate = ItemReservationSignBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemReservationSignBindingInflate, "inflate(inflater, parent, false)");
                        return itemReservationSignBindingInflate;
                    }
                };
            }
        });
    }

    public static final /* synthetic */ FragmentReservationNoSignDetailBinding access$getBinding(ReservationNoSignFragment reservationNoSignFragment) {
        return reservationNoSignFragment.getBinding();
    }

    /* JADX INFO: compiled from: ReservationNoSignFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/activity/reserve/fragment/ReservationNoSignFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "bookingId", "", "isPortrait", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Fragment newInstance$default(Companion companion, String str, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.newInstance(str, z);
        }

        public final Fragment newInstance(String bookingId, boolean isPortrait) {
            Intrinsics.checkNotNullParameter(bookingId, "bookingId");
            ReservationNoSignFragment reservationNoSignFragment = new ReservationNoSignFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", bookingId);
            bundle.putBoolean("isPortrait", isPortrait);
            reservationNoSignFragment.setArguments(bundle);
            return reservationNoSignFragment;
        }
    }

    private final ReservationViewModel getViewModel() {
        return (ReservationViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReservationNoSignFragment$peopleAdapter$2.AnonymousClass1 getPeopleAdapter() {
        return (ReservationNoSignFragment$peopleAdapter$2.AnonymousClass1) this.peopleAdapter.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        this.isPortrait = arguments != null ? arguments.getBoolean("isPortrait") : false;
        initView();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("id") : null;
        if (string == null) {
            string = "-1";
        }
        this.id = string;
        getBinding().rvFragmentReservationNoSignDetailSign.setLayoutManager(new GridLayoutManager(requireContext(), this.isPortrait ? 5 : 10));
        getBinding().rvFragmentReservationNoSignDetailSign.setAdapter(getPeopleAdapter());
        getBinding().rvFragmentReservationNoSignDetailSign.setItemAnimator(null);
        TextView textView = getBinding().tvFragmentReservationNoSignDetailCount;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string2 = getString(R.string.all_count_people);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.all_count_people)");
        String str = String.format(string2, Arrays.copyOf(new Object[]{0}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView.setText(str);
        LiveData<ReservationDetailBean> reservationDetail = getViewModel().getReservationDetail();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<ReservationDetailBean, Unit> function1 = new Function1<ReservationDetailBean, Unit>() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.ReservationNoSignFragment.initView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ReservationDetailBean reservationDetailBean) {
                invoke2(reservationDetailBean);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ReservationDetailBean reservationDetailBean) {
                ReservationNoSignFragment.this.showData = reservationDetailBean;
                if (reservationDetailBean == null) {
                    return;
                }
                ReservationNoSignFragment.this.signList.clear();
                ReservationNoSignFragment.this.signList.addAll(reservationDetailBean.getSignList());
                TextView textView2 = ReservationNoSignFragment.access$getBinding(ReservationNoSignFragment.this).tvFragmentReservationNoSignDetailCount;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String string3 = ReservationNoSignFragment.this.getString(R.string.all_count_people);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.all_count_people)");
                String str2 = String.format(string3, Arrays.copyOf(new Object[]{Integer.valueOf(ReservationNoSignFragment.this.signList.size())}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                textView2.setText(str2);
                ReservationNoSignFragment.this.getPeopleAdapter().setList(ReservationNoSignFragment.this.signList);
            }
        };
        reservationDetail.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.-$$Lambda$ReservationNoSignFragment$fRx9-E7JZBDpFRJOWbkbUXlhfJ8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReservationNoSignFragment.initView$lambda$0(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
