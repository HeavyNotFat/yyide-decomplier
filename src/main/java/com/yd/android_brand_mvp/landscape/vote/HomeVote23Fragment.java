package com.yd.android_brand_mvp.landscape.vote;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.vote.VoteListActivity;
import com.yd.android_brand_mvp.activity.vote.viewmodel.VoteViewModel;
import com.yd.android_brand_mvp.adapter.home.BannerVoteAdapter;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.FragmentHomeVote23Binding;
import com.yd.android_brand_mvp.dialog.vote.VoteDetailDialog;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.vote.VoteDetailBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.verfity.CheackNomalActivity;
import com.youth.banner.indicator.CircleIndicator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: HomeVote23Fragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u001a\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Lcom/yd/android_brand_mvp/landscape/vote/HomeVote23Fragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentHomeVote23Binding;", "()V", "adapter", "Lcom/yd/android_brand_mvp/adapter/home/BannerVoteAdapter;", "clickData", "Lcom/yd/android_brand_mvp/model/vote/VoteDetailBean;", "type", "", "viewModel", "Lcom/yd/android_brand_mvp/activity/vote/viewmodel/VoteViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/vote/viewmodel/VoteViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "UpdataEvent", "", "id", "", "initView", "onDestroyView", "onEvent", "eventBean", "Lcom/yd/android_brand_mvp/model/EventBean;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomeVote23Fragment extends KTBaseFragment<FragmentHomeVote23Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private BannerVoteAdapter adapter;
    private VoteDetailBean clickData;
    private String type;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.vote.HomeVote23Fragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomeVote23Fragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentHomeVote23Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentHomeVote23Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentHomeVote23Binding;", 0);
        }

        public final FragmentHomeVote23Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentHomeVote23Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentHomeVote23Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentHomeVote23Binding access$getBinding(HomeVote23Fragment homeVote23Fragment) {
        return homeVote23Fragment.getBinding();
    }

    public HomeVote23Fragment() {
        super(AnonymousClass1.INSTANCE);
        final HomeVote23Fragment homeVote23Fragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.vote.HomeVote23Fragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return homeVote23Fragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.vote.HomeVote23Fragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(homeVote23Fragment, Reflection.getOrCreateKotlinClass(VoteViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.vote.HomeVote23Fragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.vote.HomeVote23Fragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.vote.HomeVote23Fragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = homeVote23Fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    /* JADX INFO: compiled from: HomeVote23Fragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/vote/HomeVote23Fragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "type", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String type) {
            HomeVote23Fragment homeVote23Fragment = new HomeVote23Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            homeVote23Fragment.setArguments(bundle);
            return homeVote23Fragment;
        }
    }

    private final VoteViewModel getViewModel() {
        return (VoteViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        Bundle arguments = getArguments();
        String str = null;
        String string = arguments != null ? arguments.getString("type") : null;
        if (string == null) {
            string = "hbsjb22";
        }
        this.type = string;
        if (string == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
        } else {
            str = string;
        }
        if (Intrinsics.areEqual(str, "hbtphd23")) {
            getBinding().clFragmentHomeVote23.getLayoutParams().width = SizeUtils.dp2px(444.0f);
            getBinding().clFragmentHomeVote23.getLayoutParams().height = SizeUtils.dp2px(448.0f);
        } else if (Intrinsics.areEqual(str, "sbtphd22")) {
            getBinding().clFragmentHomeVote23.getLayoutParams().width = SizeUtils.dp2px(320.0f);
            getBinding().clFragmentHomeVote23.getLayoutParams().height = SizeUtils.dp2px(424.0f);
        }
        initView();
        request();
    }

    private final void initView() {
        getBinding().topFragmentHomeVote23.title.setText("投票");
        getBinding().topFragmentHomeVote23.llTitle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.vote.-$$Lambda$HomeVote23Fragment$vPVzd8F0mUE5aMa8ejhLSJztfEs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeVote23Fragment.initView$lambda$0(this.f$0, view);
            }
        });
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        this.adapter = new BannerVoteAdapter(contextRequireContext);
        getBinding().bannerFragmentHomeVote23.addBannerLifecycleObserver(this).setAdapter(this.adapter).isAutoLoop(true).setStartPosition(1).setBannerGalleryEffect(0, 15, 1.0f).setIndicator(new CircleIndicator(requireContext())).setIndicatorNormalColor(SimpleUtilsKt.asColor(R.color.gray)).setIndicatorSelectedColor(SimpleUtilsKt.asColor(R.color.colorPrimaryDark)).setLoopTime(BaseConstant.BANNER_TIME);
        getBinding().btnFragmentHomeVote23.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.vote.-$$Lambda$HomeVote23Fragment$GTXFTKFQkikPgjWGPLB6X13inZI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeVote23Fragment.initView$lambda$1(this.f$0, view);
            }
        });
        LiveData<List<VoteDetailBean>> homeVoteList = getViewModel().getHomeVoteList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends VoteDetailBean>, Unit> function1 = new Function1<List<? extends VoteDetailBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.vote.HomeVote23Fragment.initView.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends VoteDetailBean> list) {
                invoke2((List<VoteDetailBean>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<VoteDetailBean> list) {
                HomeVote23Fragment.access$getBinding(HomeVote23Fragment.this).bannerFragmentHomeVote23.setDatas(list);
                ViewStub viewStub = HomeVote23Fragment.access$getBinding(HomeVote23Fragment.this).emptyView;
                Intrinsics.checkNotNullExpressionValue(viewStub, "binding.emptyView");
                viewStub.setVisibility(list.isEmpty() ? 0 : 8);
            }
        };
        homeVoteList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.vote.-$$Lambda$HomeVote23Fragment$9XL7nhy6YryMUHYbHANGQtb-h7M
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeVote23Fragment.initView$lambda$2(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(HomeVote23Fragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VoteListActivity.Companion companion = VoteListActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.startGo(contextRequireContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(HomeVote23Fragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BannerVoteAdapter bannerVoteAdapter = this$0.adapter;
        if (bannerVoteAdapter != null && bannerVoteAdapter.getItemCount() == 0) {
            return;
        }
        int currentItem = this$0.getBinding().bannerFragmentHomeVote23.getCurrentItem() - 1;
        int i = currentItem >= 0 ? currentItem : 0;
        BannerVoteAdapter bannerVoteAdapter2 = this$0.adapter;
        this$0.clickData = bannerVoteAdapter2 != null ? bannerVoteAdapter2.getData(i) : null;
        Intent intent = new Intent(this$0.requireContext(), (Class<?>) CheackNomalActivity.class);
        intent.putExtra("type", BaseConstant.homeVote23);
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(EventBean eventBean) {
        VoteDetailBean voteDetailBean;
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        if (eventBean.type == BaseConstant.homeVote23 && (voteDetailBean = this.clickData) != null) {
            new VoteDetailDialog(ScreenUtils.isPortrait(), voteDetailBean, eventBean).show(getChildFragmentManager(), "voteDialog");
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (MinaConstants.CODE_VOTE == id) {
            request();
        }
    }

    private final void request() {
        VoteViewModel viewModel = getViewModel();
        String classesId = SpData.getClassesId();
        Intrinsics.checkNotNullExpressionValue(classesId, "getClassesId()");
        viewModel.getHomeVoteList(1, 3, 1, classesId);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
