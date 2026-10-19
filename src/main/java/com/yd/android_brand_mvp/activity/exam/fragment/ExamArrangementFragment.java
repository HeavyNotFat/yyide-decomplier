package com.yd.android_brand_mvp.activity.exam.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
import androidx.recyclerview.widget.GridLayoutManager;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.exam.ExamArrangementDetailActivity;
import com.yd.android_brand_mvp.activity.exam.viewmodel.ExamArrangeViewModel;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.base.ResultCodeStr;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentExamArrangementBinding;
import com.yd.android_brand_mvp.databinding.ItemExamArranement44WeekBinding;
import com.yd.android_brand_mvp.databinding.ItemExamArrangementCourseBinding;
import com.yd.android_brand_mvp.model.exam.ExamArrangementBean;
import com.yd.android_brand_mvp.model.exam.ExamGroupItem;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
import com.yd.android_brand_mvp.model.exam.ExamWeekBean;
import com.yd.android_brand_mvp.model.task.TaskVerifyBean;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.StudentCheackActivity;
import com.yd.android_brand_mvp.weight.recycleview.MyGirdItemDecoration;
import com.yyide.facepass.AppExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: ExamArrangementFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u0005\u001c\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u001a\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020#H\u0002J\b\u0010-\u001a\u00020#H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\t\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/yd/android_brand_mvp/activity/exam/fragment/ExamArrangementFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentExamArrangementBinding;", "()V", "courseAdapter", "com/yd/android_brand_mvp/activity/exam/fragment/ExamArrangementFragment$courseAdapter$2$1", "getCourseAdapter", "()Lcom/yd/android_brand_mvp/activity/exam/fragment/ExamArrangementFragment$courseAdapter$2$1;", "courseAdapter$delegate", "Lkotlin/Lazy;", "isPortrait", "", "jumpActivityWithResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "sourceTimeFormat", "", "targetTimeFormat", "viewModel", "Lcom/yd/android_brand_mvp/activity/exam/viewmodel/ExamArrangeViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/exam/viewmodel/ExamArrangeViewModel;", "viewModel$delegate", "week7", "", "[Ljava/lang/String;", "weekAdapter", "com/yd/android_brand_mvp/activity/exam/fragment/ExamArrangementFragment$weekAdapter$2$1", "getWeekAdapter", "()Lcom/yd/android_brand_mvp/activity/exam/fragment/ExamArrangementFragment$weekAdapter$2$1;", "weekAdapter$delegate", "getHighLightIndex", "", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "parserLastActivityData", "result", "Landroidx/activity/result/ActivityResult;", "request", "setHighLightItem", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExamArrangementFragment extends KTBaseFragment<FragmentExamArrangementBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: courseAdapter$delegate, reason: from kotlin metadata */
    private final Lazy courseAdapter;
    private boolean isPortrait;
    private final ActivityResultLauncher<Intent> jumpActivityWithResult;
    private final String sourceTimeFormat;
    private final String targetTimeFormat;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final String[] week7;

    /* JADX INFO: renamed from: weekAdapter$delegate, reason: from kotlin metadata */
    private final Lazy weekAdapter;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.exam.fragment.ExamArrangementFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExamArrangementFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentExamArrangementBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentExamArrangementBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentExamArrangementBinding;", 0);
        }

        public final FragmentExamArrangementBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentExamArrangementBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentExamArrangementBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentExamArrangementBinding access$getBinding(ExamArrangementFragment examArrangementFragment) {
        return examArrangementFragment.getBinding();
    }

    public ExamArrangementFragment() {
        super(AnonymousClass1.INSTANCE);
        this.week7 = new String[]{"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        final ExamArrangementFragment examArrangementFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamArrangementFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return examArrangementFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamArrangementFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(examArrangementFragment, Reflection.getOrCreateKotlinClass(ExamArrangeViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamArrangementFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamArrangementFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamArrangementFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = examArrangementFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.-$$Lambda$ExamArrangementFragment$DSw36dOwI3uTYANa0CjWKTLucSA
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ExamArrangementFragment.jumpActivityWithResult$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…ityData(result)\n        }");
        this.jumpActivityWithResult = activityResultLauncherRegisterForActivityResult;
        this.weekAdapter = LazyKt.lazy(new Function0<ExamArrangementFragment$weekAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamArrangementFragment$weekAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.activity.exam.fragment.ExamArrangementFragment$weekAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final ExamArrangementFragment examArrangementFragment2 = this.this$0;
                return new BaseBindingAdapter<ItemExamArranement44WeekBinding, ExamWeekBean>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamArrangementFragment$weekAdapter$2.1
                    {
                        super(null, 1, null);
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, ExamWeekBean examWeekBean) {
                        convertPlus2((VBViewHolder<ItemExamArranement44WeekBinding>) vBViewHolder, examWeekBean);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemExamArranement44WeekBinding> holder, ExamWeekBean item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemExamArranement44WeekBinding itemExamArranement44WeekBinding = (ItemExamArranement44WeekBinding) holder.getBinding();
                        if (itemExamArranement44WeekBinding != null) {
                            ExamArrangementFragment examArrangementFragment3 = examArrangementFragment2;
                            itemExamArranement44WeekBinding.tvItemExamArrangement44WeekName.setTextSize(SizeUtils.dp2px(20.0f));
                            itemExamArranement44WeekBinding.tvItemExamArrangement44WeekTime.setTextSize(SizeUtils.dp2px(16.0f));
                            itemExamArranement44WeekBinding.tvItemExamArrangement44WeekName.setText(examArrangementFragment3.week7[item.getWeekIndex()]);
                            itemExamArranement44WeekBinding.tvItemExamArrangement44WeekTime.setText(item.getTime());
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemExamArranement44WeekBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemExamArranement44WeekBinding itemExamArranement44WeekBindingInflate = ItemExamArranement44WeekBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemExamArranement44WeekBindingInflate, "inflate(inflater, parent, false)");
                        return itemExamArranement44WeekBindingInflate;
                    }
                };
            }
        });
        this.sourceTimeFormat = "yyyy-MM-dd HH:mm:ss";
        this.targetTimeFormat = "HH:mm";
        this.courseAdapter = LazyKt.lazy(new Function0<ExamArrangementFragment$courseAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamArrangementFragment$courseAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.activity.exam.fragment.ExamArrangementFragment$courseAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final ExamArrangementFragment examArrangementFragment2 = this.this$0;
                return new BaseBindingAdapter<ItemExamArrangementCourseBinding, ExamPlanItem>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamArrangementFragment$courseAdapter$2.1
                    {
                        super(null, 1, null);
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, ExamPlanItem examPlanItem) {
                        convertPlus2((VBViewHolder<ItemExamArrangementCourseBinding>) vBViewHolder, examPlanItem);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemExamArrangementCourseBinding> holder, ExamPlanItem item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemExamArrangementCourseBinding itemExamArrangementCourseBinding = (ItemExamArrangementCourseBinding) holder.getBinding();
                        if (itemExamArrangementCourseBinding != null) {
                            ExamArrangementFragment examArrangementFragment3 = examArrangementFragment2;
                            if (item.isSelect()) {
                                int adapterPosition = holder.getAdapterPosition();
                                if (adapterPosition == CollectionsKt.getLastIndex(getData())) {
                                    itemExamArrangementCourseBinding.clItemExamArrangementCourse.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_right_bottom_r20));
                                } else if (adapterPosition == CollectionsKt.getLastIndex(getData()) - 6) {
                                    itemExamArrangementCourseBinding.clItemExamArrangementCourse.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_left_bottom_r20));
                                } else {
                                    itemExamArrangementCourseBinding.clItemExamArrangementCourse.setBackgroundColor(SimpleUtilsKt.asColor(R.color.co_e9));
                                }
                                itemExamArrangementCourseBinding.tvItemExamArrangementCourseName.setTextColor(SimpleUtilsKt.asColor(R.color.purple2));
                                itemExamArrangementCourseBinding.tvItemExamArrangementCourseClass.setTextColor(SimpleUtilsKt.asColor(R.color.purple2));
                                itemExamArrangementCourseBinding.tvItemExamArrangementCourseTime.setTextColor(SimpleUtilsKt.asColor(R.color.purple2));
                            } else {
                                itemExamArrangementCourseBinding.clItemExamArrangementCourse.setBackgroundColor(SimpleUtilsKt.asColor(R.color.transparent));
                                itemExamArrangementCourseBinding.tvItemExamArrangementCourseName.setTextColor(SimpleUtilsKt.asColor(R.color.black13));
                                itemExamArrangementCourseBinding.tvItemExamArrangementCourseClass.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
                                itemExamArrangementCourseBinding.tvItemExamArrangementCourseTime.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
                            }
                            itemExamArrangementCourseBinding.tvItemExamArrangementCourseName.setText(item.getSubjectName());
                            if (!item.getGroup().isEmpty()) {
                                itemExamArrangementCourseBinding.tvItemExamArrangementCourseClass.setText(((ExamGroupItem) CollectionsKt.first((List) item.getGroup())).getObjectName());
                            } else {
                                itemExamArrangementCourseBinding.tvItemExamArrangementCourseClass.setText("");
                            }
                            String str = TimeUtil.formatTime(item.getExamStartTime(), examArrangementFragment3.sourceTimeFormat, examArrangementFragment3.targetTimeFormat) + '-' + TimeUtil.formatTime(item.getExamEndTime(), examArrangementFragment3.sourceTimeFormat, examArrangementFragment3.targetTimeFormat);
                            if (Intrinsics.areEqual(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                                itemExamArrangementCourseBinding.tvItemExamArrangementCourseTime.setText("");
                            } else {
                                itemExamArrangementCourseBinding.tvItemExamArrangementCourseTime.setText(str);
                            }
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemExamArrangementCourseBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemExamArrangementCourseBinding itemExamArrangementCourseBindingInflate = ItemExamArrangementCourseBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemExamArrangementCourseBindingInflate, "inflate(inflater, parent, false)");
                        return itemExamArrangementCourseBindingInflate;
                    }
                };
            }
        });
    }

    /* JADX INFO: compiled from: ExamArrangementFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/exam/fragment/ExamArrangementFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "isPortrait", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Fragment newInstance$default(Companion companion, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.newInstance(z);
        }

        public final Fragment newInstance(boolean isPortrait) {
            ExamArrangementFragment examArrangementFragment = new ExamArrangementFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isPortrait", isPortrait);
            examArrangementFragment.setArguments(bundle);
            return examArrangementFragment;
        }
    }

    private final ExamArrangeViewModel getViewModel() {
        return (ExamArrangeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jumpActivityWithResult$lambda$0(ExamArrangementFragment this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        this$0.parserLastActivityData(result);
    }

    private final void parserLastActivityData(ActivityResult result) {
        Intent data;
        TaskVerifyBean taskVerifyBean;
        Object next;
        if (result.getResultCode() != -1 || (data = result.getData()) == null) {
            return;
        }
        String stringExtra = data.getStringExtra(ResultCodeStr.NORMAL_TYPE_CODE);
        if (stringExtra == null) {
            stringExtra = "";
        }
        Intrinsics.checkNotNullExpressionValue(stringExtra, "resultData.getStringExtr…r.NORMAL_TYPE_CODE) ?: \"\"");
        if ((stringExtra.length() == 0) || !Intrinsics.areEqual(stringExtra, ResultCodeStr.TASK_SIGN_VERIFY) || (taskVerifyBean = (TaskVerifyBean) data.getParcelableExtra(ResultCodeStr.TASK_SIGN_VERIFY_SUCCESS)) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(taskVerifyBean, "resultData.getParcelable…                ?: return");
        AppExtKt.logd(this, "验证成功");
        Iterator<T> it2 = getCourseAdapter().getData().iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (!((ExamPlanItem) next).isSelect());
        ExamPlanItem examPlanItem = (ExamPlanItem) next;
        if (examPlanItem == null) {
            return;
        }
        getViewModel().signInExam(taskVerifyBean.getUserId(), examPlanItem.getSiteId(), examPlanItem.getSubjectId(), examPlanItem.getExaminationId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExamArrangementFragment$weekAdapter$2.AnonymousClass1 getWeekAdapter() {
        return (ExamArrangementFragment$weekAdapter$2.AnonymousClass1) this.weekAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExamArrangementFragment$courseAdapter$2.AnonymousClass1 getCourseAdapter() {
        return (ExamArrangementFragment$courseAdapter$2.AnonymousClass1) this.courseAdapter.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        this.isPortrait = arguments != null ? arguments.getBoolean("isPortrait") : false;
        initView();
        request();
    }

    private final void initView() {
        getBinding().rvFragmentExamArrangementWeek.setLayoutManager(new GridLayoutManager(requireContext(), 7));
        getBinding().rvFragmentExamArrangementWeek.setAdapter(getWeekAdapter());
        getBinding().rvFragmentExamArrangementCourse.setLayoutManager(new GridLayoutManager(requireContext(), 7));
        getBinding().rvFragmentExamArrangementCourse.setAdapter(getCourseAdapter());
        getBinding().rvFragmentExamArrangementCourse.addItemDecoration(new MyGirdItemDecoration(requireContext(), SimpleUtilsKt.asColor(R.color.black21), SizeUtils.dp2px(1.0f)));
        getCourseAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.-$$Lambda$ExamArrangementFragment$TaZf_DZn8F2aQrAlFmR4n37TXG4
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ExamArrangementFragment.initView$lambda$3(this.f$0, baseQuickAdapter, view, i);
            }
        });
        getBinding().btnFragmentExamSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.-$$Lambda$ExamArrangementFragment$9T_X-ROFFWyVibXnZZAEWbZofS8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamArrangementFragment.initView$lambda$6(this.f$0, view);
            }
        });
        LiveData<Result<List<ExamArrangementBean>>> weekExam = getViewModel().getWeekExam();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends List<? extends ExamArrangementBean>>, Unit> function1 = new Function1<Result<? extends List<? extends ExamArrangementBean>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamArrangementFragment.initView.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<? extends ExamArrangementBean>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<? extends ExamArrangementBean>> it2) {
                ExamArrangementFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                List list = (List) value;
                List list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                List<ExamArrangementBean> list3 = list;
                int size = 0;
                for (ExamArrangementBean examArrangementBean : list3) {
                    String time = TimeUtil.formatTime(examArrangementBean.getDateTime(), TimeUtil.dateYMDFormat, TimeUtil.chDateMDFormat);
                    Intrinsics.checkNotNullExpressionValue(time, "time");
                    arrayList.add(new ExamWeekBean(time, examArrangementBean.getWeekDay() - 1));
                    if (examArrangementBean.getExamPlan().size() > size) {
                        size = examArrangementBean.getExamPlan().size();
                    }
                }
                if (size == 0) {
                    ExamArrangementFragment.this.getWeekAdapter().setList(arrayList);
                    Button button = ExamArrangementFragment.access$getBinding(ExamArrangementFragment.this).btnFragmentExamSign;
                    Intrinsics.checkNotNullExpressionValue(button, "binding.btnFragmentExamSign");
                    SimpleUtilsKt.remove(button);
                    ViewStub viewStub = ExamArrangementFragment.access$getBinding(ExamArrangementFragment.this).emptyView;
                    Intrinsics.checkNotNullExpressionValue(viewStub, "binding.emptyView");
                    viewStub.setVisibility(0);
                    return;
                }
                ViewStub viewStub2 = ExamArrangementFragment.access$getBinding(ExamArrangementFragment.this).emptyView;
                Intrinsics.checkNotNullExpressionValue(viewStub2, "binding.emptyView");
                viewStub2.setVisibility(8);
                Button button2 = ExamArrangementFragment.access$getBinding(ExamArrangementFragment.this).btnFragmentExamSign;
                Intrinsics.checkNotNullExpressionValue(button2, "binding.btnFragmentExamSign");
                SimpleUtilsKt.show(button2);
                int i = size * 7;
                ArrayList arrayList2 = new ArrayList(i);
                for (int i2 = 0; i2 < i; i2++) {
                    arrayList2.add(new ExamPlanItem(null, null, 0, null, 0, null, 0, null, 0, null, false, false, null, 0, null, 0, null, null, null, null, 0, 0, 0, false, 16777215, null));
                }
                ArrayList arrayList3 = arrayList2;
                int i3 = 0;
                for (Object obj : list3) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ExamArrangementBean examArrangementBean2 = (ExamArrangementBean) obj;
                    int i5 = 0;
                    for (Object obj2 : examArrangementBean2.getExamPlan()) {
                        int i6 = i5 + 1;
                        if (i5 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ExamPlanItem examPlanItem = (ExamPlanItem) obj2;
                        examPlanItem.setWeekDay(examArrangementBean2.getWeekDay());
                        arrayList3.set((i5 * 7) + i3, examPlanItem);
                        i5 = i6;
                    }
                    i3 = i4;
                }
                ExamArrangementFragment.this.getWeekAdapter().setList(arrayList);
                ExamArrangementFragment.this.getCourseAdapter().setList(arrayList3);
                ExamArrangementFragment.this.setHighLightItem();
            }
        };
        weekExam.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.-$$Lambda$ExamArrangementFragment$gJZdS6iQyRSpUJfI9EqD4tsbKus
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamArrangementFragment.initView$lambda$7(function1, obj);
            }
        });
        LiveData<Result<Boolean>> signInExam = getViewModel().getSignInExam();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends Boolean>, Unit> function2 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamArrangementFragment.initView.4
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
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                Boolean bool = (Boolean) value;
                if (bool == null || !bool.booleanValue()) {
                    return;
                }
                ToastUtil.showBottomView((Activity) ExamArrangementFragment.this.requireActivity(), "签到成功");
                MinaEventManager.getInstance().notifyObserver(MinaConstants.CODE_EXAM);
            }
        };
        signInExam.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.-$$Lambda$ExamArrangementFragment$L6y_Kja5tU1wMGf5XD4LiYQRvAQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamArrangementFragment.initView$lambda$8(function2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(ExamArrangementFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        ExamPlanItem examPlanItem = this$0.getCourseAdapter().getData().get(i);
        if (Intrinsics.areEqual(examPlanItem.getExaminationId(), "")) {
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            String string = this$0.getString(R.string.not_exam_arrangement);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.not_exam_arrangement)");
            SimpleUtilsKt.showLongToast(contextRequireContext, string);
            return;
        }
        ExamArrangementDetailActivity.Companion companion = ExamArrangementDetailActivity.INSTANCE;
        Context contextRequireContext2 = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        companion.startGo(contextRequireContext2, this$0.isPortrait, examPlanItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(ExamArrangementFragment this$0, View view) {
        Object next;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getCourseAdapter().getData().isEmpty()) {
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            SimpleUtilsKt.showLongToast(contextRequireContext, "没有考试安排");
            return;
        }
        Iterator<T> it2 = this$0.getCourseAdapter().getData().iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (!((ExamPlanItem) next).isSelect());
        ExamPlanItem examPlanItem = (ExamPlanItem) next;
        if (examPlanItem != null) {
            if (examPlanItem.getSignIn()) {
                StudentCheackActivity.startGo(this$0.requireContext(), this$0.jumpActivityWithResult);
                return;
            }
            Context contextRequireContext2 = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            String string = this$0.getString(R.string.not_need_sign_in);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.not_need_sign_in)");
            SimpleUtilsKt.showShotToast(contextRequireContext2, string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final int getHighLightIndex() {
        int i = -1;
        int i2 = 0;
        for (Object obj : getCourseAdapter().getData()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ExamPlanItem examPlanItem = (ExamPlanItem) obj;
            if ((examPlanItem.getExamStartTime().length() > 0) && DateUtils.isTiming(examPlanItem.getExamStartTime(), examPlanItem.getExamEndTime(), examPlanItem.getStartMinute(), examPlanItem.getEndMinute())) {
                i = i2;
            }
            i2 = i3;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHighLightItem() {
        int highLightIndex = getHighLightIndex();
        Iterator<T> it2 = getCourseAdapter().getData().iterator();
        while (it2.hasNext()) {
            ((ExamPlanItem) it2.next()).setSelect(false);
        }
        if (highLightIndex == -1) {
            getCourseAdapter().notifyDataSetChanged();
        } else {
            getCourseAdapter().getData().get(highLightIndex).setSelect(true);
            getCourseAdapter().notifyDataSetChanged();
        }
    }

    private final void request() {
        showProgressDialog();
        getViewModel().m214getWeekExam();
    }
}
