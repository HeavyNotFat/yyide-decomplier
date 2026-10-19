package com.yd.android_brand_mvp.landscape.task;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.HonorSingleFragmentBinding;
import com.yd.android_brand_mvp.model.honor.HonorKidsLIstBean;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
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

/* JADX INFO: compiled from: HonorSingleFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0005\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0003J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/task/HonorSingleFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/HonorSingleFragmentBinding;", "()V", "mAdapter", "com/yd/android_brand_mvp/landscape/task/HonorSingleFragment$mAdapter$1", "Lcom/yd/android_brand_mvp/landscape/task/HonorSingleFragment$mAdapter$1;", "pageNo", "", "pageSize", "viewModel", "Lcom/yd/android_brand_mvp/landscape/task/HonorSingleViewModel;", "initLoadMore", "", "initView", "initViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "requestList", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorSingleFragment extends KTBaseFragment<HonorSingleFragmentBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final HonorSingleFragment$mAdapter$1 mAdapter;
    private int pageNo;
    private final int pageSize;
    private HonorSingleViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.task.HonorSingleFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HonorSingleFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, HonorSingleFragmentBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, HonorSingleFragmentBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/HonorSingleFragmentBinding;", 0);
        }

        public final HonorSingleFragmentBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return HonorSingleFragmentBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ HonorSingleFragmentBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ HonorSingleFragmentBinding access$getBinding(HonorSingleFragment honorSingleFragment) {
        return honorSingleFragment.getBinding();
    }

    public HonorSingleFragment() {
        super(AnonymousClass1.INSTANCE);
        this.pageSize = 20;
        this.pageNo = 1;
        this.mAdapter = new HonorSingleFragment$mAdapter$1();
    }

    /* JADX INFO: compiled from: HonorSingleFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/task/HonorSingleFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/task/HonorSingleFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HonorSingleFragment newInstance() {
            return new HonorSingleFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (HonorSingleViewModel) new ViewModelProvider(this).get(HonorSingleViewModel.class);
        if (ScreenUtils.isLandscape()) {
            getBinding().group.setVisibility(0);
        } else {
            getBinding().group.setVisibility(0);
        }
        initView();
        initViewModel();
        requestList();
    }

    private final void initView() {
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        this.mAdapter.setEmptyView(R.layout.layout_empty);
        initLoadMore();
    }

    private final void initLoadMore() {
        this.mAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.yd.android_brand_mvp.landscape.task.-$$Lambda$HonorSingleFragment$ijcEMRku1UViHzBkhf40qLKS6xs
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                HonorSingleFragment.initLoadMore$lambda$0(this.f$0);
            }
        });
        this.mAdapter.getLoadMoreModule().setAutoLoadMore(true);
        this.mAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLoadMore$lambda$0(HonorSingleFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAdapter.getLoadMoreModule().setEnableLoadMore(true);
        this$0.pageNo++;
        this$0.requestList();
    }

    private final void requestList() {
        selectNewStudentByIcCardRsp selectnewstudentbyiccardrspUSERCENTINFO2 = SpData.USERCENTINFO2();
        HonorSingleViewModel honorSingleViewModel = this.viewModel;
        if (honorSingleViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            honorSingleViewModel = null;
        }
        honorSingleViewModel.requestKidsHonorList(selectnewstudentbyiccardrspUSERCENTINFO2.data.id, this.pageNo, this.pageSize);
    }

    private final void initViewModel() {
        HonorSingleViewModel honorSingleViewModel = this.viewModel;
        if (honorSingleViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            honorSingleViewModel = null;
        }
        SingleLiveEvent<Result<BasePageResponse<List<HonorKidsLIstBean>>>> kidsHonorListLiveData = honorSingleViewModel.getKidsHonorListLiveData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        final Function1<Result<? extends BasePageResponse<List<HonorKidsLIstBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<HonorKidsLIstBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.task.HonorSingleFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<HonorKidsLIstBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<HonorKidsLIstBean>>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    BasePageResponse basePageResponse = (BasePageResponse) value;
                    if ((basePageResponse != null ? (List) basePageResponse.getList() : null) != null) {
                        if (HonorSingleFragment.this.pageNo == 1) {
                            HonorSingleFragment.this.mAdapter.setList((Collection) basePageResponse.getList());
                        } else {
                            HonorSingleFragment.this.mAdapter.addData((Collection) basePageResponse.getList());
                        }
                        if (((List) basePageResponse.getList()).size() < HonorSingleFragment.this.pageSize) {
                            BaseLoadMoreModule.loadMoreEnd$default(HonorSingleFragment.this.mAdapter.getLoadMoreModule(), false, 1, null);
                        } else {
                            HonorSingleFragment.this.mAdapter.getLoadMoreModule().loadMoreComplete();
                        }
                    }
                    TextView textView = HonorSingleFragment.access$getBinding(HonorSingleFragment.this).tvNumber;
                    HonorSingleFragment honorSingleFragment = HonorSingleFragment.this;
                    Object[] objArr = new Object[1];
                    objArr[0] = String.valueOf(basePageResponse != null ? Integer.valueOf(basePageResponse.getTotal()) : null);
                    textView.setText(Html.fromHtml(honorSingleFragment.getString(R.string.honor_kids, objArr)));
                }
            }
        };
        kidsHonorListLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.task.-$$Lambda$HonorSingleFragment$JUdOSBDd7aZueJoxPfDi7f7sdPs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HonorSingleFragment.initViewModel$lambda$1(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
