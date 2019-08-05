package com.andy.learning.infrastructure.Util;

public class Result<T> {

    private int code;// 业务自定义状态码

    private String msgCode;

    private String msg;// 请求状态描述，调试用

    private T data;// 请求数据，对象或数组均可

    public Result() {
    }

    /**
     * 成功时候的调用
     * @param data data
     * @param <T> t
     * @return Result
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    /**
     * 失败时候的调用
     * @param msgCode
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(String msgCode,String msg){
        return new Result<T>(msgCode,msg);
    }

    /**
     * 成功的构造函数
     * @param data data
     */
    public Result(T data){
        this.code = 20000;//默认200是成功
        this.msg = "SUCCESS";
        this.msgCode = "";
        this.data = data;
    }

    public Result(String msgCode, String msg) {
        this.code = 50000;
        this.msgCode = msgCode;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }
}