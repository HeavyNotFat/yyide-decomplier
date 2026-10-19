package com.yd.android_brand_mvp.landscape.attence;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
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
import com.google.gson.Gson;
import com.lxj.xpopup.XPopup;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.AttanceTodatDetailsRsp;
import com.yd.android_brand_mvp.model.AttenceListBean;
import com.yd.android_brand_mvp.model.AttenceNewListBean;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.presenter.AttcencesPresenter;
import com.yd.android_brand_mvp.utils.InitPieChart;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.view.AttencesView;
import com.yd.android_brand_mvp.weight.AttencesExcPopup;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class NewAttencesFragment4_2P extends BaseMvpFragment<AttcencesPresenter> implements AttencesView {
    public static final int[] PIE_COLORS1 = {Color.rgb(0, 183, 129), Color.rgb(155, 157, 162), Color.rgb(255, 111, 119), Color.rgb(Opcodes.INVOKE_CUSTOM, 192, 42)};
    public static final int[] PIE_COLORS2 = {Color.rgb(93, 173, 255), Color.rgb(246, 189, 22), Color.rgb(246, 108, 108), Color.rgb(145, 147, 153), Color.rgb(30, 193, 195)};
    AttencesEAdapter1 adapter;
    public String attendanceId;
    public String attendanceTimeId;
    AttenceNewListBean.DataDTO bean;
    public int data1 = 0;
    public int data2 = 0;
    public int data3 = 0;
    public int data4 = 0;
    public int data5 = 0;

    @BindView(R.id.expandableListView)
    ExpandableListView expandableListView;
    int layout;
    private List<AttencesExcBean> newAttenceCourseBean;

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
    public String typeStr;
    Unbinder unbinder;

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getAttenceListSuccess(AttenceListBean attenceListBean) {
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getAttenceListSuccessFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getAttenceNewListSuccess(AttenceNewListBean attenceNewListBean) {
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getToadyAttenceListFails(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getToadyAttenceListSuccess(KBRsp2 kBRsp2) {
    }

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

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        InitPieChart.InitPieChart(this.mActivity, this.piechart);
        if (getArguments() != null) {
            this.attendanceTimeId = getArguments().getString("attendanceTimeId");
            this.attendanceId = getArguments().getString("attendanceId");
            this.typeStr = getArguments().getString("type");
            this.bean = (AttenceNewListBean.DataDTO) new Gson().fromJson(getArguments().getString("bean"), AttenceNewListBean.DataDTO.class);
        }
        initView();
        if (this.bean != null) {
            ((AttcencesPresenter) this.mvpPresenter).getAttenceTodayList(this.bean.attendanceTimeId, this.bean.attendanceId, String.valueOf(this.bean.type));
        }
        this.piechart.setOnTouchListener(new View.OnTouchListener() { // from class: com.yd.android_brand_mvp.landscape.attence.-$$Lambda$NewAttencesFragment4_2P$1EnB-Jtl--8GXURFrONh-Z-Gm0Y
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return this.f$0.lambda$onViewCreated$0$NewAttencesFragment4_2P(view2, motionEvent);
            }
        });
        this.piechart.setCenterTextColor(SkinCompatResources.getInstance().getColor(R.color.black22));
    }

    public /* synthetic */ boolean lambda$onViewCreated$0$NewAttencesFragment4_2P(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        if (!this.mActivity.isDestroyed()) {
            this.nomalLoadingDiallog.show();
        }
        this.piechart.post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.NewAttencesFragment4_2P.1
            @Override // java.lang.Runnable
            public void run() {
                if (NewAttencesFragment4_2P.this.bean != null) {
                    NewAttencesFragment4_2P.this.nomalLoadingDiallog.dismiss();
                    new XPopup.Builder(NewAttencesFragment4_2P.this.mActivity).asCustom(new AttencesExcPopup(NewAttencesFragment4_2P.this.mActivity, NewAttencesFragment4_2P.this.newAttenceCourseBean, "")).show();
                }
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public AttcencesPresenter createPresenter() {
        return new AttcencesPresenter(this);
    }

    void initView() {
        if ("1".equals(this.typeStr)) {
            AttenceNewListBean.DataDTO dataDTO = this.bean;
            if (dataDTO != null) {
                this.tvTime.setText(TimeUtil.getTargetTime(dataDTO.startDate.replace(ExifInterface.GPS_DIRECTION_TRUE, " "), "yyyy-MM-dd HH:mm:ss", "HH:mm"));
                this.tvName.setText(this.bean.name);
                this.data1 = this.bean.normalNum;
                this.data2 = this.bean.leaveNum;
                this.data3 = this.bean.beLateNum;
                this.data4 = this.bean.absenteeismNum;
                this.data5 = this.bean.leaveEarlyNum;
                this.t1.setText("实到");
                this.t2.setText("请假");
                this.t3.setText("迟到");
                this.t4.setText("未签到");
                this.s1.setText(this.data1 + "人");
                this.s2.setText(this.data2 + "人");
                this.s3.setText(this.data3 + "人");
                this.s4.setText(this.data4 + "人");
            }
            setPieChartData(this.bean.total == 0 ? 0.0f : (float) (((double) (((this.bean.normalNum + this.bean.leaveEarlyNum) + this.bean.beLateNum) + this.bean.leaveNum)) / (((double) this.bean.total) * 1.0d)), Integer.valueOf(this.bean.type).intValue(), "0");
        } else {
            this.tvTime.setText(TimeUtil.getTargetTime(this.bean.startDate.replace(ExifInterface.GPS_DIRECTION_TRUE, " "), "yyyy-MM-dd HH:mm:ss", "HH:mm"));
            this.tvName.setText(this.bean.name);
            this.data1 = this.bean.normalNum;
            this.data2 = this.bean.leaveNum;
            this.data3 = this.bean.beLateNum;
            this.data4 = this.bean.absenteeismNum;
            this.data5 = this.bean.leaveEarlyNum;
            this.t1.setText("实到");
            this.t2.setText("请假");
            this.t3.setText("迟到");
            this.t4.setText("未签到");
            this.s1.setText(this.data1 + "人");
            this.s2.setText(this.data2 + "人");
            this.s3.setText(this.data3 + "人");
            this.s4.setText(this.data4 + "人");
        }
        setPieChartData(this.bean.total != 0 ? (float) (((double) (((this.bean.normalNum + this.bean.leaveEarlyNum) + this.bean.beLateNum) + this.bean.leaveNum)) / (((double) this.bean.total) * 1.0d)) : 0.0f, Integer.valueOf(this.bean.type).intValue(), "0");
        AttencesEAdapter1 attencesEAdapter1 = new AttencesEAdapter1(R.layout.att_parent_item2);
        this.adapter = attencesEAdapter1;
        attencesEAdapter1.setTextSize(SizeUtils.px2sp(20.0f));
        this.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv.setAdapter(this.adapter);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.ATTENCE_MODULE) {
            ((AttcencesPresenter) this.mvpPresenter).getAttencelist("");
        }
    }

    private void setPieChartData(float f, int i, String str) {
        if (!ScreenUtils.isLandscape()) {
            this.piechart.setCenterTextSize(10.0f);
        }
        String str2 = new DecimalFormat("0.00").format(f * 100.0f);
        ArrayList arrayList = new ArrayList();
        if (i == 1) {
            arrayList.add(new PieEntry(this.data1, "实到"));
            arrayList.add(new PieEntry(this.data2, "请假"));
            arrayList.add(new PieEntry(this.data3, "迟到"));
            arrayList.add(new PieEntry(this.data4, "未签到"));
            arrayList.add(new PieEntry(this.data5, "早退"));
        } else {
            arrayList.add(new PieEntry(this.data1, "实到"));
            arrayList.add(new PieEntry(this.data2, "请假"));
            arrayList.add(new PieEntry(this.data3, "迟到"));
            arrayList.add(new PieEntry(this.data4, "未签到"));
            arrayList.add(new PieEntry(this.data5, "早退"));
        }
        PieDataSet pieDataSet = new PieDataSet(arrayList, "");
        pieDataSet.setSliceSpace(0.0f);
        pieDataSet.setColors(PIE_COLORS2);
        pieDataSet.setDrawValues(false);
        this.piechart.setData(new PieData(pieDataSet));
        if (i == 1) {
            this.piechart.setCenterText(str2 + "%\n考勤率");
        } else if (i == 2) {
            if ("1".equals(str)) {
                this.piechart.setCenterText(str2 + "%\n考勤率");
            } else {
                this.piechart.setCenterText(str2 + "%\n考勤率");
            }
        } else {
            this.piechart.setCenterText(str2 + "%\n考勤率");
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
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.NewAttencesFragment4_2P.2
            @Override // java.lang.Runnable
            public void run() {
                SPUtils.getInstance().put(SpData.AttenceEnable, "2");
            }
        }, 5000L);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Unbinder unbinder = this.unbinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getToadyListSuccess(AttanceTodatDetailsRsp attanceTodatDetailsRsp) {
        Log.e("getToadyListSuccess4_2P", GsonUtils.toJson(attanceTodatDetailsRsp));
        if (attanceTodatDetailsRsp.code == 0) {
            List<AttencesExcBean> newAttenceCourseBean = AttenceUtil.getNewAttenceCourseBean(attanceTodatDetailsRsp);
            this.newAttenceCourseBean = newAttenceCourseBean;
            this.adapter.setList(newAttenceCourseBean);
        } else {
            this.adapter.setList(null);
            ToastUtil.showView(getActivity(), attanceTodatDetailsRsp.message);
        }
    }
}
