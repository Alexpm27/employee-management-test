package com.example.test.web.controller;

import com.example.test.service.IEmployeeService;
import com.example.test.web.dto.request.EmployeeRequest;
import com.example.test.web.dto.request.EmployeeUpdateRequest;
import com.example.test.web.dto.response.BaseResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService service;

    @PostMapping
    public ResponseEntity<BaseResponse> create(@Valid @RequestBody EmployeeRequest request){
        return service.create(request).apply();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getById(@PathVariable Long id){
        return service.getById(id).apply();
    }

    @GetMapping("/employees")
    public ResponseEntity<BaseResponse> getById(){
        return service.getAll().apply();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> update(@Valid @RequestBody EmployeeUpdateRequest request, @PathVariable Long id){
        return service.update(request, id).apply();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
