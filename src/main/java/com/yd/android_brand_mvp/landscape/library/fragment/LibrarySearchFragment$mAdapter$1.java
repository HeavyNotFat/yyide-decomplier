package com.yd.android_brand_mvp.landscape.library.fragment;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemLibraryListBinding;
import com.yd.android_brand_mvp.model.library.LibraryItemBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: LibrarySearchFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"com/yd/android_brand_mvp/landscape/library/fragment/LibrarySearchFragment$mAdapter$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/library/LibraryItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LibrarySearchFragment$mAdapter$1 extends BaseQuickAdapter<LibraryItemBean, BaseViewHolder> implements LoadMoreModule {
    final /* synthetic */ LibrarySearchFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LibrarySearchFragment$mAdapter$1(LibrarySearchFragment librarySearchFragment) {
        super(R.layout.item_library_list, null, 2, null);
        this.this$0 = librarySearchFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, LibraryItemBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemLibraryListBinding itemLibraryListBindingBind = ItemLibraryListBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemLibraryListBindingBind, "bind(holder.itemView)");
        itemLibraryListBindingBind.tvLibraryTitle.setText(item.getTitle());
        GlideUtil.loadBook2(this.this$0.requireContext(), item.getUrl(), itemLibraryListBindingBind.ivCover);
        TextView textView = itemLibraryListBindingBind.tvLibraryLoanable;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("馆藏 %d 可借 %d", Arrays.copyOf(new Object[]{Integer.valueOf(item.getItemCount()), Integer.valueOf(item.getBorrowableCount())}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView.setText(str);
        TextView textView2 = itemLibraryListBindingBind.tvLibraryAuthor;
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str2 = String.format("%s | %s | %s", Arrays.copyOf(new Object[]{item.getFirstAuthor(), item.getPublisherName(), item.getPublicationTime()}, 3));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        textView2.setText(str2);
        itemLibraryListBindingBind.tvLibraryNumber.setText(item.getCallNumber());
    }
}
