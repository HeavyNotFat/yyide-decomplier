package com.yd.android_brand_mvp.landscape.blackboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import androidx.work.WorkRequest;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentBlackBoardFragment4x4Binding;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;
import java.util.List;
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

/* JADX INFO: compiled from: BlackBoardFragment4x4.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardFragment4x4;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentBlackBoardFragment4x4Binding;", "()V", "mImageAdapter", "Lcom/yd/android_brand_mvp/landscape/blackboard/SubjectImageAdapter;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", NotificationCompat.CATEGORY_EVENT, "", "bean", "Lcom/yd/android_brand_mvp/model/EventBean;", "initView", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlackBoardFragment4x4 extends KTBaseFragment<FragmentBlackBoardFragment4x4Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private SubjectImageAdapter mImageAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment4x4$1, reason: invalid class name */
    /* JADX INFO: compiled from: BlackBoardFragment4x4.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentBlackBoardFragment4x4Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentBlackBoardFragment4x4Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentBlackBoardFragment4x4Binding;", 0);
        }

        public final FragmentBlackBoardFragment4x4Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentBlackBoardFragment4x4Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentBlackBoardFragment4x4Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public BlackBoardFragment4x4() {
        super(AnonymousClass1.INSTANCE);
        final BlackBoardFragment4x4 blackBoardFragment4x4 = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment4x4$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return blackBoardFragment4x4;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment4x4$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(blackBoardFragment4x4, Reflection.getOrCreateKotlinClass(BlackBoardViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment4x4$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment4x4$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment4x4$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = blackBoardFragment4x4.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentBlackBoardFragment4x4Binding access$getBinding(BlackBoardFragment4x4 blackBoardFragment4x4) {
        return blackBoardFragment4x4.getBinding();
    }

    /* JADX INFO: compiled from: BlackBoardFragment4x4.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardFragment4x4$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardFragment4x4;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BlackBoardFragment4x4 newInstance() {
            return new BlackBoardFragment4x4();
        }
    }

    private final BlackBoardViewModel getViewModel() {
        return (BlackBoardViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);
        initView();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private final void initView() {
        Banner startPosition;
        Banner adapter;
        Banner bannerIsAutoLoop;
        Banner loopTime;
        Banner indicator;
        Banner indicatorGravity;
        Banner indicatorSpace;
        Banner indicatorNormalColor;
        Banner indicatorSelectedColor;
        Banner indicatorWidth;
        getBinding().top.title.setText("黑板截图");
        getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.blackboard.-$$Lambda$BlackBoardFragment4x4$JDo-_a4KrE0yemaXYjvzGU6cS3M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BlackBoardFragment4x4.initView$lambda$0(this.f$0, view);
            }
        });
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        this.mImageAdapter = new SubjectImageAdapter(contextRequireContext, null);
        getBinding().mu.setViewState(2);
        Banner bannerAddBannerLifecycleObserver = getBinding().banner.addBannerLifecycleObserver(this);
        if (bannerAddBannerLifecycleObserver != null && (startPosition = bannerAddBannerLifecycleObserver.setStartPosition(1)) != null && (adapter = startPosition.setAdapter(this.mImageAdapter)) != null && (bannerIsAutoLoop = adapter.isAutoLoop(true)) != null && (loopTime = bannerIsAutoLoop.setLoopTime(WorkRequest.MIN_BACKOFF_MILLIS)) != null && (indicator = loopTime.setIndicator(new CircleIndicator(requireContext()))) != null && (indicatorGravity = indicator.setIndicatorGravity(1)) != null && (indicatorSpace = indicatorGravity.setIndicatorSpace(BannerUtils.dp2px(10.0f))) != null && (indicatorNormalColor = indicatorSpace.setIndicatorNormalColor(SimpleUtilsKt.asColor(R.color.gray))) != null && (indicatorSelectedColor = indicatorNormalColor.setIndicatorSelectedColor(SimpleUtilsKt.asColor(R.color.blue12))) != null && (indicatorWidth = indicatorSelectedColor.setIndicatorWidth(BannerUtils.dp2px(10.0f), BannerUtils.dp2px(10.0f))) != null) {
            indicatorWidth.setIndicatorHeight(BannerUtils.dp2px(10.0f));
        }
        SubjectImageAdapter subjectImageAdapter = this.mImageAdapter;
        if (subjectImageAdapter != null) {
            subjectImageAdapter.setItemClick(new SubjectImageAdapter.ItemClick() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment4x4.initView.2
                @Override // com.yd.android_brand_mvp.landscape.blackboard.SubjectImageAdapter.ItemClick
                public void onItemClick(BlackBoardModel data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    BlackBoardActivity.Companion companion = BlackBoardActivity.INSTANCE;
                    Context contextRequireContext2 = BlackBoardFragment4x4.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                    String subjectName = data.getSubjectName();
                    if (subjectName == null) {
                        subjectName = "";
                    }
                    companion.start(contextRequireContext2, subjectName);
                }
            });
        }
        SingleLiveEvent<List<BlackBoardModel>> todayList = getViewModel().getTodayList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        final Function1<List<BlackBoardModel>, Unit> function1 = new Function1<List<BlackBoardModel>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment4x4.initView.3
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
                    BlackBoardFragment4x4.access$getBinding(BlackBoardFragment4x4.this).mu.setViewState(2);
                } else {
                    BlackBoardFragment4x4.access$getBinding(BlackBoardFragment4x4.this).mu.setViewState(0);
                }
                BlackBoardFragment4x4.access$getBinding(BlackBoardFragment4x4.this).banner.setDatas(list);
            }
        };
        todayList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.blackboard.-$$Lambda$BlackBoardFragment4x4$EJLaD-QCJYjLK8nrh4fjjUMvqbc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BlackBoardFragment4x4.initView$lambda$1(function1, obj);
            }
        });
        getViewModel().m298getTodayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(BlackBoardFragment4x4 this$0, View view) {
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void event(EventBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        if (bean.Event == 10003) {
            getViewModel().m298getTodayList();
        }
    }
}
