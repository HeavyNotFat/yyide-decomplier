package com.yd.android_brand_mvp.verfity;

import android.app.Activity;
import android.content.Intent;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.SettingActivity;
import com.yd.android_brand_mvp.model.selectTeacherByClassesIdRsp;
import com.yd.android_brand_mvp.portrait.activity.SettingPActivity;
import com.yd.android_brand_mvp.user.UserCenterActivity;
import com.yd.android_brand_mvp.utils.SettingPermision;
import com.yd.android_brand_mvp.utils.SpData;
import org.json.JSONObject;

/**
 * 还原版刷卡 / 离线验证快捷入口。
 *
 * 规则：
 *  - 卡号全是 8（如 8888888888）或离线验证码 1145 -> 教师端设置页
 *  - 卡号 1234567890 或离线验证码 1024          -> 学生空间
 *
 * 这两个入口不再请求服务端，也不依赖真实卡号/权限数据，直接在本地构造
 * 一个可用的教师/学生身份后跳转。
 */
public final class RestoreVerificationRouter {

    public static final String STUDENT_CARD = "1234567890";
    public static final String TEACHER_OFFLINE_CODE = "1145";
    public static final String STUDENT_OFFLINE_CODE = "1024";

    private RestoreVerificationRouter() {
    }

    /** 卡号是否全部由字符 8 组成（长度不限，常见为 10 位）。 */
    public static boolean isAllEights(String cardNo) {
        if (cardNo == null) {
            return false;
        }
        String value = cardNo.trim();
        if (value.length() == 0) {
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) != '8') {
                return false;
            }
        }
        return true;
    }

    public static boolean isSpecialCard(String cardNo) {
        return isAllEights(cardNo) || STUDENT_CARD.equals(cardNo);
    }

    /**
     * 处理特殊卡号。
     *
     * @return true 表示已消费该卡号并完成跳转，调用方不要再请求服务端。
     */
    public static boolean handleCard(Activity activity, String cardNo) {
        if (activity == null || cardNo == null) {
            return false;
        }
        String value = cardNo.trim();
        if (isAllEights(value)) {
            openTeacher(activity, value);
            return true;
        }
        if (STUDENT_CARD.equals(value)) {
            openStudent(activity, value);
            return true;
        }
        return false;
    }

    /**
     * 处理离线验证码。
     *
     * @return true 表示已消费该验证码并完成跳转，调用方不要再校验随机码。
     */
    public static boolean handleOfflineCode(Activity activity, String code) {
        if (activity == null || code == null) {
            return false;
        }
        String value = code.trim();
        if (TEACHER_OFFLINE_CODE.equals(value)) {
            openTeacher(activity, value);
            return true;
        }
        if (STUDENT_OFFLINE_CODE.equals(value)) {
            openStudent(activity, value);
            return true;
        }
        return false;
    }

    /** 打开教师端设置页（横屏 SettingActivity / 竖屏 SettingPActivity）。 */
    public static void openTeacher(Activity activity, String identity) {
        selectTeacherByClassesIdRsp.DataDTO teacher = new selectTeacherByClassesIdRsp.DataDTO();
        teacher.id = "restore-teacher-001";
        teacher.userId = teacher.id;
        teacher.userName = "测试教师";
        teacher.name = "测试教师";
        teacher.cardNumber = identity;
        teacher.cardNo = identity;
        teacher.icCardNo = identity;
        teacher.schoolId = SpData.getSchoolId();
        teacher.position = "教师";
        SettingPermision.getInstance().mDataDTO = teacher;

        Intent intent;
        if (ScreenUtils.isLandscape()) {
            intent = new Intent(activity, SettingActivity.class);
        } else {
            intent = new Intent(activity, SettingPActivity.class);
        }
        intent.putExtra("type", "restore");
        activity.startActivity(intent);
        activity.finish();
    }

    /** 打开学生空间，并写入一个本地学生身份，避免依赖服务端查卡接口。 */
    public static void openStudent(Activity activity, String identity) {
        try {
            JSONObject root = new JSONObject();
            root.put("code", 0);
            root.put("success", true);
            root.put("error", false);
            root.put("message", "操作成功");

            JSONObject data = new JSONObject();
            data.put("id", "restore-student-001");
            data.put("userId", "restore-student-001");
            data.put("name", "测试学生");
            data.put("userName", "测试学生");
            data.put("identityId", "restore-student-001");
            data.put("isStudent", true);
            data.put("icCardNo", identity);
            data.put("schoolId", SpData.getSchoolId());
            data.put("classesId", SpData.getClassesId());
            data.put("className", SpData.getClassesName());
            data.put("teacherName", "班主任");
            data.put("avatar", "");
            root.put("data", data);

            SPUtils.getInstance().put(SpData.USERCENT2, root.toString());
        } catch (Exception ignored) {
            // JSONObject 在当前字段上不会失败；即使失败也继续打开学生空间。
        }
        activity.startActivity(new Intent(activity, UserCenterActivity.class));
        activity.finish();
    }
}
