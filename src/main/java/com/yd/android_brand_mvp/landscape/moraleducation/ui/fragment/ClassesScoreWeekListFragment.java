package com.yd.android_brand_mvp.landscape.moraleducation.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentClassesScoreWeekBinding;
import com.yd.android_brand_mvp.databinding.ItemClassesScoreDetailsBinding;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CurrentMEModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.ScoringDetailCycleModel;
import com.yd.android_brand_mvp.landscape.moraleducation.ui.DailyScoreWeekDetailsActivity;
import com.yd.android_brand_mvp.landscape.moraleducation.viewmodel.ClassMEViewModel;
import com.yd.android_brand_mvp.utils.SpData;
import java.util.Arrays;
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

/* JADX INFO: compiled from: ClassesScoreWeekListFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0002J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/fragment/ClassesScoreWeekListFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentClassesScoreWeekBinding;", "()V", "mAdapter", "com/yd/android_brand_mvp/landscape/moraleducation/ui/fragment/ClassesScoreWeekListFragment$mAdapter$1", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/fragment/ClassesScoreWeekListFragment$mAdapter$1;", "mViewModel", "Lcom/yd/android_brand_mvp/landscape/moraleducation/viewmodel/ClassMEViewModel;", "getMViewModel", "()Lcom/yd/android_brand_mvp/landscape/moraleducation/viewmodel/ClassMEViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClassesScoreWeekListFragment extends KTBaseFragment<FragmentClassesScoreWeekBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ClassesScoreWeekListFragment$mAdapter$1 mAdapter;

    /* JADX INFO: renamed from: mViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mViewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.ui.fragment.ClassesScoreWeekListFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ClassesScoreWeekListFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentClassesScoreWeekBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentClassesScoreWeekBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentClassesScoreWeekBinding;", 0);
        }

        public final FragmentClassesScoreWeekBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentClassesScoreWeekBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentClassesScoreWeekBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.yd.android_brand_mvp.landscape.moraleducation.ui.fragment.ClassesScoreWeekListFragment$mAdapter$1] */
    public ClassesScoreWeekListFragment() {
        super(AnonymousClass1.INSTANCE);
        final ClassesScoreWeekListFragment classesScoreWeekListFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.fragment.ClassesScoreWeekListFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return classesScoreWeekListFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.fragment.ClassesScoreWeekListFragment$special$$inlined$viewModels$default$2
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
        this.mViewModel = FragmentViewModelLazyKt.createViewModelLazy(classesScoreWeekListFragment, Reflection.getOrCreateKotlinClass(ClassMEViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.fragment.ClassesScoreWeekListFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.fragment.ClassesScoreWeekListFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.fragment.ClassesScoreWeekListFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = classesScoreWeekListFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.mAdapter = new BaseQuickAdapter<ScoringDetailCycleModel, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.fragment.ClassesScoreWeekListFragment$mAdapter$1
            {
                super(R.layout.item_classes_score_details, null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, ScoringDetailCycleModel item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemClassesScoreDetailsBinding itemClassesScoreDetailsBindingBind = ItemClassesScoreDetailsBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemClassesScoreDetailsBindingBind, "bind(holder.itemView)");
                itemClassesScoreDetailsBindingBind.tvWeek.setText(item.getMWeek());
                TextView textView = itemClassesScoreDetailsBindingBind.tvDate;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("(%s)", Arrays.copyOf(new Object[]{item.getMDate()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                textView.setText(str);
                itemClassesScoreDetailsBindingBind.tvClassScore.setText(item.getMTotalSubtractScore());
                itemClassesScoreDetailsBindingBind.tvClassTotalScore.setText(item.getMTotalScore());
                if (item.getMTotalSubtractScore() != null && Double.parseDouble(item.getMTotalSubtractScore()) >= 0.0d) {
                    itemClassesScoreDetailsBindingBind.tvClassScore.setTextColor(this.this$0.getResources().getColor(R.color.color_11c685));
                } else {
                    itemClassesScoreDetailsBindingBind.tvClassScore.setTextColor(this.this$0.getResources().getColor(R.color.color_FF4E4E));
                }
            }
        };
    }

    /* JADX INFO: compiled from: ClassesScoreWeekListFragment.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/fragment/ClassesScoreWeekListFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/fragment/ClassesScoreWeekListFragment;", "activityId", "", "cycleId", "", "data", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;", "(Ljava/lang/String;Ljava/lang/Long;Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;)Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/fragment/ClassesScoreWeekListFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ClassesScoreWeekListFragment newInstance(String activityId, Long cycleId, CurrentMEModel data) {
            ClassesScoreWeekListFragment classesScoreWeekListFragment = new ClassesScoreWeekListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("activityId", activityId);
            bundle.putLong("cycleId", cycleId != null ? cycleId.longValue() : 0L);
            bundle.putParcelable("data", data);
            classesScoreWeekListFragment.setArguments(bundle);
            return classesScoreWeekListFragment;
        }
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

    private final void initView() {
        CurrentMEModel currentMEModel;
        Bundle arguments = getArguments();
        if (arguments != null && (currentMEModel = (CurrentMEModel) arguments.getParcelable("data")) != null) {
            getBinding().tvClassName.setText(SpData.getBrandName());
            TextView textView = getBinding().tvClassScore;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%s分", Arrays.copyOf(new Object[]{"" + currentMEModel.getMScore()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            textView.setText(str);
            TextView textView2 = getBinding().tvThisClassRank;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str2 = String.format("本班排名：%s", Arrays.copyOf(new Object[]{currentMEModel.getMRanking()}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            textView2.setText(str2);
        }
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.fragment.-$$Lambda$ClassesScoreWeekListFragment$d8cOVpCPHBV7KBPCqBTiRO6M1n0
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ClassesScoreWeekListFragment.initView$lambda$3(this.f$0, baseQuickAdapter, view, i);
            }
        });
        MutableLiveData<Result<List<ScoringDetailCycleModel>>> mScoringDetailCycleModelLiveData = getMViewModel().getMScoringDetailCycleModelLiveData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends List<? extends ScoringDetailCycleModel>>, Unit> function1 = new Function1<Result<? extends List<? extends ScoringDetailCycleModel>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.fragment.ClassesScoreWeekListFragment.initView.3
            {
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
                setList(list);
            }
        };
        mScoringDetailCycleModelLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.fragment.-$$Lambda$ClassesScoreWeekListFragment$X7NIpczYYNLj5nWjqkSmsb5A-WA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClassesScoreWeekListFragment.initView$lambda$4(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(ClassesScoreWeekListFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        DailyScoreWeekDetailsActivity.Companion companion = DailyScoreWeekDetailsActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.start(contextRequireContext, this$0.mAdapter.getItem(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
