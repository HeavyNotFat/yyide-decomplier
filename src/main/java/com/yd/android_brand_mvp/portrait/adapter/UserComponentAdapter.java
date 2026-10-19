package com.yd.android_brand_mvp.portrait.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.LayoutCenterMenuBinding;
import com.yd.android_brand_mvp.databinding.LayoutListBinding;
import com.youth.banner.adapter.BannerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserComponentAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0012\u00060\u0004R\u00020\u00000\u0001:\u0002\u0015\u0016B\u0005¢\u0006\u0002\u0010\u0005J4\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0018\u00010\u0004R\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001e\u0010\u0010\u001a\u00060\u0004R\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/yd/android_brand_mvp/portrait/adapter/UserComponentAdapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "", "", "Lcom/yd/android_brand_mvp/portrait/adapter/UserComponentAdapter$BannerViewHolder;", "()V", "mItemClick", "Lcom/yd/android_brand_mvp/portrait/adapter/UserComponentAdapter$ItemClick;", "selectPosition", "onBindView", "", "holder", "data", "position", "", InnerConstant.Db.size, "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemClick", "BannerViewHolder", "ItemClick", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UserComponentAdapter extends BannerAdapter<List<String>, BannerViewHolder> {
    private ItemClick mItemClick;
    private String selectPosition;

    /* JADX INFO: compiled from: UserComponentAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/portrait/adapter/UserComponentAdapter$ItemClick;", "", "onItemClick", "", "position", "", "item", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ItemClick {
        void onItemClick(int position, String item);
    }

    public UserComponentAdapter() {
        super(null);
        this.selectPosition = "课表";
    }

    @Override // com.youth.banner.holder.IViewHolder
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        LayoutListBinding layoutListBindingInflate = LayoutListBinding.inflate(LayoutInflater.from(parent != null ? parent.getContext() : null), parent, false);
        Intrinsics.checkNotNullExpressionValue(layoutListBindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new BannerViewHolder(this, layoutListBindingInflate);
    }

    @Override // com.youth.banner.holder.IViewHolder
    public void onBindView(BannerViewHolder holder, List<String> data, int position, int size) {
        LayoutListBinding binding;
        View view;
        LayoutListBinding binding2;
        Intrinsics.checkNotNullParameter(data, "data");
        RecyclerView recyclerView = null;
        RecyclerView recyclerView2 = (holder == null || (binding2 = holder.getBinding()) == null) ? null : binding2.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new GridLayoutManager((holder == null || (view = holder.itemView) == null) ? null : view.getContext(), 5));
        }
        if (holder != null && (binding = holder.getBinding()) != null) {
            recyclerView = binding.recyclerView;
        }
        if (recyclerView == null) {
            return;
        }
        recyclerView.setAdapter(new AnonymousClass1(data, this, position));
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.portrait.adapter.UserComponentAdapter$onBindView$1, reason: invalid class name */
    /* JADX INFO: compiled from: UserComponentAdapter.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/yd/android_brand_mvp/portrait/adapter/UserComponentAdapter$onBindView$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends BaseQuickAdapter<String, BaseViewHolder> {
        final /* synthetic */ int $position;
        final /* synthetic */ UserComponentAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<String> list, UserComponentAdapter userComponentAdapter, int i) {
            super(R.layout.layout_center_menu, list);
            this.this$0 = userComponentAdapter;
            this.$position = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(BaseViewHolder holder, final String item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            final LayoutCenterMenuBinding layoutCenterMenuBindingBind = LayoutCenterMenuBinding.bind(holder.itemView);
            Intrinsics.checkNotNullExpressionValue(layoutCenterMenuBindingBind, "bind(holder.itemView)");
            layoutCenterMenuBindingBind.check.setText(item);
            switch (item.hashCode()) {
                case -1650280233:
                    if (item.equals("我的积分卡")) {
                        layoutCenterMenuBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab_point_card);
                    }
                    break;
                case 803305:
                    if (item.equals("报修")) {
                        layoutCenterMenuBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab_repair);
                    }
                    break;
                case 893927:
                    if (item.equals("消息")) {
                        layoutCenterMenuBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab3);
                    }
                    break;
                case 966599:
                    if (item.equals("留言")) {
                        layoutCenterMenuBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab1);
                    }
                    break;
                case 1051698:
                    if (item.equals("考试")) {
                        layoutCenterMenuBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab_exam);
                    }
                    break;
                case 1131312:
                    if (item.equals("请假")) {
                        layoutCenterMenuBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab2);
                    }
                    break;
                case 1145898:
                    if (item.equals("课表")) {
                        layoutCenterMenuBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab1);
                    }
                    break;
                case 616564054:
                    if (item.equals("个人荣誉")) {
                        layoutCenterMenuBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab4);
                    }
                    break;
                case 771029748:
                    if (item.equals("打卡任务")) {
                        layoutCenterMenuBindingBind.checkImg.setBackgroundResource(R.drawable.user_sign_task_tab4);
                    }
                    break;
                case 777748296:
                    if (item.equals("我的勋章")) {
                        layoutCenterMenuBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab_medal);
                    }
                    break;
                case 777864155:
                    if (item.equals("我的报名")) {
                        layoutCenterMenuBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab12);
                    }
                    break;
                case 778048458:
                    if (item.equals("我的积分")) {
                        layoutCenterMenuBindingBind.checkImg.setBackgroundResource(R.drawable.user_tab_point);
                    }
                    break;
            }
            layoutCenterMenuBindingBind.check.setChecked(Intrinsics.areEqual(this.this$0.selectPosition, item));
            layoutCenterMenuBindingBind.checkImg.setChecked(Intrinsics.areEqual(this.this$0.selectPosition, item));
            ConstraintLayout root = layoutCenterMenuBindingBind.getRoot();
            final int i = this.$position;
            final UserComponentAdapter userComponentAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.portrait.adapter.-$$Lambda$UserComponentAdapter$onBindView$1$M_8s4WsDoON4fq8OV-GChchnXFM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserComponentAdapter.AnonymousClass1.convert$lambda$0(i, layoutCenterMenuBindingBind, userComponentAdapter, item, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void convert$lambda$0(int i, LayoutCenterMenuBinding viewBinding, UserComponentAdapter this$0, String item, AnonymousClass1 this$1, View view) {
            Intrinsics.checkNotNullParameter(viewBinding, "$viewBinding");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Log.d("UserComponentAdapter", "position = " + i);
            viewBinding.check.setChecked(true);
            viewBinding.checkImg.setChecked(true);
            this$0.selectPosition = item;
            this$1.notifyDataSetChanged();
            ItemClick itemClick = this$0.mItemClick;
            if (itemClick != null) {
                itemClick.onItemClick(i, item);
            }
        }
    }

    public final void setItemClick(ItemClick mItemClick) {
        Intrinsics.checkNotNullParameter(mItemClick, "mItemClick");
        this.mItemClick = mItemClick;
    }

    /* JADX INFO: compiled from: UserComponentAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/portrait/adapter/UserComponentAdapter$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yd/android_brand_mvp/databinding/LayoutListBinding;", "(Lcom/yd/android_brand_mvp/portrait/adapter/UserComponentAdapter;Lcom/yd/android_brand_mvp/databinding/LayoutListBinding;)V", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/LayoutListBinding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final LayoutListBinding binding;
        final /* synthetic */ UserComponentAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(UserComponentAdapter userComponentAdapter, LayoutListBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = userComponentAdapter;
            this.binding = binding;
        }

        public final LayoutListBinding getBinding() {
            return this.binding;
        }
    }
}
