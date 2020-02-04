package com.shop.rest.base;

import java.io.Serializable;

import com.shop.rest.RestHeader;

public class BaseRestCommunication implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 565588552278672214L;
    private RestHeader header;
    private String body;
    
    public RestHeader getHeader() {
        return header;
    }
    public void setHeader(RestHeader header) {
        this.header = header;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }	
    
}
