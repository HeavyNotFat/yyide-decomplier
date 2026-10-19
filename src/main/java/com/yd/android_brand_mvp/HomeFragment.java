package com.yd.android_brand_mvp;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.android.dx.io.Opcodes;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.dk.usbNfc.Card.Mifare;
import com.dk.usbNfc.DeviceManager.ComByteManager;
import com.google.common.collect.Lists;
import com.seewo.sdk.model.SDKKeyboardCode;
import com.tencent.qcloud.tim.uikit.modules.message.MessageInfo;
import com.tencent.smtt.sdk.TbsListener;
import com.ttlock.bl.sdk.api.Command;
import com.ttlock.bl.sdk.constant.ErrorCode;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.activity.honor.fragment.HomeHonorFragment;
import com.yd.android_brand_mvp.activity.honor.fragment.HomeHonorFragment2x2;
import com.yd.android_brand_mvp.banner.BannerImageFragment;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.landscape.AssignmentFragment2_3L;
import com.yd.android_brand_mvp.landscape.AssignmentFragment2_4L;
import com.yd.android_brand_mvp.landscape.BookFragment2_1L;
import com.yd.android_brand_mvp.landscape.BookFragment2_1P;
import com.yd.android_brand_mvp.landscape.BookYwFragment4_2LBy_loan;
import com.yd.android_brand_mvp.landscape.BookYwFragment4_2LBy_new;
import com.yd.android_brand_mvp.landscape.BookYwFragment4_6LBy_search;
import com.yd.android_brand_mvp.landscape.BookYwFragmentL2;
import com.yd.android_brand_mvp.landscape.BookYwFragmentLBy_loan2_2;
import com.yd.android_brand_mvp.landscape.ClassInfoFragment2_1L;
import com.yd.android_brand_mvp.landscape.ClassInfoFragment2_2L;
import com.yd.android_brand_mvp.landscape.ClassInfoFragment2_4L;
import com.yd.android_brand_mvp.landscape.ClassInfoFragment4_1P;
import com.yd.android_brand_mvp.landscape.ClassInfoFragment4_2L;
import com.yd.android_brand_mvp.landscape.ClassInfoFragment6_2P;
import com.yd.android_brand_mvp.landscape.ClassScheduleFragment2_3L;
import com.yd.android_brand_mvp.landscape.ClassScheduleFragment2_4L;
import com.yd.android_brand_mvp.landscape.ClassScheduleFragment4_4L;
import com.yd.android_brand_mvp.landscape.ClassScheduleFragment_sk2_4L;
import com.yd.android_brand_mvp.landscape.ClassScheduleFragment_sk4_4L;
import com.yd.android_brand_mvp.landscape.CustomVerifyFragment;
import com.yd.android_brand_mvp.landscape.KBFragment2_2p;
import com.yd.android_brand_mvp.landscape.KBFragment4_2P;
import com.yd.android_brand_mvp.landscape.KBFragment4_4L;
import com.yd.android_brand_mvp.landscape.KBFragment6_3P;
import com.yd.android_brand_mvp.landscape.NCalendarLFragment;
import com.yd.android_brand_mvp.landscape.PunchThirdFragment;
import com.yd.android_brand_mvp.landscape.SiteInfoFragment;
import com.yd.android_brand_mvp.landscape.StudentCenter2_2L;
import com.yd.android_brand_mvp.landscape.StudentCenter2_3L;
import com.yd.android_brand_mvp.landscape.StudentDutyFragment2_2L;
import com.yd.android_brand_mvp.landscape.StudentDutyFragment2_3L;
import com.yd.android_brand_mvp.landscape.StudentProductionFragment2_4L;
import com.yd.android_brand_mvp.landscape.StudentProductionFragment4_4L;
import com.yd.android_brand_mvp.landscape.StudentProductionFragment4_6L;
import com.yd.android_brand_mvp.landscape.StudentProductionFragment6_3P;
import com.yd.android_brand_mvp.landscape.TimeClockFragment;
import com.yd.android_brand_mvp.landscape.TimeClockFragment2;
import com.yd.android_brand_mvp.landscape.TimeClockFragment3;
import com.yd.android_brand_mvp.landscape.TimerFragment2x2L;
import com.yd.android_brand_mvp.landscape.WebViewFragment;
import com.yd.android_brand_mvp.landscape.Wlkz2_2L;
import com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment2x2;
import com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment2x4;
import com.yd.android_brand_mvp.landscape.active.ActiveApplyFragment4x4;
import com.yd.android_brand_mvp.landscape.ai.AIFragmentFull;
import com.yd.android_brand_mvp.landscape.areover.ClassesOverFragment;
import com.yd.android_brand_mvp.landscape.attence.AttendanceFragment2_2_2L;
import com.yd.android_brand_mvp.landscape.attence.AttendanceFragment4_1_1P_list;
import com.yd.android_brand_mvp.landscape.attence.AttendanceFragment4_2P_list;
import com.yd.android_brand_mvp.landscape.attence.AttendanceFragmentSatistics2_2L;
import com.yd.android_brand_mvp.landscape.attence.AttendanceFragmentSatistics_cartoon_2_2L;
import com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment2x3;
import com.yd.android_brand_mvp.landscape.blackboard.BlackBoardFragment4x4;
import com.yd.android_brand_mvp.landscape.book.BookFragment2x2;
import com.yd.android_brand_mvp.landscape.cartoon.CartoonMenuFragment;
import com.yd.android_brand_mvp.landscape.cartoon.MessageNoticeFragment;
import com.yd.android_brand_mvp.landscape.chemistry.HomeChemistryFragment;
import com.yd.android_brand_mvp.landscape.classes.ClassInfoFragment4x2;
import com.yd.android_brand_mvp.landscape.classes.ClassInfoFragment8x6;
import com.yd.android_brand_mvp.landscape.collect.HomeCollectForm22Fragment;
import com.yd.android_brand_mvp.landscape.collect.HomeCollectForm23Fragment;
import com.yd.android_brand_mvp.landscape.consult.ConsultFragment2x6;
import com.yd.android_brand_mvp.landscape.consult.ConsultFragment4x2;
import com.yd.android_brand_mvp.landscape.consult.ConsultFragment4x4;
import com.yd.android_brand_mvp.landscape.consult.ConsultFragmentP2x2;
import com.yd.android_brand_mvp.landscape.consult.ConsultFragmentP6x2;
import com.yd.android_brand_mvp.landscape.custom.CustomBannerFragment;
import com.yd.android_brand_mvp.landscape.custom.CustomImageText2Fragment;
import com.yd.android_brand_mvp.landscape.custom.CustomImageText3Fragment;
import com.yd.android_brand_mvp.landscape.custom.CustomImageText4Fragment;
import com.yd.android_brand_mvp.landscape.custom.CustomImageTextFragment;
import com.yd.android_brand_mvp.landscape.custom.CustomRecyclerviewFragment;
import com.yd.android_brand_mvp.landscape.custom.CustomTextFragment;
import com.yd.android_brand_mvp.landscape.customized.tianjin.CustomHomeFragment;
import com.yd.android_brand_mvp.landscape.customized.tianjin.CustomizedRecyclerviewFragment;
import com.yd.android_brand_mvp.landscape.customized.tianjin.CustomizedTextFragment;
import com.yd.android_brand_mvp.landscape.dormitory.DormitoryEducationFragment;
import com.yd.android_brand_mvp.landscape.dormitory.DormitoryFragment2x6;
import com.yd.android_brand_mvp.landscape.dormitory.DormitoryFragment4x6;
import com.yd.android_brand_mvp.landscape.duty.DutyFragment2x2;
import com.yd.android_brand_mvp.landscape.duty.DutyFragment2x3;
import com.yd.android_brand_mvp.landscape.evaluation.EvaluationFragment;
import com.yd.android_brand_mvp.landscape.evaluation.EvaluationFragmentP4x4;
import com.yd.android_brand_mvp.landscape.exam.ExamArrangement24Fragment;
import com.yd.android_brand_mvp.landscape.exam.ExamArrangement44Fragment;
import com.yd.android_brand_mvp.landscape.exam.ExamArrangement66Fragment;
import com.yd.android_brand_mvp.landscape.honor.HonorFragment;
import com.yd.android_brand_mvp.landscape.ipad.Ipad_10_Fragment;
import com.yd.android_brand_mvp.landscape.library.LibraryFragment2x2;
import com.yd.android_brand_mvp.landscape.library.LibraryFragment4x4;
import com.yd.android_brand_mvp.landscape.message.AnnouncementFragment2_4L;
import com.yd.android_brand_mvp.landscape.message.AnnouncementFragment4_4L;
import com.yd.android_brand_mvp.landscape.message.MessageFragment;
import com.yd.android_brand_mvp.landscape.message.MessageHomeFragment;
import com.yd.android_brand_mvp.landscape.message.NoticeTemplateFragment;
import com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment241;
import com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment242;
import com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment26;
import com.yd.android_brand_mvp.landscape.patrol.HomePatrolFragment;
import com.yd.android_brand_mvp.landscape.repair.HomeRepair21Fragment;
import com.yd.android_brand_mvp.landscape.repair.HomeRepair22Fragment;
import com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment;
import com.yd.android_brand_mvp.landscape.reserve.HomeReservation44Fragment;
import com.yd.android_brand_mvp.landscape.reserve.HomeReservationFragment;
import com.yd.android_brand_mvp.landscape.site.SiteInfo46Fragment;
import com.yd.android_brand_mvp.landscape.site.SiteInfo66Fragment;
import com.yd.android_brand_mvp.landscape.site.SiteInfo68Fragment;
import com.yd.android_brand_mvp.landscape.site.SiteInfo86Fragment;
import com.yd.android_brand_mvp.landscape.site.UniversitySiteInfoFragment;
import com.yd.android_brand_mvp.landscape.task.PunchFragment;
import com.yd.android_brand_mvp.landscape.university.UniversityDateFragment;
import com.yd.android_brand_mvp.landscape.university.UniversityDrakTableFragment;
import com.yd.android_brand_mvp.landscape.university.UniversityInternetFragment;
import com.yd.android_brand_mvp.landscape.university.UniversityNextReservationFragment;
import com.yd.android_brand_mvp.landscape.university.UniversityNextTableFragment;
import com.yd.android_brand_mvp.landscape.university.UniversityReservationFragment;
import com.yd.android_brand_mvp.landscape.university.UniversityTableFragment;
import com.yd.android_brand_mvp.landscape.university.UniversityTrainingDeviceFragment;
import com.yd.android_brand_mvp.landscape.university.music.UniversityMusicFragment;
import com.yd.android_brand_mvp.landscape.video.VideoFragment;
import com.yd.android_brand_mvp.landscape.vote.HomeVote23Fragment;
import com.yd.android_brand_mvp.model.LayoutListRsp;
import com.yd.android_brand_mvp.model.custom.CustomJsonGroupBean;
import com.yd.android_brand_mvp.model.custom.CustomJsonParamBean;
import com.yd.android_brand_mvp.portrait.fragment.AnnouncementFragment4_2P;
import com.yd.android_brand_mvp.portrait.fragment.AnnouncementFragment6_3P;
import com.yd.android_brand_mvp.portrait.fragment.ClassInfoFragment2_1_1P;
import com.yd.android_brand_mvp.portrait.fragment.ClassInfoFragment2_2P;
import com.yd.android_brand_mvp.portrait.fragment.ClassInfoFragment4_1_1P;
import com.yd.android_brand_mvp.portrait.fragment.ClassScheduleFragment6_3P2;
import com.yd.android_brand_mvp.portrait.fragment.KBBJFragment6_6;
import com.yd.android_brand_mvp.portrait.fragment.KBCDFragment6_6;
import com.yd.android_brand_mvp.portrait.fragment.StudentCenter2_1P;
import com.yd.android_brand_mvp.portrait.fragment.StudentCenter2_2P;
import com.yd.android_brand_mvp.portrait.fragment.StudentDutyFragment4_1P;
import com.yd.android_brand_mvp.portrait.fragment.TimerFragment2x1P;
import com.yd.android_brand_mvp.portrait.fragment.TimerFragment_2_1P;
import com.yd.android_brand_mvp.portrait.fragment.WeatherFragment_2_1P;
import com.yd.android_brand_mvp.portrait.fragment.WeatherFragment_4_1P;
import com.yd.android_brand_mvp.utils.LayoutUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.apache.mina.proxy.handlers.socks.SocksProxyConstants;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.objenesis.instantiator.util.ClassDefinitionUtils;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: loaded from: classes4.dex */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.frame)
    FrameLayout frame;
    String homeindex;
    int[] ids = {R.id.module1, R.id.module2, R.id.module3, R.id.module4, R.id.module5, R.id.module6, R.id.module7, R.id.module8, R.id.module9, R.id.module10, R.id.module11, R.id.module12, R.id.module13};

    @BindView(R.id.mu)
    MultiStateView mu;
    LayoutListRsp rsp;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.homeindex = getArguments().getString("HomeInfo");
        this.rsp = SpData.HomeIndexData();
        Log.i("TAG", "homeindex: " + this.homeindex);
        ButterKnife.bind(this, view);
        SetHomeData();
    }

    void SetHomeData() {
        if (this.rsp.data == null || this.rsp.data.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.rsp.data.size(); i++) {
            LayoutListRsp.DataBean dataBean = this.rsp.data.get(i);
            if (TextUtils.isEmpty(dataBean.pagination) || TextUtils.isEmpty(this.homeindex)) {
                return;
            }
            if (dataBean.pagination.equals(this.homeindex)) {
                initHome(dataBean.layoutClassSignDetailsEntityList, i);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:902:0x0e1e  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    Fragment fragment(LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean layoutClassSignDetailsEntityListBean, int i) {
        byte b;
        if (layoutClassSignDetailsEntityListBean == null) {
            return null;
        }
        String str = layoutClassSignDetailsEntityListBean.url;
        String str2 = layoutClassSignDetailsEntityListBean.descriptive;
        ArrayList<String> arrayList = new ArrayList<>();
        if (layoutClassSignDetailsEntityListBean.imagesList != null) {
            arrayList = Lists.newArrayList(layoutClassSignDetailsEntityListBean.imagesList);
        }
        ArrayList<String> arrayList2 = arrayList;
        int i2 = layoutClassSignDetailsEntityListBean.secPageBackTime;
        String str3 = layoutClassSignDetailsEntityListBean.imgType;
        String str4 = layoutClassSignDetailsEntityListBean.images;
        String string = layoutClassSignDetailsEntityListBean.tag;
        String str5 = layoutClassSignDetailsEntityListBean.moduleId;
        if (!TextUtils.isEmpty(string) && string.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            String[] strArrSplit = string.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < strArrSplit.length; i3++) {
                if (i3 == 0 || i3 == 2) {
                    sb.append(strArrSplit[i3]);
                }
            }
            string = sb.toString();
        }
        String str6 = string;
        Log.i("fragment", str6 + " time: " + i2);
        switch (str6.hashCode()) {
            case -2135483144:
                if (str6.equals("hbdztsg22")) {
                    b = 28;
                } else {
                    b = -1;
                }
                break;
            case -2020176646:
                if (str6.equals("hbxjxc441")) {
                    b = 236;
                } else {
                    b = -1;
                }
                break;
            case -1961339230:
                if (str6.equals("hbxlyy2x6")) {
                    b = 5;
                } else {
                    b = -1;
                }
                break;
            case -1961337312:
                if (str6.equals("hbxlyy4x2")) {
                    b = 6;
                } else {
                    b = -1;
                }
                break;
            case -1961337310:
                if (str6.equals("hbxlyy4x4")) {
                    b = 7;
                } else {
                    b = -1;
                }
                break;
            case -1950786647:
                if (str6.equals("hbtsgrm431")) {
                    b = 260;
                } else {
                    b = -1;
                }
                break;
            case -1950786646:
                if (str6.equals("hbtsgrm432")) {
                    b = 259;
                } else {
                    b = -1;
                }
                break;
            case -1945066775:
                if (str6.equals("hbtsgxs431")) {
                    b = 264;
                } else {
                    b = -1;
                }
                break;
            case -1945066774:
                if (str6.equals("hbtsgxs432")) {
                    b = 263;
                } else {
                    b = -1;
                }
                break;
            case -1934290538:
                if (str6.equals("sbhdbm2x2")) {
                    b = 18;
                } else {
                    b = -1;
                }
                break;
            case -1934290536:
                if (str6.equals("sbhdbm2x4")) {
                    b = 20;
                } else {
                    b = -1;
                }
                break;
            case -1934288614:
                if (str6.equals("sbhdbm4x4")) {
                    b = 22;
                } else {
                    b = -1;
                }
                break;
            case -1752141582:
                if (str6.equals("sbbjsp42")) {
                    b = ComByteManager.ISO15693_CMD;
                } else {
                    b = -1;
                }
                break;
            case -1752141519:
                if (str6.equals("sbbjsp63")) {
                    b = 231;
                } else {
                    b = -1;
                }
                break;
            case -1752005120:
                if (str6.equals("sbbjxc42")) {
                    b = 237;
                } else {
                    b = -1;
                }
                break;
            case -1752005057:
                if (str6.equals("sbbjxc63")) {
                    b = 239;
                } else {
                    b = -1;
                }
                break;
            case -1751985002:
                if (str6.equals("sbbjxx21")) {
                    b = 182;
                } else {
                    b = -1;
                }
                break;
            case -1751985001:
                if (str6.equals("sbbjxx22")) {
                    b = 179;
                } else {
                    b = -1;
                }
                break;
            case -1751984940:
                if (str6.equals("sbbjxx41")) {
                    b = ClassDefinitionUtils.OPS_invokespecial;
                } else {
                    b = -1;
                }
                break;
            case -1751984877:
                if (str6.equals("sbbjxx62")) {
                    b = 180;
                } else {
                    b = -1;
                }
                break;
            case -1729305276:
                if (str6.equals("sbcdkb63")) {
                    b = 173;
                } else {
                    b = -1;
                }
                break;
            case -1729305273:
                if (str6.equals("sbcdkb66")) {
                    b = 164;
                } else {
                    b = -1;
                }
                break;
            case -1728909469:
                if (str6.equals("sbcdxk22")) {
                    b = SDKKeyboardCode.FUNCTION_KEY_BOARD_PLUS;
                } else {
                    b = -1;
                }
                break;
            case -1728908508:
                if (str6.equals("sbcdxl22")) {
                    b = SDKKeyboardCode.FUNCTION_KEY_BOARD_LEFT_SQUARE_BRACKET;
                } else {
                    b = -1;
                }
                break;
            case -1728896977:
                if (str6.equals("sbcdxx21")) {
                    b = 64;
                } else {
                    b = -1;
                }
                break;
            case -1728896976:
                if (str6.equals("sbcdxx22")) {
                    b = 65;
                } else {
                    b = -1;
                }
                break;
            case -1728896915:
                if (str6.equals("sbcdxx41")) {
                    b = 66;
                } else {
                    b = -1;
                }
                break;
            case -1728896911:
                if (str6.equals("sbcdxx45")) {
                    b = SDKKeyboardCode.FUNCTION_KEY_BOARD_CAPS_LOCK;
                } else {
                    b = -1;
                }
                break;
            case -1728896846:
                if (str6.equals("sbcdxx68")) {
                    b = SDKKeyboardCode.FUNCTION_KEY_BOARD_F2;
                } else {
                    b = -1;
                }
                break;
            case -1728866224:
                if (str6.equals("sbcdyy22")) {
                    b = Command.COMM_GET_ALARM_ERRCORD_OR_OPERATION_FINISHED;
                } else {
                    b = -1;
                }
                break;
            case -1728866099:
                if (str6.equals("sbcdyy63")) {
                    b = 89;
                } else {
                    b = -1;
                }
                break;
            case -1681125600:
                if (str6.equals("sbdypj46")) {
                    b = 288;
                } else {
                    b = -1;
                }
                break;
            case -1552888746:
                if (str6.equals("hbtable24")) {
                    b = 98;
                } else {
                    b = -1;
                }
                break;
            case -1552888744:
                if (str6.equals("hbtable26")) {
                    b = 97;
                } else {
                    b = -1;
                }
                break;
            case -1505986659:
                if (str6.equals("hbsite__drak26")) {
                    b = 63;
                } else {
                    b = -1;
                }
                break;
            case -1486528869:
                if (str6.equals("sbksgl43")) {
                    b = 95;
                } else {
                    b = -1;
                }
                break;
            case -1486528807:
                if (str6.equals("sbksgl63")) {
                    b = SocksProxyConstants.V4_REPLY_REQUEST_FAILED_ID_NOT_CONFIRMED;
                } else {
                    b = -1;
                }
                break;
            case -1486528804:
                if (str6.equals("sbksgl66")) {
                    b = 91;
                } else {
                    b = -1;
                }
                break;
            case -1412046043:
                if (str6.equals("hbaifull8x6")) {
                    b = 1;
                } else {
                    b = -1;
                }
                break;
            case -1343620515:
                if (str6.equals("hbtzggmb4x6")) {
                    b = 23;
                } else {
                    b = -1;
                }
                break;
            case -1337145237:
                if (str6.equals("sbxxfbgg44")) {
                    b = 104;
                } else {
                    b = -1;
                }
                break;
            case -1337120315:
                if (str6.equals("sbxxfbhb22")) {
                    b = 106;
                } else {
                    b = -1;
                }
                break;
            case -1336772433:
                if (str6.equals("sbxxfbsw22")) {
                    b = 107;
                } else {
                    b = -1;
                }
                break;
            case -1336650386:
                if (str6.equals("sbxxfbwz22")) {
                    b = 105;
                } else {
                    b = -1;
                }
                break;
            case -1336623416:
                if (str6.equals("sbxxfbxw42")) {
                    b = Command.COMM_LAMP;
                } else {
                    b = -1;
                }
                break;
            case -1336623354:
                if (str6.equals("sbxxfbxw62")) {
                    b = Command.COMM_CONFIGURE_PASSAGE_MODE;
                } else {
                    b = -1;
                }
                break;
            case -1336621494:
                if (str6.equals("sbxxfbxy42")) {
                    b = 108;
                } else {
                    b = -1;
                }
                break;
            case -1313892851:
                if (str6.equals("hbtimer24")) {
                    b = 190;
                } else {
                    b = -1;
                }
                break;
            case -1257572539:
                if (str6.equals("sbssdy45")) {
                    b = 39;
                } else {
                    b = -1;
                }
                break;
            case -1231615033:
                if (str6.equals("sbtphd22")) {
                    b = 73;
                } else {
                    b = -1;
                }
                break;
            case -1228922310:
                if (str6.equals("sbtsg223")) {
                    b = 273;
                } else {
                    b = -1;
                }
                break;
            case -1228920326:
                if (str6.equals("sbtsg443")) {
                    b = 269;
                } else {
                    b = -1;
                }
                break;
            case -1228920266:
                if (str6.equals("sbtsg461")) {
                    b = 258;
                } else {
                    b = -1;
                }
                break;
            case -1228920265:
                if (str6.equals("sbtsg462")) {
                    b = 257;
                } else {
                    b = -1;
                }
                break;
            case -1228918435:
                if (str6.equals("sbtsg633")) {
                    b = 270;
                } else {
                    b = -1;
                }
                break;
            case -1228918342:
                if (str6.equals("sbtsg663")) {
                    b = 271;
                } else {
                    b = -1;
                }
                break;
            case -1223994097:
                if (str6.equals("hbbx21")) {
                    b = 289;
                } else {
                    b = -1;
                }
                break;
            case -1223994096:
                if (str6.equals("hbbx22")) {
                    b = 292;
                } else {
                    b = -1;
                }
                break;
            case -1223947007:
                if (str6.equals("hbdk22")) {
                    b = Mifare.PHAL_MFC_CMD_WRITE;
                } else {
                    b = -1;
                }
                break;
            case -1223947006:
                if (str6.equals("hbdk23")) {
                    b = 161;
                } else {
                    b = -1;
                }
                break;
            case -1223814294:
                if (str6.equals("hbhy54")) {
                    b = Command.COMM_SET_ADMIN_KEYBOARD_PWD;
                } else {
                    b = -1;
                }
                break;
            case -1223747117:
                if (str6.equals("hbkb24")) {
                    b = 166;
                } else {
                    b = -1;
                }
                break;
            case -1223747055:
                if (str6.equals("hbkb44")) {
                    b = 165;
                } else {
                    b = -1;
                }
                break;
            case -1223732704:
                if (str6.equals("hbkq22")) {
                    b = 212;
                } else {
                    b = -1;
                }
                break;
            case -1223501102:
                if (str6.equals("hbsj23")) {
                    b = ErrorCode.LOCK_USER_TIME_INEFFECTIVE;
                } else {
                    b = -1;
                }
                break;
            case -1223379955:
                if (str6.equals("hbwl42")) {
                    b = 78;
                } else {
                    b = -1;
                }
                break;
            case -1223379924:
                if (str6.equals("hbwl52")) {
                    b = 80;
                } else {
                    b = -1;
                }
                break;
            case -1223350223:
                if (str6.equals("hbxl25")) {
                    b = 276;
                } else {
                    b = -1;
                }
                break;
            case -1223350191:
                if (str6.equals("hbxl36")) {
                    b = 51;
                } else {
                    b = -1;
                }
                break;
            case -1223350163:
                if (str6.equals("hbxl43")) {
                    b = 278;
                } else {
                    b = -1;
                }
                break;
            case -1223350162:
                if (str6.equals("hbxl44")) {
                    b = 277;
                } else {
                    b = -1;
                }
                break;
            case -1223286798:
                if (str6.equals("hbzp24")) {
                    b = 216;
                } else {
                    b = -1;
                }
                break;
            case -1223286736:
                if (str6.equals("hbzp44")) {
                    b = 218;
                } else {
                    b = -1;
                }
                break;
            case -1223286734:
                if (str6.equals("hbzp46")) {
                    b = 219;
                } else {
                    b = -1;
                }
                break;
            case -1223284878:
                if (str6.equals("hbzr22")) {
                    b = Mifare.PHAL_MFC_CMD_DECREMENT;
                } else {
                    b = -1;
                }
                break;
            case -1223284877:
                if (str6.equals("hbzr23")) {
                    b = 195;
                } else {
                    b = -1;
                }
                break;
            case -1223278150:
                if (str6.equals("hbzy23")) {
                    b = 223;
                } else {
                    b = -1;
                }
                break;
            case -1223278149:
                if (str6.equals("hbzy24")) {
                    b = 221;
                } else {
                    b = -1;
                }
                break;
            case -1222406669:
                if (str6.equals("sbtzgg42")) {
                    b = 202;
                } else {
                    b = -1;
                }
                break;
            case -1222406666:
                if (str6.equals("sbtzgg45")) {
                    b = 200;
                } else {
                    b = -1;
                }
                break;
            case -1222406606:
                if (str6.equals("sbtzgg63")) {
                    b = 201;
                } else {
                    b = -1;
                }
                break;
            case -1149311149:
                if (str6.equals("sbwlkz22")) {
                    b = 275;
                } else {
                    b = -1;
                }
                break;
            case -1148670545:
                if (str6.equals("hbyjfx2x2")) {
                    b = 3;
                } else {
                    b = -1;
                }
                break;
            case -1122300260:
                if (str6.equals("sbxjsp42")) {
                    b = 230;
                } else {
                    b = -1;
                }
                break;
            case -1122300197:
                if (str6.equals("sbxjsp63")) {
                    b = 232;
                } else {
                    b = -1;
                }
                break;
            case -1122163798:
                if (str6.equals("sbxjxc42")) {
                    b = 238;
                } else {
                    b = -1;
                }
                break;
            case -1122163735:
                if (str6.equals("sbxjxc63")) {
                    b = ComByteManager.GET_SUICA_BALANCE_COM;
                } else {
                    b = -1;
                }
                break;
            case -1114083708:
                if (str6.equals("sbxspj44")) {
                    b = 26;
                } else {
                    b = -1;
                }
                break;
            case -1114083647:
                if (str6.equals("sbxspj63")) {
                    b = 119;
                } else {
                    b = -1;
                }
                break;
            case -1109771635:
                if (str6.equals("sbxxfb68")) {
                    b = Command.COMM_GET_ADMIN_CODE;
                } else {
                    b = -1;
                }
                break;
            case -924414392:
                if (str6.equals("hbkb_sk24")) {
                    b = 168;
                } else {
                    b = -1;
                }
                break;
            case -924414330:
                if (str6.equals("hbkb_sk44")) {
                    b = 167;
                } else {
                    b = -1;
                }
                break;
            case -909073436:
                if (str6.equals("sbbx21")) {
                    b = 290;
                } else {
                    b = -1;
                }
                break;
            case -909073435:
                if (str6.equals("sbbx22")) {
                    b = 291;
                } else {
                    b = -1;
                }
                break;
            case -909026347:
                if (str6.equals("sbdk21")) {
                    b = 162;
                } else {
                    b = -1;
                }
                break;
            case -908826458:
                if (str6.equals("sbkb22")) {
                    b = 170;
                } else {
                    b = -1;
                }
                break;
            case -908826396:
                if (str6.equals("sbkb42")) {
                    b = 171;
                } else {
                    b = -1;
                }
                break;
            case -908826333:
                if (str6.equals("sbkb63")) {
                    b = 172;
                } else {
                    b = -1;
                }
                break;
            case -908818771:
                if (str6.equals("sbkj21")) {
                    b = 207;
                } else {
                    b = -1;
                }
                break;
            case -908818770:
                if (str6.equals("sbkj22")) {
                    b = ComByteManager.ULTRALIGHT_LONG_READ;
                } else {
                    b = -1;
                }
                break;
            case -908818709:
                if (str6.equals("sbkj41")) {
                    b = ComByteManager.ULTRALIGHT_CMD;
                } else {
                    b = -1;
                }
                break;
            case -908812043:
                if (str6.equals("sbkq22")) {
                    b = 211;
                } else {
                    b = -1;
                }
                break;
            case -908811982:
                if (str6.equals("sbkq41")) {
                    b = 214;
                } else {
                    b = -1;
                }
                break;
            case -908811981:
                if (str6.equals("sbkq42")) {
                    b = 215;
                } else {
                    b = -1;
                }
                break;
            case -908580443:
                if (str6.equals("sbsj21")) {
                    b = 248;
                } else {
                    b = -1;
                }
                break;
            case -908543925:
                if (str6.equals("sbtq21")) {
                    b = 246;
                } else {
                    b = -1;
                }
                break;
            case -908543863:
                if (str6.equals("sbtq41")) {
                    b = 247;
                } else {
                    b = -1;
                }
                break;
            case -908429503:
                if (str6.equals("sbxl42")) {
                    b = 280;
                } else {
                    b = -1;
                }
                break;
            case -908429500:
                if (str6.equals("sbxl45")) {
                    b = 281;
                } else {
                    b = -1;
                }
                break;
            case -908429440:
                if (str6.equals("sbxl63")) {
                    b = 282;
                } else {
                    b = -1;
                }
                break;
            case -908366077:
                if (str6.equals("sbzp42")) {
                    b = 217;
                } else {
                    b = -1;
                }
                break;
            case -908366014:
                if (str6.equals("sbzp63")) {
                    b = 220;
                } else {
                    b = -1;
                }
                break;
            case -908364218:
                if (str6.equals("sbzr21")) {
                    b = Mifare.PHAL_MFC_CMD_INCREMENT;
                } else {
                    b = -1;
                }
                break;
            case -908364217:
                if (str6.equals("sbzr22")) {
                    b = 198;
                } else {
                    b = -1;
                }
                break;
            case -908364156:
                if (str6.equals("sbzr41")) {
                    b = 196;
                } else {
                    b = -1;
                }
                break;
            case -908364155:
                if (str6.equals("sbzr42")) {
                    b = 197;
                } else {
                    b = -1;
                }
                break;
            case -908357490:
                if (str6.equals("sbzy22")) {
                    b = 222;
                } else {
                    b = -1;
                }
                break;
            case -892953215:
                if (str6.equals("sbbjxxfdy41")) {
                    b = 185;
                } else {
                    b = -1;
                }
                break;
            case -892953152:
                if (str6.equals("sbbjxxfdy62")) {
                    b = 181;
                } else {
                    b = -1;
                }
                break;
            case -876669070:
                if (str6.equals("sbbjxxwxm41")) {
                    b = 184;
                } else {
                    b = -1;
                }
                break;
            case -749632370:
                if (str6.equals("hb_ipad_10_86")) {
                    b = 49;
                } else {
                    b = -1;
                }
                break;
            case -715940620:
                if (str6.equals("hbtjcustom8x5")) {
                    b = 0;
                } else {
                    b = -1;
                }
                break;
            case -702970647:
                if (str6.equals("zhhb23")) {
                    b = 42;
                } else {
                    b = -1;
                }
                break;
            case -702970584:
                if (str6.equals("zhhb44")) {
                    b = 43;
                } else {
                    b = -1;
                }
                break;
            case -645960500:
                if (str6.equals("hbxl_machine_36")) {
                    b = 50;
                } else {
                    b = -1;
                }
                break;
            case -575286061:
                if (str6.equals("sbdypj441")) {
                    b = 284;
                } else {
                    b = -1;
                }
                break;
            case -575286060:
                if (str6.equals("sbdypj442")) {
                    b = 286;
                } else {
                    b = -1;
                }
                break;
            case -525938328:
                if (str6.equals("hbchemistry86")) {
                    b = 48;
                } else {
                    b = -1;
                }
                break;
            case -415298058:
                if (str6.equals("hbzdyyz22")) {
                    b = 126;
                } else {
                    b = -1;
                }
                break;
            case -368501847:
                if (str6.equals("sbxlyy2x2")) {
                    b = 9;
                } else {
                    b = -1;
                }
                break;
            case -368499923:
                if (str6.equals("sbxlyy4x4")) {
                    b = 8;
                } else {
                    b = -1;
                }
                break;
            case -368498003:
                if (str6.equals("sbxlyy6x2")) {
                    b = 10;
                } else {
                    b = -1;
                }
                break;
            case -352557435:
                if (str6.equals("hbwl_machine_52")) {
                    b = SDKKeyboardCode.FUNCTION_KEY_BOARD_RIGHT;
                } else {
                    b = -1;
                }
                break;
            case -304147606:
                if (str6.equals("hbsxsb_drak23")) {
                    b = 54;
                } else {
                    b = -1;
                }
                break;
            case -224813724:
                if (str6.equals("hbreservation_machine_54")) {
                    b = 82;
                } else {
                    b = -1;
                }
                break;
            case -70421148:
                if (str6.equals("hbbjxc441")) {
                    b = 235;
                } else {
                    b = -1;
                }
                break;
            case -41761717:
                if (str6.equals("hblibrary2x2")) {
                    b = 11;
                } else {
                    b = -1;
                }
                break;
            case -41759793:
                if (str6.equals("hblibrary4x4")) {
                    b = 13;
                } else {
                    b = -1;
                }
                break;
            case -41759791:
                if (str6.equals("hblibrary4x6")) {
                    b = 14;
                } else {
                    b = -1;
                }
                break;
            case 182532094:
                if (str6.equals("sbtsgrm431")) {
                    b = 262;
                } else {
                    b = -1;
                }
                break;
            case 182532095:
                if (str6.equals("sbtsgrm432")) {
                    b = 261;
                } else {
                    b = -1;
                }
                break;
            case 188251966:
                if (str6.equals("sbtsgxs431")) {
                    b = 266;
                } else {
                    b = -1;
                }
                break;
            case 188251967:
                if (str6.equals("sbtsgxs432")) {
                    b = 265;
                } else {
                    b = -1;
                }
                break;
            case 274481575:
                if (str6.equals("hbkb_drak23")) {
                    b = 53;
                } else {
                    b = -1;
                }
                break;
            case 296323568:
                if (str6.equals("sbaifull6x8")) {
                    b = 2;
                } else {
                    b = -1;
                }
                break;
            case 364752934:
                if (str6.equals("sbtzggmb6x2")) {
                    b = 25;
                } else {
                    b = -1;
                }
                break;
            case 364752936:
                if (str6.equals("sbtzggmb6x4")) {
                    b = 24;
                } else {
                    b = -1;
                }
                break;
            case 385250818:
                if (str6.equals("dxhbxl44")) {
                    b = 279;
                } else {
                    b = -1;
                }
                break;
            case 439408794:
                if (str6.equals("hbqdThird22")) {
                    b = 30;
                } else {
                    b = -1;
                }
                break;
            case 444166842:
                if (str6.equals("sbyjfx2x2")) {
                    b = 4;
                } else {
                    b = -1;
                }
                break;
            case 551781152:
                if (str6.equals("hbbjsp23")) {
                    b = ComByteManager.ISO15693_WRITE_SINGLE_BLOCK_COM;
                } else {
                    b = -1;
                }
                break;
            case 551781215:
                if (str6.equals("hbbjsp44")) {
                    b = ComByteManager.ISO15693_READ_SINGLE_BLOCK_COM;
                } else {
                    b = -1;
                }
                break;
            case 551917614:
                if (str6.equals("hbbjxc23")) {
                    b = ComByteManager.FELICA_READ_COM;
                } else {
                    b = -1;
                }
                break;
            case 551917677:
                if (str6.equals("hbbjxc44")) {
                    b = 233;
                } else {
                    b = -1;
                }
                break;
            case 551917679:
                if (str6.equals("hbbjxc46")) {
                    b = 245;
                } else {
                    b = -1;
                }
                break;
            case 551931129:
                if (str6.equals("hbbjxq42")) {
                    b = 40;
                } else {
                    b = -1;
                }
                break;
            case 551937793:
                if (str6.equals("hbbjxx21")) {
                    b = 186;
                } else {
                    b = -1;
                }
                break;
            case 551937794:
                if (str6.equals("hbbjxx22")) {
                    b = 174;
                } else {
                    b = -1;
                }
                break;
            case 551937796:
                if (str6.equals("hbbjxx24")) {
                    b = ClassDefinitionUtils.OPS_return;
                } else {
                    b = -1;
                }
                break;
            case 551937984:
                if (str6.equals("hbbjxx86")) {
                    b = 29;
                } else {
                    b = -1;
                }
                break;
            case 574617458:
                if (str6.equals("hbcdkb44")) {
                    b = 169;
                } else {
                    b = -1;
                }
                break;
            case 574617522:
                if (str6.equals("hbcdkb66")) {
                    b = 163;
                } else {
                    b = -1;
                }
                break;
            case 575013326:
                if (str6.equals("hbcdxk22")) {
                    b = 44;
                } else {
                    b = -1;
                }
                break;
            case 575014287:
                if (str6.equals("hbcdxl22")) {
                    b = SDKKeyboardCode.FUNCTION_KEY_BOARD_MINUS;
                } else {
                    b = -1;
                }
                break;
            case 575025818:
                if (str6.equals("hbcdxx21")) {
                    b = 67;
                } else {
                    b = -1;
                }
                break;
            case 575025819:
                if (str6.equals("hbcdxx22")) {
                    b = 68;
                } else {
                    b = -1;
                }
                break;
            case 575025821:
                if (str6.equals("hbcdxx24")) {
                    b = 69;
                } else {
                    b = -1;
                }
                break;
            case 575025823:
                if (str6.equals("hbcdxx26")) {
                    b = 71;
                } else {
                    b = -1;
                }
                break;
            case 575025881:
                if (str6.equals("hbcdxx42")) {
                    b = 70;
                } else {
                    b = -1;
                }
                break;
            case 575025885:
                if (str6.equals("hbcdxx46")) {
                    b = SDKKeyboardCode.FUNCTION_KEY_BOARD_LEFT_SLASH;
                } else {
                    b = -1;
                }
                break;
            case 575025947:
                if (str6.equals("hbcdxx66")) {
                    b = 60;
                } else {
                    b = -1;
                }
                break;
            case 575026009:
                if (str6.equals("hbcdxx86")) {
                    b = 61;
                } else {
                    b = -1;
                }
                break;
            case 575056571:
                if (str6.equals("hbcdyy22")) {
                    b = Command.COMM_ADD_ADMIN;
                } else {
                    b = -1;
                }
                break;
            case 575056635:
                if (str6.equals("hbcdyy44")) {
                    b = Command.COMM_FUNCTION_LOCK;
                } else {
                    b = -1;
                }
                break;
            case 608979870:
                if (str6.equals("hbdjs221")) {
                    b = ClassDefinitionUtils.OPS_new;
                } else {
                    b = -1;
                }
                break;
            case 622797133:
                if (str6.equals("hbdypj26")) {
                    b = 287;
                } else {
                    b = -1;
                }
                break;
            case 712381172:
                if (str6.equals("hbdjs23")) {
                    b = PSSSigner.TRAILER_IMPLICIT;
                } else {
                    b = -1;
                }
                break;
            case 718991889:
                if (str6.equals("hbkq221")) {
                    b = 213;
                } else {
                    b = -1;
                }
                break;
            case 725755408:
                if (str6.equals("hbryq22")) {
                    b = 125;
                } else {
                    b = -1;
                }
                break;
            case 725755409:
                if (str6.equals("hbryq23")) {
                    b = ComByteManager.CHANGE_BLE_NAME_COM;
                } else {
                    b = -1;
                }
                break;
            case 725755410:
                if (str6.equals("hbryq24")) {
                    b = ComByteManager.ANDROID_FAST_PARAMS_COM;
                } else {
                    b = -1;
                }
                break;
            case 726171489:
                if (str6.equals("hbsj211")) {
                    b = 249;
                } else {
                    b = -1;
                }
                break;
            case 726171490:
                if (str6.equals("hbsj212")) {
                    b = 251;
                } else {
                    b = -1;
                }
                break;
            case 726171491:
                if (str6.equals("hbsj213")) {
                    b = ErrorCode.LOCK_USER_TIME_EXPIRED;
                } else {
                    b = -1;
                }
                break;
            case 726217649:
                if (str6.equals("hbsjb22")) {
                    b = SDKKeyboardCode.FUNCTION_KEY_BOARD_HOME;
                } else {
                    b = -1;
                }
                break;
            case 726217650:
                if (str6.equals("hbsjb23")) {
                    b = 76;
                } else {
                    b = -1;
                }
                break;
            case 727414093:
                if (str6.equals("hbtsg21")) {
                    b = 253;
                } else {
                    b = -1;
                }
                break;
            case 732525652:
                if (str6.equals("hbzdy21")) {
                    b = 128;
                } else {
                    b = -1;
                }
                break;
            case 732525653:
                if (str6.equals("hbzdy22")) {
                    b = 129;
                } else {
                    b = -1;
                }
                break;
            case 732525654:
                if (str6.equals("hbzdy23")) {
                    b = 130;
                } else {
                    b = -1;
                }
                break;
            case 732525655:
                if (str6.equals("hbzdy24")) {
                    b = 131;
                } else {
                    b = -1;
                }
                break;
            case 732525656:
                if (str6.equals("hbzdy25")) {
                    b = 132;
                } else {
                    b = -1;
                }
                break;
            case 732525657:
                if (str6.equals("hbzdy26")) {
                    b = 133;
                } else {
                    b = -1;
                }
                break;
            case 732525683:
                if (str6.equals("hbzdy31")) {
                    b = 134;
                } else {
                    b = -1;
                }
                break;
            case 732525684:
                if (str6.equals("hbzdy32")) {
                    b = 135;
                } else {
                    b = -1;
                }
                break;
            case 732525688:
                if (str6.equals("hbzdy36")) {
                    b = 136;
                } else {
                    b = -1;
                }
                break;
            case 732525714:
                if (str6.equals("hbzdy41")) {
                    b = 137;
                } else {
                    b = -1;
                }
                break;
            case 732525715:
                if (str6.equals("hbzdy42")) {
                    b = 138;
                } else {
                    b = -1;
                }
                break;
            case 732525716:
                if (str6.equals("hbzdy43")) {
                    b = 139;
                } else {
                    b = -1;
                }
                break;
            case 732525717:
                if (str6.equals("hbzdy44")) {
                    b = 140;
                } else {
                    b = -1;
                }
                break;
            case 732525719:
                if (str6.equals("hbzdy46")) {
                    b = 141;
                } else {
                    b = -1;
                }
                break;
            case 732525746:
                if (str6.equals("hbzdy52")) {
                    b = 142;
                } else {
                    b = -1;
                }
                break;
            case 732525748:
                if (str6.equals("hbzdy54")) {
                    b = 143;
                } else {
                    b = -1;
                }
                break;
            case 732525781:
                if (str6.equals("hbzdy66")) {
                    b = 144;
                } else {
                    b = -1;
                }
                break;
            case 732525843:
                if (str6.equals("hbzdy86")) {
                    b = ComByteManager.ISO7816_POWE_OFF_CMD;
                } else {
                    b = -1;
                }
                break;
            case 732874495:
                if (str6.equals("hbzr221")) {
                    b = Mifare.PHAL_MFC_CMD_RESTORE;
                } else {
                    b = -1;
                }
                break;
            case 732936961:
                if (str6.equals("hbzrs22")) {
                    b = 31;
                } else {
                    b = -1;
                }
                break;
            case 732936962:
                if (str6.equals("hbzrs23")) {
                    b = 33;
                } else {
                    b = -1;
                }
                break;
            case 732936963:
                if (str6.equals("hbzrs24")) {
                    b = 34;
                } else {
                    b = -1;
                }
                break;
            case 767839371:
                if (str6.equals("hbhdbm2x2")) {
                    b = 17;
                } else {
                    b = -1;
                }
                break;
            case 767839373:
                if (str6.equals("hbhdbm2x4")) {
                    b = 19;
                } else {
                    b = -1;
                }
                break;
            case 767841295:
                if (str6.equals("hbhdbm4x4")) {
                    b = 21;
                } else {
                    b = -1;
                }
                break;
            case 774075828:
                if (str6.equals("hbjcjj23")) {
                    b = ComByteManager.ISO15693_LOCK_BLOCK_COM;
                } else {
                    b = -1;
                }
                break;
            case 817393865:
                if (str6.equals("hbksgl24")) {
                    b = 94;
                } else {
                    b = -1;
                }
                break;
            case 817393927:
                if (str6.equals("hbksgl44")) {
                    b = 92;
                } else {
                    b = -1;
                }
                break;
            case 817393991:
                if (str6.equals("hbksgl66")) {
                    b = 90;
                } else {
                    b = -1;
                }
                break;
            case 824503256:
                if (str6.equals("hbxxfbgg24")) {
                    b = ComByteManager.APDU_COM;
                } else {
                    b = -1;
                }
                break;
            case 824503258:
                if (str6.equals("hbxxfbgg26")) {
                    b = ComByteManager.NUMBER_DISPLAY_COM;
                } else {
                    b = -1;
                }
                break;
            case 824528302:
                if (str6.equals("hbxxfbhb42")) {
                    b = ComByteManager.KEYBOARD_INPUT_COM;
                } else {
                    b = -1;
                }
                break;
            case 824876122:
                if (str6.equals("hbxxfbsw22")) {
                    b = ComByteManager.GET_VERSIONS_COM;
                } else {
                    b = -1;
                }
                break;
            case 824998169:
                if (str6.equals("hbxxfbwz22")) {
                    b = ComByteManager.GET_BT_VALUE_COM;
                } else {
                    b = -1;
                }
                break;
            case 825025079:
                if (str6.equals("hbxxfbxw24")) {
                    b = 110;
                } else {
                    b = -1;
                }
                break;
            case 825025141:
                if (str6.equals("hbxxfbxw44")) {
                    b = 109;
                } else {
                    b = -1;
                }
                break;
            case 825027061:
                if (str6.equals("hbxxfbxy42")) {
                    b = ComByteManager.BEEP_OPEN_COM;
                } else {
                    b = -1;
                }
                break;
            case 906823097:
                if (str6.equals("hbtzgg_kt_24")) {
                    b = 178;
                } else {
                    b = -1;
                }
                break;
            case 983425108:
                if (str6.equals("hbreservation24")) {
                    b = Command.COMM_RESPONSE;
                } else {
                    b = -1;
                }
                break;
            case 983425110:
                if (str6.equals("hbreservation26")) {
                    b = 81;
                } else {
                    b = -1;
                }
                break;
            case 983425170:
                if (str6.equals("hbreservation44")) {
                    b = Command.COMM_CHECK_USER_TIME;
                } else {
                    b = -1;
                }
                break;
            case 1038912053:
                if (str6.equals("hbskcd24")) {
                    b = 41;
                } else {
                    b = -1;
                }
                break;
            case 1046350195:
                if (str6.equals("hbssdy26")) {
                    b = 38;
                } else {
                    b = -1;
                }
                break;
            case 1046938327:
                if (str6.equals("hbssxq26")) {
                    b = 36;
                } else {
                    b = -1;
                }
                break;
            case 1046938389:
                if (str6.equals("hbssxq46")) {
                    b = 37;
                } else {
                    b = -1;
                }
                break;
            case 1065993093:
                if (str6.equals("hbtime42")) {
                    b = 99;
                } else {
                    b = -1;
                }
                break;
            case 1072307763:
                if (str6.equals("hbtphd23")) {
                    b = 72;
                } else {
                    b = -1;
                }
                break;
            case 1075000485:
                if (str6.equals("hbtsg223")) {
                    b = 272;
                } else {
                    b = -1;
                }
                break;
            case 1075002469:
                if (str6.equals("hbtsg443")) {
                    b = 267;
                } else {
                    b = -1;
                }
                break;
            case 1075002529:
                if (str6.equals("hbtsg461")) {
                    b = 256;
                } else {
                    b = -1;
                }
                break;
            case 1075002530:
                if (str6.equals("hbtsg462")) {
                    b = 255;
                } else {
                    b = -1;
                }
                break;
            case 1075002531:
                if (str6.equals("hbtsg463")) {
                    b = 268;
                } else {
                    b = -1;
                }
                break;
            case 1081516066:
                if (str6.equals("hbtzgg24")) {
                    b = 199;
                } else {
                    b = -1;
                }
                break;
            case 1081516067:
                if (str6.equals("hbtzgg25")) {
                    b = ComByteManager.BUTTON_INPUT_COM;
                } else {
                    b = -1;
                }
                break;
            case 1081516068:
                if (str6.equals("hbtzgg26")) {
                    b = 204;
                } else {
                    b = -1;
                }
                break;
            case 1081516128:
                if (str6.equals("hbtzgg44")) {
                    b = 203;
                } else {
                    b = -1;
                }
                break;
            case 1154611646:
                if (str6.equals("hbwlkz22")) {
                    b = 274;
                } else {
                    b = -1;
                }
                break;
            case 1177539329:
                if (str6.equals("sbzdyyz22")) {
                    b = 127;
                } else {
                    b = -1;
                }
                break;
            case 1181622474:
                if (str6.equals("hbxjsp23")) {
                    b = ComByteManager.ISO15693_WRITE_MULTIPLE_BLOCK_COM;
                } else {
                    b = -1;
                }
                break;
            case 1181622537:
                if (str6.equals("hbxjsp44")) {
                    b = ComByteManager.ISO15693_READ_MULTIPLE_BLOCK_COM;
                } else {
                    b = -1;
                }
                break;
            case 1181758936:
                if (str6.equals("hbxjxc23")) {
                    b = ComByteManager.FELICA_COM;
                } else {
                    b = -1;
                }
                break;
            case 1181758999:
                if (str6.equals("hbxjxc44")) {
                    b = 234;
                } else {
                    b = -1;
                }
                break;
            case 1181759001:
                if (str6.equals("hbxjxc46")) {
                    b = 244;
                } else {
                    b = -1;
                }
                break;
            case 1189690068:
                if (str6.equals("hbxskj22")) {
                    b = 205;
                } else {
                    b = -1;
                }
                break;
            case 1189690069:
                if (str6.equals("hbxskj23")) {
                    b = 206;
                } else {
                    b = -1;
                }
                break;
            case 1189839027:
                if (str6.equals("hbxspj26")) {
                    b = 27;
                } else {
                    b = -1;
                }
                break;
            case 1189839087:
                if (str6.equals("hbxspj44")) {
                    b = 118;
                } else {
                    b = -1;
                }
                break;
            case 1194151220:
                if (str6.equals("hbxxfb86")) {
                    b = Command.COMM_CONFIGURE_HOTEL_DATA;
                } else {
                    b = -1;
                }
                break;
            case 1195079357:
                if (str6.equals("hbxyfg23")) {
                    b = 243;
                } else {
                    b = -1;
                }
                break;
            case 1378148192:
                if (str6.equals("sblibrary2x2")) {
                    b = 12;
                } else {
                    b = -1;
                }
                break;
            case 1378150116:
                if (str6.equals("sblibrary4x4")) {
                    b = 15;
                } else {
                    b = -1;
                }
                break;
            case 1378150118:
                if (str6.equals("sblibrary4x6")) {
                    b = 16;
                } else {
                    b = -1;
                }
                break;
            case 1455728965:
                if (str6.equals("hbtable_drak46")) {
                    b = 55;
                } else {
                    b = -1;
                }
                break;
            case 1461636382:
                if (str6.equals("hbcdxx_machine_46")) {
                    b = SDKKeyboardCode.FUNCTION_KEY_BOARD_F1;
                } else {
                    b = -1;
                }
                break;
            case 1461636444:
                if (str6.equals("hbcdxx_machine_66")) {
                    b = 62;
                } else {
                    b = -1;
                }
                break;
            case 1693642551:
                if (str6.equals("hbbjxxfdy42")) {
                    b = 176;
                } else {
                    b = -1;
                }
                break;
            case 1709926696:
                if (str6.equals("hbbjxxwxm42")) {
                    b = 175;
                } else {
                    b = -1;
                }
                break;
            case 1828501431:
                if (str6.equals("hbkq_kt_22")) {
                    b = ComByteManager.ULTRALIGHT_LONG_WRITE;
                } else {
                    b = -1;
                }
                break;
            case 1863841674:
                if (str6.equals("hbmusic_drak86")) {
                    b = 52;
                } else {
                    b = -1;
                }
                break;
            case 1884987069:
                if (str6.equals("sbdjs21")) {
                    b = 191;
                } else {
                    b = -1;
                }
                break;
            case 1884987070:
                if (str6.equals("sbdjs22")) {
                    b = 189;
                } else {
                    b = -1;
                }
                break;
            case 1898361307:
                if (str6.equals("sbryq22")) {
                    b = 124;
                } else {
                    b = -1;
                }
                break;
            case 1898361338:
                if (str6.equals("sbryq32")) {
                    b = 123;
                } else {
                    b = -1;
                }
                break;
            case 1898361371:
                if (str6.equals("sbryq44")) {
                    b = 122;
                } else {
                    b = -1;
                }
                break;
            case 1898823548:
                if (str6.equals("sbsjb22")) {
                    b = SDKKeyboardCode.FUNCTION_KEY_BOARD_PAGE_UP;
                } else {
                    b = -1;
                }
                break;
            case 1898823610:
                if (str6.equals("sbsjb42")) {
                    b = SDKKeyboardCode.FUNCTION_KEY_BOARD_END;
                } else {
                    b = -1;
                }
                break;
            case 1900019992:
                if (str6.equals("sbtsg21")) {
                    b = 254;
                } else {
                    b = -1;
                }
                break;
            case 1901627851:
                if (str6.equals("hbmultmenu46")) {
                    b = Mifare.PHAL_MFC_CMD_AUTHA;
                } else {
                    b = -1;
                }
                break;
            case 1905131551:
                if (str6.equals("sbzdy21")) {
                    b = ComByteManager.ISO7816_CMD;
                } else {
                    b = -1;
                }
                break;
            case 1905131552:
                if (str6.equals("sbzdy22")) {
                    b = 147;
                } else {
                    b = -1;
                }
                break;
            case 1905131554:
                if (str6.equals("sbzdy24")) {
                    b = 148;
                } else {
                    b = -1;
                }
                break;
            case 1905131613:
                if (str6.equals("sbzdy41")) {
                    b = 149;
                } else {
                    b = -1;
                }
                break;
            case 1905131614:
                if (str6.equals("sbzdy42")) {
                    b = 150;
                } else {
                    b = -1;
                }
                break;
            case 1905131615:
                if (str6.equals("sbzdy43")) {
                    b = 151;
                } else {
                    b = -1;
                }
                break;
            case 1905131616:
                if (str6.equals("sbzdy44")) {
                    b = 152;
                } else {
                    b = -1;
                }
                break;
            case 1905131617:
                if (str6.equals("sbzdy45")) {
                    b = 153;
                } else {
                    b = -1;
                }
                break;
            case 1905131675:
                if (str6.equals("sbzdy61")) {
                    b = 154;
                } else {
                    b = -1;
                }
                break;
            case 1905131676:
                if (str6.equals("sbzdy62")) {
                    b = 155;
                } else {
                    b = -1;
                }
                break;
            case 1905131677:
                if (str6.equals("sbzdy63")) {
                    b = 156;
                } else {
                    b = -1;
                }
                break;
            case 1905131678:
                if (str6.equals("sbzdy64")) {
                    b = 157;
                } else {
                    b = -1;
                }
                break;
            case 1905131680:
                if (str6.equals("sbzdy66")) {
                    b = 158;
                } else {
                    b = -1;
                }
                break;
            case 1905131682:
                if (str6.equals("sbzdy68")) {
                    b = 159;
                } else {
                    b = -1;
                }
                break;
            case 1905542860:
                if (str6.equals("sbzrs22")) {
                    b = 32;
                } else {
                    b = -1;
                }
                break;
            case 1905542922:
                if (str6.equals("sbzrs42")) {
                    b = 35;
                } else {
                    b = -1;
                }
                break;
            case 2126841926:
                if (str6.equals("hbdypj241")) {
                    b = 283;
                } else {
                    b = -1;
                }
                break;
            case 2126841927:
                if (str6.equals("hbdypj242")) {
                    b = 285;
                } else {
                    b = -1;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                return CustomHomeFragment.INSTANCE.newInstance();
            case 1:
            case 2:
                return AIFragmentFull.INSTANCE.newInstance();
            case 3:
            case 4:
                return ClassesOverFragment.INSTANCE.newInstance();
            case 5:
                return ConsultFragment2x6.INSTANCE.newInstance();
            case 6:
                return ConsultFragment4x2.INSTANCE.newInstance();
            case 7:
            case 8:
                return ConsultFragment4x4.INSTANCE.newInstance(str6);
            case 9:
                return ConsultFragmentP2x2.INSTANCE.newInstance();
            case 10:
                return ConsultFragmentP6x2.INSTANCE.newInstance();
            case 11:
            case 12:
                return LibraryFragment2x2.INSTANCE.newInstance(str6);
            case 13:
            case 14:
            case 15:
            case 16:
                return LibraryFragment4x4.INSTANCE.newInstance(str6);
            case 17:
            case 18:
                return ActiveApplyFragment2x2.INSTANCE.newInstance(str6);
            case 19:
            case 20:
                return ActiveApplyFragment2x4.INSTANCE.newInstance(str6);
            case 21:
            case 22:
                return ActiveApplyFragment4x4.INSTANCE.newInstance(str6);
            case 23:
            case 24:
            case 25:
                return NoticeTemplateFragment.INSTANCE.newInstance(str6);
            case 26:
                return EvaluationFragmentP4x4.INSTANCE.newInstance();
            case 27:
                return EvaluationFragment.INSTANCE.newInstance();
            case 28:
                return BookFragment2x2.INSTANCE.newInstance();
            case 29:
                return ClassInfoFragment8x6.INSTANCE.newInstance();
            case 30:
                return PunchThirdFragment.INSTANCE.newInstance();
            case 31:
            case 32:
                return DutyFragment2x2.INSTANCE.newInstance(str6);
            case 33:
            case 34:
            case 35:
                return DutyFragment2x3.INSTANCE.newInstance(str6);
            case 36:
                return DormitoryFragment2x6.INSTANCE.newInstance();
            case 37:
                return DormitoryFragment4x6.INSTANCE.newInstance();
            case 38:
            case 39:
                return DormitoryEducationFragment.INSTANCE.newInstance(str6);
            case 40:
                return ClassInfoFragment4x2.INSTANCE.newInstance();
            case 41:
                return SiteInfoFragment.INSTANCE.newInstance(str6);
            case 42:
                return BlackBoardFragment2x3.INSTANCE.newInstance();
            case 43:
                return BlackBoardFragment4x4.INSTANCE.newInstance();
            case 44:
            case 45:
            case 46:
            case 47:
                return HomePatrolFragment.INSTANCE.newInstance(str6);
            case 48:
                return HomeChemistryFragment.INSTANCE.newInstance();
            case 49:
                return Ipad_10_Fragment.INSTANCE.newInstance();
            case 50:
            case 51:
                return HomeReservation36Fragment.INSTANCE.newInstance();
            case 52:
                return UniversityMusicFragment.INSTANCE.newInstance(str6);
            case 53:
                return new ClassScheduleFragment2_3L();
            case 54:
                return UniversityTrainingDeviceFragment.INSTANCE.newInstance();
            case 55:
                return UniversityDrakTableFragment.newInstance(str6);
            case 56:
            case 57:
            case 58:
                return SiteInfo46Fragment.INSTANCE.newInstance(str6);
            case 59:
                return SiteInfo68Fragment.INSTANCE.newInstance(str6);
            case 60:
                return SiteInfo66Fragment.INSTANCE.newInstance(str6);
            case 61:
                return SiteInfo86Fragment.INSTANCE.newInstance(str6);
            case 62:
                return UniversitySiteInfoFragment.INSTANCE.newInstance(str6);
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
                return SiteInfoFragment.INSTANCE.newInstance(str6);
            case 72:
            case 73:
                return HomeVote23Fragment.INSTANCE.newInstance(str6);
            case 74:
            case 75:
                return HomeCollectForm22Fragment.INSTANCE.newInstance(str6);
            case 76:
            case 77:
                return HomeCollectForm23Fragment.INSTANCE.newInstance(str6);
            case 78:
            case 79:
            case 80:
                return UniversityInternetFragment.INSTANCE.newInstance(str6, i2);
            case 81:
            case 82:
            case 83:
                return UniversityReservationFragment.INSTANCE.newInstance(str6);
            case 84:
            case 85:
                return UniversityNextReservationFragment.INSTANCE.newInstance(str6);
            case 86:
            case 87:
                return HomeReservationFragment.INSTANCE.newInstance(str6);
            case 88:
            case 89:
                return HomeReservation44Fragment.INSTANCE.newInstance(str6);
            case 90:
            case 91:
                return ExamArrangement66Fragment.INSTANCE.newInstance(str6);
            case 92:
            case 93:
                return ExamArrangement44Fragment.INSTANCE.newInstance(str6);
            case 94:
            case 95:
                return ExamArrangement24Fragment.INSTANCE.newInstance(str6);
            case 96:
                return CartoonMenuFragment.INSTANCE.newInstance(layoutClassSignDetailsEntityListBean);
            case 97:
                return UniversityTableFragment.newInstance(str6);
            case 98:
                return UniversityNextTableFragment.newInstance();
            case 99:
                return UniversityDateFragment.newInstance();
            case 100:
            case 101:
                return MessageHomeFragment.INSTANCE.newInstance();
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
                return MessageFragment.INSTANCE.newInstance(str6);
            case 118:
            case 119:
                return HonorFragment.INSTANCE.newInstance(str6);
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
                return HomeHonorFragment.INSTANCE.newInstance(str6);
            case 125:
                return HomeHonorFragment2x2.INSTANCE.newInstance(str6);
            case 126:
            case 127:
                return CustomVerifyFragment.INSTANCE.newInstance(str, str6, str2, str4, Integer.valueOf(i2));
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                if ("4".equals(str3)) {
                    CustomJsonGroupBean groupContent = ((CustomJsonParamBean) GsonUtils.fromJson(layoutClassSignDetailsEntityListBean.jsonParam, CustomJsonParamBean.class)).getGroupContent();
                    if (LayoutUtils.INSTANCE.isLayoutExist("hbtjcustom8x5")) {
                        Log.i("CustomJsonGroupBean", "天津自定义样式");
                        if (groupContent.getContentType() == 3) {
                            return CustomizedRecyclerviewFragment.INSTANCE.newInstance(str6, layoutClassSignDetailsEntityListBean.moduleName, layoutClassSignDetailsEntityListBean.borderColor, layoutClassSignDetailsEntityListBean.showModuleName, groupContent.getListContent());
                        }
                        if (groupContent.getContentType() == 5) {
                            return CustomizedTextFragment.INSTANCE.newInstance(str6, layoutClassSignDetailsEntityListBean.moduleName, layoutClassSignDetailsEntityListBean.borderColor, layoutClassSignDetailsEntityListBean.showModuleName, groupContent.getTextContent());
                        }
                        if (groupContent.getContentType() == 4) {
                            return CustomizedRecyclerviewFragment.INSTANCE.newInstance(str6, layoutClassSignDetailsEntityListBean.moduleName, layoutClassSignDetailsEntityListBean.borderColor, layoutClassSignDetailsEntityListBean.showModuleName, groupContent.getFormContent());
                        }
                    }
                    int contentType = groupContent.getContentType();
                    if (contentType == 1) {
                        return CustomBannerFragment.INSTANCE.newInstance(str6, layoutClassSignDetailsEntityListBean.moduleName, layoutClassSignDetailsEntityListBean.borderColor, layoutClassSignDetailsEntityListBean.showModuleName, groupContent.getImageContent());
                    }
                    if (contentType != 2) {
                        if (contentType == 3) {
                            return CustomRecyclerviewFragment.INSTANCE.newInstance(str6, layoutClassSignDetailsEntityListBean.moduleName, layoutClassSignDetailsEntityListBean.borderColor, layoutClassSignDetailsEntityListBean.showModuleName, groupContent.getListContent());
                        }
                        if (contentType == 4) {
                            return CustomRecyclerviewFragment.INSTANCE.newInstance(str6, layoutClassSignDetailsEntityListBean.moduleName, layoutClassSignDetailsEntityListBean.borderColor, layoutClassSignDetailsEntityListBean.showModuleName, groupContent.getFormContent());
                        }
                        if (contentType != 5) {
                            return null;
                        }
                        return CustomTextFragment.INSTANCE.newInstance(str6, layoutClassSignDetailsEntityListBean.moduleName, layoutClassSignDetailsEntityListBean.borderColor, layoutClassSignDetailsEntityListBean.showModuleName, groupContent.getTextContent());
                    }
                    if (groupContent.getRichTextContent().getLayoutType() == 2) {
                        return CustomImageText4Fragment.INSTANCE.newInstance(str6, layoutClassSignDetailsEntityListBean.moduleName, layoutClassSignDetailsEntityListBean.borderColor, layoutClassSignDetailsEntityListBean.showModuleName, groupContent.getRichTextContent());
                    }
                    if (groupContent.getRichTextContent().getLayoutType() == 3) {
                        return CustomImageTextFragment.INSTANCE.newInstance(str6, layoutClassSignDetailsEntityListBean.moduleName, layoutClassSignDetailsEntityListBean.borderColor, layoutClassSignDetailsEntityListBean.showModuleName, groupContent.getRichTextContent());
                    }
                    if (groupContent.getRichTextContent().getLayoutType() == 4) {
                        return CustomImageText2Fragment.INSTANCE.newInstance(str6, layoutClassSignDetailsEntityListBean.moduleName, layoutClassSignDetailsEntityListBean.borderColor, layoutClassSignDetailsEntityListBean.showModuleName, groupContent.getRichTextContent());
                    }
                    return CustomImageText3Fragment.INSTANCE.newInstance(str6, layoutClassSignDetailsEntityListBean.moduleName, layoutClassSignDetailsEntityListBean.borderColor, layoutClassSignDetailsEntityListBean.showModuleName, groupContent.getRichTextContent());
                }
                return WebViewFragment.INSTANCE.newInstance(str, arrayList2, str6, !TextUtils.isEmpty(layoutClassSignDetailsEntityListBean.moduleName) ? layoutClassSignDetailsEntityListBean.moduleName : str2, str3, str5, layoutClassSignDetailsEntityListBean.borderColor, layoutClassSignDetailsEntityListBean.showModuleName);
            case 160:
            case 161:
            case 162:
                return PunchFragment.INSTANCE.newInstance(str6);
            case 163:
                return new KBCDFragment6_6();
            case 164:
                return new KBBJFragment6_6();
            case 165:
                return new ClassScheduleFragment4_4L();
            case 166:
                return new ClassScheduleFragment2_4L();
            case 167:
                return new ClassScheduleFragment_sk4_4L();
            case 168:
                return new ClassScheduleFragment_sk2_4L();
            case 169:
                return new KBFragment4_4L();
            case 170:
                return new KBFragment2_2p();
            case 171:
                return new KBFragment4_2P("sbkb42");
            case 172:
                return new ClassScheduleFragment6_3P2("sbkb63");
            case 173:
                return new KBFragment6_3P("sbkb63");
            case 174:
                return new ClassInfoFragment2_2L();
            case 175:
                return ClassInfoFragment4_2L.newFragment("");
            case 176:
                return ClassInfoFragment4_2L.newFragment("hbbjxxfdy42");
            case 177:
            case 178:
                return ClassInfoFragment2_4L.newFragment(str6);
            case 179:
                return new ClassInfoFragment2_2P();
            case 180:
            case 181:
                return ClassInfoFragment6_2P.newFragment(str6);
            case 182:
                return new ClassInfoFragment2_1_1P();
            case 183:
                return new ClassInfoFragment4_1_1P();
            case 184:
                return new ClassInfoFragment4_1P();
            case 185:
                return ClassInfoFragment4_1P.newFragment("sbbjxxfdy41");
            case 186:
                return new ClassInfoFragment2_1L();
            case 187:
            case 188:
            case 189:
            case 190:
                return TimerFragment2x2L.newInstance(str6);
            case 191:
                return new TimerFragment2x1P();
            case 192:
            case 193:
            case 194:
                return new StudentDutyFragment2_2L();
            case 195:
                return new StudentDutyFragment2_3L();
            case 196:
            case 197:
            case 198:
                return StudentDutyFragment4_1P.newInstance(str6);
            case 199:
            case 200:
                return new AnnouncementFragment2_4L();
            case 201:
                return new AnnouncementFragment6_3P();
            case 202:
                return new AnnouncementFragment4_2P();
            case 203:
                return new AnnouncementFragment4_4L();
            case 204:
                return MessageNoticeFragment.INSTANCE.newInstance();
            case 205:
                return new StudentCenter2_2L();
            case 206:
                return new StudentCenter2_3L();
            case 207:
            case 208:
                return StudentCenter2_1P.newInstance(str6);
            case 209:
                return new StudentCenter2_2P();
            case 210:
                return new AttendanceFragmentSatistics_cartoon_2_2L();
            case 211:
            case 212:
                return new AttendanceFragmentSatistics2_2L();
            case 213:
                return new AttendanceFragment2_2_2L();
            case 214:
                return new AttendanceFragment4_1_1P_list();
            case 215:
                return new AttendanceFragment4_2P_list();
            case 216:
            case 217:
                return new StudentProductionFragment2_4L();
            case 218:
                return new StudentProductionFragment4_4L();
            case 219:
                return new StudentProductionFragment4_6L();
            case 220:
                return new StudentProductionFragment6_3P();
            case 221:
            case 222:
                return new AssignmentFragment2_4L();
            case 223:
                return new AssignmentFragment2_3L();
            case 224:
            case 225:
            case 226:
            case TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL /* 227 */:
            case TbsListener.ErrorCode.INCR_ERROR_DETAIL /* 228 */:
            case TbsListener.ErrorCode.INSTALL_FROM_UNZIP /* 229 */:
            case TbsListener.ErrorCode.RENAME_SUCCESS /* 230 */:
            case TbsListener.ErrorCode.RENAME_FAIL /* 231 */:
            case TbsListener.ErrorCode.INSTALL_SUCCESS_AND_RELEASE_LOCK /* 232 */:
                return VideoFragment.newInstance(str6, i);
            case TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS /* 233 */:
            case TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS /* 234 */:
            case TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL /* 235 */:
            case TbsListener.ErrorCode.TPATCH_INSTALL_SUCCESS /* 236 */:
            case TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS /* 237 */:
            case TbsListener.ErrorCode.TPATCH_FAIL /* 238 */:
            case TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL /* 239 */:
            case 240:
            case TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID /* 241 */:
            case TbsListener.ErrorCode.TPATCH_ENABLE_EXCEPTION /* 242 */:
            case 243:
            case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE /* 244 */:
            case 245:
                return BannerImageFragment.newInstance(str6);
            case 246:
                return new WeatherFragment_2_1P();
            case 247:
                return new WeatherFragment_4_1P();
            case 248:
                return new TimerFragment_2_1P();
            case 249:
            case 250:
                return TimeClockFragment.INSTANCE.newInstance(str6);
            case Opcodes.INVOKE_POLYMORPHIC_RANGE /* 251 */:
                return new TimeClockFragment2();
            case Opcodes.INVOKE_CUSTOM /* 252 */:
                return new TimeClockFragment3();
            case Opcodes.INVOKE_CUSTOM_RANGE /* 253 */:
                return new BookFragment2_1L();
            case Opcodes.CONST_METHOD_HANDLE /* 254 */:
                return new BookFragment2_1P();
            case 255:
            case 256:
            case 257:
            case 258:
                return BookYwFragment4_6LBy_search.newInstance(str6);
            case 259:
            case MessageInfo.MSG_TYPE_GROUP_QUITE /* 260 */:
            case MessageInfo.MSG_TYPE_GROUP_KICK /* 261 */:
            case MessageInfo.MSG_TYPE_GROUP_MODIFY_NAME /* 262 */:
                return BookYwFragment4_2LBy_loan.newInstance(str6);
            case MessageInfo.MSG_TYPE_GROUP_MODIFY_NOTICE /* 263 */:
            case MessageInfo.MSG_TYPE_GROUP_AV_CALL_NOTICE /* 264 */:
            case 265:
            case 266:
                return BookYwFragment4_2LBy_new.newInstance(str6);
            case 267:
            case 268:
            case 269:
            case 270:
            case 271:
                return BookYwFragmentL2.newInstance(str6);
            case 272:
            case MessageInfo.MSG_STATUS_READ /* 273 */:
                return BookYwFragmentLBy_loan2_2.newInstance(str6);
            case MessageInfo.MSG_STATUS_DELETE /* 274 */:
            case MessageInfo.MSG_STATUS_REVOKE /* 275 */:
                return Wlkz2_2L.newInstance(str6, i2);
            case 276:
            case 277:
            case 278:
            case 279:
            case 280:
            case 281:
            case 282:
                return NCalendarLFragment.newInstance(str6);
            case DfuBaseService.NOTIFICATION_ID /* 283 */:
            case 284:
                return IndexClassMEFragment241.INSTANCE.newInstance(str6);
            case 285:
            case 286:
                return IndexClassMEFragment242.INSTANCE.newInstance(str6);
            case 287:
            case 288:
                return IndexClassMEFragment26.INSTANCE.newInstance(str6);
            case 289:
            case 290:
                return HomeRepair21Fragment.INSTANCE.newInstance(str6);
            case 291:
            case 292:
                return HomeRepair22Fragment.INSTANCE.newInstance(str6);
            default:
                return null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    void initHome(List<LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean> list, int i) {
        String json = GsonUtils.toJson(list);
        if (!TextUtils.isEmpty(json) && (json.contains("hbreservation_machine_54") || json.contains("hbhy54") || json.contains("hbxl36"))) {
            BaseConstant.baseWidth = BaseConstant.baseWidth_10;
            BaseConstant.baseHeight = BaseConstant.baseHeight_10;
        } else {
            BaseConstant.baseWidth = 467;
            BaseConstant.baseHeight = 315;
        }
        if (list.isEmpty()) {
            this.mu.setViewState(1);
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 < this.ids.length) {
                FrameLayout frameLayout = new FrameLayout(getActivity());
                frameLayout.setId(this.ids[i2]);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                if (ScreenUtils.isLandscape()) {
                    int i3 = BaseConstant.baseWidth / 2;
                    int i4 = BaseConstant.baseHeight / 2;
                    int iDp2px = SizeUtils.dp2px(list.get(i2).x * i3);
                    int iDp2px2 = SizeUtils.dp2px(list.get(i2).y * i4);
                    Log.d("HomeFragment", "leftX tag= " + list.get(i2).tag + " leftX= " + list.get(i2).x + " left = " + iDp2px);
                    layoutParams.setMargins(iDp2px, iDp2px2, 0, 0);
                } else {
                    layoutParams.setMargins(SizeUtils.dp2px(list.get(i2).x * (BaseConstant.baseWidth2 / 2)), SizeUtils.dp2px(list.get(i2).y * (BaseConstant.baseHeight2 / 2)), 0, 0);
                }
                frameLayout.setLayoutParams(layoutParams);
                this.frame.addView(frameLayout);
                if (list.get(i2).tag != null) {
                    Fragment fragment = fragment(list.get(i2), i);
                    if (!TextUtils.isEmpty(list.get(i2).tag) && fragment != null) {
                        getChildFragmentManager().beginTransaction().replace(frameLayout.getId(), fragment).commitAllowingStateLoss();
                    }
                }
            }
        }
    }
}
