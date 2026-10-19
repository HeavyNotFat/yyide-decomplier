package com.yd.android_brand_mvp.banner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.utils.GlideUtil;

/* JADX INFO: loaded from: classes4.dex */
public class ImgFragment extends Fragment {
    private static String TYPE_URL = "imgUrl";
    private ImageView imageView;
    private View mView;

    public static ImgFragment newInstance(String str) {
        ImgFragment imgFragment = new ImgFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TYPE_URL, str);
        imgFragment.setArguments(bundle);
        return imgFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.image_fragment, viewGroup, false);
        this.mView = viewInflate;
        this.imageView = (ImageView) viewInflate.findViewById(R.id.image);
        return this.mView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        GlideUtil.loadNormalImg(this.imageView, getArguments().getString(TYPE_URL));
    }
}
