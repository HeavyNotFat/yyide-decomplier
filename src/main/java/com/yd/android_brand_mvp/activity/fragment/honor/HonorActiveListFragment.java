package com.yd.android_brand_mvp.activity.fragment.honor;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.fragment.model.HonorActiveListViewModel;
import com.yd.android_brand_mvp.activity.honor.HonorActiveDetailActivity;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.HonorActiveListFragmentBinding;
import com.yd.android_brand_mvp.databinding.ItemHonorActiveBinding;
import com.yd.android_brand_mvp.model.honor.HonorActiveBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.PageUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorActiveListFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0002R\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorActiveListFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/HonorActiveListFragmentBinding;", "()V", "mAdapter", "Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorActiveListFragment$ActiveAdapter;", "pageNo", "", "pageSize", "total", "Ljava/lang/Integer;", "viewModel", "Lcom/yd/android_brand_mvp/activity/fragment/model/HonorActiveListViewModel;", "initView", "", "initViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "requestList", "ActiveAdapter", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorActiveListFragment extends KTBaseFragment<HonorActiveListFragmentBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ActiveAdapter mAdapter;
    private int pageNo;
    private final int pageSize;
    private Integer total;
    private HonorActiveListViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.fragment.honor.HonorActiveListFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HonorActiveListFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, HonorActiveListFragmentBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, HonorActiveListFragmentBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/HonorActiveListFragmentBinding;", 0);
        }

        public final HonorActiveListFragmentBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return HonorActiveListFragmentBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ HonorActiveListFragmentBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public HonorActiveListFragment() {
        super(AnonymousClass1.INSTANCE);
        this.mAdapter = new ActiveAdapter();
        this.pageSize = 6;
        this.pageNo = 1;
        this.total = 0;
    }

    /* JADX INFO: compiled from: HonorActiveListFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorActiveListFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorActiveListFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HonorActiveListFragment newInstance() {
            return new HonorActiveListFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (HonorActiveListViewModel) new ViewModelProvider(this).get(HonorActiveListViewModel.class);
        initView();
    }

    private final void initView() {
        if (ScreenUtils.isLandscape()) {
            getBinding().recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        getBinding().recyclerView.setAdapter(this.mAdapter);
        this.mAdapter.setEmptyView(R.layout.layout_empty);
        initViewModel();
        requestList();
        this.mAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorActiveListFragment$MDXN95ihZCvfk5nfrlh9E8cyKQM
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                HonorActiveListFragment.initView$lambda$0(this.f$0, baseQuickAdapter, view, i);
            }
        });
        getBinding().tvUpPage.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorActiveListFragment$bJFOtHVXDMhOxWcOnHd_mOYe5jU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HonorActiveListFragment.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().tvNext.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorActiveListFragment$bipzvkoucKAf3TXjjmpXPjs7wdI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HonorActiveListFragment.initView$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(HonorActiveListFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        HonorActiveDetailActivity.Companion companion = HonorActiveDetailActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.start(contextRequireContext, this$0.mAdapter.getItem(i).getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(HonorActiveListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.pageNo;
        if (i > 1) {
            this$0.pageNo = i - 1;
            this$0.requestList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(HonorActiveListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.total != null) {
            int iDoCalculatePageNumber = PageUtils.INSTANCE.doCalculatePageNumber(this$0.pageSize, this$0.total);
            int i = this$0.pageNo;
            if (iDoCalculatePageNumber > i) {
                this$0.pageNo = i + 1;
                this$0.requestList();
                return;
            }
        }
        ToastUtil.showBottomView((Activity) this$0.getActivity(), "没有下一页了");
    }

    private final void initViewModel() {
        HonorActiveListViewModel honorActiveListViewModel = this.viewModel;
        if (honorActiveListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            honorActiveListViewModel = null;
        }
        final Function1<Result<? extends BasePageResponse<List<HonorActiveBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<HonorActiveBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorActiveListFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<HonorActiveBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<HonorActiveBean>>> it2) {
                HonorActiveListFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    BasePageResponse basePageResponse = (BasePageResponse) value;
                    HonorActiveListFragment.this.total = basePageResponse != null ? Integer.valueOf(basePageResponse.getTotal()) : null;
                    if (basePageResponse != null) {
                        HonorActiveListFragment.this.mAdapter.setList((Collection) basePageResponse.getList());
                        return;
                    }
                    return;
                }
                Result.m594exceptionOrNullimpl(it2.getValue());
            }
        };
        honorActiveListViewModel.getHonorActiveListLiveData().observe(this, new Observer() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorActiveListFragment$GjQykG1cRyOZxnF5kxDRHXjcRMY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HonorActiveListFragment.initViewModel$lambda$3(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void requestList() {
        showProgressDialog();
        HonorActiveListViewModel honorActiveListViewModel = this.viewModel;
        if (honorActiveListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            honorActiveListViewModel = null;
        }
        String schoolId = SpData.getSchoolId();
        Intrinsics.checkNotNullExpressionValue(schoolId, "getSchoolId()");
        String classesId = SpData.getClassesId();
        Intrinsics.checkNotNullExpressionValue(classesId, "getClassesId()");
        honorActiveListViewModel.requestActiveHonorList(schoolId, classesId, this.pageSize, this.pageNo);
    }

    /* JADX INFO: compiled from: HonorActiveListFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorActiveListFragment$ActiveAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/honor/HonorActiveBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "(Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorActiveListFragment;)V", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ActiveAdapter extends BaseQuickAdapter<HonorActiveBean, BaseViewHolder> implements LoadMoreModule {
        public ActiveAdapter() {
            super(R.layout.item_honor_active, null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(BaseViewHolder holder, HonorActiveBean item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            ItemHonorActiveBinding itemHonorActiveBindingBind = ItemHonorActiveBinding.bind(holder.itemView);
            Intrinsics.checkNotNullExpressionValue(itemHonorActiveBindingBind, "bind(holder.itemView)");
            GlideUtil.loadRadiusImage(getContext(), item.getPromotionalImage(), itemHonorActiveBindingBind.ivCover, 20);
            itemHonorActiveBindingBind.tvTitle.setText(item.getTitle());
            itemHonorActiveBindingBind.tvContent.setText(item.getDescription());
            itemHonorActiveBindingBind.tvTime.setText(item.getActivityTime());
            int status = item.getStatus();
            if (status == 0) {
                itemHonorActiveBindingBind.cardViewState.setCardBackgroundColor(getContext().getResources().getColor(R.color.color_ffc328));
                itemHonorActiveBindingBind.tvState.setText("未开始");
            } else if (status == 1) {
                itemHonorActiveBindingBind.cardViewState.setCardBackgroundColor(getContext().getResources().getColor(R.color.color_11c685));
                itemHonorActiveBindingBind.tvState.setText("进行中");
            } else {
                if (status != 3) {
                    return;
                }
                itemHonorActiveBindingBind.cardViewState.setCardBackgroundColor(getContext().getResources().getColor(R.color.color_595959));
                itemHonorActiveBindingBind.tvState.setText("已结束");
            }
        }
    }
}
