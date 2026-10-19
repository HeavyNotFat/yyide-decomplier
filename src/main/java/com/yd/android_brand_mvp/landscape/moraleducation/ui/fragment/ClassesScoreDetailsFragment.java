package com.yd.android_brand_mvp.landscape.moraleducation.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentClassesScoreDetailsBinding;
import com.yd.android_brand_mvp.databinding.ItemClassesScoreNowDetailsBinding;
import com.yd.android_brand_mvp.landscape.moraleducation.model.ScoringDetailCycleModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.ScoringDetailModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: ClassesScoreDetailsFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/fragment/ClassesScoreDetailsFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentClassesScoreDetailsBinding;", "()V", "adapter", "com/yd/android_brand_mvp/landscape/moraleducation/ui/fragment/ClassesScoreDetailsFragment$adapter$1", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/fragment/ClassesScoreDetailsFragment$adapter$1;", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClassesScoreDetailsFragment extends KTBaseFragment<FragmentClassesScoreDetailsBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ClassesScoreDetailsFragment$adapter$1 adapter;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.ui.fragment.ClassesScoreDetailsFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ClassesScoreDetailsFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentClassesScoreDetailsBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentClassesScoreDetailsBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentClassesScoreDetailsBinding;", 0);
        }

        public final FragmentClassesScoreDetailsBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentClassesScoreDetailsBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentClassesScoreDetailsBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.yd.android_brand_mvp.landscape.moraleducation.ui.fragment.ClassesScoreDetailsFragment$adapter$1] */
    public ClassesScoreDetailsFragment() {
        super(AnonymousClass1.INSTANCE);
        this.adapter = new BaseQuickAdapter<ScoringDetailModel, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.fragment.ClassesScoreDetailsFragment$adapter$1
            {
                super(R.layout.item_classes_score_now_details, null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, ScoringDetailModel item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemClassesScoreNowDetailsBinding itemClassesScoreNowDetailsBindingBind = ItemClassesScoreNowDetailsBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemClassesScoreNowDetailsBindingBind, "bind(holder.itemView)");
                TextView textView = itemClassesScoreNowDetailsBindingBind.tvSeq;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("%s.", Arrays.copyOf(new Object[]{item.getMSeq()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                textView.setText(str);
                itemClassesScoreNowDetailsBindingBind.tvFirstIndex.setText(item.getMFirstIndicator());
                itemClassesScoreNowDetailsBindingBind.tvSecondIndex.setText(item.getMSecondIndicator());
                TextView textView2 = itemClassesScoreNowDetailsBindingBind.tvScore;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str2 = String.format("%s分", Arrays.copyOf(new Object[]{item.getMScore()}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                textView2.setText(str2);
                itemClassesScoreNowDetailsBindingBind.tvStandardContent.setText(item.getMStandard());
                itemClassesScoreNowDetailsBindingBind.tvRemarkContent.setText(item.getMRemark());
                if (item.getMScore() != null && Double.parseDouble(item.getMScore()) >= 0.0d) {
                    itemClassesScoreNowDetailsBindingBind.tvScore.setTextColor(this.this$0.getResources().getColor(R.color.color_11c685));
                } else {
                    itemClassesScoreNowDetailsBindingBind.tvScore.setTextColor(this.this$0.getResources().getColor(R.color.color_FF4E4E));
                }
            }
        };
    }

    /* JADX INFO: compiled from: ClassesScoreDetailsFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/fragment/ClassesScoreDetailsFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/fragment/ClassesScoreDetailsFragment;", "data", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/ScoringDetailCycleModel;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ClassesScoreDetailsFragment newInstance(ScoringDetailCycleModel data) {
            ClassesScoreDetailsFragment classesScoreDetailsFragment = new ClassesScoreDetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("data", data);
            classesScoreDetailsFragment.setArguments(bundle);
            return classesScoreDetailsFragment;
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        ScoringDetailCycleModel scoringDetailCycleModel;
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerView.setAdapter(this.adapter);
        Bundle arguments = getArguments();
        if (arguments == null || (scoringDetailCycleModel = (ScoringDetailCycleModel) arguments.getParcelable("data")) == null) {
            return;
        }
        TextView textView = getBinding().tvTotalDemerit;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%s分", Arrays.copyOf(new Object[]{scoringDetailCycleModel.getMTotalSubtractScore()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView.setText(str);
        TextView textView2 = getBinding().tvTotalScore;
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str2 = String.format("%s分", Arrays.copyOf(new Object[]{scoringDetailCycleModel.getMTotalAddScore()}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        textView2.setText(str2);
        TextView textView3 = getBinding().tvTotal;
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String str3 = String.format("%s", Arrays.copyOf(new Object[]{scoringDetailCycleModel.getMTotalScore()}, 1));
        Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
        textView3.setText(str3);
        setList(scoringDetailCycleModel.getMLineList());
    }
}
