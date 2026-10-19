package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDEditText;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivitySkyworthLoginBinding implements ViewBinding {
    public final YDEditText active;
    public final TextView activeError;
    public final Button btnActive;
    public final Button btnLogin;
    public final Button btnRegister;
    public final Button btnSkip;
    public final ConstraintLayout clActive;
    public final ConstraintLayout clLogin;
    public final ConstraintLayout clRegister;
    public final TextView error;
    public final Guideline guideline;
    public final LinearLayoutCompat linearLayoutCompat5;
    public final YDEditText pwd;
    public final YDEditText register;
    public final TextView registerError;
    private final ConstraintLayout rootView;
    public final TextView textView15;
    public final TextView tvActiveCode;
    public final TextView tvRegisterCode;
    public final YDEditText user;

    private ActivitySkyworthLoginBinding(ConstraintLayout constraintLayout, YDEditText yDEditText, TextView textView, Button button, Button button2, Button button3, Button button4, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView2, Guideline guideline, LinearLayoutCompat linearLayoutCompat, YDEditText yDEditText2, YDEditText yDEditText3, TextView textView3, TextView textView4, TextView textView5, TextView textView6, YDEditText yDEditText4) {
        this.rootView = constraintLayout;
        this.active = yDEditText;
        this.activeError = textView;
        this.btnActive = button;
        this.btnLogin = button2;
        this.btnRegister = button3;
        this.btnSkip = button4;
        this.clActive = constraintLayout2;
        this.clLogin = constraintLayout3;
        this.clRegister = constraintLayout4;
        this.error = textView2;
        this.guideline = guideline;
        this.linearLayoutCompat5 = linearLayoutCompat;
        this.pwd = yDEditText2;
        this.register = yDEditText3;
        this.registerError = textView3;
        this.textView15 = textView4;
        this.tvActiveCode = textView5;
        this.tvRegisterCode = textView6;
        this.user = yDEditText4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySkyworthLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySkyworthLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_skyworth_login, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySkyworthLoginBinding bind(View view) {
        int i = R.id.active;
        YDEditText yDEditText = (YDEditText) view.findViewById(R.id.active);
        if (yDEditText != null) {
            i = R.id.active_error;
            TextView textView = (TextView) view.findViewById(R.id.active_error);
            if (textView != null) {
                i = R.id.btn_active;
                Button button = (Button) view.findViewById(R.id.btn_active);
                if (button != null) {
                    i = R.id.btn_login;
                    Button button2 = (Button) view.findViewById(R.id.btn_login);
                    if (button2 != null) {
                        i = R.id.btn_register;
                        Button button3 = (Button) view.findViewById(R.id.btn_register);
                        if (button3 != null) {
                            i = R.id.btn_skip;
                            Button button4 = (Button) view.findViewById(R.id.btn_skip);
                            if (button4 != null) {
                                i = R.id.clActive;
                                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.clActive);
                                if (constraintLayout != null) {
                                    i = R.id.clLogin;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.clLogin);
                                    if (constraintLayout2 != null) {
                                        i = R.id.clRegister;
                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.clRegister);
                                        if (constraintLayout3 != null) {
                                            i = R.id.error;
                                            TextView textView2 = (TextView) view.findViewById(R.id.error);
                                            if (textView2 != null) {
                                                i = R.id.guideline;
                                                Guideline guideline = (Guideline) view.findViewById(R.id.guideline);
                                                if (guideline != null) {
                                                    i = R.id.linearLayoutCompat5;
                                                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.linearLayoutCompat5);
                                                    if (linearLayoutCompat != null) {
                                                        i = R.id.pwd;
                                                        YDEditText yDEditText2 = (YDEditText) view.findViewById(R.id.pwd);
                                                        if (yDEditText2 != null) {
                                                            i = R.id.register;
                                                            YDEditText yDEditText3 = (YDEditText) view.findViewById(R.id.register);
                                                            if (yDEditText3 != null) {
                                                                i = R.id.register_error;
                                                                TextView textView3 = (TextView) view.findViewById(R.id.register_error);
                                                                if (textView3 != null) {
                                                                    i = R.id.textView15;
                                                                    TextView textView4 = (TextView) view.findViewById(R.id.textView15);
                                                                    if (textView4 != null) {
                                                                        i = R.id.tvActiveCode;
                                                                        TextView textView5 = (TextView) view.findViewById(R.id.tvActiveCode);
                                                                        if (textView5 != null) {
                                                                            i = R.id.tvRegisterCode;
                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tvRegisterCode);
                                                                            if (textView6 != null) {
                                                                                i = R.id.user;
                                                                                YDEditText yDEditText4 = (YDEditText) view.findViewById(R.id.user);
                                                                                if (yDEditText4 != null) {
                                                                                    return new ActivitySkyworthLoginBinding((ConstraintLayout) view, yDEditText, textView, button, button2, button3, button4, constraintLayout, constraintLayout2, constraintLayout3, textView2, guideline, linearLayoutCompat, yDEditText2, yDEditText3, textView3, textView4, textView5, textView6, yDEditText4);
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
