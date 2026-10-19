package com.yd.android_brand_mvp.observer.observer2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class TimeManager implements TimeListener {
    private static TimeManager observerManager;
    private List<TimeNoiceListener> list = new ArrayList();

    public static TimeManager getInstance() {
        if (observerManager == null) {
            synchronized (TimeManager.class) {
                if (observerManager == null) {
                    observerManager = new TimeManager();
                }
            }
        }
        return observerManager;
    }

    @Override // com.yd.android_brand_mvp.observer.observer2.TimeListener
    public void add(TimeNoiceListener timeNoiceListener) {
        this.list.add(timeNoiceListener);
    }

    @Override // com.yd.android_brand_mvp.observer.observer2.TimeListener
    public void notifyObserver(long j) {
        Iterator<TimeNoiceListener> it2 = this.list.iterator();
        while (it2.hasNext()) {
            it2.next().updataTime(j);
        }
    }

    @Override // com.yd.android_brand_mvp.observer.observer2.TimeListener
    public void remove(TimeNoiceListener timeNoiceListener) {
        if (this.list.contains(timeNoiceListener)) {
            this.list.remove(timeNoiceListener);
        }
    }
}
