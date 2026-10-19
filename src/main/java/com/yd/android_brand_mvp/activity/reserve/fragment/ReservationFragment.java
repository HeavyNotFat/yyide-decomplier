package com.yd.android_brand_mvp.activity.reserve.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.reserve.viewmodel.ReservationViewModel;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentReservationDetailBinding;
import com.yd.android_brand_mvp.databinding.ItemReservationSignBinding;
import com.yd.android_brand_mvp.model.EventTimerBean;
import com.yd.android_brand_mvp.model.UserIcCardBean;
import com.yd.android_brand_mvp.model.reservation.ReservationDetailBean;
import com.yd.android_brand_mvp.model.reservation.ReservationSignListItemBean;
import com.yd.android_brand_mvp.observer.ObserverListener;
import com.yd.android_brand_mvp.observer.ObserverManager;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.Tool;
import com.yd.android_brand_mvp.verfity.FaceMsg;
import com.yd.android_brand_mvp.widget.FaceView;
import com.yyide.facepass.AppExtKt;
import com.yyide.facepass.FaceManager;
import com.yyide.facepass.OnRecognizeCallback;
import com.yyide.facepass.bean.RecognizeResultBean;
import com.yyide.facepass.camera.CameraPreview;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import mcv.facepass.types.FacePassFace;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: compiled from: ReservationFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0011\u0014\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00015B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\nH\u0016J\b\u0010(\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\fH\u0016J\b\u0010+\u001a\u00020%H\u0016J\b\u0010,\u001a\u00020%H\u0016J\u001a\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020%H\u0002J\b\u00103\u001a\u00020%H\u0002J\b\u00104\u001a\u00020%H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b!\u0010\"¨\u00066"}, d2 = {"Lcom/yd/android_brand_mvp/activity/reserve/fragment/ReservationFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentReservationDetailBinding;", "Lcom/yd/android_brand_mvp/observer/ObserverListener;", "()V", "cameraView", "Lcom/yyide/facepass/camera/CameraPreview;", "currentVerifyMode", "", "id", "", "isPortrait", "", "lastRecognizeTime", "", "lastRecognizeUserId", "onRecognizeCallback", "com/yd/android_brand_mvp/activity/reserve/fragment/ReservationFragment$onRecognizeCallback$1", "Lcom/yd/android_brand_mvp/activity/reserve/fragment/ReservationFragment$onRecognizeCallback$1;", "peopleAdapter", "com/yd/android_brand_mvp/activity/reserve/fragment/ReservationFragment$peopleAdapter$2$1", "getPeopleAdapter", "()Lcom/yd/android_brand_mvp/activity/reserve/fragment/ReservationFragment$peopleAdapter$2$1;", "peopleAdapter$delegate", "Lkotlin/Lazy;", "showData", "Lcom/yd/android_brand_mvp/model/reservation/ReservationDetailBean;", "showSignInList", "signList", "", "Lcom/yd/android_brand_mvp/model/reservation/ReservationSignListItemBean;", "viewModel", "Lcom/yd/android_brand_mvp/activity/reserve/viewmodel/ReservationViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/reserve/viewmodel/ReservationViewModel;", "viewModel$delegate", "initView", "", "observerUpData", "cardNo", "onDestroy", "onHiddenChanged", "hidden", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "registerFaceSDK", "releaseFaceSDK", "setShowSignInList", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ReservationFragment extends KTBaseFragment<FragmentReservationDetailBinding> implements ObserverListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CameraPreview cameraView;
    private int currentVerifyMode;
    private String id;
    private boolean isPortrait;
    private long lastRecognizeTime;
    private String lastRecognizeUserId;
    private final ReservationFragment$onRecognizeCallback$1 onRecognizeCallback;

    /* JADX INFO: renamed from: peopleAdapter$delegate, reason: from kotlin metadata */
    private final Lazy peopleAdapter;
    private ReservationDetailBean showData;
    private int showSignInList;
    private final List<ReservationSignListItemBean> signList;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.reserve.fragment.ReservationFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ReservationFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentReservationDetailBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentReservationDetailBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentReservationDetailBinding;", 0);
        }

        public final FragmentReservationDetailBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentReservationDetailBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentReservationDetailBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentReservationDetailBinding access$getBinding(ReservationFragment reservationFragment) {
        return reservationFragment.getBinding();
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.yd.android_brand_mvp.activity.reserve.fragment.ReservationFragment$onRecognizeCallback$1] */
    public ReservationFragment() {
        super(AnonymousClass1.INSTANCE);
        final ReservationFragment reservationFragment = this;
        final Function0 function0 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(reservationFragment, Reflection.getOrCreateKotlinClass(ReservationViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.ReservationFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = reservationFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.ReservationFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                if (function1 != null && (creationExtras = (CreationExtras) function1.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = reservationFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.ReservationFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = reservationFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.currentVerifyMode = 1;
        this.showSignInList = 1;
        this.id = "-1";
        this.lastRecognizeUserId = "";
        this.signList = new ArrayList();
        this.peopleAdapter = LazyKt.lazy(new Function0<ReservationFragment$peopleAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.ReservationFragment$peopleAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.activity.reserve.fragment.ReservationFragment$peopleAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new BaseBindingAdapter<ItemReservationSignBinding, ReservationSignListItemBean>() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.ReservationFragment$peopleAdapter$2.1
                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, ReservationSignListItemBean reservationSignListItemBean) {
                        convertPlus2((VBViewHolder<ItemReservationSignBinding>) vBViewHolder, reservationSignListItemBean);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemReservationSignBinding> holder, ReservationSignListItemBean item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemReservationSignBinding itemReservationSignBinding = (ItemReservationSignBinding) holder.getBinding();
                        if (itemReservationSignBinding != null) {
                            GlideUtil.loadCircleImage(getContext(), item.getAvatar(), itemReservationSignBinding.ivItemReservationSignAvatar);
                            itemReservationSignBinding.tvItemReservationSignName.setText(item.getUserName());
                            if (item.getToSignInTime().length() == 0) {
                                TextView textView = itemReservationSignBinding.tvItemReservationSignTime;
                                Intrinsics.checkNotNullExpressionValue(textView, "it.tvItemReservationSignTime");
                                SimpleUtilsKt.remove(textView);
                            } else {
                                TextView textView2 = itemReservationSignBinding.tvItemReservationSignTime;
                                Intrinsics.checkNotNullExpressionValue(textView2, "it.tvItemReservationSignTime");
                                SimpleUtilsKt.show(textView2);
                                itemReservationSignBinding.tvItemReservationSignTime.setText(item.getToSignInTime());
                            }
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemReservationSignBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemReservationSignBinding itemReservationSignBindingInflate = ItemReservationSignBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemReservationSignBindingInflate, "inflate(inflater, parent, false)");
                        return itemReservationSignBindingInflate;
                    }
                };
            }
        });
        this.onRecognizeCallback = new OnRecognizeCallback() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.ReservationFragment$onRecognizeCallback$1
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
                FaceView faceView = ReservationFragment.access$getBinding(this.this$0).faceViewFragmentReservationDetailFace;
                CameraPreview cameraPreview = this.this$0.cameraView;
                if (cameraPreview == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cameraView");
                    cameraPreview = null;
                }
                faceView.showFacePassFace(dataList, cameraPreview);
            }

            @Override // com.yyide.facepass.OnRecognizeCallback
            public void onFaceDismiss() {
                ReservationFragment.access$getBinding(this.this$0).faceViewFragmentReservationDetailFace.clear();
                ReservationFragment.access$getBinding(this.this$0).faceViewFragmentReservationDetailFace.invalidate();
            }

            @Override // com.yyide.facepass.OnRecognizeCallback
            public void onFaceRecognizeSimple(RecognizeResultBean faceData) {
                Object next;
                Intrinsics.checkNotNullParameter(faceData, "faceData");
                if (this.this$0.currentVerifyMode != 1) {
                    return;
                }
                if (SpData.isFaceEnable()) {
                    if (TextUtils.isEmpty(faceData.getUserId())) {
                        ToastUtil.showBottomView(this.this$0.requireContext(), FaceMsg.FaceNO);
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String userId = faceData.getUserId();
                    if (userId == null) {
                        userId = "";
                    }
                    if (jCurrentTimeMillis - this.this$0.lastRecognizeTime <= 30000 || Intrinsics.areEqual(this.this$0.lastRecognizeUserId, userId)) {
                        return;
                    }
                    this.this$0.lastRecognizeUserId = userId;
                    this.this$0.lastRecognizeTime = jCurrentTimeMillis;
                    if (this.this$0.showData == null) {
                        return;
                    }
                    if (Tool.isNetworkAvailable(this.this$0.requireContext())) {
                        ReservationViewModel viewModel = this.this$0.getViewModel();
                        ReservationDetailBean reservationDetailBean = this.this$0.showData;
                        Intrinsics.checkNotNull(reservationDetailBean);
                        viewModel.signInRecord(userId, reservationDetailBean.getId());
                        return;
                    }
                    ToastUtil.showBottomView(this.this$0.requireContext(), this.this$0.getString(R.string.network_is_unavailable));
                    if (this.this$0.signList.isEmpty()) {
                        return;
                    }
                    Iterator it2 = this.this$0.signList.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                    } while (!Intrinsics.areEqual(((ReservationSignListItemBean) next).getUserId(), userId));
                    if (((ReservationSignListItemBean) next) == null) {
                        return;
                    }
                    String timeStr = DateUtils.getTodayStr(TimeUtil.allTimeFormat);
                    ReservationViewModel viewModel2 = this.this$0.getViewModel();
                    ReservationDetailBean reservationDetailBean2 = this.this$0.showData;
                    Intrinsics.checkNotNull(reservationDetailBean2);
                    String id = reservationDetailBean2.getId();
                    Intrinsics.checkNotNullExpressionValue(timeStr, "timeStr");
                    viewModel2.insertReservationSignDataToDao(id, userId, timeStr);
                    return;
                }
                ToastUtil.showBottomView(this.this$0.requireContext(), FaceMsg.FaceEnable);
            }
        };
    }

    /* JADX INFO: compiled from: ReservationFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/activity/reserve/fragment/ReservationFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "bookingId", "", "isPortrait", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Fragment newInstance$default(Companion companion, String str, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.newInstance(str, z);
        }

        public final Fragment newInstance(String bookingId, boolean isPortrait) {
            Intrinsics.checkNotNullParameter(bookingId, "bookingId");
            ReservationFragment reservationFragment = new ReservationFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", bookingId);
            bundle.putBoolean("isPortrait", isPortrait);
            reservationFragment.setArguments(bundle);
            return reservationFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReservationViewModel getViewModel() {
        return (ReservationViewModel) this.viewModel.getValue();
    }

    private final ReservationFragment$peopleAdapter$2.AnonymousClass1 getPeopleAdapter() {
        return (ReservationFragment$peopleAdapter$2.AnonymousClass1) this.peopleAdapter.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        this.isPortrait = arguments != null ? arguments.getBoolean("isPortrait") : false;
        CameraPreview cameraPreview = getBinding().cameraFragmentReservationDetailFace;
        Intrinsics.checkNotNull(cameraPreview, "null cannot be cast to non-null type com.yyide.facepass.camera.CameraPreview");
        this.cameraView = cameraPreview;
        registerFaceSDK();
        initView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            registerFaceSDK();
        } else {
            releaseFaceSDK();
        }
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
        AppExtKt.logd(this, "reservation 注册人脸功能");
    }

    private final void releaseFaceSDK() {
        FaceManager.INSTANCE.onDestroyCamera();
        CameraPreview cameraPreview = this.cameraView;
        if (cameraPreview == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraView");
            cameraPreview = null;
        }
        cameraPreview.clearFocus();
        AppExtKt.logd(this, "reservation 注销人脸功能");
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

    private final void initView() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("id") : null;
        if (string == null) {
            string = "-1";
        }
        this.id = string;
        getBinding().rvFragmentReservationDetailSign.setLayoutManager(new GridLayoutManager(requireContext(), this.isPortrait ? 5 : 7));
        getBinding().rvFragmentReservationDetailSign.setAdapter(getPeopleAdapter());
        getBinding().rvFragmentReservationDetailSign.setItemAnimator(null);
        TextView textView = getBinding().tvFragmentReservationDetailCount;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string2 = getString(R.string.all_count_people);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.all_count_people)");
        String str = String.format(string2, Arrays.copyOf(new Object[]{"0"}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView.setText(str);
        getBinding().btnFragmentReservationDetailFace.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.-$$Lambda$ReservationFragment$r5RG1Q-V3K1Hd7N1PQXQ-0MO4iw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReservationFragment.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().btnFragmentReservationDetailCard.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.-$$Lambda$ReservationFragment$hl6nSaX1-GZjBJGSxT_0ZwZUjcg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReservationFragment.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().tvFragmentReservationDetailNotSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.-$$Lambda$ReservationFragment$07x4AEIvUKPJzBXfeZhKPrNmugU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReservationFragment.initView$lambda$2(this.f$0, view);
            }
        });
        getBinding().tvFragmentReservationDetailSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.-$$Lambda$ReservationFragment$P57-TUOtAwJuwOM1Gzp3umsScJw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReservationFragment.initView$lambda$3(this.f$0, view);
            }
        });
        LiveData<ReservationDetailBean> reservationDetail = getViewModel().getReservationDetail();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<ReservationDetailBean, Unit> function1 = new Function1<ReservationDetailBean, Unit>() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.ReservationFragment.initView.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ReservationDetailBean reservationDetailBean) {
                invoke2(reservationDetailBean);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ReservationDetailBean reservationDetailBean) {
                ReservationFragment.this.showData = reservationDetailBean;
                if (reservationDetailBean == null) {
                    return;
                }
                ReservationFragment.access$getBinding(ReservationFragment.this).tvFragmentReservationDetailTheme.setText(reservationDetailBean.getName());
                ReservationFragment.access$getBinding(ReservationFragment.this).tvFragmentReservationDetailTime.setText(new Regex("\\s+").split(reservationDetailBean.getBookingTime(), 0).get(1));
                ReservationFragment.this.signList.clear();
                ReservationFragment.this.signList.addAll(reservationDetailBean.getSignList());
                ReservationFragment.this.setShowSignInList();
            }
        };
        reservationDetail.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.-$$Lambda$ReservationFragment$232r274flWdvaVOYm74cxZO4FXk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReservationFragment.initView$lambda$4(function1, obj);
            }
        });
        LiveData<Result<UserIcCardBean.DataBean>> selectStudentRsp = getViewModel().getSelectStudentRsp();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends UserIcCardBean.DataBean>, Unit> function2 = new Function1<Result<? extends UserIcCardBean.DataBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.ReservationFragment.initView.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends UserIcCardBean.DataBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends UserIcCardBean.DataBean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                UserIcCardBean.DataBean dataBean = (UserIcCardBean.DataBean) value;
                if (dataBean == null || ReservationFragment.this.showData == null) {
                    return;
                }
                ReservationViewModel viewModel = ReservationFragment.this.getViewModel();
                String str2 = dataBean.id;
                Intrinsics.checkNotNullExpressionValue(str2, "data.id");
                ReservationDetailBean reservationDetailBean = ReservationFragment.this.showData;
                Intrinsics.checkNotNull(reservationDetailBean);
                viewModel.signInRecord(str2, reservationDetailBean.getId());
            }
        };
        selectStudentRsp.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.-$$Lambda$ReservationFragment$-ZBfcQOdbt6D--_PatmBbWOysGY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReservationFragment.initView$lambda$5(function2, obj);
            }
        });
        LiveData<Result<Boolean>> signInResult = getViewModel().getSignInResult();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Result<? extends Boolean>, Unit> function3 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.ReservationFragment.initView.7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Boolean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends Boolean> result) {
                ToastUtil.showBottomView(ReservationFragment.this.requireContext(), "签到成功");
                ReservationFragment.this.getViewModel().getReservationDetail(ReservationFragment.this.id);
            }
        };
        signInResult.observe(viewLifecycleOwner3, new Observer() { // from class: com.yd.android_brand_mvp.activity.reserve.fragment.-$$Lambda$ReservationFragment$UyX25X0bgeQTCURHSAgOPSVx4V0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReservationFragment.initView$lambda$6(function3, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(ReservationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentVerifyMode = 1;
        ImageView imageView = this$0.getBinding().ivCard;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivCard");
        SimpleUtilsKt.remove(imageView);
        CameraPreview cameraPreview = this$0.getBinding().cameraFragmentReservationDetailFace;
        Intrinsics.checkNotNullExpressionValue(cameraPreview, "binding.cameraFragmentReservationDetailFace");
        SimpleUtilsKt.show(cameraPreview);
        FaceView faceView = this$0.getBinding().faceViewFragmentReservationDetailFace;
        Intrinsics.checkNotNullExpressionValue(faceView, "binding.faceViewFragmentReservationDetailFace");
        SimpleUtilsKt.show(faceView);
        view.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_purple23));
        this$0.getBinding().btnFragmentReservationDetailFace.setTextColor(SimpleUtilsKt.asColor(R.color.white));
        this$0.getBinding().btnFragmentReservationDetailCard.setTextColor(SimpleUtilsKt.asColor(R.color.black10));
        this$0.getBinding().btnFragmentReservationDetailCard.setBackground(SimpleUtilsKt.asDrawable(R.drawable.frame_grey_cc_r20));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(ReservationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentVerifyMode = 2;
        ImageView imageView = this$0.getBinding().ivCard;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivCard");
        SimpleUtilsKt.show(imageView);
        CameraPreview cameraPreview = this$0.getBinding().cameraFragmentReservationDetailFace;
        Intrinsics.checkNotNullExpressionValue(cameraPreview, "binding.cameraFragmentReservationDetailFace");
        SimpleUtilsKt.hide(cameraPreview);
        FaceView faceView = this$0.getBinding().faceViewFragmentReservationDetailFace;
        Intrinsics.checkNotNullExpressionValue(faceView, "binding.faceViewFragmentReservationDetailFace");
        SimpleUtilsKt.hide(faceView);
        view.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_purple23));
        this$0.getBinding().btnFragmentReservationDetailCard.setTextColor(SimpleUtilsKt.asColor(R.color.white));
        this$0.getBinding().btnFragmentReservationDetailFace.setTextColor(SimpleUtilsKt.asColor(R.color.black10));
        this$0.getBinding().btnFragmentReservationDetailFace.setBackground(SimpleUtilsKt.asDrawable(R.drawable.frame_grey_cc_r20));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(ReservationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().tvFragmentReservationDetailNotSign.setTextColor(SimpleUtilsKt.asColor(R.color.white));
        this$0.getBinding().tvFragmentReservationDetailNotSign.setBackgroundResource(R.drawable.bg_purple23);
        this$0.getBinding().tvFragmentReservationDetailSign.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
        this$0.getBinding().tvFragmentReservationDetailSign.setBackground(null);
        this$0.showSignInList = 2;
        this$0.setShowSignInList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(ReservationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().tvFragmentReservationDetailSign.setTextColor(SimpleUtilsKt.asColor(R.color.white));
        this$0.getBinding().tvFragmentReservationDetailSign.setBackgroundResource(R.drawable.bg_purple23);
        this$0.getBinding().tvFragmentReservationDetailNotSign.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
        this$0.getBinding().tvFragmentReservationDetailNotSign.setBackground(null);
        this$0.showSignInList = 1;
        this$0.setShowSignInList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setShowSignInList() {
        ArrayList arrayList;
        if (this.showSignInList == 1) {
            List<ReservationSignListItemBean> list = this.signList;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (((ReservationSignListItemBean) obj).getSignInTime().length() > 0) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        } else {
            List<ReservationSignListItemBean> list2 = this.signList;
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : list2) {
                if (((ReservationSignListItemBean) obj2).getSignInTime().length() == 0) {
                    arrayList3.add(obj2);
                }
            }
            arrayList = arrayList3;
        }
        TextView textView = getBinding().tvFragmentReservationDetailCount;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.all_count_people);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.all_count_people)");
        String str = String.format(string, Arrays.copyOf(new Object[]{"" + arrayList.size()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView.setText(str);
        getPeopleAdapter().setList(arrayList);
    }

    @Override // com.yd.android_brand_mvp.observer.ObserverListener
    public void observerUpData(String cardNo) {
        Intrinsics.checkNotNullParameter(cardNo, "cardNo");
        if (this.currentVerifyMode != 2) {
            return;
        }
        if (!Tool.isNetworkAvailable(requireContext())) {
            ToastUtil.showBottomView(requireContext(), getString(R.string.network_is_unavailable));
        } else {
            getViewModel().checkUserInfo(cardNo);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        releaseFaceSDK();
    }
}
