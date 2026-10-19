package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.necer.calendar.MonthCalendar;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class NCalendarLFragment_ViewBinding implements Unbinder {
    private NCalendarLFragment target;

    public NCalendarLFragment_ViewBinding(NCalendarLFragment nCalendarLFragment, View view) {
        this.target = nCalendarLFragment;
        nCalendarLFragment.bg = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.bg, "field 'bg'", RelativeLayout.class);
        nCalendarLFragment.Calendar = (MonthCalendar) Utils.findRequiredViewAsType(view, R.id.calendar, "field 'Calendar'", MonthCalendar.class);
        nCalendarLFragment.schoolyear = (TextView) Utils.findRequiredViewAsType(view, R.id.schoolyear, "field 'schoolyear'", TextView.class);
        nCalendarLFragment.left_month = (TextView) Utils.findRequiredViewAsType(view, R.id.left_month, "field 'left_month'", TextView.class);
        nCalendarLFragment.right_month = (TextView) Utils.findRequiredViewAsType(view, R.id.right_month, "field 'right_month'", TextView.class);
        nCalendarLFragment.tv_month = (TextView) Utils.findRequiredViewAsType(view, R.id.month, "field 'tv_month'", TextView.class);
        nCalendarLFragment.listview = (ListView) Utils.findRequiredViewAsType(view, R.id.listview, "field 'listview'", ListView.class);
        nCalendarLFragment.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        nCalendarLFragment.back = (TextView) Utils.findRequiredViewAsType(view, R.id.ivBack, "field 'back'", TextView.class);
        nCalendarLFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        nCalendarLFragment.all_mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.all_mu, "field 'all_mu'", MultiStateView.class);
        nCalendarLFragment.top_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.top_layout, "field 'top_layout'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NCalendarLFragment nCalendarLFragment = this.target;
        if (nCalendarLFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        nCalendarLFragment.bg = null;
        nCalendarLFragment.Calendar = null;
        nCalendarLFragment.schoolyear = null;
        nCalendarLFragment.left_month = null;
        nCalendarLFragment.right_month = null;
        nCalendarLFragment.tv_month = null;
        nCalendarLFragment.listview = null;
        nCalendarLFragment.title = null;
        nCalendarLFragment.back = null;
        nCalendarLFragment.mu = null;
        nCalendarLFragment.all_mu = null;
        nCalendarLFragment.top_layout = null;
    }
}
