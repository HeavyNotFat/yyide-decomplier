package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemLibraryBooksSituationBinding implements ViewBinding {
    private final LinearLayoutCompat rootView;
    public final TextView tvCodeNumber;
    public final TextView tvCollectionSite;
    public final TextView tvLoanable;
    public final TextView tvShelvingName;

    private ItemLibraryBooksSituationBinding(LinearLayoutCompat linearLayoutCompat, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayoutCompat;
        this.tvCodeNumber = textView;
        this.tvCollectionSite = textView2;
        this.tvLoanable = textView3;
        this.tvShelvingName = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static ItemLibraryBooksSituationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemLibraryBooksSituationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_library_books_situation, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemLibraryBooksSituationBinding bind(View view) {
        int i = R.id.tv_code_number;
        TextView textView = (TextView) view.findViewById(R.id.tv_code_number);
        if (textView != null) {
            i = R.id.tv_collection_site;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_collection_site);
            if (textView2 != null) {
                i = R.id.tv_loanable;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_loanable);
                if (textView3 != null) {
                    i = R.id.tv_shelving_name;
                    TextView textView4 = (TextView) view.findViewById(R.id.tv_shelving_name);
                    if (textView4 != null) {
                        return new ItemLibraryBooksSituationBinding((LinearLayoutCompat) view, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
