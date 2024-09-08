package com.example.demoRestTemplate.controllers;

import com.example.demoRestTemplate.client.AddressClient;
import com.example.demoRestTemplate.dto.EmployeeDTO;
import com.example.demoRestTemplate.models.Address;
import com.example.demoRestTemplate.models.Employee;
import com.example.demoRestTemplate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressClient addressClient;

    @PostMapping
    ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        Employee savedEmployee = employeeRepository.save(employeeDTO.getEmployee());
        if (savedEmployee != null && savedEmployee.getEmpId() > 0){
            addressClient.saveAddress(employeeDTO.getAddresses(),savedEmployee.getEmpId());
        }
        return new ResponseEntity<String>("the employee is created with employeeId " + savedEmployee.getEmpId(),HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Employee>> getAllEmployee (){
        List<Employee> AllEmployee = employeeRepository.findAll();
        return new ResponseEntity<>(AllEmployee,HttpStatus.CREATED);
    }

}
