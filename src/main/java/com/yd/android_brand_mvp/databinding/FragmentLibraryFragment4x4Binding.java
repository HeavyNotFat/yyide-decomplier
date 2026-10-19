package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentLibraryFragment4x4Binding implements ViewBinding {
    public final Button btnAdvancedSearch;
    public final ImageButton btnSearch;
    public final LinearLayoutCompat clContent;
    public final EditText etSearch;
    public final LayoutLibraryAdvancedSearchBinding layoutSearch;
    public final LinearLayoutCompat llSearch;
    public final RecyclerView recyclerView;
    private final LinearLayoutCompat rootView;
    public final LayoutHeadTitleBinding top;
    public final TextView tvFields;
    public final TextView tvLibrary;
    public final CheckedTextView tvTab2;
    public final CheckedTextView tvTab3;

    private FragmentLibraryFragment4x4Binding(LinearLayoutCompat linearLayoutCompat, Button button, ImageButton imageButton, LinearLayoutCompat linearLayoutCompat2, EditText editText, LayoutLibraryAdvancedSearchBinding layoutLibraryAdvancedSearchBinding, LinearLayoutCompat linearLayoutCompat3, RecyclerView recyclerView, LayoutHeadTitleBinding layoutHeadTitleBinding, TextView textView, TextView textView2, CheckedTextView checkedTextView, CheckedTextView checkedTextView2) {
        this.rootView = linearLayoutCompat;
        this.btnAdvancedSearch = button;
        this.btnSearch = imageButton;
        this.clContent = linearLayoutCompat2;
        this.etSearch = editText;
        this.layoutSearch = layoutLibraryAdvancedSearchBinding;
        this.llSearch = linearLayoutCompat3;
        this.recyclerView = recyclerView;
        this.top = layoutHeadTitleBinding;
        this.tvFields = textView;
        this.tvLibrary = textView2;
        this.tvTab2 = checkedTextView;
        this.tvTab3 = checkedTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static FragmentLibraryFragment4x4Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentLibraryFragment4x4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_library_fragment4x4, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentLibraryFragment4x4Binding bind(View view) {
        int i = R.id.btn_advanced_search;
        Button button = (Button) view.findViewById(R.id.btn_advanced_search);
        if (button != null) {
            i = R.id.btn_search;
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn_search);
            if (imageButton != null) {
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
                i = R.id.et_search;
                EditText editText = (EditText) view.findViewById(R.id.et_search);
                if (editText != null) {
                    i = R.id.layout_search;
                    View viewFindViewById = view.findViewById(R.id.layout_search);
                    if (viewFindViewById != null) {
                        LayoutLibraryAdvancedSearchBinding layoutLibraryAdvancedSearchBindingBind = LayoutLibraryAdvancedSearchBinding.bind(viewFindViewById);
                        i = R.id.ll_search;
                        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) view.findViewById(R.id.ll_search);
                        if (linearLayoutCompat2 != null) {
                            i = R.id.recyclerView;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                            if (recyclerView != null) {
                                i = R.id.top;
                                View viewFindViewById2 = view.findViewById(R.id.top);
                                if (viewFindViewById2 != null) {
                                    LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById2);
                                    i = R.id.tv_fields;
                                    TextView textView = (TextView) view.findViewById(R.id.tv_fields);
                                    if (textView != null) {
                                        i = R.id.tv_library;
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_library);
                                        if (textView2 != null) {
                                            i = R.id.tv_tab_2;
                                            CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.tv_tab_2);
                                            if (checkedTextView != null) {
                                                i = R.id.tv_tab_3;
                                                CheckedTextView checkedTextView2 = (CheckedTextView) view.findViewById(R.id.tv_tab_3);
                                                if (checkedTextView2 != null) {
                                                    return new FragmentLibraryFragment4x4Binding(linearLayoutCompat, button, imageButton, linearLayoutCompat, editText, layoutLibraryAdvancedSearchBindingBind, linearLayoutCompat2, recyclerView, layoutHeadTitleBindingBind, textView, textView2, checkedTextView, checkedTextView2);
                                                }
                                            }
                                        }
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
