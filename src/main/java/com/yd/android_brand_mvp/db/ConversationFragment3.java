package com.yd.android_brand_mvp.db;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.fragment.app.FragmentTransaction;
import androidx.work.WorkRequest;
import com.tencent.imsdk.v2.V2TIMConversationResult;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMSendCallback;
import com.tencent.qcloud.tim.uikit.base.BaseFragment;
import com.tencent.qcloud.tim.uikit.component.action.PopActionClickListener;
import com.tencent.qcloud.tim.uikit.component.action.PopDialogAdapter;
import com.tencent.qcloud.tim.uikit.component.action.PopMenuAction;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationLayout;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationListLayout;
import com.tencent.qcloud.tim.uikit.modules.conversation.base.ConversationInfo;
import com.tencent.qcloud.tim.uikit.utils.PopWindowUtil;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;
import com.yd.android_brand_mvp.R;
import com.yyide.im.chat.helper.ConversationLayoutHelper;
import com.yyide.im.chat.menu.Menu;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class ConversationFragment3 extends BaseFragment {
    ChatFragment3 chatFragment2;
    private View mBaseView;
    private ConversationLayout mConversationLayout;
    private List<PopMenuAction> mConversationPopActions = new ArrayList();
    private PopDialogAdapter mConversationPopAdapter;
    private ListView mConversationPopList;
    private PopupWindow mConversationPopWindow;
    private Menu mMenu;

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mBaseView = layoutInflater.inflate(R.layout.conversation_fragment, viewGroup, false);
        initView();
        return this.mBaseView;
    }

    private void initView() {
        this.mConversationLayout = (ConversationLayout) this.mBaseView.findViewById(R.id.conversation_layout);
        this.mMenu = new Menu(getActivity(), this.mConversationLayout.getTitleBar(), 2);
        this.mConversationLayout.initDefault();
        this.mConversationLayout.getConversationList();
        ConversationLayoutHelper.customizeConversation(this.mConversationLayout);
        this.mConversationLayout.getConversationList().setOnItemClickListener(new ConversationListLayout.OnItemClickListener() { // from class: com.yd.android_brand_mvp.db.ConversationFragment3.1
            @Override // com.tencent.qcloud.tim.uikit.modules.conversation.ConversationListLayout.OnItemClickListener
            public void onItemClick(View view, int i, ConversationInfo conversationInfo) {
                ConversationFragment3.this.startChatActivity(conversationInfo);
            }
        });
        this.mConversationLayout.getConversationList().setOnItemLongClickListener(new ConversationListLayout.OnItemLongClickListener() { // from class: com.yd.android_brand_mvp.db.ConversationFragment3.2
            @Override // com.tencent.qcloud.tim.uikit.modules.conversation.ConversationListLayout.OnItemLongClickListener
            public void OnItemLongClick(View view, int i, ConversationInfo conversationInfo) {
                ConversationFragment3.this.startPopShow(view, i, conversationInfo);
            }
        });
        initTitleAction();
        initPopMenuAction();
        this.mConversationLayout.getTitleBar().setBackgroundColor(SkinCompatResources.getInstance().getColor(R.color.white));
        this.mConversationLayout.getTitleBar().getRightIcon().setVisibility(8);
        this.mConversationLayout.getTitleBar().getMiddleTitle().setVisibility(8);
        V2TIMManager.getConversationManager().getConversationList(0L, 100, new V2TIMSendCallback<V2TIMConversationResult>() { // from class: com.yd.android_brand_mvp.db.ConversationFragment3.3
            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                ToastUtil.toastShortMessage("onError==>" + str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMConversationResult v2TIMConversationResult) {
                Log.i("TAG", "onSuccess: " + v2TIMConversationResult.getConversationList().toString());
                if (ConversationFragment3.this.getActivity() != null) {
                    Intent intent = new Intent();
                    intent.setAction("finshDialong");
                    ConversationFragment3.this.getActivity().sendBroadcast(intent);
                }
            }
        });
    }

    private void initTitleAction() {
        this.mConversationLayout.getTitleBar().setOnRightClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.db.ConversationFragment3.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConversationFragment3.this.mMenu.isShowing()) {
                    ConversationFragment3.this.mMenu.hide();
                } else {
                    ConversationFragment3.this.mMenu.show();
                }
            }
        });
    }

    private void initPopMenuAction() {
        ArrayList arrayList = new ArrayList();
        PopMenuAction popMenuAction = new PopMenuAction();
        popMenuAction.setActionName(getResources().getString(R.string.chat_top));
        popMenuAction.setActionClickListener(new PopActionClickListener() { // from class: com.yd.android_brand_mvp.db.ConversationFragment3.5
            @Override // com.tencent.qcloud.tim.uikit.component.action.PopActionClickListener
            public void onActionClick(int i, Object obj) {
                ConversationFragment3.this.mConversationLayout.setConversationTop(i, (ConversationInfo) obj);
            }
        });
        arrayList.add(popMenuAction);
        PopMenuAction popMenuAction2 = new PopMenuAction();
        popMenuAction2.setActionClickListener(new PopActionClickListener() { // from class: com.yd.android_brand_mvp.db.ConversationFragment3.6
            @Override // com.tencent.qcloud.tim.uikit.component.action.PopActionClickListener
            public void onActionClick(int i, Object obj) {
                ConversationFragment3.this.mConversationLayout.deleteConversation(i, (ConversationInfo) obj);
            }
        });
        popMenuAction2.setActionName(getResources().getString(R.string.chat_delete));
        arrayList.add(popMenuAction2);
        this.mConversationPopActions.clear();
        this.mConversationPopActions.addAll(arrayList);
    }

    private void showItemPopMenu(final int i, final ConversationInfo conversationInfo, float f, float f2) {
        List<PopMenuAction> list = this.mConversationPopActions;
        if (list == null || list.size() == 0) {
            return;
        }
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.pop_menu_layout, (ViewGroup) null);
        ListView listView = (ListView) viewInflate.findViewById(R.id.pop_menu_list);
        this.mConversationPopList = listView;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yd.android_brand_mvp.db.ConversationFragment3.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                PopMenuAction popMenuAction = (PopMenuAction) ConversationFragment3.this.mConversationPopActions.get(i2);
                if (popMenuAction.getActionClickListener() != null) {
                    popMenuAction.getActionClickListener().onActionClick(i, conversationInfo);
                }
                ConversationFragment3.this.mConversationPopWindow.dismiss();
            }
        });
        for (int i2 = 0; i2 < this.mConversationPopActions.size(); i2++) {
            PopMenuAction popMenuAction = this.mConversationPopActions.get(i2);
            if (conversationInfo.isTop()) {
                if (popMenuAction.getActionName().equals(getResources().getString(R.string.chat_top))) {
                    popMenuAction.setActionName(getResources().getString(R.string.quit_chat_top));
                }
            } else if (popMenuAction.getActionName().equals(getResources().getString(R.string.quit_chat_top))) {
                popMenuAction.setActionName(getResources().getString(R.string.chat_top));
            }
        }
        PopDialogAdapter popDialogAdapter = new PopDialogAdapter();
        this.mConversationPopAdapter = popDialogAdapter;
        this.mConversationPopList.setAdapter((ListAdapter) popDialogAdapter);
        this.mConversationPopAdapter.setDataSource(this.mConversationPopActions);
        this.mConversationPopWindow = PopWindowUtil.popupWindow(viewInflate, this.mBaseView, (int) f, (int) f2);
        this.mBaseView.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.db.ConversationFragment3.8
            @Override // java.lang.Runnable
            public void run() {
                ConversationFragment3.this.mConversationPopWindow.dismiss();
            }
        }, WorkRequest.MIN_BACKOFF_MILLIS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPopShow(View view, int i, ConversationInfo conversationInfo) {
        showItemPopMenu(i, conversationInfo, view.getX(), view.getY() + (view.getHeight() / 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startChatActivity(ConversationInfo conversationInfo) {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.setType(conversationInfo.isGroup() ? 2 : 1);
        chatInfo.setId(conversationInfo.getId());
        chatInfo.setChatName(conversationInfo.getTitle());
        EventBus.getDefault().post(new ChatEventBean(5, chatInfo.getType(), chatInfo.getId(), chatInfo.getChatName()));
    }

    public void addFragment(ChatInfo chatInfo) {
        FragmentTransaction fragmentTransactionBeginTransaction = getFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.setTransition(4097);
        fragmentTransactionBeginTransaction.addToBackStack(null);
        if (this.chatFragment2 == null) {
            this.chatFragment2 = new ChatFragment3();
        }
        fragmentTransactionBeginTransaction.add(R.id.content, this.chatFragment2);
        Bundle bundle = new Bundle();
        bundle.putSerializable("chatInfo", chatInfo);
        this.chatFragment2.setArguments(bundle);
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
