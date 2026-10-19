package com.yd.android_brand_mvp.verfity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.ClassCardPermisson;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseTimerActivity;
import com.yd.android_brand_mvp.net.FragmentEventListener;
import com.yd.android_brand_mvp.observer.IdListener;
import com.yd.android_brand_mvp.observer.IdManager;
import com.yd.android_brand_mvp.utils.ClickUtils;
import com.yd.android_brand_mvp.verfity.fragment.AccountFragment;
import com.yd.android_brand_mvp.verfity.fragment.CardFragment5;
import com.yd.android_brand_mvp.verfity.fragment.FaceFragment5;
import com.yd.android_brand_mvp.verfity.fragment.ScanCodeLoginFragment;

/* JADX INFO: loaded from: classes4.dex */
public class VerificationExternalActivity extends BaseTimerActivity implements IdListener {
    private static String TITLE = "title";
    private static String URL = "url";

    @BindView(R.id.btn1)
    CheckedTextView btn1;

    @BindView(R.id.btn2)
    CheckedTextView btn2;

    @BindView(R.id.btn3)
    CheckedTextView btn3;

    @BindView(R.id.btn4)
    CheckedTextView btn4;

    @BindView(R.id.content)
    FrameLayout content;
    int index = -1;

    @BindView(R.id.layout4)
    LinearLayout layout4;

    @BindView(R.id.line1)
    TextView line1;

    @BindView(R.id.line2)
    TextView line2;

    @BindView(R.id.line3)
    TextView line3;

    @BindView(R.id.line4)
    TextView line4;
    FragmentEventListener listener;

    @BindView(R.id.tab1)
    LinearLayout tab1;

    @BindView(R.id.tab2)
    LinearLayout tab2;

    @BindView(R.id.tab3)
    LinearLayout tab3;
    int toDoType;

    public static void start(Context context, String str, String str2) {
        if (ClickUtils.isFastClick()) {
            Intent intent = new Intent(context, (Class<?>) VerificationExternalActivity.class);
            intent.putExtra(URL, str);
            intent.putExtra(TITLE, str2);
            context.startActivity(intent);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseTimerActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_student_login);
        ButterKnife.bind(this);
        this.toDoType = getIntent().getIntExtra(BaseConstant.DOSHOMTHING, -1);
        if (!BaseApplication.isNetworkAvailable(this)) {
            this.layout4.setVisibility(0);
        } else {
            this.layout4.setVisibility(8);
        }
        this.tab1.setVisibility(ClassCardPermisson.getInstance().Cheack("刷卡验证") ? 0 : 8);
        this.tab2.setVisibility(ClassCardPermisson.getInstance().Cheack("人脸验证") ? 0 : 8);
        this.tab3.setVisibility(ClassCardPermisson.getInstance().Cheack("扫码验证") ? 0 : 8);
        if (ClassCardPermisson.getInstance().Cheack("刷卡验证")) {
            setTab(0);
        } else if (ClassCardPermisson.getInstance().Cheack("人脸验证")) {
            setTab(1);
        } else if (ClassCardPermisson.getInstance().Cheack("扫码验证")) {
            setTab(2);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseTimerActivity
    public void setKeyeventListener(FragmentEventListener fragmentEventListener) {
        this.listener = fragmentEventListener;
    }

    @Override // com.yd.android_brand_mvp.base.BaseTimerActivity, androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        FragmentEventListener fragmentEventListener = this.listener;
        if (fragmentEventListener != null && this.index == 0) {
            fragmentEventListener.OnFragmentEvent(keyEvent);
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.yd.android_brand_mvp.base.BaseTimerActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        IdManager.getInstance().add(this);
        setAcountDown(60);
    }

    @Override // com.yd.android_brand_mvp.base.BaseTimerActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        IdManager.getInstance().remove(this);
    }

    void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }

    void setTab(int i) {
        getWindow().setDimAmount(i == 1 ? 0.0f : 0.3f);
        setIndex(i);
        this.btn1.setChecked(false);
        this.btn2.setChecked(false);
        this.btn3.setChecked(false);
        this.btn4.setChecked(false);
        this.line1.setVisibility(8);
        this.line2.setVisibility(8);
        this.line3.setVisibility(8);
        this.line4.setVisibility(8);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(String.valueOf(this.btn1.getId()));
        Fragment fragmentFindFragmentByTag2 = supportFragmentManager.findFragmentByTag(String.valueOf(this.btn2.getId()));
        Fragment fragmentFindFragmentByTag3 = supportFragmentManager.findFragmentByTag(String.valueOf(this.btn3.getId()));
        Fragment fragmentFindFragmentByTag4 = supportFragmentManager.findFragmentByTag(String.valueOf(this.btn4.getId()));
        if (fragmentFindFragmentByTag != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag);
        }
        if (fragmentFindFragmentByTag2 != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag2);
        }
        if (fragmentFindFragmentByTag3 != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag3);
        }
        if (fragmentFindFragmentByTag4 != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag4);
        }
        ButterKnife.bind(this.mActivity);
        if (i == 0) {
            if (fragmentFindFragmentByTag == null) {
                CardFragment5 cardFragment5 = new CardFragment5();
                Bundle bundle = new Bundle();
                bundle.putString("url", getIntent().getStringExtra(URL));
                bundle.putString("title", getIntent().getStringExtra(TITLE));
                cardFragment5.setArguments(bundle);
                fragmentTransactionBeginTransaction.add(R.id.content, cardFragment5, String.valueOf(this.btn1.getId()));
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag);
            }
            this.btn1.setChecked(true);
            this.line1.setVisibility(0);
        } else if (i == 1) {
            if (fragmentFindFragmentByTag2 == null) {
                FaceFragment5 faceFragment5 = new FaceFragment5();
                Bundle bundle2 = new Bundle();
                bundle2.putString("url", getIntent().getStringExtra(URL));
                bundle2.putString("title", getIntent().getStringExtra(TITLE));
                faceFragment5.setArguments(bundle2);
                fragmentTransactionBeginTransaction.add(R.id.content, faceFragment5, String.valueOf(this.btn2.getId()));
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
        } else if (i == 3) {
            if (fragmentFindFragmentByTag4 == null) {
                fragmentTransactionBeginTransaction.add(R.id.content, new AccountFragment(), String.valueOf(this.btn4.getId()));
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag4);
            }
            this.btn4.setChecked(true);
            this.line4.setVisibility(0);
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4})
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
            case R.id.btn4 /* 2131362032 */:
                setTab(3);
                break;
        }
    }
}
