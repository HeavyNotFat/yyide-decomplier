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
public final class ActivityPatrolListBinding implements ViewBinding {
    public final ConstraintLayout clActivityPatrolList;
    private final ConstraintLayout rootView;
    public final RecyclerView rvActivityPatrolList;
    public final TextView tvActivityPatrolListEnd;
    public final TextView tvActivityPatrolListIng;
    public final TextView tvActivityPatrolListOver;
    public final TextView tvActivityPatrolListSite;
    public final TextView tvActivityPatrolListSiteTip;
    public final TextView tvActivityPatrolListUser;

    private ActivityPatrolListBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.clActivityPatrolList = constraintLayout2;
        this.rvActivityPatrolList = recyclerView;
        this.tvActivityPatrolListEnd = textView;
        this.tvActivityPatrolListIng = textView2;
        this.tvActivityPatrolListOver = textView3;
        this.tvActivityPatrolListSite = textView4;
        this.tvActivityPatrolListSiteTip = textView5;
        this.tvActivityPatrolListUser = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPatrolListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityPatrolListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_patrol_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityPatrolListBinding bind(View view) {
        int i = R.id.cl_activity_patrol_list;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_activity_patrol_list);
        if (constraintLayout != null) {
            i = R.id.rv_activity_patrol_list;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_activity_patrol_list);
            if (recyclerView != null) {
                i = R.id.tv_activity_patrol_list_end;
                TextView textView = (TextView) view.findViewById(R.id.tv_activity_patrol_list_end);
                if (textView != null) {
                    i = R.id.tv_activity_patrol_list_ing;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_activity_patrol_list_ing);
                    if (textView2 != null) {
                        i = R.id.tv_activity_patrol_list_over;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_activity_patrol_list_over);
                        if (textView3 != null) {
                            i = R.id.tv_activity_patrol_list_site;
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_activity_patrol_list_site);
                            if (textView4 != null) {
                                i = R.id.tv_activity_patrol_list_site_tip;
                                TextView textView5 = (TextView) view.findViewById(R.id.tv_activity_patrol_list_site_tip);
                                if (textView5 != null) {
                                    i = R.id.tv_activity_patrol_list_user;
                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_activity_patrol_list_user);
                                    if (textView6 != null) {
                                        return new ActivityPatrolListBinding((ConstraintLayout) view, constraintLayout, recyclerView, textView, textView2, textView3, textView4, textView5, textView6);
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
