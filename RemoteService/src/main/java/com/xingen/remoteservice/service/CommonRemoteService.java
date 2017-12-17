package com.xingen.remoteservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.xingen.remoteservice.CommonAidlInterface;
import com.xingen.remoteservice.bean.ProcessBean;
import com.xingen.remoteservice.utils.ProcessUtils;

import java.util.UUID;

/**
 * Created by ${新根} on 2017/12/16.
 * blog博客:http://blog.csdn.net/hexingen
 *
 */
public class CommonRemoteService extends Service {
    private  final String TAG=CommonRemoteService.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,TAG+" 被创建");
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,TAG+" 被绑定");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG,TAG+" 被解绑");
        return super.onUnbind(intent);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,TAG+" 被销毁");
    }
    /**
     * 获取进程信息的对应实体
     * @return
     */
    private ProcessBean getProcessBean(){
        return ProcessUtils.getProcess(this.getApplicationContext(),ProcessUtils.getCurrentProcessId());
    }

    /**
     * 获取一个随机字符串
     * @return
     */
    private  String getRandomUUIDStr(){
        return  UUID.randomUUID().toString();
    }
    /**
     *  创建一个CommonAidlInterface.aidl对应的CommonAidlInterface.java中的Stub接口
     *
     *  用于与远程服务通讯，这里是本类（CommonRemoteService）通讯
     */
    private final CommonAidlInterface.Stub mBinder=new CommonAidlInterface.Stub() {
        @Override
        public String getRandomNumberStr() throws RemoteException {
            return CommonRemoteService.this.getRandomUUIDStr();
        }
        @Override
        public ProcessBean getRemoteServiceObject() throws RemoteException {
            return CommonRemoteService.this.getProcessBean();
        }
    };

}
