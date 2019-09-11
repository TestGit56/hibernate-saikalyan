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
//     ProductBean productBean = new ProductBean(100,"two",123.2f);
//        dao.save(productBean); 

   
//    dao.get(100);  
//   dao.load(200);
   ProductBean productBean = new ProductBean(500,"six",226.5f);
   dao.saveOrUpdate(productBean);
    }
    
}
