package com.yd.android_brand_mvp.landscape;

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
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.alibaba.fastjson.JSON;
import com.android.dx.io.Opcodes;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.lxj.xpopup.XPopup;
import com.tencent.smtt.sdk.TbsListener;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.model.AttenceBean;
import com.yd.android_brand_mvp.model.AttenceExcBean;
import com.yd.android_brand_mvp.user.AttenceActivity;
import com.yd.android_brand_mvp.utils.AttenceUtil;
import com.yd.android_brand_mvp.utils.InitPieChart;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.weight.AttenceExcPopup;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import master.flame.danmaku.danmaku.model.android.DanmakuFactory;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceFragment extends BaseFragment {
    public static final int[] PIE_COLORS1 = {Color.rgb(86, 186, Opcodes.INVOKE_CUSTOM_RANGE), Color.rgb(155, 157, 162), Color.rgb(255, 111, 119), Color.rgb(Opcodes.INVOKE_CUSTOM, 192, 42)};
    public static final int[] PIE_COLORS2 = {Color.rgb(86, 186, Opcodes.INVOKE_CUSTOM_RANGE), Color.rgb(TbsListener.ErrorCode.TPATCH_INSTALL_SUCCESS, 243, 255), Color.rgb(89, 224, 181), Color.rgb(Opcodes.INVOKE_CUSTOM, 192, 42)};
    AttenceBean.DataBean dataBean;
    int layout;
    List<AttenceExcBean> list;

    @BindView(R.id.ll_item)
    LinearLayout llItem;

    @BindView(R.id.piechart)
    PieChart piechart;
    int position;

    @BindView(R.id.post)
    TextView post;

    @BindView(R.id.rl_item)
    RelativeLayout rlItem;

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
    String title;

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_time)
    TextView tvTime;
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
    Handler handler = new Handler(Looper.myLooper()) { // from class: com.yd.android_brand_mvp.landscape.AttenceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0) {
                return;
            }
            AttenceFragment.this.list = (List) message.obj;
            new XPopup.Builder(AttenceFragment.this.mActivity).asCustom(new AttenceExcPopup(AttenceFragment.this.mActivity, AttenceFragment.this.list, AttenceFragment.this.title)).show();
            Log.e("TAG", "handleMessage: ");
            AttenceFragment.this.nomalLoadingDiallog.dismiss();
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
        this.post.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.AttenceFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AttenceFragment.this.goPermissionsActivity(AttenceActivity.class);
            }
        });
        this.position = getArguments().getInt(FirebaseAnalytics.Param.INDEX);
        this.dataBean = (AttenceBean.DataBean) new Gson().fromJson(getArguments().getString("bean"), AttenceBean.DataBean.class);
        initView();
        this.piechart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() { // from class: com.yd.android_brand_mvp.landscape.AttenceFragment.3
            @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
            public void onValueSelected(Entry entry, Highlight highlight) {
            }

            @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
            public void onNothingSelected() {
                if (AttenceFragment.this.dataBean == null) {
                }
            }
        });
        this.piechart.setOnTouchListener(new View.OnTouchListener() { // from class: com.yd.android_brand_mvp.landscape.AttenceFragment.4
            /* JADX WARN: Type inference failed for: r1v7, types: [com.yd.android_brand_mvp.landscape.AttenceFragment$4$1] */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0 || AttenceFragment.this.dataBean == null) {
                    return false;
                }
                if (!AttenceFragment.this.mActivity.isDestroyed()) {
                    AttenceFragment.this.nomalLoadingDiallog.show();
                }
                new Thread() { // from class: com.yd.android_brand_mvp.landscape.AttenceFragment.4.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        Message message = new Message();
                        message.obj = AttenceUtil.getAttenceExcBean(AttenceFragment.this.dataBean);
                        message.what = 0;
                        AttenceFragment.this.title = AttenceUtil.getTitle(AttenceFragment.this.dataBean);
                        AttenceFragment.this.handler.sendMessage(message);
                    }
                }.start();
                return false;
            }
        });
    }

    void initView() {
        AttenceBean.DataBean dataBean = this.dataBean;
        if (dataBean == null || dataBean.students == null) {
            return;
        }
        if ("Y".equals(this.dataBean.identityType)) {
            this.tvTime.setText(this.dataBean.students.subjectName);
            this.tvName.setText("第" + this.dataBean.students.section + "节 " + this.dataBean.students.name);
            if (this.dataBean.students.section == 0) {
                this.tvName.setText("早读 " + this.dataBean.students.name);
            } else {
                this.tvName.setText("第" + this.dataBean.students.section + "节 " + this.dataBean.students.name);
            }
        } else {
            this.tvTime.setText(this.dataBean.students.thingName + " " + this.dataBean.students.requiredTime);
            this.tvName.setText(this.dataBean.students.name);
        }
        if (!"0".equals(this.dataBean.students.attendanceType) && !"Y".equals(this.dataBean.identityType)) {
            this.data1 = this.dataBean.students.applyNum;
            this.data2 = this.dataBean.students.absence;
            this.data3 = this.dataBean.students.leaveEarly;
            this.data4 = this.dataBean.students.leave;
            this.t1.setText("正常");
            this.t2.setText("未签退");
            this.t3.setText("早退");
            this.t4.setText("请假");
            this.s1.setText(this.dataBean.students.applyNum + "人");
            this.s2.setText(this.dataBean.students.absence + "人");
            this.s3.setText(this.dataBean.students.leaveEarly + "人");
            this.s4.setText(this.dataBean.students.leave + "人");
            this.y3.setBackgroundResource(R.drawable.bg_att_shape5);
        } else {
            this.data1 = this.dataBean.students.applyNum;
            this.data2 = this.dataBean.students.absence;
            this.data3 = this.dataBean.students.late;
            this.data4 = this.dataBean.students.leave;
            this.t1.setText("正常");
            this.t2.setText("缺勤");
            this.t3.setText("迟到");
            this.t4.setText("请假");
            this.y3.setBackgroundResource(R.drawable.bg_att_shape2);
            this.y2.setBackgroundResource(R.drawable.bg_att_shape4);
            this.s1.setText(this.dataBean.students.applyNum + "人");
            this.s2.setText(this.dataBean.students.absence + "人");
            this.s3.setText(this.dataBean.students.late + "人");
            this.s4.setText(this.dataBean.students.leave + "人");
        }
        setPieChartData(Float.parseFloat(this.dataBean.students.rate), this.dataBean.students.attendanceType, this.dataBean.identityType);
    }

    private void setPieChartData(float f, String str, String str2) {
        if (!ScreenUtils.isLandscape()) {
            this.piechart.setCenterTextSize(10.0f);
        }
        Log.e("TAG", "data1: " + this.data1);
        Log.e("TAG", "data2: " + this.data2);
        Log.e("TAG", "data3: " + this.data3);
        Log.e("TAG", "data4: " + this.data4);
        ArrayList arrayList = new ArrayList();
        if (!"0".equals(str) && !"Y".equals(str2)) {
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
        if (!"0".equals(str) && !"Y".equals(str2)) {
            pieDataSet.setColors(PIE_COLORS2);
        } else {
            pieDataSet.setColors(PIE_COLORS1);
        }
        pieDataSet.setDrawValues(false);
        this.piechart.setData(new PieData(pieDataSet));
        if (!"0".equals(str) && !"Y".equals(str2)) {
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
        Log.e("AttenceFragment2_2_2", "onResume: " + SpData.isAttenceEnable());
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.AttenceFragment.5
            @Override // java.lang.Runnable
            public void run() {
                SPUtils.getInstance().put(SpData.AttenceEnable, "2");
                Log.e("TAG", "AttenceFragment2_2_2====》onResume: " + JSON.toJSONString(SpData.isAttenceEnable()));
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
