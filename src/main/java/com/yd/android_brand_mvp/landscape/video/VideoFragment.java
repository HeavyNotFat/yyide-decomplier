package com.yd.android_brand_mvp.landscape.video;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import butterknife.BindView;
import butterknife.OnClick;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.orhanobut.hawk.Hawk;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.VideoListBean;
import com.yd.android_brand_mvp.presenter.VideoPresenter;
import com.yd.android_brand_mvp.user.VideoAlbumActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.Tool;
import com.yd.android_brand_mvp.view.ClassPhotoView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
public class VideoFragment extends BaseMvpFragment<VideoPresenter> implements ClassPhotoView {
    private static final String BJSPID = "1";
    private static final long CLICK_INTERVAL = 10000;
    private static final String XJSPID = "2";
    private static final String bjsp = "班级视频";
    private static final String hbbjsp23 = "hbbjsp23";
    private static final String hbbjsp44 = "hbbjsp44";
    private static final String hbbjsp46 = "hbbjsp46";
    private static final String hbjcjj23 = "hbjcjj23";
    private static final String hbxjsp23 = "hbxjsp23";
    private static final String hbxjsp44 = "hbxjsp44";
    private static final String hbxjsp46 = "hbxjsp46";
    private static final String hbxjxc441 = "hbxjxc441";
    private static final String sbbjsp42 = "sbbjsp42";
    private static final String sbbjsp63 = "sbbjsp63";
    private static final String sbxjsp42 = "sbxjsp42";
    private static final String sbxjsp44 = "sbxjsp44";
    private static final String sbxjsp63 = "sbxjsp63";
    private static final String xjsp = "校级视频";
    String classesId;
    List<VideoListBean.DataBean> dataList = new ArrayList();
    String frType = "2";
    private boolean isResume = false;
    private long lastClickTime = 0;
    String kind;

