package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class DialogSeirportLandscapeBinding implements ViewBinding {
    public final TextView cancel;
    public final ListView list;
    public final TextView nowText;
    public final TextView ok;
    private final LinearLayout rootView;

    private DialogSeirportLandscapeBinding(LinearLayout linearLayout, TextView textView, ListView listView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.cancel = textView;
        this.list = listView;
        this.nowText = textView2;
        this.ok = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogSeirportLandscapeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogSeirportLandscapeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_seirport_landscape, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogSeirportLandscapeBinding bind(View view) {
        int i = R.id.cancel;
        TextView textView = (TextView) view.findViewById(R.id.cancel);
        if (textView != null) {
            i = R.id.list;
            ListView listView = (ListView) view.findViewById(R.id.list);
            if (listView != null) {
                i = R.id.now_text;
                TextView textView2 = (TextView) view.findViewById(R.id.now_text);
                if (textView2 != null) {
                    i = R.id.ok;
                    TextView textView3 = (TextView) view.findViewById(R.id.ok);
                    if (textView3 != null) {
                        return new DialogSeirportLandscapeBinding((LinearLayout) view, textView, listView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
