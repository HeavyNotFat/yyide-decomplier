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
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.utils.LunarCalendar;
import com.bigkoo.pickerview.view.TimePickerView;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentEvaluationPointBinding;
import com.yd.android_brand_mvp.model.evaluation.EvaluationPointBean;
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

/* JADX INFO: compiled from: EvaluationPointFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationPointFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentEvaluationPointBinding;", "()V", "currentClickType", "", "mAdapter", "com/yd/android_brand_mvp/landscape/evaluation/EvaluationPointFragment$mAdapter$1", "Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationPointFragment$mAdapter$1;", "pageNo", "pageSize", "timeView", "Lcom/bigkoo/pickerview/view/TimePickerView;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationViewModel;", "initLoadMore", "", "initView", "initViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EvaluationPointFragment extends KTBaseFragment<FragmentEvaluationPointBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PARAMS_ID = "id";
    private int currentClickType;
    private final EvaluationPointFragment$mAdapter$1 mAdapter;
    private int pageNo;
    private final int pageSize;
    private TimePickerView timeView;
    private EvaluationViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.evaluation.EvaluationPointFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: EvaluationPointFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentEvaluationPointBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentEvaluationPointBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentEvaluationPointBinding;", 0);
        }

        public final FragmentEvaluationPointBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentEvaluationPointBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentEvaluationPointBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public EvaluationPointFragment() {
        super(AnonymousClass1.INSTANCE);
        this.pageSize = 20;
        this.pageNo = 1;
        this.mAdapter = new EvaluationPointFragment$mAdapter$1();
    }

    public static final /* synthetic */ FragmentEvaluationPointBinding access$getBinding(EvaluationPointFragment evaluationPointFragment) {
        return evaluationPointFragment.getBinding();
    }

    /* JADX INFO: compiled from: EvaluationPointFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationPointFragment$Companion;", "", "()V", "PARAMS_ID", "", "newInstance", "Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationPointFragment;", "id", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EvaluationPointFragment newInstance(String id) {
            EvaluationPointFragment evaluationPointFragment = new EvaluationPointFragment();
            Bundle bundle = new Bundle();
            bundle.putString(EvaluationPointFragment.PARAMS_ID, id);
            evaluationPointFragment.setArguments(bundle);
            return evaluationPointFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (EvaluationViewModel) new ViewModelProvider(this).get(EvaluationViewModel.class);
        initView();
        initLoadMore();
        initViewModel();
    }

    private final void initView() {
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        this.mAdapter.setEmptyView(R.layout.item_null_layout_4);
        Bundle arguments = getArguments();
        EvaluationViewModel evaluationViewModel = null;
        String string = arguments != null ? arguments.getString(PARAMS_ID) : null;
        EvaluationViewModel evaluationViewModel2 = this.viewModel;
        if (evaluationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            evaluationViewModel = evaluationViewModel2;
        }
        if (string == null) {
            string = "";
        }
        evaluationViewModel.getEvaluationPointUse(string);
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.set(LunarCalendar.MIN_YEAR, 0, 1);
        calendar2.set(2119, 11, 31);
        final String str = "yyyy-MM-dd";
        this.timeView = new TimePickerBuilder(requireContext(), new OnTimeSelectListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointFragment$xkfWLEnDVBvjAXYrxkzh1TV67NI
            @Override // com.bigkoo.pickerview.listener.OnTimeSelectListener
            public final void onTimeSelect(Date date, View view) {
                EvaluationPointFragment.initView$lambda$0(this.f$0, str, date, view);
            }
        }).setDate(Calendar.getInstance()).setType(TransUtils.INSTANCE.getShowTimeTypeArray("YYYY-MM-DD")).setRangDate(calendar, calendar2).setTextColorCenter(getResources().getColor(R.color.purple2)).setDividerColor(getResources().getColor(R.color.purple2)).setLabel("年", "月", "日", "时", "分", "秒").setLayoutRes(R.layout.time_select, new CustomListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointFragment$cL_WOTYVp2luo7QRcKa6UbwxhJ0
            @Override // com.bigkoo.pickerview.listener.CustomListener
            public final void customLayout(View view) {
                EvaluationPointFragment.initView$lambda$3(this.f$0, view);
            }
        }).isCenterLabel(false).isDialog(true).build();
        getBinding().tvStartTime.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointFragment$wxG12--YuaAviVCgChjQPozB9a4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EvaluationPointFragment.initView$lambda$4(this.f$0, view);
            }
        });
        getBinding().tvEndTime.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointFragment$4sMpf3KfWvJ3WlvEJbdOf0oUMj4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EvaluationPointFragment.initView$lambda$5(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(EvaluationPointFragment this$0, String timeFormat, Date date, View view) {
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
    public static final void initView$lambda$3(final EvaluationPointFragment this$0, View v) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v, "v");
        Button button = (Button) v.findViewById(R.id.btnCancel);
        Button button2 = (Button) v.findViewById(R.id.btnSubmit);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointFragment$OwbnmRIrFdlW6jg1hDBm8dUjHLU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EvaluationPointFragment.initView$lambda$3$lambda$1(this.f$0, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointFragment$pKmjyTXXRZnDhJKdirgcdHkucEs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EvaluationPointFragment.initView$lambda$3$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$1(EvaluationPointFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$2(EvaluationPointFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.returnData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(EvaluationPointFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentClickType = 0;
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(EvaluationPointFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentClickType = 1;
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.show();
        }
    }

    private final void initLoadMore() {
        this.mAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointFragment$ols8UzJOiHknHZlThxYUNk_Aleg
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                EvaluationPointFragment.initLoadMore$lambda$6(this.f$0);
            }
        });
        this.mAdapter.getLoadMoreModule().setAutoLoadMore(true);
        this.mAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLoadMore$lambda$6(EvaluationPointFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAdapter.getLoadMoreModule().setEnableLoadMore(true);
        this$0.pageNo++;
        this$0.request();
    }

    private final void request() {
        String str;
        String str2;
        EvaluationViewModel evaluationViewModel;
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(PARAMS_ID) : null;
        String string2 = getBinding().tvStartTime.getText().toString();
        String string3 = getBinding().tvEndTime.getText().toString();
        if (TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
            str = "";
            str2 = str;
        } else {
            str = string2;
            str2 = string3;
        }
        EvaluationViewModel evaluationViewModel2 = this.viewModel;
        if (evaluationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            evaluationViewModel = null;
        } else {
            evaluationViewModel = evaluationViewModel2;
        }
        evaluationViewModel.getEvaluationPointPageList(this.pageNo, this.pageSize, string, str, str2);
    }

    private final void initViewModel() {
        EvaluationViewModel evaluationViewModel = this.viewModel;
        EvaluationViewModel evaluationViewModel2 = null;
        if (evaluationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            evaluationViewModel = null;
        }
        MutableLiveData<Result<BasePageResponse<List<EvaluationPointBean>>>> evaluationPoint = evaluationViewModel.getEvaluationPoint();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends BasePageResponse<List<EvaluationPointBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<EvaluationPointBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.evaluation.EvaluationPointFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<EvaluationPointBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<EvaluationPointBean>>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    BasePageResponse basePageResponse = (BasePageResponse) value;
                    if (basePageResponse != null) {
                        EvaluationPointFragment evaluationPointFragment = EvaluationPointFragment.this;
                        if (evaluationPointFragment.pageNo == 1) {
                            evaluationPointFragment.mAdapter.setList((Collection) basePageResponse.getList());
                        } else {
                            List list = (List) basePageResponse.getList();
                            if (list != null) {
                                evaluationPointFragment.mAdapter.addData((Collection) list);
                            }
                        }
                        if (basePageResponse.getList() == null || ((List) basePageResponse.getList()).size() >= evaluationPointFragment.pageSize) {
                            evaluationPointFragment.mAdapter.getLoadMoreModule().loadMoreComplete();
                            return;
                        } else {
                            BaseLoadMoreModule.loadMoreEnd$default(evaluationPointFragment.mAdapter.getLoadMoreModule(), false, 1, null);
                            return;
                        }
                    }
                    return;
                }
                Result.m594exceptionOrNullimpl(it2.getValue());
            }
        };
        evaluationPoint.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointFragment$dh33ewr48AFrL1RV3B8EFHTmEd4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EvaluationPointFragment.initViewModel$lambda$7(function1, obj);
            }
        });
        EvaluationViewModel evaluationViewModel3 = this.viewModel;
        if (evaluationViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            evaluationViewModel2 = evaluationViewModel3;
        }
        MutableLiveData<Result<EvaluationPointBean>> evaluationPointUse = evaluationViewModel2.getEvaluationPointUse();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends EvaluationPointBean>, Unit> function2 = new Function1<Result<? extends EvaluationPointBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.evaluation.EvaluationPointFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends EvaluationPointBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends EvaluationPointBean> it2) {
                EvaluationPointFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    EvaluationPointBean evaluationPointBean = (EvaluationPointBean) value;
                    if (evaluationPointBean != null) {
                        EvaluationPointFragment evaluationPointFragment = EvaluationPointFragment.this;
                        EvaluationPointFragment.access$getBinding(evaluationPointFragment).tvTotalPoint.setText(evaluationPointBean.getTotalScore());
                        EvaluationPointFragment.access$getBinding(evaluationPointFragment).tvRedeemedPoint.setText(evaluationPointBean.getConvertedScore());
                        EvaluationPointFragment.access$getBinding(evaluationPointFragment).tvRemainingPoint.setText(evaluationPointBean.getRemainingScore());
                    }
                }
            }
        };
        evaluationPointUse.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationPointFragment$zkCr4LFw5-I9cUiXRuB8kfC0-rg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EvaluationPointFragment.initViewModel$lambda$8(function2, obj);
            }
        });
        request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
