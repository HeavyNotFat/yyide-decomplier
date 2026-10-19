package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityEtherNetsMessageBinding implements ViewBinding {
    public final TextView alreadyOpen;
    public final CheckedTextView checkbox;
    public final CheckBox ckAuto;
    public final CheckBox ckNoAuto;
    public final EditText etDns1;
    public final EditText etDns2;
    public final EditText etGateway;
    public final EditText etIp;
    public final EditText etSubnet;
    public final LinearLayout etherBack;
    public final RelativeLayout layout1;
    public final RelativeLayout layout3;
    public final RelativeLayout layout4;
    public final RelativeLayout layout5;
    public final RelativeLayout layout6;
    public final RelativeLayout layout7;
    public final RelativeLayout rlTitle;
    private final LinearLayout rootView;
    public final TextView tvEtherAgency;
    public final TextView tvEtherMode;
    public final TextView tvMac;
    public final TextView tvSetIp;
    public final TextView tvWifi;

    private ActivityEtherNetsMessageBinding(LinearLayout linearLayout, TextView textView, CheckedTextView checkedTextView, CheckBox checkBox, CheckBox checkBox2, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, LinearLayout linearLayout2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = linearLayout;
        this.alreadyOpen = textView;
        this.checkbox = checkedTextView;
        this.ckAuto = checkBox;
        this.ckNoAuto = checkBox2;
        this.etDns1 = editText;
        this.etDns2 = editText2;
        this.etGateway = editText3;
        this.etIp = editText4;
        this.etSubnet = editText5;
        this.etherBack = linearLayout2;
        this.layout1 = relativeLayout;
        this.layout3 = relativeLayout2;
        this.layout4 = relativeLayout3;
        this.layout5 = relativeLayout4;
        this.layout6 = relativeLayout5;
        this.layout7 = relativeLayout6;
        this.rlTitle = relativeLayout7;
        this.tvEtherAgency = textView2;
        this.tvEtherMode = textView3;
        this.tvMac = textView4;
        this.tvSetIp = textView5;
        this.tvWifi = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityEtherNetsMessageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityEtherNetsMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_ether_nets_message, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityEtherNetsMessageBinding bind(View view) {
        int i = R.id.already_open;
        TextView textView = (TextView) view.findViewById(R.id.already_open);
        if (textView != null) {
            i = R.id.checkbox;
            CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.checkbox);
            if (checkedTextView != null) {
                i = R.id.ckAuto;
                CheckBox checkBox = (CheckBox) view.findViewById(R.id.ckAuto);
                if (checkBox != null) {
                    i = R.id.ckNoAuto;
                    CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.ckNoAuto);
                    if (checkBox2 != null) {
                        i = R.id.et_dns1;
                        EditText editText = (EditText) view.findViewById(R.id.et_dns1);
                        if (editText != null) {
                            i = R.id.et_dns2;
                            EditText editText2 = (EditText) view.findViewById(R.id.et_dns2);
                            if (editText2 != null) {
                                i = R.id.et_gateway;
                                EditText editText3 = (EditText) view.findViewById(R.id.et_gateway);
                                if (editText3 != null) {
                                    i = R.id.et_ip;
                                    EditText editText4 = (EditText) view.findViewById(R.id.et_ip);
                                    if (editText4 != null) {
                                        i = R.id.et_subnet;
                                        EditText editText5 = (EditText) view.findViewById(R.id.et_subnet);
                                        if (editText5 != null) {
                                            i = R.id.ether_back;
                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ether_back);
                                            if (linearLayout != null) {
                                                i = R.id.layout1;
                                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.layout1);
                                                if (relativeLayout != null) {
                                                    i = R.id.layout3;
                                                    RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.layout3);
                                                    if (relativeLayout2 != null) {
                                                        i = R.id.layout4;
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.layout4);
                                                        if (relativeLayout3 != null) {
                                                            i = R.id.layout5;
                                                            RelativeLayout relativeLayout4 = (RelativeLayout) view.findViewById(R.id.layout5);
                                                            if (relativeLayout4 != null) {
                                                                i = R.id.layout6;
                                                                RelativeLayout relativeLayout5 = (RelativeLayout) view.findViewById(R.id.layout6);
                                                                if (relativeLayout5 != null) {
                                                                    i = R.id.layout7;
                                                                    RelativeLayout relativeLayout6 = (RelativeLayout) view.findViewById(R.id.layout7);
                                                                    if (relativeLayout6 != null) {
                                                                        i = R.id.rl_title;
                                                                        RelativeLayout relativeLayout7 = (RelativeLayout) view.findViewById(R.id.rl_title);
                                                                        if (relativeLayout7 != null) {
                                                                            i = R.id.tv_ether_agency;
                                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_ether_agency);
                                                                            if (textView2 != null) {
                                                                                i = R.id.tv_ether_mode;
                                                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_ether_mode);
                                                                                if (textView3 != null) {
                                                                                    i = R.id.tv_mac;
                                                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_mac);
                                                                                    if (textView4 != null) {
                                                                                        i = R.id.tvSetIp;
                                                                                        TextView textView5 = (TextView) view.findViewById(R.id.tvSetIp);
                                                                                        if (textView5 != null) {
                                                                                            i = R.id.tv_wifi;
                                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_wifi);
                                                                                            if (textView6 != null) {
                                                                                                return new ActivityEtherNetsMessageBinding((LinearLayout) view, textView, checkedTextView, checkBox, checkBox2, editText, editText2, editText3, editText4, editText5, linearLayout, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, textView2, textView3, textView4, textView5, textView6);
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
