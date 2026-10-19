package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemBlackBoardHomeBinding implements ViewBinding {
    private final LinearLayoutCompat rootView;
    public final CheckedTextView tvSubject;

    private ItemBlackBoardHomeBinding(LinearLayoutCompat linearLayoutCompat, CheckedTextView checkedTextView) {
        this.rootView = linearLayoutCompat;
        this.tvSubject = checkedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static ItemBlackBoardHomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemBlackBoardHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_black_board_home, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemBlackBoardHomeBinding bind(View view) {
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.tvSubject);
        if (checkedTextView != null) {
            return new ItemBlackBoardHomeBinding((LinearLayoutCompat) view, checkedTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tvSubject)));
    }
}
