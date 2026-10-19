package com.yd.android_brand_mvp.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class UnreadMsgNum {
    public List<C2CUnreadMsgNumList> C2CUnreadMsgNumList;
    public String actionStatus;
    public int allC2CUnreadMsgNum;
    public int errorCode;
    public String errorInfo;

    public class C2CUnreadMsgNumList {

        @JSONField(name = "C2CUnreadMsgNum")
        private int c2CUnreadMsgNum;

        @JSONField(name = "Peer_Account")
        private String peer_Account;

        public C2CUnreadMsgNumList() {
        }

        public String getPeer_Account() {
            return this.peer_Account;
        }

        public void setPeer_Account(String str) {
            this.peer_Account = str;
        }

        public int getC2CUnreadMsgNum() {
            return this.c2CUnreadMsgNum;
        }

        public void setC2CUnreadMsgNum(int i) {
            this.c2CUnreadMsgNum = i;
        }
    }
}
