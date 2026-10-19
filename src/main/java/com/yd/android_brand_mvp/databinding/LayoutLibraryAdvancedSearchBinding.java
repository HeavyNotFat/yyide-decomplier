package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutLibraryAdvancedSearchBinding implements ViewBinding {
    public final Button btnReset;
    public final Button btnSearch;
    public final RecyclerView ckRecyclerView;
    public final EditText etAuthor;
    public final EditText etInscribe;
    public final EditText etPublishingHours;
    private final LinearLayoutCompat rootView;
    public final TextView tvOrder;
    public final TextView tvYearEnd;
    public final TextView tvYearStart;

    private LayoutLibraryAdvancedSearchBinding(LinearLayoutCompat linearLayoutCompat, Button button, Button button2, RecyclerView recyclerView, EditText editText, EditText editText2, EditText editText3, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayoutCompat;
        this.btnReset = button;
        this.btnSearch = button2;
        this.ckRecyclerView = recyclerView;
        this.etAuthor = editText;
        this.etInscribe = editText2;
        this.etPublishingHours = editText3;
        this.tvOrder = textView;
        this.tvYearEnd = textView2;
        this.tvYearStart = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static LayoutLibraryAdvancedSearchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutLibraryAdvancedSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_library_advanced_search, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutLibraryAdvancedSearchBinding bind(View view) {
        int i = R.id.btn_reset;
        Button button = (Button) view.findViewById(R.id.btn_reset);
        if (button != null) {
            i = R.id.btn_search;
            Button button2 = (Button) view.findViewById(R.id.btn_search);
            if (button2 != null) {
                i = R.id.ck_recyclerView;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.ck_recyclerView);
                if (recyclerView != null) {
                    i = R.id.et_author;
                    EditText editText = (EditText) view.findViewById(R.id.et_author);
                    if (editText != null) {
                        i = R.id.et_inscribe;
                        EditText editText2 = (EditText) view.findViewById(R.id.et_inscribe);
                        if (editText2 != null) {
                            i = R.id.et_publishing_hours;
                            EditText editText3 = (EditText) view.findViewById(R.id.et_publishing_hours);
                            if (editText3 != null) {
                                i = R.id.tv_order;
                                TextView textView = (TextView) view.findViewById(R.id.tv_order);
                                if (textView != null) {
                                    i = R.id.tv_year_end;
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_year_end);
                                    if (textView2 != null) {
                                        i = R.id.tv_year_start;
                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_year_start);
                                        if (textView3 != null) {
                                            return new LayoutLibraryAdvancedSearchBinding((LinearLayoutCompat) view, button, button2, recyclerView, editText, editText2, editText3, textView, textView2, textView3);
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
