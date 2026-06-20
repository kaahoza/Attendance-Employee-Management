package com.anele.employee_management.controller;

import com.anele.employee_management.entity.EmployeeEntity;
import com.anele.employee_management.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/getEmployees")
    public List<EmployeeEntity> findAll(){
        return service.findAll();
    }

    @PostMapping("/addEmployee")
    public EmployeeEntity save(@RequestBody EmployeeEntity employee){
        return service.save(employee);
    }

    @GetMapping("/getOneEmployee/{id}")
    public String findById(@PathVariable String id){
        return service.findById(id);
    }
}
