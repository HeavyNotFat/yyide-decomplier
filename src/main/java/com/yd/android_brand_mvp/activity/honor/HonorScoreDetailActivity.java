package com.yd.android_brand_mvp.activity.honor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.fragment.honor.HonorScoreDetailFragment;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yyide.chatim_pro.model.honor.HonorScoreDetailBean;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorScoreDetailActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/activity/honor/HonorScoreDetailActivity;", "Lcom/yd/android_brand_mvp/base/BaseLayoutActivity;", "()V", "addTitle", "", "getFragment", "Landroidx/fragment/app/Fragment;", "getName", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorScoreDetailActivity extends BaseLayoutActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DATA = "DATA";

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public int addTitle() {
        return R.layout.title_layout2;
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public String getName() {
        return "得分明细表";
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /* JADX INFO: compiled from: HonorScoreDetailActivity.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/activity/honor/HonorScoreDetailActivity$Companion;", "", "()V", "DATA", "", TtmlNode.START, "", "context", "Landroid/content/Context;", "honorRuleGroup", "Lcom/yyide/chatim_pro/model/honor/HonorScoreDetailBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, HonorScoreDetailBean honorRuleGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) HonorScoreDetailActivity.class);
            intent.putExtra(HonorScoreDetailActivity.DATA, honorRuleGroup);
            context.startActivity(intent);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        HonorScoreDetailFragment.Companion companion = HonorScoreDetailFragment.INSTANCE;
        Serializable serializableExtra = getIntent().getSerializableExtra(DATA);
        Intrinsics.checkNotNull(serializableExtra);
        return companion.newInstance((HonorScoreDetailBean) serializableExtra);
    }
}
