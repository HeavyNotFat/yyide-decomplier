package com.yd.android_brand_mvp.adapter;

import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemCartoonTableDayBinding;
import com.yd.android_brand_mvp.model.TableRsp;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.yd.android_brand_mvp.utils.TimeUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClassTableCartoonAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0014J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0006R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/ClassTableCartoonAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/TableRsp;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "nextIndex", "", "getNextIndex", "()I", "setNextIndex", "(I)V", "weekCount", "getWeekCount", "setWeekCount", "convert", "", "holder", "item", "isBelong", "", TtmlNode.START, "", "end", "setWeek", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClassTableCartoonAdapter extends BaseQuickAdapter<TableRsp, BaseViewHolder> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int nextIndex;
    private int weekCount;

    public ClassTableCartoonAdapter() {
        super(R.layout.item_cartoon_table_day, null, 2, null);
        this.nextIndex = -1;
    }

    public final int getWeekCount() {
        return this.weekCount;
    }

    public final void setWeekCount(int i) {
        this.weekCount = i;
    }

    public final int getNextIndex() {
        return this.nextIndex;
    }

    public final void setNextIndex(int i) {
        this.nextIndex = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, TableRsp item) {
        String string;
        String strStampToDate7;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemCartoonTableDayBinding itemCartoonTableDayBindingBind = ItemCartoonTableDayBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemCartoonTableDayBindingBind, "bind(holder.itemView)");
        if (!StringUtils.isEmpty(item.otherSubjectName)) {
            if (this.weekCount % 2 == 0) {
                string = item.otherClassesTeacher;
                Intrinsics.checkNotNullExpressionValue(string, "item.otherClassesTeacher");
                itemCartoonTableDayBindingBind.tvTableName.setText(item.otherSubjectName);
            } else {
                string = item.teacherName;
                Intrinsics.checkNotNullExpressionValue(string, "item.teacherName");
                itemCartoonTableDayBindingBind.tvTableName.setText(item.subjectsName);
            }
        } else {
            string = item.teacherName;
            Intrinsics.checkNotNullExpressionValue(string, "item.teacherName");
            itemCartoonTableDayBindingBind.tvTableName.setText(item.subjectsName);
        }
        if (!StringUtils.isEmpty(string) && string.length() > 4) {
            StringBuilder sb = new StringBuilder();
            String strSubstring = string.substring(0, 4);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(strSubstring);
            sb.append("...");
            string = sb.toString();
        }
        if (StringUtils.isEmpty(string)) {
            string = "";
        }
        itemCartoonTableDayBindingBind.tvTableTime.setText(item.startTime + '-' + item.endTime);
        itemCartoonTableDayBindingBind.tvTableTeacherName.setText(string);
        if (!StringUtils.isEmpty(item.kbIndex)) {
            itemCartoonTableDayBindingBind.f2007no.setText(item.kbIndex);
        } else if (Intrinsics.areEqual("0", item.timeFrame)) {
            itemCartoonTableDayBindingBind.f2007no.setText("早读");
        } else {
            itemCartoonTableDayBindingBind.f2007no.setText(item.seletion + "");
        }
        if (holder.getAdapterPosition() == 0) {
            strStampToDate7 = TimeUtil.stampToDate7(TimeUtil.gettime55(item.startTime) + ((long) 5000));
        } else {
            strStampToDate7 = getItem(holder.getAdapterPosition() - 1).endTime;
        }
        try {
            if (isBelong(strStampToDate7, item.endTime)) {
                itemCartoonTableDayBindingBind.tvTableIng.setVisibility(0);
                itemCartoonTableDayBindingBind.getRoot().setBackgroundResource(R.drawable.shape_cartoon_check_table_day_20);
                this.nextIndex = holder.getAdapterPosition();
                itemCartoonTableDayBindingBind.f2007no.setTextColor(getContext().getResources().getColor(R.color.white));
                itemCartoonTableDayBindingBind.seletionEnglish.setTextColor(getContext().getResources().getColor(R.color.white));
                itemCartoonTableDayBindingBind.tvTableTime.setTextColor(getContext().getResources().getColor(R.color.white));
                itemCartoonTableDayBindingBind.tvTableTeacherName.setTextColor(getContext().getResources().getColor(R.color.white));
            } else {
                itemCartoonTableDayBindingBind.tvTableIng.setVisibility(8);
                itemCartoonTableDayBindingBind.getRoot().setBackgroundResource(R.drawable.shape_cartoon_table_day_20);
                itemCartoonTableDayBindingBind.f2007no.setTextColor(getContext().getResources().getColor(R.color.black12));
                itemCartoonTableDayBindingBind.seletionEnglish.setTextColor(getContext().getResources().getColor(R.color.black12));
                itemCartoonTableDayBindingBind.tvTableTime.setTextColor(getContext().getResources().getColor(R.color.black12));
                itemCartoonTableDayBindingBind.tvTableTeacherName.setTextColor(getContext().getResources().getColor(R.color.black12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), "1")) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("ONE");
            return;
        }
        if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), "2")) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("TWO");
            return;
        }
        if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), "3")) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("THREE");
            return;
        }
        if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), "4")) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("FOUR");
            return;
        }
        if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), ConversionUtil.conditionWithSeriesName)) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("FIVE");
            return;
        }
        if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), ConversionUtil.conditionWithCallNumber)) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("SIX");
            return;
        }
        if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), ConversionUtil.conditionWithBookType)) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("SEVEN");
            return;
        }
        if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), ConversionUtil.conditionWithPublishStartYear)) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("EIGHT");
            return;
        }
        if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), ConversionUtil.conditionWithPublishEndYear)) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("NINE");
            return;
        }
        if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), ConversionUtil.conditionWithSort)) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("TEN");
            return;
        }
        if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), ConversionUtil.conditionWithYear)) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("ELEVEN");
            return;
        }
        if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), "12")) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("TWELVE");
            return;
        }
        if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), "13")) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("THIRTEEN");
            return;
        }
        if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), "14")) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("FOURTEEN");
            return;
        }
        if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), "15")) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("FIFTEEN");
            return;
        }
        if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), "16")) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("SIXTEEN");
            return;
        }
        if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), "17")) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("SEVENTEEN");
            return;
        }
        if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), "18")) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("EIGHTEEN");
        } else if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), "19")) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("NINETEEN");
        } else if (Intrinsics.areEqual(itemCartoonTableDayBindingBind.f2007no.getText().toString(), "早读")) {
            itemCartoonTableDayBindingBind.seletionEnglish.setText("");
        }
    }

    public final void setWeek(int weekCount) {
        this.weekCount = weekCount;
    }

    public final boolean isBelong(String start, String end) {
        Date date;
        Date date2;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
            Date date3 = null;
            try {
                date2 = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
                try {
                    date = simpleDateFormat.parse(start);
                    try {
                        date3 = simpleDateFormat.parse(end);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e = e2;
                    date = null;
                }
            } catch (Exception e3) {
                e = e3;
                date = null;
                date2 = null;
            }
            return INSTANCE.belongCalendar(date2, date, date3);
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: compiled from: ClassTableCartoonAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/ClassTableCartoonAdapter$Companion;", "", "()V", "belongCalendar", "", "nowTime", "Ljava/util/Date;", "beginTime", "endTime", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
            Calendar calendar = Calendar.getInstance();
            if (nowTime != null) {
                calendar.setTime(nowTime);
            }
            Calendar calendar2 = Calendar.getInstance();
            if (beginTime != null) {
                calendar2.setTime(beginTime);
            }
            Calendar calendar3 = Calendar.getInstance();
            if (endTime != null) {
                calendar3.setTime(endTime);
            }
            return calendar.after(calendar2) && calendar.before(calendar3);
        }
    }
}
