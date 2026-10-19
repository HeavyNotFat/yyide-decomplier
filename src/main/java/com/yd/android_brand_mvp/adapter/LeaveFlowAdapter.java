package com.yd.android_brand_mvp.adapter;

import android.widget.ImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.ApproverInfoRsp;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.TimeUtil;

/* JADX INFO: loaded from: classes4.dex */
public class LeaveFlowAdapter extends BaseQuickAdapter<ApproverInfoRsp.DataDTO.HiApprNodeListDTO, BaseViewHolder> {
    private BaseQuickAdapter<ApproverInfoRsp.DataDTO.CcListDTO, BaseViewHolder> mAdapter;

    public LeaveFlowAdapter() {
        super(R.layout.item_ask_for_leave_flow);
        this.mAdapter = new BaseQuickAdapter<ApproverInfoRsp.DataDTO.CcListDTO, BaseViewHolder>(R.layout.item_leave_detail_cc) { // from class: com.yd.android_brand_mvp.adapter.LeaveFlowAdapter.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder baseViewHolder, ApproverInfoRsp.DataDTO.CcListDTO ccListDTO) {
                baseViewHolder.setText(R.id.tvName, ccListDTO.name);
                GlideUtil.loadRadiusHeadImage(getContext(), ccListDTO.avatar, (ImageView) baseViewHolder.getView(R.id.iv_user_head), 5);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder baseViewHolder, ApproverInfoRsp.DataDTO.HiApprNodeListDTO hiApprNodeListDTO) {
        String targetTime = TimeUtil.getTargetTime(hiApprNodeListDTO.apprTime, "", "yyyy-MM-dd HH:mm");
        if (!hiApprNodeListDTO.isCc) {
            baseViewHolder.setText(R.id.tv_flow_title, hiApprNodeListDTO.nodeName);
            baseViewHolder.setText(R.id.tvTime, targetTime);
            baseViewHolder.setText(R.id.tv_flow_content, hiApprNodeListDTO.userName);
            if (getItemPosition(hiApprNodeListDTO) == getData().size() - 1) {
                baseViewHolder.getView(R.id.vEnd).setVisibility(4);
            }
            baseViewHolder.getView(R.id.tvComment).setVisibility(8);
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_user_head);
            GlideUtil.loadRadiusHeadImage(getContext(), hiApprNodeListDTO.avatar, imageView, 5);
            ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_flow_checked);
            if ("2".equals(hiApprNodeListDTO.status)) {
                imageView.setPadding(4, 4, 4, 4);
                imageView2.setVisibility(0);
                imageView2.setImageResource(R.drawable.icon_flow_checked);
                baseViewHolder.setText(R.id.tv_flow_content, hiApprNodeListDTO.userName + "  已同意");
            } else if ("0".equals(hiApprNodeListDTO.status)) {
                baseViewHolder.getView(R.id.tvComment).setVisibility(0);
                baseViewHolder.setText(R.id.tv_flow_content, hiApprNodeListDTO.userName + "  已拒绝");
                baseViewHolder.setText(R.id.tvComment, hiApprNodeListDTO.comment);
                imageView2.setVisibility(0);
                imageView2.setImageResource(R.drawable.icon_leave_cancel);
                imageView.setPadding(4, 4, 4, 4);
                imageView.setBackgroundResource(R.drawable.bg_white20);
            } else if ("4".equals(hiApprNodeListDTO.status)) {
                baseViewHolder.setText(R.id.tv_flow_content, "审批人  已退回");
                imageView2.setVisibility(4);
            } else {
                imageView2.setVisibility(4);
            }
            if (getItemPosition(hiApprNodeListDTO) == 0) {
                imageView.setPadding(4, 4, 4, 4);
                imageView.setBackgroundResource(R.drawable.icon_head_bg);
                imageView2.setImageResource(R.drawable.icon_flow_checked);
                baseViewHolder.setText(R.id.tv_flow_content, "我");
                imageView2.setVisibility(0);
                return;
            }
            return;
        }
        ((ImageView) baseViewHolder.getView(R.id.iv_user_head)).setImageResource(R.drawable.icon_leave_cc);
        baseViewHolder.setText(R.id.tv_flow_title, "抄送人");
        if (hiApprNodeListDTO.isCcList != null) {
            baseViewHolder.setText(R.id.tv_flow_content, "共抄送" + hiApprNodeListDTO.isCcList.size() + "人");
        } else {
            baseViewHolder.setText(R.id.tv_flow_content, "共抄送0人");
        }
        baseViewHolder.getView(R.id.iv_flow_checked).setVisibility(4);
        baseViewHolder.getView(R.id.vEnd).setVisibility(4);
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.recyclerView);
        recyclerView.setVisibility(0);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 6));
        recyclerView.setAdapter(this.mAdapter);
        this.mAdapter.setList(hiApprNodeListDTO.isCcList);
    }
}
