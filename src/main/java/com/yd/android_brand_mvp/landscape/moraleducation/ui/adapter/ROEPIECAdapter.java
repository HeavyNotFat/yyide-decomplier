package com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.RoepInEveryClassAdapterItem2Binding;
import com.yd.android_brand_mvp.databinding.RoepInEveryClassAdapterItemBinding;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CycleCurrentMEModel;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ROEPIECAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0015B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\tH\u0016J\u001c\u0010\u000e\u001a\u00020\f2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ROEPIECAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ROEPIECAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "mCycleCurrentMEModels", "", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CycleCurrentMEModel;", "mItemViewType", "", "(Landroid/content/Context;Ljava/util/List;I)V", "clearData", "", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ROEPIECAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Context mContext;
    private final List<CycleCurrentMEModel> mCycleCurrentMEModels;
    private final int mItemViewType;

    public ROEPIECAdapter(Context mContext, List<CycleCurrentMEModel> mCycleCurrentMEModels, int i) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mCycleCurrentMEModels, "mCycleCurrentMEModels");
        this.mContext = mContext;
        this.mCycleCurrentMEModels = mCycleCurrentMEModels;
        this.mItemViewType = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (this.mItemViewType == 0) {
            RoepInEveryClassAdapterItemBinding roepInEveryClassAdapterItemBindingInflate = RoepInEveryClassAdapterItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(roepInEveryClassAdapterItemBindingInflate, "inflate(\n               …      false\n            )");
            ConstraintLayout root = roepInEveryClassAdapterItemBindingInflate.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            return new ViewHolder(this, root);
        }
        RoepInEveryClassAdapterItem2Binding roepInEveryClassAdapterItem2BindingInflate = RoepInEveryClassAdapterItem2Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(roepInEveryClassAdapterItem2BindingInflate, "inflate(\n               …      false\n            )");
        ConstraintLayout root2 = roepInEveryClassAdapterItem2BindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        return new ViewHolder(this, root2);
    }

    public final void clearData() {
        this.mCycleCurrentMEModels.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CycleCurrentMEModel cycleCurrentMEModel = this.mCycleCurrentMEModels.get(position);
        if (this.mItemViewType == 0) {
            holder.getMTvRanking().setText(String.valueOf(cycleCurrentMEModel.getMRanking()));
            holder.getMTvClass().setText(cycleCurrentMEModel.getMName());
            holder.getMTvScore().setText(cycleCurrentMEModel.getMScore().toString());
            if (cycleCurrentMEModel.getMWinPrize()) {
                TextView mTvHonoraryTitle = holder.getMTvHonoraryTitle();
                if (mTvHonoraryTitle != null) {
                    mTvHonoraryTitle.setText(cycleCurrentMEModel.getMHonorTitle());
                }
                ImageView mIvMedalOfHonor = holder.getMIvMedalOfHonor();
                if (mIvMedalOfHonor != null) {
                    mIvMedalOfHonor.setVisibility(0);
                }
                GlideUtil.loadImage(this.mContext, cycleCurrentMEModel.getMMedalUrl(), holder.getMIvMedalOfHonor());
                return;
            }
            TextView mTvHonoraryTitle2 = holder.getMTvHonoraryTitle();
            if (mTvHonoraryTitle2 != null) {
                mTvHonoraryTitle2.setText("");
            }
            ImageView mIvMedalOfHonor2 = holder.getMIvMedalOfHonor();
            if (mIvMedalOfHonor2 == null) {
                return;
            }
            mIvMedalOfHonor2.setVisibility(8);
            return;
        }
        holder.getMTvRanking().setText(String.valueOf(cycleCurrentMEModel.getMRanking()));
        holder.getMTvClass().setText(cycleCurrentMEModel.getMName());
        holder.getMTvScore().setText(cycleCurrentMEModel.getMScore().toString());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mCycleCurrentMEModels.size();
    }

    /* JADX INFO: compiled from: ROEPIECAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ROEPIECAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ROEPIECAdapter;Landroid/view/View;)V", "mIvMedalOfHonor", "Landroid/widget/ImageView;", "getMIvMedalOfHonor", "()Landroid/widget/ImageView;", "setMIvMedalOfHonor", "(Landroid/widget/ImageView;)V", "mTvClass", "Landroid/widget/TextView;", "getMTvClass", "()Landroid/widget/TextView;", "setMTvClass", "(Landroid/widget/TextView;)V", "mTvHonoraryTitle", "getMTvHonoraryTitle", "setMTvHonoraryTitle", "mTvRanking", "getMTvRanking", "setMTvRanking", "mTvScore", "getMTvScore", "setMTvScore", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIvMedalOfHonor;
        private TextView mTvClass;
        private TextView mTvHonoraryTitle;
        private TextView mTvRanking;
        private TextView mTvScore;
        final /* synthetic */ ROEPIECAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ROEPIECAdapter rOEPIECAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = rOEPIECAdapter;
            View viewFindViewById = itemView.findViewById(R.id.tv_ranking_in_every_class);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(R.…v_ranking_in_every_class)");
            this.mTvRanking = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.tv_class);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "itemView.findViewById(R.id.tv_class)");
            this.mTvClass = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.tv_score_in_every_class);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "itemView.findViewById(R.….tv_score_in_every_class)");
            this.mTvScore = (TextView) viewFindViewById3;
            this.mTvHonoraryTitle = (TextView) itemView.findViewById(R.id.tv_honorary_title);
            this.mIvMedalOfHonor = (ImageView) itemView.findViewById(R.id.iv_medal_of_honor);
        }

        public final TextView getMTvRanking() {
            return this.mTvRanking;
        }

        public final void setMTvRanking(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvRanking = textView;
        }

        public final TextView getMTvClass() {
            return this.mTvClass;
        }

        public final void setMTvClass(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvClass = textView;
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
            this.mTvHonoraryTitle = textView;
        }

        public final ImageView getMIvMedalOfHonor() {
            return this.mIvMedalOfHonor;
        }

        public final void setMIvMedalOfHonor(ImageView imageView) {
            this.mIvMedalOfHonor = imageView;
        }
    }
}
