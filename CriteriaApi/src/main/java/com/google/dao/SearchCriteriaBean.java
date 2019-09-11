package com.google.dao;

public class SearchCriteriaBean {
	private String productName;
	private Float productPrice;
	public SearchCriteriaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchCriteriaBean(String productName, Float productPrice) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "SearchCriteriaBean [productName=" + productName + ", productPrice=" + productPrice + "]";
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
