package com.yd.android_brand_mvp.landscape.site;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
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
import com.yd.android_brand_mvp.databinding.FragmentUniversitySiteInfo66Binding;
import com.yd.android_brand_mvp.landscape.viewmodel.SiteInfoViewModel;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.SiteInfoBean;
import com.yd.android_brand_mvp.model.SiteTeacherBean;
import com.yd.android_brand_mvp.utils.SpData;
import com.youth.banner.indicator.CircleIndicator;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: UniversitySiteInfoFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/site/UniversitySiteInfoFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentUniversitySiteInfo66Binding;", "()V", "type", "", "viewModel", "Lcom/yd/android_brand_mvp/landscape/viewmodel/SiteInfoViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/viewmodel/SiteInfoViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UniversitySiteInfoFragment extends KTBaseFragment<FragmentUniversitySiteInfo66Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String type;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.site.UniversitySiteInfoFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: UniversitySiteInfoFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentUniversitySiteInfo66Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentUniversitySiteInfo66Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentUniversitySiteInfo66Binding;", 0);
        }

        public final FragmentUniversitySiteInfo66Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentUniversitySiteInfo66Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentUniversitySiteInfo66Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public UniversitySiteInfoFragment() {
        super(AnonymousClass1.INSTANCE);
        this.type = "";
        final UniversitySiteInfoFragment universitySiteInfoFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.site.UniversitySiteInfoFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return universitySiteInfoFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.site.UniversitySiteInfoFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(universitySiteInfoFragment, Reflection.getOrCreateKotlinClass(SiteInfoViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.site.UniversitySiteInfoFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.site.UniversitySiteInfoFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.site.UniversitySiteInfoFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = universitySiteInfoFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentUniversitySiteInfo66Binding access$getBinding(UniversitySiteInfoFragment universitySiteInfoFragment) {
        return universitySiteInfoFragment.getBinding();
    }

    /* JADX INFO: compiled from: UniversitySiteInfoFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/site/UniversitySiteInfoFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "type", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String type) {
            UniversitySiteInfoFragment universitySiteInfoFragment = new UniversitySiteInfoFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            universitySiteInfoFragment.setArguments(bundle);
            return universitySiteInfoFragment;
        }
    }

    private final SiteInfoViewModel getViewModel() {
        return (SiteInfoViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("type") : null;
        if (string == null) {
            string = "hbksgl24";
        }
        this.type = string;
        getBinding().clFragmentSiteInfo.getLayoutParams().width = SizeUtils.dp2px(1372.0f);
        getBinding().clFragmentSiteInfo.getLayoutParams().height = SizeUtils.dp2px(916.0f);
        initView();
        request();
    }

    private final void initView() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        getBinding().bannerFragmentSiteInfo66.addBannerLifecycleObserver(this).setStartPosition(0).setAdapter(new BannerImageAdapter(contextRequireContext, null, 2, 0 == true ? 1 : 0)).isAutoLoop(true).setIndicator(new CircleIndicator(requireContext())).setIndicatorNormalWidth(SizeUtils.dp2px(7.0f)).setIndicatorSelectedWidth(SizeUtils.dp2px(7.0f)).setIndicatorSelectedColorRes(R.color.blue3).setIndicatorNormalColorRes(R.color.white10).setLoopTime(WorkRequest.MIN_BACKOFF_MILLIS);
        LiveData<Result<SiteInfoBean>> siteInfo = getViewModel().getSiteInfo();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends SiteInfoBean>, Unit> function1 = new Function1<Result<? extends SiteInfoBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.site.UniversitySiteInfoFragment.initView.1
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
                SiteInfoBean siteInfoBean = (SiteInfoBean) value;
                if (siteInfoBean == null) {
                    return;
                }
                UniversitySiteInfoFragment.access$getBinding(UniversitySiteInfoFragment.this).tvFragmentSiteInfo66Name.setText(siteInfoBean.getName());
                UniversitySiteInfoFragment.access$getBinding(UniversitySiteInfoFragment.this).tvFragmentSiteInfo66TypeContent.setText(siteInfoBean.getSiteTypeName());
                UniversitySiteInfoFragment.access$getBinding(UniversitySiteInfoFragment.this).tvFragmentSiteInfo66RoomNumContent.setText(siteInfoBean.getRoomNum());
                UniversitySiteInfoFragment.access$getBinding(UniversitySiteInfoFragment.this).tvFragmentSiteInfo66ClassContent.setText(siteInfoBean.getClassesName());
                if (!siteInfoBean.getList().isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    for (Object obj : siteInfoBean.getList()) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        sb.append(((SiteTeacherBean) obj).getName());
                        if (i != CollectionsKt.getLastIndex(siteInfoBean.getList())) {
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        i = i2;
                    }
                    UniversitySiteInfoFragment.access$getBinding(UniversitySiteInfoFragment.this).tvFragmentSiteInfo66ManagerContent.setText(sb);
                }
                TextView textView = UniversitySiteInfoFragment.access$getBinding(UniversitySiteInfoFragment.this).tvFragmentSiteInfo66FloorContent;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(siteInfoBean.getFloor());
                sb2.append((char) 27004);
                textView.setText(sb2.toString());
                TextView textView2 = UniversitySiteInfoFragment.access$getBinding(UniversitySiteInfoFragment.this).tvFragmentSiteInfo66CapacityContent;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(siteInfoBean.getPeppleNum());
                sb3.append((char) 20154);
                textView2.setText(sb3.toString());
                UniversitySiteInfoFragment.access$getBinding(UniversitySiteInfoFragment.this).tvFragmentSiteInfo66SizeContent.setText(String.valueOf(siteInfoBean.getSpace()));
                UniversitySiteInfoFragment.access$getBinding(UniversitySiteInfoFragment.this).tvFragmentSiteInfo66Content.setText("\u3000\u3000" + siteInfoBean.getDescribe());
                ViewStub viewStub = UniversitySiteInfoFragment.access$getBinding(UniversitySiteInfoFragment.this).emptyViewBottom;
                Intrinsics.checkNotNullExpressionValue(viewStub, "binding.emptyViewBottom");
                viewStub.setVisibility(siteInfoBean.getDescribe().length() == 0 ? 0 : 8);
                ArrayList arrayList = new ArrayList();
                if (siteInfoBean.getImgPaths().length() > 0) {
                    Iterator it3 = StringsKt.split$default((CharSequence) siteInfoBean.getImgPaths(), new String[]{Constants.ACCEPT_TIME_SEPARATOR_SP}, false, 0, 6, (Object) null).iterator();
                    while (it3.hasNext()) {
                        arrayList.add((String) it3.next());
                    }
                }
                UniversitySiteInfoFragment.access$getBinding(UniversitySiteInfoFragment.this).bannerFragmentSiteInfo66.setDatas(arrayList);
                ViewStub viewStub2 = UniversitySiteInfoFragment.access$getBinding(UniversitySiteInfoFragment.this).emptyViewBanner;
                Intrinsics.checkNotNullExpressionValue(viewStub2, "binding.emptyViewBanner");
                viewStub2.setVisibility(arrayList.isEmpty() ? 0 : 8);
            }
        };
        siteInfo.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.site.-$$Lambda$UniversitySiteInfoFragment$qicZTkagLWVpq_CXDcjP8suAruY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UniversitySiteInfoFragment.initView$lambda$0(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
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
