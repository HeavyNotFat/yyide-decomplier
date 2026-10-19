package com.yd.android_brand_mvp.activity.fragment.honor;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.fragment.honor.HonorListFragment.ItemAdapter;
import com.yd.android_brand_mvp.databinding.ItemHonorStudentBinding;
import com.yd.android_brand_mvp.dialog.DialogHonorMedal;
import com.yd.android_brand_mvp.model.honor.HonorStudentBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorListFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"com/yd/android_brand_mvp/activity/fragment/honor/HonorListFragment$mStudentAdapter$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/honor/HonorStudentBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorListFragment$mStudentAdapter$1 extends BaseQuickAdapter<HonorStudentBean, BaseViewHolder> implements LoadMoreModule {
    final /* synthetic */ HonorListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HonorListFragment$mStudentAdapter$1(HonorListFragment honorListFragment) {
        super(R.layout.item_honor_student, null, 2, null);
        this.this$0 = honorListFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, HonorStudentBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemHonorStudentBinding itemHonorStudentBindingBind = ItemHonorStudentBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemHonorStudentBindingBind, "bind(holder.itemView)");
        itemHonorStudentBindingBind.tvName.setText(item.getStudentName());
        GlideUtil.loadCircleImage(getContext(), item.getAvatar(), itemHonorStudentBindingBind.ivCover);
        itemHonorStudentBindingBind.medalRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        final HonorListFragment.ItemAdapter itemAdapter = this.this$0.new ItemAdapter();
        itemHonorStudentBindingBind.medalRecyclerView.setAdapter(itemAdapter);
        itemAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorListFragment$mStudentAdapter$1$j-Ordfze5FSKuqeHtctixGaWumA
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                HonorListFragment$mStudentAdapter$1.convert$lambda$0(this.f$0, itemAdapter, baseQuickAdapter, view, i);
            }
        });
        itemAdapter.setList(item.getHonorList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(HonorListFragment$mStudentAdapter$1 this$0, HonorListFragment.ItemAdapter itemAdapter, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemAdapter, "$itemAdapter");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        new DialogHonorMedal().showDialog(this$0.getContext(), itemAdapter.getItem(i));
    }
}
