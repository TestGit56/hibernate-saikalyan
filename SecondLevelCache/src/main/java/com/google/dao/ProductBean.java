package com.google.dao;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name ="Product")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)


public class ProductBean implements Serializable {
	
	@Id
	@GenericGenerator(name= "icr" ,strategy = "increment")
	@GeneratedValue(generator = "icr")
	@Column(name="PID")

	private Integer productId = null;
	@Column(name="PNAME")
	private String productName = null;
	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductBean(Integer productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "ProductBean [productId=" + productId + ", productName=" + productName + "]";
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	

}
