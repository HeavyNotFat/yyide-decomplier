package com.yd.android_brand_mvp.landscape.cctv;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentCCTVBinding;
import com.yd.android_brand_mvp.model.LayoutListRsp;
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

/* JADX INFO: compiled from: CCTVFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0002J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/cctv/CCTVFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentCCTVBinding;", "()V", "viewModel", "Lcom/yd/android_brand_mvp/landscape/cctv/CCTVViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/cctv/CCTVViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "UpdataEvent", "", "id", "", "initView", "initViewModel", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setData", "dataList", "", "Lcom/yd/android_brand_mvp/model/LayoutListRsp$StreamDetails$StreamUrlsDTO;", "setVideoPlay", "bean", "videoView", "Landroid/widget/VideoView;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CCTVFragment extends KTBaseFragment<FragmentCCTVBinding> {

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String MODULEID = "moduleId";
    private static final String BRANDID = "brandId";

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.cctv.CCTVFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: CCTVFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentCCTVBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentCCTVBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentCCTVBinding;", 0);
        }

        public final FragmentCCTVBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentCCTVBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentCCTVBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public CCTVFragment() {
        super(AnonymousClass1.INSTANCE);
        final CCTVFragment cCTVFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.cctv.CCTVFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return cCTVFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.cctv.CCTVFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(cCTVFragment, Reflection.getOrCreateKotlinClass(CCTVViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.cctv.CCTVFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.cctv.CCTVFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.cctv.CCTVFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = cCTVFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    /* JADX INFO: compiled from: CCTVFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/cctv/CCTVFragment$Companion;", "", "()V", "BRANDID", "", "getBRANDID", "()Ljava/lang/String;", "MODULEID", "getMODULEID", "newInstance", "Lcom/yd/android_brand_mvp/landscape/cctv/CCTVFragment;", "moduleId", "brandId", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getMODULEID() {
            return CCTVFragment.MODULEID;
        }

        public final String getBRANDID() {
            return CCTVFragment.BRANDID;
        }

        public final CCTVFragment newInstance(String moduleId, String brandId) {
            CCTVFragment cCTVFragment = new CCTVFragment();
            Bundle bundle = new Bundle();
            bundle.putString(CCTVFragment.INSTANCE.getMODULEID(), moduleId);
            bundle.putString(CCTVFragment.INSTANCE.getBRANDID(), brandId);
            cCTVFragment.setArguments(bundle);
            return cCTVFragment;
        }
    }

    private final CCTVViewModel getViewModel() {
        return (CCTVViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(MODULEID) : null;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString(BRANDID) : null;
        getBinding().videoView1.setVisibility(8);
        getBinding().videoView2.setVisibility(8);
        getBinding().videoView3.setVisibility(8);
        getBinding().videoView4.setVisibility(8);
        getBinding().layoutCctv8.content.setVisibility(8);
        initViewModel();
        CCTVViewModel viewModel = getViewModel();
        if (string == null) {
            string = "";
        }
        if (string2 == null) {
            string2 = "";
        }
        viewModel.requestRTSPPath(string, string2);
    }

    private final void initViewModel() {
        final Function1<Result<? extends LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean>, Unit> function1 = new Function1<Result<? extends LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.cctv.CCTVFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean layoutClassSignDetailsEntityListBean = (LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean) value;
                    if (layoutClassSignDetailsEntityListBean != null) {
                        CCTVFragment cCTVFragment = CCTVFragment.this;
                        LayoutListRsp.StreamDetails streamDetails = layoutClassSignDetailsEntityListBean.streamDetails;
                        if (streamDetails != null) {
                            Intrinsics.checkNotNullExpressionValue(streamDetails, "streamDetails");
                            List<LayoutListRsp.StreamDetails.StreamUrlsDTO> streamUrls = streamDetails.streamUrls;
                            if (streamUrls != null) {
                                Intrinsics.checkNotNullExpressionValue(streamUrls, "streamUrls");
                                cCTVFragment.setData(streamUrls);
                            }
                        }
                    }
                }
            }
        };
        getViewModel().getMLiveData().observe(this, new Observer() { // from class: com.yd.android_brand_mvp.landscape.cctv.-$$Lambda$CCTVFragment$0hcGDxWWXw03E0hAnHcW4Sp1N4Q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CCTVFragment.initViewModel$lambda$0(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setData(List<LayoutListRsp.StreamDetails.StreamUrlsDTO> dataList) {
        if (dataList == null || dataList.size() <= 0) {
            return;
        }
        switch (dataList.size()) {
            case 1:
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO = dataList.get(0);
                VideoView videoView = getBinding().videoView1;
                Intrinsics.checkNotNullExpressionValue(videoView, "binding.videoView1");
                setVideoPlay(streamUrlsDTO, videoView);
                getBinding().videoView1.setVisibility(0);
                break;
            case 2:
                getBinding().videoView1.setVisibility(0);
                getBinding().videoView2.setVisibility(0);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO2 = dataList.get(0);
                VideoView videoView2 = getBinding().videoView1;
                Intrinsics.checkNotNullExpressionValue(videoView2, "binding.videoView1");
                setVideoPlay(streamUrlsDTO2, videoView2);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO3 = dataList.get(1);
                VideoView videoView3 = getBinding().videoView2;
                Intrinsics.checkNotNullExpressionValue(videoView3, "binding.videoView2");
                setVideoPlay(streamUrlsDTO3, videoView3);
                break;
            case 3:
                getBinding().videoView1.setVisibility(0);
                getBinding().videoView2.setVisibility(0);
                getBinding().videoView3.setVisibility(0);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO4 = dataList.get(0);
                VideoView videoView4 = getBinding().videoView1;
                Intrinsics.checkNotNullExpressionValue(videoView4, "binding.videoView1");
                setVideoPlay(streamUrlsDTO4, videoView4);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO5 = dataList.get(1);
                VideoView videoView5 = getBinding().videoView2;
                Intrinsics.checkNotNullExpressionValue(videoView5, "binding.videoView2");
                setVideoPlay(streamUrlsDTO5, videoView5);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO6 = dataList.get(2);
                VideoView videoView6 = getBinding().videoView3;
                Intrinsics.checkNotNullExpressionValue(videoView6, "binding.videoView3");
                setVideoPlay(streamUrlsDTO6, videoView6);
                break;
            case 4:
                getBinding().videoView1.setVisibility(0);
                getBinding().videoView2.setVisibility(0);
                getBinding().videoView3.setVisibility(0);
                getBinding().videoView4.setVisibility(0);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO7 = dataList.get(0);
                VideoView videoView7 = getBinding().videoView1;
                Intrinsics.checkNotNullExpressionValue(videoView7, "binding.videoView1");
                setVideoPlay(streamUrlsDTO7, videoView7);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO8 = dataList.get(1);
                VideoView videoView8 = getBinding().videoView2;
                Intrinsics.checkNotNullExpressionValue(videoView8, "binding.videoView2");
                setVideoPlay(streamUrlsDTO8, videoView8);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO9 = dataList.get(2);
                VideoView videoView9 = getBinding().videoView3;
                Intrinsics.checkNotNullExpressionValue(videoView9, "binding.videoView3");
                setVideoPlay(streamUrlsDTO9, videoView9);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO10 = dataList.get(3);
                VideoView videoView10 = getBinding().videoView4;
                Intrinsics.checkNotNullExpressionValue(videoView10, "binding.videoView4");
                setVideoPlay(streamUrlsDTO10, videoView10);
                break;
            case 5:
                getBinding().layoutCctv8.content.setVisibility(0);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO11 = dataList.get(0);
                VideoView videoView11 = getBinding().layoutCctv8.videoView5;
                Intrinsics.checkNotNullExpressionValue(videoView11, "binding.layoutCctv8.videoView5");
                setVideoPlay(streamUrlsDTO11, videoView11);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO12 = dataList.get(1);
                VideoView videoView12 = getBinding().layoutCctv8.videoView6;
                Intrinsics.checkNotNullExpressionValue(videoView12, "binding.layoutCctv8.videoView6");
                setVideoPlay(streamUrlsDTO12, videoView12);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO13 = dataList.get(2);
                VideoView videoView13 = getBinding().layoutCctv8.videoView7;
                Intrinsics.checkNotNullExpressionValue(videoView13, "binding.layoutCctv8.videoView7");
                setVideoPlay(streamUrlsDTO13, videoView13);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO14 = dataList.get(3);
                VideoView videoView14 = getBinding().layoutCctv8.videoView8;
                Intrinsics.checkNotNullExpressionValue(videoView14, "binding.layoutCctv8.videoView8");
                setVideoPlay(streamUrlsDTO14, videoView14);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO15 = dataList.get(4);
                VideoView videoView15 = getBinding().layoutCctv8.videoView9;
                Intrinsics.checkNotNullExpressionValue(videoView15, "binding.layoutCctv8.videoView9");
                setVideoPlay(streamUrlsDTO15, videoView15);
                break;
            case 6:
                getBinding().layoutCctv8.content.setVisibility(0);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO16 = dataList.get(0);
                VideoView videoView16 = getBinding().layoutCctv8.videoView5;
                Intrinsics.checkNotNullExpressionValue(videoView16, "binding.layoutCctv8.videoView5");
                setVideoPlay(streamUrlsDTO16, videoView16);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO17 = dataList.get(1);
                VideoView videoView17 = getBinding().layoutCctv8.videoView6;
                Intrinsics.checkNotNullExpressionValue(videoView17, "binding.layoutCctv8.videoView6");
                setVideoPlay(streamUrlsDTO17, videoView17);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO18 = dataList.get(2);
                VideoView videoView18 = getBinding().layoutCctv8.videoView7;
                Intrinsics.checkNotNullExpressionValue(videoView18, "binding.layoutCctv8.videoView7");
                setVideoPlay(streamUrlsDTO18, videoView18);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO19 = dataList.get(3);
                VideoView videoView19 = getBinding().layoutCctv8.videoView8;
                Intrinsics.checkNotNullExpressionValue(videoView19, "binding.layoutCctv8.videoView8");
                setVideoPlay(streamUrlsDTO19, videoView19);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO20 = dataList.get(4);
                VideoView videoView20 = getBinding().layoutCctv8.videoView9;
                Intrinsics.checkNotNullExpressionValue(videoView20, "binding.layoutCctv8.videoView9");
                setVideoPlay(streamUrlsDTO20, videoView20);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO21 = dataList.get(5);
                VideoView videoView21 = getBinding().layoutCctv8.videoView10;
                Intrinsics.checkNotNullExpressionValue(videoView21, "binding.layoutCctv8.videoView10");
                setVideoPlay(streamUrlsDTO21, videoView21);
                break;
            case 7:
                getBinding().layoutCctv8.content.setVisibility(0);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO22 = dataList.get(0);
                VideoView videoView22 = getBinding().layoutCctv8.videoView5;
                Intrinsics.checkNotNullExpressionValue(videoView22, "binding.layoutCctv8.videoView5");
                setVideoPlay(streamUrlsDTO22, videoView22);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO23 = dataList.get(1);
                VideoView videoView23 = getBinding().layoutCctv8.videoView6;
                Intrinsics.checkNotNullExpressionValue(videoView23, "binding.layoutCctv8.videoView6");
                setVideoPlay(streamUrlsDTO23, videoView23);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO24 = dataList.get(2);
                VideoView videoView24 = getBinding().layoutCctv8.videoView7;
                Intrinsics.checkNotNullExpressionValue(videoView24, "binding.layoutCctv8.videoView7");
                setVideoPlay(streamUrlsDTO24, videoView24);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO25 = dataList.get(3);
                VideoView videoView25 = getBinding().layoutCctv8.videoView8;
                Intrinsics.checkNotNullExpressionValue(videoView25, "binding.layoutCctv8.videoView8");
                setVideoPlay(streamUrlsDTO25, videoView25);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO26 = dataList.get(4);
                VideoView videoView26 = getBinding().layoutCctv8.videoView9;
                Intrinsics.checkNotNullExpressionValue(videoView26, "binding.layoutCctv8.videoView9");
                setVideoPlay(streamUrlsDTO26, videoView26);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO27 = dataList.get(5);
                VideoView videoView27 = getBinding().layoutCctv8.videoView10;
                Intrinsics.checkNotNullExpressionValue(videoView27, "binding.layoutCctv8.videoView10");
                setVideoPlay(streamUrlsDTO27, videoView27);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO28 = dataList.get(6);
                VideoView videoView28 = getBinding().layoutCctv8.videoView11;
                Intrinsics.checkNotNullExpressionValue(videoView28, "binding.layoutCctv8.videoView11");
                setVideoPlay(streamUrlsDTO28, videoView28);
                break;
            case 8:
                getBinding().layoutCctv8.content.setVisibility(0);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO29 = dataList.get(0);
                VideoView videoView29 = getBinding().layoutCctv8.videoView5;
                Intrinsics.checkNotNullExpressionValue(videoView29, "binding.layoutCctv8.videoView5");
                setVideoPlay(streamUrlsDTO29, videoView29);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO30 = dataList.get(1);
                VideoView videoView30 = getBinding().layoutCctv8.videoView6;
                Intrinsics.checkNotNullExpressionValue(videoView30, "binding.layoutCctv8.videoView6");
                setVideoPlay(streamUrlsDTO30, videoView30);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO31 = dataList.get(2);
                VideoView videoView31 = getBinding().layoutCctv8.videoView7;
                Intrinsics.checkNotNullExpressionValue(videoView31, "binding.layoutCctv8.videoView7");
                setVideoPlay(streamUrlsDTO31, videoView31);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO32 = dataList.get(3);
                VideoView videoView32 = getBinding().layoutCctv8.videoView8;
                Intrinsics.checkNotNullExpressionValue(videoView32, "binding.layoutCctv8.videoView8");
                setVideoPlay(streamUrlsDTO32, videoView32);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO33 = dataList.get(4);
                VideoView videoView33 = getBinding().layoutCctv8.videoView9;
                Intrinsics.checkNotNullExpressionValue(videoView33, "binding.layoutCctv8.videoView9");
                setVideoPlay(streamUrlsDTO33, videoView33);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO34 = dataList.get(5);
                VideoView videoView34 = getBinding().layoutCctv8.videoView10;
                Intrinsics.checkNotNullExpressionValue(videoView34, "binding.layoutCctv8.videoView10");
                setVideoPlay(streamUrlsDTO34, videoView34);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO35 = dataList.get(6);
                VideoView videoView35 = getBinding().layoutCctv8.videoView11;
                Intrinsics.checkNotNullExpressionValue(videoView35, "binding.layoutCctv8.videoView11");
                setVideoPlay(streamUrlsDTO35, videoView35);
                LayoutListRsp.StreamDetails.StreamUrlsDTO streamUrlsDTO36 = dataList.get(7);
                VideoView videoView36 = getBinding().layoutCctv8.videoView12;
                Intrinsics.checkNotNullExpressionValue(videoView36, "binding.layoutCctv8.videoView12");
                setVideoPlay(streamUrlsDTO36, videoView36);
                break;
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        if (BaseConstant.CCTV == id) {
            Bundle arguments = getArguments();
            String string = arguments != null ? arguments.getString(MODULEID) : null;
            Bundle arguments2 = getArguments();
            String string2 = arguments2 != null ? arguments2.getString(BRANDID) : null;
            CCTVViewModel viewModel = getViewModel();
            if (string == null) {
                string = "";
            }
            if (string2 == null) {
                string2 = "";
            }
            viewModel.requestRTSPPath(string, string2);
        }
    }

    private final void setVideoPlay(final LayoutListRsp.StreamDetails.StreamUrlsDTO bean, final VideoView videoView) {
        videoView.setVideoURI(Uri.parse(bean.url));
        videoView.requestFocus();
        videoView.start();
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.yd.android_brand_mvp.landscape.cctv.-$$Lambda$CCTVFragment$zBO043vmXe5Qs79-xVplLSBjYVY
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return CCTVFragment.setVideoPlay$lambda$2(videoView, bean, mediaPlayer, i, i2);
            }
        });
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.yd.android_brand_mvp.landscape.cctv.-$$Lambda$CCTVFragment$EUB87uaGSpqTjooiv4MhmlGIoHY
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVideoScalingMode(2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setVideoPlay$lambda$2(final VideoView videoView, final LayoutListRsp.StreamDetails.StreamUrlsDTO bean, MediaPlayer mediaPlayer, int i, int i2) {
        Intrinsics.checkNotNullParameter(videoView, "$videoView");
        Intrinsics.checkNotNullParameter(bean, "$bean");
        Log.d("CCTVFragment", "setOnErrorListener what=" + i + " extra = " + i2);
        videoView.stopPlayback();
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.cctv.-$$Lambda$CCTVFragment$cXqhIWHB86X6yqKND6MOcZVGgLE
            @Override // java.lang.Runnable
            public final void run() {
                CCTVFragment.setVideoPlay$lambda$2$lambda$1(videoView, bean);
            }
        }, 5000L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setVideoPlay$lambda$2$lambda$1(VideoView videoView, LayoutListRsp.StreamDetails.StreamUrlsDTO bean) {
        Intrinsics.checkNotNullParameter(videoView, "$videoView");
        Intrinsics.checkNotNullParameter(bean, "$bean");
        videoView.setVideoURI(Uri.parse(bean.url));
        videoView.requestFocus();
        videoView.start();
    }
}
