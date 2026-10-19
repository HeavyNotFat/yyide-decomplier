package com.yd.android_brand_mvp.video1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import butterknife.BindView;
import com.orhanobut.hawk.Hawk;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.landscape.video.RecyclerItemNormalHolder;
import com.yd.android_brand_mvp.landscape.video.ViewPagerAdapter;
import com.yd.android_brand_mvp.model.VideoListBean;
import com.yd.android_brand_mvp.presenter.ClassPhotoPresenter;
import com.yd.android_brand_mvp.user.VideoAlbumActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.Tool;
import com.yd.android_brand_mvp.utils.VideoUtils;
import com.yd.android_brand_mvp.view.ClassPhotoView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class VideoAlbum1Fragment extends BaseMvpFragment<ClassPhotoPresenter> implements ClassPhotoView {
    VideoAlbumActivity activity;
    VideoListBean bean;
    String classesId;
    String kind;

    @BindView(R.id.ll_indicator)
    LinearLayout llIndicator;

    @BindView(R.id.mu)
    MultiStateView mu;
    String schoolId;
    private ImageView[] tips;

    @BindView(R.id.view_pager2)
    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;
    List<VideoListBean.DataBean> dataList = new ArrayList();
    String frType = "2";
    private int videoPosition = 0;

    public static VideoAlbum1Fragment newInstance(String str) {
        return new VideoAlbum1Fragment(str);
    }

    public VideoAlbum1Fragment() {
    }

    public VideoAlbum1Fragment(String str) {
        this.kind = str;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_photo_album1, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.activity = (VideoAlbumActivity) getActivity();
        initData();
        initView();
    }

    void initData() {
        this.schoolId = SpData.getSchoolId() + "";
        this.classesId = SpData.getClassesId() + "";
        this.viewPagerAdapter = new ViewPagerAdapter(requireContext(), this.dataList, false);
        this.viewPager2.setOrientation(0);
        this.viewPager2.setOffscreenPageLimit(3);
        this.viewPagerAdapter.setOnNext(new ViewPagerAdapter.OnNext() { // from class: com.yd.android_brand_mvp.video1.-$$Lambda$VideoAlbum1Fragment$ckT2-OkiG35lNUiXUtyWGhCLEnI
            @Override // com.yd.android_brand_mvp.landscape.video.ViewPagerAdapter.OnNext
            public final void next(int i) {
                this.f$0.lambda$initData$0$VideoAlbum1Fragment(i);
            }
        });
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.video1.VideoAlbum1Fragment.1
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                VideoAlbum1Fragment.this.getData();
            }
        });
        this.viewPager2.setAdapter(this.viewPagerAdapter);
        this.viewPager2.registerOnPageChangeCallback(new AnonymousClass2());
    }

    public /* synthetic */ void lambda$initData$0$VideoAlbum1Fragment(int i) {
        List<VideoListBean.DataBean> list = this.dataList;
        if (list != null && list.size() == 1 && i == 0) {
            updateData();
        } else {
            this.viewPager2.setCurrentItem(i);
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.video1.VideoAlbum1Fragment$2, reason: invalid class name */
    class AnonymousClass2 extends ViewPager2.OnPageChangeCallback {
        AnonymousClass2() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(final int i) {
            super.onPageSelected(i);
            VideoAlbum1Fragment.this.setImageBackground(i);
            VideoAlbum1Fragment.this.viewPager2.post(new Runnable() { // from class: com.yd.android_brand_mvp.video1.-$$Lambda$VideoAlbum1Fragment$2$3Hr8Qpn7jB64rpGWEv75hpaFVi4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPageSelected$0$VideoAlbum1Fragment$2(i);
                }
            });
        }

        public /* synthetic */ void lambda$onPageSelected$0$VideoAlbum1Fragment$2(int i) {
            int playPosition = GSYVideoManager.instance().getPlayPosition();
            if (playPosition < 0 || !GSYVideoManager.instance().getPlayTag().equals("RecyclerView2List") || i == playPosition) {
                return;
            }
            GSYVideoManager.releaseAllVideos();
            VideoAlbum1Fragment.this.play(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play(int i) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = ((RecyclerView) this.viewPager2.getChildAt(0)).findViewHolderForAdapterPosition(i);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            ((RecyclerItemNormalHolder) viewHolderFindViewHolderForAdapterPosition).getPlayer().startPlayLogic();
        }
    }

    void initView() {
        VideoUtils.setVideoState(this.mActivity);
        this.dataList = new ArrayList();
    }

    void updateData() {
        Log.d("TAG", "VideoFragment==》updateData: ");
        setIndicator();
        ViewPagerAdapter viewPagerAdapter = this.viewPagerAdapter;
        if (viewPagerAdapter != null) {
            viewPagerAdapter.setListData(this.dataList);
        }
        this.viewPager2.post(new Runnable() { // from class: com.yd.android_brand_mvp.video1.-$$Lambda$VideoAlbum1Fragment$NLa4hF8CSgxQxXrgh2ZxHDhl5U4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateData$1$VideoAlbum1Fragment();
            }
        });
    }

    public /* synthetic */ void lambda$updateData$1$VideoAlbum1Fragment() {
        play(0);
    }

    void getData() {
        if (Tool.isNetworkAvailable(this.mActivity)) {
            if ("2".equals(this.kind)) {
                this.classesId = null;
            }
            ((ClassPhotoPresenter) this.mvpPresenter).getClassPhotoList(this.classesId, this.kind, this.frType, 0);
            return;
        }
        getCache();
    }

    private void getCache() {
        if ("2".equals(this.activity.kind)) {
            this.dataList = (List) Hawk.get(BaseHawk.BANNERVIDEO);
        } else {
            this.dataList = (List) Hawk.get(BaseHawk.BANNERVIDEO1);
        }
        MultiStateView multiStateView = this.mu;
        List<VideoListBean.DataBean> list = this.dataList;
        multiStateView.setViewState((list == null || list.size() == 0) ? 2 : 0);
        updateData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        GSYVideoManager.onPause();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.PhotoVideo) {
            getData();
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        GSYVideoManager.releaseAllVideos();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public ClassPhotoPresenter createPresenter() {
        return new ClassPhotoPresenter(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageBackground(int i) {
        int i2 = 0;
        while (true) {
            ImageView[] imageViewArr = this.tips;
            if (i2 >= imageViewArr.length) {
                return;
            }
            if (i2 == i) {
                imageViewArr[i2].setBackgroundResource(R.drawable.bg_img_indicator2);
            } else {
                imageViewArr[i2].setBackgroundResource(R.drawable.bg_img_indicator1);
            }
            i2++;
        }
    }

    private void setIndicator() {
        List<VideoListBean.DataBean> list = this.dataList;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.llIndicator.removeAllViews();
        this.tips = new ImageView[this.dataList.size()];
        for (int i = 0; i < this.dataList.size(); i++) {
            ImageView imageView = new ImageView(this.mActivity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(6, 6);
            layoutParams.setMargins(8, 0, 0, 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setLeft(20);
            ImageView[] imageViewArr = this.tips;
            imageViewArr[i] = imageView;
            if (i == 0) {
                imageViewArr[i].setBackgroundResource(R.drawable.bg_img_indicator1);
            } else {
                imageViewArr[i].setBackgroundResource(R.drawable.bg_img_indicator2);
            }
            this.llIndicator.addView(imageView);
        }
    }

    @Override // com.yd.android_brand_mvp.view.ClassPhotoView
    public void getDataSuccess(VideoListBean videoListBean) {
        if (videoListBean != null && videoListBean.code == 0) {
            this.dataList.clear();
            if (videoListBean.data != null && videoListBean.data.size() > 0) {
                this.dataList.addAll(videoListBean.data);
                if ("2".equals(this.kind)) {
                    Hawk.put(BaseHawk.BANNERVIDEO, this.dataList);
                } else {
                    Hawk.put(BaseHawk.BANNERVIDEO1, this.dataList);
                }
            }
            this.mu.setViewState(this.dataList.isEmpty() ? 2 : 0);
            updateData();
            return;
        }
        getCache();
    }

    @Override // com.yd.android_brand_mvp.view.ClassPhotoView
    public void getFail(String str) {
        getCache();
    }
}
