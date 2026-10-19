package com.yd.android_brand_mvp.dialog.vote;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.DialogFragment;
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
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.vote.viewmodel.VoteViewModel;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.DialogVoteDetailBinding;
import com.yd.android_brand_mvp.databinding.ItemVoteDetailBinding;
import com.yd.android_brand_mvp.dialog.NomalLoadingDiallog;
import com.yd.android_brand_mvp.model.EventBean;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: VoteDetailDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0018\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0002J$\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020$H\u0016J\u001a\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u00101\u001a\u00020$H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/vote/VoteDetailDialog;", "Landroidx/fragment/app/DialogFragment;", "portrait", "", "data", "Lcom/yd/android_brand_mvp/model/vote/VoteDetailBean;", "checkUser", "Lcom/yd/android_brand_mvp/model/EventBean;", "(ZLcom/yd/android_brand_mvp/model/vote/VoteDetailBean;Lcom/yd/android_brand_mvp/model/EventBean;)V", "binding", "Lcom/yd/android_brand_mvp/databinding/DialogVoteDetailBinding;", "currentSelectPosition", "", "getData", "()Lcom/yd/android_brand_mvp/model/vote/VoteDetailBean;", "isPortrait", "isSingleSelect", "loadingDialog", "Lcom/yd/android_brand_mvp/dialog/NomalLoadingDiallog;", "getLoadingDialog", "()Lcom/yd/android_brand_mvp/dialog/NomalLoadingDiallog;", "setLoadingDialog", "(Lcom/yd/android_brand_mvp/dialog/NomalLoadingDiallog;)V", "normalAdapter", "com/yd/android_brand_mvp/dialog/vote/VoteDetailDialog$normalAdapter$2$1", "getNormalAdapter", "()Lcom/yd/android_brand_mvp/dialog/vote/VoteDetailDialog$normalAdapter$2$1;", "normalAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/yd/android_brand_mvp/activity/vote/viewmodel/VoteViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/vote/viewmodel/VoteViewModel;", "viewModel$delegate", "voteType", "dismissProgressDialog", "", "initView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "showProgressDialog", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VoteDetailDialog extends DialogFragment {
    private DialogVoteDetailBinding binding;
    private final EventBean checkUser;
    private int currentSelectPosition;
    private final VoteDetailBean data;
    private boolean isPortrait;
    private boolean isSingleSelect;
    private NomalLoadingDiallog loadingDialog;

    /* JADX INFO: renamed from: normalAdapter$delegate, reason: from kotlin metadata */
    private final Lazy normalAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private int voteType;

    public final VoteDetailBean getData() {
        return this.data;
    }

    public VoteDetailDialog(boolean z, VoteDetailBean data, EventBean checkUser) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(checkUser, "checkUser");
        this.data = data;
        this.checkUser = checkUser;
        this.isPortrait = z;
        final VoteDetailDialog voteDetailDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.dialog.vote.VoteDetailDialog$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return voteDetailDialog;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.dialog.vote.VoteDetailDialog$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(voteDetailDialog, Reflection.getOrCreateKotlinClass(VoteViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.dialog.vote.VoteDetailDialog$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.dialog.vote.VoteDetailDialog$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.dialog.vote.VoteDetailDialog$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = voteDetailDialog.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.currentSelectPosition = -1;
        this.normalAdapter = LazyKt.lazy(new Function0<VoteDetailDialog$normalAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.dialog.vote.VoteDetailDialog$normalAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.dialog.vote.VoteDetailDialog$normalAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final VoteDetailDialog voteDetailDialog2 = this.this$0;
                return new BaseBindingAdapter<ItemVoteDetailBinding, OptionsItem>() { // from class: com.yd.android_brand_mvp.dialog.vote.VoteDetailDialog$normalAdapter$2.1
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
                            if (voteDetailDialog2.voteType == 4) {
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

    private final VoteViewModel getViewModel() {
        return (VoteViewModel) this.viewModel.getValue();
    }

    public final NomalLoadingDiallog getLoadingDialog() {
        return this.loadingDialog;
    }

    public final void setLoadingDialog(NomalLoadingDiallog nomalLoadingDiallog) {
        this.loadingDialog = nomalLoadingDiallog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VoteDetailDialog$normalAdapter$2.AnonymousClass1 getNormalAdapter() {
        return (VoteDetailDialog$normalAdapter$2.AnonymousClass1) this.normalAdapter.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogVoteDetailBinding dialogVoteDetailBindingInflate = DialogVoteDetailBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(dialogVoteDetailBindingInflate, "inflate(inflater, container, false)");
        this.binding = dialogVoteDetailBindingInflate;
        if (dialogVoteDetailBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogVoteDetailBindingInflate = null;
        }
        ConstraintLayout root = dialogVoteDetailBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.loadingDialog = new NomalLoadingDiallog(requireActivity());
        initView();
        showProgressDialog();
        String str = this.checkUser.id;
        Intrinsics.checkNotNullExpressionValue(str, "checkUser.id");
        String str2 = this.checkUser.name;
        Intrinsics.checkNotNullExpressionValue(str2, "checkUser.name");
        String schoolId = SpData.getSchoolId();
        Intrinsics.checkNotNullExpressionValue(schoolId, "getSchoolId()");
        getViewModel().getVoteDetail(this.data.getId(), new VoteBrandInfoBean(str, str2, schoolId));
    }

    private final void initView() {
        int i = this.isPortrait ? 3 : 2;
        getNormalAdapter().addChildClickViewIds(R.id.iv_item_vote_detail_vote_number_add, R.id.iv_item_vote_detail_vote_number_reduce);
        DialogVoteDetailBinding dialogVoteDetailBinding = this.binding;
        DialogVoteDetailBinding dialogVoteDetailBinding2 = null;
        if (dialogVoteDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogVoteDetailBinding = null;
        }
        dialogVoteDetailBinding.rvDialogVoteDetail.setLayoutManager(new StaggeredGridLayoutManager(i, 1));
        DialogVoteDetailBinding dialogVoteDetailBinding3 = this.binding;
        if (dialogVoteDetailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogVoteDetailBinding3 = null;
        }
        dialogVoteDetailBinding3.rvDialogVoteDetail.setAdapter(getNormalAdapter());
        DialogVoteDetailBinding dialogVoteDetailBinding4 = this.binding;
        if (dialogVoteDetailBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogVoteDetailBinding4 = null;
        }
        dialogVoteDetailBinding4.rvDialogVoteDetail.setItemAnimator(null);
        getNormalAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.dialog.vote.-$$Lambda$VoteDetailDialog$JeLyfHggKblvZLWK084WiQjTIWg
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                VoteDetailDialog.initView$lambda$0(this.f$0, baseQuickAdapter, view, i2);
            }
        });
        getNormalAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.yd.android_brand_mvp.dialog.vote.-$$Lambda$VoteDetailDialog$FBLNHMJbfhMZEGmd92zlssfRTOA
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                VoteDetailDialog.initView$lambda$1(this.f$0, baseQuickAdapter, view, i2);
            }
        });
        DialogVoteDetailBinding dialogVoteDetailBinding5 = this.binding;
        if (dialogVoteDetailBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogVoteDetailBinding2 = dialogVoteDetailBinding5;
        }
        dialogVoteDetailBinding2.btnDialogVoteDetail.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.vote.-$$Lambda$VoteDetailDialog$XVDFRiaWTnFhKrQEaJsV9fMKioY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoteDetailDialog.initView$lambda$3(this.f$0, view);
            }
        });
        LiveData<Result<Boolean>> submitResult = getViewModel().getSubmitResult();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends Boolean>, Unit> function1 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.dialog.vote.VoteDetailDialog.initView.4
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
                VoteDetailDialog.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                Boolean bool = (Boolean) value;
                if (bool == null || !bool.booleanValue()) {
                    return;
                }
                ToastUtil.showBottomView(VoteDetailDialog.this.requireContext(), "投票成功");
                VoteDetailDialog.this.dismiss();
            }
        };
        submitResult.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.dialog.vote.-$$Lambda$VoteDetailDialog$YdnJUEjoHDRkxTa-seXDM6i0wos
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoteDetailDialog.initView$lambda$4(function1, obj);
            }
        });
        LiveData<Result<VoteDetailBean>> voteDetail = getViewModel().getVoteDetail();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends VoteDetailBean>, Unit> function2 = new Function1<Result<? extends VoteDetailBean>, Unit>() { // from class: com.yd.android_brand_mvp.dialog.vote.VoteDetailDialog.initView.5
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
                VoteDetailDialog.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                DialogVoteDetailBinding dialogVoteDetailBinding6 = null;
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                VoteDetailBean voteDetailBean = (VoteDetailBean) value;
                if (voteDetailBean != null) {
                    DialogVoteDetailBinding dialogVoteDetailBinding7 = VoteDetailDialog.this.binding;
                    if (dialogVoteDetailBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        dialogVoteDetailBinding7 = null;
                    }
                    dialogVoteDetailBinding7.tvDialogVoteDetailTitle.setText(voteDetailBean.getTitle());
                    DialogVoteDetailBinding dialogVoteDetailBinding8 = VoteDetailDialog.this.binding;
                    if (dialogVoteDetailBinding8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        dialogVoteDetailBinding8 = null;
                    }
                    dialogVoteDetailBinding8.tvDialogVoteDetailTime.setText(voteDetailBean.getVoteDate());
                    DialogVoteDetailBinding dialogVoteDetailBinding9 = VoteDetailDialog.this.binding;
                    if (dialogVoteDetailBinding9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        dialogVoteDetailBinding9 = null;
                    }
                    dialogVoteDetailBinding9.tvDialogVoteDetailDesc.setText(voteDetailBean.getDesc());
                    VoteDetailDialog.this.getNormalAdapter().setList(voteDetailBean.getOptions());
                    RemainingBean timeRemaining = DateUtils.getTimeRemaining(voteDetailBean.getEndTime());
                    DialogVoteDetailBinding dialogVoteDetailBinding10 = VoteDetailDialog.this.binding;
                    if (dialogVoteDetailBinding10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        dialogVoteDetailBinding10 = null;
                    }
                    dialogVoteDetailBinding10.tvDialogVoteDetailDay.setText(String.valueOf(timeRemaining.getDay()));
                    DialogVoteDetailBinding dialogVoteDetailBinding11 = VoteDetailDialog.this.binding;
                    if (dialogVoteDetailBinding11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        dialogVoteDetailBinding11 = null;
                    }
                    dialogVoteDetailBinding11.tvDialogVoteDetailHours.setText(String.valueOf(timeRemaining.getHours()));
                    DialogVoteDetailBinding dialogVoteDetailBinding12 = VoteDetailDialog.this.binding;
                    if (dialogVoteDetailBinding12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        dialogVoteDetailBinding6 = dialogVoteDetailBinding12;
                    }
                    dialogVoteDetailBinding6.tvDialogVoteDetailMin.setText(String.valueOf(timeRemaining.getMin()));
                    VoteDetailDialog.this.voteType = voteDetailBean.getType();
                    VoteDetailDialog.this.isSingleSelect = TransUtils.INSTANCE.getVoteTypeIfSingleSelect(voteDetailBean.getType());
                    return;
                }
                VoteDetailDialog.this.dismiss();
            }
        };
        voteDetail.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.dialog.vote.-$$Lambda$VoteDetailDialog$LYN0yuyHBZ5BEUSVl439blEE9eY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VoteDetailDialog.initView$lambda$5(function2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(VoteDetailDialog this$0, BaseQuickAdapter adapter, View view, int i) {
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
    public static final void initView$lambda$1(VoteDetailDialog this$0, BaseQuickAdapter adapter, View view, int i) {
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
    public static final void initView$lambda$3(VoteDetailDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showProgressDialog();
        ArrayList arrayList = new ArrayList();
        for (OptionsItem optionsItem : this$0.getNormalAdapter().getData()) {
            if (optionsItem.isSelect()) {
                arrayList.add(new VoteSubmitInfoBean(optionsItem.getId(), this$0.voteType == 4 ? optionsItem.getSelectNum() : 1));
            }
        }
        Iterator<VoteSubmitInfoBean> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (it2.next().getNums() == 0) {
                ToastUtil.showBottomView(this$0.requireContext(), "选中的选项票数不能为0");
                this$0.dismissProgressDialog();
                return;
            }
        }
        VoteViewModel viewModel = this$0.getViewModel();
        String id = this$0.data.getId();
        String str = this$0.checkUser.id;
        Intrinsics.checkNotNullExpressionValue(str, "checkUser.id");
        String str2 = this$0.checkUser.name;
        Intrinsics.checkNotNullExpressionValue(str2, "checkUser.name");
        viewModel.submitVoteResult(id, str, str2, arrayList);
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        Dialog dialog2 = getDialog();
        Window window = dialog2 != null ? dialog2.getWindow() : null;
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkNotNullExpressionValue(attributes, "it.attributes");
            Display defaultDisplay = window.getWindowManager().getDefaultDisplay();
            Intrinsics.checkNotNullExpressionValue(defaultDisplay, "it.windowManager.defaultDisplay");
            if (this.isPortrait) {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.92d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.73d);
            } else {
                attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.47d);
                attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.8d);
            }
            window.setAttributes(attributes);
        }
    }

    private final void showProgressDialog() {
        NomalLoadingDiallog nomalLoadingDiallog = this.loadingDialog;
        if (nomalLoadingDiallog != null) {
            nomalLoadingDiallog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissProgressDialog() {
        NomalLoadingDiallog nomalLoadingDiallog = this.loadingDialog;
        if (nomalLoadingDiallog != null) {
            Intrinsics.checkNotNull(nomalLoadingDiallog);
            if (nomalLoadingDiallog.isShowing()) {
                NomalLoadingDiallog nomalLoadingDiallog2 = this.loadingDialog;
                Intrinsics.checkNotNull(nomalLoadingDiallog2);
                nomalLoadingDiallog2.dismiss();
            }
        }
    }
}
