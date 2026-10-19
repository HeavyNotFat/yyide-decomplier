package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.LeaveFlowAdapter;
import com.yd.android_brand_mvp.base.BaseDialog;
import com.yd.android_brand_mvp.model.ApproverInfoRsp;
import com.yd.android_brand_mvp.utils.TimeUtil;
import java.util.ArrayList;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class LeaveFlowDialog extends BaseDialog {
    private Context context;
    private LeaveFlowAdapter leaveFlowAdapter;
    CancelLeaveListener mCancelLeaveListener;
    private ApproverInfoRsp rsp;
    private ApproverInfoRsp.DataDTO rspData;

    public interface CancelLeaveListener {
        void setCancelLeave(String str);
    }

    public LeaveFlowDialog(Context context, int i) {
        super(context, i);
        this.rsp = new ApproverInfoRsp();
        this.rspData = new ApproverInfoRsp.DataDTO();
    }

    public LeaveFlowDialog(Context context, ApproverInfoRsp approverInfoRsp) {
        super(context, R.style.shareDialog);
        this.rsp = new ApproverInfoRsp();
        this.rspData = new ApproverInfoRsp.DataDTO();
        this.context = context;
        this.rsp = approverInfoRsp;
        this.rspData = approverInfoRsp.data;
    }

    public LeaveFlowDialog(Context context, ApproverInfoRsp.DataDTO dataDTO) {
        super(context, R.style.shareDialog);
        this.rsp = new ApproverInfoRsp();
        this.rspData = new ApproverInfoRsp.DataDTO();
        this.context = context;
        this.rspData = dataDTO;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pop_leave_flow_detail);
        setCanceledOnTouchOutside(true);
        getWindow().setType(2003);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        initView();
    }

    private void initView() {
        TextView textView = (TextView) findViewById(R.id.tv_top_btn);
        TextView textView2 = (TextView) findViewById(R.id.tv_top_title);
        TextView textView3 = (TextView) findViewById(R.id.tv_top_time);
        TextView textView4 = (TextView) findViewById(R.id.tv_content_time_detail);
        TextView textView5 = (TextView) findViewById(R.id.tv_content_reason_detail);
        Button button = (Button) findViewById(R.id.btn_pass);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.cl_repeal);
        TextView textView6 = (TextView) findViewById(R.id.tv_content_class_detail);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_flow);
        final ApproverInfoRsp.DataDTO dataDTO = this.rspData;
        textView2.setText(dataDTO.title);
        textView3.setText(TimeUtil.getTargetTime(dataDTO.createTime, "", "yyyy-MM-dd"));
        textView4.setText(dataDTO.apprJson.startTime + " 至 " + dataDTO.apprJson.endTime);
        textView5.setText(dataDTO.apprJson.reason);
        textView6.setText(dataDTO.dept);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.LeaveFlowDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LeaveFlowDialog.this.mCancelLeaveListener != null) {
                    LeaveFlowDialog.this.mCancelLeaveListener.setCancelLeave(dataDTO.procInstId);
                }
                LeaveFlowDialog.this.dismiss();
            }
        });
        int i = dataDTO.status;
        if (i == 0) {
            textView.setText("已拒绝");
            textView.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape_0);
        } else if (i == 1) {
            textView.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape_1);
            textView.setText("审批中");
            if (dataDTO.isWithdraw) {
                linearLayout.setVisibility(0);
                button.setVisibility(0);
            }
        } else if (i == 2) {
            textView.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape_2);
            textView.setText("已通过");
        } else if (i == 3) {
            textView.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black3));
            textView.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape);
            textView.setText("已撤销");
        }
        if (dataDTO.hiApprNodeList != null && dataDTO.ccList != null && dataDTO.ccList.size() > 0) {
            ApproverInfoRsp.DataDTO.HiApprNodeListDTO hiApprNodeListDTO = new ApproverInfoRsp.DataDTO.HiApprNodeListDTO();
            hiApprNodeListDTO.isCc = true;
            hiApprNodeListDTO.isCcList = new ArrayList();
            hiApprNodeListDTO.isCcList = dataDTO.ccList;
            dataDTO.hiApprNodeList.add(hiApprNodeListDTO);
        }
        this.leaveFlowAdapter = new LeaveFlowAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(this.leaveFlowAdapter);
        this.leaveFlowAdapter.setList(dataDTO.hiApprNodeList);
    }

    public void setCancelLeaveListener(CancelLeaveListener cancelLeaveListener) {
        this.mCancelLeaveListener = cancelLeaveListener;
    }
}
