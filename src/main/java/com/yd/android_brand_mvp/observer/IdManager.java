package com.yd.android_brand_mvp.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class IdManager implements IdSubjectListener {
    private static IdManager idManager;
    private List<IdListener> list = new ArrayList();

    public static IdManager getInstance() {
        if (idManager == null) {
            synchronized (IdManager.class) {
                if (idManager == null) {
                    idManager = new IdManager();
                }
            }
        }
        return idManager;
    }

    @Override // com.yd.android_brand_mvp.observer.IdSubjectListener
    public void add(IdListener idListener) {
        this.list.add(idListener);
    }

    @Override // com.yd.android_brand_mvp.observer.IdSubjectListener
    public void notifyObserver(String str) {
        Iterator<IdListener> it2 = this.list.iterator();
        while (it2.hasNext()) {
            it2.next().observerUpData(str);
        }
    }

    @Override // com.yd.android_brand_mvp.observer.IdSubjectListener
    public void remove(IdListener idListener) {
        if (this.list.contains(idListener)) {
            this.list.remove(idListener);
        }
    }
}
