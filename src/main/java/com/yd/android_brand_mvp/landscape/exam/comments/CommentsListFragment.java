package com.yd.android_brand_mvp.landscape.exam.comments;

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
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.yd.android_brand_mvp.adapter.comments.CommentsListAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.CommentsListFragmentBinding;
import com.yd.android_brand_mvp.model.comments.CommentsDetailBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
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

/* JADX INFO: compiled from: CommentsListFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002#$B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020\u0019H\u0002J\u0006\u0010!\u001a\u00020\u0019J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsListFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/CommentsListFragmentBinding;", "()V", "isRefresh", "", "()Z", "setRefresh", "(Z)V", "isShow", "setShow", "mAdapter", "Lcom/yd/android_brand_mvp/adapter/comments/CommentsListAdapter;", "mCommentsDetail", "Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsListFragment$CommentsDetail;", "pageNo", "", "pageSize", "viewModel", "Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initLoadMore", "", "initModel", "initView", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "request", "requestData", "setOnCommentsDetail", "CommentsDetail", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommentsListFragment extends KTBaseFragment<CommentsListFragmentBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean isRefresh;
    private boolean isShow;
    private final CommentsListAdapter mAdapter;
    private CommentsDetail mCommentsDetail;
    private int pageNo;
    private int pageSize;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: CommentsListFragment.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsListFragment$CommentsDetail;", "", "onDetail", "", "id", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CommentsDetail {
        void onDetail(String id);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.comments.CommentsListFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommentsListFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, CommentsListFragmentBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, CommentsListFragmentBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/CommentsListFragmentBinding;", 0);
        }

        public final CommentsListFragmentBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return CommentsListFragmentBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ CommentsListFragmentBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ CommentsListFragmentBinding access$getBinding(CommentsListFragment commentsListFragment) {
        return commentsListFragment.getBinding();
    }

    public CommentsListFragment() {
        super(AnonymousClass1.INSTANCE);
        final CommentsListFragment commentsListFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.CommentsListFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return commentsListFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.CommentsListFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(commentsListFragment, Reflection.getOrCreateKotlinClass(CommentsViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.CommentsListFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.CommentsListFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.CommentsListFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = commentsListFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.mAdapter = new CommentsListAdapter();
        this.pageNo = 1;
        this.pageSize = 20;
    }

    /* JADX INFO: compiled from: CommentsListFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsListFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsListFragment;", CommentsHomeFragment.TYPE_ID, "", CommentsHomeFragment.TYPE_CLASSESID, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CommentsListFragment newInstance(String studentId, String classesId) {
            Intrinsics.checkNotNullParameter(studentId, "studentId");
            Intrinsics.checkNotNullParameter(classesId, "classesId");
            CommentsListFragment commentsListFragment = new CommentsListFragment();
            Bundle bundle = new Bundle();
            bundle.putString(CommentsHomeFragment.TYPE_ID, studentId);
            bundle.putString(CommentsHomeFragment.TYPE_CLASSESID, classesId);
            commentsListFragment.setArguments(bundle);
            return commentsListFragment;
        }
    }

    private final CommentsViewModel getViewModel() {
        return (CommentsViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: renamed from: isRefresh, reason: from getter */
    public final boolean getIsRefresh() {
        return this.isRefresh;
    }

    public final void setRefresh(boolean z) {
        this.isRefresh = z;
    }

    /* JADX INFO: renamed from: isShow, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    public final void setShow(boolean z) {
        this.isShow = z;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.isShow = true;
        initView();
        initModel();
        initLoadMore();
    }

    private final void initView() {
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        getBinding().mu.setViewState(3);
        request();
        this.mAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.-$$Lambda$CommentsListFragment$ZhgszktyI5Nx1Rs84p2ZxPPOgi0
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CommentsListFragment.initView$lambda$0(this.f$0, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(CommentsListFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        CommentsDetail commentsDetail = this$0.mCommentsDetail;
        if (commentsDetail != null) {
            commentsDetail.onDetail(this$0.mAdapter.getItem(i).getId());
        }
    }

    private final void initModel() {
        LiveData<Result<BasePageResponse<List<CommentsDetailBean>>>> commentsListLiveData = getViewModel().getCommentsListLiveData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends BasePageResponse<List<CommentsDetailBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<CommentsDetailBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.CommentsListFragment.initModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<CommentsDetailBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<CommentsDetailBean>>> it2) {
                CommentsListFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (!Result.m598isSuccessimpl(it2.getValue())) {
                    if (CommentsListFragment.this.pageNo == 1) {
                        CommentsListFragment.access$getBinding(CommentsListFragment.this).mu.setViewState(1);
                        return;
                    }
                    return;
                }
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                BasePageResponse basePageResponse = (BasePageResponse) value;
                if ((basePageResponse != null ? (List) basePageResponse.getList() : null) != null) {
                    CommentsListFragment.access$getBinding(CommentsListFragment.this).mu.setViewState(0);
                    CommentsListFragment.this.mAdapter.setList((Collection) basePageResponse.getList());
                    if (CommentsListFragment.this.pageNo == 1) {
                        CommentsListFragment.this.mAdapter.setList((Collection) basePageResponse.getList());
                    } else {
                        CommentsListFragment.this.mAdapter.addData((Collection) basePageResponse.getList());
                    }
                    if (((List) basePageResponse.getList()).size() < CommentsListFragment.this.pageSize) {
                        BaseLoadMoreModule.loadMoreEnd$default(CommentsListFragment.this.mAdapter.getLoadMoreModule(), false, 1, null);
                    } else {
                        CommentsListFragment.this.mAdapter.getLoadMoreModule().loadMoreComplete();
                    }
                }
            }
        };
        commentsListLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.-$$Lambda$CommentsListFragment$_Dq4O-O_XcfzeNm_otMSyICl94M
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommentsListFragment.initModel$lambda$1(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initModel$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initLoadMore() {
        this.mAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.-$$Lambda$CommentsListFragment$HYitV3Pi5mbqLLcqSOlyorlIq5Y
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                CommentsListFragment.initLoadMore$lambda$2(this.f$0);
            }
        });
        this.mAdapter.getLoadMoreModule().setAutoLoadMore(true);
        this.mAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLoadMore$lambda$2(CommentsListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAdapter.getLoadMoreModule().setEnableLoadMore(true);
        this$0.pageNo++;
        this$0.request();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.isRefresh) {
            requestData();
            this.isRefresh = false;
        }
    }

    public final void requestData() {
        this.mAdapter.setList(null);
        getBinding().mu.setViewState(3);
        this.pageNo = 1;
        request();
    }

    private final void request() {
        String strValueOf;
        String str;
        showProgressDialog();
        Bundle arguments = getArguments();
        if (arguments != null) {
            String strValueOf2 = String.valueOf(arguments.getString(CommentsHomeFragment.TYPE_ID));
            strValueOf = String.valueOf(arguments.getString(CommentsHomeFragment.TYPE_CLASSESID));
            str = strValueOf2;
        } else {
            strValueOf = "";
            str = strValueOf;
        }
        getViewModel().commentsList(strValueOf, CommentsHomeFragment.INSTANCE.getType(), str, "", "", this.pageNo, this.pageSize);
    }

    public final void setOnCommentsDetail(CommentsDetail mCommentsDetail) {
        Intrinsics.checkNotNullParameter(mCommentsDetail, "mCommentsDetail");
        this.mCommentsDetail = mCommentsDetail;
    }
}
