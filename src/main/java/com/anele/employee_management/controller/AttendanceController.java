package com.anele.employee_management.controller;

import com.anele.employee_management.entity.EmployeeEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @PostMapping("/mark")
    public String markAttendance(){
        return "success";
    }

    @GetMapping("/{id}")
    public List<EmployeeEntity> findAttendanceById(@PathVariable String id){
        return null;
    }

}
