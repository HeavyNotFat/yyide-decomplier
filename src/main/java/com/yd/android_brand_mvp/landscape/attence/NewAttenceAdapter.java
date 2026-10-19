package com.yd.android_brand_mvp.landscape.attence;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.AttenceNewListBean;
import com.yd.android_brand_mvp.utils.TimeUtil;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class NewAttenceAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    List<AttenceNewListBean.DataDTO> courseListDTO;
    int layoutId;
    Onclick onclick;

    interface Onclick {
        void setOnAttClickListener(String str, String str2, String str3);
    }

    public NewAttenceAdapter(Context context, List<AttenceNewListBean.DataDTO> list) {
        this.courseListDTO = new ArrayList();
        this.layoutId = 0;
        this.context = context;
        this.courseListDTO = list;
    }

    public NewAttenceAdapter(Context context, List<AttenceNewListBean.DataDTO> list, int i) {
        this.courseListDTO = new ArrayList();
        this.layoutId = 0;
        this.context = context;
        this.courseListDTO = list;
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
        return this.courseListDTO.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final AttenceNewListBean.DataDTO dataDTO = this.courseListDTO.get(i);
        if (dataDTO == null) {
            return;
        }
        int i2 = dataDTO.beLateNum + dataDTO.normalNum + dataDTO.leaveEarlyNum;
        viewHolder.name.setText(dataDTO.name);
        viewHolder.time.setText(TimeUtil.getTargetTime(dataDTO.startDate.replace(ExifInterface.GPS_DIRECTION_TRUE, " "), "yyyy-MM-dd HH:mm:ss", "HH:mm"));
        viewHolder.rate.setText(i2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + dataDTO.total);
        viewHolder.leave.setText("请假 " + dataDTO.leaveNum);
        if (dataDTO.type == 1) {
            viewHolder.rl_click.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.attence.-$$Lambda$NewAttenceAdapter$Z0S6ETJuyoEdvHEzFvvqC2yLixI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0$NewAttenceAdapter(dataDTO, view);
                }
            });
        } else {
            viewHolder.rl_click.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.attence.-$$Lambda$NewAttenceAdapter$C14eI19pIQs5N_08syde8DGK0mE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$1$NewAttenceAdapter(dataDTO, view);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$NewAttenceAdapter(AttenceNewListBean.DataDTO dataDTO, View view) {
        this.onclick.setOnAttClickListener(dataDTO.attendanceTimeId, dataDTO.attendanceId, "1");
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$NewAttenceAdapter(AttenceNewListBean.DataDTO dataDTO, View view) {
        this.onclick.setOnAttClickListener(dataDTO.attendanceTimeId, dataDTO.attendanceId, "2");
    }

    public void addOnclick(Onclick onclick) {
        this.onclick = onclick;
    }

    public void addCourseListDTO(List<AttenceNewListBean.DataDTO> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.courseListDTO = list;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
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
