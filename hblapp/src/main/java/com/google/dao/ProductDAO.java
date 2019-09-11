package com.google.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class ProductDAO {
	SessionFactory sf = HBUtil.getSessionFactory();
	
public List<ProductBean> getAll(){
	List<ProductBean> productList = null;
	Session session = sf.openSession();
	String hql = "Select p From ProductBean as p";
	TypedQuery<ProductBean> query = session.createQuery(hql, ProductBean.class);
	 
	productList= query.getResultList();
	
	
	return productList;

}
public List<ProductBean> pagination()
{
	List<ProductBean> productList = null;
	Session session = sf.openSession();
	String hql = "Select p From ProductBean as p ";
	TypedQuery<ProductBean> query = session.createQuery(hql, ProductBean.class);
	query.setFirstResult(0);
	query.setMaxResults(3);
	productList = query.getResultList();
			
	return productList;
	
}
public List<ProductBean> search(String productName)
{
	List<ProductBean> productList = null;
	;
	Session session = sf.openSession();
	String hql = " Select  p From ProductBean as p where upper(p.productName) like :name";
	TypedQuery<ProductBean> query = session.createQuery(hql, ProductBean.class);
	query.setParameter("name", "%"+productName.trim().toUpperCase()+"%");
	productList = query.getResultList();
	
	
	return productList;
	
}
  public List<String> getProductNames()
{
	List<String> productNameList = null;
	Session session  = sf.openSession();
	String hql = "Select p.productName From ProductBean as p ";
	TypedQuery<String> query = session.createQuery(hql, String.class);
	productNameList = query.getResultList();
	return productNameList;
   }
  public List<Integer> getProductIds()
  {
  	List<Integer> productIdsList = null;
  	Session session  = sf.openSession();
  	String hql = "Select p.productId From ProductBean as p ";
  	TypedQuery<Integer> query = session.createQuery(hql, Integer.class);
  	productIdsList = query.getResultList();
  	return productIdsList;
     }
  public List<Object[]> productIdNamesList()
  {
	  List<Object[]> productIdNamesList = null;
	  Session session = sf.openSession();
	  String hql = "Select p.productId , p.productName From ProductBean as p";
	  TypedQuery<Object[]> query = session. createQuery(hql, Object[].class);
	  productIdNamesList = query.getResultList();
	  
	  return productIdNamesList;
  }
  public List<ProductBean> NamedQueryExamples()
  {
	  List<ProductBean> productList = null;
	  Session session = sf.openSession();
	  TypedQuery<ProductBean> query = session.getNamedQuery("findingforProducts");
	productList =  query.getResultList();
			  return productList;
  }
  
    }

