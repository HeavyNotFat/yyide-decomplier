package com.yd.android_brand_mvp.landscape.evaluation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentEvaluationMedalBinding;
import com.yd.android_brand_mvp.dialog.evaluation.EvaluationMedalDetailDialog;
import com.yd.android_brand_mvp.model.evaluation.EvaluationMedalBean;
import com.yd.android_brand_mvp.model.evaluation.EvaluationMedalTypeBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvaluationMedalFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u0007\u0010\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationMedalFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentEvaluationMedalBinding;", "()V", "evalTypeId", "", "mAdapter", "com/yd/android_brand_mvp/landscape/evaluation/EvaluationMedalFragment$mAdapter$1", "Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationMedalFragment$mAdapter$1;", "medalTypeList", "", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationMedalTypeBean;", "pageNo", "", "pageSize", "spinnerAdapter", "com/yd/android_brand_mvp/landscape/evaluation/EvaluationMedalFragment$spinnerAdapter$1", "Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationMedalFragment$spinnerAdapter$1;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationViewModel;", "initLoadMore", "", "initView", "initViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EvaluationMedalFragment extends KTBaseFragment<FragmentEvaluationMedalBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PARAMS_ID = "id";
    private String evalTypeId;
    private final EvaluationMedalFragment$mAdapter$1 mAdapter;
    private List<EvaluationMedalTypeBean> medalTypeList;
    private int pageNo;
    private final int pageSize;
    private final EvaluationMedalFragment$spinnerAdapter$1 spinnerAdapter;
    private EvaluationViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.evaluation.EvaluationMedalFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: EvaluationMedalFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentEvaluationMedalBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentEvaluationMedalBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentEvaluationMedalBinding;", 0);
        }

        public final FragmentEvaluationMedalBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentEvaluationMedalBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentEvaluationMedalBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.yd.android_brand_mvp.landscape.evaluation.EvaluationMedalFragment$spinnerAdapter$1] */
    public EvaluationMedalFragment() {
        super(AnonymousClass1.INSTANCE);
        this.medalTypeList = new ArrayList();
        this.pageSize = 20;
        this.pageNo = 1;
        this.evalTypeId = "";
        this.mAdapter = new EvaluationMedalFragment$mAdapter$1(this);
        this.spinnerAdapter = new BaseAdapter() { // from class: com.yd.android_brand_mvp.landscape.evaluation.EvaluationMedalFragment$spinnerAdapter$1
            @Override // android.widget.Adapter
            public long getItemId(int position) {
                return position;
            }

            @Override // android.widget.Adapter
            public int getCount() {
                return this.this$0.medalTypeList.size();
            }

            @Override // android.widget.Adapter
            public String getItem(int position) {
                return ((EvaluationMedalTypeBean) this.this$0.medalTypeList.get(position)).getEvalTypeName();
            }

            @Override // android.widget.Adapter
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = LayoutInflater.from(this.this$0.requireContext()).inflate(R.layout.spinner_item2, (ViewGroup) null);
                ((TextView) view.findViewById(R.id.tvText)).setText(((EvaluationMedalTypeBean) this.this$0.medalTypeList.get(position)).getEvalTypeName());
                Intrinsics.checkNotNullExpressionValue(view, "view");
                return view;
            }
        };
    }

    /* JADX INFO: compiled from: EvaluationMedalFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationMedalFragment$Companion;", "", "()V", "PARAMS_ID", "", "newInstance", "Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationMedalFragment;", "id", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EvaluationMedalFragment newInstance(String id) {
            EvaluationMedalFragment evaluationMedalFragment = new EvaluationMedalFragment();
            Bundle bundle = new Bundle();
            bundle.putString(EvaluationMedalFragment.PARAMS_ID, id);
            evaluationMedalFragment.setArguments(bundle);
            return evaluationMedalFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (EvaluationViewModel) new ViewModelProvider(this).get(EvaluationViewModel.class);
        initView();
        initLoadMore();
        initViewModel();
        EvaluationViewModel evaluationViewModel = this.viewModel;
        if (evaluationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            evaluationViewModel = null;
        }
        evaluationViewModel.getEvaluationMedalTypeList();
    }

    private final void initView() {
        getBinding().spinner.setAdapter((SpinnerAdapter) this.spinnerAdapter);
        getBinding().spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.EvaluationMedalFragment.initView.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                LogUtils.d("onItemSelected", Integer.valueOf(position + 1));
                EvaluationMedalFragment evaluationMedalFragment = EvaluationMedalFragment.this;
                evaluationMedalFragment.evalTypeId = ((EvaluationMedalTypeBean) evaluationMedalFragment.medalTypeList.get(position)).getEvalTypeId();
                EvaluationMedalFragment.this.pageNo = 1;
                EvaluationMedalFragment.this.request();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }
        });
        getBinding().recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 4));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        Bundle arguments = getArguments();
        final String string = arguments != null ? arguments.getString(PARAMS_ID) : null;
        this.mAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationMedalFragment$yhx1zDFI1CCQnVD_LJuTM7vZxlY
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                EvaluationMedalFragment.initView$lambda$0(this.f$0, string, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(EvaluationMedalFragment this$0, String str, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        EvaluationMedalBean item = this$0.mAdapter.getItem(i);
        if (item.getOwned()) {
            this$0.showProgressDialog();
            EvaluationViewModel evaluationViewModel = this$0.viewModel;
            if (evaluationViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                evaluationViewModel = null;
            }
            if (str == null) {
                str = "";
            }
            evaluationViewModel.getEvaluationMedalDetails(str, item.getMedalCode());
        }
    }

    private final void initLoadMore() {
        this.mAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationMedalFragment$jW5ehxyBeCMhGf6S1nT0Lfq7910
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                EvaluationMedalFragment.initLoadMore$lambda$1(this.f$0);
            }
        });
        this.mAdapter.getLoadMoreModule().setAutoLoadMore(true);
        this.mAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLoadMore$lambda$1(EvaluationMedalFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAdapter.getLoadMoreModule().setEnableLoadMore(true);
        this$0.pageNo++;
        this$0.request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void request() {
        Bundle arguments = getArguments();
        EvaluationViewModel evaluationViewModel = null;
        String string = arguments != null ? arguments.getString(PARAMS_ID) : null;
        EvaluationViewModel evaluationViewModel2 = this.viewModel;
        if (evaluationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            evaluationViewModel = evaluationViewModel2;
        }
        evaluationViewModel.getEvaluationMedalList(this.pageNo, this.pageSize, string, this.evalTypeId);
    }

    private final void initViewModel() {
        EvaluationViewModel evaluationViewModel = this.viewModel;
        EvaluationViewModel evaluationViewModel2 = null;
        if (evaluationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            evaluationViewModel = null;
        }
        MutableLiveData<Result<BasePageResponse<List<EvaluationMedalBean>>>> evaluationMedalListLiveData = evaluationViewModel.getEvaluationMedalListLiveData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends BasePageResponse<List<EvaluationMedalBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<EvaluationMedalBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.evaluation.EvaluationMedalFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<EvaluationMedalBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<EvaluationMedalBean>>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    BasePageResponse basePageResponse = (BasePageResponse) value;
                    if (basePageResponse != null) {
                        EvaluationMedalFragment evaluationMedalFragment = EvaluationMedalFragment.this;
                        if (evaluationMedalFragment.pageNo == 1) {
                            evaluationMedalFragment.mAdapter.setList((Collection) basePageResponse.getList());
                        } else {
                            List list = (List) basePageResponse.getList();
                            if (list != null) {
                                evaluationMedalFragment.mAdapter.addData((Collection) list);
                            }
                        }
                        if (basePageResponse.getList() == null || ((List) basePageResponse.getList()).size() >= evaluationMedalFragment.pageSize) {
                            evaluationMedalFragment.mAdapter.getLoadMoreModule().loadMoreComplete();
                            return;
                        } else {
                            BaseLoadMoreModule.loadMoreEnd$default(evaluationMedalFragment.mAdapter.getLoadMoreModule(), false, 1, null);
                            return;
                        }
                    }
                    return;
                }
                Result.m594exceptionOrNullimpl(it2.getValue());
            }
        };
        evaluationMedalListLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationMedalFragment$xvMX4cMOwFz95vf01iQHlxZhoGg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EvaluationMedalFragment.initViewModel$lambda$2(function1, obj);
            }
        });
        EvaluationViewModel evaluationViewModel3 = this.viewModel;
        if (evaluationViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            evaluationViewModel3 = null;
        }
        MutableLiveData<Result<EvaluationMedalBean>> evaluationMedalDetails = evaluationViewModel3.getEvaluationMedalDetails();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends EvaluationMedalBean>, Unit> function2 = new Function1<Result<? extends EvaluationMedalBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.evaluation.EvaluationMedalFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends EvaluationMedalBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends EvaluationMedalBean> it2) {
                EvaluationMedalFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    EvaluationMedalBean evaluationMedalBean = (EvaluationMedalBean) value;
                    if (evaluationMedalBean != null) {
                        new EvaluationMedalDetailDialog(evaluationMedalBean).show(EvaluationMedalFragment.this.getParentFragmentManager(), "messageTip");
                    }
                }
            }
        };
        evaluationMedalDetails.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationMedalFragment$7vQZ48lT5RtNdnh1k-YpLsAx28c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EvaluationMedalFragment.initViewModel$lambda$3(function2, obj);
            }
        });
        EvaluationViewModel evaluationViewModel4 = this.viewModel;
        if (evaluationViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            evaluationViewModel2 = evaluationViewModel4;
        }
        MutableLiveData<Result<List<EvaluationMedalTypeBean>>> evaluationMedalType = evaluationViewModel2.getEvaluationMedalType();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Result<? extends List<EvaluationMedalTypeBean>>, Unit> function3 = new Function1<Result<? extends List<EvaluationMedalTypeBean>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.evaluation.EvaluationMedalFragment.initViewModel.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<EvaluationMedalTypeBean>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<EvaluationMedalTypeBean>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    EvaluationMedalFragment.this.medalTypeList.add(new EvaluationMedalTypeBean("", "全部勋章"));
                    List list = EvaluationMedalFragment.this.medalTypeList;
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    ArrayList arrayList = (List) value;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    list.addAll(arrayList);
                    notifyDataSetChanged();
                }
            }
        };
        evaluationMedalType.observe(viewLifecycleOwner3, new Observer() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationMedalFragment$Q64dAZxapGI1KbOAeysvBMO2cdk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EvaluationMedalFragment.initViewModel$lambda$4(function3, obj);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
