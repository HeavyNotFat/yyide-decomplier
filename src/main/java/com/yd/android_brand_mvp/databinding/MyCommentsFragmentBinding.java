package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDEditText;

/* JADX INFO: loaded from: classes4.dex */
public final class MyCommentsFragmentBinding implements ViewBinding {
    public final CheckBox cb;
    public final YDEditText etComments;
    private final ConstraintLayout rootView;
    public final TextView tvCodeNumber;
    public final TextView tvCommit;

    private MyCommentsFragmentBinding(ConstraintLayout constraintLayout, CheckBox checkBox, YDEditText yDEditText, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.cb = checkBox;
        this.etComments = yDEditText;
        this.tvCodeNumber = textView;
        this.tvCommit = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MyCommentsFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MyCommentsFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.my_comments_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MyCommentsFragmentBinding bind(View view) {
        int i = R.id.cb;
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.cb);
        if (checkBox != null) {
            i = R.id.et_comments;
            YDEditText yDEditText = (YDEditText) view.findViewById(R.id.et_comments);
            if (yDEditText != null) {
                i = R.id.tvCodeNumber;
                TextView textView = (TextView) view.findViewById(R.id.tvCodeNumber);
                if (textView != null) {
                    i = R.id.tvCommit;
                    TextView textView2 = (TextView) view.findViewById(R.id.tvCommit);
                    if (textView2 != null) {
                        return new MyCommentsFragmentBinding((ConstraintLayout) view, checkBox, yDEditText, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
