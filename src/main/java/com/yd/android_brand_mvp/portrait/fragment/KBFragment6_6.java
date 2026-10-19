package com.yd.android_brand_mvp.portrait.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.orhanobut.hawk.Hawk;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.SiteKBActivity;
import com.yd.android_brand_mvp.adapter.KBAdapter66;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.KBRsp;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.presenter.KBPresenter;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.MyGridView;
import com.yd.android_brand_mvp.view.KBView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class KBFragment6_6 extends BaseMvpFragment<KBPresenter> implements KBView {
    KBAdapter66 adapter1;
    KBAdapter66 adapter2;
    KBAdapter66 adapter3;
    KBAdapter66 adapter4;
    KBAdapter66 adapter5;
    KBRsp.DataDTO dto;

    @BindView(R.id.gv_list1)
    MyGridView gvList1;

    @BindView(R.id.gv_list2)
    MyGridView gvList2;

    @BindView(R.id.gv_list3)
    MyGridView gvList3;

    @BindView(R.id.gv_list4)
    MyGridView gvList4;

    @BindView(R.id.gv_list5)
    MyGridView gvList5;
    private MyHandler handler;
    int height1;
    int height2;
    int height3;
    int height4;
    int height5;
    public List<KBRsp.DataDTO.jc.JcDTO> jcList;
    int list1Size;
    int list2Size;
    int list3Size;
    int list4Size;
    int list5Size;

    @BindView(R.id.ll_afternoon)
    LinearLayout llAfternoon;

    @BindView(R.id.ll_content)
    LinearLayout llContent;

    @BindView(R.id.ll_forenoon)
    LinearLayout llForenoon;

    @BindView(R.id.ll_lab)
    LinearLayout llLab;

    @BindView(R.id.ll_morning_reading)
    LinearLayout llMorningReading;

    @BindView(R.id.ll_night)
    LinearLayout llNight;

    @BindView(R.id.ll_night_zx)
    LinearLayout llNightZx;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.rb_month)
    Button rbMonth;

    @BindView(R.id.rb_trimester)
    Button rbTrimester;

    @BindView(R.id.rb_week)
    Button rbWeek;

    @BindView(R.id.rl_check)
    RelativeLayout rlCheck;
    public List<KBRsp.DataDTO.ListDTO> subList;
    public List<KBRsp.DataDTO.ListDTO> subList1;
    public List<KBRsp.DataDTO.ListDTO> subList2;
    public List<KBRsp.DataDTO.ListDTO> subList3;
    public List<KBRsp.DataDTO.ListDTO> subList4;
    public List<KBRsp.DataDTO.ListDTO> subList5;

    @BindView(R.id.title)
    TextView tvTitle;

    @BindView(R.id.tv_week)
    TextView tvWeek;

    @BindView(R.id.v1)
    View v1;

    @BindView(R.id.v2)
    View v2;

    @BindView(R.id.weekRecyclerView)
    RecyclerView weekRecyclerView;
    KBRsp.DataDTO.ZxbDTO zxbDTO;
    int maxDay = 7;
    int jcIndex = 0;
    int height = 75;
    int weekCount = -1;
    int statusCount = -1;
    Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.portrait.fragment.KBFragment6_6.1
        @Override // java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 200;
            KBFragment6_6.this.handler.sendMessage(message);
        }
    };
    private BaseQuickAdapter<KBRsp.DataDTO.WeekTimeBean.WeekBean, BaseViewHolder> weekAdapter = new BaseQuickAdapter<KBRsp.DataDTO.WeekTimeBean.WeekBean, BaseViewHolder>(R.layout.item_kb_week) { // from class: com.yd.android_brand_mvp.portrait.fragment.KBFragment6_6.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(BaseViewHolder baseViewHolder, KBRsp.DataDTO.WeekTimeBean.WeekBean weekBean) {
            baseViewHolder.setText(R.id.tvWeek, weekBean.week).setText(R.id.tvWeekTime, weekBean.time);
        }
    };

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getCDKBData(KBRsp2 kBRsp2) {
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getClassKBData(KBRsp2 kBRsp2) {
    }

    private static class MyHandler extends Handler {
        private WeakReference<KBFragment6_6> mWeakReference;

        public MyHandler(KBFragment6_6 kBFragment6_6) {
            this.mWeakReference = new WeakReference<>(kBFragment6_6);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 200) {
                this.mWeakReference.get().handler.postDelayed(this.mWeakReference.get().runnable, 60000L);
                KBRsp kBRsp = (KBRsp) Hawk.get(BaseHawk.CDKB);
                if (kBRsp != null) {
                    this.mWeakReference.get().setData(kBRsp);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_k_b6_6, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
        initData();
        this.handler = new MyHandler(this);
        KBRsp kBRsp = (KBRsp) Hawk.get(BaseHawk.CDKB);
        if (kBRsp != null) {
            setData(kBRsp);
        }
    }

    @OnClick({R.id.title})
    public void onViewClicked(View view) {
        if (view.getId() == R.id.title) {
            goPermissionsActivity(SiteKBActivity.class);
        }
    }

    private void setWeekData(KBRsp.DataDTO dataDTO) {
        this.weekRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 7));
        this.weekRecyclerView.setAdapter(this.weekAdapter);
        if (dataDTO == null || dataDTO.weekmap == null) {
            return;
        }
        this.weekAdapter.setList(dataDTO.weekmap.getList());
    }

    void setData(KBRsp kBRsp) {
        KBRsp.DataDTO dataDTO = kBRsp.data;
        this.dto = dataDTO;
        if (dataDTO != null) {
            if (dataDTO.zxb != null) {
                this.statusCount = this.dto.zxb.xnzzc;
            }
            this.weekCount = this.dto.bzzc;
            this.tvWeek.setText("当前周次：第" + this.weekCount + "周");
            this.rlCheck.setVisibility(0);
            this.mu.setViewState(0);
        }
        setWeekData(this.dto);
        this.tvTitle.setText(this.dto.cdmc);
        this.subList = new ArrayList();
        this.subList1 = new ArrayList();
        this.subList2 = new ArrayList();
        this.subList3 = new ArrayList();
        this.subList4 = new ArrayList();
        this.subList5 = new ArrayList();
        this.jcList = new ArrayList();
        if (this.dto.jcbMap.zzx != null) {
            this.jcList.addAll(this.dto.jcbMap.zzx);
        }
        if (this.dto.jcbMap.sw != null) {
            this.jcList.addAll(this.dto.jcbMap.sw);
        }
        if (this.dto.jcbMap.xw != null) {
            this.jcList.addAll(this.dto.jcbMap.xw);
        }
        if (this.dto.jcbMap.ws != null) {
            this.jcList.addAll(this.dto.jcbMap.ws);
        }
        if (this.dto.jcbMap.wzx != null) {
            this.jcList.addAll(this.dto.jcbMap.wzx);
        }
        this.subList = this.dto.list;
        this.zxbDTO = this.dto.zxb;
        this.subList1 = new ArrayList();
        KBRsp.DataDTO.ZxbDTO zxbDTO = this.zxbDTO;
        if (zxbDTO != null) {
            int i = TextUtils.isEmpty(zxbDTO.zzxkjs) ? 0 : Integer.parseInt(this.zxbDTO.zzxkjs) * 7;
            int i2 = TextUtils.isEmpty(this.zxbDTO.swkjs) ? 0 : Integer.parseInt(this.zxbDTO.swkjs) * 7;
            int i3 = TextUtils.isEmpty(this.zxbDTO.xwkjs) ? 0 : Integer.parseInt(this.zxbDTO.xwkjs) * 7;
            int i4 = TextUtils.isEmpty(this.zxbDTO.wskjs) ? 0 : Integer.parseInt(this.zxbDTO.wskjs) * 7;
            int i5 = TextUtils.isEmpty(this.zxbDTO.wzxkjs) ? 0 : Integer.parseInt(this.zxbDTO.wzxkjs) * 7;
            for (int i6 = 0; i6 < i; i6++) {
                this.subList1.add(new KBRsp.DataDTO.ListDTO());
            }
            for (int i7 = 0; i7 < i2; i7++) {
                this.subList2.add(new KBRsp.DataDTO.ListDTO());
            }
            for (int i8 = 0; i8 < i3; i8++) {
                this.subList3.add(new KBRsp.DataDTO.ListDTO());
            }
            for (int i9 = 0; i9 < i4; i9++) {
                this.subList4.add(new KBRsp.DataDTO.ListDTO());
            }
            for (int i10 = 0; i10 < i5; i10++) {
                this.subList5.add(new KBRsp.DataDTO.ListDTO());
            }
        }
        if (this.subList != null) {
            for (int i11 = 0; i11 < this.subList.size(); i11++) {
                KBRsp.DataDTO.ListDTO listDTO = this.subList.get(i11);
                int i12 = ((this.subList.get(i11).jcdm - 1) * 7) + (this.subList.get(i11).skxq - 1);
                if ("zzx".equals(this.subList.get(i11).jcsdbs)) {
                    this.subList1.get(i12).kcmc = listDTO.kcmc;
                    this.subList1.get(i12).jzgmc = listDTO.jzgmc;
                    this.subList1.get(i12).kssj = listDTO.kssj;
                    this.subList1.get(i12).jssj = listDTO.jssj;
                    this.subList1.get(i12).skxq = listDTO.skxq;
                    this.subList1.get(i12).xh = listDTO.xh;
                }
                if ("sw".equals(this.subList.get(i11).jcsdbs)) {
                    this.subList2.get(i12).kcmc = listDTO.kcmc;
                    this.subList2.get(i12).jzgmc = listDTO.jzgmc;
                    this.subList2.get(i12).kssj = listDTO.kssj;
                    this.subList2.get(i12).jssj = listDTO.jssj;
                    this.subList2.get(i12).skxq = listDTO.skxq;
                    this.subList2.get(i12).xh = listDTO.xh;
                }
                if ("xw".equals(this.subList.get(i11).jcsdbs)) {
                    this.subList3.get(i12).kcmc = listDTO.kcmc;
                    this.subList3.get(i12).jzgmc = listDTO.jzgmc;
                    this.subList3.get(i12).kssj = listDTO.kssj;
                    this.subList3.get(i12).jssj = listDTO.jssj;
                    this.subList3.get(i12).skxq = listDTO.skxq;
                    this.subList3.get(i12).xh = listDTO.xh;
                }
                if ("ws".equals(this.subList.get(i11).jcsdbs)) {
                    this.subList4.get(i12).kcmc = listDTO.kcmc;
                    this.subList4.get(i12).jzgmc = listDTO.jzgmc;
                    this.subList4.get(i12).kssj = listDTO.kssj;
                    this.subList4.get(i12).jssj = listDTO.jssj;
                    this.subList4.get(i12).skxq = listDTO.skxq;
                    this.subList4.get(i12).xh = listDTO.xh;
                }
                if ("wzx".equals(this.subList.get(i11).jcsdbs)) {
                    this.subList5.get(i12).kcmc = listDTO.kcmc;
                    this.subList5.get(i12).jzgmc = listDTO.jzgmc;
                    this.subList5.get(i12).kssj = listDTO.kssj;
                    this.subList5.get(i12).jssj = listDTO.jssj;
                    this.subList5.get(i12).skxq = listDTO.skxq;
                    this.subList5.get(i12).xh = listDTO.xh;
                }
            }
        }
        setAdapter();
        setParams();
    }

    private void setAdapter() {
        this.adapter1 = new KBAdapter66(this.mActivity, this.maxDay);
        this.adapter2 = new KBAdapter66(this.mActivity, this.maxDay);
        this.adapter3 = new KBAdapter66(this.mActivity, this.maxDay);
        this.adapter4 = new KBAdapter66(this.mActivity, this.maxDay);
        this.adapter5 = new KBAdapter66(this.mActivity, this.maxDay);
        this.gvList1.setNumColumns(this.maxDay);
        this.gvList2.setNumColumns(this.maxDay);
        this.gvList3.setNumColumns(this.maxDay);
        this.gvList4.setNumColumns(this.maxDay);
        this.gvList5.setNumColumns(this.maxDay);
        this.gvList1.setAdapter((ListAdapter) this.adapter1);
        this.gvList2.setAdapter((ListAdapter) this.adapter2);
        this.gvList3.setAdapter((ListAdapter) this.adapter3);
        this.gvList4.setAdapter((ListAdapter) this.adapter4);
        this.gvList5.setAdapter((ListAdapter) this.adapter5);
        this.adapter1.notifyData(this.subList1);
        this.adapter2.notifyData(this.subList2);
        this.adapter3.notifyData(this.subList3);
        this.adapter4.notifyData(this.subList4);
        this.adapter5.notifyData(this.subList5);
    }

    private void setParams() {
        this.llLab.removeAllViews();
        if (this.zxbDTO != null) {
            this.llContent.setVisibility(0);
            this.list1Size = Integer.parseInt(this.zxbDTO.zzxkjs);
            this.list2Size = Integer.parseInt(this.zxbDTO.swkjs);
            this.list3Size = Integer.parseInt(this.zxbDTO.xwkjs);
            this.list4Size = Integer.parseInt(this.zxbDTO.wskjs);
            this.list5Size = Integer.parseInt(this.zxbDTO.wzxkjs);
            setLab();
            int i = this.list1Size;
            this.llMorningReading.setLayoutParams(new LinearLayout.LayoutParams(-1, SizeUtils.dp2px((((this.height * i) + i) + i) - 1)));
            int i2 = this.list2Size;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px((((this.height * i2) + i2) + i2) - 1));
            layoutParams.setMargins(0, SizeUtils.dp2px(10.0f), 0, 0);
            this.llForenoon.setLayoutParams(layoutParams);
            int i3 = this.list3Size;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px((((this.height * i3) + i3) + i3) - 1));
            layoutParams2.setMargins(0, SizeUtils.dp2px(10.0f), 0, 0);
            this.llAfternoon.setLayoutParams(layoutParams2);
            int i4 = this.list4Size;
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px((((this.height * i4) + i4) + i4) - 1));
            layoutParams3.setMargins(0, SizeUtils.dp2px(10.0f), 0, 0);
            this.llNight.setLayoutParams(layoutParams3);
            int i5 = this.list5Size;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px((((this.height * i5) + i5) + i5) - 1));
            layoutParams4.setMargins(0, SizeUtils.dp2px(10.0f), 0, 0);
            this.llNightZx.setLayoutParams(layoutParams4);
        }
    }

    private View getLab(String str, String str2, LinearLayout.LayoutParams layoutParams) {
        View viewInflate = LayoutInflater.from(this.mActivity).inflate(R.layout.item_class_schedule_lab, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_name);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_s_name);
        textView.setText(str);
        textView2.setText(str2);
        viewInflate.setLayoutParams(layoutParams);
        return viewInflate;
    }

    private void setLab() {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout.LayoutParams layoutParams3;
        LinearLayout.LayoutParams layoutParams4;
        LinearLayout.LayoutParams layoutParams5;
        this.jcIndex = 0;
        for (int i = 0; i < this.list1Size; i++) {
            if (i > 0) {
                this.height1++;
                layoutParams5 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height + 1));
            } else {
                layoutParams5 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height));
            }
            this.llLab.addView(getLab(this.jcList.get(this.jcIndex).jcmc, this.jcList.get(this.jcIndex).kssj + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.jcList.get(this.jcIndex).jssj, layoutParams5));
            this.jcIndex = this.jcIndex + 1;
            this.llLab.addView(addLine());
        }
        for (int i2 = 0; i2 < this.list2Size; i2++) {
            if (i2 > 0) {
                this.height2++;
                layoutParams4 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height + 1));
            } else {
                layoutParams4 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height));
            }
            layoutParams4.setMargins(0, 10, 0, 0);
            if (i2 == 0) {
                layoutParams4.setMargins(0, 10, 0, 0);
            } else {
                layoutParams4.setMargins(0, 0, 0, 0);
            }
            this.llLab.addView(getLab(this.jcList.get(this.jcIndex).jcmc, this.jcList.get(this.jcIndex).kssj + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.jcList.get(this.jcIndex).jssj, layoutParams4));
            this.jcIndex = this.jcIndex + 1;
            this.llLab.addView(addLine());
        }
        for (int i3 = 0; i3 < this.list3Size; i3++) {
            if (i3 > 0) {
                this.height3++;
                layoutParams3 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height + 1));
            } else {
                layoutParams3 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height));
            }
            if (i3 == 0) {
                layoutParams3.setMargins(0, SizeUtils.dp2px(getViewHeight(3)), 0, 0);
            } else {
                layoutParams3.setMargins(0, 0, 0, 0);
            }
            this.llLab.addView(getLab(this.jcList.get(this.jcIndex).jcmc, this.jcList.get(this.jcIndex).kssj + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.jcList.get(this.jcIndex).jssj, layoutParams3));
            this.jcIndex = this.jcIndex + 1;
            this.llLab.addView(addLine());
        }
        for (int i4 = 0; i4 < this.list4Size; i4++) {
            if (i4 > 0) {
                this.height4++;
                layoutParams2 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height + 1));
            } else {
                layoutParams2 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height));
            }
            if (i4 == 0) {
                layoutParams2.setMargins(0, SizeUtils.dp2px(getViewHeight(4)), 0, 0);
            } else {
                layoutParams2.setMargins(0, 0, 0, 0);
            }
            this.llLab.addView(getLab(this.jcList.get(this.jcIndex).jcmc, this.jcList.get(this.jcIndex).kssj + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.jcList.get(this.jcIndex).jssj, layoutParams2));
            this.jcIndex = this.jcIndex + 1;
            this.llLab.addView(addLine());
        }
        for (int i5 = 0; i5 < this.list5Size; i5++) {
            if (i5 > 0) {
                this.height5++;
                layoutParams = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height + 1));
            } else {
                layoutParams = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height));
            }
            if (i5 == 0) {
                layoutParams.setMargins(0, SizeUtils.dp2px(getViewHeight(4)), 0, 0);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.llLab.addView(getLab(this.jcList.get(this.jcIndex).jcmc, this.jcList.get(this.jcIndex).kssj + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.jcList.get(this.jcIndex).jssj, layoutParams));
            this.jcIndex = this.jcIndex + 1;
            this.llLab.addView(addLine());
        }
    }

    public int getViewHeight(int i) {
        if (i > 3) {
            return (this.subList3.size() == 0 && this.subList2.size() == 0 && this.subList1.size() == 0) ? 0 : 10;
        }
        if (i > 2) {
            return (this.subList2.size() == 0 && this.subList1.size() == 0) ? 0 : 10;
        }
        return (i <= 1 || this.subList1.size() == 0) ? 0 : 10;
    }

    View addLine() {
        return this.mActivity.getLayoutInflater().inflate(R.layout.layout_line, (ViewGroup) null);
    }

    void initView() {
        this.rlCheck.setVisibility(8);
        this.mu.setViewState(3);
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.portrait.fragment.KBFragment6_6.3
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((KBPresenter) KBFragment6_6.this.mvpPresenter).getKB(SpData.getClassesId() + "", KBFragment6_6.this.weekCount);
                if (KBFragment6_6.this.mActivity.isDestroyed()) {
                    return;
                }
                KBFragment6_6.this.bookLoadingDiallog.show();
            }
        });
    }

    @OnClick({R.id.rb_week, R.id.rb_month, R.id.rb_trimester})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.rb_month) {
            showProgressDialog();
            ((KBPresenter) this.mvpPresenter).getKB(SpData.getClassesId() + "", -1);
            this.rbMonth.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
            this.rbTrimester.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
            this.rbWeek.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
            return;
        }
        if (id != R.id.rb_trimester) {
            if (id == R.id.rb_week && this.weekCount > 1) {
                showProgressDialog();
                KBPresenter kBPresenter = (KBPresenter) this.mvpPresenter;
                String str = SpData.getClassesId() + "";
                int i = this.weekCount - 1;
                this.weekCount = i;
                kBPresenter.getKB(str, i);
                this.rbMonth.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
                this.rbTrimester.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
                this.rbWeek.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
                return;
            }
            return;
        }
        if (this.weekCount < this.statusCount) {
            showProgressDialog();
            KBPresenter kBPresenter2 = (KBPresenter) this.mvpPresenter;
            String str2 = SpData.getClassesId() + "";
            int i2 = this.weekCount + 1;
            this.weekCount = i2;
            kBPresenter2.getKB(str2, i2);
            this.rbMonth.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
            this.rbTrimester.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
            this.rbWeek.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.Table || i == MinaConstants.SEMESTER) {
            ((KBPresenter) this.mvpPresenter).getKB(SpData.getClassesId() + "", -1);
        }
    }

    void initData() {
        ((KBPresenter) this.mvpPresenter).getKB(SpData.getClassesId() + "", -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public KBPresenter createPresenter() {
        return new KBPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getKBData(KBRsp kBRsp) {
        dismissProgressDialog();
        if (kBRsp != null && kBRsp.code == 200) {
            if (kBRsp.data != null) {
                setData(kBRsp);
                Hawk.put(BaseHawk.CDKB, kBRsp);
                this.handler.postDelayed(this.runnable, 60000L);
            } else {
                Hawk.delete(BaseHawk.CDKB);
                this.mu.setViewState(2);
            }
        }
        if (kBRsp == null || kBRsp.data == null) {
            this.mu.setViewState(2);
        }
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void KBDataFail(String str) {
        dismissProgressDialog();
        KBRsp kBRsp = (KBRsp) Hawk.get(BaseHawk.CDKB);
        if (kBRsp != null) {
            setData(kBRsp);
        } else {
            this.mu.setViewState(2);
        }
    }
}
