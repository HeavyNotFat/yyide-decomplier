package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemHonorCommentBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvContent;
    public final TextView tvIs;
    public final TextView tvScore;
    public final TextView tvSelectScore;

    private ItemHonorCommentBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.tvContent = textView;
        this.tvIs = textView2;
        this.tvScore = textView3;
        this.tvSelectScore = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemHonorCommentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemHonorCommentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_honor_comment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemHonorCommentBinding bind(View view) {
        int i = R.id.tvContent;
        TextView textView = (TextView) view.findViewById(R.id.tvContent);
        if (textView != null) {
            i = R.id.tvIs;
            TextView textView2 = (TextView) view.findViewById(R.id.tvIs);
            if (textView2 != null) {
                i = R.id.tvScore;
                TextView textView3 = (TextView) view.findViewById(R.id.tvScore);
                if (textView3 != null) {
                    i = R.id.tvSelectScore;
                    TextView textView4 = (TextView) view.findViewById(R.id.tvSelectScore);
                    if (textView4 != null) {
                        return new ItemHonorCommentBinding((ConstraintLayout) view, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
