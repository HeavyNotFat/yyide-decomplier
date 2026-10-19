package com.yd.android_brand_mvp.landscape.university;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
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
import androidx.work.WorkRequest;
import com.blankj.utilcode.util.SPUtils;
import com.google.android.exoplayer2.C;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.yd.android_brand_mvp.activity.reserve.ReservationActivity;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.FragmentReservationBinding;
import com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.reservation.ReservationDetailBean;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
import com.yd.android_brand_mvp.model.reservation.ReservationSignListItemBean;
import com.yd.android_brand_mvp.utils.GPIOUtils;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.verfity.CheackNomalActivity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: UniversityReservationFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001c\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00142\b\u0010\"\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020\u001cH\u0002J\b\u0010%\u001a\u00020\u001cH\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(H\u0007J\u001a\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\u001cH\u0002R$\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u00060"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/UniversityReservationFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentReservationBinding;", "()V", "result", "", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "getResult", "()Ljava/util/List;", "setResult", "(Ljava/util/List;)V", "signList", "", "Lcom/yd/android_brand_mvp/model/reservation/ReservationSignListItemBean;", "timeReservation", "getTimeReservation", "()Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "setTimeReservation", "(Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;)V", "type", "", "viewModel", "Lcom/yd/android_brand_mvp/landscape/university/viewmodel/UniversityViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/university/viewmodel/UniversityViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "UpdataEvent", "", "id", "", "forRemindTime", "", "starTime", "endTime", "initView", "initViewModel", "onDestroyView", "onEvent", "eventBean", "Lcom/yd/android_brand_mvp/model/EventBean;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setTable", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UniversityReservationFragment extends KTBaseFragment<FragmentReservationBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LAYOUT_TAG = RemoteMessageConst.Notification.TAG;
    private List<ReservationRecordBean> result;
    private final List<ReservationSignListItemBean> signList;
    private ReservationRecordBean timeReservation;
    private String type;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @JvmStatic
    public static final UniversityReservationFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.UniversityReservationFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: UniversityReservationFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentReservationBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentReservationBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentReservationBinding;", 0);
        }

        public final FragmentReservationBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentReservationBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentReservationBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public UniversityReservationFragment() {
        super(AnonymousClass1.INSTANCE);
        final UniversityReservationFragment universityReservationFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.university.UniversityReservationFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return universityReservationFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.university.UniversityReservationFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(universityReservationFragment, Reflection.getOrCreateKotlinClass(UniversityViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.university.UniversityReservationFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.university.UniversityReservationFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.university.UniversityReservationFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = universityReservationFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.type = "";
        this.signList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UniversityViewModel getViewModel() {
        return (UniversityViewModel) this.viewModel.getValue();
    }

    public final ReservationRecordBean getTimeReservation() {
        return this.timeReservation;
    }

    public final void setTimeReservation(ReservationRecordBean reservationRecordBean) {
        this.timeReservation = reservationRecordBean;
    }

    public final List<ReservationRecordBean> getResult() {
        return this.result;
    }

    public final void setResult(List<ReservationRecordBean> list) {
        this.result = list;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0060  */
    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        getBinding().cl45.setVisibility(8);
        getBinding().constraintLayout.setVisibility(8);
        Bundle arguments = getArguments();
        if (Intrinsics.areEqual(arguments != null ? arguments.getString(LAYOUT_TAG) : null, "hbreservation_machine_54")) {
            getBinding().cl45.setVisibility(0);
        } else {
            Bundle arguments2 = getArguments();
            if (Intrinsics.areEqual(arguments2 != null ? arguments2.getString(LAYOUT_TAG) : null, "hbhy54")) {
                getBinding().cl45.setVisibility(0);
            } else {
                getBinding().constraintLayout.setVisibility(0);
            }
        }
        initView();
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.UniversityReservationFragment$initView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UniversityReservationFragment.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/yd/android_brand_mvp/landscape/university/UniversityReservationFragment$initView$1", "Ljava/util/TimerTask;", "run", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class C05321 extends TimerTask {
        C05321() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            FragmentActivity activity = UniversityReservationFragment.this.getActivity();
            if (activity != null) {
                final UniversityReservationFragment universityReservationFragment = UniversityReservationFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityReservationFragment$initView$1$UG3an_HmvWWe4vmhQOmtVpuU8Uw
                    @Override // java.lang.Runnable
                    public final void run() {
                        UniversityReservationFragment.C05321.run$lambda$0(universityReservationFragment);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(UniversityReservationFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setTable();
        }
    }

    private final void initView() {
        new Timer().schedule(new C05321(), new Date(), WorkRequest.MIN_BACKOFF_MILLIS);
        final String week = TimeUtil.getWeek(System.currentTimeMillis());
        new Timer().schedule(new TimerTask() { // from class: com.yd.android_brand_mvp.landscape.university.UniversityReservationFragment.initView.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (Intrinsics.areEqual(week, TimeUtil.getWeek(System.currentTimeMillis()))) {
                    return;
                }
                this.getViewModel().getTodayReservationList(SpData.getSiteId());
            }
        }, new Date(), 20000L);
        getBinding().tvDescription.setMovementMethod(ScrollingMovementMethod.getInstance());
        getBinding().tvDescription1.setMovementMethod(ScrollingMovementMethod.getInstance());
        getBinding().constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityReservationFragment$kmDTC3oWU7ZOfFDxfetSJJ3Tc9k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UniversityReservationFragment.initView$lambda$0(this.f$0, view);
            }
        });
        initViewModel();
        getBinding().ivSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityReservationFragment$BaATNvtWjGal0Gazo7b3dg3OALc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UniversityReservationFragment.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().ivSign1.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityReservationFragment$oSjXsPjZDoBP0eIIJboZSZ2nsI4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UniversityReservationFragment.initView$lambda$2(this.f$0, view);
            }
        });
        getViewModel().getTodayReservationList(SpData.getSiteId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(UniversityReservationFragment this$0, View view) {
        String id;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReservationActivity.Companion companion = ReservationActivity.INSTANCE;
        Activity mActivity = this$0.mActivity;
        Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
        Activity activity = mActivity;
        ReservationRecordBean reservationRecordBean = this$0.timeReservation;
        if (reservationRecordBean == null || (id = reservationRecordBean.getId()) == null) {
            id = "-1";
        }
        boolean zStartsWith$default = StringsKt.startsWith$default(this$0.type, "sb", false, 2, (Object) null);
        ReservationRecordBean reservationRecordBean2 = this$0.timeReservation;
        companion.startGo(activity, id, zStartsWith$default, reservationRecordBean2 != null ? reservationRecordBean2.getSignIn() : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(UniversityReservationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.requireContext(), (Class<?>) CheackNomalActivity.class);
        intent.putExtra("type", BaseConstant.homeReservation44);
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(UniversityReservationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.requireContext(), (Class<?>) CheackNomalActivity.class);
        intent.putExtra("type", BaseConstant.homeReservation44);
        this$0.startActivity(intent);
    }

    private final void initViewModel() {
        LiveData<List<ReservationRecordBean>> reservationList = getViewModel().getReservationList();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        final Function1<List<? extends ReservationRecordBean>, Unit> function1 = new Function1<List<? extends ReservationRecordBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.university.UniversityReservationFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ReservationRecordBean> list) {
                invoke2((List<ReservationRecordBean>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ReservationRecordBean> list) {
                UniversityReservationFragment.this.setResult(list);
                SPUtils.getInstance().put(SpData.RESERVATION_LIST, GsonUtils.toJson(list));
                UniversityReservationFragment.this.setTable();
            }
        };
        reservationList.observe(fragmentActivityRequireActivity, new Observer() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityReservationFragment$vJhcJplgCH5aqITwthzeUhQC_JM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UniversityReservationFragment.initViewModel$lambda$3(function1, obj);
            }
        });
        LiveData<ReservationDetailBean> reservationDetail = getViewModel().getReservationDetail();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<ReservationDetailBean, Unit> function2 = new Function1<ReservationDetailBean, Unit>() { // from class: com.yd.android_brand_mvp.landscape.university.UniversityReservationFragment.initViewModel.2
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
                UniversityReservationFragment.this.signList.addAll(reservationDetailBean.getSignList());
            }
        };
        reservationDetail.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityReservationFragment$2gAIEgluXnbo_kR7i1lqvl5pANQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UniversityReservationFragment.initViewModel$lambda$4(function2, obj);
            }
        });
        LiveData<Result<Boolean>> signInResult = getViewModel().getSignInResult();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final AnonymousClass3 anonymousClass3 = new AnonymousClass3();
        signInResult.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityReservationFragment$f2ND1czfmhDClea7VSGPkPpIMPE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UniversityReservationFragment.initViewModel$lambda$5(anonymousClass3, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.UniversityReservationFragment$initViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: UniversityReservationFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lkotlin/Result;", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass3 extends Lambda implements Function1<Result<? extends Boolean>, Unit> {
        AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Boolean> result) {
            invoke2(result);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Result<? extends Boolean> result) {
            ToastUtil.showBottomView((Activity) UniversityReservationFragment.this.requireActivity(), "签到成功");
            GPIOUtils.INSTANCE.set_oem_gpio(GPIOUtils.INSTANCE.getGPIO_MODE_GRENN());
            GPIOUtils.INSTANCE.set_oem_gpio(GPIOUtils.INSTANCE.getGPIO_HIGH());
            new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityReservationFragment$initViewModel$3$wkv2zRV-4OUMBcSSiA5PWGLCGaM
                @Override // java.lang.Runnable
                public final void run() {
                    UniversityReservationFragment.AnonymousClass3.invoke$lambda$0();
                }
            }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0() {
            GPIOUtils.INSTANCE.set_oem_gpio(GPIOUtils.INSTANCE.getGPIO_MODE_GRENN_CLOSE());
            GPIOUtils.INSTANCE.set_oem_gpio(GPIOUtils.INSTANCE.getGPIO_LOW());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTable() {
        ReservationRecordBean reservationRecordBean;
        String str;
        String str2;
        String bookingTime;
        String id;
        String id2;
        List<ReservationRecordBean> list = this.result;
        if (list != null) {
            reservationRecordBean = null;
            for (ReservationRecordBean reservationRecordBean2 : list) {
                if (forRemindTime(reservationRecordBean2 != null ? reservationRecordBean2.getStartTimeStr() : null, reservationRecordBean2 != null ? reservationRecordBean2.getEndTimeStr() : null)) {
                    reservationRecordBean = reservationRecordBean2;
                }
            }
        } else {
            reservationRecordBean = null;
        }
        ReservationRecordBean reservationRecordBean3 = this.timeReservation;
        if (!Intrinsics.areEqual(reservationRecordBean3 != null ? reservationRecordBean3.getId() : null, reservationRecordBean != null ? reservationRecordBean.getId() : null)) {
            if (reservationRecordBean != null && (id2 = reservationRecordBean.getId()) != null) {
                getViewModel().requestActivityCycle(id2);
            }
            UniversityViewModel viewModel = getViewModel();
            if (reservationRecordBean == null || (id = reservationRecordBean.getId()) == null) {
                id = "";
            }
            viewModel.getReservationDetail(id);
        }
        if (reservationRecordBean != null) {
            this.timeReservation = reservationRecordBean;
            getBinding().tvTitle.setVisibility(0);
            getBinding().group.setVisibility(8);
            TextView textView = getBinding().tvTitle;
            StringBuilder sb = new StringBuilder();
            sb.append("正在进行的");
            ReservationRecordBean reservationRecordBean4 = this.timeReservation;
            sb.append(reservationRecordBean4 != null ? reservationRecordBean4.getSiteBookingTypeName() : null);
            textView.setText(sb.toString());
            TextView textView2 = getBinding().tvTableName;
            ReservationRecordBean reservationRecordBean5 = this.timeReservation;
            textView2.setText(reservationRecordBean5 != null ? reservationRecordBean5.getName() : null);
            ReservationRecordBean reservationRecordBean6 = this.timeReservation;
            List<String> listSplit = (reservationRecordBean6 == null || (bookingTime = reservationRecordBean6.getBookingTime()) == null) ? null : new Regex("\\s+").split(bookingTime, 0);
            getBinding().tvTableTime.setText((listSplit == null || (str2 = listSplit.get(1)) == null) ? "" : str2);
            TextView textView3 = getBinding().tvDescription;
            ReservationRecordBean reservationRecordBean7 = this.timeReservation;
            textView3.setText(reservationRecordBean7 != null ? reservationRecordBean7.getDescribe() : null);
            ImageView imageView = getBinding().imageView4;
            TransUtils transUtils = TransUtils.INSTANCE;
            ReservationRecordBean reservationRecordBean8 = this.timeReservation;
            imageView.setImageDrawable(SimpleUtilsKt.asDrawable(transUtils.transSiteBookingTypeCodeToBackground(reservationRecordBean8 != null ? reservationRecordBean8.getSiteBookingTypeCode() : 0)));
            ReservationRecordBean reservationRecordBean9 = this.timeReservation;
            Intrinsics.checkNotNull(reservationRecordBean9);
            if (reservationRecordBean9.getSignIn()) {
                ImageView imageView2 = getBinding().ivSign;
                Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivSign");
                SimpleUtilsKt.show(imageView2);
                ImageView imageView3 = getBinding().ivSign1;
                Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ivSign1");
                SimpleUtilsKt.show(imageView3);
            } else {
                ImageView imageView4 = getBinding().ivSign;
                Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ivSign");
                SimpleUtilsKt.remove(imageView4);
                ImageView imageView5 = getBinding().ivSign1;
                Intrinsics.checkNotNullExpressionValue(imageView5, "binding.ivSign1");
                SimpleUtilsKt.remove(imageView5);
            }
            getBinding().tvTitle1.setVisibility(0);
            getBinding().tvTitle1.setVisibility(0);
            getBinding().group1.setVisibility(8);
            getBinding().group.setVisibility(8);
            TextView textView4 = getBinding().tvTitle1;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("正在进行的");
            ReservationRecordBean reservationRecordBean10 = this.timeReservation;
            sb2.append(reservationRecordBean10 != null ? reservationRecordBean10.getSiteBookingTypeName() : null);
            textView4.setText(sb2.toString());
            TextView textView5 = getBinding().tvTableName1;
            ReservationRecordBean reservationRecordBean11 = this.timeReservation;
            textView5.setText(reservationRecordBean11 != null ? reservationRecordBean11.getName() : null);
            getBinding().tvTableTime1.setText((listSplit == null || (str = listSplit.get(1)) == null) ? "" : str);
            TextView textView6 = getBinding().tvDescription1;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("预约人：");
            ReservationRecordBean reservationRecordBean12 = this.timeReservation;
            sb3.append(reservationRecordBean12 != null ? reservationRecordBean12.getSponsorName() : null);
            textView6.setText(sb3.toString());
            this.signList.clear();
            return;
        }
        getBinding().ivSign.setVisibility(8);
        getBinding().ivSign1.setVisibility(8);
        getBinding().group.setVisibility(8);
        getBinding().group1.setVisibility(0);
        getBinding().tvTitle1.setVisibility(4);
        getBinding().tvTitle.setText("");
        getBinding().tvTableName.setText("暂无预约");
        getBinding().tvTableTime.setText("");
        getBinding().tvTitle1.setText("");
        getBinding().tvTableName1.setText("暂无预约");
        getBinding().tvTableTime1.setText("");
        getBinding().tvDescription1.setText("");
        getBinding().tvDescription.setText("");
    }

    private final boolean forRemindTime(String starTime, String endTime) {
        long j = TimeUtil.gettime(starTime);
        long j2 = TimeUtil.gettime(endTime);
        long j3 = TimeUtil.gettime(TimeUtil.stampToDate8(System.currentTimeMillis()));
        return j <= j3 && j3 < j2;
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (MinaConstants.CODE_RESERVE == id) {
            getViewModel().getTodayReservationList(SpData.getSiteId());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(EventBean eventBean) {
        ReservationRecordBean reservationRecordBean;
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        if (eventBean.type == BaseConstant.homeReservation44 && (reservationRecordBean = this.timeReservation) != null) {
            UniversityViewModel viewModel = getViewModel();
            String str = eventBean.id;
            Intrinsics.checkNotNullExpressionValue(str, "eventBean.id");
            viewModel.signInRecord(str, reservationRecordBean.getId());
        }
    }

    /* JADX INFO: compiled from: UniversityReservationFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/UniversityReservationFragment$Companion;", "", "()V", "LAYOUT_TAG", "", "getLAYOUT_TAG", "()Ljava/lang/String;", "newInstance", "Lcom/yd/android_brand_mvp/landscape/university/UniversityReservationFragment;", "layoutTag", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getLAYOUT_TAG() {
            return UniversityReservationFragment.LAYOUT_TAG;
        }

        @JvmStatic
        public final UniversityReservationFragment newInstance(String layoutTag) {
            Intrinsics.checkNotNullParameter(layoutTag, "layoutTag");
            UniversityReservationFragment universityReservationFragment = new UniversityReservationFragment();
            Bundle bundle = new Bundle();
            bundle.putString(UniversityReservationFragment.INSTANCE.getLAYOUT_TAG(), layoutTag);
            universityReservationFragment.setArguments(bundle);
            return universityReservationFragment;
        }
    }
}
