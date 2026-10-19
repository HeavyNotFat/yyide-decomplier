package com.yd.android_brand_mvp.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.vise.utils.view.ActivityUtil;
import com.yd.android_brand_mvp.WelcomeActivity;
import java.util.List;
import java.util.Stack;

/* JADX INFO: loaded from: classes4.dex */
public class ActivityTool {
    private static final String TAG = "ActivityUtil";
    private static ActivityTool sActivityUtil;
    public Stack<Activity> mActivityStack = new Stack<>();

    private ActivityTool() {
    }

    public static ActivityTool getInstance() {
        if (sActivityUtil == null) {
            synchronized (ActivityUtil.class) {
                if (sActivityUtil == null) {
                    sActivityUtil = new ActivityTool();
                }
            }
        }
        return sActivityUtil;
    }

    public void addActivity(Activity activity) {
        this.mActivityStack.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (activity == null || !this.mActivityStack.contains(activity)) {
            return;
        }
        this.mActivityStack.remove(activity);
    }

    public Activity getCurrentActivity() {
        return this.mActivityStack.lastElement();
    }

    public Activity getActivity(Class<?> cls) {
        Stack<Activity> stack = this.mActivityStack;
        if (stack == null) {
            return null;
        }
        for (Activity activity : stack) {
            if (activity.getClass().equals(cls)) {
                return activity;
            }
        }
        return null;
    }

    public void finishCurrentActivity() {
        finishActivity(this.mActivityStack.lastElement());
    }

    public void finishActivity(Activity activity) {
        if (activity == null || !this.mActivityStack.contains(activity)) {
            return;
        }
        this.mActivityStack.remove(activity);
        activity.finish();
    }

    public void finishActivity(Class<?> cls) {
        for (Activity activity : this.mActivityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                return;
            }
        }
    }

    public void finishAllActivity() {
        for (int size = this.mActivityStack.size() - 1; size >= 0; size--) {
            if (this.mActivityStack.get(size) != null) {
                finishActivity(this.mActivityStack.get(size));
            }
        }
        this.mActivityStack.clear();
    }

    public void finishAllActivityExcept(Class<?> cls) {
        for (int size = this.mActivityStack.size() - 1; size >= 0; size--) {
            if (this.mActivityStack.get(size) != null && !this.mActivityStack.get(size).getClass().equals(cls)) {
                finishActivity(this.mActivityStack.get(size));
            }
        }
    }

    public void exitApp() {
        try {
            try {
                finishAllActivity();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            System.exit(0);
        }
    }

    public static boolean isForeground(Context context, String str) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        return (context == null || TextUtils.isEmpty(str) || (runningTasks = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1)) == null || runningTasks.size() <= 0 || !str.equals(runningTasks.get(0).topActivity.getClassName())) ? false : true;
    }

    public static void relaunchApp(boolean z, Context context) {
        Intent intent = new Intent(context, (Class<?>) WelcomeActivity.class);
        intent.addFlags(335577088);
        context.startActivity(intent);
        if (z) {
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }
}
