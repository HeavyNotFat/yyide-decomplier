package com.yd.android_brand_mvp;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.paradoxie.autoscrolltextview.VerticalTextview;
import com.yd.android_brand_mvp.widget.YDViewPager;

/* JADX INFO: loaded from: D:\Desktop\AndroidProjects\HackedBrand3.0.15\build\app-smali-3.0.15\com\yd\android_brand_mvp\MainActivity_ViewBinding.smali */
public class MainActivity_ViewBinding implements Unbinder {
    private MainActivity target;
    private View view7f0a0422;
    private View view7f0a0446;
    private View view7f0a045d;
    private View view7f0a0524;
    private View view7f0a05c2;
    private View view7f0a05c8;
    private View view7f0a0c9e;
    private View view7f0a0cc0;

    public MainActivity_ViewBinding(MainActivity mainActivity) {
        this(mainActivity, mainActivity.getWindow().getDecorView());
    }

    public MainActivity_ViewBinding(final MainActivity mainActivity, View view) {
        this.target = mainActivity;
        mainActivity.bg = (ImageView) Utils.findRequiredViewAsType(view, R.id.bg, "field 'bg'", ImageView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.logo, "field 'logo' and method 'onViewClicked'");
        mainActivity.logo = (ImageView) Utils.castView(viewFindRequiredView, R.id.logo, "field 'logo'", ImageView.class);
        this.view7f0a05c8 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.MainActivity_ViewBinding.1
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        mainActivity.officename = (TextView) Utils.findRequiredViewAsType(view, R.id.officename, "field 'officename'", TextView.class);
        mainActivity.tv_text = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_text, "field 'tv_text'", TextView.class);
        mainActivity.weathericon = (ImageView) Utils.findRequiredViewAsType(view, R.id.weathericon, "field 'weathericon'", ImageView.class);
        mainActivity.weathertext = (TextView) Utils.findRequiredViewAsType(view, R.id.weathertext, "field 'weathertext'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.weatherlayout, "field 'weatherlayout' and method 'onViewClicked'");
        mainActivity.weatherlayout = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.weatherlayout, "field 'weatherlayout'", LinearLayout.class);
        this.view7f0a0c9e = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.MainActivity_ViewBinding.2
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        mainActivity.calendarLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.calendar_layout, "field 'calendarLayout'", LinearLayout.class);
        mainActivity.wifi = (ImageView) Utils.findRequiredViewAsType(view, R.id.wifi, "field 'wifi'", ImageView.class);
        mainActivity.pager = (YDViewPager) Utils.findRequiredViewAsType(view, R.id.pager, "field 'pager'", YDViewPager.class);
        mainActivity.recyleview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyleview, "field 'recyleview'", RecyclerView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.layout_setting, "field 'layout_setting' and method 'onViewClicked'");
        mainActivity.layout_setting = (LinearLayout) Utils.castView(viewFindRequiredView3, R.id.layout_setting, "field 'layout_setting'", LinearLayout.class);
        this.view7f0a0524 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.MainActivity_ViewBinding.3
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.xx, "field 'xx' and method 'onViewClicked'");
        mainActivity.xx = (ImageView) Utils.castView(viewFindRequiredView4, R.id.xx, "field 'xx'", ImageView.class);
        this.view7f0a0cc0 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.MainActivity_ViewBinding.4
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.lock, "field 'lock' and method 'onViewClicked'");
        mainActivity.lock = (TextView) Utils.castView(viewFindRequiredView5, R.id.lock, "field 'lock'", TextView.class);
        this.view7f0a05c2 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.MainActivity_ViewBinding.5
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.img_set, "field 'imgSet' and method 'onViewClicked'");
        mainActivity.imgSet = (ImageView) Utils.castView(viewFindRequiredView6, R.id.img_set, "field 'imgSet'", ImageView.class);
        this.view7f0a0422 = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.MainActivity_ViewBinding.6
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        mainActivity.wd = (TextView) Utils.findRequiredViewAsType(view, R.id.wd, "field 'wd'", TextView.class);
        mainActivity.vsname = (TextView) Utils.findRequiredViewAsType(view, R.id.vsname, "field 'vsname'", TextView.class);
        mainActivity.textView = (VerticalTextview) Utils.findRequiredViewAsType(view, R.id.text, "field 'textView'", VerticalTextview.class);
        mainActivity.download_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.download_msg, "field 'download_msg'", TextView.class);
        mainActivity.top_hint = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.top_hint, "field 'top_hint'", FrameLayout.class);
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.ivTiming, "method 'onViewClicked'");
        this.view7f0a045d = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.MainActivity_ViewBinding.7
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.ivBlank, "method 'onViewClicked'");
        this.view7f0a0446 = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.MainActivity_ViewBinding.8
            public void doClick(View view2) {
                mainActivity.onViewClicked(view2);
            }
        });
    }

    public void unbind() {
        MainActivity mainActivity = this.target;
        if (mainActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mainActivity.bg = null;
        mainActivity.logo = null;
        mainActivity.officename = null;
        mainActivity.tv_text = null;
        mainActivity.weathericon = null;
        mainActivity.weathertext = null;
        mainActivity.weatherlayout = null;
        mainActivity.calendarLayout = null;
        mainActivity.wifi = null;
        mainActivity.pager = null;
        mainActivity.recyleview = null;
        mainActivity.layout_setting = null;
        mainActivity.xx = null;
        mainActivity.lock = null;
        mainActivity.imgSet = null;
        mainActivity.wd = null;
        mainActivity.vsname = null;
        mainActivity.textView = null;
        mainActivity.download_msg = null;
        mainActivity.top_hint = null;
        this.view7f0a05c8.setOnClickListener(null);
        this.view7f0a05c8 = null;
        this.view7f0a0c9e.setOnClickListener(null);
        this.view7f0a0c9e = null;
        this.view7f0a0524.setOnClickListener(null);
        this.view7f0a0524 = null;
        this.view7f0a0cc0.setOnClickListener(null);
        this.view7f0a0cc0 = null;
        this.view7f0a05c2.setOnClickListener(null);
        this.view7f0a05c2 = null;
        this.view7f0a0422.setOnClickListener(null);
        this.view7f0a0422 = null;
        this.view7f0a045d.setOnClickListener(null);
        this.view7f0a045d = null;
        this.view7f0a0446.setOnClickListener(null);
        this.view7f0a0446 = null;
    }
}
