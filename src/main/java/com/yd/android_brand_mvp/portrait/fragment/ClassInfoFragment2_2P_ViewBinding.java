package com.yd.android_brand_mvp.portrait.fragment;

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
public class ClassInfoFragment2_2P_ViewBinding implements Unbinder {
    private ClassInfoFragment2_2P target;
    private View view7f0a05a9;

    public ClassInfoFragment2_2P_ViewBinding(final ClassInfoFragment2_2P classInfoFragment2_2P, View view) {
        this.target = classInfoFragment2_2P;
        classInfoFragment2_2P.imgHead = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_head, "field 'imgHead'", ImageView.class);
        classInfoFragment2_2P.tvClassName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class_name, "field 'tvClassName'", TextView.class);
        classInfoFragment2_2P.tvTeacherName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_name, "field 'tvTeacherName'", TextView.class);
        classInfoFragment2_2P.ll_no = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_no, "field 'll_no'", LinearLayout.class);
        classInfoFragment2_2P.tvStudentNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_student_num, "field 'tvStudentNum'", TextView.class);
        classInfoFragment2_2P.tv_class = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class, "field 'tv_class'", TextView.class);
        classInfoFragment2_2P.tvTeacherNums = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_nums, "field 'tvTeacherNums'", TextView.class);
        classInfoFragment2_2P.recyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyleview, "field 'recyclerview'", RecyclerView.class);
        classInfoFragment2_2P.content = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", LinearLayout.class);
        classInfoFragment2_2P.tvTeacherDuty = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_duty, "field 'tvTeacherDuty'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_tab, "method 'onClick'");
        this.view7f0a05a9 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.ClassInfoFragment2_2P_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classInfoFragment2_2P.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassInfoFragment2_2P classInfoFragment2_2P = this.target;
        if (classInfoFragment2_2P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classInfoFragment2_2P.imgHead = null;
        classInfoFragment2_2P.tvClassName = null;
        classInfoFragment2_2P.tvTeacherName = null;
        classInfoFragment2_2P.ll_no = null;
        classInfoFragment2_2P.tvStudentNum = null;
        classInfoFragment2_2P.tv_class = null;
        classInfoFragment2_2P.tvTeacherNums = null;
        classInfoFragment2_2P.recyclerview = null;
        classInfoFragment2_2P.content = null;
        classInfoFragment2_2P.tvTeacherDuty = null;
        this.view7f0a05a9.setOnClickListener(null);
        this.view7f0a05a9 = null;
    }
}
