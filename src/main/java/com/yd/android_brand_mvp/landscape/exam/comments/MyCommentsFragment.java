package com.yd.android_brand_mvp.landscape.exam.comments;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.MyCommentsFragmentBinding;
import com.yd.android_brand_mvp.model.ConfigComplaintBean;
import com.yd.android_brand_mvp.user.viewmodel.ConfigViewModel;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.widget.YDEditText;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MyCommentsFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/comments/MyCommentsFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/MyCommentsFragmentBinding;", "()V", "mCommitListener", "Lcom/yd/android_brand_mvp/landscape/exam/comments/MyCommentsFragment$CommitListener;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewModelConfig", "Lcom/yd/android_brand_mvp/user/viewmodel/ConfigViewModel;", "getViewModelConfig", "()Lcom/yd/android_brand_mvp/user/viewmodel/ConfigViewModel;", "viewModelConfig$delegate", "initView", "", "initViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "requestData", "type", "", "setOnCommitListener", "CommitListener", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MyCommentsFragment extends KTBaseFragment<MyCommentsFragmentBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CommitListener mCommitListener;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: viewModelConfig$delegate, reason: from kotlin metadata */
    private final Lazy viewModelConfig;

    /* JADX INFO: compiled from: MyCommentsFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/comments/MyCommentsFragment$CommitListener;", "", "onCommitCall", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CommitListener {
        void onCommitCall();
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.comments.MyCommentsFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: MyCommentsFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, MyCommentsFragmentBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, MyCommentsFragmentBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/MyCommentsFragmentBinding;", 0);
        }

        public final MyCommentsFragmentBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return MyCommentsFragmentBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ MyCommentsFragmentBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ MyCommentsFragmentBinding access$getBinding(MyCommentsFragment myCommentsFragment) {
        return myCommentsFragment.getBinding();
    }

    public MyCommentsFragment() {
        super(AnonymousClass1.INSTANCE);
        final MyCommentsFragment myCommentsFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.MyCommentsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return myCommentsFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.MyCommentsFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(myCommentsFragment, Reflection.getOrCreateKotlinClass(CommentsViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.MyCommentsFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.MyCommentsFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.MyCommentsFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = myCommentsFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        final Function0<Fragment> function2 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.MyCommentsFragment$special$$inlined$viewModels$default$6
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return myCommentsFragment;
            }
        };
        final Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.MyCommentsFragment$special$$inlined$viewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function2.invoke();
            }
        });
        this.viewModelConfig = FragmentViewModelLazyKt.createViewModelLazy(myCommentsFragment, Reflection.getOrCreateKotlinClass(ConfigViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.MyCommentsFragment$special$$inlined$viewModels$default$8
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy2).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "owner.viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.MyCommentsFragment$special$$inlined$viewModels$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function3 = function1;
                if (function3 != null && (creationExtras = (CreationExtras) function3.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM19viewModels$lambda1 = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy2);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM19viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM19viewModels$lambda1 : null;
                CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.MyCommentsFragment$special$$inlined$viewModels$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                ViewModelStoreOwner viewModelStoreOwnerM19viewModels$lambda1 = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy2);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM19viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM19viewModels$lambda1 : null;
                if (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) {
                    defaultViewModelProviderFactory = myCommentsFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    /* JADX INFO: compiled from: MyCommentsFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/comments/MyCommentsFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/exam/comments/MyCommentsFragment;", CommentsHomeFragment.TYPE_ID, "", CommentsHomeFragment.TYPE_CLASSESID, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MyCommentsFragment newInstance(String studentId, String classesId) {
            Intrinsics.checkNotNullParameter(studentId, "studentId");
            Intrinsics.checkNotNullParameter(classesId, "classesId");
            MyCommentsFragment myCommentsFragment = new MyCommentsFragment();
            Bundle bundle = new Bundle();
            bundle.putString(CommentsHomeFragment.TYPE_ID, studentId);
            bundle.putString(CommentsHomeFragment.TYPE_CLASSESID, classesId);
            myCommentsFragment.setArguments(bundle);
            return myCommentsFragment;
        }
    }

    private final CommentsViewModel getViewModel() {
        return (CommentsViewModel) this.viewModel.getValue();
    }

    private final ConfigViewModel getViewModelConfig() {
        return (ConfigViewModel) this.viewModelConfig.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initViewModel();
        getViewModelConfig().getDeviceConfig("1");
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.String] */
    private final void initView() {
        YDEditText yDEditText = getBinding().etComments;
        Intrinsics.checkNotNullExpressionValue(yDEditText, "binding.etComments");
        yDEditText.addTextChangedListener(new TextWatcher() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.MyCommentsFragment$initView$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                int length = StringsKt.trim((CharSequence) String.valueOf(MyCommentsFragment.access$getBinding(this.this$0).etComments.getText())).toString().length();
                MyCommentsFragment.access$getBinding(this.this$0).tvCodeNumber.setText(length + "/1000");
            }
        });
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = "";
        Bundle arguments = getArguments();
        if (arguments != null) {
            objectRef.element = String.valueOf(arguments.getString(CommentsHomeFragment.TYPE_ID));
            objectRef2.element = String.valueOf(arguments.getString(CommentsHomeFragment.TYPE_CLASSESID));
        }
        getBinding().tvCommit.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.-$$Lambda$MyCommentsFragment$yMCMX5YjlaD_baRfCrH8atELv_I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyCommentsFragment.initView$lambda$2(this.f$0, objectRef2, objectRef, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$2(MyCommentsFragment this$0, Ref.ObjectRef classesId, Ref.ObjectRef studentId, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(classesId, "$classesId");
        Intrinsics.checkNotNullParameter(studentId, "$studentId");
        String string = StringsKt.trim((CharSequence) String.valueOf(this$0.getBinding().etComments.getText())).toString();
        if (TextUtils.isEmpty(string)) {
            ToastUtil.showBottomView((Activity) this$0.requireActivity(), "请输入留言内容！");
        } else {
            this$0.showProgressDialog();
            this$0.getViewModel().addComments((String) classesId.element, (String) studentId.element, string, CommentsHomeFragment.INSTANCE.getType(), this$0.getBinding().cb.isChecked());
        }
    }

    public final void requestData(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        getViewModelConfig().getDeviceConfig(type);
    }

    private final void initViewModel() {
        LiveData<Result<String>> commentsLiveData = getViewModel().getCommentsLiveData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends String>, Unit> function1 = new Function1<Result<? extends String>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.MyCommentsFragment.initViewModel.1
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
                MyCommentsFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    ToastUtil.showBottomView((Activity) MyCommentsFragment.this.requireActivity(), "留言成功");
                    MyCommentsFragment.access$getBinding(MyCommentsFragment.this).etComments.setText("");
                    CommitListener commitListener = MyCommentsFragment.this.mCommitListener;
                    if (commitListener != null) {
                        commitListener.onCommitCall();
                        return;
                    }
                    return;
                }
                ToastUtil.showBottomView((Activity) MyCommentsFragment.this.requireActivity(), "留言失败");
            }
        };
        commentsLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.-$$Lambda$MyCommentsFragment$-KzKjjXLLtetsf6Ak-o2tdFaLCE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MyCommentsFragment.initViewModel$lambda$3(function1, obj);
            }
        });
        LiveData<ConfigComplaintBean> configLiveData = getViewModelConfig().getConfigLiveData();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<ConfigComplaintBean, Unit> function2 = new Function1<ConfigComplaintBean, Unit>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.MyCommentsFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ConfigComplaintBean configComplaintBean) {
                invoke2(configComplaintBean);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ConfigComplaintBean configComplaintBean) {
                MyCommentsFragment.access$getBinding(MyCommentsFragment.this).cb.setVisibility(configComplaintBean.isAnonymity() ? 0 : 4);
                MyCommentsFragment.access$getBinding(MyCommentsFragment.this).cb.setChecked(configComplaintBean.isAnonymity());
            }
        };
        configLiveData.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.-$$Lambda$MyCommentsFragment$_RdfsM08oOHMNs9MIdXC0ZNdpGA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MyCommentsFragment.initViewModel$lambda$4(function2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void setOnCommitListener(CommitListener mCommitListener) {
        Intrinsics.checkNotNullParameter(mCommitListener, "mCommitListener");
        this.mCommitListener = mCommitListener;
    }
}
