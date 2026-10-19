package com.yd.android_brand_mvp.banner.manager;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.Toast;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.yd.android_brand_mvp.banner.adapter.MediaVideoBannerAdapter;
import com.yd.android_brand_mvp.banner.holder.VideoHolder;
import com.yd.android_brand_mvp.model.VideoListBean;
import com.youth.banner.listener.OnPageChangeListener;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BannerVideoManager {
    private MediaVideoBannerAdapter adapter;
    private ChangeBanner banner;
    private Context context;
    private List<VideoListBean.DataBean> list;
    private int type;
    private Runnable videoPlayRunnable;
    private long mPageChangeMillis = 5000;
    private long mVideoPlayLoadWait = 500;
    private VideoHolder currentVideoHolder = null;
    private int mPosition = 0;
    private Handler mHandler = new Handler();
    private Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.banner.manager.BannerVideoManager.1
        @Override // java.lang.Runnable
        public void run() {
            BannerVideoManager.this.mHandler.removeCallbacks(BannerVideoManager.this.runnable);
            BannerVideoManager.this.banner.setCurrentItem(BannerVideoManager.this.banner.getCurrentItem() + 1, true);
        }
    };

    public void updateVoice(CheckBox checkBox) {
    }

    public BannerVideoManager(Context context, ChangeBanner changeBanner, MediaVideoBannerAdapter mediaVideoBannerAdapter, List<VideoListBean.DataBean> list, int i) {
        this.context = context;
        this.banner = changeBanner;
        this.adapter = mediaVideoBannerAdapter;
        this.list = list;
        this.type = i;
        changeBanner.addOnPageChangeListener(new BannerPageChange());
    }

    public void setPageChangeMillis(long j) {
        this.mPageChangeMillis = j;
    }

    public void setVideoPlayLoadWait(long j) {
        this.mVideoPlayLoadWait = j;
    }

    private class BannerPageChange implements OnPageChangeListener {
        @Override // com.youth.banner.listener.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // com.youth.banner.listener.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        private BannerPageChange() {
        }

        @Override // com.youth.banner.listener.OnPageChangeListener
        public void onPageSelected(int i) {
            BannerVideoManager.this.mPosition = i;
            if (BannerVideoManager.this.adapter != null) {
                BannerVideoManager.this.currentVideoHolder = null;
                if (BannerVideoManager.this.type != 2) {
                    BannerVideoManager.this.adapter.stopVideo();
                    if (BannerVideoManager.this.videoPlayRunnable != null) {
                        BannerVideoManager.this.mHandler.removeCallbacks(BannerVideoManager.this.videoPlayRunnable);
                    }
                    BannerVideoManager bannerVideoManager = BannerVideoManager.this;
                    bannerVideoManager.startScroll(bannerVideoManager.mPageChangeMillis);
                } else {
                    if (BannerVideoManager.this.list.size() == 1) {
                        Log.i("video", "自动重播");
                        BannerVideoManager.this.playVideo(0L, i);
                    } else {
                        Log.i("video", "播放下一个");
                        BannerVideoManager bannerVideoManager2 = BannerVideoManager.this;
                        bannerVideoManager2.playVideo(bannerVideoManager2.mVideoPlayLoadWait, i + 1);
                    }
                    BannerVideoManager.this.stopScroll();
                }
                BannerVideoManager.this.adapter.notifyDataSetChanged();
            }
        }
    }

    public void stopVideo() {
        Runnable runnable = this.videoPlayRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        VideoHolder videoHolder = this.currentVideoHolder;
        if (videoHolder != null) {
            videoHolder.player.onVideoReset();
            this.currentVideoHolder.player.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo(long j, final int i) {
        Runnable runnable = this.videoPlayRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.yd.android_brand_mvp.banner.manager.BannerVideoManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (i != 1 || BannerVideoManager.this.list.size() <= 1 || BannerVideoManager.this.banner.getCurrentItem() == 1) {
                    final VideoHolder videoHolder = BannerVideoManager.this.adapter.getVideoHolder(Integer.valueOf(i));
                    if (videoHolder == null) {
                        BannerVideoManager.this.showToast("获取视频播放控件出错");
                        return;
                    }
                    videoHolder.player.onVideoReset();
                    videoHolder.player.startPlayLogic();
                    videoHolder.player.setVideoAllCallBack(new GSYSampleCallBack() { // from class: com.yd.android_brand_mvp.banner.manager.BannerVideoManager.2.1
                        @Override // com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack, com.shuyu.gsyvideoplayer.listener.VideoAllCallBack
                        public void onAutoComplete(String str, Object... objArr) {
                            super.onAutoComplete(str, objArr);
                            if (i == 0) {
                                videoHolder.player.startPlayLogic();
                            } else {
                                BannerVideoManager.this.startScroll(0L);
                            }
                        }
                    });
                    videoHolder.player.onPause();
                    BannerVideoManager.this.currentVideoHolder = videoHolder;
                    return;
                }
                BannerVideoManager.this.banner.setCurrentItem(1, false);
            }
        };
        this.videoPlayRunnable = runnable2;
        this.mHandler.postDelayed(runnable2, j);
    }

    private void stopVideo(long j, final int i) {
        Runnable runnable = this.videoPlayRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.yd.android_brand_mvp.banner.manager.BannerVideoManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (i != 1 || BannerVideoManager.this.list.size() <= 1 || BannerVideoManager.this.banner.getCurrentItem() == 1) {
                    final VideoHolder videoHolder = BannerVideoManager.this.adapter.getVideoHolder(Integer.valueOf(i));
                    if (videoHolder == null) {
                        BannerVideoManager.this.showToast("获取视频播放控件出错");
                        return;
                    }
                    videoHolder.player.onVideoReset();
                    videoHolder.player.startPlayLogic();
                    videoHolder.player.setVideoAllCallBack(new GSYSampleCallBack() { // from class: com.yd.android_brand_mvp.banner.manager.BannerVideoManager.3.1
                        @Override // com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack, com.shuyu.gsyvideoplayer.listener.VideoAllCallBack
                        public void onAutoComplete(String str, Object... objArr) {
                            super.onAutoComplete(str, objArr);
                            if (i == 0) {
                                videoHolder.player.startPlayLogic();
                            } else {
                                BannerVideoManager.this.startScroll(0L);
                            }
                        }
                    });
                    videoHolder.player.onPause();
                    BannerVideoManager.this.mHandler.removeCallbacks(BannerVideoManager.this.videoPlayRunnable);
                    BannerVideoManager.this.currentVideoHolder = videoHolder;
                    return;
                }
                BannerVideoManager.this.banner.setCurrentItem(1, false);
            }
        };
        this.videoPlayRunnable = runnable2;
        this.mHandler.postDelayed(runnable2, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startScroll(long j) {
        this.mHandler.postDelayed(this.runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopScroll() {
        this.mHandler.removeCallbacks(this.runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast.makeText(this.context, str, 0).show();
    }

    public void onPause() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.banner.manager.BannerVideoManager.4
                @Override // java.lang.Runnable
                public void run() {
                    BannerVideoManager.this.stopScroll();
                    if (BannerVideoManager.this.currentVideoHolder != null) {
                        BannerVideoManager.this.currentVideoHolder.player.onVideoPause();
                    }
                }
            }, 1000L);
        }
        VideoHolder videoHolder = this.currentVideoHolder;
        if (videoHolder != null) {
            videoHolder.player.onPause();
        }
    }

    public void onResume() {
        List<VideoListBean.DataBean> list = this.list;
        if (list == null || list.size() == 0) {
            return;
        }
        if (this.type == 2) {
            VideoHolder videoHolder = this.currentVideoHolder;
            if (videoHolder != null) {
                videoHolder.player.onVideoResume();
                return;
            } else if (this.list.size() == 1) {
                playVideo(this.mVideoPlayLoadWait, this.mPosition);
                return;
            } else {
                playVideo(this.mVideoPlayLoadWait, this.mPosition + 1);
                return;
            }
        }
        startScroll(this.mPageChangeMillis);
    }

    public void onStop() {
        List<VideoListBean.DataBean> list = this.list;
        if (list == null || list.size() == 0) {
            return;
        }
        if (this.type == 2) {
            VideoHolder videoHolder = this.currentVideoHolder;
            if (videoHolder != null) {
                videoHolder.player.onVideoResume();
                return;
            } else if (this.list.size() == 1) {
                stopVideo(this.mVideoPlayLoadWait, this.mPosition);
                return;
            } else {
                stopVideo(this.mVideoPlayLoadWait, this.mPosition + 1);
                return;
            }
        }
        startScroll(this.mPageChangeMillis);
    }

    public void onDetachedFromWindow() {
        stopScroll();
    }
}
