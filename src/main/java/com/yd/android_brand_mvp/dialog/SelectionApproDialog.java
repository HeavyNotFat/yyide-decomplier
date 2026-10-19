package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
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
public class SelectionApproDialog extends BaseDialog implements View.OnClickListener {
    private Context context;
    private String id;
    private BaseQuickAdapter mAdapter;
    private List<ApproverListRsp.DataDTO.ApproverDTO.BranapprListDTO> mAppList;
    private List<ApproverListRsp.DataDTO.CcListDTO> mList;
    List<LeaveAdapterBean> mReturnList;
    SelectApproOnclickListener mSelectApproOnclickListener;
    private String title;

    public interface SelectApproOnclickListener {
        void ApproListener(List<LeaveAdapterBean> list);
    }

    public SelectionApproDialog(Context context, int i) {
        super(context, i);
        this.title = "请选择审批人";
        this.id = "";
        this.mList = new ArrayList();
        this.mAppList = new ArrayList();
        this.mReturnList = new ArrayList();
    }

    public SelectionApproDialog(Context context, List<ApproverListRsp.DataDTO.ApproverDTO.BranapprListDTO> list) {
        this(context, R.style.shareDialog);
        this.context = context;
        this.mAppList = list;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.select_examine_dialog);
        setCanceledOnTouchOutside(false);
        getWindow().setType(2003);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        initView();
    }

    private void initView() {
        TextView textView = (TextView) findViewById(R.id.tv_amount);
        TextView textView2 = (TextView) findViewById(R.id.tv_title);
        TextView textView3 = (TextView) findViewById(R.id.tv_commit);
        TextView textView4 = (TextView) findViewById(R.id.tv_dismiss);
        textView2.setText(this.title);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.dl_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        textView.setText("已选择：1人");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(R.layout.item_select_examine, textView);
        this.mAdapter = anonymousClass1;
        recyclerView.setAdapter(anonymousClass1);
        this.mAdapter.setList(this.mAppList);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.dialog.SelectionApproDialog$1, reason: invalid class name */
    class AnonymousClass1 extends BaseQuickAdapter<ApproverListRsp.DataDTO.ApproverDTO.BranapprListDTO, BaseViewHolder> {
        final /* synthetic */ TextView val$mAmount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, TextView textView) {
            super(i);
            this.val$mAmount = textView;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(BaseViewHolder baseViewHolder, final ApproverListRsp.DataDTO.ApproverDTO.BranapprListDTO branapprListDTO) {
            SelectionApproDialog.this.findViewById(R.id.ivHead);
            final CheckBox checkBox = (CheckBox) baseViewHolder.getView(R.id.cbCheck);
            TextView textView = (TextView) baseViewHolder.getView(R.id.tvName);
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.ivHead);
            ConstraintLayout constraintLayout = (ConstraintLayout) baseViewHolder.getView(R.id.app_itemview);
            TextView textView2 = (TextView) baseViewHolder.getView(R.id.tvDesc);
            textView.setText(branapprListDTO.name);
            GlideUtil.loadRadiusHeadImage(SelectionApproDialog.this.context, branapprListDTO.avatar, imageView, 5);
            if (branapprListDTO.userInfo != null && branapprListDTO.userInfo.size() > 0) {
                textView2.setText(TeacherNameUtils.INSTANCE.getStringByList(branapprListDTO.userInfo));
            }
            if (SelectionApproDialog.this.id.equals(branapprListDTO.approverId)) {
                branapprListDTO.isChecked = true;
            } else {
                branapprListDTO.isChecked = false;
            }
            if (branapprListDTO.isChecked) {
                checkBox.setChecked(true);
            } else {
                checkBox.setChecked(false);
            }
            final TextView textView3 = this.val$mAmount;
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.-$$Lambda$SelectionApproDialog$1$TEFm5FGN-pDfytIo7VJBx2_pU1M
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$convert$0$SelectionApproDialog$1(checkBox, branapprListDTO, textView3, view);
                }
            });
        }

        public /* synthetic */ void lambda$convert$0$SelectionApproDialog$1(CheckBox checkBox, ApproverListRsp.DataDTO.ApproverDTO.BranapprListDTO branapprListDTO, TextView textView, View view) {
            SelectionApproDialog.this.mReturnList.clear();
            if (checkBox.isChecked()) {
                branapprListDTO.isChecked = false;
            } else {
                branapprListDTO.isChecked = true;
            }
            if (!branapprListDTO.approverId.equals(SelectionApproDialog.this.id)) {
                SelectionApproDialog.this.id = branapprListDTO.approverId;
                LeaveAdapterBean leaveAdapterBean = new LeaveAdapterBean();
                leaveAdapterBean.userId = branapprListDTO.userId;
                leaveAdapterBean.name = branapprListDTO.name;
                leaveAdapterBean.approverId = branapprListDTO.approverId;
                leaveAdapterBean.avatar = branapprListDTO.avatar;
                SelectionApproDialog.this.mReturnList.add(leaveAdapterBean);
                branapprListDTO.isChecked = true;
                notifyDataSetChanged();
            }
            textView.setText("已选择：" + SelectionApproDialog.this.mReturnList.size() + "人");
        }
    }

    public void setSelectList(String str) {
        this.id = str;
        Log.e(this.TAG, "setSelectList" + str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.tv_commit) {
            if (id != R.id.tv_dismiss) {
                return;
            }
            cancel();
        } else {
            if (this.mSelectApproOnclickListener != null && this.mReturnList.size() > 0) {
                this.mSelectApproOnclickListener.ApproListener(this.mReturnList);
            }
            cancel();
        }
    }

    public void setApproListner(SelectApproOnclickListener selectApproOnclickListener) {
        this.mSelectApproOnclickListener = selectApproOnclickListener;
    }
}
