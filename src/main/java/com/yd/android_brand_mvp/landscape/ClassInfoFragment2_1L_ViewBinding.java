package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class ClassInfoFragment2_1L_ViewBinding implements Unbinder {
    private ClassInfoFragment2_1L target;
    private View view7f0a0250;

    public ClassInfoFragment2_1L_ViewBinding(final ClassInfoFragment2_1L classInfoFragment2_1L, View view) {
        this.target = classInfoFragment2_1L;
        classInfoFragment2_1L.className = (TextView) Utils.findRequiredViewAsType(view, R.id.className, "field 'className'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.content, "field 'content' and method 'onClick'");
        classInfoFragment2_1L.content = (FrameLayout) Utils.castView(viewFindRequiredView, R.id.content, "field 'content'", FrameLayout.class);
        this.view7f0a0250 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.ClassInfoFragment2_1L_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classInfoFragment2_1L.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassInfoFragment2_1L classInfoFragment2_1L = this.target;
        if (classInfoFragment2_1L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classInfoFragment2_1L.className = null;
        classInfoFragment2_1L.content = null;
        this.view7f0a0250.setOnClickListener(null);
        this.view7f0a0250 = null;
    }
}
