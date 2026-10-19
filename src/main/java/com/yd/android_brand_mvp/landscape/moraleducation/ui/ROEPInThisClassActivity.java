package com.yd.android_brand_mvp.landscape.moraleducation.ui;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ActivityUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CurrentMEModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ROEPInThisClassActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/ROEPInThisClassActivity;", "Lcom/yd/android_brand_mvp/base/BaseLayoutActivity;", "()V", "getFragment", "Landroidx/fragment/app/Fragment;", "getName", "", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ROEPInThisClassActivity extends BaseLayoutActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String PARAMS = "data";

    /* JADX INFO: compiled from: ROEPInThisClassActivity.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JA\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/ROEPInThisClassActivity$Companion;", "", "()V", "PARAMS", "", TtmlNode.START, "", "context", "Landroid/content/Context;", "activityId", "cycleId", "", "title", "data", "", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;)V", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String activityId, Long cycleId, String title, List<CurrentMEModel> data) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) ROEPInThisClassActivity.class);
            intent.putParcelableArrayListExtra("data", (ArrayList) data);
            intent.putExtra("activityId", activityId);
            intent.putExtra("cycleId", cycleId);
            intent.putExtra("title", title);
            ActivityUtils.startActivity(intent);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        ArrayList<CurrentMEModel> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("data");
        Intrinsics.checkNotNull(parcelableArrayListExtra, "null cannot be cast to non-null type java.util.ArrayList<com.yd.android_brand_mvp.landscape.moraleducation.model.CurrentMEModel>{ kotlin.collections.TypeAliasesKt.ArrayList<com.yd.android_brand_mvp.landscape.moraleducation.model.CurrentMEModel> }");
        String stringExtra = getIntent().getStringExtra("activityId");
        long longExtra = getIntent().getLongExtra("cycleId", 0L);
        return ROEPInThisClassFragment.INSTANCE.newInstance(stringExtra, Long.valueOf(longExtra), getIntent().getStringExtra("title"), parcelableArrayListExtra);
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        String string = getResources().getString(R.string.roep_in_this_class);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.roep_in_this_class)");
        return string;
    }
}
