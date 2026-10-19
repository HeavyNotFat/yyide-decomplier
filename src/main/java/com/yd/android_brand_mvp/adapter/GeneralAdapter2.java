package com.yd.android_brand_mvp.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.necer.painter.CalendarAdapter;
import com.necer.utils.CalendarUtil;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.selectSchoolCalendarRsp;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDate;

/* JADX INFO: loaded from: classes4.dex */
public class GeneralAdapter2 extends CalendarAdapter {
    public List<selectSchoolCalendarRsp.DataDTO> list = new ArrayList();

    @Override // com.necer.painter.CalendarAdapter
    public View getCalendarItemView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.item_calendar4, (ViewGroup) null);
    }

    @Override // com.necer.painter.CalendarAdapter
    public void onBindToadyView(View view, LocalDate localDate, List<LocalDate> list) {
        View viewFindViewById = view.findViewById(R.id.ll_content);
        TextView textView = (TextView) view.findViewById(R.id.flag);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_item);
        TextView textView3 = (TextView) view.findViewById(R.id.tv_lunar);
        textView2.setTextColor(SupportMenu.CATEGORY_MASK);
        textView2.setText(String.valueOf(localDate.getDayOfMonth()));
        setLunar(view, localDate);
        for (selectSchoolCalendarRsp.DataDTO dataDTO : this.list) {
            if (!TextUtils.isEmpty(dataDTO.startTime) && textView != null && localDate.toString().equals(dataDTO.startTime)) {
                textView.setVisibility(0);
            }
        }
        if (list.contains(localDate)) {
            viewFindViewById.setBackgroundResource(R.drawable.bg_checked2);
            textView2.setTextColor(-1);
            textView3.setVisibility(8);
            return;
        }
        viewFindViewById.setBackgroundResource(R.drawable.bg_unchecked);
    }

    @Override // com.necer.painter.CalendarAdapter
    public void onBindCurrentMonthOrWeekView(View view, LocalDate localDate, List<LocalDate> list) {
        View viewFindViewById = view.findViewById(R.id.ll_content);
        TextView textView = (TextView) view.findViewById(R.id.tv_item);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_lunar);
        TextView textView3 = (TextView) view.findViewById(R.id.flag);
        textView.setTextColor(-16777216);
        textView.setText(String.valueOf(localDate.getDayOfMonth()));
        setLunar(view, localDate);
        textView2.setVisibility(8);
        for (selectSchoolCalendarRsp.DataDTO dataDTO : this.list) {
            if (!TextUtils.isEmpty(dataDTO.startTime) && textView3 != null && localDate.toString().equals(dataDTO.startTime)) {
                textView3.setVisibility(0);
            }
        }
        if (list.contains(localDate)) {
            viewFindViewById.setBackgroundResource(R.drawable.bg_unchecked);
        } else {
            viewFindViewById.setBackgroundResource(R.drawable.bg_unchecked);
        }
    }

    @Override // com.necer.painter.CalendarAdapter
    public void onBindLastOrNextMonthView(View view, LocalDate localDate, List<LocalDate> list) {
        View viewFindViewById = view.findViewById(R.id.ll_content);
        TextView textView = (TextView) view.findViewById(R.id.tv_item);
        TextView textView2 = (TextView) view.findViewById(R.id.flag);
        TextView textView3 = (TextView) view.findViewById(R.id.tv_lunar);
        textView.setTextColor(-7829368);
        textView.setText(String.valueOf(localDate.getDayOfMonth()));
        textView3.setVisibility(8);
        setLunar(view, localDate);
        if (list.contains(localDate)) {
            viewFindViewById.setBackgroundResource(R.drawable.bg_last_next_checked);
        } else {
            viewFindViewById.setBackgroundResource(R.drawable.bg_unchecked);
        }
        for (selectSchoolCalendarRsp.DataDTO dataDTO : this.list) {
            if (!TextUtils.isEmpty(dataDTO.startTime) && textView2 != null && localDate.toString().equals(dataDTO.startTime)) {
                textView2.setVisibility(0);
            }
        }
    }

    private void setLunar(View view, LocalDate localDate) {
        ((TextView) view.findViewById(R.id.tv_lunar)).setText(CalendarUtil.getCalendarDate(localDate).lunar.lunarOnDrawStr);
    }

    public void notydata(List<selectSchoolCalendarRsp.DataDTO> list) {
        this.list = list;
    }
}
