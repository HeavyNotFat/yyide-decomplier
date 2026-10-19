package com.yd.android_brand_mvp.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.TableRsp;
import com.yd.android_brand_mvp.utils.SortList;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.VHUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MyTableAdapter1 extends BaseAdapter {
    Activity activity;
    String tab;
    int week;
    int weekCount;
    public List<TableRsp> list = new ArrayList();
    boolean timetable = false;
    int nextIndex = 0;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public MyTableAdapter1(Activity activity, int i) {
        this.activity = activity;
        this.week = i;
    }

    public MyTableAdapter1(Activity activity, int i, String str) {
        this.activity = activity;
        this.week = i;
        this.tab = str;
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
        String strStampToDate7;
        boolean z = false;
        if (view == null) {
            if (ScreenUtils.isLandscape()) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_mytable_item_h1, (ViewGroup) null, false);
            } else if (!StringUtils.isEmpty(this.tab) && this.tab.equals("sbkb42")) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_mytable_item_4_2, (ViewGroup) null, false);
            } else if (!StringUtils.isEmpty(this.tab) && this.tab.equals("sbcdkb42")) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_mytable_item_4_2, (ViewGroup) null, false);
            } else if (!StringUtils.isEmpty(this.tab) && this.tab.equals("sbcdkb63")) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_mytable_item_6_3, (ViewGroup) null, false);
            } else if (!StringUtils.isEmpty(this.tab) && this.tab.equals("sbkb63")) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_mytable_item_6_3, (ViewGroup) null, false);
            } else {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_mytable_item_4_2, (ViewGroup) null, false);
            }
        }
        TextView textView = (TextView) VHUtil.ViewHolder.get(view, R.id.teacherName);
        TextView textView2 = (TextView) VHUtil.ViewHolder.get(view, R.id.seletion);
        RelativeLayout relativeLayout = (RelativeLayout) VHUtil.ViewHolder.get(view, R.id.rl_bg);
        TextView textView3 = (TextView) VHUtil.ViewHolder.get(view, R.id.subjectName);
        TextView textView4 = (TextView) VHUtil.ViewHolder.get(view, R.id.tv_table_tip);
        ImageView imageView = (ImageView) VHUtil.ViewHolder.get(view, R.id.iv_d);
        TextView textView5 = (TextView) VHUtil.ViewHolder.get(view, R.id.time);
        TableRsp item = getItem(i);
        textView5.setText(item.startTime + Constants.ACCEPT_TIME_SEPARATOR_SERVER + item.endTime);
        textView2.setText(item.sectionName);
        Log.i("MyTableAdapter1", "courseType = " + item.courseType);
        if ("2".equals(item.courseType)) {
            textView4.setVisibility(0);
            textView4.setBackgroundResource(R.drawable.bg_table_left_tip);
            textView4.setText("调课");
        } else if ("3".equals(item.courseType)) {
            textView4.setVisibility(0);
            textView4.setBackgroundResource(R.drawable.bg_table_left_tip2);
            textView4.setText("代课");
        } else {
            textView4.setVisibility(8);
        }
        if (item.otherSubjectName != null) {
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (this.weekCount % 2 == 0) {
                if (!StringUtils.isEmpty(item.otherSubjectName) && item.otherSubjectName.length() > 5) {
                    z = true;
                }
                setTextView(textView3, z);
                imageView.setImageResource(R.drawable.icon_two_st);
                textView3.setText(item.otherSubjectName);
                textView.setText(item.otherClassesTeacher);
            } else {
                if (!StringUtils.isEmpty(item.subjectsName) && item.subjectsName.length() > 5) {
                    z = true;
                }
                setTextView(textView3, z);
                imageView.setImageResource(R.drawable.icon_one_st);
                textView3.setText(item.subjectsName);
                textView.setText(item.otherClassesTeacher);
            }
        } else {
            if (!StringUtils.isEmpty(item.subjectsName) && item.subjectsName.length() > 5) {
                z = true;
            }
            setTextView(textView3, z);
            textView3.setText(item.subjectsName);
            textView.setText(item.teacherName);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
        int intWeek = TimeUtil.getIntWeek(System.currentTimeMillis());
        if (TextUtils.isEmpty(item.startTime)) {
            strStampToDate7 = "";
        } else {
            long j = TimeUtil.gettime55(item.startTime);
            if (i == 0) {
                strStampToDate7 = TimeUtil.stampToDate7(j - 300000);
            } else {
                strStampToDate7 = TimeUtil.stampToDate7(j - 60000);
            }
        }
        if (TimeUtil.forRemindTime(strStampToDate7, item.endTime) && intWeek == this.week) {
            relativeLayout.setBackgroundResource(R.drawable.icon_kbl);
            this.nextIndex = i;
        } else {
            relativeLayout.setBackgroundResource(R.drawable.icon_kb_white);
        }
        return view;
    }

    void setTextView(TextView textView, boolean z) {
        if (z) {
            if (ScreenUtils.isLandscape() || StringUtils.isEmpty(this.tab) || this.tab.equals("sbkb63")) {
                textView.setTextSize(SizeUtils.px2sp(20.0f));
            } else {
                textView.setTextSize(SizeUtils.px2sp(20.0f));
            }
            textView.setSingleLine(false);
            textView.setLines(2);
            return;
        }
        if (ScreenUtils.isLandscape() || StringUtils.isEmpty(this.tab) || this.tab.equals("sbkb63")) {
            textView.setTextSize(SizeUtils.px2sp(20.0f));
        } else {
            textView.setTextSize(SizeUtils.px2sp(20.0f));
        }
        textView.setSingleLine(false);
        textView.setLines(1);
    }

    public void setWeekCount(String str, String str2) {
        if ("单双周课表不同".equals(str2)) {
            this.timetable = true;
            if (StringUtils.isEmpty(str)) {
                this.weekCount = -1;
                return;
            } else {
                this.weekCount = Integer.parseInt(str);
                return;
            }
        }
        this.timetable = false;
    }

    public void notifyData(List<TableRsp> list) {
        this.list = SortList.listSorting2(list);
        notifyDataSetChanged();
    }

    public void notifyData(List<TableRsp> list, int i) {
        this.list = SortList.listSorting2(list);
        notifyDataSetChanged();
    }

    public int getNextIndex() {
        return this.nextIndex;
    }
}
