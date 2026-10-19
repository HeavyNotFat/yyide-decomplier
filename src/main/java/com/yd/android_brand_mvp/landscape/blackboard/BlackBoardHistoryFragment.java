package com.yd.android_brand_mvp.landscape.blackboard;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.BitmapShowActivity;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentBlackBroadHistoryBinding;
import com.yd.android_brand_mvp.databinding.ItemBlackBoardFileBinding;
import com.yd.android_brand_mvp.databinding.ItemBlackBoardHomeBinding;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: BlackBoardHistoryFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0003\u0005\b\u000b\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0012\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardHistoryFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentBlackBroadHistoryBinding;", "()V", "childAdapter", "com/yd/android_brand_mvp/landscape/blackboard/BlackBoardHistoryFragment$childAdapter$1", "Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardHistoryFragment$childAdapter$1;", "contentAdapter", "com/yd/android_brand_mvp/landscape/blackboard/BlackBoardHistoryFragment$contentAdapter$1", "Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardHistoryFragment$contentAdapter$1;", "homeAdapter", "com/yd/android_brand_mvp/landscape/blackboard/BlackBoardHistoryFragment$homeAdapter$1", "Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardHistoryFragment$homeAdapter$1;", "position", "", "viewModel", "Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "initViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlackBoardHistoryFragment extends KTBaseFragment<FragmentBlackBroadHistoryBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SUBJECT_NAME = "SubjectName";
    private final BlackBoardHistoryFragment$childAdapter$1 childAdapter;
    private final BlackBoardHistoryFragment$contentAdapter$1 contentAdapter;
    private final BlackBoardHistoryFragment$homeAdapter$1 homeAdapter;
    private int position;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardHistoryFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: BlackBoardHistoryFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentBlackBroadHistoryBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentBlackBroadHistoryBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentBlackBroadHistoryBinding;", 0);
        }

        public final FragmentBlackBroadHistoryBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentBlackBroadHistoryBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentBlackBroadHistoryBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.yd.android_brand_mvp.landscape.blackboard.BlackBoardHistoryFragment$homeAdapter$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.yd.android_brand_mvp.landscape.blackboard.BlackBoardHistoryFragment$contentAdapter$1] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.yd.android_brand_mvp.landscape.blackboard.BlackBoardHistoryFragment$childAdapter$1] */
    public BlackBoardHistoryFragment() {
        super(AnonymousClass1.INSTANCE);
        final BlackBoardHistoryFragment blackBoardHistoryFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardHistoryFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return blackBoardHistoryFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardHistoryFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(blackBoardHistoryFragment, Reflection.getOrCreateKotlinClass(BlackBoardViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardHistoryFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardHistoryFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardHistoryFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = blackBoardHistoryFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.homeAdapter = new BaseQuickAdapter<BlackBoardModel, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardHistoryFragment$homeAdapter$1
            {
                super(R.layout.item_black_board_home, null, 2, null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, BlackBoardModel item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemBlackBoardHomeBinding itemBlackBoardHomeBindingBind = ItemBlackBoardHomeBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemBlackBoardHomeBindingBind, "bind(holder.itemView)");
                itemBlackBoardHomeBindingBind.tvSubject.setText(item.getSubjectName());
                itemBlackBoardHomeBindingBind.tvSubject.setChecked(this.this$0.position == holder.getAdapterPosition());
            }
        };
        this.contentAdapter = new BaseQuickAdapter<BlackBoardModel, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardHistoryFragment$contentAdapter$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, BlackBoardModel item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemBlackBoardFileBinding itemBlackBoardFileBindingBind = ItemBlackBoardFileBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemBlackBoardFileBindingBind, "bind(holder.itemView)");
                itemBlackBoardFileBindingBind.tvSubject.setText(item.getSubjectName() + '_' + TimeUtil.formatTime(item.getTime(), "yyyyMMddHHmmss", "yyyyMMdd"));
            }
        };
        this.childAdapter = new BaseQuickAdapter<BlackBoardModel, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardHistoryFragment$childAdapter$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, BlackBoardModel item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemBlackBoardFileBinding itemBlackBoardFileBindingBind = ItemBlackBoardFileBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemBlackBoardFileBindingBind, "bind(holder.itemView)");
                itemBlackBoardFileBindingBind.tvSubject.setText(item.getSubjectName() + '_' + TimeUtil.formatTime(item.getTime(), "yyyyMMddHHmmss", "yyyyMMdd_HHmmss"));
                itemBlackBoardFileBindingBind.ivIcon.setImageBitmap(BitmapFactory.decodeFile(item.getFilePath()));
            }
        };
    }

    public static final /* synthetic */ FragmentBlackBroadHistoryBinding access$getBinding(BlackBoardHistoryFragment blackBoardHistoryFragment) {
        return blackBoardHistoryFragment.getBinding();
    }

    /* JADX INFO: compiled from: BlackBoardHistoryFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardHistoryFragment$Companion;", "", "()V", "SUBJECT_NAME", "", "getSUBJECT_NAME", "()Ljava/lang/String;", "newInstance", "Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardHistoryFragment;", AppMeasurementSdk.ConditionalUserProperty.NAME, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getSUBJECT_NAME() {
            return BlackBoardHistoryFragment.SUBJECT_NAME;
        }

        public final BlackBoardHistoryFragment newInstance(String name) {
            BlackBoardHistoryFragment blackBoardHistoryFragment = new BlackBoardHistoryFragment();
            Bundle bundle = new Bundle();
            bundle.putString(BlackBoardHistoryFragment.INSTANCE.getSUBJECT_NAME(), name);
            blackBoardHistoryFragment.setArguments(bundle);
            return blackBoardHistoryFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BlackBoardViewModel getViewModel() {
        return (BlackBoardViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initViewModel();
    }

    private final void initView() {
        getBinding().mu.setViewState(2);
        getBinding().rvHome.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().rvHome.setAdapter(this.homeAdapter);
        setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.blackboard.-$$Lambda$BlackBoardHistoryFragment$bH8-B3PW_exWiS_O8IIWz-3TxBE
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                BlackBoardHistoryFragment.initView$lambda$0(this.f$0, baseQuickAdapter, view, i);
            }
        });
        getBinding().tvSubject.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.blackboard.-$$Lambda$BlackBoardHistoryFragment$atpy5KPEhSWnbyGEb7-kftv9TwY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BlackBoardHistoryFragment.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().rvContent.setLayoutManager(new GridLayoutManager(requireContext(), 4));
        getBinding().rvContent.setAdapter(this.contentAdapter);
        setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.blackboard.-$$Lambda$BlackBoardHistoryFragment$hDPzK4ohvFG29zJzxSjRBFC9PhI
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                BlackBoardHistoryFragment.initView$lambda$2(this.f$0, baseQuickAdapter, view, i);
            }
        });
        getBinding().rvChild.setLayoutManager(new GridLayoutManager(requireContext(), 4));
        getBinding().rvChild.setAdapter(this.childAdapter);
        setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.blackboard.-$$Lambda$BlackBoardHistoryFragment$fO9U3mRUeEuQ8PoWCJz9j44ZgHE
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                BlackBoardHistoryFragment.initView$lambda$3(this.f$0, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(BlackBoardHistoryFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.position = i;
        BlackBoardModel item = this$0.homeAdapter.getItem(i);
        BlackBoardViewModel viewModel = this$0.getViewModel();
        String subjectName = item.getSubjectName();
        if (subjectName == null) {
            subjectName = "";
        }
        viewModel.getSubjectHistoryStatisticsList(subjectName);
        this$0.getBinding().rvContent.setVisibility(0);
        this$0.getBinding().rvChild.setVisibility(4);
        this$0.getBinding().tvSubjectName.setText("");
        this$0.homeAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(BlackBoardHistoryFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().rvContent.setVisibility(0);
        this$0.getBinding().rvChild.setVisibility(4);
        this$0.getBinding().tvSubjectName.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(BlackBoardHistoryFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        BlackBoardModel item = this$0.contentAdapter.getItem(i);
        this$0.getBinding().tvSubjectName.setText('/' + item.getSubjectName());
        BlackBoardViewModel viewModel = this$0.getViewModel();
        String time = item.getTime();
        if (time == null) {
            time = "";
        }
        viewModel.getTodaytTableList(time);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(BlackBoardHistoryFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        BitmapShowActivity.Companion companion = BitmapShowActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.start(contextRequireContext, this$0.childAdapter.getItem(i).getFilePath());
    }

    private final void initViewModel() {
        SingleLiveEvent<List<BlackBoardModel>> singleSubjectList = getViewModel().getSingleSubjectList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        final Function1<List<BlackBoardModel>, Unit> function1 = new Function1<List<BlackBoardModel>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardHistoryFragment.initViewModel.1
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
                BlackBoardHistoryFragment.access$getBinding(BlackBoardHistoryFragment.this).rvContent.setVisibility(4);
                BlackBoardHistoryFragment.access$getBinding(BlackBoardHistoryFragment.this).rvChild.setVisibility(0);
                Log.d("initViewModel", GsonUtils.toJson(list));
                setList(list);
            }
        };
        singleSubjectList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.blackboard.-$$Lambda$BlackBoardHistoryFragment$i6YziD081C54b52n60vAKj5ShUA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BlackBoardHistoryFragment.initViewModel$lambda$4(function1, obj);
            }
        });
        SingleLiveEvent<List<BlackBoardModel>> historyList = getViewModel().getHistoryList();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        final Function1<List<BlackBoardModel>, Unit> function2 = new Function1<List<BlackBoardModel>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardHistoryFragment.initViewModel.2
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
                setList(list);
            }
        };
        historyList.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.blackboard.-$$Lambda$BlackBoardHistoryFragment$-XMT0SZe4Y3_zmaJYcTiSaPAA7I
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BlackBoardHistoryFragment.initViewModel$lambda$5(function2, obj);
            }
        });
        SingleLiveEvent<List<BlackBoardModel>> allSubjectList = getViewModel().getAllSubjectList();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        final Function1<List<BlackBoardModel>, Unit> function3 = new Function1<List<BlackBoardModel>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardHistoryFragment.initViewModel.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<BlackBoardModel> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<BlackBoardModel> it2) {
                setList(it2);
                Bundle arguments = BlackBoardHistoryFragment.this.getArguments();
                String string = arguments != null ? arguments.getString(BlackBoardHistoryFragment.INSTANCE.getSUBJECT_NAME()) : null;
                int i = 0;
                if (it2.size() > 0) {
                    BlackBoardHistoryFragment.access$getBinding(BlackBoardHistoryFragment.this).mu.setViewState(0);
                    if (TextUtils.isEmpty(string)) {
                        string = String.valueOf(it2.get(0).getSubjectName());
                    }
                }
                ArrayList arrayList = new ArrayList();
                BlackBoardModel blackBoardModel = new BlackBoardModel(null, null, null, null, 15, null);
                if (!TextUtils.isEmpty(string)) {
                    Intrinsics.checkNotNullExpressionValue(it2, "it");
                    BlackBoardHistoryFragment blackBoardHistoryFragment = BlackBoardHistoryFragment.this;
                    for (Object obj : it2) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        BlackBoardModel blackBoardModel2 = (BlackBoardModel) obj;
                        if (Intrinsics.areEqual(blackBoardModel2.getSubjectName(), string)) {
                            List<BlackBoardModel> list = blackBoardModel2.getList();
                            Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.MutableList<com.yd.android_brand_mvp.landscape.blackboard.BlackBoardModel>");
                            arrayList = TypeIntrinsics.asMutableList(list);
                            blackBoardHistoryFragment.position = i;
                            blackBoardModel = blackBoardModel2;
                        }
                        i = i2;
                    }
                }
                if (arrayList.size() > 0 && arrayList.size() >= BlackBoardHistoryFragment.this.position) {
                    blackBoardModel = it2.get(BlackBoardHistoryFragment.this.position);
                    List<BlackBoardModel> list2 = it2.get(BlackBoardHistoryFragment.this.position).getList();
                    Intrinsics.checkNotNull(list2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.yd.android_brand_mvp.landscape.blackboard.BlackBoardModel>");
                    TypeIntrinsics.asMutableList(list2);
                }
                TextView textView = BlackBoardHistoryFragment.access$getBinding(BlackBoardHistoryFragment.this).tvSubjectName;
                StringBuilder sb = new StringBuilder();
                sb.append('/');
                BlackBoardModel blackBoardModel3 = blackBoardModel;
                sb.append(blackBoardModel3.getSubjectName());
                textView.setText(sb.toString());
                BlackBoardViewModel viewModel = BlackBoardHistoryFragment.this.getViewModel();
                String subjectName = blackBoardModel3.getSubjectName();
                if (subjectName == null) {
                    subjectName = "";
                }
                viewModel.getSubjectHistoryStatisticsList(subjectName);
            }
        };
        allSubjectList.observe(viewLifecycleOwner3, new Observer() { // from class: com.yd.android_brand_mvp.landscape.blackboard.-$$Lambda$BlackBoardHistoryFragment$L4nT8lqFFw4_KoiHMPgfgETfnQQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BlackBoardHistoryFragment.initViewModel$lambda$6(function3, obj);
            }
        });
        getViewModel().m296getAllSubjectList();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
