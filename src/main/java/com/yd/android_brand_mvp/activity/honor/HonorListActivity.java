package com.yd.android_brand_mvp.activity.honor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.fragment.honor.HonorListFragment;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorListActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014¨\u0006\r"}, d2 = {"Lcom/yd/android_brand_mvp/activity/honor/HonorListActivity;", "Lcom/yd/android_brand_mvp/base/BaseLayoutActivity;", "()V", "addTitle", "", "getFragment", "Landroidx/fragment/app/Fragment;", "getName", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorListActivity extends BaseLayoutActivity {
    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public int addTitle() {
        return R.layout.title_layout2;
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        return "学生评价";
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = (TextView) findViewById(R.id.tv_right);
        ImageView imageView = (ImageView) findViewById(R.id.ivRightLeft);
        View viewFindViewById = findViewById(R.id.clRight);
        imageView.setVisibility(0);
        textView.setVisibility(0);
        textView.setText("活动");
        viewFindViewById.setVisibility(0);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.honor.-$$Lambda$HonorListActivity$EPy3bT3IYJZNNCnCjPs5GRe36zo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HonorListActivity.onCreate$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(HonorListActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) HonorActiveListActivity.class));
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        return HonorListFragment.INSTANCE.newInstance();
    }
}
