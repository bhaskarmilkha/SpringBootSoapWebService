/**
 * 
 */
package com.springbootsoap.endpoint;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.springbootsoap.model.Employee;
import com.springbootsoap.service.EmployeeService;

import allapis.springbootsoap.com.AddEmployeeRequest;
import allapis.springbootsoap.com.AddEmployeeResponse;
import allapis.springbootsoap.com.DeleteEmployeeRequest;
import allapis.springbootsoap.com.DeleteEmployeeResponse;
import allapis.springbootsoap.com.EmployeeInfo;
import allapis.springbootsoap.com.GetEmployeeByIdRequest;
import allapis.springbootsoap.com.GetEmployeeResponse;
import allapis.springbootsoap.com.ServiceStatus;
import allapis.springbootsoap.com.UpdateEmployeeRequest;
import allapis.springbootsoap.com.UpdateEmployeeResponse;

/**
 * @author BHASKAR
 *
 */

@Endpoint
public class EmployeeEndPoint {

	private static final String NAMESPACE_URI = "http://com.springbootsoap.allapis";
	
	@Autowired
	EmployeeService employeeService;
	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
	@ResponsePayload
	public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {

		AddEmployeeResponse response = new AddEmployeeResponse();
		ServiceStatus serviceStatus = new ServiceStatus();

		Employee employee = new Employee();
		BeanUtils.copyProperties(request.getEmployeeInfo(), employee);

		employeeService.addEmployee(employee);
		serviceStatus.setStatus("Success");
		serviceStatus.setMessage("Added Successfully");

		response.setServiceStatus(serviceStatus);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIdRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeByIdRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();

		EmployeeInfo employeeInfo = new EmployeeInfo();
		BeanUtils.copyProperties(employeeService.getEmployeeById(request.getEmployeeId()), employeeInfo);

		response.setEmployeeInfo(employeeInfo);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
	@ResponsePayload
	public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {

		UpdateEmployeeResponse response = new UpdateEmployeeResponse();

		Employee employee = new Employee();
		BeanUtils.copyProperties(request.getEmployeeInfo(), employee);

		ServiceStatus serviceStatus = new ServiceStatus();
		serviceStatus.setMessage("Successfully Updated");
		serviceStatus.setStatus("Success");

		response.setServiceStatus(serviceStatus);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
	@ResponsePayload
	public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request) {

		DeleteEmployeeResponse response = new DeleteEmployeeResponse();

		employeeService.deleteEmployee(request.getEmployeeId());

		ServiceStatus serviceStatus = new ServiceStatus();
		serviceStatus.setMessage("Successfully Deleted");
		serviceStatus.setStatus("Success");

		response.setServiceStatus(serviceStatus);

		return response;

	}
}
