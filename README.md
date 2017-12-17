# RemoteServiceDemo
Android 进程间IPC通讯 , 涉及AIDL, Parcelable和远程服务。

本案例包含两个Module：

- 一个远程服务的Module，名为RemoteService。远程服务接受客户端指令，执行逻辑操作。

- 一个客户端的Module，名为app。用于发送具体的任务给远程服务。
