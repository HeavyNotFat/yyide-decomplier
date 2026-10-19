package com.yd.android_brand_mvp.landscape.honor;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.honor.HonorListActivity;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.HonorCartoonFragmentBinding;
import com.yd.android_brand_mvp.databinding.ItemHonorClassBinding;
import com.yd.android_brand_mvp.model.honor.HonorClassBean;
import com.yd.android_brand_mvp.model.honor.HonorStudentBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SpData;
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

/* JADX INFO: compiled from: HonorCartoonFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\u0005\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/honor/HonorCartoonFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/HonorCartoonFragmentBinding;", "()V", "mAdapter", "com/yd/android_brand_mvp/landscape/honor/HonorCartoonFragment$mAdapter$1", "Lcom/yd/android_brand_mvp/landscape/honor/HonorCartoonFragment$mAdapter$1;", "mStudentAdapter", "com/yd/android_brand_mvp/landscape/honor/HonorCartoonFragment$mStudentAdapter$1", "Lcom/yd/android_brand_mvp/landscape/honor/HonorCartoonFragment$mStudentAdapter$1;", "pageNo", "", "pageSize", "viewModel", "Lcom/yd/android_brand_mvp/landscape/honor/HonorViewModel;", "initView", "", "initViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorCartoonFragment extends KTBaseFragment<HonorCartoonFragmentBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TYPE = "type";
    private final HonorCartoonFragment$mAdapter$1 mAdapter;
    private final HonorCartoonFragment$mStudentAdapter$1 mStudentAdapter;
    private final int pageNo;
    private final int pageSize;
    private HonorViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.honor.HonorCartoonFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HonorCartoonFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, HonorCartoonFragmentBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, HonorCartoonFragmentBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/HonorCartoonFragmentBinding;", 0);
        }

        public final HonorCartoonFragmentBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return HonorCartoonFragmentBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ HonorCartoonFragmentBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.yd.android_brand_mvp.landscape.honor.HonorCartoonFragment$mAdapter$1] */
    public HonorCartoonFragment() {
        super(AnonymousClass1.INSTANCE);
        this.pageSize = 3;
        this.pageNo = 1;
        this.mStudentAdapter = new HonorCartoonFragment$mStudentAdapter$1();
        this.mAdapter = new BaseQuickAdapter<HonorClassBean, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.honor.HonorCartoonFragment$mAdapter$1
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

    /* JADX INFO: compiled from: HonorCartoonFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/honor/HonorCartoonFragment$Companion;", "", "()V", "TYPE", "", "newInstance", "Lcom/yd/android_brand_mvp/landscape/honor/HonorCartoonFragment;", "type", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HonorCartoonFragment newInstance(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            HonorCartoonFragment honorCartoonFragment = new HonorCartoonFragment();
            Bundle bundle = new Bundle();
            bundle.putString(HonorCartoonFragment.TYPE, type);
            honorCartoonFragment.setArguments(bundle);
            return honorCartoonFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (HonorViewModel) new ViewModelProvider(this).get(HonorViewModel.class);
        initView();
    }

    private final void initView() {
        getBinding().tvHonorClass.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.honor.-$$Lambda$HonorCartoonFragment$TRVyRmDxEUeLOskUicq43CnYp2w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HonorCartoonFragment.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().tvHonorStudent.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.honor.-$$Lambda$HonorCartoonFragment$7sLzfSdQvTVzYhhm27TMg8Xz3Q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HonorCartoonFragment.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        setEmptyView(R.layout.layout_empty);
        setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.honor.-$$Lambda$HonorCartoonFragment$S5YHPdtjXkveqyIdkt3hgo4OgJQ
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                HonorCartoonFragment.initView$lambda$2(this.f$0, baseQuickAdapter, view, i);
            }
        });
        getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.honor.-$$Lambda$HonorCartoonFragment$xnYj2GJNIc2PznKfnWxZdLakz6w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HonorCartoonFragment.initView$lambda$3(this.f$0, view);
            }
        });
        initViewModel();
        if (SpData.NewUser().data == null || TextUtils.isEmpty(SpData.getClassesId())) {
            return;
        }
        HonorViewModel honorViewModel = this.viewModel;
        if (honorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            honorViewModel = null;
        }
        String classesId = SpData.getClassesId();
        Intrinsics.checkNotNullExpressionValue(classesId, "getClassesId()");
        honorViewModel.requestHonorClassList(classesId, this.pageSize, this.pageNo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(HonorCartoonFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HonorViewModel honorViewModel = null;
        this$0.getBinding().tvHonorStudent.setBackground(null);
        this$0.getBinding().tvHonorStudent.setTextColor(this$0.getResources().getColor(R.color.black16));
        this$0.getBinding().tvHonorClass.setBackground(this$0.getResources().getDrawable(R.drawable.icon_cardoon_honor));
        this$0.getBinding().tvHonorClass.setTextColor(this$0.getResources().getColor(R.color.white));
        this$0.getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(this$0.getActivity()));
        this$0.getBinding().recyclerView.setAdapter(this$0.mAdapter);
        if (SpData.NewUser().data == null || TextUtils.isEmpty(SpData.getClassesId())) {
            return;
        }
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
    public static final void initView$lambda$1(HonorCartoonFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().tvHonorStudent.setBackground(this$0.getResources().getDrawable(R.drawable.icon_cardoon_honor));
        this$0.getBinding().tvHonorStudent.setTextColor(this$0.getResources().getColor(R.color.white));
        HonorViewModel honorViewModel = null;
        this$0.getBinding().tvHonorClass.setBackground(null);
        this$0.getBinding().tvHonorClass.setTextColor(this$0.getResources().getColor(R.color.black16));
        this$0.getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(this$0.getActivity()));
        this$0.getBinding().recyclerView.setAdapter(this$0.mStudentAdapter);
        this$0.mStudentAdapter.setEmptyView(R.layout.layout_empty);
        if (SpData.NewUser().data == null || TextUtils.isEmpty(SpData.getClassesId())) {
            return;
        }
        HonorViewModel honorViewModel2 = this$0.viewModel;
        if (honorViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            honorViewModel = honorViewModel2;
        }
        String classesId = SpData.getClassesId();
        Intrinsics.checkNotNullExpressionValue(classesId, "getClassesId()");
        honorViewModel.requestStudentHonorList(classesId, this$0.pageSize, this$0.pageNo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(HonorCartoonFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.goPermissionsActivity(new Intent(this$0.getActivity(), (Class<?>) HonorListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(HonorCartoonFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.goPermissionsActivity(new Intent(this$0.getActivity(), (Class<?>) HonorListActivity.class));
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
        final Function1<Result<? extends BasePageResponse<List<HonorClassBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<HonorClassBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.honor.HonorCartoonFragment.initViewModel.1
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
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    BasePageResponse basePageResponse = (BasePageResponse) value;
                    if (basePageResponse != null) {
                        setList((Collection) basePageResponse.getList());
                        return;
                    }
                    return;
                }
                Result.m594exceptionOrNullimpl(it2.getValue());
            }
        };
        honorClassListLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.honor.-$$Lambda$HonorCartoonFragment$9z38VEdHJ8HmSmftAZ4TvTqGnnk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HonorCartoonFragment.initViewModel$lambda$4(function1, obj);
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
        final Function1<Result<? extends BasePageResponse<List<HonorStudentBean>>>, Unit> function2 = new Function1<Result<? extends BasePageResponse<List<HonorStudentBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.honor.HonorCartoonFragment.initViewModel.2
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
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    BasePageResponse basePageResponse = (BasePageResponse) value;
                    if (basePageResponse != null) {
                        HonorCartoonFragment.this.mStudentAdapter.setList((Collection) basePageResponse.getList());
                        return;
                    }
                    return;
                }
                Result.m594exceptionOrNullimpl(it2.getValue());
            }
        };
        honorStudentListLiveData.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.honor.-$$Lambda$HonorCartoonFragment$veQi6j8YGVGNUQAeQ8UJxCTKeng
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HonorCartoonFragment.initViewModel$lambda$5(function2, obj);
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
}
