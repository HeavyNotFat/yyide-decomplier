package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class ClassScheduleFragment4_6L_ViewBinding implements Unbinder {
    private ClassScheduleFragment4_6L target;
    private View view7f0a0c24;

    public ClassScheduleFragment4_6L_ViewBinding(final ClassScheduleFragment4_6L classScheduleFragment4_6L, View view) {
        this.target = classScheduleFragment4_6L;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_week, "field 'tv_week' and method 'onViewClicked'");
        classScheduleFragment4_6L.tv_week = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_week, "field 'tv_week'", TextView.class);
        this.view7f0a0c24 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.ClassScheduleFragment4_6L_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classScheduleFragment4_6L.onViewClicked(view2);
            }
        });
        classScheduleFragment4_6L.listview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'listview'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassScheduleFragment4_6L classScheduleFragment4_6L = this.target;
        if (classScheduleFragment4_6L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classScheduleFragment4_6L.tv_week = null;
        classScheduleFragment4_6L.listview = null;
        this.view7f0a0c24.setOnClickListener(null);
        this.view7f0a0c24 = null;
    }
}
