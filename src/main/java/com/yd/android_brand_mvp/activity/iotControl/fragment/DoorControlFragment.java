package com.yd.android_brand_mvp.activity.iotControl.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.tencent.smtt.sdk.TbsListener;
import com.yd.android_brand_mvp.ClassCardPermisson;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.iotControl.viewmodel.DoorControlViewModel;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentDoorControlBinding;
import com.yd.android_brand_mvp.model.EventTimerBean;
import com.yd.android_brand_mvp.model.IdentityBean;
import com.yd.android_brand_mvp.model.VerifyTeacherLoginBean;
import com.yd.android_brand_mvp.observer.ObserverListener;
import com.yd.android_brand_mvp.observer.ObserverManager;
import com.yd.android_brand_mvp.utils.GPIOUtils;
import com.yd.android_brand_mvp.utils.SettingPermision;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.verfity.FaceMsg;
import com.yd.android_brand_mvp.widget.FaceView;
import com.yd.android_brand_mvp.widget.YDEditText;
import com.yyide.facepass.AppExtKt;
import com.yyide.facepass.FaceManager;
import com.yyide.facepass.OnRecognizeCallback;
import com.yyide.facepass.bean.RecognizeResultBean;
import com.yyide.facepass.camera.CameraPreview;
import com.yyide.facepass.database.DatabaseUtil;
import com.yyide.facepass.database.FacePeople;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import mcv.facepass.types.FacePassFace;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: compiled from: DoorControlFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u000f\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001)B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0016J\u001a\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\u0018\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006*"}, d2 = {"Lcom/yd/android_brand_mvp/activity/iotControl/fragment/DoorControlFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentDoorControlBinding;", "Lcom/yd/android_brand_mvp/observer/ObserverListener;", "()V", "backTime", "", "cameraView", "Lcom/yyide/facepass/camera/CameraPreview;", "currentVerifyMode", "lastRecognizeTime", "", "lastRecognizeUserId", "", "onRecognizeCallback", "com/yd/android_brand_mvp/activity/iotControl/fragment/DoorControlFragment$onRecognizeCallback$1", "Lcom/yd/android_brand_mvp/activity/iotControl/fragment/DoorControlFragment$onRecognizeCallback$1;", "viewModel", "Lcom/yd/android_brand_mvp/activity/iotControl/viewmodel/DoorControlViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/iotControl/viewmodel/DoorControlViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "initViewModel", "observerUpData", "cardNo", "onDestroy", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "registerFaceSDK", "releaseFaceSDK", "setTipUI", "status", "number", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DoorControlFragment extends KTBaseFragment<FragmentDoorControlBinding> implements ObserverListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int backTime;
    private CameraPreview cameraView;
    private int currentVerifyMode;
    private long lastRecognizeTime;
    private String lastRecognizeUserId;
    private final DoorControlFragment$onRecognizeCallback$1 onRecognizeCallback;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.iotControl.fragment.DoorControlFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: DoorControlFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentDoorControlBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentDoorControlBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentDoorControlBinding;", 0);
        }

        public final FragmentDoorControlBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentDoorControlBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentDoorControlBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.yd.android_brand_mvp.activity.iotControl.fragment.DoorControlFragment$onRecognizeCallback$1] */
    public DoorControlFragment() {
        super(AnonymousClass1.INSTANCE);
        this.lastRecognizeUserId = "";
        final DoorControlFragment doorControlFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.iotControl.fragment.DoorControlFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return doorControlFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.iotControl.fragment.DoorControlFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(doorControlFragment, Reflection.getOrCreateKotlinClass(DoorControlViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.iotControl.fragment.DoorControlFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.iotControl.fragment.DoorControlFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.iotControl.fragment.DoorControlFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = doorControlFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.onRecognizeCallback = new OnRecognizeCallback() { // from class: com.yd.android_brand_mvp.activity.iotControl.fragment.DoorControlFragment$onRecognizeCallback$1
            @Override // com.yyide.facepass.OnRecognizeCallback
            public void onFaceRecognitionStatus(long trackId, int status) {
            }

            @Override // com.yyide.facepass.OnRecognizeCallback
            public void onFaceRecognizeError(String msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
            }

            @Override // com.yyide.facepass.OnRecognizeCallback
            public void onFaceDetect(List<FacePassFace> dataList) {
                Intrinsics.checkNotNullParameter(dataList, "dataList");
                EventBus.getDefault().post(new EventTimerBean());
                Iterator<FacePassFace> it2 = dataList.iterator();
                while (it2.hasNext()) {
                    if (it2.next().facePassFeedFrameErrorCode == 7) {
                        ToastUtil.showBottomView(this.this$0.requireContext(), FaceMsg.FaceLight);
                        return;
                    }
                }
                FaceView faceView = DoorControlFragment.access$getBinding(this.this$0).faceViewFragmentDoorControl;
                CameraPreview cameraPreview = this.this$0.cameraView;
                if (cameraPreview == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cameraView");
                    cameraPreview = null;
                }
                faceView.showFacePassFace(dataList, cameraPreview);
            }

            @Override // com.yyide.facepass.OnRecognizeCallback
            public void onFaceDismiss() {
                DoorControlFragment.access$getBinding(this.this$0).faceViewFragmentDoorControl.clear();
                DoorControlFragment.access$getBinding(this.this$0).faceViewFragmentDoorControl.invalidate();
            }

            @Override // com.yyide.facepass.OnRecognizeCallback
            public void onFaceRecognizeSimple(RecognizeResultBean faceData) {
                Intrinsics.checkNotNullParameter(faceData, "faceData");
                BaseConstant.exitOutTime = this.this$0.backTime;
                if (!SpData.isFaceEnable()) {
                    this.this$0.setTipUI(1, "");
                    ToastUtil.showBottomView(this.this$0.requireContext(), FaceMsg.FaceEnable);
                    return;
                }
                LogUtils.i("DoorControlFragment", "通行人员 = " + GsonUtils.toJson(faceData));
                if (TextUtils.isEmpty(faceData.getUserId())) {
                    this.this$0.setTipUI(1, "");
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                String userId = faceData.getUserId();
                if (userId == null) {
                    userId = "";
                }
                if (jCurrentTimeMillis - this.this$0.lastRecognizeTime <= 30000 || Intrinsics.areEqual(this.this$0.lastRecognizeUserId, userId)) {
                    this.this$0.setTipUI(0, userId);
                    DoorControlViewModel viewModel = this.this$0.getViewModel();
                    String userType = faceData.getUserType();
                    viewModel.addOpenDoorRecodes(userId, "1", userType != null ? userType : "");
                    return;
                }
                this.this$0.lastRecognizeUserId = userId;
                this.this$0.lastRecognizeTime = jCurrentTimeMillis;
                DoorControlViewModel viewModel2 = this.this$0.getViewModel();
                String userType2 = faceData.getUserType();
                viewModel2.addOpenDoorRecodes(userId, "1", userType2 != null ? userType2 : "");
                this.this$0.setTipUI(0, userId);
            }
        };
    }

    public static final /* synthetic */ FragmentDoorControlBinding access$getBinding(DoorControlFragment doorControlFragment) {
        return doorControlFragment.getBinding();
    }

    /* JADX INFO: compiled from: DoorControlFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/iotControl/fragment/DoorControlFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "time", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(int time) {
            DoorControlFragment doorControlFragment = new DoorControlFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("time", time);
            doorControlFragment.setArguments(bundle);
            return doorControlFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DoorControlViewModel getViewModel() {
        return (DoorControlViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (ScreenUtils.isPortrait()) {
            getBinding().previewParent.getLayoutParams().height = SizeUtils.dp2px(500.0f);
            getBinding().faceViewFragmentDoorControl.getLayoutParams().height = SizeUtils.dp2px(500.0f);
        }
        this.cameraView = new CameraPreview(getActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        CameraPreview cameraPreview = this.cameraView;
        if (cameraPreview == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraView");
            cameraPreview = null;
        }
        cameraPreview.setLayoutParams(layoutParams);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.backTime = arguments.getInt("time", BaseConstant.exitOutTime);
        }
        initView();
        setTipUI(-1, "");
        BaseConstant.exitOutTime = this.backTime;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObserverManager.getInstance().add(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ObserverManager.getInstance().remove(this);
    }

    private final void registerFaceSDK() {
        try {
            LinearLayoutCompat linearLayoutCompat = getBinding().previewParent;
            CameraPreview cameraPreview = this.cameraView;
            CameraPreview cameraPreview2 = null;
            if (cameraPreview == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cameraView");
                cameraPreview = null;
            }
            linearLayoutCompat.removeView(cameraPreview);
            LinearLayoutCompat linearLayoutCompat2 = getBinding().previewParent;
            CameraPreview cameraPreview3 = this.cameraView;
            if (cameraPreview3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cameraView");
                cameraPreview3 = null;
            }
            linearLayoutCompat2.addView(cameraPreview3);
            FaceManager faceManager = FaceManager.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            FragmentActivity fragmentActivity = fragmentActivityRequireActivity;
            CameraPreview cameraPreview4 = this.cameraView;
            if (cameraPreview4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cameraView");
            } else {
                cameraPreview2 = cameraPreview4;
            }
            faceManager.initFaceHandler(fragmentActivity, cameraPreview2, this.onRecognizeCallback);
            AppExtKt.logd(this, "reservation 注册人脸功能");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void releaseFaceSDK() {
        try {
            LinearLayoutCompat linearLayoutCompat = getBinding().previewParent;
            CameraPreview cameraPreview = this.cameraView;
            if (cameraPreview == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cameraView");
                cameraPreview = null;
            }
            linearLayoutCompat.removeView(cameraPreview);
            FaceManager.INSTANCE.onDestroyCamera();
            AppExtKt.logd(this, "reservation 注销人脸功能");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void initView() {
        Button button = getBinding().btnFragmentDoorControlAccount;
        Intrinsics.checkNotNullExpressionValue(button, "binding.btnFragmentDoorControlAccount");
        SimpleUtilsKt.remove(button);
        Button button2 = getBinding().btnFragmentDoorControlCard;
        Intrinsics.checkNotNullExpressionValue(button2, "binding.btnFragmentDoorControlCard");
        SimpleUtilsKt.remove(button2);
        Button button3 = getBinding().btnFragmentDoorControlFace;
        Intrinsics.checkNotNullExpressionValue(button3, "binding.btnFragmentDoorControlFace");
        SimpleUtilsKt.remove(button3);
        Group group = getBinding().groupFragmentDoorControl;
        Intrinsics.checkNotNullExpressionValue(group, "binding.groupFragmentDoorControl");
        SimpleUtilsKt.remove(group);
        ImageView imageView = getBinding().ivFragmentDoorControlCard;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivFragmentDoorControlCard");
        SimpleUtilsKt.hide(imageView);
        ConstraintLayout constraintLayout = getBinding().clFragmentDoorControlAccount;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clFragmentDoorControlAccount");
        SimpleUtilsKt.remove(constraintLayout);
        TextView textView = getBinding().tvTip;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvTip");
        SimpleUtilsKt.show(textView);
        if (ClassCardPermisson.getInstance().Cheack("人脸验证")) {
            this.currentVerifyMode = 1;
            Button button4 = getBinding().btnFragmentDoorControlFace;
            Intrinsics.checkNotNullExpressionValue(button4, "binding.btnFragmentDoorControlFace");
            SimpleUtilsKt.show(button4);
            Group group2 = getBinding().groupFragmentDoorControl;
            Intrinsics.checkNotNullExpressionValue(group2, "binding.groupFragmentDoorControl");
            SimpleUtilsKt.show(group2);
            registerFaceSDK();
            TextView textView2 = getBinding().tvTip;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvTip");
            SimpleUtilsKt.remove(textView2);
        }
        if (ClassCardPermisson.getInstance().Cheack("刷卡验证")) {
            Button button5 = getBinding().btnFragmentDoorControlCard;
            Intrinsics.checkNotNullExpressionValue(button5, "binding.btnFragmentDoorControlCard");
            SimpleUtilsKt.show(button5);
            if (this.currentVerifyMode == 0) {
                this.currentVerifyMode = 2;
                ImageView imageView2 = getBinding().ivFragmentDoorControlCard;
                Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivFragmentDoorControlCard");
                SimpleUtilsKt.show(imageView2);
                getBinding().btnFragmentDoorControlCard.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_purple23));
                getBinding().btnFragmentDoorControlCard.setTextColor(SimpleUtilsKt.asColor(R.color.white));
            }
            TextView textView3 = getBinding().tvTip;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvTip");
            SimpleUtilsKt.remove(textView3);
        }
        if (ClassCardPermisson.getInstance().Cheack("密码验证")) {
            Button button6 = getBinding().btnFragmentDoorControlAccount;
            Intrinsics.checkNotNullExpressionValue(button6, "binding.btnFragmentDoorControlAccount");
            SimpleUtilsKt.show(button6);
            if (this.currentVerifyMode == 0) {
                this.currentVerifyMode = 3;
                ConstraintLayout constraintLayout2 = getBinding().clFragmentDoorControlAccount;
                Intrinsics.checkNotNullExpressionValue(constraintLayout2, "binding.clFragmentDoorControlAccount");
                SimpleUtilsKt.show(constraintLayout2);
                getBinding().btnFragmentDoorControlAccount.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_purple23));
                getBinding().btnFragmentDoorControlAccount.setTextColor(SimpleUtilsKt.asColor(R.color.white));
            }
            TextView textView4 = getBinding().tvTip;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.tvTip");
            SimpleUtilsKt.remove(textView4);
        }
        getBinding().btnFragmentDoorControlFace.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.iotControl.fragment.-$$Lambda$DoorControlFragment$4233d0-Did-boxA9obm26GkAJp0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DoorControlFragment.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().btnFragmentDoorControlCard.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.iotControl.fragment.-$$Lambda$DoorControlFragment$le2zCj7ujl5CcD2PIaa82Y9W8K4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DoorControlFragment.initView$lambda$2(this.f$0, view);
            }
        });
        getBinding().btnFragmentDoorControlAccount.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.iotControl.fragment.-$$Lambda$DoorControlFragment$rsLdJ5SLGSYpzoj0z03toZwMXwI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DoorControlFragment.initView$lambda$3(this.f$0, view);
            }
        });
        getBinding().login.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.iotControl.fragment.-$$Lambda$DoorControlFragment$cIBGEZCqM3NXPPZAUNMbFFRaofE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DoorControlFragment.initView$lambda$4(this.f$0, view);
            }
        });
        getBinding().tvReveal.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.iotControl.fragment.-$$Lambda$DoorControlFragment$JLkc1THpXqdJ-Xk8UNew1EzmpdM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DoorControlFragment.initView$lambda$5(this.f$0, view);
            }
        });
        getBinding().btnFail.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.iotControl.fragment.-$$Lambda$DoorControlFragment$p49UKtLPSukoBMSlRHI33nxjlAc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DoorControlFragment.initView$lambda$6(this.f$0, view);
            }
        });
        getBinding().btnClose.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.iotControl.fragment.-$$Lambda$DoorControlFragment$wV4wrrH6FLVSecR4K_7-qOcPd_c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DoorControlFragment.initView$lambda$7(this.f$0, view);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass8(null), 3, null);
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(DoorControlFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentVerifyMode = 1;
        this$0.registerFaceSDK();
        view.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_purple23));
        this$0.getBinding().btnFragmentDoorControlFace.setTextColor(SimpleUtilsKt.asColor(R.color.white));
        this$0.getBinding().btnFragmentDoorControlCard.setTextColor(SimpleUtilsKt.asColor(R.color.black10));
        this$0.getBinding().btnFragmentDoorControlCard.setBackground(SimpleUtilsKt.asDrawable(R.drawable.frame_grey_cc_r20));
        this$0.getBinding().btnFragmentDoorControlAccount.setTextColor(SimpleUtilsKt.asColor(R.color.black10));
        this$0.getBinding().btnFragmentDoorControlAccount.setBackground(SimpleUtilsKt.asDrawable(R.drawable.frame_grey_cc_r20));
        ImageView imageView = this$0.getBinding().ivFragmentDoorControlCard;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivFragmentDoorControlCard");
        SimpleUtilsKt.hide(imageView);
        ConstraintLayout constraintLayout = this$0.getBinding().clFragmentDoorControlAccount;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clFragmentDoorControlAccount");
        SimpleUtilsKt.hide(constraintLayout);
        ConstraintLayout constraintLayout2 = this$0.getBinding().clLoginSuccess;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "binding.clLoginSuccess");
        SimpleUtilsKt.remove(constraintLayout2);
        ConstraintLayout constraintLayout3 = this$0.getBinding().clLoginFail;
        Intrinsics.checkNotNullExpressionValue(constraintLayout3, "binding.clLoginFail");
        SimpleUtilsKt.remove(constraintLayout3);
        Group group = this$0.getBinding().groupFragmentDoorControl;
        Intrinsics.checkNotNullExpressionValue(group, "binding.groupFragmentDoorControl");
        SimpleUtilsKt.show(group);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(DoorControlFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentVerifyMode = 2;
        this$0.releaseFaceSDK();
        view.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_purple23));
        this$0.getBinding().btnFragmentDoorControlCard.setTextColor(SimpleUtilsKt.asColor(R.color.white));
        this$0.getBinding().btnFragmentDoorControlFace.setTextColor(SimpleUtilsKt.asColor(R.color.black10));
        this$0.getBinding().btnFragmentDoorControlFace.setBackground(SimpleUtilsKt.asDrawable(R.drawable.frame_grey_cc_r20));
        this$0.getBinding().btnFragmentDoorControlAccount.setTextColor(SimpleUtilsKt.asColor(R.color.black10));
        this$0.getBinding().btnFragmentDoorControlAccount.setBackground(SimpleUtilsKt.asDrawable(R.drawable.frame_grey_cc_r20));
        ImageView imageView = this$0.getBinding().ivFragmentDoorControlCard;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivFragmentDoorControlCard");
        SimpleUtilsKt.show(imageView);
        ConstraintLayout constraintLayout = this$0.getBinding().clLoginSuccess;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clLoginSuccess");
        SimpleUtilsKt.remove(constraintLayout);
        ConstraintLayout constraintLayout2 = this$0.getBinding().clLoginFail;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "binding.clLoginFail");
        SimpleUtilsKt.remove(constraintLayout2);
        ConstraintLayout constraintLayout3 = this$0.getBinding().clFragmentDoorControlAccount;
        Intrinsics.checkNotNullExpressionValue(constraintLayout3, "binding.clFragmentDoorControlAccount");
        SimpleUtilsKt.hide(constraintLayout3);
        Group group = this$0.getBinding().groupFragmentDoorControl;
        Intrinsics.checkNotNullExpressionValue(group, "binding.groupFragmentDoorControl");
        SimpleUtilsKt.hide(group);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(DoorControlFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentVerifyMode = 3;
        this$0.releaseFaceSDK();
        view.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_purple23));
        this$0.getBinding().btnFragmentDoorControlAccount.setTextColor(SimpleUtilsKt.asColor(R.color.white));
        this$0.getBinding().btnFragmentDoorControlCard.setTextColor(SimpleUtilsKt.asColor(R.color.black10));
        this$0.getBinding().btnFragmentDoorControlCard.setBackground(SimpleUtilsKt.asDrawable(R.drawable.frame_grey_cc_r20));
        this$0.getBinding().btnFragmentDoorControlFace.setTextColor(SimpleUtilsKt.asColor(R.color.black10));
        this$0.getBinding().btnFragmentDoorControlFace.setBackground(SimpleUtilsKt.asDrawable(R.drawable.frame_grey_cc_r20));
        ImageView imageView = this$0.getBinding().ivFragmentDoorControlCard;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivFragmentDoorControlCard");
        SimpleUtilsKt.hide(imageView);
        Group group = this$0.getBinding().groupFragmentDoorControl;
        Intrinsics.checkNotNullExpressionValue(group, "binding.groupFragmentDoorControl");
        SimpleUtilsKt.hide(group);
        ConstraintLayout constraintLayout = this$0.getBinding().clFragmentDoorControlAccount;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clFragmentDoorControlAccount");
        SimpleUtilsKt.show(constraintLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(DoorControlFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string = StringsKt.trim((CharSequence) String.valueOf(this$0.getBinding().user.getText())).toString();
        String string2 = StringsKt.trim((CharSequence) String.valueOf(this$0.getBinding().pwd.getText())).toString();
        if (TextUtils.isEmpty(string)) {
            this$0.getBinding().user.setError("请输入账号");
        } else if (TextUtils.isEmpty(string2)) {
            this$0.getBinding().pwd.setError("请输入密码");
        } else {
            this$0.showProgressDialog();
            this$0.getViewModel().verifyTeacherLogin(string, string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(DoorControlFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().tvReveal.setSelected(!this$0.getBinding().tvReveal.isSelected());
        if (this$0.getBinding().tvReveal.isSelected()) {
            this$0.getBinding().pwd.setInputType(144);
            this$0.getBinding().tvReveal.setText("隐藏");
        } else {
            this$0.getBinding().tvReveal.setText("显示");
            this$0.getBinding().pwd.setInputType(225);
        }
        YDEditText yDEditText = this$0.getBinding().pwd;
        Editable text = this$0.getBinding().pwd.getText();
        yDEditText.setSelection(text != null ? text.length() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(DoorControlFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ConstraintLayout constraintLayout = this$0.getBinding().clFragmentDoorControlAccount;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clFragmentDoorControlAccount");
        SimpleUtilsKt.show(constraintLayout);
        ConstraintLayout constraintLayout2 = this$0.getBinding().clLoginSuccess;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "binding.clLoginSuccess");
        SimpleUtilsKt.remove(constraintLayout2);
        ConstraintLayout constraintLayout3 = this$0.getBinding().clLoginFail;
        Intrinsics.checkNotNullExpressionValue(constraintLayout3, "binding.clLoginFail");
        SimpleUtilsKt.remove(constraintLayout3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(DoorControlFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.iotControl.fragment.DoorControlFragment$initView$8, reason: invalid class name */
    /* JADX INFO: compiled from: DoorControlFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.iotControl.fragment.DoorControlFragment$initView$8", f = "DoorControlFragment.kt", i = {}, l = {TbsListener.ErrorCode.TPATCH_FAIL}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass8(Continuation<? super AnonymousClass8> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DoorControlFragment.this.new AnonymousClass8(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow<String> timeSharedFlow = DoorControlFragment.this.getViewModel().getTimeSharedFlow();
                final DoorControlFragment doorControlFragment = DoorControlFragment.this;
                this.label = 1;
                if (timeSharedFlow.collect(new FlowCollector() { // from class: com.yd.android_brand_mvp.activity.iotControl.fragment.DoorControlFragment.initView.8.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((String) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(String str, Continuation<? super Unit> continuation) {
                        doorControlFragment.setTipUI(-1, "");
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    private final void initViewModel() {
        LiveData<Result<VerifyTeacherLoginBean>> verifyTeacher = getViewModel().getVerifyTeacher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends VerifyTeacherLoginBean>, Unit> function1 = new Function1<Result<? extends VerifyTeacherLoginBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.iotControl.fragment.DoorControlFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends VerifyTeacherLoginBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends VerifyTeacherLoginBean> it2) {
                String message;
                DoorControlFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    VerifyTeacherLoginBean verifyTeacherLoginBean = (VerifyTeacherLoginBean) value;
                    if (verifyTeacherLoginBean != null) {
                        DoorControlFragment doorControlFragment = DoorControlFragment.this;
                        doorControlFragment.getViewModel().addOpenDoorRecodes(verifyTeacherLoginBean.getId(), "4", verifyTeacherLoginBean.getType());
                        ConstraintLayout constraintLayout = DoorControlFragment.access$getBinding(doorControlFragment).clFragmentDoorControlAccount;
                        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clFragmentDoorControlAccount");
                        SimpleUtilsKt.remove(constraintLayout);
                        ConstraintLayout constraintLayout2 = DoorControlFragment.access$getBinding(doorControlFragment).clLoginSuccess;
                        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "binding.clLoginSuccess");
                        SimpleUtilsKt.show(constraintLayout2);
                        ConstraintLayout constraintLayout3 = DoorControlFragment.access$getBinding(doorControlFragment).clLoginFail;
                        Intrinsics.checkNotNullExpressionValue(constraintLayout3, "binding.clLoginFail");
                        SimpleUtilsKt.remove(constraintLayout3);
                        GPIOUtils gPIOUtils = GPIOUtils.INSTANCE;
                        Context contextRequireContext = doorControlFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                        gPIOUtils.open(contextRequireContext);
                        return;
                    }
                    return;
                }
                ConstraintLayout constraintLayout4 = DoorControlFragment.access$getBinding(DoorControlFragment.this).clFragmentDoorControlAccount;
                Intrinsics.checkNotNullExpressionValue(constraintLayout4, "binding.clFragmentDoorControlAccount");
                SimpleUtilsKt.remove(constraintLayout4);
                ConstraintLayout constraintLayout5 = DoorControlFragment.access$getBinding(DoorControlFragment.this).clLoginSuccess;
                Intrinsics.checkNotNullExpressionValue(constraintLayout5, "binding.clLoginSuccess");
                SimpleUtilsKt.remove(constraintLayout5);
                ConstraintLayout constraintLayout6 = DoorControlFragment.access$getBinding(DoorControlFragment.this).clLoginFail;
                Intrinsics.checkNotNullExpressionValue(constraintLayout6, "binding.clLoginFail");
                SimpleUtilsKt.show(constraintLayout6);
                TextView textView = DoorControlFragment.access$getBinding(DoorControlFragment.this).tvTipMessageFail;
                Throwable thM594exceptionOrNullimpl = Result.m594exceptionOrNullimpl(it2.getValue());
                if (thM594exceptionOrNullimpl == null || (message = thM594exceptionOrNullimpl.getMessage()) == null) {
                    message = "密码输入错误，请重试";
                }
                textView.setText(message);
            }
        };
        verifyTeacher.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.iotControl.fragment.-$$Lambda$DoorControlFragment$KOKoTWpLG0D1sCwKyHx0aaQliF8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DoorControlFragment.initViewModel$lambda$8(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.yd.android_brand_mvp.observer.ObserverListener
    public void observerUpData(String cardNo) {
        Intrinsics.checkNotNullParameter(cardNo, "cardNo");
        BaseConstant.exitOutTime = this.backTime;
        if (this.currentVerifyMode == 2 && isAdded()) {
            DatabaseUtil databaseUtil = DatabaseUtil.INSTANCE;
            Activity mActivity = this.mActivity;
            Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
            FacePeople facePeopleCard = databaseUtil.getFacePeopleCard(mActivity, cardNo);
            if (facePeopleCard != null) {
                DoorControlViewModel viewModel = getViewModel();
                String userId = facePeopleCard.getUserId();
                String userType = facePeopleCard.getUserType();
                viewModel.addOpenDoorRecodes(userId, "2", userType != null ? userType : "");
                setTipUI(0, cardNo);
                return;
            }
            IdentityBean permissionIdentityInfo = SettingPermision.getInstance().getPermissionIdentityInfo(cardNo);
            if (permissionIdentityInfo != null) {
                setTipUI(0, cardNo);
                String identityId = permissionIdentityInfo.getIdentityId();
                if (identityId != null) {
                    DoorControlViewModel viewModel2 = getViewModel();
                    String personType = permissionIdentityInfo.getPersonType();
                    viewModel2.addOpenDoorRecodes(identityId, "2", personType != null ? personType : "");
                    return;
                }
                return;
            }
            setTipUI(2, cardNo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTipUI(int status, String number) {
        if (status == -1) {
            getBinding().clFragmentDoorControl.setBackground(null);
            ImageView imageView = getBinding().ivFragmentDoorControlTip;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivFragmentDoorControlTip");
            SimpleUtilsKt.hide(imageView);
            getBinding().tvFragmentDoorControlTip.setText("");
        } else if (status == 0) {
            GPIOUtils gPIOUtils = GPIOUtils.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            gPIOUtils.open(contextRequireContext);
            getBinding().clFragmentDoorControl.setBackgroundResource(R.drawable.bg_green_ddffcd_r30);
            ImageView imageView2 = getBinding().ivFragmentDoorControlTip;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivFragmentDoorControlTip");
            SimpleUtilsKt.show(imageView2);
            getBinding().ivFragmentDoorControlTip.setImageResource(R.drawable.icon_green_right);
            getBinding().tvFragmentDoorControlTip.setText("识别成功，请通行");
        } else if (status == 1) {
            getBinding().clFragmentDoorControl.setBackgroundResource(R.drawable.bg_red_r30);
            ImageView imageView3 = getBinding().ivFragmentDoorControlTip;
            Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ivFragmentDoorControlTip");
            SimpleUtilsKt.show(imageView3);
            getBinding().ivFragmentDoorControlTip.setImageResource(R.drawable.icon_main_jg);
            getBinding().tvFragmentDoorControlTip.setText(FaceMsg.FaceNO);
        } else if (status == 2) {
            getBinding().clFragmentDoorControl.setBackgroundResource(R.drawable.bg_red_r30);
            ImageView imageView4 = getBinding().ivFragmentDoorControlTip;
            Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ivFragmentDoorControlTip");
            SimpleUtilsKt.show(imageView4);
            getBinding().ivFragmentDoorControlTip.setImageResource(R.drawable.icon_main_jg);
            getBinding().tvFragmentDoorControlTip.setText("验证失败(卡号:" + number + ')');
        } else if (status == 3) {
            getBinding().clFragmentDoorControl.setBackgroundResource(R.drawable.bg_yellow_ffe4bd_r30);
            ImageView imageView5 = getBinding().ivFragmentDoorControlTip;
            Intrinsics.checkNotNullExpressionValue(imageView5, "binding.ivFragmentDoorControlTip");
            SimpleUtilsKt.show(imageView5);
            getBinding().ivFragmentDoorControlTip.setImageResource(R.drawable.icon_warn_origin);
            getBinding().tvFragmentDoorControlTip.setText("正在识别中...请耐心等待");
        } else if (status == 4) {
            getBinding().clFragmentDoorControl.setBackgroundResource(R.drawable.bg_yellow_ffe4bd_r30);
            ImageView imageView6 = getBinding().ivFragmentDoorControlTip;
            Intrinsics.checkNotNullExpressionValue(imageView6, "binding.ivFragmentDoorControlTip");
            SimpleUtilsKt.show(imageView6);
            getBinding().ivFragmentDoorControlTip.setImageResource(R.drawable.icon_warn_origin);
            getBinding().tvFragmentDoorControlTip.setText("重复识别");
        }
        if (status != -1) {
            getViewModel().setTimer(3L);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        releaseFaceSDK();
    }
}
