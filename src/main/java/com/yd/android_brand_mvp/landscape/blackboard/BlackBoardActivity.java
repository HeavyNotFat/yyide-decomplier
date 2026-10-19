package com.yd.android_brand_mvp.landscape.blackboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ActivityUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlackBoardActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardActivity;", "Lcom/yd/android_brand_mvp/base/BaseLayoutActivity;", "()V", "getFragment", "Landroidx/fragment/app/Fragment;", "getName", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "persistentState", "Landroid/os/PersistableBundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlackBoardActivity extends BaseLayoutActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        return "黑板截图";
    }

    /* JADX INFO: compiled from: BlackBoardActivity.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardActivity$Companion;", "", "()V", TtmlNode.START, "", "context", "Landroid/content/Context;", "subject", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ActivityUtils.startActivity(new Intent(context, (Class<?>) BlackBoardActivity.class));
        }

        public final void start(Context context, String subject) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(subject, "subject");
            Intent intent = new Intent(context, (Class<?>) BlackBoardActivity.class);
            intent.putExtra("bean", subject);
            ActivityUtils.startActivity(intent);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        getRightTextView().setTextSize(20.0f);
        getRightTextView().setTextColor(getResources().getColor(R.color.color_666666));
        setRightTextView("（注：历史截图仅保留7天，大于7天的截图将被清除）");
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        return BlackBoardHomeFragment.INSTANCE.newInstance(getIntent().getStringExtra("bean"));
    }
}
