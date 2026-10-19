package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemApproverHeadBinding implements ViewBinding {
    public final ImageView ivAddApproval;
    public final ImageView ivDel;
    public final ImageView ivUserHead;
    private final ConstraintLayout rootView;
    public final TextView tvDesc;
    public final View viewCode;
    public final View viewEnd;
    public final View viewLine;
    public final View viewTop;

    private ItemApproverHeadBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, View view, View view2, View view3, View view4) {
        this.rootView = constraintLayout;
        this.ivAddApproval = imageView;
        this.ivDel = imageView2;
        this.ivUserHead = imageView3;
        this.tvDesc = textView;
        this.viewCode = view;
        this.viewEnd = view2;
        this.viewLine = view3;
        this.viewTop = view4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemApproverHeadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemApproverHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_approver_head, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemApproverHeadBinding bind(View view) {
        int i = R.id.iv_add_approval;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_add_approval);
        if (imageView != null) {
            i = R.id.ivDel;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.ivDel);
            if (imageView2 != null) {
                i = R.id.iv_user_head;
                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_user_head);
                if (imageView3 != null) {
                    i = R.id.tvDesc;
                    TextView textView = (TextView) view.findViewById(R.id.tvDesc);
                    if (textView != null) {
                        i = R.id.viewCode;
                        View viewFindViewById = view.findViewById(R.id.viewCode);
                        if (viewFindViewById != null) {
                            i = R.id.viewEnd;
                            View viewFindViewById2 = view.findViewById(R.id.viewEnd);
                            if (viewFindViewById2 != null) {
                                i = R.id.viewLine;
                                View viewFindViewById3 = view.findViewById(R.id.viewLine);
                                if (viewFindViewById3 != null) {
                                    i = R.id.viewTop;
                                    View viewFindViewById4 = view.findViewById(R.id.viewTop);
                                    if (viewFindViewById4 != null) {
                                        return new ItemApproverHeadBinding((ConstraintLayout) view, imageView, imageView2, imageView3, textView, viewFindViewById, viewFindViewById2, viewFindViewById3, viewFindViewById4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
