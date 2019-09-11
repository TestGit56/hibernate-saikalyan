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
        
       Employee emp = new Employee(111,"Srinu");
       RegularEmployee regemp = new RegularEmployee(222,"sai",1222f,1433f);
       ContractEmployee conemp = new ContractEmployee(333,"kalyan","year",1005f);
       dao.saveOrUpdate(emp);
       dao.saveOrUpdate(regemp);
       dao.saveOrUpdate(conemp);
    }
}
