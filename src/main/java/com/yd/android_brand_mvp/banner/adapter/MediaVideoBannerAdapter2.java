package com.yd.android_brand_mvp.banner.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.banner.holder.ImageHolder;
import com.yd.android_brand_mvp.banner.holder.VideoHolder;
import com.yd.android_brand_mvp.model.VideoListBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.youth.banner.util.BannerUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class MediaVideoBannerAdapter2 extends BaseBannerAdapter<VideoListBean.DataBean, RecyclerView.ViewHolder> {
    private Context context;
    public String imgUrl;
    public String nowurl;
    OnClickListener onClickListener;
    private int type;
    private Map<Integer, VideoHolder> videoHolderMap;

    public interface OnBannerVideoPlayListener {
        void onVideoPlayComplete();

        void onVideoPlayStart();
    }

    public interface OnClickListener {
        void onClicklistener();
    }

    public MediaVideoBannerAdapter2(Context context, List<VideoListBean.DataBean> list, int i, OnClickListener onClickListener) {
        super(list);
        this.nowurl = "";
        this.imgUrl = "";
        this.context = context;
        this.type = i;
        this.onClickListener = onClickListener;
        this.videoHolderMap = new HashMap();
    }

    @Override // com.yd.android_brand_mvp.banner.holder.IBaseViewHolder
    public RecyclerView.ViewHolder onCreateHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new ImageHolder(BannerUtils.getView(viewGroup, R.layout.banner_image));
        }
        if (i == 2) {
            return new VideoHolder(BannerUtils.getView(viewGroup, R.layout.banner_video2));
        }
        return new ImageHolder(BannerUtils.getView(viewGroup, R.layout.banner_image));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.type;
    }

    @Override // com.yd.android_brand_mvp.banner.holder.IBaseViewHolder
    public void onBindView(RecyclerView.ViewHolder viewHolder, final VideoListBean.DataBean dataBean, int i, int i2, int i3) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 1) {
            ImageHolder imageHolder = (ImageHolder) viewHolder;
            GlideUtil.loadNomalImage(this.context, dataBean.url, imageHolder.imageView);
            imageHolder.imageView.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.banner.adapter.MediaVideoBannerAdapter2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MediaVideoBannerAdapter2.this.imgUrl = dataBean.url;
                    MediaVideoBannerAdapter2.this.onClickListener.onClicklistener();
                }
            });
        } else {
            if (itemViewType != 2) {
                return;
            }
            VideoHolder videoHolder = (VideoHolder) viewHolder;
            videoHolder.tm.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.banner.adapter.MediaVideoBannerAdapter2.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MediaVideoBannerAdapter2.this.nowurl = dataBean.url;
                    MediaVideoBannerAdapter2.this.onClickListener.onClicklistener();
                }
            });
            ImageView imageView = new ImageView(this.context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            videoHolder.player.setThumbImageView(imageView);
            videoHolder.player.setUp(dataBean.url, true, null);
            this.videoHolderMap.put(Integer.valueOf(i3), videoHolder);
            videoHolder.player.startPlayLogic();
            videoHolder.check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.yd.android_brand_mvp.banner.adapter.MediaVideoBannerAdapter2.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                }
            });
            videoHolder.check.setChecked(true);
            videoHolder.player.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.banner.adapter.MediaVideoBannerAdapter2.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Log.e("TAG", "onClick: ");
                    MediaVideoBannerAdapter2.this.nowurl = dataBean.url;
                    MediaVideoBannerAdapter2.this.onClickListener.onClicklistener();
                }
            });
        }
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
}
