package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemLibraryTypeCheckboxBinding implements ViewBinding {
    public final CheckBox checkbox;
    private final LinearLayoutCompat rootView;

    private ItemLibraryTypeCheckboxBinding(LinearLayoutCompat linearLayoutCompat, CheckBox checkBox) {
        this.rootView = linearLayoutCompat;
        this.checkbox = checkBox;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static ItemLibraryTypeCheckboxBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemLibraryTypeCheckboxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_library_type_checkbox, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemLibraryTypeCheckboxBinding bind(View view) {
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox);
        if (checkBox != null) {
            return new ItemLibraryTypeCheckboxBinding((LinearLayoutCompat) view, checkBox);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.checkbox)));
    }
}
