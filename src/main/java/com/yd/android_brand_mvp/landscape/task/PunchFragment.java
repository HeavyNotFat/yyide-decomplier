package com.yd.android_brand_mvp.landscape.task;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.task.BannerTask21Adapter;
import com.yd.android_brand_mvp.adapter.task.BannerTask23Adapter;
import com.yd.android_brand_mvp.adapter.task.BannerTaskAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentHomeTaskSignBinding;
import com.yd.android_brand_mvp.dialog.TaskDetailDialog;
import com.yd.android_brand_mvp.landscape.task.viewmodel.PunchViewModel;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.task.MyTaskListItem;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.websocket.WebSocketEventBean;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PunchFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0003J\u001a\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R#\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/task/PunchFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentHomeTaskSignBinding;", "()V", "banner21Adapter", "Lcom/yd/android_brand_mvp/adapter/task/BannerTask21Adapter;", "banner23Adapter", "Lcom/yd/android_brand_mvp/adapter/task/BannerTask23Adapter;", "bannerAdapter", "Lcom/yd/android_brand_mvp/adapter/task/BannerTaskAdapter;", "info", "Lcom/yd/android_brand_mvp/model/NewBrandLoginRsp$DataBean;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/yd/android_brand_mvp/model/NewBrandLoginRsp$DataBean;", "info$delegate", "Lkotlin/Lazy;", "noDataList", "", "Lcom/yd/android_brand_mvp/model/task/MyTaskListItem;", "type", "", "viewModel", "Lcom/yd/android_brand_mvp/landscape/task/viewmodel/PunchViewModel;", "UpdataEvent", "", "id", "", "initView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PunchFragment extends KTBaseFragment<FragmentHomeTaskSignBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PARAMS2 = "type";
    private BannerTask21Adapter banner21Adapter;
    private BannerTask23Adapter banner23Adapter;
    private BannerTaskAdapter bannerAdapter;

    /* JADX INFO: renamed from: info$delegate, reason: from kotlin metadata */
    private final Lazy info;
    private final List<MyTaskListItem> noDataList;
    private String type;
    private PunchViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.task.PunchFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: PunchFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentHomeTaskSignBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentHomeTaskSignBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentHomeTaskSignBinding;", 0);
        }

        public final FragmentHomeTaskSignBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentHomeTaskSignBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentHomeTaskSignBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentHomeTaskSignBinding access$getBinding(PunchFragment punchFragment) {
        return punchFragment.getBinding();
    }

    public PunchFragment() {
        super(AnonymousClass1.INSTANCE);
        this.noDataList = new ArrayList();
        this.info = LazyKt.lazy(new Function0<NewBrandLoginRsp.DataBean>() { // from class: com.yd.android_brand_mvp.landscape.task.PunchFragment$info$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NewBrandLoginRsp.DataBean invoke() {
                return SpData.NewUser().data;
            }
        });
    }

    /* JADX INFO: compiled from: PunchFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/task/PunchFragment$Companion;", "", "()V", "PARAMS2", "", "newInstance", "Landroidx/fragment/app/Fragment;", "type", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String type) {
            PunchFragment punchFragment = new PunchFragment();
            Bundle bundle = new Bundle();
            bundle.putString(PunchFragment.PARAMS2, type);
            punchFragment.setArguments(bundle);
            return punchFragment;
        }
    }

    private final NewBrandLoginRsp.DataBean getInfo() {
        return (NewBrandLoginRsp.DataBean) this.info.getValue();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        PunchViewModel punchViewModel;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.viewModel = (PunchViewModel) new ViewModelProvider(this).get(PunchViewModel.class);
        Bundle arguments = getArguments();
        String strValueOf = String.valueOf(arguments != null ? arguments.getString(PARAMS2) : null);
        this.type = strValueOf;
        if (strValueOf == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
            strValueOf = null;
        }
        switch (strValueOf.hashCode()) {
            case -1223947007:
                if (strValueOf.equals("hbdk22")) {
                    getBinding().clContent.getLayoutParams().width = SizeUtils.dp2px(444.0f);
                    getBinding().clContent.getLayoutParams().height = SizeUtils.dp2px(292.0f);
                }
                break;
            case -1223947006:
                if (strValueOf.equals("hbdk23")) {
                    getBinding().clContent.getLayoutParams().width = SizeUtils.dp2px(444.0f);
                    getBinding().clContent.getLayoutParams().height = SizeUtils.dp2px(454.0f);
                }
                break;
            case -909026347:
                if (strValueOf.equals("sbdk21")) {
                    getBinding().clContent.getLayoutParams().width = SizeUtils.dp2px(320.0f);
                    getBinding().clContent.getLayoutParams().height = SizeUtils.dp2px(202.0f);
                }
                break;
        }
        initView();
        PunchViewModel punchViewModel2 = this.viewModel;
        if (punchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            punchViewModel = null;
        } else {
            punchViewModel = punchViewModel2;
        }
        PunchViewModel.getHomeList$default(punchViewModel, getInfo().classesId, getInfo().schoolId, 0, 4, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void initView() {
        MyTaskListItem myTaskListItem = new MyTaskListItem(null, null, null, null, null, false, null, null, null, 0, 0, null, null, null, null, false, null, null, 262143, null);
        myTaskListItem.setTaskName("暂无任务");
        myTaskListItem.setTaskDescription("暂无任务");
        this.noDataList.add(myTaskListItem);
        String str = this.type;
        PunchViewModel punchViewModel = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
            str = null;
        }
        switch (str.hashCode()) {
            case -1223947007:
                if (str.equals("hbdk22")) {
                    Context contextRequireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    BannerTaskAdapter bannerTaskAdapter = new BannerTaskAdapter(contextRequireContext, null);
                    this.bannerAdapter = bannerTaskAdapter;
                    if (bannerTaskAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bannerAdapter");
                        bannerTaskAdapter = null;
                    }
                    bannerTaskAdapter.setDatas(this.noDataList);
                    Banner startPosition = getBinding().bannerHomeTask.addBannerLifecycleObserver(this).setStartPosition(1);
                    BannerTaskAdapter bannerTaskAdapter2 = this.bannerAdapter;
                    if (bannerTaskAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bannerAdapter");
                        bannerTaskAdapter2 = null;
                    }
                    startPosition.setAdapter(bannerTaskAdapter2).isAutoLoop(false);
                }
                break;
            case -1223947006:
                if (str.equals("hbdk23")) {
                    Context contextRequireContext2 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                    BannerTask23Adapter bannerTask23Adapter = new BannerTask23Adapter(contextRequireContext2, null);
                    this.banner23Adapter = bannerTask23Adapter;
                    if (bannerTask23Adapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("banner23Adapter");
                        bannerTask23Adapter = null;
                    }
                    bannerTask23Adapter.setDatas(this.noDataList);
                    getBinding().clContent.setBackgroundResource(R.color.transparent);
                    Banner startPosition2 = getBinding().bannerHomeTask.addBannerLifecycleObserver(this).setStartPosition(1);
                    BannerTask23Adapter bannerTask23Adapter2 = this.banner23Adapter;
                    if (bannerTask23Adapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("banner23Adapter");
                        bannerTask23Adapter2 = null;
                    }
                    startPosition2.setAdapter(bannerTask23Adapter2).isAutoLoop(false);
                }
                break;
            case -909026347:
                if (str.equals("sbdk21")) {
                    Context contextRequireContext3 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
                    BannerTask21Adapter bannerTask21Adapter = new BannerTask21Adapter(contextRequireContext3, null);
                    this.banner21Adapter = bannerTask21Adapter;
                    if (bannerTask21Adapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("banner21Adapter");
                        bannerTask21Adapter = null;
                    }
                    bannerTask21Adapter.setDatas(this.noDataList);
                    Banner startPosition3 = getBinding().bannerHomeTask.addBannerLifecycleObserver(this).setStartPosition(1);
                    BannerTask21Adapter bannerTask21Adapter2 = this.banner21Adapter;
                    if (bannerTask21Adapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("banner21Adapter");
                        bannerTask21Adapter2 = null;
                    }
                    startPosition3.setAdapter(bannerTask21Adapter2).isAutoLoop(false);
                }
                break;
        }
        getBinding().bannerHomeTask.setOnBannerListener(new OnBannerListener() { // from class: com.yd.android_brand_mvp.landscape.task.-$$Lambda$PunchFragment$AJd74rzwoyZZ3gnqsOevE8dSj2U
            @Override // com.youth.banner.listener.OnBannerListener
            public final void OnBannerClick(Object obj, int i) {
                PunchFragment.initView$lambda$1(this.f$0, obj, i);
            }
        });
        PunchViewModel punchViewModel2 = this.viewModel;
        if (punchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            punchViewModel = punchViewModel2;
        }
        LiveData<Result<List<MyTaskListItem>>> homeTaskList = punchViewModel.getHomeTaskList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends List<? extends MyTaskListItem>>, Unit> function1 = new Function1<Result<? extends List<? extends MyTaskListItem>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.task.PunchFragment.initView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<? extends MyTaskListItem>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<? extends MyTaskListItem>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                List list = (List) value;
                if (list == null) {
                    return;
                }
                if (!(!list.isEmpty())) {
                    PunchFragment.access$getBinding(PunchFragment.this).bannerHomeTask.setDatas(PunchFragment.this.noDataList);
                } else {
                    PunchFragment.access$getBinding(PunchFragment.this).bannerHomeTask.setDatas(list);
                }
            }
        };
        homeTaskList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.task.-$$Lambda$PunchFragment$gaeDaXtb3sJKY3tX0xNhL0fHjkU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PunchFragment.initView$lambda$2(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(PunchFragment this$0, Object data, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "data");
        MyTaskListItem myTaskListItem = data instanceof MyTaskListItem ? (MyTaskListItem) data : null;
        if (myTaskListItem == null || Intrinsics.areEqual(myTaskListItem.getTaskName(), "暂无任务")) {
            return;
        }
        new TaskDetailDialog(myTaskListItem).show(this$0.getChildFragmentManager(), "detailDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (Intrinsics.areEqual(WebSocketEventBean.CODE_TASK_SIGN_HOME, String.valueOf(id))) {
            PunchViewModel punchViewModel = this.viewModel;
            if (punchViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                punchViewModel = null;
            }
            PunchViewModel.getHomeList$default(punchViewModel, getInfo().classesId, getInfo().schoolId, 0, 4, null);
        }
    }
}
