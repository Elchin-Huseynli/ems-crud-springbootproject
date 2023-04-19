package com.company.springproject2.service.impl;

import com.company.springproject2.dto.request.*;
import com.company.springproject2.dto.response.EmployeeResponseDto;
import com.company.springproject2.dto.response.ResponseDto;
import com.company.springproject2.exception.EmployeeNotFoundException;
import com.company.springproject2.model.Employee;
import com.company.springproject2.repository.EmployeeRepository;
import com.company.springproject2.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<EmployeeResponseDto> findAll() {
        return employeeRepository.findAll().stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponseDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public EmployeeResponseDto findById(Long id) {
        return modelMapper.map(employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new),
                EmployeeResponseDto.class);
    }

    @Override
    public ResponseDto insert(EmployeeRequestDto employee) {
        return employeeRepository.insert(modelMapper.map(employee, Employee.class)) > 0
                ? new ResponseDto("Employee created successfully!") :
                new ResponseDto("Employee created failed!");
    }

    @Override
    public ResponseDto update(EmployeeRequestDtoId employee) {
        return employeeRepository.update(modelMapper.map(employee, Employee.class)) > 0
                ? new ResponseDto("Employee updated successfully!") :
                new ResponseDto("Employee updated failed!");

    }

    @Override
    public ResponseDto delete(Long id) {
        return employeeRepository.delete(id) > 0
                ? new ResponseDto("Employee deleted successfully!") :
                new ResponseDto("Employee deleted failed!");

    }
}
