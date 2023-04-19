package com.company.springproject2.handler;

import com.company.springproject2.dto.response.ExceptionResponse;
import com.company.springproject2.enums.ExceptionEnum;
import com.company.springproject2.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handle() {
        return ExceptionResponse.builder()
                .message(ExceptionEnum.EMPLOYEE_NOT_FOUND_EXCEPTION.getMessage())
                .localDateTime(LocalDateTime.now())
                .build();
    }
}
