package com.yd.android_brand_mvp.landscape;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.JSON;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.dialog.LeaveFinishDialog;
import com.yd.android_brand_mvp.dialog.SelectionApproDialog;
import com.yd.android_brand_mvp.dialog.SelectionLeaveDialog;
import com.yd.android_brand_mvp.model.ApproverAdapterBean;
import com.yd.android_brand_mvp.model.ApproverInfoRsp;
import com.yd.android_brand_mvp.model.ApproverListRsp;
import com.yd.android_brand_mvp.model.BaseContentRsp;
import com.yd.android_brand_mvp.model.GetAskLeaveRecordBandRsp;
import com.yd.android_brand_mvp.model.LeaveAdapterBean;
import com.yd.android_brand_mvp.model.RequestJsonData;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.observer.MinaListener;
import com.yd.android_brand_mvp.presenter.LeavePresenter;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.view.LeaveView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class RequestLeaveFragment extends BaseMvpFragment<LeavePresenter> implements LeaveView, MinaListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    @BindView(R.id.appLine)
    View appLine;

    @BindView(R.id.ccLine)
    View ccLine;
    String content;
    private SelectionLeaveDialog dialog;

    @BindView(R.id.et_content)
    EditText etContent;
    float hours;
    boolean isBack;

    @BindView(R.id.iv_add_approval)
    ImageView ivApproval;

    @BindView(R.id.iv_add_staff)
    ImageView iv_add_staff;
    int layout;

    @BindView(R.id.approvalList)
    RecyclerView mApprovalRecycle;

    @BindView(R.id.ccList)
    RecyclerView mCcRecycle;
    String procId;
    private TimePickerView pvTime;
    String sponsorType;
    int timeType;

    @BindView(R.id.tv_approver_prompt)
    TextView tvApproverPrompt;

    @BindView(R.id.tv_class)
    TextView tvClassName;

    @BindView(R.id.tv_copy_prompt)
    TextView tvCopuPrompt;

    @BindView(R.id.tv_end_time)
    TextView tvEndTime;

    @BindView(R.id.tv_start_time)
    TextView tvStartTime;

    @BindView(R.id.tv_approver)
    TextView tv_approver;
    Unbinder unbinder;

    @BindView(R.id.viewLine)
    View viewLine;

    @BindView(R.id.viewTop)
    View viewTop;
    List<ApproverListRsp.DataDTO.CcListDTO> ccDataList = new ArrayList();
    private String TAG = RequestLeaveFragment.class.getSimpleName();
    List<LeaveAdapterBean> ccList = new ArrayList();
    private final BaseQuickAdapter<LeaveAdapterBean, BaseViewHolder> mCCAdapter = new AnonymousClass1(R.layout.item_leave_cc);
    private final BaseQuickAdapter<LeaveAdapterBean, BaseViewHolder> mAdapter = new AnonymousClass2(R.layout.item_approver_head);

    @Override // com.yd.android_brand_mvp.view.LeaveView
    public void GetAskLeaveRecordBandRsp(GetAskLeaveRecordBandRsp getAskLeaveRecordBandRsp) {
    }

    @Override // com.yd.android_brand_mvp.view.LeaveView
    public void GetAskLeaveRecordBandRspFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.LeaveView
    public void delectFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.LeaveView
    public void delectSuccess(BaseContentRsp baseContentRsp) {
    }

    @Override // com.yd.android_brand_mvp.view.LeaveView
    public void getApproverInfoSuccess(ApproverInfoRsp approverInfoRsp) {
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        judgeLandscape();
        View viewInflate = layoutInflater.inflate(this.layout, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    private void judgeLandscape() {
        this.layout = R.layout.fragment_new_leave;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
    }

    private void initView() {
        Log.e(this.TAG, "token == " + SpData.getToken());
        this.tvStartTime.setText(TimeUtil.stampToDate8(System.currentTimeMillis()));
        this.tvEndTime.setText(TimeUtil.stampToDate8(System.currentTimeMillis()));
        this.tvClassName.setText(SpData.USERCENTINFO2().data.className);
        this.mApprovalRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mCcRecycle.setLayoutManager(new GridLayoutManager(getActivity(), 6));
        this.mCcRecycle.setAdapter(this.mCCAdapter);
        this.dialog = new SelectionLeaveDialog(getContext(), this.ccDataList);
    }

    @OnClick({R.id.tv_submit, R.id.tv_start_time, R.id.tv_end_time, R.id.iv_add_staff})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_add_staff /* 2131362922 */:
                this.dialog.setSelectList(this.mCCAdapter.getData());
                this.dialog.show();
                break;
            case R.id.tv_end_time /* 2131364366 */:
                this.timeType = 2;
                showTime(2);
                break;
            case R.id.tv_start_time /* 2131364781 */:
                this.timeType = 1;
                showTime(1);
                break;
            case R.id.tv_submit /* 2131364789 */:
                if (sheckMessage() && sheckLeaveTime()) {
                    RequestJsonData requestJsonData = new RequestJsonData();
                    requestJsonData.startTime = this.tvStartTime.getText().toString();
                    requestJsonData.endTime = this.tvEndTime.getText().toString();
                    requestJsonData.reason = this.etContent.getText().toString();
                    requestJsonData.student = SpData.USERCENTINFO2().data.name;
                    requestJsonData.studentId = SpData.USERCENTINFO2().data.id;
                    requestJsonData.hours = this.hours;
                    if (getAppList().size() > 0 || !TextUtils.isEmpty(getCCList())) {
                        ((LeavePresenter) this.mvpPresenter).addLeave(requestJsonData, getAppList(), this.isBack, this.procId, this.sponsorType, SpData.USERCENTINFO2().data.classesId, SpData.USERCENTINFO2().data.className, getCCList(), SpData.USERCENTINFO2().data.id);
                    }
                    if (!this.mActivity.isDestroyed()) {
                        this.bookLoadingDiallog.show();
                    }
                    break;
                }
                break;
        }
    }

    public boolean sheckMessage() {
        String string = this.etContent.getText().toString();
        this.content = string;
        if (!StringUtils.isEmpty(string)) {
            return true;
        }
        ToastUtil.showBottomView(this.mActivity, "请输入请假事由");
        return false;
    }

    public boolean sheckLeaveTime() {
        if (TextUtils.isEmpty(this.tvStartTime.getText().toString()) || TextUtils.isEmpty(this.tvEndTime.getText().toString())) {
            ToastUtil.showBottomView(this.mActivity, "请选择请假事时间");
            return false;
        }
        if (TimeUtil.gettime(this.tvEndTime.getText().toString()) > TimeUtil.gettime(this.tvStartTime.getText().toString())) {
            return true;
        }
        ToastUtil.showBottomView(this.mActivity, "结束时间不能小于或等于开始时间");
        return false;
    }

    private void requestApprover() {
        String strValueOf = String.valueOf(SpData.USERCENTINFO2().data.classesId);
        String strValueOf2 = String.valueOf(SpData.USERCENTINFO2().data.id);
        SpData.getToken();
        showProgressDialog();
        ((LeavePresenter) this.mvpPresenter).getApproverList(strValueOf, this.tvStartTime.getText().toString(), this.tvEndTime.getText().toString(), strValueOf2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public LeavePresenter createPresenter() {
        return new LeavePresenter(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Log.d(this.TAG, "onDestroy: RequestLeaveFragment");
        Unbinder unbinder = this.unbinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
        SelectionLeaveDialog selectionLeaveDialog = this.dialog;
        if (selectionLeaveDialog == null || !selectionLeaveDialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
    }

    @Override // com.yd.android_brand_mvp.view.LeaveView
    public void getSuccessFail(String str) {
        dismissProgressDialog();
        ToastUtils.showShort(str);
    }

    @Override // com.yd.android_brand_mvp.view.LeaveView
    public void getApproverListSuccess(ApproverListRsp approverListRsp) {
        dismissProgressDialog();
        Log.e("addLeaveSuccess", JSON.toJSONString(approverListRsp));
        if (approverListRsp.code == 0) {
            initApproverData(approverListRsp.data);
            return;
        }
        this.tvStartTime.setText(TimeUtil.stampToDate8(System.currentTimeMillis()));
        this.tvEndTime.setText(TimeUtil.stampToDate8(System.currentTimeMillis()));
        this.tvCopuPrompt.setVisibility(0);
        this.tvApproverPrompt.setVisibility(0);
        this.ccList.clear();
        this.mCCAdapter.setList(null);
        this.mAdapter.setList(null);
        ToastUtil.showView(getActivity(), approverListRsp.message);
    }

    @Override // com.yd.android_brand_mvp.view.LeaveView
    public void addLeaveSuccess(BaseContentRsp baseContentRsp) {
        Log.e("addLeaveSuccess", JSON.toJSONString(baseContentRsp));
        if (!this.mActivity.isDestroyed()) {
            this.bookLoadingDiallog.dismiss();
        }
        if (baseContentRsp.code == 0) {
            LeaveFinishDialog leaveFinishDialog = new LeaveFinishDialog(getContext());
            leaveFinishDialog.show();
            leaveFinishDialog.setFinishListener(new LeaveFinishDialog.addListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$RequestLeaveFragment$U1DZRFIoTxdfQqIqHZ_ZAWi5vWI
                @Override // com.yd.android_brand_mvp.dialog.LeaveFinishDialog.addListener
                public final void addFinishListener() {
                    this.f$0.lambda$addLeaveSuccess$0$RequestLeaveFragment();
                }
            });
            return;
        }
        ToastUtil.showView(getActivity(), baseContentRsp.message);
    }

    public /* synthetic */ void lambda$addLeaveSuccess$0$RequestLeaveFragment() {
        this.tvStartTime.setText(TimeUtil.stampToDate8(System.currentTimeMillis()));
        this.tvEndTime.setText(TimeUtil.stampToDate8(System.currentTimeMillis()));
        this.etContent.setText("");
        this.tvCopuPrompt.setVisibility(0);
        this.tvApproverPrompt.setVisibility(0);
        this.ccList.clear();
        this.mCCAdapter.setList(null);
        this.mAdapter.setList(null);
        MinaEventManager.getInstance().notifyObserver(MinaConstants.Updata_Leave);
    }

    private void initApproverData(ApproverListRsp.DataDTO dataDTO) {
        this.ccDataList = dataDTO.ccList;
        this.hours = dataDTO.hours;
        this.sponsorType = dataDTO.sponsorType;
        this.procId = dataDTO.procId;
        this.isBack = dataDTO.isBack;
        this.tvCopuPrompt.setVisibility(8);
        this.tvApproverPrompt.setVisibility(8);
        List<ApproverListRsp.DataDTO.ApproverDTO> list = dataDTO.approver;
        ArrayList arrayList = new ArrayList();
        this.ccList.clear();
        if (this.ccDataList.size() > 0) {
            ApproverListRsp.DataDTO.CcListDTO ccListDTO = this.ccDataList.get(0);
            LeaveAdapterBean leaveAdapterBean = new LeaveAdapterBean();
            leaveAdapterBean.avatar = ccListDTO.avatar;
            leaveAdapterBean.name = ccListDTO.name;
            leaveAdapterBean.id = ccListDTO.id;
            leaveAdapterBean.userId = ccListDTO.userId;
            this.ccList.add(leaveAdapterBean);
            this.mCCAdapter.setList(this.ccList);
        } else {
            this.mCCAdapter.setList(null);
        }
        this.dialog.setExamineListner(new SelectionLeaveDialog.SelectExAmineOnclickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$RequestLeaveFragment$c038-qZoUdGD1n65Cl8AkWcnICk
            @Override // com.yd.android_brand_mvp.dialog.SelectionLeaveDialog.SelectExAmineOnclickListener
            public final void ExamineListener(List list2) {
                this.f$0.lambda$initApproverData$1$RequestLeaveFragment(list2);
            }
        });
        for (int i = 0; i < list.size(); i++) {
            ApproverListRsp.DataDTO.ApproverDTO approverDTO = list.get(i);
            if (approverDTO.branapprList.size() > 0) {
                ApproverListRsp.DataDTO.ApproverDTO.BranapprListDTO branapprListDTO = approverDTO.branapprList.get(0);
                LeaveAdapterBean leaveAdapterBean2 = new LeaveAdapterBean();
                leaveAdapterBean2.id = approverDTO.id;
                leaveAdapterBean2.name = approverDTO.name;
                leaveAdapterBean2.approverId = branapprListDTO.approverId;
                leaveAdapterBean2.brandName = branapprListDTO.name;
                leaveAdapterBean2.userId = branapprListDTO.userId;
                leaveAdapterBean2.avatar = branapprListDTO.avatar;
                leaveAdapterBean2.branapprList = new ArrayList();
                leaveAdapterBean2.branapprList.addAll(approverDTO.branapprList);
                arrayList.add(leaveAdapterBean2);
            }
            arrayList.size();
            addApprovalList(arrayList);
        }
    }

    public /* synthetic */ void lambda$initApproverData$1$RequestLeaveFragment(List list) {
        this.ccList.clear();
        if (list.size() > 0) {
            this.ccList.addAll(list);
            this.mCCAdapter.setList(this.ccList);
        } else {
            this.mCCAdapter.setList(null);
        }
    }

    private void addApprovalList(List<LeaveAdapterBean> list) {
        if (list != null && list.size() > 0) {
            this.ivApproval.setVisibility(4);
            this.appLine.setVisibility(8);
        }
        this.mApprovalRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mApprovalRecycle.setAdapter(this.mAdapter);
        this.mAdapter.setList(list);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.RequestLeaveFragment$1, reason: invalid class name */
    class AnonymousClass1 extends BaseQuickAdapter<LeaveAdapterBean, BaseViewHolder> {
        AnonymousClass1(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(BaseViewHolder baseViewHolder, final LeaveAdapterBean leaveAdapterBean) {
            baseViewHolder.setText(R.id.tvName, leaveAdapterBean.name);
            baseViewHolder.getView(R.id.ivDel).setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$RequestLeaveFragment$1$e9_-9gr5fS-v_U6KrDKDQfBMop0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$convert$0$RequestLeaveFragment$1(leaveAdapterBean, view);
                }
            });
            GlideUtil.loadRadiusHeadImage(getContext(), leaveAdapterBean.avatar, (ImageView) baseViewHolder.getView(R.id.ivHead), 5);
        }

        public /* synthetic */ void lambda$convert$0$RequestLeaveFragment$1(LeaveAdapterBean leaveAdapterBean, View view) {
            RequestLeaveFragment.this.mCCAdapter.remove(leaveAdapterBean);
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.RequestLeaveFragment$2, reason: invalid class name */
    class AnonymousClass2 extends BaseQuickAdapter<LeaveAdapterBean, BaseViewHolder> {
        AnonymousClass2(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(BaseViewHolder baseViewHolder, final LeaveAdapterBean leaveAdapterBean) {
            baseViewHolder.setText(R.id.tvDesc, leaveAdapterBean.brandName);
            final int size = leaveAdapterBean.branapprList.size();
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.ivDel);
            ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_add_approval);
            if (size > 1) {
                imageView2.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$RequestLeaveFragment$2$rMK4XBGXWdT8tiK8rRmJGK5JH2M
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$convert$0$RequestLeaveFragment$2(leaveAdapterBean, view);
                    }
                });
                baseViewHolder.getView(R.id.iv_add_approval).setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$RequestLeaveFragment$2$mKyFZUkPaX98mr7PYb6Hyd5C_eI
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$convert$2$RequestLeaveFragment$2(leaveAdapterBean, size, view);
                    }
                });
            } else {
                imageView2.setVisibility(8);
                imageView.setVisibility(8);
            }
            GlideUtil.loadRadiusHeadImage(getContext(), leaveAdapterBean.avatar, (ImageView) baseViewHolder.getView(R.id.iv_user_head), 5);
        }

        public /* synthetic */ void lambda$convert$0$RequestLeaveFragment$2(LeaveAdapterBean leaveAdapterBean, View view) {
            RequestLeaveFragment.this.mAdapter.remove(leaveAdapterBean);
        }

        public /* synthetic */ void lambda$convert$2$RequestLeaveFragment$2(final LeaveAdapterBean leaveAdapterBean, int i, View view) {
            final int itemPosition = getItemPosition(leaveAdapterBean);
            if (i > 0) {
                SelectionApproDialog selectionApproDialog = new SelectionApproDialog(getContext(), leaveAdapterBean.branapprList);
                selectionApproDialog.setSelectList(leaveAdapterBean.approverId);
                selectionApproDialog.setApproListner(new SelectionApproDialog.SelectApproOnclickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$RequestLeaveFragment$2$Zp05AeaBQDYXM28tpIEcdOFAYFo
                    @Override // com.yd.android_brand_mvp.dialog.SelectionApproDialog.SelectApproOnclickListener
                    public final void ApproListener(List list) {
                        this.f$0.lambda$convert$1$RequestLeaveFragment$2(leaveAdapterBean, itemPosition, list);
                    }
                });
                selectionApproDialog.show();
            }
        }

        public /* synthetic */ void lambda$convert$1$RequestLeaveFragment$2(LeaveAdapterBean leaveAdapterBean, int i, List list) {
            leaveAdapterBean.userId = ((LeaveAdapterBean) list.get(0)).userId;
            leaveAdapterBean.brandName = ((LeaveAdapterBean) list.get(0)).name;
            leaveAdapterBean.approverId = ((LeaveAdapterBean) list.get(0)).approverId;
            leaveAdapterBean.avatar = ((LeaveAdapterBean) list.get(0)).avatar;
            notifyItemChanged(i);
        }
    }

    private List<ApproverAdapterBean.RequestParam> getAppList() {
        List<LeaveAdapterBean> data = this.mAdapter.getData();
        ArrayList arrayList = new ArrayList();
        for (LeaveAdapterBean leaveAdapterBean : data) {
            arrayList.add(new ApproverAdapterBean.RequestParam(leaveAdapterBean.id, leaveAdapterBean.name, leaveAdapterBean.approverId));
        }
        return arrayList;
    }

    private String getCCList() {
        List<LeaveAdapterBean> data = this.mCCAdapter.getData();
        StringBuilder sb = new StringBuilder();
        if (data.size() <= 0) {
            return "";
        }
        Iterator<LeaveAdapterBean> it2 = data.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next().id);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        return sb.toString();
    }

    public void showTime(final int i) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar3 = Calendar.getInstance();
        calendar2.set(2022, 0, 1);
        calendar3.set(2025, 11, 31);
        TimePickerView timePickerViewBuild = new TimePickerBuilder(this.mActivity, new OnTimeSelectListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$RequestLeaveFragment$OGFsYDOCg7dyOf8DzN1lgi4yzA0
            @Override // com.bigkoo.pickerview.listener.OnTimeSelectListener
            public final void onTimeSelect(Date date, View view) {
                this.f$0.lambda$showTime$2$RequestLeaveFragment(i, date, view);
            }
        }).setType(new boolean[]{true, true, true, true, true, false}).setDate(calendar).setRangDate(calendar2, calendar3).setTextColorCenter(SkinCompatResources.getInstance().getColor(R.color.purple2)).setDividerColor(SkinCompatResources.getInstance().getColor(R.color.purple2)).setLabel("年", "月", "日", "时", "分", "").setLayoutRes(R.layout.time_select, new CustomListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$RequestLeaveFragment$Zwyao0_4RtdZ70W2hTEOwfnZJxs
            @Override // com.bigkoo.pickerview.listener.CustomListener
            public final void customLayout(View view) {
                this.f$0.lambda$showTime$5$RequestLeaveFragment(view);
            }
        }).isCenterLabel(false).isDialog(true).build();
        this.pvTime = timePickerViewBuild;
        timePickerViewBuild.getDialog();
        this.pvTime.show();
    }

    public /* synthetic */ void lambda$showTime$2$RequestLeaveFragment(int i, Date date, View view) {
        if (i == 1) {
            this.tvStartTime.setText(getTime(date));
        } else {
            this.tvEndTime.setText(getTime(date));
        }
        if (!TextUtils.isEmpty(this.tvStartTime.getText()) && !TextUtils.isEmpty(this.tvEndTime.getText()) && sheckLeaveTime()) {
            requestApprover();
        }
        this.pvTime.dismiss();
    }

    public /* synthetic */ void lambda$showTime$5$RequestLeaveFragment(View view) {
        Button button = (Button) view.findViewById(R.id.btnCancel);
        Button button2 = (Button) view.findViewById(R.id.btnSubmit);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$RequestLeaveFragment$dyysf4oPE0d-uqCdv91upcMaLlE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$showTime$3$RequestLeaveFragment(view2);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$RequestLeaveFragment$CiBtwLtSIB26ou_D8aik1EBqXPI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$showTime$4$RequestLeaveFragment(view2);
            }
        });
    }

    public /* synthetic */ void lambda$showTime$3$RequestLeaveFragment(View view) {
        this.pvTime.dismiss();
    }

    public /* synthetic */ void lambda$showTime$4$RequestLeaveFragment(View view) {
        this.pvTime.returnData();
    }

    private String getTime(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
    }
}
