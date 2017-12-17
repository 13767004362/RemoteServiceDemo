// CommonAidlInterface.aidl
package com.xingen.remoteservice;

import com.xingen.remoteservice.bean.ProcessBean;

// Declare any non-default types here with import statements

//使用 Android Studio，增量编译几乎会立即生成 Binder 类

//在.aidl文件中定义一些方法
interface CommonAidlInterface {
    /**
     * 获取一个随机数的字符串
     */
    String getRandomNumberStr();
    /**
     * 获取远程服务返回的对象,注意点：需要import导入该对象
     */
    ProcessBean getRemoteServiceObject();

}
