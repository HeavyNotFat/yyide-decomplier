package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.makeramen.roundedimageview.RoundedImageView;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentUserLayout4Binding implements ViewBinding {
    public final FrameLayout content;
    public final CheckedTextView iconcheck1;
    public final CheckedTextView iconcheck2;
    public final CheckedTextView iconcheck3;
    public final CheckedTextView iconcheck4;
    public final CheckedTextView iconcheck5;
    public final CheckedTextView iconcheck6;
    public final CheckedTextView iconcheck7;
    public final RoundedImageView img;
    public final TextView name;
    private final FrameLayout rootView;
    public final LinearLayout tab1;
    public final LinearLayout tab2;
    public final LinearLayout tab3;
    public final LinearLayout tab4;
    public final LinearLayout tab5;
    public final LinearLayout tab6;
    public final LinearLayout tab7;
    public final TextView teacherName;
    public final CheckedTextView textcheck1;
    public final CheckedTextView textcheck2;
    public final CheckedTextView textcheck3;
    public final CheckedTextView textcheck4;
    public final CheckedTextView textcheck5;
    public final CheckedTextView textcheck6;
    public final CheckedTextView textcheck7;
    public final TextView tvClassName;

    private FragmentUserLayout4Binding(FrameLayout frameLayout, FrameLayout frameLayout2, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, CheckedTextView checkedTextView3, CheckedTextView checkedTextView4, CheckedTextView checkedTextView5, CheckedTextView checkedTextView6, CheckedTextView checkedTextView7, RoundedImageView roundedImageView, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, TextView textView2, CheckedTextView checkedTextView8, CheckedTextView checkedTextView9, CheckedTextView checkedTextView10, CheckedTextView checkedTextView11, CheckedTextView checkedTextView12, CheckedTextView checkedTextView13, CheckedTextView checkedTextView14, TextView textView3) {
        this.rootView = frameLayout;
        this.content = frameLayout2;
        this.iconcheck1 = checkedTextView;
        this.iconcheck2 = checkedTextView2;
        this.iconcheck3 = checkedTextView3;
        this.iconcheck4 = checkedTextView4;
        this.iconcheck5 = checkedTextView5;
        this.iconcheck6 = checkedTextView6;
        this.iconcheck7 = checkedTextView7;
        this.img = roundedImageView;
        this.name = textView;
        this.tab1 = linearLayout;
        this.tab2 = linearLayout2;
        this.tab3 = linearLayout3;
        this.tab4 = linearLayout4;
        this.tab5 = linearLayout5;
        this.tab6 = linearLayout6;
        this.tab7 = linearLayout7;
        this.teacherName = textView2;
        this.textcheck1 = checkedTextView8;
        this.textcheck2 = checkedTextView9;
        this.textcheck3 = checkedTextView10;
        this.textcheck4 = checkedTextView11;
        this.textcheck5 = checkedTextView12;
        this.textcheck6 = checkedTextView13;
        this.textcheck7 = checkedTextView14;
        this.tvClassName = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentUserLayout4Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUserLayout4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_user_layout4, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentUserLayout4Binding bind(View view) {
        int i = R.id.content;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content);
        if (frameLayout != null) {
            i = R.id.iconcheck1;
            CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.iconcheck1);
            if (checkedTextView != null) {
                i = R.id.iconcheck2;
                CheckedTextView checkedTextView2 = (CheckedTextView) view.findViewById(R.id.iconcheck2);
                if (checkedTextView2 != null) {
                    i = R.id.iconcheck3;
                    CheckedTextView checkedTextView3 = (CheckedTextView) view.findViewById(R.id.iconcheck3);
                    if (checkedTextView3 != null) {
                        i = R.id.iconcheck4;
                        CheckedTextView checkedTextView4 = (CheckedTextView) view.findViewById(R.id.iconcheck4);
                        if (checkedTextView4 != null) {
                            i = R.id.iconcheck5;
                            CheckedTextView checkedTextView5 = (CheckedTextView) view.findViewById(R.id.iconcheck5);
                            if (checkedTextView5 != null) {
                                i = R.id.iconcheck6;
                                CheckedTextView checkedTextView6 = (CheckedTextView) view.findViewById(R.id.iconcheck6);
                                if (checkedTextView6 != null) {
                                    i = R.id.iconcheck7;
                                    CheckedTextView checkedTextView7 = (CheckedTextView) view.findViewById(R.id.iconcheck7);
                                    if (checkedTextView7 != null) {
                                        i = R.id.img;
                                        RoundedImageView roundedImageView = (RoundedImageView) view.findViewById(R.id.img);
                                        if (roundedImageView != null) {
                                            i = R.id.name;
                                            TextView textView = (TextView) view.findViewById(R.id.name);
                                            if (textView != null) {
                                                i = R.id.tab1;
                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.tab1);
                                                if (linearLayout != null) {
                                                    i = R.id.tab2;
                                                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.tab2);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.tab3;
                                                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.tab3);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.tab4;
                                                            LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.tab4);
                                                            if (linearLayout4 != null) {
                                                                i = R.id.tab5;
                                                                LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.tab5);
                                                                if (linearLayout5 != null) {
                                                                    i = R.id.tab6;
                                                                    LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.tab6);
                                                                    if (linearLayout6 != null) {
                                                                        i = R.id.tab7;
                                                                        LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.tab7);
                                                                        if (linearLayout7 != null) {
                                                                            i = R.id.teacherName;
                                                                            TextView textView2 = (TextView) view.findViewById(R.id.teacherName);
                                                                            if (textView2 != null) {
                                                                                i = R.id.textcheck1;
                                                                                CheckedTextView checkedTextView8 = (CheckedTextView) view.findViewById(R.id.textcheck1);
                                                                                if (checkedTextView8 != null) {
                                                                                    i = R.id.textcheck2;
                                                                                    CheckedTextView checkedTextView9 = (CheckedTextView) view.findViewById(R.id.textcheck2);
                                                                                    if (checkedTextView9 != null) {
                                                                                        i = R.id.textcheck3;
                                                                                        CheckedTextView checkedTextView10 = (CheckedTextView) view.findViewById(R.id.textcheck3);
                                                                                        if (checkedTextView10 != null) {
                                                                                            i = R.id.textcheck4;
                                                                                            CheckedTextView checkedTextView11 = (CheckedTextView) view.findViewById(R.id.textcheck4);
                                                                                            if (checkedTextView11 != null) {
                                                                                                i = R.id.textcheck5;
                                                                                                CheckedTextView checkedTextView12 = (CheckedTextView) view.findViewById(R.id.textcheck5);
                                                                                                if (checkedTextView12 != null) {
                                                                                                    i = R.id.textcheck6;
                                                                                                    CheckedTextView checkedTextView13 = (CheckedTextView) view.findViewById(R.id.textcheck6);
                                                                                                    if (checkedTextView13 != null) {
                                                                                                        i = R.id.textcheck7;
                                                                                                        CheckedTextView checkedTextView14 = (CheckedTextView) view.findViewById(R.id.textcheck7);
                                                                                                        if (checkedTextView14 != null) {
                                                                                                            i = R.id.tv_class_name;
                                                                                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_class_name);
                                                                                                            if (textView3 != null) {
                                                                                                                return new FragmentUserLayout4Binding((FrameLayout) view, frameLayout, checkedTextView, checkedTextView2, checkedTextView3, checkedTextView4, checkedTextView5, checkedTextView6, checkedTextView7, roundedImageView, textView, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, textView2, checkedTextView8, checkedTextView9, checkedTextView10, checkedTextView11, checkedTextView12, checkedTextView13, checkedTextView14, textView3);
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
