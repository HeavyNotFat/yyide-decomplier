package com.yd.android_brand_mvp.portrait.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.SchoolInfoActivity;
import com.yd.android_brand_mvp.adapter.SchoolAdapter;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.SchoolInfoBean;
import com.yd.android_brand_mvp.model.SchoolStytleRsp;
import com.yd.android_brand_mvp.presenter.SchoolPresenter;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.StringUtils;
import com.yd.android_brand_mvp.view.SchoolSytleView;
import com.yd.android_brand_mvp.widget.YDWebView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class SchoolInfoFragment1P extends BaseMvpFragment<SchoolPresenter> implements SchoolSytleView {
    SchoolInfoActivity activity;
    SchoolAdapter adapter;

    @BindView(R.id.grid)
    GridView grid;

    @BindView(R.id.img)
    ImageView img;

    @BindView(R.id.school_name)
    TextView school_name;

    @BindView(R.id.tv_sname)
    TextView tv_sname;

    @BindView(R.id.tv_time)
    TextView tv_time;

    @BindView(R.id.webview)
    YDWebView webview;

    static /* synthetic */ boolean lambda$SchoolSytlSuccess$0(View view) {
        return true;
    }

    @Override // com.yd.android_brand_mvp.view.SchoolSytleView
    public void SchoolSytlFail(String str) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_school_info1_p, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.activity = (SchoolInfoActivity) this.mActivity;
        SchoolAdapter schoolAdapter = new SchoolAdapter();
        this.adapter = schoolAdapter;
        this.grid.setAdapter((ListAdapter) schoolAdapter);
        ((SchoolPresenter) this.mvpPresenter).SchoolStyle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public SchoolPresenter createPresenter() {
        return new SchoolPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.view.SchoolSytleView
    public void SchoolSytlSuccess(SchoolStytleRsp schoolStytleRsp) {
        if (schoolStytleRsp.code.intValue() == 0) {
            Log.i("TAG", "SchoolSytlSuccess: " + JSON.toJSONString(schoolStytleRsp));
            setBean(schoolStytleRsp);
            GlideUtil.loadCircleHeadImage(this.mActivity, schoolStytleRsp.data.schoolLogo, this.img);
            this.school_name.setText(schoolStytleRsp.data.schoolName);
            this.tv_time.setText(schoolStytleRsp.data.foundTime);
            this.tv_sname.setText(schoolStytleRsp.data.schoolName);
            this.webview.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.-$$Lambda$SchoolInfoFragment1P$MTnnmMhO5GFvAnw3hB3IsGPeYnw
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return SchoolInfoFragment1P.lambda$SchoolSytlSuccess$0(view);
                }
            });
            this.webview.loadDataWithBaseURL(null, StringUtils.formatHtmlData(schoolStytleRsp.data.schoolIntroduce), "text/html", "utf-8", null);
        }
    }

    void setBean(SchoolStytleRsp schoolStytleRsp) {
        ArrayList arrayList = new ArrayList();
        SchoolInfoBean schoolInfoBean = new SchoolInfoBean();
        schoolInfoBean.num = schoolStytleRsp.data.stuNums.intValue();
        schoolInfoBean.name = "学生";
        schoolInfoBean.type = "名";
        SchoolInfoBean schoolInfoBean2 = new SchoolInfoBean();
        schoolInfoBean2.num = schoolStytleRsp.data.gradeNums.intValue();
        schoolInfoBean2.name = "年级";
        schoolInfoBean2.type = "个";
        SchoolInfoBean schoolInfoBean3 = new SchoolInfoBean();
        schoolInfoBean3.num = schoolStytleRsp.data.classesNums.intValue();
        schoolInfoBean3.name = "班级";
        schoolInfoBean3.type = "个";
        SchoolInfoBean schoolInfoBean4 = new SchoolInfoBean();
        schoolInfoBean4.num = schoolStytleRsp.data.teacherNums.intValue();
        schoolInfoBean4.name = "教师";
        schoolInfoBean4.type = "名";
        SchoolInfoBean schoolInfoBean5 = new SchoolInfoBean();
        schoolInfoBean5.num = schoolStytleRsp.data.level_1_TeacherNums.intValue();
        schoolInfoBean5.name = "正高级教师";
        schoolInfoBean5.type = "名";
        SchoolInfoBean schoolInfoBean6 = new SchoolInfoBean();
        schoolInfoBean6.num = schoolStytleRsp.data.level_2_TeacherNums.intValue();
        schoolInfoBean6.name = "高级教师";
        schoolInfoBean6.type = "名";
        SchoolInfoBean schoolInfoBean7 = new SchoolInfoBean();
        schoolInfoBean7.num = schoolStytleRsp.data.level_3_TeacherNums.intValue();
        schoolInfoBean7.name = "一级教师";
        schoolInfoBean7.type = "名";
        SchoolInfoBean schoolInfoBean8 = new SchoolInfoBean();
        schoolInfoBean8.num = schoolStytleRsp.data.level_4_TeacherNums.intValue();
        schoolInfoBean8.name = "二级教师";
        schoolInfoBean8.type = "名";
        SchoolInfoBean schoolInfoBean9 = new SchoolInfoBean();
        schoolInfoBean9.num = schoolStytleRsp.data.level_5_TeacherNums.intValue();
        schoolInfoBean9.name = "三级教师";
        schoolInfoBean9.type = "名";
        arrayList.add(schoolInfoBean4);
        arrayList.add(schoolInfoBean5);
        arrayList.add(schoolInfoBean6);
        arrayList.add(schoolInfoBean7);
        arrayList.add(schoolInfoBean8);
        arrayList.add(schoolInfoBean9);
        arrayList.add(schoolInfoBean);
        arrayList.add(schoolInfoBean2);
        arrayList.add(schoolInfoBean3);
        this.adapter.notifyData(arrayList);
    }
}
