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
      /* Employee emp = new Employee(222,"nandhini");
        RegularEmployee regemp = new RegularEmployee(444,"karishma",500f,600f);
        ContractEmployee conemp = new ContractEmployee(555,"Mahathi","to years",700f);
        dao.save(emp);
        dao.save(regemp);
        dao.save(conemp);*/
       dao.delete(222);
    }
}
