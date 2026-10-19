package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityDoorControlBinding implements ViewBinding {
    public final FrameLayout Reconnection;
    public final TextView back;
    public final FrameLayout delectconnect;
    public final TextView device;
    public final LinearLayout llBack;
    public final Button open;
    private final LinearLayout rootView;
    public final TextView title;
    public final TextView tvRC;
    public final TextView tvUD;

    private ActivityDoorControlBinding(LinearLayout linearLayout, FrameLayout frameLayout, TextView textView, FrameLayout frameLayout2, TextView textView2, LinearLayout linearLayout2, Button button, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.Reconnection = frameLayout;
        this.back = textView;
        this.delectconnect = frameLayout2;
        this.device = textView2;
        this.llBack = linearLayout2;
        this.open = button;
        this.title = textView3;
        this.tvRC = textView4;
        this.tvUD = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDoorControlBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDoorControlBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_door_control, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDoorControlBinding bind(View view) {
        int i = R.id.Reconnection;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.Reconnection);
        if (frameLayout != null) {
            i = R.id.back;
            TextView textView = (TextView) view.findViewById(R.id.back);
            if (textView != null) {
                i = R.id.delectconnect;
                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.delectconnect);
                if (frameLayout2 != null) {
                    i = R.id.device;
                    TextView textView2 = (TextView) view.findViewById(R.id.device);
                    if (textView2 != null) {
                        i = R.id.ll_back;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_back);
                        if (linearLayout != null) {
                            i = R.id.open;
                            Button button = (Button) view.findViewById(R.id.open);
                            if (button != null) {
                                i = R.id.title;
                                TextView textView3 = (TextView) view.findViewById(R.id.title);
                                if (textView3 != null) {
                                    i = R.id.tvRC;
                                    TextView textView4 = (TextView) view.findViewById(R.id.tvRC);
                                    if (textView4 != null) {
                                        i = R.id.tvUD;
                                        TextView textView5 = (TextView) view.findViewById(R.id.tvUD);
                                        if (textView5 != null) {
                                            return new ActivityDoorControlBinding((LinearLayout) view, frameLayout, textView, frameLayout2, textView2, linearLayout, button, textView3, textView4, textView5);
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
