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
public final class LayoutSiteMusicBinding implements ViewBinding {
    public final ImageView gankImageview3;
    public final TextView gankTextview11;
    public final TextView gankTextview12;
    public final TextView gankTextview13;
    public final TextView gankTextview14;
    public final TextView gankTextview15;
    public final TextView gankTextview16;
    public final TextView gankTextview17;
    private final ConstraintLayout rootView;
    public final TextView tvSiteAdmin24;
    public final TextView tvSiteArea24;
    public final TextView tvSiteCapacityNumber24;
    public final TextView tvSiteClass24;
    public final TextView tvSiteFloor24;
    public final TextView tvSiteName24;
    public final TextView tvSiteNumber24;
    public final TextView tvSiteType26;

    private LayoutSiteMusicBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15) {
        this.rootView = constraintLayout;
        this.gankImageview3 = imageView;
        this.gankTextview11 = textView;
        this.gankTextview12 = textView2;
        this.gankTextview13 = textView3;
        this.gankTextview14 = textView4;
        this.gankTextview15 = textView5;
        this.gankTextview16 = textView6;
        this.gankTextview17 = textView7;
        this.tvSiteAdmin24 = textView8;
        this.tvSiteArea24 = textView9;
        this.tvSiteCapacityNumber24 = textView10;
        this.tvSiteClass24 = textView11;
        this.tvSiteFloor24 = textView12;
        this.tvSiteName24 = textView13;
        this.tvSiteNumber24 = textView14;
        this.tvSiteType26 = textView15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutSiteMusicBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutSiteMusicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_site_music, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutSiteMusicBinding bind(View view) {
        int i = R.id.gank_imageview3;
        ImageView imageView = (ImageView) view.findViewById(R.id.gank_imageview3);
        if (imageView != null) {
            i = R.id.gank_textview11;
            TextView textView = (TextView) view.findViewById(R.id.gank_textview11);
            if (textView != null) {
                i = R.id.gank_textview12;
                TextView textView2 = (TextView) view.findViewById(R.id.gank_textview12);
                if (textView2 != null) {
                    i = R.id.gank_textview13;
                    TextView textView3 = (TextView) view.findViewById(R.id.gank_textview13);
                    if (textView3 != null) {
                        i = R.id.gank_textview14;
                        TextView textView4 = (TextView) view.findViewById(R.id.gank_textview14);
                        if (textView4 != null) {
                            i = R.id.gank_textview15;
                            TextView textView5 = (TextView) view.findViewById(R.id.gank_textview15);
                            if (textView5 != null) {
                                i = R.id.gank_textview16;
                                TextView textView6 = (TextView) view.findViewById(R.id.gank_textview16);
                                if (textView6 != null) {
                                    i = R.id.gank_textview17;
                                    TextView textView7 = (TextView) view.findViewById(R.id.gank_textview17);
                                    if (textView7 != null) {
                                        i = R.id.tv_site_admin_24;
                                        TextView textView8 = (TextView) view.findViewById(R.id.tv_site_admin_24);
                                        if (textView8 != null) {
                                            i = R.id.tv_site_area_24;
                                            TextView textView9 = (TextView) view.findViewById(R.id.tv_site_area_24);
                                            if (textView9 != null) {
                                                i = R.id.tv_site_capacity_number_24;
                                                TextView textView10 = (TextView) view.findViewById(R.id.tv_site_capacity_number_24);
                                                if (textView10 != null) {
                                                    i = R.id.tv_site_class_24;
                                                    TextView textView11 = (TextView) view.findViewById(R.id.tv_site_class_24);
                                                    if (textView11 != null) {
                                                        i = R.id.tv_site_floor_24;
                                                        TextView textView12 = (TextView) view.findViewById(R.id.tv_site_floor_24);
                                                        if (textView12 != null) {
                                                            i = R.id.tv_site_name_24;
                                                            TextView textView13 = (TextView) view.findViewById(R.id.tv_site_name_24);
                                                            if (textView13 != null) {
                                                                i = R.id.tv_site_number_24;
                                                                TextView textView14 = (TextView) view.findViewById(R.id.tv_site_number_24);
                                                                if (textView14 != null) {
                                                                    i = R.id.tv_siteType_26;
                                                                    TextView textView15 = (TextView) view.findViewById(R.id.tv_siteType_26);
                                                                    if (textView15 != null) {
                                                                        return new LayoutSiteMusicBinding((ConstraintLayout) view, imageView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
