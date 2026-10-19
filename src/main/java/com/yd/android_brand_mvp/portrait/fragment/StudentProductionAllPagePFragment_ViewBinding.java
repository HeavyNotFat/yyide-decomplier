package com.yd.android_brand_mvp.portrait.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public class StudentProductionAllPagePFragment_ViewBinding implements Unbinder {
    private StudentProductionAllPagePFragment target;
    private View view7f0a00eb;
    private View view7f0a0534;

    public StudentProductionAllPagePFragment_ViewBinding(final StudentProductionAllPagePFragment studentProductionAllPagePFragment, View view) {
        this.target = studentProductionAllPagePFragment;
        studentProductionAllPagePFragment.rvCommentList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_comment_list, "field 'rvCommentList'", RecyclerView.class);
        studentProductionAllPagePFragment.etComment = (EditText) Utils.findRequiredViewAsType(view, R.id.et_comment, "field 'etComment'", EditText.class);
        studentProductionAllPagePFragment.ivHeadPortrait = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_head_portrait, "field 'ivHeadPortrait'", ImageView.class);
        studentProductionAllPagePFragment.tvName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvName'", TextView.class);
        studentProductionAllPagePFragment.tvPersonalMotto = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_personal_motto, "field 'tvPersonalMotto'", TextView.class);
        studentProductionAllPagePFragment.tvWorName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_work_name, "field 'tvWorName'", TextView.class);
        studentProductionAllPagePFragment.tv_work_desc = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_work_desc, "field 'tv_work_desc'", TextView.class);
        studentProductionAllPagePFragment.mBanner = (Banner) Utils.findRequiredViewAsType(view, R.id.banner, "field 'mBanner'", Banner.class);
        studentProductionAllPagePFragment.ivLike = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_like, "field 'ivLike'", ImageView.class);
        studentProductionAllPagePFragment.tvLike = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_like, "field 'tvLike'", TextView.class);
        studentProductionAllPagePFragment.tvCommentHint = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_comment_hint, "field 'tvCommentHint'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.bt_comment, "method 'onClick'");
        this.view7f0a00eb = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.StudentProductionAllPagePFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                studentProductionAllPagePFragment.onClick(view2);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.like_layout, "method 'onClick'");
        this.view7f0a0534 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.StudentProductionAllPagePFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                studentProductionAllPagePFragment.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StudentProductionAllPagePFragment studentProductionAllPagePFragment = this.target;
        if (studentProductionAllPagePFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        studentProductionAllPagePFragment.rvCommentList = null;
        studentProductionAllPagePFragment.etComment = null;
        studentProductionAllPagePFragment.ivHeadPortrait = null;
        studentProductionAllPagePFragment.tvName = null;
        studentProductionAllPagePFragment.tvPersonalMotto = null;
        studentProductionAllPagePFragment.tvWorName = null;
        studentProductionAllPagePFragment.tv_work_desc = null;
        studentProductionAllPagePFragment.mBanner = null;
        studentProductionAllPagePFragment.ivLike = null;
        studentProductionAllPagePFragment.tvLike = null;
        studentProductionAllPagePFragment.tvCommentHint = null;
        this.view7f0a00eb.setOnClickListener(null);
        this.view7f0a00eb = null;
        this.view7f0a0534.setOnClickListener(null);
        this.view7f0a0534 = null;
    }
}
