package com.yd.android_brand_mvp.adapter.attence;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.yd.android_brand_mvp.ClassCardPermisson;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseActivity;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.observer.IdListener;
import com.yd.android_brand_mvp.observer.IdManager;
import com.yd.android_brand_mvp.observer.MinaListener;
import com.yd.android_brand_mvp.verfity.fragment.FaceFragment2;
import com.yd.android_brand_mvp.verfity.fragment.ScanCodeLoginFragment;
import com.yyide.facepass.FaceManager;

/* JADX INFO: loaded from: classes4.dex */
public class CheckAttendanceActivity extends BaseActivity implements IdListener, MinaListener {

    @BindView(R.id.btn1)
    CheckedTextView btn1;

    @BindView(R.id.btn2)
    CheckedTextView btn2;

    @BindView(R.id.btn3)
    CheckedTextView btn3;

    @BindView(R.id.content)
    FrameLayout content;

    @BindView(R.id.line1)
    TextView line1;

    @BindView(R.id.line2)
    TextView line2;

    @BindView(R.id.line3)
    TextView line3;

    @BindView(R.id.tab1)
    LinearLayout tab1;

    @BindView(R.id.tab2)
    LinearLayout tab2;

    @BindView(R.id.tab3)
    LinearLayout tab3;
    int toDoType;
    int type = 0;
    private String TAG = CheckAttendanceActivity.class.getSimpleName();

    void doSomeThing(String str) {
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.isTheme = false;
        super.onCreate(bundle);
        setContentView(R.layout.activity_student_login);
        ButterKnife.bind(this);
        this.toDoType = getIntent().getIntExtra(BaseConstant.DOSHOMTHING, -1);
        this.type = getIntent().getIntExtra("type", 0);
        this.tab1.setVisibility(ClassCardPermisson.getInstance().Cheack("刷卡验证") ? 0 : 8);
        this.tab2.setVisibility(ClassCardPermisson.getInstance().Cheack("人脸验证") ? 0 : 8);
        this.tab3.setVisibility(ClassCardPermisson.getInstance().Cheack("扫码验证") ? 0 : 8);
        if (ClassCardPermisson.getInstance().Cheack("刷卡验证")) {
            setTab(0);
        } else if (ClassCardPermisson.getInstance().Cheack("人脸验证")) {
            setTab(1);
        }
        setNoShowTime();
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        IdManager.getInstance().add(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        IdManager.getInstance().remove(this);
    }

    void setTab(int i) {
        getWindow().setDimAmount(i == 1 ? 0.0f : 0.3f);
        this.btn1.setChecked(false);
        this.btn2.setChecked(false);
        this.btn3.setChecked(false);
        this.line1.setVisibility(8);
        this.line2.setVisibility(8);
        this.line3.setVisibility(8);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(String.valueOf(this.btn1.getId()));
        Fragment fragmentFindFragmentByTag2 = supportFragmentManager.findFragmentByTag(String.valueOf(this.btn2.getId()));
        Fragment fragmentFindFragmentByTag3 = supportFragmentManager.findFragmentByTag(String.valueOf(this.btn3.getId()));
        if (fragmentFindFragmentByTag != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag);
        }
        if (fragmentFindFragmentByTag2 != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag2);
        }
        if (fragmentFindFragmentByTag3 != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag3);
        }
        if (i != 0 && fragmentFindFragmentByTag != null && fragmentFindFragmentByTag.isAdded()) {
            fragmentTransactionBeginTransaction.remove(fragmentFindFragmentByTag);
            ((CardFragment2) fragmentFindFragmentByTag).releaseCamera();
        }
        if (i != 1 && fragmentFindFragmentByTag2 != null && fragmentFindFragmentByTag2.isAdded()) {
            fragmentTransactionBeginTransaction.remove(fragmentFindFragmentByTag2);
            FaceManager.INSTANCE.onDestroyCamera();
        }
        if (i == 0) {
            if (fragmentFindFragmentByTag == null) {
                CardFragment2 cardFragment2 = new CardFragment2();
                Bundle bundle = new Bundle();
                bundle.putBoolean("type", true);
                cardFragment2.setArguments(bundle);
                fragmentTransactionBeginTransaction.add(R.id.content, cardFragment2, String.valueOf(this.btn1.getId()));
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag);
            }
            this.btn1.setChecked(true);
            this.line1.setVisibility(0);
        } else if (i == 1) {
            if (fragmentFindFragmentByTag2 == null) {
                fragmentTransactionBeginTransaction.add(R.id.content, new FaceFragment2(), String.valueOf(this.btn2.getId()));
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag2);
            }
            this.btn2.setChecked(true);
            this.line2.setVisibility(0);
        } else if (i == 2) {
            if (fragmentFindFragmentByTag3 == null) {
                fragmentTransactionBeginTransaction.add(R.id.content, ScanCodeLoginFragment.INSTANCE.newInstance(""), String.valueOf(this.btn3.getId()));
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag3);
            }
            this.btn3.setChecked(true);
            this.line3.setVisibility(0);
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, com.yd.android_brand_mvp.observer.ObserverListener
    public void observerUpData(String str) {
        doSomeThing(str);
    }

    @Override // com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        if (i == MinaConstants.CODE_UPDATA_ATTENCE_LIST) {
            Log.e(this.TAG, "UpdataEvent");
            setAcountDown(40);
        }
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1 /* 2131362029 */:
                setTab(0);
                break;
            case R.id.btn2 /* 2131362030 */:
                setTab(1);
                break;
            case R.id.btn3 /* 2131362031 */:
                setTab(2);
                break;
        }
    }
}
