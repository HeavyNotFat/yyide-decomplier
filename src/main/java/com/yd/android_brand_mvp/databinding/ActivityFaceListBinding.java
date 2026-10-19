package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityFaceListBinding implements ViewBinding {
    public final ConstraintLayout clItem;
    public final ConstraintLayout constraintlayout;
    public final ConstraintLayout gankConstraintlayout3;
    public final TextView gankTextview3;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TitleLayoutBinding top;
    public final TextView tv1;
    public final TextView tv2;
    public final TextView tv3;
    public final TextView tvConfirm;
    public final TextView tvDesc;
    public final TextView tvFaveNumber;

    private ActivityFaceListBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView, RecyclerView recyclerView, TitleLayoutBinding titleLayoutBinding, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = constraintLayout;
        this.clItem = constraintLayout2;
        this.constraintlayout = constraintLayout3;
        this.gankConstraintlayout3 = constraintLayout4;
        this.gankTextview3 = textView;
        this.recyclerView = recyclerView;
        this.top = titleLayoutBinding;
        this.tv1 = textView2;
        this.tv2 = textView3;
        this.tv3 = textView4;
        this.tvConfirm = textView5;
        this.tvDesc = textView6;
        this.tvFaveNumber = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFaceListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityFaceListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_face_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFaceListBinding bind(View view) {
        int i = R.id.clItem;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.clItem);
        if (constraintLayout != null) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
            i = R.id.gank_constraintlayout3;
            ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.gank_constraintlayout3);
            if (constraintLayout3 != null) {
                i = R.id.gank_textview3;
                TextView textView = (TextView) view.findViewById(R.id.gank_textview3);
                if (textView != null) {
                    i = R.id.recyclerView;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                    if (recyclerView != null) {
                        i = R.id.top;
                        View viewFindViewById = view.findViewById(R.id.top);
                        if (viewFindViewById != null) {
                            TitleLayoutBinding titleLayoutBindingBind = TitleLayoutBinding.bind(viewFindViewById);
                            i = R.id.tv1;
                            TextView textView2 = (TextView) view.findViewById(R.id.tv1);
                            if (textView2 != null) {
                                i = R.id.tv2;
                                TextView textView3 = (TextView) view.findViewById(R.id.tv2);
                                if (textView3 != null) {
                                    i = R.id.tv3;
                                    TextView textView4 = (TextView) view.findViewById(R.id.tv3);
                                    if (textView4 != null) {
                                        i = R.id.tvConfirm;
                                        TextView textView5 = (TextView) view.findViewById(R.id.tvConfirm);
                                        if (textView5 != null) {
                                            i = R.id.tvDesc;
                                            TextView textView6 = (TextView) view.findViewById(R.id.tvDesc);
                                            if (textView6 != null) {
                                                i = R.id.tvFaveNumber;
                                                TextView textView7 = (TextView) view.findViewById(R.id.tvFaveNumber);
                                                if (textView7 != null) {
                                                    return new ActivityFaceListBinding(constraintLayout2, constraintLayout, constraintLayout2, constraintLayout3, textView, recyclerView, titleLayoutBindingBind, textView2, textView3, textView4, textView5, textView6, textView7);
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
