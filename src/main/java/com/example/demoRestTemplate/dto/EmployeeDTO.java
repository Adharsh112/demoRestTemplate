package com.example.demoRestTemplate.dto;

import com.example.demoRestTemplate.models.Address;
import com.example.demoRestTemplate.models.Employee;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO  {

    // first we need to bring the address entity from the other service and store it in the model
    // then we need a DTO - data transfer object will store the both the objects employee and Address
    // here since an employee can have multiple addresses we used a list
    private Employee employee;
    private List<Address> addresses;
}
