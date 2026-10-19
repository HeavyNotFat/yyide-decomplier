package com.yd.android_brand_mvp.activity;

import androidx.fragment.app.Fragment;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.ai.AIJuniorAssistantFragment;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIJuniorAssistantActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/AIJuniorAssistantActivity;", "Lcom/yd/android_brand_mvp/base/BaseLayoutActivity;", "()V", "getFragment", "Landroidx/fragment/app/Fragment;", "getName", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AIJuniorAssistantActivity extends BaseLayoutActivity {
    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        this.isAutoClose = false;
        return AIJuniorAssistantFragment.INSTANCE.newInstance();
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        String stringExtra = getIntent().getStringExtra("title");
        if (stringExtra != null) {
            return stringExtra;
        }
        String string = getString(R.string.one_intelligence);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.one_intelligence)");
        return string;
    }
}
