package com.yd.android_brand_mvp.portrait.fragment;

import android.os.Bundle;
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
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.orhanobut.hawk.Hawk;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.SiteKBActivity;
import com.yd.android_brand_mvp.adapter.KBAdapter66_2;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.KBRsp;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.presenter.KBPresenter;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.MyGridView;
import com.yd.android_brand_mvp.view.KBView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class KBFragment extends BaseMvpFragment<KBPresenter> implements KBView {
    KBAdapter66_2 adapter1;
    KBAdapter66_2 adapter2;
    KBAdapter66_2 adapter3;
    KBAdapter66_2 adapter4;
    KBAdapter66_2 adapter5;
    KBRsp2.DataDTO dto;

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
    int height1;
    int height2;
    int height3;
    int height4;
    int height5;
    public List<KBRsp2.DataDTO.SectionListDTO.ZX> jcList;
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
    SiteKBActivity siteKBActivity;
    public List<KBRsp2.DataDTO.TimetableListDTO> subList;
    public List<KBRsp2.DataDTO.TimetableListDTO> subList1;
    public List<KBRsp2.DataDTO.TimetableListDTO> subList2;
    public List<KBRsp2.DataDTO.TimetableListDTO> subList3;
    public List<KBRsp2.DataDTO.TimetableListDTO> subList4;
    public List<KBRsp2.DataDTO.TimetableListDTO> subList5;

    @BindView(R.id.v1)
    View v1;

    @BindView(R.id.v2)
    View v2;

    @BindView(R.id.v3)
    View v3;

    @BindView(R.id.weekRecyclerView)
    RecyclerView weekRecyclerView;
    KBRsp2.DataDTO.SectionListDTO zxbDTO;
    int maxDay = 7;
    int jcIndex = 0;
    int height = 75;
    int weekCount = -1;
    int statusCount = -1;
    private BaseQuickAdapter<KBRsp.DataDTO.WeekTimeBean.WeekBean, BaseViewHolder> weekAdapter = new BaseQuickAdapter<KBRsp.DataDTO.WeekTimeBean.WeekBean, BaseViewHolder>(R.layout.item_kb_week) { // from class: com.yd.android_brand_mvp.portrait.fragment.KBFragment.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(BaseViewHolder baseViewHolder, KBRsp.DataDTO.WeekTimeBean.WeekBean weekBean) {
            baseViewHolder.setText(R.id.tvWeek, weekBean.week).setText(R.id.tvWeekTime, weekBean.time);
        }
    };

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getClassKBData(KBRsp2 kBRsp2) {
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getKBData(KBRsp kBRsp) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_new_k_b, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (ScreenUtils.isLandscape()) {
            this.height = 75;
        } else {
            this.height = 149;
        }
        this.siteKBActivity = (SiteKBActivity) this.mActivity;
        initView();
        initData();
    }

    private void setWeekData(KBRsp2.DataDTO dataDTO) {
        this.weekRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 7));
        this.weekRecyclerView.setAdapter(this.weekAdapter);
        if (dataDTO == null || dataDTO.weekList == null) {
            return;
        }
        this.weekAdapter.setList(dataDTO.weekList.getList());
    }

    void initView() {
        this.rlCheck.setVisibility(8);
        this.mu.setViewState(3);
        this.siteKBActivity = (SiteKBActivity) this.mActivity;
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.portrait.fragment.KBFragment.2
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((KBPresenter) KBFragment.this.mvpPresenter).getCDKB(SpData.getClassesId(), KBFragment.this.weekCount);
                if (KBFragment.this.mActivity.isDestroyed()) {
                    return;
                }
                KBFragment.this.bookLoadingDiallog.show();
            }
        });
    }

    @OnClick({R.id.rb_week, R.id.rb_month, R.id.rb_trimester})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.rb_month) {
            ((KBPresenter) this.mvpPresenter).getCDKB(SpData.getSiteId(), -1);
            this.rbMonth.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
            this.rbTrimester.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
            this.rbWeek.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
            return;
        }
        if (id != R.id.rb_trimester) {
            if (id == R.id.rb_week && this.weekCount > 1) {
                KBPresenter kBPresenter = (KBPresenter) this.mvpPresenter;
                String siteId = SpData.getSiteId();
                int i = this.weekCount - 1;
                this.weekCount = i;
                kBPresenter.getCDKB(siteId, i);
                this.rbMonth.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
                this.rbTrimester.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
                this.rbWeek.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
                return;
            }
            return;
        }
        if (this.weekCount < this.statusCount) {
            KBPresenter kBPresenter2 = (KBPresenter) this.mvpPresenter;
            String siteId2 = SpData.getSiteId();
            int i2 = this.weekCount + 1;
            this.weekCount = i2;
            kBPresenter2.getCDKB(siteId2, i2);
            this.rbMonth.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
            this.rbTrimester.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
            this.rbWeek.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
        }
    }

    void initData() {
        ((KBPresenter) this.mvpPresenter).getCDKB(SpData.getSiteId(), -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public KBPresenter createPresenter() {
        return new KBPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void KBDataFail(String str) {
        KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCLASSKB);
        if (kBRsp2 != null) {
            setKbDto(kBRsp2.data);
        } else {
            this.mu.setViewState(2);
        }
    }

    public void setKbDto(KBRsp2.DataDTO dataDTO) {
        this.dto = dataDTO;
        this.subList = new ArrayList();
        this.subList1 = new ArrayList();
        this.subList2 = new ArrayList();
        this.subList3 = new ArrayList();
        this.subList4 = new ArrayList();
        this.subList5 = new ArrayList();
        this.jcList = new ArrayList();
        setWeekData(dataDTO);
        if (this.dto.sectionList != null) {
            if (this.dto.sectionList.earlySelfStudyList != null) {
                this.jcList.addAll(this.dto.sectionList.earlySelfStudyList);
            }
            if (this.dto.sectionList.morningList != null) {
                this.jcList.addAll(this.dto.sectionList.morningList);
            }
            if (this.dto.sectionList.afternoonList != null) {
                this.jcList.addAll(this.dto.sectionList.afternoonList);
            }
            if (this.dto.sectionList.nightList != null) {
                this.jcList.addAll(this.dto.sectionList.nightList);
            }
            if (this.dto.sectionList.lateSelfStudyList != null) {
                this.jcList.addAll(this.dto.sectionList.lateSelfStudyList);
            }
            this.subList = this.dto.timetableList;
            this.zxbDTO = this.dto.sectionList;
            this.subList1 = new ArrayList();
            KBRsp2.DataDTO.SectionListDTO sectionListDTO = this.zxbDTO;
            if (sectionListDTO != null) {
                int size = sectionListDTO.earlySelfStudyList.size() == 0 ? 0 : this.zxbDTO.earlySelfStudyList.size() * 7;
                int size2 = this.zxbDTO.morningList.size() == 0 ? 0 : this.zxbDTO.morningList.size() * 7;
                int size3 = this.zxbDTO.afternoonList.size() == 0 ? 0 : this.zxbDTO.afternoonList.size() * 7;
                int size4 = this.zxbDTO.nightList.size() == 0 ? 0 : this.zxbDTO.nightList.size() * 7;
                int size5 = this.zxbDTO.lateSelfStudyList.size() == 0 ? 0 : this.zxbDTO.lateSelfStudyList.size() * 7;
                for (int i = 0; i < size; i++) {
                    this.subList1.add(new KBRsp2.DataDTO.TimetableListDTO());
                }
                for (int i2 = 0; i2 < size2; i2++) {
                    this.subList2.add(new KBRsp2.DataDTO.TimetableListDTO());
                }
                for (int i3 = 0; i3 < size3; i3++) {
                    this.subList3.add(new KBRsp2.DataDTO.TimetableListDTO());
                }
                for (int i4 = 0; i4 < size4; i4++) {
                    this.subList4.add(new KBRsp2.DataDTO.TimetableListDTO());
                }
                for (int i5 = 0; i5 < size5; i5++) {
                    this.subList5.add(new KBRsp2.DataDTO.TimetableListDTO());
                }
            }
            if (this.subList != null) {
                for (int i6 = 0; i6 < this.subList.size(); i6++) {
                    KBRsp2.DataDTO.TimetableListDTO timetableListDTO = this.subList.get(i6);
                    int i7 = ((this.subList.get(i6).sectionTypeNum - 1) * 7) + (timetableListDTO.week - 1);
                    if ("1".equals(this.subList.get(i6).sectionType)) {
                        this.subList1.get(i7).subjectName = timetableListDTO.subjectName;
                        this.subList1.get(i7).teacherList = timetableListDTO.teacherList;
                        this.subList1.get(i7).startTime = timetableListDTO.startTime;
                        this.subList1.get(i7).endTime = timetableListDTO.endTime;
                        this.subList1.get(i7).week = timetableListDTO.week;
                        this.subList1.get(i7).sectionTypeNum = timetableListDTO.sectionTypeNum;
                    }
                    if ("2".equals(this.subList.get(i6).sectionType)) {
                        this.subList2.get(i7).subjectName = timetableListDTO.subjectName;
                        this.subList2.get(i7).teacherList = timetableListDTO.teacherList;
                        this.subList2.get(i7).startTime = timetableListDTO.startTime;
                        this.subList2.get(i7).endTime = timetableListDTO.endTime;
                        this.subList2.get(i7).week = timetableListDTO.week;
                        this.subList2.get(i7).sectionTypeNum = timetableListDTO.sectionTypeNum;
                    }
                    if ("3".equals(this.subList.get(i6).sectionType)) {
                        this.subList3.get(i7).subjectName = timetableListDTO.subjectName;
                        this.subList3.get(i7).teacherList = timetableListDTO.teacherList;
                        this.subList3.get(i7).startTime = timetableListDTO.startTime;
                        this.subList3.get(i7).endTime = timetableListDTO.endTime;
                        this.subList3.get(i7).week = timetableListDTO.week;
                        this.subList3.get(i7).sectionTypeNum = timetableListDTO.sectionTypeNum;
                    }
                    if ("4".equals(this.subList.get(i6).sectionType)) {
                        this.subList4.get(i7).subjectName = timetableListDTO.subjectName;
                        this.subList4.get(i7).teacherList = timetableListDTO.teacherList;
                        this.subList4.get(i7).startTime = timetableListDTO.startTime;
                        this.subList4.get(i7).endTime = timetableListDTO.endTime;
                        this.subList4.get(i7).week = timetableListDTO.week;
                        this.subList4.get(i7).sectionTypeNum = timetableListDTO.sectionTypeNum;
                    }
                    if (ConversionUtil.conditionWithSeriesName.equals(this.subList.get(i6).sectionType)) {
                        this.subList5.get(i7).subjectName = timetableListDTO.subjectName;
                        this.subList5.get(i7).teacherList = timetableListDTO.teacherList;
                        this.subList5.get(i7).startTime = timetableListDTO.startTime;
                        this.subList5.get(i7).endTime = timetableListDTO.endTime;
                        this.subList5.get(i7).week = timetableListDTO.week;
                        this.subList5.get(i7).sectionTypeNum = timetableListDTO.sectionTypeNum;
                    }
                }
            }
            setAdapter();
            setParams();
        }
    }

    private void setAdapter() {
        this.adapter1 = new KBAdapter66_2(this.mActivity, this.maxDay);
        this.adapter2 = new KBAdapter66_2(this.mActivity, this.maxDay);
        this.adapter3 = new KBAdapter66_2(this.mActivity, this.maxDay);
        this.adapter4 = new KBAdapter66_2(this.mActivity, this.maxDay);
        this.adapter5 = new KBAdapter66_2(this.mActivity, this.maxDay);
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
        int size = this.zxbDTO.earlySelfStudyList.size();
        int size2 = this.zxbDTO.morningList.size();
        int size3 = this.zxbDTO.afternoonList.size();
        int size4 = this.zxbDTO.nightList.size();
        int size5 = this.zxbDTO.lateSelfStudyList.size();
        this.list1Size = size;
        this.list2Size = size2;
        this.list3Size = size3;
        this.list4Size = size4;
        this.list5Size = size5;
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
        if (this.list4Size > 0) {
            layoutParams3.setMargins(0, SizeUtils.dp2px(10.0f), 0, 0);
        }
        this.llNight.setLayoutParams(layoutParams3);
        int i5 = this.list5Size;
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px((((this.height * i5) + i5) + i5) - 1));
        layoutParams4.setMargins(0, SizeUtils.dp2px(10.0f), 0, 0);
        this.llNightZx.setLayoutParams(layoutParams4);
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
            this.llLab.addView(getLab(this.jcList.get(this.jcIndex).name, this.jcList.get(this.jcIndex).startTime + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.jcList.get(this.jcIndex).endTime, layoutParams5));
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
            if (i2 == 0) {
                layoutParams4.setMargins(0, 10, 0, 0);
            } else {
                layoutParams4.setMargins(0, 0, 0, 0);
            }
            this.llLab.addView(getLab(this.jcList.get(this.jcIndex).name, this.jcList.get(this.jcIndex).startTime + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.jcList.get(this.jcIndex).endTime, layoutParams4));
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
            this.llLab.addView(getLab(this.jcList.get(this.jcIndex).name, this.jcList.get(this.jcIndex).startTime + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.jcList.get(this.jcIndex).endTime, layoutParams3));
            this.jcIndex = this.jcIndex + 1;
            this.llLab.addView(addLine());
        }
        if (this.list4Size <= 0) {
            this.v3.setVisibility(8);
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
            this.llLab.addView(getLab(this.jcList.get(this.jcIndex).name, this.jcList.get(this.jcIndex).startTime + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.jcList.get(this.jcIndex).endTime, layoutParams2));
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
            this.llLab.addView(getLab(this.jcList.get(this.jcIndex).name, this.jcList.get(this.jcIndex).startTime + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.jcList.get(this.jcIndex).endTime, layoutParams));
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

    private View getLab(String str, String str2, LinearLayout.LayoutParams layoutParams) {
        View viewInflate = LayoutInflater.from(this.mActivity).inflate(R.layout.item_class_schedule_lab, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_name);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_s_name);
        textView.setText(str);
        textView2.setText(str2);
        viewInflate.setLayoutParams(layoutParams);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getCDKBData(KBRsp2 kBRsp2) {
        hideLoading();
        if (kBRsp2.code.intValue() == 0 && kBRsp2.data != null) {
            KBRsp2.DataDTO dataDTO = kBRsp2.data;
            this.dto = dataDTO;
            this.statusCount = dataDTO.weekTotal.intValue();
            this.weekCount = this.dto.thisWeek.intValue();
            this.siteKBActivity.setRightTitle("当前周次：第" + this.weekCount + "周");
            Hawk.delete(BaseHawk.NEWCDKB);
            Hawk.put(BaseHawk.NEWCDKB, kBRsp2);
            setKbDto(kBRsp2.data);
            if (kBRsp2.data.timetableList.size() == 0) {
                Hawk.delete(BaseHawk.NEWCDKB);
                this.mu.setViewState(2);
                return;
            } else {
                this.rlCheck.setVisibility(0);
                this.mu.setViewState(0);
                return;
            }
        }
        this.mu.setViewState(2);
    }
}
