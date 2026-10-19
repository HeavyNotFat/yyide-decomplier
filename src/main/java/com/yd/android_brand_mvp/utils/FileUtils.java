package com.yd.android_brand_mvp.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class FileUtils {
    public static final String DOCUMENTS_DIR = "documents";
    public static String filePath = Environment.getExternalStorageDirectory() + File.separator + "yd_screenshot";

    private FileUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String saveBitmapFile(Bitmap bitmap, String str) {
        if (bitmap == null || TextUtils.isEmpty(str)) {
            return "";
        }
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str + ".jpg");
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file2.getAbsolutePath();
    }

    public static void closeIO(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void closeIOQuietly(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    public static boolean createOrExistsFile(String str) {
        return createOrExistsFile(getFileByPath(str));
    }

    public static File getFileByPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(str);
    }

    public static boolean createOrExistsFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static void writeErrorStringToFile(String str, String str2) {
        File file = new File(str2);
        if (!file.exists()) {
            if (file.mkdirs()) {
                writeStringToFile(str, file);
                return;
            }
            return;
        }
        writeStringToFile(str, file);
    }

    private static void writeStringToFile(final String str, final File file) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new Thread(new Runnable() { // from class: com.yd.android_brand_mvp.utils.-$$Lambda$FileUtils$ToLRSvmTs86Fr7CxhdhtMPMU3SE
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                FileUtils.lambda$writeStringToFile$0(str, file);
            }
        }).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x006d -> B:32:0x0070). Please report as a decompilation issue!!! */
    static /* synthetic */ void lambda$writeStringToFile$0(String str, File file) throws Throwable {
        ?? r0 = 0;
        FileOutputStream fileOutputStream = null;
        r0 = 0;
        try {
            try {
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, TimeUtil.getCurrentTimeStr() + ".txt"));
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = byteArrayInputStream.read(bArr);
                            if (i == -1) {
                                break;
                            } else {
                                fileOutputStream2.write(bArr, 0, i);
                            }
                        }
                        fileOutputStream2.flush();
                        StringBuilder sb = new StringBuilder();
                        sb.append("写入本地文件成功：");
                        sb.append(file.getAbsolutePath());
                        Log.e("程序出异常了", sb.toString());
                        fileOutputStream2.close();
                        r0 = sb;
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        r0 = fileOutputStream;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            r0 = fileOutputStream;
                        }
                    } catch (Throwable th) {
                        th = th;
                        r0 = fileOutputStream2;
                        if (r0 != 0) {
                            try {
                                r0.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
            r0 = r0;
        }
    }

    public static File getDocumentCacheDir(Context context) {
        File file = new File(context.getCacheDir(), "documents");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
