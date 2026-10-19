package com.yd.android_brand_mvp.utils;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import java.io.File;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class TakePicUtil {
    private static final int CODE_ALBUM = 102;
    private static final int CODE_ALBUM_NOCORP = 105;
    private static final int CODE_CORP = 103;
    private static final int CODE_PICTURE = 101;
    private static final int CODE_PICTURE_NOCORP = 104;
    private static Config config;
    private static File output = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/ydapp/portraits/temp.png");

    public static void config(Config config2) {
        config = config2;
    }

    public static void takePicture(Activity activity) {
        takePicture(activity, true);
    }

    public static void albumPhoto(Activity activity) {
        albumPhoto(activity, true);
    }

    public static void takePicture(Activity activity, boolean z) {
        if (hasSdcard()) {
            if (output.getParentFile() != null && !output.getParentFile().exists()) {
                output.getParentFile().mkdirs();
            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            Uri uriForFile = getUriForFile(activity, output);
            if (Build.VERSION.SDK_INT >= 24) {
                intent.setFlags(1);
            }
            intent.putExtra("output", uriForFile);
            if (z) {
                activity.startActivityForResult(intent, 101);
            } else {
                activity.startActivityForResult(intent, 104);
            }
        }
    }

    public static void albumPhoto(Activity activity, boolean z) {
        if (output.getParentFile() != null && !output.getParentFile().exists()) {
            output.getParentFile().mkdirs();
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType(TransUtils.MIME_IMAGE);
        if (z) {
            activity.startActivityForResult(intent, 102);
        } else {
            activity.startActivityForResult(intent, 105);
        }
    }

    private static boolean corp(Activity activity, File file) {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Uri uriForFile = getUriForFile(activity, file);
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uriForFile, TransUtils.MIME_IMAGE);
        intent.putExtra("crop", "true");
        intent.putExtra("circleCrop", false);
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
            intent.addFlags(2);
        }
        Config config2 = config;
        if (config2 == null) {
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
        } else {
            if (config2.circleCorp) {
                intent.putExtra("circleCrop", true);
            }
            if (config.acceptX != 0) {
                intent.putExtra("aspectX", config.acceptX);
                intent.putExtra("aspectY", config.acceptY);
            }
            if (config.enableZipPixel) {
                intent.putExtra("outputX", config.acceptX * 400);
                intent.putExtra("outputY", config.acceptY * 400);
            }
        }
        config = null;
        intent.putExtra("return-data", false);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("output", Uri.fromFile(output));
        if (!isIntentAvailable(activity, intent)) {
            return false;
        }
        try {
            activity.startActivityForResult(intent, 103);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static File onActivityResult(Activity activity, int i, int i2, Intent intent) {
        String absolutePath;
        if (i2 == -1 && ((i != 102 && i != 105) || intent != null)) {
            if (i != 101 && i != 102) {
                if (i == 103 || i == 104) {
                    return output;
                }
                if (i != 105) {
                    return null;
                }
                String path = getPath(activity, intent.getData());
                if (TextUtils.isEmpty(path)) {
                    return null;
                }
                return new File(path);
            }
            if (i == 101) {
                absolutePath = output.getAbsolutePath();
            } else {
                absolutePath = i != 102 ? "" : getPath(activity, intent.getData());
            }
            if (TextUtils.isEmpty(absolutePath)) {
                return null;
            }
            corp(activity, new File(absolutePath));
        }
        return null;
    }

    private static boolean isIntentAvailable(Activity activity, Intent intent) {
        return activity.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    private static Uri getUriForFile(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, "com.yd.android_brand_mvp.FileProvider", file);
        }
        return Uri.fromFile(file);
    }

    private static boolean hasSdcard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String getPath(Context context, Uri uri) {
        Uri uri2 = null;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                    return "" + Environment.getExternalStorageDirectory() + MqttTopic.TOPIC_LEVEL_SEPARATOR + strArrSplit[1];
                }
            } else {
                if (isDownloadsDocument(uri)) {
                    return "" + getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                }
                if (isMediaDocument(uri)) {
                    String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    String str = strArrSplit2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return "" + getDataColumn(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return "" + getDataColumn(context, uri, null, null);
            }
            if ("output".equalsIgnoreCase(uri.getScheme())) {
                return "" + uri.getPath();
            }
        }
        return null;
    }

    private static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return string;
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (cursorQuery == null) {
            return null;
        }
        cursorQuery.close();
        return null;
    }

    private static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static class Config {
        private int acceptX = 1;
        private int acceptY = 1;
        private boolean circleCorp;
        private boolean enableZipPixel;

        public Config enableZipPixel() {
            this.enableZipPixel = true;
            return this;
        }

        public Config enableCircleCorp() {
            this.circleCorp = true;
            return this;
        }

        public Config rectParm(int i, int i2) {
            this.acceptX = i;
            this.acceptY = i2;
            return this;
        }
    }
}
