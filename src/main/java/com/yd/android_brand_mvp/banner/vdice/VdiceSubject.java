package com.yd.android_brand_mvp.banner.vdice;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class VdiceSubject {
    public static ArrayList<VdiceObserver> observers = new ArrayList<>();

    public void addView(VdiceObserver vdiceObserver) {
        observers.add(vdiceObserver);
    }

    public void deleteObserver(VdiceSubject vdiceSubject) {
        observers.remove(vdiceSubject);
    }

    public void notfifyObserver(boolean z) {
        Iterator<VdiceObserver> it2 = observers.iterator();
        while (it2.hasNext()) {
            it2.next().updateViceo(z);
        }
    }
}
