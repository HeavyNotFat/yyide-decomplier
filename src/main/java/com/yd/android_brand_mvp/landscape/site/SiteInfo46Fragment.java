package com.yd.android_brand_mvp.landscape.site;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
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
import androidx.work.WorkRequest;
import com.blankj.utilcode.util.SizeUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.home.BannerImageAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.databinding.FragmentSiteInfo46Binding;
import com.yd.android_brand_mvp.landscape.viewmodel.SiteInfoViewModel;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.SiteInfoBean;
import com.yd.android_brand_mvp.utils.MMKVUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.youth.banner.indicator.CircleIndicator;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SiteInfo46Fragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u001a\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/site/SiteInfo46Fragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentSiteInfo46Binding;", "()V", "adapter", "Lcom/yd/android_brand_mvp/adapter/home/BannerImageAdapter;", "getAdapter", "()Lcom/yd/android_brand_mvp/adapter/home/BannerImageAdapter;", "setAdapter", "(Lcom/yd/android_brand_mvp/adapter/home/BannerImageAdapter;)V", "type", "", "viewModel", "Lcom/yd/android_brand_mvp/landscape/viewmodel/SiteInfoViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/viewmodel/SiteInfoViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "UpdataEvent", "", "id", "", "initView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "setData", "data", "Lcom/yd/android_brand_mvp/model/SiteInfoBean;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SiteInfo46Fragment extends KTBaseFragment<FragmentSiteInfo46Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private BannerImageAdapter adapter;
    private String type;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.site.SiteInfo46Fragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: SiteInfo46Fragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentSiteInfo46Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentSiteInfo46Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentSiteInfo46Binding;", 0);
        }

        public final FragmentSiteInfo46Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentSiteInfo46Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentSiteInfo46Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public SiteInfo46Fragment() {
        super(AnonymousClass1.INSTANCE);
        this.type = "";
        final SiteInfo46Fragment siteInfo46Fragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.site.SiteInfo46Fragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return siteInfo46Fragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.site.SiteInfo46Fragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(siteInfo46Fragment, Reflection.getOrCreateKotlinClass(SiteInfoViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.site.SiteInfo46Fragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.site.SiteInfo46Fragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.site.SiteInfo46Fragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = siteInfo46Fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    /* JADX INFO: compiled from: SiteInfo46Fragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/site/SiteInfo46Fragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "type", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String type) {
            SiteInfo46Fragment siteInfo46Fragment = new SiteInfo46Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            siteInfo46Fragment.setArguments(bundle);
            return siteInfo46Fragment;
        }
    }

    private final SiteInfoViewModel getViewModel() {
        return (SiteInfoViewModel) this.viewModel.getValue();
    }

    public final BannerImageAdapter getAdapter() {
        return this.adapter;
    }

    public final void setAdapter(BannerImageAdapter bannerImageAdapter) {
        this.adapter = bannerImageAdapter;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("type") : null;
        if (string == null) {
            string = "hbcdxx46";
        }
        this.type = string;
        getBinding().topFragmentSiteInfo46.title.setText("场地信息");
        String str = this.type;
        switch (str.hashCode()) {
            case -1728896911:
                if (str.equals("sbcdxx45")) {
                    getBinding().clFragmentSiteInfo.getLayoutParams().width = SizeUtils.dp2px(660.0f);
                    getBinding().clFragmentSiteInfo.getLayoutParams().height = SizeUtils.dp2px(1090.0f);
                }
                break;
            case -1728896846:
                if (str.equals("sbcdxx68")) {
                    getBinding().clFragmentSiteInfo.getLayoutParams().width = SizeUtils.dp2px(1020.0f);
                    getBinding().clFragmentSiteInfo.getLayoutParams().height = SizeUtils.dp2px(1756.0f);
                    getBinding().bannerFragmentSiteInfo46.getLayoutParams().height = SizeUtils.dp2px(990.0f);
                    getBinding().ivFragmentSiteInfo46.setImageResource(R.drawable.icon_site_logo);
                    getBinding().topFragmentSiteInfo46.title.setText(SpData.getSiteName());
                }
                break;
            case 575025885:
                if (str.equals("hbcdxx46")) {
                    getBinding().clFragmentSiteInfo.getLayoutParams().width = SizeUtils.dp2px(908.0f);
                    getBinding().clFragmentSiteInfo.getLayoutParams().height = SizeUtils.dp2px(916.0f);
                }
                break;
            case 1461636382:
                if (str.equals("hbcdxx_machine_46")) {
                    getBinding().clFragmentSiteInfo.getLayoutParams().width = SizeUtils.dp2px(908.0f);
                    getBinding().clFragmentSiteInfo.getLayoutParams().height = SizeUtils.dp2px(916.0f);
                    getBinding().ivFragmentSiteInfo46.setImageResource(R.drawable.icon_site_logo);
                }
                break;
        }
        initView();
        request();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
    }

    private final void initView() {
        ViewStub viewStub = getBinding().emptyViewBottom;
        Intrinsics.checkNotNullExpressionValue(viewStub, "binding.emptyViewBottom");
        viewStub.setVisibility(0);
        ViewStub viewStub2 = getBinding().emptyViewBanner;
        Intrinsics.checkNotNullExpressionValue(viewStub2, "binding.emptyViewBanner");
        viewStub2.setVisibility(0);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        this.adapter = new BannerImageAdapter(contextRequireContext, null, 2, 0 == true ? 1 : 0);
        getBinding().bannerFragmentSiteInfo46.addBannerLifecycleObserver(this).setStartPosition(0).setAdapter(this.adapter).isAutoLoop(true).setIndicator(new CircleIndicator(requireContext())).setIndicatorNormalWidth(SizeUtils.dp2px(8.0f)).setIndicatorSelectedWidth(SizeUtils.dp2px(8.0f)).setIndicatorSelectedColorRes(Intrinsics.areEqual(this.type, "hbcdxx_machine_46") ? R.color.blue3 : R.color.colorPrimaryDark).setIndicatorNormalColorRes(R.color.white10).setLoopTime(WorkRequest.MIN_BACKOFF_MILLIS);
        SiteInfoBean siteInfoBean = (SiteInfoBean) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.SITE_INFO), SiteInfoBean.class);
        if (siteInfoBean != null) {
            setData(siteInfoBean);
        }
        LiveData<Result<SiteInfoBean>> siteInfo = getViewModel().getSiteInfo();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends SiteInfoBean>, Unit> function1 = new Function1<Result<? extends SiteInfoBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.site.SiteInfo46Fragment.initView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends SiteInfoBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends SiteInfoBean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                SiteInfoBean siteInfoBean2 = (SiteInfoBean) value;
                if (siteInfoBean2 == null) {
                    return;
                }
                MMKVUtils.INSTANCE.put(MMKVConstant.SITE_INFO, GsonUtils.toJson(siteInfoBean2));
                SiteInfo46Fragment.this.setData(siteInfoBean2);
            }
        };
        siteInfo.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.site.-$$Lambda$SiteInfo46Fragment$tHxgsn3kLdFGZbLXVXjRLwopgjQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SiteInfo46Fragment.initView$lambda$0(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setData(SiteInfoBean data) {
        getBinding().tvFragmentSiteInfo46Name.setText(data.getName());
        getBinding().tvFragmentSiteInfo46Content.setText("\u3000\u3000" + data.getDescribe());
        ArrayList arrayList = new ArrayList();
        if (data.getImgPaths().length() > 0) {
            Iterator it2 = StringsKt.split$default((CharSequence) data.getImgPaths(), new String[]{Constants.ACCEPT_TIME_SEPARATOR_SP}, false, 0, 6, (Object) null).iterator();
            while (it2.hasNext()) {
                arrayList.add((String) it2.next());
            }
        }
        getBinding().bannerFragmentSiteInfo46.setDatas(arrayList);
        ViewStub viewStub = getBinding().emptyViewBottom;
        Intrinsics.checkNotNullExpressionValue(viewStub, "binding.emptyViewBottom");
        viewStub.setVisibility(data.getDescribe().length() == 0 ? 0 : 8);
        ViewStub viewStub2 = getBinding().emptyViewBanner;
        Intrinsics.checkNotNullExpressionValue(viewStub2, "binding.emptyViewBanner");
        viewStub2.setVisibility(arrayList.isEmpty() ? 0 : 8);
    }

    private final void request() {
        NewBrandLoginRsp.DataBean dataBean = SpData.NewUser().data;
        if (dataBean != null) {
            String str = dataBean.siteId;
            if (str == null || str.length() == 0) {
                return;
            }
            SiteInfoViewModel viewModel = getViewModel();
            String str2 = dataBean.siteId;
            Intrinsics.checkNotNullExpressionValue(str2, "userData.siteId");
            viewModel.getSiteInfo(str2);
        }
    }
}
