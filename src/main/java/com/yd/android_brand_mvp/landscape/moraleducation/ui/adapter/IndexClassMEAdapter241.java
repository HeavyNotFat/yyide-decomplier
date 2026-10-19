package com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.IndexClassMe241AdapterItemBinding;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CurrentMEModel;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IndexClassMEAdapter241.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0015\u0016B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/IndexClassMEAdapter241;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/IndexClassMEAdapter241$ViewHolder;", "mContext", "Landroid/content/Context;", "mCurrentMEModels", "", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;", "mOnItemClickListener", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/IndexClassMEAdapter241$OnItemClickListener;", "(Landroid/content/Context;Ljava/util/List;Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/IndexClassMEAdapter241$OnItemClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OnItemClickListener", "ViewHolder", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IndexClassMEAdapter241 extends RecyclerView.Adapter<ViewHolder> {
    private final Context mContext;
    private final List<CurrentMEModel> mCurrentMEModels;
    private final OnItemClickListener mOnItemClickListener;

    /* JADX INFO: compiled from: IndexClassMEAdapter241.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/IndexClassMEAdapter241$OnItemClickListener;", "", "onItemClicked", "", "view", "Landroid/view/View;", "currentMEModel", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnItemClickListener {
        void onItemClicked(View view, CurrentMEModel currentMEModel);
    }

    public IndexClassMEAdapter241(Context mContext, List<CurrentMEModel> mCurrentMEModels, OnItemClickListener mOnItemClickListener) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mCurrentMEModels, "mCurrentMEModels");
        Intrinsics.checkNotNullParameter(mOnItemClickListener, "mOnItemClickListener");
        this.mContext = mContext;
        this.mCurrentMEModels = mCurrentMEModels;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        IndexClassMe241AdapterItemBinding indexClassMe241AdapterItemBindingInflate = IndexClassMe241AdapterItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        Intrinsics.checkNotNullExpressionValue(indexClassMe241AdapterItemBindingInflate, "inflate(LayoutInflater.from(parent.context))");
        LinearLayout root = indexClassMe241AdapterItemBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return new ViewHolder(this, root);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final CurrentMEModel currentMEModel = this.mCurrentMEModels.get(position);
        GlideUtil.loadImage(this.mContext, currentMEModel.getMMedalUrl(), holder.getMIvWeekCycle());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.-$$Lambda$IndexClassMEAdapter241$Ho7JGdSXuFHcp4pZGAIujKup77U
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IndexClassMEAdapter241.onBindViewHolder$lambda$0(this.f$0, currentMEModel, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(IndexClassMEAdapter241 this$0, CurrentMEModel currentMEModel, View it2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentMEModel, "$currentMEModel");
        OnItemClickListener onItemClickListener = this$0.mOnItemClickListener;
        Intrinsics.checkNotNullExpressionValue(it2, "it");
        onItemClickListener.onItemClicked(it2, currentMEModel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mCurrentMEModels.size();
    }

    /* JADX INFO: compiled from: IndexClassMEAdapter241.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/IndexClassMEAdapter241$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/IndexClassMEAdapter241;Landroid/view/View;)V", "mIvWeekCycle", "Landroid/widget/ImageView;", "getMIvWeekCycle", "()Landroid/widget/ImageView;", "setMIvWeekCycle", "(Landroid/widget/ImageView;)V", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIvWeekCycle;
        final /* synthetic */ IndexClassMEAdapter241 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(IndexClassMEAdapter241 indexClassMEAdapter241, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = indexClassMEAdapter241;
            View viewFindViewById = itemView.findViewById(R.id.iv_medal_of_honor);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(R.id.iv_medal_of_honor)");
            this.mIvWeekCycle = (ImageView) viewFindViewById;
        }

        public final ImageView getMIvWeekCycle() {
            return this.mIvWeekCycle;
        }

        public final void setMIvWeekCycle(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mIvWeekCycle = imageView;
        }
    }
}
