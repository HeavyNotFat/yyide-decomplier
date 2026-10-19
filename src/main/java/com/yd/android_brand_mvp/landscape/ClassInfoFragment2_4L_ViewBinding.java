package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class ClassInfoFragment2_4L_ViewBinding implements Unbinder {
    private ClassInfoFragment2_4L target;
    private View view7f0a0250;
    private View view7f0a05a9;

    public ClassInfoFragment2_4L_ViewBinding(final ClassInfoFragment2_4L classInfoFragment2_4L, View view) {
        this.target = classInfoFragment2_4L;
        classInfoFragment2_4L.imgHead = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_head, "field 'imgHead'", ImageView.class);
        classInfoFragment2_4L.tvClassName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class_name, "field 'tvClassName'", TextView.class);
        classInfoFragment2_4L.tvTeacherName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_name, "field 'tvTeacherName'", TextView.class);
        classInfoFragment2_4L.tvStudentNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_student_num, "field 'tvStudentNum'", TextView.class);
        classInfoFragment2_4L.tv_class = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class, "field 'tv_class'", TextView.class);
        classInfoFragment2_4L.recyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyleview, "field 'recyclerview'", RecyclerView.class);
        classInfoFragment2_4L.tvTeacherDuty = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_duty, "field 'tvTeacherDuty'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_tab, "method 'onClick'");
        this.view7f0a05a9 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.ClassInfoFragment2_4L_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classInfoFragment2_4L.onClick(view2);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.content, "method 'onClick'");
        this.view7f0a0250 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.ClassInfoFragment2_4L_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classInfoFragment2_4L.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassInfoFragment2_4L classInfoFragment2_4L = this.target;
        if (classInfoFragment2_4L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classInfoFragment2_4L.imgHead = null;
        classInfoFragment2_4L.tvClassName = null;
        classInfoFragment2_4L.tvTeacherName = null;
        classInfoFragment2_4L.tvStudentNum = null;
        classInfoFragment2_4L.tv_class = null;
        classInfoFragment2_4L.recyclerview = null;
        classInfoFragment2_4L.tvTeacherDuty = null;
        this.view7f0a05a9.setOnClickListener(null);
        this.view7f0a05a9 = null;
        this.view7f0a0250.setOnClickListener(null);
        this.view7f0a0250 = null;
    }
}
