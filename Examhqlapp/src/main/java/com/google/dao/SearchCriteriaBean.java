package com.google.dao;

public class SearchCriteriaBean {
	private Integer productId;
	private String productName;
	public SearchCriteriaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchCriteriaBean(Integer productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "SearchCriteriaBean [productId=" + productId + ", productName=" + productName + "]";
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
