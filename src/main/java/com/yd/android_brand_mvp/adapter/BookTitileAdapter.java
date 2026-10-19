package com.yd.android_brand_mvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.utils.VHUtil;

/* JADX INFO: loaded from: classes4.dex */
public class BookTitileAdapter extends BaseAdapter {
    int index = -1;
    String[] strs = {"图书检索", "热门借阅", "新书通报"};

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.strs.length;
    }

    @Override // android.widget.Adapter
    public String getItem(int i) {
        return this.strs[i];
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_head_book_title, (ViewGroup) null);
        }
        CheckedTextView checkedTextView = (CheckedTextView) VHUtil.ViewHolder.get(view, R.id.weekItem);
        checkedTextView.setChecked(this.index == i);
        checkedTextView.setBackgroundResource(i == this.index ? R.drawable.bg_purple20_book : R.drawable.bg_white21_gray);
        checkedTextView.setText(getItem(i) + "");
        return view;
    }

    public void setPosition(int i) {
        this.index = i;
        notifyDataSetChanged();
    }

    public int getPosition() {
        return this.index;
    }

    public void upData(String[] strArr) {
        this.strs = strArr;
        notifyDataSetChanged();
    }
}
