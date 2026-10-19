package com.yd.android_brand_mvp.landscape.blackboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentBlackBoardFragment2x3Binding;
import com.yd.android_brand_mvp.databinding.ItemBbSubjectBinding;
import com.yd.android_brand_mvp.dialog.SocketIPDialog;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
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

/* JADX INFO: compiled from: BlackBoardFragment2x3.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0005\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardFragment2x3;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentBlackBoardFragment2x3Binding;", "()V", "adapter", "com/yd/android_brand_mvp/landscape/blackboard/BlackBoardFragment2x3$adapter$1", "Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardFragment2x3$adapter$1;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", NotificationCompat.CATEGORY_EVENT, "", "bean", "Lcom/yd/android_brand_mvp/model/EventBean;", "initView", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlackBoardFragment2x3 extends KTBaseFragment<FragmentBlackBoardFragment2x3Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BlackBoardFragment2x3$adapter$1 adapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment2x3$1, reason: invalid class name */
    /* JADX INFO: compiled from: BlackBoardFragment2x3.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentBlackBoardFragment2x3Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentBlackBoardFragment2x3Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentBlackBoardFragment2x3Binding;", 0);
        }

        public final FragmentBlackBoardFragment2x3Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentBlackBoardFragment2x3Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentBlackBoardFragment2x3Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment2x3$adapter$1] */
    public BlackBoardFragment2x3() {
        super(AnonymousClass1.INSTANCE);
        final BlackBoardFragment2x3 blackBoardFragment2x3 = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment2x3$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return blackBoardFragment2x3;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment2x3$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(blackBoardFragment2x3, Reflection.getOrCreateKotlinClass(BlackBoardViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment2x3$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment2x3$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment2x3$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = blackBoardFragment2x3.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.adapter = new BaseQuickAdapter<BlackBoardModel, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment2x3$adapter$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, BlackBoardModel item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemBbSubjectBinding itemBbSubjectBindingBind = ItemBbSubjectBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemBbSubjectBindingBind, "bind(holder.itemView)");
                itemBbSubjectBindingBind.tvName.setText(item.getSubjectName());
                TextView textView = itemBbSubjectBindingBind.tvNumber;
                List<BlackBoardModel> list = item.getList();
                textView.setText(String.valueOf(list != null ? Integer.valueOf(list.size()) : null));
            }
        };
    }

    public static final /* synthetic */ FragmentBlackBoardFragment2x3Binding access$getBinding(BlackBoardFragment2x3 blackBoardFragment2x3) {
        return blackBoardFragment2x3.getBinding();
    }

    /* JADX INFO: compiled from: BlackBoardFragment2x3.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardFragment2x3$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardFragment2x3;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BlackBoardFragment2x3 newInstance() {
            return new BlackBoardFragment2x3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BlackBoardViewModel getViewModel() {
        return (BlackBoardViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);
        initView();
    }

    private final void initView() {
        getBinding().top.title.setText("黑板截图");
        getBinding().recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        getBinding().recyclerView.setAdapter(this.adapter);
        getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.blackboard.-$$Lambda$BlackBoardFragment2x3$uFfWvbZ4oy7dG8Xu4cBWQDuEIQ0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BlackBoardFragment2x3.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().ivNoData.setVisibility(0);
        getBinding().ivToday.setVisibility(4);
        getBinding().recyclerView.setVisibility(4);
        SingleLiveEvent<List<BlackBoardModel>> todaySubjectList = getViewModel().getTodaySubjectList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        final Function1<List<BlackBoardModel>, Unit> function1 = new Function1<List<BlackBoardModel>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment2x3.initView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<BlackBoardModel> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<BlackBoardModel> list) {
                if (list.size() == 0) {
                    BlackBoardFragment2x3.access$getBinding(BlackBoardFragment2x3.this).ivNoData.setVisibility(0);
                    BlackBoardFragment2x3.access$getBinding(BlackBoardFragment2x3.this).ivToday.setVisibility(4);
                    BlackBoardFragment2x3.access$getBinding(BlackBoardFragment2x3.this).recyclerView.setVisibility(4);
                } else {
                    BlackBoardFragment2x3.access$getBinding(BlackBoardFragment2x3.this).ivNoData.setVisibility(4);
                    BlackBoardFragment2x3.access$getBinding(BlackBoardFragment2x3.this).ivToday.setVisibility(0);
                    BlackBoardFragment2x3.access$getBinding(BlackBoardFragment2x3.this).recyclerView.setVisibility(0);
                }
                setList(list);
            }
        };
        todaySubjectList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.blackboard.-$$Lambda$BlackBoardFragment2x3$QFoaJOhoHGGk6Q9n1FZG3-cqpD8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BlackBoardFragment2x3.initView$lambda$1(function1, obj);
            }
        });
        setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.blackboard.-$$Lambda$BlackBoardFragment2x3$22XuOYS10UzRsONoIJAfFiEc4FI
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                BlackBoardFragment2x3.initView$lambda$2(this.f$0, baseQuickAdapter, view, i);
            }
        });
        getBinding().clContent.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.yd.android_brand_mvp.landscape.blackboard.-$$Lambda$BlackBoardFragment2x3$jIwRTQ3FSK6_4bS3ZshK5phgSB4
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return BlackBoardFragment2x3.initView$lambda$3(this.f$0, view);
            }
        });
        new Timer().schedule(new TimerTask() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment2x3.initView.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                BlackBoardFragment2x3.this.getViewModel().m299getTodaySubjectList();
            }
        }, 0L, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(BlackBoardFragment2x3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BlackBoardActivity.Companion companion = BlackBoardActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.start(contextRequireContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(BlackBoardFragment2x3 this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = adapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.yd.android_brand_mvp.landscape.blackboard.BlackBoardModel");
        BlackBoardActivity.Companion companion = BlackBoardActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        String subjectName = ((BlackBoardModel) item).getSubjectName();
        if (subjectName == null) {
            subjectName = "";
        }
        companion.start(contextRequireContext, subjectName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$3(BlackBoardFragment2x3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new SocketIPDialog(this$0.requireContext()).show();
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void event(EventBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        if (bean.Event == 10003) {
            getViewModel().m299getTodaySubjectList();
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
