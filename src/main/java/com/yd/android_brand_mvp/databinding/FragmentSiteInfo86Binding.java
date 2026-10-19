package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentSiteInfo86Binding implements ViewBinding {
    public final Banner bannerFragmentSiteInfo66;
    public final Barrier barrierFragmentSiteInfo66Name;
    public final ConstraintLayout clFragmentSiteInfo;
    public final ViewStub emptyViewBanner;
    public final ViewStub emptyViewBottom;
    public final ImageView ivBack;
    public final ImageView ivFragmentSiteInfo66;
    public final LinearLayout linearLayout2;
    private final ConstraintLayout rootView;
    public final TextView title;
    public final TextView tvFragmentSiteInfo66Capacity;
    public final TextView tvFragmentSiteInfo66CapacityContent;
    public final TextView tvFragmentSiteInfo66Class;
    public final TextView tvFragmentSiteInfo66ClassContent;
    public final TextView tvFragmentSiteInfo66Content;
    public final TextView tvFragmentSiteInfo66Floor;
    public final TextView tvFragmentSiteInfo66FloorContent;
    public final TextView tvFragmentSiteInfo66Introduce;
    public final TextView tvFragmentSiteInfo66Manager;
    public final TextView tvFragmentSiteInfo66ManagerContent;
    public final TextView tvFragmentSiteInfo66RoomNum;
    public final TextView tvFragmentSiteInfo66RoomNumContent;
    public final TextView tvFragmentSiteInfo66Size;
    public final TextView tvFragmentSiteInfo66SizeContent;
    public final TextView tvFragmentSiteInfo66Type;
    public final TextView tvFragmentSiteInfo66TypeContent;

    private FragmentSiteInfo86Binding(ConstraintLayout constraintLayout, Banner banner, Barrier barrier, ConstraintLayout constraintLayout2, ViewStub viewStub, ViewStub viewStub2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17) {
        this.rootView = constraintLayout;
        this.bannerFragmentSiteInfo66 = banner;
        this.barrierFragmentSiteInfo66Name = barrier;
        this.clFragmentSiteInfo = constraintLayout2;
        this.emptyViewBanner = viewStub;
        this.emptyViewBottom = viewStub2;
        this.ivBack = imageView;
        this.ivFragmentSiteInfo66 = imageView2;
        this.linearLayout2 = linearLayout;
        this.title = textView;
        this.tvFragmentSiteInfo66Capacity = textView2;
        this.tvFragmentSiteInfo66CapacityContent = textView3;
        this.tvFragmentSiteInfo66Class = textView4;
        this.tvFragmentSiteInfo66ClassContent = textView5;
        this.tvFragmentSiteInfo66Content = textView6;
        this.tvFragmentSiteInfo66Floor = textView7;
        this.tvFragmentSiteInfo66FloorContent = textView8;
        this.tvFragmentSiteInfo66Introduce = textView9;
        this.tvFragmentSiteInfo66Manager = textView10;
        this.tvFragmentSiteInfo66ManagerContent = textView11;
        this.tvFragmentSiteInfo66RoomNum = textView12;
        this.tvFragmentSiteInfo66RoomNumContent = textView13;
        this.tvFragmentSiteInfo66Size = textView14;
        this.tvFragmentSiteInfo66SizeContent = textView15;
        this.tvFragmentSiteInfo66Type = textView16;
        this.tvFragmentSiteInfo66TypeContent = textView17;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSiteInfo86Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSiteInfo86Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_site_info86, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentSiteInfo86Binding bind(View view) {
        int i = R.id.banner_fragment_site_info66;
        Banner banner = (Banner) view.findViewById(R.id.banner_fragment_site_info66);
        if (banner != null) {
            i = R.id.barrier_fragment_site_info66_name;
            Barrier barrier = (Barrier) view.findViewById(R.id.barrier_fragment_site_info66_name);
            if (barrier != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.empty_view_banner;
                ViewStub viewStub = (ViewStub) view.findViewById(R.id.empty_view_banner);
                if (viewStub != null) {
                    i = R.id.empty_view_bottom;
                    ViewStub viewStub2 = (ViewStub) view.findViewById(R.id.empty_view_bottom);
                    if (viewStub2 != null) {
                        i = R.id.ivBack;
                        ImageView imageView = (ImageView) view.findViewById(R.id.ivBack);
                        if (imageView != null) {
                            i = R.id.iv_fragment_site_info66;
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_fragment_site_info66);
                            if (imageView2 != null) {
                                i = R.id.linearLayout2;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout2);
                                if (linearLayout != null) {
                                    i = R.id.title;
                                    TextView textView = (TextView) view.findViewById(R.id.title);
                                    if (textView != null) {
                                        i = R.id.tv_fragment_site_info66_capacity;
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_site_info66_capacity);
                                        if (textView2 != null) {
                                            i = R.id.tv_fragment_site_info66_capacity_content;
                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_fragment_site_info66_capacity_content);
                                            if (textView3 != null) {
                                                i = R.id.tv_fragment_site_info66_class;
                                                TextView textView4 = (TextView) view.findViewById(R.id.tv_fragment_site_info66_class);
                                                if (textView4 != null) {
                                                    i = R.id.tv_fragment_site_info66_class_content;
                                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_fragment_site_info66_class_content);
                                                    if (textView5 != null) {
                                                        i = R.id.tv_fragment_site_info66_content;
                                                        TextView textView6 = (TextView) view.findViewById(R.id.tv_fragment_site_info66_content);
                                                        if (textView6 != null) {
                                                            i = R.id.tv_fragment_site_info66_floor;
                                                            TextView textView7 = (TextView) view.findViewById(R.id.tv_fragment_site_info66_floor);
                                                            if (textView7 != null) {
                                                                i = R.id.tv_fragment_site_info66_floor_content;
                                                                TextView textView8 = (TextView) view.findViewById(R.id.tv_fragment_site_info66_floor_content);
                                                                if (textView8 != null) {
                                                                    i = R.id.tv_fragment_site_info66_introduce;
                                                                    TextView textView9 = (TextView) view.findViewById(R.id.tv_fragment_site_info66_introduce);
                                                                    if (textView9 != null) {
                                                                        i = R.id.tv_fragment_site_info66_manager;
                                                                        TextView textView10 = (TextView) view.findViewById(R.id.tv_fragment_site_info66_manager);
                                                                        if (textView10 != null) {
                                                                            i = R.id.tv_fragment_site_info66_manager_content;
                                                                            TextView textView11 = (TextView) view.findViewById(R.id.tv_fragment_site_info66_manager_content);
                                                                            if (textView11 != null) {
                                                                                i = R.id.tv_fragment_site_info66_roomNum;
                                                                                TextView textView12 = (TextView) view.findViewById(R.id.tv_fragment_site_info66_roomNum);
                                                                                if (textView12 != null) {
                                                                                    i = R.id.tv_fragment_site_info66_roomNum_content;
                                                                                    TextView textView13 = (TextView) view.findViewById(R.id.tv_fragment_site_info66_roomNum_content);
                                                                                    if (textView13 != null) {
                                                                                        i = R.id.tv_fragment_site_info66_size;
                                                                                        TextView textView14 = (TextView) view.findViewById(R.id.tv_fragment_site_info66_size);
                                                                                        if (textView14 != null) {
                                                                                            i = R.id.tv_fragment_site_info66_size_content;
                                                                                            TextView textView15 = (TextView) view.findViewById(R.id.tv_fragment_site_info66_size_content);
                                                                                            if (textView15 != null) {
                                                                                                i = R.id.tv_fragment_site_info66_type;
                                                                                                TextView textView16 = (TextView) view.findViewById(R.id.tv_fragment_site_info66_type);
                                                                                                if (textView16 != null) {
                                                                                                    i = R.id.tv_fragment_site_info66_type_content;
                                                                                                    TextView textView17 = (TextView) view.findViewById(R.id.tv_fragment_site_info66_type_content);
                                                                                                    if (textView17 != null) {
                                                                                                        return new FragmentSiteInfo86Binding(constraintLayout, banner, barrier, constraintLayout, viewStub, viewStub2, imageView, imageView2, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17);
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
