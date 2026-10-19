package com.yd.android_brand_mvp.portrait.activity;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.portrait.fragment.MessageDetailsFragment;
import com.yd.android_brand_mvp.user.AnnouncementListActivity;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageDetailsPActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/portrait/activity/MessageDetailsPActivity;", "Lcom/yd/android_brand_mvp/base/BaseLayoutActivity;", "()V", "getFragment", "Landroidx/fragment/app/Fragment;", "getName", "", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageDetailsPActivity extends BaseLayoutActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: MessageDetailsPActivity.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/portrait/activity/MessageDetailsPActivity$Companion;", "", "()V", TtmlNode.START, "", "context", "Landroid/content/Context;", "type", "", "data", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String type, MessageItemBean data) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Intent intent = new Intent(context, (Class<?>) MessageDetailsPActivity.class);
            intent.putExtra("type", type);
            intent.putExtra("data", GsonUtils.toJson(data));
            context.startActivity(intent);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        return MessageDetailsFragment.INSTANCE.newInstance();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        String stringExtra = getIntent().getStringExtra("type");
        if (stringExtra != null) {
            switch (stringExtra.hashCode()) {
                case -1372949486:
                    if (stringExtra.equals(AnnouncementListActivity.TYPE_CAMPUSSTYLE)) {
                        String string = getString(R.string.st_notification_campus_title);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.st_notification_campus_title)");
                        return string;
                    }
                    break;
                case -982450867:
                    if (stringExtra.equals(AnnouncementListActivity.TYPE_POSTER)) {
                        String string2 = getString(R.string.st_notification_poster_title);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.st_notification_poster_title)");
                        return string2;
                    }
                    break;
                case -732377866:
                    if (stringExtra.equals(AnnouncementListActivity.TYPE_ARTICLE)) {
                        String string3 = getString(R.string.st_notification_article_title);
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.st_notification_article_title)");
                        return string3;
                    }
                    break;
                case 3377875:
                    if (stringExtra.equals(AnnouncementListActivity.TYPE_NEWS)) {
                        String string4 = getString(R.string.st_notification_news_title);
                        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.st_notification_news_title)");
                        return string4;
                    }
                    break;
                case 156781895:
                    if (stringExtra.equals(AnnouncementListActivity.TYPE_ANNOUNCEMENT)) {
                        String string5 = getString(R.string.st_notification_announcement);
                        Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.st_notification_announcement)");
                        return string5;
                    }
                    break;
                case 1082290915:
                    if (stringExtra.equals(AnnouncementListActivity.TYPE_RECEIVE)) {
                        String string6 = getString(R.string.st_notification_receiver_title);
                        Intrinsics.checkNotNullExpressionValue(string6, "getString(R.string.st_notification_receiver_title)");
                        return string6;
                    }
                    break;
            }
        }
        String string7 = getString(R.string.st_notification_announcement);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(R.string.st_notification_announcement)");
        return string7;
    }
}