    @BindView(R.id.ll_indicator)
    LinearLayout llIndicator;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.content)
    RelativeLayout rlContent;
    String schoolId;
    private ImageView[] tips;

    @BindView(R.id.title)
    TextView title;
    String titleName;
    private String type;

    @BindView(R.id.view_pager2)
    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;

    public static VideoFragment newInstance(String str, int i) {
        return new VideoFragment(str);
    }

    public VideoFragment(String str) {
        this.type = str;
    }

    public VideoFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (hbxjsp23.equals(this.type) || hbbjsp23.equals(this.type) || hbjcjj23.equals(this.type)) {
            return layoutInflater.inflate(R.layout.fragment_video_view_pager23, viewGroup, false);
        }
        if (hbbjsp46.equals(this.type) || hbxjsp46.equals(this.type)) {
            return layoutInflater.inflate(R.layout.fragment_video_view_pager46, viewGroup, false);
        }
        return layoutInflater.inflate(R.layout.fragment_video_view_pager, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setLayoutParams();
        initView();
        setValue();
        getData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        GSYVideoManager.onPause();
        this.isResume = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isResume = true;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastClickTime < CLICK_INTERVAL) {
            return;
        }
        this.lastClickTime = jCurrentTimeMillis;
        getData();
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
    public VideoPresenter createPresenter() {
        return new VideoPresenter(this);
    }

    private void initView() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(requireContext(), this.dataList, true);
        this.viewPagerAdapter = viewPagerAdapter;
        viewPagerAdapter.setOnNext(new ViewPagerAdapter.OnNext() { // from class: com.yd.android_brand_mvp.landscape.video.-$$Lambda$VideoFragment$eMHVRYl8w4AK-41lZjvKTcQhGTA
            @Override // com.yd.android_brand_mvp.landscape.video.ViewPagerAdapter.OnNext
            public final void next(int i) {
                this.f$0.lambda$initView$0$VideoFragment(i);
            }
        });
        this.viewPager2.setOffscreenPageLimit(3);
        this.viewPager2.setOrientation(0);
        this.viewPager2.setAdapter(this.viewPagerAdapter);
        this.viewPager2.registerOnPageChangeCallback(new AnonymousClass1());
    }

    public /* synthetic */ void lambda$initView$0$VideoFragment(int i) {
        List<VideoListBean.DataBean> list = this.dataList;
        if (list != null && list.size() == 1 && i == 0) {
            updateData();
        } else {
            this.viewPager2.setCurrentItem(i);
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.video.VideoFragment$1, reason: invalid class name */
    class AnonymousClass1 extends ViewPager2.OnPageChangeCallback {
        AnonymousClass1() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(final int i) {
            super.onPageSelected(i);
            VideoFragment.this.setImageBackground(i);
            VideoFragment.this.viewPager2.post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.video.-$$Lambda$VideoFragment$1$ep09YqKhpcR3LEYamvHJelFaTuc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPageSelected$0$VideoFragment$1(i);
                }
            });
        }

        public /* synthetic */ void lambda$onPageSelected$0$VideoFragment$1(int i) {
            int playPosition = GSYVideoManager.instance().getPlayPosition();
            if (playPosition < 0 || !GSYVideoManager.instance().getPlayTag().equals("RecyclerView2List") || i == playPosition) {
                return;
            }
            GSYVideoManager.releaseAllVideos();
            VideoFragment.this.play(i);
        }
    }

    private void getData() {
        if (Tool.isNetworkAvailable(this.mActivity)) {
            if ("2".equals(this.kind)) {
                this.classesId = null;
            }
            ((VideoPresenter) this.mvpPresenter).getHomeVideo(this.classesId, this.kind, this.frType);
            return;
        }
        setCache();
    }

    private void setCache() {
        List list;
        if ("2".equals(this.kind)) {
            list = (List) Hawk.get(BaseHawk.BANNERVIDEO);
        } else {
            list = (List) Hawk.get(BaseHawk.BANNERVIDEO1);
        }
        this.dataList.clear();
        if (list != null) {
            this.dataList.addAll(list);
        }
        MultiStateView multiStateView = this.mu;
        List<VideoListBean.DataBean> list2 = this.dataList;
        multiStateView.setViewState((list2 == null || list2.size() == 0) ? 2 : 0);
        updateData();
    }

    void setLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (hbbjsp44.equals(this.type) || hbxjsp44.equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(908.0f);
            layoutParams.height = SizeUtils.dp2px(604.0f);
        } else if (sbbjsp42.equals(this.type) || sbxjsp42.equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(660.0f);
            layoutParams.height = SizeUtils.dp2px(424.0f);
        } else if (sbbjsp63.equals(this.type) || sbxjsp63.equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(1000.0f);
            layoutParams.height = SizeUtils.dp2px(646.0f);
        } else if (hbbjsp23.equals(this.type) || hbxjsp23.equals(this.type) || hbjcjj23.equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(444.0f);
            layoutParams.height = SizeUtils.dp2px(448.0f);
        } else if (hbxjsp46.equals(this.type) || hbbjsp46.equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(726.0f);
            layoutParams.height = SizeUtils.dp2px(896.0f);
        }
        this.rlContent.setLayoutParams(layoutParams);
    }

    void updateData() {
        List<VideoListBean.DataBean> list;
        Log.i("TAG", "VideoFragment==》updateData: ");
        setIndicator();
        if (this.viewPagerAdapter == null || (list = this.dataList) == null || list.size() <= 0) {
            return;
        }
        this.viewPagerAdapter.setListData(this.dataList);
        int iNextInt = new Random().nextInt(4000) + 1000;
        Log.i("VideoFragment", "VideoFragment==》random: " + iNextInt);
        GSYVideoManager.releaseAllVideos();
        this.viewPager2.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.video.-$$Lambda$VideoFragment$kwmXvkVOnV0rsFg5_QbWLVMN19c
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateData$1$VideoFragment();
            }
        }, (long) iNextInt);
    }

    public /* synthetic */ void lambda$updateData$1$VideoFragment() {
        play(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play(int i) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = ((RecyclerView) this.viewPager2.getChildAt(0)).findViewHolderForAdapterPosition(i);
        if (viewHolderFindViewHolderForAdapterPosition == null || !this.isResume) {
            return;
        }
        ((RecyclerItemNormalHolder) viewHolderFindViewHolderForAdapterPosition).getPlayer().startPlayLogic();
    }

    private void setValue() {
        this.schoolId = SpData.getSchoolId() + "";
        this.classesId = SpData.getClassesId() + "";
        if (hbbjsp44.equals(this.type) || sbbjsp42.equals(this.type) || sbbjsp63.equals(this.type) || hbbjsp23.equals(this.type) || hbbjsp46.equals(this.type)) {
            this.kind = "1";
            this.titleName = bjsp;
        } else if (hbxjsp44.equals(this.type) || sbxjsp42.equals(this.type) || hbxjxc441.equals(this.type) || sbxjsp44.equals(this.type) || sbxjsp63.equals(this.type) || hbxjsp23.equals(this.type) || hbjcjj23.equals(this.type) || hbxjsp46.equals(this.type)) {
            this.kind = "2";
            this.titleName = xjsp;
        } else {
            this.kind = "1";
            this.frType = "1";
            this.titleName = "";
        }
        this.title.setText(this.titleName);
        if (hbjcjj23.equals(this.type)) {
            this.title.setText("精彩集锦");
        }
    }

    @Override // com.yd.android_brand_mvp.view.ClassPhotoView
    public void getDataSuccess(VideoListBean videoListBean) {
        if (videoListBean == null || videoListBean.code != 0) {
            return;
        }
        this.dataList.clear();
        if (videoListBean.data != null && videoListBean.data.size() > 0) {
            this.dataList.addAll(videoListBean.data);
            if ("2".equals(this.kind)) {
                Hawk.put(BaseHawk.BANNERVIDEO, this.dataList);
            } else {
                Hawk.put(BaseHawk.BANNERVIDEO1, this.dataList);
            }
        }
        this.mu.setViewState(this.dataList.size() == 0 ? 2 : 0);
        updateData();
    }

    @Override // com.yd.android_brand_mvp.view.ClassPhotoView
    public void getFail(String str) {
        List list;
        this.dataList.clear();
        if ("2".equals(this.kind)) {
            list = (List) Hawk.get(BaseHawk.BANNERVIDEO);
        } else {
            list = (List) Hawk.get(BaseHawk.BANNERVIDEO1);
        }
        if (list != null) {
            this.dataList.addAll(list);
        }
        MultiStateView multiStateView = this.mu;
        List<VideoListBean.DataBean> list2 = this.dataList;
        multiStateView.setViewState((list2 == null || list2.size() == 0) ? 2 : 0);
        updateData();
    }

    private void setIndicator() {
        this.llIndicator.removeAllViews();
        List<VideoListBean.DataBean> list = this.dataList;
        if (list != null) {
            this.tips = new ImageView[list.size()];
            for (int i = 0; i < this.dataList.size(); i++) {
                ImageView imageView = new ImageView(this.mActivity);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(6, 6);
                layoutParams.setMargins(8, 0, 0, 0);
                imageView.setLayoutParams(layoutParams);
                imageView.setLeft(20);
                ImageView[] imageViewArr = this.tips;
                imageViewArr[i] = imageView;
                if (i == 0) {
                    imageViewArr[i].setBackgroundResource(R.drawable.bg_img_indicator2);
                } else {
                    imageViewArr[i].setBackgroundResource(R.drawable.bg_img_indicator1);
                }
                this.llIndicator.addView(imageView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageBackground(int i) {
        ImageView[] imageViewArr = this.tips;
        if (imageViewArr == null || imageViewArr.length == 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            ImageView[] imageViewArr2 = this.tips;
            if (i2 >= imageViewArr2.length || imageViewArr2[i2] == null) {
                return;
            }
            if (i2 == i) {
                imageViewArr2[i2].setBackgroundResource(R.drawable.bg_img_indicator2);
            } else {
                imageViewArr2[i2].setBackgroundResource(R.drawable.bg_img_indicator1);
            }
            i2++;
        }
    }

    @OnClick({R.id.title, R.id.mu})
    public void onClick(View view) {
        if (view.getId() == R.id.title || view.getId() == R.id.mu) {
            LogUtils.i("video", "打开视频二级页面");
            Intent intent = new Intent(this.mActivity, (Class<?>) VideoAlbumActivity.class);
            intent.putExtra("type", this.frType);
            intent.putExtra("kind", this.kind);
            intent.putExtra("titleName", this.titleName);
            intent.putExtra(CommentsHomeFragment.TYPE_CLASSESID, this.classesId);
            intent.putExtra("schoolId", this.schoolId);
            goPermissionsActivity(intent);
        }
    }
}
