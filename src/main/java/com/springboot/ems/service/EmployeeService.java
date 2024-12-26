package com.springboot.ems.service;

import com.springboot.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    void deleteEmployee(Long employeeId);
}
