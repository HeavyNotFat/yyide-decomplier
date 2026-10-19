package com.yd.android_brand_mvp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.yd.android_brand_mvp.base.BaseActivity;
import com.yd.android_brand_mvp.widget.X5WebView;

/* JADX INFO: loaded from: classes4.dex */
public class WebActivity extends BaseActivity {
    public static String ID = "ID";
    public static String TITLEEXTRA = "TITLEEXTRA";
    public static String URLEXTRA = "URLEXTRA";

    @BindView(R.id.back)
    TextView back;
    String mIntentUrl;
    String titleStr;
    String userid;

    @BindView(R.id.webView1)
    X5WebView webView1;

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_web3);
        ButterKnife.bind(this);
        this.titleStr = getIntent().getExtras().getString(TITLEEXTRA);
        String string = getIntent().getExtras().getString(ID);
        this.userid = string;
        String strSubstring = string.substring(0, 10);
        this.mIntentUrl = getIntent().getExtras().getString(URLEXTRA);
        this.mIntentUrl += "?uid=" + strSubstring;
        Log.i("TAG", "nid: " + strSubstring);
        Log.i("TAG", "userid: " + this.userid);
        Log.i("TAG", "loadUrl: " + this.mIntentUrl);
        this.webView1.loadUrl(this.mIntentUrl);
    }

    @OnClick({R.id.back})
    public void onViewClicked(View view) {
        if (view.getId() == R.id.back) {
            finish();
        }
    }
}
