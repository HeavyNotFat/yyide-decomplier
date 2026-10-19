package com.yd.android_brand_mvp.landscape.moraleducation.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
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
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentDailyScoreDetailsBinding;
import com.yd.android_brand_mvp.landscape.moraleducation.model.ScoringDetailCycleModel;
import com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.ScoringDetailsAdapter;
import com.yd.android_brand_mvp.landscape.moraleducation.viewmodel.ClassMEViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: DailyScoreDetailsFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u001a\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/DailyScoreDetailsFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentDailyScoreDetailsBinding;", "()V", "mViewModel", "Lcom/yd/android_brand_mvp/landscape/moraleducation/viewmodel/ClassMEViewModel;", "getMViewModel", "()Lcom/yd/android_brand_mvp/landscape/moraleducation/viewmodel/ClassMEViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "fillData", "", "scoringDetailsAdapter", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ScoringDetailsAdapter;", "scoringDetailCycleModel", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/ScoringDetailCycleModel;", "initView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DailyScoreDetailsFragment extends KTBaseFragment<FragmentDailyScoreDetailsBinding> {
    private static final String ARG_PARAM1 = "data";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: mViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mViewModel;

    @JvmStatic
    public static final DailyScoreDetailsFragment newInstance(String str, Long l) {
        return INSTANCE.newInstance(str, l);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.ui.DailyScoreDetailsFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: DailyScoreDetailsFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentDailyScoreDetailsBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentDailyScoreDetailsBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentDailyScoreDetailsBinding;", 0);
        }

        public final FragmentDailyScoreDetailsBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentDailyScoreDetailsBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentDailyScoreDetailsBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentDailyScoreDetailsBinding access$getBinding(DailyScoreDetailsFragment dailyScoreDetailsFragment) {
        return dailyScoreDetailsFragment.getBinding();
    }

    public DailyScoreDetailsFragment() {
        super(AnonymousClass1.INSTANCE);
        final DailyScoreDetailsFragment dailyScoreDetailsFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.DailyScoreDetailsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return dailyScoreDetailsFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.DailyScoreDetailsFragment$special$$inlined$viewModels$default$2
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
        this.mViewModel = FragmentViewModelLazyKt.createViewModelLazy(dailyScoreDetailsFragment, Reflection.getOrCreateKotlinClass(ClassMEViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.DailyScoreDetailsFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.DailyScoreDetailsFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.DailyScoreDetailsFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = dailyScoreDetailsFragment.getDefaultViewModelProviderFactory();
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
        initView();
        Bundle bundleRequireArguments = requireArguments();
        String string = bundleRequireArguments.getString("activityId");
        long j = bundleRequireArguments.getLong("cycleId");
        ClassMEViewModel mViewModel = getMViewModel();
        if (string == null) {
            string = "";
        }
        mViewModel.getDailyScoreDetails(string, j);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.ui.DailyScoreDetailsFragment$initView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DailyScoreDetailsFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004 \u0006*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lkotlin/Result;", "", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/ScoringDetailCycleModel;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C04941 extends Lambda implements Function1<Result<? extends List<? extends ScoringDetailCycleModel>>, Unit> {
        C04941() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<? extends ScoringDetailCycleModel>> result) {
            invoke2(result);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Result<? extends List<? extends ScoringDetailCycleModel>> it2) {
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            Object value = it2.getValue();
            if (Result.m597isFailureimpl(value)) {
                value = null;
            }
            List list = (List) value;
            if (list == null) {
                return;
            }
            Context contextRequireContext = DailyScoreDetailsFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            final ScoringDetailsAdapter scoringDetailsAdapter = new ScoringDetailsAdapter(contextRequireContext, new ArrayList());
            final LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                String mWeek = ((ScoringDetailCycleModel) obj).getMWeek();
                Object obj2 = linkedHashMap.get(mWeek);
                if (obj2 == null) {
                    obj2 = (List) new ArrayList();
                    linkedHashMap.put(mWeek, obj2);
                }
                ((List) obj2).add(obj);
            }
            DailyScoreDetailsFragment.access$getBinding(DailyScoreDetailsFragment.this).rvScoringDetails.setLayoutManager(new LinearLayoutManager(DailyScoreDetailsFragment.this.requireContext()));
            DailyScoreDetailsFragment.access$getBinding(DailyScoreDetailsFragment.this).rvScoringDetails.setAdapter(scoringDetailsAdapter);
            RadioGroup radioGroup = DailyScoreDetailsFragment.access$getBinding(DailyScoreDetailsFragment.this).rgWeek;
            final DailyScoreDetailsFragment dailyScoreDetailsFragment = DailyScoreDetailsFragment.this;
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$DailyScoreDetailsFragment$initView$1$qYI_C51c7OHGsK6PJa0_hr_hDAg
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                    DailyScoreDetailsFragment.C04941.invoke$lambda$1(dailyScoreDetailsFragment, linkedHashMap, scoringDetailsAdapter, radioGroup2, i);
                }
            });
            DailyScoreDetailsFragment.access$getBinding(DailyScoreDetailsFragment.this).rgWeek.check(R.id.rb_monday);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1(DailyScoreDetailsFragment this$0, Map scoringDetailCycleMap, ScoringDetailsAdapter scoringDetailsAdapter, RadioGroup radioGroup, int i) {
            char c;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(scoringDetailCycleMap, "$scoringDetailCycleMap");
            Intrinsics.checkNotNullParameter(scoringDetailsAdapter, "$scoringDetailsAdapter");
            String[] stringArray = this$0.getResources().getStringArray(R.array.weekStr_7);
            Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(R.array.weekStr_7)");
            switch (i) {
                case R.id.rb_friday /* 2131363528 */:
                    c = 4;
                    break;
                case R.id.rb_monday /* 2131363531 */:
                default:
                    c = 0;
                    break;
                case R.id.rb_saturday /* 2131363540 */:
                    c = 5;
                    break;
                case R.id.rb_sunday /* 2131363541 */:
                    c = 6;
                    break;
                case R.id.rb_thursday /* 2131363543 */:
                    c = 3;
                    break;
                case R.id.rb_tuesday /* 2131363547 */:
                    c = 1;
                    break;
                case R.id.rb_wednesday /* 2131363548 */:
                    c = 2;
                    break;
            }
            String str = stringArray[c];
            if (scoringDetailCycleMap.containsKey(str)) {
                List list = (List) scoringDetailCycleMap.get(str);
                if (list == null || list.size() != 1) {
                    return;
                }
                this$0.fillData(scoringDetailsAdapter, (ScoringDetailCycleModel) list.get(0));
                return;
            }
            scoringDetailsAdapter.clearData();
        }
    }

    private final void initView() {
        MutableLiveData<Result<List<ScoringDetailCycleModel>>> mScoringDetailCycleModelLiveData = getMViewModel().getMScoringDetailCycleModelLiveData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final C04941 c04941 = new C04941();
        mScoringDetailCycleModelLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$DailyScoreDetailsFragment$0OQDQW2laDDgeaJDYgeI1lH8XsU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailyScoreDetailsFragment.initView$lambda$1(c04941, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fillData(ScoringDetailsAdapter scoringDetailsAdapter, ScoringDetailCycleModel scoringDetailCycleModel) {
        scoringDetailsAdapter.replaceData(CollectionsKt.toMutableList((Collection) scoringDetailCycleModel.getMLineList()));
        getBinding().tvTotalPoints.setText(scoringDetailCycleModel.getMTotalScore());
        TextView textView = getBinding().tvBonusPointsForTheDay;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getResources().getString(R.string.plus_label);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.plus_label)");
        String str = String.format(string, Arrays.copyOf(new Object[]{scoringDetailCycleModel.getMTotalAddScore()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView.setText(str);
        getBinding().tvMinusPointsForTheDay.setText(scoringDetailCycleModel.getMTotalSubtractScore());
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.yd.android_brand_mvp.base.BaseLayoutActivity");
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String string2 = getResources().getString(R.string.current_week);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.current_week)");
        String str2 = String.format(string2, Arrays.copyOf(new Object[]{scoringDetailCycleModel.getMCycle()}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        ((BaseLayoutActivity) fragmentActivityRequireActivity).setRightTextView(str2);
    }

    /* JADX INFO: compiled from: DailyScoreDetailsFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/DailyScoreDetailsFragment$Companion;", "", "()V", "ARG_PARAM1", "", "newInstance", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/DailyScoreDetailsFragment;", "activityId", "cycleId", "", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/DailyScoreDetailsFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DailyScoreDetailsFragment newInstance(String activityId, Long cycleId) {
            DailyScoreDetailsFragment dailyScoreDetailsFragment = new DailyScoreDetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("activityId", activityId);
            bundle.putLong("cycleId", cycleId != null ? cycleId.longValue() : 0L);
            dailyScoreDetailsFragment.setArguments(bundle);
            return dailyScoreDetailsFragment;
        }
    }
}
