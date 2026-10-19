package com.yd.android_brand_mvp.user.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.userspace.LeaveRecordAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentRecyclerViewBinding;
import com.yd.android_brand_mvp.dialog.FormDetailDialog;
import com.yd.android_brand_mvp.dialog.LeaveFlowDialog;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.listener.StringListener;
import com.yd.android_brand_mvp.model.ApproverInfoRsp;
import com.yd.android_brand_mvp.model.userspace.LeaveDetailBean;
import com.yd.android_brand_mvp.model.userspace.LeaveRecordBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.user.viewmodel.LeaveRecordViewModel;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
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
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: StudentLeaveRecordFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\u001a\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/yd/android_brand_mvp/user/fragment/StudentLeaveRecordFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentRecyclerViewBinding;", "()V", "current", "", "dialog", "Lcom/yd/android_brand_mvp/dialog/FormDetailDialog;", "oldDialog", "Lcom/yd/android_brand_mvp/dialog/LeaveFlowDialog;", "recordAdapter", "Lcom/yd/android_brand_mvp/adapter/userspace/LeaveRecordAdapter;", "getRecordAdapter", "()Lcom/yd/android_brand_mvp/adapter/userspace/LeaveRecordAdapter;", "recordAdapter$delegate", "Lkotlin/Lazy;", InnerConstant.Db.size, CommentsHomeFragment.TYPE_ID, "", "studentName", "viewModel", "Lcom/yd/android_brand_mvp/user/viewmodel/LeaveRecordViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/user/viewmodel/LeaveRecordViewModel;", "viewModel$delegate", "initView", "", "onDestroyView", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "requestListData", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StudentLeaveRecordFragment extends KTBaseFragment<FragmentRecyclerViewBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int current;
    private FormDetailDialog dialog;
    private LeaveFlowDialog oldDialog;

    /* JADX INFO: renamed from: recordAdapter$delegate, reason: from kotlin metadata */
    private final Lazy recordAdapter;
    private final int size;
    private String studentId;
    private String studentName;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.user.fragment.StudentLeaveRecordFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: StudentLeaveRecordFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentRecyclerViewBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentRecyclerViewBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentRecyclerViewBinding;", 0);
        }

        public final FragmentRecyclerViewBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentRecyclerViewBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentRecyclerViewBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentRecyclerViewBinding access$getBinding(StudentLeaveRecordFragment studentLeaveRecordFragment) {
        return studentLeaveRecordFragment.getBinding();
    }

    public StudentLeaveRecordFragment() {
        super(AnonymousClass1.INSTANCE);
        this.recordAdapter = LazyKt.lazy(new Function0<LeaveRecordAdapter>() { // from class: com.yd.android_brand_mvp.user.fragment.StudentLeaveRecordFragment$recordAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LeaveRecordAdapter invoke() {
                return new LeaveRecordAdapter();
            }
        });
        final StudentLeaveRecordFragment studentLeaveRecordFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.user.fragment.StudentLeaveRecordFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return studentLeaveRecordFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.user.fragment.StudentLeaveRecordFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(studentLeaveRecordFragment, Reflection.getOrCreateKotlinClass(LeaveRecordViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.user.fragment.StudentLeaveRecordFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.user.fragment.StudentLeaveRecordFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.user.fragment.StudentLeaveRecordFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = studentLeaveRecordFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.size = 20;
        this.current = 1;
        this.studentId = "-1";
        this.studentName = "";
    }

    /* JADX INFO: compiled from: StudentLeaveRecordFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/user/fragment/StudentLeaveRecordFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/user/fragment/StudentLeaveRecordFragment;", "id", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StudentLeaveRecordFragment newInstance(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, name);
            StudentLeaveRecordFragment studentLeaveRecordFragment = new StudentLeaveRecordFragment();
            studentLeaveRecordFragment.setArguments(bundle);
            return studentLeaveRecordFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LeaveRecordAdapter getRecordAdapter() {
        return (LeaveRecordAdapter) this.recordAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LeaveRecordViewModel getViewModel() {
        return (LeaveRecordViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requestListData();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("id") : null;
        if (string == null) {
            string = "-1";
        }
        this.studentId = string;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME) : null;
        if (string2 == null) {
            string2 = "";
        }
        this.studentName = string2;
        getBinding().rvFragmentContent.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().rvFragmentContent.setAdapter(getRecordAdapter());
        getBinding().rvFragmentContent.setBackgroundColor(SimpleUtilsKt.asColor(R.color.white));
        getRecordAdapter().setEmptyView(R.layout.item_null_layout_4);
        getRecordAdapter().getLoadMoreModule().setAutoLoadMore(true);
        getRecordAdapter().getLoadMoreModule().setEnableLoadMoreIfNotFullPage(true);
        getRecordAdapter().getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentLeaveRecordFragment$9Stui0uau-Z9SBza2uqSsKP379Y
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                StudentLeaveRecordFragment.initView$lambda$0(this.f$0);
            }
        });
        getRecordAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentLeaveRecordFragment$EX1BaLipiYhILVtpuEC-2-k1hmA
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                StudentLeaveRecordFragment.initView$lambda$1(this.f$0, baseQuickAdapter, view, i);
            }
        });
        getBinding().srlRecycler.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentLeaveRecordFragment$OisBOoQ-XGtZKJ4vyc_Vlvs5iBg
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                StudentLeaveRecordFragment.initView$lambda$2(this.f$0);
            }
        });
        LiveData<Result<BasePageResponse<List<LeaveRecordBean>>>> leaveRecord = getViewModel().getLeaveRecord();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends BasePageResponse<List<? extends LeaveRecordBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<? extends LeaveRecordBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.user.fragment.StudentLeaveRecordFragment.initView.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<? extends LeaveRecordBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<? extends LeaveRecordBean>>> it2) {
                StudentLeaveRecordFragment.this.dismissProgressDialog();
                StudentLeaveRecordFragment.access$getBinding(StudentLeaveRecordFragment.this).srlRecycler.setRefreshing(false);
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                BasePageResponse basePageResponse = (BasePageResponse) value;
                if (basePageResponse == null) {
                    return;
                }
                if (basePageResponse.getList() == null) {
                    BaseLoadMoreModule.loadMoreEnd$default(StudentLeaveRecordFragment.this.getRecordAdapter().getLoadMoreModule(), false, 1, null);
                    return;
                }
                if (StudentLeaveRecordFragment.this.current == 1) {
                    StudentLeaveRecordFragment.this.getRecordAdapter().setList((Collection) basePageResponse.getList());
                } else {
                    StudentLeaveRecordFragment.this.getRecordAdapter().addData((Collection) basePageResponse.getList());
                }
                if (((List) basePageResponse.getList()).size() < StudentLeaveRecordFragment.this.size) {
                    BaseLoadMoreModule.loadMoreEnd$default(StudentLeaveRecordFragment.this.getRecordAdapter().getLoadMoreModule(), false, 1, null);
                } else {
                    StudentLeaveRecordFragment.this.getRecordAdapter().getLoadMoreModule().loadMoreComplete();
                }
            }
        };
        leaveRecord.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentLeaveRecordFragment$rd7ZjwKhcYwPmaKSxgLrrIYMTjQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StudentLeaveRecordFragment.initView$lambda$3(function1, obj);
            }
        });
        LiveData<Result<LeaveDetailBean>> leaveDetail = getViewModel().getLeaveDetail();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final AnonymousClass5 anonymousClass5 = new AnonymousClass5();
        leaveDetail.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentLeaveRecordFragment$a893iV140eGfK3tDp9zfJyB_63A
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StudentLeaveRecordFragment.initView$lambda$4(anonymousClass5, obj);
            }
        });
        LiveData<Result<ApproverInfoRsp.DataDTO>> oldLeaveDetail = getViewModel().getOldLeaveDetail();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final AnonymousClass6 anonymousClass6 = new AnonymousClass6();
        oldLeaveDetail.observe(viewLifecycleOwner3, new Observer() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentLeaveRecordFragment$B4RSUEMTn1kZ5ryHIseZGoz93P0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StudentLeaveRecordFragment.initView$lambda$5(anonymousClass6, obj);
            }
        });
        LiveData<Result<Boolean>> revokeResult = getViewModel().getRevokeResult();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<Result<? extends Boolean>, Unit> function2 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.user.fragment.StudentLeaveRecordFragment.initView.7
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
                StudentLeaveRecordFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                Boolean bool = (Boolean) value;
                if (bool == null || !bool.booleanValue()) {
                    return;
                }
                FormDetailDialog formDetailDialog = StudentLeaveRecordFragment.this.dialog;
                if (formDetailDialog != null) {
                    formDetailDialog.dismiss();
                }
                ToastUtil.showBottomView(StudentLeaveRecordFragment.this.requireContext(), "已撤销");
                StudentLeaveRecordFragment.this.requestListData();
            }
        };
        revokeResult.observe(viewLifecycleOwner4, new Observer() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentLeaveRecordFragment$Ji97orG6i8anF2L86xozPLqd06o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StudentLeaveRecordFragment.initView$lambda$6(function2, obj);
            }
        });
        LiveData<Result<String>> oldRevokeResult = getViewModel().getOldRevokeResult();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        final Function1<Result<? extends String>, Unit> function3 = new Function1<Result<? extends String>, Unit>() { // from class: com.yd.android_brand_mvp.user.fragment.StudentLeaveRecordFragment.initView.8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends String> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends String> it2) {
                StudentLeaveRecordFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                if (((String) value) == null) {
                    return;
                }
                LeaveFlowDialog leaveFlowDialog = StudentLeaveRecordFragment.this.oldDialog;
                if (leaveFlowDialog != null) {
                    leaveFlowDialog.dismiss();
                }
                ToastUtil.showBottomView(StudentLeaveRecordFragment.this.requireContext(), "已撤销");
                StudentLeaveRecordFragment.this.requestListData();
            }
        };
        oldRevokeResult.observe(viewLifecycleOwner5, new Observer() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentLeaveRecordFragment$hAoG8QGOpKv4L3fardjXP85xtXw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StudentLeaveRecordFragment.initView$lambda$7(function3, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(StudentLeaveRecordFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.current++;
        this$0.getViewModel().getLeaveRecord(this$0.studentId, this$0.studentName, this$0.current, this$0.size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(StudentLeaveRecordFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        LeaveRecordBean leaveRecordBean = this$0.getRecordAdapter().getData().get(i);
        if (Intrinsics.areEqual(leaveRecordBean.getType(), "1")) {
            this$0.showProgressDialog();
            this$0.getViewModel().getOldLeaveDetail(leaveRecordBean.getId());
        } else {
            this$0.showProgressDialog();
            this$0.getViewModel().getLeaveDetail(leaveRecordBean.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(StudentLeaveRecordFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.current = 1;
        this$0.getViewModel().getLeaveRecord(this$0.studentId, this$0.studentName, this$0.current, this$0.size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.user.fragment.StudentLeaveRecordFragment$initView$5, reason: invalid class name */
    /* JADX INFO: compiled from: StudentLeaveRecordFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/userspace/LeaveDetailBean;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass5 extends Lambda implements Function1<Result<? extends LeaveDetailBean>, Unit> {
        AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Result<? extends LeaveDetailBean> result) {
            invoke2(result);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Result<? extends LeaveDetailBean> it2) {
            StudentLeaveRecordFragment.this.dismissProgressDialog();
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            Object value = it2.getValue();
            if (Result.m597isFailureimpl(value)) {
                value = null;
            }
            final LeaveDetailBean leaveDetailBean = (LeaveDetailBean) value;
            if (leaveDetailBean == null) {
                return;
            }
            StudentLeaveRecordFragment.this.dialog = new FormDetailDialog("请假", leaveDetailBean, false);
            FormDetailDialog formDetailDialog = StudentLeaveRecordFragment.this.dialog;
            Intrinsics.checkNotNull(formDetailDialog);
            final StudentLeaveRecordFragment studentLeaveRecordFragment = StudentLeaveRecordFragment.this;
            formDetailDialog.setCallBack(new StringListener() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentLeaveRecordFragment$initView$5$H32vt5vjIghbEyBo4Gy0Vm3hSs8
                @Override // com.yd.android_brand_mvp.listener.StringListener
                public final void getStringData(String str) {
                    StudentLeaveRecordFragment.AnonymousClass5.invoke$lambda$0(studentLeaveRecordFragment, leaveDetailBean, str);
                }
            });
            FormDetailDialog formDetailDialog2 = StudentLeaveRecordFragment.this.dialog;
            Intrinsics.checkNotNull(formDetailDialog2);
            formDetailDialog2.show(StudentLeaveRecordFragment.this.getChildFragmentManager(), "leaveDetail");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(StudentLeaveRecordFragment this$0, LeaveDetailBean info, String it2) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(info, "$info");
            Intrinsics.checkNotNullParameter(it2, "it");
            if (Intrinsics.areEqual(it2, "dismiss")) {
                return;
            }
            this$0.showProgressDialog();
            LeaveRecordViewModel viewModel = this$0.getViewModel();
            String procInstId = info.getProcInstId();
            String schoolId = SpData.getSchoolId();
            Intrinsics.checkNotNullExpressionValue(schoolId, "getSchoolId()");
            LeaveRecordViewModel.revokeLeave$default(viewModel, procInstId, schoolId, this$0.studentId, 0, this$0.studentName, null, 32, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.user.fragment.StudentLeaveRecordFragment$initView$6, reason: invalid class name */
    /* JADX INFO: compiled from: StudentLeaveRecordFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/ApproverInfoRsp$DataDTO;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass6 extends Lambda implements Function1<Result<? extends ApproverInfoRsp.DataDTO>, Unit> {
        AnonymousClass6() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Result<? extends ApproverInfoRsp.DataDTO> result) {
            invoke2(result);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Result<? extends ApproverInfoRsp.DataDTO> it2) {
            StudentLeaveRecordFragment.this.dismissProgressDialog();
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            Object value = it2.getValue();
            if (Result.m597isFailureimpl(value)) {
                value = null;
            }
            ApproverInfoRsp.DataDTO dataDTO = (ApproverInfoRsp.DataDTO) value;
            if (dataDTO == null) {
                return;
            }
            StudentLeaveRecordFragment.this.oldDialog = new LeaveFlowDialog(StudentLeaveRecordFragment.this.requireContext(), dataDTO);
            LeaveFlowDialog leaveFlowDialog = StudentLeaveRecordFragment.this.oldDialog;
            Intrinsics.checkNotNull(leaveFlowDialog);
            final StudentLeaveRecordFragment studentLeaveRecordFragment = StudentLeaveRecordFragment.this;
            leaveFlowDialog.setCancelLeaveListener(new LeaveFlowDialog.CancelLeaveListener() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentLeaveRecordFragment$initView$6$M9n5qJKIlWmiZFDz1458AoJ0Frw
                @Override // com.yd.android_brand_mvp.dialog.LeaveFlowDialog.CancelLeaveListener
                public final void setCancelLeave(String str) {
                    StudentLeaveRecordFragment.AnonymousClass6.invoke$lambda$0(studentLeaveRecordFragment, str);
                }
            });
            LeaveFlowDialog leaveFlowDialog2 = StudentLeaveRecordFragment.this.oldDialog;
            Intrinsics.checkNotNull(leaveFlowDialog2);
            leaveFlowDialog2.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(StudentLeaveRecordFragment this$0, String id) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            LeaveRecordViewModel viewModel = this$0.getViewModel();
            Intrinsics.checkNotNullExpressionValue(id, "id");
            viewModel.oldRevokeLeave(id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestListData() {
        showProgressDialog();
        getViewModel().getLeaveRecord(this.studentId, this.studentName, this.current, this.size);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        LeaveFlowDialog leaveFlowDialog = this.oldDialog;
        if (leaveFlowDialog != null) {
            Intrinsics.checkNotNull(leaveFlowDialog);
            leaveFlowDialog.dismiss();
        }
    }
}
