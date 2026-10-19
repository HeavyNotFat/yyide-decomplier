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
public class StudentCheackActivity_ViewBinding implements Unbinder {
    private StudentCheackActivity target;
    private View view7f0a00ed;
    private View view7f0a00ee;
    private View view7f0a00ef;

    public StudentCheackActivity_ViewBinding(StudentCheackActivity studentCheackActivity) {
        this(studentCheackActivity, studentCheackActivity.getWindow().getDecorView());
    }

    public StudentCheackActivity_ViewBinding(final StudentCheackActivity studentCheackActivity, View view) {
        this.target = studentCheackActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn1, "field 'btn1' and method 'onViewClicked'");
        studentCheackActivity.btn1 = (CheckedTextView) Utils.castView(viewFindRequiredView, R.id.btn1, "field 'btn1'", CheckedTextView.class);
        this.view7f0a00ed = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.verfity.StudentCheackActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                studentCheackActivity.onViewClicked(view2);
            }
        });
        studentCheackActivity.line1 = (TextView) Utils.findRequiredViewAsType(view, R.id.line1, "field 'line1'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn2, "field 'btn2' and method 'onViewClicked'");
        studentCheackActivity.btn2 = (CheckedTextView) Utils.castView(viewFindRequiredView2, R.id.btn2, "field 'btn2'", CheckedTextView.class);
        this.view7f0a00ee = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.verfity.StudentCheackActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                studentCheackActivity.onViewClicked(view2);
            }
        });
        studentCheackActivity.line2 = (TextView) Utils.findRequiredViewAsType(view, R.id.line2, "field 'line2'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn3, "field 'btn3' and method 'onViewClicked'");
        studentCheackActivity.btn3 = (CheckedTextView) Utils.castView(viewFindRequiredView3, R.id.btn3, "field 'btn3'", CheckedTextView.class);
        this.view7f0a00ef = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.verfity.StudentCheackActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                studentCheackActivity.onViewClicked(view2);
            }
        });
        studentCheackActivity.line3 = (TextView) Utils.findRequiredViewAsType(view, R.id.line3, "field 'line3'", TextView.class);
        studentCheackActivity.content = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", FrameLayout.class);
        studentCheackActivity.tab1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tab1, "field 'tab1'", LinearLayout.class);
        studentCheackActivity.tab2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tab2, "field 'tab2'", LinearLayout.class);
        studentCheackActivity.tab3 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tab3, "field 'tab3'", LinearLayout.class);
        studentCheackActivity.tab4 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout4, "field 'tab4'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StudentCheackActivity studentCheackActivity = this.target;
        if (studentCheackActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        studentCheackActivity.btn1 = null;
        studentCheackActivity.line1 = null;
        studentCheackActivity.btn2 = null;
        studentCheackActivity.line2 = null;
        studentCheackActivity.btn3 = null;
        studentCheackActivity.line3 = null;
        studentCheackActivity.content = null;
        studentCheackActivity.tab1 = null;
        studentCheackActivity.tab2 = null;
        studentCheackActivity.tab3 = null;
        studentCheackActivity.tab4 = null;
        this.view7f0a00ed.setOnClickListener(null);
        this.view7f0a00ed = null;
        this.view7f0a00ee.setOnClickListener(null);
        this.view7f0a00ee = null;
        this.view7f0a00ef.setOnClickListener(null);
        this.view7f0a00ef = null;
    }
}
