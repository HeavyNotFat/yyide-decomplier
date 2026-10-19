package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class ClassInfoFragment2_1P_ViewBinding implements Unbinder {
    private ClassInfoFragment2_1P target;
    private View view7f0a05a9;

    public ClassInfoFragment2_1P_ViewBinding(final ClassInfoFragment2_1P classInfoFragment2_1P, View view) {
        this.target = classInfoFragment2_1P;
        classInfoFragment2_1P.imgHead = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_head, "field 'imgHead'", ImageView.class);
        classInfoFragment2_1P.tvClassName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class_name, "field 'tvClassName'", TextView.class);
        classInfoFragment2_1P.tvTeacherName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_name, "field 'tvTeacherName'", TextView.class);
        classInfoFragment2_1P.tvTeacherDuty = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_duty, "field 'tvTeacherDuty'", TextView.class);
        classInfoFragment2_1P.tvStudentNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_student_num, "field 'tvStudentNum'", TextView.class);
        classInfoFragment2_1P.llTeacherName = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_teacher_name, "field 'llTeacherName'", LinearLayout.class);
        classInfoFragment2_1P.llStudentNum = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_student_num, "field 'llStudentNum'", LinearLayout.class);
        classInfoFragment2_1P.recyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyleview, "field 'recyclerview'", RecyclerView.class);
        classInfoFragment2_1P.content = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", LinearLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_tab, "method 'onClick'");
        this.view7f0a05a9 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.ClassInfoFragment2_1P_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classInfoFragment2_1P.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassInfoFragment2_1P classInfoFragment2_1P = this.target;
        if (classInfoFragment2_1P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classInfoFragment2_1P.imgHead = null;
        classInfoFragment2_1P.tvClassName = null;
        classInfoFragment2_1P.tvTeacherName = null;
        classInfoFragment2_1P.tvTeacherDuty = null;
        classInfoFragment2_1P.tvStudentNum = null;
        classInfoFragment2_1P.llTeacherName = null;
        classInfoFragment2_1P.llStudentNum = null;
        classInfoFragment2_1P.recyclerview = null;
        classInfoFragment2_1P.content = null;
        this.view7f0a05a9.setOnClickListener(null);
        this.view7f0a05a9 = null;
    }
}
