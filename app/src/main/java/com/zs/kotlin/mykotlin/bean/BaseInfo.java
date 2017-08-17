package com.zs.kotlin.mykotlin.bean;

import java.io.Serializable;

/**
 * Created by cuijl on 2016/6/13.
 */
public class BaseInfo implements Serializable {
    String status;
    String msg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
