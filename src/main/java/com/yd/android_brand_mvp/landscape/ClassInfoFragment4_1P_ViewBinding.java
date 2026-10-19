package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class ClassInfoFragment4_1P_ViewBinding implements Unbinder {
    private ClassInfoFragment4_1P target;
    private View view7f0a05a9;

    public ClassInfoFragment4_1P_ViewBinding(final ClassInfoFragment4_1P classInfoFragment4_1P, View view) {
        this.target = classInfoFragment4_1P;
        classInfoFragment4_1P.imgHead = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_head, "field 'imgHead'", ImageView.class);
        classInfoFragment4_1P.tvClassName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class_name, "field 'tvClassName'", TextView.class);
        classInfoFragment4_1P.tvTeacherName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_name, "field 'tvTeacherName'", TextView.class);
        classInfoFragment4_1P.tvTeacherDuty = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_duty, "field 'tvTeacherDuty'", TextView.class);
        classInfoFragment4_1P.tvStudentNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_student_num, "field 'tvStudentNum'", TextView.class);
        classInfoFragment4_1P.tvTeacherNums = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_nums, "field 'tvTeacherNums'", TextView.class);
        classInfoFragment4_1P.content = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", LinearLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_tab, "method 'onClick'");
        this.view7f0a05a9 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.ClassInfoFragment4_1P_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classInfoFragment4_1P.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassInfoFragment4_1P classInfoFragment4_1P = this.target;
        if (classInfoFragment4_1P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classInfoFragment4_1P.imgHead = null;
        classInfoFragment4_1P.tvClassName = null;
        classInfoFragment4_1P.tvTeacherName = null;
        classInfoFragment4_1P.tvTeacherDuty = null;
        classInfoFragment4_1P.tvStudentNum = null;
        classInfoFragment4_1P.tvTeacherNums = null;
        classInfoFragment4_1P.content = null;
        this.view7f0a05a9.setOnClickListener(null);
        this.view7f0a05a9 = null;
    }
}
