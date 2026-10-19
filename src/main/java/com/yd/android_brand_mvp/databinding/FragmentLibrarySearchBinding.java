package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentLibrarySearchBinding implements ViewBinding {
    public final Button btnAdvancedSearch;
    public final ImageButton btnSearch;
    public final EditText etSearch;
    public final LayoutLibraryAdvancedSearchBinding layoutSearch;
    public final LinearLayoutCompat llSearch;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvFields;
    public final TextView tvLibrary;

    private FragmentLibrarySearchBinding(ConstraintLayout constraintLayout, Button button, ImageButton imageButton, EditText editText, LayoutLibraryAdvancedSearchBinding layoutLibraryAdvancedSearchBinding, LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.btnAdvancedSearch = button;
        this.btnSearch = imageButton;
        this.etSearch = editText;
        this.layoutSearch = layoutLibraryAdvancedSearchBinding;
        this.llSearch = linearLayoutCompat;
        this.recyclerView = recyclerView;
        this.tvFields = textView;
        this.tvLibrary = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentLibrarySearchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentLibrarySearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_library_search, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentLibrarySearchBinding bind(View view) {
        int i = R.id.btn_advanced_search;
        Button button = (Button) view.findViewById(R.id.btn_advanced_search);
        if (button != null) {
            i = R.id.btn_search;
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn_search);
            if (imageButton != null) {
                i = R.id.et_search;
                EditText editText = (EditText) view.findViewById(R.id.et_search);
                if (editText != null) {
                    i = R.id.layout_search;
                    View viewFindViewById = view.findViewById(R.id.layout_search);
                    if (viewFindViewById != null) {
                        LayoutLibraryAdvancedSearchBinding layoutLibraryAdvancedSearchBindingBind = LayoutLibraryAdvancedSearchBinding.bind(viewFindViewById);
                        i = R.id.ll_search;
                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.ll_search);
                        if (linearLayoutCompat != null) {
                            i = R.id.recyclerView;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                            if (recyclerView != null) {
                                i = R.id.tv_fields;
                                TextView textView = (TextView) view.findViewById(R.id.tv_fields);
                                if (textView != null) {
                                    i = R.id.tv_library;
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_library);
                                    if (textView2 != null) {
                                        return new FragmentLibrarySearchBinding((ConstraintLayout) view, button, imageButton, editText, layoutLibraryAdvancedSearchBindingBind, linearLayoutCompat, recyclerView, textView, textView2);
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
