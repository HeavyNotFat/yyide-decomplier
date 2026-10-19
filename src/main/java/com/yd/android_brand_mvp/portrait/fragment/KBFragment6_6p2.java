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
import com.yd.android_brand_mvp.base.MinaConstants;
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
public class KBFragment6_6p2 extends BaseMvpFragment<KBPresenter> implements KBView {
    private KBAdapter66_2 adapter1;
    private KBAdapter66_2 adapter2;
    private KBAdapter66_2 adapter3;
    private KBAdapter66_2 adapter4;
    private KBAdapter66_2 adapter5;
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
    private List<KBRsp2.DataDTO.SectionListDTO.ZX> jcList;
    private int list1Size;
    private int list2Size;
    private int list3Size;
    private int list4Size;
    private int list5Size;

    @BindView(R.id.ll_afternoon)
    LinearLayout llAfternoon;

    @BindView(R.id.ll_forenoon)
    LinearLayout llForenoon;

    @BindView(R.id.ll_lab)
    LinearLayout llLab;

    @BindView(R.id.ll_morning_reading)
    LinearLayout llMorningReading;

    @BindView(R.id.ll_night)
    LinearLayout llNight;

    @BindView(R.id.ll_night_ws)
    LinearLayout llNightWS;

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
    private List<KBRsp2.DataDTO.TimetableListDTO> subList;
    private List<KBRsp2.DataDTO.TimetableListDTO> subList1;
    private List<KBRsp2.DataDTO.TimetableListDTO> subList2;
    private List<KBRsp2.DataDTO.TimetableListDTO> subList3;
    private List<KBRsp2.DataDTO.TimetableListDTO> subList4;
    private List<KBRsp2.DataDTO.TimetableListDTO> subList5;

    @BindView(R.id.title)
    TextView tvTitle;

    @BindView(R.id.tv_week)
    TextView tvWeek;

    @BindView(R.id.weekRecyclerView)
    RecyclerView weekRecyclerView;
    KBRsp2.DataDTO.SectionListDTO zxbDTO;
    private int maxDay = 7;
    private int jcIndex = 0;
    private int height = 149;
    int weekCount = -1;
    int statusCount = -1;
    private BaseQuickAdapter<KBRsp.DataDTO.WeekTimeBean.WeekBean, BaseViewHolder> weekAdapter = new BaseQuickAdapter<KBRsp.DataDTO.WeekTimeBean.WeekBean, BaseViewHolder>(R.layout.item_kb_week) { // from class: com.yd.android_brand_mvp.portrait.fragment.KBFragment6_6p2.1
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
        return layoutInflater.inflate(R.layout.fragment_k_b6_6p, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
        initData();
        KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCDKB);
        if (kBRsp2 != null) {
            setData(kBRsp2);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.Table || i == MinaConstants.SEMESTER) {
            ((KBPresenter) this.mvpPresenter).getCDKB(SpData.getSiteId(), -1);
        }
    }

