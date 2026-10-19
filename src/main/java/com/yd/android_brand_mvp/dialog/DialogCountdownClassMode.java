package com.yd.android_brand_mvp.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blankj.utilcode.util.SizeUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.yd.android_brand_mvp.activity.ClassModeActivity;
import com.yd.android_brand_mvp.databinding.DialogClassModeBinding;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yyide.facepass.AppExtKt;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogCountdownClassMode.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u001a\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0002J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/DialogCountdownClassMode;", "Landroidx/fragment/app/DialogFragment;", PushConstants.INTENT_ACTIVITY_NAME, "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "JSON", "", "binding", "Lcom/yd/android_brand_mvp/databinding/DialogClassModeBinding;", "countDownTimer", "com/yd/android_brand_mvp/dialog/DialogCountdownClassMode$countDownTimer$1", "Lcom/yd/android_brand_mvp/dialog/DialogCountdownClassMode$countDownTimer$1;", "mTable", "Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO$TimetableListDTO;", "time", "", "dismiss", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStart", "onViewCreated", "view", "setData", "showAllowingStateLoss", "manager", "Landroidx/fragment/app/FragmentManager;", RemoteMessageConst.Notification.TAG, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DialogCountdownClassMode extends DialogFragment {
    private final String JSON;
    private DialogClassModeBinding binding;
    private final DialogCountdownClassMode$countDownTimer$1 countDownTimer;
    private KBRsp2.DataDTO.TimetableListDTO mTable;
    private final long time;

    /* JADX WARN: Type inference failed for: r2v1, types: [com.yd.android_brand_mvp.dialog.DialogCountdownClassMode$countDownTimer$1] */
    public DialogCountdownClassMode(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        final long j = 120000;
        this.time = 120000L;
        this.JSON = "json";
        this.countDownTimer = new CountDownTimer(j) { // from class: com.yd.android_brand_mvp.dialog.DialogCountdownClassMode$countDownTimer$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                KBRsp2.DataDTO.TimetableListDTO timetableListDTO = this.this$0.mTable;
                if (timetableListDTO != null) {
                    ClassModeActivity.Companion.start$default(ClassModeActivity.INSTANCE, activity, timetableListDTO, null, 4, null);
                }
                this.this$0.dismiss();
                AppExtKt.loge(this, "millisUntilFinished : close");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                long j2 = millisUntilFinished / ((long) 1000);
                DialogClassModeBinding dialogClassModeBinding = this.this$0.binding;
                if (dialogClassModeBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogClassModeBinding = null;
                }
                TextView textView = dialogClassModeBinding.tvCountdown;
                StringBuilder sb = new StringBuilder();
                sb.append(j2);
                sb.append('s');
                textView.setText(sb.toString());
                AppExtKt.loge(this, "millisUntilFinished : " + millisUntilFinished);
            }
        };
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogClassModeBinding dialogClassModeBindingInflate = DialogClassModeBinding.inflate(getLayoutInflater(), container, false);
        Intrinsics.checkNotNullExpressionValue(dialogClassModeBindingInflate, "inflate(layoutInflater, container, false)");
        this.binding = dialogClassModeBindingInflate;
        if (dialogClassModeBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogClassModeBindingInflate = null;
        }
        ConstraintLayout root = dialogClassModeBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setData();
        start();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        Dialog dialog2 = getDialog();
        Window window = dialog2 != null ? dialog2.getWindow() : null;
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkNotNullExpressionValue(attributes, "it.attributes");
            Intrinsics.checkNotNullExpressionValue(window.getWindowManager().getDefaultDisplay(), "it.windowManager.defaultDisplay");
            attributes.width = SizeUtils.dp2px(500.0f);
            attributes.height = SizeUtils.dp2px(440.0f);
            window.setAttributes(attributes);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (getFragmentManager() == null) {
            AppExtKt.loge(this, "dismiss: " + this + " not associated with a fragment manager.");
            return;
        }
        super.dismiss();
    }

    private final void setData() {
        KBRsp2.DataDTO.TimetableListDTO timetableListDTO;
        List<KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO> teacherList;
        Bundle arguments = getArguments();
        if (arguments != null) {
            KBRsp2.DataDTO.TimetableListDTO timetableListDTO2 = (KBRsp2.DataDTO.TimetableListDTO) arguments.getSerializable(this.JSON);
            this.mTable = timetableListDTO2;
            String str = "";
            if ((timetableListDTO2 != null ? timetableListDTO2.teacherList : null) != null && (timetableListDTO = this.mTable) != null && (teacherList = timetableListDTO.teacherList) != null) {
                Intrinsics.checkNotNullExpressionValue(teacherList, "teacherList");
                Iterator<T> it2 = teacherList.iterator();
                String str2 = "";
                while (it2.hasNext()) {
                    str2 = ((KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO) it2.next()).name + "";
                }
                str = str2;
            }
            String str3 = str;
            if (!TextUtils.isEmpty(str3)) {
                Intrinsics.checkNotNullExpressionValue(str.substring(str.length() - 1, str.length()), "this as java.lang.String…ing(startIndex, endIndex)");
            }
            DialogClassModeBinding dialogClassModeBinding = this.binding;
            if (dialogClassModeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogClassModeBinding = null;
            }
            dialogClassModeBinding.tvTeacherName.setText(str3);
            DialogClassModeBinding dialogClassModeBinding2 = this.binding;
            if (dialogClassModeBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogClassModeBinding2 = null;
            }
            TextView textView = dialogClassModeBinding2.tvAttendClass;
            StringBuilder sb = new StringBuilder();
            sb.append("即将上课：");
            KBRsp2.DataDTO.TimetableListDTO timetableListDTO3 = this.mTable;
            sb.append(timetableListDTO3 != null ? timetableListDTO3.startTime : null);
            sb.append('-');
            KBRsp2.DataDTO.TimetableListDTO timetableListDTO4 = this.mTable;
            sb.append(timetableListDTO4 != null ? timetableListDTO4.endTime : null);
            textView.setText(sb.toString());
            DialogClassModeBinding dialogClassModeBinding3 = this.binding;
            if (dialogClassModeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogClassModeBinding3 = null;
            }
            TextView textView2 = dialogClassModeBinding3.tvSubject;
            KBRsp2.DataDTO.TimetableListDTO timetableListDTO5 = this.mTable;
            textView2.setText(timetableListDTO5 != null ? timetableListDTO5.subjectName : null);
        }
    }

    public final void showAllowingStateLoss(FragmentManager manager, String tag) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        try {
            Field declaredField = DialogFragment.class.getDeclaredField("mDismissed");
            Intrinsics.checkNotNullExpressionValue(declaredField, "DialogFragment::class.ja…claredField(\"mDismissed\")");
            declaredField.setAccessible(true);
            declaredField.set(this, false);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        try {
            Field declaredField2 = DialogFragment.class.getDeclaredField("mShownByMe");
            Intrinsics.checkNotNullExpressionValue(declaredField2, "DialogFragment::class.ja…claredField(\"mShownByMe\")");
            declaredField2.setAccessible(true);
            declaredField2.set(this, true);
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        }
        FragmentTransaction fragmentTransactionBeginTransaction = manager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "manager.beginTransaction()");
        fragmentTransactionBeginTransaction.add(this, tag);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        cancel();
    }
}
