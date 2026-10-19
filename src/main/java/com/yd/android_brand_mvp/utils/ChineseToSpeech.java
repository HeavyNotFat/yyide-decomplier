package com.yd.android_brand_mvp.utils;

import android.speech.tts.TextToSpeech;
import android.util.Log;
import com.yd.android_brand_mvp.BaseApplication;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class ChineseToSpeech {
    private static ChineseToSpeech mInstance;
    private TextToSpeech textToSpeech = new TextToSpeech(BaseApplication.getInstance(), new TextToSpeech.OnInitListener() { // from class: com.yd.android_brand_mvp.utils.ChineseToSpeech.1
        @Override // android.speech.tts.TextToSpeech.OnInitListener
        public void onInit(int i) {
            if (i == 0) {
                int language = ChineseToSpeech.this.textToSpeech.setLanguage(Locale.CHINA);
                if (language == -1 || language == -2) {
                    Log.e("TAG", "onInit: 不支持朗读功能");
                }
            }
        }
    });

    public static synchronized ChineseToSpeech getInstance() {
        if (mInstance == null) {
            mInstance = new ChineseToSpeech();
        }
        return mInstance;
    }

    public void speech(String str) {
        this.textToSpeech.speak(str, 0, null);
    }

    public void destroy() {
        TextToSpeech textToSpeech = this.textToSpeech;
        if (textToSpeech != null) {
            textToSpeech.stop();
            this.textToSpeech.shutdown();
        }
    }
}
