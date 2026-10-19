package com.yd.android_brand_mvp.landscape.ai;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import androidx.recyclerview.widget.GridLayoutManager;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.AIJuniorAssistantActivity;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.FragmentAiFragment8x6Binding;
import com.yd.android_brand_mvp.model.ai.AIIntellectHomeBean;
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

/* JADX INFO: compiled from: AIFragmentFull.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u001a\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/ai/AIFragmentFull;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentAiFragment8x6Binding;", "()V", "mAdapter", "com/yd/android_brand_mvp/landscape/ai/AIFragmentFull$mAdapter$1", "Lcom/yd/android_brand_mvp/landscape/ai/AIFragmentFull$mAdapter$1;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/ai/AIFragmentViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/ai/AIFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "UpdataEvent", "", "id", "", "initView", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AIFragmentFull extends KTBaseFragment<FragmentAiFragment8x6Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AIFragmentFull$mAdapter$1 mAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(View view) {
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.ai.AIFragmentFull$1, reason: invalid class name */
    /* JADX INFO: compiled from: AIFragmentFull.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentAiFragment8x6Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentAiFragment8x6Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentAiFragment8x6Binding;", 0);
        }

        public final FragmentAiFragment8x6Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentAiFragment8x6Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentAiFragment8x6Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public AIFragmentFull() {
        super(AnonymousClass1.INSTANCE);
        final AIFragmentFull aIFragmentFull = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.ai.AIFragmentFull$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return aIFragmentFull;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.ai.AIFragmentFull$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(aIFragmentFull, Reflection.getOrCreateKotlinClass(AIFragmentViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.ai.AIFragmentFull$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.ai.AIFragmentFull$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.ai.AIFragmentFull$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = aIFragmentFull.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.mAdapter = new AIFragmentFull$mAdapter$1(this);
    }

    /* JADX INFO: compiled from: AIFragmentFull.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/ai/AIFragmentFull$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/ai/AIFragmentFull;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AIFragmentFull newInstance() {
            return new AIFragmentFull();
        }
    }

    private final AIFragmentViewModel getViewModel() {
        return (AIFragmentViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        if (ScreenUtils.isLandscape()) {
            getBinding().constraintLayout.getLayoutParams().width = SizeUtils.dp2px(1856.0f);
            getBinding().constraintLayout.getLayoutParams().height = SizeUtils.dp2px(924.0f);
        } else {
            getBinding().constraintLayout.getLayoutParams().width = SizeUtils.dp2px(1000.0f);
            getBinding().constraintLayout.getLayoutParams().height = SizeUtils.dp2px(1756.0f);
        }
        getBinding().tvSearch.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.ai.-$$Lambda$AIFragmentFull$mjdL8Xb6DhgGJPaI107uVfIhvLs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIFragmentFull.initView$lambda$0(view);
            }
        });
        getBinding().recyclerView.setLayoutManager(new GridLayoutManager(getContext(), ScreenUtils.isLandscape() ? 4 : 2));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        getBinding().tvSearch.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.ai.-$$Lambda$AIFragmentFull$-7wxaV4le_4GLIrZ_AYI5gjtj_g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIFragmentFull.initView$lambda$1(this.f$0, view);
            }
        });
        LiveData<Result<List<AIIntellectHomeBean>>> aiHomeList = getViewModel().getAiHomeList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends List<AIIntellectHomeBean>>, Unit> function1 = new Function1<Result<? extends List<AIIntellectHomeBean>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.ai.AIFragmentFull.initView.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<AIIntellectHomeBean>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<AIIntellectHomeBean>> it2) {
                StringBuilder sb = new StringBuilder();
                sb.append("AI 首页智能体列表：");
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                sb.append(GsonUtils.toJson(value));
                Log.i("TAG", sb.toString());
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value2 = it2.getValue();
                    List list = (List) (Result.m597isFailureimpl(value2) ? null : value2);
                    if (list != null) {
                        AIFragmentFull.this.mAdapter.setList(list);
                        return;
                    }
                    return;
                }
                Throwable thM594exceptionOrNullimpl = Result.m594exceptionOrNullimpl(it2.getValue());
                ToastUtils.showShort(thM594exceptionOrNullimpl != null ? thM594exceptionOrNullimpl.getMessage() : null, new Object[0]);
            }
        };
        aiHomeList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.ai.-$$Lambda$AIFragmentFull$ddwwJThY1_9TW3JuBlD6rt1m6fU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AIFragmentFull.initView$lambda$2(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(AIFragmentFull this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.requireContext(), (Class<?>) AIJuniorAssistantActivity.class);
        intent.putExtra("title", this$0.getString(R.string.one_intelligence));
        intent.putExtra("isNotDefault", false);
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (id == MinaConstants.netWork) {
            getViewModel().getAIHomeAgentList();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getViewModel().getAIHomeAgentList();
    }
}
