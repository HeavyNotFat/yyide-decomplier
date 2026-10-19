package com.yd.android_brand_mvp.dialog;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.net.HttpHeaders;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.BookTypeBean;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.utils.VHUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Pop5 extends PopupWindow {
    RoomAdapter adapter;
    Activity context;
    int first = -1;
    public String[] listss = {"全部分类", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "X", "Z"};
    TextView textView;

    public Pop5(Activity activity, TextView textView) {
        this.context = activity;
        this.textView = textView;
        init();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:140:0x0232  */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r15v0 int, still in use, count: 11, list:
  (r15v0 int) from 0x004f: IF  (r15v0 int) != (88 int)  -> B:7:0x0051 A[HIDDEN]
  (r15v0 int) from 0x0053: IF  (r15v0 int) != (90 int)  -> B:9:0x0055 A[HIDDEN]
  (r15v0 int) from 0x0057: IF  (r15v0 int) != (2670 int)  -> B:11:0x0059 A[HIDDEN]
  (r15v0 int) from 0x005b: IF  (r15v0 int) != (2687 int)  -> B:13:0x005d A[HIDDEN]
  (r15v0 int) from 0x005f: IF  (r15v0 int) != (2684 int)  -> B:15:0x0061 A[HIDDEN]
  (r15v0 int) from 0x0063: IF  (r15v0 int) != (2685 int)  -> B:17:0x0065 A[HIDDEN]
  (r15v0 int) from 0x0067: IF  (r15v0 int) != (2689 int)  -> B:19:0x0069 A[HIDDEN]
  (r15v0 int) from 0x006b: IF  (r15v0 int) != (2690 int)  -> B:21:0x006d A[HIDDEN]
  (r15v0 int) from 0x0070: SWITCH (r15v0 int)
 case 78: goto B:80:0x0153
 case 79: goto B:77:0x0147
 case 80: goto B:74:0x013b
 case 81: goto B:71:0x012f
 case 82: goto B:68:0x0123
 case 83: goto B:65:0x0117
 case 84: goto B:62:0x010b
 case 85: goto B:59:0x00ff
 case 86: goto B:56:0x00f3
 default: goto B:23:0x0073 A[RegionRef:SW:22]
  (r15v0 int) from 0x0073: SWITCH (r15v0 int)
 case 2672: goto B:53:0x00e7
 case 2673: goto B:50:0x00db
 case 2674: goto B:47:0x00cf
 case 2675: goto B:44:0x00c3
 case 2676: goto B:41:0x00b7
 default: goto B:24:0x0076 A[RegionRef:SW:23]
  (r15v0 int) from 0x0076: SWITCH (r15v0 int)
 case 2678: goto B:38:0x00ab
 case 2679: goto B:35:0x009f
 case 2680: goto B:32:0x0093
 case 2681: goto B:29:0x0087
 case 2682: goto B:26:0x007b
 default: goto B:140:0x0232 A[RegionRef:SW:24]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void init() {
        byte b;
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.layout_pop_dialog2, (ViewGroup) null);
        final PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2, true);
        ListView listView = (ListView) viewInflate.findViewById(R.id.list);
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.layout);
        RoomAdapter roomAdapter = new RoomAdapter();
        this.adapter = roomAdapter;
        listView.setAdapter((ListAdapter) roomAdapter);
        ArrayList arrayList = new ArrayList();
        for (String str : this.listss) {
            BookTypeBean bookTypeBean = new BookTypeBean();
            bookTypeBean.type = str;
            if (iHashCode != 88) {
                if (iHashCode != 90) {
                    if (iHashCode != 2670) {
                        if (iHashCode != 2687) {
                            if (iHashCode != 2684) {
                                if (iHashCode != 2685) {
                                    if (iHashCode != 2689) {
                                        if (iHashCode != 2690) {
                                            switch (str) {
                                                case "A":
                                                    b = 0;
                                                    break;
                                                case "B":
                                                    b = 1;
                                                    break;
                                                case "C":
                                                    b = 2;
                                                    break;
                                                case "D":
                                                    b = 3;
                                                    break;
                                                case "E":
                                                    b = 4;
                                                    break;
                                                case "F":
                                                    b = 5;
                                                    break;
                                                case "G":
                                                    b = 6;
                                                    break;
                                                case "H":
                                                    b = 7;
                                                    break;
                                                case "I":
                                                    b = 8;
                                                    break;
                                                case "J":
                                                    b = 9;
                                                    break;
                                                case "K":
                                                    b = 10;
                                                    break;
                                                default:
                                                    switch (str) {
                                                        case 78:
                                                            if (str.equals("N")) {
                                                                b = 11;
                                                            } else {
                                                                b = -1;
                                                            }
                                                            break;
                                                        case 79:
                                                            if (str.equals("O")) {
                                                                b = 12;
                                                            } else {
                                                                b = -1;
                                                            }
                                                            break;
                                                        case 80:
                                                            if (str.equals("P")) {
                                                                b = 13;
                                                            } else {
                                                                b = -1;
                                                            }
                                                            break;
                                                        case 81:
                                                            if (str.equals("Q")) {
                                                                b = 14;
                                                            } else {
                                                                b = -1;
                                                            }
                                                            break;
                                                        case 82:
                                                            if (str.equals("R")) {
                                                                b = 15;
                                                            } else {
                                                                b = -1;
                                                            }
                                                            break;
                                                        case 83:
                                                            if (str.equals(ExifInterface.LATITUDE_SOUTH)) {
                                                                b = 16;
                                                            } else {
                                                                b = -1;
                                                            }
                                                            break;
                                                        case 84:
                                                            if (str.equals(ExifInterface.GPS_DIRECTION_TRUE)) {
                                                                b = 17;
                                                            } else {
                                                                b = -1;
                                                            }
                                                            break;
                                                        case 85:
                                                            if (str.equals("U")) {
                                                                b = 34;
                                                            } else {
                                                                b = -1;
                                                            }
                                                            break;
                                                        case 86:
                                                            if (str.equals(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
                                                                b = 35;
                                                            } else {
                                                                b = -1;
                                                            }
                                                            break;
                                                        default:
                                                            switch (str) {
                                                                case 2672:
                                                                    if (str.equals("TD")) {
                                                                        b = 19;
                                                                    } else {
                                                                        b = -1;
                                                                    }
                                                                    break;
                                                                case 2673:
                                                                    if (str.equals(HttpHeaders.TE)) {
                                                                        b = 20;
                                                                    } else {
                                                                        b = -1;
                                                                    }
                                                                    break;
                                                                case 2674:
                                                                    if (str.equals("TF")) {
                                                                        b = 21;
                                                                    } else {
                                                                        b = -1;
                                                                    }
                                                                    break;
                                                                case 2675:
                                                                    if (str.equals("TG")) {
                                                                        b = 22;
                                                                    } else {
                                                                        b = -1;
                                                                    }
                                                                    break;
                                                                case 2676:
                                                                    if (str.equals("TH")) {
                                                                        b = 23;
                                                                    } else {
                                                                        b = -1;
                                                                    }
                                                                    break;
                                                                default:
                                                                    switch (str) {
                                                                        case 2678:
                                                                            if (str.equals("TJ")) {
                                                                                b = 24;
                                                                            } else {
                                                                                b = -1;
                                                                            }
                                                                            break;
                                                                        case 2679:
                                                                            if (str.equals("TK")) {
                                                                                b = 25;
                                                                            } else {
                                                                                b = -1;
                                                                            }
                                                                            break;
                                                                        case 2680:
                                                                            if (str.equals("TL")) {
                                                                                b = 26;
                                                                            } else {
                                                                                b = -1;
                                                                            }
                                                                            break;
                                                                        case 2681:
                                                                            if (str.equals("TM")) {
                                                                                b = 27;
                                                                            } else {
                                                                                b = -1;
                                                                            }
                                                                            break;
                                                                        case 2682:
                                                                            if (str.equals("TN")) {
                                                                                b = 28;
                                                                            } else {
                                                                                b = -1;
                                                                            }
                                                                            break;
                                                                        default:
                                                                            b = -1;
                                                                            break;
                                                                    }
                                                                    break;
                                                            }
                                                            break;
                                                    }
                                            }
                                        } else if (str.equals("TV")) {
                                            b = 33;
                                        } else {
                                            b = -1;
                                        }
                                    } else if (str.equals("TU")) {
                                        b = 32;
                                    } else {
                                        b = -1;
                                    }
                                } else if (str.equals("TQ")) {
                                    b = 30;
                                } else {
                                    b = -1;
                                }
                            } else if (str.equals("TP")) {
                                b = 29;
                            } else {
                                b = -1;
                            }
                        } else if (str.equals("TS")) {
                            b = 31;
                        } else {
                            b = -1;
                        }
                    } else if (str.equals("TB")) {
                        b = 18;
                    } else {
                        b = -1;
                    }
                } else if (str.equals("Z")) {
                    b = 37;
                } else {
                    b = -1;
                }
            } else if (str.equals("X")) {
                b = 36;
            } else {
                b = -1;
            }
            switch (b) {
                case 0:
                    bookTypeBean.msg = "马克思主义、列宁主义、毛泽东思想";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 1:
                    bookTypeBean.msg = "哲学";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 2:
                    bookTypeBean.msg = "社会科学总论";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 3:
                    bookTypeBean.msg = "政治、法律";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 4:
                    bookTypeBean.msg = "军事";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 5:
                    bookTypeBean.msg = "经济";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 6:
                    bookTypeBean.msg = "文化、科学、教育、体育";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 7:
                    bookTypeBean.msg = "语言、文字";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 8:
                    bookTypeBean.msg = "文学";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 9:
                    bookTypeBean.msg = "艺术";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 10:
                    bookTypeBean.msg = "历史、地理";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 11:
                    bookTypeBean.msg = "自然科学总论";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 12:
                    bookTypeBean.msg = "数学科学和化学";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 13:
                    bookTypeBean.msg = "天文学、地球科学";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 14:
                    bookTypeBean.msg = "生物科学";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 15:
                    bookTypeBean.msg = "医药、卫生";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 16:
                    bookTypeBean.msg = "农业科学";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 17:
                    bookTypeBean.msg = "工业技术";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 18:
                    bookTypeBean.msg = "一般工业技术";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 19:
                    bookTypeBean.msg = "矿业工程";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 20:
                    bookTypeBean.msg = "石油、天然气工业";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 21:
                    bookTypeBean.msg = "冶金工业";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 22:
                    bookTypeBean.msg = "金属学、金属工艺";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 23:
                    bookTypeBean.msg = "机械、仪表工业";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 24:
                    bookTypeBean.msg = "武器工业";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 25:
                    bookTypeBean.msg = "动力工程";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 26:
                    bookTypeBean.msg = "原子能技术";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 27:
                    bookTypeBean.msg = "电工技术";
                    break;
                case 28:
                    break;
                case 29:
                    bookTypeBean.msg = "自动化技术、计算技术";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 30:
                    bookTypeBean.msg = "化学工业";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 31:
                    bookTypeBean.msg = "轻工业、手工业";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 32:
                    bookTypeBean.msg = "建筑科学";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 33:
                    bookTypeBean.msg = "水利工程";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 34:
                    bookTypeBean.msg = "交通运输";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 35:
                    bookTypeBean.msg = "航空、航天";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 36:
                    bookTypeBean.msg = "环境科学、劳动保护科学（安全科学）";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                case 37:
                    bookTypeBean.msg = "综合性图书";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
                default:
                    bookTypeBean.msg = "";
                    continue;
                    arrayList.add(bookTypeBean);
                    break;
            }
            bookTypeBean.msg = "无线电电子学、电信技术";
            arrayList.add(bookTypeBean);
        }
        this.adapter.refreshData(arrayList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yd.android_brand_mvp.dialog.Pop5.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Pop5.this.textView.setText(Pop5.this.adapter.getItem(i).type + " " + Pop5.this.adapter.getItem(i).msg);
                popupWindow.dismiss();
            }
        });
        popupWindow.setFocusable(false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        int[] iArr = new int[2];
        popupWindow.showAsDropDown(this.textView, iArr[0], iArr[1] + 20);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.yd.android_brand_mvp.dialog.Pop5.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                MinaEventManager.getInstance().notifyObserver(MinaConstants.updateBook);
                Pop5.this.dismiss();
            }
        });
        viewInflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.yd.android_brand_mvp.dialog.Pop5.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Pop5.this.dismiss();
                return false;
            }
        });
        frameLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.yd.android_brand_mvp.dialog.Pop5.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                popupWindow.dismiss();
                return false;
            }
        });
    }

    private class RoomAdapter extends BaseAdapter {
        int index;
        List<BookTypeBean> list;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        private RoomAdapter() {
            this.list = new ArrayList();
            this.index = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.list.size();
        }

        @Override // android.widget.Adapter
        public BookTypeBean getItem(int i) {
            return this.list.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_xz_item2, (ViewGroup) null);
            }
            ((TextView) VHUtil.ViewHolder.get(view, R.id.name)).setText(getItem(i).type + "  " + getItem(i).msg);
            return view;
        }

        public void notiyfData(int i) {
            this.index = i;
            notifyDataSetChanged();
        }

        void refreshData(List<BookTypeBean> list) {
            this.list = list;
            notifyDataSetChanged();
        }
    }
}
