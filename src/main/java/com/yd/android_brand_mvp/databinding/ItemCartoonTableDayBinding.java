package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemCartoonTableDayBinding implements ViewBinding {
    public final ConstraintLayout constraintLayout;

    /* JADX INFO: renamed from: no, reason: collision with root package name */
    public final TextView f2007no;
    private final ConstraintLayout rootView;
    public final TextView seletionEnglish;
    public final TextView tvTableIng;
    public final TextView tvTableName;
    public final TextView tvTableTeacherName;
    public final TextView tvTableTime;

    private ItemCartoonTableDayBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.constraintLayout = constraintLayout2;
        this.f2007no = textView;
        this.seletionEnglish = textView2;
        this.tvTableIng = textView3;
        this.tvTableName = textView4;
        this.tvTableTeacherName = textView5;
        this.tvTableTime = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemCartoonTableDayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemCartoonTableDayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_cartoon_table_day, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemCartoonTableDayBinding bind(View view) {
        int i = R.id.constraintLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.constraintLayout);
        if (constraintLayout != null) {
            i = R.id.no;
            TextView textView = (TextView) view.findViewById(R.id.no);
            if (textView != null) {
                i = R.id.seletionEnglish;
                TextView textView2 = (TextView) view.findViewById(R.id.seletionEnglish);
                if (textView2 != null) {
                    i = R.id.tv_table_ing;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_table_ing);
                    if (textView3 != null) {
                        i = R.id.tv_table_name;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_table_name);
                        if (textView4 != null) {
                            i = R.id.tv_table_teacher_name;
                            TextView textView5 = (TextView) view.findViewById(R.id.tv_table_teacher_name);
                            if (textView5 != null) {
                                i = R.id.tv_table_time;
                                TextView textView6 = (TextView) view.findViewById(R.id.tv_table_time);
                                if (textView6 != null) {
                                    return new ItemCartoonTableDayBinding((ConstraintLayout) view, constraintLayout, textView, textView2, textView3, textView4, textView5, textView6);
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
