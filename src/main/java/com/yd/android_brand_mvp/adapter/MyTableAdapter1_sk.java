package com.yd.android_brand_mvp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.TableRsp;
import com.yd.android_brand_mvp.utils.SortList;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.VHUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MyTableAdapter1_sk extends BaseAdapter {
    Activity activity;
    String tab;
    int week;
    int weekCount;
    public List<TableRsp> list = new ArrayList();
    boolean timetable = false;
    boolean isNight = false;
    int nextIndex = 0;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    void setTextView(TextView textView, boolean z) {
    }

    public MyTableAdapter1_sk(Activity activity, int i) {
        this.activity = activity;
        this.week = i;
    }

    public MyTableAdapter1_sk(Activity activity, int i, String str) {
        this.activity = activity;
        this.week = i;
        this.tab = str;
    }

    public MyTableAdapter1_sk(Activity activity) {
        this.activity = activity;
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
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_mytable_item_h1_sk, (ViewGroup) null, false);
        TextView textView = (TextView) VHUtil.ViewHolder.get(viewInflate, R.id.teacherName);
        ConstraintLayout constraintLayout = (ConstraintLayout) VHUtil.ViewHolder.get(viewInflate, R.id.cl_bg);
        TextView textView2 = (TextView) VHUtil.ViewHolder.get(viewInflate, R.id.subjectName);
        ((TextView) VHUtil.ViewHolder.get(viewInflate, R.id.time)).setText(getItem(i).startTime + Constants.ACCEPT_TIME_SEPARATOR_SERVER + getItem(i).endTime);
        if (getItem(i).otherSubjectName != null) {
            if (this.weekCount % 2 == 0) {
                if (!StringUtils.isEmpty(getItem(i).otherSubjectName) && getItem(i).otherSubjectName.length() > 5) {
                    z = true;
                }
                setTextView(textView2, z);
                textView2.setText(getItem(i).otherSubjectName);
                textView.setText(getItem(i).otherClassesTeacher);
            } else {
                if (!StringUtils.isEmpty(getItem(i).subjectsName) && getItem(i).subjectsName.length() > 5) {
                    z = true;
                }
                setTextView(textView2, z);
                textView2.setText(getItem(i).subjectsName);
                textView.setText(getItem(i).otherClassesTeacher);
            }
        } else {
            if (!StringUtils.isEmpty(getItem(i).subjectsName) && getItem(i).subjectsName.length() > 5) {
                z = true;
            }
            setTextView(textView2, z);
            textView2.setText(getItem(i).subjectsName);
            List<KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO> list = getItem(i).teacherList;
            textView.setText(getItem(i).teacherName);
        }
        int intWeek = TimeUtil.getIntWeek(System.currentTimeMillis());
        if (i == 0) {
            strStampToDate7 = TimeUtil.stampToDate7(TimeUtil.gettime55(getItem(i).startTime) + 5000);
        } else {
            strStampToDate7 = getItem(i).startTime;
        }
        if (TimeUtil.isBelong(strStampToDate7, getItem(i).endTime) && intWeek == this.week) {
            this.isNight = true;
            constraintLayout.setBackgroundResource(R.drawable.icon_kbl_sk);
            this.nextIndex = i;
        } else {
            constraintLayout.setBackgroundResource(R.drawable.icon_kb_white_sk);
        }
        return viewInflate;
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
        this.list = list;
        this.isNight = false;
        this.list = SortList.listSorting2(list);
        notifyDataSetChanged();
    }

    public void notifyData(List<TableRsp> list, int i) {
        this.list = list;
        this.isNight = false;
        this.list = SortList.listSorting2(list);
        notifyDataSetInvalidated();
    }

    public int getNextIndex() {
        return this.nextIndex;
    }
}
