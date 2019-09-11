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
    		
    		ProductBean product = dao.getByID(222);
    			if(product == null)
    			{
    				System.out.println(" Invalid ID ");
    			}else
    			{
    				System.out.println(product);
    			}
    }
}