package com.xingen.remoteservice.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;

import com.xingen.remoteservice.bean.ProcessBean;

import java.util.List;

/**
 * Created by ${新根} on 2017/12/16.
 * blog博客:http://blog.csdn.net/hexingen
 */
public class ProcessUtils {
    /**
     * 获取当前进程的pid
     * @return
     */
    public  static  int getCurrentProcessId(){
        return  Process.myPid();
    }
    /**
     * 获取指定Id的进程，生成对应的实体类，存储信息
     * @param context
     * @param pid
     * @return
     */
    public static ProcessBean getProcess(Context context, int pid){
        ProcessBean processBean=new ProcessBean();
       try {
           ActivityManager mActivityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
           List<ActivityManager.RunningAppProcessInfo> appProcessInfoList= mActivityManager.getRunningAppProcesses();
           for (ActivityManager.RunningAppProcessInfo appProcessInfo:appProcessInfoList){
               if (appProcessInfo.pid==pid){
                    processBean.setPid(pid);
                    processBean.setProcessName(appProcessInfo.processName);
                   break;
               }else{
                  continue;
               }
           }
       }catch (Exception e){
           e.printStackTrace();
       }
       return processBean;
    }
}
