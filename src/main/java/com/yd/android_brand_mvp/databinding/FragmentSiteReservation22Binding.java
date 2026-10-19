package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentSiteReservation22Binding implements ViewBinding {
    public final Button btnFragmentSiteReservation22Sign;
    public final ConstraintLayout clFragmentSiteReservation22;
    public final ConstraintLayout clFragmentSiteReservation22Content;
    public final ConstraintLayout clFragmentSiteReservation44Meeting;
    private final ConstraintLayout rootView;
    public final RecyclerView rvFragmentSiteReservation44Meeting;
    public final LayoutHeadTitleBinding topFragmentSiteReservation22;
    public final ImageView topFragmentSiteReservation22Content;
    public final TextView tvFragmentSiteReservation22Time;
    public final TextView tvFragmentSiteReservation22Title;
    public final TextView tvFragmentSiteReservation44Title;

    private FragmentSiteReservation22Binding(ConstraintLayout constraintLayout, Button button, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, RecyclerView recyclerView, LayoutHeadTitleBinding layoutHeadTitleBinding, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnFragmentSiteReservation22Sign = button;
        this.clFragmentSiteReservation22 = constraintLayout2;
        this.clFragmentSiteReservation22Content = constraintLayout3;
        this.clFragmentSiteReservation44Meeting = constraintLayout4;
        this.rvFragmentSiteReservation44Meeting = recyclerView;
        this.topFragmentSiteReservation22 = layoutHeadTitleBinding;
        this.topFragmentSiteReservation22Content = imageView;
        this.tvFragmentSiteReservation22Time = textView;
        this.tvFragmentSiteReservation22Title = textView2;
        this.tvFragmentSiteReservation44Title = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSiteReservation22Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSiteReservation22Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_site_reservation22, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentSiteReservation22Binding bind(View view) {
        int i = R.id.btn_fragment_site_reservation22_sign;
        Button button = (Button) view.findViewById(R.id.btn_fragment_site_reservation22_sign);
        if (button != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.cl_fragment_site_reservation22_content;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_site_reservation22_content);
            if (constraintLayout2 != null) {
                i = R.id.cl_fragment_site_reservation44_meeting;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_site_reservation44_meeting);
                if (constraintLayout3 != null) {
                    i = R.id.rv_fragment_site_reservation44_meeting;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_site_reservation44_meeting);
                    if (recyclerView != null) {
                        i = R.id.top_fragment_site_reservation22;
                        View viewFindViewById = view.findViewById(R.id.top_fragment_site_reservation22);
                        if (viewFindViewById != null) {
                            LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
                            i = R.id.top_fragment_site_reservation22_content;
                            ImageView imageView = (ImageView) view.findViewById(R.id.top_fragment_site_reservation22_content);
                            if (imageView != null) {
                                i = R.id.tv_fragment_site_reservation22_time;
                                TextView textView = (TextView) view.findViewById(R.id.tv_fragment_site_reservation22_time);
                                if (textView != null) {
                                    i = R.id.tv_fragment_site_reservation22_title;
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_site_reservation22_title);
                                    if (textView2 != null) {
                                        i = R.id.tv_fragment_site_reservation44_title;
                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_fragment_site_reservation44_title);
                                        if (textView3 != null) {
                                            return new FragmentSiteReservation22Binding(constraintLayout, button, constraintLayout, constraintLayout2, constraintLayout3, recyclerView, layoutHeadTitleBindingBind, imageView, textView, textView2, textView3);
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
