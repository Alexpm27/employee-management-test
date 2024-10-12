package com.example.test.web.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class EmployeeUpdateRequest {
    @NotNull(message = "Position cannot be null")
    @Size(min = 2, max = 50, message = "Position must be between 2 and 50 characters")
    private String position;

    @Min(value = 0, message = "Salary must be greater than or equal to 0")
    private double salary;
}
