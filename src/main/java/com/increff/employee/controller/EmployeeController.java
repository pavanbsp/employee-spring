package com.increff.employee.controller;

import com.increff.employee.model.EmployeeData;
import com.increff.employee.model.EmployeeForm;
import com.increff.employee.pojo.EmployeePojo;
import com.increff.employee.service.ApiException;
import com.increff.employee.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@ApiOperation(value = "Adds an employee")
	@RequestMapping(path = "/api/employee", method = RequestMethod.POST)
	public void add(@RequestBody EmployeeForm form) {
		EmployeePojo p = convert(form);
		service.add(p);
	}

	
	@ApiOperation(value = "Deletes and employee")
	@RequestMapping(path = "/api/employee/{id}", method = RequestMethod.DELETE)
	// /api/1
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

	@ApiOperation(value = "Gets an employee by ID")
	@RequestMapping(path = "/api/employee/{id}", method = RequestMethod.GET)
	public EmployeeData get(@PathVariable int id) throws ApiException {
		EmployeePojo p = service.get(id);
		return convert(p);
	}

	@ApiOperation(value = "Gets list of all employees")
	@RequestMapping(path = "/api/employee", method = RequestMethod.GET)
	public List<EmployeeData> getAll() {
		List<EmployeePojo> list = service.getAll();
		List<EmployeeData> list2 = new ArrayList<EmployeeData>();
		for (EmployeePojo p : list) {
			list2.add(convert(p));
		}
		return list2;
	}

	@ApiOperation(value = "Updates an employee")
	@RequestMapping(path = "/api/employee/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable int id, @RequestBody EmployeeForm f) throws ApiException {
		EmployeePojo p = convert(f);
		service.update(id, p);
	}
	

	private static EmployeeData convert(EmployeePojo p) {
		EmployeeData d = new EmployeeData();
		d.setAge(p.getAge());
		d.setName(p.getName());
		d.setId(p.getId());
		return d;
	}

	private static EmployeePojo convert(EmployeeForm f) {
		EmployeePojo p = new EmployeePojo();
		p.setAge(f.getAge());
		p.setName(f.getName());
		return p;
	}

}
