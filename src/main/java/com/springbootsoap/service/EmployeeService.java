/**
 * 
 */
package com.springbootsoap.service;

import com.springbootsoap.model.Employee;

/**
 * @author BHASKAR
 *
 */
public interface EmployeeService {

	void addEmployee(Employee employee);

	Employee getEmployeeById(long employeeId);

	void updateEmployee(Employee employee);

	void deleteEmployee(long employeeId);

}
