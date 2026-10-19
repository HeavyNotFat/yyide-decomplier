package com.yd.android_brand_mvp.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.necer.painter.CalendarAdapter;
import com.necer.utils.CalendarUtil;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.selectSchoolCalendarRsp;
import com.yd.android_brand_mvp.utils.TimeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.joda.time.LocalDate;

/* JADX INFO: loaded from: classes4.dex */
public class GeneralAdapter extends CalendarAdapter {
    String endData;
    public LastOrNextOnClickListener lastOrNextOnClickListener;
    public List<selectSchoolCalendarRsp.DataDTO> list = new ArrayList();
    public String selectTime = "";
    String startData;

    public interface LastOrNextOnClickListener {
        void onLastOrNextOnClickListener(LocalDate localDate);
    }

    @Override // com.necer.painter.CalendarAdapter
    public View getCalendarItemView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.item_calendar3, (ViewGroup) null);
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
        Iterator<selectSchoolCalendarRsp.DataDTO> it2 = this.list.iterator();
        while (it2.hasNext()) {
            if (localDate.toString().equals(it2.next().startTime)) {
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
        Iterator<selectSchoolCalendarRsp.DataDTO> it2 = this.list.iterator();
        while (it2.hasNext()) {
            if (localDate.toString().equals(it2.next().startTime)) {
                textView3.setVisibility(0);
            }
        }
        if (list.contains(localDate)) {
            viewFindViewById.setBackgroundResource(R.drawable.bg_unchecked);
        } else {
            viewFindViewById.setBackgroundResource(R.drawable.bg_unchecked);
        }
        if (this.selectTime.contains(localDate.toString())) {
            viewFindViewById.setBackgroundResource(R.drawable.bg_checked2);
            textView.setTextColor(-1);
            textView2.setVisibility(8);
            return;
        }
        viewFindViewById.setBackgroundResource(R.drawable.bg_unchecked);
    }

    @Override // com.necer.painter.CalendarAdapter
    public void onBindLastOrNextMonthView(View view, final LocalDate localDate, List<LocalDate> list) {
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
        Iterator<selectSchoolCalendarRsp.DataDTO> it2 = this.list.iterator();
        while (it2.hasNext()) {
            if (localDate.toString().equals(it2.next().startTime)) {
                textView2.setVisibility(0);
            }
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.adapter.GeneralAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (GeneralAdapter.this.lastOrNextOnClickListener == null || TextUtils.isEmpty(GeneralAdapter.this.startData) || TextUtils.isEmpty(GeneralAdapter.this.endData)) {
                    return;
                }
                long j = TimeUtil.gettime10(GeneralAdapter.this.startData);
                long j2 = TimeUtil.gettime10(GeneralAdapter.this.endData);
                long j3 = TimeUtil.gettime10(localDate.toString());
                Log.e("TAG", "time1: " + j + "==》" + GeneralAdapter.this.startData);
                Log.e("TAG", "time2: " + j2 + "==》" + GeneralAdapter.this.endData);
                Log.e("TAG", "time3: " + j3 + "==》" + localDate.toString());
                if (j >= j3 || j3 >= j2) {
                    return;
                }
                GeneralAdapter.this.lastOrNextOnClickListener.onLastOrNextOnClickListener(localDate);
            }
        });
    }

    private void setLunar(View view, LocalDate localDate) {
        ((TextView) view.findViewById(R.id.tv_lunar)).setText(CalendarUtil.getCalendarDate(localDate).lunar.lunarOnDrawStr);
    }

    public void notydata(List<selectSchoolCalendarRsp.DataDTO> list) {
        this.list = list;
    }

    public void setIndex(String str) {
        this.selectTime = str;
    }

    public void setLastOrNextOnClickListener(LastOrNextOnClickListener lastOrNextOnClickListener) {
        this.lastOrNextOnClickListener = lastOrNextOnClickListener;
    }

    public void setTimeContent(String str, String str2) {
        this.startData = str;
        this.endData = str2;
    }
}
