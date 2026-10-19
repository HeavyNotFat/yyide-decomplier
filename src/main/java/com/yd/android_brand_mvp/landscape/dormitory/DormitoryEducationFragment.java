package com.yd.android_brand_mvp.landscape.dormitory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.adapter.dormitory.BannerDormitoryRoomAdapter;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentHomeDormitoryEducationBinding;
import com.yd.android_brand_mvp.databinding.ItemDormitoryEducationRankingBinding;
import com.yd.android_brand_mvp.landscape.dormitory.viewmodel.DormitoryViewModel;
import com.yd.android_brand_mvp.model.dormitory.DormitoryEducationBean;
import com.yd.android_brand_mvp.model.dormitory.DormitoryEducationItemBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: DormitoryEducationFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0005\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\u001a\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/dormitory/DormitoryEducationFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentHomeDormitoryEducationBinding;", "()V", "rankingAdapter", "com/yd/android_brand_mvp/landscape/dormitory/DormitoryEducationFragment$rankingAdapter$1", "Lcom/yd/android_brand_mvp/landscape/dormitory/DormitoryEducationFragment$rankingAdapter$1;", "type", "", "viewModel", "Lcom/yd/android_brand_mvp/landscape/dormitory/viewmodel/DormitoryViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/dormitory/viewmodel/DormitoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "UpdataEvent", "", "id", "", "initView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DormitoryEducationFragment extends KTBaseFragment<FragmentHomeDormitoryEducationBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DormitoryEducationFragment$rankingAdapter$1 rankingAdapter;
    private String type;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.dormitory.DormitoryEducationFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: DormitoryEducationFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentHomeDormitoryEducationBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentHomeDormitoryEducationBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentHomeDormitoryEducationBinding;", 0);
        }

        public final FragmentHomeDormitoryEducationBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentHomeDormitoryEducationBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentHomeDormitoryEducationBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentHomeDormitoryEducationBinding access$getBinding(DormitoryEducationFragment dormitoryEducationFragment) {
        return dormitoryEducationFragment.getBinding();
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.yd.android_brand_mvp.landscape.dormitory.DormitoryEducationFragment$rankingAdapter$1] */
    public DormitoryEducationFragment() {
        super(AnonymousClass1.INSTANCE);
        final DormitoryEducationFragment dormitoryEducationFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.dormitory.DormitoryEducationFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return dormitoryEducationFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.dormitory.DormitoryEducationFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(dormitoryEducationFragment, Reflection.getOrCreateKotlinClass(DormitoryViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.dormitory.DormitoryEducationFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.dormitory.DormitoryEducationFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.dormitory.DormitoryEducationFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = dormitoryEducationFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.type = "hbssdy26";
        this.rankingAdapter = new BaseBindingAdapter<ItemDormitoryEducationRankingBinding, DormitoryEducationItemBean>() { // from class: com.yd.android_brand_mvp.landscape.dormitory.DormitoryEducationFragment$rankingAdapter$1
            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
            public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, DormitoryEducationItemBean dormitoryEducationItemBean) {
                convertPlus2((VBViewHolder<ItemDormitoryEducationRankingBinding>) vBViewHolder, dormitoryEducationItemBean);
            }

            /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
            public void convertPlus2(VBViewHolder<ItemDormitoryEducationRankingBinding> holder, DormitoryEducationItemBean item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemDormitoryEducationRankingBinding itemDormitoryEducationRankingBinding = (ItemDormitoryEducationRankingBinding) holder.getBinding();
                if (itemDormitoryEducationRankingBinding != null) {
                    if (holder.getLayoutPosition() == getData().size() - 1) {
                        View view = itemDormitoryEducationRankingBinding.viewLine;
                        Intrinsics.checkNotNullExpressionValue(view, "it.viewLine");
                        SimpleUtilsKt.hide(view);
                    } else {
                        View view2 = itemDormitoryEducationRankingBinding.viewLine;
                        Intrinsics.checkNotNullExpressionValue(view2, "it.viewLine");
                        SimpleUtilsKt.show(view2);
                    }
                    itemDormitoryEducationRankingBinding.tvItemDormitoryEducationRankingScore.setText(item.getGoal() + (char) 20998);
                    itemDormitoryEducationRankingBinding.tvItemDormitoryEducationRankingNumber.setText(item.getTargetName());
                    itemDormitoryEducationRankingBinding.tvItemDormitoryEducationRankingRanking.setText(item.getRanking());
                }
            }

            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
            public ItemDormitoryEducationRankingBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                Intrinsics.checkNotNullParameter(inflater, "inflater");
                Intrinsics.checkNotNullParameter(parent, "parent");
                ItemDormitoryEducationRankingBinding itemDormitoryEducationRankingBindingInflate = ItemDormitoryEducationRankingBinding.inflate(inflater, parent, false);
                Intrinsics.checkNotNullExpressionValue(itemDormitoryEducationRankingBindingInflate, "inflate(inflater, parent, false)");
                return itemDormitoryEducationRankingBindingInflate;
            }
        };
    }

    /* JADX INFO: compiled from: DormitoryEducationFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/dormitory/DormitoryEducationFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "type", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String type) {
            DormitoryEducationFragment dormitoryEducationFragment = new DormitoryEducationFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            dormitoryEducationFragment.setArguments(bundle);
            return dormitoryEducationFragment;
        }
    }

    private final DormitoryViewModel getViewModel() {
        return (DormitoryViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("type") : null;
        if (string == null) {
            string = "hbssdy26";
        }
        this.type = string;
        if (Intrinsics.areEqual(string, "hbssdy26")) {
            getBinding().clFragmentHomeDormitoryEducation.getLayoutParams().width = SizeUtils.dp2px(444.0f);
            getBinding().clFragmentHomeDormitoryEducation.getLayoutParams().height = SizeUtils.dp2px(916.0f);
        } else if (Intrinsics.areEqual(string, "sbssdy45")) {
            getBinding().clFragmentHomeDormitoryEducation.getLayoutParams().width = SizeUtils.dp2px(660.0f);
            getBinding().clFragmentHomeDormitoryEducation.getLayoutParams().height = SizeUtils.dp2px(1090.0f);
        }
        initView();
        request();
    }

    private final void initView() {
        ViewStub viewStub = getBinding().emptyView;
        Intrinsics.checkNotNullExpressionValue(viewStub, "binding.emptyView");
        viewStub.setVisibility(0);
        getBinding().rvFragmentHomeDormitoryEducationRank.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().rvFragmentHomeDormitoryEducationRank.setAdapter(this.rankingAdapter);
        BannerDormitoryRoomAdapter bannerDormitoryRoomAdapter = new BannerDormitoryRoomAdapter();
        BannerDormitoryRoomAdapter bannerDormitoryRoomAdapter2 = new BannerDormitoryRoomAdapter();
        BannerDormitoryRoomAdapter bannerDormitoryRoomAdapter3 = new BannerDormitoryRoomAdapter();
        DormitoryEducationFragment dormitoryEducationFragment = this;
        getBinding().bannerFragmentDormitoryEducation1Score.addBannerLifecycleObserver(dormitoryEducationFragment).setAdapter(bannerDormitoryRoomAdapter).setOrientation(1).isAutoLoop(true).setLoopTime(BaseConstant.BANNER_TIME);
        getBinding().bannerFragmentDormitoryEducation2Score.addBannerLifecycleObserver(dormitoryEducationFragment).setAdapter(bannerDormitoryRoomAdapter2).setOrientation(1).isAutoLoop(true).setLoopTime(BaseConstant.BANNER_TIME);
        getBinding().bannerFragmentDormitoryEducation3Score.addBannerLifecycleObserver(dormitoryEducationFragment).setAdapter(bannerDormitoryRoomAdapter3).setOrientation(1).isAutoLoop(true).setLoopTime(BaseConstant.BANNER_TIME);
        MutableLiveData<Result<DormitoryEducationBean>> educationRanking = getViewModel().getEducationRanking();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends DormitoryEducationBean>, Unit> function1 = new Function1<Result<? extends DormitoryEducationBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.dormitory.DormitoryEducationFragment.initView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends DormitoryEducationBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends DormitoryEducationBean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                DormitoryEducationBean dormitoryEducationBean = (DormitoryEducationBean) value;
                if (dormitoryEducationBean == null) {
                    ViewStub viewStub2 = DormitoryEducationFragment.access$getBinding(DormitoryEducationFragment.this).emptyView;
                    Intrinsics.checkNotNullExpressionValue(viewStub2, "binding.emptyView");
                    viewStub2.setVisibility(0);
                    return;
                }
                ViewStub viewStub3 = DormitoryEducationFragment.access$getBinding(DormitoryEducationFragment.this).emptyView;
                Intrinsics.checkNotNullExpressionValue(viewStub3, "binding.emptyView");
                viewStub3.setVisibility(8);
                setList(dormitoryEducationBean.getOwnList());
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                List<DormitoryEducationItemBean> rankList = dormitoryEducationBean.getRankList();
                ArrayList arrayList4 = new ArrayList();
                for (Object obj : rankList) {
                    if (Intrinsics.areEqual(((DormitoryEducationItemBean) obj).getRanking(), "1")) {
                        arrayList4.add(obj);
                    }
                }
                arrayList.addAll(arrayList4);
                List<DormitoryEducationItemBean> rankList2 = dormitoryEducationBean.getRankList();
                ArrayList arrayList5 = new ArrayList();
                for (Object obj2 : rankList2) {
                    if (Intrinsics.areEqual(((DormitoryEducationItemBean) obj2).getRanking(), "2")) {
                        arrayList5.add(obj2);
                    }
                }
                arrayList2.addAll(arrayList5);
                List<DormitoryEducationItemBean> rankList3 = dormitoryEducationBean.getRankList();
                ArrayList arrayList6 = new ArrayList();
                for (Object obj3 : rankList3) {
                    if (Intrinsics.areEqual(((DormitoryEducationItemBean) obj3).getRanking(), "3")) {
                        arrayList6.add(obj3);
                    }
                }
                arrayList3.addAll(arrayList6);
                DormitoryEducationFragment.access$getBinding(DormitoryEducationFragment.this).bannerFragmentDormitoryEducation1Score.setDatas(arrayList);
                DormitoryEducationFragment.access$getBinding(DormitoryEducationFragment.this).bannerFragmentDormitoryEducation2Score.setDatas(arrayList2);
                DormitoryEducationFragment.access$getBinding(DormitoryEducationFragment.this).bannerFragmentDormitoryEducation3Score.setDatas(arrayList3);
                DormitoryEducationFragment.access$getBinding(DormitoryEducationFragment.this).tvFragmentDormitoryEducationWeek.setText(dormitoryEducationBean.getTitle());
            }
        };
        educationRanking.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.dormitory.-$$Lambda$DormitoryEducationFragment$FRu3BRzkvh5Zzi3QlSfUKwA9Ex0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DormitoryEducationFragment.initView$lambda$0(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void request() {
        getViewModel().getDormitoryEducationRanking();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
    }
}
