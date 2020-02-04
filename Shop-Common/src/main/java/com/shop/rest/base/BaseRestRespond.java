package com.shop.rest.base;

import java.io.Serializable;

/**
 * tiendd
 */

public class BaseRestRespond implements Serializable {

    private static final long serialVersionUID = 250179657056418418L;
    private long replyTime;
    private String responseCode;
    private String responseDesc;

    public long getReplyTime() {
	return replyTime;
    }

    public void setReplyTime(long replyTime) {
	this.replyTime = replyTime;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }
    
}
