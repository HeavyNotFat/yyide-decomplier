package com.yd.android_brand_mvp.banner.holder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.banner.manager.YDVideo;

/* JADX INFO: loaded from: classes4.dex */
public class VideoHolder extends RecyclerView.ViewHolder {
    public CheckBox check;
    public YDVideo player;
    public TextView tm;

    public VideoHolder(View view) {
        super(view);
        this.player = (YDVideo) view.findViewById(R.id.player);
        this.tm = (TextView) view.findViewById(R.id.tm);
        this.check = (CheckBox) view.findViewById(R.id.check);
    }
}
