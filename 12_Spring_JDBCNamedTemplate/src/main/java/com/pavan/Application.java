package com.pavan;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.pavan.dto.EmployeeDto;
import com.pavan.service.EmployeeServiceImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		System.out.println();
		EmployeeServiceImpl emp = context.getBean(EmployeeServiceImpl.class);
		System.out.println("Employee Details by Password is :: ");
		List<EmployeeDto> empDetailsByPassword = emp.getEmployeessByPassword("mypassword", "password123",
				"strongpass1");
		empDetailsByPassword.forEach(System.out::println);

		System.out.println("********************************************************************************");

		String email = emp.getEmployeMailByEmpNumber("EMP143");
		System.out.println("Employee Mail Which You Are Locking for is: " + email);
		System.out.println("********************************************************************************");
		System.out.println();
		System.out.println("********************************************************************************");
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDate = now.format(dateformat);
		
		EmployeeDto dto = new EmployeeDto();
		dto.setEmployeeId(200);
		dto.setEmployeeNumber("EMP018");
		dto.setEmailId("Testing@gmail.com");
		dto.setPassword("Pav@0211");
		dto.setCreatedBy(1);
		
		dto.setCreatedOn(formattedDate);
		System.out.println("formatted Date :: " + formattedDate);
		
		
		Integer count = emp.registerEmployee(dto);
		
		System.out.println(count ==1 ?"employee Registration Successfully" : "Failed to register the employee");
		
		System.out.println("********************************************************************************");

		System.out.println(new java.util.Date());

		((ConfigurableApplicationContext) context).close();
	}

}
