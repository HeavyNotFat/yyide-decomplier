package com.yd.android_brand_mvp.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemBannerImageBinding;
import com.youth.banner.adapter.BannerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BannerImageAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/home/BannerImageAdapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "", "Lcom/yd/android_brand_mvp/adapter/home/BannerImageAdapter$BannerViewHolder;", "context", "Landroid/content/Context;", "data", "", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "getData", "()Ljava/util/List;", "onBindView", "", "holder", "position", "", InnerConstant.Db.size, "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "BannerViewHolder", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BannerImageAdapter extends BannerAdapter<String, BannerViewHolder> {
    private final Context context;
    private final List<String> data;

    public /* synthetic */ BannerImageAdapter(Context context, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : list);
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<String> getData() {
        return this.data;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerImageAdapter(Context context, List<String> list) {
        super(list);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.data = list;
    }

    /* JADX INFO: compiled from: BannerImageAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/home/BannerImageAdapter$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yd/android_brand_mvp/databinding/ItemBannerImageBinding;", "(Lcom/yd/android_brand_mvp/databinding/ItemBannerImageBinding;)V", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/ItemBannerImageBinding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final ItemBannerImageBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(ItemBannerImageBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final ItemBannerImageBinding getBinding() {
            return this.binding;
        }
    }

    @Override // com.youth.banner.holder.IViewHolder
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemBannerImageBinding itemBannerImageBindingInflate = ItemBannerImageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemBannerImageBindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new BannerViewHolder(itemBannerImageBindingInflate);
    }

    @Override // com.youth.banner.holder.IViewHolder
    public void onBindView(BannerViewHolder holder, String data, int position, int size) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        Glide.with(this.context).load(data).error(R.drawable.defualt_placeholderl).placeholder(R.drawable.defualt_placeholderl).into(holder.getBinding().ivItemBannerImage);
    }
}
