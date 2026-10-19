package com.yd.android_brand_mvp.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.GankDialogHonerWallBinding;
import com.yd.android_brand_mvp.model.honor.HonorWallItem;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TransUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: HonorDetailDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\u001a\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/HonorDetailDialog;", "Landroidx/fragment/app/DialogFragment;", "data", "Lcom/yd/android_brand_mvp/model/honor/HonorWallItem;", "(Lcom/yd/android_brand_mvp/model/honor/HonorWallItem;)V", "binding", "Lcom/yd/android_brand_mvp/databinding/GankDialogHonerWallBinding;", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/GankDialogHonerWallBinding;", "setBinding", "(Lcom/yd/android_brand_mvp/databinding/GankDialogHonerWallBinding;)V", "initView", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorDetailDialog extends DialogFragment {
    public GankDialogHonerWallBinding binding;
    private HonorWallItem data;

    public final GankDialogHonerWallBinding getBinding() {
        GankDialogHonerWallBinding gankDialogHonerWallBinding = this.binding;
        if (gankDialogHonerWallBinding != null) {
            return gankDialogHonerWallBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(GankDialogHonerWallBinding gankDialogHonerWallBinding) {
        Intrinsics.checkNotNullParameter(gankDialogHonerWallBinding, "<set-?>");
        this.binding = gankDialogHonerWallBinding;
    }

    public HonorDetailDialog(HonorWallItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        GankDialogHonerWallBinding gankDialogHonerWallBindingInflate = GankDialogHonerWallBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(gankDialogHonerWallBindingInflate, "inflate(inflater, container, false)");
        setBinding(gankDialogHonerWallBindingInflate);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        int i;
        if (this.data.getWinnerNames().length() == 0) {
            TextView textView = getBinding().tvDialogHonerWallStudent;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvDialogHonerWallStudent");
            SimpleUtilsKt.hide(textView);
        }
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SimpleUtilsKt.asColor(R.color.black9));
        int honorType = this.data.getHonorType();
        if (honorType != 2) {
            i = honorType != 3 ? R.string.honer_wall_getClass : R.string.honer_wall_getTeacher;
        } else {
            i = R.string.honer_wall_getStudent;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(strContentId)");
        String str = String.format(string, Arrays.copyOf(new Object[]{this.data.getWinnerNames()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(foregroundColorSpan, 5, spannableString.length(), 17);
        getBinding().tvDialogHonerWallStudent.setText(spannableString);
        getBinding().tvDialogHonerWallType.setText(TransUtils.INSTANCE.transHonorLevelToStr(this.data.getLevel()));
        getBinding().tvDialogHonerWallTitle.setText(this.data.getName());
        Glide.with(requireContext()).load(this.data.getImgPaths()).into(getBinding().ivDialogHonerWallTemplate);
        getBinding().tvDialogHonerWallTime.setText(this.data.getCreateTime());
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
            attributes.width = SizeUtils.dp2px(782.0f);
            attributes.height = SizeUtils.dp2px(657.0f);
            window.setAttributes(attributes);
        }
    }
}
