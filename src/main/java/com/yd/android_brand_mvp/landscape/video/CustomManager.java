package com.yd.android_brand_mvp.landscape.video;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.shuyu.gsyvideoplayer.GSYVideoBaseManager;
import com.shuyu.gsyvideoplayer.player.IPlayerManager;
import com.shuyu.gsyvideoplayer.player.IjkPlayerManager;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class CustomManager extends GSYVideoBaseManager {
    public static final int FULLSCREEN_ID = 2131362427;
    public static final int SMALL_ID = 2131362428;
    public static String TAG = "GSYVideoManager";
    private static Map<String, CustomManager> sMap = new HashMap();

    public CustomManager() {
        init();
    }

    @Override // com.shuyu.gsyvideoplayer.GSYVideoBaseManager
    protected IPlayerManager getPlayManager() {
        return new IjkPlayerManager();
    }

    @Override // com.shuyu.gsyvideoplayer.GSYVideoBaseManager
    public void setNeedMute(boolean z) {
        super.setNeedMute(true);
    }

    public static void setNeedMuteYD(boolean z) {
        if (sMap.size() > 0) {
            Iterator<Map.Entry<String, CustomManager>> it2 = sMap.entrySet().iterator();
            while (it2.hasNext()) {
                it2.next().getValue().setNeedMute(z);
            }
        }
    }

    public static boolean backFromWindowFull(Context context, String str) {
        if (((ViewGroup) CommonUtil.scanForActivity(context).findViewById(R.id.content)).findViewById(com.yd.android_brand_mvp.R.id.custom_full_id) == null) {
            return false;
        }
        CommonUtil.hideNavKey(context);
        if (getCustomManager(str).lastListener() == null) {
            return true;
        }
        getCustomManager(str).lastListener().onBackFullscreen();
        return true;
    }

    public static void releaseAllVideos(String str) {
        if (getCustomManager(str).listener() != null) {
            getCustomManager(str).listener().onCompletion();
        }
        getCustomManager(str).releaseMediaPlayer();
    }

    public void onPause(String str) {
        if (getCustomManager(str).listener() != null) {
            getCustomManager(str).listener().onVideoPause();
        }
    }

    public void onResume(String str) {
        if (getCustomManager(str).listener() != null) {
            getCustomManager(str).listener().onVideoResume();
        }
    }

    public void onResume(String str, boolean z) {
        if (getCustomManager(str).listener() != null) {
            getCustomManager(str).listener().onVideoResume(z);
        }
    }

    public static synchronized Map<String, CustomManager> instance() {
        return sMap;
    }

    public static synchronized CustomManager getCustomManager(String str) {
        CustomManager customManager;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException("key not be empty");
        }
        customManager = sMap.get(str);
        if (customManager == null) {
            customManager = new CustomManager();
            sMap.put(str, customManager);
        }
        return customManager;
    }

    public static void onPauseAll() {
        if (sMap.size() > 0) {
            for (Map.Entry<String, CustomManager> entry : sMap.entrySet()) {
                entry.getValue().onPause(entry.getKey());
            }
        }
    }

    public static void onResumeAll() {
        if (sMap.size() > 0) {
            for (Map.Entry<String, CustomManager> entry : sMap.entrySet()) {
                entry.getValue().onResume(entry.getKey());
            }
        }
    }

    public static void onResumeAll(boolean z) {
        if (sMap.size() > 0) {
            for (Map.Entry<String, CustomManager> entry : sMap.entrySet()) {
                entry.getValue().onResume(entry.getKey(), z);
            }
        }
    }

    public static void clearAllVideo() {
        if (sMap.size() > 0) {
            Iterator<Map.Entry<String, CustomManager>> it2 = sMap.entrySet().iterator();
            while (it2.hasNext()) {
                releaseAllVideos(it2.next().getKey());
            }
        }
        sMap.clear();
    }

    public static void removeManager(String str) {
        sMap.remove(str);
    }

    public static boolean isFullState(Activity activity) {
        View viewFindViewById = ((ViewGroup) CommonUtil.scanForActivity(activity).findViewById(R.id.content)).findViewById(com.yd.android_brand_mvp.R.id.custom_full_id);
        return (viewFindViewById != null ? (GSYVideoPlayer) viewFindViewById : null) != null;
    }
}
