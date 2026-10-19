package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAnnouncementListBinding implements ViewBinding {
    public final EditText etSearchTitle;
    public final LayoutListAnnouncementBinding layoutContent;
    public final LayoutPosterBinding layoutPoster;
    public final LinearLayout llContent;
    public final MultiStateView mu;
    private final LinearLayout rootView;
    public final RecyclerView rvList;
    public final TextView tvEndTime;
    public final TextView tvNumber;
    public final TextView tvReset;
    public final TextView tvSearch;
    public final TextView tvStartTime;
    public final View viewLine;

    private FragmentAnnouncementListBinding(LinearLayout linearLayout, EditText editText, LayoutListAnnouncementBinding layoutListAnnouncementBinding, LayoutPosterBinding layoutPosterBinding, LinearLayout linearLayout2, MultiStateView multiStateView, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view) {
        this.rootView = linearLayout;
        this.etSearchTitle = editText;
        this.layoutContent = layoutListAnnouncementBinding;
        this.layoutPoster = layoutPosterBinding;
        this.llContent = linearLayout2;
        this.mu = multiStateView;
        this.rvList = recyclerView;
        this.tvEndTime = textView;
        this.tvNumber = textView2;
        this.tvReset = textView3;
        this.tvSearch = textView4;
        this.tvStartTime = textView5;
        this.viewLine = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAnnouncementListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAnnouncementListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_announcement_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAnnouncementListBinding bind(View view) {
        int i = R.id.etSearchTitle;
        EditText editText = (EditText) view.findViewById(R.id.etSearchTitle);
        if (editText != null) {
            i = R.id.layout_content;
            View viewFindViewById = view.findViewById(R.id.layout_content);
            if (viewFindViewById != null) {
                LayoutListAnnouncementBinding layoutListAnnouncementBindingBind = LayoutListAnnouncementBinding.bind(viewFindViewById);
                i = R.id.layout_poster;
                View viewFindViewById2 = view.findViewById(R.id.layout_poster);
                if (viewFindViewById2 != null) {
                    LayoutPosterBinding layoutPosterBindingBind = LayoutPosterBinding.bind(viewFindViewById2);
                    i = R.id.llContent;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.llContent);
                    if (linearLayout != null) {
                        i = R.id.mu;
                        MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                        if (multiStateView != null) {
                            i = R.id.rv_list;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
                            if (recyclerView != null) {
                                i = R.id.tvEndTime;
                                TextView textView = (TextView) view.findViewById(R.id.tvEndTime);
                                if (textView != null) {
                                    i = R.id.tvNumber;
                                    TextView textView2 = (TextView) view.findViewById(R.id.tvNumber);
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
                                                    i = R.id.viewLine;
                                                    View viewFindViewById3 = view.findViewById(R.id.viewLine);
                                                    if (viewFindViewById3 != null) {
                                                        return new FragmentAnnouncementListBinding((LinearLayout) view, editText, layoutListAnnouncementBindingBind, layoutPosterBindingBind, linearLayout, multiStateView, recyclerView, textView, textView2, textView3, textView4, textView5, viewFindViewById3);
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
