package com.yd.android_brand_mvp.photo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.banner.manager.ShowImageActivity;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.PhotoAlbumTwoBean;
import com.yd.android_brand_mvp.presenter.PhotoAlbumTwoPresenter;
import com.yd.android_brand_mvp.view.PhotoAlbumTwoView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.yd.android_brand_mvp.weight.rv.PagerGridLayoutManager;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class ShowPhotoAlbumAllFragment extends BaseMvpFragment<PhotoAlbumTwoPresenter> implements PhotoAlbumTwoView, PagerGridLayoutManager.PageListener {

    @BindView(R.id.banner)
    Banner banner;
    private List<PhotoAlbumTwoBean.DataBean.Bean> dataList;
    String imgLisg;
    PagerGridLayoutManager mLayoutManager;
    PhotoAlbumTwoBannerAdapter mPhotoAlbumTwoBannerAdapter;

    @BindView(R.id.mu)
    MultiStateView mu;
    private int mRows = 5;
    private int mColumns = 2;

    @Override // com.yd.android_brand_mvp.view.PhotoAlbumTwoView
    public void getDataSuccess(PhotoAlbumTwoBean photoAlbumTwoBean) {
    }

    @Override // com.yd.android_brand_mvp.view.PhotoAlbumTwoView
    public void getFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.weight.rv.PagerGridLayoutManager.PageListener
    public void onPageSelect(int i) {
    }

    @Override // com.yd.android_brand_mvp.weight.rv.PagerGridLayoutManager.PageListener
    public void onPageSizeChanged(int i) {
    }

    public ShowPhotoAlbumAllFragment() {
    }

    public ShowPhotoAlbumAllFragment(String str) {
        this.imgLisg = str;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_all_photo_two, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public PhotoAlbumTwoPresenter createPresenter() {
        return new PhotoAlbumTwoPresenter(this);
    }

    void initView() {
        List<PhotoAlbumTwoBean.DataBean.Bean> list = (List) new Gson().fromJson(this.imgLisg, new TypeToken<List<PhotoAlbumTwoBean.DataBean.Bean>>() { // from class: com.yd.android_brand_mvp.photo.ShowPhotoAlbumAllFragment.1
        }.getType());
        this.dataList = list;
        this.mu.setViewState((list == null || list.size() != 0) ? 0 : 2);
        this.mPhotoAlbumTwoBannerAdapter = new PhotoAlbumTwoBannerAdapter(getContext(), null);
        this.banner.addBannerLifecycleObserver(this).setStartPosition(1).setAdapter(this.mPhotoAlbumTwoBannerAdapter).isAutoLoop(true).setLoopTime(5000L).setIndicator(new CircleIndicator(requireContext())).setIndicatorGravity(1).setIndicatorSpace(BannerUtils.dp2px(10.0f)).setIndicatorNormalColor(SkinCompatResources.getInstance().getColor(R.color.gray)).setIndicatorSelectedColor(SkinCompatResources.getInstance().getColor(R.color.blue12)).setIndicatorWidth(BannerUtils.dp2px(10.0f), BannerUtils.dp2px(10.0f)).setIndicatorHeight(BannerUtils.dp2px(10.0f));
        this.banner.setDatas(splitList(this.dataList, 10));
        this.mPhotoAlbumTwoBannerAdapter.setItemClick(new PhotoAlbumTwoBannerAdapter.ItemClick() { // from class: com.yd.android_brand_mvp.photo.-$$Lambda$ShowPhotoAlbumAllFragment$xTsJ_E5h72xrEBUqZoHaI4LMcpA
            @Override // com.yd.android_brand_mvp.photo.PhotoAlbumTwoBannerAdapter.ItemClick
            public final void onItemClick(int i) {
                this.f$0.lambda$initView$0$ShowPhotoAlbumAllFragment(i);
            }
        });
    }

    public /* synthetic */ void lambda$initView$0$ShowPhotoAlbumAllFragment(int i) {
        Intent intent = new Intent(this.mActivity, (Class<?>) ShowImageActivity.class);
        intent.putStringArrayListExtra(TUIKitConstants.Selection.LIST, getImageUrl());
        intent.putExtra("postion", i);
        startActivity(intent);
    }

    public static List<List<PhotoAlbumTwoBean.DataBean.Bean>> splitList(List<PhotoAlbumTwoBean.DataBean.Bean> list, int i) {
        if (list == null) {
            return new ArrayList();
        }
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

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    private ArrayList<String> getImageUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<PhotoAlbumTwoBean.DataBean.Bean> it2 = this.dataList.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().url);
        }
        return arrayList;
    }
}
