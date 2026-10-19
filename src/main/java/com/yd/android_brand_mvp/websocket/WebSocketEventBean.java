package com.yd.android_brand_mvp.websocket;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;

/* JADX INFO: loaded from: classes4.dex */
public class WebSocketEventBean {
    public static final String CODE_ADMIN_UPDATE = "1109";
    public static final String CODE_APP_UPDATE = "1212";
    public static final String CODE_CAMPUSSTYLE_CHANGE = "1307";
    public static final String CODE_CARD_NUMBER_UPDATE = "1110";
    public static final String CODE_CLASSESWATCHWORD_CHANGE = "1311";
    public static final String CODE_COUNTDOWN_CHANGE = "1308";
    public static final String CODE_DEL_PEOPLE = "1111";
    public static final String CODE_DOMINATESCREEN_CHANGE = "1313";
    public static final String CODE_DOMINATE_LEVEL = "1701";
    public static final String CODE_FACE_ADD = "1207";
    public static final String CODE_FACE_ALL = "1206";
    public static final String CODE_FACE_COMPLETE = "1213";
    public static final String CODE_FACE_DEL = "1209";
    public static final String CODE_FACE_EDIT = "1208";
    public static final String CODE_FACE_SNAP = "1211";
    public static final String CODE_OPENCLOSETIME_CHANGE = "1312";
    public static final String CODE_REMIND_CHANGE = "1309";
    public static final String CODE_RESET_DISABLE = "1108";
    public static final String CODE_RESET_ENABLE = "1107";
    public static final String CODE_RESET_PED = "1106";
    public static final String CODE_RESTART = "1301";
    public static final String CODE_SCHOOL_CALENDAR = "1315";
    public static final String CODE_SOCKET_HEARTBEAT = "1003";
    public static final String CODE_STUDENTWORKS_CHANGE = "1310";
    public static final String CODE_SYNC_STATUS = "1004";
    public static final String CODE_TASK_HONOR_WALL = "1326";
    public static final String CODE_TASK_SIGN_HOME = "1400";
    public static final String CODE_TURN_OFF = "1300";
    public static final String CODE_UPDATE_ADD_RULE = "1103";
    public static final String CODE_UPDATE_ALL_RULE = "1102";
    public static final String CODE_UPDATE_DEL_RULE = "1105";
    public static final String CODE_UPDATE_EDIT_RULE = "1104";
    public static final String CODE_VIDEOALBUM_CHANGE = "1306";
    public static final String DEVICE_TYPE = "brand";

    @SerializedName("data")
    private String data;

    @SerializedName("type")
    private String type;

    public boolean getCurrentDevice() {
        return "brand".equals(getType());
    }

    public static class EventBean {
        private String eventCode;
        private String params;

        public String getParams() {
            return this.params;
        }

        public void setParams(String str) {
            this.params = str;
        }

        public String getEventCode() {
            return this.eventCode;
        }

        public void setEventCode(String str) {
            this.eventCode = str;
        }

        public static class EventChildBean {
            private String param;

            public String getParam() {
                return this.param;
            }

            public void setParam(String str) {
                this.param = str;
            }
        }
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public EventBean getData() {
        if (TextUtils.isEmpty(this.data)) {
            return null;
        }
        try {
            return (EventBean) GsonUtils.fromJson(this.data, EventBean.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setData(String str) {
        this.data = str;
    }
}
