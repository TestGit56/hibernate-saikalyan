package com.google.dao;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "Product")
public class ProductBean  implements Serializable{
	@Id
	@GenericGenerator(name ="icr" ,strategy = "increment")
	@GeneratedValue(generator= "increment")
	
	@Column(name = "PID")
	private Integer productId;
	@Column(name="PNAME")
	private String productName;
	@Column(name="PRICE")
private Float productPrice;
public ProductBean(Integer productId, String productName, Float productPrice) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.productPrice = productPrice;
}
public ProductBean() {
	super();
	// TODO Auto-generated constructor stub
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
public Float getProductPrice() {
	return productPrice;
}
public void setProductPrice(Float productPrice) {
	this.productPrice = productPrice;
}

}
