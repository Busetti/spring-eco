package com.guru.employee.dao;

import java.util.List;

public interface EmployeeDAO {
	public String getEmployeeName(int id);
	public void batchInsert(List<Employee> employees);
}