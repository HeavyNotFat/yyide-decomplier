package com.yd.android_brand_mvp.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;
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
public class MyTableAdapter3 extends BaseAdapter {
    Activity activity;
    String tab;
    int week;
    List<TableRsp> list = new ArrayList();
    int nextIndex = 0;
    boolean indexOpenbg = false;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public MyTableAdapter3(Activity activity, int i) {
        this.activity = activity;
        this.week = i;
    }

    public MyTableAdapter3(Activity activity, int i, String str) {
        this.activity = activity;
        this.week = i;
        this.tab = str;
    }

    public MyTableAdapter3(Activity activity) {
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
        if (view == null) {
            if (ScreenUtils.isLandscape()) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_mytable_item_h, (ViewGroup) null, false);
            } else if (!StringUtils.isEmpty(this.tab) && this.tab.equals("sbkb42")) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_mytable_item_4_2, (ViewGroup) null, false);
            } else {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_mytable_item_l, (ViewGroup) null, false);
            }
        }
        RelativeLayout relativeLayout = (RelativeLayout) VHUtil.ViewHolder.get(view, R.id.rl_bg);
        TextView textView = (TextView) VHUtil.ViewHolder.get(view, R.id.subjectName);
        TextView textView2 = (TextView) VHUtil.ViewHolder.get(view, R.id.seletion);
        TextView textView3 = (TextView) VHUtil.ViewHolder.get(view, R.id.teacherName);
        TextView textView4 = (TextView) VHUtil.ViewHolder.get(view, R.id.time);
        LinearLayout linearLayout = (LinearLayout) VHUtil.ViewHolder.get(view, R.id.ll_two);
        TextView textView5 = (TextView) VHUtil.ViewHolder.get(view, R.id.otherSubjectName);
        TextView textView6 = (TextView) VHUtil.ViewHolder.get(view, R.id.otherClassesTeacher);
        textView.setText(getItem(i).subjectsName);
        textView4.setText(getItem(i).startTime + Constants.ACCEPT_TIME_SEPARATOR_SERVER + getItem(i).endTime);
        if (StringUtils.isEmpty(getItem(i).otherSubjectName)) {
            textView3.setText(getItem(i).teacherName);
            linearLayout.setVisibility(8);
            textView.setCompoundDrawables(null, null, null, null);
            textView5.setCompoundDrawables(null, null, null, null);
        } else {
            textView5.setText(getItem(i).otherSubjectName);
            textView3.setText(getItem(i).otherClassesTeacher);
            textView6.setText(getItem(i).teacherName);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.activity.getResources().getDrawable(R.drawable.icon_one_st), (Drawable) null);
            textView5.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.activity.getResources().getDrawable(R.drawable.icon_two_st), (Drawable) null);
        }
        int intWeek = TimeUtil.getIntWeek(System.currentTimeMillis());
        if (isBelong(getItem(i).startTime, getItem(i).endTime) && intWeek == this.week) {
            if (getWeek() < this.list.size()) {
                relativeLayout.setBackground(viewGroup.getContext().getResources().getDrawable(R.drawable.icon_kbl));
            }
            this.nextIndex = i + 1;
        } else {
            relativeLayout.setBackground(viewGroup.getContext().getResources().getDrawable(R.drawable.icon_kb_white));
        }
        textView2.setText(getItem(i).sectionName);
        return view;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:42:0x008a  */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 int, still in use, count: 1, list:
  (r0v0 int) from 0x0004: SWITCH (r0v0 int)
 case 49: goto B:39:0x0080
 case 50: goto B:36:0x0076
 case 51: goto B:33:0x006c
 case 52: goto B:30:0x0062
 case 53: goto B:27:0x0058
 case 54: goto B:24:0x004e
 case 55: goto B:21:0x0044
 case 56: goto B:18:0x003a
 case 57: goto B:15:0x002f
 default: goto B:4:0x0007 A[RegionRef:SW:3]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public String setLab2(String str) {
        byte b;
        switch (str.hashCode()) {
            case 49:
                if (!str.equals("1")) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            case 50:
                if (!str.equals("2")) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case 51:
                if (!str.equals("3")) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case 52:
                if (!str.equals("4")) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            case 53:
                if (!str.equals(ConversionUtil.conditionWithSeriesName)) {
                    b = -1;
                } else {
                    b = 4;
                }
                break;
            case 54:
                if (!str.equals(ConversionUtil.conditionWithCallNumber)) {
                    b = -1;
                } else {
                    b = 5;
                }
                break;
            case 55:
                if (!str.equals(ConversionUtil.conditionWithBookType)) {
                    b = -1;
                } else {
                    b = 6;
                }
                break;
            case 56:
                if (!str.equals(ConversionUtil.conditionWithPublishStartYear)) {
                    b = -1;
                } else {
                    b = 7;
                }
                break;
            case 57:
                if (!str.equals(ConversionUtil.conditionWithPublishEndYear)) {
                    b = -1;
                } else {
                    b = 8;
                }
                break;
            default:
                switch (str) {
                    case "10":
                        b = 9;
                        break;
                    case "11":
                        b = 10;
                        break;
                    case "12":
                        b = 11;
                        break;
                    default:
                        b = -1;
                        break;
                }
                break;
        }
        switch (b) {
            case 0:
                return "一";
            case 1:
                return "二";
            case 2:
                return "三";
            case 3:
                return "四";
            case 4:
                return "五";
            case 5:
                return "六";
            case 6:
                return "七";
            case 7:
                return "八";
            case 8:
                return "九";
            case 9:
                return "十";
            case 10:
                return "十一";
            case 11:
                return "十二";
            default:
                return "";
        }
    }

    public void notifyData(List<TableRsp> list) {
        this.list = list;
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x005e  */
    private int getWeek() {
        switch (TimeUtils.getChineseWeek(new Date())) {
            case "周一":
                return 1;
            case "周二":
                return 2;
            case "周三":
                return 3;
            case "周四":
                return 4;
            case "周五":
                return 5;
            case "周六":
                return 6;
            case "周日":
                return 7;
            default:
                return -1;
        }
    }
}
