package com.anele.employee_management.service;

import com.anele.employee_management.entity.EmployeeEntity;
import com.anele.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<EmployeeEntity> findAll(){
        return repository.findAll();
    }


    public EmployeeEntity save(EmployeeEntity employee){
        return repository.save(employee);
    }

    public String findById(String id){

        return repository.findById(id).get().getFirstName();
    }
}
