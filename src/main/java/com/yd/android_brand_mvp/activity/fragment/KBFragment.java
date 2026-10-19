package com.yd.android_brand_mvp.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.blankj.utilcode.util.SizeUtils;
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.KBActivity;
import com.yd.android_brand_mvp.adapter.KBAdapter;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.KBRsp;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.presenter.KBPresenter;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.view.MyGridView;
import com.yd.android_brand_mvp.view.KBView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class KBFragment extends BaseMvpFragment<KBPresenter> implements KBView {
    KBAdapter adapter1;
    KBAdapter adapter2;
    KBAdapter adapter3;
    KBAdapter adapter4;
    KBRsp.DataDTO dto;
    KBRsp2.DataDTO dto2;

    @BindView(R.id.gv_list1)
    MyGridView gvList1;

    @BindView(R.id.gv_list2)
    MyGridView gvList2;

    @BindView(R.id.gv_list3)
    MyGridView gvList3;

    @BindView(R.id.gv_list4)
    MyGridView gvList4;
    int height1;
    int height2;
    int height3;
    int height4;
    KBActivity kbActivity;
    int list1Size;
    int list2Size;
    int list3Size;
    int list4Size;

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

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.rb_month)
    Button rbMonth;

    @BindView(R.id.rl_check)
    RelativeLayout rlCheck;
    public List<KBRsp.DataDTO.ListDTO> subList;
    public List<KBRsp.DataDTO.ListDTO> subList1;
    public List<KBRsp.DataDTO.ListDTO> subList2;
    public List<KBRsp.DataDTO.ListDTO> subList3;
    public List<KBRsp.DataDTO.ListDTO> subList4;

    @BindView(R.id.tv_saturday)
    TextView tvSaturday;

    @BindView(R.id.tv_sunday)
    TextView tvSunday;

    @BindView(R.id.v1)
    View v1;

    @BindView(R.id.v2)
    View v2;

    @BindView(R.id.v3)
    View v3;
    KBRsp.DataDTO.ZxbDTO zxbDTO;
    int maxDay = 7;
    int height = 66;
    int weekCount = -1;
    int statusCount = -1;

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getCDKBData(KBRsp2 kBRsp2) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_k_b, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
        initData();
    }

    void setData() {
        this.subList = new ArrayList();
        this.subList1 = new ArrayList();
        this.subList2 = new ArrayList();
        this.subList3 = new ArrayList();
        this.subList4 = new ArrayList();
        this.subList = this.dto.list;
        KBRsp.DataDTO.ZxbDTO zxbDTO = this.dto.zxb;
        this.zxbDTO = zxbDTO;
        int i = Integer.parseInt(zxbDTO.zzxkjs) * 7;
        int i2 = Integer.parseInt(this.zxbDTO.swkjs) * 7;
        int i3 = Integer.parseInt(this.zxbDTO.xwkjs) * 7;
        int i4 = Integer.parseInt(this.zxbDTO.wzxkjs) * 7;
        for (int i5 = 0; i5 < i; i5++) {
            this.subList1.add(new KBRsp.DataDTO.ListDTO());
        }
        for (int i6 = 0; i6 < i2; i6++) {
            this.subList2.add(new KBRsp.DataDTO.ListDTO());
        }
        for (int i7 = 0; i7 < i3; i7++) {
            this.subList3.add(new KBRsp.DataDTO.ListDTO());
        }
        for (int i8 = 0; i8 < i4; i8++) {
            this.subList4.add(new KBRsp.DataDTO.ListDTO());
        }
        for (int i9 = 0; i9 < this.subList.size(); i9++) {
            KBRsp.DataDTO.ListDTO listDTO = this.subList.get(i9);
            int i10 = ((this.subList.get(i9).jcdm - 1) * 7) + (this.subList.get(i9).skxq - 1);
            if ("zzx".equals(this.subList.get(i9).jcsdbs)) {
                this.subList1.get(i10).kcmc = listDTO.kcmc;
            }
            if ("sw".equals(this.subList.get(i9).jcsdbs)) {
                this.subList2.get(i10).kcmc = listDTO.kcmc;
            }
            if ("xw".equals(this.subList.get(i9).jcsdbs)) {
                this.subList3.get(i10).kcmc = listDTO.kcmc;
            }
            if ("wzx".equals(this.subList.get(i9).jcsdbs)) {
                this.subList4.get(i10).kcmc = listDTO.kcmc;
            }
        }
        setAdapter();
        setParams();
    }

    private void setAdapter() {
        this.adapter1 = new KBAdapter(this.mActivity, this.maxDay);
        this.adapter2 = new KBAdapter(this.mActivity, this.maxDay);
        this.adapter3 = new KBAdapter(this.mActivity, this.maxDay);
        this.adapter4 = new KBAdapter(this.mActivity, this.maxDay);
        this.gvList1.setNumColumns(this.maxDay);
        this.gvList2.setNumColumns(this.maxDay);
        this.gvList3.setNumColumns(this.maxDay);
        this.gvList4.setNumColumns(this.maxDay);
        this.gvList1.setAdapter((ListAdapter) this.adapter1);
        this.gvList2.setAdapter((ListAdapter) this.adapter2);
        this.gvList3.setAdapter((ListAdapter) this.adapter3);
        this.gvList4.setAdapter((ListAdapter) this.adapter4);
        this.adapter1.notifyData(this.subList1);
        this.adapter2.notifyData(this.subList2);
        this.adapter3.notifyData(this.subList3);
        this.adapter4.notifyData(this.subList4);
    }

    private void setParams() {
        this.llLab.removeAllViews();
        this.list1Size = Integer.parseInt(this.zxbDTO.zzxkjs);
        this.list2Size = Integer.parseInt(this.zxbDTO.swkjs);
        this.list3Size = Integer.parseInt(this.zxbDTO.xwkjs);
        this.list4Size = Integer.parseInt(this.zxbDTO.wzxkjs);
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
    }

    private void setLab() {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout.LayoutParams layoutParams3;
        int i = this.list1Size;
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px((this.height * i) + i));
        TextView textView = new TextView(this.mActivity);
        textView.setTextSize(SizeUtils.px2sp(20.0f));
        textView.setText("早读");
        textView.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black13));
        textView.setBackgroundResource(R.color.white);
        textView.setLayoutParams(layoutParams4);
        textView.setGravity(17);
        this.llLab.addView(textView);
        this.llLab.addView(addLine());
        int i2 = 0;
        for (int i3 = 0; i3 < this.list2Size; i3++) {
            i2++;
            if (i3 > 0) {
                this.height2++;
                layoutParams3 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height + 1));
            } else {
                layoutParams3 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height));
            }
            if (i3 == 0) {
                layoutParams3.setMargins(0, SizeUtils.dp2px(getViewHeight(2)), 0, 0);
            } else {
                layoutParams3.setMargins(0, 0, 0, 0);
            }
            TextView textView2 = new TextView(this.mActivity);
            textView2.setTextSize(SizeUtils.px2sp(20.0f));
            StringBuilder sb = new StringBuilder();
            sb.append("第");
            sb.append(setLab2(i2 + ""));
            sb.append("节");
            textView2.setText(sb.toString());
            textView2.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black13));
            textView2.setBackgroundResource(R.color.white);
            textView2.setLayoutParams(layoutParams3);
            textView2.setGravity(17);
            this.llLab.addView(textView2);
            this.llLab.addView(addLine());
        }
        for (int i4 = 0; i4 < this.list3Size; i4++) {
            i2++;
            if (i4 > 0) {
                this.height3++;
                layoutParams2 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height + 1));
            } else {
                layoutParams2 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height));
            }
            if (i4 == 0) {
                layoutParams2.setMargins(0, SizeUtils.dp2px(getViewHeight(3)), 0, 0);
            } else {
                layoutParams2.setMargins(0, 0, 0, 0);
            }
            TextView textView3 = new TextView(this.mActivity);
            textView3.setTextSize(SizeUtils.px2sp(20.0f));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("第");
            sb2.append(setLab2(i2 + ""));
            sb2.append("节");
            textView3.setText(sb2.toString());
            textView3.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black13));
            textView3.setBackgroundResource(R.color.white);
            textView3.setLayoutParams(layoutParams2);
            textView3.setGravity(17);
            this.llLab.addView(textView3);
            this.llLab.addView(addLine());
        }
        for (int i5 = 0; i5 < this.list4Size; i5++) {
            i2++;
            if (i5 > 0) {
                this.height4++;
                layoutParams = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height + 1));
            } else {
                layoutParams = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height));
            }
            if (i5 == 0) {
                layoutParams.setMargins(0, SizeUtils.dp2px(getViewHeight(4)), 0, 0);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            TextView textView4 = new TextView(this.mActivity);
            textView4.setTextSize(SizeUtils.px2sp(20.0f));
            StringBuilder sb3 = new StringBuilder();
            sb3.append("第");
            sb3.append(setLab2(i2 + ""));
            sb3.append("节");
            textView4.setText(sb3.toString());
            textView4.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black13));
            textView4.setBackgroundResource(R.color.white);
            textView4.setLayoutParams(layoutParams);
            textView4.setGravity(17);
            this.llLab.addView(textView4);
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
        this.kbActivity = (KBActivity) this.mActivity;
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.activity.fragment.KBFragment.1
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((KBPresenter) KBFragment.this.mvpPresenter).getKB(SpData.getClassesId() + "", KBFragment.this.weekCount);
                if (KBFragment.this.mActivity.isDestroyed()) {
                    return;
                }
                KBFragment.this.bookLoadingDiallog.show();
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

    @OnClick({R.id.rb_week, R.id.rb_month, R.id.rb_trimester})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.rb_month) {
            showLoading();
            ((KBPresenter) this.mvpPresenter).getKB(SpData.getClassesId() + "", -1);
            this.rbMonth.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
            return;
        }
        if (id == R.id.rb_trimester) {
            showLoading();
            if (this.weekCount < this.statusCount) {
                KBPresenter kBPresenter = (KBPresenter) this.mvpPresenter;
                String str = SpData.getClassesId() + "";
                int i = this.weekCount + 1;
                this.weekCount = i;
                kBPresenter.getKB(str, i);
                this.rbMonth.setTextColor(SkinCompatResources.getInstance().getColor(R.color.schedule_check_bg_color));
                return;
            }
            return;
        }
        if (id != R.id.rb_week) {
            return;
        }
        showLoading();
        if (this.weekCount > 1) {
            KBPresenter kBPresenter2 = (KBPresenter) this.mvpPresenter;
            String str2 = SpData.getClassesId() + "";
            int i2 = this.weekCount - 1;
            this.weekCount = i2;
            kBPresenter2.getKB(str2, i2);
            this.rbMonth.setTextColor(SkinCompatResources.getInstance().getColor(R.color.schedule_check_bg_color));
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
        hideLoading();
        if (kBRsp != null && kBRsp.code == 0) {
            KBRsp.DataDTO dataDTO = kBRsp.data;
            this.dto = dataDTO;
            if (dataDTO != null) {
                if (dataDTO.zxb != null) {
                    this.statusCount = this.dto.zxb.xnzzc;
                }
                this.weekCount = this.dto.bzzc;
            }
            this.kbActivity.setRightTitle("当前周次：第" + this.weekCount + "周");
            setData();
            this.rlCheck.setVisibility(0);
            this.mu.setViewState(0);
        }
        if (kBRsp == null || kBRsp.data == null) {
            this.mu.setViewState(2);
        }
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void KBDataFail(String str) {
        hideLoading();
        this.mu.setViewState(2);
        ToastUtil.showBottomView(this.mActivity, str);
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getClassKBData(KBRsp2 kBRsp2) {
        hideLoading();
        if (kBRsp2.code.intValue() == 0) {
            if (kBRsp2.data == null || kBRsp2.data.timetableList == null || kBRsp2.data.timetableList.size() == 0) {
                this.mu.setViewState(2);
                return;
            }
            Hawk.delete(BaseHawk.TABLE);
            Hawk.put(BaseHawk.TABLE, kBRsp2);
            if (kBRsp2.data.timetableList.size() == 0) {
                Hawk.delete(BaseHawk.CDKB);
                this.mu.setViewState(2);
                return;
            }
            return;
        }
        this.mu.setViewState(2);
    }
}
