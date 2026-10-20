package com.yd.android_brand_mvp.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NetWorkManager implements NetWorkListener {
    private final List<NetWorkStaus> list = new ArrayList();

    /* JADX INFO: loaded from: classes4.dex */
    private static final class NetWorkManagerHolder {
        private static final NetWorkManager netWorkManager = new NetWorkManager();

        private NetWorkManagerHolder() {
        }
    }

    public static NetWorkManager getInstance() {
        return NetWorkManagerHolder.netWorkManager;
    }

    @Override // com.yd.android_brand_mvp.observer.NetWorkListener
    public void add(NetWorkStaus netWorkStaus) {
        this.list.add(netWorkStaus);
    }

    @Override // com.yd.android_brand_mvp.observer.NetWorkListener
    public void notifyObserver(boolean z) {
        Iterator<NetWorkStaus> it2 = this.list.iterator();
        while (it2.hasNext()) {
            it2.next().getWork(z);
        }
    }

    @Override // com.yd.android_brand_mvp.observer.NetWorkListener
    public void remove(NetWorkStaus netWorkStaus) {
        this.list.remove(netWorkStaus);
    }
}
