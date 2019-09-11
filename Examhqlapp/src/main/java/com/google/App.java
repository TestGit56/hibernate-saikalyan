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
        System.out.println("REALTIMEUSE "+dao.getIdNamesRealTimeUseCase()+"\n\n");
        System.out.println("MAXPRICE "+dao.getMaxPrice()+"\n\n");
        System.out.println("update "+dao.update()+"\n\n");
    }
}
