package com.yd.android_brand_mvp.adapter.task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemPunch21FragmentBinding;
import com.yd.android_brand_mvp.model.task.MyTaskListItem;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.youth.banner.adapter.BannerAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: BannerTask21Adapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0015B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ,\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001e\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/task/BannerTask21Adapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "Lcom/yd/android_brand_mvp/model/task/MyTaskListItem;", "Lcom/yd/android_brand_mvp/adapter/task/BannerTask21Adapter$BannerViewHolder;", "context", "Landroid/content/Context;", "data", "", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "onBindView", "", "holder", "position", "", InnerConstant.Db.size, "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "BannerViewHolder", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BannerTask21Adapter extends BannerAdapter<MyTaskListItem, BannerViewHolder> {
    private final Context context;

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerTask21Adapter(Context context, List<MyTaskListItem> list) {
        super(list);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.youth.banner.holder.IViewHolder
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ItemPunch21FragmentBinding itemPunch21FragmentBindingInflate = ItemPunch21FragmentBinding.inflate(LayoutInflater.from(parent != null ? parent.getContext() : null), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemPunch21FragmentBindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new BannerViewHolder(this, itemPunch21FragmentBindingInflate);
    }

    @Override // com.youth.banner.holder.IViewHolder
    public void onBindView(BannerViewHolder holder, MyTaskListItem data, int position, int size) {
        Object next;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        ItemPunch21FragmentBinding binding = holder.getBinding();
        binding.gankInclude.title.setText(SimpleUtilsKt.maxLength(data.getTaskName(), 10));
        TextView textView = binding.gankInclude.tvLayoutHeadSubTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.gankInclude.tvLayoutHeadSubTitle");
        SimpleUtilsKt.show(textView);
        TextView textView2 = binding.gankInclude.tvLayoutHeadSubTitle;
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(position + 1);
        sb.append('/');
        sb.append(size);
        sb.append(')');
        textView2.setText(sb.toString());
        ArrayList arrayList = new ArrayList();
        if (!data.getSubjectList().isEmpty()) {
            Iterator<T> it2 = data.getSubjectList().iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
            } while (!Intrinsics.areEqual((String) next, "不限"));
            if (next == null) {
                arrayList.add('(' + ((String) CollectionsKt.first((List) data.getSubjectList())) + ')');
            }
        }
        binding.tvItemPunchDesc.setContentAndTag(data.getTaskDescription(), arrayList);
        TextView textView3 = binding.tvItemPunchEndTime;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this.context.getString(R.string.task_sign_endDate);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.task_sign_endDate)");
        String str = String.format(string, Arrays.copyOf(new Object[]{data.getPublishEnd()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView3.setText(str);
    }

    /* JADX INFO: compiled from: BannerTask21Adapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/task/BannerTask21Adapter$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yd/android_brand_mvp/databinding/ItemPunch21FragmentBinding;", "(Lcom/yd/android_brand_mvp/adapter/task/BannerTask21Adapter;Lcom/yd/android_brand_mvp/databinding/ItemPunch21FragmentBinding;)V", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/ItemPunch21FragmentBinding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final ItemPunch21FragmentBinding binding;
        final /* synthetic */ BannerTask21Adapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(BannerTask21Adapter bannerTask21Adapter, ItemPunch21FragmentBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = bannerTask21Adapter;
            this.binding = binding;
        }

        public final ItemPunch21FragmentBinding getBinding() {
            return this.binding;
        }
    }
}
