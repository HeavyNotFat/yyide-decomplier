package com.yd.android_brand_mvp.landscape.chemistry;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.work.WorkRequest;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.orhanobut.hawk.Hawk;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.SiteKBActivity;
import com.yd.android_brand_mvp.adapter.ClassTableAdapter2x2;
import com.yd.android_brand_mvp.adapter.attence.CheckAttendanceActivity;
import com.yd.android_brand_mvp.adapter.chemistry.DeviceListAdapter;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.FragmentHomeChemistryBinding;
import com.yd.android_brand_mvp.dialog.chemistry.SiteInfoDialog;
import com.yd.android_brand_mvp.landscape.chemistry.viewmodel.HomeChemistryViewModel;
import com.yd.android_brand_mvp.landscape.university.adapter.UniversityHeadAdapter;
import com.yd.android_brand_mvp.model.AttenceNewListBean;
import com.yd.android_brand_mvp.model.BaseBean;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.SiteInfoBean;
import com.yd.android_brand_mvp.model.TableRsp;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TeacherNameUtils;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
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
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
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
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: compiled from: HomeChemistryFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\u001a\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0016H\u0002J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u000fH\u0002J\b\u0010(\u001a\u00020\u0016H\u0002J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u000fH\u0002J(\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0+2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020\u0018R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\u0013¨\u0006/"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/chemistry/HomeChemistryFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentHomeChemistryBinding;", "()V", "courseListAdapter", "Lcom/yd/android_brand_mvp/adapter/ClassTableAdapter2x2;", "getCourseListAdapter", "()Lcom/yd/android_brand_mvp/adapter/ClassTableAdapter2x2;", "courseListAdapter$delegate", "Lkotlin/Lazy;", "showTimetable", "Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO$TimetableListDTO;", "siteInfoData", "Lcom/yd/android_brand_mvp/model/SiteInfoBean;", "tempCourseListData", "Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/chemistry/viewmodel/HomeChemistryViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/chemistry/viewmodel/HomeChemistryViewModel;", "viewModel$delegate", "UpdataEvent", "", "id", "", "getLastList", "", "Lcom/yd/android_brand_mvp/model/TableRsp;", TUIKitConstants.Selection.LIST, "getTableRsp", "datum", "initView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "requestCourseList", "setCourseListData", "data", "setSaveCourseData", "setShowCourseInfo", "splitList", "", "Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO$TimetableListDTO$TeacherListDTO;", "groupSize", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomeChemistryFragment extends KTBaseFragment<FragmentHomeChemistryBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: courseListAdapter$delegate, reason: from kotlin metadata */
    private final Lazy courseListAdapter;
    private KBRsp2.DataDTO.TimetableListDTO showTimetable;
    private SiteInfoBean siteInfoData;
    private KBRsp2.DataDTO tempCourseListData;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomeChemistryFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentHomeChemistryBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentHomeChemistryBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentHomeChemistryBinding;", 0);
        }

        public final FragmentHomeChemistryBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentHomeChemistryBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentHomeChemistryBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentHomeChemistryBinding access$getBinding(HomeChemistryFragment homeChemistryFragment) {
        return homeChemistryFragment.getBinding();
    }

    public HomeChemistryFragment() {
        super(AnonymousClass1.INSTANCE);
        this.courseListAdapter = LazyKt.lazy(new Function0<ClassTableAdapter2x2>() { // from class: com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment$courseListAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ClassTableAdapter2x2 invoke() {
                return new ClassTableAdapter2x2(R.drawable.bg_purple_r10, R.drawable.bg_f5f6fa_r10, R.color.white, R.color.black);
            }
        });
        final HomeChemistryFragment homeChemistryFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return homeChemistryFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(homeChemistryFragment, Reflection.getOrCreateKotlinClass(HomeChemistryViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = homeChemistryFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    /* JADX INFO: compiled from: HomeChemistryFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/chemistry/HomeChemistryFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance() {
            HomeChemistryFragment homeChemistryFragment = new HomeChemistryFragment();
            homeChemistryFragment.setArguments(new Bundle());
            return homeChemistryFragment;
        }
    }

    private final ClassTableAdapter2x2 getCourseListAdapter() {
        return (ClassTableAdapter2x2) this.courseListAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeChemistryViewModel getViewModel() {
        return (HomeChemistryViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        requestCourseList();
        NewBrandLoginRsp.DataBean dataBean = SpData.NewUser().data;
        if (dataBean != null) {
            String str = dataBean.siteId;
            if (str == null || str.length() == 0) {
                return;
            }
            HomeChemistryViewModel viewModel = getViewModel();
            String str2 = dataBean.siteId;
            Intrinsics.checkNotNullExpressionValue(str2, "newUserData.siteId");
            viewModel.getSiteInfo(str2);
        }
    }

    private final void requestCourseList() {
        NewBrandLoginRsp newBrandLoginRspNewUser = SpData.NewUser();
        if ((newBrandLoginRspNewUser != null ? newBrandLoginRspNewUser.data : null) != null) {
            HomeChemistryViewModel viewModel = getViewModel();
            String str = newBrandLoginRspNewUser.data.siteId;
            Intrinsics.checkNotNullExpressionValue(str, "userData.data.siteId");
            viewModel.getCourseList(str, -1, "2");
        }
    }

    private final void initView() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        HomeChemistryFragment homeChemistryFragment = this;
        getBinding().bannerFragmentChemistryCourseTeacher.addBannerLifecycleObserver(homeChemistryFragment).setStartPosition(1).setAdapter(new UniversityHeadAdapter(contextRequireContext, null, false)).isAutoLoop(true).setLoopTime(WorkRequest.MIN_BACKOFF_MILLIS).setIndicator(new CircleIndicator(requireContext())).setIndicatorGravity(1).setIndicatorSpace(BannerUtils.dp2px(10.0f)).setIndicatorNormalColor(SimpleUtilsKt.asColor(R.color.color_CCDFFF)).setIndicatorSelectedColor(SimpleUtilsKt.asColor(R.color.blue7)).setIndicatorWidth(BannerUtils.dp2px(10.0f), BannerUtils.dp2px(10.0f)).setIndicatorHeight(BannerUtils.dp2px(10.0f));
        DeviceListAdapter deviceListAdapter = new DeviceListAdapter();
        getBinding().rvFragmentChemistryDevice.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().rvFragmentChemistryDevice.setAdapter(deviceListAdapter);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BaseBean(null, "试管", "60支", 1, null));
        arrayList.add(new BaseBean(null, "蒸发皿", "30个", 1, null));
        arrayList.add(new BaseBean(null, "烧杯", "42个", 1, null));
        arrayList.add(new BaseBean(null, "烧瓶", "36个", 1, null));
        arrayList.add(new BaseBean(null, "锥形瓶", "32个", 1, null));
        deviceListAdapter.setList(arrayList);
        getBinding().rvFragmentChemistryCourseList.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().rvFragmentChemistryCourseList.setAdapter(getCourseListAdapter());
        getBinding().btnFragmentHomeChemistryCourse.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.chemistry.-$$Lambda$HomeChemistryFragment$NMFhWr43fg-qCQcZv04-BFyB-zE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeChemistryFragment.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().tvFragmentHomeChemistrySite.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.chemistry.-$$Lambda$HomeChemistryFragment$PM_N4h3cgxMb2tB4ZhxgBOhZ2Jk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeChemistryFragment.initView$lambda$2(this.f$0, view);
            }
        });
        getBinding().clFragmentChemistryCourseTitle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.chemistry.-$$Lambda$HomeChemistryFragment$Dxg3_NtjjKv3EuwLyjo8M3XNm4w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeChemistryFragment.initView$lambda$3(this.f$0, view);
            }
        });
        LiveData<Result<KBRsp2.DataDTO>> courseList = getViewModel().getCourseList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends KBRsp2.DataDTO>, Unit> function1 = new Function1<Result<? extends KBRsp2.DataDTO>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment.initView.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends KBRsp2.DataDTO> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends KBRsp2.DataDTO> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (!Result.m598isSuccessimpl(it2.getValue())) {
                    HomeChemistryFragment.this.setSaveCourseData();
                    return;
                }
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                KBRsp2.DataDTO dataDTO = (KBRsp2.DataDTO) value;
                if (dataDTO == null) {
                    HomeChemistryFragment.this.setSaveCourseData();
                    return;
                }
                KBRsp2 kBRsp2 = new KBRsp2();
                kBRsp2.data = dataDTO;
                kBRsp2.code = 0;
                kBRsp2.message = "success";
                SPUtils.getInstance().put(SpData.Table, JSON.toJSONString(kBRsp2));
                Hawk.delete(BaseHawk.NEWCLASSKB);
                Hawk.put(BaseHawk.NEWCLASSKB, kBRsp2);
                if (dataDTO.timetableList.size() == 0) {
                    Hawk.delete(BaseHawk.NEWCLASSKB);
                }
                HomeChemistryFragment.this.tempCourseListData = dataDTO;
                HomeChemistryFragment.this.setCourseListData(dataDTO);
                HomeChemistryFragment.this.setShowCourseInfo(dataDTO);
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(HomeChemistryFragment.this), null, null, new AnonymousClass1(HomeChemistryFragment.this, null), 3, null);
            }

            /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment$initView$4$1, reason: invalid class name */
            /* JADX INFO: compiled from: HomeChemistryFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment$initView$4$1", f = "HomeChemistryFragment.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ HomeChemistryFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(HomeChemistryFragment homeChemistryFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = homeChemistryFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (this.this$0.getViewModel().startTimer(30, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        };
        courseList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.chemistry.-$$Lambda$HomeChemistryFragment$MlmIKB6mRMdt_cdzfycbA8Mq_Ow
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeChemistryFragment.initView$lambda$4(function1, obj);
            }
        });
        LiveData<Result<SiteInfoBean>> siteInfo = getViewModel().getSiteInfo();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends SiteInfoBean>, Unit> function2 = new Function1<Result<? extends SiteInfoBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment.initView.5
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
                HomeChemistryFragment.this.siteInfoData = siteInfoBean;
                HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).tvFragmentHomeChemistrySite.setText(siteInfoBean.getName());
            }
        };
        siteInfo.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.chemistry.-$$Lambda$HomeChemistryFragment$_BJxE6KBQIaQe8l-6X4pvxgm_k4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeChemistryFragment.initView$lambda$5(function2, obj);
            }
        });
        LiveData<Result<List<AttenceNewListBean.DataDTO>>> attendanceResultList = getViewModel().getAttendanceResultList();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Result<? extends List<? extends AttenceNewListBean.DataDTO>>, Unit> function3 = new Function1<Result<? extends List<? extends AttenceNewListBean.DataDTO>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment.initView.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<? extends AttenceNewListBean.DataDTO>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<? extends AttenceNewListBean.DataDTO>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                Object obj = null;
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                List list = (List) value;
                if (list == null) {
                    HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).tvFragmentHomeChemistryCourseAbsenceTotal.setText("/0");
                    HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).tvFragmentHomeChemistryCourseSignTotal.setText("/0");
                    HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).tvFragmentHomeChemistryCourseSignNumber.setText("0");
                    HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).tvFragmentHomeChemistryCourseAbsenceNumber.setText("0");
                    HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).pbFragmentHomeChemistryCourseSign.setProgress(0);
                    HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).pbFragmentHomeChemistryCourseAbsence.setProgress(0);
                    return;
                }
                for (Object obj2 : list) {
                    if (((AttenceNewListBean.DataDTO) obj2).type == 3) {
                        obj = obj2;
                        break;
                    }
                }
                AttenceNewListBean.DataDTO dataDTO = (AttenceNewListBean.DataDTO) obj;
                if (dataDTO == null) {
                    HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).tvFragmentHomeChemistryCourseAbsenceTotal.setText("/0");
                    HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).tvFragmentHomeChemistryCourseSignTotal.setText("/0");
                    HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).tvFragmentHomeChemistryCourseSignNumber.setText("0");
                    HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).tvFragmentHomeChemistryCourseAbsenceNumber.setText("0");
                    HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).pbFragmentHomeChemistryCourseSign.setProgress(0);
                    HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).pbFragmentHomeChemistryCourseAbsence.setProgress(0);
                    return;
                }
                int i = dataDTO.total;
                if (i == 0) {
                    HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).tvFragmentHomeChemistryCourseAbsenceTotal.setText("/0");
                    HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).tvFragmentHomeChemistryCourseSignTotal.setText("/0");
                    HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).tvFragmentHomeChemistryCourseSignNumber.setText("0");
                    HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).tvFragmentHomeChemistryCourseAbsenceNumber.setText("0");
                    HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).pbFragmentHomeChemistryCourseSign.setProgress(0);
                    HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).pbFragmentHomeChemistryCourseAbsence.setProgress(0);
                    return;
                }
                int i2 = dataDTO.normalNum + dataDTO.beLateNum;
                int i3 = dataDTO.absenteeismNum;
                float f = i;
                float f2 = 100;
                int i4 = (int) ((i2 / f) * f2);
                int i5 = (int) ((i3 / f) * f2);
                TextView textView = HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).tvFragmentHomeChemistryCourseAbsenceTotal;
                StringBuilder sb = new StringBuilder();
                sb.append('/');
                sb.append(i);
                textView.setText(sb.toString());
                TextView textView2 = HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).tvFragmentHomeChemistryCourseSignTotal;
                StringBuilder sb2 = new StringBuilder();
                sb2.append('/');
                sb2.append(i);
                textView2.setText(sb2.toString());
                HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).tvFragmentHomeChemistryCourseSignNumber.setText(String.valueOf(i2));
                HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).tvFragmentHomeChemistryCourseAbsenceNumber.setText(String.valueOf(i3));
                HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).pbFragmentHomeChemistryCourseSign.setProgress(i4);
                HomeChemistryFragment.access$getBinding(HomeChemistryFragment.this).pbFragmentHomeChemistryCourseAbsence.setProgress(i5);
            }
        };
        attendanceResultList.observe(viewLifecycleOwner3, new Observer() { // from class: com.yd.android_brand_mvp.landscape.chemistry.-$$Lambda$HomeChemistryFragment$FW4io1Ym2oe6B8rPLo9qZilA6f0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeChemistryFragment.initView$lambda$6(function3, obj);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(homeChemistryFragment), null, null, new AnonymousClass7(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(HomeChemistryFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.requireContext(), (Class<?>) CheckAttendanceActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(HomeChemistryFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SiteInfoBean siteInfoBean = this$0.siteInfoData;
        if (siteInfoBean != null) {
            new SiteInfoDialog(siteInfoBean).show(this$0.getChildFragmentManager(), "siteInfo");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(HomeChemistryFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getActivity(), (Class<?>) SiteKBActivity.class);
        intent.putExtra("drak", "chemistry");
        this$0.goPermissionsActivity(intent);
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

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment$initView$7, reason: invalid class name */
    /* JADX INFO: compiled from: HomeChemistryFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment$initView$7", f = "HomeChemistryFragment.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass7(Continuation<? super AnonymousClass7> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeChemistryFragment.this.new AnonymousClass7(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow<String> timeSharedFlow = HomeChemistryFragment.this.getViewModel().getTimeSharedFlow();
                final HomeChemistryFragment homeChemistryFragment = HomeChemistryFragment.this;
                this.label = 1;
                if (timeSharedFlow.collect(new FlowCollector() { // from class: com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment.initView.7.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((String) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(String str, Continuation<? super Unit> continuation) {
                        KBRsp2.DataDTO dataDTO = homeChemistryFragment.tempCourseListData;
                        if (dataDTO != null) {
                            HomeChemistryFragment homeChemistryFragment2 = homeChemistryFragment;
                            homeChemistryFragment2.setCourseListData(dataDTO);
                            homeChemistryFragment2.setShowCourseInfo(dataDTO);
                        }
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void setCourseListData(KBRsp2.DataDTO data) {
        ClassTableAdapter2x2 courseListAdapter = getCourseListAdapter();
        Integer num = data.thisWeek;
        Intrinsics.checkNotNullExpressionValue(num, "data.thisWeek");
        courseListAdapter.setWeek(num.intValue());
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < 8; i++) {
            ArrayList arrayList2 = new ArrayList();
            for (KBRsp2.DataDTO.TimetableListDTO datum : data.timetableList) {
                if (datum.week == i && datum.subjectName != null) {
                    Intrinsics.checkNotNullExpressionValue(datum, "datum");
                    arrayList2.add(getTableRsp(datum));
                }
            }
            arrayList.add(getLastList(arrayList2));
        }
        String chineseWeek = TimeUtils.getChineseWeek(new Date());
        int i2 = -1;
        if (chineseWeek != null) {
            switch (chineseWeek.hashCode()) {
                case 689816:
                    if (chineseWeek.equals("周一")) {
                        i2 = 1;
                    }
                    break;
                case 689825:
                    if (chineseWeek.equals("周三")) {
                        i2 = 3;
                    }
                    break;
                case 689956:
                    if (chineseWeek.equals("周二")) {
                        i2 = 2;
                    }
                    break;
                case 689964:
                    if (chineseWeek.equals("周五")) {
                        i2 = 5;
                    }
                    break;
                case 690693:
                    if (chineseWeek.equals("周六")) {
                        i2 = 6;
                    }
                    break;
                case 692083:
                    if (chineseWeek.equals("周四")) {
                        i2 = 4;
                    }
                    break;
                case 695933:
                    if (chineseWeek.equals("周日")) {
                        i2 = 7;
                    }
                    break;
            }
        }
        getCourseListAdapter().setList((Collection) arrayList.get(i2 - 1));
        int i3 = 0;
        for (TableRsp tableRsp : getCourseListAdapter().getData()) {
            int i4 = i3 + 1;
            if (TimeUtil.forRemindTime(tableRsp.startTime, tableRsp.endTime)) {
                getBinding().rvFragmentChemistryCourseList.smoothScrollToPosition(i3);
                return;
            }
            i3 = i4;
        }
    }

    private final List<TableRsp> getLastList(List<? extends TableRsp> list) {
        return CollectionsKt.sortedWith(list, new Comparator() { // from class: com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment$getLastList$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((TableRsp) t).startTime, ((TableRsp) t2).startTime);
            }
        });
    }

    private final TableRsp getTableRsp(KBRsp2.DataDTO.TimetableListDTO datum) {
        TableRsp tableRsp = new TableRsp();
        tableRsp.subjectsName = datum.subjectName;
        if (datum.teacherList != null && datum.teacherList.size() > 0) {
            TeacherNameUtils teacherNameUtils = TeacherNameUtils.INSTANCE;
            List<KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO> list = datum.teacherList;
            Intrinsics.checkNotNullExpressionValue(list, "datum.teacherList");
            tableRsp.teacherName = teacherNameUtils.getTeacherNameByList(list);
        }
        tableRsp.seletion = datum.section;
        tableRsp.startTime = datum.startTime;
        tableRsp.endTime = datum.endTime;
        tableRsp.week = datum.week;
        tableRsp.timeFrame = datum.sectionType;
        return tableRsp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSaveCourseData() {
        KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCLASSKB);
        if ((kBRsp2 != null ? kBRsp2.data : null) == null) {
            this.tempCourseListData = null;
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C04111(null), 3, null);
        } else {
            this.tempCourseListData = kBRsp2.data;
            KBRsp2.DataDTO dataDTO = kBRsp2.data;
            Intrinsics.checkNotNullExpressionValue(dataDTO, "value.data");
            setCourseListData(dataDTO);
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment$setSaveCourseData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeChemistryFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment$setSaveCourseData$1", f = "HomeChemistryFragment.kt", i = {}, l = {290}, m = "invokeSuspend", n = {}, s = {})
    static final class C04111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C04111(Continuation<? super C04111> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeChemistryFragment.this.new C04111(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (HomeChemistryFragment.this.getViewModel().cancelTimer(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setShowCourseInfo(KBRsp2.DataDTO data) {
        KBRsp2.DataDTO.TimetableListDTO next;
        boolean z;
        int intWeekDay = TimeUtil.getIntWeekDay(System.currentTimeMillis());
        List<KBRsp2.DataDTO.TimetableListDTO> list = data.timetableList;
        boolean z2 = false;
        if (list != null) {
            Iterator<KBRsp2.DataDTO.TimetableListDTO> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    z = false;
                    break;
                } else {
                    next = it2.next();
                    if (next.week == intWeekDay && TimeUtil.forRemindTime(next.startTime, next.endTime)) {
                        z = true;
                        break;
                    }
                }
            }
            if (next != null) {
                z2 = z;
                break;
            }
            Iterator<KBRsp2.DataDTO.TimetableListDTO> it3 = data.timetableList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    z2 = z;
                    break;
                }
                KBRsp2.DataDTO.TimetableListDTO next2 = it3.next();
                if (next2.week == intWeekDay && TimeUtil.isTable(next2.startTime, next2.endTime)) {
                    next = next2;
                    break;
                }
            }
        } else {
            next = null;
        }
        if (next != null) {
            if (this.showTimetable == null) {
                HomeChemistryViewModel viewModel = getViewModel();
                String str = next.id;
                Intrinsics.checkNotNullExpressionValue(str, "itemTable!!.id");
                viewModel.requestActivityCycle(str);
            }
            KBRsp2.DataDTO.TimetableListDTO timetableListDTO = this.showTimetable;
            if (timetableListDTO != null) {
                Intrinsics.checkNotNull(timetableListDTO);
                if (!Intrinsics.areEqual(timetableListDTO.id, next.id)) {
                    HomeChemistryViewModel viewModel2 = getViewModel();
                    String str2 = next.id;
                    Intrinsics.checkNotNullExpressionValue(str2, "itemTable!!.id");
                    viewModel2.requestActivityCycle(str2);
                }
            }
            this.showTimetable = next;
            if (z2) {
                getBinding().tvFragmentHomeChemistryCourseTip.setText("正在上课");
            } else {
                getBinding().tvFragmentHomeChemistryCourseTip.setText("即将上课");
            }
            KBRsp2.DataDTO.TimetableListDTO timetableListDTO2 = this.showTimetable;
            if (timetableListDTO2 != null) {
                getBinding().tvFragmentHomeChemistryCourseTitle.setText(timetableListDTO2.subjectName);
                getBinding().tvFragmentHomeChemistryCourseTime.setText(timetableListDTO2.startTime + '-' + timetableListDTO2.endTime);
                List<KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO> teacherList = timetableListDTO2.teacherList;
                if (teacherList != null) {
                    Intrinsics.checkNotNullExpressionValue(teacherList, "teacherList");
                    getBinding().bannerFragmentChemistryCourseTeacher.setDatas(splitList(teacherList, 3));
                    return;
                }
                return;
            }
            return;
        }
        getBinding().bannerFragmentChemistryCourseTeacher.setDatas(null);
        getBinding().tvFragmentHomeChemistryCourseTip.setText("即将上课");
        getBinding().tvFragmentHomeChemistryCourseTitle.setText("暂无课程");
        getBinding().tvFragmentHomeChemistryCourseTime.setText("");
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

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        KBRsp2.DataDTO.TimetableListDTO timetableListDTO;
        super.UpdataEvent(id);
        if (MinaConstants.Table == id) {
            requestCourseList();
            return;
        }
        if (id != MinaConstants.CODE_UPDATA_ATTENCE_LIST || (timetableListDTO = this.showTimetable) == null) {
            return;
        }
        HomeChemistryViewModel viewModel = getViewModel();
        String str = timetableListDTO.id;
        Intrinsics.checkNotNullExpressionValue(str, "it.id");
        viewModel.requestActivityCycle(str);
    }
}
