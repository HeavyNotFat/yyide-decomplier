package com.yd.android_brand_mvp.landscape.attence;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.android.dx.io.Opcodes;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
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
import com.yd.android_brand_mvp.model.AttenceBean;
import com.yd.android_brand_mvp.model.AttenceListBean;
import com.yd.android_brand_mvp.utils.InitPieChart;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.weight.AttencesExcPopup;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class AttencesFragment4_2P extends BaseFragment {
    public static final int[] PIE_COLORS1 = {Color.rgb(82, 149, TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS), Color.rgb(246, 205, 87), Color.rgb(246, 108, 108), Color.rgb(143, 129, Opcodes.CONST_METHOD_HANDLE)};
    public static final int[] PIE_COLORS2 = {Color.rgb(86, 186, Opcodes.INVOKE_CUSTOM_RANGE), Color.rgb(TbsListener.ErrorCode.TPATCH_INSTALL_SUCCESS, 243, 255), Color.rgb(89, 224, 181), Color.rgb(Opcodes.INVOKE_CUSTOM, 192, 42)};
    AttenceListBean.DataDTO.CourseListDTO courseListDTOBean;
    AttenceBean.DataBean dataBean;
    AttenceListBean.DataDTO.EventListDTO eventListDTOBean;

    @BindView(R.id.expandableListView)
    ExpandableListView expandableListView;
    int layout;

    @BindView(R.id.piechart)
    PieChart piechart;
    int position;

    @BindView(R.id.rv)
    RecyclerView rv;

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
    public int data1 = 0;
    public int data2 = 0;
    public int data3 = 0;
    public int data4 = 0;
    Handler handler = new Handler(Looper.myLooper()) { // from class: com.yd.android_brand_mvp.landscape.attence.AttencesFragment4_2P.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AttencesExcPopup attencesExcPopup;
            if (message.what != 0) {
                return;
            }
            if (AttencesFragment4_2P.this.type == 0) {
                attencesExcPopup = new AttencesExcPopup(AttencesFragment4_2P.this.mActivity, AttenceUtil.getAttenceCourseBean(AttencesFragment4_2P.this.courseListDTOBean), AttencesFragment4_2P.this.courseListDTOBean.courseName);
            } else {
                attencesExcPopup = new AttencesExcPopup(AttencesFragment4_2P.this.mActivity, AttenceUtil.getAttenceCourseBean(AttencesFragment4_2P.this.eventListDTOBean), AttencesFragment4_2P.this.eventListDTOBean.eventName);
            }
            new XPopup.Builder(AttencesFragment4_2P.this.mActivity).asCustom(attencesExcPopup).show();
            AttencesFragment4_2P.this.nomalLoadingDiallog.dismiss();
        }
    };

    private void judgeLandscape() {
        this.layout = R.layout.fragment_attence_p4_2;
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
        this.position = getArguments().getInt(FirebaseAnalytics.Param.INDEX);
        int i = getArguments().getInt("type");
        this.type = i;
        if (i == 0) {
            this.courseListDTOBean = (AttenceListBean.DataDTO.CourseListDTO) new Gson().fromJson(getArguments().getString("bean"), AttenceListBean.DataDTO.CourseListDTO.class);
        } else {
            this.eventListDTOBean = (AttenceListBean.DataDTO.EventListDTO) new Gson().fromJson(getArguments().getString("bean"), AttenceListBean.DataDTO.EventListDTO.class);
        }
        initView();
        this.piechart.setOnTouchListener(new View.OnTouchListener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttencesFragment4_2P.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                if (!AttencesFragment4_2P.this.mActivity.isDestroyed()) {
                    AttencesFragment4_2P.this.nomalLoadingDiallog.show();
                }
                AttencesFragment4_2P.this.piechart.post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.AttencesFragment4_2P.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Message message = new Message();
                        if (AttencesFragment4_2P.this.type == 0) {
                            message.obj = AttenceUtil.getAttenceCourseBean(AttencesFragment4_2P.this.courseListDTOBean);
                        } else {
                            message.obj = AttenceUtil.getAttenceCourseBean(AttencesFragment4_2P.this.eventListDTOBean);
                        }
                        message.what = 0;
                        AttencesFragment4_2P.this.handler.sendMessage(message);
                    }
                });
                return false;
            }
        });
        this.piechart.setCenterTextColor(SkinCompatResources.getInstance().getColor(R.color.black22));
    }

    void initView() {
        List<AttencesExcBean> attenceCourseBean;
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
                setPieChartData(Float.parseFloat(this.courseListDTOBean.signInOutRate), this.type, "0");
            }
        } else {
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
                }
                setPieChartData(Float.parseFloat(this.eventListDTOBean.signInOutRate), this.type, this.eventListDTOBean.attendanceSignOut);
            }
        }
        if (this.type == 0) {
            attenceCourseBean = AttenceUtil.getAttenceCourseBean(this.courseListDTOBean);
        } else {
            attenceCourseBean = AttenceUtil.getAttenceCourseBean(this.eventListDTOBean);
        }
        AttencesEAdapter1 attencesEAdapter1 = new AttencesEAdapter1(R.layout.att_parent_item2);
        attencesEAdapter1.setTextSize(SizeUtils.px2sp(20.0f));
        this.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv.setAdapter(attencesEAdapter1);
        attencesEAdapter1.setList(attenceCourseBean);
    }

    private void setPieChartData(float f, int i, String str) {
        if (!ScreenUtils.isLandscape()) {
            this.piechart.setCenterTextSize(10.0f);
        }
        ArrayList arrayList = new ArrayList();
        if (i == 1 && !"1".equals(str)) {
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
        if (i == 1 && !"1".equals(str)) {
            pieDataSet.setColors(PIE_COLORS2);
        } else {
            pieDataSet.setColors(PIE_COLORS1);
        }
        pieDataSet.setDrawValues(false);
        this.piechart.setData(new PieData(pieDataSet));
        if (i == 1 && "1".equals(str)) {
            this.piechart.setCenterText(f + "%\n签退率");
        } else {
            this.piechart.setCenterText(f + "%\n考勤率");
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
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.AttencesFragment4_2P.3
            @Override // java.lang.Runnable
            public void run() {
                SPUtils.getInstance().put(SpData.AttenceEnable, "2");
            }
        }, 5000L);
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
