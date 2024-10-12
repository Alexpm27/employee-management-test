package com.example.test.mapper;

import com.example.test.persistence.model.Employee;
import com.example.test.web.dto.request.EmployeeRequest;
import com.example.test.web.dto.response.EmployeeResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeMapper {
    public Employee toEntity(EmployeeRequest request){
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setPosition(request.getPosition());
        employee.setSalary(request.getSalary());
        employee.setHiringDate(request.getHiringDate());
        return employee;
    }

    public EmployeeResponse toDto(Employee employee){
        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .position(employee.getPosition())
                .salary(employee.getSalary())
                .hiringDate(employee.getHiringDate())
                .build();
    }

    public List<EmployeeResponse> toDtoList(List<Employee> employeeList){
        return employeeList.stream()
                .map(this::toDto)
                .toList();
    }
}
