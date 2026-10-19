package com.yd.android_brand_mvp.landscape.book;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.view.HackyViewPager2;

/* JADX INFO: loaded from: classes4.dex */
public class BookImageInfo_ViewBinding implements Unbinder {
    private BookImageInfo target;
    private View view7f0a009c;
    private View view7f0a009d;
    private View view7f0a079c;

    public BookImageInfo_ViewBinding(BookImageInfo bookImageInfo) {
        this(bookImageInfo, bookImageInfo.getWindow().getDecorView());
    }

    public BookImageInfo_ViewBinding(final BookImageInfo bookImageInfo, View view) {
        this.target = bookImageInfo;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.back, "field 'back' and method 'onViewClicked'");
        bookImageInfo.back = (TextView) Utils.castView(viewFindRequiredView, R.id.back, "field 'back'", TextView.class);
        this.view7f0a009c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.book.BookImageInfo_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                bookImageInfo.onViewClicked(view2);
            }
        });
        bookImageInfo.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.setting, "field 'setting' and method 'onViewClicked'");
        bookImageInfo.setting = (TextView) Utils.castView(viewFindRequiredView2, R.id.setting, "field 'setting'", TextView.class);
        this.view7f0a079c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.book.BookImageInfo_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                bookImageInfo.onViewClicked(view2);
            }
        });
        bookImageInfo.pager = (HackyViewPager2) Utils.findRequiredViewAsType(view, R.id.pager, "field 'pager'", HackyViewPager2.class);
        bookImageInfo.page = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.page, "field 'page'", FrameLayout.class);
        bookImageInfo.layout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.layout, "field 'layout'", FrameLayout.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.back_layout, "field 'back_layout' and method 'onViewClicked'");
        bookImageInfo.back_layout = (FrameLayout) Utils.castView(viewFindRequiredView3, R.id.back_layout, "field 'back_layout'", FrameLayout.class);
        this.view7f0a009d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.book.BookImageInfo_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                bookImageInfo.onViewClicked(view2);
            }
        });
        bookImageInfo.layoutLl = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.layout_ll, "field 'layoutLl'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BookImageInfo bookImageInfo = this.target;
        if (bookImageInfo == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bookImageInfo.back = null;
        bookImageInfo.title = null;
        bookImageInfo.setting = null;
        bookImageInfo.pager = null;
        bookImageInfo.page = null;
        bookImageInfo.layout = null;
        bookImageInfo.back_layout = null;
        bookImageInfo.layoutLl = null;
        this.view7f0a009c.setOnClickListener(null);
        this.view7f0a009c = null;
        this.view7f0a079c.setOnClickListener(null);
        this.view7f0a079c = null;
        this.view7f0a009d.setOnClickListener(null);
        this.view7f0a009d = null;
    }
}
