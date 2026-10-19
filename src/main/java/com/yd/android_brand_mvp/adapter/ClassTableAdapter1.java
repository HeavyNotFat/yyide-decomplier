package com.yd.android_brand_mvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.TableRsp;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.yd.android_brand_mvp.utils.SortList;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.VHUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class ClassTableAdapter1 extends BaseAdapter {
    public List<TableRsp> list = new ArrayList();
    int nextIndex = -1;
    int weekCount;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
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
        String str;
        String strStampToDate7;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_table_item2_2p, (ViewGroup) null, false);
        }
        TextView textView = (TextView) VHUtil.ViewHolder.get(view, R.id.subjectName);
        ImageView imageView = (ImageView) VHUtil.ViewHolder.get(view, R.id.iv_img);
        TextView textView2 = (TextView) VHUtil.ViewHolder.get(view, R.id.time);
        TextView textView3 = (TextView) VHUtil.ViewHolder.get(view, R.id.e_time);
        TextView textView4 = (TextView) VHUtil.ViewHolder.get(view, R.id.no);
        if (!StringUtils.isEmpty(getItem(i).otherSubjectName)) {
            if (this.weekCount % 2 == 0) {
                str = getItem(i).otherClassesTeacher;
                textView.setText(getItem(i).otherSubjectName);
                imageView.setImageResource(R.drawable.icon_two_st);
            } else {
                imageView.setImageResource(R.drawable.icon_one_st);
                str = getItem(i).teacherName;
                textView.setText(getItem(i).subjectsName);
            }
        } else {
            str = getItem(i).teacherName;
            textView.setText(getItem(i).subjectsName);
        }
        if (!StringUtils.isEmpty(str) && str.length() > 4) {
            str = str.substring(0, 4) + "...";
        }
        textView2.setText(getItem(i).startTime + Constants.ACCEPT_TIME_SEPARATOR_SERVER + getItem(i).endTime + "    " + str);
        if ("0".equals(getItem(i).timeFrame)) {
            textView4.setText("早读");
            textView4.setTextSize(SizeUtils.px2sp(20.0f));
        } else {
            textView4.setText(getItem(i).seletion + "");
            textView4.setTextSize((float) SizeUtils.px2sp(20.0f));
        }
        if (i == 0) {
            strStampToDate7 = TimeUtil.stampToDate7(TimeUtil.gettime55(getItem(i).startTime) + 5000);
        } else {
            strStampToDate7 = getItem(i - 1).endTime;
        }
        try {
            if (isBelong(strStampToDate7, getItem(i).endTime)) {
                textView4.setTextColor(SkinCompatResources.getInstance().getColor(R.color.color_bule67));
                textView3.setTextColor(SkinCompatResources.getInstance().getColor(R.color.color_bule67));
                this.nextIndex = i;
            } else {
                textView4.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
                textView3.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (textView4.getText().toString().equals("1")) {
            textView3.setText("ONE");
        } else if (textView4.getText().toString().equals("2")) {
            textView3.setText("TWO");
        } else if (textView4.getText().toString().equals("3")) {
            textView3.setText("THREE");
        } else if (textView4.getText().toString().equals("4")) {
            textView3.setText("FOUR");
        } else if (textView4.getText().toString().equals(ConversionUtil.conditionWithSeriesName)) {
            textView3.setText("FIVE");
        } else if (textView4.getText().toString().equals(ConversionUtil.conditionWithCallNumber)) {
            textView3.setText("SIX");
        } else if (textView4.getText().toString().equals(ConversionUtil.conditionWithBookType)) {
            textView3.setText("SEVEN");
        } else if (textView4.getText().toString().equals(ConversionUtil.conditionWithPublishStartYear)) {
            textView3.setText("EIGHT");
        } else if (textView4.getText().toString().equals(ConversionUtil.conditionWithPublishEndYear)) {
            textView3.setText("NINE");
        } else if (textView4.getText().toString().equals(ConversionUtil.conditionWithSort)) {
            textView3.setText("TEN");
        } else if (textView4.getText().toString().equals(ConversionUtil.conditionWithYear)) {
            textView3.setText("ELEVEN");
        } else if (textView4.getText().toString().equals("12")) {
            textView3.setText("TWELVE");
        } else if (textView4.getText().toString().equals("13")) {
            textView3.setText("THIRTEEN");
        } else if (textView4.getText().toString().equals("14")) {
            textView3.setText("FOURTEEN");
        } else if (textView4.getText().toString().equals("15")) {
            textView3.setText("FIFTEEN");
        } else if (textView4.getText().toString().equals("16")) {
            textView3.setText("SIXTEEN");
        } else if (textView4.getText().toString().equals("17")) {
            textView3.setText("SEVENTEEN");
        } else if (textView4.getText().toString().equals("18")) {
            textView3.setText("EIGHTEEN");
        } else if (textView4.getText().toString().equals("19")) {
            textView3.setText("NINETEEN");
        } else if (textView4.getText().toString().equals("早读")) {
            textView3.setText("");
        }
        return view;
    }

    public void setWeek(int i) {
        this.weekCount = i;
    }

    public void notifyData(List<TableRsp> list) {
        this.list = list;
        this.list = SortList.listSorting2(list);
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

    public int getNextIndex() {
        return this.nextIndex;
    }
}
