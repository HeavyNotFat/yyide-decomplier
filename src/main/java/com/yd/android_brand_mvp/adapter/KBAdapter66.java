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
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.StringUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.KBRsp;
import com.yd.android_brand_mvp.utils.TimeUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class KBAdapter66 extends BaseAdapter {
    private Context context;
    int maxDay;
    List<KBRsp.DataDTO.ListDTO> list = new ArrayList();
    int nextIndex = 0;
    int timetableType = 1;
    String checkId = "-1";
    int week = TimeUtil.getIntWeek(System.currentTimeMillis());

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public KBAdapter66(Context context, int i) {
        this.maxDay = 5;
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
        View viewInflate;
        String strStampToDate7;
        if (ScreenUtils.isLandscape()) {
            viewInflate = View.inflate(this.context, R.layout.item_class_schedule66, null);
        } else {
            viewInflate = View.inflate(this.context, R.layout.item_class_schedule66p, null);
        }
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        KBRsp.DataDTO.ListDTO item = getItem(i);
        viewHolder.tvChannel.setText(item.kcmc);
        viewHolder.tvSName.setText(item.jzgmc);
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
                viewHolder.tvSName.setTextColor(Color.parseColor("#6747D3"));
                this.nextIndex = i;
            } else {
                viewHolder.tvChannel.setTextColor(Color.parseColor("#303133"));
                viewHolder.tvSName.setTextColor(Color.parseColor("#A4A4A4"));
                viewHolder.llLab.setBackgroundColor(-1);
            }
        }
        return viewInflate;
    }

    class ViewHolder {
        protected ImageView ivImg;
        protected LinearLayout llLab;
        protected TextView tvChannel;
        protected TextView tvSName;

        public ViewHolder(View view) {
            this.tvChannel = (TextView) view.findViewById(R.id.tv_name);
            this.tvSName = (TextView) view.findViewById(R.id.tv_s_name);
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
