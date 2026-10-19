package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentHomeCollectForm22Binding implements ViewBinding {
    public final Button btnFragmentHomeCollectForm22;
    public final ConstraintLayout clFragmentHomeCollectForm;
    public final ConstraintLayout clFragmentHomeCollectFormContent;
    public final ViewStub emptyView;
    private final ConstraintLayout rootView;
    public final LayoutHeadTitleBinding topFragmentHomeCollectForm22;
    public final TextView tvFragmentHomeCollectForm22FormName;
    public final TextView tvFragmentHomeCollectForm22Next;
    public final TextView tvFragmentHomeCollectForm22Page;
    public final TextView tvFragmentHomeCollectForm22Pre;

    private FragmentHomeCollectForm22Binding(ConstraintLayout constraintLayout, Button button, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ViewStub viewStub, LayoutHeadTitleBinding layoutHeadTitleBinding, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.btnFragmentHomeCollectForm22 = button;
        this.clFragmentHomeCollectForm = constraintLayout2;
        this.clFragmentHomeCollectFormContent = constraintLayout3;
        this.emptyView = viewStub;
        this.topFragmentHomeCollectForm22 = layoutHeadTitleBinding;
        this.tvFragmentHomeCollectForm22FormName = textView;
        this.tvFragmentHomeCollectForm22Next = textView2;
        this.tvFragmentHomeCollectForm22Page = textView3;
        this.tvFragmentHomeCollectForm22Pre = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomeCollectForm22Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHomeCollectForm22Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_home_collect_form22, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHomeCollectForm22Binding bind(View view) {
        int i = R.id.btn_fragment_home_collect_form22;
        Button button = (Button) view.findViewById(R.id.btn_fragment_home_collect_form22);
        if (button != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.cl_fragment_home_collect_form_content;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_home_collect_form_content);
            if (constraintLayout2 != null) {
                i = R.id.empty_view;
                ViewStub viewStub = (ViewStub) view.findViewById(R.id.empty_view);
                if (viewStub != null) {
                    i = R.id.top_fragment_home_collect_form22;
                    View viewFindViewById = view.findViewById(R.id.top_fragment_home_collect_form22);
                    if (viewFindViewById != null) {
                        LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
                        i = R.id.tv_fragment_home_collect_form22_formName;
                        TextView textView = (TextView) view.findViewById(R.id.tv_fragment_home_collect_form22_formName);
                        if (textView != null) {
                            i = R.id.tv_fragment_home_collect_form22_next;
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_home_collect_form22_next);
                            if (textView2 != null) {
                                i = R.id.tv_fragment_home_collect_form22_page;
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_fragment_home_collect_form22_page);
                                if (textView3 != null) {
                                    i = R.id.tv_fragment_home_collect_form22_pre;
                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_fragment_home_collect_form22_pre);
                                    if (textView4 != null) {
                                        return new FragmentHomeCollectForm22Binding(constraintLayout, button, constraintLayout, constraintLayout2, viewStub, layoutHeadTitleBindingBind, textView, textView2, textView3, textView4);
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
