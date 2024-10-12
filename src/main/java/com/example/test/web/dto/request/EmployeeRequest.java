package com.example.test.web.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class EmployeeRequest {
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotNull(message = "Position cannot be null")
    @Size(min = 2, max = 50, message = "Position must be between 2 and 50 characters")
    private String position;

    @Min(value = 0, message = "Salary must be greater than or equal to 0")
    private double salary;

    @NotNull(message = "Hiring date cannot be null")
    @PastOrPresent(message = "Hiring date cannot be in the future")
    private LocalDate hiringDate;
}
