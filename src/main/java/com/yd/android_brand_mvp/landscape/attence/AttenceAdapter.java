package com.yd.android_brand_mvp.landscape.attence;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.AttenceListBean;
import com.yd.android_brand_mvp.utils.TimeUtil;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    List<AttenceListBean.DataDTO.CourseListDTO> courseListDTO;
    List<AttenceListBean.DataDTO.EventListDTO> eventListDTO;
    int layoutId;
    Onclick onclick;

    interface Onclick {
        void setOnClick(int i, int i2);
    }

    public AttenceAdapter(Context context, List<AttenceListBean.DataDTO.CourseListDTO> list, List<AttenceListBean.DataDTO.EventListDTO> list2) {
        this.courseListDTO = new ArrayList();
        this.eventListDTO = new ArrayList();
        this.layoutId = 0;
        this.context = context;
        this.courseListDTO = list;
        this.eventListDTO = list2;
    }

    public AttenceAdapter(Context context, List<AttenceListBean.DataDTO.CourseListDTO> list, List<AttenceListBean.DataDTO.EventListDTO> list2, int i) {
        this.courseListDTO = new ArrayList();
        this.eventListDTO = new ArrayList();
        this.layoutId = 0;
        this.context = context;
        this.courseListDTO = list;
        this.eventListDTO = list2;
        this.layoutId = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.layoutId == 0) {
            this.layoutId = R.layout.attence_item_2_2;
        }
        return new ViewHolder(LayoutInflater.from(this.context).inflate(this.layoutId, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.courseListDTO.size() + this.eventListDTO.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        int i2;
        int i3;
        if (this.courseListDTO.size() > i) {
            int i4 = this.courseListDTO.get(i).late + this.courseListDTO.get(i).normal;
            viewHolder.time.setText(TimeUtil.getSplitTime(this.courseListDTO.get(i).courseStartTime));
            viewHolder.rate.setText(i4 + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.courseListDTO.get(i).totalNumber);
            viewHolder.name.setText(this.courseListDTO.get(i).sectionInfo + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.courseListDTO.get(i).courseName);
            viewHolder.leave.setText("请假 " + this.courseListDTO.get(i).leave);
            viewHolder.rl_click.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttenceAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AttenceAdapter.this.onclick.setOnClick(i, 0);
                }
            });
            if (this.courseListDTO.get(i).teacherInfo == null || this.courseListDTO.get(i).teacherInfo.size() <= 0) {
                return;
            }
            if ("0".equals(this.courseListDTO.get(i).teacherInfo.get(0).attendanceType) || "2".equals(this.courseListDTO.get(i).teacherInfo.get(0).attendanceType)) {
                viewHolder.tv_teacher.setVisibility(0);
                return;
            } else {
                viewHolder.tv_teacher.setVisibility(8);
                return;
            }
        }
        if (this.eventListDTO.size() > 0) {
            final int size = i - this.courseListDTO.size();
            if ("0".equals(this.eventListDTO.get(size).attendanceSignOut)) {
                i2 = this.eventListDTO.get(size).late;
                i3 = this.eventListDTO.get(size).normal;
            } else {
                i2 = this.eventListDTO.get(size).normal;
                i3 = this.eventListDTO.get(size).early;
            }
            int i5 = i2 + i3;
            viewHolder.time.setText(TimeUtil.getSplitTime(this.eventListDTO.get(size).requiredTime));
            viewHolder.rate.setText(i5 + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.eventListDTO.get(size).totalNumber);
            viewHolder.name.setText(this.eventListDTO.get(size).eventName);
            viewHolder.leave.setText("请假 " + this.eventListDTO.get(size).leave);
            viewHolder.rl_click.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttenceAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AttenceAdapter.this.onclick.setOnClick(size, 1);
                }
            });
            viewHolder.tv_teacher.setVisibility(8);
        }
    }

    public void addOnclick(Onclick onclick) {
        this.onclick = onclick;
    }

    public void addCourseListDTO(List<AttenceListBean.DataDTO.CourseListDTO> list, List<AttenceListBean.DataDTO.EventListDTO> list2) {
        this.courseListDTO = list;
        this.eventListDTO = list2;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView leave;
        TextView name;
        TextView rate;
        RelativeLayout rl_click;
        TextView time;
        TextView tv_teacher;

        public ViewHolder(View view) {
            super(view);
            this.leave = (TextView) view.findViewById(R.id.leave);
            this.time = (TextView) view.findViewById(R.id.time);
            this.tv_teacher = (TextView) view.findViewById(R.id.tv_teacher);
            this.name = (TextView) view.findViewById(R.id.name);
            this.rate = (TextView) view.findViewById(R.id.rate);
            this.rl_click = (RelativeLayout) view.findViewById(R.id.rl_click);
        }
    }
}
