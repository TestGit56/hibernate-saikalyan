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
       ProductBean saveRecord = new ProductBean(121,"sai",23.2f);
      
       dao.save(saveRecord);
      
    }
}
