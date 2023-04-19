package com.company.springproject2.exception;

import com.company.springproject2.enums.ExceptionEnum;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException () {
        super(ExceptionEnum.EMPLOYEE_NOT_FOUND_EXCEPTION.getMessage());
    }
}
