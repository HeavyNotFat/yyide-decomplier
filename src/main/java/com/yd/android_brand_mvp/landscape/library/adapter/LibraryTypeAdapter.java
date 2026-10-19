package com.yd.android_brand_mvp.landscape.library.adapter;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemLibraryTypeCheckboxBinding;
import com.yd.android_brand_mvp.model.SelectMenuBean;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LibraryTypeAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0002H\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/library/adapter/LibraryTypeAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/SelectMenuBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "selectCheckBoxId", "", "getSelectCheckBoxId", "()Ljava/lang/String;", "setSelectCheckBoxId", "(Ljava/lang/String;)V", "selectMap", "", "", "", "selectedPosition", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "clear", "", "convert", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LibraryTypeAdapter extends BaseQuickAdapter<SelectMenuBean, BaseViewHolder> {
    private String selectCheckBoxId;
    private final Map<Integer, Boolean> selectMap;
    private int selectedPosition;

    public LibraryTypeAdapter() {
        super(R.layout.item_library_type_checkbox, null, 2, null);
        this.selectCheckBoxId = "";
        this.selectedPosition = -1;
        this.selectMap = new LinkedHashMap();
    }

    public final String getSelectCheckBoxId() {
        return this.selectCheckBoxId;
    }

    public final void setSelectCheckBoxId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectCheckBoxId = str;
    }

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final void setSelectedPosition(int i) {
        this.selectedPosition = i;
    }

    public final void clear() {
        this.selectMap.put(Integer.valueOf(this.selectedPosition), false);
        notifyItemChanged(this.selectedPosition);
        this.selectCheckBoxId = "";
        this.selectedPosition = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(final BaseViewHolder holder, final SelectMenuBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        final ItemLibraryTypeCheckboxBinding itemLibraryTypeCheckboxBindingBind = ItemLibraryTypeCheckboxBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemLibraryTypeCheckboxBindingBind, "bind(holder.itemView)");
        itemLibraryTypeCheckboxBindingBind.checkbox.setText(item.getName());
        itemLibraryTypeCheckboxBindingBind.checkbox.setClickable(false);
        itemLibraryTypeCheckboxBindingBind.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.adapter.-$$Lambda$LibraryTypeAdapter$bD9ihCe26DLkbtiKPtPGFdYESGw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibraryTypeAdapter.convert$lambda$0(this.f$0, item, itemLibraryTypeCheckboxBindingBind, holder, view);
            }
        });
        if (this.selectMap.get(Integer.valueOf(holder.getAdapterPosition())) == null) {
            this.selectMap.put(Integer.valueOf(holder.getAdapterPosition()), false);
        }
        Boolean bool = this.selectMap.get(Integer.valueOf(holder.getAdapterPosition()));
        if (bool != null) {
            itemLibraryTypeCheckboxBindingBind.checkbox.setChecked(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(LibraryTypeAdapter this$0, SelectMenuBean item, ItemLibraryTypeCheckboxBinding binding, BaseViewHolder holder, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        this$0.selectCheckBoxId = item.getId();
        if (this$0.selectedPosition != -1) {
            binding.checkbox.setChecked(false);
            this$0.selectMap.put(Integer.valueOf(this$0.selectedPosition), false);
            this$0.notifyItemChanged(this$0.selectedPosition);
        }
        this$0.selectedPosition = holder.getAdapterPosition();
        binding.checkbox.setChecked(!binding.checkbox.isChecked());
        this$0.selectMap.put(Integer.valueOf(holder.getAdapterPosition()), Boolean.valueOf(!binding.checkbox.isChecked()));
    }
}
