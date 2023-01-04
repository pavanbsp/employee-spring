package com.increff.employee.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.increff.employee.model.UserData;
import com.increff.employee.model.UserForm;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
public class ApiController {


    @ApiOperation(value = "Say hello")
    @RequestMapping(path = "/api/say-hello", method = RequestMethod.POST)
    public UserData sayHello(@RequestBody UserForm userform) {
        UserData data = new UserData();
        data.setName(userform.getName());
        data.setMessage("Howdy!");
        return data;
    }

    @ApiOperation(value = "Say hello 2")
    @RequestMapping(path = "/api/say-hello2", method = RequestMethod.GET)
    public UserData sayHello2() {
        UserData data = new UserData();
        data.setName("Default user");
        data.setMessage("Howdy!");
        return data;
    }

}