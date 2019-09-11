package com.google.service;


import java.util.List;

import com.google.dao.DataSourceException;
import com.google.dao.ProductBean;
import com.google.dao.ProductDAO;

public class ProductService {
	ProductDAO dao = new ProductDAO();
	public List<ProductBean> search(String productName) throws ServicesException{
		List<ProductBean> productList = null;
		try
		{
			productList = dao.search(productName);
		}catch(DataSourceException exp)
		{
			exp.printStackTrace();
			throw new ServicesException(exp.getMessage());
	
		}
		return productList;
		
	}
	public ProductBean getProductById(Integer productId) throws ServicesException{
	ProductBean productBean = null;
		try
		{
			productBean = dao.getProductById(productId);
		}catch(DataSourceException exp)
		{
			exp.printStackTrace();
			throw new ServicesException(exp.getMessage());
	
		}
		return productBean;
		
	}
	public List<ProductBean> getAll() throws ServicesException{
		List<ProductBean> productList = null;
		try
		{
			productList = dao.getAll();
		}catch(DataSourceException exp)
		{
			exp.printStackTrace();
			throw new ServicesException(exp.getMessage());
	
		}
		return productList;
		
	}
	public void update(ProductBean product)throws ServicesException{
		try
		{
			dao.update(product);
		}catch(DataSourceException exp)
		{
			exp.printStackTrace();
			throw new ServicesException(exp.getMessage());
	
		}
	}
	public boolean deleteProductById(Integer productId)throws ServicesException{
		boolean flag = false;
		try
		{
			flag = dao.deleteProductById(productId);
		}catch(DataSourceException exp)
		{
			exp.printStackTrace();
			throw new ServicesException(exp.getMessage());
	
		}
		
		return flag;
		
	}
}
