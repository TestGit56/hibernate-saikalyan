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
       System.out.println("getAll "+dao.getAll());
      System.out.println("Pagination "+dao.pagination());
      System.out.println("SEARCH "+dao.search("sai"));
      System.out.println("ProductNamesList "+dao.getProductNames()+"\n\n");
      System.out.println("ProductIDs List"+dao.getProductIds()+"\n\n");
      System.out.println("ProductIDNAMESLISt "+dao.productIdNamesList());
    List<Object[]> objArryList = dao.productIdNamesList();
	for(Object[]  objArry:objArryList)
      {
    	  for(Object element:objArry)
    	  {
    		  System.out.print(element);
    	  }
    	  System.out.println();
      }
	System.out.println("DEmoONNamesQueries   "+dao.NamedQueryExamples()+"\n\n");
	
    }
}
