package com.yd.android_brand_mvp.model;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class KBRsp {
    public int code;
    public DataDTO data;
    public String msg;
    public boolean success;

    public static class DataDTO {
        public int bzzc;
        public String cdmc;
        public jc jcbMap;
        public List<ListDTO> list;
        public WeekTimeBean weekmap;
        public ZxbDTO zxb;

        public static class ListDTO {
            public int bbh;
            public String bjid;
            public String bjmc;
            public Object cdid;
            public Object cdmc;
            public Object cjr;
            public Object cjsj;
            public int current;
            public Object gxr;
            public Object gxsj;
            public String id;
            public String jcbid;
            public int jcdm;
            public String jcmc;
            public String jcsd;
            public String jcsdbs;
            public String jssj;
            public String jzgid;
            public String jzgmc;
            public String kcid;
            public String kcmc;
            public String kssj;
            public int scbs;
            public int size;
            public int skxq;
            public String skzc;
            public int total;
            public int xh;
            public String xnxq;
            public String xnxqid;
            public String xsid;
            public String zxbid;
        }

        public static class ZxbDTO {
            public int bbh;
            public String cjr;
            public String cjsj;
            public int current;
            public Object gxr;
            public Object gxsj;
            public String id;
            public Object jcbList;
            public int scbs;
            public int size;
            public String swkjs;
            public int total;
            public String wskjs;
            public String wzxkjs;
            public String xnjsrq;
            public String xnksrq;
            public String xnxq;
            public String xnxqid;
            public int xnzzc;
            public String xsid;
            public String xwkjs;
            public String zxbmc;
            public String zzxkjs;
        }

        public static class jc {
            public List<JcDTO> sw;
            public List<JcDTO> ws;
            public List<JcDTO> wzx;
            public List<JcDTO> xw;
            public List<JcDTO> zzx;

            public static class JcDTO {
                public String jcmc;
                public String jcsd;
                public String jssj;
                public String kssj;
                public String xxid;
            }
        }

        public static class WeekTimeBean {
            public String FRIDAY;
            public String MONDAY;
            public String SATURDAY;
            public String SUNDAY;
            public String THURSDAY;
            public String TUESDAY;
            public String WEDNESDAY;

            public static class WeekBean {
                public String time;
                public String week;
            }

            public List<WeekBean> getList() {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < 7; i++) {
                    WeekBean weekBean = new WeekBean();
                    switch (i) {
                        case 0:
                            weekBean.week = "星期一";
                            weekBean.time = this.MONDAY;
                            break;
                        case 1:
                            weekBean.week = "星期二";
                            weekBean.time = this.TUESDAY;
                            break;
                        case 2:
                            weekBean.week = "星期三";
                            weekBean.time = this.WEDNESDAY;
                            break;
                        case 3:
                            weekBean.week = "星期四";
                            weekBean.time = this.THURSDAY;
                            break;
                        case 4:
                            weekBean.week = "星期五";
                            weekBean.time = this.FRIDAY;
                            break;
                        case 5:
                            weekBean.week = "星期六";
                            weekBean.time = this.SATURDAY;
                            break;
                        case 6:
                            weekBean.week = "星期日";
                            weekBean.time = this.SUNDAY;
                            break;
                    }
                    arrayList.add(weekBean);
                }
                return arrayList;
            }
        }
    }
}
