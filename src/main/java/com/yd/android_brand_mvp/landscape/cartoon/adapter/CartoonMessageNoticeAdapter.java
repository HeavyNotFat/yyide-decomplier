package com.yd.android_brand_mvp.landscape.cartoon.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.databinding.ItemAnnouncementCartoonBinding;
import com.yd.android_brand_mvp.model.getNoticeRsp;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.widget.ImageGetterUtils;
import com.youth.banner.adapter.BannerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CartoonMessageNoticeAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0019\u001aB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ,\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u001e\u0010\u0014\u001a\u00060\u0003R\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/cartoon/adapter/CartoonMessageNoticeAdapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "Lcom/yd/android_brand_mvp/model/getNoticeRsp$DataDTO$RecordsDTO;", "Lcom/yd/android_brand_mvp/landscape/cartoon/adapter/CartoonMessageNoticeAdapter$BannerViewHolder;", "context", "Landroid/content/Context;", "data", "", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "mItemClick", "Lcom/yd/android_brand_mvp/landscape/cartoon/adapter/CartoonMessageNoticeAdapter$ItemClick;", "onBindView", "", "holder", "item", "position", "", InnerConstant.Db.size, "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemClick", "BannerViewHolder", "ItemClick", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CartoonMessageNoticeAdapter extends BannerAdapter<getNoticeRsp.DataDTO.RecordsDTO, BannerViewHolder> {
    private final Context context;
    private ItemClick mItemClick;

    /* JADX INFO: compiled from: CartoonMessageNoticeAdapter.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/cartoon/adapter/CartoonMessageNoticeAdapter$ItemClick;", "", "onItemClick", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ItemClick {
        void onItemClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBindView$lambda$0(View view) {
        return true;
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CartoonMessageNoticeAdapter(Context context, List<getNoticeRsp.DataDTO.RecordsDTO> list) {
        super(list);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.youth.banner.holder.IViewHolder
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ItemAnnouncementCartoonBinding itemAnnouncementCartoonBindingInflate = ItemAnnouncementCartoonBinding.inflate(LayoutInflater.from(parent != null ? parent.getContext() : null), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemAnnouncementCartoonBindingInflate, "inflate(\n            Lay…, parent, false\n        )");
        return new BannerViewHolder(this, itemAnnouncementCartoonBindingInflate);
    }

    @Override // com.youth.banner.holder.IViewHolder
    public void onBindView(BannerViewHolder holder, getNoticeRsp.DataDTO.RecordsDTO item, int position, int size) {
        getNoticeRsp.DataDTO.RecordsDTO.detailsBean detailsbean;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        holder.getBinding().tvPublishTitle.setText(item.title);
        holder.getBinding().tvPublishName.setText(item.identityUserName);
        holder.getBinding().tvPublishTime.setText(item.timerDate);
        String str = null;
        if (item.contentType == 0) {
            holder.getBinding().webview.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.yd.android_brand_mvp.landscape.cartoon.adapter.-$$Lambda$CartoonMessageNoticeAdapter$usXCnk4zYgDq_3_R3ekj4ZAq8KU
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return CartoonMessageNoticeAdapter.onBindView$lambda$0(view);
                }
            });
            holder.getBinding().textHtml.setText(Html.fromHtml(item.content, new ImageGetterUtils.MyImageGetter(this.context, holder.getBinding().textHtml), null));
            holder.getBinding().img.setVisibility(8);
            holder.getBinding().textHtml.setVisibility(0);
            holder.getBinding().gankConstraintlayout.setVisibility(0);
        } else {
            holder.getBinding().gankConstraintlayout.setVisibility(8);
            holder.getBinding().webview.setVisibility(8);
            holder.getBinding().textHtml.setVisibility(8);
            holder.getBinding().img.setVisibility(0);
            Context context = this.context;
            List<getNoticeRsp.DataDTO.RecordsDTO.detailsBean> list = item.details;
            if (list != null && (detailsbean = list.get(0)) != null) {
                str = detailsbean.coverImg;
            }
            if (str == null) {
                str = "";
            }
            GlideUtil.loadNomalImage(context, str, holder.getBinding().img);
        }
        holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.cartoon.adapter.-$$Lambda$CartoonMessageNoticeAdapter$4SfCIduk9L5pT8Ky6LjbS2XJ9zg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CartoonMessageNoticeAdapter.onBindView$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindView$lambda$1(CartoonMessageNoticeAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ItemClick itemClick = this$0.mItemClick;
        if (itemClick != null) {
            itemClick.onItemClick();
        }
    }

    public final void setItemClick(ItemClick mItemClick) {
        Intrinsics.checkNotNullParameter(mItemClick, "mItemClick");
        this.mItemClick = mItemClick;
    }

    /* JADX INFO: compiled from: CartoonMessageNoticeAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/cartoon/adapter/CartoonMessageNoticeAdapter$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yd/android_brand_mvp/databinding/ItemAnnouncementCartoonBinding;", "(Lcom/yd/android_brand_mvp/landscape/cartoon/adapter/CartoonMessageNoticeAdapter;Lcom/yd/android_brand_mvp/databinding/ItemAnnouncementCartoonBinding;)V", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/ItemAnnouncementCartoonBinding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final ItemAnnouncementCartoonBinding binding;
        final /* synthetic */ CartoonMessageNoticeAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(CartoonMessageNoticeAdapter cartoonMessageNoticeAdapter, ItemAnnouncementCartoonBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = cartoonMessageNoticeAdapter;
            this.binding = binding;
        }

        public final ItemAnnouncementCartoonBinding getBinding() {
            return this.binding;
        }
    }
}
