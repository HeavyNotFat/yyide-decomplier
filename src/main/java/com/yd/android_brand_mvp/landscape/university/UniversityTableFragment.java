package com.yd.android_brand_mvp.landscape.university;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.KBActivity;
import com.yd.android_brand_mvp.activity.SiteKBActivity;
import com.yd.android_brand_mvp.adapter.attence.CheckAttendanceActivity;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.FragmentTableBinding;
import com.yd.android_brand_mvp.landscape.university.adapter.UniversityHeadAdapter;
import com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityViewModel;
import com.yd.android_brand_mvp.model.AttenceNewListBean;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.TableDataBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;
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
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: UniversityTableFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u001a\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!J\u001a\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u001bH\u0002J(\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0*2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010-\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006/"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/UniversityTableFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentTableBinding;", "()V", "KBType", "", "getKBType", "()I", "setKBType", "(I)V", "isHaveClass", "", "mUniversityHeadAdapter", "Lcom/yd/android_brand_mvp/landscape/university/adapter/UniversityHeadAdapter;", "timetable", "Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO$TimetableListDTO;", "getTimetable", "()Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO$TimetableListDTO;", "setTimetable", "(Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO$TimetableListDTO;)V", "viewModel", "Lcom/yd/android_brand_mvp/landscape/university/viewmodel/UniversityViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/university/viewmodel/UniversityViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "UpdataEvent", "", "id", "initView", "initViewModel", "isTable", "startTime", "", "endTime", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setTable", "splitList", "", "Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO$TimetableListDTO$TeacherListDTO;", TUIKitConstants.Selection.LIST, "groupSize", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UniversityTableFragment extends KTBaseFragment<FragmentTableBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LAYOUT_TAG = "layoutTag";
    private int KBType;
    private boolean isHaveClass;
    private UniversityHeadAdapter mUniversityHeadAdapter;
    private KBRsp2.DataDTO.TimetableListDTO timetable;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @JvmStatic
    public static final UniversityTableFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.UniversityTableFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: UniversityTableFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentTableBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentTableBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentTableBinding;", 0);
        }

        public final FragmentTableBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentTableBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentTableBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public UniversityTableFragment() {
        super(AnonymousClass1.INSTANCE);
        final UniversityTableFragment universityTableFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.university.UniversityTableFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return universityTableFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.university.UniversityTableFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(universityTableFragment, Reflection.getOrCreateKotlinClass(UniversityViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.university.UniversityTableFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.university.UniversityTableFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.university.UniversityTableFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = universityTableFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.KBType = 1;
    }

    public static final /* synthetic */ FragmentTableBinding access$getBinding(UniversityTableFragment universityTableFragment) {
        return universityTableFragment.getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UniversityViewModel getViewModel() {
        return (UniversityViewModel) this.viewModel.getValue();
    }

    public final KBRsp2.DataDTO.TimetableListDTO getTimetable() {
        return this.timetable;
    }

    public final void setTimetable(KBRsp2.DataDTO.TimetableListDTO timetableListDTO) {
        this.timetable = timetableListDTO;
    }

    public final int getKBType() {
        return this.KBType;
    }

    public final void setKBType(int i) {
        this.KBType = i;
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.UniversityTableFragment$initView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UniversityTableFragment.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/yd/android_brand_mvp/landscape/university/UniversityTableFragment$initView$1", "Ljava/util/TimerTask;", "run", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class C05351 extends TimerTask {
        C05351() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            FragmentActivity activity = UniversityTableFragment.this.getActivity();
            if (activity != null) {
                final UniversityTableFragment universityTableFragment = UniversityTableFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityTableFragment$initView$1$nSjhH7bgvbiC6Af54tixGaZ6YgM
                    @Override // java.lang.Runnable
                    public final void run() {
                        UniversityTableFragment.C05351.run$lambda$0(universityTableFragment);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(UniversityTableFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setTable();
        }
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
        Banner indicatorWidth;
        new Timer().schedule(new C05351(), new Date(), 20000L);
        getBinding().constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityTableFragment$21d-DuvOlWBpYJvO7pNONCYBSxM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UniversityTableFragment.initView$lambda$0(this.f$0, view);
            }
        });
        initViewModel();
        getBinding().ivSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityTableFragment$aLpP7kydbBAQVR4jrxiPQhriTMY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UniversityTableFragment.initView$lambda$1(this.f$0, view);
            }
        });
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        this.mUniversityHeadAdapter = new UniversityHeadAdapter(contextRequireContext, null, false);
        Banner bannerAddBannerLifecycleObserver = getBinding().bannerHead.addBannerLifecycleObserver(this);
        if (bannerAddBannerLifecycleObserver != null && (startPosition = bannerAddBannerLifecycleObserver.setStartPosition(1)) != null && (adapter = startPosition.setAdapter(this.mUniversityHeadAdapter)) != null && (bannerIsAutoLoop = adapter.isAutoLoop(true)) != null && (loopTime = bannerIsAutoLoop.setLoopTime(WorkRequest.MIN_BACKOFF_MILLIS)) != null && (indicator = loopTime.setIndicator(new CircleIndicator(requireContext()))) != null && (indicatorGravity = indicator.setIndicatorGravity(1)) != null && (indicatorSpace = indicatorGravity.setIndicatorSpace(BannerUtils.dp2px(10.0f))) != null && (indicatorNormalColor = indicatorSpace.setIndicatorNormalColor(SimpleUtilsKt.asColor(R.color.color_CCDFFF))) != null && (indicatorSelectedColor = indicatorNormalColor.setIndicatorSelectedColor(SimpleUtilsKt.asColor(R.color.blue7))) != null && (indicatorWidth = indicatorSelectedColor.setIndicatorWidth(BannerUtils.dp2px(10.0f), BannerUtils.dp2px(10.0f))) != null) {
            indicatorWidth.setIndicatorHeight(BannerUtils.dp2px(10.0f));
        }
        getBinding().cardView2.setVisibility(8);
        getBinding().ivSign.setVisibility(8);
        getBinding().group.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(UniversityTableFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.KBType == 2) {
            this$0.goPermissionsActivity(KBActivity.class);
        } else {
            this$0.goPermissionsActivity(SiteKBActivity.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(UniversityTableFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.mActivity, (Class<?>) CheckAttendanceActivity.class));
    }

    private final void initViewModel() {
        final Function1<Result<? extends List<AttenceNewListBean.DataDTO>>, Unit> function1 = new Function1<Result<? extends List<AttenceNewListBean.DataDTO>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.university.UniversityTableFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<AttenceNewListBean.DataDTO>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<AttenceNewListBean.DataDTO>> it2) {
                AttenceNewListBean.DataDTO dataDTO;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    if (value != null) {
                        Object value2 = it2.getValue();
                        if (Result.m597isFailureimpl(value2)) {
                            value2 = null;
                        }
                        List list = (List) value2;
                        Integer numValueOf = list != null ? Integer.valueOf(list.size()) : null;
                        Intrinsics.checkNotNull(numValueOf);
                        if (numValueOf.intValue() > 0) {
                            Object value3 = it2.getValue();
                            if (Result.m597isFailureimpl(value3)) {
                                value3 = null;
                            }
                            List<AttenceNewListBean.DataDTO> list2 = (List) value3;
                            if (list2 != null) {
                                dataDTO = null;
                                for (AttenceNewListBean.DataDTO dataDTO2 : list2) {
                                    if (dataDTO2.type == 3) {
                                        dataDTO = dataDTO2;
                                    }
                                }
                            } else {
                                dataDTO = null;
                            }
                            if (dataDTO != null && dataDTO.type == 3) {
                                int i = dataDTO != null ? dataDTO.total : 0;
                                int i2 = dataDTO != null ? dataDTO.normalNum : 0;
                                int i3 = dataDTO != null ? dataDTO.beLateNum : 0;
                                int i4 = dataDTO != null ? dataDTO.absenteeismNum : 0;
                                float f = i;
                                float f2 = 100;
                                int i5 = (int) (((i3 + i2) / f) * f2);
                                int i6 = (int) ((i4 / f) * f2);
                                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).group.setVisibility(8);
                                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).cardView2.setVisibility(0);
                                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).ivSign.setVisibility(0);
                                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).tvSignNumber.setText(String.valueOf(i2 + i3));
                                TextView textView = UniversityTableFragment.access$getBinding(UniversityTableFragment.this).tvSignTotal;
                                UniversityTableFragment universityTableFragment = UniversityTableFragment.this;
                                Object[] objArr = new Object[1];
                                objArr[0] = String.valueOf(dataDTO != null ? Integer.valueOf(dataDTO.total) : null);
                                textView.setText(universityTableFragment.getString(R.string.right_string, objArr));
                                TextView textView2 = UniversityTableFragment.access$getBinding(UniversityTableFragment.this).tvAbsenceTotal;
                                UniversityTableFragment universityTableFragment2 = UniversityTableFragment.this;
                                Object[] objArr2 = new Object[1];
                                objArr2[0] = String.valueOf(dataDTO != null ? Integer.valueOf(dataDTO.total) : null);
                                textView2.setText(universityTableFragment2.getString(R.string.right_string, objArr2));
                                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).tvAbsenceNumber.setText(String.valueOf(i4));
                                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).progressBar.setProgress(i5);
                                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).absenceProgressBar.setProgress(i6);
                                return;
                            }
                            UniversityTableFragment.access$getBinding(UniversityTableFragment.this).group.setVisibility(0);
                            UniversityTableFragment.access$getBinding(UniversityTableFragment.this).cardView2.setVisibility(8);
                            UniversityTableFragment.access$getBinding(UniversityTableFragment.this).ivSign.setVisibility(8);
                            return;
                        }
                    }
                }
                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).group.setVisibility(0);
                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).cardView2.setVisibility(8);
                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).ivSign.setVisibility(8);
                Result.m594exceptionOrNullimpl(it2.getValue());
            }
        };
        getViewModel().getAttendanceResultList().observe(this, new Observer() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityTableFragment$ty90jdpjybfrLBjBuc6aVFRO9Pw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UniversityTableFragment.initViewModel$lambda$2(function1, obj);
            }
        });
        LiveData<TableDataBean> kbRspData = getViewModel().getKbRspData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<TableDataBean, Unit> function2 = new Function1<TableDataBean, Unit>() { // from class: com.yd.android_brand_mvp.landscape.university.UniversityTableFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TableDataBean tableDataBean) {
                invoke2(tableDataBean);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TableDataBean tableDataBean) {
                KBRsp2.DataDTO.TimetableListDTO timetableListDTO;
                List<KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO> list;
                String str;
                KBRsp2.DataDTO dataDTO;
                KBRsp2.DataDTO dataDTO2;
                List<KBRsp2.DataDTO.TimetableListDTO> list2;
                int intWeekDay = TimeUtil.getIntWeekDay(System.currentTimeMillis());
                UniversityTableFragment.this.setKBType(tableDataBean.getType());
                KBRsp2 data = tableDataBean.getData();
                if (data == null || (dataDTO2 = data.data) == null || (list2 = dataDTO2.timetableList) == null) {
                    timetableListDTO = null;
                } else {
                    UniversityTableFragment universityTableFragment = UniversityTableFragment.this;
                    timetableListDTO = null;
                    for (KBRsp2.DataDTO.TimetableListDTO timetableListDTO2 : list2) {
                        if (Intrinsics.areEqual(timetableListDTO2.date, TimeUtil.getCurrentyyyyMMdd()) && timetableListDTO2.week == intWeekDay && TimeUtil.forRemindTime(timetableListDTO2.startTime, timetableListDTO2.endTime)) {
                            universityTableFragment.isHaveClass = true;
                            timetableListDTO = timetableListDTO2;
                        }
                    }
                }
                if (timetableListDTO == null) {
                    if (((data == null || (dataDTO = data.data) == null) ? null : dataDTO.timetableList) != null) {
                        KBRsp2.DataDTO dataDTO3 = data.data;
                        List<KBRsp2.DataDTO.TimetableListDTO> list3 = dataDTO3 != null ? dataDTO3.timetableList : null;
                        Intrinsics.checkNotNull(list3);
                        for (KBRsp2.DataDTO.TimetableListDTO timetableListDTO3 : list3) {
                            if (Intrinsics.areEqual(timetableListDTO3.date, TimeUtil.getCurrentyyyyMMdd()) && timetableListDTO3.week == intWeekDay && UniversityTableFragment.this.isTable(timetableListDTO3.startTime, timetableListDTO3.endTime)) {
                                UniversityTableFragment.this.isHaveClass = false;
                                timetableListDTO = timetableListDTO3;
                                break;
                            }
                        }
                    }
                }
                KBRsp2.DataDTO.TimetableListDTO timetable = UniversityTableFragment.this.getTimetable();
                if (!Intrinsics.areEqual(timetable != null ? timetable.id : null, timetableListDTO != null ? timetableListDTO.id : null) && timetableListDTO != null && (str = timetableListDTO.id) != null) {
                    UniversityTableFragment.this.getViewModel().requestActivityCycle(str);
                }
                if (timetableListDTO != null) {
                    UniversityTableFragment.this.setTimetable(timetableListDTO);
                    Log.i("UniversityTableFragment", "正在上课：" + GsonUtils.toJson(timetableListDTO));
                    KBRsp2.DataDTO.TimetableListDTO timetable2 = UniversityTableFragment.this.getTimetable();
                    if (timetable2 != null && (list = timetable2.teacherList) != null) {
                        UniversityTableFragment universityTableFragment2 = UniversityTableFragment.this;
                        UniversityTableFragment.access$getBinding(universityTableFragment2).groupHead.setVisibility(list.size() > 0 ? 0 : 4);
                        UniversityTableFragment.access$getBinding(universityTableFragment2).groupHead.setVisibility(4);
                        UniversityTableFragment.access$getBinding(universityTableFragment2).bannerHead.setVisibility(0);
                        UniversityTableFragment.access$getBinding(universityTableFragment2).bannerHead.setDatas(universityTableFragment2.splitList(list, 3));
                    }
                    if (UniversityTableFragment.this.isHaveClass) {
                        UniversityTableFragment.access$getBinding(UniversityTableFragment.this).textView2.setText("正在上课");
                    } else {
                        UniversityTableFragment.access$getBinding(UniversityTableFragment.this).textView2.setText("即将上课");
                    }
                    UniversityTableFragment.access$getBinding(UniversityTableFragment.this).textView2.setVisibility(0);
                    TextView textView = UniversityTableFragment.access$getBinding(UniversityTableFragment.this).tvTableName;
                    KBRsp2.DataDTO.TimetableListDTO timetable3 = UniversityTableFragment.this.getTimetable();
                    textView.setText(timetable3 != null ? timetable3.subjectName : null);
                    TextView textView2 = UniversityTableFragment.access$getBinding(UniversityTableFragment.this).tvTableTime;
                    UniversityTableFragment universityTableFragment3 = UniversityTableFragment.this;
                    Object[] objArr = new Object[2];
                    KBRsp2.DataDTO.TimetableListDTO timetable4 = universityTableFragment3.getTimetable();
                    objArr[0] = timetable4 != null ? timetable4.startTime : null;
                    KBRsp2.DataDTO.TimetableListDTO timetable5 = UniversityTableFragment.this.getTimetable();
                    objArr[1] = timetable5 != null ? timetable5.endTime : null;
                    textView2.setText(universityTableFragment3.getString(R.string.left_right, objArr));
                    return;
                }
                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).bannerHead.setDatas(null);
                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).bannerHead.setVisibility(8);
                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).cardView2.setVisibility(8);
                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).ivSign.setVisibility(8);
                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).textView2.setVisibility(4);
                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).group.setVisibility(0);
                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).tvTableName.setText("暂无课程");
                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).tvTableTime.setText("");
                UniversityTableFragment.access$getBinding(UniversityTableFragment.this).tvName.setText("暂无老师");
            }
        };
        kbRspData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityTableFragment$AYCon8DxvRtOJnI4IZgmeiZbocg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UniversityTableFragment.initViewModel$lambda$3(function2, obj);
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

    public final boolean isTable(String startTime, String endTime) {
        long j = TimeUtil.gettime99(startTime);
        TimeUtil.gettime99(endTime);
        return j >= TimeUtil.gettime99(TimeUtil.stampToDate2(System.currentTimeMillis()));
    }

    public final List<List<KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO>> splitList(List<KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO> list, int groupSize) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTable() {
        getViewModel().getKbData();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        KBRsp2.DataDTO.TimetableListDTO timetableListDTO;
        super.UpdataEvent(id);
        if (id == MinaConstants.TABLE_CODE) {
            setTable();
            return;
        }
        if (id != MinaConstants.CODE_UPDATA_ATTENCE_LIST || (timetableListDTO = this.timetable) == null) {
            return;
        }
        UniversityViewModel viewModel = getViewModel();
        String str = timetableListDTO.id;
        Intrinsics.checkNotNullExpressionValue(str, "it.id");
        viewModel.requestActivityCycle(str);
    }

    /* JADX INFO: compiled from: UniversityTableFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/UniversityTableFragment$Companion;", "", "()V", "LAYOUT_TAG", "", "getLAYOUT_TAG", "()Ljava/lang/String;", "newInstance", "Lcom/yd/android_brand_mvp/landscape/university/UniversityTableFragment;", "layoutTag", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getLAYOUT_TAG() {
            return UniversityTableFragment.LAYOUT_TAG;
        }

        @JvmStatic
        public final UniversityTableFragment newInstance(String layoutTag) {
            Intrinsics.checkNotNullParameter(layoutTag, "layoutTag");
            UniversityTableFragment universityTableFragment = new UniversityTableFragment();
            Bundle bundle = new Bundle();
            bundle.putString(UniversityTableFragment.INSTANCE.getLAYOUT_TAG(), layoutTag);
            universityTableFragment.setArguments(bundle);
            return universityTableFragment;
        }
    }
}
