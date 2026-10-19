package com.yd.android_brand_mvp.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ViewPagerFragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mList;

    public ViewPagerFragmentAdapter(FragmentManager fragmentManager, List<Fragment> list) {
        super(fragmentManager);
        this.mList = new ArrayList();
        this.mList = list;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        return this.mList.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<Fragment> list = this.mList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
