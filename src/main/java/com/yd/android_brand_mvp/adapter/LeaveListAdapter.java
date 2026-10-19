package com.yd.android_brand_mvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.GetAskLeaveRecordBandRsp;
import com.yd.android_brand_mvp.utils.VHUtil;
import java.util.ArrayList;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class LeaveListAdapter extends BaseAdapter {
    public List<GetAskLeaveRecordBandRsp.RecordBean> list = new ArrayList();
    private LeaveAdapterClickListener mLeaveAdapterClickListener;

    public interface LeaveAdapterClickListener {
        void addAdapterClickListener(String str);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public GetAskLeaveRecordBandRsp.RecordBean getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_leave_item, (ViewGroup) null, false);
        }
        TextView textView = (TextView) VHUtil.ViewHolder.get(view, R.id.reason);
        LinearLayout linearLayout = (LinearLayout) VHUtil.ViewHolder.get(view, R.id.item_layout);
        TextView textView2 = (TextView) VHUtil.ViewHolder.get(view, R.id.time);
        TextView textView3 = (TextView) VHUtil.ViewHolder.get(view, R.id.type);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.adapter.LeaveListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (LeaveListAdapter.this.mLeaveAdapterClickListener != null) {
                    LeaveListAdapter.this.mLeaveAdapterClickListener.addAdapterClickListener(LeaveListAdapter.this.getItem(i).id);
                }
            }
        });
        textView.setText(getItem(i).title);
        textView2.setText(getItem(i).createTime);
        int i2 = getItem(i).status;
        if (i2 == 0) {
            textView3.setText("已拒绝");
            textView3.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape_0);
        } else if (i2 == 1) {
            textView3.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape_1);
            textView3.setText("审批中");
        } else if (i2 == 2) {
            textView3.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape_2);
            textView3.setText("已通过");
        } else if (i2 == 3) {
            textView3.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black3));
            textView3.setBackgroundResource(R.drawable.ask_for_leave_status_pass_shape);
            textView3.setText("已撤销");
        }
        return view;
    }

    public void notifyData(List<GetAskLeaveRecordBandRsp.RecordBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addOnClick(LeaveAdapterClickListener leaveAdapterClickListener) {
        this.mLeaveAdapterClickListener = leaveAdapterClickListener;
    }
}
