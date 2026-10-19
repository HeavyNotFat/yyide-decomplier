package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentActiveApplyDetailsBinding implements ViewBinding {
    public final Banner banner;
    public final TextView btnActiveLogin;
    public final TextView btnActiveSign;
    public final TextView btnOutLogin;
    public final ConstraintLayout constraintLayout6;
    public final ImageView ivCover;
    public final LinearLayoutCompat llBottom;
    private final ConstraintLayout rootView;
    public final TextView tvActiveChildRegistration;
    public final TextView tvActiveCreateDate;
    public final TextView tvActiveCreateName;
    public final TextView tvActiveDate;
    public final TextView tvActiveDateTip;
    public final TextView tvActiveDescribe;
    public final TextView tvActiveItemSetTip;
    public final TextView tvActiveObjectScope;
    public final TextView tvActiveObjectScopeTip;
    public final TextView tvActiveRemark;
    public final TextView tvActiveRemarkTip;
    public final TextView tvActiveSignDate;
    public final TextView tvActiveSignDateTip;
    public final TextView tvActiveStatus;
    public final TextView tvActiveTitle;

    private FragmentActiveApplyDetailsBinding(ConstraintLayout constraintLayout, Banner banner, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout2, ImageView imageView, LinearLayoutCompat linearLayoutCompat, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18) {
        this.rootView = constraintLayout;
        this.banner = banner;
        this.btnActiveLogin = textView;
        this.btnActiveSign = textView2;
        this.btnOutLogin = textView3;
        this.constraintLayout6 = constraintLayout2;
        this.ivCover = imageView;
        this.llBottom = linearLayoutCompat;
        this.tvActiveChildRegistration = textView4;
        this.tvActiveCreateDate = textView5;
        this.tvActiveCreateName = textView6;
        this.tvActiveDate = textView7;
        this.tvActiveDateTip = textView8;
        this.tvActiveDescribe = textView9;
        this.tvActiveItemSetTip = textView10;
        this.tvActiveObjectScope = textView11;
        this.tvActiveObjectScopeTip = textView12;
        this.tvActiveRemark = textView13;
        this.tvActiveRemarkTip = textView14;
        this.tvActiveSignDate = textView15;
        this.tvActiveSignDateTip = textView16;
        this.tvActiveStatus = textView17;
        this.tvActiveTitle = textView18;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentActiveApplyDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentActiveApplyDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_active_apply_details, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentActiveApplyDetailsBinding bind(View view) {
        int i = R.id.banner;
        Banner banner = (Banner) view.findViewById(R.id.banner);
        if (banner != null) {
            i = R.id.btn_active_login;
            TextView textView = (TextView) view.findViewById(R.id.btn_active_login);
            if (textView != null) {
                i = R.id.btn_active_sign;
                TextView textView2 = (TextView) view.findViewById(R.id.btn_active_sign);
                if (textView2 != null) {
                    i = R.id.btn_out_login;
                    TextView textView3 = (TextView) view.findViewById(R.id.btn_out_login);
                    if (textView3 != null) {
                        i = R.id.constraintLayout6;
                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.constraintLayout6);
                        if (constraintLayout != null) {
                            i = R.id.iv_cover;
                            ImageView imageView = (ImageView) view.findViewById(R.id.iv_cover);
                            if (imageView != null) {
                                i = R.id.ll_bottom;
                                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.ll_bottom);
                                if (linearLayoutCompat != null) {
                                    i = R.id.tv_active_child_registration;
                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_active_child_registration);
                                    if (textView4 != null) {
                                        i = R.id.tv_active_create_date;
                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_active_create_date);
                                        if (textView5 != null) {
                                            i = R.id.tv_active_create_name;
                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_active_create_name);
                                            if (textView6 != null) {
                                                i = R.id.tv_active_date;
                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_active_date);
                                                if (textView7 != null) {
                                                    i = R.id.tv_active_date_tip;
                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_active_date_tip);
                                                    if (textView8 != null) {
                                                        i = R.id.tv_active_describe;
                                                        TextView textView9 = (TextView) view.findViewById(R.id.tv_active_describe);
                                                        if (textView9 != null) {
                                                            i = R.id.tv_active_item_set_tip;
                                                            TextView textView10 = (TextView) view.findViewById(R.id.tv_active_item_set_tip);
                                                            if (textView10 != null) {
                                                                i = R.id.tv_active_object_scope;
                                                                TextView textView11 = (TextView) view.findViewById(R.id.tv_active_object_scope);
                                                                if (textView11 != null) {
                                                                    i = R.id.tv_active_object_scope_tip;
                                                                    TextView textView12 = (TextView) view.findViewById(R.id.tv_active_object_scope_tip);
                                                                    if (textView12 != null) {
                                                                        i = R.id.tv_active_remark;
                                                                        TextView textView13 = (TextView) view.findViewById(R.id.tv_active_remark);
                                                                        if (textView13 != null) {
                                                                            i = R.id.tv_active_remark_tip;
                                                                            TextView textView14 = (TextView) view.findViewById(R.id.tv_active_remark_tip);
                                                                            if (textView14 != null) {
                                                                                i = R.id.tv_active_sign_date;
                                                                                TextView textView15 = (TextView) view.findViewById(R.id.tv_active_sign_date);
                                                                                if (textView15 != null) {
                                                                                    i = R.id.tv_active_sign_date_tip;
                                                                                    TextView textView16 = (TextView) view.findViewById(R.id.tv_active_sign_date_tip);
                                                                                    if (textView16 != null) {
                                                                                        i = R.id.tv_active_status;
                                                                                        TextView textView17 = (TextView) view.findViewById(R.id.tv_active_status);
                                                                                        if (textView17 != null) {
                                                                                            i = R.id.tv_active_title;
                                                                                            TextView textView18 = (TextView) view.findViewById(R.id.tv_active_title);
                                                                                            if (textView18 != null) {
                                                                                                return new FragmentActiveApplyDetailsBinding((ConstraintLayout) view, banner, textView, textView2, textView3, constraintLayout, imageView, linearLayoutCompat, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18);
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
