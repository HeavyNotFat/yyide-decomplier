package com.yd.android_brand_mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.LayoutListBinding;
import com.yd.android_brand_mvp.databinding.LayoutStudentItemBinding;
import com.yd.android_brand_mvp.model.StudentMsgBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.youth.banner.adapter.BannerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BannerStudentMessageAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0012\u00060\u0004R\u00020\u00000\u0001:\u0002\u001b\u001cB+\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0014\u0010\t\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002¢\u0006\u0002\u0010\nJ6\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0018\u00010\u0004R\u00020\u00002\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u001e\u0010\u0016\u001a\u00060\u0004R\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/BannerStudentMessageAdapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "", "Lcom/yd/android_brand_mvp/model/StudentMsgBean$Data0;", "Lcom/yd/android_brand_mvp/adapter/BannerStudentMessageAdapter$BannerViewHolder;", "context", "Landroid/content/Context;", "dataSize", "", "data", "(Landroid/content/Context;ILjava/util/List;)V", "getContext", "()Landroid/content/Context;", "getDataSize", "()I", "mItemClick", "Lcom/yd/android_brand_mvp/adapter/BannerStudentMessageAdapter$ItemClick;", "onBindView", "", "holder", "position", InnerConstant.Db.size, "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemClick", "BannerViewHolder", "ItemClick", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BannerStudentMessageAdapter extends BannerAdapter<List<StudentMsgBean.Data0>, BannerViewHolder> {
    private final Context context;
    private final int dataSize;
    private ItemClick mItemClick;

    /* JADX INFO: compiled from: BannerStudentMessageAdapter.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/BannerStudentMessageAdapter$ItemClick;", "", "onItemClick", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ItemClick {
        void onItemClick();
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getDataSize() {
        return this.dataSize;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerStudentMessageAdapter(Context context, int i, List<List<StudentMsgBean.Data0>> list) {
        super(list);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.dataSize = i;
    }

    @Override // com.youth.banner.holder.IViewHolder
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        LayoutListBinding layoutListBindingInflate = LayoutListBinding.inflate(LayoutInflater.from(parent != null ? parent.getContext() : null), parent, false);
        Intrinsics.checkNotNullExpressionValue(layoutListBindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new BannerViewHolder(this, layoutListBindingInflate);
    }

    @Override // com.youth.banner.holder.IViewHolder
    public void onBindView(BannerViewHolder holder, List<StudentMsgBean.Data0> data, int position, int size) {
        LayoutListBinding binding;
        LayoutListBinding binding2;
        RecyclerView recyclerView = null;
        RecyclerView recyclerView2 = (holder == null || (binding2 = holder.getBinding()) == null) ? null : binding2.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new GridLayoutManager(this.context, this.dataSize));
        }
        if (holder != null && (binding = holder.getBinding()) != null) {
            recyclerView = binding.recyclerView;
        }
        if (recyclerView == null) {
            return;
        }
        recyclerView.setAdapter(new AnonymousClass1(data, this));
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.adapter.BannerStudentMessageAdapter$onBindView$1, reason: invalid class name */
    /* JADX INFO: compiled from: BannerStudentMessageAdapter.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/yd/android_brand_mvp/adapter/BannerStudentMessageAdapter$onBindView$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/StudentMsgBean$Data0;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends BaseQuickAdapter<StudentMsgBean.Data0, BaseViewHolder> {
        final /* synthetic */ BannerStudentMessageAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<StudentMsgBean.Data0> list, BannerStudentMessageAdapter bannerStudentMessageAdapter) {
            super(R.layout.layout_student_item, list);
            this.this$0 = bannerStudentMessageAdapter;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(BaseViewHolder holder, StudentMsgBean.Data0 item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            LayoutStudentItemBinding layoutStudentItemBindingBind = LayoutStudentItemBinding.bind(holder.itemView);
            Intrinsics.checkNotNullExpressionValue(layoutStudentItemBindingBind, "bind(holder.itemView)");
            layoutStudentItemBindingBind.name.setText(item.name);
            layoutStudentItemBindingBind.msg.setText(String.valueOf(item.msgNum));
            GlideUtil.loadCircleHeadImage(getContext(), item.image, layoutStudentItemBindingBind.img);
            LinearLayout root = layoutStudentItemBindingBind.getRoot();
            final BannerStudentMessageAdapter bannerStudentMessageAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.adapter.-$$Lambda$BannerStudentMessageAdapter$onBindView$1$uhuzHBT35xf2Xx4r73BCSkieHqI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BannerStudentMessageAdapter.AnonymousClass1.convert$lambda$0(bannerStudentMessageAdapter, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void convert$lambda$0(BannerStudentMessageAdapter this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ItemClick itemClick = this$0.mItemClick;
            if (itemClick != null) {
                itemClick.onItemClick();
            }
        }
    }

    public final void setItemClick(ItemClick mItemClick) {
        Intrinsics.checkNotNullParameter(mItemClick, "mItemClick");
        this.mItemClick = mItemClick;
    }

    /* JADX INFO: compiled from: BannerStudentMessageAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/BannerStudentMessageAdapter$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yd/android_brand_mvp/databinding/LayoutListBinding;", "(Lcom/yd/android_brand_mvp/adapter/BannerStudentMessageAdapter;Lcom/yd/android_brand_mvp/databinding/LayoutListBinding;)V", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/LayoutListBinding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final LayoutListBinding binding;
        final /* synthetic */ BannerStudentMessageAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(BannerStudentMessageAdapter bannerStudentMessageAdapter, LayoutListBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = bannerStudentMessageAdapter;
            this.binding = binding;
        }

        public final LayoutListBinding getBinding() {
            return this.binding;
        }
    }
}
