package com.yd.android_brand_mvp.network.task;

import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.task.AddressBookBean;
import com.yd.android_brand_mvp.model.task.MyTaskListBean;
import com.yd.android_brand_mvp.model.task.MyTaskListItem;
import com.yd.android_brand_mvp.model.task.TaskDetailBean;
import com.yd.android_brand_mvp.network.base.BaseNetworkApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: TaskSignNetwork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\f\u0010\nJ0\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00052\u0006\u0010\u0010\u001a\u00020\u0006H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0015\u0010\nJ*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0018\u0010\nJ0\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u000e0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001b\u0010\nJ*\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001d\u0010\nJ*\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001f\u0010\n\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/yd/android_brand_mvp/network/task/TaskSignNetwork;", "Lcom/yd/android_brand_mvp/network/base/BaseNetworkApi;", "Lcom/yd/android_brand_mvp/network/task/ITaskSignService;", "()V", "addTask", "Lkotlin/Result;", "", "requestBody", "Lokhttp3/RequestBody;", "addTask-gIAlu-s", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTask", "deleteTask-gIAlu-s", "getAddressBook", "", "Lcom/yd/android_brand_mvp/model/task/AddressBookBean;", CommentsHomeFragment.TYPE_ID, "getAddressBook-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyTaskList", "Lcom/yd/android_brand_mvp/model/task/MyTaskListBean;", "getMyTaskList-gIAlu-s", "getTaskDetail", "Lcom/yd/android_brand_mvp/model/task/TaskDetailBean;", "getTaskDetail-gIAlu-s", "getTaskList", "Lcom/yd/android_brand_mvp/model/task/MyTaskListItem;", "getTaskList-gIAlu-s", "signTask", "signTask-gIAlu-s", "updateTask", "updateTask-gIAlu-s", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TaskSignNetwork extends BaseNetworkApi<ITaskSignService> {
    public static final TaskSignNetwork INSTANCE = new TaskSignNetwork();

    private TaskSignNetwork() {
        super("https://api.yyide.com");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: deleteTask-gIAlu-s, reason: not valid java name */
    public final Object m534deleteTaskgIAlus(RequestBody requestBody, Continuation<? super Result<String>> continuation) {
        TaskSignNetwork$deleteTask$1 taskSignNetwork$deleteTask$1;
        if (continuation instanceof TaskSignNetwork$deleteTask$1) {
            taskSignNetwork$deleteTask$1 = (TaskSignNetwork$deleteTask$1) continuation;
            if ((taskSignNetwork$deleteTask$1.label & Integer.MIN_VALUE) != 0) {
                taskSignNetwork$deleteTask$1.label -= Integer.MIN_VALUE;
            } else {
                taskSignNetwork$deleteTask$1 = new TaskSignNetwork$deleteTask$1(this, continuation);
            }
        } else {
            taskSignNetwork$deleteTask$1 = new TaskSignNetwork$deleteTask$1(this, continuation);
        }
        Object obj = taskSignNetwork$deleteTask$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = taskSignNetwork$deleteTask$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        TaskSignNetwork$deleteTask$2 taskSignNetwork$deleteTask$2 = new TaskSignNetwork$deleteTask$2(requestBody, null);
        taskSignNetwork$deleteTask$1.label = 1;
        Object obj2 = m485getResultgIAlus(taskSignNetwork$deleteTask$2, taskSignNetwork$deleteTask$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: addTask-gIAlu-s, reason: not valid java name */
    public final Object m533addTaskgIAlus(RequestBody requestBody, Continuation<? super Result<String>> continuation) {
        TaskSignNetwork$addTask$1 taskSignNetwork$addTask$1;
        if (continuation instanceof TaskSignNetwork$addTask$1) {
            taskSignNetwork$addTask$1 = (TaskSignNetwork$addTask$1) continuation;
            if ((taskSignNetwork$addTask$1.label & Integer.MIN_VALUE) != 0) {
                taskSignNetwork$addTask$1.label -= Integer.MIN_VALUE;
            } else {
                taskSignNetwork$addTask$1 = new TaskSignNetwork$addTask$1(this, continuation);
            }
        } else {
            taskSignNetwork$addTask$1 = new TaskSignNetwork$addTask$1(this, continuation);
        }
        Object obj = taskSignNetwork$addTask$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = taskSignNetwork$addTask$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        TaskSignNetwork$addTask$2 taskSignNetwork$addTask$2 = new TaskSignNetwork$addTask$2(requestBody, null);
        taskSignNetwork$addTask$1.label = 1;
        Object obj2 = m485getResultgIAlus(taskSignNetwork$addTask$2, taskSignNetwork$addTask$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: updateTask-gIAlu-s, reason: not valid java name */
    public final Object m540updateTaskgIAlus(RequestBody requestBody, Continuation<? super Result<String>> continuation) {
        TaskSignNetwork$updateTask$1 taskSignNetwork$updateTask$1;
        if (continuation instanceof TaskSignNetwork$updateTask$1) {
            taskSignNetwork$updateTask$1 = (TaskSignNetwork$updateTask$1) continuation;
            if ((taskSignNetwork$updateTask$1.label & Integer.MIN_VALUE) != 0) {
                taskSignNetwork$updateTask$1.label -= Integer.MIN_VALUE;
            } else {
                taskSignNetwork$updateTask$1 = new TaskSignNetwork$updateTask$1(this, continuation);
            }
        } else {
            taskSignNetwork$updateTask$1 = new TaskSignNetwork$updateTask$1(this, continuation);
        }
        Object obj = taskSignNetwork$updateTask$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = taskSignNetwork$updateTask$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        TaskSignNetwork$updateTask$2 taskSignNetwork$updateTask$2 = new TaskSignNetwork$updateTask$2(requestBody, null);
        taskSignNetwork$updateTask$1.label = 1;
        Object obj2 = m485getResultgIAlus(taskSignNetwork$updateTask$2, taskSignNetwork$updateTask$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getTaskList-gIAlu-s, reason: not valid java name */
    public final Object m538getTaskListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<MyTaskListItem>>> continuation) {
        TaskSignNetwork$getTaskList$1 taskSignNetwork$getTaskList$1;
        if (continuation instanceof TaskSignNetwork$getTaskList$1) {
            taskSignNetwork$getTaskList$1 = (TaskSignNetwork$getTaskList$1) continuation;
            if ((taskSignNetwork$getTaskList$1.label & Integer.MIN_VALUE) != 0) {
                taskSignNetwork$getTaskList$1.label -= Integer.MIN_VALUE;
            } else {
                taskSignNetwork$getTaskList$1 = new TaskSignNetwork$getTaskList$1(this, continuation);
            }
        } else {
            taskSignNetwork$getTaskList$1 = new TaskSignNetwork$getTaskList$1(this, continuation);
        }
        Object obj = taskSignNetwork$getTaskList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = taskSignNetwork$getTaskList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        TaskSignNetwork$getTaskList$2 taskSignNetwork$getTaskList$2 = new TaskSignNetwork$getTaskList$2(requestBody, null);
        taskSignNetwork$getTaskList$1.label = 1;
        Object obj2 = m485getResultgIAlus(taskSignNetwork$getTaskList$2, taskSignNetwork$getTaskList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getMyTaskList-gIAlu-s, reason: not valid java name */
    public final Object m536getMyTaskListgIAlus(RequestBody requestBody, Continuation<? super Result<MyTaskListBean>> continuation) {
        TaskSignNetwork$getMyTaskList$1 taskSignNetwork$getMyTaskList$1;
        if (continuation instanceof TaskSignNetwork$getMyTaskList$1) {
            taskSignNetwork$getMyTaskList$1 = (TaskSignNetwork$getMyTaskList$1) continuation;
            if ((taskSignNetwork$getMyTaskList$1.label & Integer.MIN_VALUE) != 0) {
                taskSignNetwork$getMyTaskList$1.label -= Integer.MIN_VALUE;
            } else {
                taskSignNetwork$getMyTaskList$1 = new TaskSignNetwork$getMyTaskList$1(this, continuation);
            }
        } else {
            taskSignNetwork$getMyTaskList$1 = new TaskSignNetwork$getMyTaskList$1(this, continuation);
        }
        Object obj = taskSignNetwork$getMyTaskList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = taskSignNetwork$getMyTaskList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        TaskSignNetwork$getMyTaskList$2 taskSignNetwork$getMyTaskList$2 = new TaskSignNetwork$getMyTaskList$2(requestBody, null);
        taskSignNetwork$getMyTaskList$1.label = 1;
        Object obj2 = m485getResultgIAlus(taskSignNetwork$getMyTaskList$2, taskSignNetwork$getMyTaskList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getTaskDetail-gIAlu-s, reason: not valid java name */
    public final Object m537getTaskDetailgIAlus(RequestBody requestBody, Continuation<? super Result<TaskDetailBean>> continuation) {
        TaskSignNetwork$getTaskDetail$1 taskSignNetwork$getTaskDetail$1;
        if (continuation instanceof TaskSignNetwork$getTaskDetail$1) {
            taskSignNetwork$getTaskDetail$1 = (TaskSignNetwork$getTaskDetail$1) continuation;
            if ((taskSignNetwork$getTaskDetail$1.label & Integer.MIN_VALUE) != 0) {
                taskSignNetwork$getTaskDetail$1.label -= Integer.MIN_VALUE;
            } else {
                taskSignNetwork$getTaskDetail$1 = new TaskSignNetwork$getTaskDetail$1(this, continuation);
            }
        } else {
            taskSignNetwork$getTaskDetail$1 = new TaskSignNetwork$getTaskDetail$1(this, continuation);
        }
        Object obj = taskSignNetwork$getTaskDetail$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = taskSignNetwork$getTaskDetail$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        TaskSignNetwork$getTaskDetail$2 taskSignNetwork$getTaskDetail$2 = new TaskSignNetwork$getTaskDetail$2(requestBody, null);
        taskSignNetwork$getTaskDetail$1.label = 1;
        Object obj2 = m485getResultgIAlus(taskSignNetwork$getTaskDetail$2, taskSignNetwork$getTaskDetail$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: signTask-gIAlu-s, reason: not valid java name */
    public final Object m539signTaskgIAlus(RequestBody requestBody, Continuation<? super Result<String>> continuation) {
        TaskSignNetwork$signTask$1 taskSignNetwork$signTask$1;
        if (continuation instanceof TaskSignNetwork$signTask$1) {
            taskSignNetwork$signTask$1 = (TaskSignNetwork$signTask$1) continuation;
            if ((taskSignNetwork$signTask$1.label & Integer.MIN_VALUE) != 0) {
                taskSignNetwork$signTask$1.label -= Integer.MIN_VALUE;
            } else {
                taskSignNetwork$signTask$1 = new TaskSignNetwork$signTask$1(this, continuation);
            }
        } else {
            taskSignNetwork$signTask$1 = new TaskSignNetwork$signTask$1(this, continuation);
        }
        Object obj = taskSignNetwork$signTask$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = taskSignNetwork$signTask$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        TaskSignNetwork$signTask$2 taskSignNetwork$signTask$2 = new TaskSignNetwork$signTask$2(requestBody, null);
        taskSignNetwork$signTask$1.label = 1;
        Object obj2 = m485getResultgIAlus(taskSignNetwork$signTask$2, taskSignNetwork$signTask$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getAddressBook-gIAlu-s, reason: not valid java name */
    public final Object m535getAddressBookgIAlus(String str, Continuation<? super Result<? extends List<AddressBookBean>>> continuation) {
        TaskSignNetwork$getAddressBook$1 taskSignNetwork$getAddressBook$1;
        if (continuation instanceof TaskSignNetwork$getAddressBook$1) {
            taskSignNetwork$getAddressBook$1 = (TaskSignNetwork$getAddressBook$1) continuation;
            if ((taskSignNetwork$getAddressBook$1.label & Integer.MIN_VALUE) != 0) {
                taskSignNetwork$getAddressBook$1.label -= Integer.MIN_VALUE;
            } else {
                taskSignNetwork$getAddressBook$1 = new TaskSignNetwork$getAddressBook$1(this, continuation);
            }
        } else {
            taskSignNetwork$getAddressBook$1 = new TaskSignNetwork$getAddressBook$1(this, continuation);
        }
        Object obj = taskSignNetwork$getAddressBook$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = taskSignNetwork$getAddressBook$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        TaskSignNetwork$getAddressBook$2 taskSignNetwork$getAddressBook$2 = new TaskSignNetwork$getAddressBook$2(str, null);
        taskSignNetwork$getAddressBook$1.label = 1;
        Object obj2 = m485getResultgIAlus(taskSignNetwork$getAddressBook$2, taskSignNetwork$getAddressBook$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }
}
