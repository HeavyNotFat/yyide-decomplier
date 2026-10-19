package com.yd.android_brand_mvp.activity.vote.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.vote.viewmodel.VoteViewModel;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ActivityVoteDetailBinding;
import com.yd.android_brand_mvp.databinding.ItemVoteDetailBinding;
import com.yd.android_brand_mvp.databinding.ItemVoteDetailEndBinding;
import com.yd.android_brand_mvp.model.RemainingBean;
import com.yd.android_brand_mvp.model.vote.FilesItem;
import com.yd.android_brand_mvp.model.vote.OptionsItem;
import com.yd.android_brand_mvp.model.vote.VoteBrandInfoBean;
import com.yd.android_brand_mvp.model.vote.VoteDetailBean;
import com.yd.android_brand_mvp.model.vote.VoteSubmitInfoBean;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.TransUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: VoteDetailFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u000b\u0016\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0002J\u001a\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/yd/android_brand_mvp/activity/vote/fragment/VoteDetailFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/ActivityVoteDetailBinding;", "()V", "allCount", "", "checkId", "", "checkName", "currentSelectPosition", "endAdapter", "com/yd/android_brand_mvp/activity/vote/fragment/VoteDetailFragment$endAdapter$2$1", "getEndAdapter", "()Lcom/yd/android_brand_mvp/activity/vote/fragment/VoteDetailFragment$endAdapter$2$1;", "endAdapter$delegate", "Lkotlin/Lazy;", "id", "isEndVote", "", "isPortrait", "isSingleSelect", "normalAdapter", "com/yd/android_brand_mvp/activity/vote/fragment/VoteDetailFragment$normalAdapter$2$1", "getNormalAdapter", "()Lcom/yd/android_brand_mvp/activity/vote/fragment/VoteDetailFragment$normalAdapter$2$1;", "normalAdapter$delegate", "viewModel", "Lcom/yd/android_brand_mvp/activity/vote/viewmodel/VoteViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/vote/viewmodel/VoteViewModel;", "viewModel$delegate", "voteType", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VoteDetailFragment extends KTBaseFragment<ActivityVoteDetailBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int allCount;
    private String checkId;
    private String checkName;
    private int currentSelectPosition;

    /* JADX INFO: renamed from: endAdapter$delegate, reason: from kotlin metadata */
    private final Lazy endAdapter;
    private String id;
    private boolean isEndVote;
    private boolean isPortrait;
    private boolean isSingleSelect;

    /* JADX INFO: renamed from: normalAdapter$delegate, reason: from kotlin metadata */
    private final Lazy normalAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private int voteType;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.vote.fragment.VoteDetailFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: VoteDetailFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ActivityVoteDetailBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, ActivityVoteDetailBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/ActivityVoteDetailBinding;", 0);
        }

        public final ActivityVoteDetailBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ActivityVoteDetailBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ActivityVoteDetailBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ ActivityVoteDetailBinding access$getBinding(VoteDetailFragment voteDetailFragment) {
        return voteDetailFragment.getBinding();
    }

    public VoteDetailFragment() {
        super(AnonymousClass1.INSTANCE);
        final VoteDetailFragment voteDetailFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.VoteDetailFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return voteDetailFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.VoteDetailFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(voteDetailFragment, Reflection.getOrCreateKotlinClass(VoteViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.VoteDetailFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.VoteDetailFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.VoteDetailFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = voteDetailFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.id = "";
        this.checkId = "";
        this.checkName = "";
        this.currentSelectPosition = -1;
        this.endAdapter = LazyKt.lazy(new Function0<VoteDetailFragment$endAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.VoteDetailFragment$endAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.activity.vote.fragment.VoteDetailFragment$endAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final VoteDetailFragment voteDetailFragment2 = this.this$0;
                return new BaseBindingAdapter<ItemVoteDetailEndBinding, OptionsItem>() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.VoteDetailFragment$endAdapter$2.1
                    {
                        super(null, 1, null);
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, OptionsItem optionsItem) {
                        convertPlus2((VBViewHolder<ItemVoteDetailEndBinding>) vBViewHolder, optionsItem);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemVoteDetailEndBinding> holder, OptionsItem item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemVoteDetailEndBinding itemVoteDetailEndBinding = (ItemVoteDetailEndBinding) holder.getBinding();
                        if (itemVoteDetailEndBinding != null) {
                            VoteDetailFragment voteDetailFragment3 = voteDetailFragment2;
                            itemVoteDetailEndBinding.tvItemVoteDetailEndTitle.setText(item.getTitle());
                            if (item.getCountNum() > 0) {
                                ImageView imageView = itemVoteDetailEndBinding.viewLineProgress;
                                Intrinsics.checkNotNullExpressionValue(imageView, "it.viewLineProgress");
                                SimpleUtilsKt.show(imageView);
                                ImageView imageView2 = itemVoteDetailEndBinding.viewLineProgress;
                                Intrinsics.checkNotNullExpressionValue(imageView2, "it.viewLineProgress");
                                ImageView imageView3 = imageView2;
                                ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
                                if (layoutParams != null) {
                                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                                    ((ConstraintLayout.LayoutParams) layoutParams).width = (int) (((double) VoteDetailFragment.access$getBinding(voteDetailFragment3).rvActivityVoteDetail.getWidth()) * (((double) item.getCountNum()) / ((double) voteDetailFragment3.allCount)));
                                    imageView3.setLayoutParams(layoutParams);
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                                }
                            } else {
                                ImageView imageView4 = itemVoteDetailEndBinding.viewLineProgress;
                                Intrinsics.checkNotNullExpressionValue(imageView4, "it.viewLineProgress");
                                SimpleUtilsKt.hide(imageView4);
                            }
                            TextView textView = itemVoteDetailEndBinding.tvItemVoteDetailEndCount;
                            StringBuilder sb = new StringBuilder();
                            sb.append(item.getCountNum());
                            sb.append((char) 31080);
                            textView.setText(sb.toString());
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemVoteDetailEndBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemVoteDetailEndBinding itemVoteDetailEndBindingInflate = ItemVoteDetailEndBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemVoteDetailEndBindingInflate, "inflate(inflater, parent, false)");
                        return itemVoteDetailEndBindingInflate;
                    }
                };
            }
        });
        this.normalAdapter = LazyKt.lazy(new Function0<VoteDetailFragment$normalAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.VoteDetailFragment$normalAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.activity.vote.fragment.VoteDetailFragment$normalAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final VoteDetailFragment voteDetailFragment2 = this.this$0;
                return new BaseBindingAdapter<ItemVoteDetailBinding, OptionsItem>() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.VoteDetailFragment$normalAdapter$2.1
                    {
                        super(null, 1, null);
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, OptionsItem optionsItem) {
                        convertPlus2((VBViewHolder<ItemVoteDetailBinding>) vBViewHolder, optionsItem);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemVoteDetailBinding> holder, OptionsItem item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemVoteDetailBinding itemVoteDetailBinding = (ItemVoteDetailBinding) holder.getBinding();
                        if (itemVoteDetailBinding != null) {
                            if (voteDetailFragment2.voteType == 4) {
                                Group group = itemVoteDetailBinding.groupItemVoteDetailSelection;
                                Intrinsics.checkNotNullExpressionValue(group, "it.groupItemVoteDetailSelection");
                                SimpleUtilsKt.show(group);
                            } else {
                                Group group2 = itemVoteDetailBinding.groupItemVoteDetailSelection;
                                Intrinsics.checkNotNullExpressionValue(group2, "it.groupItemVoteDetailSelection");
                                SimpleUtilsKt.remove(group2);
                            }
                            if (item.isSelect()) {
                                itemVoteDetailBinding.ivItemVoteDetailSelect.setImageResource(R.drawable.icon_purple_select);
                            } else {
                                itemVoteDetailBinding.ivItemVoteDetailSelect.setImageResource(R.drawable.icon_not_select);
                            }
                            if (!item.getFiles().isEmpty()) {
                                GlideUtil.loadImage(getContext(), ((FilesItem) CollectionsKt.first((List) item.getFiles())).getUrl(), itemVoteDetailBinding.ivItemVoteDetail);
                            } else {
                                GlideUtil.loadImage(getContext(), R.drawable.defalut_vote, itemVoteDetailBinding.ivItemVoteDetail);
                            }
                            itemVoteDetailBinding.tvItemVoteDetailName.setText(item.getTitle());
                            itemVoteDetailBinding.tvItemVoteDetailDesc.setText(item.getDesc());
                            TextView textView = itemVoteDetailBinding.tvItemVoteDetailCount;
                            StringBuilder sb = new StringBuilder();
                            sb.append(item.getCountNum());
                            sb.append((char) 31080);
                            textView.setText(sb.toString());
                            TextView textView2 = itemVoteDetailBinding.tvItemVoteDetailNumber;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(holder.getLayoutPosition() + 1);
                            sb2.append((char) 21495);
                            textView2.setText(sb2.toString());
                            itemVoteDetailBinding.tvItemVoteDetailVoteNumber.setText(String.valueOf(item.getSelectNum()));
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemVoteDetailBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemVoteDetailBinding itemVoteDetailBindingInflate = ItemVoteDetailBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemVoteDetailBindingInflate, "inflate(inflater, parent, false)");
                        return itemVoteDetailBindingInflate;
                    }
                };
            }
        });
    }

    /* JADX INFO: compiled from: VoteDetailFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/activity/vote/fragment/VoteDetailFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "id", "", "isPortrait", "", "isEndVote", "checkId", "checkName", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String id, boolean isPortrait, boolean isEndVote, String checkId, String checkName) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(checkId, "checkId");
            Intrinsics.checkNotNullParameter(checkName, "checkName");
            VoteDetailFragment voteDetailFragment = new VoteDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putBoolean("isPortrait", isPortrait);
            bundle.putBoolean("isEndVote", isEndVote);
            bundle.putString("checkId", checkId);
            bundle.putString("checkName", checkName);
            voteDetailFragment.setArguments(bundle);
            return voteDetailFragment;
        }
    }

    private final VoteViewModel getViewModel() {
        return (VoteViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VoteDetailFragment$endAdapter$2.AnonymousClass1 getEndAdapter() {
        return (VoteDetailFragment$endAdapter$2.AnonymousClass1) this.endAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VoteDetailFragment$normalAdapter$2.AnonymousClass1 getNormalAdapter() {
        return (VoteDetailFragment$normalAdapter$2.AnonymousClass1) this.normalAdapter.getValue();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        this.isPortrait = arguments != null ? arguments.getBoolean("isPortrait") : false;
        Bundle arguments2 = getArguments();
        this.isEndVote = arguments2 != null ? arguments2.getBoolean("isEndVote") : false;
        Bundle arguments3 = getArguments();
        String string = arguments3 != null ? arguments3.getString("id") : null;
        if (string == null) {
            string = "";
        }
        this.id = string;
        Bundle arguments4 = getArguments();
        String string2 = arguments4 != null ? arguments4.getString("checkId") : null;
        if (string2 == null) {
            string2 = "";
        }
        this.checkId = string2;
        Bundle arguments5 = getArguments();
        String string3 = arguments5 != null ? arguments5.getString("checkName") : null;
        this.checkName = string3 != null ? string3 : "";
        if (this.isEndVote) {
            Group group = getBinding().groupEndDetail;
            Intrinsics.checkNotNullExpressionValue(group, "binding.groupEndDetail");
            SimpleUtilsKt.hide(group);
            TextView textView = getBinding().btnActivityVoteDetail;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.btnActivityVoteDetail");
            SimpleUtilsKt.hide(textView);
            TextView textView2 = getBinding().tvActivityVoteDetailEnd;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvActivityVoteDetailEnd");
            SimpleUtilsKt.show(textView2);
            getBinding().rvActivityVoteDetail.setLayoutManager(new LinearLayoutManager(requireContext()));
            getBinding().rvActivityVoteDetail.setAdapter(getEndAdapter());
        } else {
            Group group2 = getBinding().groupEndDetail;
            Intrinsics.checkNotNullExpressionValue(group2, "binding.groupEndDetail");
            SimpleUtilsKt.show(group2);
            TextView textView3 = getBinding().btnActivityVoteDetail;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.btnActivityVoteDetail");
            SimpleUtilsKt.show(textView3);
            int i = this.isPortrait ? 3 : 4;
            getNormalAdapter().addChildClickViewIds(R.id.iv_item_vote_detail_vote_number_add, R.id.iv_item_vote_detail_vote_number_reduce);
            getBinding().rvActivityVoteDetail.setLayoutManager(new StaggeredGridLayoutManager(i, 1));
            getBinding().rvActivityVoteDetail.setAdapter(getNormalAdapter());
            getBinding().rvActivityVoteDetail.setItemAnimator(null);
        }
        getNormalAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.-$$Lambda$VoteDetailFragment$9Ti46jvgTNQPZiXzpZaieopNzI8
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                VoteDetailFragment.initView$lambda$0(this.f$0, baseQuickAdapter, view, i2);
            }
        });
        getNormalAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.-$$Lambda$VoteDetailFragment$zkDXAhTx3LlJPXN0CQIspgMa2yw
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                VoteDetailFragment.initView$lambda$1(this.f$0, baseQuickAdapter, view, i2);
            }
        });
        getBinding().btnActivityVoteDetail.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.-$$Lambda$VoteDetailFragment$xKtz4L3-6L4xmZ2TkOhC0W_DsnY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoteDetailFragment.initView$lambda$3(this.f$0, view);
            }
        });
        LiveData<Result<VoteDetailBean>> voteDetail = getViewModel().getVoteDetail();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends VoteDetailBean>, Unit> function1 = new Function1<Result<? extends VoteDetailBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.VoteDetailFragment.initView.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends VoteDetailBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends VoteDetailBean> it2) {
                VoteDetailFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                VoteDetailBean voteDetailBean = (VoteDetailBean) value;
                if (voteDetailBean == null) {
                    return;
                }
                if (voteDetailBean.getUrl().length() > 0) {
                    GlideUtil.loadImage(VoteDetailFragment.this.getContext(), voteDetailBean.getUrl(), VoteDetailFragment.access$getBinding(VoteDetailFragment.this).ivActivityVoteDetailCover);
                } else {
                    GlideUtil.loadImage(VoteDetailFragment.this.getContext(), R.mipmap.default_vote_cover2, VoteDetailFragment.access$getBinding(VoteDetailFragment.this).ivActivityVoteDetailCover);
                }
                VoteDetailFragment.access$getBinding(VoteDetailFragment.this).tvActivityVoteDetailTitle.setText(voteDetailBean.getTitle());
                VoteDetailFragment.access$getBinding(VoteDetailFragment.this).tvActivityVoteDetailTime.setText(voteDetailBean.getVoteDate());
                VoteDetailFragment.access$getBinding(VoteDetailFragment.this).tvActivityVoteDetailDesc.setText(voteDetailBean.getDesc());
                VoteDetailFragment.this.getNormalAdapter().setList(voteDetailBean.getOptions());
                VoteDetailFragment.this.getEndAdapter().setList(voteDetailBean.getOptions());
                RemainingBean timeRemaining = DateUtils.getTimeRemaining(voteDetailBean.getEndTime());
                VoteDetailFragment.access$getBinding(VoteDetailFragment.this).tvActivityVoteDetailDay.setText(String.valueOf(timeRemaining.getDay()));
                VoteDetailFragment.access$getBinding(VoteDetailFragment.this).tvActivityVoteDetailHours.setText(String.valueOf(timeRemaining.getHours()));
                VoteDetailFragment.access$getBinding(VoteDetailFragment.this).tvActivityVoteDetailMin.setText(String.valueOf(timeRemaining.getMin()));
                VoteDetailFragment.this.voteType = voteDetailBean.getType();
                VoteDetailFragment.this.isSingleSelect = TransUtils.INSTANCE.getVoteTypeIfSingleSelect(voteDetailBean.getType());
                List<OptionsItem> options = voteDetailBean.getOptions();
                VoteDetailFragment voteDetailFragment = VoteDetailFragment.this;
                Iterator<T> it3 = options.iterator();
                while (it3.hasNext()) {
                    voteDetailFragment.allCount += ((OptionsItem) it3.next()).getCountNum();
                }
                if (VoteDetailFragment.this.allCount == 0) {
                    VoteDetailFragment.this.allCount = 1;
                }
            }
        };
        voteDetail.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.-$$Lambda$VoteDetailFragment$BoUDOh-_6UACmDlS4ewkA_Jyveg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoteDetailFragment.initView$lambda$4(function1, obj);
            }
        });
        LiveData<Result<Boolean>> submitResult = getViewModel().getSubmitResult();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends Boolean>, Unit> function2 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.VoteDetailFragment.initView.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Boolean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends Boolean> it2) {
                VoteDetailFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                Boolean bool = (Boolean) value;
                if (bool == null || !bool.booleanValue()) {
                    return;
                }
                ToastUtil.showBottomView(VoteDetailFragment.this.requireContext(), "投票成功");
                VoteDetailFragment.this.requireActivity().finish();
            }
        };
        submitResult.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.activity.vote.fragment.-$$Lambda$VoteDetailFragment$n5qL6ta2ujuAk-w-O3XMh10dANI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoteDetailFragment.initView$lambda$5(function2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(VoteDetailFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (this$0.isSingleSelect && (i2 = this$0.currentSelectPosition) != -1 && i2 != i) {
            this$0.getNormalAdapter().getItem(this$0.currentSelectPosition).setSelect(false);
            adapter.notifyItemChanged(this$0.currentSelectPosition);
        }
        OptionsItem item = this$0.getNormalAdapter().getItem(i);
        item.setSelect(!item.isSelect());
        this$0.currentSelectPosition = item.isSelect() ? i : -1;
        adapter.notifyItemChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(VoteDetailFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        OptionsItem item = this$0.getNormalAdapter().getItem(i);
        if (view.getId() == R.id.iv_item_vote_detail_vote_number_add) {
            item.setSelectNum(item.getSelectNum() + 1);
            adapter.notifyItemChanged(i);
        } else {
            if (view.getId() != R.id.iv_item_vote_detail_vote_number_reduce || item.getSelectNum() == 0) {
                return;
            }
            item.setSelectNum(item.getSelectNum() - 1);
            adapter.notifyItemChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(VoteDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showProgressDialog();
        ArrayList arrayList = new ArrayList();
        for (OptionsItem optionsItem : this$0.getNormalAdapter().getData()) {
            if (optionsItem.isSelect()) {
                arrayList.add(new VoteSubmitInfoBean(optionsItem.getId(), this$0.voteType == 4 ? optionsItem.getSelectNum() : 1));
            }
        }
        this$0.getViewModel().submitVoteResult(this$0.id, this$0.checkId, this$0.checkName, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void request() {
        showProgressDialog();
        String str = this.checkId;
        String str2 = this.checkName;
        String schoolId = SpData.getSchoolId();
        Intrinsics.checkNotNullExpressionValue(schoolId, "getSchoolId()");
        getViewModel().getVoteDetail(this.id, new VoteBrandInfoBean(str, str2, schoolId));
    }
}
