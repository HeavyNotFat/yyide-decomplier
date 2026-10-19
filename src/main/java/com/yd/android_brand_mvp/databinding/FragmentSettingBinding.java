package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentSettingBinding implements ViewBinding {
    public final TextView activationTextview;
    public final FrameLayout bg;
    public final ImageView down;
    public final ImageView img;
    public final ImageView imgGetFace;
    public final LinearLayout layout1;
    public final LinearLayout layout10;
    public final LinearLayout layout11;
    public final LinearLayout layout3;
    public final LinearLayout layout4;
    public final LinearLayout layout5;
    public final LinearLayout layout6;
    public final LinearLayout layout7;
    public final LinearLayout layout8;
    public final LinearLayout layout88;
    public final LinearLayout layout9;
    public final LinearLayout layout99;
    public final LinearLayout layoutClose;
    public final LinearLayout layoutConfig;
    public final LinearLayout layoutGetFace;
    public final LinearLayout layoutNetworkTest;
    public final LinearLayout layoutOpen;
    public final LinearLayout layoutScreen;
    public final LinearLayout layoutSkin;
    public final LinearLayout llBack;
    public final TextView msg2;
    public final RelativeLayout rlBg;
    private final FrameLayout rootView;
    public final SeekBar seekBar;
    public final TextView title;
    public final TextView toplongview;
    public final ImageView tvBgImg;
    public final ImageView tvBgImg2;
    public final TextView tvConfig;
    public final TextView tvCurrentVolume;
    public final TextView tvLab3;
    public final TextView tvLab4;
    public final TextView tvScreen;
    public final TextView tvSkin;
    public final ImageView up;

    private FragmentSettingBinding(FrameLayout frameLayout, TextView textView, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, LinearLayout linearLayout10, LinearLayout linearLayout11, LinearLayout linearLayout12, LinearLayout linearLayout13, LinearLayout linearLayout14, LinearLayout linearLayout15, LinearLayout linearLayout16, LinearLayout linearLayout17, LinearLayout linearLayout18, LinearLayout linearLayout19, LinearLayout linearLayout20, TextView textView2, RelativeLayout relativeLayout, SeekBar seekBar, TextView textView3, TextView textView4, ImageView imageView4, ImageView imageView5, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, ImageView imageView6) {
        this.rootView = frameLayout;
        this.activationTextview = textView;
        this.bg = frameLayout2;
        this.down = imageView;
        this.img = imageView2;
        this.imgGetFace = imageView3;
        this.layout1 = linearLayout;
        this.layout10 = linearLayout2;
        this.layout11 = linearLayout3;
        this.layout3 = linearLayout4;
        this.layout4 = linearLayout5;
        this.layout5 = linearLayout6;
        this.layout6 = linearLayout7;
        this.layout7 = linearLayout8;
        this.layout8 = linearLayout9;
        this.layout88 = linearLayout10;
        this.layout9 = linearLayout11;
        this.layout99 = linearLayout12;
        this.layoutClose = linearLayout13;
        this.layoutConfig = linearLayout14;
        this.layoutGetFace = linearLayout15;
        this.layoutNetworkTest = linearLayout16;
        this.layoutOpen = linearLayout17;
        this.layoutScreen = linearLayout18;
        this.layoutSkin = linearLayout19;
        this.llBack = linearLayout20;
        this.msg2 = textView2;
        this.rlBg = relativeLayout;
        this.seekBar = seekBar;
        this.title = textView3;
        this.toplongview = textView4;
        this.tvBgImg = imageView4;
        this.tvBgImg2 = imageView5;
        this.tvConfig = textView5;
        this.tvCurrentVolume = textView6;
        this.tvLab3 = textView7;
        this.tvLab4 = textView8;
        this.tvScreen = textView9;
        this.tvSkin = textView10;
        this.up = imageView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentSettingBinding bind(View view) {
        int i = R.id.activation_textview;
        TextView textView = (TextView) view.findViewById(R.id.activation_textview);
        if (textView != null) {
            i = R.id.bg;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.bg);
            if (frameLayout != null) {
                i = R.id.down;
                ImageView imageView = (ImageView) view.findViewById(R.id.down);
                if (imageView != null) {
                    i = R.id.img;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.img);
                    if (imageView2 != null) {
                        i = R.id.img_get_face;
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.img_get_face);
                        if (imageView3 != null) {
                            i = R.id.layout1;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout1);
                            if (linearLayout != null) {
                                i = R.id.layout10;
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.layout10);
                                if (linearLayout2 != null) {
                                    i = R.id.layout11;
                                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.layout11);
                                    if (linearLayout3 != null) {
                                        i = R.id.layout3;
                                        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.layout3);
                                        if (linearLayout4 != null) {
                                            i = R.id.layout4;
                                            LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.layout4);
                                            if (linearLayout5 != null) {
                                                i = R.id.layout5;
                                                LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.layout5);
                                                if (linearLayout6 != null) {
                                                    i = R.id.layout6;
                                                    LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.layout6);
                                                    if (linearLayout7 != null) {
                                                        i = R.id.layout7;
                                                        LinearLayout linearLayout8 = (LinearLayout) view.findViewById(R.id.layout7);
                                                        if (linearLayout8 != null) {
                                                            i = R.id.layout8;
                                                            LinearLayout linearLayout9 = (LinearLayout) view.findViewById(R.id.layout8);
                                                            if (linearLayout9 != null) {
                                                                i = R.id.layout88;
                                                                LinearLayout linearLayout10 = (LinearLayout) view.findViewById(R.id.layout88);
                                                                if (linearLayout10 != null) {
                                                                    i = R.id.layout9;
                                                                    LinearLayout linearLayout11 = (LinearLayout) view.findViewById(R.id.layout9);
                                                                    if (linearLayout11 != null) {
                                                                        i = R.id.layout99;
                                                                        LinearLayout linearLayout12 = (LinearLayout) view.findViewById(R.id.layout99);
                                                                        if (linearLayout12 != null) {
                                                                            i = R.id.layout_close;
                                                                            LinearLayout linearLayout13 = (LinearLayout) view.findViewById(R.id.layout_close);
                                                                            if (linearLayout13 != null) {
                                                                                i = R.id.layout_config;
                                                                                LinearLayout linearLayout14 = (LinearLayout) view.findViewById(R.id.layout_config);
                                                                                if (linearLayout14 != null) {
                                                                                    i = R.id.layout_get_face;
                                                                                    LinearLayout linearLayout15 = (LinearLayout) view.findViewById(R.id.layout_get_face);
                                                                                    if (linearLayout15 != null) {
                                                                                        i = R.id.layout_network_test;
                                                                                        LinearLayout linearLayout16 = (LinearLayout) view.findViewById(R.id.layout_network_test);
                                                                                        if (linearLayout16 != null) {
                                                                                            i = R.id.layout_open;
                                                                                            LinearLayout linearLayout17 = (LinearLayout) view.findViewById(R.id.layout_open);
                                                                                            if (linearLayout17 != null) {
                                                                                                i = R.id.layout_screen;
                                                                                                LinearLayout linearLayout18 = (LinearLayout) view.findViewById(R.id.layout_screen);
                                                                                                if (linearLayout18 != null) {
                                                                                                    i = R.id.layout_skin;
                                                                                                    LinearLayout linearLayout19 = (LinearLayout) view.findViewById(R.id.layout_skin);
                                                                                                    if (linearLayout19 != null) {
                                                                                                        i = R.id.ll_back;
                                                                                                        LinearLayout linearLayout20 = (LinearLayout) view.findViewById(R.id.ll_back);
                                                                                                        if (linearLayout20 != null) {
                                                                                                            i = R.id.msg2;
                                                                                                            TextView textView2 = (TextView) view.findViewById(R.id.msg2);
                                                                                                            if (textView2 != null) {
                                                                                                                i = R.id.rl_bg;
                                                                                                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_bg);
                                                                                                                if (relativeLayout != null) {
                                                                                                                    i = R.id.seekBar;
                                                                                                                    SeekBar seekBar = (SeekBar) view.findViewById(R.id.seekBar);
                                                                                                                    if (seekBar != null) {
                                                                                                                        i = R.id.title;
                                                                                                                        TextView textView3 = (TextView) view.findViewById(R.id.title);
                                                                                                                        if (textView3 != null) {
                                                                                                                            i = R.id.toplongview;
                                                                                                                            TextView textView4 = (TextView) view.findViewById(R.id.toplongview);
                                                                                                                            if (textView4 != null) {
                                                                                                                                i = R.id.tv_bg_img;
                                                                                                                                ImageView imageView4 = (ImageView) view.findViewById(R.id.tv_bg_img);
                                                                                                                                if (imageView4 != null) {
                                                                                                                                    i = R.id.tv_bg_img2;
                                                                                                                                    ImageView imageView5 = (ImageView) view.findViewById(R.id.tv_bg_img2);
                                                                                                                                    if (imageView5 != null) {
                                                                                                                                        i = R.id.tvConfig;
                                                                                                                                        TextView textView5 = (TextView) view.findViewById(R.id.tvConfig);
                                                                                                                                        if (textView5 != null) {
                                                                                                                                            i = R.id.tv_currentVolume;
                                                                                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_currentVolume);
                                                                                                                                            if (textView6 != null) {
                                                                                                                                                i = R.id.tv_lab3;
                                                                                                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_lab3);
                                                                                                                                                if (textView7 != null) {
                                                                                                                                                    i = R.id.tv_lab4;
                                                                                                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_lab4);
                                                                                                                                                    if (textView8 != null) {
                                                                                                                                                        i = R.id.tvScreen;
                                                                                                                                                        TextView textView9 = (TextView) view.findViewById(R.id.tvScreen);
                                                                                                                                                        if (textView9 != null) {
                                                                                                                                                            i = R.id.tvSkin;
                                                                                                                                                            TextView textView10 = (TextView) view.findViewById(R.id.tvSkin);
                                                                                                                                                            if (textView10 != null) {
                                                                                                                                                                i = R.id.up;
                                                                                                                                                                ImageView imageView6 = (ImageView) view.findViewById(R.id.up);
                                                                                                                                                                if (imageView6 != null) {
                                                                                                                                                                    return new FragmentSettingBinding((FrameLayout) view, textView, frameLayout, imageView, imageView2, imageView3, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, linearLayout11, linearLayout12, linearLayout13, linearLayout14, linearLayout15, linearLayout16, linearLayout17, linearLayout18, linearLayout19, linearLayout20, textView2, relativeLayout, seekBar, textView3, textView4, imageView4, imageView5, textView5, textView6, textView7, textView8, textView9, textView10, imageView6);
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
