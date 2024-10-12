package com.example.test.service;

import com.example.test.web.dto.request.EmployeeRequest;
import com.example.test.web.dto.request.EmployeeUpdateRequest;
import com.example.test.web.dto.response.BaseResponse;

import java.util.List;

public interface IEmployeeService {
    BaseResponse create(EmployeeRequest request);

    BaseResponse getById(Long id);

   BaseResponse getAll();

    BaseResponse update(EmployeeUpdateRequest request, Long id);

    void delete(Long id);
}
