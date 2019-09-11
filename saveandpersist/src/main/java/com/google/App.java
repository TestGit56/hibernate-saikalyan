package com.google;

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
        dao.sessionLevelCache();
    }
}
