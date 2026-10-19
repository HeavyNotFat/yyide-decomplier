package com.yd.android_brand_mvp.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NewBrandLoginRsp {
    public String message = "";
    public int code = -1;
    public DataBean data = new DataBean();

    public static class DataBean {
        public String cityCode;
        public String brandName = "";
        public String classesId = "";
        public String direction = "";
        public String id = "";
        public Boolean isMessage = false;
        public boolean isSecond = false;
        public String plaintextPassword = "";
        public String schoolId = "";
        public String badgeUrl = "";
        public String siteId = "";
        public String siteName = "";
        public String loginName = "";
        public List<VerifyBean> verify = new ArrayList();
        public String schoolType = "1";

        public static class VerifyBean {
            public String id = "";
            public String name = "";
        }

        public String getClassesId() {
            return TextUtils.isEmpty(this.classesId) ? "" : this.classesId;
        }
    }
}
