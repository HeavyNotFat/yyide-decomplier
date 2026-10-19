package com.yd.android_brand_mvp.activity.exam.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import com.blankj.utilcode.util.ScreenUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.exam.viewmodel.ExamArrangeViewModel;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.base.ResultCodeStr;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentNormalFullScreenExamBinding;
import com.yd.android_brand_mvp.databinding.ItemExamArrangement66SeatBinding;
import com.yd.android_brand_mvp.databinding.ItemExamFullSeatBinding;
import com.yd.android_brand_mvp.databinding.ItemExamFullTeacherBinding;
import com.yd.android_brand_mvp.model.exam.ExamGroupItem;
import com.yd.android_brand_mvp.model.exam.ExamInvigilatorBean;
import com.yd.android_brand_mvp.model.exam.ExamPersonSeatBean;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
import com.yd.android_brand_mvp.model.task.TaskVerifyBean;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.utils.OrderUtils;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.StudentCheackActivity;
import com.yyide.facepass.AppExtKt;
import java.util.ArrayList;
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

/* JADX INFO: compiled from: NormalFullScreenFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0003\u0005\u0013\u001b\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020%H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\t\u001a\u0004\b!\u0010\"¨\u0006/"}, d2 = {"Lcom/yd/android_brand_mvp/activity/exam/fragment/NormalFullScreenFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentNormalFullScreenExamBinding;", "()V", "addNumberSeatAdapter", "com/yd/android_brand_mvp/activity/exam/fragment/NormalFullScreenFragment$addNumberSeatAdapter$2$1", "getAddNumberSeatAdapter", "()Lcom/yd/android_brand_mvp/activity/exam/fragment/NormalFullScreenFragment$addNumberSeatAdapter$2$1;", "addNumberSeatAdapter$delegate", "Lkotlin/Lazy;", "arrangeType", "", "dataBean", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "jumpActivityWithResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "notNumberSeatAdapter", "com/yd/android_brand_mvp/activity/exam/fragment/NormalFullScreenFragment$notNumberSeatAdapter$2$1", "getNotNumberSeatAdapter", "()Lcom/yd/android_brand_mvp/activity/exam/fragment/NormalFullScreenFragment$notNumberSeatAdapter$2$1;", "notNumberSeatAdapter$delegate", "seatCell", "seatRow", "spanCount", "teacherAdapter", "com/yd/android_brand_mvp/activity/exam/fragment/NormalFullScreenFragment$teacherAdapter$2$1", "getTeacherAdapter", "()Lcom/yd/android_brand_mvp/activity/exam/fragment/NormalFullScreenFragment$teacherAdapter$2$1;", "teacherAdapter$delegate", "viewModel", "Lcom/yd/android_brand_mvp/activity/exam/viewmodel/ExamArrangeViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/exam/viewmodel/ExamArrangeViewModel;", "viewModel$delegate", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "parserLastActivityData", "result", "Landroidx/activity/result/ActivityResult;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NormalFullScreenFragment extends KTBaseFragment<FragmentNormalFullScreenExamBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: addNumberSeatAdapter$delegate, reason: from kotlin metadata */
    private final Lazy addNumberSeatAdapter;
    private int arrangeType;
    private ExamPlanItem dataBean;
    private final ActivityResultLauncher<Intent> jumpActivityWithResult;

    /* JADX INFO: renamed from: notNumberSeatAdapter$delegate, reason: from kotlin metadata */
    private final Lazy notNumberSeatAdapter;
    private int seatCell;
    private int seatRow;
    private int spanCount;

    /* JADX INFO: renamed from: teacherAdapter$delegate, reason: from kotlin metadata */
    private final Lazy teacherAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.exam.fragment.NormalFullScreenFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: NormalFullScreenFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentNormalFullScreenExamBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentNormalFullScreenExamBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentNormalFullScreenExamBinding;", 0);
        }

        public final FragmentNormalFullScreenExamBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentNormalFullScreenExamBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentNormalFullScreenExamBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public NormalFullScreenFragment() {
        super(AnonymousClass1.INSTANCE);
        this.spanCount = 5;
        this.seatRow = 1;
        this.seatCell = 4;
        final NormalFullScreenFragment normalFullScreenFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.NormalFullScreenFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return normalFullScreenFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.NormalFullScreenFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(normalFullScreenFragment, Reflection.getOrCreateKotlinClass(ExamArrangeViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.NormalFullScreenFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.NormalFullScreenFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.NormalFullScreenFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = normalFullScreenFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.-$$Lambda$NormalFullScreenFragment$GJYzxhguulaFD4i3h0ptd87uhxc
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                NormalFullScreenFragment.jumpActivityWithResult$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…ityData(result)\n        }");
        this.jumpActivityWithResult = activityResultLauncherRegisterForActivityResult;
        this.notNumberSeatAdapter = LazyKt.lazy(new Function0<NormalFullScreenFragment$notNumberSeatAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.NormalFullScreenFragment$notNumberSeatAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.activity.exam.fragment.NormalFullScreenFragment$notNumberSeatAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new BaseBindingAdapter<ItemExamArrangement66SeatBinding, ExamPersonSeatBean>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.NormalFullScreenFragment$notNumberSeatAdapter$2.1
                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, ExamPersonSeatBean examPersonSeatBean) {
                        convertPlus2((VBViewHolder<ItemExamArrangement66SeatBinding>) vBViewHolder, examPersonSeatBean);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemExamArrangement66SeatBinding> holder, ExamPersonSeatBean item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemExamArrangement66SeatBinding itemExamArrangement66SeatBinding = (ItemExamArrangement66SeatBinding) holder.getBinding();
                        if (itemExamArrangement66SeatBinding != null) {
                            itemExamArrangement66SeatBinding.tvItemExamArrangement66SeatNumber.setText(item.getSeat());
                            itemExamArrangement66SeatBinding.tvItemExamArrangement66Name.setText(item.getPersonName());
                            if (item.getSignInType() == 1) {
                                itemExamArrangement66SeatBinding.tvItemExamArrangement66SeatNumber.setTextColor(SimpleUtilsKt.asColor(R.color.white));
                                itemExamArrangement66SeatBinding.clItemExamArrangementSeatLeft.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_purle_left_r10));
                            } else {
                                itemExamArrangement66SeatBinding.tvItemExamArrangement66SeatNumber.setTextColor(SimpleUtilsKt.asColor(R.color.black10));
                                itemExamArrangement66SeatBinding.clItemExamArrangementSeatLeft.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_e5grey_left_r10));
                            }
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemExamArrangement66SeatBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemExamArrangement66SeatBinding itemExamArrangement66SeatBindingInflate = ItemExamArrangement66SeatBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemExamArrangement66SeatBindingInflate, "inflate(inflater, parent, false)");
                        return itemExamArrangement66SeatBindingInflate;
                    }
                };
            }
        });
        this.addNumberSeatAdapter = LazyKt.lazy(new Function0<NormalFullScreenFragment$addNumberSeatAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.NormalFullScreenFragment$addNumberSeatAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.activity.exam.fragment.NormalFullScreenFragment$addNumberSeatAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new BaseBindingAdapter<ItemExamFullSeatBinding, ExamPersonSeatBean>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.NormalFullScreenFragment$addNumberSeatAdapter$2.1
                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, ExamPersonSeatBean examPersonSeatBean) {
                        convertPlus2((VBViewHolder<ItemExamFullSeatBinding>) vBViewHolder, examPersonSeatBean);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemExamFullSeatBinding> holder, ExamPersonSeatBean item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemExamFullSeatBinding itemExamFullSeatBinding = (ItemExamFullSeatBinding) holder.getBinding();
                        if (itemExamFullSeatBinding != null) {
                            itemExamFullSeatBinding.tvItemExamFullSeatNumber.setText(item.getSeat());
                            itemExamFullSeatBinding.tvItemExamFullName.setText(item.getPersonName());
                            itemExamFullSeatBinding.tvItemExamFullExamineNumber.setText(item.getExamineNumber());
                            if (item.getSignInType() == 1) {
                                itemExamFullSeatBinding.tvItemExamFullSeatNumber.setTextColor(SimpleUtilsKt.asColor(R.color.white));
                                itemExamFullSeatBinding.clItemExamFullSeatLeft.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_purle_left_r10));
                            } else {
                                itemExamFullSeatBinding.tvItemExamFullSeatNumber.setTextColor(SimpleUtilsKt.asColor(R.color.black10));
                                itemExamFullSeatBinding.clItemExamFullSeatLeft.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_e5grey_left_r10));
                            }
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemExamFullSeatBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemExamFullSeatBinding itemExamFullSeatBindingInflate = ItemExamFullSeatBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemExamFullSeatBindingInflate, "inflate(inflater, parent, false)");
                        return itemExamFullSeatBindingInflate;
                    }
                };
            }
        });
        this.teacherAdapter = LazyKt.lazy(new Function0<NormalFullScreenFragment$teacherAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.NormalFullScreenFragment$teacherAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.activity.exam.fragment.NormalFullScreenFragment$teacherAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new BaseBindingAdapter<ItemExamFullTeacherBinding, ExamInvigilatorBean>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.NormalFullScreenFragment$teacherAdapter$2.1
                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, ExamInvigilatorBean examInvigilatorBean) {
                        convertPlus2((VBViewHolder<ItemExamFullTeacherBinding>) vBViewHolder, examInvigilatorBean);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemExamFullTeacherBinding> holder, ExamInvigilatorBean item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemExamFullTeacherBinding itemExamFullTeacherBinding = (ItemExamFullTeacherBinding) holder.getBinding();
                        TextView textView = itemExamFullTeacherBinding != null ? itemExamFullTeacherBinding.tvItemExamFullTeacherName : null;
                        if (textView == null) {
                            return;
                        }
                        textView.setText(item.getPersonName());
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemExamFullTeacherBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemExamFullTeacherBinding itemExamFullTeacherBindingInflate = ItemExamFullTeacherBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemExamFullTeacherBindingInflate, "inflate(inflater, parent, false)");
                        return itemExamFullTeacherBindingInflate;
                    }
                };
            }
        });
    }

    /* JADX INFO: compiled from: NormalFullScreenFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/exam/fragment/NormalFullScreenFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "data", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(ExamPlanItem data) {
            Intrinsics.checkNotNullParameter(data, "data");
            NormalFullScreenFragment normalFullScreenFragment = new NormalFullScreenFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("data", data);
            normalFullScreenFragment.setArguments(bundle);
            return normalFullScreenFragment;
        }
    }

    private final ExamArrangeViewModel getViewModel() {
        return (ExamArrangeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jumpActivityWithResult$lambda$0(NormalFullScreenFragment this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        this$0.parserLastActivityData(result);
    }

    private final void parserLastActivityData(ActivityResult result) {
        Intent data;
        TaskVerifyBean taskVerifyBean;
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
        Intrinsics.checkNotNullExpressionValue(taskVerifyBean, "resultData.getParcelable…VERIFY_SUCCESS) ?: return");
        AppExtKt.logd(this, "验证成功");
        ExamArrangeViewModel viewModel = getViewModel();
        String userId = taskVerifyBean.getUserId();
        ExamPlanItem examPlanItem = this.dataBean;
        ExamPlanItem examPlanItem2 = null;
        if (examPlanItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem = null;
        }
        String siteId = examPlanItem.getSiteId();
        ExamPlanItem examPlanItem3 = this.dataBean;
        if (examPlanItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem3 = null;
        }
        String subjectId = examPlanItem3.getSubjectId();
        ExamPlanItem examPlanItem4 = this.dataBean;
        if (examPlanItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
        } else {
            examPlanItem2 = examPlanItem4;
        }
        viewModel.signInExam(userId, siteId, subjectId, examPlanItem2.getExaminationId());
    }

    private final NormalFullScreenFragment$notNumberSeatAdapter$2.AnonymousClass1 getNotNumberSeatAdapter() {
        return (NormalFullScreenFragment$notNumberSeatAdapter$2.AnonymousClass1) this.notNumberSeatAdapter.getValue();
    }

    private final NormalFullScreenFragment$addNumberSeatAdapter$2.AnonymousClass1 getAddNumberSeatAdapter() {
        return (NormalFullScreenFragment$addNumberSeatAdapter$2.AnonymousClass1) this.addNumberSeatAdapter.getValue();
    }

    private final NormalFullScreenFragment$teacherAdapter$2.AnonymousClass1 getTeacherAdapter() {
        return (NormalFullScreenFragment$teacherAdapter$2.AnonymousClass1) this.teacherAdapter.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        final NormalFullScreenFragment$notNumberSeatAdapter$2.AnonymousClass1 notNumberSeatAdapter;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        ExamPlanItem examPlanItem = null;
        ExamPlanItem examPlanItem2 = arguments != null ? (ExamPlanItem) arguments.getParcelable("data") : null;
        if (examPlanItem2 == null) {
            examPlanItem2 = new ExamPlanItem(null, null, 0, null, 0, null, 0, null, 0, null, false, false, null, 0, null, 0, null, null, null, null, 0, 0, 0, false, 16777215, null);
        }
        this.dataBean = examPlanItem2;
        if (ScreenUtils.isPortrait()) {
            this.spanCount = 3;
        }
        ExamPlanItem examPlanItem3 = this.dataBean;
        if (examPlanItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem3 = null;
        }
        if (!examPlanItem3.getGroup().isEmpty()) {
            ExamPlanItem examPlanItem4 = this.dataBean;
            if (examPlanItem4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBean");
                examPlanItem4 = null;
            }
            this.arrangeType = examPlanItem4.getGroup().get(0).getArrangeType();
        }
        ExamPlanItem examPlanItem5 = this.dataBean;
        if (examPlanItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem5 = null;
        }
        if (((ExamGroupItem) CollectionsKt.first((List) examPlanItem5.getGroup())).getExaminationArrange() == 2) {
            this.seatCell = this.spanCount;
            ExamPlanItem examPlanItem6 = this.dataBean;
            if (examPlanItem6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBean");
                examPlanItem6 = null;
            }
            int examinationPersonCount = examPlanItem6.getExaminationPersonCount();
            int i = this.seatCell;
            int i2 = examinationPersonCount / i;
            int i3 = i * i2;
            ExamPlanItem examPlanItem7 = this.dataBean;
            if (examPlanItem7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBean");
                examPlanItem7 = null;
            }
            if (i3 < examPlanItem7.getExaminationPersonCount()) {
                i2++;
            }
            this.seatRow = i2;
        } else {
            ExamPlanItem examPlanItem8 = this.dataBean;
            if (examPlanItem8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBean");
                examPlanItem8 = null;
            }
            this.seatRow = examPlanItem8.getRow();
            ExamPlanItem examPlanItem9 = this.dataBean;
            if (examPlanItem9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBean");
                examPlanItem9 = null;
            }
            int cell = examPlanItem9.getCell();
            this.seatCell = cell;
            if (cell != 0) {
                this.spanCount = cell;
            }
        }
        getBinding().rvFragmentNormalFullScreenSeat.setLayoutManager(new GridLayoutManager(requireContext(), this.spanCount));
        ExamPlanItem examPlanItem10 = this.dataBean;
        if (examPlanItem10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem10 = null;
        }
        if (examPlanItem10.getShowed()) {
            notNumberSeatAdapter = getAddNumberSeatAdapter();
        } else {
            notNumberSeatAdapter = getNotNumberSeatAdapter();
        }
        getBinding().rvFragmentNormalFullScreenSeat.setAdapter(notNumberSeatAdapter);
        getBinding().rvFragmentNormalFullScreenTeacher.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        getBinding().rvFragmentNormalFullScreenTeacher.setAdapter(getTeacherAdapter());
        NormalFullScreenFragment$teacherAdapter$2.AnonymousClass1 teacherAdapter = getTeacherAdapter();
        ExamPlanItem examPlanItem11 = this.dataBean;
        if (examPlanItem11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem11 = null;
        }
        teacherAdapter.setList(examPlanItem11.getInvigilators());
        StringBuilder sb = new StringBuilder();
        ExamPlanItem examPlanItem12 = this.dataBean;
        if (examPlanItem12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem12 = null;
        }
        sb.append(TimeUtil.formatTime(examPlanItem12.getExamStartTime(), TimeUtil.allTimeFormat, TimeUtil.notSecondFormat));
        sb.append('-');
        ExamPlanItem examPlanItem13 = this.dataBean;
        if (examPlanItem13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem13 = null;
        }
        sb.append(TimeUtil.formatTime(examPlanItem13.getExamEndTime(), TimeUtil.allTimeFormat, TimeUtil.hoursMinuteTimeFormat));
        String string = sb.toString();
        if (Intrinsics.areEqual(string, Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            getBinding().tvFragmentFullExamTime.setText("");
        } else {
            getBinding().tvFragmentFullExamTime.setText(string);
        }
        TextView textView = getBinding().tvFragmentFullExamAddress;
        ExamPlanItem examPlanItem14 = this.dataBean;
        if (examPlanItem14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem14 = null;
        }
        textView.setText(examPlanItem14.getExaminationRoomName());
        ExamPlanItem examPlanItem15 = this.dataBean;
        if (examPlanItem15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem15 = null;
        }
        if (((ExamGroupItem) CollectionsKt.first((List) examPlanItem15.getGroup())).getExaminationArrange() == 2) {
            getBinding().tvFragmentFullExamNumber.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        } else {
            TextView textView2 = getBinding().tvFragmentFullExamNumber;
            StringBuilder sb2 = new StringBuilder();
            ExamPlanItem examPlanItem16 = this.dataBean;
            if (examPlanItem16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBean");
                examPlanItem16 = null;
            }
            sb2.append(examPlanItem16.getExamPeopleNum());
            sb2.append((char) 20154);
            textView2.setText(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder();
        ExamPlanItem examPlanItem17 = this.dataBean;
        if (examPlanItem17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem17 = null;
        }
        sb3.append(examPlanItem17.getSubjectName());
        sb3.append('(');
        ExamPlanItem examPlanItem18 = this.dataBean;
        if (examPlanItem18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem18 = null;
        }
        sb3.append(TimeUtil.formatTime(examPlanItem18.getExamStartTime(), TimeUtil.allTimeFormat, TimeUtil.hoursMinuteTimeFormat));
        sb3.append('-');
        ExamPlanItem examPlanItem19 = this.dataBean;
        if (examPlanItem19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem19 = null;
        }
        sb3.append(TimeUtil.formatTime(examPlanItem19.getExamEndTime(), TimeUtil.allTimeFormat, TimeUtil.hoursMinuteTimeFormat));
        sb3.append(')');
        getBinding().tvFragmentNormalFullScreenCourse.setText(sb3.toString());
        ExamPlanItem examPlanItem20 = this.dataBean;
        if (examPlanItem20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem20 = null;
        }
        if (!examPlanItem20.getGroup().isEmpty()) {
            TextView textView3 = getBinding().tvFragmentFullExamTarget;
            ExamPlanItem examPlanItem21 = this.dataBean;
            if (examPlanItem21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            } else {
                examPlanItem = examPlanItem21;
            }
            textView3.setText(((ExamGroupItem) CollectionsKt.first((List) examPlanItem.getGroup())).getObjectName());
        } else {
            getBinding().tvFragmentFullExamTarget.setText("");
        }
        getBinding().btnFragmentFullExamSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.-$$Lambda$NormalFullScreenFragment$lmzX5RyLhEGvxAmU4EmNuiNAtdY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NormalFullScreenFragment.onViewCreated$lambda$2(this.f$0, view2);
            }
        });
        LiveData<Result<List<ExamPersonSeatBean>>> seatInExam = getViewModel().getSeatInExam();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends List<? extends ExamPersonSeatBean>>, Unit> function1 = new Function1<Result<? extends List<? extends ExamPersonSeatBean>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.NormalFullScreenFragment.onViewCreated.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<? extends ExamPersonSeatBean>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<? extends ExamPersonSeatBean>> it2) {
                int examinationPersonCount2;
                NormalFullScreenFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                ExamPlanItem examPlanItem22 = null;
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                List list = (List) value;
                ExamPlanItem examPlanItem23 = NormalFullScreenFragment.this.dataBean;
                if (examPlanItem23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataBean");
                    examPlanItem23 = null;
                }
                if (((ExamGroupItem) CollectionsKt.first((List) examPlanItem23.getGroup())).getExaminationArrange() == 2) {
                    ExamPlanItem examPlanItem24 = NormalFullScreenFragment.this.dataBean;
                    if (examPlanItem24 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataBean");
                    } else {
                        examPlanItem22 = examPlanItem24;
                    }
                    examinationPersonCount2 = examPlanItem22.getExaminationPersonCount();
                } else {
                    examinationPersonCount2 = NormalFullScreenFragment.this.seatRow * NormalFullScreenFragment.this.seatCell;
                }
                AppExtKt.logd(NormalFullScreenFragment.this, "seat size = " + examinationPersonCount2);
                if (examinationPersonCount2 == 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList(examinationPersonCount2);
                for (int i4 = 0; i4 < examinationPersonCount2; i4++) {
                    arrayList.add(new ExamPersonSeatBean(0, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null));
                }
                ArrayList arrayList2 = arrayList;
                if (list != null) {
                    int i5 = 0;
                    for (Object obj : list) {
                        int i6 = i5 + 1;
                        if (i5 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ExamPersonSeatBean examPersonSeatBean = (ExamPersonSeatBean) obj;
                        if (i5 < arrayList2.size()) {
                            arrayList2.set(i5, examPersonSeatBean);
                        }
                        i5 = i6;
                    }
                }
                int i7 = 0;
                for (Object obj2 : arrayList2) {
                    int i8 = i7 + 1;
                    if (i7 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ((ExamPersonSeatBean) obj2).setSeat(String.valueOf(i8));
                    i7 = i8;
                }
                int i9 = NormalFullScreenFragment.this.arrangeType;
                if (i9 == 1) {
                    notNumberSeatAdapter.setList(OrderUtils.INSTANCE.printStudentsInOrder(arrayList2, NormalFullScreenFragment.this.seatRow, NormalFullScreenFragment.this.seatCell));
                } else if (i9 == 2) {
                    notNumberSeatAdapter.setList(OrderUtils.INSTANCE.printStudentsInSShape(arrayList2, NormalFullScreenFragment.this.seatRow, NormalFullScreenFragment.this.seatCell));
                } else {
                    notNumberSeatAdapter.setList(arrayList2);
                }
            }
        };
        seatInExam.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.-$$Lambda$NormalFullScreenFragment$F_PahGhyH7tiYhHXUQJHcfuh1X4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NormalFullScreenFragment.onViewCreated$lambda$3(function1, obj);
            }
        });
        LiveData<Result<Boolean>> signInExam = getViewModel().getSignInExam();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends Boolean>, Unit> function2 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.NormalFullScreenFragment.onViewCreated.3
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
                ToastUtil.showBottomView((Activity) NormalFullScreenFragment.this.requireActivity(), "签到成功");
                NormalFullScreenFragment.this.request();
                MinaEventManager.getInstance().notifyObserver(MinaConstants.CODE_EXAM);
            }
        };
        signInExam.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.-$$Lambda$NormalFullScreenFragment$tq8rmtkOR2altXdWtpmfYSwI48Y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NormalFullScreenFragment.onViewCreated$lambda$4(function2, obj);
            }
        });
        request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(NormalFullScreenFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ExamPlanItem examPlanItem = this$0.dataBean;
        if (examPlanItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem = null;
        }
        if (examPlanItem.getSignIn()) {
            StudentCheackActivity.startGo(this$0.requireContext(), this$0.jumpActivityWithResult);
            return;
        }
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        String string = this$0.getString(R.string.not_need_sign_in);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.not_need_sign_in)");
        SimpleUtilsKt.showShotToast(contextRequireContext, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void request() {
        showProgressDialog();
        ExamArrangeViewModel viewModel = getViewModel();
        ExamPlanItem examPlanItem = this.dataBean;
        ExamPlanItem examPlanItem2 = null;
        if (examPlanItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem = null;
        }
        String siteId = examPlanItem.getSiteId();
        ExamPlanItem examPlanItem3 = this.dataBean;
        if (examPlanItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem3 = null;
        }
        String subjectId = examPlanItem3.getSubjectId();
        ExamPlanItem examPlanItem4 = this.dataBean;
        if (examPlanItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
        } else {
            examPlanItem2 = examPlanItem4;
        }
        viewModel.getExamSeat(siteId, subjectId, examPlanItem2.getExaminationId());
    }
}
