package com.yd.android_brand_mvp;

import android.util.Log;
import com.ttlock.bl.sdk.util.GsonUtil;
import com.yd.android_brand_mvp.model.AllstudentRsp;
import com.yd.android_brand_mvp.model.StudentMsgBean;
import com.yd.android_brand_mvp.utils.SpData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ClassStudentMsg {
    private final List<StudentMsgBean.Data0> data = new ArrayList();
    public List<StudentMsgBean.Data0> list = new ArrayList();
    private final List<StudentMsgBean.Data0> newlist = new ArrayList();

    private static final class RuleHolder {
        static final ClassStudentMsg rule = new ClassStudentMsg();

        private RuleHolder() {
        }
    }

    public static ClassStudentMsg getInstance() {
        return RuleHolder.rule;
    }

    public synchronized List<StudentMsgBean.Data0> getStudentMsg(StudentMsgBean studentMsgBean) {
        AllstudentRsp allStudents = SpData.getAllStudents();
        if (this.data.size() == 0 && studentMsgBean != null && studentMsgBean.data.size() > 0 && allStudents != null) {
            Log.i("ClassStudentMsg", "getStudentMsg: " + GsonUtil.toJson(studentMsgBean));
            this.list.clear();
            this.newlist.clear();
            this.data.addAll(studentMsgBean.data);
            for (StudentMsgBean.Data0 data0 : studentMsgBean.data) {
                for (AllstudentRsp.DataDTO dataDTO : allStudents.data) {
                    if (data0 != null && data0.id == dataDTO.id) {
                        data0.name = dataDTO.name;
                        data0.image = dataDTO.avatar;
                        this.newlist.add(data0);
                    }
                }
            }
            this.list.addAll(this.newlist);
            this.data.clear();
        }
        return this.list;
    }
}
