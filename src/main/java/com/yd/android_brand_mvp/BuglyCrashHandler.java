package com.yd.android_brand_mvp;

import com.blankj.utilcode.util.LogUtils;
import com.tencent.bugly.crashreport.CrashReport;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes4.dex */
public class BuglyCrashHandler implements Thread.UncaughtExceptionHandler {
    static BuglyCrashHandler instance;
    Thread.UncaughtExceptionHandler exceptionHandler;

    public BuglyCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.exceptionHandler = uncaughtExceptionHandler;
        instance = this;
    }

    public static BuglyCrashHandler getInstance() {
        return instance;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        LogUtils.e("Thread = " + thread.getName());
        LogUtils.e(getStackTraceInfo(th));
        CrashReport.postCatchedException(th);
    }

    public String getStackTraceInfo(Throwable th) throws Throwable {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = null;
        try {
            PrintWriter printWriter2 = new PrintWriter(stringWriter);
            try {
                th.printStackTrace(printWriter2);
                printWriter2.close();
                return stringWriter.toString();
            } catch (Exception unused) {
                printWriter = printWriter2;
                if (printWriter != null) {
                    printWriter.close();
                }
                return "";
            } catch (Throwable th2) {
                th = th2;
                printWriter = printWriter2;
                if (printWriter != null) {
                    printWriter.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
