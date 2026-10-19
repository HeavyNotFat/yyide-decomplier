package com.yd.android_brand_mvp.activity.honor.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.honor.HonorWallActivity;
import com.yd.android_brand_mvp.activity.honor.viewmodel.HonorWallViewModel;
import com.yd.android_brand_mvp.adapter.honor.HomeBannerHonorAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.databinding.FragmentHomeNormalBannerBinding;
import com.yd.android_brand_mvp.model.honor.HonorWallBean;
import com.yd.android_brand_mvp.model.honor.HonorWallItem;
import com.yd.android_brand_mvp.utils.MMKVUtils;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.websocket.WebSocketEventBean;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeHonorFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/activity/honor/fragment/HomeHonorFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentHomeNormalBannerBinding;", "()V", "bannerAdapter", "Lcom/yd/android_brand_mvp/adapter/honor/HomeBannerHonorAdapter;", "type", "", "viewModel", "Lcom/yd/android_brand_mvp/activity/honor/viewmodel/HonorWallViewModel;", "UpdataEvent", "", "id", "", "initView", "networkReconnection", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomeHonorFragment extends KTBaseFragment<FragmentHomeNormalBannerBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private HomeBannerHonorAdapter bannerAdapter;
    private String type;
    private HonorWallViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.honor.fragment.HomeHonorFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomeHonorFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentHomeNormalBannerBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentHomeNormalBannerBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentHomeNormalBannerBinding;", 0);
        }

        public final FragmentHomeNormalBannerBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentHomeNormalBannerBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentHomeNormalBannerBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public HomeHonorFragment() {
        super(AnonymousClass1.INSTANCE);
    }

    public static final /* synthetic */ FragmentHomeNormalBannerBinding access$getBinding(HomeHonorFragment homeHonorFragment) {
        return homeHonorFragment.getBinding();
    }

    /* JADX INFO: compiled from: HomeHonorFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/honor/fragment/HomeHonorFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "type", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String type) {
            HomeHonorFragment homeHonorFragment = new HomeHonorFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            homeHonorFragment.setArguments(bundle);
            return homeHonorFragment;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.viewModel = (HonorWallViewModel) new ViewModelProvider(this).get(HonorWallViewModel.class);
        Bundle arguments = getArguments();
        HonorWallViewModel honorWallViewModel = null;
        String strValueOf = String.valueOf(arguments != null ? arguments.getString("type") : null);
        this.type = strValueOf;
        if (strValueOf == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
            strValueOf = null;
        }
        switch (strValueOf.hashCode()) {
            case 725755409:
                if (strValueOf.equals("hbryq23")) {
                    getBinding().clFragmentHomeNormal.getLayoutParams().width = SizeUtils.dp2px(444.0f);
                    getBinding().clFragmentHomeNormal.getLayoutParams().height = SizeUtils.dp2px(448.0f);
                }
                break;
            case 725755410:
                if (strValueOf.equals("hbryq24")) {
                    getBinding().clFragmentHomeNormal.getLayoutParams().width = SizeUtils.dp2px(444.0f);
                    getBinding().clFragmentHomeNormal.getLayoutParams().height = SizeUtils.dp2px(604.0f);
                }
                break;
            case 725755474:
                if (strValueOf.equals("hbryq46")) {
                    getBinding().gankInclude.getRoot().setVisibility(8);
                    getBinding().clFragmentHomeNormal.getLayoutParams().width = SizeUtils.dp2px(725.0f);
                    getBinding().clFragmentHomeNormal.getLayoutParams().height = SizeUtils.dp2px(896.0f);
                    getBinding().bannerFragmentHomeNormal.getLayoutParams().height = -1;
                }
                break;
            case 1898361307:
                if (strValueOf.equals("sbryq22")) {
                    getBinding().clFragmentHomeNormal.getLayoutParams().width = SizeUtils.dp2px(320.0f);
                    getBinding().clFragmentHomeNormal.getLayoutParams().height = SizeUtils.dp2px(424.0f);
                }
                break;
            case 1898361338:
                if (strValueOf.equals("sbryq32")) {
                    getBinding().clFragmentHomeNormal.getLayoutParams().width = SizeUtils.dp2px(490.0f);
                    getBinding().clFragmentHomeNormal.getLayoutParams().height = SizeUtils.dp2px(424.0f);
                }
                break;
            case 1898361371:
                if (strValueOf.equals("sbryq44")) {
                    getBinding().clFragmentHomeNormal.getLayoutParams().width = SizeUtils.dp2px(660.0f);
                    getBinding().clFragmentHomeNormal.getLayoutParams().height = SizeUtils.dp2px(868.0f);
                }
                break;
        }
        initView();
        HonorWallViewModel honorWallViewModel2 = this.viewModel;
        if (honorWallViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            honorWallViewModel = honorWallViewModel2;
        }
        honorWallViewModel.getHonorList(1, 5);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment
    public void networkReconnection() {
        super.networkReconnection();
        HonorWallViewModel honorWallViewModel = this.viewModel;
        if (honorWallViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            honorWallViewModel = null;
        }
        honorWallViewModel.getHonorList(1, 5);
    }

    private final void initView() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        HonorWallViewModel honorWallViewModel = null;
        this.bannerAdapter = new HomeBannerHonorAdapter(contextRequireContext, null);
        int iAsColor = SimpleUtilsKt.asColor(R.color.blue12);
        String str = this.type;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
            str = null;
        }
        if (Intrinsics.areEqual("hbryq46", str)) {
            iAsColor = SimpleUtilsKt.asColor(R.color.blue12);
        }
        Banner startPosition = getBinding().bannerFragmentHomeNormal.addBannerLifecycleObserver(this).setStartPosition(1);
        HomeBannerHonorAdapter homeBannerHonorAdapter = this.bannerAdapter;
        if (homeBannerHonorAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerAdapter");
            homeBannerHonorAdapter = null;
        }
        startPosition.setAdapter(homeBannerHonorAdapter).isAutoLoop(true).setLoopTime(5000L).setIndicator(new CircleIndicator(requireContext())).setIndicatorGravity(1).setIndicatorSpace(BannerUtils.dp2px(12.0f)).setIndicatorNormalColor(SimpleUtilsKt.asColor(R.color.gray)).setIndicatorSelectedColor(iAsColor).setIndicatorWidth(BannerUtils.dp2px(10.0f), BannerUtils.dp2px(10.0f)).setIndicatorHeight(BannerUtils.dp2px(10.0f));
        getBinding().gankInclude.title.setText("荣誉墙");
        getBinding().gankInclude.title.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.honor.fragment.-$$Lambda$HomeHonorFragment$9kHB5QebL4o6vZv7h6lL8WEdG2I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeHonorFragment.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().bannerFragmentHomeNormal.setOnBannerListener(new OnBannerListener() { // from class: com.yd.android_brand_mvp.activity.honor.fragment.-$$Lambda$HomeHonorFragment$B6ad0GtHySR72BKEf9PC5jQI320
            @Override // com.youth.banner.listener.OnBannerListener
            public final void OnBannerClick(Object obj, int i) {
                HomeHonorFragment.initView$lambda$1(this.f$0, obj, i);
            }
        });
        HonorWallViewModel honorWallViewModel2 = this.viewModel;
        if (honorWallViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            honorWallViewModel = honorWallViewModel2;
        }
        LiveData<Result<HonorWallBean>> honorList = honorWallViewModel.getHonorList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends HonorWallBean>, Unit> function1 = new Function1<Result<? extends HonorWallBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.honor.fragment.HomeHonorFragment.initView.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends HonorWallBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends HonorWallBean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                HonorWallBean honorWallBean = (HonorWallBean) value;
                if (honorWallBean == null) {
                    return;
                }
                if (!honorWallBean.getList().isEmpty()) {
                    LinearLayout root = HomeHonorFragment.access$getBinding(HomeHonorFragment.this).viewEmpty.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "binding.viewEmpty.root");
                    SimpleUtilsKt.remove(root);
                    HomeHonorFragment.access$getBinding(HomeHonorFragment.this).bannerFragmentHomeNormal.setDatas(honorWallBean.getList());
                    MMKVUtils.INSTANCE.put(MMKVConstant.HONOR_LIST, GsonUtils.toJson(honorWallBean.getList()));
                    return;
                }
                MMKVUtils.INSTANCE.put(MMKVConstant.HONOR_LIST, "");
                LinearLayout root2 = HomeHonorFragment.access$getBinding(HomeHonorFragment.this).viewEmpty.getRoot();
                Intrinsics.checkNotNullExpressionValue(root2, "binding.viewEmpty.root");
                SimpleUtilsKt.show(root2);
            }
        };
        honorList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.honor.fragment.-$$Lambda$HomeHonorFragment$gJyv8lP4W3MwsMgfRGZx3c2a3Mc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeHonorFragment.initView$lambda$2(function1, obj);
            }
        });
        List list = (List) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.HONOR_LIST), new TypeReference<List<? extends HonorWallItem>>() { // from class: com.yd.android_brand_mvp.activity.honor.fragment.HomeHonorFragment$initView$list$1
        }.getType());
        if (list != null) {
            LinearLayout root = getBinding().viewEmpty.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.viewEmpty.root");
            SimpleUtilsKt.remove(root);
            getBinding().bannerFragmentHomeNormal.setDatas(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(HomeHonorFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) HonorWallActivity.class);
        String str = this$0.type;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
            str = null;
        }
        intent.putExtra("isPortrait", Intrinsics.areEqual(str, "sbryq44"));
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(HomeHonorFragment this$0, Object obj, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) HonorWallActivity.class);
        String str = this$0.type;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
            str = null;
        }
        intent.putExtra("isPortrait", Intrinsics.areEqual(str, "sbryq44"));
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
        if (Intrinsics.areEqual(WebSocketEventBean.CODE_TASK_HONOR_WALL, String.valueOf(id))) {
            HonorWallViewModel honorWallViewModel = this.viewModel;
            if (honorWallViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                honorWallViewModel = null;
            }
            honorWallViewModel.getHonorList(1, 5);
        }
    }
}
