package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragment_hot_ViewBinding implements Unbinder {
    private BookYwFragment_hot target;

    public BookYwFragment_hot_ViewBinding(BookYwFragment_hot bookYwFragment_hot, View view) {
        this.target = bookYwFragment_hot;
        bookYwFragment_hot.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
        bookYwFragment_hot.flag = (TextView) Utils.findRequiredViewAsType(view, R.id.flag, "field 'flag'", TextView.class);
        bookYwFragment_hot.time = (TextView) Utils.findRequiredViewAsType(view, R.id.time, "field 'time'", TextView.class);
        bookYwFragment_hot.language = (TextView) Utils.findRequiredViewAsType(view, R.id.language, "field 'language'", TextView.class);
        bookYwFragment_hot.yz_layout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.yz_layout, "field 'yz_layout'", FrameLayout.class);
        bookYwFragment_hot.typelayout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.typelayout, "field 'typelayout'", FrameLayout.class);
        bookYwFragment_hot.type = (TextView) Utils.findRequiredViewAsType(view, R.id.type, "field 'type'", TextView.class);
        bookYwFragment_hot.flaglayout2 = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flaglayout2, "field 'flaglayout2'", FrameLayout.class);
        bookYwFragment_hot.flag2 = (TextView) Utils.findRequiredViewAsType(view, R.id.flag2, "field 'flag2'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BookYwFragment_hot bookYwFragment_hot = this.target;
        if (bookYwFragment_hot == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bookYwFragment_hot.recyclerView = null;
        bookYwFragment_hot.flag = null;
        bookYwFragment_hot.time = null;
        bookYwFragment_hot.language = null;
        bookYwFragment_hot.yz_layout = null;
        bookYwFragment_hot.typelayout = null;
        bookYwFragment_hot.type = null;
        bookYwFragment_hot.flaglayout2 = null;
        bookYwFragment_hot.flag2 = null;
    }
}
