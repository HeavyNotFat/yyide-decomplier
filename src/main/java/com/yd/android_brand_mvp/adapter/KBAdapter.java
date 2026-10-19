package com.yd.android_brand_mvp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.StringUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.KBRsp;
import com.yd.android_brand_mvp.utils.TimeUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class KBAdapter extends BaseAdapter {
    String checkId;
    private Context context;
    List<KBRsp.DataDTO.ListDTO> list;
    int maxDay;
    int nextIndex;
    int timetableType;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public KBAdapter() {
        this.list = new ArrayList();
        this.nextIndex = 0;
        this.timetableType = 1;
        this.maxDay = 5;
        this.checkId = "-1";
    }

    public KBAdapter(Context context, int i) {
        this.list = new ArrayList();
        this.nextIndex = 0;
        this.timetableType = 1;
        this.maxDay = 5;
        this.checkId = "-1";
        this.context = context;
        this.maxDay = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public KBRsp.DataDTO.ListDTO getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        String strStampToDate7;
        View viewInflate = View.inflate(this.context, R.layout.item_class_schedule, null);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        KBRsp.DataDTO.ListDTO item = getItem(i);
        viewHolder.tvChannel.setText(item.kcmc);
        StringUtils.isEmpty(item.kcmc);
        if (item.skxq == TimeUtil.getIntWeekDay(System.currentTimeMillis())) {
            if (i == 0) {
                strStampToDate7 = TimeUtil.stampToDate7(TimeUtil.gettime55(item.kssj) + 5000);
            } else {
                strStampToDate7 = item.kssj;
            }
            Log.i("isBelong", "skxq:" + item.skxq + " KBName:" + item.kcmc + " start: " + strStampToDate7 + " end:" + item.jssj);
            if (TimeUtil.isBelong(strStampToDate7, item.jssj)) {
                viewHolder.llLab.setBackgroundColor(Color.parseColor("#E9E6FD"));
                viewHolder.tvChannel.setTextColor(Color.parseColor("#6747D3"));
                this.nextIndex = i;
            } else {
                viewHolder.tvChannel.setTextColor(Color.parseColor("#303133"));
                viewHolder.llLab.setBackgroundColor(-1);
            }
        }
        return viewInflate;
    }

    class ViewHolder {
        protected ImageView ivImg;
        protected LinearLayout llLab;
        protected TextView tvChannel;

        public ViewHolder(View view) {
            this.tvChannel = (TextView) view.findViewById(R.id.tv_name);
            this.llLab = (LinearLayout) view.findViewById(R.id.ll_lab);
            this.ivImg = (ImageView) view.findViewById(R.id.iv_img);
        }
    }

    public void settimetableType(int i) {
        this.timetableType = i;
        notifyDataSetChanged();
    }

    public void notifyData(List<KBRsp.DataDTO.ListDTO> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
