package com.yd.android_brand_mvp.landscape;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.gson.Gson;
import com.lxj.xpopup.XPopup;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.VideoALLActivity;
import com.yd.android_brand_mvp.banner.adapter.MediaVideoBannerAdapter;
import com.yd.android_brand_mvp.banner.manager.BannerVideoManager;
import com.yd.android_brand_mvp.banner.manager.ChangeBanner;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.VideoListBean;
import com.yd.android_brand_mvp.net.MachineIpService;
import com.yd.android_brand_mvp.presenter.ClassPhotoPresenter;
import com.yd.android_brand_mvp.user.PhotoAlbumActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.CircleIndicator;
import com.yd.android_brand_mvp.view.ClassPhotoView;
import com.yd.android_brand_mvp.weight.ImageShowPopup;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoAlbumFragment extends BaseMvpFragment<ClassPhotoPresenter> implements ClassPhotoView, MediaVideoBannerAdapter.OnClickListener {
    PhotoAlbumActivity activity;

    @BindView(R.id.banner)
    ChangeBanner banner;
    VideoListBean bean;
    private List<VideoListBean.DataBean> dataList;
    private Handler handler = new Handler() { // from class: com.yd.android_brand_mvp.landscape.PhotoAlbumFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str = (String) message.obj;
            Log.i("videojson", str);
            PhotoAlbumFragment.this.dataList = new ArrayList();
            PhotoAlbumFragment.this.bean = (VideoListBean) new Gson().fromJson(str, VideoListBean.class);
            if (PhotoAlbumFragment.this.dataList != null) {
                PhotoAlbumFragment.this.dataList.clear();
            }
            PhotoAlbumFragment.this.dataList.addAll(PhotoAlbumFragment.this.bean.data);
            PhotoAlbumFragment.this.mu.setViewState(PhotoAlbumFragment.this.dataList.size() == 0 ? 2 : 0);
            PhotoAlbumFragment.this.initViewPager();
        }
    };
    int layout;
    private MediaVideoBannerAdapter mAdapter;
    private BannerVideoManager mBannerVideoManager;
    private View mView;

    @BindView(R.id.mu)
    MultiStateView mu;
    String tabId;

    private void initDataList() {
    }

    @Override // com.yd.android_brand_mvp.view.ClassPhotoView
    public void getDataSuccess(VideoListBean videoListBean) {
    }

    @Override // com.yd.android_brand_mvp.view.ClassPhotoView
    public void getFail(String str) {
    }

    public static PhotoAlbumFragment newInstance(String str) {
        return new PhotoAlbumFragment(str);
    }

    public PhotoAlbumFragment(String str) {
        this.tabId = str;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = ScreenUtils.isLandscape() ? R.layout.fragment_photo_album : R.layout.banner_fragment_p;
        this.layout = i;
        View viewInflate = layoutInflater.inflate(i, viewGroup, false);
        this.mView = viewInflate;
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initViewPager();
        getVideo();
    }

    private void getVideo() {
        new Thread(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.PhotoAlbumFragment.2
            @Override // java.lang.Runnable
            public void run() {
                Log.i("videojson", PhotoAlbumFragment.this.tabId);
                if (PhotoAlbumFragment.this.activity.kind.equals("2")) {
                    MachineIpService.getVideo2(PhotoAlbumFragment.this.tabId, PhotoAlbumFragment.this.activity.kind, PhotoAlbumFragment.this.activity.schoolId, PhotoAlbumFragment.this.activity.type, PhotoAlbumFragment.this.handler);
                } else {
                    MachineIpService.getVideo(PhotoAlbumFragment.this.tabId, PhotoAlbumFragment.this.activity.classesId, PhotoAlbumFragment.this.activity.kind, PhotoAlbumFragment.this.activity.schoolId, PhotoAlbumFragment.this.activity.type, PhotoAlbumFragment.this.handler);
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        this.activity = (PhotoAlbumActivity) getActivity();
        initDataList();
        this.mAdapter = new MediaVideoBannerAdapter(getActivity(), this.dataList, Integer.parseInt(this.activity.type), this);
        this.banner.isAutoLoop(false);
        if (this.mActivity != null) {
            this.banner.setAdapter(this.mAdapter).setIndicator(new CircleIndicator(this.mActivity)).setIndicatorGravity(1);
        }
        BannerVideoManager bannerVideoManager = new BannerVideoManager(getActivity(), this.banner, this.mAdapter, this.dataList, Integer.parseInt(this.activity.type));
        this.mBannerVideoManager = bannerVideoManager;
        bannerVideoManager.setPageChangeMillis(5000L);
        this.mBannerVideoManager.setVideoPlayLoadWait(500L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public ClassPhotoPresenter createPresenter() {
        return new ClassPhotoPresenter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        BannerVideoManager bannerVideoManager = this.mBannerVideoManager;
        if (bannerVideoManager != null) {
            bannerVideoManager.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        BannerVideoManager bannerVideoManager = this.mBannerVideoManager;
        if (bannerVideoManager != null) {
            bannerVideoManager.onPause();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        BannerVideoManager bannerVideoManager = this.mBannerVideoManager;
        if (bannerVideoManager != null) {
            bannerVideoManager.onDetachedFromWindow();
        }
    }

    @Override // com.yd.android_brand_mvp.banner.adapter.MediaVideoBannerAdapter.OnClickListener
    public void onClicklistener(ImageView imageView, int i) {
        if (SpData.getMsgType()) {
            if ("2".equals(this.activity.type)) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), VideoALLActivity.class);
                Log.e("TAG", "getCurrentItem: " + this.mAdapter.nowurl);
                intent.putExtra("url", this.mAdapter.nowurl);
                startActivity(intent);
                return;
            }
            new XPopup.Builder(this.mActivity).asCustom(new ImageShowPopup(this.mActivity, this.mAdapter.nowurl)).show();
        }
    }
}
