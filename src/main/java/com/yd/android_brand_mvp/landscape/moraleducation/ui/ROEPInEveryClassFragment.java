package com.yd.android_brand_mvp.landscape.moraleducation.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentRoepInEveryClassBinding;
import com.yd.android_brand_mvp.landscape.Wlkz2_2L;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CurrentMEModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CycleCurrentMEModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.IndexClassMEModel;
import com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.ROEPIECAdapter;
import com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.TopThreeRankingIconAdapter;
import com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.TopThreeRankingScoreAdapter2;
import com.yd.android_brand_mvp.landscape.moraleducation.viewmodel.ClassMEViewModel;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.verfity.TeacherCheackActivity2;
import com.zhpan.bannerview.BannerViewPager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: ROEPInEveryClassFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000245B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u001eH\u0016J\u001a\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)H\u0007J\u0018\u0010*\u001a\u00020\u001e2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001bH\u0002J\u0018\u0010,\u001a\u00020\u001e2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001bH\u0002J\u0016\u0010.\u001a\u00020\u001e2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\n0\u001bH\u0002J\u0016\u00100\u001a\u00020\u001e2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\n0\u001bH\u0002J\u0016\u00102\u001a\u00020\u001e2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\n0\u001bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00060\u0007R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/ROEPInEveryClassFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentRoepInEveryClassBinding;", "()V", "mActivityId", "", "mBroadcastReceiver", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/ROEPInEveryClassFragment$MyBroadcastReceiver;", "mBvpClassIcon1", "Lcom/zhpan/bannerview/BannerViewPager;", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CycleCurrentMEModel;", "mBvpClassIcon2", "mBvpClassIcon3", "mBvpClassScore1", "mBvpClassScore2", "mBvpClassScore3", "mCycleId", "", "Ljava/lang/Long;", "mTitle", "mViewModel", "Lcom/yd/android_brand_mvp/landscape/moraleducation/viewmodel/ClassMEViewModel;", "getMViewModel", "()Lcom/yd/android_brand_mvp/landscape/moraleducation/viewmodel/ClassMEViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mWinPrizeList", "", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;", "initBannerViewPager", "", "initViewModel", "onResume", "onStop", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "parseEventBean", "data", "Lcom/yd/android_brand_mvp/model/EventBean;", "showRankingForCurrentWeek", "currentResultList", "showRankingForLastWeek", "lastCycleResultList", "showTopOneUI", "topOneResults", "showTopThreeUI", "topThreeResults", "showTopTwoUI", "topTwoResults", "Companion", "MyBroadcastReceiver", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ROEPInEveryClassFragment extends KTBaseFragment<FragmentRoepInEveryClassBinding> {
    private static final String ARG_PARAM1 = "data";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = ROEPInEveryClassFragment.class.getName();
    private String mActivityId;
    private final MyBroadcastReceiver mBroadcastReceiver;
    private BannerViewPager<CycleCurrentMEModel> mBvpClassIcon1;
    private BannerViewPager<CycleCurrentMEModel> mBvpClassIcon2;
    private BannerViewPager<CycleCurrentMEModel> mBvpClassIcon3;
    private BannerViewPager<CycleCurrentMEModel> mBvpClassScore1;
    private BannerViewPager<CycleCurrentMEModel> mBvpClassScore2;
    private BannerViewPager<CycleCurrentMEModel> mBvpClassScore3;
    private Long mCycleId;
    private String mTitle;

    /* JADX INFO: renamed from: mViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mViewModel;
    private List<CurrentMEModel> mWinPrizeList;

    @JvmStatic
    public static final ROEPInEveryClassFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void parseEventBean(EventBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.ui.ROEPInEveryClassFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ROEPInEveryClassFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentRoepInEveryClassBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentRoepInEveryClassBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentRoepInEveryClassBinding;", 0);
        }

        public final FragmentRoepInEveryClassBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentRoepInEveryClassBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentRoepInEveryClassBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentRoepInEveryClassBinding access$getBinding(ROEPInEveryClassFragment rOEPInEveryClassFragment) {
        return rOEPInEveryClassFragment.getBinding();
    }

    public ROEPInEveryClassFragment() {
        super(AnonymousClass1.INSTANCE);
        this.mActivityId = "";
        this.mCycleId = 0L;
        this.mTitle = "";
        this.mBroadcastReceiver = new MyBroadcastReceiver();
        final ROEPInEveryClassFragment rOEPInEveryClassFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.ROEPInEveryClassFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return rOEPInEveryClassFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.ROEPInEveryClassFragment$special$$inlined$viewModels$default$2
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
        this.mViewModel = FragmentViewModelLazyKt.createViewModelLazy(rOEPInEveryClassFragment, Reflection.getOrCreateKotlinClass(ClassMEViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.ROEPInEveryClassFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.ROEPInEveryClassFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.ROEPInEveryClassFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = rOEPInEveryClassFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    private final ClassMEViewModel getMViewModel() {
        return (ClassMEViewModel) this.mViewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().rgWeek.check(R.id.rb_ranking_for_last_week);
        initBannerViewPager();
        initViewModel();
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.ui.ROEPInEveryClassFragment$initViewModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ROEPInEveryClassFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/IndexClassMEModel;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C04981 extends Lambda implements Function1<Result<? extends IndexClassMEModel>, Unit> {
        C04981() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Result<? extends IndexClassMEModel> result) {
            invoke2(result);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Result<? extends IndexClassMEModel> it2) {
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            Object value = it2.getValue();
            if (Result.m597isFailureimpl(value)) {
                value = null;
            }
            final IndexClassMEModel indexClassMEModel = (IndexClassMEModel) value;
            if (indexClassMEModel != null) {
                ROEPInEveryClassFragment.this.mActivityId = indexClassMEModel.getMActivityId();
                ROEPInEveryClassFragment.this.mCycleId = indexClassMEModel.getMCycleId();
                ROEPInEveryClassFragment.this.mTitle = indexClassMEModel.getMTitle();
                ROEPInEveryClassFragment.this.mWinPrizeList = indexClassMEModel.getMWinPrizeList();
                CurrentMEModel mCurrentObj = indexClassMEModel.getMCurrentObj();
                if (mCurrentObj != null) {
                    ROEPInEveryClassFragment rOEPInEveryClassFragment = ROEPInEveryClassFragment.this;
                    ROEPInEveryClassFragment.access$getBinding(rOEPInEveryClassFragment).tvRankingCurrentWeekInThisClass.setText(mCurrentObj.getMRanking());
                    ROEPInEveryClassFragment.access$getBinding(rOEPInEveryClassFragment).tvScoringCurrentWeekInThisClass.setText(String.valueOf(mCurrentObj.getMScore()));
                }
                CycleCurrentMEModel mLastCycleCurrentObj = indexClassMEModel.getMLastCycleCurrentObj();
                if (mLastCycleCurrentObj != null) {
                    ROEPInEveryClassFragment rOEPInEveryClassFragment2 = ROEPInEveryClassFragment.this;
                    ROEPInEveryClassFragment.access$getBinding(rOEPInEveryClassFragment2).tvRankingLastWeekInThisClass.setText(String.valueOf(mLastCycleCurrentObj.getMRanking()));
                    ROEPInEveryClassFragment.access$getBinding(rOEPInEveryClassFragment2).tvScoringLastWeekInThisClass.setText(mLastCycleCurrentObj.getMScore());
                }
                ConstraintLayout constraintLayout = ROEPInEveryClassFragment.access$getBinding(ROEPInEveryClassFragment.this).clRankingLastWeekInThisClass;
                final ROEPInEveryClassFragment rOEPInEveryClassFragment3 = ROEPInEveryClassFragment.this;
                constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$ROEPInEveryClassFragment$initViewModel$1$_AcsGK8hYTIki7pgOKIpqwQn6BY
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ROEPInEveryClassFragment.C04981.invoke$lambda$2(rOEPInEveryClassFragment3, view);
                    }
                });
                ConstraintLayout constraintLayout2 = ROEPInEveryClassFragment.access$getBinding(ROEPInEveryClassFragment.this).clRankingCurrentWeekInThisClass;
                final ROEPInEveryClassFragment rOEPInEveryClassFragment4 = ROEPInEveryClassFragment.this;
                constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$ROEPInEveryClassFragment$initViewModel$1$OXNzvE3xvRyAih8BIIGeoO3hfTw
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ROEPInEveryClassFragment.C04981.invoke$lambda$3(rOEPInEveryClassFragment4, view);
                    }
                });
                RadioGroup radioGroup = ROEPInEveryClassFragment.access$getBinding(ROEPInEveryClassFragment.this).rgWeek;
                final ROEPInEveryClassFragment rOEPInEveryClassFragment5 = ROEPInEveryClassFragment.this;
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$ROEPInEveryClassFragment$initViewModel$1$EMQDOXbCVD9EifcKXsFu9Ilbs9o
                    @Override // android.widget.RadioGroup.OnCheckedChangeListener
                    public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                        ROEPInEveryClassFragment.C04981.invoke$lambda$6(rOEPInEveryClassFragment5, indexClassMEModel, radioGroup2, i);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2(ROEPInEveryClassFragment this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intent intent = new Intent(this$0.requireContext(), (Class<?>) TeacherCheackActivity2.class);
            intent.putExtra("type", BaseConstant.enterROEPInThisClass3);
            this$0.startActivity(intent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$3(ROEPInEveryClassFragment this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intent intent = new Intent(this$0.requireContext(), (Class<?>) TeacherCheackActivity2.class);
            intent.putExtra("type", BaseConstant.enterROEPInThisClass3);
            this$0.startActivity(intent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$6(ROEPInEveryClassFragment this$0, IndexClassMEModel indexClassMEModel, RadioGroup radioGroup, int i) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            switch (i) {
                case R.id.rb_ranking_for_current_week /* 2131363536 */:
                    String mTimeRange = indexClassMEModel.getMTimeRange();
                    if (mTimeRange != null) {
                        List listSplit$default = StringsKt.split$default((CharSequence) mTimeRange, new String[]{Constants.ACCEPT_TIME_SEPARATOR_SERVER}, false, 0, 6, (Object) null);
                        if (listSplit$default.size() == 2) {
                            String strDrop = StringsKt.drop((String) listSplit$default.get(0), 5);
                            String strDrop2 = StringsKt.drop((String) listSplit$default.get(1), 5);
                            ROEPInEveryClassFragment.access$getBinding(this$0).tvWeekCycle.setText(strDrop + '-' + strDrop2);
                        } else {
                            ROEPInEveryClassFragment.access$getBinding(this$0).tvWeekCycle.setText("");
                        }
                    }
                    this$0.showRankingForCurrentWeek(indexClassMEModel.getMResultList());
                    break;
                case R.id.rb_ranking_for_last_week /* 2131363537 */:
                    this$0.showRankingForLastWeek(indexClassMEModel.getMLastCycleResultList());
                    String mLastTimeRange = indexClassMEModel.getMLastTimeRange();
                    if (mLastTimeRange != null) {
                        List listSplit$default2 = StringsKt.split$default((CharSequence) mLastTimeRange, new String[]{Constants.ACCEPT_TIME_SEPARATOR_SERVER}, false, 0, 6, (Object) null);
                        if (listSplit$default2.size() == 2) {
                            String strDrop3 = StringsKt.drop((String) listSplit$default2.get(0), 5);
                            String strDrop4 = StringsKt.drop((String) listSplit$default2.get(1), 5);
                            ROEPInEveryClassFragment.access$getBinding(this$0).tvWeekCycle.setText(strDrop3 + '-' + strDrop4);
                        } else {
                            ROEPInEveryClassFragment.access$getBinding(this$0).tvWeekCycle.setText("");
                        }
                    }
                    break;
            }
        }
    }

    private final void initViewModel() {
        MutableLiveData<Result<IndexClassMEModel>> mClassMEModelLiveData = getMViewModel().getMClassMEModelLiveData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final C04981 c04981 = new C04981();
        mClassMEModelLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$ROEPInEveryClassFragment$Sl9BCXXkEy5CGWBi245AGy50oGk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ROEPInEveryClassFragment.initViewModel$lambda$0(c04981, obj);
            }
        });
        getMViewModel().getRanking();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initBannerViewPager() {
        View viewFindViewById = requireActivity().findViewById(R.id.bvp_class_icon1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "requireActivity().findVi…yId(R.id.bvp_class_icon1)");
        BannerViewPager<CycleCurrentMEModel> bannerViewPager = (BannerViewPager) viewFindViewById;
        this.mBvpClassIcon1 = bannerViewPager;
        BannerViewPager<CycleCurrentMEModel> bannerViewPager2 = null;
        if (bannerViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBvpClassIcon1");
            bannerViewPager = null;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        bannerViewPager.setAdapter(new TopThreeRankingIconAdapter(contextRequireContext));
        bannerViewPager.setOrientation(1);
        bannerViewPager.setLifecycleRegistry(getLifecycle());
        bannerViewPager.stopLoopWhenDetachedFromWindow(true);
        bannerViewPager.setIndicatorHeight(0);
        bannerViewPager.setIndicatorSliderWidth(0);
        bannerViewPager.setScrollDuration(500);
        bannerViewPager.setInterval(2000);
        bannerViewPager.setUserInputEnabled(false);
        bannerViewPager.create();
        View viewFindViewById2 = requireActivity().findViewById(R.id.bvp_class_score1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "requireActivity().findVi…Id(R.id.bvp_class_score1)");
        BannerViewPager<CycleCurrentMEModel> bannerViewPager3 = (BannerViewPager) viewFindViewById2;
        this.mBvpClassScore1 = bannerViewPager3;
        if (bannerViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBvpClassScore1");
            bannerViewPager3 = null;
        }
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        bannerViewPager3.setAdapter(new TopThreeRankingScoreAdapter2(contextRequireContext2, 1));
        bannerViewPager3.setOrientation(1);
        bannerViewPager3.setLifecycleRegistry(getLifecycle());
        bannerViewPager3.stopLoopWhenDetachedFromWindow(true);
        bannerViewPager3.setIndicatorHeight(0);
        bannerViewPager3.setIndicatorSliderWidth(0);
        bannerViewPager3.setScrollDuration(500);
        bannerViewPager3.setInterval(2000);
        bannerViewPager3.setUserInputEnabled(false);
        bannerViewPager3.create();
        View viewFindViewById3 = requireActivity().findViewById(R.id.bvp_class_icon2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "requireActivity().findVi…yId(R.id.bvp_class_icon2)");
        BannerViewPager<CycleCurrentMEModel> bannerViewPager4 = (BannerViewPager) viewFindViewById3;
        this.mBvpClassIcon2 = bannerViewPager4;
        if (bannerViewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBvpClassIcon2");
            bannerViewPager4 = null;
        }
        Context contextRequireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
        bannerViewPager4.setAdapter(new TopThreeRankingIconAdapter(contextRequireContext3));
        bannerViewPager4.setOrientation(1);
        bannerViewPager4.setLifecycleRegistry(getLifecycle());
        bannerViewPager4.stopLoopWhenDetachedFromWindow(true);
        bannerViewPager4.setIndicatorHeight(0);
        bannerViewPager4.setIndicatorSliderWidth(0);
        bannerViewPager4.setScrollDuration(500);
        bannerViewPager4.setInterval(2000);
        bannerViewPager4.setUserInputEnabled(false);
        bannerViewPager4.create();
        View viewFindViewById4 = requireActivity().findViewById(R.id.bvp_class_score2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "requireActivity().findVi…Id(R.id.bvp_class_score2)");
        BannerViewPager<CycleCurrentMEModel> bannerViewPager5 = (BannerViewPager) viewFindViewById4;
        this.mBvpClassScore2 = bannerViewPager5;
        if (bannerViewPager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBvpClassScore2");
            bannerViewPager5 = null;
        }
        Context contextRequireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext()");
        bannerViewPager5.setAdapter(new TopThreeRankingScoreAdapter2(contextRequireContext4, 2));
        bannerViewPager5.setOrientation(1);
        bannerViewPager5.setLifecycleRegistry(getLifecycle());
        bannerViewPager5.stopLoopWhenDetachedFromWindow(true);
        bannerViewPager5.setIndicatorHeight(0);
        bannerViewPager5.setIndicatorSliderWidth(0);
        bannerViewPager5.setScrollDuration(500);
        bannerViewPager5.setInterval(2000);
        bannerViewPager5.setUserInputEnabled(false);
        bannerViewPager5.create();
        View viewFindViewById5 = requireActivity().findViewById(R.id.bvp_class_icon3);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "requireActivity().findVi…yId(R.id.bvp_class_icon3)");
        BannerViewPager<CycleCurrentMEModel> bannerViewPager6 = (BannerViewPager) viewFindViewById5;
        this.mBvpClassIcon3 = bannerViewPager6;
        if (bannerViewPager6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBvpClassIcon3");
            bannerViewPager6 = null;
        }
        Context contextRequireContext5 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext()");
        bannerViewPager6.setAdapter(new TopThreeRankingIconAdapter(contextRequireContext5));
        bannerViewPager6.setOrientation(1);
        bannerViewPager6.setLifecycleRegistry(getLifecycle());
        bannerViewPager6.stopLoopWhenDetachedFromWindow(true);
        bannerViewPager6.setIndicatorHeight(0);
        bannerViewPager6.setIndicatorSliderWidth(0);
        bannerViewPager6.setScrollDuration(500);
        bannerViewPager6.setInterval(2000);
        bannerViewPager6.setUserInputEnabled(false);
        bannerViewPager6.create();
        View viewFindViewById6 = requireActivity().findViewById(R.id.bvp_class_score3);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "requireActivity().findVi…Id(R.id.bvp_class_score3)");
        BannerViewPager<CycleCurrentMEModel> bannerViewPager7 = (BannerViewPager) viewFindViewById6;
        this.mBvpClassScore3 = bannerViewPager7;
        if (bannerViewPager7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBvpClassScore3");
        } else {
            bannerViewPager2 = bannerViewPager7;
        }
        Context contextRequireContext6 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext6, "requireContext()");
        bannerViewPager2.setAdapter(new TopThreeRankingScoreAdapter2(contextRequireContext6, 3));
        bannerViewPager2.setOrientation(1);
        bannerViewPager2.setLifecycleRegistry(getLifecycle());
        bannerViewPager2.stopLoopWhenDetachedFromWindow(true);
        bannerViewPager2.setIndicatorHeight(0);
        bannerViewPager2.setIndicatorSliderWidth(0);
        bannerViewPager2.setScrollDuration(500);
        bannerViewPager2.setInterval(2000);
        bannerViewPager2.setUserInputEnabled(false);
        bannerViewPager2.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showRankingForLastWeek(List<CycleCurrentMEModel> lastCycleResultList) {
        getBinding().clTitleForLastWeek.setVisibility(0);
        getBinding().clTitleForCurrentWeek.setVisibility(8);
        getBinding().clRankingLastWeekInThisClass.setVisibility(0);
        getBinding().clRankingCurrentWeekInThisClass.setVisibility(8);
        getBinding().clRanking.setBackgroundResource(R.drawable.bg_ranking_last_week);
        List<CycleCurrentMEModel> list = lastCycleResultList;
        if (list == null || list.isEmpty()) {
            getBinding().tvRankingFirst.setVisibility(0);
            getBinding().tvRankingSecond.setVisibility(0);
            getBinding().tvRankingThird.setVisibility(0);
            BannerViewPager<CycleCurrentMEModel> bannerViewPager = this.mBvpClassIcon1;
            if (bannerViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBvpClassIcon1");
                bannerViewPager = null;
            }
            bannerViewPager.refreshData(CollectionsKt.emptyList());
            BannerViewPager<CycleCurrentMEModel> bannerViewPager2 = this.mBvpClassIcon2;
            if (bannerViewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBvpClassIcon2");
                bannerViewPager2 = null;
            }
            bannerViewPager2.refreshData(CollectionsKt.emptyList());
            BannerViewPager<CycleCurrentMEModel> bannerViewPager3 = this.mBvpClassIcon3;
            if (bannerViewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBvpClassIcon3");
                bannerViewPager3 = null;
            }
            bannerViewPager3.refreshData(CollectionsKt.emptyList());
            BannerViewPager<CycleCurrentMEModel> bannerViewPager4 = this.mBvpClassScore1;
            if (bannerViewPager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBvpClassScore1");
                bannerViewPager4 = null;
            }
            bannerViewPager4.refreshData(CollectionsKt.emptyList());
            BannerViewPager<CycleCurrentMEModel> bannerViewPager5 = this.mBvpClassScore2;
            if (bannerViewPager5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBvpClassScore2");
                bannerViewPager5 = null;
            }
            bannerViewPager5.refreshData(CollectionsKt.emptyList());
            BannerViewPager<CycleCurrentMEModel> bannerViewPager6 = this.mBvpClassScore3;
            if (bannerViewPager6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBvpClassScore3");
                bannerViewPager6 = null;
            }
            bannerViewPager6.refreshData(CollectionsKt.emptyList());
            RecyclerView.Adapter adapter = getBinding().rvRankingEveryClass.getAdapter();
            ROEPIECAdapter rOEPIECAdapter = adapter instanceof ROEPIECAdapter ? (ROEPIECAdapter) adapter : null;
            if (rOEPIECAdapter != null) {
                rOEPIECAdapter.clearData();
                return;
            }
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : lastCycleResultList) {
            Integer numValueOf = Integer.valueOf(((CycleCurrentMEModel) obj).getMRanking());
            Object obj2 = linkedHashMap.get(numValueOf);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(numValueOf, obj2);
            }
            ((List) obj2).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((Number) entry.getKey()).intValue() < 4) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        SortedMap sortedMap = MapsKt.toSortedMap(linkedHashMap2);
        int size = sortedMap.size();
        if (size == 1) {
            getBinding().tvRankingFirst.setVisibility(8);
            getBinding().tvRankingSecond.setVisibility(0);
            getBinding().tvRankingThird.setVisibility(0);
            List<CycleCurrentMEModel> list2 = (List) sortedMap.get(1);
            if (list2 != null) {
                showTopOneUI(list2);
            }
        } else if (size == 2) {
            getBinding().tvRankingFirst.setVisibility(8);
            getBinding().tvRankingSecond.setVisibility(8);
            getBinding().tvRankingThird.setVisibility(0);
            List<CycleCurrentMEModel> list3 = (List) sortedMap.get(1);
            List<CycleCurrentMEModel> list4 = (List) sortedMap.get(2);
            if (list3 != null) {
                showTopOneUI(list3);
            }
            if (list4 != null) {
                showTopTwoUI(list4);
            }
        } else if (size == 3) {
            getBinding().tvRankingFirst.setVisibility(8);
            getBinding().tvRankingSecond.setVisibility(8);
            getBinding().tvRankingThird.setVisibility(8);
            List<CycleCurrentMEModel> list5 = (List) sortedMap.get(1);
            List<CycleCurrentMEModel> list6 = (List) sortedMap.get(2);
            List<CycleCurrentMEModel> list7 = (List) sortedMap.get(3);
            if (list5 != null) {
                showTopOneUI(list5);
            }
            if (list6 != null) {
                showTopTwoUI(list6);
            }
            if (list7 != null) {
                showTopThreeUI(list7);
            }
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        ArrayList mutableList = CollectionsKt.toMutableList((Collection) list);
        if (mutableList == null) {
            mutableList = new ArrayList();
        }
        ROEPIECAdapter rOEPIECAdapter2 = new ROEPIECAdapter(contextRequireContext, mutableList, 0);
        getBinding().rvRankingEveryClass.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().rvRankingEveryClass.setAdapter(rOEPIECAdapter2);
        rOEPIECAdapter2.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showRankingForCurrentWeek(List<CycleCurrentMEModel> currentResultList) {
        getBinding().clTitleForLastWeek.setVisibility(8);
        getBinding().clTitleForCurrentWeek.setVisibility(0);
        getBinding().clRankingLastWeekInThisClass.setVisibility(8);
        getBinding().clRankingCurrentWeekInThisClass.setVisibility(0);
        getBinding().clRanking.setBackgroundResource(R.drawable.bg_ranking_current_week);
        List<CycleCurrentMEModel> list = currentResultList;
        if (list == null || list.isEmpty()) {
            getBinding().tvRankingFirst.setVisibility(0);
            getBinding().tvRankingSecond.setVisibility(0);
            getBinding().tvRankingThird.setVisibility(0);
            BannerViewPager<CycleCurrentMEModel> bannerViewPager = this.mBvpClassIcon1;
            if (bannerViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBvpClassIcon1");
                bannerViewPager = null;
            }
            bannerViewPager.refreshData(CollectionsKt.emptyList());
            BannerViewPager<CycleCurrentMEModel> bannerViewPager2 = this.mBvpClassIcon2;
            if (bannerViewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBvpClassIcon2");
                bannerViewPager2 = null;
            }
            bannerViewPager2.refreshData(CollectionsKt.emptyList());
            BannerViewPager<CycleCurrentMEModel> bannerViewPager3 = this.mBvpClassIcon3;
            if (bannerViewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBvpClassIcon3");
                bannerViewPager3 = null;
            }
            bannerViewPager3.refreshData(CollectionsKt.emptyList());
            BannerViewPager<CycleCurrentMEModel> bannerViewPager4 = this.mBvpClassScore1;
            if (bannerViewPager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBvpClassScore1");
                bannerViewPager4 = null;
            }
            bannerViewPager4.refreshData(CollectionsKt.emptyList());
            BannerViewPager<CycleCurrentMEModel> bannerViewPager5 = this.mBvpClassScore2;
            if (bannerViewPager5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBvpClassScore2");
                bannerViewPager5 = null;
            }
            bannerViewPager5.refreshData(CollectionsKt.emptyList());
            BannerViewPager<CycleCurrentMEModel> bannerViewPager6 = this.mBvpClassScore3;
            if (bannerViewPager6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBvpClassScore3");
                bannerViewPager6 = null;
            }
            bannerViewPager6.refreshData(CollectionsKt.emptyList());
            RecyclerView.Adapter adapter = getBinding().rvRankingEveryClass.getAdapter();
            ROEPIECAdapter rOEPIECAdapter = adapter instanceof ROEPIECAdapter ? (ROEPIECAdapter) adapter : null;
            if (rOEPIECAdapter != null) {
                rOEPIECAdapter.clearData();
                return;
            }
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : currentResultList) {
            Integer numValueOf = Integer.valueOf(((CycleCurrentMEModel) obj).getMRanking());
            Object obj2 = linkedHashMap.get(numValueOf);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(numValueOf, obj2);
            }
            ((List) obj2).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((Number) entry.getKey()).intValue() < 4) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        SortedMap sortedMap = MapsKt.toSortedMap(linkedHashMap2);
        int size = sortedMap.size();
        if (size == 1) {
            getBinding().tvRankingFirst.setVisibility(8);
            getBinding().tvRankingSecond.setVisibility(0);
            getBinding().tvRankingThird.setVisibility(0);
            List<CycleCurrentMEModel> list2 = (List) sortedMap.get(1);
            if (list2 != null) {
                showTopOneUI(list2);
            }
        } else if (size == 2) {
            getBinding().tvRankingFirst.setVisibility(8);
            getBinding().tvRankingSecond.setVisibility(8);
            getBinding().tvRankingThird.setVisibility(0);
            List<CycleCurrentMEModel> list3 = (List) sortedMap.get(1);
            List<CycleCurrentMEModel> list4 = (List) sortedMap.get(2);
            if (list3 != null) {
                showTopOneUI(list3);
            }
            if (list4 != null) {
                showTopTwoUI(list4);
            }
        } else if (size == 3) {
            getBinding().tvRankingFirst.setVisibility(8);
            getBinding().tvRankingSecond.setVisibility(8);
            getBinding().tvRankingThird.setVisibility(8);
            List<CycleCurrentMEModel> list5 = (List) sortedMap.get(1);
            List<CycleCurrentMEModel> list6 = (List) sortedMap.get(2);
            List<CycleCurrentMEModel> list7 = (List) sortedMap.get(3);
            if (list5 != null) {
                showTopOneUI(list5);
            }
            if (list6 != null) {
                showTopTwoUI(list6);
            }
            if (list7 != null) {
                showTopThreeUI(list7);
            }
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        ArrayList mutableList = CollectionsKt.toMutableList((Collection) list);
        if (mutableList == null) {
            mutableList = new ArrayList();
        }
        ROEPIECAdapter rOEPIECAdapter2 = new ROEPIECAdapter(contextRequireContext, mutableList, 1);
        getBinding().rvRankingEveryClass.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().rvRankingEveryClass.setAdapter(rOEPIECAdapter2);
        rOEPIECAdapter2.notifyDataSetChanged();
    }

    private final void showTopOneUI(List<CycleCurrentMEModel> topOneResults) {
        BannerViewPager<CycleCurrentMEModel> bannerViewPager = this.mBvpClassIcon1;
        BannerViewPager<CycleCurrentMEModel> bannerViewPager2 = null;
        if (bannerViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBvpClassIcon1");
            bannerViewPager = null;
        }
        bannerViewPager.refreshData(topOneResults);
        BannerViewPager<CycleCurrentMEModel> bannerViewPager3 = this.mBvpClassScore1;
        if (bannerViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBvpClassScore1");
        } else {
            bannerViewPager2 = bannerViewPager3;
        }
        bannerViewPager2.refreshData(topOneResults);
    }

    private final void showTopTwoUI(List<CycleCurrentMEModel> topTwoResults) {
        BannerViewPager<CycleCurrentMEModel> bannerViewPager = this.mBvpClassIcon2;
        BannerViewPager<CycleCurrentMEModel> bannerViewPager2 = null;
        if (bannerViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBvpClassIcon2");
            bannerViewPager = null;
        }
        bannerViewPager.refreshData(topTwoResults);
        BannerViewPager<CycleCurrentMEModel> bannerViewPager3 = this.mBvpClassScore2;
        if (bannerViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBvpClassScore2");
        } else {
            bannerViewPager2 = bannerViewPager3;
        }
        bannerViewPager2.refreshData(topTwoResults);
    }

    private final void showTopThreeUI(List<CycleCurrentMEModel> topThreeResults) {
        BannerViewPager<CycleCurrentMEModel> bannerViewPager = this.mBvpClassIcon3;
        BannerViewPager<CycleCurrentMEModel> bannerViewPager2 = null;
        if (bannerViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBvpClassIcon3");
            bannerViewPager = null;
        }
        bannerViewPager.refreshData(topThreeResults);
        BannerViewPager<CycleCurrentMEModel> bannerViewPager3 = this.mBvpClassScore3;
        if (bannerViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBvpClassScore3");
        } else {
            bannerViewPager2 = bannerViewPager3;
        }
        bannerViewPager2.refreshData(topThreeResults);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        requireActivity().unregisterReceiver(this.mBroadcastReceiver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Wlkz2_2L.SUO);
        requireActivity().registerReceiver(this.mBroadcastReceiver, intentFilter);
    }

    /* JADX INFO: compiled from: ROEPInEveryClassFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/ROEPInEveryClassFragment$MyBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/ROEPInEveryClassFragment;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class MyBroadcastReceiver extends BroadcastReceiver {
        public MyBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, Wlkz2_2L.SUO)) {
                Integer numValueOf = intent != null ? Integer.valueOf(intent.getIntExtra("type", 0)) : null;
                int i = BaseConstant.enterROEPInThisClass3;
                if (numValueOf != null && numValueOf.intValue() == i) {
                    ROEPInThisClassActivity.Companion companion = ROEPInThisClassActivity.INSTANCE;
                    Context contextRequireContext = ROEPInEveryClassFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    companion.start(contextRequireContext, ROEPInEveryClassFragment.this.mActivityId, ROEPInEveryClassFragment.this.mCycleId, ROEPInEveryClassFragment.this.mTitle, ROEPInEveryClassFragment.this.mWinPrizeList);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ROEPInEveryClassFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/ROEPInEveryClassFragment$Companion;", "", "()V", "ARG_PARAM1", "", "TAG", "kotlin.jvm.PlatformType", "newInstance", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/ROEPInEveryClassFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ROEPInEveryClassFragment newInstance() {
            ROEPInEveryClassFragment rOEPInEveryClassFragment = new ROEPInEveryClassFragment();
            rOEPInEveryClassFragment.setArguments(new Bundle());
            return rOEPInEveryClassFragment;
        }
    }
}
