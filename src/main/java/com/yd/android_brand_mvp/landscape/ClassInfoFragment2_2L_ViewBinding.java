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
public class ClassInfoFragment2_2L_ViewBinding implements Unbinder {
    private ClassInfoFragment2_2L target;
    private View view7f0a05a9;

    public ClassInfoFragment2_2L_ViewBinding(final ClassInfoFragment2_2L classInfoFragment2_2L, View view) {
        this.target = classInfoFragment2_2L;
        classInfoFragment2_2L.imgHead = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_head, "field 'imgHead'", ImageView.class);
        classInfoFragment2_2L.tvClassName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class_name, "field 'tvClassName'", TextView.class);
        classInfoFragment2_2L.tvTeacherName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_name, "field 'tvTeacherName'", TextView.class);
        classInfoFragment2_2L.tvTeacherDuty = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_duty, "field 'tvTeacherDuty'", TextView.class);
        classInfoFragment2_2L.tvStudentNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_student_num, "field 'tvStudentNum'", TextView.class);
        classInfoFragment2_2L.tv_class = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class, "field 'tv_class'", TextView.class);
        classInfoFragment2_2L.llTeacherName = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_teacher_name, "field 'llTeacherName'", LinearLayout.class);
        classInfoFragment2_2L.llStudentNum = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_student_num, "field 'llStudentNum'", LinearLayout.class);
        classInfoFragment2_2L.recyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyleview, "field 'recyclerview'", RecyclerView.class);
        classInfoFragment2_2L.content = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", LinearLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_tab, "method 'onClick'");
        this.view7f0a05a9 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.ClassInfoFragment2_2L_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classInfoFragment2_2L.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassInfoFragment2_2L classInfoFragment2_2L = this.target;
        if (classInfoFragment2_2L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classInfoFragment2_2L.imgHead = null;
        classInfoFragment2_2L.tvClassName = null;
        classInfoFragment2_2L.tvTeacherName = null;
        classInfoFragment2_2L.tvTeacherDuty = null;
        classInfoFragment2_2L.tvStudentNum = null;
        classInfoFragment2_2L.tv_class = null;
        classInfoFragment2_2L.llTeacherName = null;
        classInfoFragment2_2L.llStudentNum = null;
        classInfoFragment2_2L.recyclerview = null;
        classInfoFragment2_2L.content = null;
        this.view7f0a05a9.setOnClickListener(null);
        this.view7f0a05a9 = null;
    }
}
