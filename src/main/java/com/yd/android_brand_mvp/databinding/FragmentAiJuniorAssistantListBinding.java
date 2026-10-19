package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAiJuniorAssistantListBinding implements ViewBinding {
    public final ConstraintLayout clInit;
    public final ConstraintLayout clInput;
    public final CheckedTextView ctDeepThinking;
    public final CheckedTextView ctInternetSearch;
    public final CheckedTextView ctSendSearch;
    public final EditText etInput;
    public final ImageView ivIcon;
    private final ConstraintLayout rootView;
    public final RecyclerView rvChatMessages;
    public final RecyclerView rvProblem;
    public final TextView textview;
    public final TextView tvDescription;
    public final TextView tvSelectMode;

    private FragmentAiJuniorAssistantListBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, CheckedTextView checkedTextView3, EditText editText, ImageView imageView, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.clInit = constraintLayout2;
        this.clInput = constraintLayout3;
        this.ctDeepThinking = checkedTextView;
        this.ctInternetSearch = checkedTextView2;
        this.ctSendSearch = checkedTextView3;
        this.etInput = editText;
        this.ivIcon = imageView;
        this.rvChatMessages = recyclerView;
        this.rvProblem = recyclerView2;
        this.textview = textView;
        this.tvDescription = textView2;
        this.tvSelectMode = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAiJuniorAssistantListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAiJuniorAssistantListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ai_junior_assistant_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAiJuniorAssistantListBinding bind(View view) {
        int i = R.id.cl_init;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_init);
        if (constraintLayout != null) {
            i = R.id.cl_input;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_input);
            if (constraintLayout2 != null) {
                i = R.id.ct_deep_thinking;
                CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.ct_deep_thinking);
                if (checkedTextView != null) {
                    i = R.id.ct_internet_search;
                    CheckedTextView checkedTextView2 = (CheckedTextView) view.findViewById(R.id.ct_internet_search);
                    if (checkedTextView2 != null) {
                        i = R.id.ct_send_search;
                        CheckedTextView checkedTextView3 = (CheckedTextView) view.findViewById(R.id.ct_send_search);
                        if (checkedTextView3 != null) {
                            i = R.id.et_input;
                            EditText editText = (EditText) view.findViewById(R.id.et_input);
                            if (editText != null) {
                                i = R.id.iv_icon;
                                ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon);
                                if (imageView != null) {
                                    i = R.id.rvChatMessages;
                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvChatMessages);
                                    if (recyclerView != null) {
                                        i = R.id.rv_problem;
                                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_problem);
                                        if (recyclerView2 != null) {
                                            i = R.id.textview;
                                            TextView textView = (TextView) view.findViewById(R.id.textview);
                                            if (textView != null) {
                                                i = R.id.tv_description;
                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_description);
                                                if (textView2 != null) {
                                                    i = R.id.tv_select_mode;
                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_select_mode);
                                                    if (textView3 != null) {
                                                        return new FragmentAiJuniorAssistantListBinding((ConstraintLayout) view, constraintLayout, constraintLayout2, checkedTextView, checkedTextView2, checkedTextView3, editText, imageView, recyclerView, recyclerView2, textView, textView2, textView3);
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
