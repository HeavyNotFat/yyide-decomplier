package com.yd.android_brand_mvp.verfity;

import kotlin.Metadata;

/* JADX INFO: compiled from: CheckEnum.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/verfity/CheckEnum;", "", "todoType", "", "(Ljava/lang/String;II)V", "getTodoType", "()I", "UserCenterCheck", "AttendanceCheck", "TeacherCheck", "TeacherAndStudentCheck", "BookCheck", "ProductionCheck", "THIRD_PARTY", "ACTIVE_REGISTRATION", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum CheckEnum {
    UserCenterCheck(1),
    AttendanceCheck(2),
    TeacherCheck(3),
    TeacherAndStudentCheck(4),
    BookCheck(5),
    ProductionCheck(6),
    THIRD_PARTY(7),
    ACTIVE_REGISTRATION(8);

    private final int todoType;

    CheckEnum(int i) {
        this.todoType = i;
    }

    public final int getTodoType() {
        return this.todoType;
    }
}
