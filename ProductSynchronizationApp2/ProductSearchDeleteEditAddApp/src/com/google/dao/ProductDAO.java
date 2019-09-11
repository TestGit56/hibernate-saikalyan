package com.google.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ProductDAO {
	DataSource dataSource = DataSourceUtil.getDataSource()	;
	public List<ProductBean> search(String productName)throws DataSourceException{
		List<ProductBean> productList = new ArrayList<ProductBean>();
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try
		{
			con = dataSource.getConnection();
			ps = con.prepareStatement("Select PID , PNAME , PRICE From Product where upper(PNAME) like ?");
			ps.setString(1, "%"+productName.trim().toUpperCase()+"%");
			rs = ps.executeQuery();
			while(rs.next())
			{
				ProductBean product = new ProductBean();
				product.setProductId(rs.getInt("PID"));
				product.setProductName(rs.getString("PNAME"));
				product.setProductPrice(rs.getFloat("PRICE"));
				productList.add(product);
			}
		}catch (SQLException exp) {
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		}finally
		{
			if(rs!=null)
			{
				try
				{
					rs.close();
					
				}catch(Exception exp)
				{
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
			}
		}
			if(ps!=null)
			{
				try
				{
					ps.close();
					
				}catch(Exception exp)
				{
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
			}
		}
			if(con!=null)
			{
				try
				{
					con.close();
					
				}catch(Exception exp)
				{
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
			}
		}
		}

		return productList;
		
	}
	public boolean deleteProductById(Integer productId)throws DataSourceException{
	    boolean flag = false;
		Connection con = null;
		PreparedStatement ps =null;
	
		try
		{
			con = dataSource.getConnection();
			ps = con.prepareStatement("Delete From Product  where PID = ?");
			ps.setInt(1, productId);
			int count = ps.executeUpdate();
			if(count>0)
			{
				flag = true;
			}
			
			
		}catch (SQLException exp) {
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		}finally
		{
			
			if(ps!=null)
			{
				try
				{
					ps.close();
					
				}catch(Exception exp)
				{
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
			}
		}
			if(con!=null)
			{
				try
				{
					con.close();
					
				}catch(Exception exp)
				{
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
			}
		}
		}
	
return flag;
	}
	public List<ProductBean> getAll()throws DataSourceException{
 List<ProductBean> productList = new ArrayList<ProductBean>();
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try
		{
			con = dataSource.getConnection();
			ps = con.prepareStatement("Select PID , PNAME , PRICE From Product ");
		    rs = ps.executeQuery();
			while(rs.next())
			{
				ProductBean product = new ProductBean();
				product.setProductId(rs.getInt("PID"));
				product.setProductName(rs.getString("PNAME"));
				product.setProductPrice(rs.getFloat("PRICE"));
				productList.add(product);
			}
		}catch (SQLException exp) {
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		}finally
		{
			if(rs!=null)
			{
				try
				{
					rs.close();
					
				}catch(Exception exp)
				{
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
			}
		}
			if(ps!=null)
			{
				try
				{
					ps.close();
					
				}catch(Exception exp)
				{
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
			}
		}
			if(con!=null)
			{
				try
				{
					con.close();
					
				}catch(Exception exp)
				{
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
			}
		}
		}

		return productList;
}
	public ProductBean getProductById(Integer productId)throws DataSourceException{
		ProductBean product = null;
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try
		{
			con = dataSource.getConnection();
			ps = con.prepareStatement("Select PID , PNAME , PRICE From Product where PID = ?");
			ps.setInt(1, productId);
			rs = ps.executeQuery();
			while(rs.next())
			{
				 product = new ProductBean();
				product.setProductId(rs.getInt("PID"));
				product.setProductName(rs.getString("PNAME"));
				product.setProductPrice(rs.getFloat("PRICE"));
				
			}
		}catch (SQLException exp) {
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		}finally
		{
			if(rs!=null)
			{
				try
				{
					rs.close();
					
				}catch(Exception exp)
				{
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
			}
		}
			if(ps!=null)
			{
				try
				{
					ps.close();
					
				}catch(Exception exp)
				{
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
			}
		}
			if(con!=null)
			{
				try
				{
					con.close();
					
				}catch(Exception exp)
				{
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
			}
		}
		}

		return product;
}
	public void update(ProductBean product)throws DataSourceException{
		 
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con  = dataSource.getConnection();
			ps  = con.prepareStatement("Update Product SET  PNAME = ? , PRICE =?where PID = ?");
			ps.setString(1, product.getProductName());
			ps.setFloat(2, product.getProductPrice());
			ps.setInt(3,product.getProductId());
			ps.executeUpdate();
		}catch (SQLException exp) {
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		}
		if(ps!=null)
		{
			try
			{
				ps.close();
				
			}catch(Exception exp)
			{
				exp.printStackTrace();
				throw new DataSourceException(exp.getMessage());
		}
	}
		if(con!=null)
		{
			try
			{
				con.close();
				
			}catch(Exception exp)
			{
				exp.printStackTrace();
				throw new DataSourceException(exp.getMessage());
		}
	}
	}
	public boolean add(ProductBean product)throws DataSourceException{
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = dataSource.getConnection();
			ps = con.prepareStatement("Insert into Product(PID , PNAME , PRICE) values(?,?,?)");
			ps.setInt(1, product.getProductId());
			ps.setString(2,product.getProductName());
			ps.setFloat(3,product.getProductPrice()); 
			 int count = ps.executeUpdate();
			 
		}catch(SQLException exp)
		{
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		}catch(Exception exp)
		{
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		}
		
		return false;
		
	}
}

