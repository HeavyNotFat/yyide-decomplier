package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class AssignmentItemBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView tvContent;
    public final TextView tvIssuer;
    public final TextView tvSubject;

    private AssignmentItemBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.tvContent = textView;
        this.tvIssuer = textView2;
        this.tvSubject = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AssignmentItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AssignmentItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.assignment_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AssignmentItemBinding bind(View view) {
        int i = R.id.tv_content;
        TextView textView = (TextView) view.findViewById(R.id.tv_content);
        if (textView != null) {
            i = R.id.tv_issuer;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_issuer);
            if (textView2 != null) {
                i = R.id.tv_subject;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_subject);
                if (textView3 != null) {
                    return new AssignmentItemBinding((RelativeLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
