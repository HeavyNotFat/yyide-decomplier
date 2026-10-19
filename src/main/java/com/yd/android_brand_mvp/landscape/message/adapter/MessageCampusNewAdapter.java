package com.yd.android_brand_mvp.landscape.message.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemMessageCampusBinding;
import com.yd.android_brand_mvp.databinding.LayoutListBinding;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.youth.banner.adapter.BannerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageCampusNewAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0012\u00060\u0004R\u00020\u00000\u0001:\u0002\u0018\u0019B#\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002¢\u0006\u0002\u0010\bJ6\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0018\u00010\u0004R\u00020\u00002\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001e\u0010\u0013\u001a\u00060\u0004R\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/adapter/MessageCampusNewAdapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "Lcom/yd/android_brand_mvp/landscape/message/adapter/MessageCampusNewAdapter$BannerViewHolder;", "context", "Landroid/content/Context;", "data", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "mItemClick", "Lcom/yd/android_brand_mvp/landscape/message/adapter/MessageCampusNewAdapter$ItemClick;", "onBindView", "", "holder", "position", "", InnerConstant.Db.size, "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemClick", "BannerViewHolder", "ItemClick", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageCampusNewAdapter extends BannerAdapter<List<MessageItemBean>, BannerViewHolder> {
    private final Context context;
    private ItemClick mItemClick;

    /* JADX INFO: compiled from: MessageCampusNewAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/adapter/MessageCampusNewAdapter$ItemClick;", "", "onItemClick", "", "mMessageItemBean", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ItemClick {
        void onItemClick(MessageItemBean mMessageItemBean);
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageCampusNewAdapter(Context context, List<List<MessageItemBean>> list) {
        super(list);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.youth.banner.holder.IViewHolder
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        LayoutListBinding layoutListBindingInflate = LayoutListBinding.inflate(LayoutInflater.from(parent != null ? parent.getContext() : null), parent, false);
        Intrinsics.checkNotNullExpressionValue(layoutListBindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new BannerViewHolder(this, layoutListBindingInflate);
    }

    @Override // com.youth.banner.holder.IViewHolder
    public void onBindView(BannerViewHolder holder, List<MessageItemBean> data, int position, int size) {
        LayoutListBinding binding;
        LayoutListBinding binding2;
        LayoutListBinding binding3;
        RecyclerView recyclerView = null;
        if (ScreenUtils.isLandscape()) {
            RecyclerView recyclerView2 = (holder == null || (binding3 = holder.getBinding()) == null) ? null : binding3.recyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setLayoutManager(new GridLayoutManager(this.context, 3));
            }
        } else {
            RecyclerView recyclerView3 = (holder == null || (binding = holder.getBinding()) == null) ? null : binding.recyclerView;
            if (recyclerView3 != null) {
                recyclerView3.setLayoutManager(new GridLayoutManager(this.context, 2));
            }
        }
        if (holder != null && (binding2 = holder.getBinding()) != null) {
            recyclerView = binding2.recyclerView;
        }
        if (recyclerView == null) {
            return;
        }
        recyclerView.setAdapter(new AnonymousClass1(data, this));
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.message.adapter.MessageCampusNewAdapter$onBindView$1, reason: invalid class name */
    /* JADX INFO: compiled from: MessageCampusNewAdapter.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/yd/android_brand_mvp/landscape/message/adapter/MessageCampusNewAdapter$onBindView$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends BaseQuickAdapter<MessageItemBean, BaseViewHolder> {
        final /* synthetic */ MessageCampusNewAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<MessageItemBean> list, MessageCampusNewAdapter messageCampusNewAdapter) {
            super(R.layout.item_message_campus, list);
            this.this$0 = messageCampusNewAdapter;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(BaseViewHolder holder, final MessageItemBean item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            ItemMessageCampusBinding itemMessageCampusBindingBind = ItemMessageCampusBinding.bind(holder.itemView);
            Intrinsics.checkNotNullExpressionValue(itemMessageCampusBindingBind, "bind(holder.itemView)");
            itemMessageCampusBindingBind.tvTitle.setText(item.getTitle());
            GlideUtil.loadImageRadius(getContext(), item.getCoverImg(), itemMessageCampusBindingBind.ivImg, R.drawable.icon_message_campus_defualt, SizeUtils.dp2px(10.0f));
            ConstraintLayout root = itemMessageCampusBindingBind.getRoot();
            final MessageCampusNewAdapter messageCampusNewAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.adapter.-$$Lambda$MessageCampusNewAdapter$onBindView$1$psrld1yf5C9HjIzp04_df69FZGU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MessageCampusNewAdapter.AnonymousClass1.convert$lambda$0(messageCampusNewAdapter, item, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void convert$lambda$0(MessageCampusNewAdapter this$0, MessageItemBean item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            ItemClick itemClick = this$0.mItemClick;
            if (itemClick != null) {
                itemClick.onItemClick(item);
            }
        }
    }

    public final void setItemClick(ItemClick mItemClick) {
        Intrinsics.checkNotNullParameter(mItemClick, "mItemClick");
        this.mItemClick = mItemClick;
    }

    /* JADX INFO: compiled from: MessageCampusNewAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/adapter/MessageCampusNewAdapter$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yd/android_brand_mvp/databinding/LayoutListBinding;", "(Lcom/yd/android_brand_mvp/landscape/message/adapter/MessageCampusNewAdapter;Lcom/yd/android_brand_mvp/databinding/LayoutListBinding;)V", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/LayoutListBinding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final LayoutListBinding binding;
        final /* synthetic */ MessageCampusNewAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(MessageCampusNewAdapter messageCampusNewAdapter, LayoutListBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = messageCampusNewAdapter;
            this.binding = binding;
        }

        public final LayoutListBinding getBinding() {
            return this.binding;
        }
    }
}
