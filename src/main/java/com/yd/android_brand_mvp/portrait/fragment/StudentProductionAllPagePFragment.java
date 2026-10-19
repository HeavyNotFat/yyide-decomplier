package com.yd.android_brand_mvp.portrait.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.blankj.utilcode.util.StringUtils;
import com.lxj.xpopup.XPopup;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.ImageAdapter;
import com.yd.android_brand_mvp.adapter.ProductionCommentAdapter;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.listener.AdapterListener;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.NewWorkCommentRsp;
import com.yd.android_brand_mvp.model.StudentInfoBean;
import com.yd.android_brand_mvp.model.StudentWorkListBean;
import com.yd.android_brand_mvp.model.UserIcCardBean;
import com.yd.android_brand_mvp.presenter.StudentProductionPresenter;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.CheackNomalActivity;
import com.yd.android_brand_mvp.view.StudentProductionView;
import com.yd.android_brand_mvp.weight.ImageShowPopup;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes4.dex */
public class StudentProductionAllPagePFragment extends BaseMvpFragment<StudentProductionPresenter> implements StudentProductionView {
    ProductionCommentAdapter commentAdapter;
    List<StudentWorkListBean.DataBean.RecordsBean.WorkCommentVosBean> commentList;
    StudentWorkListBean.DataBean.RecordsBean dataBean;

    @BindView(R.id.et_comment)
    EditText etComment;
    List<ImageView> imageList;

    @BindView(R.id.iv_head_portrait)
    ImageView ivHeadPortrait;

    @BindView(R.id.iv_like)
    ImageView ivLike;

    @BindView(R.id.banner)
    Banner mBanner;

    @BindView(R.id.rv_comment_list)
    RecyclerView rvCommentList;

    @BindView(R.id.tv_comment_hint)
    TextView tvCommentHint;

