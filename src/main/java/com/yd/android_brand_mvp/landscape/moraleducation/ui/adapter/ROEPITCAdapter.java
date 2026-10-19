package com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.RoepInThisClassAdapterItemBinding;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CurrentMEModel;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ROEPITCAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0015\u0016B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ROEPITCAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ROEPITCAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "mCurrentModels", "", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;", "mOnItemClickListener", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ROEPITCAdapter$OnItemClickListener;", "(Landroid/content/Context;Ljava/util/List;Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ROEPITCAdapter$OnItemClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OnItemClickListener", "ViewHolder", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ROEPITCAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Context mContext;
    private final List<CurrentMEModel> mCurrentModels;
    private final OnItemClickListener mOnItemClickListener;

    /* JADX INFO: compiled from: ROEPITCAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ROEPITCAdapter$OnItemClickListener;", "", "onItemClicked", "", "view", "Landroid/view/View;", "currentMEModel", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnItemClickListener {
        void onItemClicked(View view, CurrentMEModel currentMEModel);
    }

    public ROEPITCAdapter(Context mContext, List<CurrentMEModel> mCurrentModels, OnItemClickListener mOnItemClickListener) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mCurrentModels, "mCurrentModels");
        Intrinsics.checkNotNullParameter(mOnItemClickListener, "mOnItemClickListener");
        this.mContext = mContext;
        this.mCurrentModels = mCurrentModels;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        RoepInThisClassAdapterItemBinding roepInThisClassAdapterItemBindingInflate = RoepInThisClassAdapterItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(roepInThisClassAdapterItemBindingInflate, "inflate(\n            Lay…, parent, false\n        )");
        LinearLayout root = roepInThisClassAdapterItemBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return new ViewHolder(this, root);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final CurrentMEModel currentMEModel = this.mCurrentModels.get(position);
        holder.getMTvActivityCycle().setText(currentMEModel.getMCycle());
        holder.getMTvRanking().setText(currentMEModel.getMRanking());
        holder.getMTvScore().setText(String.valueOf(currentMEModel.getMScore()));
        holder.getMTvCurrentCycleLabel().setVisibility(position == 0 ? 0 : 8);
        holder.itemView.setSelected(position == 0);
        if (currentMEModel.getMWinPrize()) {
            holder.getMTvHonoraryTitle().setText(currentMEModel.getMHonorTitle());
            holder.getMIvMedalOfHonor().setVisibility(0);
            holder.getMTvNoMedalOfHonor().setVisibility(8);
            GlideUtil.loadImage(this.mContext, currentMEModel.getMMedalUrl(), holder.getMIvMedalOfHonor());
        } else {
            holder.getMIvMedalOfHonor().setVisibility(8);
            holder.getMTvNoMedalOfHonor().setVisibility(0);
            holder.getMTvHonoraryTitle().setText(this.mContext.getResources().getString(R.string.nothing));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.-$$Lambda$ROEPITCAdapter$Ep_7OVf-wYOC3RAhzLKaCXYOL0Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ROEPITCAdapter.onBindViewHolder$lambda$0(this.f$0, currentMEModel, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(ROEPITCAdapter this$0, CurrentMEModel currentMEModel, View it2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentMEModel, "$currentMEModel");
        OnItemClickListener onItemClickListener = this$0.mOnItemClickListener;
        Intrinsics.checkNotNullExpressionValue(it2, "it");
        onItemClickListener.onItemClicked(it2, currentMEModel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mCurrentModels.size();
    }

    /* JADX INFO: compiled from: ROEPITCAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u001d\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ROEPITCAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ROEPITCAdapter;Landroid/view/View;)V", "mIvMedalOfHonor", "Landroid/widget/ImageView;", "getMIvMedalOfHonor", "()Landroid/widget/ImageView;", "setMIvMedalOfHonor", "(Landroid/widget/ImageView;)V", "mTvActivityCycle", "Landroid/widget/TextView;", "getMTvActivityCycle", "()Landroid/widget/TextView;", "setMTvActivityCycle", "(Landroid/widget/TextView;)V", "mTvCurrentCycleLabel", "getMTvCurrentCycleLabel", "setMTvCurrentCycleLabel", "mTvHonoraryTitle", "getMTvHonoraryTitle", "setMTvHonoraryTitle", "mTvNoMedalOfHonor", "getMTvNoMedalOfHonor", "setMTvNoMedalOfHonor", "mTvRanking", "getMTvRanking", "setMTvRanking", "mTvScore", "getMTvScore", "setMTvScore", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIvMedalOfHonor;
        private TextView mTvActivityCycle;
        private TextView mTvCurrentCycleLabel;
        private TextView mTvHonoraryTitle;
        private TextView mTvNoMedalOfHonor;
        private TextView mTvRanking;
        private TextView mTvScore;
        final /* synthetic */ ROEPITCAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ROEPITCAdapter rOEPITCAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = rOEPITCAdapter;
            View viewFindViewById = itemView.findViewById(R.id.tv_activity_cycle);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(R.id.tv_activity_cycle)");
            this.mTvActivityCycle = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.tv_ranking_in_this_class);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "itemView.findViewById(R.…tv_ranking_in_this_class)");
            this.mTvRanking = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.tv_score_in_this_class);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "itemView.findViewById(R.id.tv_score_in_this_class)");
            this.mTvScore = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R.id.tv_honorary_title);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "itemView.findViewById(R.id.tv_honorary_title)");
            this.mTvHonoraryTitle = (TextView) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(R.id.iv_medal_of_honor);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "itemView.findViewById(R.id.iv_medal_of_honor)");
            this.mIvMedalOfHonor = (ImageView) viewFindViewById5;
            View viewFindViewById6 = itemView.findViewById(R.id.tv_no_medal_of_honor);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "itemView.findViewById(R.id.tv_no_medal_of_honor)");
            this.mTvNoMedalOfHonor = (TextView) viewFindViewById6;
            View viewFindViewById7 = itemView.findViewById(R.id.tv_current_cycle_label);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "itemView.findViewById(R.id.tv_current_cycle_label)");
            this.mTvCurrentCycleLabel = (TextView) viewFindViewById7;
        }

        public final TextView getMTvActivityCycle() {
            return this.mTvActivityCycle;
        }

        public final void setMTvActivityCycle(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvActivityCycle = textView;
        }

        public final TextView getMTvRanking() {
            return this.mTvRanking;
        }

        public final void setMTvRanking(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvRanking = textView;
        }

        public final TextView getMTvScore() {
            return this.mTvScore;
        }

        public final void setMTvScore(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvScore = textView;
        }

        public final TextView getMTvHonoraryTitle() {
            return this.mTvHonoraryTitle;
        }

        public final void setMTvHonoraryTitle(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvHonoraryTitle = textView;
        }

        public final ImageView getMIvMedalOfHonor() {
            return this.mIvMedalOfHonor;
        }

        public final void setMIvMedalOfHonor(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mIvMedalOfHonor = imageView;
        }

        public final TextView getMTvNoMedalOfHonor() {
            return this.mTvNoMedalOfHonor;
        }

        public final void setMTvNoMedalOfHonor(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvNoMedalOfHonor = textView;
        }

        public final TextView getMTvCurrentCycleLabel() {
            return this.mTvCurrentCycleLabel;
        }

        public final void setMTvCurrentCycleLabel(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvCurrentCycleLabel = textView;
        }
    }
}
