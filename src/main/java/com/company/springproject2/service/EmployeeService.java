package com.company.springproject2.service;

import com.company.springproject2.dto.request.EmployeeRequestDtoId;
import com.company.springproject2.dto.request.EmployeeRequestDto;
import com.company.springproject2.dto.response.EmployeeResponseDto;
import com.company.springproject2.dto.response.ResponseDto;
import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDto> findAll();
    EmployeeResponseDto findById(Long id);
    ResponseDto insert(EmployeeRequestDto employee);
    ResponseDto update(EmployeeRequestDtoId employee);
    ResponseDto delete(Long id);
}
