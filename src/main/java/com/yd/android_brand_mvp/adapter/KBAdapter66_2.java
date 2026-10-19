package com.yd.android_brand_mvp.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.StringUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.utils.TeacherNameUtils;
import com.yd.android_brand_mvp.utils.TimeUtil;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class KBAdapter66_2 extends BaseAdapter {
    private Context context;
    int maxDay;
    List<KBRsp2.DataDTO.TimetableListDTO> list = new ArrayList();
    int nextIndex = 0;
    int timetableType = 1;
    String checkId = "-1";
    int week = TimeUtil.getIntWeek(System.currentTimeMillis());

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public KBAdapter66_2(Context context, int i) {
        this.maxDay = 5;
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
        View viewInflate;
        String strStampToDate7;
        if (ScreenUtils.isLandscape()) {
            viewInflate = View.inflate(this.context, R.layout.item_class_schedule66, null);
        } else {
            viewInflate = View.inflate(this.context, R.layout.item_class_schedule66p, null);
        }
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        KBRsp2.DataDTO.TimetableListDTO item = getItem(i);
        viewHolder.tvChannel.setText(item.subjectName);
        if (TextUtils.isEmpty(item.subjectName)) {
            viewHolder.tvChannel.setText(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        } else {
            viewHolder.tvChannel.setText(item.subjectName);
        }
        if (item.teacherList != null && item.teacherList.size() > 0) {
            viewHolder.tvSName.setText(TeacherNameUtils.INSTANCE.getTeacherNameByList(item.teacherList));
        } else {
            viewHolder.tvSName.setText("");
        }
        if ("2".equals(item.courseType)) {
            viewHolder.tipView.setVisibility(0);
            viewHolder.tipView.setBackgroundResource(R.drawable.bg_table_left_tip4);
            viewHolder.tipView.setText("调课");
        } else if ("3".equals(item.courseType)) {
            viewHolder.tipView.setVisibility(0);
            viewHolder.tipView.setBackgroundResource(R.drawable.bg_table_left_tip3);
            viewHolder.tipView.setText("代课");
        } else {
            viewHolder.tipView.setVisibility(8);
        }
        StringUtils.isEmpty(item.subjectName);
        int intWeekDay = TimeUtil.getIntWeekDay(System.currentTimeMillis());
        if (item.week != -1 && item.week == intWeekDay) {
            if (i == 0) {
                strStampToDate7 = TimeUtil.stampToDate7(TimeUtil.gettime55(item.startTime) + 5000);
            } else {
                strStampToDate7 = item.startTime;
            }
            if (TimeUtil.isBelong(strStampToDate7, item.endTime)) {
                viewHolder.llLab.setBackgroundResource(R.color.co_e9);
                viewHolder.tvChannel.setTextColor(SkinCompatResources.getInstance().getColor(R.color.table_two_text));
                viewHolder.tvSName.setTextColor(SkinCompatResources.getInstance().getColor(R.color.table_two_hint));
                this.nextIndex = i;
            } else {
                viewHolder.tvChannel.setTextColor(SkinCompatResources.getInstance().getColor(R.color.color_303133));
                viewHolder.tvChannel.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black9));
                viewHolder.tvSName.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
                viewHolder.llLab.setBackgroundColor(-1);
            }
        }
        return viewInflate;
    }

    static class ViewHolder {
        protected ImageView ivImg;
        protected LinearLayout llLab;
        protected TextView tipView;
        protected TextView tvChannel;
        protected TextView tvSName;

        public ViewHolder(View view) {
            this.tvChannel = (TextView) view.findViewById(R.id.tv_name);
            this.tvSName = (TextView) view.findViewById(R.id.tv_s_name);
            this.llLab = (LinearLayout) view.findViewById(R.id.ll_lab);
            this.ivImg = (ImageView) view.findViewById(R.id.iv_img);
            this.tipView = (TextView) view.findViewById(R.id.tv_table_tip);
        }
    }

    public void settimetableType(int i) {
        this.timetableType = i;
        notifyDataSetChanged();
    }

    public void notifyData(List<KBRsp2.DataDTO.TimetableListDTO> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
