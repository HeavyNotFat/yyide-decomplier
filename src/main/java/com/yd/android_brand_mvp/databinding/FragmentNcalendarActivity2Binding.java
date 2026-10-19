package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.customview.MyGridView;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentNcalendarActivity2Binding implements ViewBinding {
    public final MultiStateView allMu;
    public final LinearLayout layoutMonth;
    public final LinearLayout layoutWeek;
    public final ListView listview;
    public final LinearLayout lyaoutYear;
    public final MultiStateView mu;
    private final LinearLayout rootView;
    public final GridView topGrid;
    public final MyGridView weekGrid;

    private FragmentNcalendarActivity2Binding(LinearLayout linearLayout, MultiStateView multiStateView, LinearLayout linearLayout2, LinearLayout linearLayout3, ListView listView, LinearLayout linearLayout4, MultiStateView multiStateView2, GridView gridView, MyGridView myGridView) {
        this.rootView = linearLayout;
        this.allMu = multiStateView;
        this.layoutMonth = linearLayout2;
        this.layoutWeek = linearLayout3;
        this.listview = listView;
        this.lyaoutYear = linearLayout4;
        this.mu = multiStateView2;
        this.topGrid = gridView;
        this.weekGrid = myGridView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentNcalendarActivity2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentNcalendarActivity2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ncalendar_activity2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentNcalendarActivity2Binding bind(View view) {
        int i = R.id.all_mu;
        MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.all_mu);
        if (multiStateView != null) {
            i = R.id.layout_month;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_month);
            if (linearLayout != null) {
                i = R.id.layout_week;
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.layout_week);
                if (linearLayout2 != null) {
                    i = R.id.listview;
                    ListView listView = (ListView) view.findViewById(R.id.listview);
                    if (listView != null) {
                        i = R.id.lyaout_year;
                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.lyaout_year);
                        if (linearLayout3 != null) {
                            i = R.id.mu;
                            MultiStateView multiStateView2 = (MultiStateView) view.findViewById(R.id.mu);
                            if (multiStateView2 != null) {
                                i = R.id.top_grid;
                                GridView gridView = (GridView) view.findViewById(R.id.top_grid);
                                if (gridView != null) {
                                    i = R.id.week_grid;
                                    MyGridView myGridView = (MyGridView) view.findViewById(R.id.week_grid);
                                    if (myGridView != null) {
                                        return new FragmentNcalendarActivity2Binding((LinearLayout) view, multiStateView, linearLayout, linearLayout2, listView, linearLayout3, multiStateView2, gridView, myGridView);
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
