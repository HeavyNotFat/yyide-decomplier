package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDEditText;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class StudentProductionAllPageBinding implements ViewBinding {
    public final Banner banner;
    public final Button btComment;
    public final YDEditText etComment;
    public final ImageView ivHeadPortrait;
    public final ImageView ivLike;
    public final LinearLayout likeLayout;
    public final RelativeLayout rlHead;
    private final LinearLayout rootView;
    public final RecyclerView rvCommentList;
    public final TextView tvCommentHint;
    public final TextView tvLab1;
    public final TextView tvLab2;
    public final TextView tvLike;
    public final TextView tvName;
    public final TextView tvPersonalMotto;
    public final TextView tvWorkDesc;
    public final TextView tvWorkName;
    public final View vIsFine;
    public final ViewPager vpProduction;

    private StudentProductionAllPageBinding(LinearLayout linearLayout, Banner banner, Button button, YDEditText yDEditText, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, RelativeLayout relativeLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, View view, ViewPager viewPager) {
        this.rootView = linearLayout;
        this.banner = banner;
        this.btComment = button;
        this.etComment = yDEditText;
        this.ivHeadPortrait = imageView;
        this.ivLike = imageView2;
        this.likeLayout = linearLayout2;
        this.rlHead = relativeLayout;
        this.rvCommentList = recyclerView;
        this.tvCommentHint = textView;
        this.tvLab1 = textView2;
        this.tvLab2 = textView3;
        this.tvLike = textView4;
        this.tvName = textView5;
        this.tvPersonalMotto = textView6;
        this.tvWorkDesc = textView7;
        this.tvWorkName = textView8;
        this.vIsFine = view;
        this.vpProduction = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static StudentProductionAllPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static StudentProductionAllPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.student_production_all_page, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static StudentProductionAllPageBinding bind(View view) {
        int i = R.id.banner;
        Banner banner = (Banner) view.findViewById(R.id.banner);
        if (banner != null) {
            i = R.id.bt_comment;
            Button button = (Button) view.findViewById(R.id.bt_comment);
            if (button != null) {
                i = R.id.et_comment;
                YDEditText yDEditText = (YDEditText) view.findViewById(R.id.et_comment);
                if (yDEditText != null) {
                    i = R.id.iv_head_portrait;
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_head_portrait);
                    if (imageView != null) {
                        i = R.id.iv_like;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_like);
                        if (imageView2 != null) {
                            i = R.id.like_layout;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.like_layout);
                            if (linearLayout != null) {
                                i = R.id.rl_head;
                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_head);
                                if (relativeLayout != null) {
                                    i = R.id.rv_comment_list;
                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_comment_list);
                                    if (recyclerView != null) {
                                        i = R.id.tv_comment_hint;
                                        TextView textView = (TextView) view.findViewById(R.id.tv_comment_hint);
                                        if (textView != null) {
                                            i = R.id.tv_lab1;
                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_lab1);
                                            if (textView2 != null) {
                                                i = R.id.tv_lab2;
                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_lab2);
                                                if (textView3 != null) {
                                                    i = R.id.tv_like;
                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_like);
                                                    if (textView4 != null) {
                                                        i = R.id.tv_name;
                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_name);
                                                        if (textView5 != null) {
                                                            i = R.id.tv_personal_motto;
                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_personal_motto);
                                                            if (textView6 != null) {
                                                                i = R.id.tv_work_desc;
                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_work_desc);
                                                                if (textView7 != null) {
                                                                    i = R.id.tv_work_name;
                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_work_name);
                                                                    if (textView8 != null) {
                                                                        i = R.id.v_is_fine;
                                                                        View viewFindViewById = view.findViewById(R.id.v_is_fine);
                                                                        if (viewFindViewById != null) {
                                                                            i = R.id.vp_production;
                                                                            ViewPager viewPager = (ViewPager) view.findViewById(R.id.vp_production);
                                                                            if (viewPager != null) {
                                                                                return new StudentProductionAllPageBinding((LinearLayout) view, banner, button, yDEditText, imageView, imageView2, linearLayout, relativeLayout, recyclerView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, viewFindViewById, viewPager);
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
