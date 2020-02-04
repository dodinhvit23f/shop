package com.shop.rest.request;

import com.shop.rest.base.BaseRestRequest;

public class ProductRequest extends BaseRestRequest {
  
    /**
     * tiendd
     */
    private static final long serialVersionUID = 2879722582746306573L;
    private String code;
    private String groupCode;
    private double inputPrice;
    private String insertby;
    private String name;
    private double outputPrice;
    private int quantyties;
    private String type;
    private String updateby;

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getGroupCode() {
	return groupCode;
    }

    public void setGroupCode(String groupCode) {
	this.groupCode = groupCode;
    }

    public double getInputPrice() {
	return inputPrice;
    }

    public void setInputPrice(double inputPrice) {
	this.inputPrice = inputPrice;
    }

    public String getInsertby() {
	return insertby;
    }

    public void setInsertby(String insertby) {
	this.insertby = insertby;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public double getOutputPrice() {
	return outputPrice;
    }

    public void setOutputPrice(double outputPrice) {
	this.outputPrice = outputPrice;
    }

    public int getQuantyties() {
	return quantyties;
    }

    public void setQuantyties(int quantyties) {
	this.quantyties = quantyties;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getUpdateby() {
	return updateby;
    }

    public void setUpdateby(String updateby) {
	this.updateby = updateby;
    }

}
