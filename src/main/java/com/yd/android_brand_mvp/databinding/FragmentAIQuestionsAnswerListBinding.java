package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAIQuestionsAnswerListBinding implements ViewBinding {
    public final ConstraintLayout clInput;
    public final CheckedTextView ctSendSearch;
    public final EditText etInput;
    public final ConstraintLayout nestedScrollView;
    private final ConstraintLayout rootView;
    public final RecyclerView rvChatMessages;

    private FragmentAIQuestionsAnswerListBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, CheckedTextView checkedTextView, EditText editText, ConstraintLayout constraintLayout3, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.clInput = constraintLayout2;
        this.ctSendSearch = checkedTextView;
        this.etInput = editText;
        this.nestedScrollView = constraintLayout3;
        this.rvChatMessages = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAIQuestionsAnswerListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAIQuestionsAnswerListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_a_i_questions_answer_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAIQuestionsAnswerListBinding bind(View view) {
        int i = R.id.cl_input;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_input);
        if (constraintLayout != null) {
            i = R.id.ct_send_search;
            CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.ct_send_search);
            if (checkedTextView != null) {
                i = R.id.et_input;
                EditText editText = (EditText) view.findViewById(R.id.et_input);
                if (editText != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                    i = R.id.rvChatMessages;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvChatMessages);
                    if (recyclerView != null) {
                        return new FragmentAIQuestionsAnswerListBinding(constraintLayout2, constraintLayout, checkedTextView, editText, constraintLayout2, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
