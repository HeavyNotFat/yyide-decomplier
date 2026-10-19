package com.yd.android_brand_mvp.adapter;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.AttenceBean;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceAdapter extends BaseQuickAdapter<AttenceBean.DataBean, BaseViewHolder> {
    public AttenceAdapter(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder baseViewHolder, AttenceBean.DataBean dataBean) {
        int i;
        int i2;
        baseViewHolder.setText(R.id.leave, "请假：" + dataBean.students.leave);
        TextView textView = (TextView) baseViewHolder.getView(R.id.time);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_teacher);
        if ("Y".equals(dataBean.identityType)) {
            textView.setText(dataBean.students.subjectName);
            textView2.setVisibility(dataBean.students.isExitTeacherInd ? 0 : 8);
            if (dataBean.students.section == 0) {
                baseViewHolder.setText(R.id.name, "早读 " + dataBean.students.name);
            } else {
                baseViewHolder.setText(R.id.name, "第" + dataBean.students.section + "节 " + dataBean.students.name);
            }
        } else {
            textView.setText(dataBean.students.thingName + " " + dataBean.students.requiredTime);
            baseViewHolder.setText(R.id.name, dataBean.students.name);
        }
        if (!"0".equals(dataBean.students.attendanceType) && !"Y".equals(dataBean.identityType)) {
            i = dataBean.students.applyNum;
            i2 = dataBean.students.leaveEarly;
        } else {
            i = dataBean.students.applyNum;
            i2 = dataBean.students.late;
        }
        baseViewHolder.setText(R.id.rate, (i + i2) + MqttTopic.TOPIC_LEVEL_SEPARATOR + dataBean.students.number);
    }
}
