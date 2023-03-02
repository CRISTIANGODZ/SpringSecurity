package com.cqupt.security.utils;

/**
 * @auther DyingZhang
 * @Create 2023-03-02 下午 7:29
 * @Discriptioon
 */
public class Result<T> {

    /**
     * 返回码
     */
    private int code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 具体内容(返回的数据)
     */
    private T data;

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
}
