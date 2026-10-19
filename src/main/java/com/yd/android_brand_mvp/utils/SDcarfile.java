package com.yd.android_brand_mvp.utils;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes4.dex */
public class SDcarfile {
    public static final String FACE_CODE = "face_code";
    public static final String FACE_CODE_TYPE = "face_code_type";

    public static String read(String str) {
        FileInputStream fileInputStream;
        String str2 = null;
        try {
            File file = new File(Environment.getExternalStorageDirectory(), str + ".txt");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    fileInputStream.close();
                    str2 = new String(bArr, "UTF-8");
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        }
        Log.e("SDcarfile", str + " == " + str2);
        return str2;
    }

    public static String read2() {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(Environment.getExternalStorageDirectory() + "/Download/CBG_Android_Face_Reco-active.txt"));
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                return new String(bArr, "UTF-8");
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                if (fileInputStream == null) {
                    return null;
                }
                try {
                    fileInputStream.close();
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        }
    }

    public static void save(String str, String str2) {
        FileOutputStream fileOutputStream = null;
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return;
            }
            File file = new File(Environment.getExternalStorageDirectory(), str + ".txt");
            Log.i("TAG", "getAbsolutePath: " + file.getAbsolutePath());
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(str2.getBytes());
                fileOutputStream2.close();
                return;
            } catch (Exception e) {
                e = e;
                fileOutputStream = fileOutputStream2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        e.printStackTrace();
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }
}
