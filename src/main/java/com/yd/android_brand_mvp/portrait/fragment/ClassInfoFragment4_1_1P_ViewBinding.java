package com.yd.android_brand_mvp.portrait.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class ClassInfoFragment4_1_1P_ViewBinding implements Unbinder {
    private ClassInfoFragment4_1_1P target;
    private View view7f0a0717;

    public ClassInfoFragment4_1_1P_ViewBinding(final ClassInfoFragment4_1_1P classInfoFragment4_1_1P, View view) {
        this.target = classInfoFragment4_1_1P;
        classInfoFragment4_1_1P.tvClassName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class_name, "field 'tvClassName'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rl_tab, "method 'onClick'");
        this.view7f0a0717 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.ClassInfoFragment4_1_1P_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classInfoFragment4_1_1P.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassInfoFragment4_1_1P classInfoFragment4_1_1P = this.target;
        if (classInfoFragment4_1_1P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classInfoFragment4_1_1P.tvClassName = null;
        this.view7f0a0717.setOnClickListener(null);
        this.view7f0a0717 = null;
    }
}
