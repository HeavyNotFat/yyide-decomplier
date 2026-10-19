package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemFormContentListBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvItemFormContentListTitle;
    public final TextView tvItemFormContentListValue;
    public final View viewItemFormContentListLine;
    public final View viewItemFormContentListLineVertical;

    private ItemFormContentListBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, View view, View view2) {
        this.rootView = constraintLayout;
        this.tvItemFormContentListTitle = textView;
        this.tvItemFormContentListValue = textView2;
        this.viewItemFormContentListLine = view;
        this.viewItemFormContentListLineVertical = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemFormContentListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemFormContentListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_form_content_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemFormContentListBinding bind(View view) {
        int i = R.id.tv_item_form_content_list_title;
        TextView textView = (TextView) view.findViewById(R.id.tv_item_form_content_list_title);
        if (textView != null) {
            i = R.id.tv_item_form_content_list_value;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_item_form_content_list_value);
            if (textView2 != null) {
                i = R.id.view_item_form_content_list_line;
                View viewFindViewById = view.findViewById(R.id.view_item_form_content_list_line);
                if (viewFindViewById != null) {
                    i = R.id.view_item_form_content_list_line_vertical;
                    View viewFindViewById2 = view.findViewById(R.id.view_item_form_content_list_line_vertical);
                    if (viewFindViewById2 != null) {
                        return new ItemFormContentListBinding((ConstraintLayout) view, textView, textView2, viewFindViewById, viewFindViewById2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