    void setData(KBRsp2 kBRsp2) {
        KBRsp2.DataDTO dataDTO = kBRsp2.data;
        this.dto = dataDTO;
        if (dataDTO != null) {
            this.statusCount = dataDTO.weekTotal.intValue();
            this.weekCount = this.dto.thisWeek.intValue();
            this.tvWeek.setText("当前周次：第" + this.weekCount + "周");
            this.rlCheck.setVisibility(0);
            this.mu.setViewState(0);
        }
        setWeekData(this.dto);
        if (SpData.getSiteName() != null) {
            this.tvTitle.setText(SpData.getSiteName());
        } else {
            this.tvTitle.setText("场地课表");
        }
        this.subList = new ArrayList();
        this.subList1 = new ArrayList();
        this.subList2 = new ArrayList();
        this.subList3 = new ArrayList();
        this.subList4 = new ArrayList();
        this.subList5 = new ArrayList();
        this.jcList = new ArrayList();
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
                setAdapter();
                setParams();
            }
        }
    }

    private void setWeekData(KBRsp2.DataDTO dataDTO) {
        this.weekRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 7));
        this.weekRecyclerView.setAdapter(this.weekAdapter);
        if (dataDTO == null || dataDTO.weekList == null) {
            return;
        }
        this.weekAdapter.setList(dataDTO.weekList.getList());
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
        layoutParams3.setMargins(0, SizeUtils.dp2px(10.0f), 0, 0);
        this.llNightWS.setLayoutParams(layoutParams3);
        int i5 = this.list5Size;
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px((((this.height * i5) + i5) + i5) - 1));
        layoutParams4.setMargins(0, SizeUtils.dp2px(10.0f), 0, 0);
        this.llNight.setLayoutParams(layoutParams4);
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
            layoutParams4.setMargins(0, 10, 0, 0);
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

    void initView() {
        this.rlCheck.setVisibility(8);
        if (SpData.NewUser() != null) {
            this.tvTitle.setText("场地课表");
        } else {
            this.tvTitle.setText(SpData.getSiteName());
        }
        this.mu.setViewState(3);
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.portrait.fragment.KBFragment6_6p2.2
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((KBPresenter) KBFragment6_6p2.this.mvpPresenter).getCDKB(SpData.getSiteId(), KBFragment6_6p2.this.weekCount);
                if (KBFragment6_6p2.this.mActivity.isDestroyed()) {
                    return;
                }
                KBFragment6_6p2.this.bookLoadingDiallog.show();
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:67:0x00ee  */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 int, still in use, count: 2, list:
  (r0v0 int) from 0x0006: IF  (r0v0 int) != (1598 int)  -> B:4:0x0008 A[HIDDEN]
  (r0v0 int) from 0x000b: SWITCH (r0v0 int)
 case 1567: goto B:34:0x007c
 case 1568: goto B:31:0x0070
 case 1569: goto B:28:0x0064
 case 1570: goto B:25:0x0058
 case 1571: goto B:22:0x004c
 case 1572: goto B:19:0x0040
 case 1573: goto B:16:0x0034
 case 1574: goto B:13:0x0028
 case 1575: goto B:10:0x001c
 case 1576: goto B:7:0x0010
 default: goto B:67:0x00ee A[RegionRef:SW:5]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public String setLab2(String str) {
        byte b;
        if (str.hashCode() != 1598) {
            switch (str) {
                case "1":
                    b = 0;
                    break;
                case "2":
                    b = 1;
                    break;
                case "3":
                    b = 2;
                    break;
                case "4":
                    b = 3;
                    break;
                case "5":
                    b = 4;
                    break;
                case "6":
                    b = 5;
                    break;
                case "7":
                    b = 6;
                    break;
                case "8":
                    b = 7;
                    break;
                case "9":
                    b = 8;
                    break;
                default:
                    switch (str) {
                        case 1567:
                            if (!str.equals(ConversionUtil.conditionWithSort)) {
                                b = -1;
                            } else {
                                b = 9;
                            }
                            break;
                        case 1568:
                            if (!str.equals(ConversionUtil.conditionWithYear)) {
                                b = -1;
                            } else {
                                b = 10;
                            }
                            break;
                        case 1569:
                            if (!str.equals("12")) {
                                b = -1;
                            } else {
                                b = 11;
                            }
                            break;
                        case 1570:
                            if (!str.equals("13")) {
                                b = -1;
                            } else {
                                b = 12;
                            }
                            break;
                        case 1571:
                            if (!str.equals("14")) {
                                b = -1;
                            } else {
                                b = 13;
                            }
                            break;
                        case 1572:
                            if (!str.equals("15")) {
                                b = -1;
                            } else {
                                b = 14;
                            }
                            break;
                        case 1573:
                            if (!str.equals("16")) {
                                b = -1;
                            } else {
                                b = 15;
                            }
                            break;
                        case 1574:
                            if (!str.equals("17")) {
                                b = -1;
                            } else {
                                b = 16;
                            }
                            break;
                        case 1575:
                            if (!str.equals("18")) {
                                b = -1;
                            } else {
                                b = 17;
                            }
                            break;
                        case 1576:
                            if (!str.equals("19")) {
                                b = -1;
                            } else {
                                b = 18;
                            }
                            break;
                        default:
                            b = -1;
                            break;
                    }
            }
        } else if (str.equals("20")) {
            b = 19;
        } else {
            b = -1;
        }
        switch (b) {
            case 0:
                return "一";
            case 1:
                return "二";
            case 2:
                return "三";
            case 3:
                return "四";
            case 4:
                return "五";
            case 5:
                return "六";
            case 6:
                return "七";
            case 7:
                return "八";
            case 8:
                return "九";
            case 9:
                return "十";
            case 10:
                return "十一";
            case 11:
                return "十二";
            case 12:
                return "十三";
            case 13:
                return "十四";
            case 14:
                return "十五";
            case 15:
                return "十六";
            case 16:
                return "十七";
            case 17:
                return "十八";
            case 18:
                return "十九";
            case 19:
                return "二十";
            default:
                return "section";
        }
    }

    @OnClick({R.id.rb_week, R.id.rb_month, R.id.rb_trimester, R.id.title})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_month /* 2131363532 */:
                showLoading();
                ((KBPresenter) this.mvpPresenter).getCDKB(SpData.getSiteId(), -1);
                this.rbMonth.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
                this.rbTrimester.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
                this.rbWeek.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
                break;
            case R.id.rb_trimester /* 2131363545 */:
                showLoading();
                if (this.weekCount < this.statusCount) {
                    KBPresenter kBPresenter = (KBPresenter) this.mvpPresenter;
                    String siteId = SpData.getSiteId();
                    int i = this.weekCount + 1;
                    this.weekCount = i;
                    kBPresenter.getCDKB(siteId, i);
                    this.rbMonth.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
                    this.rbTrimester.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
                    this.rbWeek.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
                }
                break;
            case R.id.rb_week /* 2131363549 */:
                showLoading();
                if (this.weekCount > 1) {
                    KBPresenter kBPresenter2 = (KBPresenter) this.mvpPresenter;
                    String siteId2 = SpData.getSiteId();
                    int i2 = this.weekCount - 1;
                    this.weekCount = i2;
                    kBPresenter2.getCDKB(siteId2, i2);
                    this.rbMonth.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
                    this.rbTrimester.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
                    this.rbWeek.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
                }
                break;
            case R.id.title /* 2131363939 */:
                goPermissionsActivity(SiteKBActivity.class);
                break;
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
        hideLoading();
        KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCDKB);
        if (kBRsp2 != null) {
            setData(kBRsp2);
        } else {
            this.mu.setViewState(2);
        }
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getCDKBData(KBRsp2 kBRsp2) {
        hideLoading();
        if (kBRsp2 != null && kBRsp2.code.intValue() == 0) {
            setData(kBRsp2);
            Hawk.delete(BaseHawk.NEWCDKB);
            Hawk.put(BaseHawk.NEWCDKB, kBRsp2);
            if (kBRsp2.data.timetableList.size() == 0) {
                Hawk.delete(BaseHawk.NEWCDKB);
                this.mu.setViewState(2);
            }
        }
        if (kBRsp2 == null || kBRsp2.data == null) {
            this.mu.setViewState(2);
        }
    }
}
