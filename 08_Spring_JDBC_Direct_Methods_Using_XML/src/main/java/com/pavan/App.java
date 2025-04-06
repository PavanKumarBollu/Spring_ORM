package com.pavan;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pavan.service.EmployeeMgmtServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/pavan/cfg/applicationContext.xml");
    	
    	EmployeeMgmtServiceImpl emp = context.getBean(EmployeeMgmtServiceImpl.class);
    	try {
			int count = emp.fetchEmpsCount();
			System.out.println("total Number of employees are :: " +count);
			
			
			String empName = emp.getEmployeeNameByNo(2);
			System.out.println("Employee Name By Using the QueryForObject(query, Returntype, Eno) :: " + empName);
    		
			System.out.println();
			System.out.println();
			
			Map<String, Object> empFullData = emp.getEmployeeDetailsByNo(2);
			System.out.println("Query For Map Employeee Details by No : " + empFullData);
			
    		
			System.out.println();
			List<Map<String, Object>> list = emp.getEmployeeDeatilsByAddress("HYD", "PY");
			System.out.println("Query For List Employees Details by Address : " );
			list.forEach(System.out::println);
			System.out.println();
			System.out.println("Inserting the Employee Using the Update method : " );
			int empInsert = emp.insertEmp("SpringJdbc", "Spring", 100000);
			
			System.out.println(empInsert==1?"Employee Record Inserted":"Employee Record Insertiong Failed");
			System.out.println();
			System.out.println("Add Bonus By Address:: HYD, 100000");
			int bonusToEmpByAddress = emp.addBonusToEmpByAddress("HYD", 100000);
			System.out.println(bonusToEmpByAddress>=0 ? "Bonus Added Successfull ":"Failed to Add bonus");
			
			
			
		} catch (Exception e) {
			System.out.println("Exception came " + e.getMessage());
			e.printStackTrace();
		}
    	
    	
    	
    	
    	((AbstractApplicationContext) context).close();
    }
}
