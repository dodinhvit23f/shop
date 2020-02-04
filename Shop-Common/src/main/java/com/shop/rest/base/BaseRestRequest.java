package com.shop.rest.base;

import java.io.Serializable;

public class BaseRestRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long receiTime;
	
	public void setReceiTime(long receiTime) {
	    this.receiTime = receiTime;
	}

	public long getReceiTime() {
	    return receiTime;
	}
	
}
