package com.xingen.remoteservicetest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.xingen.remoteservice.CommonAidlInterface;
import com.xingen.remoteservice.bean.ProcessBean;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 远程服务的接口
     */
    private CommonAidlInterface remoteServiceInterface;
    private TextView showMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindRemoteService();
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除远程绑定
        unBindRomoteService();
    }

    private void initView() {
        this.showMessage = findViewById(R.id.main_show_text);
        this.findViewById(R.id.main_remote_service_random_btn).setOnClickListener(this);
        this.findViewById(R.id.main_remote_service_process_message_btn).setOnClickListener(this);
    }

    /**
     * 绑定远程服务
     */
    private void bindRemoteService() {
        Intent intent = new Intent("com.xingen.remoteservice.service.CommonRemoteService");
        //android 5.0及其以上需要添加服务的所在程序的包名
        intent.setPackage("com.xingen.remoteservice");
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    /**
     * 解除远程服务的绑定
     */
    private void unBindRomoteService() {
        unbindService(serviceConnection);
    }


    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //Stub.asInterface(service)转成对应的服务接口
            remoteServiceInterface = CommonAidlInterface.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            remoteServiceInterface = null;
        }
    };
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_remote_service_process_message_btn: {
                if (remoteServiceInterface == null) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("远程服务所在进程：\n");
                try {
                    ProcessBean processBean = remoteServiceInterface.getRemoteServiceObject();
                    stringBuffer.append("pid-");
                    stringBuffer.append(processBean.getPid());
                    stringBuffer.append("\n");
                    stringBuffer.append("名字-");
                    stringBuffer.append(processBean.getProcessName());
                } catch (Exception e) {
                    e.printStackTrace();
                    stringBuffer.append(e.getMessage());
                }
                showMessage.setText(stringBuffer);
            }
            break;
            case R.id.main_remote_service_random_btn: {
                if (remoteServiceInterface == null) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("远程服务返回的随机数：\n ");
                try {
                    stringBuffer.append(remoteServiceInterface.getRandomNumberStr());
                } catch (Exception e) {
                    e.printStackTrace();
                    stringBuffer.append(e.getMessage());
                }
                showMessage.setText(stringBuffer);
            }
            break;
        }
    }
}
