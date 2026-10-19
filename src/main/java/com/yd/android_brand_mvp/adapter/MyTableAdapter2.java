package com.yd.android_brand_mvp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.ScreenUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.TableRsp;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.VHUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MyTableAdapter2 extends BaseAdapter {
    Activity activity;
    int week;
    List<TableRsp> list = new ArrayList();
    int nextIndex = 0;
    boolean indexOpenbg = false;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public MyTableAdapter2(Activity activity, int i) {
        this.activity = activity;
        this.week = i;
    }

    public MyTableAdapter2(Activity activity) {
        this.activity = activity;
    }

    public List<TableRsp> getList() {
        return this.list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public TableRsp getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            if (ScreenUtils.isLandscape()) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_mytable_item_l, (ViewGroup) null, false);
            } else {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_mytable_item_l, (ViewGroup) null, false);
            }
        }
        RelativeLayout relativeLayout = (RelativeLayout) VHUtil.ViewHolder.get(view, R.id.rl_bg);
        TextView textView = (TextView) VHUtil.ViewHolder.get(view, R.id.subjectName);
        TextView textView2 = (TextView) VHUtil.ViewHolder.get(view, R.id.seletion);
        TextView textView3 = (TextView) VHUtil.ViewHolder.get(view, R.id.seletion_english);
        TextView textView4 = (TextView) VHUtil.ViewHolder.get(view, R.id.teacherName);
        TextView textView5 = (TextView) VHUtil.ViewHolder.get(view, R.id.time);
        textView.setText(getItem(i).subjectsName);
        textView4.setText(getItem(i).teacherName);
        textView5.setText(getItem(i).startTime + Constants.ACCEPT_TIME_SEPARATOR_SERVER + getItem(i).endTime);
        int intWeek = TimeUtil.getIntWeek(System.currentTimeMillis());
        if (isBelong(getItem(i).startTime, getItem(i).endTime) && intWeek == this.week) {
            relativeLayout.setBackground(viewGroup.getContext().getResources().getDrawable(R.drawable.icon_kbl));
            this.nextIndex = i + 1;
        } else {
            relativeLayout.setBackground(viewGroup.getContext().getResources().getDrawable(R.drawable.icon_kb_white));
        }
        for (int i2 = 0; i2 < this.list.size() - 1; i2++) {
        }
        textView2.setText((i + 1) + "");
        if (textView2.getText().toString().equals("1")) {
            textView3.setText("ONE");
        } else if (textView2.getText().toString().equals("2")) {
            textView3.setText("TWO");
        } else if (textView2.getText().toString().equals("3")) {
            textView3.setText("THREE");
        } else if (textView2.getText().toString().equals("4")) {
            textView3.setText("FOUR");
        } else if (textView2.getText().toString().equals(ConversionUtil.conditionWithSeriesName)) {
            textView3.setText("FIVE");
        } else if (textView2.getText().toString().equals(ConversionUtil.conditionWithCallNumber)) {
            textView3.setText("SIX");
        } else if (textView2.getText().toString().equals(ConversionUtil.conditionWithBookType)) {
            textView3.setText("SEVEN");
        } else if (textView2.getText().toString().equals(ConversionUtil.conditionWithPublishStartYear)) {
            textView3.setText("EIGHT");
        } else if (textView2.getText().toString().equals(ConversionUtil.conditionWithPublishEndYear)) {
            textView3.setText("NINE");
        } else if (textView2.getText().toString().equals(ConversionUtil.conditionWithSort)) {
            textView3.setText("TEN");
        } else if (textView2.getText().toString().equals(ConversionUtil.conditionWithYear)) {
            textView3.setText("ELEVEN");
        } else if (textView2.getText().toString().equals("12")) {
            textView3.setText("TWELVE");
        } else if (textView2.getText().toString().equals("13")) {
            textView3.setText("THIRTEEN");
        } else if (textView2.getText().toString().equals("14")) {
            textView3.setText("FOURTEEN");
        } else if (textView2.getText().toString().equals("15")) {
            textView3.setText("FIFTHEEN");
        }
        return view;
    }

    public void notifyData(List<TableRsp> list) {
        if (list != null) {
            this.list = list;
        }
        notifyDataSetChanged();
    }

    public void notifyData(List<TableRsp> list, int i) {
        this.list = list;
        this.week = i;
        notifyDataSetChanged();
    }

    public void notifyNow() {
        notifyDataSetChanged();
    }

    public boolean isBelong(String str, String str2) {
        Date date;
        Date date2;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        Date date3 = null;
        try {
            date2 = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            try {
                date = simpleDateFormat.parse(str);
                try {
                    date3 = simpleDateFormat.parse(str2);
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
        return belongCalendar(date2, date, date3);
    }

    public static boolean belongCalendar(Date date, Date date2, Date date3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date3);
        return calendar.after(calendar2) && calendar.before(calendar3);
    }

    public boolean isBelong2(String str) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        Date date2 = null;
        try {
            date = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            try {
                date2 = simpleDateFormat.parse(str);
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e = e2;
            date = null;
        }
        return belongCalendar2(date, date2);
    }

    public static boolean belongCalendar2(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar.before(calendar2);
    }
}
