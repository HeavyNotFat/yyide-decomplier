package com.yd.android_brand_mvp.landscape.exam;

import android.content.Context;
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
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentUserExamBinding;
import com.yd.android_brand_mvp.databinding.ItemUserExamBinding;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.landscape.exam.viewmodel.UserExamViewModel;
import com.yd.android_brand_mvp.model.exam.ExamInvigilatorBean;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TimeUtil;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: UserExamFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\t\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/UserExamFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentUserExamBinding;", "()V", "sourceTimeFormat", "", CommentsHomeFragment.TYPE_ID, "targetTimeFormat", "userExamAdapter", "com/yd/android_brand_mvp/landscape/exam/UserExamFragment$userExamAdapter$2$1", "getUserExamAdapter", "()Lcom/yd/android_brand_mvp/landscape/exam/UserExamFragment$userExamAdapter$2$1;", "userExamAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/exam/viewmodel/UserExamViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/exam/viewmodel/UserExamViewModel;", "viewModel$delegate", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UserExamFragment extends KTBaseFragment<FragmentUserExamBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String sourceTimeFormat;
    private String studentId;
    private final String targetTimeFormat;

    /* JADX INFO: renamed from: userExamAdapter$delegate, reason: from kotlin metadata */
    private final Lazy userExamAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.UserExamFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: UserExamFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentUserExamBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentUserExamBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentUserExamBinding;", 0);
        }

        public final FragmentUserExamBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentUserExamBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentUserExamBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public UserExamFragment() {
        super(AnonymousClass1.INSTANCE);
        this.studentId = "0";
        final UserExamFragment userExamFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.exam.UserExamFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return userExamFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.exam.UserExamFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(userExamFragment, Reflection.getOrCreateKotlinClass(UserExamViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.exam.UserExamFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.exam.UserExamFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.exam.UserExamFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = userExamFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.sourceTimeFormat = "yyyy-MM-dd HH:mm:ss";
        this.targetTimeFormat = "HH:mm";
        this.userExamAdapter = LazyKt.lazy(new Function0<UserExamFragment$userExamAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.landscape.exam.UserExamFragment$userExamAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.landscape.exam.UserExamFragment$userExamAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final UserExamFragment userExamFragment2 = this.this$0;
                return new BaseBindingAdapter<ItemUserExamBinding, ExamPlanItem>() { // from class: com.yd.android_brand_mvp.landscape.exam.UserExamFragment$userExamAdapter$2.1
                    {
                        super(null, 1, null);
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, ExamPlanItem examPlanItem) {
                        convertPlus2((VBViewHolder<ItemUserExamBinding>) vBViewHolder, examPlanItem);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemUserExamBinding> holder, ExamPlanItem item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemUserExamBinding itemUserExamBinding = (ItemUserExamBinding) holder.getBinding();
                        if (itemUserExamBinding != null) {
                            UserExamFragment userExamFragment3 = userExamFragment2;
                            itemUserExamBinding.tvItemUserExamAddress.setText(item.getExaminationRoomName() + '-' + item.getBuildingName() + '-' + item.getSiteName());
                            StringBuilder sb = new StringBuilder();
                            int i = 0;
                            for (Object obj : item.getInvigilators()) {
                                int i2 = i + 1;
                                if (i < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                sb.append(((ExamInvigilatorBean) obj).getPersonName());
                                if (i != CollectionsKt.getLastIndex(item.getInvigilators())) {
                                    sb.append("、");
                                }
                                i = i2;
                            }
                            StringBuilder sb2 = sb;
                            if (sb2.length() == 0) {
                                sb.append("无");
                            }
                            itemUserExamBinding.tvItemUserExamTeacher.setText(sb2);
                            String str = TimeUtil.formatTime(item.getExamStartTime(), userExamFragment3.sourceTimeFormat, "yyyy-MM-dd HH:mm") + '-' + TimeUtil.formatTime(item.getExamEndTime(), userExamFragment3.sourceTimeFormat, userExamFragment3.targetTimeFormat);
                            if (Intrinsics.areEqual(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                                itemUserExamBinding.tvItemUserExamTime.setText("");
                            } else {
                                itemUserExamBinding.tvItemUserExamTime.setText(str);
                            }
                            itemUserExamBinding.tvItemUserExamNumber.setText(item.getStudentSeat());
                            itemUserExamBinding.tvItemUserExamTitle.setText(item.getSubjectName());
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemUserExamBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemUserExamBinding itemUserExamBindingInflate = ItemUserExamBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemUserExamBindingInflate, "inflate(inflater, parent, false)");
                        return itemUserExamBindingInflate;
                    }
                };
            }
        });
    }

    /* JADX INFO: compiled from: UserExamFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/UserExamFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/exam/UserExamFragment;", "id", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UserExamFragment newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            UserExamFragment userExamFragment = new UserExamFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            userExamFragment.setArguments(bundle);
            return userExamFragment;
        }
    }

    private final UserExamViewModel getViewModel() {
        return (UserExamViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UserExamFragment$userExamAdapter$2.AnonymousClass1 getUserExamAdapter() {
        return (UserExamFragment$userExamAdapter$2.AnonymousClass1) this.userExamAdapter.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("id") : null;
        if (string == null) {
            string = "0";
        }
        this.studentId = string;
        getBinding().rvFragmentUserExam.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().rvFragmentUserExam.setAdapter(getUserExamAdapter());
        getUserExamAdapter().setEmptyView(R.layout.layout_empty);
        LiveData<Result<List<ExamPlanItem>>> studentExam = getViewModel().getStudentExam();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends List<? extends ExamPlanItem>>, Unit> function1 = new Function1<Result<? extends List<? extends ExamPlanItem>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.exam.UserExamFragment.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<? extends ExamPlanItem>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<? extends ExamPlanItem>> it2) {
                UserExamFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                List list = (List) value;
                if (list == null) {
                    return;
                }
                UserExamFragment.this.getUserExamAdapter().setList(list);
            }
        };
        studentExam.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$UserExamFragment$r1eVHY3mModYuHcBEYebH4FdEEs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UserExamFragment.onViewCreated$lambda$0(function1, obj);
            }
        });
        request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void request() {
        if (Intrinsics.areEqual(this.studentId, "0")) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            SimpleUtilsKt.showShotToast(contextRequireContext, "获取学生id失败");
        } else {
            showProgressDialog();
            getViewModel().getStudentExamList(this.studentId);
        }
    }
}
