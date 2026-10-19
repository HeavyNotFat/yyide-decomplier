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
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentEvaluationBinding;
import com.yd.android_brand_mvp.databinding.ItemEvaluationBinding;
import com.yd.android_brand_mvp.model.evaluation.EvaluationBean;
import com.yd.android_brand_mvp.utils.SpData;
import java.util.Arrays;
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
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: EvaluationFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\u0005\b\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentEvaluationBinding;", "()V", "adapter", "com/yd/android_brand_mvp/landscape/evaluation/EvaluationFragment$adapter$1", "Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationFragment$adapter$1;", "spinnerAdapter", "com/yd/android_brand_mvp/landscape/evaluation/EvaluationFragment$spinnerAdapter$1", "Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationFragment$spinnerAdapter$1;", "strings", "", "", "[Ljava/lang/String;", "type", "", "viewModel", "Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationViewModel;", "UpdataEvent", "", "id", "initView", "initViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EvaluationFragment extends KTBaseFragment<FragmentEvaluationBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final EvaluationFragment$adapter$1 adapter;
    private final EvaluationFragment$spinnerAdapter$1 spinnerAdapter;
    private final String[] strings;
    private int type;
    private EvaluationViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.evaluation.EvaluationFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: EvaluationFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentEvaluationBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentEvaluationBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentEvaluationBinding;", 0);
        }

        public final FragmentEvaluationBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentEvaluationBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentEvaluationBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.yd.android_brand_mvp.landscape.evaluation.EvaluationFragment$adapter$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.yd.android_brand_mvp.landscape.evaluation.EvaluationFragment$spinnerAdapter$1] */
    public EvaluationFragment() {
        super(AnonymousClass1.INSTANCE);
        this.strings = new String[]{"按积分排名", "按积分卡排名", "按勋章排名"};
        this.type = 1;
        this.adapter = new BaseQuickAdapter<EvaluationBean, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.evaluation.EvaluationFragment$adapter$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, EvaluationBean item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemEvaluationBinding itemEvaluationBindingBind = ItemEvaluationBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemEvaluationBindingBind, "bind(holder.itemView)");
                itemEvaluationBindingBind.tvStudentName.setText(item.getParentName());
                itemEvaluationBindingBind.tvMedal.setText(String.valueOf(item.getCountMedal()));
                itemEvaluationBindingBind.tvPointCard.setText(String.valueOf(item.getCountScoreCard()));
                itemEvaluationBindingBind.tvPointTotal.setText(String.valueOf(item.getTotalScore()));
                itemEvaluationBindingBind.ivMedal.setVisibility(0);
                itemEvaluationBindingBind.tvSort.setVisibility(4);
                itemEvaluationBindingBind.imageView8.setImageResource(R.drawable.icon_evaluation_medal);
                itemEvaluationBindingBind.imageView9.setImageResource(R.drawable.icon_evaluation_point_card);
                itemEvaluationBindingBind.imageView10.setImageResource(R.drawable.icon_evaluation_point_total);
                int sort = item.getSort();
                if (sort == 1) {
                    itemEvaluationBindingBind.llCentent.setBackgroundResource(R.drawable.bg_yellow_20);
                    itemEvaluationBindingBind.ivMedal.setImageResource(R.drawable.icon_evaluation_first);
                    return;
                }
                if (sort == 2) {
                    itemEvaluationBindingBind.llCentent.setBackgroundResource(R.drawable.bg_e9f1ff_20);
                    itemEvaluationBindingBind.ivMedal.setImageResource(R.drawable.icon_evaluation_two);
                    return;
                }
                if (sort == 3) {
                    itemEvaluationBindingBind.llCentent.setBackgroundResource(R.drawable.bg_fff1e9_20);
                    itemEvaluationBindingBind.ivMedal.setImageResource(R.drawable.icon_evaluation_three);
                    return;
                }
                itemEvaluationBindingBind.ivMedal.setVisibility(4);
                itemEvaluationBindingBind.tvSort.setVisibility(0);
                itemEvaluationBindingBind.llCentent.setBackgroundResource(R.drawable.border_1dp_white_20);
                TextView textView = itemEvaluationBindingBind.tvSort;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("NO.%s", Arrays.copyOf(new Object[]{Integer.valueOf(item.getSort())}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                textView.setText(str);
                itemEvaluationBindingBind.imageView8.setImageResource(R.drawable.icon_evaluation_medal_normal);
                itemEvaluationBindingBind.imageView9.setImageResource(R.drawable.icon_evaluation_point_card_normal);
                itemEvaluationBindingBind.imageView10.setImageResource(R.drawable.icon_evaluation_point_total_normal);
            }
        };
        this.spinnerAdapter = new BaseAdapter() { // from class: com.yd.android_brand_mvp.landscape.evaluation.EvaluationFragment$spinnerAdapter$1
            @Override // android.widget.Adapter
            public long getItemId(int position) {
                return position;
            }

            @Override // android.widget.Adapter
            public int getCount() {
                return this.this$0.strings.length;
            }

            @Override // android.widget.Adapter
            public String getItem(int position) {
                return this.this$0.strings[position];
            }

            @Override // android.widget.Adapter
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = LayoutInflater.from(this.this$0.requireContext()).inflate(R.layout.spinner_item, (ViewGroup) null);
                ((TextView) view.findViewById(R.id.tvText)).setText(this.this$0.strings[position]);
                Intrinsics.checkNotNullExpressionValue(view, "view");
                return view;
            }
        };
    }

    /* JADX INFO: compiled from: EvaluationFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/evaluation/EvaluationFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EvaluationFragment newInstance() {
            return new EvaluationFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (EvaluationViewModel) new ViewModelProvider(this).get(EvaluationViewModel.class);
        initView();
    }

    private final void initView() {
        getBinding().title.setText("评评帮榜单");
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerView.setAdapter(this.adapter);
        setEmptyView(R.layout.item_min_null_layout_2);
        getBinding().spinner.setAdapter((SpinnerAdapter) this.spinnerAdapter);
        getBinding().spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.yd.android_brand_mvp.landscape.evaluation.EvaluationFragment.initView.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = position + 1;
                LogUtils.d("onItemSelected", Integer.valueOf(i));
                EvaluationViewModel evaluationViewModel = EvaluationFragment.this.viewModel;
                if (evaluationViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    evaluationViewModel = null;
                }
                String classesId = SpData.getClassesId();
                Intrinsics.checkNotNullExpressionValue(classesId, "getClassesId()");
                evaluationViewModel.getEvaluationList(classesId, i);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }
        });
        initViewModel();
        EvaluationViewModel evaluationViewModel = this.viewModel;
        if (evaluationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            evaluationViewModel = null;
        }
        String classesId = SpData.getClassesId();
        Intrinsics.checkNotNullExpressionValue(classesId, "getClassesId()");
        evaluationViewModel.getEvaluationList(classesId, this.type);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        if (id == 2201) {
            EvaluationViewModel evaluationViewModel = this.viewModel;
            if (evaluationViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                evaluationViewModel = null;
            }
            String classesId = SpData.getClassesId();
            Intrinsics.checkNotNullExpressionValue(classesId, "getClassesId()");
            evaluationViewModel.getEvaluationList(classesId, this.type);
        }
    }

    private final void initViewModel() {
        EvaluationViewModel evaluationViewModel = this.viewModel;
        if (evaluationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            evaluationViewModel = null;
        }
        MutableLiveData<Result<List<EvaluationBean>>> evaluationListLiveData = evaluationViewModel.getEvaluationListLiveData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends List<EvaluationBean>>, Unit> function1 = new Function1<Result<? extends List<EvaluationBean>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.evaluation.EvaluationFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<EvaluationBean>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<EvaluationBean>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    setList((List) value);
                }
            }
        };
        evaluationListLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.evaluation.-$$Lambda$EvaluationFragment$CzDJ1FLr91vNqUKoZ8BCmzV-8eM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EvaluationFragment.initViewModel$lambda$0(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
