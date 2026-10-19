package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentHomeVote23Binding implements ViewBinding {
    public final Banner bannerFragmentHomeVote23;
    public final TextView btnFragmentHomeVote23;
    public final ConstraintLayout clFragmentHomeVote23;
    public final ViewStub emptyView;
    private final ConstraintLayout rootView;
    public final LayoutHeadTitleBinding topFragmentHomeVote23;

    private FragmentHomeVote23Binding(ConstraintLayout constraintLayout, Banner banner, TextView textView, ConstraintLayout constraintLayout2, ViewStub viewStub, LayoutHeadTitleBinding layoutHeadTitleBinding) {
        this.rootView = constraintLayout;
        this.bannerFragmentHomeVote23 = banner;
        this.btnFragmentHomeVote23 = textView;
        this.clFragmentHomeVote23 = constraintLayout2;
        this.emptyView = viewStub;
        this.topFragmentHomeVote23 = layoutHeadTitleBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomeVote23Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHomeVote23Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_home_vote23, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHomeVote23Binding bind(View view) {
        int i = R.id.banner_fragment_home_vote23;
        Banner banner = (Banner) view.findViewById(R.id.banner_fragment_home_vote23);
        if (banner != null) {
            i = R.id.btn_fragment_home_vote23;
            TextView textView = (TextView) view.findViewById(R.id.btn_fragment_home_vote23);
            if (textView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.empty_view;
                ViewStub viewStub = (ViewStub) view.findViewById(R.id.empty_view);
                if (viewStub != null) {
                    i = R.id.top_fragment_home_vote23;
                    View viewFindViewById = view.findViewById(R.id.top_fragment_home_vote23);
                    if (viewFindViewById != null) {
                        return new FragmentHomeVote23Binding(constraintLayout, banner, textView, constraintLayout, viewStub, LayoutHeadTitleBinding.bind(viewFindViewById));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
