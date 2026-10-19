package com.yd.android_brand_mvp.landscape.consult;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemConsult4x4Binding;
import com.yd.android_brand_mvp.dialog.ConsultDetailsDialog;
import com.yd.android_brand_mvp.dialog.ConsultListHeadDialog;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
import com.yd.android_brand_mvp.model.reservation.ReservationSignListItemBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TimeUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: ConsultFragment4x4.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¨\u0006\b"}, d2 = {"com/yd/android_brand_mvp/landscape/consult/ConsultFragment4x4$mAdapter$1", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConsultFragment4x4$mAdapter$1 extends BaseQuickAdapter<ReservationRecordBean, BaseViewHolder> {
    final /* synthetic */ ConsultFragment4x4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConsultFragment4x4$mAdapter$1(ConsultFragment4x4 consultFragment4x4) {
        super(R.layout.item_consult_4x4, null, 2, null);
        this.this$0 = consultFragment4x4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, final ReservationRecordBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemConsult4x4Binding itemConsult4x4BindingBind = ItemConsult4x4Binding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemConsult4x4BindingBind, "bind(holder.itemView)");
        itemConsult4x4BindingBind.tvWeek.setText(item.getWeek());
        final ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : item.getSignList()) {
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
        String userName = "";
        if (arrayList.size() > 0) {
            ReservationSignListItemBean reservationSignListItemBean2 = (ReservationSignListItemBean) CollectionsKt.first((List) arrayList);
            userName = reservationSignListItemBean2.getUserName();
            if (arrayList.size() > 1) {
                TextView textView = itemConsult4x4BindingBind.tvConsultNameMore;
                Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.tvConsultNameMore");
                SimpleUtilsKt.show(textView);
                TextView textView2 = itemConsult4x4BindingBind.tvConsultNameMore;
                final ConsultFragment4x4 consultFragment4x4 = this.this$0;
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.consult.-$$Lambda$ConsultFragment4x4$mAdapter$1$byNpNsUQxv7XMCwYCK6MIrxUcq8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ConsultFragment4x4$mAdapter$1.convert$lambda$1(item, arrayList, consultFragment4x4, view);
                    }
                });
            }
            if (!TextUtils.isEmpty(reservationSignListItemBean2.getAvatar())) {
                ImageView imageView = itemConsult4x4BindingBind.ivHead;
                Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.ivHead");
                SimpleUtilsKt.show(imageView);
                GlideUtil.loadCircleImage(this.this$0.requireContext(), reservationSignListItemBean2.getAvatar(), itemConsult4x4BindingBind.ivHead);
            } else if (!TextUtils.isEmpty(userName)) {
                ImageView imageView2 = itemConsult4x4BindingBind.ivHead;
                Intrinsics.checkNotNullExpressionValue(imageView2, "viewBinding.ivHead");
                SimpleUtilsKt.remove(imageView2);
                TextView textView3 = itemConsult4x4BindingBind.tvHeadName;
                String strSubstring = userName.substring(0, 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                textView3.setText(strSubstring);
            }
        } else {
            TextView textView4 = itemConsult4x4BindingBind.tvHeadName;
            Intrinsics.checkNotNullExpressionValue(textView4, "viewBinding.tvHeadName");
            SimpleUtilsKt.hide(textView4);
            ImageView imageView3 = itemConsult4x4BindingBind.ivHead;
            Intrinsics.checkNotNullExpressionValue(imageView3, "viewBinding.ivHead");
            SimpleUtilsKt.show(imageView3);
            itemConsult4x4BindingBind.tvHeadName.setText("");
            itemConsult4x4BindingBind.ivHead.setImageResource(R.drawable.icon_consult_default);
        }
        if (TextUtils.isEmpty(userName)) {
            userName = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        TextView textView5 = itemConsult4x4BindingBind.tvConsultName;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("咨询师：%s", Arrays.copyOf(new Object[]{userName}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView5.setText(str);
        itemConsult4x4BindingBind.tvHeadName.setTextColor(-1);
        String time = TimeUtil.formatTime(item.getEndTimeStr(), TimeUtil.notSecondFormat, TimeUtil.hoursMinuteTimeFormat);
        String time2 = TimeUtil.formatTime(item.getStartTimeStr(), TimeUtil.notSecondFormat, TimeUtil.notSecondFormat2);
        TextView textView6 = itemConsult4x4BindingBind.tvConsultDate;
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str2 = String.format("时间：%s-%s", Arrays.copyOf(new Object[]{time2, time}, 2));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        textView6.setText(str2);
        if (TimeUtil.isTime(item.getStartTimeStr(), item.getEndTimeStr())) {
            itemConsult4x4BindingBind.clContent.setBackgroundResource(R.drawable.bg_3f87ff_10);
            itemConsult4x4BindingBind.tvHeadName.setBackgroundResource(R.drawable.bg_white100);
            itemConsult4x4BindingBind.tvHeadName.setTextColor(this.this$0.getResources().getColor(R.color.blue3));
            itemConsult4x4BindingBind.tvConsultTitle.setTextColor(-1);
            itemConsult4x4BindingBind.tvConsultName.setTextColor(-1);
            itemConsult4x4BindingBind.tvConsultDate.setTextColor(-1);
            itemConsult4x4BindingBind.tvConsultNameMore.setTextColor(-1);
            itemConsult4x4BindingBind.tvWeek.setTextColor(-1);
            TextView textView7 = itemConsult4x4BindingBind.tvConsultTitle;
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String str3 = String.format("【进行中】%s", Arrays.copyOf(new Object[]{item.getName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
            textView7.setText(str3);
        } else {
            itemConsult4x4BindingBind.clContent.setBackgroundResource(R.drawable.bg_f6faff_10);
            itemConsult4x4BindingBind.tvConsultTitle.setTextColor(this.this$0.getResources().getColor(R.color.black9));
            itemConsult4x4BindingBind.tvConsultName.setTextColor(this.this$0.getResources().getColor(R.color.black11));
            itemConsult4x4BindingBind.tvConsultDate.setTextColor(this.this$0.getResources().getColor(R.color.black11));
            itemConsult4x4BindingBind.tvConsultNameMore.setTextColor(this.this$0.getResources().getColor(R.color.black11));
            itemConsult4x4BindingBind.tvWeek.setTextColor(this.this$0.getResources().getColor(R.color.black9));
            TextView textView8 = itemConsult4x4BindingBind.tvConsultTitle;
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            String str4 = String.format("【未开始】%s", Arrays.copyOf(new Object[]{item.getName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str4, "format(format, *args)");
            textView8.setText(str4);
        }
        if (TimeUtil.gettime(item.getEndTimeStr()) < System.currentTimeMillis()) {
            TextView textView9 = itemConsult4x4BindingBind.tvConsultTitle;
            StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
            String str5 = String.format("【已结束】%s", Arrays.copyOf(new Object[]{item.getName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str5, "format(format, *args)");
            textView9.setText(str5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$1(ReservationRecordBean item, List namesList, final ConsultFragment4x4 this$0, View view) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(namesList, "$namesList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ConsultListHeadDialog consultListHeadDialog = new ConsultListHeadDialog(item, namesList);
        consultListHeadDialog.setCallBack(new ConsultListHeadDialog.CallBack() { // from class: com.yd.android_brand_mvp.landscape.consult.ConsultFragment4x4$mAdapter$1$convert$2$1
            @Override // com.yd.android_brand_mvp.dialog.ConsultListHeadDialog.CallBack
            public void clickSubmit(ReservationRecordBean data, ReservationSignListItemBean item2) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(item2, "item");
                new ConsultDetailsDialog(item2.getUserId()).show(this$0.getParentFragmentManager(), "ConsultListHeadDialog");
            }
        });
        consultListHeadDialog.show(this$0.getParentFragmentManager(), "ConsultListHeadDialog");
    }
}
