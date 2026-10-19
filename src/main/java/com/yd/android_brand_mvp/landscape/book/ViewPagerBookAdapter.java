package com.yd.android_brand_mvp.landscape.book;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ViewPagerBookAdapter extends FragmentPagerAdapter {
    public List<Fragment> list;

    public ViewPagerBookAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.list = new ArrayList();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.list.size() == 0) {
            return 2;
        }
        return this.list.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.list.get(i);
    }

    public void addFragment(Fragment fragment) {
        this.list.add(fragment);
        notifyDataSetChanged();
    }

    public void removeFragment() {
        this.list.clear();
        Log.e("TAG", "removeFragment: " + this.list.size());
        notifyDataSetChanged();
    }
}
