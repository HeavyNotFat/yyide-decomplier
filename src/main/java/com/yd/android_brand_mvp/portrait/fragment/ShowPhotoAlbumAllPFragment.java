package com.yd.android_brand_mvp.portrait.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.ShowPhotoAlbumAdapter;
import com.yd.android_brand_mvp.banner.manager.ShowImageActivity;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.PhotoAlbumTwoBean;
import com.yd.android_brand_mvp.presenter.PhotoAlbumTwoPresenter;
import com.yd.android_brand_mvp.utils.view.GridSpacingItemDecoration;
import com.yd.android_brand_mvp.view.PhotoAlbumTwoView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ShowPhotoAlbumAllPFragment extends BaseMvpFragment<PhotoAlbumTwoPresenter> implements PhotoAlbumTwoView {
    ShowPhotoAlbumAdapter adapter;
    private List<PhotoAlbumTwoBean.DataBean.Bean> dataList;
    String imgLisg;
    List<String> lists;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.rl_list)
    RecyclerView rlList;
    private int mRows = 5;
    private int mColumns = 2;

    @Override // com.yd.android_brand_mvp.view.PhotoAlbumTwoView
    public void getDataSuccess(PhotoAlbumTwoBean photoAlbumTwoBean) {
    }

    @Override // com.yd.android_brand_mvp.view.PhotoAlbumTwoView
    public void getFail(String str) {
    }

    public ShowPhotoAlbumAllPFragment() {
    }

    public ShowPhotoAlbumAllPFragment(String str) {
        this.imgLisg = str;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_all_photo_two_p, viewGroup, false);
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
        this.dataList = (List) new Gson().fromJson(this.imgLisg, new TypeToken<List<PhotoAlbumTwoBean.DataBean.Bean>>() { // from class: com.yd.android_brand_mvp.portrait.fragment.ShowPhotoAlbumAllPFragment.1
        }.getType());
        this.rlList.setLayoutManager(new GridLayoutManager(this.mActivity, 3));
        int i = 0;
        this.rlList.addItemDecoration(new GridSpacingItemDecoration(3, 50, false));
        ShowPhotoAlbumAdapter showPhotoAlbumAdapter = new ShowPhotoAlbumAdapter(R.layout.photo_album_item, this.dataList);
        this.adapter = showPhotoAlbumAdapter;
        this.rlList.setAdapter(showPhotoAlbumAdapter);
        MultiStateView multiStateView = this.mu;
        List<PhotoAlbumTwoBean.DataBean.Bean> list = this.dataList;
        if (list != null && list.size() == 0) {
            i = 2;
        }
        multiStateView.setViewState(i);
        this.adapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.ShowPhotoAlbumAllPFragment.2
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public void onItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i2) {
                Intent intent = new Intent(ShowPhotoAlbumAllPFragment.this.mActivity, (Class<?>) ShowImageActivity.class);
                intent.putStringArrayListExtra(TUIKitConstants.Selection.LIST, ShowPhotoAlbumAllPFragment.this.getImageUrl());
                intent.putExtra("postion", i2);
                ShowPhotoAlbumAllPFragment.this.startActivity(intent);
            }
        });
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> getImageUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<PhotoAlbumTwoBean.DataBean.Bean> it2 = this.dataList.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().url);
        }
        return arrayList;
    }
}
