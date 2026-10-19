package com.yd.android_brand_mvp.banner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.work.WorkRequest;
import butterknife.BindView;
import butterknife.OnClick;
import com.blankj.utilcode.util.SizeUtils;
import com.orhanobut.hawk.Hawk;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.to.aboomy.pager2banner.Banner;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.ImageAdapter;
import com.yd.android_brand_mvp.banner.manager.ShowImageActivity;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.listener.AdapterListener;
import com.yd.android_brand_mvp.model.VideoListBean;
import com.yd.android_brand_mvp.photo.PhotoAlbumTwoActivity;
import com.yd.android_brand_mvp.presenter.ClassPhotoPresenter;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.Tool;
import com.yd.android_brand_mvp.view.ClassPhotoView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class BannerImageFragment extends BaseMvpFragment<ClassPhotoPresenter> implements ClassPhotoView {
    private ImageAdapter adapter;

    @BindView(R.id.banner)
    Banner banner;
    String classesId;
    String kind;

    @BindView(R.id.content)
    LinearLayout llContent;

    @BindView(R.id.mu)
    MultiStateView mu;
    int postion;
    BootBroadcastReceiver receiver;
    String schoolId;

    @BindView(R.id.title)
    TextView title;
    String titleName;

    @BindView(R.id.tv_index)
    TextView tv_index;
    String type;
    String frType = "0";
    List<VideoListBean.DataBean> dataList = new ArrayList();
    private final String Action = "VideoBanner";
    private int imageListToTal = 0;

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.PhotoVideo || i == 1307) {
            lambda$initView$1$BannerImageFragment();
        }
    }

    public static BannerImageFragment newInstance(String str) {
        return new BannerImageFragment(str);
    }

    public BannerImageFragment() {
    }

    public BannerImageFragment(String str) {
        this.type = str;
        setValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if ("sbbjxc42".equals(this.type) || "sbxjxc42".equals(this.type)) {
            return layoutInflater.inflate(R.layout.banner_image_fragment42, viewGroup, false);
        }
        if ("hbbjxc23".equals(this.type) || "hbxjxc23".equals(this.type) || "hbxyfg23".equals(this.type)) {
            return layoutInflater.inflate(R.layout.banner_image_fragment23, viewGroup, false);
        }
        if ("hbbjxc46".equals(this.type) || "hbxjxc46".equals(this.type)) {
            return layoutInflater.inflate(R.layout.banner_image_fragment46, viewGroup, false);
        }
        return layoutInflater.inflate(R.layout.banner_image_fragment, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setLayoutParams();
        initView();
        this.receiver = new BootBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("VideoBanner");
        if (this.mActivity != null) {
            this.mActivity.registerReceiver(this.receiver, intentFilter);
        }
        lambda$initView$1$BannerImageFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mActivity == null || this.receiver == null) {
            return;
        }
        this.mActivity.unregisterReceiver(this.receiver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public ClassPhotoPresenter createPresenter() {
        return new ClassPhotoPresenter(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getVideo, reason: merged with bridge method [inline-methods] */
    public void lambda$initView$1$BannerImageFragment() {
        if (Tool.isNetworkAvailable(this.mActivity)) {
            if ("2".equals(this.kind)) {
                ((ClassPhotoPresenter) this.mvpPresenter).getClassPhotoList("", this.kind, this.frType, 10);
                return;
            } else {
                ((ClassPhotoPresenter) this.mvpPresenter).getClassPhotoList(this.classesId, this.kind, this.frType, 10);
                return;
            }
        }
        if ("2".equals(this.kind)) {
            this.dataList = (List) Hawk.get(BaseHawk.BANNERIMAGE);
        } else {
            this.dataList = (List) Hawk.get(BaseHawk.BANNERIMAGE1);
        }
        List<VideoListBean.DataBean> list = this.dataList;
        if (list != null && list.size() != 0) {
            this.mu.setViewState(0);
            this.banner.setVisibility(0);
            this.adapter.setDatas(getImageUrl());
        } else {
            this.mu.setViewState(2);
            this.banner.setVisibility(8);
        }
    }

    void setLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if ("hbbjxc44".equals(this.type) || "hbxjxc44".equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(908.0f);
            layoutParams.height = SizeUtils.dp2px(604.0f);
        } else if ("sbbjxc42".equals(this.type) || "sbxjxc42".equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(660.0f);
            layoutParams.height = SizeUtils.dp2px(424.0f);
        } else if ("sbbjxc63".equals(this.type) || "sbxjxc63".equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(1000.0f);
            layoutParams.height = SizeUtils.dp2px(646.0f);
        } else if ("hbbjxc23".equals(this.type) || "hbxjxc23".equals(this.type) || "hbxyfg23".equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(444.0f);
            layoutParams.height = SizeUtils.dp2px(448.0f);
        } else if ("hbbjxc46".equals(this.type) || "hbxjxc46".equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(726.0f);
            layoutParams.height = SizeUtils.dp2px(896.0f);
        }
        this.llContent.setLayoutParams(layoutParams);
    }

    private void initView() {
        if (!TextUtils.isEmpty(this.type)) {
            if (this.type.equals("hbxyfg23")) {
                this.title.setText("校园风光");
            } else {
                this.title.setText(this.titleName);
            }
        }
        ImageAdapter imageAdapter = new ImageAdapter(requireContext(), null);
        this.adapter = imageAdapter;
        imageAdapter.setIncreaseCount(0);
        this.adapter.setAdapterListener(new AdapterListener() { // from class: com.yd.android_brand_mvp.banner.-$$Lambda$BannerImageFragment$C3FicUvEw0kbocTGgOpwemOEPsA
            @Override // com.yd.android_brand_mvp.listener.AdapterListener
            public final void setOnclick(int i, String str) {
                this.f$0.lambda$initView$0$BannerImageFragment(i, str);
            }
        });
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.banner.-$$Lambda$BannerImageFragment$B_7TS8rDLc6EIO57gMnDKqi17Xk
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public final void reload() {
                this.f$0.lambda$initView$1$BannerImageFragment();
            }
        });
        this.banner.setIndicator(null).setAutoPlay(true).setAutoTurningTime(WorkRequest.MIN_BACKOFF_MILLIS).setAdapter(this.adapter);
        this.banner.setCurrentItem(0);
        this.banner.setOuterPageChangeListener(new ViewPager2.OnPageChangeCallback() { // from class: com.yd.android_brand_mvp.banner.BannerImageFragment.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i, float f, int i2) {
                super.onPageScrolled(i, f, i2);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                BannerImageFragment.this.postion = i;
                BannerImageFragment.this.tv_index.setText((i + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + BannerImageFragment.this.adapter.getItemCount());
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i) {
                super.onPageScrollStateChanged(i);
            }
        });
    }

    public /* synthetic */ void lambda$initView$0$BannerImageFragment(int i, String str) {
        Intent intent = new Intent(this.mActivity, (Class<?>) ShowImageActivity.class);
        intent.putStringArrayListExtra(TUIKitConstants.Selection.LIST, getImageUrl());
        intent.putExtra("postion", i);
        goPermissionsActivity(intent);
    }

    @OnClick({R.id.title, R.id.content})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.content || id == R.id.title) {
            Intent intent = new Intent(this.mActivity, (Class<?>) PhotoAlbumTwoActivity.class);
            intent.putExtra("type", this.frType);
            intent.putExtra("kind", this.kind);
            intent.putExtra("titleName", this.titleName);
            intent.putExtra(CommentsHomeFragment.TYPE_CLASSESID, this.classesId);
            intent.putExtra("schoolId", this.schoolId);
            goPermissionsActivity(intent);
        }
    }

    private void setValue() {
        this.classesId = SpData.getClassesId();
        this.schoolId = SpData.getSchoolId();
        if ("hbbjxc44".equals(this.type) || "sbbjxc42".equals(this.type) || "hbbjxc441".equals(this.type) || "hbbjxc46".equals(this.type) || "sbbjxc63".equals(this.type) || "hbbjxc23".equals(this.type)) {
            this.kind = "1";
            this.frType = "1";
            this.titleName = "班级相册";
        } else if ("hbxjxc44".equals(this.type) || "sbxjxc42".equals(this.type) || "hbxjxc441".equals(this.type) || "hbxjxc46".equals(this.type) || "sbxjxc63".equals(this.type) || "hbxjxc23".equals(this.type) || "hbxyfg23".equals(this.type)) {
            this.kind = "2";
            this.frType = "1";
            this.titleName = "校级相册";
        } else {
            this.kind = "1";
            this.frType = "1";
            this.titleName = "";
        }
    }

    private ArrayList<String> getImageUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        List<VideoListBean.DataBean> list = this.dataList;
        if (list == null) {
            return arrayList;
        }
        int i = 0;
        for (VideoListBean.DataBean dataBean : list) {
            i++;
            if (i <= 10) {
                arrayList.add(dataBean.url);
            }
        }
        return arrayList;
    }

    @Override // com.yd.android_brand_mvp.view.ClassPhotoView
    public void getDataSuccess(VideoListBean videoListBean) {
        List<VideoListBean.DataBean> list;
        List<VideoListBean.DataBean> list2 = this.dataList;
        if (list2 != null) {
            list2.clear();
        }
        if (videoListBean != null && videoListBean.data != null && (list = this.dataList) != null) {
            list.addAll(videoListBean.data);
            if ("2".equals(this.kind)) {
                Hawk.delete(BaseHawk.BANNERIMAGE);
                Hawk.put(BaseHawk.BANNERIMAGE, this.dataList);
            } else {
                Hawk.delete(BaseHawk.BANNERIMAGE1);
                Hawk.put(BaseHawk.BANNERIMAGE1, this.dataList);
            }
        }
        updateData();
    }

    private void updateData() {
        List<VideoListBean.DataBean> list = this.dataList;
        if (list != null && list.size() != 0) {
            this.mu.setViewState(0);
            ArrayList<String> imageUrl = getImageUrl();
            if (imageUrl != null) {
                this.imageListToTal = imageUrl.size();
                this.tv_index.setText((this.postion + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.imageListToTal);
            }
            this.banner.setVisibility(0);
            this.adapter.setDatas(imageUrl);
            return;
        }
        this.mu.setViewState(2);
        this.banner.setVisibility(8);
    }

    @Override // com.yd.android_brand_mvp.view.ClassPhotoView
    public void getFail(String str) {
        this.mu.setViewState(1);
        if ("2".equals(this.kind)) {
            this.dataList = (List) Hawk.get(BaseHawk.BANNERIMAGE);
        } else {
            this.dataList = (List) Hawk.get(BaseHawk.BANNERIMAGE1);
        }
        List<VideoListBean.DataBean> list = this.dataList;
        if (list != null && list.size() != 0) {
            this.mu.setViewState(0);
            this.banner.setVisibility(0);
            this.adapter.setDatas(getImageUrl());
        } else {
            this.mu.setViewState(2);
            this.banner.setVisibility(8);
        }
        setLayoutParams();
    }

    public class BootBroadcastReceiver extends BroadcastReceiver {
        public BootBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("VideoBanner")) {
                BannerImageFragment.this.lambda$initView$1$BannerImageFragment();
            }
        }
    }
}
