package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class ClassInfoFragmentL_ViewBinding implements Unbinder {
    private ClassInfoFragmentL target;

    public ClassInfoFragmentL_ViewBinding(ClassInfoFragmentL classInfoFragmentL, View view) {
        this.target = classInfoFragmentL;
        classInfoFragmentL.imgHead = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_head, "field 'imgHead'", ImageView.class);
        classInfoFragmentL.tvClassName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class_name, "field 'tvClassName'", TextView.class);
        classInfoFragmentL.tvTeacherName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_name, "field 'tvTeacherName'", TextView.class);
        classInfoFragmentL.tvTeacherDuty = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_duty, "field 'tvTeacherDuty'", TextView.class);
        classInfoFragmentL.tvStudentNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_student_num, "field 'tvStudentNum'", TextView.class);
        classInfoFragmentL.tvTeacherNums = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_teacher_nums, "field 'tvTeacherNums'", TextView.class);
        classInfoFragmentL.recyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyleview, "field 'recyclerview'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassInfoFragmentL classInfoFragmentL = this.target;
        if (classInfoFragmentL == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classInfoFragmentL.imgHead = null;
        classInfoFragmentL.tvClassName = null;
        classInfoFragmentL.tvTeacherName = null;
        classInfoFragmentL.tvTeacherDuty = null;
        classInfoFragmentL.tvStudentNum = null;
        classInfoFragmentL.tvTeacherNums = null;
        classInfoFragmentL.recyclerview = null;
    }
}
