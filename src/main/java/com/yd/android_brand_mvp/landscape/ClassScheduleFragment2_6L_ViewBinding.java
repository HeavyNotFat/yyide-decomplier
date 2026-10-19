package com.yd.android_brand_mvp.landscape;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class ClassScheduleFragment2_6L_ViewBinding implements Unbinder {
    private ClassScheduleFragment2_6L target;
    private View view7f0a0255;

    public ClassScheduleFragment2_6L_ViewBinding(final ClassScheduleFragment2_6L classScheduleFragment2_6L, View view) {
        this.target = classScheduleFragment2_6L;
        classScheduleFragment2_6L.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.content_layout, "method 'onViewClicked'");
        this.view7f0a0255 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.ClassScheduleFragment2_6L_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classScheduleFragment2_6L.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassScheduleFragment2_6L classScheduleFragment2_6L = this.target;
        if (classScheduleFragment2_6L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classScheduleFragment2_6L.recyclerView = null;
        this.view7f0a0255.setOnClickListener(null);
        this.view7f0a0255 = null;
    }
}
