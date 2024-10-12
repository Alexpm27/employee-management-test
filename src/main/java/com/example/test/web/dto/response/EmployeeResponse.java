package com.example.test.web.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class EmployeeResponse {
    private Long id;

    private String name;

    private String position;

    private double salary;

    private LocalDate hiringDate;
}
