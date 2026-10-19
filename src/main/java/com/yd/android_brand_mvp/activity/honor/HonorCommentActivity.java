package com.yd.android_brand_mvp.activity.honor;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.activity.fragment.honor.HonorCommentFragment;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.model.honor.HonorActiveDetailBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorCommentActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/activity/honor/HonorCommentActivity;", "Lcom/yd/android_brand_mvp/base/BaseLayoutActivity;", "()V", "getFragment", "Landroidx/fragment/app/Fragment;", "getName", "", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorCommentActivity extends BaseLayoutActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PARAMS_DATA = "data";
    private static final String PARAMS_IDENTITY_ID = "identityId";
    private static final String PARAMS_IDENTITY = "identity";

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        return "评分";
    }

    /* JADX INFO: compiled from: HonorCommentActivity.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/activity/honor/HonorCommentActivity$Companion;", "", "()V", "PARAMS_DATA", "", "PARAMS_IDENTITY", "PARAMS_IDENTITY_ID", TtmlNode.START, "", "context", "Landroid/content/Context;", "data", "Lcom/yd/android_brand_mvp/model/honor/HonorActiveDetailBean;", "identityId", "identity", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, HonorActiveDetailBean data, String identityId, String identity) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Intent intent = new Intent(context, (Class<?>) HonorCommentActivity.class);
            intent.putExtra(HonorCommentActivity.PARAMS_DATA, data);
            intent.putExtra(HonorCommentActivity.PARAMS_IDENTITY_ID, identityId);
            intent.putExtra(HonorCommentActivity.PARAMS_IDENTITY, identity);
            context.startActivity(intent);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        String stringExtra = getIntent().getStringExtra(PARAMS_IDENTITY_ID);
        String stringExtra2 = getIntent().getStringExtra(PARAMS_IDENTITY);
        return HonorCommentFragment.INSTANCE.newInstance((HonorActiveDetailBean) getIntent().getSerializableExtra(PARAMS_DATA), stringExtra, stringExtra2);
    }
}
