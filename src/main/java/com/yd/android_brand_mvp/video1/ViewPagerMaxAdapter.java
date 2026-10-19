package com.yd.android_brand_mvp.video1;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.VideoListBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ViewPagerMaxAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "RecyclerBaseAdapter";
    private Context context;
    private boolean isTouchWiget;
    private List<VideoListBean.DataBean> itemDataList;
    private OnVideoPlay onVideoPlay;
    private int type = 0;
    private Map<Integer, ItemNormalHolder> videoHolderMap = new HashMap();

    public interface OnVideoPlay {
        void onBottomState(int i);

        void onPlay(int i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return 1;
    }

    public ViewPagerMaxAdapter(Context context, List<VideoListBean.DataBean> list, OnVideoPlay onVideoPlay, boolean z) {
        this.itemDataList = null;
        this.context = null;
        this.isTouchWiget = false;
        this.itemDataList = list;
        this.context = context;
        this.onVideoPlay = onVideoPlay;
        this.isTouchWiget = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ItemNormalHolder(this.context, LayoutInflater.from(this.context).inflate(R.layout.layout_viewpager2_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        ItemNormalHolder itemNormalHolder = (ItemNormalHolder) viewHolder;
        itemNormalHolder.setIsTouchWiget(this.isTouchWiget);
        itemNormalHolder.setRecyclerBaseAdapter(this);
        itemNormalHolder.setType(this.type);
        itemNormalHolder.onBind(i, this.itemDataList.get(i));
        this.videoHolderMap.put(Integer.valueOf(i), itemNormalHolder);
        Log.i("palyadapter", "startPlayLogic" + i);
        itemNormalHolder.gsyVideoPlayer.setOnPlayState(new OnPlayState() { // from class: com.yd.android_brand_mvp.video1.ViewPagerMaxAdapter.1
            @Override // com.yd.android_brand_mvp.video1.OnPlayState
            public void complete() {
                ViewPagerMaxAdapter.this.itemDataList.size();
                int size = ViewPagerMaxAdapter.this.itemDataList.size();
                int i2 = i;
                ViewPagerMaxAdapter.this.onVideoPlay.onPlay(size == i2 + 1 ? 0 : i2 + 1);
            }

            @Override // com.yd.android_brand_mvp.video1.OnPlayState
            public void bottemState(int i2) {
                ViewPagerMaxAdapter.this.onVideoPlay.onBottomState(i2);
            }
        });
        itemNormalHolder.gsyVideoPlayer.setBottonState(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemDataList.size();
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setListData(List<VideoListBean.DataBean> list) {
        this.itemDataList = list;
        notifyDataSetChanged();
    }

    public ItemNormalHolder getVideoHolder(Integer num) {
        return this.videoHolderMap.get(num);
    }

    public void playVideo(long j, final int i) {
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.video1.ViewPagerMaxAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                ItemNormalHolder videoHolder = ViewPagerMaxAdapter.this.getVideoHolder(Integer.valueOf(i));
                if (videoHolder == null) {
                    ViewPagerMaxAdapter.this.showToast("获取视频播放控件出错");
                } else {
                    videoHolder.gsyVideoPlayer.onVideoReset();
                    videoHolder.gsyVideoPlayer.startPlayLogic();
                }
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast.makeText(this.context, str, 0).show();
    }
}
