package com.yd.android_brand_mvp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.ScreenUtils;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.TimelistRsp;
import com.yd.android_brand_mvp.utils.VHUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AnnounAdapter6 extends LoopPagerAdapter {
    Activity context;
    public List<TimelistRsp.DataBean> list;

    public AnnounAdapter6(RollPagerView rollPagerView) {
        super(rollPagerView);
        this.list = new ArrayList();
    }

    public AnnounAdapter6(RollPagerView rollPagerView, Activity activity) {
        super(rollPagerView);
        this.list = new ArrayList();
        this.context = activity;
    }

    private TimelistRsp.DataBean getItem(int i) {
        return this.list.get(i);
    }

    @Override // com.jude.rollviewpager.adapter.LoopPagerAdapter
    public View getView(ViewGroup viewGroup, int i) {
        View viewInflate;
        if (ScreenUtils.isLandscape()) {
            viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_timer_item, (ViewGroup) null);
        } else {
            viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_timer_item_p, (ViewGroup) null);
        }
        TextView textView = (TextView) VHUtil.ViewHolder.get(viewInflate, R.id.tv_content);
        TextView textView2 = (TextView) VHUtil.ViewHolder.get(viewInflate, R.id.tv_num);
        ImageView imageView = (ImageView) VHUtil.ViewHolder.get(viewInflate, R.id.iv_img);
        textView.setText("距离" + getItem(i).activityTheme);
        textView2.setText(getItem(i).countDown + "");
        if ("1".equals(this.list.get(i).templateUrl)) {
            imageView.setBackgroundResource(R.drawable.icon_timer_bg1);
        } else if ("2".equals(this.list.get(i).templateUrl)) {
            imageView.setBackgroundResource(R.drawable.icon_timer_bg2);
        } else if ("3".equals(this.list.get(i).templateUrl)) {
            imageView.setBackgroundResource(R.drawable.icon_timer_bg3);
        }
        return viewInflate;
    }

    @Override // com.jude.rollviewpager.adapter.LoopPagerAdapter
    public int getRealCount() {
        return this.list.size();
    }

    public void notifyData(List<TimelistRsp.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
