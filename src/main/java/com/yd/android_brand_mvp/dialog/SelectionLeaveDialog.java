package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialog;
import com.yd.android_brand_mvp.model.ApproverListRsp;
import com.yd.android_brand_mvp.model.LeaveAdapterBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.TeacherNameUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SelectionLeaveDialog extends BaseDialog implements View.OnClickListener {
    private Context context;
    BaseQuickAdapter<ApproverListRsp.DataDTO.CcListDTO, BaseViewHolder> mAdapter;
    private TextView mAmount;
    private List<ApproverListRsp.DataDTO.CcListDTO> mList;
    private final List<LeaveAdapterBean> mReturnList;
    SelectExAmineOnclickListener mSelectExAmineOnclickListener;
    private String title;

    public interface SelectExAmineOnclickListener {
        void ExamineListener(List<LeaveAdapterBean> list);
    }

    public SelectionLeaveDialog(Context context, int i) {
        super(context, i);
        this.title = "请选择抄送人";
        this.mAdapter = new BaseQuickAdapter<ApproverListRsp.DataDTO.CcListDTO, BaseViewHolder>(R.layout.item_select_examine) { // from class: com.yd.android_brand_mvp.dialog.SelectionLeaveDialog.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder baseViewHolder, ApproverListRsp.DataDTO.CcListDTO ccListDTO) {
                SelectionLeaveDialog.this.findViewById(R.id.ivHead);
                CheckBox checkBox = (CheckBox) baseViewHolder.getView(R.id.cbCheck);
                TextView textView = (TextView) baseViewHolder.getView(R.id.tvName);
                ImageView imageView = (ImageView) baseViewHolder.getView(R.id.ivHead);
                TextView textView2 = (TextView) baseViewHolder.getView(R.id.tvDesc);
                textView.setText(ccListDTO.name);
                GlideUtil.loadRadiusHeadImage(SelectionLeaveDialog.this.context, ccListDTO.avatar, imageView, 5);
                if (ccListDTO.userInfo != null && ccListDTO.userInfo.size() > 0) {
                    textView2.setText(TeacherNameUtils.INSTANCE.getStringByList(ccListDTO.userInfo));
                } else {
                    textView2.setText("");
                }
                checkBox.setChecked(ccListDTO.isChecked);
            }
        };
        this.mList = new ArrayList();
        this.mReturnList = new ArrayList();
    }

    public SelectionLeaveDialog(Context context, List<ApproverListRsp.DataDTO.CcListDTO> list) {
        this(context, R.style.shareDialog);
        this.context = context;
        this.mList.clear();
        this.mList.addAll(list);
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.select_examine_dialog);
        setCanceledOnTouchOutside(false);
        getWindow().setType(2003);
        initView();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        if (this.mReturnList.isEmpty()) {
            for (int i = 0; i < this.mList.size(); i++) {
                this.mList.get(i).isChecked = false;
            }
            this.mAdapter.setList(this.mList);
            this.mAmount.setText("已选择: 0人");
            return;
        }
        for (int i2 = 0; i2 < this.mList.size(); i2++) {
            this.mList.get(i2).isChecked = false;
        }
        for (int i3 = 0; i3 < this.mReturnList.size(); i3++) {
            LeaveAdapterBean leaveAdapterBean = this.mReturnList.get(i3);
            for (int i4 = 0; i4 < this.mList.size(); i4++) {
                ApproverListRsp.DataDTO.CcListDTO ccListDTO = this.mList.get(i4);
                if (ccListDTO.userId.equals(leaveAdapterBean.userId)) {
                    ccListDTO.isChecked = true;
                }
            }
        }
        this.mAmount.setText("已选择: " + this.mReturnList.size() + "人");
        this.mAdapter.setList(this.mList);
    }

    private void initView() {
        this.mAmount = (TextView) findViewById(R.id.tv_amount);
        TextView textView = (TextView) findViewById(R.id.tv_title);
        TextView textView2 = (TextView) findViewById(R.id.tv_commit);
        TextView textView3 = (TextView) findViewById(R.id.tv_dismiss);
        textView.setText(this.title);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        this.mAmount.setText("已选择: 0人");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.dl_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(this.mAdapter);
        this.mAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.dialog.SelectionLeaveDialog.2
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public void onItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i) {
                ApproverListRsp.DataDTO.CcListDTO item = SelectionLeaveDialog.this.mAdapter.getItem(i);
                item.isChecked = !item.isChecked;
                if (!item.isChecked) {
                    for (int i2 = 0; i2 < SelectionLeaveDialog.this.mReturnList.size(); i2++) {
                        if (item.userId.equals(((LeaveAdapterBean) SelectionLeaveDialog.this.mReturnList.get(i2)).userId)) {
                            SelectionLeaveDialog.this.mReturnList.remove(i2);
                            break;
                        }
                    }
                } else {
                    LeaveAdapterBean leaveAdapterBean = new LeaveAdapterBean();
                    leaveAdapterBean.userId = item.userId;
                    leaveAdapterBean.name = item.name;
                    leaveAdapterBean.id = item.id;
                    leaveAdapterBean.avatar = item.avatar;
                    SelectionLeaveDialog.this.mReturnList.add(leaveAdapterBean);
                }
                SelectionLeaveDialog.this.mAmount.setText("已选择：" + SelectionLeaveDialog.this.mReturnList.size() + "人");
                baseQuickAdapter.notifyItemChanged(i);
            }
        });
    }

    public void setSelectList(List<LeaveAdapterBean> list) {
        this.mReturnList.clear();
        this.mReturnList.addAll(list);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.tv_commit) {
            if (id != R.id.tv_dismiss) {
                return;
            }
            this.mReturnList.clear();
            cancel();
            return;
        }
        SelectExAmineOnclickListener selectExAmineOnclickListener = this.mSelectExAmineOnclickListener;
        if (selectExAmineOnclickListener != null) {
            selectExAmineOnclickListener.ExamineListener(this.mReturnList);
        }
        this.mReturnList.clear();
        cancel();
    }

    public void setExamineListner(SelectExAmineOnclickListener selectExAmineOnclickListener) {
        this.mSelectExAmineOnclickListener = selectExAmineOnclickListener;
    }
}
