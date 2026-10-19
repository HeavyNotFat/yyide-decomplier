package com.yd.android_brand_mvp.banner.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.banner.holder.ImageHolder;
import com.yd.android_brand_mvp.banner.holder.VideoHolder;
import com.yd.android_brand_mvp.banner.vdice.VdiceObserver;
import com.yd.android_brand_mvp.banner.vdice.VdiceSubject;
import com.yd.android_brand_mvp.model.VideoListBean;
import com.yd.android_brand_mvp.utils.VideoUtils;
import com.youth.banner.util.BannerUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class MediaVideoBannerAdapter extends BaseBannerAdapter<VideoListBean.DataBean, RecyclerView.ViewHolder> implements VdiceObserver {
    private Context context;
    public String nowurl;
    OnClickListener onClickListener;
    private int type;
    VdiceSubject vdiceSubject;
    private Map<Integer, VideoHolder> videoHolderMap;

    public interface OnBannerVideoPlayListener {
        void onVideoPlayComplete();

        void onVideoPlayStart();
    }

    public interface OnClickListener {
        void onClicklistener(ImageView imageView, int i);
    }

    @Override // com.yd.android_brand_mvp.banner.vdice.VdiceObserver
    public void updateViceo(boolean z) {
        Map<Integer, VideoHolder> map = this.videoHolderMap;
        if (map != null) {
            Iterator<Integer> it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                this.videoHolderMap.get(it2.next()).check.setChecked(z);
            }
        }
    }

    public MediaVideoBannerAdapter(Context context, List<VideoListBean.DataBean> list, int i, OnClickListener onClickListener) {
        super(list);
        this.nowurl = "";
        this.context = context;
        this.type = i;
        this.onClickListener = onClickListener;
        this.videoHolderMap = new HashMap();
        VdiceSubject vdiceSubject = new VdiceSubject();
        this.vdiceSubject = vdiceSubject;
        vdiceSubject.addView(this);
    }

    @Override // com.yd.android_brand_mvp.banner.holder.IBaseViewHolder
    public RecyclerView.ViewHolder onCreateHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new ImageHolder(BannerUtils.getView(viewGroup, R.layout.banner_image));
        }
        if (i == 2) {
            return new VideoHolder(BannerUtils.getView(viewGroup, R.layout.banner_video));
        }
        return new ImageHolder(BannerUtils.getView(viewGroup, R.layout.banner_image));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.type;
    }

    @Override // com.yd.android_brand_mvp.banner.holder.IBaseViewHolder
    public void onBindView(RecyclerView.ViewHolder viewHolder, final VideoListBean.DataBean dataBean, final int i, int i2, int i3) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 1) {
            final ImageHolder imageHolder = (ImageHolder) viewHolder;
            Glide.with(this.context).load(dataBean.url).into(imageHolder.imageView);
            imageHolder.imageView.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.banner.adapter.MediaVideoBannerAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MediaVideoBannerAdapter.this.onClickListener.onClicklistener(imageHolder.imageView, i);
                }
            });
            return;
        }
        if (itemViewType != 2) {
            return;
        }
        VideoHolder videoHolder = (VideoHolder) viewHolder;
        videoHolder.tm.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.banner.adapter.MediaVideoBannerAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MediaVideoBannerAdapter.this.nowurl = dataBean.url;
                MediaVideoBannerAdapter.this.onClickListener.onClicklistener(null, i);
            }
        });
        ImageView imageView = new ImageView(this.context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        videoHolder.player.setThumbImageView(imageView);
        videoHolder.player.setUp(dataBean.url, true, null);
        this.videoHolderMap.put(Integer.valueOf(i3), videoHolder);
        videoHolder.player.startPlayLogic();
        updateVoice(videoHolder.check);
        videoHolder.player.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.banner.adapter.MediaVideoBannerAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.e("TAG", "onClick: ");
                MediaVideoBannerAdapter.this.nowurl = dataBean.url;
                MediaVideoBannerAdapter.this.onClickListener.onClicklistener(null, i);
            }
        });
        if (VideoUtils.getVideoMute(this.context) > 0) {
            videoHolder.check.setChecked(true);
        }
        videoHolder.check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.yd.android_brand_mvp.banner.adapter.MediaVideoBannerAdapter.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    VideoUtils.setVideoState(MediaVideoBannerAdapter.this.context);
                } else {
                    VideoUtils.setVideoMute(MediaVideoBannerAdapter.this.context);
                }
                MediaVideoBannerAdapter.this.vdiceSubject.notfifyObserver(z);
            }
        });
    }

    public VideoHolder getVideoHolder(Integer num) {
        return this.videoHolderMap.get(num);
    }

    public void stopVideo() {
        for (Integer num : this.videoHolderMap.keySet()) {
            try {
                if (getVideoHolder(num) != null) {
                    getVideoHolder(num).player.onVideoReset();
                }
            } catch (Throwable th) {
                Log.e("VideoBannerError", "停止视频播放出错 " + th.getLocalizedMessage());
            }
        }
    }

    public void staetVideo(Integer num) {
        for (Integer num2 : this.videoHolderMap.keySet()) {
            if (num2 == num) {
                try {
                    getVideoHolder(num2).player.startPlayLogic();
                } catch (Throwable th) {
                    Log.e("VideoBannerError", "停止视频播放出错 " + th.getLocalizedMessage());
                }
            }
        }
    }

    public void updateVoice(CheckBox checkBox) {
        int videoMute = VideoUtils.getVideoMute(this.context);
        Log.i("volume", videoMute + "---");
        if (videoMute > 0) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }
    }
}
