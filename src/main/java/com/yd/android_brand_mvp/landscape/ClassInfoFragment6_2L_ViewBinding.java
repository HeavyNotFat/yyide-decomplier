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
public class ClassInfoFragment6_2L_ViewBinding implements Unbinder {
    private ClassInfoFragment6_2L target;
    private View view7f0a05a9;

    public ClassInfoFragment6_2L_ViewBinding(final ClassInfoFragment6_2L classInfoFragment6_2L, View view) {
        this.target = classInfoFragment6_2L;
        classInfoFragment6_2L.imgHead = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_head, "field 'imgHead'", ImageView.class);
        classInfoFragment6_2L.tvClassName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class_name, "field 'tvClassName'", TextView.class);
        classInfoFragment6_2L.tvTeacherName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_name, "field 'tvTeacherName'", TextView.class);
        classInfoFragment6_2L.ll_no = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_no, "field 'll_no'", LinearLayout.class);
        classInfoFragment6_2L.tvStudentNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_student_num, "field 'tvStudentNum'", TextView.class);
        classInfoFragment6_2L.tv_class = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class, "field 'tv_class'", TextView.class);
        classInfoFragment6_2L.recyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyleview, "field 'recyclerview'", RecyclerView.class);
        classInfoFragment6_2L.content = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", LinearLayout.class);
        classInfoFragment6_2L.tvTeacherDuty = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_duty, "field 'tvTeacherDuty'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_tab, "method 'onClick'");
        this.view7f0a05a9 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.ClassInfoFragment6_2L_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classInfoFragment6_2L.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassInfoFragment6_2L classInfoFragment6_2L = this.target;
        if (classInfoFragment6_2L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classInfoFragment6_2L.imgHead = null;
        classInfoFragment6_2L.tvClassName = null;
        classInfoFragment6_2L.tvTeacherName = null;
        classInfoFragment6_2L.ll_no = null;
        classInfoFragment6_2L.tvStudentNum = null;
        classInfoFragment6_2L.tv_class = null;
        classInfoFragment6_2L.recyclerview = null;
        classInfoFragment6_2L.content = null;
        classInfoFragment6_2L.tvTeacherDuty = null;
        this.view7f0a05a9.setOnClickListener(null);
        this.view7f0a05a9 = null;
    }
}
