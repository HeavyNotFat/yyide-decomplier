package com.yd.android_brand_mvp.db;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import com.alibaba.fastjson.JSON;
import com.tencent.imsdk.v2.V2TIMGroupAtInfo;
import com.tencent.qcloud.tim.uikit.base.BaseFragment;
import com.tencent.qcloud.tim.uikit.component.AudioPlayer;
import com.tencent.qcloud.tim.uikit.component.TitleBarLayout;
import com.tencent.qcloud.tim.uikit.modules.chat.ChatLayout;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.modules.chat.layout.input.InputLayout;
import com.tencent.qcloud.tim.uikit.modules.group.info.GroupInfo;
import com.tencent.qcloud.tim.uikit.modules.group.info.StartGroupMemberSelectActivity;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yyide.im.chat.DemoApplication;
import com.yyide.im.chat.contact.FriendProfileActivity;
import com.yyide.im.chat.helper.AuildTimeListener;
import com.yyide.im.chat.helper.ChatLayoutHelper;
import com.yyide.im.chat.login.UserInfo;
import com.yyide.im.chat.scenes.LiveRoomAnchorActivity;
import com.yyide.im.chat.utils.TimeUtil;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class ChatFragment3 extends BaseFragment implements AuildTimeListener {
    private static final String TAG = ChatFragment3.class.getSimpleName();
    boolean first = false;
    private FragmentManager fm;
    HandBD handbd;
    InputLayout inputLayout;
    private View mBaseView;
    private ChatInfo mChatInfo;
    private ChatLayout mChatLayout;
    private TitleBarLayout mTitleBar;

    @Override // com.yyide.im.chat.helper.AuildTimeListener
    public void UpdataTime(long j) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.chat_fragment, viewGroup, false);
        this.mBaseView = viewInflate;
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("setIndex");
        intentFilter.addAction("seacherDB1");
        intentFilter.addAction("seacherDB2");
        intentFilter.addAction("seacherDB3");
        intentFilter.addAction("seacherDB4");
        this.handbd = new HandBD();
        if (getActivity() != null) {
            getActivity().registerReceiver(this.handbd, intentFilter);
        }
    }

    private void initView() {
        ChatLayout chatLayout = (ChatLayout) this.mBaseView.findViewById(R.id.chat_layout);
        this.mChatLayout = chatLayout;
        chatLayout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.db.ChatFragment3.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.mChatLayout.initDefault();
        this.mChatLayout.setChatInfo(this.mChatInfo);
        TitleBarLayout titleBar = this.mChatLayout.getTitleBar();
        this.mTitleBar = titleBar;
        titleBar.getRightGroup().setVisibility(8);
        this.mTitleBar.getLeftIcon().setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.back_btn_im));
        this.mTitleBar.setBackgroundColor(SkinCompatResources.getInstance().getColor(R.color.white));
        this.mChatLayout.getMessageLayout().setBackgroundColor(SkinCompatResources.getInstance().getColor(R.color.white));
        this.mChatLayout.getInputLayout().setBackgroundColor(SkinCompatResources.getInstance().getColor(R.color.white));
        this.inputLayout = this.mChatLayout.getInputLayout();
        this.mTitleBar.setOnLeftClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.db.ChatFragment3.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                for (int i = 0; i < ChatFragment3.this.getFragmentManager().getBackStackEntryCount(); i++) {
                    ChatFragment3.this.fm.popBackStack();
                }
            }
        });
        if (this.mChatInfo.getType() == 1) {
            this.mTitleBar.setOnRightClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.db.ChatFragment3.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent(DemoApplication.instance(), (Class<?>) FriendProfileActivity.class);
                    intent.addFlags(268435456);
                    intent.putExtra("content", ChatFragment3.this.mChatInfo);
                    DemoApplication.instance().startActivity(intent);
                }
            });
        }
        this.mChatLayout.getInputLayout().setStartActivityListener(new InputLayout.onStartActivityListener() { // from class: com.yd.android_brand_mvp.db.ChatFragment3.4
            @Override // com.tencent.qcloud.tim.uikit.modules.chat.layout.input.InputLayout.onStartActivityListener
            public void onStartGroupMemberSelectActivity() {
                Intent intent = new Intent(DemoApplication.instance(), (Class<?>) StartGroupMemberSelectActivity.class);
                GroupInfo groupInfo = new GroupInfo();
                groupInfo.setId(ChatFragment3.this.mChatInfo.getId());
                groupInfo.setChatName(ChatFragment3.this.mChatInfo.getChatName());
                intent.putExtra(TUIKitConstants.Group.GROUP_INFO, groupInfo);
                ChatFragment3.this.startActivityForResult(intent, 1);
            }

            @Override // com.tencent.qcloud.tim.uikit.modules.chat.layout.input.InputLayout.onStartActivityListener
            public boolean handleStartGroupLiveActivity() {
                LiveRoomAnchorActivity.start(DemoApplication.instance(), ChatFragment3.this.mChatInfo.getId());
                return true;
            }
        });
    }

    private void updateAtInfoLayout() {
        int atInfoType = getAtInfoType(this.mChatInfo.getAtInfoList());
        if (atInfoType == 1) {
            this.mChatLayout.getAtInfoLayout().setVisibility(0);
            this.mChatLayout.getAtInfoLayout().setText(DemoApplication.instance().getString(R.string.ui_at_me));
        } else if (atInfoType == 2) {
            this.mChatLayout.getAtInfoLayout().setVisibility(0);
            this.mChatLayout.getAtInfoLayout().setText(DemoApplication.instance().getString(R.string.ui_at_all));
        } else if (atInfoType == 3) {
            this.mChatLayout.getAtInfoLayout().setVisibility(0);
            this.mChatLayout.getAtInfoLayout().setText(DemoApplication.instance().getString(R.string.ui_at_all_me));
        } else {
            this.mChatLayout.getAtInfoLayout().setVisibility(8);
        }
    }

    private int getAtInfoType(List<V2TIMGroupAtInfo> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        boolean z = false;
        boolean z2 = false;
        for (V2TIMGroupAtInfo v2TIMGroupAtInfo : list) {
            if (v2TIMGroupAtInfo.getAtType() != 1) {
                if (v2TIMGroupAtInfo.getAtType() == 2) {
                    z = true;
                } else if (v2TIMGroupAtInfo.getAtType() == 3) {
                    z = true;
                }
            }
            z2 = true;
        }
        if (z && z2) {
            return 3;
        }
        if (z) {
            return 2;
        }
        return z2 ? 1 : 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == 3) {
            String stringExtra = intent.getStringExtra(TUIKitConstants.Selection.USER_ID_SELECT);
            this.mChatLayout.getInputLayout().updateInputText(intent.getStringExtra(TUIKitConstants.Selection.USER_NAMECARD_SELECT), stringExtra);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ChatInfo chatInfo = (ChatInfo) getArguments().getSerializable("chatInfo");
        this.mChatInfo = chatInfo;
        if (chatInfo == null) {
            return;
        }
        this.fm = getFragmentManager();
        initView();
        if (!this.first) {
            new ChatLayoutHelper(getActivity()).customizeChatLayout(this.mChatLayout);
            this.first = true;
        }
        ChatLayout chatLayout = this.mChatLayout;
        if (chatLayout != null) {
            chatLayout.getInputLayout().disableAudioInput(false);
            this.mChatLayout.getInputLayout().disableEmojiInput(true);
            this.mChatLayout.getInputLayout().disableMoreInput(true);
        }
        LinearLayout linearLayout = (LinearLayout) this.inputLayout.findViewById(R.id.dhlayout);
        LinearLayout linearLayout2 = (LinearLayout) this.inputLayout.findViewById(R.id.splayout);
        linearLayout.setVisibility(8);
        linearLayout2.setVisibility(8);
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.db.ChatFragment3.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ChatFragment3.this.getActivity() != null) {
                    ChatFragment3.this.getActivity().sendBroadcast(new Intent("seacherDB3"));
                }
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AudioPlayer.getInstance().stopPlay();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ChatLayout chatLayout = this.mChatLayout;
        if (chatLayout != null) {
            chatLayout.exitChat();
        }
        if (getActivity() != null) {
            getActivity().unregisterReceiver(this.handbd);
        }
    }

    public class HandBD extends BroadcastReceiver {
        public HandBD() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("setIndex")) {
                for (int i = 0; i < ChatFragment3.this.getFragmentManager().getBackStackEntryCount(); i++) {
                    ChatFragment3.this.fm.popBackStack();
                }
                return;
            }
            if (intent.getAction().equals("seacherDB1")) {
                ChatFragment3.this.seacherDB1(UserInfo.getInstance().getUserId());
                return;
            }
            if (intent.getAction().equals("seacherDB2")) {
                ChatFragment3.this.seacherDB2(UserInfo.getInstance().getUserId());
            } else if (intent.getAction().equals("seacherDB3")) {
                ChatFragment3.this.seacherDB3(UserInfo.getInstance().getUserId());
            } else if (intent.getAction().equals("seacherDB4")) {
                ChatFragment3.this.seacherDB4(UserInfo.getInstance().getUserId());
            }
        }
    }

    void seacherDB1(String str) {
        new insertAsyncTask(DataBaseInstance.getInstance(getActivity()).ImUserDao(), str).execute(new ImUserDao[0]);
    }

    private class insertAsyncTask extends AsyncTask<ImUserDao, String, Void> {
        ImUserDao toDoDao;

        insertAsyncTask(ImUserDao imUserDao, String str) {
            this.toDoDao = imUserDao;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(ImUserDao... imUserDaoArr) {
            List<ImUser> listFindById = this.toDoDao.findById(UserInfo.getInstance().getUserId());
            Log.e(ChatFragment3.TAG, "mChatInfo: " + JSON.toJSONString(UserInfo.getInstance().getUserId()));
            Log.e(ChatFragment3.TAG, "seacherDB1: " + JSON.toJSONString(listFindById));
            if (listFindById.size() > 0) {
                boolean z = false;
                for (ImUser imUser : listFindById) {
                    if (imUser.userId.equals(UserInfo.getInstance().getUserId())) {
                        if (!TimeUtil.stampToDate(System.currentTimeMillis()).equals(imUser.time) || imUser.count.intValue() < 2) {
                            ChatFragment3.this.inputLayout.startAudioCall();
                        } else {
                            ToastUtil.showBottomView((Activity) ChatFragment3.this.getActivity(), "您今日已无通话时长");
                        }
                        z = true;
                    }
                }
                if (z) {
                    return null;
                }
                ChatFragment3.this.inputLayout.startAudioCall();
                return null;
            }
            ChatFragment3.this.inputLayout.startAudioCall();
            return null;
        }
    }

    void seacherDB2(String str) {
        new seacherAsyncTask(DataBaseInstance.getInstance(getActivity()).ImUserDao(), str).execute(new ImUserDao[0]);
    }

    private class seacherAsyncTask extends AsyncTask<ImUserDao, String, Void> {
        String id;
        ImUserDao toDoDao;

        seacherAsyncTask(ImUserDao imUserDao, String str) {
            this.toDoDao = imUserDao;
            this.id = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(ImUserDao... imUserDaoArr) {
            List<ImUser> listFindById = this.toDoDao.findById(this.id);
            Log.e(ChatFragment3.TAG, "seacherDB2: " + JSON.toJSONString(listFindById));
            if (listFindById.size() > 0) {
                ImUser imUser = new ImUser();
                imUser.userId = UserInfo.getInstance().getUserId();
                for (ImUser imUser2 : listFindById) {
                    int iIntValue = imUser2.count.intValue();
                    imUser.id = imUser2.id;
                    if (!TimeUtil.stampToDate(System.currentTimeMillis()).equals(imUser2.time)) {
                        imUser.count = 1;
                    } else if (iIntValue == 0) {
                        imUser.count = 1;
                    } else {
                        imUser.count = Integer.valueOf(iIntValue + 1);
                    }
                }
                imUser.time = TimeUtil.stampToDate(System.currentTimeMillis());
                Log.e(ChatFragment3.TAG, "imUser2: " + JSON.toJSONString(imUser));
                this.toDoDao.update(imUser);
                return null;
            }
            ImUser imUser3 = new ImUser();
            imUser3.userId = UserInfo.getInstance().getUserId();
            imUser3.time = TimeUtil.stampToDate(System.currentTimeMillis());
            imUser3.count = 1;
            this.toDoDao.insertAll(imUser3);
            return null;
        }
    }

    void seacherDB3(String str) {
        new insertAsyncTask3(DataBaseInstance.getInstance(getActivity()).ImUserDao(), str).execute(new ImUserDao[0]);
    }

    private class insertAsyncTask3 extends AsyncTask<ImUserDao, String, Void> {
        ImUserDao toDoDao;

        insertAsyncTask3(ImUserDao imUserDao, String str) {
            this.toDoDao = imUserDao;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(ImUserDao... imUserDaoArr) {
            List<ImUser> listFindById = this.toDoDao.findById(UserInfo.getInstance().getUserId());
            Log.e(ChatFragment3.TAG, "mChatInfo: " + JSON.toJSONString(UserInfo.getInstance().getUserId()));
            Log.e(ChatFragment3.TAG, "seacherDB3: " + JSON.toJSONString(listFindById));
            if (listFindById.size() > 0) {
                boolean z = false;
                for (ImUser imUser : listFindById) {
                    if (imUser.userId.equals(UserInfo.getInstance().getUserId())) {
                        if (!TimeUtil.stampToDate(System.currentTimeMillis()).equals(imUser.videotime) || imUser.videocount.intValue() < 2) {
                            ChatFragment3.this.inputLayout.startVideoCall();
                        } else {
                            ToastUtil.showBottomView((Activity) ChatFragment3.this.getActivity(), "您今日已无视频时长");
                        }
                        z = true;
                    }
                }
                if (z) {
                    return null;
                }
                ChatFragment3.this.inputLayout.startVideoCall();
                return null;
            }
            ChatFragment3.this.inputLayout.startVideoCall();
            return null;
        }
    }

    void seacherDB4(String str) {
        new seacherAsyncTask4(DataBaseInstance.getInstance(getActivity()).ImUserDao(), str).execute(new ImUserDao[0]);
    }

    private class seacherAsyncTask4 extends AsyncTask<ImUserDao, String, Void> {
        String id;
        ImUserDao toDoDao;

        seacherAsyncTask4(ImUserDao imUserDao, String str) {
            this.toDoDao = imUserDao;
            this.id = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(ImUserDao... imUserDaoArr) {
            List<ImUser> listFindById = this.toDoDao.findById(this.id);
            Log.e(ChatFragment3.TAG, "seacherDB2: " + JSON.toJSONString(listFindById));
            if (listFindById.size() > 0) {
                ImUser imUser = new ImUser();
                imUser.userId = UserInfo.getInstance().getUserId();
                for (ImUser imUser2 : listFindById) {
                    Integer num = imUser2.videocount;
                    imUser.id = imUser2.id;
                    if (TimeUtil.stampToDate(System.currentTimeMillis()).equals(imUser2.videotime)) {
                        if (num.intValue() == 0) {
                            imUser.videocount = 1;
                        } else {
                            imUser.videocount = Integer.valueOf(num.intValue() + 1);
                        }
                    } else {
                        imUser.videocount = 1;
                    }
                }
                imUser.videotime = TimeUtil.stampToDate(System.currentTimeMillis());
                Log.e(ChatFragment3.TAG, "imUser2: " + JSON.toJSONString(imUser));
                this.toDoDao.update(imUser);
                return null;
            }
            ImUser imUser3 = new ImUser();
            imUser3.userId = UserInfo.getInstance().getUserId();
            imUser3.videotime = TimeUtil.stampToDate(System.currentTimeMillis());
            imUser3.videocount = 1;
            this.toDoDao.insertAll(imUser3);
            return null;
        }
    }
}
