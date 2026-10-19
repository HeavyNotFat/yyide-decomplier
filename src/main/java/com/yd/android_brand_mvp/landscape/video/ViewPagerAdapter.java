package com.yd.android_brand_mvp.landscape.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.VideoListBean;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ViewPagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "RecyclerBaseAdapter";
    private Context context;
    private boolean isMusic;
    private List<VideoListBean.DataBean> itemDataList;
    private OnNext onVideoPlay;

    public interface OnNext {
        void next(int i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return 1;
    }

    public ViewPagerAdapter(Context context, List<VideoListBean.DataBean> list, boolean z) {
        this.itemDataList = null;
        this.context = null;
        this.isMusic = false;
        this.itemDataList = list;
        this.context = context;
        this.isMusic = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new RecyclerItemNormalHolder(this.context, LayoutInflater.from(this.context).inflate(R.layout.layout_viewpager2_video, viewGroup, false), this.isMusic);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        RecyclerItemNormalHolder recyclerItemNormalHolder = (RecyclerItemNormalHolder) viewHolder;
        recyclerItemNormalHolder.setRecyclerBaseAdapter(this);
        recyclerItemNormalHolder.onBind(i, this.itemDataList.get(i));
        recyclerItemNormalHolder.getPlayer().setOnPlayState(new SampleCoverVideo.OnPlayState() { // from class: com.yd.android_brand_mvp.landscape.video.ViewPagerAdapter.1
            @Override // com.yd.android_brand_mvp.landscape.video.SampleCoverVideo.OnPlayState
            public void playError() {
            }

            @Override // com.yd.android_brand_mvp.landscape.video.SampleCoverVideo.OnPlayState
            public void playing() {
            }

            @Override // com.yd.android_brand_mvp.landscape.video.SampleCoverVideo.OnPlayState
            public void complete() {
                ViewPagerAdapter.this.itemDataList.size();
                int size = ViewPagerAdapter.this.itemDataList.size();
                int i2 = i;
                ViewPagerAdapter.this.onVideoPlay.next(size == i2 + 1 ? 0 : i2 + 1);
            }
        });
    }

    public void setOnNext(OnNext onNext) {
        this.onVideoPlay = onNext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<VideoListBean.DataBean> list = this.itemDataList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void setListData(List<VideoListBean.DataBean> list) {
        this.itemDataList = list;
        notifyDataSetChanged();
    }
}
