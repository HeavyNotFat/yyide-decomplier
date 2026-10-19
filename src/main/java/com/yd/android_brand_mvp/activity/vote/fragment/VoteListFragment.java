package com.yd.android_brand_mvp.activity.vote.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.vote.VoteDetailActivity;
import com.yd.android_brand_mvp.activity.vote.viewmodel.VoteViewModel;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ActivityVoteListBinding;
import com.yd.android_brand_mvp.databinding.ItemVoteListBinding;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.RemainingBean;
import com.yd.android_brand_mvp.model.vote.VoteDetailBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.GridSpacingItemDecoration;
import com.yd.android_brand_mvp.verfity.CheackNomalActivity;
import java.util.Arrays;
import java.util.Collection;
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
import kotlin.jvm.internal.StringCompanionObject;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: VoteListFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u001a\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082.¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/yd/android_brand_mvp/activity/vote/fragment/VoteListFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/ActivityVoteListBinding;", "()V", "current", "", "currentClickVoteId", "", "currentSelectList", "isPortrait", "", InnerConstant.Db.size, "totalCount", "viewModel", "Lcom/yd/android_brand_mvp/activity/vote/viewmodel/VoteViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/vote/viewmodel/VoteViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "voteListAdapter", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/ItemVoteListBinding;", "Lcom/yd/android_brand_mvp/model/vote/VoteDetailBean;", "initView", "", "onDestroyView", "onEvent", "eventBean", "Lcom/yd/android_brand_mvp/model/EventBean;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VoteListFragment extends KTBaseFragment<ActivityVoteListBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int current;
    private String currentClickVoteId;
    private int currentSelectList;
    private boolean isPortrait;
    private final int size;
    private int totalCount;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private BaseBindingAdapter<ItemVoteListBinding, VoteDetailBean> voteListAdapter;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.vote.fragment.VoteListFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: VoteListFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ActivityVoteListBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, ActivityVoteListBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/ActivityVoteListBinding;", 0);
        }

        public final ActivityVoteListBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ActivityVoteListBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ActivityVoteListBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public VoteListFragment() {
        super(AnonymousClass1.INSTANCE);
        this.size = 6;
        this.current = 1;
        this.totalCount = 8;
        this.currentSelectList = 1;
        final VoteListFragment voteListFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.VoteListFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return voteListFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.VoteListFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(voteListFragment, Reflection.getOrCreateKotlinClass(VoteViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.VoteListFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.VoteListFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.VoteListFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = voteListFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.currentClickVoteId = "";
    }

    /* JADX INFO: compiled from: VoteListFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/activity/vote/fragment/VoteListFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "id", "", "isPortrait", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String id, boolean isPortrait) {
            Intrinsics.checkNotNullParameter(id, "id");
            VoteListFragment voteListFragment = new VoteListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putBoolean("isPortrait", isPortrait);
            voteListFragment.setArguments(bundle);
            return voteListFragment;
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
        initView();
        request();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        this.isPortrait = arguments != null ? arguments.getBoolean("isPortrait") : false;
        this.voteListAdapter = new BaseBindingAdapter<ItemVoteListBinding, VoteDetailBean>() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.VoteListFragment.initView.1
            {
                super(null, 1, null);
            }

            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
            public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, VoteDetailBean voteDetailBean) {
                convertPlus2((VBViewHolder<ItemVoteListBinding>) vBViewHolder, voteDetailBean);
            }

            /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
            public void convertPlus2(VBViewHolder<ItemVoteListBinding> holder, VoteDetailBean item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemVoteListBinding itemVoteListBinding = (ItemVoteListBinding) holder.getBinding();
                if (itemVoteListBinding != null) {
                    VoteListFragment voteListFragment = VoteListFragment.this;
                    if (voteListFragment.currentSelectList == 2) {
                        Group group = itemVoteListBinding.groupItemVoteListIngTime;
                        Intrinsics.checkNotNullExpressionValue(group, "it.groupItemVoteListIngTime");
                        SimpleUtilsKt.hide(group);
                        TextView textView = itemVoteListBinding.tvItemVoteListEndTime;
                        Intrinsics.checkNotNullExpressionValue(textView, "it.tvItemVoteListEndTime");
                        SimpleUtilsKt.show(textView);
                        itemVoteListBinding.tvItemVoteStatus.setBackgroundResource(R.drawable.bg_black_r8);
                        itemVoteListBinding.tvItemVoteStatus.setText("已结束");
                        TextView textView2 = itemVoteListBinding.tvItemVoteListEndTime;
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String string = voteListFragment.getString(R.string.activity_time);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.activity_time)");
                        String str = String.format(string, Arrays.copyOf(new Object[]{item.getVoteDate()}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                        textView2.setText(str);
                    } else {
                        Group group2 = itemVoteListBinding.groupItemVoteListIngTime;
                        Intrinsics.checkNotNullExpressionValue(group2, "it.groupItemVoteListIngTime");
                        SimpleUtilsKt.show(group2);
                        TextView textView3 = itemVoteListBinding.tvItemVoteListEndTime;
                        Intrinsics.checkNotNullExpressionValue(textView3, "it.tvItemVoteListEndTime");
                        SimpleUtilsKt.hide(textView3);
                        itemVoteListBinding.tvItemVoteStatus.setBackgroundResource(R.drawable.bg_green_r8);
                        itemVoteListBinding.tvItemVoteStatus.setText("进行中");
                        RemainingBean timeRemaining = DateUtils.getTimeRemaining(item.getEndTime());
                        itemVoteListBinding.tvItemVoteDay.setText(String.valueOf(timeRemaining.getDay()));
                        itemVoteListBinding.tvItemVoteHours.setText(String.valueOf(timeRemaining.getHours()));
                        itemVoteListBinding.tvItemVoteMin.setText(String.valueOf(timeRemaining.getMin()));
                    }
                    if (item.getUrl().length() > 0) {
                        GlideUtil.loadImage(getContext(), item.getUrl(), itemVoteListBinding.ivItemVoteCover);
                    } else {
                        GlideUtil.loadImage(getContext(), R.mipmap.default_vote_cover, itemVoteListBinding.ivItemVoteCover);
                    }
                    itemVoteListBinding.tvItemVoteTitle.setText(item.getTitle());
                }
            }

            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
            public ItemVoteListBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                Intrinsics.checkNotNullParameter(inflater, "inflater");
                Intrinsics.checkNotNullParameter(parent, "parent");
                ItemVoteListBinding itemVoteListBindingInflate = ItemVoteListBinding.inflate(inflater, parent, false);
                Intrinsics.checkNotNullExpressionValue(itemVoteListBindingInflate, "inflate(inflater, parent, false)");
                return itemVoteListBindingInflate;
            }
        };
        if (this.isPortrait) {
            getBinding().rvActivityVoteListList.setLayoutManager(new LinearLayoutManager(requireContext()));
        } else {
            getBinding().rvActivityVoteListList.setLayoutManager(new GridLayoutManager(requireContext(), 2));
            getBinding().rvActivityVoteListList.addItemDecoration(new GridSpacingItemDecoration(2, SizeUtils.dp2px(30.0f), false));
        }
        RecyclerView recyclerView = getBinding().rvActivityVoteListList;
        BaseBindingAdapter<ItemVoteListBinding, VoteDetailBean> baseBindingAdapter = this.voteListAdapter;
        BaseBindingAdapter<ItemVoteListBinding, VoteDetailBean> baseBindingAdapter2 = null;
        if (baseBindingAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voteListAdapter");
            baseBindingAdapter = null;
        }
        recyclerView.setAdapter(baseBindingAdapter);
        BaseBindingAdapter<ItemVoteListBinding, VoteDetailBean> baseBindingAdapter3 = this.voteListAdapter;
        if (baseBindingAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voteListAdapter");
        } else {
            baseBindingAdapter2 = baseBindingAdapter3;
        }
        baseBindingAdapter2.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.-$$Lambda$VoteListFragment$RpdNlIv-riKRbeYSkFII9l5HVdU
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                VoteListFragment.initView$lambda$0(this.f$0, baseQuickAdapter, view, i);
            }
        });
        getBinding().tvActivityVoteListNext.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.-$$Lambda$VoteListFragment$xpe04C1fEMgzZ_RV5ZEJmLvwuW8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoteListFragment.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().tvActivityVoteListPre.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.-$$Lambda$VoteListFragment$jDHZGHq4t3ItBgRwds77nlJ6odg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoteListFragment.initView$lambda$2(this.f$0, view);
            }
        });
        getBinding().tvActivityVoteListIng.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.-$$Lambda$VoteListFragment$UPHBY08rd4QT--NT5ye9EJcqH38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoteListFragment.initView$lambda$3(this.f$0, view);
            }
        });
        getBinding().tvActivityVoteListEnd.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.-$$Lambda$VoteListFragment$kg5ws16p6REOFI97EZxVjSVgE98
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoteListFragment.initView$lambda$4(this.f$0, view);
            }
        });
        LiveData<Result<BasePageResponse<List<VoteDetailBean>>>> voteList = getViewModel().getVoteList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends BasePageResponse<List<? extends VoteDetailBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<? extends VoteDetailBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.VoteListFragment.initView.7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<? extends VoteDetailBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<? extends VoteDetailBean>>> it2) {
                VoteListFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                BaseBindingAdapter baseBindingAdapter4 = null;
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                BasePageResponse basePageResponse = (BasePageResponse) value;
                if (basePageResponse == null) {
                    return;
                }
                VoteListFragment.this.totalCount = basePageResponse.getTotal();
                BaseBindingAdapter baseBindingAdapter5 = VoteListFragment.this.voteListAdapter;
                if (baseBindingAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("voteListAdapter");
                } else {
                    baseBindingAdapter4 = baseBindingAdapter5;
                }
                baseBindingAdapter4.setList((Collection) basePageResponse.getList());
            }
        };
        voteList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.-$$Lambda$VoteListFragment$_pA8d3CrQlDh-HZtfCX9xy-8nFw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoteListFragment.initView$lambda$5(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(VoteListFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        BaseBindingAdapter<ItemVoteListBinding, VoteDetailBean> baseBindingAdapter = this$0.voteListAdapter;
        if (baseBindingAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voteListAdapter");
            baseBindingAdapter = null;
        }
        this$0.currentClickVoteId = baseBindingAdapter.getItem(i).getId();
        Intent intent = new Intent(this$0.requireContext(), (Class<?>) CheackNomalActivity.class);
        intent.putExtra("type", BaseConstant.voteDetail);
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(VoteListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.current;
        if (this$0.size * i >= this$0.totalCount) {
            this$0.toastShow("没有下一页了");
        } else {
            this$0.current = i + 1;
            this$0.request();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(VoteListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.current;
        if (i == 1) {
            this$0.toastShow("没有上一页了");
            return;
        }
        if (i > 1) {
            this$0.current = i - 1;
        }
        this$0.request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(VoteListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentSelectList = 1;
        this$0.getBinding().tvActivityVoteListIng.setTextColor(SimpleUtilsKt.asColor(R.color.white));
        this$0.getBinding().tvActivityVoteListIng.setBackgroundResource(R.drawable.bg_purple23);
        this$0.getBinding().tvActivityVoteListEnd.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
        this$0.getBinding().tvActivityVoteListEnd.setBackground(null);
        this$0.current = 1;
        this$0.request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(VoteListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentSelectList = 2;
        this$0.getBinding().tvActivityVoteListEnd.setTextColor(SimpleUtilsKt.asColor(R.color.white));
        this$0.getBinding().tvActivityVoteListEnd.setBackgroundResource(R.drawable.bg_purple23);
        this$0.getBinding().tvActivityVoteListIng.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
        this$0.getBinding().tvActivityVoteListIng.setBackground(null);
        this$0.current = 1;
        this$0.request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void request() {
        showProgressDialog();
        int i = this.currentSelectList != 1 ? 2 : 1;
        VoteViewModel viewModel = getViewModel();
        int i2 = this.current;
        int i3 = this.size;
        String classesId = SpData.getClassesId();
        Intrinsics.checkNotNullExpressionValue(classesId, "getClassesId()");
        viewModel.getVoteList(i2, i3, i, classesId);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(EventBean eventBean) {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        if (eventBean.type != BaseConstant.voteDetail) {
            return;
        }
        boolean z = this.currentSelectList != 1;
        VoteDetailActivity.Companion companion = VoteDetailActivity.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        String str = this.currentClickVoteId;
        boolean z2 = this.isPortrait;
        String str2 = eventBean.id;
        Intrinsics.checkNotNullExpressionValue(str2, "eventBean.id");
        String str3 = eventBean.name;
        Intrinsics.checkNotNullExpressionValue(str3, "eventBean.name");
        companion.startGo(contextRequireContext, str, z2, z, str2, str3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
