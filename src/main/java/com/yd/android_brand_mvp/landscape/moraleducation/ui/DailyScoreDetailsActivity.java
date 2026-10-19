package com.yd.android_brand_mvp.landscape.moraleducation.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CurrentMEModel;
import com.yd.android_brand_mvp.landscape.moraleducation.ui.fragment.ClassesScoreWeekListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DailyScoreDetailsActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/DailyScoreDetailsActivity;", "Lcom/yd/android_brand_mvp/base/BaseLayoutActivity;", "()V", "getFragment", "Landroidx/fragment/app/Fragment;", "getName", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DailyScoreDetailsActivity extends BaseLayoutActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String PARAMS = "data";

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /* JADX INFO: compiled from: DailyScoreDetailsActivity.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/DailyScoreDetailsActivity$Companion;", "", "()V", "PARAMS", "", TtmlNode.START, "", "context", "Landroid/content/Context;", "activityId", "cycleId", "", "data", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;)V", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String activityId, Long cycleId, CurrentMEModel data) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) DailyScoreDetailsActivity.class);
            intent.putExtra("activityId", activityId);
            intent.putExtra("cycleId", cycleId);
            intent.putExtra("data", data);
            ActivityUtils.startActivity(intent);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        String stringExtra = getIntent().getStringExtra("activityId");
        long longExtra = getIntent().getLongExtra("cycleId", 0L);
        CurrentMEModel currentMEModel = (CurrentMEModel) getIntent().getParcelableExtra("data");
        StringBuilder sb = new StringBuilder();
        sb.append("当前周次: ");
        sb.append(currentMEModel != null ? currentMEModel.getMCycle() : null);
        setRightTextView(sb.toString());
        getRightTextView().setTextColor(getResources().getColor(R.color.black9));
        if (ScreenUtils.isLandscape()) {
            return DailyScoreDetailsFragment.INSTANCE.newInstance(stringExtra, Long.valueOf(longExtra));
        }
        return ClassesScoreWeekListFragment.INSTANCE.newInstance(stringExtra, Long.valueOf(longExtra), currentMEModel);
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        String string = getResources().getString(R.string.daily_score_details);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.daily_score_details)");
        return string;
    }
}
