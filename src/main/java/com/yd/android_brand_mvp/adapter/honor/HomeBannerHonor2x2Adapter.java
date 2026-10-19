package com.yd.android_brand_mvp.adapter.honor;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.GankItemHomeHonor2x2Binding;
import com.yd.android_brand_mvp.model.honor.HonorWallItem;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.youth.banner.adapter.BannerAdapter;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: HomeBannerHonor2x2Adapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0015B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ,\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001e\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/honor/HomeBannerHonor2x2Adapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "Lcom/yd/android_brand_mvp/model/honor/HonorWallItem;", "Lcom/yd/android_brand_mvp/adapter/honor/HomeBannerHonor2x2Adapter$BannerViewHolder;", "context", "Landroid/content/Context;", "data", "", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "onBindView", "", "holder", "position", "", InnerConstant.Db.size, "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "BannerViewHolder", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomeBannerHonor2x2Adapter extends BannerAdapter<HonorWallItem, BannerViewHolder> {
    private final Context context;

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeBannerHonor2x2Adapter(Context context, List<HonorWallItem> list) {
        super(list);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.youth.banner.holder.IViewHolder
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        GankItemHomeHonor2x2Binding gankItemHomeHonor2x2BindingInflate = GankItemHomeHonor2x2Binding.inflate(LayoutInflater.from(parent != null ? parent.getContext() : null), parent, false);
        Intrinsics.checkNotNullExpressionValue(gankItemHomeHonor2x2BindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new BannerViewHolder(this, gankItemHomeHonor2x2BindingInflate);
    }

    @Override // com.youth.banner.holder.IViewHolder
    public void onBindView(BannerViewHolder holder, HonorWallItem data, int position, int size) {
        int i;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        GankItemHomeHonor2x2Binding binding = holder.getBinding();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SimpleUtilsKt.asColor(R.color.black9));
        if (data.getWinnerNames().length() == 0) {
            TextView textView = binding.tvItemHonerWallGetClass;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvItemHonerWallGetClass");
            SimpleUtilsKt.remove(textView);
        } else {
            TextView textView2 = binding.tvItemHonerWallGetClass;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvItemHonerWallGetClass");
            SimpleUtilsKt.show(textView2);
            int honorType = data.getHonorType();
            if (honorType != 2) {
                i = honorType != 3 ? R.string.honer_wall_getClass : R.string.honer_wall_getTeacher;
            } else {
                i = R.string.honer_wall_getStudent;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = this.context.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(strContentId)");
            String str = String.format(string, Arrays.copyOf(new Object[]{data.getWinnerNames()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(foregroundColorSpan, 5, spannableString.length(), 17);
            binding.tvItemHonerWallGetClass.setText(spannableString);
        }
        binding.tvItemHonerWallType.setText(TransUtils.INSTANCE.transHonorLevelToStr(data.getLevel()));
        binding.tvItemHonerWallTitle.setText(data.getName());
        if (data.getImgPaths().length() > 0) {
            Glide.with(this.context).load(data.getImgPaths()).into(binding.ivItemHonerWallTemplate);
        }
    }

    /* JADX INFO: compiled from: HomeBannerHonor2x2Adapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/honor/HomeBannerHonor2x2Adapter$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yd/android_brand_mvp/databinding/GankItemHomeHonor2x2Binding;", "(Lcom/yd/android_brand_mvp/adapter/honor/HomeBannerHonor2x2Adapter;Lcom/yd/android_brand_mvp/databinding/GankItemHomeHonor2x2Binding;)V", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/GankItemHomeHonor2x2Binding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final GankItemHomeHonor2x2Binding binding;
        final /* synthetic */ HomeBannerHonor2x2Adapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(HomeBannerHonor2x2Adapter homeBannerHonor2x2Adapter, GankItemHomeHonor2x2Binding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = homeBannerHonor2x2Adapter;
            this.binding = binding;
        }

        public final GankItemHomeHonor2x2Binding getBinding() {
            return this.binding;
        }
    }
}
