package com.springboot.ems.service.impl;

import com.springboot.ems.dto.EmployeeDto;
import com.springboot.ems.entity.Employee;
import com.springboot.ems.exception.ResourceNotFoundException;
import com.springboot.ems.mapper.EmployeeMapper;
import com.springboot.ems.repository.EmployeeRepository;
import com.springboot.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->
                    new ResourceNotFoundException("Employee doen't exist for this Id: " + employeeId)
                );
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employeeDtoList = employeeRepository.findAll();
        return employeeDtoList.stream().map(employee ->
            EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee doen't exist for this Id: " + employeeId)
                );

        employee.setFirstName(updatedEmployee.getFirstname());
        employee.setLastName(updatedEmployee.getLastname());
        employee.setEmailId(updatedEmployee.getEmailId());
        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee doen't exist for this Id: " + employeeId)
                );

        employeeRepository.deleteById(employeeId);
    }

}
