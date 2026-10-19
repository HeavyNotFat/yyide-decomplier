package com.yd.android_brand_mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.FragmentTimerItemBinding;
import com.yd.android_brand_mvp.model.TimelistRsp;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.youth.banner.adapter.BannerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimerListAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/TimerListAdapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "Lcom/yd/android_brand_mvp/model/TimelistRsp$DataBean;", "Lcom/yd/android_brand_mvp/adapter/TimerListAdapter$BannerViewHolder;", "cx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getCx", "()Landroid/content/Context;", "onBindView", "", "holder", "data", "position", "", InnerConstant.Db.size, "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "BannerViewHolder", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TimerListAdapter extends BannerAdapter<TimelistRsp.DataBean, BannerViewHolder> {
    private final Context cx;

    /* JADX INFO: compiled from: TimerListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/TimerListAdapter$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yd/android_brand_mvp/databinding/FragmentTimerItemBinding;", "(Lcom/yd/android_brand_mvp/databinding/FragmentTimerItemBinding;)V", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/FragmentTimerItemBinding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final FragmentTimerItemBinding binding;

        public final FragmentTimerItemBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(FragmentTimerItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimerListAdapter(Context cx) {
        super(null);
        Intrinsics.checkNotNullParameter(cx, "cx");
        this.cx = cx;
    }

    public final Context getCx() {
        return this.cx;
    }

    @Override // com.youth.banner.holder.IViewHolder
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        FragmentTimerItemBinding fragmentTimerItemBindingInflate = FragmentTimerItemBinding.inflate(LayoutInflater.from(parent != null ? parent.getContext() : null), parent, false);
        Intrinsics.checkNotNullExpressionValue(fragmentTimerItemBindingInflate, "inflate(\n               …      false\n            )");
        return new BannerViewHolder(fragmentTimerItemBindingInflate);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.youth.banner.holder.IViewHolder
    public void onBindView(BannerViewHolder holder, TimelistRsp.DataBean data, int position, int size) {
        FragmentTimerItemBinding binding;
        ImageView imageView;
        FragmentTimerItemBinding binding2;
        ImageView imageView2;
        FragmentTimerItemBinding binding3;
        ImageView imageView3;
        FragmentTimerItemBinding binding4;
        ImageView imageView4;
        FragmentTimerItemBinding binding5;
        ImageView imageView5;
        FragmentTimerItemBinding binding6;
        ImageView imageView6;
        FragmentTimerItemBinding binding7;
        ImageView imageView7;
        FragmentTimerItemBinding binding8;
        ImageView imageView8;
        FragmentTimerItemBinding binding9;
        ImageView imageView9;
        FragmentTimerItemBinding binding10;
        FragmentTimerItemBinding binding11;
        TextView textView = (holder == null || (binding11 = holder.getBinding()) == null) ? null : binding11.tvContent;
        if (textView != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("距离");
            sb.append(data != null ? data.activityTheme : null);
            textView.setText(sb.toString());
        }
        TextView textView2 = (holder == null || (binding10 = holder.getBinding()) == null) ? null : binding10.tvNum;
        if (textView2 != null) {
            textView2.setText(String.valueOf(data != null ? Integer.valueOf(data.countDown) : null));
        }
        String str = data != null ? data.templateUrl : null;
        if (str != null) {
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1") && holder != null && (binding = holder.getBinding()) != null && (imageView = binding.ivImg) != null) {
                        imageView.setBackgroundResource(R.drawable.icon_timer_bg1);
                    }
                    break;
                case 50:
                    if (str.equals("2") && holder != null && (binding2 = holder.getBinding()) != null && (imageView2 = binding2.ivImg) != null) {
                        imageView2.setBackgroundResource(R.drawable.icon_timer_bg2);
                    }
                    break;
                case 51:
                    if (str.equals("3") && holder != null && (binding3 = holder.getBinding()) != null && (imageView3 = binding3.ivImg) != null) {
                        imageView3.setBackgroundResource(R.drawable.icon_timer_bg3);
                    }
                    break;
                case 52:
                    if (str.equals("4") && holder != null && (binding4 = holder.getBinding()) != null && (imageView4 = binding4.ivImg) != null) {
                        imageView4.setBackgroundResource(R.drawable.icon_timer_bg4);
                    }
                    break;
                case 53:
                    if (str.equals(ConversionUtil.conditionWithSeriesName) && holder != null && (binding5 = holder.getBinding()) != null && (imageView5 = binding5.ivImg) != null) {
                        imageView5.setBackgroundResource(R.drawable.icon_timer_bg5);
                    }
                    break;
                case 54:
                    if (str.equals(ConversionUtil.conditionWithCallNumber) && holder != null && (binding6 = holder.getBinding()) != null && (imageView6 = binding6.ivImg) != null) {
                        imageView6.setBackgroundResource(R.drawable.icon_timer_bg6);
                    }
                    break;
                case 55:
                    if (str.equals(ConversionUtil.conditionWithBookType) && holder != null && (binding7 = holder.getBinding()) != null && (imageView7 = binding7.ivImg) != null) {
                        imageView7.setBackgroundResource(R.drawable.icon_timer_bg7);
                    }
                    break;
                case 56:
                    if (str.equals(ConversionUtil.conditionWithPublishStartYear) && holder != null && (binding8 = holder.getBinding()) != null && (imageView8 = binding8.ivImg) != null) {
                        imageView8.setBackgroundResource(R.drawable.icon_timer_bg8);
                    }
                    break;
                case 57:
                    if (str.equals(ConversionUtil.conditionWithPublishEndYear) && holder != null && (binding9 = holder.getBinding()) != null && (imageView9 = binding9.ivImg) != null) {
                        imageView9.setBackgroundResource(R.drawable.icon_timer_bg9);
                    }
                    break;
            }
        }
    }
}
