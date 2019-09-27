package com.datageeks;

import com.datageeks.dao.ContractEmployee;
import com.datageeks.dao.Employee;
import com.datageeks.dao.EmployeeDAO;
import com.datageeks.dao.RegularEmployee;

/**	
 * Hello world!
 *
 */
public class App 
{	
    public static void main( String[] args )
    {

    	EmployeeDAO dao = new EmployeeDAO();
    	
    	
    	Employee emp = new Employee(1242, "Srinu Np");
    	RegularEmployee regemp = new RegularEmployee(1254, "Tirumal T",5000f,800f);
    	ContractEmployee conemp = new ContractEmployee(1240, "Rajeev R","two-Year",1500f);
    	dao.saveOrUpdate(emp);
    	dao.saveOrUpdate(regemp);
    	dao.saveOrUpdate(conemp);
   
    	
    	// System.out.println(dao.getById(1240));
    	
    	//dao.delete(1242);
    		
    }
}
