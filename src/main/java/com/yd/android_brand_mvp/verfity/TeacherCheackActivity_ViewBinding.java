package com.yd.android_brand_mvp.verfity;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class TeacherCheackActivity_ViewBinding implements Unbinder {
    private TeacherCheackActivity target;
    private View view7f0a00ed;
    private View view7f0a00ee;
    private View view7f0a00ef;
    private View view7f0a00f0;

    public TeacherCheackActivity_ViewBinding(TeacherCheackActivity teacherCheackActivity) {
        this(teacherCheackActivity, teacherCheackActivity.getWindow().getDecorView());
    }

    public TeacherCheackActivity_ViewBinding(final TeacherCheackActivity teacherCheackActivity, View view) {
        this.target = teacherCheackActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn1, "field 'btn1' and method 'onViewClicked'");
        teacherCheackActivity.btn1 = (CheckedTextView) Utils.castView(viewFindRequiredView, R.id.btn1, "field 'btn1'", CheckedTextView.class);
        this.view7f0a00ed = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.verfity.TeacherCheackActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                teacherCheackActivity.onViewClicked(view2);
            }
        });
        teacherCheackActivity.line1 = (TextView) Utils.findRequiredViewAsType(view, R.id.line1, "field 'line1'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn2, "field 'btn2' and method 'onViewClicked'");
        teacherCheackActivity.btn2 = (CheckedTextView) Utils.castView(viewFindRequiredView2, R.id.btn2, "field 'btn2'", CheckedTextView.class);
        this.view7f0a00ee = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.verfity.TeacherCheackActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                teacherCheackActivity.onViewClicked(view2);
            }
        });
        teacherCheackActivity.line2 = (TextView) Utils.findRequiredViewAsType(view, R.id.line2, "field 'line2'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn3, "field 'btn3' and method 'onViewClicked'");
        teacherCheackActivity.btn3 = (CheckedTextView) Utils.castView(viewFindRequiredView3, R.id.btn3, "field 'btn3'", CheckedTextView.class);
        this.view7f0a00ef = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.verfity.TeacherCheackActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                teacherCheackActivity.onViewClicked(view2);
            }
        });
        teacherCheackActivity.line3 = (TextView) Utils.findRequiredViewAsType(view, R.id.line3, "field 'line3'", TextView.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.btn4, "field 'btn4' and method 'onViewClicked'");
        teacherCheackActivity.btn4 = (CheckedTextView) Utils.castView(viewFindRequiredView4, R.id.btn4, "field 'btn4'", CheckedTextView.class);
        this.view7f0a00f0 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.verfity.TeacherCheackActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                teacherCheackActivity.onViewClicked(view2);
            }
        });
        teacherCheackActivity.line4 = (TextView) Utils.findRequiredViewAsType(view, R.id.line4, "field 'line4'", TextView.class);
        teacherCheackActivity.content = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", FrameLayout.class);
        teacherCheackActivity.layout_content = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout_content, "field 'layout_content'", LinearLayout.class);
        teacherCheackActivity.layout4 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout4, "field 'layout4'", LinearLayout.class);
        teacherCheackActivity.tab1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tab1, "field 'tab1'", LinearLayout.class);
        teacherCheackActivity.tab2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tab2, "field 'tab2'", LinearLayout.class);
        teacherCheackActivity.tab3 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tab3, "field 'tab3'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        TeacherCheackActivity teacherCheackActivity = this.target;
        if (teacherCheackActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        teacherCheackActivity.btn1 = null;
        teacherCheackActivity.line1 = null;
        teacherCheackActivity.btn2 = null;
        teacherCheackActivity.line2 = null;
        teacherCheackActivity.btn3 = null;
        teacherCheackActivity.line3 = null;
        teacherCheackActivity.btn4 = null;
        teacherCheackActivity.line4 = null;
        teacherCheackActivity.content = null;
        teacherCheackActivity.layout_content = null;
        teacherCheackActivity.layout4 = null;
        teacherCheackActivity.tab1 = null;
        teacherCheackActivity.tab2 = null;
        teacherCheackActivity.tab3 = null;
        this.view7f0a00ed.setOnClickListener(null);
        this.view7f0a00ed = null;
        this.view7f0a00ee.setOnClickListener(null);
        this.view7f0a00ee = null;
        this.view7f0a00ef.setOnClickListener(null);
        this.view7f0a00ef = null;
        this.view7f0a00f0.setOnClickListener(null);
        this.view7f0a00f0 = null;
    }
}
