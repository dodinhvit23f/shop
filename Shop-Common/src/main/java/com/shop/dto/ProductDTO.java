package com.shop.dto;

import java.io.Serializable;

/**
 * The persistent class for the products database table.
 * 
 */

public class ProductDTO implements Serializable {
    /**
     * tiendd
     */
    private static final long serialVersionUID = 6503222894923122972L;
    private String code;
    private String description;
    private String groupCode;
    private double inputPrice;
    private String insertBy;
    private String name;
    private double outputPrice;
    private String parentCode;
    private int quantities;
    private String status;
    private String type;
    private String updateby;

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
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

    public String getInsertBy() {
	return insertBy;
    }

    public void setInsertBy(String insertBy) {
	this.insertBy = insertBy;
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

    public String getParentCode() {
	return parentCode;
    }

    public void setParentCode(String parentCode) {
	this.parentCode = parentCode;
    }

    public int getQuantities() {
	return quantities;
    }

    public void setQuantities(int quantities) {
	this.quantities = quantities;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
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