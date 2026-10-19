package com.yd.android_brand_mvp.adapter.consult;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.BannerItemConsult2x6Binding;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
import com.yd.android_brand_mvp.model.reservation.ReservationSignListItemBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.youth.banner.adapter.BannerAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: Consult2x6Adapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0014\u0015B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0002J.\u0010\n\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0018\u00010\u0003R\u00020\u00002\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001e\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/consult/Consult2x6Adapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "Lcom/yd/android_brand_mvp/adapter/consult/Consult2x6Adapter$BannerViewHolder;", "()V", "mOnItemClickCallback", "Lcom/yd/android_brand_mvp/adapter/consult/Consult2x6Adapter$OnItemClickCallback;", "itemClick", "", "data", "onBindView", "holder", "position", "", InnerConstant.Db.size, "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickCallback", "BannerViewHolder", "OnItemClickCallback", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Consult2x6Adapter extends BannerAdapter<ReservationRecordBean, BannerViewHolder> {
    private OnItemClickCallback mOnItemClickCallback;

    /* JADX INFO: compiled from: Consult2x6Adapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/consult/Consult2x6Adapter$OnItemClickCallback;", "", "itemClick", "", "data", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", TUIKitConstants.Selection.LIST, "", "Lcom/yd/android_brand_mvp/model/reservation/ReservationSignListItemBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnItemClickCallback {
        void itemClick(ReservationRecordBean data, List<ReservationSignListItemBean> list);
    }

    public Consult2x6Adapter() {
        super(null);
    }

    @Override // com.youth.banner.holder.IViewHolder
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        BannerItemConsult2x6Binding bannerItemConsult2x6BindingInflate = BannerItemConsult2x6Binding.inflate(LayoutInflater.from(parent != null ? parent.getContext() : null), parent, false);
        Intrinsics.checkNotNullExpressionValue(bannerItemConsult2x6BindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new BannerViewHolder(this, bannerItemConsult2x6BindingInflate);
    }

    @Override // com.youth.banner.holder.IViewHolder
    public void onBindView(BannerViewHolder holder, final ReservationRecordBean data, int position, int size) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (holder != null) {
            holder.getBinding().tvConsultTitle.setText(data.getName());
            if (TimeUtil.isTime(data.getStartTimeStr(), data.getEndTimeStr())) {
                holder.getBinding().tvConsultStatus.setText("进行中");
                holder.getBinding().tvConsultCreateName.setTextColor(-1);
                holder.getBinding().tvConsultStatus.setTextColor(-1);
                holder.getBinding().tvConsultStatus.setBackgroundResource(R.drawable.bg_3f87ff_50);
                TextView textView = holder.getBinding().btnFragmentHomeChemistryCourse;
                Intrinsics.checkNotNullExpressionValue(textView, "it.binding.btnFragmentHomeChemistryCourse");
                SimpleUtilsKt.show(textView);
            } else {
                holder.getBinding().tvConsultStatus.setText("未开始");
                holder.getBinding().tvConsultStatus.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.color_595959));
                holder.getBinding().tvConsultStatus.setBackgroundResource(R.drawable.bg_e4e4e4_50);
                TextView textView2 = holder.getBinding().btnFragmentHomeChemistryCourse;
                Intrinsics.checkNotNullExpressionValue(textView2, "it.binding.btnFragmentHomeChemistryCourse");
                SimpleUtilsKt.remove(textView2);
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Object obj : data.getSignList()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ReservationSignListItemBean reservationSignListItemBean = (ReservationSignListItemBean) obj;
                if (reservationSignListItemBean.getUserType() == 1) {
                    arrayList.add(reservationSignListItemBean);
                }
                i = i2;
            }
            if (arrayList.size() > 0) {
                ReservationSignListItemBean reservationSignListItemBean2 = (ReservationSignListItemBean) CollectionsKt.first((List) arrayList);
                if (arrayList.size() > 1) {
                    TextView textView3 = holder.getBinding().tvConsultName;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str = String.format("%s >", Arrays.copyOf(new Object[]{reservationSignListItemBean2.getUserName()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                    textView3.setText(str);
                    holder.getBinding().ivHead.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.adapter.consult.-$$Lambda$Consult2x6Adapter$SFHLgPoZp52VFji2nuOIj0PVPCw
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            Consult2x6Adapter.onBindView$lambda$3$lambda$1(this.f$0, data, view);
                        }
                    });
                    holder.getBinding().tvConsultName.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.adapter.consult.-$$Lambda$Consult2x6Adapter$7GcLnxe479APHG6c3MPHXGb3UQg
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            Consult2x6Adapter.onBindView$lambda$3$lambda$2(this.f$0, data, view);
                        }
                    });
                } else {
                    holder.getBinding().tvConsultName.setText(reservationSignListItemBean2.getUserName());
                }
                if (!TextUtils.isEmpty(reservationSignListItemBean2.getUserName()) && TextUtils.isEmpty(reservationSignListItemBean2.getAvatar())) {
                    TextView textView4 = holder.getBinding().tvConsultCreateName;
                    String strSubstring = reservationSignListItemBean2.getUserName().substring(0, 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    textView4.setText(strSubstring);
                } else {
                    TextView textView5 = holder.getBinding().tvConsultCreateName;
                    Intrinsics.checkNotNullExpressionValue(textView5, "it.binding.tvConsultCreateName");
                    SimpleUtilsKt.remove(textView5);
                    GlideUtil.loadCircleImage(holder.itemView.getContext(), reservationSignListItemBean2.getAvatar(), holder.getBinding().ivHead);
                }
            } else {
                TextView textView6 = holder.getBinding().tvConsultCreateName;
                Intrinsics.checkNotNullExpressionValue(textView6, "it.binding.tvConsultCreateName");
                SimpleUtilsKt.remove(textView6);
                holder.getBinding().tvConsultName.setText("");
                holder.getBinding().ivHead.setImageResource(R.drawable.icon_consult_default);
            }
            String time = TimeUtil.formatTime(data.getStartTimeStr(), TimeUtil.notSecondFormat, TimeUtil.dateYMDFormat2);
            TextView textView7 = holder.getBinding().tvConsultDate;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str2 = String.format("%s %s", Arrays.copyOf(new Object[]{time, TimeUtil.getWeek(TimeUtil.gettime(data.getStartTimeStr(), TimeUtil.notSecondFormat))}, 2));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            textView7.setText(str2);
            String startTime = TimeUtil.formatTime(data.getStartTimeStr(), TimeUtil.notSecondFormat, TimeUtil.hoursMinuteTimeFormat);
            if (!TextUtils.isEmpty(startTime) && startTime.length() > 4) {
                TextView textView8 = holder.getBinding().tvStartHours1;
                Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
                String strSubstring2 = startTime.substring(0, 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                textView8.setText(strSubstring2);
                TextView textView9 = holder.getBinding().tvStartHours2;
                String strSubstring3 = startTime.substring(1, 2);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                textView9.setText(strSubstring3);
                TextView textView10 = holder.getBinding().tvStartMinutes1;
                String strSubstring4 = startTime.substring(3, 4);
                Intrinsics.checkNotNullExpressionValue(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
                textView10.setText(strSubstring4);
                TextView textView11 = holder.getBinding().tvStartMinutes2;
                String strSubstring5 = startTime.substring(4, 5);
                Intrinsics.checkNotNullExpressionValue(strSubstring5, "this as java.lang.String…ing(startIndex, endIndex)");
                textView11.setText(strSubstring5);
            }
            String endTime = TimeUtil.formatTime(data.getEndTimeStr(), TimeUtil.notSecondFormat, TimeUtil.hoursMinuteTimeFormat);
            if (TextUtils.isEmpty(endTime) || endTime.length() <= 4) {
                return;
            }
            TextView textView12 = holder.getBinding().tvEndHours1;
            Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
            String strSubstring6 = endTime.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring6, "this as java.lang.String…ing(startIndex, endIndex)");
            textView12.setText(strSubstring6);
            TextView textView13 = holder.getBinding().tvEndHours2;
            String strSubstring7 = endTime.substring(1, 2);
            Intrinsics.checkNotNullExpressionValue(strSubstring7, "this as java.lang.String…ing(startIndex, endIndex)");
            textView13.setText(strSubstring7);
            TextView textView14 = holder.getBinding().tvEndMinutes1;
            String strSubstring8 = endTime.substring(3, 4);
            Intrinsics.checkNotNullExpressionValue(strSubstring8, "this as java.lang.String…ing(startIndex, endIndex)");
            textView14.setText(strSubstring8);
            TextView textView15 = holder.getBinding().tvEndMinutes2;
            String strSubstring9 = endTime.substring(4, 5);
            Intrinsics.checkNotNullExpressionValue(strSubstring9, "this as java.lang.String…ing(startIndex, endIndex)");
            textView15.setText(strSubstring9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindView$lambda$3$lambda$1(Consult2x6Adapter this$0, ReservationRecordBean data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.itemClick(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindView$lambda$3$lambda$2(Consult2x6Adapter this$0, ReservationRecordBean data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.itemClick(data);
    }

    private final void itemClick(ReservationRecordBean data) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : data.getSignList()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ReservationSignListItemBean reservationSignListItemBean = (ReservationSignListItemBean) obj;
            if (reservationSignListItemBean.getUserType() == 1) {
                arrayList.add(reservationSignListItemBean);
            }
            i = i2;
        }
        OnItemClickCallback onItemClickCallback = this.mOnItemClickCallback;
        if (onItemClickCallback != null) {
            onItemClickCallback.itemClick(data, arrayList);
        }
    }

    /* JADX INFO: compiled from: Consult2x6Adapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/consult/Consult2x6Adapter$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yd/android_brand_mvp/databinding/BannerItemConsult2x6Binding;", "(Lcom/yd/android_brand_mvp/adapter/consult/Consult2x6Adapter;Lcom/yd/android_brand_mvp/databinding/BannerItemConsult2x6Binding;)V", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/BannerItemConsult2x6Binding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final BannerItemConsult2x6Binding binding;
        final /* synthetic */ Consult2x6Adapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(Consult2x6Adapter consult2x6Adapter, BannerItemConsult2x6Binding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = consult2x6Adapter;
            this.binding = binding;
        }

        public final BannerItemConsult2x6Binding getBinding() {
            return this.binding;
        }
    }

    public final void setOnItemClickCallback(OnItemClickCallback mOnItemClickCallback) {
        Intrinsics.checkNotNullParameter(mOnItemClickCallback, "mOnItemClickCallback");
        this.mOnItemClickCallback = mOnItemClickCallback;
    }
}
