package com.example.test.web.controller.advice;

import com.example.test.persistence.exception.NotFoundException;
import com.example.test.web.dto.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseResponse> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(
                BaseResponse.builder()
                        .message(ex.getMessage())
                        .success(false)
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .statusCode(404)
                        .build(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(
                BaseResponse.builder()
                        .data(errors)
                        .message("Validation error")
                        .success(false)
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .statusCode(400)
                        .build(),
                HttpStatus.BAD_REQUEST);
    }
}
