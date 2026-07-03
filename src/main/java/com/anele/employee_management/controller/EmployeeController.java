package com.anele.employee_management.controller;

import com.anele.employee_management.dto.EmployeeDTO;
import com.anele.employee_management.dto.EmployeeResponse;
import com.anele.employee_management.entity.EmployeeEntity;
import com.anele.employee_management.service.EmployeeService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/eployees")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@Valid @RequestBody EmployeeDTO dto){
        EmployeeResponse savedEmployee = service.addEmployee(dto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

}
