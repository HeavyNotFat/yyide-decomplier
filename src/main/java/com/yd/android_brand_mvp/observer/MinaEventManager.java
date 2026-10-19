package com.yd.android_brand_mvp.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/* JADX INFO: loaded from: classes4.dex */
public class MinaEventManager implements EventListener {
    private final Vector<MinaListener> list = new Vector<>();

    private static final class IdManagerHolder {
        static final MinaEventManager idManager = new MinaEventManager();

        private IdManagerHolder() {
        }
    }

    public static MinaEventManager getInstance() {
        return IdManagerHolder.idManager;
    }

    @Override // com.yd.android_brand_mvp.observer.EventListener
    public void add(MinaListener minaListener) {
        this.list.add(minaListener);
    }

    @Override // com.yd.android_brand_mvp.observer.EventListener
    public void notifyObserver(int i) {
        synchronized (MinaEventManager.class) {
            Iterator it2 = new ArrayList(this.list).iterator();
            while (it2.hasNext()) {
                ((MinaListener) it2.next()).UpdataEvent(i);
            }
        }
    }

    @Override // com.yd.android_brand_mvp.observer.EventListener
    public void remove(MinaListener minaListener) {
        this.list.remove(minaListener);
    }
}
