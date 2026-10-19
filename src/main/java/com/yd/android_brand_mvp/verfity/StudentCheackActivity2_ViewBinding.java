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
public class StudentCheackActivity2_ViewBinding implements Unbinder {
    private StudentCheackActivity2 target;
    private View view7f0a00ed;
    private View view7f0a00ee;
    private View view7f0a00ef;

    public StudentCheackActivity2_ViewBinding(StudentCheackActivity2 studentCheackActivity2) {
        this(studentCheackActivity2, studentCheackActivity2.getWindow().getDecorView());
    }

    public StudentCheackActivity2_ViewBinding(final StudentCheackActivity2 studentCheackActivity2, View view) {
        this.target = studentCheackActivity2;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn1, "field 'btn1' and method 'onViewClicked'");
        studentCheackActivity2.btn1 = (CheckedTextView) Utils.castView(viewFindRequiredView, R.id.btn1, "field 'btn1'", CheckedTextView.class);
        this.view7f0a00ed = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.verfity.StudentCheackActivity2_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                studentCheackActivity2.onViewClicked(view2);
            }
        });
        studentCheackActivity2.line1 = (TextView) Utils.findRequiredViewAsType(view, R.id.line1, "field 'line1'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn2, "field 'btn2' and method 'onViewClicked'");
        studentCheackActivity2.btn2 = (CheckedTextView) Utils.castView(viewFindRequiredView2, R.id.btn2, "field 'btn2'", CheckedTextView.class);
        this.view7f0a00ee = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.verfity.StudentCheackActivity2_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                studentCheackActivity2.onViewClicked(view2);
            }
        });
        studentCheackActivity2.line2 = (TextView) Utils.findRequiredViewAsType(view, R.id.line2, "field 'line2'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn3, "field 'btn3' and method 'onViewClicked'");
        studentCheackActivity2.btn3 = (CheckedTextView) Utils.castView(viewFindRequiredView3, R.id.btn3, "field 'btn3'", CheckedTextView.class);
        this.view7f0a00ef = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.verfity.StudentCheackActivity2_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                studentCheackActivity2.onViewClicked(view2);
            }
        });
        studentCheackActivity2.line3 = (TextView) Utils.findRequiredViewAsType(view, R.id.line3, "field 'line3'", TextView.class);
        studentCheackActivity2.content = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", FrameLayout.class);
        studentCheackActivity2.tab1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tab1, "field 'tab1'", LinearLayout.class);
        studentCheackActivity2.tab2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tab2, "field 'tab2'", LinearLayout.class);
        studentCheackActivity2.tab3 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tab3, "field 'tab3'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StudentCheackActivity2 studentCheackActivity2 = this.target;
        if (studentCheackActivity2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        studentCheackActivity2.btn1 = null;
        studentCheackActivity2.line1 = null;
        studentCheackActivity2.btn2 = null;
        studentCheackActivity2.line2 = null;
        studentCheackActivity2.btn3 = null;
        studentCheackActivity2.line3 = null;
        studentCheackActivity2.content = null;
        studentCheackActivity2.tab1 = null;
        studentCheackActivity2.tab2 = null;
        studentCheackActivity2.tab3 = null;
        this.view7f0a00ed.setOnClickListener(null);
        this.view7f0a00ed = null;
        this.view7f0a00ee.setOnClickListener(null);
        this.view7f0a00ee = null;
        this.view7f0a00ef.setOnClickListener(null);
        this.view7f0a00ef = null;
    }
}
