package com.google;

import com.google.dao.ProductBean;

import com.google.dao.ProductDAO;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String args[])
	{
    ProductDAO dao = new ProductDAO();
    ProductBean product = dao.getByID(111);
    if(product == null)
    {
    	System.out.println("invalid  id");
    }
    else
    {
    	System.out.println(product);
    }
}
}

