package com.yd.android_brand_mvp.landscape.video;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.shuyu.gsyvideoplayer.cache.CacheFactory;
import com.shuyu.gsyvideoplayer.cache.ProxyCacheManager;
import com.shuyu.gsyvideoplayer.player.IjkPlayerManager;
import com.shuyu.gsyvideoplayer.player.PlayerFactory;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import com.yd.android_brand_mvp.R;
import moe.codeest.enviews.ENPlayView;
import tv.danmaku.ijk.media.exo2.ExoPlayerCacheManager;

/* JADX INFO: loaded from: classes4.dex */
public class SampleCoverVideo extends StandardGSYVideoPlayer {
    protected boolean byStartedClick;
    ImageView mCoverImage;
    int mCoverOriginId;
    String mCoverOriginUrl;
    int mDefaultRes;
    private OnPlayState onPlayState;

    public interface OnPlayState {
        void complete();

        void playError();

        void playing();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public int getLayoutId() {
        return R.layout.video_layout_cover;
    }

    public SampleCoverVideo(Context context, Boolean bool) {
        super(context, bool);
        this.mCoverOriginId = 0;
    }

    public SampleCoverVideo(Context context) {
        super(context);
        this.mCoverOriginId = 0;
    }

    public SampleCoverVideo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCoverOriginId = 0;
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView, com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    protected void init(Context context) {
        super.init(context);
        this.mCoverImage = (ImageView) findViewById(R.id.thumbImage);
        if (this.mThumbImageViewLayout != null && (this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 7)) {
            this.mThumbImageViewLayout.setVisibility(0);
        }
        PlayerFactory.setPlayManager(IjkPlayerManager.class);
        CacheFactory.setCacheManager(ExoPlayerCacheManager.class);
        ProxyCacheManager.DEFAULT_MAX_SIZE = 2097152000L;
        CacheFactory.setCacheManager(ProxyCacheManager.class);
    }

    public void loadCoverImage(String str, int i) {
        this.mCoverOriginUrl = str;
        this.mDefaultRes = i;
        Glide.with(getContext().getApplicationContext()).setDefaultRequestOptions(new RequestOptions().frame(1000000L).centerCrop().error(i).placeholder(i)).load(str).into(this.mCoverImage);
    }

