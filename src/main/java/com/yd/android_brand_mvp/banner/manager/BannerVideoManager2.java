package com.yd.android_brand_mvp.banner.manager;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.yd.android_brand_mvp.banner.adapter.MediaVideoBannerAdapter2;
import com.yd.android_brand_mvp.banner.holder.VideoHolder;
import com.yd.android_brand_mvp.model.VideoListBean;
import com.youth.banner.listener.OnPageChangeListener;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BannerVideoManager2 {
    private MediaVideoBannerAdapter2 adapter;
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
    private Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.banner.manager.BannerVideoManager2.1
        @Override // java.lang.Runnable
        public void run() {
            BannerVideoManager2.this.mHandler.removeCallbacks(BannerVideoManager2.this.runnable);
            BannerVideoManager2.this.banner.setCurrentItem(BannerVideoManager2.this.banner.getCurrentItem() + 1, true);
        }
    };

    public BannerVideoManager2(Context context, ChangeBanner changeBanner, MediaVideoBannerAdapter2 mediaVideoBannerAdapter2, List<VideoListBean.DataBean> list, int i) {
        this.context = context;
        this.banner = changeBanner;
        this.adapter = mediaVideoBannerAdapter2;
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
            BannerVideoManager2.this.mPosition = i;
            if (BannerVideoManager2.this.adapter != null) {
                BannerVideoManager2.this.currentVideoHolder = null;
                if (BannerVideoManager2.this.type != 2) {
                    BannerVideoManager2.this.adapter.stopVideo();
                    if (BannerVideoManager2.this.videoPlayRunnable != null) {
                        BannerVideoManager2.this.mHandler.removeCallbacks(BannerVideoManager2.this.videoPlayRunnable);
                    }
                    BannerVideoManager2 bannerVideoManager2 = BannerVideoManager2.this;
                    bannerVideoManager2.startScroll(bannerVideoManager2.mPageChangeMillis);
                    return;
                }
                if (BannerVideoManager2.this.list.size() == 1) {
                    BannerVideoManager2.this.playVideo(0L, i);
                } else {
                    BannerVideoManager2 bannerVideoManager3 = BannerVideoManager2.this;
                    bannerVideoManager3.playVideo(bannerVideoManager3.mVideoPlayLoadWait, i + 1);
                }
                BannerVideoManager2.this.stopScroll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo(long j, final int i) {
        Runnable runnable = this.videoPlayRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.yd.android_brand_mvp.banner.manager.BannerVideoManager2.2
            @Override // java.lang.Runnable
            public void run() {
                if (i != 1 || BannerVideoManager2.this.list.size() <= 1 || BannerVideoManager2.this.banner.getCurrentItem() == 1) {
                    final VideoHolder videoHolder = BannerVideoManager2.this.adapter.getVideoHolder(Integer.valueOf(i));
                    if (videoHolder == null) {
                        BannerVideoManager2.this.showToast("获取视频播放控件出错");
                        return;
                    }
                    videoHolder.player.onVideoReset();
                    videoHolder.player.startPlayLogic();
                    videoHolder.player.setVideoAllCallBack(new GSYSampleCallBack() { // from class: com.yd.android_brand_mvp.banner.manager.BannerVideoManager2.2.1
                        @Override // com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack, com.shuyu.gsyvideoplayer.listener.VideoAllCallBack
                        public void onAutoComplete(String str, Object... objArr) {
                            super.onAutoComplete(str, objArr);
                            if (i == 0) {
                                videoHolder.player.startPlayLogic();
                            } else {
                                BannerVideoManager2.this.startScroll(0L);
                            }
                        }
                    });
                    BannerVideoManager2.this.currentVideoHolder = videoHolder;
                    return;
                }
                BannerVideoManager2.this.banner.setCurrentItem(1, false);
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
        stopScroll();
        VideoHolder videoHolder = this.currentVideoHolder;
        if (videoHolder != null) {
            videoHolder.player.onVideoPause();
        }
        this.mHandler.removeCallbacks(this.videoPlayRunnable);
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

    public void onDetachedFromWindow() {
        stopScroll();
    }
}
