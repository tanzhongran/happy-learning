package com.andy.learning.infrastructure;

public class BizException extends Exception {

    private String code;
    private String msg;

    public BizException(String code,String msg){
        super(msg);
        if("".equals(code.trim())){
            code = "BIZ_ERROR_000";
        }
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "调用接口异常 BizException [code=" + code + ", msg=" + msg + "]";
    }

}
