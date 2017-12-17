package com.xingen.remoteservice.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ${新根} on 2017/12/16.
 * blog博客:http://blog.csdn.net/hexingen
 * 一个当前进程的信息实体类
 * <p>
 * 跨进程通信的对象必须继承Parcelable 接口
 */
public class ProcessBean implements Parcelable {
    private int pid;
    private String processName;
    /**
     * 默认构造方法
     */
    public ProcessBean() {
    }
    private ProcessBean(Parcel in) {
        this.pid = in.readInt();
        this.processName = in.readString();
    }
    @Override
    public int describeContents() {
        return 0;
    }
    /**
     * 注意点： 读取Parcel数据的次序要和这里的write次序一致
     *
     * @param dest
     * @param i
     */
    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeInt(pid);
        dest.writeString(processName);
    }
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }
    /**
     * CREATOR 的静态字段，这个字段是一个实现 Parcelable.Creator 接口的对象
     */
    public  static final Creator<ProcessBean> CREATOR = new Creator<ProcessBean>() {
        @Override
        public ProcessBean createFromParcel(Parcel parcel) {
            return new ProcessBean(parcel);
        }

        @Override
        public ProcessBean[] newArray(int i) {
            return new ProcessBean[0];
        }
    };
}
