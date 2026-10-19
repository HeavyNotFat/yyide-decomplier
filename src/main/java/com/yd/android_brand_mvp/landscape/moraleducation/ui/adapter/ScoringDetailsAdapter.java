package com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ScoringDetailsAdapterItemBinding;
import com.yd.android_brand_mvp.landscape.moraleducation.model.ScoringDetailModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScoringDetailsAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\n2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0014\u0010\u0014\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ScoringDetailsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ScoringDetailsAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "mScoringDetailModels", "", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/ScoringDetailModel;", "(Landroid/content/Context;Ljava/util/List;)V", "clearData", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "replaceData", "scoringDetailModels", "ViewHolder", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScoringDetailsAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Context mContext;
    private List<ScoringDetailModel> mScoringDetailModels;

    public ScoringDetailsAdapter(Context mContext, List<ScoringDetailModel> mScoringDetailModels) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mScoringDetailModels, "mScoringDetailModels");
        this.mContext = mContext;
        this.mScoringDetailModels = mScoringDetailModels;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ScoringDetailsAdapterItemBinding scoringDetailsAdapterItemBindingInflate = ScoringDetailsAdapterItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(scoringDetailsAdapterItemBindingInflate, "inflate(\n            Lay…          false\n        )");
        ConstraintLayout root = scoringDetailsAdapterItemBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return new ViewHolder(this, root);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ScoringDetailModel scoringDetailModel = this.mScoringDetailModels.get(position);
        holder.getMTvSerialNumber().setText(scoringDetailModel.getMSeq());
        holder.getMTvFirstIndex().setText(scoringDetailModel.getMFirstIndicator());
        holder.getMTvSecondIndex().setText(scoringDetailModel.getMSecondIndicator());
        holder.getMTvScoringCriteria().setText(scoringDetailModel.getMStandard());
        holder.getMTvScore().setText(scoringDetailModel.getMScore());
        holder.getMTvScoreRemarks().setText(scoringDetailModel.getMRemark());
        holder.getMTvTime().setText(scoringDetailModel.getMCreateTime());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mScoringDetailModels.size();
    }

    public final void replaceData(List<ScoringDetailModel> scoringDetailModels) {
        Intrinsics.checkNotNullParameter(scoringDetailModels, "scoringDetailModels");
        this.mScoringDetailModels.clear();
        this.mScoringDetailModels.addAll(scoringDetailModels);
        notifyDataSetChanged();
    }

    public final void clearData() {
        if (!this.mScoringDetailModels.isEmpty()) {
            this.mScoringDetailModels.clear();
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: ScoringDetailsAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ScoringDetailsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ScoringDetailsAdapter;Landroid/view/View;)V", "mTvFirstIndex", "Landroid/widget/TextView;", "getMTvFirstIndex", "()Landroid/widget/TextView;", "setMTvFirstIndex", "(Landroid/widget/TextView;)V", "mTvScore", "getMTvScore", "setMTvScore", "mTvScoreRemarks", "getMTvScoreRemarks", "setMTvScoreRemarks", "mTvScoringCriteria", "getMTvScoringCriteria", "setMTvScoringCriteria", "mTvSecondIndex", "getMTvSecondIndex", "setMTvSecondIndex", "mTvSerialNumber", "getMTvSerialNumber", "setMTvSerialNumber", "mTvTime", "getMTvTime", "setMTvTime", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvFirstIndex;
        private TextView mTvScore;
        private TextView mTvScoreRemarks;
        private TextView mTvScoringCriteria;
        private TextView mTvSecondIndex;
        private TextView mTvSerialNumber;
        private TextView mTvTime;
        final /* synthetic */ ScoringDetailsAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ScoringDetailsAdapter scoringDetailsAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = scoringDetailsAdapter;
            View viewFindViewById = itemView.findViewById(R.id.tv_serial_number);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(R.id.tv_serial_number)");
            this.mTvSerialNumber = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.tv_first_index);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "itemView.findViewById(R.id.tv_first_index)");
            this.mTvFirstIndex = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.tv_second_index);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "itemView.findViewById(R.id.tv_second_index)");
            this.mTvSecondIndex = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R.id.tv_scoring_criteria);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "itemView.findViewById(R.id.tv_scoring_criteria)");
            this.mTvScoringCriteria = (TextView) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(R.id.tv_score);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "itemView.findViewById(R.id.tv_score)");
            this.mTvScore = (TextView) viewFindViewById5;
            View viewFindViewById6 = itemView.findViewById(R.id.tv_score_remarks);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "itemView.findViewById(R.id.tv_score_remarks)");
            this.mTvScoreRemarks = (TextView) viewFindViewById6;
            View viewFindViewById7 = itemView.findViewById(R.id.tv_time);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "itemView.findViewById(R.id.tv_time)");
            this.mTvTime = (TextView) viewFindViewById7;
        }

        public final TextView getMTvSerialNumber() {
            return this.mTvSerialNumber;
        }

        public final void setMTvSerialNumber(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvSerialNumber = textView;
        }

        public final TextView getMTvFirstIndex() {
            return this.mTvFirstIndex;
        }

        public final void setMTvFirstIndex(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvFirstIndex = textView;
        }

        public final TextView getMTvSecondIndex() {
            return this.mTvSecondIndex;
        }

        public final void setMTvSecondIndex(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvSecondIndex = textView;
        }

        public final TextView getMTvScoringCriteria() {
            return this.mTvScoringCriteria;
        }

        public final void setMTvScoringCriteria(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvScoringCriteria = textView;
        }

        public final TextView getMTvScore() {
            return this.mTvScore;
        }

        public final void setMTvScore(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvScore = textView;
        }

        public final TextView getMTvScoreRemarks() {
            return this.mTvScoreRemarks;
        }

        public final void setMTvScoreRemarks(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvScoreRemarks = textView;
        }

        public final TextView getMTvTime() {
            return this.mTvTime;
        }

        public final void setMTvTime(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvTime = textView;
        }
    }
}
