package com.yd.android_brand_mvp.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.landscape.message.AnnouncementListFragment;
import com.yd.android_brand_mvp.portrait.fragment.AnnouncementListFragmentP;

/* JADX INFO: loaded from: classes4.dex */
public class AnnouncementListActivity extends BaseLayoutActivity {
    public static final String TYPE_ANNOUNCEMENT = "announcement";
    public static final String TYPE_ARTICLE = "article";
    public static final String TYPE_CAMPUSSTYLE = "campusStyle";
    public static final String TYPE_NEWS = "news";
    public static final String TYPE_POSTER = "poster";
    public static final String TYPE_RECEIVE = "receive";

    public static void start(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) AnnouncementListActivity.class);
        intent.putExtra("type", str);
        intent.putExtra("id", str2);
        context.startActivity(intent);
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        Fragment announcementListFragmentP;
        if (ScreenUtils.isLandscape()) {
            announcementListFragmentP = new AnnouncementListFragment();
        } else {
            announcementListFragmentP = new AnnouncementListFragmentP();
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", getIntent().getStringExtra("type"));
        bundle.putString("id", getIntent().getStringExtra("id"));
        announcementListFragmentP.setArguments(bundle);
        return announcementListFragmentP;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        String stringExtra = getIntent().getStringExtra("type");
        if (stringExtra != null) {
            byte b = -1;
            switch (stringExtra.hashCode()) {
                case -1372949486:
                    if (stringExtra.equals(TYPE_CAMPUSSTYLE)) {
                        b = 4;
                    }
                    break;
                case -982450867:
                    if (stringExtra.equals(TYPE_POSTER)) {
                        b = 5;
                    }
                    break;
                case -732377866:
                    if (stringExtra.equals(TYPE_ARTICLE)) {
                        b = 3;
                    }
                    break;
                case 3377875:
                    if (stringExtra.equals(TYPE_NEWS)) {
                        b = 0;
                    }
                    break;
                case 156781895:
                    if (stringExtra.equals(TYPE_ANNOUNCEMENT)) {
                        b = 1;
                    }
                    break;
                case 1082290915:
                    if (stringExtra.equals(TYPE_RECEIVE)) {
                        b = 2;
                    }
                    break;
            }
            if (b == 0) {
                return getString(R.string.st_notification_news_title);
            }
            if (b == 1) {
                return getString(R.string.st_notification_announcement);
            }
            if (b == 2) {
                return getString(R.string.st_notification_receiver_title);
            }
            if (b == 3) {
                return getString(R.string.st_notification_article_title);
            }
            if (b == 4) {
                return getString(R.string.st_notification_campus_title);
            }
            if (b == 5) {
                return getString(R.string.st_notification_poster_title);
            }
        }
        return getString(R.string.st_notification_announcement);
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
