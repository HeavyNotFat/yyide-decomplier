package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutSiteMessageSk24Binding implements ViewBinding {
    public final ConstraintLayout clHBsk24;
    public final ImageView gankImageview3;
    public final TextView gankTextview11;
    public final TextView gankTextview12;
    public final TextView gankTextview14;
    public final TextView gankTextview15;
    public final TextView gankTextview16;
    public final TextView gankTextview17;
    private final ConstraintLayout rootView;
    public final TextView tvSiteAdminSk24;
    public final TextView tvSiteAreaSk24;
    public final TextView tvSiteCapacityNumberSk24;
    public final TextView tvSiteFloorSk24;
    public final TextView tvSiteNameSk24;
    public final TextView tvSiteNumberSk24;
    public final TextView tvSiteTypeSk26;

    private LayoutSiteMessageSk24Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13) {
        this.rootView = constraintLayout;
        this.clHBsk24 = constraintLayout2;
        this.gankImageview3 = imageView;
        this.gankTextview11 = textView;
        this.gankTextview12 = textView2;
        this.gankTextview14 = textView3;
        this.gankTextview15 = textView4;
        this.gankTextview16 = textView5;
        this.gankTextview17 = textView6;
        this.tvSiteAdminSk24 = textView7;
        this.tvSiteAreaSk24 = textView8;
        this.tvSiteCapacityNumberSk24 = textView9;
        this.tvSiteFloorSk24 = textView10;
        this.tvSiteNameSk24 = textView11;
        this.tvSiteNumberSk24 = textView12;
        this.tvSiteTypeSk26 = textView13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutSiteMessageSk24Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutSiteMessageSk24Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_site_message_sk_24, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutSiteMessageSk24Binding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.gank_imageview3;
        ImageView imageView = (ImageView) view.findViewById(R.id.gank_imageview3);
        if (imageView != null) {
            i = R.id.gank_textview11;
            TextView textView = (TextView) view.findViewById(R.id.gank_textview11);
            if (textView != null) {
                i = R.id.gank_textview12;
                TextView textView2 = (TextView) view.findViewById(R.id.gank_textview12);
                if (textView2 != null) {
                    i = R.id.gank_textview14;
                    TextView textView3 = (TextView) view.findViewById(R.id.gank_textview14);
                    if (textView3 != null) {
                        i = R.id.gank_textview15;
                        TextView textView4 = (TextView) view.findViewById(R.id.gank_textview15);
                        if (textView4 != null) {
                            i = R.id.gank_textview16;
                            TextView textView5 = (TextView) view.findViewById(R.id.gank_textview16);
                            if (textView5 != null) {
                                i = R.id.gank_textview17;
                                TextView textView6 = (TextView) view.findViewById(R.id.gank_textview17);
                                if (textView6 != null) {
                                    i = R.id.tv_site_admin_sk_24;
                                    TextView textView7 = (TextView) view.findViewById(R.id.tv_site_admin_sk_24);
                                    if (textView7 != null) {
                                        i = R.id.tv_site_area_sk_24;
                                        TextView textView8 = (TextView) view.findViewById(R.id.tv_site_area_sk_24);
                                        if (textView8 != null) {
                                            i = R.id.tv_site_capacity_number_sk_24;
                                            TextView textView9 = (TextView) view.findViewById(R.id.tv_site_capacity_number_sk_24);
                                            if (textView9 != null) {
                                                i = R.id.tv_site_floor_sk_24;
                                                TextView textView10 = (TextView) view.findViewById(R.id.tv_site_floor_sk_24);
                                                if (textView10 != null) {
                                                    i = R.id.tv_site_name_sk_24;
                                                    TextView textView11 = (TextView) view.findViewById(R.id.tv_site_name_sk_24);
                                                    if (textView11 != null) {
                                                        i = R.id.tv_site_number_sk_24;
                                                        TextView textView12 = (TextView) view.findViewById(R.id.tv_site_number_sk_24);
                                                        if (textView12 != null) {
                                                            i = R.id.tv_siteType_sk_26;
                                                            TextView textView13 = (TextView) view.findViewById(R.id.tv_siteType_sk_26);
                                                            if (textView13 != null) {
                                                                return new LayoutSiteMessageSk24Binding(constraintLayout, constraintLayout, imageView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