    public void loadCoverImageBy(int i, int i2) {
        this.mCoverOriginId = i;
        this.mDefaultRes = i2;
        this.mCoverImage.setImageResource(i);
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer
    public GSYBaseVideoPlayer startWindowFullscreen(Context context, boolean z, boolean z2) {
        GSYBaseVideoPlayer gSYBaseVideoPlayerStartWindowFullscreen = super.startWindowFullscreen(context, z, z2);
        SampleCoverVideo sampleCoverVideo = (SampleCoverVideo) gSYBaseVideoPlayerStartWindowFullscreen;
        String str = this.mCoverOriginUrl;
        if (str != null) {
            sampleCoverVideo.loadCoverImage(str, this.mDefaultRes);
        } else {
            int i = this.mCoverOriginId;
            if (i != 0) {
                sampleCoverVideo.loadCoverImageBy(i, this.mDefaultRes);
            }
        }
        return gSYBaseVideoPlayerStartWindowFullscreen;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer
    public GSYBaseVideoPlayer showSmallVideo(Point point, boolean z, boolean z2) {
        SampleCoverVideo sampleCoverVideo = (SampleCoverVideo) super.showSmallVideo(point, z, z2);
        sampleCoverVideo.mStartButton.setVisibility(8);
        sampleCoverVideo.mStartButton = null;
        return sampleCoverVideo;
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer
    protected void cloneParams(GSYBaseVideoPlayer gSYBaseVideoPlayer, GSYBaseVideoPlayer gSYBaseVideoPlayer2) {
        super.cloneParams(gSYBaseVideoPlayer, gSYBaseVideoPlayer2);
        ((SampleCoverVideo) gSYBaseVideoPlayer2).mShowFullAnimation = ((SampleCoverVideo) gSYBaseVideoPlayer).mShowFullAnimation;
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer
    protected void updateStartImage() {
        if (this.mStartButton instanceof ENPlayView) {
            ENPlayView eNPlayView = (ENPlayView) this.mStartButton;
            eNPlayView.setDuration(500);
            if (this.mCurrentState == 2) {
                eNPlayView.play();
                return;
            } else if (this.mCurrentState == 7) {
                eNPlayView.pause();
                return;
            } else {
                eNPlayView.pause();
                return;
            }
        }
        if (this.mStartButton instanceof ImageView) {
            ImageView imageView = (ImageView) this.mStartButton;
            if (this.mCurrentState == 2) {
                imageView.setImageResource(R.drawable.video_click_pause);
            } else if (this.mCurrentState == 7) {
                imageView.setImageResource(R.drawable.video_click_error_selector);
            } else {
                imageView.setImageResource(R.drawable.video_click_play);
            }
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer
    protected void clearFullscreenLayout() {
        int iBackToProtVideo;
        if (this.mFullAnimEnd) {
            this.mIfCurrentIsFullscreen = false;
            if (this.mOrientationUtils != null) {
                iBackToProtVideo = this.mOrientationUtils.backToProtVideo();
                this.mOrientationUtils.setEnable(false);
                if (this.mOrientationUtils != null) {
                    this.mOrientationUtils.releaseListener();
                    this.mOrientationUtils = null;
                }
            } else {
                iBackToProtVideo = 0;
            }
            if (!this.mShowFullAnimation) {
                iBackToProtVideo = 0;
            }
            View viewFindViewById = ((ViewGroup) CommonUtil.scanForActivity(getContext()).findViewById(android.R.id.content)).findViewById(getFullId());
            if (viewFindViewById != null) {
                ((SampleCoverVideo) viewFindViewById).mIfCurrentIsFullscreen = false;
            }
            if (iBackToProtVideo == 0) {
                backToNormal();
            } else {
                postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.video.SampleCoverVideo.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SampleCoverVideo.this.backToNormal();
                    }
                }, iBackToProtVideo);
            }
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYTextureRenderView, com.shuyu.gsyvideoplayer.render.view.listener.IGSYSurfaceListener
    public void onSurfaceUpdated(Surface surface) {
        super.onSurfaceUpdated(surface);
        if (this.mThumbImageViewLayout == null || this.mThumbImageViewLayout.getVisibility() != 0) {
            return;
        }
        this.mThumbImageViewLayout.setVisibility(4);
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    protected void setViewShowState(View view, int i) {
        if (view != this.mThumbImageViewLayout || i == 0) {
            super.setViewShowState(view, i);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYTextureRenderView, com.shuyu.gsyvideoplayer.render.view.listener.IGSYSurfaceListener
    public void onSurfaceAvailable(Surface surface) {
        super.onSurfaceAvailable(surface);
        if (GSYVideoType.getRenderType() == 0 || this.mThumbImageViewLayout == null || this.mThumbImageViewLayout.getVisibility() != 0) {
            return;
        }
        this.mThumbImageViewLayout.setVisibility(4);
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    protected void onClickUiToggle(MotionEvent motionEvent) {
        if (this.mIfCurrentIsFullscreen && this.mLockCurScreen && this.mNeedLockFull) {
            setViewShowState(this.mLockScreen, 0);
        } else {
            this.byStartedClick = true;
            super.onClickUiToggle(motionEvent);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    protected void changeUiToNormal() {
        super.changeUiToNormal();
        this.byStartedClick = false;
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    protected void changeUiToPreparingShow() {
        super.changeUiToPreparingShow();
        Debuger.printfLog("Sample changeUiToPreparingShow");
        setViewShowState(this.mBottomContainer, 4);
        setViewShowState(this.mStartButton, 4);
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    protected void changeUiToPlayingBufferingShow() {
        super.changeUiToPlayingBufferingShow();
        Debuger.printfLog("Sample changeUiToPlayingBufferingShow");
        if (this.byStartedClick) {
            return;
        }
        setViewShowState(this.mBottomContainer, 4);
        setViewShowState(this.mStartButton, 4);
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    protected void changeUiToPlayingShow() {
        super.changeUiToPlayingShow();
        Debuger.printfLog("Sample changeUiToPlayingShow");
        if (this.byStartedClick) {
            return;
        }
        setViewShowState(this.mBottomContainer, 4);
        setViewShowState(this.mStartButton, 4);
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public void startAfterPrepared() {
        super.startAfterPrepared();
        Debuger.printfLog("Sample startAfterPrepared");
        setViewShowState(this.mBottomContainer, 4);
        setViewShowState(this.mStartButton, 4);
        setViewShowState(this.mBottomProgressBar, 0);
    }

    public void setBottomProgressBar() {
        changeUiToClear();
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.byStartedClick = true;
        super.onStartTrackingTouch(seekBar);
    }

    public void setOnPlayState(OnPlayState onPlayState) {
        this.onPlayState = onPlayState;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView, com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    protected void setStateAndUi(int i) {
        OnPlayState onPlayState;
        super.setStateAndUi(i);
        int i2 = this.mCurrentState;
        if (i2 == 2) {
            OnPlayState onPlayState2 = this.onPlayState;
            if (onPlayState2 != null) {
                onPlayState2.playing();
                return;
            }
            return;
        }
        if (i2 != 6) {
            if (i2 == 7 && (onPlayState = this.onPlayState) != null) {
                onPlayState.playError();
                return;
            }
            return;
        }
        OnPlayState onPlayState3 = this.onPlayState;
        if (onPlayState3 != null) {
            onPlayState3.complete();
        }
    }
}
