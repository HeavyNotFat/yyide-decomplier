package com.yd.android_brand_mvp.observer;

import android.util.Log;
import com.yd.android_brand_mvp.model.EventTimerBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes4.dex */
public class ObserverManager implements SubjectListener {
    private static volatile ObserverManager instance;
    private final String TAG;
    private final List<ObserverListener> list;

    private ObserverManager() {
        this.TAG = "ObserverManager";
        this.list = new ArrayList();
        Log.d("ObserverManager", "ObserverManager: init new");
    }

    private static class ObserverManagerHolder {
        private static final ObserverManager observerManager = new ObserverManager();

        private ObserverManagerHolder() {
        }
    }

    public static ObserverManager getInstance() {
        if (instance == null) {
            synchronized (ObserverManager.class) {
                if (instance == null) {
                    instance = new ObserverManager();
                }
            }
        }
        return instance;
    }

    @Override // com.yd.android_brand_mvp.observer.SubjectListener
    public void add(ObserverListener observerListener) {
        Log.d("ObserverManager", "add: " + observerListener.getClass());
        this.list.add(observerListener);
    }

    @Override // com.yd.android_brand_mvp.observer.SubjectListener
    public void notifyObserver(String str) {
        ArrayList arrayList = new ArrayList(this.list);
        Log.d("ObserverManager", "notifyObserver: listener size = " + this.list.size());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((ObserverListener) it2.next()).observerUpData(str);
        }
        EventBus.getDefault().post(new EventTimerBean());
    }

    @Override // com.yd.android_brand_mvp.observer.SubjectListener
    public void remove(ObserverListener observerListener) {
        this.list.remove(observerListener);
    }
}
