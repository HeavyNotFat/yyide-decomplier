package com.yd.android_brand_mvp.utils;

import android.content.Context;
import android.media.AudioManager;

/* JADX INFO: loaded from: classes4.dex */
public class AudioUtil {
    private static AudioUtil mInstance;
    private AudioManager mAudioManager;

    private AudioUtil(Context context) {
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
    }

    public static synchronized AudioUtil getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new AudioUtil(context);
        }
        return mInstance;
    }

    public int getMediaMaxVolume() {
        return this.mAudioManager.getStreamMaxVolume(3);
    }

    public int getMediaVolume() {
        return this.mAudioManager.getStreamVolume(3);
    }

    public int getCallMaxVolume() {
        return this.mAudioManager.getStreamMaxVolume(0);
    }

    public int getSystemMaxVolume() {
        return this.mAudioManager.getStreamMaxVolume(1);
    }

    public int getSystemVolume() {
        return this.mAudioManager.getStreamVolume(1);
    }

    public int getAlermMaxVolume() {
        return this.mAudioManager.getStreamMaxVolume(4);
    }

    public void setMediaVolume(int i) {
        this.mAudioManager.setStreamVolume(3, i, 12);
    }

    public void setCallVolume(int i) {
        this.mAudioManager.setStreamVolume(0, i, 0);
    }

    public void setSpeakerStatus(boolean z) {
        if (z) {
            this.mAudioManager.setSpeakerphoneOn(true);
            this.mAudioManager.setMode(0);
            return;
        }
        this.mAudioManager.setStreamVolume(0, this.mAudioManager.getStreamMaxVolume(0), 0);
        this.mAudioManager.setMode(3);
        this.mAudioManager.setSpeakerphoneOn(false);
        this.mAudioManager.setRouting(0, 1, -1);
    }
}
