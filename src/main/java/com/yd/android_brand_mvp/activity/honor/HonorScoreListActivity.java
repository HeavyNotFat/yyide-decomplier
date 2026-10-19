package com.yd.android_brand_mvp.activity.honor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.fragment.honor.HonorScoreListFragment;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorScoreListActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/activity/honor/HonorScoreListActivity;", "Lcom/yd/android_brand_mvp/base/BaseLayoutActivity;", "()V", "addTitle", "", "getFragment", "Landroidx/fragment/app/Fragment;", "getName", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorScoreListActivity extends BaseLayoutActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PARAMS_ACTIVEID = "activeId";
    private static final String PARAMS_IDENTITYID = "identityId";

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public int addTitle() {
        return R.layout.title_layout2;
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        return "分值明细";
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /* JADX INFO: compiled from: HonorScoreListActivity.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/activity/honor/HonorScoreListActivity$Companion;", "", "()V", "PARAMS_ACTIVEID", "", "PARAMS_IDENTITYID", TtmlNode.START, "", "context", "Landroid/content/Context;", "activeId", "identityId", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String activeId, String identityId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(activeId, "activeId");
            Intrinsics.checkNotNullParameter(identityId, "identityId");
            Intent intent = new Intent(context, (Class<?>) HonorScoreListActivity.class);
            intent.putExtra(HonorScoreListActivity.PARAMS_ACTIVEID, activeId);
            intent.putExtra(HonorScoreListActivity.PARAMS_IDENTITYID, identityId);
            context.startActivity(intent);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        HonorScoreListFragment.Companion companion = HonorScoreListFragment.INSTANCE;
        String stringExtra = getIntent().getStringExtra(PARAMS_ACTIVEID);
        Intrinsics.checkNotNull(stringExtra);
        String stringExtra2 = getIntent().getStringExtra(PARAMS_IDENTITYID);
        Intrinsics.checkNotNull(stringExtra2);
        return companion.newInstance(stringExtra, stringExtra2);
    }
}
