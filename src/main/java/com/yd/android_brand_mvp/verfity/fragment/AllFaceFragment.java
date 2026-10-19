package com.yd.android_brand_mvp.verfity.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blankj.utilcode.util.LogUtils;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.ResultCodeStr;
import com.yd.android_brand_mvp.databinding.FragmentAllFaceBinding;
import com.yd.android_brand_mvp.model.EventTimerBean;
import com.yd.android_brand_mvp.model.task.TaskVerifyBean;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.verfity.AllCheckActivity;
import com.yd.android_brand_mvp.verfity.AllCheckViewModel;
import com.yd.android_brand_mvp.verfity.CheckEnum;
import com.yd.android_brand_mvp.verfity.FaceMsg;
import com.yyide.facepass.FaceManager;
import com.yyide.facepass.OnRecognizeCallback;
import com.yyide.facepass.bean.RecognizeResultBean;
import com.yyide.facepass.camera.CameraPreview;
import java.util.Iterator;
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
import mcv.facepass.types.FacePassFace;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: compiled from: AllFaceFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\r\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0006\u0010\u001b\u001a\u00020\u0017J\u0006\u0010\u001c\u001a\u00020\u0017J\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u0014¨\u0006$"}, d2 = {"Lcom/yd/android_brand_mvp/verfity/fragment/AllFaceFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentAllFaceBinding;", "()V", "asActivity", "Lcom/yd/android_brand_mvp/verfity/AllCheckActivity;", "getAsActivity", "()Lcom/yd/android_brand_mvp/verfity/AllCheckActivity;", "asActivity$delegate", "Lkotlin/Lazy;", "cameraPreview", "Lcom/yyide/facepass/camera/CameraPreview;", "onRecognizeCallback", "com/yd/android_brand_mvp/verfity/fragment/AllFaceFragment$onRecognizeCallback$1", "Lcom/yd/android_brand_mvp/verfity/fragment/AllFaceFragment$onRecognizeCallback$1;", "toDoType", "", "viewModel", "Lcom/yd/android_brand_mvp/verfity/AllCheckViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/verfity/AllCheckViewModel;", "viewModel$delegate", "faceTask", "", "temp", "Lcom/yyide/facepass/bean/RecognizeResultBean;", "initFace", "initView", "initViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "stopFace", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AllFaceFragment extends KTBaseFragment<FragmentAllFaceBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TYPE = "type";

    /* JADX INFO: renamed from: asActivity$delegate, reason: from kotlin metadata */
    private final Lazy asActivity;
    private CameraPreview cameraPreview;
    private final AllFaceFragment$onRecognizeCallback$1 onRecognizeCallback;
    private int toDoType;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.verfity.fragment.AllFaceFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: AllFaceFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentAllFaceBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentAllFaceBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentAllFaceBinding;", 0);
        }

        public final FragmentAllFaceBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentAllFaceBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentAllFaceBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.yd.android_brand_mvp.verfity.fragment.AllFaceFragment$onRecognizeCallback$1] */
    public AllFaceFragment() {
        super(AnonymousClass1.INSTANCE);
        this.asActivity = LazyKt.lazy(new Function0<AllCheckActivity>() { // from class: com.yd.android_brand_mvp.verfity.fragment.AllFaceFragment$asActivity$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AllCheckActivity invoke() {
                return (AllCheckActivity) this.this$0.mActivity;
            }
        });
        this.toDoType = -1;
        final AllFaceFragment allFaceFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.verfity.fragment.AllFaceFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return allFaceFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.verfity.fragment.AllFaceFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(allFaceFragment, Reflection.getOrCreateKotlinClass(AllCheckViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.verfity.fragment.AllFaceFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.verfity.fragment.AllFaceFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.verfity.fragment.AllFaceFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = allFaceFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.onRecognizeCallback = new OnRecognizeCallback() { // from class: com.yd.android_brand_mvp.verfity.fragment.AllFaceFragment$onRecognizeCallback$1
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
                this.this$0.getBinding().faceView.showFacePassFace(dataList, this.this$0.cameraPreview);
            }

            @Override // com.yyide.facepass.OnRecognizeCallback
            public void onFaceDismiss() {
                this.this$0.getBinding().faceView.clear();
                this.this$0.getBinding().faceView.invalidate();
            }

            @Override // com.yyide.facepass.OnRecognizeCallback
            public void onFaceRecognizeSimple(RecognizeResultBean faceData) {
                Intrinsics.checkNotNullParameter(faceData, "faceData");
                if (SpData.isFaceEnable()) {
                    AllCheckActivity asActivity = this.this$0.getAsActivity();
                    if (asActivity != null && asActivity.getIndex() == 1) {
                        LogUtils.i(GsonUtils.toJson(faceData));
                        if (!TextUtils.isEmpty(faceData.getUserId())) {
                            this.this$0.faceTask(faceData);
                            return;
                        } else {
                            ToastUtil.showBottomView(this.this$0.mActivity, FaceMsg.FaceNO);
                            return;
                        }
                    }
                    return;
                }
                ToastUtil.showBottomView(this.this$0.mActivity, FaceMsg.FaceEnable);
            }
        };
    }

    /* JADX INFO: compiled from: AllFaceFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/verfity/fragment/AllFaceFragment$Companion;", "", "()V", "TYPE", "", "getTYPE", "()Ljava/lang/String;", "newInstance", "Lcom/yd/android_brand_mvp/verfity/fragment/AllFaceFragment;", "layoutTag", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTYPE() {
            return AllFaceFragment.TYPE;
        }

        public final AllFaceFragment newInstance(int layoutTag) {
            AllFaceFragment allFaceFragment = new AllFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AllFaceFragment.INSTANCE.getTYPE(), layoutTag);
            allFaceFragment.setArguments(bundle);
            return allFaceFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AllCheckActivity getAsActivity() {
        return (AllCheckActivity) this.asActivity.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.toDoType = arguments.getInt(TYPE);
        }
        initView();
    }

    private final AllCheckViewModel getViewModel() {
        return (AllCheckViewModel) this.viewModel.getValue();
    }

    public final void initView() {
        this.cameraPreview = new CameraPreview(getActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        CameraPreview cameraPreview = this.cameraPreview;
        if (cameraPreview != null) {
            cameraPreview.setLayoutParams(layoutParams);
        }
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void initViewModel() {
        MutableLiveData<Result<String>> pauschCard = getViewModel().getPauschCard();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        final Function1<Result<? extends String>, Unit> function1 = new Function1<Result<? extends String>, Unit>() { // from class: com.yd.android_brand_mvp.verfity.fragment.AllFaceFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends String> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends String> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    ToastUtil.showBottomView(AllFaceFragment.this.requireContext(), "签到成功");
                } else {
                    ToastUtil.showBottomView(AllFaceFragment.this.requireContext(), "签到失败");
                }
            }
        };
        pauschCard.observe(fragmentActivityRequireActivity, new Observer() { // from class: com.yd.android_brand_mvp.verfity.fragment.-$$Lambda$AllFaceFragment$0Zxh4eRlZOQEKQ8P1jrD1qDI4YY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AllFaceFragment.initViewModel$lambda$1(function1, obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        initFace();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        stopFace();
    }

    private final void initFace() {
        try {
            getBinding().previewView.removeView(this.cameraPreview);
            getBinding().previewView.addView(this.cameraPreview);
            FaceManager faceManager = FaceManager.INSTANCE;
            Activity mActivity = this.mActivity;
            Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
            CameraPreview cameraPreview = this.cameraPreview;
            Intrinsics.checkNotNull(cameraPreview);
            faceManager.initFaceHandler(mActivity, cameraPreview, this.onRecognizeCallback);
        } catch (Exception e) {
            LogUtils.i("initFace init:" + e.getMessage());
            e.printStackTrace();
        }
    }

    private final void stopFace() {
        try {
            getBinding().previewView.removeView(this.cameraPreview);
            FaceManager.INSTANCE.onDestroyCamera();
        } catch (Exception e) {
            LogUtils.i("initFace stop:" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void faceTask(RecognizeResultBean temp) {
        if (this.toDoType == CheckEnum.THIRD_PARTY.getTodoType()) {
            String userId = temp.getUserId();
            getViewModel().pauschCard(userId != null ? userId : "");
            return;
        }
        if (this.toDoType == CheckEnum.ACTIVE_REGISTRATION.getTodoType()) {
            Log.i("FaceFragment", "活动人脸验证成功");
            String userId2 = temp.getUserId();
            if (userId2 == null) {
                userId2 = "";
            }
            String userType = temp.getUserType();
            if (userType == null) {
                userType = "";
            }
            Intent intent = new Intent();
            intent.putExtra(ResultCodeStr.NORMAL_TYPE_CODE, ResultCodeStr.ACTIVE_REGISTRATION_VERIFY);
            intent.putExtra(ResultCodeStr.TASK_SIGN_VERIFY_SUCCESS, new TaskVerifyBean(userId2, "", "", Intrinsics.areEqual(userType, "1") ? "0" : "1"));
            requireActivity().setResult(-1, intent);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }
}
