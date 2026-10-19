package com.yd.android_brand_mvp.adapter.consult;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.databinding.LayoutListBinding;
import com.yd.android_brand_mvp.model.consult.ConsultTeacherBean;
import com.youth.banner.adapter.BannerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Consult6x2Adapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0012\u00060\u0004R\u00020\u00000\u0001:\u0002\u0014\u0015B\u0005¢\u0006\u0002\u0010\u0005J6\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0018\u00010\u0004R\u00020\u00002\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001e\u0010\u000f\u001a\u00060\u0004R\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/consult/Consult6x2Adapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "", "Lcom/yd/android_brand_mvp/model/consult/ConsultTeacherBean;", "Lcom/yd/android_brand_mvp/adapter/consult/Consult6x2Adapter$BannerViewHolder;", "()V", "mOnItemClickCallback", "Lcom/yd/android_brand_mvp/adapter/consult/Consult6x2Adapter$OnItemClickCallback;", "onBindView", "", "holder", "data", "position", "", InnerConstant.Db.size, "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickCallback", "BannerViewHolder", "OnItemClickCallback", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Consult6x2Adapter extends BannerAdapter<List<ConsultTeacherBean>, BannerViewHolder> {
    private OnItemClickCallback mOnItemClickCallback;

    /* JADX INFO: compiled from: Consult6x2Adapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/consult/Consult6x2Adapter$OnItemClickCallback;", "", "itemClick", "", "userId", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnItemClickCallback {
        void itemClick(String userId);
    }

    public Consult6x2Adapter() {
        super(null);
    }

    @Override // com.youth.banner.holder.IViewHolder
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        LayoutListBinding layoutListBindingInflate = LayoutListBinding.inflate(LayoutInflater.from(parent != null ? parent.getContext() : null), parent, false);
        Intrinsics.checkNotNullExpressionValue(layoutListBindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new BannerViewHolder(this, layoutListBindingInflate);
    }

    @Override // com.youth.banner.holder.IViewHolder
    public void onBindView(BannerViewHolder holder, List<ConsultTeacherBean> data, int position, int size) {
        if (holder != null) {
            holder.getBinding().recyclerView.setLayoutManager(new GridLayoutManager(holder.itemView.getContext(), 6));
            holder.getBinding().recyclerView.setAdapter(new Consult6x2Adapter$onBindView$1$1(data, this));
        }
    }

    public final void setOnItemClickCallback(OnItemClickCallback mOnItemClickCallback) {
        Intrinsics.checkNotNullParameter(mOnItemClickCallback, "mOnItemClickCallback");
        this.mOnItemClickCallback = mOnItemClickCallback;
    }

    /* JADX INFO: compiled from: Consult6x2Adapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/consult/Consult6x2Adapter$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yd/android_brand_mvp/databinding/LayoutListBinding;", "(Lcom/yd/android_brand_mvp/adapter/consult/Consult6x2Adapter;Lcom/yd/android_brand_mvp/databinding/LayoutListBinding;)V", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/LayoutListBinding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final LayoutListBinding binding;
        final /* synthetic */ Consult6x2Adapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(Consult6x2Adapter consult6x2Adapter, LayoutListBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = consult6x2Adapter;
            this.binding = binding;
        }

        public final LayoutListBinding getBinding() {
            return this.binding;
        }
    }
}
