package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import butterknife.BindView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.BookTitileAdapter;
import com.yd.android_brand_mvp.base.BaseFragment;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragment4_4L extends BaseFragment {
    BookTitileAdapter adapter;

    @BindView(R.id.grid)
    GridView gridView;
    String[] strs = {String.valueOf(R.string.book_title_tab1), String.valueOf(R.string.book_title_tab2), String.valueOf(R.string.book_title_tab3)};
    View view;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ywbook4_4_l, viewGroup, false);
        this.view = viewInflate;
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        BookTitileAdapter bookTitileAdapter = new BookTitileAdapter();
        this.adapter = bookTitileAdapter;
        this.gridView.setAdapter((ListAdapter) bookTitileAdapter);
        this.adapter.upData(this.strs);
        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragment4_4L.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                BookYwFragment4_4L.this.setFragment(i);
            }
        });
    }

    void setFragment(int i) {
        this.adapter.setPosition(i);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
