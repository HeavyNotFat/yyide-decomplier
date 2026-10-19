package com.yd.android_brand_mvp.landscape.video;

import android.content.Context;
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
public class RecyclerItemNormalHolder extends RecyclerItemBaseHolder {
    public static final String TAG = "RecyclerView2List";
    protected Context context;
    GSYVideoOptionBuilder gsyVideoOptionBuilder;
    SampleCoverVideo gsyVideoPlayer;
    ImageView imageView;
    private boolean isMusic;

    public RecyclerItemNormalHolder(Context context, View view, boolean z) {
        super(view);
        this.isMusic = false;
        this.context = context;
        this.gsyVideoPlayer = (SampleCoverVideo) view.findViewById(R.id.video_item_player);
        this.imageView = new ImageView(context);
        this.gsyVideoOptionBuilder = new GSYVideoOptionBuilder();
        this.isMusic = z;
    }

    public void onBind(int i, VideoListBean.DataBean dataBean) {
        HashMap map = new HashMap();
        map.put("ee", "33");
        this.gsyVideoOptionBuilder.setIsTouchWiget(false).setIsTouchWigetFull(false).setUrl(dataBean.url).setHideKey(false).setVideoTitle("").setNeedOrientationUtils(false).setCacheWithPlay(true).setRotateViewAuto(false).setNeedShowWifiTip(false).setLockLand(true).setPlayTag("RecyclerView2List").setMapHeadData(map).setShowFullAnimation(true).setNeedLockFull(true).setPlayPosition(i).setVideoAllCallBack(new GSYSampleCallBack() { // from class: com.yd.android_brand_mvp.landscape.video.RecyclerItemNormalHolder.1
            @Override // com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack, com.shuyu.gsyvideoplayer.listener.VideoAllCallBack
            public void onPrepared(String str, Object... objArr) {
                super.onPrepared(str, objArr);
                GSYVideoManager.instance().setNeedMute(RecyclerItemNormalHolder.this.isMusic);
            }

            @Override // com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack, com.shuyu.gsyvideoplayer.listener.VideoAllCallBack
            public void onQuitFullscreen(String str, Object... objArr) {
                super.onQuitFullscreen(str, objArr);
                GSYVideoManager.instance().setNeedMute(RecyclerItemNormalHolder.this.isMusic);
            }

            @Override // com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack, com.shuyu.gsyvideoplayer.listener.VideoAllCallBack
            public void onEnterFullscreen(String str, Object... objArr) {
                super.onEnterFullscreen(str, objArr);
                GSYVideoManager.instance().setNeedMute(false);
                RecyclerItemNormalHolder.this.gsyVideoPlayer.getCurrentPlayer().getTitleTextView().setText((String) objArr[0]);
            }
        }).build((StandardGSYVideoPlayer) this.gsyVideoPlayer);
        this.gsyVideoPlayer.getTitleTextView().setVisibility(8);
        this.gsyVideoPlayer.getBackButton().setVisibility(8);
        this.gsyVideoPlayer.getFullscreenButton().setVisibility(this.isMusic ? 8 : 0);
        this.gsyVideoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.video.-$$Lambda$RecyclerItemNormalHolder$AHcHcQBTAgJ8Q49aV8SgCQSNNEI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBind$0$RecyclerItemNormalHolder(view);
            }
        });
    }

    public /* synthetic */ void lambda$onBind$0$RecyclerItemNormalHolder(View view) {
        resolveFullBtn(this.gsyVideoPlayer);
    }

    private void resolveFullBtn(StandardGSYVideoPlayer standardGSYVideoPlayer) {
        standardGSYVideoPlayer.startWindowFullscreen(this.context, false, false);
    }

    public SampleCoverVideo getPlayer() {
        return this.gsyVideoPlayer;
    }
}
