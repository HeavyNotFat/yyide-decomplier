package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewCollectFormEditBinding implements ViewBinding {
    public final EditText etViewCollectFormEdit;
    private final ConstraintLayout rootView;
    public final TextView tvViewCollectFormEditName;
    public final TextView tvViewCollectFormEditRequired;

    private ViewCollectFormEditBinding(ConstraintLayout constraintLayout, EditText editText, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.etViewCollectFormEdit = editText;
        this.tvViewCollectFormEditName = textView;
        this.tvViewCollectFormEditRequired = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewCollectFormEditBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCollectFormEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_collect_form_edit, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewCollectFormEditBinding bind(View view) {
        int i = R.id.et_view_collect_form_edit;
        EditText editText = (EditText) view.findViewById(R.id.et_view_collect_form_edit);
        if (editText != null) {
            i = R.id.tv_view_collect_form_edit_name;
            TextView textView = (TextView) view.findViewById(R.id.tv_view_collect_form_edit_name);
            if (textView != null) {
                i = R.id.tv_view_collect_form_edit_required;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_view_collect_form_edit_required);
                if (textView2 != null) {
                    return new ViewCollectFormEditBinding((ConstraintLayout) view, editText, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
