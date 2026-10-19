package com.yd.android_brand_mvp.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemBannerHomeVoteBinding;
import com.yd.android_brand_mvp.model.vote.VoteDetailBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.youth.banner.adapter.BannerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BannerVoteAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0018\u0019B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u001a\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/home/BannerVoteAdapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "Lcom/yd/android_brand_mvp/model/vote/VoteDetailBean;", "Lcom/yd/android_brand_mvp/adapter/home/BannerVoteAdapter$BannerViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "callBack", "Lcom/yd/android_brand_mvp/adapter/home/BannerVoteAdapter$VoteBannerListener;", "getContext", "()Landroid/content/Context;", "onBindView", "", "holder", "data", "position", "", InnerConstant.Db.size, "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setListener", "cb", "BannerViewHolder", "VoteBannerListener", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BannerVoteAdapter extends BannerAdapter<VoteDetailBean, BannerViewHolder> {
    private VoteBannerListener callBack;
    private final Context context;

    /* JADX INFO: compiled from: BannerVoteAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/home/BannerVoteAdapter$VoteBannerListener;", "", "clickVoteItem", "", "data", "Lcom/yd/android_brand_mvp/model/vote/VoteDetailBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface VoteBannerListener {
        void clickVoteItem(VoteDetailBean data);
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerVoteAdapter(Context context) {
        super(null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.youth.banner.holder.IViewHolder
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ItemBannerHomeVoteBinding itemBannerHomeVoteBindingInflate = ItemBannerHomeVoteBinding.inflate(LayoutInflater.from(parent != null ? parent.getContext() : null), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemBannerHomeVoteBindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new BannerViewHolder(itemBannerHomeVoteBindingInflate);
    }

    @Override // com.youth.banner.holder.IViewHolder
    public void onBindView(BannerViewHolder holder, VoteDetailBean data, int position, int size) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        ItemBannerHomeVoteBinding binding = holder.getBinding();
        if (data.getUrl().length() > 0) {
            GlideUtil.loadImage(this.context, data.getUrl(), binding.ivItemBannerHomeVote);
        } else {
            GlideUtil.loadImage(this.context, R.mipmap.default_vote_cover, binding.ivItemBannerHomeVote);
        }
        binding.tvItemBannerHomeVote.setText(data.getTitle());
    }

    public final void setListener(VoteBannerListener cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        this.callBack = cb;
    }

    /* JADX INFO: compiled from: BannerVoteAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/home/BannerVoteAdapter$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yd/android_brand_mvp/databinding/ItemBannerHomeVoteBinding;", "(Lcom/yd/android_brand_mvp/databinding/ItemBannerHomeVoteBinding;)V", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/ItemBannerHomeVoteBinding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final ItemBannerHomeVoteBinding binding;

        public final ItemBannerHomeVoteBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(ItemBannerHomeVoteBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }
    }
}
