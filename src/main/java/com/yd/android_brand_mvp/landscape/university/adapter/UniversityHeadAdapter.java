package com.yd.android_brand_mvp.landscape.university.adapter;

import android.content.Context;
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
import com.yd.android_brand_mvp.databinding.ItemUniversityHeadBinding;
import com.yd.android_brand_mvp.databinding.LayoutListBinding;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.youth.banner.adapter.BannerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UniversityHeadAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0012\u00060\u0004R\u00020\u00000\u0001:\u0002\u001d\u001eB+\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ6\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0018\u00010\u0004R\u00020\u00002\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u001e\u0010\u0018\u001a\u00060\u0004R\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0016H\u0016J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/adapter/UniversityHeadAdapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "", "Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO$TimetableListDTO$TeacherListDTO;", "Lcom/yd/android_brand_mvp/landscape/university/adapter/UniversityHeadAdapter$BannerViewHolder;", "context", "Landroid/content/Context;", "data", "isWhite", "", "(Landroid/content/Context;Ljava/util/List;Z)V", "getContext", "()Landroid/content/Context;", "getData", "()Ljava/util/List;", "()Z", "mItemClick", "Lcom/yd/android_brand_mvp/landscape/university/adapter/UniversityHeadAdapter$ItemClick;", "onBindView", "", "holder", "position", "", InnerConstant.Db.size, "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemClick", "BannerViewHolder", "ItemClick", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UniversityHeadAdapter extends BannerAdapter<List<KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO>, BannerViewHolder> {
    private final Context context;
    private final List<List<KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO>> data;
    private final boolean isWhite;
    private ItemClick mItemClick;

    /* JADX INFO: compiled from: UniversityHeadAdapter.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/adapter/UniversityHeadAdapter$ItemClick;", "", "onItemClick", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ItemClick {
        void onItemClick();
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<List<KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO>> getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: isWhite, reason: from getter */
    public final boolean getIsWhite() {
        return this.isWhite;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UniversityHeadAdapter(Context context, List<List<KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO>> list, boolean z) {
        super(list);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.data = list;
        this.isWhite = z;
    }

    @Override // com.youth.banner.holder.IViewHolder
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        LayoutListBinding layoutListBindingInflate = LayoutListBinding.inflate(LayoutInflater.from(parent != null ? parent.getContext() : null), parent, false);
        Intrinsics.checkNotNullExpressionValue(layoutListBindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new BannerViewHolder(this, layoutListBindingInflate);
    }

    @Override // com.youth.banner.holder.IViewHolder
    public void onBindView(BannerViewHolder holder, List<KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO> data, int position, int size) {
        LayoutListBinding binding;
        LayoutListBinding binding2;
        LayoutListBinding binding3;
        RecyclerView recyclerView = null;
        if (data != null) {
            if (data.size() > 2) {
                RecyclerView recyclerView2 = (holder == null || (binding3 = holder.getBinding()) == null) ? null : binding3.recyclerView;
                if (recyclerView2 != null) {
                    recyclerView2.setLayoutManager(new GridLayoutManager(this.context, 3));
                }
            } else {
                RecyclerView recyclerView3 = (holder == null || (binding2 = holder.getBinding()) == null) ? null : binding2.recyclerView;
                if (recyclerView3 != null) {
                    recyclerView3.setLayoutManager(new GridLayoutManager(this.context, data.size()));
                }
            }
        }
        if (holder != null && (binding = holder.getBinding()) != null) {
            recyclerView = binding.recyclerView;
        }
        if (recyclerView == null) {
            return;
        }
        recyclerView.setAdapter(new AnonymousClass2(data, this));
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.adapter.UniversityHeadAdapter$onBindView$2, reason: invalid class name */
    /* JADX INFO: compiled from: UniversityHeadAdapter.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/yd/android_brand_mvp/landscape/university/adapter/UniversityHeadAdapter$onBindView$2", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO$TimetableListDTO$TeacherListDTO;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass2 extends BaseQuickAdapter<KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO, BaseViewHolder> {
        final /* synthetic */ UniversityHeadAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List<KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO> list, UniversityHeadAdapter universityHeadAdapter) {
            super(R.layout.item_university_head, list);
            this.this$0 = universityHeadAdapter;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(BaseViewHolder holder, KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            ItemUniversityHeadBinding itemUniversityHeadBindingBind = ItemUniversityHeadBinding.bind(holder.itemView);
            Intrinsics.checkNotNullExpressionValue(itemUniversityHeadBindingBind, "bind(holder.itemView)");
            itemUniversityHeadBindingBind.tvName.setText(item.name);
            if (this.this$0.getIsWhite()) {
                itemUniversityHeadBindingBind.tvName.setTextColor(-1);
            }
            ConstraintLayout root = itemUniversityHeadBindingBind.getRoot();
            final UniversityHeadAdapter universityHeadAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.university.adapter.-$$Lambda$UniversityHeadAdapter$onBindView$2$zwtfKruIT6mQGFRsElLU_5rAwhQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UniversityHeadAdapter.AnonymousClass2.convert$lambda$0(universityHeadAdapter, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void convert$lambda$0(UniversityHeadAdapter this$0, View view) {
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

    /* JADX INFO: compiled from: UniversityHeadAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/adapter/UniversityHeadAdapter$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yd/android_brand_mvp/databinding/LayoutListBinding;", "(Lcom/yd/android_brand_mvp/landscape/university/adapter/UniversityHeadAdapter;Lcom/yd/android_brand_mvp/databinding/LayoutListBinding;)V", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/LayoutListBinding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final LayoutListBinding binding;
        final /* synthetic */ UniversityHeadAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(UniversityHeadAdapter universityHeadAdapter, LayoutListBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = universityHeadAdapter;
            this.binding = binding;
        }

        public final LayoutListBinding getBinding() {
            return this.binding;
        }
    }
}
