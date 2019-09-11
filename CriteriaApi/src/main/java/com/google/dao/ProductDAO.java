package com.google.dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class ProductDAO<SearchBeanCriteria> {
	private static final String ObjArryList = null;
	SessionFactory  sf = HBUtil.getSessionFactory();
	public List<String> ProductNamesList()
	{
		List<String> productNamesList =null;
		Session session = sf.openSession();
		CriteriaBuilder Builder = session.getCriteriaBuilder();
		CriteriaQuery<String> CriteriaQuery = Builder.createQuery(String.class);
		Root<ProductBean> root = CriteriaQuery.from(ProductBean.class);
		CriteriaQuery.select(root.get("productName"));
	TypedQuery<String> query = session.createQuery(CriteriaQuery);
	productNamesList = query.getResultList();
	
	
		
		
		return productNamesList;
		
	}
	public List<ProductBean> getAll()
	{
		List<ProductBean> productList = null;
		Session session = sf.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ProductBean> criteriaQuery = builder.createQuery(ProductBean.class);
		Root<ProductBean> root = criteriaQuery.from(ProductBean.class);
		criteriaQuery.select(root);
		TypedQuery<ProductBean> query = session.createQuery(criteriaQuery);
		productList = query.getResultList();
		return productList;
	}
	public List<Integer> getProductIds()
	{
		List<Integer> getproductIdList = null;
		Session session = sf.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Integer> criteriaQuery = builder.createQuery(Integer.class);
		Root<ProductBean> root = criteriaQuery.from(ProductBean.class);
		criteriaQuery.select(root.get("productId"));
		TypedQuery<Integer> query = session.createQuery(criteriaQuery);
		getproductIdList = query.getResultList();
		return getproductIdList;
	}
	public List<Float> getProductPrices()
	{
		List<Float> productIdList = null;
		Session session = sf.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Float> criteriaQuery = builder.createQuery(Float.class);
		Root<ProductBean> root = criteriaQuery.from(ProductBean.class);
		criteriaQuery.select(root.get("productPrice"));
		TypedQuery<Float> query = session.createQuery(criteriaQuery);
		productIdList = query.getResultList();
		return productIdList;
	}
	public List<ProductBean> pagination()
	{
		List<ProductBean> productList =null;
		Session session = sf.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ProductBean> criteriaQuery = 	builder.createQuery(ProductBean.class);
		Root<ProductBean> root = criteriaQuery.from(ProductBean.class);
		criteriaQuery.select(root);
		TypedQuery<ProductBean> query = session.createQuery(criteriaQuery);
		query.setFirstResult(1);
		query.setMaxResults(2);
		productList = query.getResultList();
		
		
				return productList;
		
	}
	public List<Object[]> getProductIDPrices()
	{
		List<Object[]> productIdPriceList = null;
		Session session = sf.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
		Root<ProductBean> root = criteriaQuery.from(ProductBean .class);
		criteriaQuery.multiselect(root.get("productId") , 
				root.get("productPrice"));
		TypedQuery<Object[]> query = session.createQuery(criteriaQuery);
		productIdPriceList = query.getResultList();
		return productIdPriceList;
	}
	public List<SearchCriteriaBean> getIdNamesRelaTimeUseCase() {
		List<SearchCriteriaBean> searchList = new ArrayList<SearchCriteriaBean>();

		List<Object[]> objArrayList = null;
		Session session = sf.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
		Root<ProductBean> root = criteriaQuery.from(ProductBean.class);
		criteriaQuery.multiselect(root.get("productPrice"), root.get("productName"));
		TypedQuery<Object[]> query = session.createQuery(criteriaQuery);
		objArrayList = query.getResultList();

		for (Object[] objArray : objArrayList) {
			SearchCriteriaBean searchBean = new SearchCriteriaBean();
			searchBean.setProductPrice((Float) objArray[0]);
			searchBean.setProductName((String) objArray[1]);

			searchList.add(searchBean);
		}

		return searchList;
	}

	
	}
