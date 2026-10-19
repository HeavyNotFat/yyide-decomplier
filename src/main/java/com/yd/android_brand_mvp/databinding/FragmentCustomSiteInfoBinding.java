package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentCustomSiteInfoBinding implements ViewBinding {
    public final ImageView imageview;
    public final ImageView imageview2;
    public final ImageView imageview3;
    public final ImageView ivQrCode;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView textView35;
    public final TextView textView36;
    public final TextView textView37;
    public final TextView tvAffiliatedCollege;
    public final TextView tvGrade;
    public final TextView tvPersonCharge;
    public final TextView tvRoomNumber;
    public final TextView tvSiteName;
    public final View view;

    private FragmentCustomSiteInfoBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, View view) {
        this.rootView = constraintLayout;
        this.imageview = imageView;
        this.imageview2 = imageView2;
        this.imageview3 = imageView3;
        this.ivQrCode = imageView4;
        this.recyclerView = recyclerView;
        this.textView35 = textView;
        this.textView36 = textView2;
        this.textView37 = textView3;
        this.tvAffiliatedCollege = textView4;
        this.tvGrade = textView5;
        this.tvPersonCharge = textView6;
        this.tvRoomNumber = textView7;
        this.tvSiteName = textView8;
        this.view = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCustomSiteInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCustomSiteInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_custom_site_info, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCustomSiteInfoBinding bind(View view) {
        int i = R.id.imageview;
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        if (imageView != null) {
            i = R.id.imageview2;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.imageview2);
            if (imageView2 != null) {
                i = R.id.imageview3;
                ImageView imageView3 = (ImageView) view.findViewById(R.id.imageview3);
                if (imageView3 != null) {
                    i = R.id.iv_qr_code;
                    ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_qr_code);
                    if (imageView4 != null) {
                        i = R.id.recyclerView;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                        if (recyclerView != null) {
                            i = R.id.textView35;
                            TextView textView = (TextView) view.findViewById(R.id.textView35);
                            if (textView != null) {
                                i = R.id.textView36;
                                TextView textView2 = (TextView) view.findViewById(R.id.textView36);
                                if (textView2 != null) {
                                    i = R.id.textView37;
                                    TextView textView3 = (TextView) view.findViewById(R.id.textView37);
                                    if (textView3 != null) {
                                        i = R.id.tv_affiliated_college;
                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_affiliated_college);
                                        if (textView4 != null) {
                                            i = R.id.tv_grade;
                                            TextView textView5 = (TextView) view.findViewById(R.id.tv_grade);
                                            if (textView5 != null) {
                                                i = R.id.tv_person_charge;
                                                TextView textView6 = (TextView) view.findViewById(R.id.tv_person_charge);
                                                if (textView6 != null) {
                                                    i = R.id.tv_room_number;
                                                    TextView textView7 = (TextView) view.findViewById(R.id.tv_room_number);
                                                    if (textView7 != null) {
                                                        i = R.id.tv_site_name;
                                                        TextView textView8 = (TextView) view.findViewById(R.id.tv_site_name);
                                                        if (textView8 != null) {
                                                            i = R.id.view;
                                                            View viewFindViewById = view.findViewById(R.id.view);
                                                            if (viewFindViewById != null) {
                                                                return new FragmentCustomSiteInfoBinding((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4, recyclerView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, viewFindViewById);
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
