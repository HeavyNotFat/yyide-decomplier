package com.yd.android_brand_mvp.photo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.google.gson.Gson;
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.PhotoAlbumTwoBean;
import com.yd.android_brand_mvp.presenter.PhotoAlbumTwoPresenter;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.Tool;
import com.yd.android_brand_mvp.view.PhotoAlbumTwoView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.yd.android_brand_mvp.weight.rv.PagerGridLayoutManager;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;
import java.util.ArrayList;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoAlbumAllFragment extends BaseMvpFragment<PhotoAlbumTwoPresenter> implements PhotoAlbumTwoView, PagerGridLayoutManager.PageListener {
    PhotoAlbumTwoActivity activity;

    @BindView(R.id.banner)
    Banner banner;

    @BindView(R.id.mu)
    MultiStateView mu;
    PhotoAlbumBannerAdapter photoAlbumBannerAdapter;
    private int mRows = 5;
    private int mColumns = 2;
    private List<PhotoAlbumTwoBean.DataBean> dataList = new ArrayList();

    @Override // com.yd.android_brand_mvp.weight.rv.PagerGridLayoutManager.PageListener
    public void onPageSelect(int i) {
    }

    @Override // com.yd.android_brand_mvp.weight.rv.PagerGridLayoutManager.PageListener
    public void onPageSizeChanged(int i) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_all_photo_two, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.activity = (PhotoAlbumTwoActivity) getActivity();
        this.photoAlbumBannerAdapter = new PhotoAlbumBannerAdapter(this.mActivity, null);
        this.banner.addBannerLifecycleObserver(this).setStartPosition(1).setAdapter(this.photoAlbumBannerAdapter).isAutoLoop(true).setLoopTime(5000L).setIndicator(new CircleIndicator(requireContext())).setIndicatorGravity(1).setIndicatorSpace(BannerUtils.dp2px(10.0f)).setIndicatorNormalColor(SkinCompatResources.getInstance().getColor(R.color.gray)).setIndicatorSelectedColor(SkinCompatResources.getInstance().getColor(R.color.blue12)).setIndicatorWidth(BannerUtils.dp2px(10.0f), BannerUtils.dp2px(10.0f)).setIndicatorHeight(BannerUtils.dp2px(10.0f));
        getData();
    }

    void getData() {
        if (Tool.isNetworkAvailable(this.mActivity)) {
            ((PhotoAlbumTwoPresenter) this.mvpPresenter).getPhotoAlbumTablist(this.activity.classesId, this.activity.kind, this.activity.type);
            return;
        }
        if ("2".equals(this.activity.kind)) {
            this.dataList = (List) Hawk.get(BaseHawk.BANNERIMAGE2);
        } else {
            this.dataList = (List) Hawk.get(BaseHawk.BANNERIMAGE12);
        }
        List<PhotoAlbumTwoBean.DataBean> list = this.dataList;
        if (list == null || list.size() == 0) {
            this.mu.setViewState(2);
        } else {
            this.mu.setViewState(0);
            initView();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public PhotoAlbumTwoPresenter createPresenter() {
        return new PhotoAlbumTwoPresenter(this);
    }

    void initView() {
        this.mu.setViewState(this.dataList.size() == 0 ? 2 : 0);
        this.banner.setDatas(splitList(this.dataList, 10));
        this.photoAlbumBannerAdapter.setItemClick(new PhotoAlbumBannerAdapter.ItemClick() { // from class: com.yd.android_brand_mvp.photo.PhotoAlbumAllFragment.1
            @Override // com.yd.android_brand_mvp.photo.PhotoAlbumBannerAdapter.ItemClick
            public void onItemClick(PhotoAlbumTwoBean.DataBean dataBean) {
                if (dataBean.albumDTOList != null && dataBean.albumDTOList.size() > 0) {
                    Intent intent = new Intent(PhotoAlbumAllFragment.this.mActivity, (Class<?>) ShowPhotoAlbumActivity.class);
                    intent.putExtra("titleName", dataBean.name);
                    intent.putExtra("imgJson", new Gson().toJson(dataBean.albumDTOList));
                    PhotoAlbumAllFragment.this.startActivity(intent);
                    return;
                }
                ToastUtil.showBottomView(PhotoAlbumAllFragment.this.mActivity, "暂无图片");
            }
        });
    }

    public static List<List<PhotoAlbumTwoBean.DataBean>> splitList(List<PhotoAlbumTwoBean.DataBean> list, int i) {
        int size = list.size();
        int i2 = ((size + i) - 1) / i;
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 * i;
            i3++;
            arrayList.add(list.subList(i4, Math.min(i3 * i, size)));
        }
        return arrayList;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.yd.android_brand_mvp.view.PhotoAlbumTwoView
    public void getDataSuccess(PhotoAlbumTwoBean photoAlbumTwoBean) {
        if (photoAlbumTwoBean.data != null && photoAlbumTwoBean.code == 0) {
            this.dataList.addAll(photoAlbumTwoBean.data);
            if ("2".equals(this.activity.kind)) {
                Hawk.delete(BaseHawk.BANNERIMAGE2);
                Hawk.put(BaseHawk.BANNERIMAGE2, this.dataList);
            } else {
                Hawk.delete(BaseHawk.BANNERIMAGE12);
                Hawk.put(BaseHawk.BANNERIMAGE12, this.dataList);
            }
            initView();
            return;
        }
        this.mu.setViewState(2);
    }

    @Override // com.yd.android_brand_mvp.view.PhotoAlbumTwoView
    public void getFail(String str) {
        this.mu.setViewState(2);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
