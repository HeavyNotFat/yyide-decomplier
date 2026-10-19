package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentDutyFragment2x2Binding implements ViewBinding {
    public final Banner banner;
    public final ConstraintLayout clAllDay;
    public final ConstraintLayout clContent;
    public final ConstraintLayout clTime;
    public final TextView ivBack;
    public final LinearLayoutCompat linearLayoutCompat;
    public final LinearLayoutCompat linearLayoutCompat2;
    public final MultiStateView mu;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView title;
    public final TextView tvWeek;

    private FragmentDutyFragment2x2Binding(ConstraintLayout constraintLayout, Banner banner, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView, LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, MultiStateView multiStateView, RecyclerView recyclerView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.banner = banner;
        this.clAllDay = constraintLayout2;
        this.clContent = constraintLayout3;
        this.clTime = constraintLayout4;
        this.ivBack = textView;
        this.linearLayoutCompat = linearLayoutCompat;
        this.linearLayoutCompat2 = linearLayoutCompat2;
        this.mu = multiStateView;
        this.recyclerView = recyclerView;
        this.title = textView2;
        this.tvWeek = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDutyFragment2x2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDutyFragment2x2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_duty_fragment2x2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentDutyFragment2x2Binding bind(View view) {
        int i = R.id.banner;
        Banner banner = (Banner) view.findViewById(R.id.banner);
        if (banner != null) {
            i = R.id.clAllDay;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.clAllDay);
            if (constraintLayout != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                i = R.id.clTime;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.clTime);
                if (constraintLayout3 != null) {
                    i = R.id.ivBack;
                    TextView textView = (TextView) view.findViewById(R.id.ivBack);
                    if (textView != null) {
                        i = R.id.linearLayoutCompat;
                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.linearLayoutCompat);
                        if (linearLayoutCompat != null) {
                            i = R.id.linearLayoutCompat2;
                            LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) view.findViewById(R.id.linearLayoutCompat2);
                            if (linearLayoutCompat2 != null) {
                                i = R.id.mu;
                                MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                                if (multiStateView != null) {
                                    i = R.id.recyclerView;
                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                                    if (recyclerView != null) {
                                        i = R.id.title;
                                        TextView textView2 = (TextView) view.findViewById(R.id.title);
                                        if (textView2 != null) {
                                            i = R.id.tvWeek;
                                            TextView textView3 = (TextView) view.findViewById(R.id.tvWeek);
                                            if (textView3 != null) {
                                                return new FragmentDutyFragment2x2Binding(constraintLayout2, banner, constraintLayout, constraintLayout2, constraintLayout3, textView, linearLayoutCompat, linearLayoutCompat2, multiStateView, recyclerView, textView2, textView3);
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
