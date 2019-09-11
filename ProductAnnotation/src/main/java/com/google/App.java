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
ProductDAO dao =  new ProductDAO();
ProductBean productBean  = new ProductBean(999,"srinu",000.2f);
dao.save(productBean);
    }
}
