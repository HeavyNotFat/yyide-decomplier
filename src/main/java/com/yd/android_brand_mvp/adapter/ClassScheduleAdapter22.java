package com.yd.android_brand_mvp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.StringUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.UserTableRsp;
import com.yd.android_brand_mvp.utils.TimeUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class ClassScheduleAdapter22 extends BaseAdapter {
    String checkId;
    private Context context;
    List<UserTableRsp.DataDTO.SubListDTO> list;
    int maxDay;
    int timetableType;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public ClassScheduleAdapter22() {
        this.list = new ArrayList();
        this.timetableType = 1;
        this.maxDay = 5;
        this.checkId = "";
    }

    public ClassScheduleAdapter22(Context context, int i) {
        this.list = new ArrayList();
        this.timetableType = 1;
        this.maxDay = 5;
        this.checkId = "";
        this.context = context;
        this.maxDay = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public UserTableRsp.DataDTO.SubListDTO getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = View.inflate(this.context, R.layout.item_class_schedule22, null);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        UserTableRsp.DataDTO.SubListDTO item = getItem(i);
        if (item != null) {
            if (item.otherSubjectName != null) {
                if (this.timetableType == 1) {
                    if (!StringUtils.isEmpty(item.subjectName) && item.subjectName.length() > 5) {
                        viewHolder.tvChannel.setTextSize(SizeUtils.px2sp(20.0f));
                        viewHolder.tvChannel.setSingleLine(false);
                        viewHolder.tvChannel.setLines(2);
                    }
                    viewHolder.ivImg.setImageResource(R.drawable.icon_one_st);
                    viewHolder.tvChannel.setText(StringUtils.isEmpty(item.subjectName) ? "" : item.subjectName);
                } else {
                    if (!StringUtils.isEmpty(item.otherSubjectName) && item.otherSubjectName.length() > 5) {
                        viewHolder.tvChannel.setTextSize(SizeUtils.px2sp(20.0f));
                        viewHolder.tvChannel.setSingleLine(false);
                        viewHolder.tvChannel.setLines(2);
                    }
                    viewHolder.ivImg.setImageResource(R.drawable.icon_two_st);
                    viewHolder.tvChannel.setText(StringUtils.isEmpty(item.otherSubjectName) ? "" : item.otherSubjectName);
                }
            } else {
                if (!StringUtils.isEmpty(item.subjectName) && item.subjectName.length() > 5) {
                    viewHolder.tvChannel.setTextSize(SizeUtils.px2sp(20.0f));
                    viewHolder.tvChannel.setSingleLine(false);
                    viewHolder.tvChannel.setLines(2);
                }
                viewHolder.tvChannel.setText(StringUtils.isEmpty(item.subjectName) ? "" : item.subjectName);
            }
        } else {
            viewHolder.tvChannel.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black21));
            viewHolder.tvChannel.setText("");
        }
        try {
            if (this.checkId.equals(item.id) && i % this.maxDay == getDay()) {
                viewHolder.llLab.setBackgroundResource(R.color.co_e9);
                viewHolder.tvChannel.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
            } else {
                viewHolder.llLab.setBackgroundResource(R.color.white);
                viewHolder.tvChannel.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black13));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return viewInflate;
    }

    private int getDay() {
        int intWeek = TimeUtil.getIntWeek(System.currentTimeMillis());
        if (intWeek == 1) {
            return 6;
        }
        return intWeek - 2;
    }

    public void notifyData(List<UserTableRsp.DataDTO.SubListDTO> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void notifyData(List<UserTableRsp.DataDTO.SubListDTO> list, String str) {
        this.list = list;
        this.checkId = str;
        notifyDataSetInvalidated();
    }

    class ViewHolder {
        protected ImageView ivImg;
        protected LinearLayout llLab;
        protected TextView tvChannel;

        public ViewHolder(View view) {
            this.tvChannel = (TextView) view.findViewById(R.id.tv_name);
            this.llLab = (LinearLayout) view.findViewById(R.id.ll_lab);
            this.ivImg = (ImageView) view.findViewById(R.id.iv_img);
        }
    }

    public void settimetableType(int i) {
        this.timetableType = i;
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
}
