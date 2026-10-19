package com.yd.android_brand_mvp.landscape.honor;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemHonorMedalBinding;
import com.yd.android_brand_mvp.databinding.ItemHonorStudentBinding;
import com.yd.android_brand_mvp.dialog.DialogHonorMedal;
import com.yd.android_brand_mvp.model.honor.HonorItemBean;
import com.yd.android_brand_mvp.model.honor.HonorStudentBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"com/yd/android_brand_mvp/landscape/honor/HonorFragment$mStudentAdapter$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/honor/HonorStudentBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorFragment$mStudentAdapter$1 extends BaseQuickAdapter<HonorStudentBean, BaseViewHolder> implements LoadMoreModule {
    HonorFragment$mStudentAdapter$1() {
        super(R.layout.item_honor_student, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.yd.android_brand_mvp.landscape.honor.HonorFragment$mStudentAdapter$1$convert$mAdapter$1] */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, HonorStudentBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemHonorStudentBinding itemHonorStudentBindingBind = ItemHonorStudentBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemHonorStudentBindingBind, "bind(holder.itemView)");
        itemHonorStudentBindingBind.tvName.setText(item.getStudentName());
        GlideUtil.loadCircleImage(getContext(), item.getAvatar(), itemHonorStudentBindingBind.ivCover);
        final ?? r0 = new BaseQuickAdapter<HonorItemBean, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.honor.HonorFragment$mStudentAdapter$1$convert$mAdapter$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder2, HonorItemBean item2) {
                Intrinsics.checkNotNullParameter(holder2, "holder");
                Intrinsics.checkNotNullParameter(item2, "item");
                ItemHonorMedalBinding itemHonorMedalBindingBind = ItemHonorMedalBinding.bind(holder2.itemView);
                Intrinsics.checkNotNullExpressionValue(itemHonorMedalBindingBind, "bind(holder.itemView)");
                GlideUtil.loadImage(getContext(), item2.getMedalUrl(), itemHonorMedalBindingBind.ivCover);
            }
        };
        r0.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.honor.-$$Lambda$HonorFragment$mStudentAdapter$1$k1IxWRZv8BndLIgy5SOT0K0t0LM
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                HonorFragment$mStudentAdapter$1.convert$lambda$0(this.f$0, r0, baseQuickAdapter, view, i);
            }
        });
        itemHonorStudentBindingBind.medalRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        itemHonorStudentBindingBind.medalRecyclerView.setAdapter((RecyclerView.Adapter) r0);
        r0.setList(item.getHonorList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(HonorFragment$mStudentAdapter$1 this$0, HonorFragment$mStudentAdapter$1$convert$mAdapter$1 mAdapter, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mAdapter, "$mAdapter");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        new DialogHonorMedal().showDialog(this$0.getContext(), mAdapter.getItem(i));
    }
}