    @BindView(R.id.tv_like)
    TextView tvLike;

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_personal_motto)
    TextView tvPersonalMotto;

    @BindView(R.id.tv_work_name)
    TextView tvWorName;

    @BindView(R.id.tv_work_desc)
    TextView tv_work_desc;
    Unbinder unbinder;

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void getProductionSuccessFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void getStudentWorkSuccess(StudentWorkListBean studentWorkListBean) {
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void getStudentWorkSuccessFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void getWorkCommentSuccessFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void getWorkLikeSuccessFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void selectUserInfoByIcCardSuccess(UserIcCardBean userIcCardBean) {
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void selectUserInfoByIcCardSuccessFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void setWorkLikeSuccess(NewWorkCommentRsp newWorkCommentRsp) {
    }

    public static StudentProductionAllPagePFragment getInstance(StudentWorkListBean.DataBean.RecordsBean recordsBean) {
        return new StudentProductionAllPagePFragment(recordsBean);
    }

    public StudentProductionAllPagePFragment() {
    }

    public StudentProductionAllPagePFragment(StudentWorkListBean.DataBean.RecordsBean recordsBean) {
        this.dataBean = recordsBean;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.student_production_all_page_p, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
        initData();
        EventBus.getDefault().register(this);
    }

    private void initView() {
        StudentWorkListBean.DataBean.RecordsBean recordsBean = this.dataBean;
        if (recordsBean == null) {
            return;
        }
        if (recordsBean.workCommentVos != null) {
            this.commentList = this.dataBean.workCommentVos;
        } else {
            this.commentList = new ArrayList();
        }
        List<StudentWorkListBean.DataBean.RecordsBean.WorkCommentVosBean> list = this.commentList;
        if (list != null && list.size() != 0) {
            this.tvCommentHint.setVisibility(8);
        } else {
            this.tvCommentHint.setVisibility(0);
        }
        if (this.dataBean.likeCount != 0) {
            this.tvLike.setText(this.dataBean.likeCount + "");
        } else {
            this.tvLike.setText(R.string.tv_like);
        }
        GlideUtil.loadCircleHeadImage(this.mActivity, this.dataBean.avatar, this.ivHeadPortrait);
        this.tvPersonalMotto.setText(StringUtils.isEmpty(this.dataBean.studentName) ? "" : this.dataBean.studentName);
        this.tvName.setText(StringUtils.isEmpty(this.dataBean.studentName) ? "" : this.dataBean.studentName);
        this.tv_work_desc.setText(StringUtils.isEmpty(this.dataBean.workDesc) ? "无" : this.dataBean.workDesc);
        this.tvWorName.setText(StringUtils.isEmpty(this.dataBean.workName) ? "无" : this.dataBean.workName);
        setImageList();
    }

    private void initData() {
        initBanner();
        showComment();
    }

    private void showComment() {
        this.commentAdapter = new ProductionCommentAdapter(R.layout.production_comment_item, this.commentList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.rvCommentList.setLayoutManager(linearLayoutManager);
        this.rvCommentList.setAdapter(this.commentAdapter);
    }

    private void setImageList() {
        this.imageList = new ArrayList();
        if (this.dataBean.worksUrl == null || this.dataBean.worksUrl.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.dataBean.worksUrl.size(); i++) {
            ImageView imageView = new ImageView(this.mActivity);
            GlideUtil.loadNormalImg(imageView, this.dataBean.worksUrl.get(i));
            imageView.setTag(this.dataBean.worksUrl.get(i));
            this.imageList.add(imageView);
        }
    }

    private void initBanner() {
        ImageAdapter imageAdapter = new ImageAdapter(requireContext(), null);
        imageAdapter.setAdapterListener(new AdapterListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.StudentProductionAllPagePFragment.1
            @Override // com.yd.android_brand_mvp.listener.AdapterListener
            public void setOnclick(int i, String str) {
                new XPopup.Builder(StudentProductionAllPagePFragment.this.mActivity).asCustom(new ImageShowPopup(StudentProductionAllPagePFragment.this.mActivity, str)).show();
            }
        });
        this.mBanner.addBannerLifecycleObserver(this).setStartPosition(1).setAdapter(imageAdapter).isAutoLoop(true).setLoopTime(5000L).setIndicator(new CircleIndicator(requireContext())).setIndicatorGravity(1).setIndicatorSpace(BannerUtils.dp2px(10.0f)).setIndicatorNormalColor(getResources().getColor(R.color.gray)).setIndicatorSelectedColor(getResources().getColor(R.color.blue12)).setIndicatorWidth(BannerUtils.dp2px(6.0f), BannerUtils.dp2px(6.0f)).setIndicatorHeight(BannerUtils.dp2px(6.0f));
        this.mBanner.setDatas(this.dataBean.worksUrl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public StudentProductionPresenter createPresenter() {
        return new StudentProductionPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Unbinder unbinder = this.unbinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
        EventBus.getDefault().unregister(this);
    }

    private boolean verifyComment(String str) {
        if (!StringUtils.isEmpty(str)) {
            return true;
        }
        ToastUtil.showBottomView(this.mActivity, "请输入评论");
        return false;
    }

    @OnClick({R.id.bt_comment, R.id.like_layout})
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.bt_comment) {
            if (id != R.id.like_layout) {
                return;
            }
            Intent intent = new Intent(this.mActivity, (Class<?>) CheackNomalActivity.class);
            intent.putExtra("type", BaseConstant.like);
            intent.putExtra("productionId", this.dataBean.id);
            startActivity(intent);
            return;
        }
        if (verifyComment(this.etComment.getText().toString())) {
            Intent intent2 = new Intent(this.mActivity, (Class<?>) CheackNomalActivity.class);
            intent2.putExtra("type", BaseConstant.comment);
            intent2.putExtra("productionId", this.dataBean.id);
            startActivity(intent2);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(EventBean eventBean) {
        if (eventBean.Event == BaseConstant.CheackMsg && eventBean.productionId.equals(this.dataBean.id)) {
            if (eventBean.type == BaseConstant.comment) {
                ((StudentProductionPresenter) this.mvpPresenter).setWorkComment(this.dataBean.id + "", this.etComment.getText().toString(), eventBean.id + "", eventBean.name);
                return;
            }
            ((StudentProductionPresenter) this.mvpPresenter).setWorkLike(this.dataBean.id + "", eventBean.id + "");
        }
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void setWorkCommentSuccess(NewWorkCommentRsp newWorkCommentRsp) {
        ((StudentProductionPresenter) this.mvpPresenter).selectStudentInfo(this.dataBean.id + "");
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void selectStudentInfoSuccess(StudentInfoBean studentInfoBean) {
        this.commentList.add(0, studentInfoBean.data.workCommentVos.get(0));
        showComment();
        this.etComment.setText("");
        List<StudentWorkListBean.DataBean.RecordsBean.WorkCommentVosBean> list = this.commentList;
        if (list != null && list.size() != 0) {
            this.tvCommentHint.setVisibility(8);
        } else {
            this.tvCommentHint.setVisibility(0);
        }
        ToastUtil.showBottomView(this.mActivity, "添加评论成功");
    }
}
