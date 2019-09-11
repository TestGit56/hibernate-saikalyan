package com.google.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class ProductDAO {
	SessionFactory sf = HBUtil.getSessionFactory();

	public List<SearchCriteriaBean> getIdNamesRealTimeUseCase()
	{
		Session session = sf.openSession();
		List<Object[]> objArryList = null;
		List<SearchCriteriaBean> searchList = new ArrayList<SearchCriteriaBean>();
		String hql = "Select p.productId , p.productName From ProductBean as p";
			TypedQuery<Object[]> query = session.createQuery(hql,Object[].class);
			objArryList=query.getResultList();
		
		

		
		for(Object objArry[]:objArryList)
		{
			SearchCriteriaBean  searchBean = new SearchCriteriaBean();
			searchBean.setProductId((Integer )objArry[0]);
			searchBean.setProductName((String) objArry[1]);
			searchList.add(searchBean);
			
		}
		return searchList;
	}
	public Float getMaxPrice() {
		Float maxPrice = null;
		String hql = " Select  max(p.productPrice) From ProductBean as p";

		Session session = sf.openSession();

		TypedQuery<Float> query = session.createQuery(hql, Float.class);

		maxPrice = query.getSingleResult();

		return maxPrice;
	}
	public Integer update()
	{
		Integer count = null;
		Session session = sf.openSession();
		String hql = "update ProductBean  as p set p.productPrice = p.productPrice+ :increment "
				+ "  where p.productPrice <= :minimum";
	 Query query = session.createQuery(hql);
	 session.beginTransaction();
	 query.setParameter("increment", 25000f);
	 query.setParameter("minimum", 300f);
	count =  query.executeUpdate();
	 session.getTransaction().commit();
	 
		return count;
		
	}
	}

