package com.pavan;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.pavan.dto.StudentDto;
import com.pavan.service.StudentMngtServiceImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		StudentMngtServiceImpl stdBean = context.getBean(StudentMngtServiceImpl.class);
		StudentDto dto = stdBean.getStudentByNo(1);
		System.out.println(dto);
		
		System.out.println();
		System.out.println();
		
		System.out.println("Students Details by names:: ");
		List<StudentDto> stdNames = stdBean.getStudentsByNames("Pavan", "Krishna");
		stdNames.forEach(System.out::println);
		System.out.println();
		System.out.println("Get students Deatils by Address:::");
		List<StudentDto> stdNamesbyAddress = stdBean.getStudentsByAddress("HYDERABAD", "MI");
		stdNamesbyAddress.forEach(System.out::println);
		
		
		((ConfigurableApplicationContext) context).close();
	}

}
