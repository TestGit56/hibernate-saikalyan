package com.google;

import java.util.List;

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
        System.out.println("ProductNamesList   "+dao.ProductNamesList());
        System.out.println("getAll   "+dao.getAll());
        System.out.println("getProductIds "+dao.getProductIds());
        System.out.println("getProductPrices "+dao.getProductPrices());
         System.out.println("pagination   "+dao.pagination());
         System.out.println("productIdPriceList ");
         List<Object[]> ObjArryList = dao.getProductIDPrices();
         for(Object[] ObjArry : ObjArryList)
         {
        	 for(Object element : ObjArry)
        	 {
        		 System.out.print(element +"\t\t");
        	 }
        	 System.out.println();
         }
         System.out.println("getIdNamesRelaTimeUseCase   "+dao.getIdNamesRelaTimeUseCase());
    }
}
