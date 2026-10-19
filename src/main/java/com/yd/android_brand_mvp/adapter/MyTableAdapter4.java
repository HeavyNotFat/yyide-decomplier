package com.yd.android_brand_mvp.adapter;

import android.app.Activity;
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
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.yd.android_brand_mvp.utils.SortList;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.VHUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MyTableAdapter4 extends BaseAdapter {
    Activity activity;
    String tab;
    int week;
    int weekCount;
    public List<TableRsp> list = new ArrayList();
    boolean timetable = false;
    boolean isNight = false;
    int nextIndex = 0;
    boolean indexOpenbg = false;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public MyTableAdapter4(Activity activity, int i) {
        this.activity = activity;
        this.week = i;
    }

    public MyTableAdapter4(Activity activity, int i, String str) {
        this.activity = activity;
        this.week = i;
        this.tab = str;
    }

    public MyTableAdapter4(Activity activity) {
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
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_mytable_item_h1, (ViewGroup) null, false);
        }
        TextView textView = (TextView) VHUtil.ViewHolder.get(view, R.id.teacherName);
        TextView textView2 = (TextView) VHUtil.ViewHolder.get(view, R.id.seletion);
        RelativeLayout relativeLayout = (RelativeLayout) VHUtil.ViewHolder.get(view, R.id.rl_bg);
        TextView textView3 = (TextView) VHUtil.ViewHolder.get(view, R.id.subjectName);
        ImageView imageView = (ImageView) VHUtil.ViewHolder.get(view, R.id.iv_d);
        ((TextView) VHUtil.ViewHolder.get(view, R.id.time)).setText(getItem(i).startTime + Constants.ACCEPT_TIME_SEPARATOR_SERVER + getItem(i).endTime);
        textView2.setText(getItem(i).sectionName);
        if (getItem(i).otherSubjectName != null) {
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (this.weekCount % 2 == 0) {
                if (!StringUtils.isEmpty(getItem(i).otherSubjectName) && getItem(i).otherSubjectName.length() > 5) {
                    z = true;
                }
                setTextView(textView3, z);
                imageView.setImageResource(R.drawable.icon_two_st);
                textView3.setText(getItem(i).otherSubjectName);
                textView.setText(getItem(i).otherClassesTeacher);
            } else {
                if (!StringUtils.isEmpty(getItem(i).subjectsName) && getItem(i).subjectsName.length() > 5) {
                    z = true;
                }
                setTextView(textView3, z);
                imageView.setImageResource(R.drawable.icon_one_st);
                textView3.setText(getItem(i).subjectsName);
                textView.setText(getItem(i).teacherName);
            }
        } else {
            if (!StringUtils.isEmpty(getItem(i).subjectsName) && getItem(i).subjectsName.length() > 5) {
                z = true;
            }
            setTextView(textView3, z);
            textView3.setText(getItem(i).subjectsName);
            textView.setText(getItem(i).teacherName);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
        int intWeek = TimeUtil.getIntWeek(System.currentTimeMillis());
        if (i == 0) {
            strStampToDate7 = TimeUtil.stampToDate7(TimeUtil.gettime55(getItem(i).startTime) + 5000);
        } else {
            strStampToDate7 = getItem(i).startTime;
        }
        if (TimeUtil.isBelong(strStampToDate7, getItem(i).endTime) && intWeek == this.week && !this.isNight) {
            this.isNight = true;
            relativeLayout.setBackground(viewGroup.getContext().getResources().getDrawable(R.drawable.icon_kbl));
            this.nextIndex = i;
        } else {
            relativeLayout.setBackground(viewGroup.getContext().getResources().getDrawable(R.drawable.icon_kb_white));
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

    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v0 int, still in use, count: 2, list:
  (r1v0 int) from 0x000d: IF  (r1v0 int) != (1598 int)  -> B:6:0x000f A[HIDDEN]
  (r1v0 int) from 0x0012: SWITCH (r1v0 int)
 case 1567: goto B:36:0x0083
 case 1568: goto B:33:0x0077
 case 1569: goto B:30:0x006b
 case 1570: goto B:27:0x005f
 case 1571: goto B:24:0x0053
 case 1572: goto B:21:0x0047
 case 1573: goto B:18:0x003b
 case 1574: goto B:15:0x002f
 case 1575: goto B:12:0x0023
 case 1576: goto B:9:0x0017
 default: goto B:69:0x00f4 A[RegionRef:SW:7]
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
    public String getSection(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        byte b = -1;
        if (iHashCode != 1598) {
            switch (str) {
                case "1":
                    b = 0;
                    break;
                case "2":
                    b = 1;
                    break;
                case "3":
                    b = 2;
                    break;
                case "4":
                    b = 3;
                    break;
                case "5":
                    b = 4;
                    break;
                case "6":
                    b = 5;
                    break;
                case "7":
                    b = 6;
                    break;
                case "8":
                    b = 7;
                    break;
                case "9":
                    b = 8;
                    break;
                default:
                    switch (iHashCode) {
                        case 1567:
                            if (str.equals(ConversionUtil.conditionWithSort)) {
                                b = 9;
                            }
                            break;
                        case 1568:
                            if (str.equals(ConversionUtil.conditionWithYear)) {
                                b = 10;
                            }
                            break;
                        case 1569:
                            if (str.equals("12")) {
                                b = 11;
                            }
                            break;
                        case 1570:
                            if (str.equals("13")) {
                                b = 12;
                            }
                            break;
                        case 1571:
                            if (str.equals("14")) {
                                b = 13;
                            }
                            break;
                        case 1572:
                            if (str.equals("15")) {
                                b = 14;
                            }
                            break;
                        case 1573:
                            if (str.equals("16")) {
                                b = 15;
                            }
                            break;
                        case 1574:
                            if (str.equals("17")) {
                                b = 16;
                            }
                            break;
                        case 1575:
                            if (str.equals("18")) {
                                b = 17;
                            }
                            break;
                        case 1576:
                            if (str.equals("19")) {
                                b = 18;
                            }
                            break;
                    }
            }
        } else if (str.equals("20")) {
            b = 19;
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
            case 12:
                return "十三";
            case 13:
                return "十四";
            case 14:
                return "十五";
            case 15:
                return "十六";
            case 16:
                return "十七";
            case 17:
                return "十八";
            case 18:
                return "十九";
            case 19:
                return "二十";
            default:
                return "";
        }
    }

    public void notifyData(List<TableRsp> list) {
        this.list = list;
        this.isNight = false;
        this.list = SortList.listSorting2(list);
        notifyDataSetChanged();
    }

    public void notifyData(List<TableRsp> list, int i) {
        this.list = list;
        this.week = i;
        this.isNight = false;
        this.list = SortList.listSorting2(list);
        notifyDataSetInvalidated();
    }

    public int getNextIndex() {
        return this.nextIndex;
    }
}
