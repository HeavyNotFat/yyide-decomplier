package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public class StudentProductionAllPageFragment_ViewBinding implements Unbinder {
    private StudentProductionAllPageFragment target;
    private View view7f0a00eb;
    private View view7f0a0534;

    public StudentProductionAllPageFragment_ViewBinding(final StudentProductionAllPageFragment studentProductionAllPageFragment, View view) {
        this.target = studentProductionAllPageFragment;
        studentProductionAllPageFragment.rvCommentList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_comment_list, "field 'rvCommentList'", RecyclerView.class);
        studentProductionAllPageFragment.etComment = (EditText) Utils.findRequiredViewAsType(view, R.id.et_comment, "field 'etComment'", EditText.class);
        studentProductionAllPageFragment.ivHeadPortrait = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_head_portrait, "field 'ivHeadPortrait'", ImageView.class);
        studentProductionAllPageFragment.tvName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvName'", TextView.class);
        studentProductionAllPageFragment.tvPersonalMotto = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_personal_motto, "field 'tvPersonalMotto'", TextView.class);
        studentProductionAllPageFragment.mBanner = (Banner) Utils.findRequiredViewAsType(view, R.id.banner, "field 'mBanner'", Banner.class);
        studentProductionAllPageFragment.ivLike = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_like, "field 'ivLike'", ImageView.class);
        studentProductionAllPageFragment.tvLike = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_like, "field 'tvLike'", TextView.class);
        studentProductionAllPageFragment.tvCommentHint = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_comment_hint, "field 'tvCommentHint'", TextView.class);
        studentProductionAllPageFragment.tvWorName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_work_name, "field 'tvWorName'", TextView.class);
        studentProductionAllPageFragment.vIsFine = Utils.findRequiredView(view, R.id.v_is_fine, "field 'vIsFine'");
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.like_layout, "field 'like_layout' and method 'onClick'");
        studentProductionAllPageFragment.like_layout = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.like_layout, "field 'like_layout'", LinearLayout.class);
        this.view7f0a0534 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.StudentProductionAllPageFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                studentProductionAllPageFragment.onClick(view2);
            }
        });
        studentProductionAllPageFragment.tv_work_desc = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_work_desc, "field 'tv_work_desc'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.bt_comment, "method 'onClick'");
        this.view7f0a00eb = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.StudentProductionAllPageFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                studentProductionAllPageFragment.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StudentProductionAllPageFragment studentProductionAllPageFragment = this.target;
        if (studentProductionAllPageFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        studentProductionAllPageFragment.rvCommentList = null;
        studentProductionAllPageFragment.etComment = null;
        studentProductionAllPageFragment.ivHeadPortrait = null;
        studentProductionAllPageFragment.tvName = null;
        studentProductionAllPageFragment.tvPersonalMotto = null;
        studentProductionAllPageFragment.mBanner = null;
        studentProductionAllPageFragment.ivLike = null;
        studentProductionAllPageFragment.tvLike = null;
        studentProductionAllPageFragment.tvCommentHint = null;
        studentProductionAllPageFragment.tvWorName = null;
        studentProductionAllPageFragment.vIsFine = null;
        studentProductionAllPageFragment.like_layout = null;
        studentProductionAllPageFragment.tv_work_desc = null;
        this.view7f0a0534.setOnClickListener(null);
        this.view7f0a0534 = null;
        this.view7f0a00eb.setOnClickListener(null);
        this.view7f0a00eb = null;
    }
}
