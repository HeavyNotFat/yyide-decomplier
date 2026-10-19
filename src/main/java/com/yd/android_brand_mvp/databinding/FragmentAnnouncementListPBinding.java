package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAnnouncementListPBinding implements ViewBinding {
    public final EditText etSearchTitle;
    public final RelativeLayout rlBt;
    private final LinearLayout rootView;
    public final RecyclerView rvList;
    public final TextView tvCount;
    public final TextView tvEndTime;
    public final TextView tvReset;
    public final TextView tvSearch;
    public final TextView tvStartTime;
    public final View viewLine;

    private FragmentAnnouncementListPBinding(LinearLayout linearLayout, EditText editText, RelativeLayout relativeLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view) {
        this.rootView = linearLayout;
        this.etSearchTitle = editText;
        this.rlBt = relativeLayout;
        this.rvList = recyclerView;
        this.tvCount = textView;
        this.tvEndTime = textView2;
        this.tvReset = textView3;
        this.tvSearch = textView4;
        this.tvStartTime = textView5;
        this.viewLine = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAnnouncementListPBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAnnouncementListPBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_announcement_list_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAnnouncementListPBinding bind(View view) {
        int i = R.id.etSearchTitle;
        EditText editText = (EditText) view.findViewById(R.id.etSearchTitle);
        if (editText != null) {
            i = R.id.rl_bt;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_bt);
            if (relativeLayout != null) {
                i = R.id.rv_list;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
                if (recyclerView != null) {
                    i = R.id.tv_count;
                    TextView textView = (TextView) view.findViewById(R.id.tv_count);
                    if (textView != null) {
                        i = R.id.tvEndTime;
                        TextView textView2 = (TextView) view.findViewById(R.id.tvEndTime);
                        if (textView2 != null) {
                            i = R.id.tvReset;
                            TextView textView3 = (TextView) view.findViewById(R.id.tvReset);
                            if (textView3 != null) {
                                i = R.id.tvSearch;
                                TextView textView4 = (TextView) view.findViewById(R.id.tvSearch);
                                if (textView4 != null) {
                                    i = R.id.tvStartTime;
                                    TextView textView5 = (TextView) view.findViewById(R.id.tvStartTime);
                                    if (textView5 != null) {
                                        i = R.id.view_line;
                                        View viewFindViewById = view.findViewById(R.id.view_line);
                                        if (viewFindViewById != null) {
                                            return new FragmentAnnouncementListPBinding((LinearLayout) view, editText, relativeLayout, recyclerView, textView, textView2, textView3, textView4, textView5, viewFindViewById);
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
