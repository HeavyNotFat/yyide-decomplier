package com.yd.android_brand_mvp.landscape.consult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.blankj.utilcode.util.ScreenUtils;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.consult.ConsultDetailsHeadAdapter;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentConsultDetailsBinding;
import com.yd.android_brand_mvp.dialog.ConsultDetailsDialog;
import com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.reservation.ReservationDetailBean;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
import com.yd.android_brand_mvp.model.reservation.ReservationSignListItemBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.Tool;
import com.yd.android_brand_mvp.verfity.CheackNomalActivity;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;
import java.util.ArrayList;
import java.util.Arrays;
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
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: ConsultSignDetailsFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J(\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001f0\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u001f2\u0006\u0010!\u001a\u00020\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/consult/ConsultSignDetailsFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentConsultDetailsBinding;", "()V", "bannerAdapter", "Lcom/yd/android_brand_mvp/adapter/consult/ConsultDetailsHeadAdapter;", "data", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "getData", "()Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "data$delegate", "Lkotlin/Lazy;", "signList", "", "Lcom/yd/android_brand_mvp/model/reservation/ReservationSignListItemBean;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/reserve/viemodel/HomeReservationViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/reserve/viemodel/HomeReservationViewModel;", "viewModel$delegate", "initView", "", "initViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEvent", "eventBean", "Lcom/yd/android_brand_mvp/model/EventBean;", "splitList", "", TUIKitConstants.Selection.LIST, "groupSize", "", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConsultSignDetailsFragment extends KTBaseFragment<FragmentConsultDetailsBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ConsultDetailsHeadAdapter bannerAdapter;

    /* JADX INFO: renamed from: data$delegate, reason: from kotlin metadata */
    private final Lazy data;
    private final List<ReservationSignListItemBean> signList;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.consult.ConsultSignDetailsFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConsultSignDetailsFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentConsultDetailsBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentConsultDetailsBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentConsultDetailsBinding;", 0);
        }

        public final FragmentConsultDetailsBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentConsultDetailsBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentConsultDetailsBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public ConsultSignDetailsFragment() {
        super(AnonymousClass1.INSTANCE);
        final ConsultSignDetailsFragment consultSignDetailsFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultSignDetailsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return consultSignDetailsFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultSignDetailsFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(consultSignDetailsFragment, Reflection.getOrCreateKotlinClass(HomeReservationViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultSignDetailsFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultSignDetailsFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultSignDetailsFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = consultSignDetailsFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.data = LazyKt.lazy(new Function0<ReservationRecordBean>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultSignDetailsFragment$data$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ReservationRecordBean invoke() {
                return (ReservationRecordBean) this.this$0.mActivity.getIntent().getParcelableExtra("data");
            }
        });
        this.signList = new ArrayList();
        this.bannerAdapter = new ConsultDetailsHeadAdapter();
    }

    public static final /* synthetic */ FragmentConsultDetailsBinding access$getBinding(ConsultSignDetailsFragment consultSignDetailsFragment) {
        return consultSignDetailsFragment.getBinding();
    }

    /* JADX INFO: compiled from: ConsultSignDetailsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/consult/ConsultSignDetailsFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/consult/ConsultSignDetailsFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConsultSignDetailsFragment newInstance() {
            ConsultSignDetailsFragment consultSignDetailsFragment = new ConsultSignDetailsFragment();
            consultSignDetailsFragment.setArguments(new Bundle());
            return consultSignDetailsFragment;
        }
    }

    private final HomeReservationViewModel getViewModel() {
        return (HomeReservationViewModel) this.viewModel.getValue();
    }

    private final ReservationRecordBean getData() {
        return (ReservationRecordBean) this.data.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);
        initView();
    }

    private final void initView() {
        Banner startPosition;
        Banner adapter;
        Banner bannerIsAutoLoop;
        Banner loopTime;
        Banner indicator;
        Banner indicatorGravity;
        Banner indicatorSpace;
        Banner indicatorNormalColor;
        Banner indicatorSelectedColor;
        TextView textView = getBinding().btnConsultSign;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.btnConsultSign");
        SimpleUtilsKt.remove(textView);
        getBinding().btnConsultSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.consult.-$$Lambda$ConsultSignDetailsFragment$XSkOv1xDQrVy2QdfH5aFU_3QBNo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConsultSignDetailsFragment.initView$lambda$0(this.f$0, view);
            }
        });
        Banner bannerAddBannerLifecycleObserver = getBinding().bannerDetails.addBannerLifecycleObserver(this);
        if (bannerAddBannerLifecycleObserver != null && (startPosition = bannerAddBannerLifecycleObserver.setStartPosition(1)) != null && (adapter = startPosition.setAdapter(this.bannerAdapter)) != null && (bannerIsAutoLoop = adapter.isAutoLoop(false)) != null && (loopTime = bannerIsAutoLoop.setLoopTime(5000L)) != null && (indicator = loopTime.setIndicator(new CircleIndicator(requireContext()))) != null && (indicatorGravity = indicator.setIndicatorGravity(1)) != null && (indicatorSpace = indicatorGravity.setIndicatorSpace(BannerUtils.dp2px(10.0f))) != null && (indicatorNormalColor = indicatorSpace.setIndicatorNormalColor(SimpleUtilsKt.asColor(R.color.gray))) != null && (indicatorSelectedColor = indicatorNormalColor.setIndicatorSelectedColor(SimpleUtilsKt.asColor(R.color.blue3))) != null) {
            indicatorSelectedColor.setIndicatorWidth(BannerUtils.dp2px(10.0f), BannerUtils.dp2px(10.0f));
        }
        this.bannerAdapter.setOnItemClickCallback(new ConsultDetailsHeadAdapter.OnItemClickCallback() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultSignDetailsFragment.initView.2
            @Override // com.yd.android_brand_mvp.adapter.consult.ConsultDetailsHeadAdapter.OnItemClickCallback
            public void itemClick(String userId) {
                Intrinsics.checkNotNullParameter(userId, "userId");
                new ConsultDetailsDialog(userId).show(ConsultSignDetailsFragment.this.getParentFragmentManager(), "ConsultListHeadDialog");
            }
        });
        initViewModel();
        ReservationRecordBean data = getData();
        if (data != null) {
            getViewModel().getReservationDetail(data.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(ConsultSignDetailsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.requireContext(), (Class<?>) CheackNomalActivity.class);
        intent.putExtra("type", BaseConstant.homeReservation);
        this$0.startActivity(intent);
    }

    private final void initViewModel() {
        LiveData<ReservationDetailBean> reservationDetail = getViewModel().getReservationDetail();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<ReservationDetailBean, Unit> function1 = new Function1<ReservationDetailBean, Unit>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultSignDetailsFragment.initViewModel.1
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
                if (reservationDetailBean.getSignIn()) {
                    TextView textView = ConsultSignDetailsFragment.access$getBinding(ConsultSignDetailsFragment.this).btnConsultSign;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.btnConsultSign");
                    SimpleUtilsKt.show(textView);
                } else {
                    TextView textView2 = ConsultSignDetailsFragment.access$getBinding(ConsultSignDetailsFragment.this).btnConsultSign;
                    Intrinsics.checkNotNullExpressionValue(textView2, "binding.btnConsultSign");
                    SimpleUtilsKt.remove(textView2);
                }
                ConsultSignDetailsFragment.access$getBinding(ConsultSignDetailsFragment.this).tvConsultTitle.setText(reservationDetailBean.getName());
                String time = TimeUtil.formatTime(reservationDetailBean.getStartTimeStr(), TimeUtil.notSecondFormat, TimeUtil.dateYMDFormat2);
                String week = TimeUtil.getWeek(TimeUtil.gettime(reservationDetailBean.getStartTimeStr(), TimeUtil.notSecondFormat));
                TextView textView3 = ConsultSignDetailsFragment.access$getBinding(ConsultSignDetailsFragment.this).tvConsultDate;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("%s %s", Arrays.copyOf(new Object[]{time, week}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                textView3.setText(str);
                ConsultSignDetailsFragment.this.signList.addAll(reservationDetailBean.getSignList());
                String startTime = TimeUtil.formatTime(reservationDetailBean.getStartTimeStr(), TimeUtil.notSecondFormat, TimeUtil.hoursMinuteTimeFormat);
                if (!TextUtils.isEmpty(startTime) && startTime.length() > 4) {
                    TextView textView4 = ConsultSignDetailsFragment.access$getBinding(ConsultSignDetailsFragment.this).tvStartHours1;
                    Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
                    String strSubstring = startTime.substring(0, 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    textView4.setText(strSubstring);
                    TextView textView5 = ConsultSignDetailsFragment.access$getBinding(ConsultSignDetailsFragment.this).tvStartHours2;
                    String strSubstring2 = startTime.substring(1, 2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    textView5.setText(strSubstring2);
                    TextView textView6 = ConsultSignDetailsFragment.access$getBinding(ConsultSignDetailsFragment.this).tvStartMinutes1;
                    String strSubstring3 = startTime.substring(3, 4);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    textView6.setText(strSubstring3);
                    TextView textView7 = ConsultSignDetailsFragment.access$getBinding(ConsultSignDetailsFragment.this).tvStartMinutes2;
                    String strSubstring4 = startTime.substring(4, 5);
                    Intrinsics.checkNotNullExpressionValue(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
                    textView7.setText(strSubstring4);
                }
                String endTime = TimeUtil.formatTime(reservationDetailBean.getEndTimeStr(), TimeUtil.notSecondFormat, TimeUtil.hoursMinuteTimeFormat);
                if (!TextUtils.isEmpty(endTime) && endTime.length() > 4) {
                    TextView textView8 = ConsultSignDetailsFragment.access$getBinding(ConsultSignDetailsFragment.this).tvEndHours1;
                    Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
                    String strSubstring5 = endTime.substring(0, 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring5, "this as java.lang.String…ing(startIndex, endIndex)");
                    textView8.setText(strSubstring5);
                    TextView textView9 = ConsultSignDetailsFragment.access$getBinding(ConsultSignDetailsFragment.this).tvEndHours2;
                    String strSubstring6 = endTime.substring(1, 2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring6, "this as java.lang.String…ing(startIndex, endIndex)");
                    textView9.setText(strSubstring6);
                    TextView textView10 = ConsultSignDetailsFragment.access$getBinding(ConsultSignDetailsFragment.this).tvEndMinutes1;
                    String strSubstring7 = endTime.substring(3, 4);
                    Intrinsics.checkNotNullExpressionValue(strSubstring7, "this as java.lang.String…ing(startIndex, endIndex)");
                    textView10.setText(strSubstring7);
                    TextView textView11 = ConsultSignDetailsFragment.access$getBinding(ConsultSignDetailsFragment.this).tvEndMinutes2;
                    String strSubstring8 = endTime.substring(4, 5);
                    Intrinsics.checkNotNullExpressionValue(strSubstring8, "this as java.lang.String…ing(startIndex, endIndex)");
                    textView11.setText(strSubstring8);
                }
                if (ScreenUtils.isLandscape()) {
                    ConsultSignDetailsFragment.access$getBinding(ConsultSignDetailsFragment.this).bannerDetails.setDatas(ConsultSignDetailsFragment.this.splitList(reservationDetailBean.getSignList(), 10));
                } else {
                    ConsultSignDetailsFragment.access$getBinding(ConsultSignDetailsFragment.this).bannerDetails.setDatas(ConsultSignDetailsFragment.this.splitList(reservationDetailBean.getSignList(), 5));
                }
            }
        };
        reservationDetail.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.consult.-$$Lambda$ConsultSignDetailsFragment$1KJCLVy2JzH8HxUoKPs9raWaahI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ConsultSignDetailsFragment.initViewModel$lambda$2(function1, obj);
            }
        });
        LiveData<Result<Boolean>> signInResult = getViewModel().getSignInResult();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends Boolean>, Unit> function2 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultSignDetailsFragment.initViewModel.2
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
                ToastUtil.showBottomView((Activity) ConsultSignDetailsFragment.this.requireActivity(), "签到成功");
            }
        };
        signInResult.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.consult.-$$Lambda$ConsultSignDetailsFragment$l51FSx0F18rW54QpL5SJRgVWBSI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ConsultSignDetailsFragment.initViewModel$lambda$3(function2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public final List<List<ReservationSignListItemBean>> splitList(List<ReservationSignListItemBean> list, int groupSize) {
        Intrinsics.checkNotNullParameter(list, "list");
        int size = list.size();
        int i = ((size + groupSize) - 1) / groupSize;
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 * groupSize;
            i2++;
            arrayList.add(list.subList(i3, RangesKt.coerceAtMost(i2 * groupSize, size)));
        }
        return arrayList;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(EventBean eventBean) {
        String id;
        Object next;
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        if (eventBean.type != BaseConstant.homeReservation) {
            return;
        }
        if (!Tool.isNetworkAvailable(requireContext())) {
            ToastUtil.showBottomView(requireContext(), getString(R.string.network_is_unavailable));
            if (this.signList.isEmpty()) {
                return;
            }
            Iterator<T> it2 = this.signList.iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
            } while (!Intrinsics.areEqual(((ReservationSignListItemBean) next).getUserId(), eventBean.id));
            if (((ReservationSignListItemBean) next) == null) {
                ToastUtil.showBottomView(requireContext(), "不在名单内");
                return;
            }
        }
        HomeReservationViewModel viewModel = getViewModel();
        String str = eventBean.id;
        Intrinsics.checkNotNullExpressionValue(str, "eventBean.id");
        ReservationRecordBean data = getData();
        if (data == null || (id = data.getId()) == null) {
            id = "";
        }
        viewModel.signInRecord(str, id);
    }
}
