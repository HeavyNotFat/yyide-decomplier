package com.yd.android_brand_mvp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.StringUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.utils.TimeUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NewKBAdapter extends BaseAdapter {
    String checkId;
    private Context context;
    List<KBRsp2.DataDTO.TimetableListDTO> list;
    int maxDay;
    int nextIndex;
    int timetableType;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public NewKBAdapter() {
        this.list = new ArrayList();
        this.nextIndex = 0;
        this.timetableType = 1;
        this.maxDay = 5;
        this.checkId = "-1";
    }

    public NewKBAdapter(Context context, int i) {
        this.list = new ArrayList();
        this.nextIndex = 0;
        this.timetableType = 1;
        this.maxDay = 5;
        this.checkId = "-1";
        this.context = context;
        this.maxDay = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public KBRsp2.DataDTO.TimetableListDTO getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        String strStampToDate7;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.course_section, (ViewGroup) null, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);
        KBRsp2.DataDTO.TimetableListDTO item = getItem(i);
        viewHolder.tvChannel.setText(item.subjectName);
        viewHolder.tvTeacher.setText(item.teacherList.get(0).name);
        StringUtils.isEmpty(item.subjectName);
        if (item.week == TimeUtil.getIntWeekDay(System.currentTimeMillis())) {
            if (i == 0) {
                strStampToDate7 = TimeUtil.stampToDate7(TimeUtil.gettime55(item.startTime) + 5000);
            } else {
                strStampToDate7 = item.startTime;
            }
            Log.i("isBelong", "skxq: KBName:" + item.subjectName + " start: " + strStampToDate7 + " end:" + item.endTime);
            if (TimeUtil.isBelong(strStampToDate7, item.endTime)) {
                viewHolder.llLab.setBackgroundColor(Color.parseColor("#E9E6FD"));
                viewHolder.tvChannel.setTextColor(Color.parseColor("#6747D3"));
                this.nextIndex = i;
            } else {
                viewHolder.tvChannel.setTextColor(Color.parseColor("#303133"));
                viewHolder.llLab.setBackgroundColor(-1);
            }
        }
        return view;
    }

    class ViewHolder {
        protected LinearLayout llLab;
        protected TextView tvChannel;
        protected TextView tvTeacher;

        public ViewHolder(View view) {
            this.tvChannel = (TextView) view.findViewById(R.id.tv_name);
            this.tvTeacher = (TextView) view.findViewById(R.id.tv_time);
            this.llLab = (LinearLayout) view.findViewById(R.id.ll_lab);
        }
    }

    public void settimetableType(int i) {
        this.timetableType = i;
        notifyDataSetChanged();
    }

    public void setList(List<KBRsp2.DataDTO.TimetableListDTO> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
}
