package com.company.springproject2.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionEnum {
    EMPLOYEE_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "Employee not found!");

    private final HttpStatus status;
    private final String message;
}
