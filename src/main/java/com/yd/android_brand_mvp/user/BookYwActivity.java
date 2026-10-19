package com.yd.android_brand_mvp.user;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.landscape.BookYwFragmentL;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwActivity extends BaseLayoutActivity {
    public static String idnex = "idnex";
    public int poistion;

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        String stringExtra = getIntent().getStringExtra("idnex");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.poistion = Integer.parseInt(stringExtra);
        }
        BookYwFragmentL bookYwFragmentL = new BookYwFragmentL();
        Bundle bundle = new Bundle();
        bundle.putInt(idnex, this.poistion);
        bookYwFragmentL.setArguments(bundle);
        return bookYwFragmentL;
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public String getName() {
        return getString(R.string.st_book_info);
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
