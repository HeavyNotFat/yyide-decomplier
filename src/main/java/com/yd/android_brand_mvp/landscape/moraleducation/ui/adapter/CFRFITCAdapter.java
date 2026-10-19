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
import com.yd.android_brand_mvp.databinding.CfrfInThisClassAdapterItemBinding;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CurrentMEModel;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CFRFITCAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/CFRFITCAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/CFRFITCAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "mCurrentMEModels", "", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;", "(Landroid/content/Context;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CFRFITCAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Context mContext;
    private final List<CurrentMEModel> mCurrentMEModels;

    public CFRFITCAdapter(Context mContext, List<CurrentMEModel> mCurrentMEModels) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mCurrentMEModels, "mCurrentMEModels");
        this.mContext = mContext;
        this.mCurrentMEModels = mCurrentMEModels;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        CfrfInThisClassAdapterItemBinding cfrfInThisClassAdapterItemBindingInflate = CfrfInThisClassAdapterItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(cfrfInThisClassAdapterItemBindingInflate, "inflate(\n            Lay…          false\n        )");
        LinearLayout root = cfrfInThisClassAdapterItemBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return new ViewHolder(this, root);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CurrentMEModel currentMEModel = this.mCurrentMEModels.get(position);
        GlideUtil.loadImage(this.mContext, currentMEModel.getMMedalUrl(), holder.getMIvMedalOfHonor());
        holder.getMTvWeekCycle().setText(currentMEModel.getMCycle());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mCurrentMEModels.size();
    }

    /* JADX INFO: compiled from: CFRFITCAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/CFRFITCAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/CFRFITCAdapter;Landroid/view/View;)V", "mIvMedalOfHonor", "Landroid/widget/ImageView;", "getMIvMedalOfHonor", "()Landroid/widget/ImageView;", "setMIvMedalOfHonor", "(Landroid/widget/ImageView;)V", "mTvWeekCycle", "Landroid/widget/TextView;", "getMTvWeekCycle", "()Landroid/widget/TextView;", "setMTvWeekCycle", "(Landroid/widget/TextView;)V", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIvMedalOfHonor;
        private TextView mTvWeekCycle;
        final /* synthetic */ CFRFITCAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(CFRFITCAdapter cFRFITCAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = cFRFITCAdapter;
            View viewFindViewById = itemView.findViewById(R.id.iv_medal_of_honor);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(R.id.iv_medal_of_honor)");
            this.mIvMedalOfHonor = (ImageView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.tv_week_cycle);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "itemView.findViewById(R.id.tv_week_cycle)");
            this.mTvWeekCycle = (TextView) viewFindViewById2;
        }

        public final ImageView getMIvMedalOfHonor() {
            return this.mIvMedalOfHonor;
        }

        public final void setMIvMedalOfHonor(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mIvMedalOfHonor = imageView;
        }

        public final TextView getMTvWeekCycle() {
            return this.mTvWeekCycle;
        }

        public final void setMTvWeekCycle(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvWeekCycle = textView;
        }
    }
}
