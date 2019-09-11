package com.google.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

public class ProductDAO {
	SessionFactory  sf = HBUtil.getSessionFactory();
	public List<ProductBean> getAll()
	{
		List<ProductBean> productList= null;
		Session session = sf.openSession();
		String sql = "select * From Product";
		
		NativeQuery query= session.createNativeQuery(sql);
		query.addEntity(ProductBean.class);
		productList = query.getResultList();
		
		return productList;
		
	}
	public List<String> getProductNames()
	{
		List<String> productNamesList = null;
		String sql = "Select PNAME from Product ";
		Session session = sf.openSession();
		
		NativeQuery<String> query = session.createNativeQuery(sql);
		query.addScalar("PNAME" , StringType.INSTANCE);
		productNamesList = query.getResultList();
		return productNamesList;
	}
	public List<SearchCriteriaBean> getNamePriceList()
	{
		List<SearchCriteriaBean> searchList = new ArrayList<SearchCriteriaBean>();
		Session session = sf.openSession();
		String sql = "Select PNAME , PRICE from Product";
		List<Object[]> ObjArryList = null;
		@SuppressWarnings("unchecked")
		NativeQuery<Object[]> query = session.createNativeQuery(sql);
		query.addScalar("PNAME" , StringType.INSTANCE);
		query.addScalar("PRICE" , FloatType.INSTANCE);
	
		ObjArryList = query.getResultList();

	
		for(Object[] ObjArry : ObjArryList)
		{
			SearchCriteriaBean searchBean = new SearchCriteriaBean();
			searchBean.setProductName( (String) ObjArry[0]);
			searchBean.setProductPrice( (Float)   ObjArry[1]);
			searchList.add(searchBean);
			
		}
		
		
		
		return searchList;
	}
	public Integer getMaxPrice()
	{
		 Integer count = null;
		 
		 String sql = "Select max(PRICE) MaxPrice from Product";
		 Session session = sf.openSession();
		 session.beginTransaction();
		 @SuppressWarnings("unchecked")
		NativeQuery<Integer> query = session.createNativeQuery(sql);
		 query.addScalar("MaxPrice" , FloatType.INSTANCE);
   count =  query.executeUpdate();
		 session.getTransaction().commit();
		 session.close();
		 
		return count;
	}
	public List<ProductBean> search(String productName)
	
	{
		List<ProductBean>  productList = null;
		Session session = sf.openSession();
		String sql = "Select * From Product where upper(PNAME) like :name";
		NativeQuery<ProductBean> query  = session.createNativeQuery(sql, ProductBean.class);
		query.setParameter("name", "%"+productName.trim().toUpperCase()+"%");
  productList =		query.getResultList();
		
		return productList;
	}
	public List<Integer> getProductByIdList()
	{
		  List<Integer> productIdList = null;
		  Session session = sf.openSession();
		  String sql = "Select PID from Product ";
		  NativeQuery<Integer> query = session.createNativeQuery(sql);
		  query.addScalar("PID" , IntegerType.INSTANCE);
		  productIdList =   query.getResultList();
		  
		return productIdList;
	}
	public List<Float> getProductPRiceList()
	{
		List<Float> productPriceList = null;
		Session session = sf.openSession();
		String sql = "Select PRICE From Product";
		NativeQuery<Float> query = session.createNativeQuery(sql);
		query.addScalar("PRICE" , FloatType.INSTANCE);
		productPriceList =  query.getResultList();
		return productPriceList;
	}
	public Integer getMinToMax()
	{
		Integer count = null;
		 Session session = sf.openSession();
		 String sql = "update Product set PRICE = :MaxPrice where PRICE <= :Minimum";
		 session.beginTransaction();
		 NativeQuery<ProductBean> query = session.createNativeQuery(sql, ProductBean.class);
		 query.setParameter("MaxPrice", 50000f);
		 query.setParameter("Minimum", 400f );
		 count =  query.executeUpdate();
		 session.getTransaction().commit();
		 session.close();
		 
		
		return count;
	}
	public List<ProductBean> pagination()
	{
		List<ProductBean> productBean  = null;
		 Session session = sf.openSession();
		 String sql = "Select * From Product";
		 NativeQuery<ProductBean> query = session.createNativeQuery(sql, ProductBean.class);
		 query.setFirstResult(1);
		 query.setMaxResults(3);
		 productBean = query.getResultList();
		 
		return productBean;
	}
}
