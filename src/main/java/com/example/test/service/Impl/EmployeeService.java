package com.example.test.service.Impl;

import com.example.test.mapper.EmployeeMapper;
import com.example.test.persistence.exception.NotFoundException;
import com.example.test.persistence.model.Employee;
import com.example.test.persistence.repository.IEmployeeRepository;
import com.example.test.service.IEmployeeService;
import com.example.test.web.dto.request.EmployeeRequest;
import com.example.test.web.dto.request.EmployeeUpdateRequest;
import com.example.test.web.dto.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository repository;

    @Autowired
    private EmployeeMapper mapper;

    @Override
    @Transactional
    public BaseResponse create(EmployeeRequest request) {
        Employee employeeCreated = repository.save(mapper.toEntity(request));
        return BaseResponse.builder()
                .data(mapper.toDto(employeeCreated))
                .message("Employee created successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .statusCode(201)
                .build();
    }

    @Override
    public BaseResponse getById(Long id) {
        Employee employeeFound = findAndEnsureExist(id);
        return BaseResponse.builder()
                .data(mapper.toDto(employeeFound))
                .message("Employee found successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .statusCode(200)
                .build();
    }

    @Override
    public BaseResponse getAll() {
        List<Employee> employees = repository.findAll();
        if (employees.isEmpty()){
            throw new NotFoundException("No employees found");
        }
        return BaseResponse.builder()
                .data(mapper.toDtoList(employees))
                .message("Employees found successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .statusCode(200)
                .build();
    }

    @Override
    @Transactional
    public BaseResponse update(EmployeeUpdateRequest request, Long id) {
        Employee employeeFound = findAndEnsureExist(id);
        employeeFound.setPosition(request.getPosition());
        employeeFound.setSalary(request.getSalary());

        Employee employeeUpdated = repository.save(employeeFound);
        return BaseResponse.builder()
                .data(mapper.toDto(employeeUpdated))
                .message("Employee updated successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .statusCode(200)
                .build();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(findAndEnsureExist(id));
    }

    private Employee findAndEnsureExist(Long id){
        return repository.findById(id).orElseThrow(() ->
                new NotFoundException("Employee with id " + id + " not found"));
    }
}
