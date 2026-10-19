package com.yd.android_brand_mvp.adapter.attence;

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
public class CheckAttendanceActivity_ViewBinding implements Unbinder {
    private CheckAttendanceActivity target;
    private View view7f0a00ed;
    private View view7f0a00ee;
    private View view7f0a00ef;

    public CheckAttendanceActivity_ViewBinding(CheckAttendanceActivity checkAttendanceActivity) {
        this(checkAttendanceActivity, checkAttendanceActivity.getWindow().getDecorView());
    }

    public CheckAttendanceActivity_ViewBinding(final CheckAttendanceActivity checkAttendanceActivity, View view) {
        this.target = checkAttendanceActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn1, "field 'btn1' and method 'onViewClicked'");
        checkAttendanceActivity.btn1 = (CheckedTextView) Utils.castView(viewFindRequiredView, R.id.btn1, "field 'btn1'", CheckedTextView.class);
        this.view7f0a00ed = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.adapter.attence.CheckAttendanceActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                checkAttendanceActivity.onViewClicked(view2);
            }
        });
        checkAttendanceActivity.line1 = (TextView) Utils.findRequiredViewAsType(view, R.id.line1, "field 'line1'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn2, "field 'btn2' and method 'onViewClicked'");
        checkAttendanceActivity.btn2 = (CheckedTextView) Utils.castView(viewFindRequiredView2, R.id.btn2, "field 'btn2'", CheckedTextView.class);
        this.view7f0a00ee = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.adapter.attence.CheckAttendanceActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                checkAttendanceActivity.onViewClicked(view2);
            }
        });
        checkAttendanceActivity.line2 = (TextView) Utils.findRequiredViewAsType(view, R.id.line2, "field 'line2'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn3, "field 'btn3' and method 'onViewClicked'");
        checkAttendanceActivity.btn3 = (CheckedTextView) Utils.castView(viewFindRequiredView3, R.id.btn3, "field 'btn3'", CheckedTextView.class);
        this.view7f0a00ef = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.adapter.attence.CheckAttendanceActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                checkAttendanceActivity.onViewClicked(view2);
            }
        });
        checkAttendanceActivity.line3 = (TextView) Utils.findRequiredViewAsType(view, R.id.line3, "field 'line3'", TextView.class);
        checkAttendanceActivity.content = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", FrameLayout.class);
        checkAttendanceActivity.tab1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tab1, "field 'tab1'", LinearLayout.class);
        checkAttendanceActivity.tab2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tab2, "field 'tab2'", LinearLayout.class);
        checkAttendanceActivity.tab3 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tab3, "field 'tab3'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CheckAttendanceActivity checkAttendanceActivity = this.target;
        if (checkAttendanceActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        checkAttendanceActivity.btn1 = null;
        checkAttendanceActivity.line1 = null;
        checkAttendanceActivity.btn2 = null;
        checkAttendanceActivity.line2 = null;
        checkAttendanceActivity.btn3 = null;
        checkAttendanceActivity.line3 = null;
        checkAttendanceActivity.content = null;
        checkAttendanceActivity.tab1 = null;
        checkAttendanceActivity.tab2 = null;
        checkAttendanceActivity.tab3 = null;
        this.view7f0a00ed.setOnClickListener(null);
        this.view7f0a00ed = null;
        this.view7f0a00ee.setOnClickListener(null);
        this.view7f0a00ee = null;
        this.view7f0a00ef.setOnClickListener(null);
        this.view7f0a00ef = null;
    }
}
