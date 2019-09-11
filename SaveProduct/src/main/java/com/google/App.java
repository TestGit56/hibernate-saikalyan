package com.google;

import com.google.dao.ProductBean;
import com.google.dao.ProductDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ProductDAO dao = new ProductDAO();
       ProductBean saveRecord = new ProductBean(98,"sai",23.2f);
       ProductBean persistRecord = new ProductBean(908,"kalyan",100.2f);
       dao.save(saveRecord);
       dao.persist(persistRecord);
    }
}
