package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentPingNetworkBinding implements ViewBinding {
    public final EditText etIp;
    public final LinearLayoutCompat llPingResult;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvPing;
    public final TextView tvPingData;
    public final TextView tvPingStatus;
    public final TextView tvTesting;

    private FragmentPingNetworkBinding(ConstraintLayout constraintLayout, EditText editText, LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.etIp = editText;
        this.llPingResult = linearLayoutCompat;
        this.recyclerView = recyclerView;
        this.tvPing = textView;
        this.tvPingData = textView2;
        this.tvPingStatus = textView3;
        this.tvTesting = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPingNetworkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentPingNetworkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ping_network, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentPingNetworkBinding bind(View view) {
        int i = R.id.etIp;
        EditText editText = (EditText) view.findViewById(R.id.etIp);
        if (editText != null) {
            i = R.id.llPingResult;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.llPingResult);
            if (linearLayoutCompat != null) {
                i = R.id.recyclerView;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                if (recyclerView != null) {
                    i = R.id.tvPing;
                    TextView textView = (TextView) view.findViewById(R.id.tvPing);
                    if (textView != null) {
                        i = R.id.tvPingData;
                        TextView textView2 = (TextView) view.findViewById(R.id.tvPingData);
                        if (textView2 != null) {
                            i = R.id.tvPingStatus;
                            TextView textView3 = (TextView) view.findViewById(R.id.tvPingStatus);
                            if (textView3 != null) {
                                i = R.id.tvTesting;
                                TextView textView4 = (TextView) view.findViewById(R.id.tvTesting);
                                if (textView4 != null) {
                                    return new FragmentPingNetworkBinding((ConstraintLayout) view, editText, linearLayoutCompat, recyclerView, textView, textView2, textView3, textView4);
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
