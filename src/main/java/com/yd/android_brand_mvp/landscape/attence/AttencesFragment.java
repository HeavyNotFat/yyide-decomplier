package com.yd.android_brand_mvp.landscape.attence;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.alibaba.fastjson.JSON;
import com.android.dx.io.Opcodes;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.lxj.xpopup.XPopup;
import com.tencent.smtt.sdk.TbsListener;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.model.AttenceListBean;
import com.yd.android_brand_mvp.user.AttenceActivity;
import com.yd.android_brand_mvp.utils.InitPieChart;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.weight.AttencesExcPopup;
import java.text.DecimalFormat;
import java.util.ArrayList;
import master.flame.danmaku.danmaku.model.android.DanmakuFactory;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class AttencesFragment extends BaseFragment {
    public static final int[] PIE_COLORS1 = {Color.rgb(86, 186, Opcodes.INVOKE_CUSTOM_RANGE), Color.rgb(155, 157, 162), Color.rgb(255, 111, 119), Color.rgb(Opcodes.INVOKE_CUSTOM, 192, 42)};
    public static final int[] PIE_COLORS2 = {Color.rgb(86, 186, Opcodes.INVOKE_CUSTOM_RANGE), Color.rgb(TbsListener.ErrorCode.TPATCH_INSTALL_SUCCESS, 243, 255), Color.rgb(89, 224, 181), Color.rgb(Opcodes.INVOKE_CUSTOM, 192, 42)};
    AttenceListBean.DataDTO.CourseListDTO courseListDTOBean;
    AttenceListBean.DataDTO.EventListDTO eventListDTOBean;
    int layout;

    @BindView(R.id.ll_item)
    LinearLayout llItem;

    @BindView(R.id.piechart)
    PieChart piechart;
    int position;

    @BindView(R.id.post)
    TextView post;

    @BindView(R.id.s1)
    TextView s1;

    @BindView(R.id.s2)
    TextView s2;

    @BindView(R.id.s3)
    TextView s3;

    @BindView(R.id.s4)
    TextView s4;

    @BindView(R.id.tv1)
    TextView t1;

    @BindView(R.id.tv2)
    TextView t2;

    @BindView(R.id.tv3)
    TextView t3;

    @BindView(R.id.tv4)
    TextView t4;

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_time)
    TextView tvTime;
    int type;
    Unbinder unbinder;

    @BindView(R.id.y1)
    TextView y1;

    @BindView(R.id.y2)
    TextView y2;

    @BindView(R.id.y3)
    TextView y3;

    @BindView(R.id.y4)
    TextView y4;
    public int data1 = 0;
    public int data2 = 0;
    public int data3 = 0;
    public int data4 = 0;
    Handler handler = new Handler(Looper.myLooper()) { // from class: com.yd.android_brand_mvp.landscape.attence.AttencesFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AttencesExcPopup attencesExcPopup;
            if (message.what != 0) {
                return;
            }
            if (AttencesFragment.this.type == 0) {
                attencesExcPopup = new AttencesExcPopup(AttencesFragment.this.mActivity, AttenceUtil.getAttenceCourseBean(AttencesFragment.this.courseListDTOBean), AttencesFragment.this.courseListDTOBean.courseName);
            } else {
                attencesExcPopup = new AttencesExcPopup(AttencesFragment.this.mActivity, AttenceUtil.getAttenceCourseBean(AttencesFragment.this.eventListDTOBean), AttencesFragment.this.eventListDTOBean.eventName);
            }
            new XPopup.Builder(AttencesFragment.this.mActivity).asCustom(attencesExcPopup).show();
            AttencesFragment.this.nomalLoadingDiallog.dismiss();
        }
    };

    private void judgeLandscape() {
        if (ScreenUtils.isLandscape()) {
            this.layout = R.layout.fragment_attence_l2x2;
        } else {
            this.layout = R.layout.fragment_attence_2x2_p;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        judgeLandscape();
        View viewInflate = layoutInflater.inflate(this.layout, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        InitPieChart.InitPieChart(this.mActivity, this.piechart);
        this.post.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttencesFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AttencesFragment.this.goPermissionsActivity(AttenceActivity.class);
            }
        });
        this.position = getArguments().getInt(FirebaseAnalytics.Param.INDEX);
        int i = getArguments().getInt("type");
        this.type = i;
        if (i == 0) {
            this.courseListDTOBean = (AttenceListBean.DataDTO.CourseListDTO) new Gson().fromJson(getArguments().getString("bean"), AttenceListBean.DataDTO.CourseListDTO.class);
        } else {
            this.eventListDTOBean = (AttenceListBean.DataDTO.EventListDTO) new Gson().fromJson(getArguments().getString("bean"), AttenceListBean.DataDTO.EventListDTO.class);
        }
        initView();
        this.piechart.setOnTouchListener(new View.OnTouchListener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttencesFragment.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                if (!AttencesFragment.this.mActivity.isDestroyed()) {
                    AttencesFragment.this.nomalLoadingDiallog.show();
                }
                AttencesFragment.this.piechart.post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.AttencesFragment.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Message message = new Message();
                        if (AttencesFragment.this.type == 0) {
                            message.obj = AttenceUtil.getAttenceCourseBean(AttencesFragment.this.courseListDTOBean);
                        } else {
                            message.obj = AttenceUtil.getAttenceCourseBean(AttencesFragment.this.eventListDTOBean);
                        }
                        message.what = 0;
                        AttencesFragment.this.handler.sendMessage(message);
                    }
                });
                return false;
            }
        });
    }

    void initView() {
        if (this.type == 0) {
            AttenceListBean.DataDTO.CourseListDTO courseListDTO = this.courseListDTOBean;
            if (courseListDTO != null) {
                this.tvTime.setText(TimeUtil.getSplitTime(courseListDTO.courseStartTime));
                this.tvName.setText(this.courseListDTOBean.sectionInfo + this.courseListDTOBean.courseName);
                this.data1 = this.courseListDTOBean.normal;
                this.data2 = this.courseListDTOBean.absenteeism;
                this.data3 = this.courseListDTOBean.late;
                this.data4 = this.courseListDTOBean.leave;
                this.t1.setText("正常");
                this.t2.setText("缺勤");
                this.t3.setText("迟到");
                this.t4.setText("请假");
                this.s1.setText(this.data1 + "人");
                this.s2.setText(this.data2 + "人");
                this.s3.setText(this.data3 + "人");
                this.s4.setText(this.data4 + "人");
                this.y3.setBackgroundResource(R.drawable.bg_att_shape2);
                this.y2.setBackgroundResource(R.drawable.bg_att_shape4);
            }
            setPieChartData(Float.parseFloat(this.courseListDTOBean.signInOutRate), this.type, "0");
            return;
        }
        AttenceListBean.DataDTO.EventListDTO eventListDTO = this.eventListDTOBean;
        if (eventListDTO != null) {
            if ("1".equals(eventListDTO.attendanceSignOut)) {
                this.tvTime.setText(TimeUtil.getSplitTime(this.eventListDTOBean.requiredTime));
                this.tvName.setText(this.eventListDTOBean.eventName);
                this.data1 = this.eventListDTOBean.normal;
                this.data2 = this.eventListDTOBean.absenteeism;
                this.data3 = this.eventListDTOBean.early;
                this.data4 = this.eventListDTOBean.leave;
                this.t1.setText("正常");
                this.t2.setText("未签退");
                this.t3.setText("早退");
                this.t4.setText("请假");
                this.s1.setText(this.data1 + "人");
                this.s2.setText(this.data2 + "人");
                this.s3.setText(this.data3 + "人");
                this.s4.setText(this.data4 + "人");
                this.y3.setBackgroundResource(R.drawable.bg_att_shape5);
            } else {
                this.tvTime.setText(TimeUtil.getSplitTime(this.eventListDTOBean.requiredTime));
                this.tvName.setText(this.eventListDTOBean.eventName);
                this.data1 = this.eventListDTOBean.normal;
                this.data2 = this.eventListDTOBean.absenteeism;
                this.data3 = this.eventListDTOBean.late;
                this.data4 = this.eventListDTOBean.leave;
                this.t1.setText("正常");
                this.t2.setText("缺勤");
                this.t3.setText("迟到");
                this.t4.setText("请假");
                this.s1.setText(this.data1 + "人");
                this.s2.setText(this.data2 + "人");
                this.s3.setText(this.data3 + "人");
                this.s4.setText(this.data4 + "人");
                this.y3.setBackgroundResource(R.drawable.bg_att_shape2);
                this.y2.setBackgroundResource(R.drawable.bg_att_shape4);
            }
            setPieChartData(Float.parseFloat(this.eventListDTOBean.signInOutRate), this.type, this.eventListDTOBean.attendanceSignOut);
        }
    }

    private void setPieChartData(float f, int i, String str) {
        if (!ScreenUtils.isLandscape()) {
            this.piechart.setCenterTextSize(10.0f);
        }
        ArrayList arrayList = new ArrayList();
        if (i != 0 && "1".equals(str)) {
            arrayList.add(new PieEntry(this.data1, "正常"));
            arrayList.add(new PieEntry(this.data2, "未签退"));
            arrayList.add(new PieEntry(this.data3, "早退"));
            arrayList.add(new PieEntry(this.data4, "请假"));
        } else {
            arrayList.add(new PieEntry(this.data1, "正常"));
            arrayList.add(new PieEntry(this.data2, "缺勤"));
            arrayList.add(new PieEntry(this.data3, "迟到"));
            arrayList.add(new PieEntry(this.data4, "请假"));
        }
        PieDataSet pieDataSet = new PieDataSet(arrayList, "");
        pieDataSet.setSliceSpace(0.0f);
        if (i == 1 && "1".equals(str)) {
            pieDataSet.setColors(PIE_COLORS2);
        } else {
            pieDataSet.setColors(PIE_COLORS1);
        }
        pieDataSet.setDrawValues(false);
        this.piechart.setData(new PieData(pieDataSet));
        if (i == 0) {
            this.piechart.setCenterText(f + "%\n考勤率");
        } else if (i == 1) {
            if ("1".equals(str)) {
                this.piechart.setCenterText(f + "%\n签退率");
            } else {
                this.piechart.setCenterText(f + "%\n考勤率");
            }
        }
        this.piechart.invalidate();
    }

    public static String txfloat(float f, float f2) {
        return new DecimalFormat("0.00").format((f / f2) * 100.0f);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SPUtils.getInstance().put(SpData.AttenceEnable, "1");
        Log.e("AttendanceFragment2_2_2L", "onResume: " + SpData.isAttenceEnable());
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.AttencesFragment.4
            @Override // java.lang.Runnable
            public void run() {
                SPUtils.getInstance().put(SpData.AttenceEnable, "2");
                Log.e("TAG", "AttendanceFragment2_2_2L====》onResume: " + JSON.toJSONString(SpData.isAttenceEnable()));
            }
        }, DanmakuFactory.MIN_DANMAKU_DURATION);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Unbinder unbinder = this.unbinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
