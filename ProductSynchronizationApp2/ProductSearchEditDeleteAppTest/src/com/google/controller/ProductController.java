package com.google.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.dao.ProductBean;
import com.google.service.ProductService;
import com.google.service.ServicesException;
@WebServlet(urlPatterns= {"/search","/delete","/editPage" ,"/update"})
public class ProductController  extends HttpServlet{
	ProductService service = new ProductService();

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	String reqPath = request.getServletPath();
	if(reqPath.endsWith("search"))
	{
		String productName = request.getParameter("productName");
		if(productName == null || productName.trim().length()==0)
		{
			request.setAttribute("productNameRequired", "please give");
			request.getRequestDispatcher("/search.jsp").forward(request, response);
		}
		else
		{
			try
			{
				List<ProductBean> productList = service.search(productName);
				if(productList == null || productList.size() == 0)
				{
					request.setAttribute("invalidName","Not Found");
					request.getRequestDispatcher("/search.jsp").forward(request, response);
					
				}else
				{
					request.setAttribute("productList", productList);
					request.getRequestDispatcher("/success.jsp").forward(request, response);
				}
				}
			catch (ServicesException e) {
				response.sendRedirect("./error.jsp");
				
			}
		}
	}else if(reqPath.endsWith("/delete"))
	{
		Integer productId = Integer.valueOf(request.getParameter("productId"));
		try
		{
			boolean flag=service.deleteProductById(productId);
			List<ProductBean> productList = service.getAll();
			if(productList == null || productList.size()==0)
			{
				request.setAttribute("noData", "No Products Avaliable Mr.Saikalyan");
				request.getRequestDispatcher("/search.jsp").forward(request, response);
				
			}else
			{
				request.setAttribute("productList", productList);
				request.getRequestDispatcher("/success.jsp").forward(request, response);
			}
			
		}catch (ServicesException e) {
		response.sendRedirect("./error.jsp");
		}
	}else if(reqPath.endsWith("/editPage"))
	{
		Integer productId = Integer.valueOf(request.getParameter("productId"));
				
					try
					{
		ProductBean product =  service.getProductById(productId);
		request.setAttribute("product", product);
		request.getRequestDispatcher("/edit.jsp").forward(request, response);
			
				}catch (ServicesException e) {
					response.sendRedirect("./error.jsp");
				}
	}else if(reqPath.endsWith("/update"))
	{
		Integer productId = Integer.valueOf(request.getParameter("productId"));
		String productName = request.getParameter("productName");
		Float productPrice = Float.valueOf(request.getParameter("productPrice"));
		try
		{
			ProductBean product = new ProductBean(productId, productName, productPrice);
			service.update(product);
			List<ProductBean> productList = service.getAll();
			request.setAttribute("productList", productList);
			request.getRequestDispatcher("/success.jsp").forward(request, response);
			
			 
		}catch (ServicesException e) {
			response.sendRedirect("./error.jsp");
		}
	}
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	this.doGet(request, response);
}

}
