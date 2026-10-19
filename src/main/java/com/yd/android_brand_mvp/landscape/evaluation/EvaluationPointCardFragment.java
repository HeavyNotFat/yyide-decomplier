package com.yd.android_brand_mvp.landscape.evaluation;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.utils.LunarCalendar;
import com.bigkoo.pickerview.view.TimePickerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentEvaluationPointCardBinding;
import com.yd.android_brand_mvp.dialog.evaluation.EvaluationPointDetailDialog;
import com.yd.android_brand_mvp.model.evaluation.EvaluationPointCardBean;
import com.yd.android_brand_mvp.model.evaluation.EvaluationPointCardCancelBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.TransUtils;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvaluationPointCardFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0007\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationPointCardFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentEvaluationPointCardBinding;", "()V", "currentClickType", "", "mAdapter", "com/yd/android_brand_mvp/landscape/evaluation/EvaluationPointCardFragment$mAdapter$1", "Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationPointCardFragment$mAdapter$1;", "pageNo", "pageSize", "personId", "", "timeView", "Lcom/bigkoo/pickerview/view/TimePickerView;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationViewModel;", "initLoadMore", "", "initView", "initViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EvaluationPointCardFragment extends KTBaseFragment<FragmentEvaluationPointCardBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PARAMS_ID = "id";
    private int currentClickType;
    private final EvaluationPointCardFragment$mAdapter$1 mAdapter;
    private int pageNo;
    private final int pageSize;
    private String personId;
    private TimePickerView timeView;
    private EvaluationViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.evaluation.EvaluationPointCardFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: EvaluationPointCardFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentEvaluationPointCardBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentEvaluationPointCardBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentEvaluationPointCardBinding;", 0);
        }

        public final FragmentEvaluationPointCardBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentEvaluationPointCardBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentEvaluationPointCardBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public EvaluationPointCardFragment() {
        super(AnonymousClass1.INSTANCE);
        this.pageSize = 24;
        this.pageNo = 1;
        this.personId = "";
        this.mAdapter = new EvaluationPointCardFragment$mAdapter$1();
    }

    public static final /* synthetic */ FragmentEvaluationPointCardBinding access$getBinding(EvaluationPointCardFragment evaluationPointCardFragment) {
        return evaluationPointCardFragment.getBinding();
    }

    /* JADX INFO: compiled from: EvaluationPointCardFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationPointCardFragment$Companion;", "", "()V", "PARAMS_ID", "", "newInstance", "Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationPointCardFragment;", "id", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EvaluationPointCardFragment newInstance(String id) {
            EvaluationPointCardFragment evaluationPointCardFragment = new EvaluationPointCardFragment();
            Bundle bundle = new Bundle();
            bundle.putString(EvaluationPointCardFragment.PARAMS_ID, id);
            evaluationPointCardFragment.setArguments(bundle);
            return evaluationPointCardFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (EvaluationViewModel) new ViewModelProvider(this).get(EvaluationViewModel.class);
        Bundle arguments = getArguments();
        EvaluationViewModel evaluationViewModel = null;
        String string = arguments != null ? arguments.getString(PARAMS_ID) : null;
        if (string == null) {
            string = "";
        }
        this.personId = string;
        initView();
        initLoadMore();
        initViewModel();
        EvaluationViewModel evaluationViewModel2 = this.viewModel;
        if (evaluationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            evaluationViewModel = evaluationViewModel2;
        }
        evaluationViewModel.getEvaluationPointCardDetails(this.personId);
    }

    private final void initView() {
        getBinding().recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        this.mAdapter.setEmptyView(R.layout.item_null_layout_4);
        this.mAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointCardFragment$StaMsF6eQGtyBa658c0PExhei5U
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                EvaluationPointCardFragment.initView$lambda$0(this.f$0, baseQuickAdapter, view, i);
            }
        });
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.set(LunarCalendar.MIN_YEAR, 0, 1);
        calendar2.set(2119, 11, 31);
        final String str = "yyyy-MM-dd";
        this.timeView = new TimePickerBuilder(requireContext(), new OnTimeSelectListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointCardFragment$tMR1ObibfolHgEceZBLu1NvMI3o
            @Override // com.bigkoo.pickerview.listener.OnTimeSelectListener
            public final void onTimeSelect(Date date, View view) {
                EvaluationPointCardFragment.initView$lambda$1(this.f$0, str, date, view);
            }
        }).setDate(Calendar.getInstance()).setType(TransUtils.INSTANCE.getShowTimeTypeArray("YYYY-MM-DD")).setRangDate(calendar, calendar2).setTextColorCenter(getResources().getColor(R.color.purple2)).setDividerColor(getResources().getColor(R.color.purple2)).setLabel("年", "月", "日", "时", "分", "秒").setLayoutRes(R.layout.time_select, new CustomListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointCardFragment$5ivclPVw4152c-vGcTq5Cy3MgbY
            @Override // com.bigkoo.pickerview.listener.CustomListener
            public final void customLayout(View view) {
                EvaluationPointCardFragment.initView$lambda$4(this.f$0, view);
            }
        }).isCenterLabel(false).isDialog(true).build();
        getBinding().tvStartTime.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointCardFragment$Ofe6fA9sRh8LD73Y4rWEpl9PPVA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EvaluationPointCardFragment.initView$lambda$5(this.f$0, view);
            }
        });
        getBinding().tvEndTime.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointCardFragment$3aP9rOwaK5D21bPwjQkjt9AtHSU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EvaluationPointCardFragment.initView$lambda$6(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(EvaluationPointCardFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        new EvaluationPointDetailDialog(this$0.mAdapter.getItem(i)).show(this$0.getParentFragmentManager(), "EvaluationPointDetailDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(EvaluationPointCardFragment this$0, String timeFormat, Date date, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(timeFormat, "$timeFormat");
        Intrinsics.checkNotNullParameter(date, "date");
        Calendar.getInstance().setTime(date);
        int i = this$0.currentClickType;
        if (i == 0) {
            this$0.getBinding().tvStartTime.setText(DateUtils.getDate(date, timeFormat));
        } else if (i == 1) {
            this$0.getBinding().tvEndTime.setText(DateUtils.getDate(date, timeFormat));
        }
        this$0.pageNo = 1;
        this$0.request();
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(final EvaluationPointCardFragment this$0, View v) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v, "v");
        Button button = (Button) v.findViewById(R.id.btnCancel);
        Button button2 = (Button) v.findViewById(R.id.btnSubmit);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointCardFragment$XxSyNqVAAmoYgvyF5PYWugMOoWg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EvaluationPointCardFragment.initView$lambda$4$lambda$2(this.f$0, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointCardFragment$jkEYHOzHkKAX43ljJ0FzKtq-ho8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EvaluationPointCardFragment.initView$lambda$4$lambda$3(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$2(EvaluationPointCardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$3(EvaluationPointCardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.returnData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(EvaluationPointCardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentClickType = 0;
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(EvaluationPointCardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentClickType = 1;
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.show();
        }
    }

    private final void initLoadMore() {
        this.mAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointCardFragment$_UfTe9mmtuhwf-rxJMQeeHuBMg8
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                EvaluationPointCardFragment.initLoadMore$lambda$7(this.f$0);
            }
        });
        this.mAdapter.getLoadMoreModule().setAutoLoadMore(true);
        this.mAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLoadMore$lambda$7(EvaluationPointCardFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAdapter.getLoadMoreModule().setEnableLoadMore(true);
        this$0.pageNo++;
        this$0.request();
    }

    private final void request() {
        String str;
        String str2;
        String string = getBinding().tvStartTime.getText().toString();
        String string2 = getBinding().tvEndTime.getText().toString();
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            str = "";
            str2 = str;
        } else {
            str = string;
            str2 = string2;
        }
        EvaluationViewModel evaluationViewModel = this.viewModel;
        if (evaluationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            evaluationViewModel = null;
        }
        evaluationViewModel.getEvaluationPointCardPageList(this.pageNo, this.pageSize, this.personId, str, str2);
    }

    private final void initViewModel() {
        EvaluationViewModel evaluationViewModel = this.viewModel;
        EvaluationViewModel evaluationViewModel2 = null;
        if (evaluationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            evaluationViewModel = null;
        }
        MutableLiveData<Result<BasePageResponse<List<EvaluationPointCardBean>>>> evaluationPointCard = evaluationViewModel.getEvaluationPointCard();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends BasePageResponse<List<EvaluationPointCardBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<EvaluationPointCardBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.evaluation.EvaluationPointCardFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<EvaluationPointCardBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<EvaluationPointCardBean>>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    BasePageResponse basePageResponse = (BasePageResponse) value;
                    if (basePageResponse != null) {
                        EvaluationPointCardFragment evaluationPointCardFragment = EvaluationPointCardFragment.this;
                        if (evaluationPointCardFragment.pageNo == 1) {
                            evaluationPointCardFragment.mAdapter.setList((Collection) basePageResponse.getList());
                        } else {
                            List list = (List) basePageResponse.getList();
                            if (list != null) {
                                evaluationPointCardFragment.mAdapter.addData((Collection) list);
                            }
                        }
                        if (basePageResponse.getList() == null || ((List) basePageResponse.getList()).size() >= evaluationPointCardFragment.pageSize) {
                            evaluationPointCardFragment.mAdapter.getLoadMoreModule().loadMoreComplete();
                            return;
                        } else {
                            BaseLoadMoreModule.loadMoreEnd$default(evaluationPointCardFragment.mAdapter.getLoadMoreModule(), false, 1, null);
                            return;
                        }
                    }
                    return;
                }
                Result.m594exceptionOrNullimpl(it2.getValue());
            }
        };
        evaluationPointCard.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointCardFragment$sKI6uPS2WN-qEndV8aw9rSBch8k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EvaluationPointCardFragment.initViewModel$lambda$8(function1, obj);
            }
        });
        EvaluationViewModel evaluationViewModel3 = this.viewModel;
        if (evaluationViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            evaluationViewModel2 = evaluationViewModel3;
        }
        MutableLiveData<Result<EvaluationPointCardCancelBean>> evaluationPointCardDetails = evaluationViewModel2.getEvaluationPointCardDetails();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends EvaluationPointCardCancelBean>, Unit> function2 = new Function1<Result<? extends EvaluationPointCardCancelBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.evaluation.EvaluationPointCardFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends EvaluationPointCardCancelBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends EvaluationPointCardCancelBean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    EvaluationPointCardCancelBean evaluationPointCardCancelBean = (EvaluationPointCardCancelBean) value;
                    if (evaluationPointCardCancelBean != null) {
                        EvaluationPointCardFragment evaluationPointCardFragment = EvaluationPointCardFragment.this;
                        EvaluationPointCardFragment.access$getBinding(evaluationPointCardFragment).tvPointCard.setText(evaluationPointCardCancelBean.getCountWriteOffCard());
                        EvaluationPointCardFragment.access$getBinding(evaluationPointCardFragment).tvCancelPoint.setText(evaluationPointCardCancelBean.getCountWriteOffScore());
                    }
                }
            }
        };
        evaluationPointCardDetails.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointCardFragment$osrVG2ZL7MpOdTAr3XbhvPJrfvU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EvaluationPointCardFragment.initViewModel$lambda$9(function2, obj);
            }
        });
        request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
