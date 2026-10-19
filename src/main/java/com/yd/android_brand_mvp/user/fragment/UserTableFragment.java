package com.yd.android_brand_mvp.user.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import butterknife.BindView;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.TimeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.MyTableAdapter2;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.GetAskLeaveRecordBandRsp;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.TableRsp;
import com.yd.android_brand_mvp.model.UserTableRsp;
import com.yd.android_brand_mvp.model.getUserSigByUserIdRsp;
import com.yd.android_brand_mvp.presenter.UserCenterPresenter;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.VHUtil;
import com.yd.android_brand_mvp.view.UserTableView;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class UserTableFragment extends BaseMvpFragment<UserCenterPresenter> implements UserTableView {
    weekAdapter adapter;
    MyTableAdapter2 dutyAdapter;

    @BindView(R.id.grid_rl)
    GridView gridRl;

    @BindView(R.id.list_table)
    GridView listTable;
    private List<List<TableRsp>> lists;

    @BindView(R.id.table_view)
    FrameLayout table_view;

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void GetAskLeaveRecordBandRsp(GetAskLeaveRecordBandRsp getAskLeaveRecordBandRsp) {
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void GetAskLeaveRecordBandRspFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void UserTableDataFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void getCDKBData(KBRsp2 kBRsp2) {
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void getUserSigByUserId(getUserSigByUserIdRsp getusersigbyuseridrsp) {
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void getUserSigByUserIdFail(String str) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.user_table_layout, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        init();
        ((UserCenterPresenter) this.mvpPresenter).UserTable(SpData.getClassesId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public UserCenterPresenter createPresenter() {
        return new UserCenterPresenter(this);
    }

    private void init() {
        MyTableAdapter2 myTableAdapter2 = new MyTableAdapter2(this.mActivity, TimeUtil.getIntWeek(System.currentTimeMillis()));
        this.dutyAdapter = myTableAdapter2;
        this.listTable.setAdapter((ListAdapter) myTableAdapter2);
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void UserTableData(UserTableRsp userTableRsp) {
        if (userTableRsp.code.intValue() == BaseConstant.REQUEST_SUCCES2) {
            setData(userTableRsp);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:45:0x00d9  */
    void setData(UserTableRsp userTableRsp) {
        this.lists = new ArrayList();
        int i = 1;
        for (int i2 = 1; i2 <= 7; i2++) {
            ArrayList arrayList = new ArrayList();
            for (UserTableRsp.DataDTO.SubListDTO subListDTO : userTableRsp.data.subList) {
                if (subListDTO.weekTime == i2 && subListDTO.subjectName != null) {
                    arrayList.add(getTableRsp(subListDTO));
                }
            }
            if (arrayList.size() > 0) {
                this.lists.add(arrayList);
            }
        }
        Iterator<List<TableRsp>> it2 = this.lists.iterator();
        while (it2.hasNext()) {
            Log.e("wick", JSON.toJSONString(it2.next()));
        }
        Log.e("TAG", "" + this.lists.size());
        switch (TimeUtils.getChineseWeek(new Date())) {
            case "周一":
                break;
            case "周二":
                i = 2;
                break;
            case "周三":
                i = 3;
                break;
            case "周四":
                i = 4;
                break;
            case "周五":
                i = 5;
                break;
            case "周六":
                i = 6;
                break;
            case "周日":
                i = 7;
                break;
            default:
                i = -1;
                break;
        }
        if (i > this.lists.size()) {
            this.dutyAdapter.notifyData(this.lists.get(0));
        } else {
            this.dutyAdapter.notifyData(this.lists.get(i - 1), i == 7 ? 0 : i + 1);
        }
        this.gridRl.setNumColumns(this.lists.size());
        this.adapter = new weekAdapter();
        if (i > this.lists.size()) {
            this.adapter.setPostion(0);
        }
        this.gridRl.setAdapter((ListAdapter) this.adapter);
        this.gridRl.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yd.android_brand_mvp.user.fragment.UserTableFragment.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                UserTableFragment.this.adapter.setPostion(i3);
                if (UserTableFragment.this.lists != null) {
                    UserTableFragment.this.dutyAdapter.notifyData((List) UserTableFragment.this.lists.get(i3 == 6 ? 0 : i3 + 2));
                }
            }
        });
    }

    public TableRsp getTableRsp(UserTableRsp.DataDTO.SubListDTO subListDTO) {
        TableRsp tableRsp = new TableRsp();
        tableRsp.subjectsName = subListDTO.subjectName;
        tableRsp.teacherName = subListDTO.classesTeacher;
        tableRsp.seletion = Integer.valueOf(subListDTO.section).intValue();
        tableRsp.startTime = subListDTO.fromDateTime;
        tableRsp.endTime = subListDTO.toDateTime;
        tableRsp.week = subListDTO.weekTime;
        return tableRsp;
    }

    private class weekAdapter extends BaseAdapter {
        public int i;
        Resources res;
        String[] week;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        private weekAdapter() {
            this.res = UserTableFragment.this.getResources();
            this.week = getWeek();
            this.i = -1;
        }

        private String[] getWeek() {
            if (UserTableFragment.this.lists.size() != 5) {
                if (UserTableFragment.this.lists.size() != 6) {
                    if (UserTableFragment.this.lists.size() == 5) {
                        return this.res.getStringArray(R.array.weekStr_7);
                    }
                    return this.res.getStringArray(R.array.weekStr_7);
                }
                return this.res.getStringArray(R.array.weekStr_6);
            }
            return this.res.getStringArray(R.array.weekStr_5);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.week.length;
        }

        @Override // android.widget.Adapter
        public String getItem(int i) {
            return this.week[i];
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_week_item5_l, (ViewGroup) null);
            }
            CheckedTextView checkedTextView = (CheckedTextView) VHUtil.ViewHolder.get(view, R.id.weekItem);
            checkedTextView.setText(getItem(i));
            checkedTextView.setChecked(TextUtils.equals(getItem(i), TimeUtils.getChineseWeek(new Date())));
            int i2 = this.i;
            if (i2 != -1) {
                if (i2 == i) {
                    checkedTextView.setChecked(true);
                } else {
                    checkedTextView.setChecked(false);
                }
            }
            return view;
        }

        public void setPostion(int i) {
            this.i = i;
            notifyDataSetChanged();
        }
    }
}
