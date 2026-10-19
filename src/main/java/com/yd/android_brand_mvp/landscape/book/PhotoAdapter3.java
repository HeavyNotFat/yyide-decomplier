package com.yd.android_brand_mvp.landscape.book;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.ArrayList;
import java.util.List;
import uk.co.senab.photoview.PhotoViewAttacher;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoAdapter3 extends PagerAdapter {
    private List<String> list = new ArrayList();
    PhotoViewAttacher.OnPhotoTapListener listener;
    View.OnClickListener listener2;

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public PhotoAdapter3(PhotoViewAttacher.OnPhotoTapListener onPhotoTapListener) {
        this.listener = onPhotoTapListener;
    }

    public PhotoAdapter3(View.OnClickListener onClickListener) {
        this.listener2 = onClickListener;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams2.height = -1;
        layoutParams2.width = 0;
        layoutParams2.weight = 1.0f;
        layoutParams3.width = 40;
        Log.e("TAG", "position: " + i + "/url:" + getItem(i).get(0));
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setId(R.id.left_view);
        imageView.setLayoutParams(layoutParams2);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setOnClickListener(this.listener2);
        if (getItem(i).size() > 0) {
            GlideUtil.loadImage(viewGroup.getContext(), getItem(i).get(0), imageView);
        }
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        ImageView imageView2 = new ImageView(viewGroup.getContext());
        imageView2.setId(R.id.right_view);
        imageView2.setLayoutParams(layoutParams2);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setOnClickListener(this.listener2);
        if (getItem(i).size() == 2) {
            GlideUtil.loadImage(viewGroup.getContext(), getItem(i).get(1), imageView2);
        }
        new TextView(viewGroup.getContext());
        linearLayout.addView(imageView);
        linearLayout.addView(imageView2);
        viewGroup.addView(linearLayout, -1, -1);
        return linearLayout;
    }

    public void notifyData(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    List<String> getItem(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = i * 2;
        int i3 = i2 + 1;
        Log.e("TAG", "getItem: " + i2);
        Log.e("TAG", "getItem: " + i3);
        int size = this.list.size() + (-1);
        String str = i2 > size ? null : this.list.get(i2);
        String str2 = i3 <= size ? this.list.get(i3) : null;
        arrayList.add(str);
        arrayList.add(str2);
        return arrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return (this.list.size() / 2) + (this.list.size() % 2);
    }
}
