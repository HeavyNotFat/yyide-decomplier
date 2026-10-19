package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.view.TagTextView;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemSignTaskMyListBinding implements ViewBinding {
    public final ConstraintLayout clItemSignTaskState;
    private final ConstraintLayout rootView;
    public final TextView tvItemSignTaskEndDate;
    public final TagTextView tvItemSignTaskMyListTitle;
    public final TextView tvItemSignTaskState;

    private ItemSignTaskMyListBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TagTextView tagTextView, TextView textView2) {
        this.rootView = constraintLayout;
        this.clItemSignTaskState = constraintLayout2;
        this.tvItemSignTaskEndDate = textView;
        this.tvItemSignTaskMyListTitle = tagTextView;
        this.tvItemSignTaskState = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemSignTaskMyListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemSignTaskMyListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_sign_task_my_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemSignTaskMyListBinding bind(View view) {
        int i = R.id.cl_item_sign_task_state;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_item_sign_task_state);
        if (constraintLayout != null) {
            i = R.id.tv_item_sign_task_endDate;
            TextView textView = (TextView) view.findViewById(R.id.tv_item_sign_task_endDate);
            if (textView != null) {
                i = R.id.tv_item_sign_task_myList_title;
                TagTextView tagTextView = (TagTextView) view.findViewById(R.id.tv_item_sign_task_myList_title);
                if (tagTextView != null) {
                    i = R.id.tv_item_sign_task_state;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_item_sign_task_state);
                    if (textView2 != null) {
                        return new ItemSignTaskMyListBinding((ConstraintLayout) view, constraintLayout, textView, tagTextView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
