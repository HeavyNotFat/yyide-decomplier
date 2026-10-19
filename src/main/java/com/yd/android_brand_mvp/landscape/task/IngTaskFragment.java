package com.yd.android_brand_mvp.landscape.task;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentRecyclerViewBinding;
import com.yd.android_brand_mvp.databinding.ItemSignTaskMyListBinding;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.landscape.task.viewmodel.MyTaskListViewModel;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.model.task.EventTaskBean;
import com.yd.android_brand_mvp.model.task.MyTaskListBean;
import com.yd.android_brand_mvp.model.task.MyTaskListItem;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.jvm.internal.StringCompanionObject;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: IngTaskFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u001a\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010 \u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R#\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/yd/android_brand_mvp/landscape/task/IngTaskFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentRecyclerViewBinding;", "()V", "current", "", "dataAdapter", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/ItemSignTaskMyListBinding;", "Lcom/yd/android_brand_mvp/model/task/MyTaskListItem;", InnerConstant.Db.size, "studentInfo", "Lcom/yd/android_brand_mvp/model/selectNewStudentByIcCardRsp$DataBean;", "kotlin.jvm.PlatformType", "getStudentInfo", "()Lcom/yd/android_brand_mvp/model/selectNewStudentByIcCardRsp$DataBean;", "studentInfo$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/task/viewmodel/MyTaskListViewModel;", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEventMessageHandle", "item", "Lcom/yd/android_brand_mvp/model/task/EventTaskBean;", "onViewCreated", "view", "Landroid/view/View;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IngTaskFragment extends KTBaseFragment<FragmentRecyclerViewBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int current;
    private BaseBindingAdapter<ItemSignTaskMyListBinding, MyTaskListItem> dataAdapter;
    private final int size;

    /* JADX INFO: renamed from: studentInfo$delegate, reason: from kotlin metadata */
    private final Lazy studentInfo;
    private MyTaskListViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.task.IngTaskFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: IngTaskFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentRecyclerViewBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentRecyclerViewBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentRecyclerViewBinding;", 0);
        }

        public final FragmentRecyclerViewBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentRecyclerViewBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentRecyclerViewBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentRecyclerViewBinding access$getBinding(IngTaskFragment ingTaskFragment) {
        return ingTaskFragment.getBinding();
    }

    /* JADX INFO: compiled from: IngTaskFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/task/IngTaskFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/task/IngTaskFragment;", "id", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IngTaskFragment newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            IngTaskFragment ingTaskFragment = new IngTaskFragment();
            Bundle bundle = new Bundle();
            bundle.putString(CommentsHomeFragment.TYPE_ID, id);
            ingTaskFragment.setArguments(bundle);
            return ingTaskFragment;
        }
    }

    public IngTaskFragment() {
        super(AnonymousClass1.INSTANCE);
        this.size = 20;
        this.current = 1;
        this.studentInfo = LazyKt.lazy(new Function0<selectNewStudentByIcCardRsp.DataBean>() { // from class: com.yd.android_brand_mvp.landscape.task.IngTaskFragment$studentInfo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final selectNewStudentByIcCardRsp.DataBean invoke() {
                return SpData.USERCENTINFO2().data;
            }
        });
    }

    private final selectNewStudentByIcCardRsp.DataBean getStudentInfo() {
        return (selectNewStudentByIcCardRsp.DataBean) this.studentInfo.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMessageHandle(EventTaskBean item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getType() == 0) {
            this.current = 1;
            request();
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        request();
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.task.IngTaskFragment$initView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IngTaskFragment.kt */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/yd/android_brand_mvp/landscape/task/IngTaskFragment$initView$1", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/ItemSignTaskMyListBinding;", "Lcom/yd/android_brand_mvp/model/task/MyTaskListItem;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "convertPlus", "", "holder", "Lcom/yd/android_brand_mvp/base/VBViewHolder;", "item", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class C05231 extends BaseBindingAdapter<ItemSignTaskMyListBinding, MyTaskListItem> implements LoadMoreModule {
        C05231() {
            super(null, 1, null);
        }

        @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
        public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, MyTaskListItem myTaskListItem) {
            convertPlus2((VBViewHolder<ItemSignTaskMyListBinding>) vBViewHolder, myTaskListItem);
        }

        /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
        public void convertPlus2(VBViewHolder<ItemSignTaskMyListBinding> holder, MyTaskListItem item) {
            Object next;
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            ItemSignTaskMyListBinding itemSignTaskMyListBinding = (ItemSignTaskMyListBinding) holder.getBinding();
            if (itemSignTaskMyListBinding != null) {
                IngTaskFragment ingTaskFragment = IngTaskFragment.this;
                if (item.getTodayCanSign()) {
                    ConstraintLayout constraintLayout = itemSignTaskMyListBinding.clItemSignTaskState;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout, "it.clItemSignTaskState");
                    SimpleUtilsKt.show(constraintLayout);
                }
                ArrayList arrayList = new ArrayList();
                if (!item.getSubjectList().isEmpty()) {
                    Iterator<T> it2 = item.getSubjectList().iterator();
                    do {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                    } while (!Intrinsics.areEqual((String) next, "不限"));
                    if (next == null) {
                        arrayList.add('(' + ((String) CollectionsKt.first((List) item.getSubjectList())) + ')');
                    }
                }
                itemSignTaskMyListBinding.tvItemSignTaskMyListTitle.setContentAndTag(item.getTaskName(), arrayList);
                TextView textView = itemSignTaskMyListBinding.tvItemSignTaskEndDate;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = ingTaskFragment.getString(R.string.task_sign_endDate);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.task_sign_endDate)");
                String str = String.format(string, Arrays.copyOf(new Object[]{item.getPublishEnd()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                textView.setText(str);
                if (!item.getTodayHaveSign()) {
                    itemSignTaskMyListBinding.clItemSignTaskState.setBackgroundResource(R.drawable.bg_frame_sign_task_ing);
                    itemSignTaskMyListBinding.tvItemSignTaskState.setText("未打卡\r\n" + item.getAlreadySignCount() + '/' + item.getTotalSignCount());
                    return;
                }
                itemSignTaskMyListBinding.clItemSignTaskState.setBackgroundResource(R.drawable.bg_frame_sign_task_ing2);
                itemSignTaskMyListBinding.tvItemSignTaskState.setText("已打卡\r\n" + item.getAlreadySignCount() + '/' + item.getTotalSignCount());
            }
        }

        @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
        public ItemSignTaskMyListBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(parent, "parent");
            ItemSignTaskMyListBinding itemSignTaskMyListBindingInflate = ItemSignTaskMyListBinding.inflate(inflater, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemSignTaskMyListBindingInflate, "inflate(inflater, parent, false)");
            return itemSignTaskMyListBindingInflate;
        }
    }

    private final void initView() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        this.viewModel = (MyTaskListViewModel) new ViewModelProvider(fragmentActivityRequireActivity).get(MyTaskListViewModel.class);
        C05231 c05231 = new C05231();
        this.dataAdapter = c05231;
        MyTaskListViewModel myTaskListViewModel = null;
        if (c05231 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataAdapter");
            c05231 = null;
        }
        c05231.getLoadMoreModule().setAutoLoadMore(true);
        BaseBindingAdapter<ItemSignTaskMyListBinding, MyTaskListItem> baseBindingAdapter = this.dataAdapter;
        if (baseBindingAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataAdapter");
            baseBindingAdapter = null;
        }
        baseBindingAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(true);
        getBinding().rvFragmentContent.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView = getBinding().rvFragmentContent;
        BaseBindingAdapter<ItemSignTaskMyListBinding, MyTaskListItem> baseBindingAdapter2 = this.dataAdapter;
        if (baseBindingAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataAdapter");
            baseBindingAdapter2 = null;
        }
        recyclerView.setAdapter(baseBindingAdapter2);
        BaseBindingAdapter<ItemSignTaskMyListBinding, MyTaskListItem> baseBindingAdapter3 = this.dataAdapter;
        if (baseBindingAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataAdapter");
            baseBindingAdapter3 = null;
        }
        baseBindingAdapter3.setEmptyView(R.layout.item_null_layout_4);
        BaseBindingAdapter<ItemSignTaskMyListBinding, MyTaskListItem> baseBindingAdapter4 = this.dataAdapter;
        if (baseBindingAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataAdapter");
            baseBindingAdapter4 = null;
        }
        baseBindingAdapter4.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.yd.android_brand_mvp.landscape.task.-$$Lambda$IngTaskFragment$d8Km_1iUGm_2xzC4mVJWRwebKS0
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                IngTaskFragment.initView$lambda$0(this.f$0);
            }
        });
        BaseBindingAdapter<ItemSignTaskMyListBinding, MyTaskListItem> baseBindingAdapter5 = this.dataAdapter;
        if (baseBindingAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataAdapter");
            baseBindingAdapter5 = null;
        }
        baseBindingAdapter5.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.task.-$$Lambda$IngTaskFragment$YBEe5IFcTxe-pDSXT-1InH5HoRI
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                IngTaskFragment.initView$lambda$1(baseQuickAdapter, view, i);
            }
        });
        getBinding().srlRecycler.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.yd.android_brand_mvp.landscape.task.-$$Lambda$IngTaskFragment$LxyeWYGUfQTWrEisQOC2849Ky6E
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                IngTaskFragment.initView$lambda$2(this.f$0);
            }
        });
        getBinding().srlRecycler.setColorSchemeColors(SimpleUtilsKt.asColor(R.color.colorPrimary));
        MyTaskListViewModel myTaskListViewModel2 = this.viewModel;
        if (myTaskListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            myTaskListViewModel = myTaskListViewModel2;
        }
        LiveData<Result<MyTaskListBean>> ingList = myTaskListViewModel.getIngList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends MyTaskListBean>, Unit> function1 = new Function1<Result<? extends MyTaskListBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.task.IngTaskFragment.initView.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends MyTaskListBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends MyTaskListBean> it2) {
                IngTaskFragment.access$getBinding(IngTaskFragment.this).srlRecycler.setRefreshing(false);
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                BaseBindingAdapter baseBindingAdapter6 = null;
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                MyTaskListBean myTaskListBean = (MyTaskListBean) value;
                if (myTaskListBean == null) {
                    return;
                }
                if (IngTaskFragment.this.current == 1) {
                    BaseBindingAdapter baseBindingAdapter7 = IngTaskFragment.this.dataAdapter;
                    if (baseBindingAdapter7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataAdapter");
                        baseBindingAdapter7 = null;
                    }
                    baseBindingAdapter7.setList(myTaskListBean.getList());
                } else {
                    BaseBindingAdapter baseBindingAdapter8 = IngTaskFragment.this.dataAdapter;
                    if (baseBindingAdapter8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataAdapter");
                        baseBindingAdapter8 = null;
                    }
                    baseBindingAdapter8.addData((Collection) myTaskListBean.getList());
                }
                if (myTaskListBean.getList().size() < IngTaskFragment.this.size) {
                    BaseBindingAdapter baseBindingAdapter9 = IngTaskFragment.this.dataAdapter;
                    if (baseBindingAdapter9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataAdapter");
                        baseBindingAdapter9 = null;
                    }
                    BaseLoadMoreModule.loadMoreEnd$default(baseBindingAdapter9.getLoadMoreModule(), false, 1, null);
                    return;
                }
                BaseBindingAdapter baseBindingAdapter10 = IngTaskFragment.this.dataAdapter;
                if (baseBindingAdapter10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataAdapter");
                } else {
                    baseBindingAdapter6 = baseBindingAdapter10;
                }
                baseBindingAdapter6.getLoadMoreModule().loadMoreComplete();
            }
        };
        ingList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.task.-$$Lambda$IngTaskFragment$Yt6429bqVDtTGsxdPQ1RzQd5U9c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IngTaskFragment.initView$lambda$3(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(IngTaskFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseBindingAdapter<ItemSignTaskMyListBinding, MyTaskListItem> baseBindingAdapter = this$0.dataAdapter;
        if (baseBindingAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataAdapter");
            baseBindingAdapter = null;
        }
        baseBindingAdapter.getLoadMoreModule().setEnableLoadMore(true);
        this$0.current++;
        this$0.request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object obj = adapter.getData().get(i);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.yd.android_brand_mvp.model.task.MyTaskListItem");
        EventBus.getDefault().post(new EventTaskBean(3, ((MyTaskListItem) obj).getId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(IngTaskFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.current = 1;
        this$0.request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void request() {
        MyTaskListViewModel myTaskListViewModel;
        MyTaskListViewModel myTaskListViewModel2 = this.viewModel;
        if (myTaskListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            myTaskListViewModel = null;
        } else {
            myTaskListViewModel = myTaskListViewModel2;
        }
        int i = this.current;
        int i2 = this.size;
        selectNewStudentByIcCardRsp.DataBean studentInfo = getStudentInfo();
        String str = studentInfo != null ? studentInfo.id : null;
        String str2 = str == null ? "" : str;
        selectNewStudentByIcCardRsp.DataBean studentInfo2 = getStudentInfo();
        String str3 = studentInfo2 != null ? studentInfo2.schoolId : null;
        myTaskListViewModel.getNoStartList("in_progress", i, i2, str2, str3 == null ? "" : str3);
    }
}
