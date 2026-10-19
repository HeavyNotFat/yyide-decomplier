package com.yd.android_brand_mvp.activity.repair;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
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
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.google.gson.reflect.TypeToken;
import com.q_zheng.wifi.AccessPoint;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.collect.fragment.BaseCollectFragment;
import com.yd.android_brand_mvp.activity.repair.viewmodel.RepairViewModel;
import com.yd.android_brand_mvp.adapter.common.FlowAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentLaunchRepairBinding;
import com.yd.android_brand_mvp.dialog.reservation.userspace.SelectLeavePeopleDialog;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.FormVerifyBean;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.collect.UserVerifyBean;
import com.yd.android_brand_mvp.model.userspace.FlowElementListItem;
import com.yd.android_brand_mvp.model.userspace.LeaveFormBean;
import com.yd.android_brand_mvp.model.userspace.LeaveProcessBean;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.form.FormComponentUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
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

/* JADX INFO: compiled from: LaunchRepairFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u001a\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&H\u0007J\b\u0010'\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020\bH\u0002J\b\u0010)\u001a\u00020\u001eH\u0002J\u0018\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a¨\u0006."}, d2 = {"Lcom/yd/android_brand_mvp/activity/repair/LaunchRepairFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentLaunchRepairBinding;", "()V", "componentDataList", "", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "formContent", "", "formKey", "idPrefix", "", "isModify", "", "kitDataList", "modifyFormId", "processAdapter", "Lcom/yd/android_brand_mvp/adapter/common/FlowAdapter;", "processView", "Landroid/view/View;", "reason", "verifyBean", "Lcom/yd/android_brand_mvp/model/collect/UserVerifyBean;", "viewModel", "Lcom/yd/android_brand_mvp/activity/repair/viewmodel/RepairViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/repair/viewmodel/RepairViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "onDestroyView", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "parseData", "data", "Lcom/yd/android_brand_mvp/model/FormVerifyBean;", "parseFormUI", "parseSubmitJsonData", "request", "requestProcess", "key", "jsonContent", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LaunchRepairFragment extends KTBaseFragment<FragmentLaunchRepairBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<FormBaseBean> componentDataList;
    private String formContent;
    private String formKey;
    private final int idPrefix;
    private boolean isModify;
    private final List<FormBaseBean> kitDataList;
    private String modifyFormId;
    private final FlowAdapter processAdapter;
    private View processView;
    private String reason;
    private UserVerifyBean verifyBean;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.repair.LaunchRepairFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: LaunchRepairFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentLaunchRepairBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentLaunchRepairBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentLaunchRepairBinding;", 0);
        }

        public final FragmentLaunchRepairBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentLaunchRepairBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentLaunchRepairBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentLaunchRepairBinding access$getBinding(LaunchRepairFragment launchRepairFragment) {
        return launchRepairFragment.getBinding();
    }

    public LaunchRepairFragment() {
        super(AnonymousClass1.INSTANCE);
        this.componentDataList = new ArrayList();
        this.kitDataList = new ArrayList();
        this.processAdapter = new FlowAdapter();
        this.formKey = "-1";
        final LaunchRepairFragment launchRepairFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.repair.LaunchRepairFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return launchRepairFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.repair.LaunchRepairFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(launchRepairFragment, Reflection.getOrCreateKotlinClass(RepairViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.repair.LaunchRepairFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.repair.LaunchRepairFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.repair.LaunchRepairFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = launchRepairFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.idPrefix = AccessPoint.LOWER_FREQ_24GHZ;
        this.formContent = "";
        this.reason = "";
        this.modifyFormId = "";
    }

    /* JADX INFO: compiled from: LaunchRepairFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/activity/repair/LaunchRepairFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/repair/LaunchRepairFragment;", "data", "Lcom/yd/android_brand_mvp/model/collect/UserVerifyBean;", "formContent", "", "formKeyStr", "modifyReason", "modifyFormId", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LaunchRepairFragment newInstance(UserVerifyBean data) {
            Intrinsics.checkNotNullParameter(data, "data");
            Bundle bundle = new Bundle();
            LaunchRepairFragment launchRepairFragment = new LaunchRepairFragment();
            bundle.putParcelable("verifyData", data);
            launchRepairFragment.setArguments(bundle);
            return launchRepairFragment;
        }

        public final LaunchRepairFragment newInstance(UserVerifyBean data, String formContent, String formKeyStr, String modifyReason, String modifyFormId) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(formContent, "formContent");
            Intrinsics.checkNotNullParameter(formKeyStr, "formKeyStr");
            Intrinsics.checkNotNullParameter(modifyReason, "modifyReason");
            Intrinsics.checkNotNullParameter(modifyFormId, "modifyFormId");
            Bundle bundle = new Bundle();
            bundle.putParcelable("verifyData", data);
            bundle.putString("formContent", formContent);
            bundle.putString("formKey", formKeyStr);
            bundle.putString("reason", modifyReason);
            bundle.putString("formId", modifyFormId);
            bundle.putBoolean("isModify", true);
            LaunchRepairFragment launchRepairFragment = new LaunchRepairFragment();
            launchRepairFragment.setArguments(bundle);
            return launchRepairFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RepairViewModel getViewModel() {
        return (RepairViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        initView();
        if (!this.isModify) {
            request();
        } else {
            parseFormUI();
        }
    }

    private final void initView() {
        UserVerifyBean userVerifyBean;
        Bundle arguments = getArguments();
        if (arguments == null || (userVerifyBean = (UserVerifyBean) arguments.getParcelable("verifyData")) == null) {
            userVerifyBean = new UserVerifyBean(false, null, null, null, 15, null);
        }
        this.verifyBean = userVerifyBean;
        Bundle arguments2 = getArguments();
        View view = null;
        String string = arguments2 != null ? arguments2.getString("formContent") : null;
        if (string == null) {
            string = "";
        }
        this.formContent = string;
        Bundle arguments3 = getArguments();
        String string2 = arguments3 != null ? arguments3.getString("formKey") : null;
        if (string2 == null) {
            string2 = "";
        }
        this.formKey = string2;
        Bundle arguments4 = getArguments();
        String string3 = arguments4 != null ? arguments4.getString("reason") : null;
        if (string3 == null) {
            string3 = "";
        }
        this.reason = string3;
        Bundle arguments5 = getArguments();
        this.isModify = arguments5 != null ? arguments5.getBoolean("isModify") : false;
        Bundle arguments6 = getArguments();
        String string4 = arguments6 != null ? arguments6.getString("formId") : null;
        this.modifyFormId = string4 != null ? string4 : "";
        View viewInflate = LayoutInflater.from(requireContext()).inflate(R.layout.view_leave_process, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(requireContext()).i…view_leave_process, null)");
        this.processView = viewInflate;
        if (viewInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processView");
        } else {
            view = viewInflate;
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_view_leave_process);
        this.processAdapter.addChildClickViewIds(R.id.iv_item_user_leave_node_add);
        this.processAdapter.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$LaunchRepairFragment$0QeYPdtu46xfO449kOUXTARx6ms
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                LaunchRepairFragment.initView$lambda$1(this.f$0, baseQuickAdapter, view2, i);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.processAdapter);
        getBinding().llFragmentStudentApplyLeave.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$LaunchRepairFragment$93w7CXciJYm9k8iLhB3DOjiB_fo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LaunchRepairFragment.initView$lambda$2(this.f$0, view2);
            }
        });
        getBinding().btnFragmentStudentApplyLeave.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$LaunchRepairFragment$OKkv2YaletcfeKdCX6z_MAO8qus
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LaunchRepairFragment.initView$lambda$3(this.f$0, view2);
            }
        });
        LiveData<Result<LeaveFormBean>> studentLeaveForm = getViewModel().getStudentLeaveForm();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends LeaveFormBean>, Unit> function1 = new Function1<Result<? extends LeaveFormBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.repair.LaunchRepairFragment.initView.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends LeaveFormBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends LeaveFormBean> it2) {
                List list;
                boolean z;
                String userId;
                LaunchRepairFragment.this.dismissProgressDialog();
                LaunchRepairFragment.this.getViewModel().getComponentFragmentList().clear();
                LaunchRepairFragment.access$getBinding(LaunchRepairFragment.this).llFragmentStudentApplyLeave.removeAllViews();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                View view2 = null;
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                LeaveFormBean leaveFormBean = (LeaveFormBean) value;
                if (leaveFormBean == null || (list = (List) GsonUtils.fromJson(leaveFormBean.getFormItems(), new TypeToken<List<? extends FormBaseBean>>() { // from class: com.yd.android_brand_mvp.activity.repair.LaunchRepairFragment$initView$4$formItemList$1
                }.getType())) == null) {
                    return;
                }
                LaunchRepairFragment.this.formKey = leaveFormBean.getFromKey();
                LaunchRepairFragment.this.componentDataList.clear();
                LaunchRepairFragment launchRepairFragment = LaunchRepairFragment.this;
                Iterator it3 = list.iterator();
                while (true) {
                    z = true;
                    if (!it3.hasNext()) {
                        break;
                    }
                    FormBaseBean formBaseBean = (FormBaseBean) it3.next();
                    if (formBaseBean.isKit()) {
                        launchRepairFragment.kitDataList.add(formBaseBean);
                        for (FormBaseBean formBaseBean2 : formBaseBean.getChildren()) {
                            formBaseBean2.setKit(true);
                            formBaseBean2.setKitId(formBaseBean.getId());
                        }
                        launchRepairFragment.componentDataList.addAll(formBaseBean.getChildren());
                    } else {
                        launchRepairFragment.componentDataList.add(formBaseBean);
                    }
                }
                if (!LaunchRepairFragment.this.componentDataList.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    FragmentTransaction fragmentTransactionBeginTransaction = LaunchRepairFragment.this.getChildFragmentManager().beginTransaction();
                    Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "childFragmentManager.beginTransaction()");
                    List list2 = LaunchRepairFragment.this.componentDataList;
                    LaunchRepairFragment launchRepairFragment2 = LaunchRepairFragment.this;
                    int i = 0;
                    for (Object obj : list2) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        FormBaseBean formBaseBean3 = (FormBaseBean) obj;
                        if (formBaseBean3.getProps().getRequired() && !Intrinsics.areEqual(formBaseBean3.getName(), FormComponentUtil.MultipleCascader)) {
                            z = false;
                        }
                        formBaseBean3.setSort(i);
                        formBaseBean3.setSortNum(i2);
                        FormComponentUtil formComponentUtil = FormComponentUtil.INSTANCE;
                        UserVerifyBean userVerifyBean2 = launchRepairFragment2.verifyBean;
                        if (userVerifyBean2 == null || (userId = userVerifyBean2.getUserId()) == null) {
                            userId = "";
                        }
                        Fragment componentFragment = formComponentUtil.getComponentFragment(formBaseBean3, userId);
                        if (componentFragment != null) {
                            FrameLayout frameLayout = new FrameLayout(launchRepairFragment2.requireContext());
                            frameLayout.setId(launchRepairFragment2.idPrefix + i);
                            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                            fragmentTransactionBeginTransaction.replace(frameLayout.getId(), componentFragment);
                            arrayList.add(formBaseBean3);
                            LaunchRepairFragment.access$getBinding(launchRepairFragment2).llFragmentStudentApplyLeave.addView(frameLayout);
                            launchRepairFragment2.getViewModel().getComponentFragmentList().add(componentFragment);
                        }
                        i = i2;
                    }
                    fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                }
                LinearLayout linearLayout = LaunchRepairFragment.access$getBinding(LaunchRepairFragment.this).llFragmentStudentApplyLeave;
                View view3 = LaunchRepairFragment.this.processView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("processView");
                } else {
                    view2 = view3;
                }
                linearLayout.addView(view2);
                if (z) {
                    LaunchRepairFragment.this.requestProcess(leaveFormBean.getFromKey(), leaveFormBean.getFormItems());
                }
            }
        };
        studentLeaveForm.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$LaunchRepairFragment$49BZ0gO8QmC2rVLquSN2_ku99Oo
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LaunchRepairFragment.initView$lambda$4(function1, obj);
            }
        });
        LiveData<Result<LeaveProcessBean>> studentLeaveProcess = getViewModel().getStudentLeaveProcess();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends LeaveProcessBean>, Unit> function2 = new Function1<Result<? extends LeaveProcessBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.repair.LaunchRepairFragment.initView.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends LeaveProcessBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends LeaveProcessBean> it2) {
                LaunchRepairFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                LeaveProcessBean leaveProcessBean = (LeaveProcessBean) value;
                if (leaveProcessBean == null) {
                    return;
                }
                LaunchRepairFragment.this.processAdapter.setList(leaveProcessBean.getFlowElementList());
            }
        };
        studentLeaveProcess.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$LaunchRepairFragment$gbLCwbQseP8rttMrHr7fb1lPXqY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LaunchRepairFragment.initView$lambda$5(function2, obj);
            }
        });
        LiveData<Result<String>> submitResult = getViewModel().getSubmitResult();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Result<? extends String>, Unit> function3 = new Function1<Result<? extends String>, Unit>() { // from class: com.yd.android_brand_mvp.activity.repair.LaunchRepairFragment.initView.6
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
                LaunchRepairFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                String str = (String) value;
                if (str == null) {
                    return;
                }
                ToastUtil.showBottomView(LaunchRepairFragment.this.requireContext(), "报修成功");
                EventBus.getDefault().post(new EventBean(10002, str, "repair"));
            }
        };
        submitResult.observe(viewLifecycleOwner3, new Observer() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$LaunchRepairFragment$o8M-NNxBPUtjA2VVTd8ahfOcS-4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LaunchRepairFragment.initView$lambda$6(function3, obj);
            }
        });
        LiveData<Result<Boolean>> modifyResult = getViewModel().getModifyResult();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<Result<? extends Boolean>, Unit> function4 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.repair.LaunchRepairFragment.initView.7
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
                LaunchRepairFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                Boolean bool = (Boolean) value;
                if (bool == null || !bool.booleanValue()) {
                    return;
                }
                ToastUtil.showBottomView(LaunchRepairFragment.this.requireContext(), "修改成功");
                LaunchRepairFragment.this.requireActivity().finish();
            }
        };
        modifyResult.observe(viewLifecycleOwner4, new Observer() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$LaunchRepairFragment$nuioHpJP_DTMoFCywR32Djj2TWU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LaunchRepairFragment.initView$lambda$7(function4, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(LaunchRepairFragment this$0, final BaseQuickAdapter adapter, View view, final int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        final FlowElementListItem flowElementListItem = this$0.processAdapter.getData().get(i);
        SelectLeavePeopleDialog selectLeavePeopleDialog = new SelectLeavePeopleDialog(flowElementListItem.getUserInfoList(), flowElementListItem.getUserSelectType());
        selectLeavePeopleDialog.setSelectLeavePeopleListener(new SelectLeavePeopleDialog.SelectLeavePeopleListener() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$LaunchRepairFragment$A8B-6AI-oEWEsE9U-9j48BEz7Qg
            @Override // com.yd.android_brand_mvp.dialog.reservation.userspace.SelectLeavePeopleDialog.SelectLeavePeopleListener
            public final void getUserInfoList(List list) {
                LaunchRepairFragment.initView$lambda$1$lambda$0(flowElementListItem, adapter, i, list);
            }
        });
        selectLeavePeopleDialog.show(this$0.getChildFragmentManager(), "peopleDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(FlowElementListItem itemData, BaseQuickAdapter adapter, int i, List list) {
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        Intrinsics.checkNotNullParameter(list, "list");
        itemData.getUserInfoList().clear();
        itemData.getUserInfoList().addAll(list);
        adapter.notifyItemChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(LaunchRepairFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().llFragmentStudentApplyLeave.requestFocus();
        this$0.getBinding().llFragmentStudentApplyLeave.setFocusable(true);
        this$0.getBinding().llFragmentStudentApplyLeave.setFocusableInTouchMode(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(LaunchRepairFragment this$0, View view) {
        boolean z;
        String userName;
        String userId;
        String userName2;
        String userId2;
        FormVerifyBean formVerifyBean;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showProgressDialog();
        Iterator<Fragment> it2 = this$0.getViewModel().getComponentFragmentList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = true;
                break;
            }
            Fragment next = it2.next();
            BaseCollectFragment baseCollectFragment = next instanceof BaseCollectFragment ? (BaseCollectFragment) next : null;
            if (baseCollectFragment == null || (formVerifyBean = baseCollectFragment.readySubmit()) == null) {
                formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
            }
            if (!formVerifyBean.getStatus()) {
                ToastUtil.showBottomView(this$0.requireContext(), formVerifyBean.getErrorMessage());
                z = false;
                break;
            } else if (!this$0.componentDataList.isEmpty() && formVerifyBean.getSort() >= 0 && formVerifyBean.getSort() < this$0.componentDataList.size()) {
                this$0.componentDataList.get(formVerifyBean.getSort()).setValue(formVerifyBean.getDataValue());
            }
        }
        if (z) {
            String submitJsonData = this$0.parseSubmitJsonData();
            if (this$0.isModify) {
                RepairViewModel viewModel = this$0.getViewModel();
                String str = this$0.modifyFormId;
                List<FlowElementListItem> data = this$0.processAdapter.getData();
                String str2 = this$0.reason;
                UserVerifyBean userVerifyBean = this$0.verifyBean;
                String str3 = (userVerifyBean == null || (userId2 = userVerifyBean.getUserId()) == null) ? "" : userId2;
                UserVerifyBean userVerifyBean2 = this$0.verifyBean;
                String str4 = (userVerifyBean2 == null || (userName2 = userVerifyBean2.getUserName()) == null) ? "" : userName2;
                UserVerifyBean userVerifyBean3 = this$0.verifyBean;
                boolean zIsStudent = userVerifyBean3 != null ? userVerifyBean3.isStudent() : false;
                String schoolId = SpData.getSchoolId();
                Intrinsics.checkNotNullExpressionValue(schoolId, "getSchoolId()");
                viewModel.modifyForm(str, submitJsonData, data, str2, str3, str4, zIsStudent, schoolId);
                return;
            }
            RepairViewModel viewModel2 = this$0.getViewModel();
            String str5 = this$0.formKey;
            List<FlowElementListItem> data2 = this$0.processAdapter.getData();
            UserVerifyBean userVerifyBean4 = this$0.verifyBean;
            String str6 = (userVerifyBean4 == null || (userId = userVerifyBean4.getUserId()) == null) ? "" : userId;
            UserVerifyBean userVerifyBean5 = this$0.verifyBean;
            viewModel2.submitRepair(str5, submitJsonData, data2, str6, (userVerifyBean5 == null || (userName = userVerifyBean5.getUserName()) == null) ? "" : userName);
            return;
        }
        this$0.dismissProgressDialog();
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

    private final void request() {
        showProgressDialog();
        RepairViewModel viewModel = getViewModel();
        UserVerifyBean userVerifyBean = this.verifyBean;
        viewModel.getFormDetail(userVerifyBean != null ? userVerifyBean.isStudent() : false);
    }

    private final void parseFormUI() {
        String userId;
        List list = (List) GsonUtils.fromJson(this.formContent, new TypeToken<List<? extends FormBaseBean>>() { // from class: com.yd.android_brand_mvp.activity.repair.LaunchRepairFragment$parseFormUI$formItemList$1
        }.getType());
        if (list == null) {
            return;
        }
        this.componentDataList.clear();
        int i = 0;
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            FormBaseBean formBaseBean = (FormBaseBean) obj;
            formBaseBean.setParentSort(i2);
            if (formBaseBean.isKit()) {
                this.kitDataList.add(formBaseBean);
                for (FormBaseBean formBaseBean2 : formBaseBean.getChildren()) {
                    formBaseBean2.setKit(true);
                    formBaseBean2.setKitId(formBaseBean.getId());
                }
                this.componentDataList.addAll(formBaseBean.getChildren());
            } else {
                this.componentDataList.add(formBaseBean);
            }
            i2 = i3;
        }
        if (!this.componentDataList.isEmpty()) {
            FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "childFragmentManager.beginTransaction()");
            for (Object obj2 : this.componentDataList) {
                int i4 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FormBaseBean formBaseBean3 = (FormBaseBean) obj2;
                formBaseBean3.setSort(i);
                formBaseBean3.setSortNum(i4);
                FormComponentUtil formComponentUtil = FormComponentUtil.INSTANCE;
                UserVerifyBean userVerifyBean = this.verifyBean;
                if (userVerifyBean == null || (userId = userVerifyBean.getUserId()) == null) {
                    userId = "";
                }
                Fragment componentFragment = formComponentUtil.getComponentFragment(formBaseBean3, userId);
                if (componentFragment != null) {
                    FrameLayout frameLayout = new FrameLayout(requireContext());
                    frameLayout.setId(this.idPrefix + i);
                    frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                    fragmentTransactionBeginTransaction.replace(frameLayout.getId(), componentFragment);
                    getBinding().llFragmentStudentApplyLeave.addView(frameLayout);
                    getViewModel().getComponentFragmentList().add(componentFragment);
                }
                i = i4;
            }
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        }
        LinearLayout linearLayout = getBinding().llFragmentStudentApplyLeave;
        View view = this.processView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processView");
            view = null;
        }
        linearLayout.addView(view);
        requestProcess(this.formKey, this.formContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestProcess(String key, String jsonContent) {
        showProgressDialog();
        UserVerifyBean userVerifyBean = this.verifyBean;
        if (userVerifyBean != null) {
            String schoolId = SpData.getSchoolId();
            RepairViewModel viewModel = getViewModel();
            String userId = userVerifyBean.getUserId();
            boolean zIsStudent = userVerifyBean.isStudent();
            String identityUserId = userVerifyBean.getIdentityUserId();
            Intrinsics.checkNotNullExpressionValue(schoolId, "schoolId");
            viewModel.getRepairProcess(key, jsonContent, userId, zIsStudent, identityUserId, schoolId);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void parseData(FormVerifyBean data) {
        FormVerifyBean formVerifyBean;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getStatus()) {
            boolean z = true;
            for (Fragment fragment : getViewModel().getComponentFragmentList()) {
                BaseCollectFragment baseCollectFragment = fragment instanceof BaseCollectFragment ? (BaseCollectFragment) fragment : null;
                if (baseCollectFragment == null || (formVerifyBean = baseCollectFragment.readySubmit()) == null) {
                    formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
                }
                if (!formVerifyBean.getStatus()) {
                    z = false;
                    break;
                } else if (!this.componentDataList.isEmpty() && formVerifyBean.getSort() >= 0 && formVerifyBean.getSort() < this.componentDataList.size()) {
                    FormBaseBean formBaseBean = this.componentDataList.get(formVerifyBean.getSort());
                    formBaseBean.setValue(formVerifyBean.getDataValue());
                    formBaseBean.setValueData(formVerifyBean.getDataValueBean());
                }
            }
            if (!z) {
                Log.e("LaunchRepair", "达不到请求流程的要求");
            } else {
                requestProcess(this.formKey, parseSubmitJsonData());
            }
        }
    }

    private final String parseSubmitJsonData() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.kitDataList);
        for (FormBaseBean formBaseBean : this.componentDataList) {
            if (!formBaseBean.isKit()) {
                arrayList.add(formBaseBean);
            }
        }
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.yd.android_brand_mvp.activity.repair.LaunchRepairFragment$parseSubmitJsonData$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((FormBaseBean) t).getParentSort()), Integer.valueOf(((FormBaseBean) t2).getParentSort()));
                }
            });
        }
        String json = GsonUtils.toJson(arrayList);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(submitBean)");
        return json;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
