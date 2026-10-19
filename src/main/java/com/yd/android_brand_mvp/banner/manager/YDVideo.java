package com.yd.android_brand_mvp.banner.manager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.yd.android_brand_mvp.R;
import moe.codeest.enviews.ENPlayView;

/* JADX INFO: loaded from: classes4.dex */
public class YDVideo extends StandardGSYVideoPlayer {
    public LiveDataFullscreenButtonClick liveDataClick;

    public interface LiveDataFullscreenButtonClick {
        void onClick();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public int getLayoutId() {
        return R.layout.video_layout_standard;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    protected boolean isShowNetConfirm() {
        return false;
    }

    public YDVideo(Context context, Boolean bool) {
        super(context, bool);
        init();
    }

    public YDVideo(Context context) {
        super(context);
        init();
    }

    public YDVideo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void onResume() {
        onVideoResume();
    }

    public void onPause() {
        onVideoPause();
    }

    public void setOnFullscreenButtonClick(LiveDataFullscreenButtonClick liveDataFullscreenButtonClick) {
        this.liveDataClick = liveDataFullscreenButtonClick;
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

    private void init() {
        settingsVideo();
    }

    public void settingsVideo() {
        GSYVideoType.enableMediaCodec();
        Debuger.enable();
        setViewShowState(this.mBottomContainer, 0);
        setViewShowState(this.mTopContainer, 0);
        setViewShowState(this.mLockScreen, 8);
        setViewShowState(this.mLoadingProgressBar, 8);
        setViewShowState(this.mTopContainer, 8);
        setViewShowState(this.mThumbImageView, 8);
        setViewShowState(this.mBottomProgressBar, 8);
        setViewShowState(this.mStartButton, 8);
        setViewShowState(this.mLoadingProgressBar, 8);
        setViewShowState(this.mFullscreenButton, 8);
        setViewShowState(this.mBackButton, 8);
        setViewShowState(this.mProgressBar, 8);
        setViewShowState(this.mCurrentTimeTextView, 8);
        setViewShowState(this.mTotalTimeTextView, 8);
        this.mChangeVolume = true;
    }

    public void setViewShowProgressBar(int i) {
        setViewShowState(this.mLoadingProgressBar, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.mFullscreenButton.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.banner.manager.YDVideo.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YDVideo.this.liveDataClick.onClick();
            }
        });
        return super.dispatchTouchEvent(motionEvent);
    }
}
