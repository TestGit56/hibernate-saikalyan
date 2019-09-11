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
 System.out.println("Get all "+dao.getAll());
 System.out.println("Get By Names "+dao.getProductNames());
 System.out.println("GetPRoductNAmeAndPrice "+dao.getNamePriceList());
 System.out.println("GetMAxPRice   "+dao.getMaxPrice());
 System.out.println("Search       "+dao.search("sai"));
 System.out.println("getBYId  "+dao.getProductByIdList());
 System.out.println("getProductPRiceList "+dao.getProductPRiceList());
 System.out.println("update         "+dao.getMinToMax());
 System.out.println("pagination  "+dao.pagination());
    }
}
