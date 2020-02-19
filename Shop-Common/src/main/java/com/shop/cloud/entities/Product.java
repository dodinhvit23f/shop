package com.shop.cloud.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String code;
	private String description;
	private String groupCode;
	private double inputPrice;
	private String insertBy;
	private Date insertDate;
	private String name;
	private double outputPrice;
	private String parentCode;
	private int quantities;
	private String status;
	private String type;
	private String updateby;
	private Date updateDate;

	public Product() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	@Lob
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getGroupCode() {
		return this.groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}


	public double getInputPrice() {
		return this.inputPrice;
	}

	public void setInputPrice(double inputPrice) {
		this.inputPrice = inputPrice;
	}


	public String getInsertBy() {
		return this.insertBy;
	}

	public void setInsertBy(String insertBy) {
		this.insertBy = insertBy;
	}


	@Temporal(TemporalType.DATE)
	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public double getOutputPrice() {
		return this.outputPrice;
	}

	public void setOutputPrice(double outputPrice) {
		this.outputPrice = outputPrice;
	}


	public String getParentCode() {
		return this.parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}


	public int getQuantities() {
		return this.quantities;
	}

	public void setQuantities(int quantities) {
		this.quantities = quantities;
	}


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getUpdateby() {
		return this.updateby;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}


	@Temporal(TemporalType.DATE)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}