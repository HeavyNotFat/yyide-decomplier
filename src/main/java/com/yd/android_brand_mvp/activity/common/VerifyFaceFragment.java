package com.yd.android_brand_mvp.activity.common;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentVerifyFaceBinding;
import com.yd.android_brand_mvp.model.EventTimerBean;
import com.yd.android_brand_mvp.model.VerifyEventBean;
import com.yd.android_brand_mvp.model.selectTeacherByIcCardRsp;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.FaceMsg;
import com.yd.android_brand_mvp.widget.FaceView;
import com.yyide.facepass.AppExtKt;
import com.yyide.facepass.FaceManager;
import com.yyide.facepass.OnRecognizeCallback;
import com.yyide.facepass.bean.RecognizeResultBean;
import com.yyide.facepass.camera.CameraPreview;
import com.yyide.facepass.database.DatabaseUtil;
import com.yyide.facepass.database.FacePeople;
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

/* JADX INFO: compiled from: VerifyFaceFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u000b\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u001a\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/yd/android_brand_mvp/activity/common/VerifyFaceFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentVerifyFaceBinding;", "()V", "cameraView", "Lcom/yyide/facepass/camera/CameraPreview;", "lastRecognizeTime", "", "lastRecognizeUserId", "", "onRecognizeCallback", "com/yd/android_brand_mvp/activity/common/VerifyFaceFragment$onRecognizeCallback$1", "Lcom/yd/android_brand_mvp/activity/common/VerifyFaceFragment$onRecognizeCallback$1;", "postBean", "Lcom/yd/android_brand_mvp/model/VerifyEventBean;", "type", "viewModel", "Lcom/yd/android_brand_mvp/activity/common/viewmodel/VerifyViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/common/viewmodel/VerifyViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "registerFaceSDK", "releaseFaceSDK", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VerifyFaceFragment extends KTBaseFragment<FragmentVerifyFaceBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CameraPreview cameraView;
    private long lastRecognizeTime;
    private String lastRecognizeUserId;
    private final VerifyFaceFragment$onRecognizeCallback$1 onRecognizeCallback;
    private final VerifyEventBean postBean;
    private String type;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.common.VerifyFaceFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: VerifyFaceFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentVerifyFaceBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentVerifyFaceBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentVerifyFaceBinding;", 0);
        }

        public final FragmentVerifyFaceBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentVerifyFaceBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentVerifyFaceBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.yd.android_brand_mvp.activity.common.VerifyFaceFragment$onRecognizeCallback$1] */
    public VerifyFaceFragment() {
        super(AnonymousClass1.INSTANCE);
        this.lastRecognizeUserId = "";
        this.type = "";
        final VerifyFaceFragment verifyFaceFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyFaceFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return verifyFaceFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyFaceFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(verifyFaceFragment, Reflection.getOrCreateKotlinClass(VerifyViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyFaceFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyFaceFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyFaceFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = verifyFaceFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.postBean = new VerifyEventBean(null, null, false, null, null, 31, null);
        this.onRecognizeCallback = new OnRecognizeCallback() { // from class: com.yd.android_brand_mvp.activity.common.VerifyFaceFragment$onRecognizeCallback$1
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
                FaceView faceView = this.this$0.getBinding().faceViewFragmentVerifyFace;
                CameraPreview cameraPreview = this.this$0.cameraView;
                if (cameraPreview == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cameraView");
                    cameraPreview = null;
                }
                faceView.showFacePassFace(dataList, cameraPreview);
            }

            @Override // com.yyide.facepass.OnRecognizeCallback
            public void onFaceDismiss() {
                this.this$0.getBinding().faceViewFragmentVerifyFace.clear();
                this.this$0.getBinding().faceViewFragmentVerifyFace.invalidate();
            }

            @Override // com.yyide.facepass.OnRecognizeCallback
            public void onFaceRecognizeSimple(RecognizeResultBean faceData) {
                Intrinsics.checkNotNullParameter(faceData, "faceData");
                if (SpData.isFaceEnable()) {
                    if (TextUtils.isEmpty(faceData.getUserId())) {
                        ToastUtil.showBottomView(this.this$0.requireContext(), FaceMsg.FaceNO);
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String userId = faceData.getUserId();
                    if (jCurrentTimeMillis - this.this$0.lastRecognizeTime <= 30000 || Intrinsics.areEqual(this.this$0.lastRecognizeUserId, userId)) {
                        return;
                    }
                    VerifyFaceFragment verifyFaceFragment2 = this.this$0;
                    if (userId == null) {
                        userId = "";
                    }
                    verifyFaceFragment2.lastRecognizeUserId = userId;
                    this.this$0.lastRecognizeTime = jCurrentTimeMillis;
                    DatabaseUtil databaseUtil = DatabaseUtil.INSTANCE;
                    Activity mActivity = this.this$0.mActivity;
                    Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
                    FacePeople faceByUserId = databaseUtil.getFaceByUserId(mActivity, this.this$0.lastRecognizeUserId);
                    if (faceByUserId != null) {
                        VerifyFaceFragment verifyFaceFragment3 = this.this$0;
                        if (Intrinsics.areEqual(faceByUserId.getUserType(), "2")) {
                            VerifyViewModel viewModel = verifyFaceFragment3.getViewModel();
                            String userId2 = faceByUserId.getUserId();
                            String userType = faceByUserId.getUserType();
                            viewModel.checkTeacherInfo(userId2, userType != null ? userType : "2");
                            return;
                        }
                        verifyFaceFragment3.postBean.setId("0");
                        verifyFaceFragment3.postBean.setUserId(faceByUserId.getUserId());
                        verifyFaceFragment3.postBean.setUserName(faceByUserId.getName() + "");
                        verifyFaceFragment3.postBean.setStudent(true);
                        VerifyEventBean verifyEventBean = verifyFaceFragment3.postBean;
                        String schoolId = SpData.getSchoolId();
                        Intrinsics.checkNotNullExpressionValue(schoolId, "getSchoolId()");
                        verifyEventBean.setSchoolId(schoolId);
                        verifyFaceFragment3.getViewModel().patrolPunch(faceByUserId.getUserId());
                        return;
                    }
                    return;
                }
                ToastUtil.showBottomView(this.this$0.requireContext(), FaceMsg.FaceEnable);
            }
        };
    }

    /* JADX INFO: compiled from: VerifyFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/common/VerifyFaceFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/common/VerifyFaceFragment;", "type", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VerifyFaceFragment newInstance(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            VerifyFaceFragment verifyFaceFragment = new VerifyFaceFragment();
            verifyFaceFragment.setArguments(bundle);
            return verifyFaceFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VerifyViewModel getViewModel() {
        return (VerifyViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        CameraPreview cameraPreview = getBinding().cameraFragmentVerifyFace;
        Intrinsics.checkNotNullExpressionValue(cameraPreview, "binding.cameraFragmentVerifyFace");
        this.cameraView = cameraPreview;
        registerFaceSDK();
        initView();
    }

    private final void registerFaceSDK() {
        FaceManager faceManager = FaceManager.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        FragmentActivity fragmentActivity = fragmentActivityRequireActivity;
        CameraPreview cameraPreview = this.cameraView;
        if (cameraPreview == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraView");
            cameraPreview = null;
        }
        faceManager.initFaceHandler(fragmentActivity, cameraPreview, this.onRecognizeCallback);
        AppExtKt.logd(this, "注册人脸功能");
    }

    private final void releaseFaceSDK() {
        FaceManager.INSTANCE.onDestroyCamera();
        CameraPreview cameraPreview = this.cameraView;
        if (cameraPreview == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraView");
            cameraPreview = null;
        }
        cameraPreview.clearFocus();
        AppExtKt.logd(this, "注销人脸功能");
    }

    private final void initView() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("type") : null;
        if (string == null) {
            string = "";
        }
        this.type = string;
        LiveData<Result<selectTeacherByIcCardRsp.DataDTO>> teacherInfoByFace = getViewModel().getTeacherInfoByFace();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends selectTeacherByIcCardRsp.DataDTO>, Unit> function1 = new Function1<Result<? extends selectTeacherByIcCardRsp.DataDTO>, Unit>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyFaceFragment.initView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends selectTeacherByIcCardRsp.DataDTO> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends selectTeacherByIcCardRsp.DataDTO> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                selectTeacherByIcCardRsp.DataDTO dataDTO = (selectTeacherByIcCardRsp.DataDTO) value;
                if (dataDTO == null) {
                    Context contextRequireContext = VerifyFaceFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    SimpleUtilsKt.showLongToast(contextRequireContext, "不是教师人员");
                    return;
                }
                VerifyEventBean verifyEventBean = new VerifyEventBean(null, null, false, null, null, 31, null);
                verifyEventBean.setId(String.valueOf(dataDTO.id));
                verifyEventBean.setUserId(String.valueOf(dataDTO.userId));
                String str = dataDTO.name;
                Intrinsics.checkNotNullExpressionValue(str, "userData.name");
                verifyEventBean.setUserName(str);
                verifyEventBean.setStudent(false);
                verifyEventBean.setSchoolId(String.valueOf(dataDTO.schoolId));
                EventBus.getDefault().post(verifyEventBean);
            }
        };
        teacherInfoByFace.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.common.-$$Lambda$VerifyFaceFragment$Nt7amxPbHjo1HlIhvU5rRrVF2cQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerifyFaceFragment.initView$lambda$0(function1, obj);
            }
        });
        LiveData<Result<Boolean>> patrolPunch = getViewModel().getPatrolPunch();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends Boolean>, Unit> function2 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.common.VerifyFaceFragment.initView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Boolean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends Boolean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    EventBus.getDefault().post(VerifyFaceFragment.this.postBean);
                }
            }
        };
        patrolPunch.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.activity.common.-$$Lambda$VerifyFaceFragment$BpntHKbWCULYFGikxqmQYT3mkfI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VerifyFaceFragment.initView$lambda$1(function2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        releaseFaceSDK();
    }
}
