package com.yd.android_brand_mvp.utils;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.util.Log;
import com.yd.android_brand_mvp.BuildConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public class FileStorageHelper {
    private static final String SEPARATOR = File.separator;
    private static String TAG = "update";

    public static boolean copyAssetsToDst(Context context, String str, String str2) {
        try {
            String[] list = context.getAssets().list(str);
            Log.i("TAG", "start copy");
            if (list.length > 0) {
                File file = new File(Environment.getExternalStorageDirectory(), str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                for (String str3 : list) {
                    if (!str.equals(BuildConfig.FLAVOR)) {
                        Log.i("TAG", "path not exit,creat it now");
                        copyAssetsToDst(context, str + File.separator + str3, str2 + File.separator + str3);
                    } else {
                        Log.i("TAG", "copy files  now");
                        copyAssetsToDst(context, str3, str2 + File.separator + str3);
                    }
                }
                return true;
            }
            Log.i("TAG", "file name xiaoyu 0");
            File file2 = new File(Environment.getExternalStorageDirectory(), str2);
            InputStream inputStreamOpen = context.getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.flush();
                    inputStreamOpen.close();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void copyFilesFromRaw(Context context, int i, String str, String str2) {
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i);
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        readInputStream(str2 + SEPARATOR + str, inputStreamOpenRawResource);
    }

    public static void readInputStream(String str, InputStream inputStream) {
        File file = new File(str);
        try {
            if (file.exists()) {
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[inputStream.available()];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    Log.d(TAG, "cp " + str + "ok");
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static String getStoragePath(Context context, boolean z) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = cls.getMethod("getPath", new Class[0]);
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Object objInvoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(objInvoke);
            for (int i = 0; i < length; i++) {
                Object obj = Array.get(objInvoke, i);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (z == ((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static boolean isSameFile(String str, String str2) throws IOException {
        try {
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                FileInputStream fileInputStream2 = new FileInputStream(str2);
                int iAvailable = fileInputStream.available();
                int iAvailable2 = fileInputStream2.available();
                if (iAvailable == iAvailable2) {
                    byte[] bArr = new byte[iAvailable];
                    byte[] bArr2 = new byte[iAvailable2];
                    fileInputStream.read(bArr);
                    fileInputStream2.read(bArr2);
                    for (int i = 0; i < iAvailable; i++) {
                        if (bArr[i] != bArr2[i]) {
                            System.out.println("文件内容不一样");
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                fileInputStream2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            return false;
                        }
                    }
                    System.out.println("两个文件完全相同");
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    try {
                        fileInputStream2.close();
                        return true;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return true;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                try {
                    fileInputStream2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                return false;
            } catch (FileNotFoundException e7) {
                e7.printStackTrace();
                return false;
            }
        } catch (IOException e8) {
            e8.printStackTrace();
            return false;
        }
    }
}
