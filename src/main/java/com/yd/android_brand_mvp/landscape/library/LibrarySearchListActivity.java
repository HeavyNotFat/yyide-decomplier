package com.yd.android_brand_mvp.landscape.library;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.reflect.TypeToken;
import com.tencent.mmkv.MMKV;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.dialog.SelectPopUp;
import com.yd.android_brand_mvp.landscape.library.fragment.LibraryHomeFragment;
import com.yd.android_brand_mvp.model.SelectPopBean;
import com.yd.android_brand_mvp.model.library.LibraryBean;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LibrarySearchListActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/library/LibrarySearchListActivity;", "Lcom/yd/android_brand_mvp/base/BaseLayoutActivity;", "()V", "dataSelectList", "", "Lcom/yd/android_brand_mvp/model/SelectPopBean;", "mLibraryHomeFragment", "Lcom/yd/android_brand_mvp/landscape/library/fragment/LibraryHomeFragment;", "selectInfo", "studentPopUp", "Lcom/yd/android_brand_mvp/dialog/SelectPopUp;", "getFragment", "Landroidx/fragment/app/Fragment;", "getName", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LibrarySearchListActivity extends BaseLayoutActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private LibraryHomeFragment mLibraryHomeFragment;
    private SelectPopUp studentPopUp;
    private SelectPopBean selectInfo = new SelectPopBean("", "");
    private final List<SelectPopBean> dataSelectList = new ArrayList();

    /* JADX INFO: compiled from: LibrarySearchListActivity.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/library/LibrarySearchListActivity$Companion;", "", "()V", "startGo", "", "context", "Landroid/content/Context;", FirebaseAnalytics.Param.INDEX, "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startGo(Context context, int index) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) LibrarySearchListActivity.class);
            intent.putExtra(FirebaseAnalytics.Param.INDEX, index);
            context.startActivity(intent);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        LibraryHomeFragment libraryHomeFragmentNewInstance = LibraryHomeFragment.INSTANCE.newInstance(getIntent().getIntExtra(FirebaseAnalytics.Param.INDEX, -1));
        this.mLibraryHomeFragment = libraryHomeFragmentNewInstance;
        Intrinsics.checkNotNull(libraryHomeFragmentNewInstance);
        return libraryHomeFragmentNewInstance;
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        String string = getString(R.string.library_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.library_title)");
        return string;
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String strDecodeString = MMKV.defaultMMKV().decodeString(MMKVConstant.LIBRARY_LIST_KEY);
        LibraryBean libraryBean = (LibraryBean) MMKV.defaultMMKV().decodeParcelable(MMKVConstant.LIBRARY_KEY, LibraryBean.class);
        List<LibraryBean> list = (List) GsonUtils.fromJson(strDecodeString, new TypeToken<List<? extends LibraryBean>>() { // from class: com.yd.android_brand_mvp.landscape.library.LibrarySearchListActivity$onCreate$libraryList$1
        }.getType());
        if (list != null) {
            for (LibraryBean libraryBean2 : list) {
                this.dataSelectList.add(new SelectPopBean(libraryBean2.getId(), libraryBean2.getName()));
            }
        }
        if (libraryBean != null) {
            this.selectInfo = new SelectPopBean(libraryBean.getId(), libraryBean.getName());
            setRightTextView(libraryBean.getName());
        }
        if (this.dataSelectList.size() > 1) {
            getRightTextView().setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.icon_library_down, 0);
            getRightTextView().setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.-$$Lambda$LibrarySearchListActivity$Bs3NGLJ3EapapiBSSyfbfEYM_28
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LibrarySearchListActivity.onCreate$lambda$2(this.f$0, view);
                }
            });
        }
        SelectPopUp selectPopUp = new SelectPopUp(this);
        this.studentPopUp = selectPopUp;
        if (selectPopUp != null) {
            selectPopUp.setPopupGravity(80);
        }
        SelectPopUp selectPopUp2 = this.studentPopUp;
        if (selectPopUp2 != null) {
            selectPopUp2.setData(this.dataSelectList, this.selectInfo);
        }
        SelectPopUp selectPopUp3 = this.studentPopUp;
        if (selectPopUp3 != null) {
            selectPopUp3.setSubmitCallBack(new SelectPopUp.SubmitCallBack() { // from class: com.yd.android_brand_mvp.landscape.library.LibrarySearchListActivity.onCreate.4
                @Override // com.yd.android_brand_mvp.dialog.SelectPopUp.SubmitCallBack
                public void getSubmitData(SelectPopBean data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    LibrarySearchListActivity.this.getRightTextView().setText(data.getName());
                    LibraryHomeFragment libraryHomeFragment = LibrarySearchListActivity.this.mLibraryHomeFragment;
                    if (libraryHomeFragment != null) {
                        libraryHomeFragment.clearFragment();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(LibrarySearchListActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SelectPopUp selectPopUp = this$0.studentPopUp;
        Intrinsics.checkNotNull(selectPopUp);
        if (selectPopUp.isShowing()) {
            SelectPopUp selectPopUp2 = this$0.studentPopUp;
            Intrinsics.checkNotNull(selectPopUp2);
            selectPopUp2.dismiss();
        } else {
            SelectPopUp selectPopUp3 = this$0.studentPopUp;
            Intrinsics.checkNotNull(selectPopUp3);
            selectPopUp3.showPopupWindow(this$0.getRightTextView());
        }
    }
}
