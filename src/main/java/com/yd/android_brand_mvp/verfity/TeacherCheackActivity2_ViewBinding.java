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
public class TeacherCheackActivity2_ViewBinding implements Unbinder {
    private TeacherCheackActivity2 target;
    private View view7f0a00ed;
    private View view7f0a00ee;
    private View view7f0a00ef;
    private View view7f0a00f0;

    public TeacherCheackActivity2_ViewBinding(TeacherCheackActivity2 teacherCheackActivity2) {
        this(teacherCheackActivity2, teacherCheackActivity2.getWindow().getDecorView());
    }

    public TeacherCheackActivity2_ViewBinding(final TeacherCheackActivity2 teacherCheackActivity2, View view) {
        this.target = teacherCheackActivity2;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn1, "field 'btn1' and method 'onViewClicked'");
        teacherCheackActivity2.btn1 = (CheckedTextView) Utils.castView(viewFindRequiredView, R.id.btn1, "field 'btn1'", CheckedTextView.class);
        this.view7f0a00ed = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.verfity.TeacherCheackActivity2_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                teacherCheackActivity2.onViewClicked(view2);
            }
        });
        teacherCheackActivity2.line1 = (TextView) Utils.findRequiredViewAsType(view, R.id.line1, "field 'line1'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn2, "field 'btn2' and method 'onViewClicked'");
        teacherCheackActivity2.btn2 = (CheckedTextView) Utils.castView(viewFindRequiredView2, R.id.btn2, "field 'btn2'", CheckedTextView.class);
        this.view7f0a00ee = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.verfity.TeacherCheackActivity2_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                teacherCheackActivity2.onViewClicked(view2);
            }
        });
        teacherCheackActivity2.line2 = (TextView) Utils.findRequiredViewAsType(view, R.id.line2, "field 'line2'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn3, "field 'btn3' and method 'onViewClicked'");
        teacherCheackActivity2.btn3 = (CheckedTextView) Utils.castView(viewFindRequiredView3, R.id.btn3, "field 'btn3'", CheckedTextView.class);
        this.view7f0a00ef = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.verfity.TeacherCheackActivity2_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                teacherCheackActivity2.onViewClicked(view2);
            }
        });
        teacherCheackActivity2.line3 = (TextView) Utils.findRequiredViewAsType(view, R.id.line3, "field 'line3'", TextView.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.btn4, "field 'btn4' and method 'onViewClicked'");
        teacherCheackActivity2.btn4 = (CheckedTextView) Utils.castView(viewFindRequiredView4, R.id.btn4, "field 'btn4'", CheckedTextView.class);
        this.view7f0a00f0 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.verfity.TeacherCheackActivity2_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                teacherCheackActivity2.onViewClicked(view2);
            }
        });
        teacherCheackActivity2.line4 = (TextView) Utils.findRequiredViewAsType(view, R.id.line4, "field 'line4'", TextView.class);
        teacherCheackActivity2.content = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", FrameLayout.class);
        teacherCheackActivity2.layout4 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout4, "field 'layout4'", LinearLayout.class);
        teacherCheackActivity2.tab1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tab1, "field 'tab1'", LinearLayout.class);
        teacherCheackActivity2.tab2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tab2, "field 'tab2'", LinearLayout.class);
        teacherCheackActivity2.tab3 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tab3, "field 'tab3'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        TeacherCheackActivity2 teacherCheackActivity2 = this.target;
        if (teacherCheackActivity2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        teacherCheackActivity2.btn1 = null;
        teacherCheackActivity2.line1 = null;
        teacherCheackActivity2.btn2 = null;
        teacherCheackActivity2.line2 = null;
        teacherCheackActivity2.btn3 = null;
        teacherCheackActivity2.line3 = null;
        teacherCheackActivity2.btn4 = null;
        teacherCheackActivity2.line4 = null;
        teacherCheackActivity2.content = null;
        teacherCheackActivity2.layout4 = null;
        teacherCheackActivity2.tab1 = null;
        teacherCheackActivity2.tab2 = null;
        teacherCheackActivity2.tab3 = null;
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
