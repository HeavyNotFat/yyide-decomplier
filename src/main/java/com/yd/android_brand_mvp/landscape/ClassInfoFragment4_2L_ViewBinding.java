package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class ClassInfoFragment4_2L_ViewBinding implements Unbinder {
    private ClassInfoFragment4_2L target;
    private View view7f0a0250;

    public ClassInfoFragment4_2L_ViewBinding(final ClassInfoFragment4_2L classInfoFragment4_2L, View view) {
        this.target = classInfoFragment4_2L;
        classInfoFragment4_2L.imgHead = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_head, "field 'imgHead'", ImageView.class);
        classInfoFragment4_2L.tvClassName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class_name, "field 'tvClassName'", TextView.class);
        classInfoFragment4_2L.tvTeacherName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_name, "field 'tvTeacherName'", TextView.class);
        classInfoFragment4_2L.ll_no = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_no, "field 'll_no'", LinearLayout.class);
        classInfoFragment4_2L.ll_class = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_class, "field 'll_class'", LinearLayout.class);
        classInfoFragment4_2L.tvStudentNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_student_num, "field 'tvStudentNum'", TextView.class);
        classInfoFragment4_2L.tv_class = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class, "field 'tv_class'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.content, "field 'content' and method 'onClick'");
        classInfoFragment4_2L.content = (FrameLayout) Utils.castView(viewFindRequiredView, R.id.content, "field 'content'", FrameLayout.class);
        this.view7f0a0250 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.ClassInfoFragment4_2L_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classInfoFragment4_2L.onClick(view2);
            }
        });
        classInfoFragment4_2L.tvTeacherDuty = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_duty, "field 'tvTeacherDuty'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassInfoFragment4_2L classInfoFragment4_2L = this.target;
        if (classInfoFragment4_2L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classInfoFragment4_2L.imgHead = null;
        classInfoFragment4_2L.tvClassName = null;
        classInfoFragment4_2L.tvTeacherName = null;
        classInfoFragment4_2L.ll_no = null;
        classInfoFragment4_2L.ll_class = null;
        classInfoFragment4_2L.tvStudentNum = null;
        classInfoFragment4_2L.tv_class = null;
        classInfoFragment4_2L.content = null;
        classInfoFragment4_2L.tvTeacherDuty = null;
        this.view7f0a0250.setOnClickListener(null);
        this.view7f0a0250 = null;
    }
}
