package com.yd.android_brand_mvp.adapter.active;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemActiveApplyDetailsBinding;
import com.yd.android_brand_mvp.databinding.LayoutListBinding;
import com.yd.android_brand_mvp.model.active.ActiveDetailsBean;
import com.yd.android_brand_mvp.model.active.ActiveEnrollSubBean;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.youth.banner.adapter.BannerAdapter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActiveDetailsListAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0012\u00060\u0004R\u00020\u00000\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0005J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J4\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0018\u00010\u0004R\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u001e\u0010\u0014\u001a\u00060\u0004R\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u0006\u0010\u0018\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/active/ActiveDetailsListAdapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "", "Lcom/yd/android_brand_mvp/model/active/ActiveEnrollSubBean;", "Lcom/yd/android_brand_mvp/adapter/active/ActiveDetailsListAdapter$BannerViewHolder;", "()V", "dataDetails", "Lcom/yd/android_brand_mvp/model/active/ActiveDetailsBean;", "selectList", "selectMap", "", "", "", "getCheckBoxList", "onBindView", "", "holder", "data", "position", InnerConstant.Db.size, "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeCheckBoxList", "setDataDetails", "BannerViewHolder", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActiveDetailsListAdapter extends BannerAdapter<List<ActiveEnrollSubBean>, BannerViewHolder> {
    private ActiveDetailsBean dataDetails;
    private List<ActiveEnrollSubBean> selectList;
    private final Map<Integer, Boolean> selectMap;

    public ActiveDetailsListAdapter() {
        super(null);
        this.selectList = new ArrayList();
        this.selectMap = new LinkedHashMap();
    }

    @Override // com.youth.banner.holder.IViewHolder
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        LayoutListBinding layoutListBindingInflate = LayoutListBinding.inflate(LayoutInflater.from(parent != null ? parent.getContext() : null), parent, false);
        Intrinsics.checkNotNullExpressionValue(layoutListBindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new BannerViewHolder(this, layoutListBindingInflate);
    }

    @Override // com.youth.banner.holder.IViewHolder
    public void onBindView(BannerViewHolder holder, List<ActiveEnrollSubBean> data, int position, int size) {
        View view;
        LayoutListBinding binding;
        LayoutListBinding binding2;
        View view2;
        LayoutListBinding binding3;
        Intrinsics.checkNotNullParameter(data, "data");
        RecyclerView recyclerView = null;
        if (ScreenUtils.isPortrait()) {
            RecyclerView recyclerView2 = (holder == null || (binding3 = holder.getBinding()) == null) ? null : binding3.recyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setLayoutManager(new GridLayoutManager((holder == null || (view2 = holder.itemView) == null) ? null : view2.getContext(), 3));
            }
        } else {
            RecyclerView recyclerView3 = (holder == null || (binding = holder.getBinding()) == null) ? null : binding.recyclerView;
            if (recyclerView3 != null) {
                recyclerView3.setLayoutManager(new GridLayoutManager((holder == null || (view = holder.itemView) == null) ? null : view.getContext(), 4));
            }
        }
        if (holder != null && (binding2 = holder.getBinding()) != null) {
            recyclerView = binding2.recyclerView;
        }
        if (recyclerView == null) {
            return;
        }
        recyclerView.setAdapter(new AnonymousClass1(data, this, position));
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.adapter.active.ActiveDetailsListAdapter$onBindView$1, reason: invalid class name */
    /* JADX INFO: compiled from: ActiveDetailsListAdapter.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/yd/android_brand_mvp/adapter/active/ActiveDetailsListAdapter$onBindView$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/active/ActiveEnrollSubBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends BaseQuickAdapter<ActiveEnrollSubBean, BaseViewHolder> {
        final /* synthetic */ int $position;
        final /* synthetic */ ActiveDetailsListAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<ActiveEnrollSubBean> list, ActiveDetailsListAdapter activeDetailsListAdapter, int i) {
            super(R.layout.item_active_apply_details, list);
            this.this$0 = activeDetailsListAdapter;
            this.$position = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code duplicated, block: B:22:0x0116  */
        /* JADX WARN: Code duplicated, block: B:24:0x0122  */
        /* JADX WARN: Code duplicated, block: B:29:0x0132  */
        /* JADX WARN: Code duplicated, block: B:31:0x0135  */
        /* JADX WARN: Code duplicated, block: B:51:0x0184  */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(BaseViewHolder holder, final ActiveEnrollSubBean item) {
            ActiveDetailsBean activeDetailsBean;
            boolean z;
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            final ItemActiveApplyDetailsBinding itemActiveApplyDetailsBindingBind = ItemActiveApplyDetailsBinding.bind(holder.itemView);
            Intrinsics.checkNotNullExpressionValue(itemActiveApplyDetailsBindingBind, "bind(holder.itemView)");
            itemActiveApplyDetailsBindingBind.tvActiveTitle.setText(item.getSubName());
            if (item.getNumQuantity() == 0) {
                itemActiveApplyDetailsBindingBind.tvActiveRestrictNumber.setText("不限制");
            } else {
                itemActiveApplyDetailsBindingBind.tvActiveRestrictNumber.setText("" + item.getNumQuantity());
            }
            itemActiveApplyDetailsBindingBind.tvActiveAlreadyNumber.setText("" + item.getSubEnrollCount());
            TextView textView = itemActiveApplyDetailsBindingBind.tvActiveStatus;
            Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.tvActiveStatus");
            SimpleUtilsKt.remove(textView);
            CheckBox checkBox = itemActiveApplyDetailsBindingBind.checkbox;
            Intrinsics.checkNotNullExpressionValue(checkBox, "viewBinding.checkbox");
            SimpleUtilsKt.remove(checkBox);
            CheckBox checkBox2 = itemActiveApplyDetailsBindingBind.checkbox;
            final ActiveDetailsListAdapter activeDetailsListAdapter = this.this$0;
            checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.yd.android_brand_mvp.adapter.active.-$$Lambda$ActiveDetailsListAdapter$onBindView$1$IsWwCHAuM3DhVWZggGO4GSAgkNs
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    ActiveDetailsListAdapter.AnonymousClass1.convert$lambda$0(activeDetailsListAdapter, item, compoundButton, z2);
                }
            });
            ConstraintLayout root = itemActiveApplyDetailsBindingBind.getRoot();
            final ActiveDetailsListAdapter activeDetailsListAdapter2 = this.this$0;
            final int i = this.$position;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.adapter.active.-$$Lambda$ActiveDetailsListAdapter$onBindView$1$vdqFwIRFy_IKq7VE4jzbYbk0wr0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ActiveDetailsListAdapter.AnonymousClass1.convert$lambda$1(itemActiveApplyDetailsBindingBind, activeDetailsListAdapter2, i, view);
                }
            });
            boolean z2 = false;
            if (this.this$0.selectMap.get(Integer.valueOf(this.$position)) == null) {
                this.this$0.selectMap.put(Integer.valueOf(this.$position), false);
            }
            Boolean bool = (Boolean) this.this$0.selectMap.get(Integer.valueOf(this.$position));
            if (bool != null) {
                itemActiveApplyDetailsBindingBind.checkbox.setChecked(bool.booleanValue());
            }
            itemActiveApplyDetailsBindingBind.checkbox.setBackgroundResource(R.drawable.checkbox_selector_invalid);
            if (!TextUtils.isEmpty(item.getSubUserEnrollStatus())) {
                ActiveDetailsBean activeDetailsBean2 = this.this$0.dataDetails;
                if (activeDetailsBean2 != null && activeDetailsBean2.getSubType() == 1) {
                    CheckBox checkBox3 = itemActiveApplyDetailsBindingBind.checkbox;
                    Intrinsics.checkNotNullExpressionValue(checkBox3, "viewBinding.checkbox");
                    SimpleUtilsKt.show(checkBox3);
                    itemActiveApplyDetailsBindingBind.checkbox.setClickable(false);
                } else if (!TextUtils.isEmpty(item.getSubUserEnrollStatus())) {
                    activeDetailsBean = this.this$0.dataDetails;
                    if (activeDetailsBean == null) {
                        z = false;
                    } else {
                        z = false;
                    }
                    if (z) {
                        itemActiveApplyDetailsBindingBind.checkbox.setClickable(true);
                        CheckBox checkBox4 = itemActiveApplyDetailsBindingBind.checkbox;
                        Intrinsics.checkNotNullExpressionValue(checkBox4, "viewBinding.checkbox");
                        SimpleUtilsKt.show(checkBox4);
                    }
                }
            } else if (!TextUtils.isEmpty(item.getSubUserEnrollStatus())) {
                activeDetailsBean = this.this$0.dataDetails;
                if (activeDetailsBean == null && activeDetailsBean.getSubType() == 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    itemActiveApplyDetailsBindingBind.checkbox.setClickable(true);
                    CheckBox checkBox5 = itemActiveApplyDetailsBindingBind.checkbox;
                    Intrinsics.checkNotNullExpressionValue(checkBox5, "viewBinding.checkbox");
                    SimpleUtilsKt.show(checkBox5);
                }
            }
            ActiveDetailsBean activeDetailsBean3 = this.this$0.dataDetails;
            if (TextUtils.isEmpty(activeDetailsBean3 != null ? activeDetailsBean3.getUserEnrollStatus() : null)) {
                ActiveDetailsBean activeDetailsBean4 = this.this$0.dataDetails;
                if (TextUtils.isEmpty(activeDetailsBean4 != null ? activeDetailsBean4.getUserEnrollStatus() : null)) {
                    ActiveDetailsBean activeDetailsBean5 = this.this$0.dataDetails;
                    if (activeDetailsBean5 != null && activeDetailsBean5.getSubType() == 2) {
                        TextView textView2 = itemActiveApplyDetailsBindingBind.tvActiveStatus;
                        Intrinsics.checkNotNullExpressionValue(textView2, "viewBinding.tvActiveStatus");
                        SimpleUtilsKt.show(textView2);
                    }
                }
            } else {
                TextView textView3 = itemActiveApplyDetailsBindingBind.tvActiveStatus;
                Intrinsics.checkNotNullExpressionValue(textView3, "viewBinding.tvActiveStatus");
                SimpleUtilsKt.show(textView3);
            }
            itemActiveApplyDetailsBindingBind.tvActiveStatus.setTextColor(getContext().getResources().getColor(R.color.color_87858F));
            ActiveDetailsBean activeDetailsBean6 = this.this$0.dataDetails;
            String userEnrollStatus = activeDetailsBean6 != null ? activeDetailsBean6.getUserEnrollStatus() : null;
            ActiveDetailsBean activeDetailsBean7 = this.this$0.dataDetails;
            if (activeDetailsBean7 != null && activeDetailsBean7.getSubType() == 2) {
                z2 = true;
            }
            if (z2) {
                userEnrollStatus = item.getSubUserEnrollStatus();
            }
            if (userEnrollStatus != null) {
                switch (userEnrollStatus.hashCode()) {
                    case 48:
                        if (userEnrollStatus.equals("0")) {
                            itemActiveApplyDetailsBindingBind.tvActiveStatus.setText("未开始");
                            return;
                        }
                        break;
                    case 49:
                        if (userEnrollStatus.equals("1")) {
                            itemActiveApplyDetailsBindingBind.tvActiveStatus.setText("可报名");
                            itemActiveApplyDetailsBindingBind.checkbox.setClickable(true);
                            itemActiveApplyDetailsBindingBind.checkbox.setBackgroundResource(R.drawable.checkbox_selector);
                            itemActiveApplyDetailsBindingBind.tvActiveStatus.setTextColor(getContext().getResources().getColor(R.color.color_00B781));
                            return;
                        }
                        break;
                    case 50:
                        if (userEnrollStatus.equals("2")) {
                            itemActiveApplyDetailsBindingBind.tvActiveStatus.setText("无资格");
                            return;
                        }
                        break;
                    case 51:
                        if (userEnrollStatus.equals("3")) {
                            itemActiveApplyDetailsBindingBind.tvActiveStatus.setText("名额已满");
                            return;
                        }
                        break;
                    case 52:
                        if (userEnrollStatus.equals("4")) {
                            itemActiveApplyDetailsBindingBind.tvActiveStatus.setText("已报名");
                            itemActiveApplyDetailsBindingBind.tvActiveStatus.setTextColor(getContext().getResources().getColor(R.color.colorPrimaryDark));
                            return;
                        }
                        break;
                    case 53:
                        if (userEnrollStatus.equals(ConversionUtil.conditionWithSeriesName)) {
                            itemActiveApplyDetailsBindingBind.tvActiveStatus.setText("已结束");
                            return;
                        }
                        break;
                    case 54:
                        if (userEnrollStatus.equals(ConversionUtil.conditionWithCallNumber)) {
                            itemActiveApplyDetailsBindingBind.tvActiveStatus.setText("已关闭");
                            return;
                        }
                        break;
                    case 55:
                        if (userEnrollStatus.equals(ConversionUtil.conditionWithBookType)) {
                            itemActiveApplyDetailsBindingBind.tvActiveStatus.setText("报名失败");
                            return;
                        }
                        break;
                }
            }
            itemActiveApplyDetailsBindingBind.tvActiveStatus.setText("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void convert$lambda$0(ActiveDetailsListAdapter this$0, ActiveEnrollSubBean item, CompoundButton compoundButton, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            if (z) {
                this$0.selectList.add(item);
            } else {
                this$0.selectList.remove(item);
            }
            Log.i("TAG", "selectList = " + this$0.selectList.size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void convert$lambda$1(ItemActiveApplyDetailsBinding viewBinding, ActiveDetailsListAdapter this$0, int i, View view) {
            Intrinsics.checkNotNullParameter(viewBinding, "$viewBinding");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (viewBinding.checkbox.isShown()) {
                viewBinding.checkbox.setChecked(!viewBinding.checkbox.isChecked());
                this$0.selectMap.put(Integer.valueOf(i), Boolean.valueOf(!viewBinding.checkbox.isChecked()));
            }
        }
    }

    public final void setDataDetails(ActiveDetailsBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.dataDetails = data;
    }

    public final List<ActiveEnrollSubBean> getCheckBoxList() {
        return this.selectList;
    }

    public final void removeCheckBoxList() {
        this.selectList.clear();
        this.selectMap.clear();
    }

    /* JADX INFO: compiled from: ActiveDetailsListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/active/ActiveDetailsListAdapter$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yd/android_brand_mvp/databinding/LayoutListBinding;", "(Lcom/yd/android_brand_mvp/adapter/active/ActiveDetailsListAdapter;Lcom/yd/android_brand_mvp/databinding/LayoutListBinding;)V", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/LayoutListBinding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final LayoutListBinding binding;
        final /* synthetic */ ActiveDetailsListAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(ActiveDetailsListAdapter activeDetailsListAdapter, LayoutListBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = activeDetailsListAdapter;
            this.binding = binding;
        }

        public final LayoutListBinding getBinding() {
            return this.binding;
        }
    }
}
