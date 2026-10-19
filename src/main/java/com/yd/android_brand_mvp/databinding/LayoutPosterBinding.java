package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutPosterBinding implements ViewBinding {
    public final ConstraintLayout clposter;
    public final RecyclerView posterRecyclerView;
    public final RadioButton rbMonth1;
    public final RadioButton rbToday1;
    public final RadioButton rbTrimester1;
    public final RadioButton rbWeek1;
    public final RadioGroup rgCheck1;
    private final ConstraintLayout rootView;
    public final TextView tvNext;
    public final TextView tvPageNumber;
    public final TextView tvUpPage;

    private LayoutPosterBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioGroup radioGroup, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.clposter = constraintLayout2;
        this.posterRecyclerView = recyclerView;
        this.rbMonth1 = radioButton;
        this.rbToday1 = radioButton2;
        this.rbTrimester1 = radioButton3;
        this.rbWeek1 = radioButton4;
        this.rgCheck1 = radioGroup;
        this.tvNext = textView;
        this.tvPageNumber = textView2;
        this.tvUpPage = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutPosterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutPosterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_poster, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutPosterBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.posterRecyclerView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.posterRecyclerView);
        if (recyclerView != null) {
            i = R.id.rb_month1;
            RadioButton radioButton = (RadioButton) view.findViewById(R.id.rb_month1);
            if (radioButton != null) {
                i = R.id.rb_today1;
                RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.rb_today1);
                if (radioButton2 != null) {
                    i = R.id.rb_trimester1;
                    RadioButton radioButton3 = (RadioButton) view.findViewById(R.id.rb_trimester1);
                    if (radioButton3 != null) {
                        i = R.id.rb_week1;
                        RadioButton radioButton4 = (RadioButton) view.findViewById(R.id.rb_week1);
                        if (radioButton4 != null) {
                            i = R.id.rg_check1;
                            RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.rg_check1);
                            if (radioGroup != null) {
                                i = R.id.tvNext;
                                TextView textView = (TextView) view.findViewById(R.id.tvNext);
                                if (textView != null) {
                                    i = R.id.tvPageNumber;
                                    TextView textView2 = (TextView) view.findViewById(R.id.tvPageNumber);
                                    if (textView2 != null) {
                                        i = R.id.tvUpPage;
                                        TextView textView3 = (TextView) view.findViewById(R.id.tvUpPage);
                                        if (textView3 != null) {
                                            return new LayoutPosterBinding(constraintLayout, constraintLayout, recyclerView, radioButton, radioButton2, radioButton3, radioButton4, radioGroup, textView, textView2, textView3);
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
