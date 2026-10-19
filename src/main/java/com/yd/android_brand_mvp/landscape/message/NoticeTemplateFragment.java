package com.yd.android_brand_mvp.landscape.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.FragmentNoticeTemplateBinding;
import com.yd.android_brand_mvp.landscape.message.adapter.NoticeTemplateAdapter;
import com.yd.android_brand_mvp.landscape.message.viewmodel.MessageHomeNewViewModel;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import com.yd.android_brand_mvp.portrait.activity.MessageDetailsPActivity;
import com.yd.android_brand_mvp.user.AnnouncementListActivity;
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

/* JADX INFO: compiled from: NoticeTemplateFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\u001a\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/NoticeTemplateFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentNoticeTemplateBinding;", "()V", "mAdapter", "Lcom/yd/android_brand_mvp/landscape/message/adapter/NoticeTemplateAdapter;", "pageNo", "", "pageSize", "viewModel", "Lcom/yd/android_brand_mvp/landscape/message/viewmodel/MessageHomeNewViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/message/viewmodel/MessageHomeNewViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "UpdataEvent", "", "id", "initLoadMore", "initView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoticeTemplateFragment extends KTBaseFragment<FragmentNoticeTemplateBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TYPE = "type";
    private final NoticeTemplateAdapter mAdapter;
    private int pageNo;
    private final int pageSize;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.message.NoticeTemplateFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: NoticeTemplateFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentNoticeTemplateBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentNoticeTemplateBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentNoticeTemplateBinding;", 0);
        }

        public final FragmentNoticeTemplateBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentNoticeTemplateBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentNoticeTemplateBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public NoticeTemplateFragment() {
        super(AnonymousClass1.INSTANCE);
        this.pageSize = 20;
        this.pageNo = 1;
        final NoticeTemplateFragment noticeTemplateFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.message.NoticeTemplateFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return noticeTemplateFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.message.NoticeTemplateFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(noticeTemplateFragment, Reflection.getOrCreateKotlinClass(MessageHomeNewViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.message.NoticeTemplateFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.message.NoticeTemplateFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.message.NoticeTemplateFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = noticeTemplateFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.mAdapter = new NoticeTemplateAdapter();
    }

    /* JADX INFO: compiled from: NoticeTemplateFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/NoticeTemplateFragment$Companion;", "", "()V", "TYPE", "", "newInstance", "Lcom/yd/android_brand_mvp/landscape/message/NoticeTemplateFragment;", "type", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NoticeTemplateFragment newInstance(String type) {
            NoticeTemplateFragment noticeTemplateFragment = new NoticeTemplateFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            noticeTemplateFragment.setArguments(bundle);
            return noticeTemplateFragment;
        }
    }

    private final MessageHomeNewViewModel getViewModel() {
        return (MessageHomeNewViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("type") : null;
        if (Intrinsics.areEqual("sbtzggmb6x4", string)) {
            getBinding().clContent.getLayoutParams().width = SizeUtils.dp2px(1000.0f);
            getBinding().clContent.getLayoutParams().height = SizeUtils.dp2px(878.0f);
        } else if (Intrinsics.areEqual("sbtzggmb6x2", string)) {
            getBinding().clContent.getLayoutParams().width = SizeUtils.dp2px(1000.0f);
            getBinding().clContent.getLayoutParams().height = SizeUtils.dp2px(424.0f);
        }
        initView();
        request();
        getBinding().top.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$NoticeTemplateFragment$FAZGXGEEYx73VAjiIhuthpLiNrI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NoticeTemplateFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
        getBinding().clContent.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$NoticeTemplateFragment$YPwCyc96-Wn1uv50w1-KuY3DqGQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NoticeTemplateFragment.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
        this.mAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$NoticeTemplateFragment$7Rffjzq3Gzt4F-c4wxpsX1DVdEA
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                NoticeTemplateFragment.onViewCreated$lambda$2(this.f$0, baseQuickAdapter, view2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(NoticeTemplateFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) AnnouncementListActivity.class);
        intent.putExtra("type", AnnouncementListActivity.TYPE_ANNOUNCEMENT);
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(NoticeTemplateFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) AnnouncementListActivity.class);
        intent.putExtra("type", AnnouncementListActivity.TYPE_ANNOUNCEMENT);
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(NoticeTemplateFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (this$0.secondaryPagePermissions()) {
            if (ScreenUtils.isLandscape()) {
                Intent intent = new Intent(this$0.getContext(), (Class<?>) AnnouncementListActivity.class);
                intent.putExtra("type", AnnouncementListActivity.TYPE_ANNOUNCEMENT);
                intent.putExtra("id", this$0.mAdapter.getItem(i).getId());
                this$0.goPermissionsActivity(intent);
                return;
            }
            MessageDetailsPActivity.Companion companion = MessageDetailsPActivity.INSTANCE;
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.start(contextRequireContext, AnnouncementListActivity.TYPE_ANNOUNCEMENT, this$0.mAdapter.getItem(i));
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (id == MinaConstants.Notice) {
            this.pageNo = 1;
            request();
        }
    }

    private final void initView() {
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        this.mAdapter.setEmptyView(R.layout.item_nc_null_layout44_x);
        initLoadMore();
        SingleLiveEvent<Result<BasePageResponse<List<MessageItemBean>>>> messageHomeLiveData = getViewModel().getMessageHomeLiveData();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        final Function1<Result<? extends BasePageResponse<List<MessageItemBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<MessageItemBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.message.NoticeTemplateFragment.initView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<MessageItemBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<MessageItemBean>>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    BasePageResponse basePageResponse = (BasePageResponse) value;
                    if (basePageResponse != null) {
                        NoticeTemplateFragment noticeTemplateFragment = NoticeTemplateFragment.this;
                        if (noticeTemplateFragment.pageNo == 1) {
                            noticeTemplateFragment.mAdapter.setList((Collection) basePageResponse.getList());
                        } else {
                            List list = (List) basePageResponse.getList();
                            if (list != null) {
                                noticeTemplateFragment.mAdapter.addData((Collection) list);
                            }
                        }
                        if (basePageResponse.getList() == null || ((List) basePageResponse.getList()).size() >= noticeTemplateFragment.pageSize) {
                            noticeTemplateFragment.mAdapter.getLoadMoreModule().loadMoreComplete();
                            return;
                        } else {
                            BaseLoadMoreModule.loadMoreEnd$default(noticeTemplateFragment.mAdapter.getLoadMoreModule(), false, 1, null);
                            return;
                        }
                    }
                    return;
                }
                Result.m594exceptionOrNullimpl(it2.getValue());
            }
        };
        messageHomeLiveData.observe(fragmentActivityRequireActivity, new Observer() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$NoticeTemplateFragment$ISx1gPg_E4_3mvRUme0dYY0Va14
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NoticeTemplateFragment.initView$lambda$3(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initLoadMore() {
        this.mAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$NoticeTemplateFragment$a0_exUIUR1f8vjB-cla8JFLnjN0
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                NoticeTemplateFragment.initLoadMore$lambda$4(this.f$0);
            }
        });
        this.mAdapter.getLoadMoreModule().setAutoLoadMore(true);
        this.mAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLoadMore$lambda$4(NoticeTemplateFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAdapter.getLoadMoreModule().setEnableLoadMore(true);
        this$0.pageNo++;
        this$0.request();
    }

    private final void request() {
        getViewModel().requestMessageHome(AnnouncementListActivity.TYPE_ANNOUNCEMENT, this.pageNo, this.pageSize);
    }
}
