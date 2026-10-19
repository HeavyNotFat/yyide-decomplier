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
import com.yd.android_brand_mvp.databinding.IndexClassMe26AdapterItemBinding;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CycleCurrentMEModel;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: IndexClassMEAdapter26.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/IndexClassMEAdapter26;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/IndexClassMEAdapter26$ViewHolder;", "mContext", "Landroid/content/Context;", "mCycleCurrentMEModels", "", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CycleCurrentMEModel;", "(Landroid/content/Context;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IndexClassMEAdapter26 extends RecyclerView.Adapter<ViewHolder> {
    private final Context mContext;
    private final List<CycleCurrentMEModel> mCycleCurrentMEModels;

    public IndexClassMEAdapter26(Context mContext, List<CycleCurrentMEModel> mCycleCurrentMEModels) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mCycleCurrentMEModels, "mCycleCurrentMEModels");
        this.mContext = mContext;
        this.mCycleCurrentMEModels = mCycleCurrentMEModels;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        IndexClassMe26AdapterItemBinding indexClassMe26AdapterItemBindingInflate = IndexClassMe26AdapterItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(indexClassMe26AdapterItemBindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        ConstraintLayout root = indexClassMe26AdapterItemBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return new ViewHolder(this, root);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CycleCurrentMEModel cycleCurrentMEModel = this.mCycleCurrentMEModels.get(position);
        cycleCurrentMEModel.getMId();
        String mName = cycleCurrentMEModel.getMName();
        int mRanking = cycleCurrentMEModel.getMRanking();
        String mScore = cycleCurrentMEModel.getMScore();
        holder.getMTvRanking().setText(String.valueOf(mRanking));
        GlideUtil.loadCircleHeadImage(this.mContext, cycleCurrentMEModel.getMAvatar(), holder.getMIvClassIcon());
        holder.getMTvClassName().setText(mName);
        TextView mTvScore = holder.getMTvScore();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this.mContext.getResources().getString(R.string.score3);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.resources.getString(R.string.score3)");
        String str = String.format(string, Arrays.copyOf(new Object[]{mScore.toString()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        mTvScore.setText(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mCycleCurrentMEModels.size();
    }

    /* JADX INFO: compiled from: IndexClassMEAdapter26.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/IndexClassMEAdapter26$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/IndexClassMEAdapter26;Landroid/view/View;)V", "mIvClassIcon", "Landroid/widget/ImageView;", "getMIvClassIcon", "()Landroid/widget/ImageView;", "setMIvClassIcon", "(Landroid/widget/ImageView;)V", "mTvClassName", "Landroid/widget/TextView;", "getMTvClassName", "()Landroid/widget/TextView;", "setMTvClassName", "(Landroid/widget/TextView;)V", "mTvRanking", "getMTvRanking", "setMTvRanking", "mTvScore", "getMTvScore", "setMTvScore", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIvClassIcon;
        private TextView mTvClassName;
        private TextView mTvRanking;
        private TextView mTvScore;
        final /* synthetic */ IndexClassMEAdapter26 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(IndexClassMEAdapter26 indexClassMEAdapter26, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = indexClassMEAdapter26;
            View viewFindViewById = itemView.findViewById(R.id.tv_ranking);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(R.id.tv_ranking)");
            this.mTvRanking = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.iv_class_icon);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "itemView.findViewById(R.id.iv_class_icon)");
            this.mIvClassIcon = (ImageView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.tv_class_name);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "itemView.findViewById(R.id.tv_class_name)");
            this.mTvClassName = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R.id.tv_score);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "itemView.findViewById(R.id.tv_score)");
            this.mTvScore = (TextView) viewFindViewById4;
        }

        public final TextView getMTvRanking() {
            return this.mTvRanking;
        }

        public final void setMTvRanking(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvRanking = textView;
        }

        public final ImageView getMIvClassIcon() {
            return this.mIvClassIcon;
        }

        public final void setMIvClassIcon(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mIvClassIcon = imageView;
        }

        public final TextView getMTvClassName() {
            return this.mTvClassName;
        }

        public final void setMTvClassName(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvClassName = textView;
        }

        public final TextView getMTvScore() {
            return this.mTvScore;
        }

        public final void setMTvScore(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvScore = textView;
        }
    }
}
