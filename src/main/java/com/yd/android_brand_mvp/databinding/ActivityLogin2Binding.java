package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDEditText;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityLogin2Binding implements ViewBinding {
    public final TextView AuthCode;
    public final TextView activateBtn;
    public final LinearLayout activateLayout;
    public final LinearLayout calendarLayout;
    public final TextView config;
    public final LinearLayout faceLayout;
    public final FrameLayout facelayout;
    public final FrameLayout flQRRefresh;
    public final TextView getCode;
    public final TextView getFaceCode;
    public final TextView go2qrcode;
    public final GridView grid;
    public final ImageView ivSet;
    public final TextView jumpToMain;
    public final LinearLayout llAccount;
    public final LinearLayout llQRConfirm;
    public final LinearLayout llQrcode;
    public final LinearLayout nameLayout;
    public final LinearLayout passwordLayout;
    public final ProgressBar progress;
    public final YDEditText psd;
    public final ImageView qrcode;
    public final YDEditText register;
    public final TextView registerBtn;
    public final LinearLayout registerLayout;
    private final FrameLayout rootView;
    public final FrameLayout schoolLayout;
    public final TextView showcode;
    public final TextView tips;
    public final TextView tvAccount;
    public final TextView tvRegister;
    public final YDEditText user;
    public final LinearLayout welcome;

    private ActivityLogin2Binding(FrameLayout frameLayout, TextView textView, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView3, LinearLayout linearLayout3, FrameLayout frameLayout2, FrameLayout frameLayout3, TextView textView4, TextView textView5, TextView textView6, GridView gridView, ImageView imageView, TextView textView7, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, ProgressBar progressBar, YDEditText yDEditText, ImageView imageView2, YDEditText yDEditText2, TextView textView8, LinearLayout linearLayout9, FrameLayout frameLayout4, TextView textView9, TextView textView10, TextView textView11, TextView textView12, YDEditText yDEditText3, LinearLayout linearLayout10) {
        this.rootView = frameLayout;
        this.AuthCode = textView;
        this.activateBtn = textView2;
        this.activateLayout = linearLayout;
        this.calendarLayout = linearLayout2;
        this.config = textView3;
        this.faceLayout = linearLayout3;
        this.facelayout = frameLayout2;
        this.flQRRefresh = frameLayout3;
        this.getCode = textView4;
        this.getFaceCode = textView5;
        this.go2qrcode = textView6;
        this.grid = gridView;
        this.ivSet = imageView;
        this.jumpToMain = textView7;
        this.llAccount = linearLayout4;
        this.llQRConfirm = linearLayout5;
        this.llQrcode = linearLayout6;
        this.nameLayout = linearLayout7;
        this.passwordLayout = linearLayout8;
        this.progress = progressBar;
        this.psd = yDEditText;
        this.qrcode = imageView2;
        this.register = yDEditText2;
        this.registerBtn = textView8;
        this.registerLayout = linearLayout9;
        this.schoolLayout = frameLayout4;
        this.showcode = textView9;
        this.tips = textView10;
        this.tvAccount = textView11;
        this.tvRegister = textView12;
        this.user = yDEditText3;
        this.welcome = linearLayout10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLogin2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityLogin2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_login2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityLogin2Binding bind(View view) {
        int i = R.id.AuthCode;
        TextView textView = (TextView) view.findViewById(R.id.AuthCode);
        if (textView != null) {
            i = R.id.activateBtn;
            TextView textView2 = (TextView) view.findViewById(R.id.activateBtn);
            if (textView2 != null) {
                i = R.id.activate_layout;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.activate_layout);
                if (linearLayout != null) {
                    i = R.id.calendar_layout;
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.calendar_layout);
                    if (linearLayout2 != null) {
                        i = R.id.config;
                        TextView textView3 = (TextView) view.findViewById(R.id.config);
                        if (textView3 != null) {
                            i = R.id.face_layout;
                            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.face_layout);
                            if (linearLayout3 != null) {
                                i = R.id.facelayout;
                                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.facelayout);
                                if (frameLayout != null) {
                                    i = R.id.flQRRefresh;
                                    FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.flQRRefresh);
                                    if (frameLayout2 != null) {
                                        i = R.id.getCode;
                                        TextView textView4 = (TextView) view.findViewById(R.id.getCode);
                                        if (textView4 != null) {
                                            i = R.id.getFaceCode;
                                            TextView textView5 = (TextView) view.findViewById(R.id.getFaceCode);
                                            if (textView5 != null) {
                                                i = R.id.go2qrcode;
                                                TextView textView6 = (TextView) view.findViewById(R.id.go2qrcode);
                                                if (textView6 != null) {
                                                    i = R.id.grid;
                                                    GridView gridView = (GridView) view.findViewById(R.id.grid);
                                                    if (gridView != null) {
                                                        i = R.id.ivSet;
                                                        ImageView imageView = (ImageView) view.findViewById(R.id.ivSet);
                                                        if (imageView != null) {
                                                            i = R.id.jump_to_main;
                                                            TextView textView7 = (TextView) view.findViewById(R.id.jump_to_main);
                                                            if (textView7 != null) {
                                                                i = R.id.ll_account;
                                                                LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.ll_account);
                                                                if (linearLayout4 != null) {
                                                                    i = R.id.llQRConfirm;
                                                                    LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.llQRConfirm);
                                                                    if (linearLayout5 != null) {
                                                                        i = R.id.ll_qrcode;
                                                                        LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.ll_qrcode);
                                                                        if (linearLayout6 != null) {
                                                                            i = R.id.name_layout;
                                                                            LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.name_layout);
                                                                            if (linearLayout7 != null) {
                                                                                i = R.id.password_layout;
                                                                                LinearLayout linearLayout8 = (LinearLayout) view.findViewById(R.id.password_layout);
                                                                                if (linearLayout8 != null) {
                                                                                    i = R.id.progress;
                                                                                    ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress);
                                                                                    if (progressBar != null) {
                                                                                        i = R.id.psd;
                                                                                        YDEditText yDEditText = (YDEditText) view.findViewById(R.id.psd);
                                                                                        if (yDEditText != null) {
                                                                                            i = R.id.qrcode;
                                                                                            ImageView imageView2 = (ImageView) view.findViewById(R.id.qrcode);
                                                                                            if (imageView2 != null) {
                                                                                                i = R.id.register;
                                                                                                YDEditText yDEditText2 = (YDEditText) view.findViewById(R.id.register);
                                                                                                if (yDEditText2 != null) {
                                                                                                    i = R.id.registerBtn;
                                                                                                    TextView textView8 = (TextView) view.findViewById(R.id.registerBtn);
                                                                                                    if (textView8 != null) {
                                                                                                        i = R.id.register_layout;
                                                                                                        LinearLayout linearLayout9 = (LinearLayout) view.findViewById(R.id.register_layout);
                                                                                                        if (linearLayout9 != null) {
                                                                                                            i = R.id.school_layout;
                                                                                                            FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.school_layout);
                                                                                                            if (frameLayout3 != null) {
                                                                                                                i = R.id.showcode;
                                                                                                                TextView textView9 = (TextView) view.findViewById(R.id.showcode);
                                                                                                                if (textView9 != null) {
                                                                                                                    i = R.id.tips;
                                                                                                                    TextView textView10 = (TextView) view.findViewById(R.id.tips);
                                                                                                                    if (textView10 != null) {
                                                                                                                        i = R.id.tvAccount;
                                                                                                                        TextView textView11 = (TextView) view.findViewById(R.id.tvAccount);
                                                                                                                        if (textView11 != null) {
                                                                                                                            i = R.id.tvRegister;
                                                                                                                            TextView textView12 = (TextView) view.findViewById(R.id.tvRegister);
                                                                                                                            if (textView12 != null) {
                                                                                                                                i = R.id.user;
                                                                                                                                YDEditText yDEditText3 = (YDEditText) view.findViewById(R.id.user);
                                                                                                                                if (yDEditText3 != null) {
                                                                                                                                    i = R.id.welcome;
                                                                                                                                    LinearLayout linearLayout10 = (LinearLayout) view.findViewById(R.id.welcome);
                                                                                                                                    if (linearLayout10 != null) {
                                                                                                                                        return new ActivityLogin2Binding((FrameLayout) view, textView, textView2, linearLayout, linearLayout2, textView3, linearLayout3, frameLayout, frameLayout2, textView4, textView5, textView6, gridView, imageView, textView7, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, progressBar, yDEditText, imageView2, yDEditText2, textView8, linearLayout9, frameLayout3, textView9, textView10, textView11, textView12, yDEditText3, linearLayout10);
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
