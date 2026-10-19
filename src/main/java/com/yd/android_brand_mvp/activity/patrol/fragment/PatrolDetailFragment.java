package com.yd.android_brand_mvp.activity.patrol.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.blankj.utilcode.util.SizeUtils;
import com.google.gson.reflect.TypeToken;
import com.yd.android_brand_mvp.activity.patrol.viewmodel.PatrolEditViewModel;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ActivityPatrolDetailBinding;
import com.yd.android_brand_mvp.databinding.ItemFormContentListBinding;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.patrol.PatrolDetailBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.form.FormComponentUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
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

/* JADX INFO: compiled from: PatrolDetailFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0005\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u001a\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/activity/patrol/fragment/PatrolDetailFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/ActivityPatrolDetailBinding;", "()V", "formResultAdapter", "com/yd/android_brand_mvp/activity/patrol/fragment/PatrolDetailFragment$formResultAdapter$1", "Lcom/yd/android_brand_mvp/activity/patrol/fragment/PatrolDetailFragment$formResultAdapter$1;", "taskId", "", "viewModel", "Lcom/yd/android_brand_mvp/activity/patrol/viewmodel/PatrolEditViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/patrol/viewmodel/PatrolEditViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PatrolDetailFragment extends KTBaseFragment<ActivityPatrolDetailBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PatrolDetailFragment$formResultAdapter$1 formResultAdapter;
    private String taskId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolDetailFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: PatrolDetailFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ActivityPatrolDetailBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, ActivityPatrolDetailBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/ActivityPatrolDetailBinding;", 0);
        }

        public final ActivityPatrolDetailBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ActivityPatrolDetailBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ActivityPatrolDetailBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ ActivityPatrolDetailBinding access$getBinding(PatrolDetailFragment patrolDetailFragment) {
        return patrolDetailFragment.getBinding();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.yd.android_brand_mvp.activity.patrol.fragment.PatrolDetailFragment$formResultAdapter$1] */
    public PatrolDetailFragment() {
        super(AnonymousClass1.INSTANCE);
        this.formResultAdapter = new BaseBindingAdapter<ItemFormContentListBinding, FormBaseBean>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolDetailFragment$formResultAdapter$1
            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
            public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, FormBaseBean formBaseBean) {
                convertPlus2((VBViewHolder<ItemFormContentListBinding>) vBViewHolder, formBaseBean);
            }

            /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
            public void convertPlus2(VBViewHolder<ItemFormContentListBinding> holder, FormBaseBean item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemFormContentListBinding itemFormContentListBinding = (ItemFormContentListBinding) holder.getBinding();
                if (itemFormContentListBinding != null) {
                    itemFormContentListBinding.tvItemFormContentListTitle.setText(item.getTitle());
                    TextView textView = itemFormContentListBinding.tvItemFormContentListValue;
                    FormComponentUtil formComponentUtil = FormComponentUtil.INSTANCE;
                    String name = item.getName();
                    String value = item.getValue();
                    if (value == null) {
                        value = "";
                    }
                    textView.setText(formComponentUtil.parseDataValueToShowValue(name, value));
                    if (holder.getLayoutPosition() == getData().size() - 1) {
                        View view = itemFormContentListBinding.viewItemFormContentListLine;
                        Intrinsics.checkNotNullExpressionValue(view, "it.viewItemFormContentListLine");
                        SimpleUtilsKt.remove(view);
                    } else {
                        View view2 = itemFormContentListBinding.viewItemFormContentListLine;
                        Intrinsics.checkNotNullExpressionValue(view2, "it.viewItemFormContentListLine");
                        SimpleUtilsKt.show(view2);
                    }
                }
            }

            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
            public ItemFormContentListBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                Intrinsics.checkNotNullParameter(inflater, "inflater");
                Intrinsics.checkNotNullParameter(parent, "parent");
                ItemFormContentListBinding itemFormContentListBindingInflate = ItemFormContentListBinding.inflate(inflater, parent, false);
                Intrinsics.checkNotNullExpressionValue(itemFormContentListBindingInflate, "inflate(inflater, parent, false)");
                return itemFormContentListBindingInflate;
            }
        };
        final PatrolDetailFragment patrolDetailFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolDetailFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return patrolDetailFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolDetailFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(patrolDetailFragment, Reflection.getOrCreateKotlinClass(PatrolEditViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolDetailFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolDetailFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolDetailFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = patrolDetailFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.taskId = "-1";
    }

    /* JADX INFO: compiled from: PatrolDetailFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/patrol/fragment/PatrolDetailFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/patrol/fragment/PatrolDetailFragment;", "taskId", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PatrolDetailFragment newInstance(String taskId) {
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            Bundle bundle = new Bundle();
            bundle.putString("taskId", taskId);
            PatrolDetailFragment patrolDetailFragment = new PatrolDetailFragment();
            patrolDetailFragment.setArguments(bundle);
            return patrolDetailFragment;
        }
    }

    private final PatrolEditViewModel getViewModel() {
        return (PatrolEditViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        request();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("taskId") : null;
        if (string == null) {
            string = "-1";
        }
        this.taskId = string;
        getBinding().viewActivityPatrolHead.tvViewPatrolBaseInfoFormTitle.setText("巡查反馈");
        ImageView imageView = getBinding().viewActivityPatrolHead.ivViewPatrolBaseInfoStatus;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.viewActivityPatr…vViewPatrolBaseInfoStatus");
        SimpleUtilsKt.show(imageView);
        TextView textView = getBinding().viewActivityPatrolHead.tvViewPatrolBaseInfoTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.viewActivityPatr…tvViewPatrolBaseInfoTitle");
        textView.setPadding(SizeUtils.dp2px(10.0f), 0, SizeUtils.dp2px(30.0f), 0);
        TextView textView2 = getBinding().viewActivityPatrolHead.tvViewPatrolBaseInfoSubmitTime;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.viewActivityPatr…wPatrolBaseInfoSubmitTime");
        SimpleUtilsKt.show(textView2);
        getBinding().rvActivityPatrolDetail.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().rvActivityPatrolDetail.setAdapter(this.formResultAdapter);
        LiveData<Result<PatrolDetailBean>> patrolDetail = getViewModel().getPatrolDetail();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends PatrolDetailBean>, Unit> function1 = new Function1<Result<? extends PatrolDetailBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolDetailFragment.initView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends PatrolDetailBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends PatrolDetailBean> it2) {
                List list;
                PatrolDetailFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                PatrolDetailBean patrolDetailBean = (PatrolDetailBean) value;
                if (patrolDetailBean == null) {
                    return;
                }
                PatrolDetailFragment.access$getBinding(PatrolDetailFragment.this).viewActivityPatrolHead.tvViewPatrolBaseInfoTitle.setText(String.valueOf(patrolDetailBean.getProjectName()));
                PatrolDetailFragment.access$getBinding(PatrolDetailFragment.this).viewActivityPatrolHead.tvViewPatrolBaseInfoTime.setText("任务时间: " + patrolDetailBean.getStartTime() + " - " + patrolDetailBean.getEndTime());
                TextView textView3 = PatrolDetailFragment.access$getBinding(PatrolDetailFragment.this).viewActivityPatrolHead.tvViewPatrolBaseInfoSubmitTime;
                StringBuilder sb = new StringBuilder();
                sb.append("完成时间: ");
                sb.append(patrolDetailBean.getFinishTime());
                textView3.setText(sb.toString());
                PatrolDetailFragment.access$getBinding(PatrolDetailFragment.this).viewActivityPatrolHead.tvViewPatrolBaseInfoPeople.setText("执行人员: " + patrolDetailBean.getExecuteNames());
                PatrolDetailFragment.access$getBinding(PatrolDetailFragment.this).viewActivityPatrolHead.tvViewPatrolBaseInfoDesc.setText("任务描述: ");
                if (!(patrolDetailBean.getFormJson().length() > 0) || (list = (List) GsonUtils.fromJson(patrolDetailBean.getFormJson(), new TypeToken<List<? extends FormBaseBean>>() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.PatrolDetailFragment$initView$1$formItemList$1
                }.getType())) == null) {
                    return;
                }
                setList(list);
            }
        };
        patrolDetail.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.patrol.fragment.-$$Lambda$PatrolDetailFragment$6ry5KYlUY5HRNqsgrhw4tHYdUs4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PatrolDetailFragment.initView$lambda$0(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void request() {
        showProgressDialog();
        getViewModel().getPatrolDetail(this.taskId);
    }
}
