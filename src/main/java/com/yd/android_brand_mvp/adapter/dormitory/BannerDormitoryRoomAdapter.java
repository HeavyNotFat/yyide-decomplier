package com.yd.android_brand_mvp.adapter.dormitory;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.databinding.ItemBannerDormitoryRankingRoomBinding;
import com.yd.android_brand_mvp.model.dormitory.DormitoryEducationItemBean;
import com.youth.banner.adapter.BannerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BannerDormitoryRoomAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/dormitory/BannerDormitoryRoomAdapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "Lcom/yd/android_brand_mvp/model/dormitory/DormitoryEducationItemBean;", "Lcom/yd/android_brand_mvp/adapter/dormitory/BannerDormitoryRoomAdapter$BannerViewHolder;", "()V", "onBindView", "", "holder", "data", "position", "", InnerConstant.Db.size, "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "BannerViewHolder", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BannerDormitoryRoomAdapter extends BannerAdapter<DormitoryEducationItemBean, BannerViewHolder> {
    public BannerDormitoryRoomAdapter() {
        super(null);
    }

    /* JADX INFO: compiled from: BannerDormitoryRoomAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/dormitory/BannerDormitoryRoomAdapter$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yd/android_brand_mvp/databinding/ItemBannerDormitoryRankingRoomBinding;", "(Lcom/yd/android_brand_mvp/databinding/ItemBannerDormitoryRankingRoomBinding;)V", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/ItemBannerDormitoryRankingRoomBinding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final ItemBannerDormitoryRankingRoomBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(ItemBannerDormitoryRankingRoomBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final ItemBannerDormitoryRankingRoomBinding getBinding() {
            return this.binding;
        }
    }

    @Override // com.youth.banner.holder.IViewHolder
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ItemBannerDormitoryRankingRoomBinding itemBannerDormitoryRankingRoomBindingInflate = ItemBannerDormitoryRankingRoomBinding.inflate(LayoutInflater.from(parent != null ? parent.getContext() : null), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemBannerDormitoryRankingRoomBindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new BannerViewHolder(itemBannerDormitoryRankingRoomBindingInflate);
    }

    @Override // com.youth.banner.holder.IViewHolder
    public void onBindView(BannerViewHolder holder, DormitoryEducationItemBean data, int position, int size) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        ItemBannerDormitoryRankingRoomBinding binding = holder.getBinding();
        binding.tvItemRankingRoomName.setText(data.getTargetName());
        binding.tvItemRankingRoomScore.setText(data.getGoal() + (char) 20998);
    }
}
