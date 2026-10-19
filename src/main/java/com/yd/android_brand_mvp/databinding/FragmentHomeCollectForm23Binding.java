package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentHomeCollectForm23Binding implements ViewBinding {
    public final Button btnFragmentHomeCollectForm23;
    public final ConstraintLayout clFragmentHomeCollectForm;
    public final ConstraintLayout clFragmentHomeCollectFormContent;
    public final ViewStub emptyView;
    public final ImageView ivFragmentHomeCollectForm23Submit;
    public final ImageView ivFragmentHomeCollectForm23UnSubmit;
    private final ConstraintLayout rootView;
    public final LayoutHeadTitleBinding topFragmentHomeCollectForm23;
    public final TextView tvFragmentHomeCollectForm23FormName;
    public final TextView tvFragmentHomeCollectForm23Next;
    public final TextView tvFragmentHomeCollectForm23Page;
    public final TextView tvFragmentHomeCollectForm23Pre;
    public final TextView tvFragmentHomeCollectForm23Submit;
    public final TextView tvFragmentHomeCollectForm23SubmitCount;
    public final TextView tvFragmentHomeCollectForm23UnSubmit;
    public final TextView tvFragmentHomeCollectForm23UnSubmitCount;

    private FragmentHomeCollectForm23Binding(ConstraintLayout constraintLayout, Button button, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ViewStub viewStub, ImageView imageView, ImageView imageView2, LayoutHeadTitleBinding layoutHeadTitleBinding, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.btnFragmentHomeCollectForm23 = button;
        this.clFragmentHomeCollectForm = constraintLayout2;
        this.clFragmentHomeCollectFormContent = constraintLayout3;
        this.emptyView = viewStub;
        this.ivFragmentHomeCollectForm23Submit = imageView;
        this.ivFragmentHomeCollectForm23UnSubmit = imageView2;
        this.topFragmentHomeCollectForm23 = layoutHeadTitleBinding;
        this.tvFragmentHomeCollectForm23FormName = textView;
        this.tvFragmentHomeCollectForm23Next = textView2;
        this.tvFragmentHomeCollectForm23Page = textView3;
        this.tvFragmentHomeCollectForm23Pre = textView4;
        this.tvFragmentHomeCollectForm23Submit = textView5;
        this.tvFragmentHomeCollectForm23SubmitCount = textView6;
        this.tvFragmentHomeCollectForm23UnSubmit = textView7;
        this.tvFragmentHomeCollectForm23UnSubmitCount = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomeCollectForm23Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHomeCollectForm23Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_home_collect_form23, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHomeCollectForm23Binding bind(View view) {
        int i = R.id.btn_fragment_home_collect_form23;
        Button button = (Button) view.findViewById(R.id.btn_fragment_home_collect_form23);
        if (button != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.cl_fragment_home_collect_form_content;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_home_collect_form_content);
            if (constraintLayout2 != null) {
                i = R.id.empty_view;
                ViewStub viewStub = (ViewStub) view.findViewById(R.id.empty_view);
                if (viewStub != null) {
                    i = R.id.iv_fragment_home_collect_form23_submit;
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_fragment_home_collect_form23_submit);
                    if (imageView != null) {
                        i = R.id.iv_fragment_home_collect_form23_unSubmit;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_fragment_home_collect_form23_unSubmit);
                        if (imageView2 != null) {
                            i = R.id.top_fragment_home_collect_form23;
                            View viewFindViewById = view.findViewById(R.id.top_fragment_home_collect_form23);
                            if (viewFindViewById != null) {
                                LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
                                i = R.id.tv_fragment_home_collect_form23_formName;
                                TextView textView = (TextView) view.findViewById(R.id.tv_fragment_home_collect_form23_formName);
                                if (textView != null) {
                                    i = R.id.tv_fragment_home_collect_form23_next;
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_home_collect_form23_next);
                                    if (textView2 != null) {
                                        i = R.id.tv_fragment_home_collect_form23_page;
                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_fragment_home_collect_form23_page);
                                        if (textView3 != null) {
                                            i = R.id.tv_fragment_home_collect_form23_pre;
                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_fragment_home_collect_form23_pre);
                                            if (textView4 != null) {
                                                i = R.id.tv_fragment_home_collect_form23_submit;
                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_fragment_home_collect_form23_submit);
                                                if (textView5 != null) {
                                                    i = R.id.tv_fragment_home_collect_form23_submitCount;
                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_fragment_home_collect_form23_submitCount);
                                                    if (textView6 != null) {
                                                        i = R.id.tv_fragment_home_collect_form23_unSubmit;
                                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_fragment_home_collect_form23_unSubmit);
                                                        if (textView7 != null) {
                                                            i = R.id.tv_fragment_home_collect_form23_unSubmitCount;
                                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_fragment_home_collect_form23_unSubmitCount);
                                                            if (textView8 != null) {
                                                                return new FragmentHomeCollectForm23Binding(constraintLayout, button, constraintLayout, constraintLayout2, viewStub, imageView, imageView2, layoutHeadTitleBindingBind, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
