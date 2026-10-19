package com.yd.android_brand_mvp.weight;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.LeaveFlowAdapter;
import com.yd.android_brand_mvp.base.BaseCenterPopup;
import com.yd.android_brand_mvp.model.ApproverInfoRsp;
import java.util.ArrayList;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class LeaveFlowPop extends BaseCenterPopup {
    private LeaveFlowAdapter leaveFlowAdapter;
    CancelLeaveListener mCancelLeaveListener;
    private ApproverInfoRsp rsp;

    public interface CancelLeaveListener {
        void setCancelLeave(String str);
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.pop_leave_flow_detail;
    }

    public LeaveFlowPop(Context context, ApproverInfoRsp approverInfoRsp) {
        super(context);
        this.rsp = new ApproverInfoRsp();
        this.rsp = approverInfoRsp;
    }

    @Override // com.yd.android_brand_mvp.base.BaseCenterPopup, com.lxj.xpopup.core.BasePopupView
    protected void onCreate() {
        super.onCreate();
        TextView textView = (TextView) findViewById(R.id.tv_top_btn);
        TextView textView2 = (TextView) findViewById(R.id.tv_top_title);
        TextView textView3 = (TextView) findViewById(R.id.tv_top_time);
        TextView textView4 = (TextView) findViewById(R.id.tv_content_time_detail);
        TextView textView5 = (TextView) findViewById(R.id.tv_content_reason_detail);
        Button button = (Button) findViewById(R.id.btn_pass);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.cl_repeal);
        TextView textView6 = (TextView) findViewById(R.id.tv_content_class_detail);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_flow);
        final ApproverInfoRsp.DataDTO dataDTO = this.rsp.data;
        textView2.setText(dataDTO.title);
        textView3.setText(dataDTO.createTime);
        textView4.setText(dataDTO.apprJson.startTime + "至" + dataDTO.apprJson.endTime);
        textView5.setText(dataDTO.apprJson.reason);
        textView6.setText(dataDTO.dept);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.weight.LeaveFlowPop.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LeaveFlowPop.this.mCancelLeaveListener != null) {
                    LeaveFlowPop.this.mCancelLeaveListener.setCancelLeave(dataDTO.id);
                }
            }
        });
        int i = dataDTO.status;
        if (i == 0) {
            textView.setText("已拒绝");
            textView.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape_0);
        } else if (i == 1) {
            textView.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape_1);
            textView.setText("审批中");
            if (dataDTO.isBack) {
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

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getMaxHeight() {
        return super.getMaxHeight();
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        return super.getMaxWidth();
    }
}
