package com.yd.android_brand_mvp.activity.honor;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.activity.fragment.honor.HonorActiveDetailFragment;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorActiveDetailActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/activity/honor/HonorActiveDetailActivity;", "Lcom/yd/android_brand_mvp/base/BaseLayoutActivity;", "()V", "getFragment", "Landroidx/fragment/app/Fragment;", "getName", "", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorActiveDetailActivity extends BaseLayoutActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PARAMS_ID = "id";

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        return "活动详情";
    }

    /* JADX INFO: compiled from: HonorActiveDetailActivity.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/activity/honor/HonorActiveDetailActivity$Companion;", "", "()V", "PARAMS_ID", "", TtmlNode.START, "", "context", "Landroid/content/Context;", "id", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String id) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) HonorActiveDetailActivity.class);
            intent.putExtra(HonorActiveDetailActivity.PARAMS_ID, id);
            context.startActivity(intent);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        return HonorActiveDetailFragment.INSTANCE.newInstance(getIntent().getStringExtra(PARAMS_ID));
    }
}
