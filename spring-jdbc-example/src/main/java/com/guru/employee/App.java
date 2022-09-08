package com.guru.employee;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.guru.employee.dao.Employee;
import com.guru.employee.dao.EmployeeDAO;

public class App {
	public static void main(String[] args) throws SQLException {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringJDBCConfiguration.class);

		EmployeeDAO empDAO = applicationContext.getBean(EmployeeDAO.class);

		// Batch Insert
		List<Employee> employees = Arrays.asList(new Employee(1, "guru", 20), new Employee(1, "nath", 30));
		empDAO.batchInsert(employees);

		String empName = empDAO.getEmployeeName(1);
		
		System.out.println("Employee name is " + empName);

		applicationContext.close();
	}
}