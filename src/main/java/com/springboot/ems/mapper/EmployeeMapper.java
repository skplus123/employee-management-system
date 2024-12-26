package com.springboot.ems.mapper;

import com.springboot.ems.dto.EmployeeDto;
import com.springboot.ems.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmailId()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstname(),
                employeeDto.getLastname(),
                employeeDto.getEmailId()
        );
    }
}
