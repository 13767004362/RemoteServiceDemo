/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: F:\\RemoteServiceDemo\\RemoteService\\src\\main\\aidl\\com\\xingen\\remoteservice\\CommonAidlInterface.aidl
 */
package com.xingen.remoteservice;
// Declare any non-default types here with import statements
//使用 Android Studio，增量编译几乎会立即生成 Binder 类
//在.aidl文件中定义一些方法

public interface CommonAidlInterface extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements CommonAidlInterface
{
private static final String DESCRIPTOR = "com.xingen.remoteservice.CommonAidlInterface";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.xingen.remoteservice.CommonAidlInterface interface,
 * generating a proxy if needed.
 */
public static CommonAidlInterface asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof CommonAidlInterface))) {
return ((CommonAidlInterface)iin);
}
return new Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getRandomNumberStr:
{
data.enforceInterface(DESCRIPTOR);
String _result = this.getRandomNumberStr();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getRemoteServiceObject:
{
data.enforceInterface(DESCRIPTOR);
com.xingen.remoteservice.bean.ProcessBean _result = this.getRemoteServiceObject();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements CommonAidlInterface
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public String getRandomNumberStr() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getRandomNumberStr, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * 获取远程服务返回的对象,注意点：需要import导入该对象
     */
@Override public com.xingen.remoteservice.bean.ProcessBean getRemoteServiceObject() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.xingen.remoteservice.bean.ProcessBean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getRemoteServiceObject, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.xingen.remoteservice.bean.ProcessBean.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getRandomNumberStr = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getRemoteServiceObject = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public String getRandomNumberStr() throws android.os.RemoteException;
/**
     * 获取远程服务返回的对象,注意点：需要import导入该对象
     */
public com.xingen.remoteservice.bean.ProcessBean getRemoteServiceObject() throws android.os.RemoteException;
}
