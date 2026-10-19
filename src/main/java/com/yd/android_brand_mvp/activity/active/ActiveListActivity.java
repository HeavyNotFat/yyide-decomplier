package com.yd.android_brand_mvp.activity.active;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.active.fragment.ActiveListFragment;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActiveListActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/activity/active/ActiveListActivity;", "Lcom/yd/android_brand_mvp/base/BaseLayoutActivity;", "()V", "getFragment", "Landroidx/fragment/app/Fragment;", "getName", "", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActiveListActivity extends BaseLayoutActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: ActiveListActivity.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/activity/active/ActiveListActivity$Companion;", "", "()V", "startGo", "", "context", "Landroid/content/Context;", "title", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startGo(Context context, String title) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(title, "title");
            Intent intent = new Intent(context, (Class<?>) ActiveListActivity.class);
            intent.putExtra("title", title);
            context.startActivity(intent);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        return ActiveListFragment.INSTANCE.newInstance();
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        String stringExtra = getIntent().getStringExtra("title");
        if (stringExtra != null) {
            return stringExtra;
        }
        String string = getString(R.string.active_apply_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.active_apply_title)");
        return string;
    }
}
