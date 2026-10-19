package com.yd.android_brand_mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.databinding.ItemImageBinding;
import com.yd.android_brand_mvp.listener.AdapterListener;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.youth.banner.adapter.BannerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001a\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/ImageAdapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "", "Lcom/yd/android_brand_mvp/adapter/ImageAdapter$BannerViewHolder;", "context", "Landroid/content/Context;", "data", "", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yd/android_brand_mvp/listener/AdapterListener;", "onBindView", "", "holder", "position", "", InnerConstant.Db.size, "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAdapterListener", "setListener", "BannerViewHolder", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ImageAdapter extends BannerAdapter<String, BannerViewHolder> {
    private final Context context;
    private AdapterListener listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageAdapter(Context context, List<String> list) {
        super(list);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: compiled from: ImageAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/ImageAdapter$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yd/android_brand_mvp/databinding/ItemImageBinding;", "(Lcom/yd/android_brand_mvp/databinding/ItemImageBinding;)V", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/ItemImageBinding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final ItemImageBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(ItemImageBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final ItemImageBinding getBinding() {
            return this.binding;
        }
    }

    public final void setAdapterListener(AdapterListener setListener) {
        Intrinsics.checkNotNullParameter(setListener, "setListener");
        this.listener = setListener;
    }

    @Override // com.youth.banner.holder.IViewHolder
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ItemImageBinding itemImageBindingInflate = ItemImageBinding.inflate(LayoutInflater.from(parent != null ? parent.getContext() : null), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemImageBindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new BannerViewHolder(itemImageBindingInflate);
    }

    @Override // com.youth.banner.holder.IViewHolder
    public void onBindView(BannerViewHolder holder, final String data, final int position, int size) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        GlideUtil.loadImageCenterInsideType(this.context, data, holder.getBinding().ivImg);
        holder.getBinding().ivImg.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.adapter.-$$Lambda$ImageAdapter$Oc42vGpYb2AimONn9btLwzeQaik
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImageAdapter.onBindView$lambda$0(this.f$0, position, data, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindView$lambda$0(ImageAdapter this$0, int i, String data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        AdapterListener adapterListener = this$0.listener;
        if (adapterListener != null) {
            adapterListener.setOnclick(i, data);
        }
    }
}
