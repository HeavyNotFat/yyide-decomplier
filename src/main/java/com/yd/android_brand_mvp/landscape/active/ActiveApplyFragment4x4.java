package com.yd.android_brand_mvp.landscape.active;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.active.ActiveDetailsActivity;
import com.yd.android_brand_mvp.activity.active.ActiveListActivity;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentActiveApplyFragment4x4Binding;
import com.yd.android_brand_mvp.databinding.ItemActiveApply4x4Binding;
import com.yd.android_brand_mvp.dialog.UpdateTitleDialog;
import com.yd.android_brand_mvp.landscape.active.viewModel.ActiveApplyFragmentViewModel;
import com.yd.android_brand_mvp.model.active.ActiveRegistrationBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.MMKVUtils;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;
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
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: ActiveApplyFragment4x4.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0005\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0006\u0010\u0016\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\u001a\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/yd/android_brand_mvp/landscape/active/ActiveApplyFragment4x4;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentActiveApplyFragment4x4Binding;", "()V", "mAdapter", "com/yd/android_brand_mvp/landscape/active/ActiveApplyFragment4x4$mAdapter$1", "Lcom/yd/android_brand_mvp/landscape/active/ActiveApplyFragment4x4$mAdapter$1;", "mHandle", "Lcom/yd/android_brand_mvp/landscape/active/ActiveApplyFragment4x4$MyHandler;", "runnable", "Ljava/lang/Runnable;", "selectIndex", "", "viewModel", "Lcom/yd/android_brand_mvp/landscape/active/viewModel/ActiveApplyFragmentViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/active/viewModel/ActiveApplyFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "UpdataEvent", "", "id", "initView", "initViewModel", "onDestroy", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "MyHandler", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActiveApplyFragment4x4 extends KTBaseFragment<FragmentActiveApplyFragment4x4Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LAYOUT_TAG = "layoutTag";
    private final ActiveApplyFragment4x4$mAdapter$1 mAdapter;
    private MyHandler mHandle;
    private final Runnable runnable;
    private int selectIndex;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment4x4$1, reason: invalid class name */
    /* JADX INFO: compiled from: ActiveApplyFragment4x4.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentActiveApplyFragment4x4Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentActiveApplyFragment4x4Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentActiveApplyFragment4x4Binding;", 0);
        }

        public final FragmentActiveApplyFragment4x4Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentActiveApplyFragment4x4Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentActiveApplyFragment4x4Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment4x4$mAdapter$1] */
    public ActiveApplyFragment4x4() {
        super(AnonymousClass1.INSTANCE);
        final ActiveApplyFragment4x4 activeApplyFragment4x4 = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment4x4$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return activeApplyFragment4x4;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment4x4$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(activeApplyFragment4x4, Reflection.getOrCreateKotlinClass(ActiveApplyFragmentViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment4x4$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment4x4$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment4x4$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = activeApplyFragment4x4.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.runnable = new Runnable() { // from class: com.yd.android_brand_mvp.landscape.active.-$$Lambda$ActiveApplyFragment4x4$qgyIwW7A5pMVZ-tzagpjmM8vois
            @Override // java.lang.Runnable
            public final void run() {
                ActiveApplyFragment4x4.runnable$lambda$0(this.f$0);
            }
        };
        this.mAdapter = new BaseQuickAdapter<ActiveRegistrationBean, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment4x4$mAdapter$1
            {
                super(R.layout.item_active_apply_4x4, null, 2, null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, ActiveRegistrationBean item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemActiveApply4x4Binding itemActiveApply4x4BindingBind = ItemActiveApply4x4Binding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemActiveApply4x4BindingBind, "bind(holder.itemView)");
                if (!ScreenUtils.isPortrait()) {
                    if (this.this$0.selectIndex == holder.getAdapterPosition()) {
                        itemActiveApply4x4BindingBind.clContent.setBackgroundResource(R.drawable.bg_fffbad_10);
                    } else {
                        itemActiveApply4x4BindingBind.clContent.setBackgroundResource(R.drawable.bg_white10);
                    }
                } else {
                    GlideUtil.loadRadiusImage(this.this$0.requireContext(), item.getCoverImg(), itemActiveApply4x4BindingBind.ivCover, R.drawable.icon_active_default_bg, SizeUtils.dp2px(10.0f));
                }
                itemActiveApply4x4BindingBind.tvActiveStatus.setText(item.getStatusName());
                itemActiveApply4x4BindingBind.tvActiveTitle.setText(item.getActivityName());
                TextView textView = itemActiveApply4x4BindingBind.tvActiveObject;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("报名对象：%s", Arrays.copyOf(new Object[]{item.getRangeNames()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                textView.setText(str);
                TextView textView2 = itemActiveApply4x4BindingBind.tvActiveDate;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str2 = String.format("活动时间：%s 至 %s", Arrays.copyOf(new Object[]{item.getActivityStartTime(), item.getActivityEndTime()}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                textView2.setText(str2);
                TextView textView3 = itemActiveApply4x4BindingBind.tvActiveApplyDate;
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String str3 = String.format("报名时间：%s 至 %s", Arrays.copyOf(new Object[]{item.getRegisterStartTime(), item.getRegisterEndTime()}, 2));
                Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
                textView3.setText(str3);
                if (item.getTotal() <= 0) {
                    TextView textView4 = itemActiveApply4x4BindingBind.tvActiveTotal;
                    if (textView4 != null) {
                        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                        String str4 = String.format("总报名额度：%s", Arrays.copyOf(new Object[]{"不限制"}, 1));
                        Intrinsics.checkNotNullExpressionValue(str4, "format(format, *args)");
                        textView4.setText(str4);
                    }
                } else {
                    TextView textView5 = itemActiveApply4x4BindingBind.tvActiveTotal;
                    if (textView5 != null) {
                        StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
                        String str5 = String.format("总报名额度：%s", Arrays.copyOf(new Object[]{Integer.valueOf(item.getTotal())}, 1));
                        Intrinsics.checkNotNullExpressionValue(str5, "format(format, *args)");
                        textView5.setText(str5);
                    }
                }
                TextView textView6 = itemActiveApply4x4BindingBind.tvActiveAlreadyRegisteredNumber;
                if (textView6 != null) {
                    StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
                    String str6 = String.format("已报名：%s", Arrays.copyOf(new Object[]{Integer.valueOf(item.getEnrollCount())}, 1));
                    Intrinsics.checkNotNullExpressionValue(str6, "format(format, *args)");
                    textView6.setText(str6);
                }
                String statusName = item.getStatusName();
                if (Intrinsics.areEqual(statusName, "未开始")) {
                    itemActiveApply4x4BindingBind.tvActiveStatus.setBackgroundResource(R.drawable.bg_ffac08_50);
                } else if (Intrinsics.areEqual(statusName, "已结束")) {
                    itemActiveApply4x4BindingBind.tvActiveStatus.setBackgroundResource(R.drawable.bg_3eaef3_50);
                } else {
                    itemActiveApply4x4BindingBind.tvActiveStatus.setBackgroundResource(R.drawable.bg_4cc89b_50);
                }
            }
        };
    }

    public static final /* synthetic */ FragmentActiveApplyFragment4x4Binding access$getBinding(ActiveApplyFragment4x4 activeApplyFragment4x4) {
        return activeApplyFragment4x4.getBinding();
    }

    /* JADX INFO: compiled from: ActiveApplyFragment4x4.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/active/ActiveApplyFragment4x4$Companion;", "", "()V", "LAYOUT_TAG", "", "getLAYOUT_TAG", "()Ljava/lang/String;", "newInstance", "Lcom/yd/android_brand_mvp/landscape/active/ActiveApplyFragment4x4;", "layoutTag", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getLAYOUT_TAG() {
            return ActiveApplyFragment4x4.LAYOUT_TAG;
        }

        public final ActiveApplyFragment4x4 newInstance(String layoutTag) {
            Intrinsics.checkNotNullParameter(layoutTag, "layoutTag");
            ActiveApplyFragment4x4 activeApplyFragment4x4 = new ActiveApplyFragment4x4();
            Bundle bundle = new Bundle();
            bundle.putString(ActiveApplyFragment4x4.INSTANCE.getLAYOUT_TAG(), layoutTag);
            activeApplyFragment4x4.setArguments(bundle);
            return activeApplyFragment4x4;
        }
    }

    private final ActiveApplyFragmentViewModel getViewModel() {
        return (ActiveApplyFragmentViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.mHandle = new MyHandler(this);
        initView();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (2401 == id) {
            getViewModel().getActiveList(1, 3);
        }
    }

    /* JADX INFO: compiled from: ActiveApplyFragment4x4.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/active/ActiveApplyFragment4x4$MyHandler;", "Landroid/os/Handler;", "mainActivity", "Lcom/yd/android_brand_mvp/landscape/active/ActiveApplyFragment4x4;", "(Lcom/yd/android_brand_mvp/landscape/active/ActiveApplyFragment4x4;)V", "mWeakReference", "Ljava/lang/ref/WeakReference;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class MyHandler extends Handler {
        private final WeakReference<ActiveApplyFragment4x4> mWeakReference;

        public MyHandler(ActiveApplyFragment4x4 mainActivity) {
            Intrinsics.checkNotNullParameter(mainActivity, "mainActivity");
            this.mWeakReference = new WeakReference<>(mainActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            ActiveApplyFragment4x4 activeApplyFragment4x4 = this.mWeakReference.get();
            Intrinsics.checkNotNull(activeApplyFragment4x4);
            if (activeApplyFragment4x4.mAdapter.getData().size() > 0) {
                ActiveApplyFragment4x4 activeApplyFragment4x5 = this.mWeakReference.get();
                Intrinsics.checkNotNull(activeApplyFragment4x5);
                activeApplyFragment4x5.selectIndex++;
                ActiveApplyFragment4x4 activeApplyFragment4x6 = this.mWeakReference.get();
                Intrinsics.checkNotNull(activeApplyFragment4x6);
                int i = activeApplyFragment4x6.selectIndex;
                ActiveApplyFragment4x4 activeApplyFragment4x7 = this.mWeakReference.get();
                Intrinsics.checkNotNull(activeApplyFragment4x7);
                if (i >= activeApplyFragment4x7.mAdapter.getData().size()) {
                    ActiveApplyFragment4x4 activeApplyFragment4x8 = this.mWeakReference.get();
                    Intrinsics.checkNotNull(activeApplyFragment4x8);
                    activeApplyFragment4x8.selectIndex = 0;
                }
                ActiveApplyFragment4x4 activeApplyFragment4x9 = this.mWeakReference.get();
                Intrinsics.checkNotNull(activeApplyFragment4x9);
                Context contextRequireContext = activeApplyFragment4x9.requireContext();
                ActiveApplyFragment4x4 activeApplyFragment4x10 = this.mWeakReference.get();
                Intrinsics.checkNotNull(activeApplyFragment4x10);
                ActiveApplyFragment4x4$mAdapter$1 activeApplyFragment4x4$mAdapter$1 = activeApplyFragment4x10.mAdapter;
                ActiveApplyFragment4x4 activeApplyFragment4x11 = this.mWeakReference.get();
                Intrinsics.checkNotNull(activeApplyFragment4x11);
                String coverImg = activeApplyFragment4x4$mAdapter$1.getItem(activeApplyFragment4x11.selectIndex).getCoverImg();
                ActiveApplyFragment4x4 activeApplyFragment4x12 = this.mWeakReference.get();
                Intrinsics.checkNotNull(activeApplyFragment4x12);
                GlideUtil.loadRadiusImage(contextRequireContext, coverImg, ActiveApplyFragment4x4.access$getBinding(activeApplyFragment4x12).ivCover, R.drawable.icon_active_default_bg, 10);
                ActiveApplyFragment4x4 activeApplyFragment4x13 = this.mWeakReference.get();
                Intrinsics.checkNotNull(activeApplyFragment4x13);
                activeApplyFragment4x13.mAdapter.notifyDataSetChanged();
            }
            ActiveApplyFragment4x4 activeApplyFragment4x14 = this.mWeakReference.get();
            Intrinsics.checkNotNull(activeApplyFragment4x14);
            MyHandler myHandler = activeApplyFragment4x14.mHandle;
            if (myHandler != null) {
                ActiveApplyFragment4x4 activeApplyFragment4x15 = this.mWeakReference.get();
                Intrinsics.checkNotNull(activeApplyFragment4x15);
                myHandler.postDelayed(activeApplyFragment4x15.runnable, 5000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runnable$lambda$0(ActiveApplyFragment4x4 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Message message = new Message();
        MyHandler myHandler = this$0.mHandle;
        if (myHandler != null) {
            myHandler.sendMessage(message);
        }
    }

    public final void initView() {
        final String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(LAYOUT_TAG)) == null) {
            string = "";
        }
        String string2 = MMKVUtils.INSTANCE.getString(string);
        TextView textView = getBinding().top.title;
        String string3 = string2;
        if (TextUtils.isEmpty(string3)) {
            string3 = getString(R.string.active_apply_title);
        }
        textView.setText(string3);
        TextView textView2 = getBinding().top.tvLayoutHeadSubTitle;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.top.tvLayoutHeadSubTitle");
        SimpleUtilsKt.show(textView2);
        getBinding().top.tvLayoutHeadSubTitle.setText(getString(R.string.view_more_title));
        getBinding().top.tvLayoutHeadSubTitle.setTextColor(getResources().getColor(R.color.purple2));
        getBinding().top.tvLayoutHeadSubTitle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.active.-$$Lambda$ActiveApplyFragment4x4$EdjAItL8GVv3XwewJV9LTsdmaqo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActiveApplyFragment4x4.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().top.title.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.yd.android_brand_mvp.landscape.active.-$$Lambda$ActiveApplyFragment4x4$9ggCO2I1XM81bRuKghQZcS1squs
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return ActiveApplyFragment4x4.initView$lambda$2(string, this, view);
            }
        });
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        setEmptyView(R.layout.item_min_null_layout_2_2);
        setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.active.-$$Lambda$ActiveApplyFragment4x4$ygw7n302CHQENrRqnDHKTFgkfas
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ActiveApplyFragment4x4.initView$lambda$3(this.f$0, baseQuickAdapter, view, i);
            }
        });
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(ActiveApplyFragment4x4 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActiveListActivity.Companion companion = ActiveListActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.startGo(contextRequireContext, this$0.getBinding().top.title.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$2(final String tagLayout, final ActiveApplyFragment4x4 this$0, View view) {
        Intrinsics.checkNotNullParameter(tagLayout, "$tagLayout");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UpdateTitleDialog updateTitleDialog = new UpdateTitleDialog(tagLayout, this$0.getBinding().top.title.getText().toString());
        updateTitleDialog.setCallBack(new UpdateTitleDialog.CallBack() { // from class: com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment4x4$initView$2$1
            @Override // com.yd.android_brand_mvp.dialog.UpdateTitleDialog.CallBack
            public void clickSubmit() {
                String string = MMKVUtils.INSTANCE.getString(tagLayout);
                TextView textView = ActiveApplyFragment4x4.access$getBinding(this$0).top.title;
                String string2 = string;
                if (TextUtils.isEmpty(string2)) {
                    string2 = this$0.getString(R.string.active_apply_title);
                }
                textView.setText(string2);
            }
        });
        updateTitleDialog.show(this$0.getParentFragmentManager(), "updateTitleDialog");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(ActiveApplyFragment4x4 this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (this$0.secondaryPagePermissions()) {
            ActiveRegistrationBean item = this$0.mAdapter.getItem(i);
            ActiveDetailsActivity.Companion companion = ActiveDetailsActivity.INSTANCE;
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.startGo(contextRequireContext, item.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void initViewModel() {
        MutableLiveData<Result<BasePageResponse<List<ActiveRegistrationBean>>>> activeList = getViewModel().getActiveList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends BasePageResponse<List<ActiveRegistrationBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<ActiveRegistrationBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment4x4.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<ActiveRegistrationBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<ActiveRegistrationBean>>> it2) {
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append("获取活动报名4x4：");
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                sb.append(GsonUtils.toJson(value));
                objArr[0] = sb.toString();
                LogUtils.i(objArr);
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value2 = it2.getValue();
                    BasePageResponse basePageResponse = (BasePageResponse) (Result.m597isFailureimpl(value2) ? null : value2);
                    if (basePageResponse != null) {
                        ActiveApplyFragment4x4 activeApplyFragment4x4 = ActiveApplyFragment4x4.this;
                        activeApplyFragment4x4.mAdapter.setList((Collection) basePageResponse.getList());
                        if (ScreenUtils.isLandscape()) {
                            MyHandler myHandler = activeApplyFragment4x4.mHandle;
                            if (myHandler != null) {
                                myHandler.removeCallbacks(activeApplyFragment4x4.runnable);
                            }
                            MyHandler myHandler2 = activeApplyFragment4x4.mHandle;
                            if (myHandler2 != null) {
                                myHandler2.postDelayed(activeApplyFragment4x4.runnable, 5000L);
                            }
                        }
                    }
                }
            }
        };
        activeList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.active.-$$Lambda$ActiveApplyFragment4x4$z3Zpe4KtbGbtlnr3voZEY_zZGa8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveApplyFragment4x4.initViewModel$lambda$4(function1, obj);
            }
        });
        getViewModel().getActiveList(1, 3);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MyHandler myHandler = this.mHandle;
        if (myHandler != null) {
            myHandler.removeCallbacks(this.runnable);
        }
    }
}
