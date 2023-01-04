package com.increff.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increff.employee.dao.EmployeeDao;
import com.increff.employee.pojo.EmployeePojo;

@Service
public class EmployeeService1 {

    @Autowired
    private EmployeeDao dao;

    public void init() {

    }

    public void addList(List<EmployeePojo> list) {
        for (EmployeePojo p : list) {
            dao.insert(p);
        }
    }

}