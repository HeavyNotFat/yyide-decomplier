package com.yd.android_brand_mvp.activity.exam.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.exam.viewmodel.ExamArrangeViewModel;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentExamSeatDetailBinding;
import com.yd.android_brand_mvp.databinding.ItemExamArrangement66SeatBinding;
import com.yd.android_brand_mvp.model.exam.ExamGroupItem;
import com.yd.android_brand_mvp.model.exam.ExamPersonSeatBean;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
import com.yd.android_brand_mvp.utils.OrderUtils;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
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

/* JADX INFO: compiled from: ExamSeatDetailFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/activity/exam/fragment/ExamSeatDetailFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentExamSeatDetailBinding;", "()V", "dataBean", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "seatAdapter", "com/yd/android_brand_mvp/activity/exam/fragment/ExamSeatDetailFragment$seatAdapter$2$1", "getSeatAdapter", "()Lcom/yd/android_brand_mvp/activity/exam/fragment/ExamSeatDetailFragment$seatAdapter$2$1;", "seatAdapter$delegate", "Lkotlin/Lazy;", "seatCell", "", "seatRow", "spanCount", "viewModel", "Lcom/yd/android_brand_mvp/activity/exam/viewmodel/ExamArrangeViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/exam/viewmodel/ExamArrangeViewModel;", "viewModel$delegate", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExamSeatDetailFragment extends KTBaseFragment<FragmentExamSeatDetailBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ExamPlanItem dataBean;

    /* JADX INFO: renamed from: seatAdapter$delegate, reason: from kotlin metadata */
    private final Lazy seatAdapter;
    private int seatCell;
    private int seatRow;
    private int spanCount;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.exam.fragment.ExamSeatDetailFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExamSeatDetailFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentExamSeatDetailBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentExamSeatDetailBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentExamSeatDetailBinding;", 0);
        }

        public final FragmentExamSeatDetailBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentExamSeatDetailBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentExamSeatDetailBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public ExamSeatDetailFragment() {
        super(AnonymousClass1.INSTANCE);
        this.spanCount = 5;
        this.seatRow = 1;
        this.seatCell = 4;
        final ExamSeatDetailFragment examSeatDetailFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamSeatDetailFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return examSeatDetailFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamSeatDetailFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(examSeatDetailFragment, Reflection.getOrCreateKotlinClass(ExamArrangeViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamSeatDetailFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamSeatDetailFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamSeatDetailFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = examSeatDetailFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.seatAdapter = LazyKt.lazy(new Function0<ExamSeatDetailFragment$seatAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamSeatDetailFragment$seatAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.activity.exam.fragment.ExamSeatDetailFragment$seatAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new BaseBindingAdapter<ItemExamArrangement66SeatBinding, ExamPersonSeatBean>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamSeatDetailFragment$seatAdapter$2.1
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
                            String.valueOf(holder.getAdapterPosition() + 1);
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
    }

    /* JADX INFO: compiled from: ExamSeatDetailFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/exam/fragment/ExamSeatDetailFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "data", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(ExamPlanItem data) {
            Intrinsics.checkNotNullParameter(data, "data");
            ExamSeatDetailFragment examSeatDetailFragment = new ExamSeatDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("data", data);
            examSeatDetailFragment.setArguments(bundle);
            return examSeatDetailFragment;
        }
    }

    private final ExamArrangeViewModel getViewModel() {
        return (ExamArrangeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExamSeatDetailFragment$seatAdapter$2.AnonymousClass1 getSeatAdapter() {
        return (ExamSeatDetailFragment$seatAdapter$2.AnonymousClass1) this.seatAdapter.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
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
        if (((ExamGroupItem) CollectionsKt.first((List) examPlanItem3.getGroup())).getExaminationArrange() == 2) {
            this.seatCell = this.spanCount;
            ExamPlanItem examPlanItem4 = this.dataBean;
            if (examPlanItem4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBean");
                examPlanItem4 = null;
            }
            int examinationPersonCount = examPlanItem4.getExaminationPersonCount();
            int i = this.seatCell;
            int i2 = examinationPersonCount / i;
            int i3 = i * i2;
            ExamPlanItem examPlanItem5 = this.dataBean;
            if (examPlanItem5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            } else {
                examPlanItem = examPlanItem5;
            }
            if (i3 < examPlanItem.getExaminationPersonCount()) {
                i2++;
            }
            this.seatRow = i2;
        } else {
            ExamPlanItem examPlanItem6 = this.dataBean;
            if (examPlanItem6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBean");
                examPlanItem6 = null;
            }
            this.seatRow = examPlanItem6.getRow();
            ExamPlanItem examPlanItem7 = this.dataBean;
            if (examPlanItem7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            } else {
                examPlanItem = examPlanItem7;
            }
            int cell = examPlanItem.getCell();
            this.seatCell = cell;
            if (cell != 0) {
                this.spanCount = cell;
            }
        }
        getBinding().rvFragmentExamSeatDetail.setLayoutManager(new GridLayoutManager(requireContext(), this.spanCount));
        getBinding().rvFragmentExamSeatDetail.setAdapter(getSeatAdapter());
        LiveData<Result<List<ExamPersonSeatBean>>> seatInExam = getViewModel().getSeatInExam();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends List<? extends ExamPersonSeatBean>>, Unit> function1 = new Function1<Result<? extends List<? extends ExamPersonSeatBean>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.ExamSeatDetailFragment.onViewCreated.1
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
                ExamPlanItem examPlanItem8;
                ExamSeatDetailFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                List list = (List) value;
                ExamPlanItem examPlanItem9 = ExamSeatDetailFragment.this.dataBean;
                if (examPlanItem9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataBean");
                    examPlanItem9 = null;
                }
                if (((ExamGroupItem) CollectionsKt.first((List) examPlanItem9.getGroup())).getExaminationArrange() == 2) {
                    ExamPlanItem examPlanItem10 = ExamSeatDetailFragment.this.dataBean;
                    if (examPlanItem10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataBean");
                        examPlanItem10 = null;
                    }
                    examinationPersonCount2 = examPlanItem10.getExaminationPersonCount();
                } else {
                    examinationPersonCount2 = ExamSeatDetailFragment.this.seatRow * ExamSeatDetailFragment.this.seatCell;
                }
                if (examinationPersonCount2 == 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList(examinationPersonCount2);
                int i4 = 0;
                for (int i5 = 0; i5 < examinationPersonCount2; i5++) {
                    arrayList.add(new ExamPersonSeatBean(0, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null));
                }
                ArrayList arrayList2 = arrayList;
                if (list != null) {
                    int i6 = 0;
                    for (Object obj : list) {
                        int i7 = i6 + 1;
                        if (i6 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ExamPersonSeatBean examPersonSeatBean = (ExamPersonSeatBean) obj;
                        if (i6 < arrayList2.size()) {
                            arrayList2.set(i6, examPersonSeatBean);
                        }
                        i6 = i7;
                    }
                }
                for (Object obj2 : arrayList2) {
                    int i8 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ((ExamPersonSeatBean) obj2).setSeat(String.valueOf(i8));
                    i4 = i8;
                }
                ExamPlanItem examPlanItem11 = ExamSeatDetailFragment.this.dataBean;
                if (examPlanItem11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataBean");
                    examPlanItem8 = null;
                } else {
                    examPlanItem8 = examPlanItem11;
                }
                int arrangeType = ((ExamGroupItem) CollectionsKt.first((List) examPlanItem8.getGroup())).getArrangeType();
                if (arrangeType == 1) {
                    ExamSeatDetailFragment.this.getSeatAdapter().setList(OrderUtils.INSTANCE.printStudentsInOrder(arrayList2, ExamSeatDetailFragment.this.seatRow, ExamSeatDetailFragment.this.seatCell));
                } else if (arrangeType != 2) {
                    ExamSeatDetailFragment.this.getSeatAdapter().setList(arrayList2);
                } else {
                    ExamSeatDetailFragment.this.getSeatAdapter().setList(OrderUtils.INSTANCE.printStudentsInSShape(arrayList2, ExamSeatDetailFragment.this.seatRow, ExamSeatDetailFragment.this.seatCell));
                }
            }
        };
        seatInExam.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.-$$Lambda$ExamSeatDetailFragment$KcnwEPHsgkX_32godpRKqZAE-WQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamSeatDetailFragment.onViewCreated$lambda$0(function1, obj);
            }
        });
        request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void request() {
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
