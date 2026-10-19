package com.yd.android_brand_mvp.activity.fragment.honor;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.HonorListFragmentBinding;
import com.yd.android_brand_mvp.databinding.ItemHonorClassBinding;
import com.yd.android_brand_mvp.databinding.ItemHonorMedalBinding;
import com.yd.android_brand_mvp.landscape.honor.HonorViewModel;
import com.yd.android_brand_mvp.model.honor.HonorClassBean;
import com.yd.android_brand_mvp.model.honor.HonorItemBean;
import com.yd.android_brand_mvp.model.honor.HonorStudentBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
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

/* JADX INFO: compiled from: HonorListFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u0007\n\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorListFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/HonorListFragmentBinding;", "()V", "isClass", "", "mAdapter", "com/yd/android_brand_mvp/activity/fragment/honor/HonorListFragment$mAdapter$1", "Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorListFragment$mAdapter$1;", "mStudentAdapter", "com/yd/android_brand_mvp/activity/fragment/honor/HonorListFragment$mStudentAdapter$1", "Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorListFragment$mStudentAdapter$1;", "pageNo", "", "pageSize", "total", "Ljava/lang/Integer;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/honor/HonorViewModel;", "initView", "", "initViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "requestList", "Companion", "ItemAdapter", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorListFragment extends KTBaseFragment<HonorListFragmentBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean isClass;
    private final HonorListFragment$mAdapter$1 mAdapter;
    private final HonorListFragment$mStudentAdapter$1 mStudentAdapter;
    private int pageNo;
    private final int pageSize;
    private Integer total;
    private HonorViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.fragment.honor.HonorListFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HonorListFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, HonorListFragmentBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, HonorListFragmentBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/HonorListFragmentBinding;", 0);
        }

        public final HonorListFragmentBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return HonorListFragmentBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ HonorListFragmentBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ HonorListFragmentBinding access$getBinding(HonorListFragment honorListFragment) {
        return honorListFragment.getBinding();
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.yd.android_brand_mvp.activity.fragment.honor.HonorListFragment$mAdapter$1] */
    public HonorListFragment() {
        super(AnonymousClass1.INSTANCE);
        this.pageSize = 6;
        this.pageNo = 1;
        this.isClass = true;
        this.total = 0;
        this.mStudentAdapter = new HonorListFragment$mStudentAdapter$1(this);
        this.mAdapter = new BaseQuickAdapter<HonorClassBean, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorListFragment$mAdapter$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, HonorClassBean item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemHonorClassBinding itemHonorClassBindingBind = ItemHonorClassBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemHonorClassBindingBind, "bind(holder.itemView)");
                itemHonorClassBindingBind.tvRanking.setText(item.getRanking());
                GlideUtil.loadImage(getContext(), item.getMedalUrl(), itemHonorClassBindingBind.ivCoverLab);
                GlideUtil.loadImage(getContext(), item.getPromotionalImage(), itemHonorClassBindingBind.ivCover);
                itemHonorClassBindingBind.tvTitle.setText(item.getTitle());
                itemHonorClassBindingBind.tvTime.setText(item.getActivityTime());
            }
        };
    }

    /* JADX INFO: compiled from: HonorListFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorListFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorListFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HonorListFragment newInstance() {
            return new HonorListFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (HonorViewModel) new ViewModelProvider(this).get(HonorViewModel.class);
        initView();
    }

    private final void initView() {
        if (ScreenUtils.isLandscape()) {
            getBinding().recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        getBinding().recyclerView.setAdapter(this.mAdapter);
        setEmptyView(R.layout.layout_empty);
        this.mStudentAdapter.setEmptyView(R.layout.layout_empty);
        initViewModel();
        showProgressDialog();
        HonorViewModel honorViewModel = this.viewModel;
        if (honorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            honorViewModel = null;
        }
        String classesId = SpData.getClassesId();
        Intrinsics.checkNotNullExpressionValue(classesId, "getClassesId()");
        honorViewModel.requestHonorClassList(classesId, this.pageSize, this.pageNo);
        getBinding().tvUpPage.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorListFragment$TiMrFX_ns1zplodxqd1AH_KwxeM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HonorListFragment.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().tvNext.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorListFragment$O44jmTxfpyBMy3X39rZTE-2Qkjs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HonorListFragment.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().tvHonorClass.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorListFragment$nRY4877UKFT53mSZoc_9-wZvJBA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HonorListFragment.initView$lambda$2(this.f$0, view);
            }
        });
        getBinding().tvHonorStudent.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorListFragment$k9WvOPMS-33Sk7uahsFn5se0diA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HonorListFragment.initView$lambda$3(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(HonorListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.pageNo;
        if (i > 1) {
            this$0.pageNo = i - 1;
            this$0.requestList();
        } else {
            ToastUtil.showBottomView((Activity) this$0.getActivity(), "没有上一页了");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(HonorListFragment this$0, View view) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(HonorListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isClass = true;
        HonorViewModel honorViewModel = null;
        this$0.getBinding().tvHonorStudent.setBackground(null);
        this$0.getBinding().tvHonorStudent.setTextColor(this$0.getResources().getColor(R.color.black16));
        this$0.getBinding().tvHonorClass.setBackgroundResource(R.drawable.bg_comment_bt_40);
        this$0.getBinding().tvHonorClass.setTextColor(this$0.getResources().getColor(R.color.white));
        if (ScreenUtils.isLandscape()) {
            this$0.getBinding().recyclerView.setLayoutManager(new GridLayoutManager(this$0.getActivity(), 2));
        } else {
            this$0.getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(this$0.getActivity()));
        }
        this$0.getBinding().recyclerView.setAdapter(this$0.mAdapter);
        this$0.pageNo = 1;
        HonorViewModel honorViewModel2 = this$0.viewModel;
        if (honorViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            honorViewModel = honorViewModel2;
        }
        String classesId = SpData.getClassesId();
        Intrinsics.checkNotNullExpressionValue(classesId, "getClassesId()");
        honorViewModel.requestHonorClassList(classesId, this$0.pageSize, this$0.pageNo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(HonorListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isClass = false;
        this$0.getBinding().tvHonorStudent.setBackgroundResource(R.drawable.bg_comment_bt_40);
        this$0.getBinding().tvHonorStudent.setTextColor(this$0.getResources().getColor(R.color.white));
        HonorViewModel honorViewModel = null;
        this$0.getBinding().tvHonorClass.setBackground(null);
        this$0.getBinding().tvHonorClass.setTextColor(this$0.getResources().getColor(R.color.black16));
        if (ScreenUtils.isLandscape()) {
            this$0.getBinding().recyclerView.setLayoutManager(new GridLayoutManager(this$0.getActivity(), 2));
        } else {
            this$0.getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(this$0.getActivity()));
        }
        this$0.getBinding().recyclerView.setAdapter(this$0.mStudentAdapter);
        this$0.pageNo = 1;
        HonorViewModel honorViewModel2 = this$0.viewModel;
        if (honorViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            honorViewModel = honorViewModel2;
        }
        String classesId = SpData.getClassesId();
        Intrinsics.checkNotNullExpressionValue(classesId, "getClassesId()");
        honorViewModel.requestStudentHonorList(classesId, this$0.pageSize, this$0.pageNo);
        this$0.mStudentAdapter.setEmptyView(R.layout.layout_empty);
    }

    private final void requestList() {
        showProgressDialog();
        HonorViewModel honorViewModel = null;
        if (this.isClass) {
            HonorViewModel honorViewModel2 = this.viewModel;
            if (honorViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                honorViewModel = honorViewModel2;
            }
            String classesId = SpData.getClassesId();
            Intrinsics.checkNotNullExpressionValue(classesId, "getClassesId()");
            honorViewModel.requestHonorClassList(classesId, this.pageSize, this.pageNo);
            return;
        }
        HonorViewModel honorViewModel3 = this.viewModel;
        if (honorViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            honorViewModel = honorViewModel3;
        }
        String classesId2 = SpData.getClassesId();
        Intrinsics.checkNotNullExpressionValue(classesId2, "getClassesId()");
        honorViewModel.requestStudentHonorList(classesId2, this.pageSize, this.pageNo);
    }

    private final void initViewModel() {
        HonorViewModel honorViewModel = this.viewModel;
        HonorViewModel honorViewModel2 = null;
        if (honorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            honorViewModel = null;
        }
        SingleLiveEvent<Result<BasePageResponse<List<HonorClassBean>>>> honorClassListLiveData = honorViewModel.getHonorClassListLiveData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        final Function1<Result<? extends BasePageResponse<List<HonorClassBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<HonorClassBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorListFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<HonorClassBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<HonorClassBean>>> it2) {
                HonorListFragment.this.dismissProgressDialog();
                HonorListFragment.access$getBinding(HonorListFragment.this).tvUpPage.setEnabled(true);
                HonorListFragment.access$getBinding(HonorListFragment.this).tvNext.setEnabled(true);
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    BasePageResponse basePageResponse = (BasePageResponse) value;
                    HonorListFragment.this.total = basePageResponse != null ? Integer.valueOf(basePageResponse.getTotal()) : null;
                    if (basePageResponse != null) {
                        setList((Collection) basePageResponse.getList());
                        return;
                    }
                    return;
                }
                Result.m594exceptionOrNullimpl(it2.getValue());
            }
        };
        honorClassListLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorListFragment$fmPExqv_xGFDABSqSDsZCacMNh0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HonorListFragment.initViewModel$lambda$4(function1, obj);
            }
        });
        HonorViewModel honorViewModel3 = this.viewModel;
        if (honorViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            honorViewModel2 = honorViewModel3;
        }
        SingleLiveEvent<Result<BasePageResponse<List<HonorStudentBean>>>> honorStudentListLiveData = honorViewModel2.getHonorStudentListLiveData();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        final Function1<Result<? extends BasePageResponse<List<HonorStudentBean>>>, Unit> function2 = new Function1<Result<? extends BasePageResponse<List<HonorStudentBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorListFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<HonorStudentBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<HonorStudentBean>>> it2) {
                HonorListFragment.this.dismissProgressDialog();
                HonorListFragment.access$getBinding(HonorListFragment.this).tvUpPage.setEnabled(true);
                HonorListFragment.access$getBinding(HonorListFragment.this).tvNext.setEnabled(true);
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    BasePageResponse basePageResponse = (BasePageResponse) value;
                    HonorListFragment.this.total = basePageResponse != null ? Integer.valueOf(basePageResponse.getTotal()) : null;
                    if (basePageResponse != null) {
                        HonorListFragment.this.mStudentAdapter.setList((Collection) basePageResponse.getList());
                        return;
                    }
                    return;
                }
                Result.m594exceptionOrNullimpl(it2.getValue());
            }
        };
        honorStudentListLiveData.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorListFragment$p-jzr9eNry1ILGmoRKKJouiVk5I
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HonorListFragment.initViewModel$lambda$5(function2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: compiled from: HonorListFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorListFragment$ItemAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/honor/HonorItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "(Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorListFragment;)V", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ItemAdapter extends BaseQuickAdapter<HonorItemBean, BaseViewHolder> {
        public ItemAdapter() {
            super(R.layout.item_honor_medal, null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(BaseViewHolder holder, HonorItemBean item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            ItemHonorMedalBinding itemHonorMedalBindingBind = ItemHonorMedalBinding.bind(holder.itemView);
            Intrinsics.checkNotNullExpressionValue(itemHonorMedalBindingBind, "bind(holder.itemView)");
            GlideUtil.loadImage(getContext(), item.getMedalUrl(), itemHonorMedalBindingBind.ivCover);
        }
    }
}
