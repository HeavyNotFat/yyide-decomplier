package com.yd.android_brand_mvp.landscape.blackboard;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.databinding.ItemBbSubjectImageBinding;
import com.youth.banner.adapter.BannerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubjectImageAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0018\u0019B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ.\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0018\u00010\u0003R\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001e\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/blackboard/SubjectImageAdapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardModel;", "Lcom/yd/android_brand_mvp/landscape/blackboard/SubjectImageAdapter$BannerViewHolder;", "context", "Landroid/content/Context;", "data", "", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "mItemClick", "Lcom/yd/android_brand_mvp/landscape/blackboard/SubjectImageAdapter$ItemClick;", "onBindView", "", "holder", "position", "", InnerConstant.Db.size, "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemClick", "BannerViewHolder", "ItemClick", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubjectImageAdapter extends BannerAdapter<BlackBoardModel, BannerViewHolder> {
    private final Context context;
    private ItemClick mItemClick;

    /* JADX INFO: compiled from: SubjectImageAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/blackboard/SubjectImageAdapter$ItemClick;", "", "onItemClick", "", "data", "Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardModel;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ItemClick {
        void onItemClick(BlackBoardModel data);
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubjectImageAdapter(Context context, List<BlackBoardModel> list) {
        super(list);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.youth.banner.holder.IViewHolder
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ItemBbSubjectImageBinding itemBbSubjectImageBindingInflate = ItemBbSubjectImageBinding.inflate(LayoutInflater.from(parent != null ? parent.getContext() : null), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemBbSubjectImageBindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new BannerViewHolder(this, itemBbSubjectImageBindingInflate);
    }

    @Override // com.youth.banner.holder.IViewHolder
    public void onBindView(BannerViewHolder holder, final BlackBoardModel data, int position, int size) {
        ItemBbSubjectImageBinding binding;
        ConstraintLayout root;
        ItemBbSubjectImageBinding binding2;
        ImageView imageView;
        ItemBbSubjectImageBinding binding3;
        Intrinsics.checkNotNullParameter(data, "data");
        TextView textView = (holder == null || (binding3 = holder.getBinding()) == null) ? null : binding3.tvSubject;
        if (textView != null) {
            textView.setText(data.getSubjectName());
        }
        if (holder != null && (binding2 = holder.getBinding()) != null && (imageView = binding2.ivIcon) != null) {
            imageView.setImageBitmap(BitmapFactory.decodeFile(data.getFilePath()));
        }
        if (holder == null || (binding = holder.getBinding()) == null || (root = binding.getRoot()) == null) {
            return;
        }
        root.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.blackboard.-$$Lambda$SubjectImageAdapter$dR-K0NqR-086VJQWqYTh3c4D49I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubjectImageAdapter.onBindView$lambda$0(this.f$0, data, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindView$lambda$0(SubjectImageAdapter this$0, BlackBoardModel data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        ItemClick itemClick = this$0.mItemClick;
        if (itemClick != null) {
            itemClick.onItemClick(data);
        }
    }

    public final void setItemClick(ItemClick mItemClick) {
        Intrinsics.checkNotNullParameter(mItemClick, "mItemClick");
        this.mItemClick = mItemClick;
    }

    /* JADX INFO: compiled from: SubjectImageAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/blackboard/SubjectImageAdapter$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yd/android_brand_mvp/databinding/ItemBbSubjectImageBinding;", "(Lcom/yd/android_brand_mvp/landscape/blackboard/SubjectImageAdapter;Lcom/yd/android_brand_mvp/databinding/ItemBbSubjectImageBinding;)V", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/ItemBbSubjectImageBinding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final ItemBbSubjectImageBinding binding;
        final /* synthetic */ SubjectImageAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(SubjectImageAdapter subjectImageAdapter, ItemBbSubjectImageBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = subjectImageAdapter;
            this.binding = binding;
        }

        public final ItemBbSubjectImageBinding getBinding() {
            return this.binding;
        }
    }
}
