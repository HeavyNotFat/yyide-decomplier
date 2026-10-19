package com.yd.android_brand_mvp.adapter;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.StudenDutyBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class DayStudentDutyAdapter extends BaseQuickAdapter<StudenDutyBean.DataBean, BaseViewHolder> {
    private String TAG;
    int colorId;
    int type;

    public DayStudentDutyAdapter(int i, List list) {
        super(i, list);
        this.type = 0;
        this.colorId = 0;
        this.TAG = DayStudentDutyAdapter.class.getSimpleName();
    }

    public DayStudentDutyAdapter(int i, List list, int i2) {
        super(i, list);
        this.type = 0;
        this.colorId = 0;
        this.TAG = DayStudentDutyAdapter.class.getSimpleName();
        this.type = i2;
    }

    public DayStudentDutyAdapter(int i, List list, int i2, int i3) {
        super(i, list);
        this.type = 0;
        this.colorId = 0;
        this.TAG = DayStudentDutyAdapter.class.getSimpleName();
        this.type = i2;
        this.colorId = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder baseViewHolder, StudenDutyBean.DataBean dataBean) {
        int i;
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_icon);
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.rv_name);
        ConstraintLayout constraintLayout = (ConstraintLayout) baseViewHolder.getView(R.id.ll_duty);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_project_name);
        Log.e(this.TAG, "getProjectName" + this.type);
        GlideUtil.loadStudent(getContext(), dataBean.getIcon(), imageView);
        if (this.type == 1) {
            i = R.layout.student_all_name_item;
        } else {
            i = ScreenUtils.isLandscape() ? R.layout.student_name_item : R.layout.student_name_item_p;
        }
        if (this.colorId == 1) {
            textView.setTextColor(SkinCompatResources.getInstance().getColor(R.color.white));
            constraintLayout.setBackgroundResource(R.drawable.icon_content_z);
        }
        textView.setText(dataBean.getProjectName());
        BaseQuickAdapter<StudenDutyBean.DataBean.StudentDutyInfoBean, BaseViewHolder> baseQuickAdapter = new BaseQuickAdapter<StudenDutyBean.DataBean.StudentDutyInfoBean, BaseViewHolder>(i) { // from class: com.yd.android_brand_mvp.adapter.DayStudentDutyAdapter.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder baseViewHolder2, StudenDutyBean.DataBean.StudentDutyInfoBean studentDutyInfoBean) {
                TextView textView2 = (TextView) baseViewHolder2.getView(R.id.tv_name);
                Log.e(DayStudentDutyAdapter.this.TAG, "infoBean.getStudentName()" + studentDutyInfoBean.getStudentName());
                if (DayStudentDutyAdapter.this.colorId == 1) {
                    textView2.setTextColor(SkinCompatResources.getInstance().getColor(R.color.white));
                }
                textView2.setText(studentDutyInfoBean.getStudentName());
            }
        };
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        baseQuickAdapter.setList(dataBean.getStudentDutyInfo());
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(baseQuickAdapter);
    }
}
