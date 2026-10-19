package com.yd.android_brand_mvp;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.widget.X5WebView;

/* JADX INFO: loaded from: classes4.dex */
public class WebActivity_ViewBinding implements Unbinder {
    private WebActivity target;
    private View view7f0a009c;

    public WebActivity_ViewBinding(WebActivity webActivity) {
        this(webActivity, webActivity.getWindow().getDecorView());
    }

    public WebActivity_ViewBinding(final WebActivity webActivity, View view) {
        this.target = webActivity;
        webActivity.webView1 = (X5WebView) Utils.findRequiredViewAsType(view, R.id.webView1, "field 'webView1'", X5WebView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.back, "field 'back' and method 'onViewClicked'");
        webActivity.back = (TextView) Utils.castView(viewFindRequiredView, R.id.back, "field 'back'", TextView.class);
        this.view7f0a009c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.WebActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                webActivity.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        WebActivity webActivity = this.target;
        if (webActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        webActivity.webView1 = null;
        webActivity.back = null;
        this.view7f0a009c.setOnClickListener(null);
        this.view7f0a009c = null;
    }
}
