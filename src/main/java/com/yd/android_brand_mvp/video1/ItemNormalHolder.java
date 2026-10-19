package com.yd.android_brand_mvp.video1;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.VideoListBean;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class ItemNormalHolder extends RecyclerItemBaseHolder {
    public static final String TAG = "RecyclerView2List";
    protected Context context;
    GSYVideoOptionBuilder gsyVideoOptionBuilder;
    public SampleCoverVideo gsyVideoPlayer;
    ImageView imageView;
    private boolean isTouchWiget;
    private int mPosition;
    int type;
    String url;

    public ItemNormalHolder(Context context, View view) {
        super(view);
        this.context = null;
        this.type = 0;
        this.mPosition = 0;
        this.context = context;
        this.gsyVideoPlayer = (SampleCoverVideo) view.findViewById(R.id.video_item_player);
        this.imageView = new ImageView(context);
        this.gsyVideoOptionBuilder = new GSYVideoOptionBuilder();
    }

    public void onBind(int i, VideoListBean.DataBean dataBean) {
        this.url = dataBean.url;
        HashMap map = new HashMap();
        map.put("ee", "33");
        this.gsyVideoOptionBuilder.setIsTouchWiget(this.isTouchWiget).setIsTouchWigetFull(this.isTouchWiget).setUrl(this.url).setVideoTitle("").setCacheWithPlay(true).setRotateViewAuto(false).setLockLand(false).setPlayTag("RecyclerView2List").setNeedShowWifiTip(false).setReleaseWhenLossAudio(false).setMapHeadData(map).setShowFullAnimation(true).setRotateWithSystem(true).setNeedLockFull(true).setNeedOrientationUtils(false).setPlayPosition(i).setVideoAllCallBack(new GSYSampleCallBack() { // from class: com.yd.android_brand_mvp.video1.ItemNormalHolder.1
            @Override // com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack, com.shuyu.gsyvideoplayer.listener.VideoAllCallBack
            public void onPrepared(String str, Object... objArr) {
                super.onPrepared(str, objArr);
                if (ItemNormalHolder.this.gsyVideoPlayer.isIfCurrentIsFullscreen()) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("-onPrepared--静音-");
                sb.append(ItemNormalHolder.this.type == 0);
                Log.i("videos", sb.toString());
                GSYVideoManager.instance().setNeedMute(ItemNormalHolder.this.type == 0);
            }

            @Override // com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack, com.shuyu.gsyvideoplayer.listener.VideoAllCallBack
            public void onQuitFullscreen(String str, Object... objArr) {
                super.onQuitFullscreen(str, objArr);
                GSYVideoManager.instance().setNeedMute(false);
                Log.i("videos", "-onQuitFullscreen--不静音-");
            }

            @Override // com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack, com.shuyu.gsyvideoplayer.listener.VideoAllCallBack
            public void onEnterFullscreen(String str, Object... objArr) {
                super.onEnterFullscreen(str, objArr);
                GSYVideoManager.instance().setNeedMute(false);
                Log.i("videos", "-onEnterFullscreen--不静音-");
                ItemNormalHolder.this.gsyVideoPlayer.getCurrentPlayer().getTitleTextView().setText((String) objArr[0]);
            }
        }).build((StandardGSYVideoPlayer) this.gsyVideoPlayer);
        this.gsyVideoPlayer.getTitleTextView().setVisibility(8);
        this.gsyVideoPlayer.getBackButton().setVisibility(8);
    }

    private void resolveFullBtn(StandardGSYVideoPlayer standardGSYVideoPlayer) {
        standardGSYVideoPlayer.startWindowFullscreen(this.context, true, true);
    }

    public SampleCoverVideo getPlayer() {
        return this.gsyVideoPlayer;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setIsTouchWiget(boolean z) {
        this.isTouchWiget = z;
    }
}
