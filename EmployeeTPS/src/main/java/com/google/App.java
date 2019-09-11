package com.google;

import com.google.dao.ContractEmployee;
import com.google.dao.Employee;
import com.google.dao.EmployeeDAO;
import com.google.dao.RegularEmployee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
EmployeeDAO dao = new EmployeeDAO();
    	
    
    	Employee emp = new Employee(1242, "Sai");
    	RegularEmployee regemp = new RegularEmployee(1254, "kalyan",5000f,800f);
    	ContractEmployee conemp = new ContractEmployee(1240, "siri","two-Year",1500f);
    	dao.save(emp);
    	dao.save(regemp);
    	dao.save(conemp);
   		
    }
}
