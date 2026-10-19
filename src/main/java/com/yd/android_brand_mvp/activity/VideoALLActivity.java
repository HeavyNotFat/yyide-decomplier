package com.yd.android_brand_mvp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseActivity;
import com.yd.android_brand_mvp.utils.VideoUtils;
import com.yd.android_brand_mvp.video1.SampleCoverVideo;

/* JADX INFO: loaded from: classes4.dex */
public class VideoALLActivity extends BaseActivity {
    TextView close;
    SampleCoverVideo player;
    String url = "url";
    int volume;

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_allvideo);
        this.close = (TextView) findViewById(R.id.close);
        this.player = (SampleCoverVideo) findViewById(R.id.player);
        this.volume = VideoUtils.getVideoMute(this);
        String stringExtra = getIntent().getStringExtra(this.url);
        this.player.setBottonState(8);
        this.player.setUp(stringExtra, false, null);
        this.player.startPlayLogic();
        VideoUtils.setVideoState(this, "1");
        this.close.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.VideoALLActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoALLActivity.this.finish();
            }
        });
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        VideoUtils.setVideoMute(this, this.volume);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }
}
