package com.yd.android_brand_mvp.portrait.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.PhotoAlbumAdapter;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.PhotoAlbumTwoBean;
import com.yd.android_brand_mvp.photo.PhotoAlbumTwoActivity;
import com.yd.android_brand_mvp.photo.ShowPhotoAlbumActivity;
import com.yd.android_brand_mvp.presenter.PhotoAlbumTwoPresenter;
import com.yd.android_brand_mvp.utils.Tool;
import com.yd.android_brand_mvp.utils.view.GridSpacingItemDecoration;
import com.yd.android_brand_mvp.view.PhotoAlbumTwoView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoAlbumAllPFragment extends BaseMvpFragment<PhotoAlbumTwoPresenter> implements PhotoAlbumTwoView {
    PhotoAlbumTwoActivity activity;
    PhotoAlbumAdapter adapter;
    PhotoAlbumTwoBean bean;
    private List<PhotoAlbumTwoBean.DataBean> dataList = new ArrayList();

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.rl_list)
    RecyclerView rlList;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_all_photo_two_p, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.activity = (PhotoAlbumTwoActivity) getActivity();
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
        this.adapter = new PhotoAlbumAdapter(R.layout.photo_album_item, this.dataList);
        this.rlList.setLayoutManager(new GridLayoutManager(this.mActivity, 3));
        this.rlList.addItemDecoration(new GridSpacingItemDecoration(3, 50, false));
        this.rlList.setAdapter(this.adapter);
        this.mu.setViewState(this.dataList.size() == 0 ? 2 : 0);
        this.adapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.PhotoAlbumAllPFragment.1
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public void onItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i) {
                if (((PhotoAlbumTwoBean.DataBean) PhotoAlbumAllPFragment.this.dataList.get(i)).albumDTOList != null && ((PhotoAlbumTwoBean.DataBean) PhotoAlbumAllPFragment.this.dataList.get(i)).albumDTOList.size() > 0) {
                    Intent intent = new Intent(PhotoAlbumAllPFragment.this.mActivity, (Class<?>) ShowPhotoAlbumActivity.class);
                    intent.putExtra("titleName", ((PhotoAlbumTwoBean.DataBean) PhotoAlbumAllPFragment.this.dataList.get(i)).name);
                    intent.putExtra("imgJson", new Gson().toJson(((PhotoAlbumTwoBean.DataBean) PhotoAlbumAllPFragment.this.dataList.get(i)).albumDTOList));
                    PhotoAlbumAllPFragment.this.startActivity(intent);
                    return;
                }
                ToastUtils.showShort("暂无图片");
            }
        });
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
