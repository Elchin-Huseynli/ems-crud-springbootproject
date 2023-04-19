package com.company.springproject2.controller;

import com.company.springproject2.dto.request.EmployeeRequestDtoId;
import com.company.springproject2.dto.request.EmployeeRequestDto;
import com.company.springproject2.dto.response.EmployeeResponseDto;
import com.company.springproject2.dto.response.ResponseDto;
import com.company.springproject2.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeResponseDto> employees() {
        log.info("GET - /employees -> request none");
        List<EmployeeResponseDto> response = employeeService.findAll();
        log.info("GET - /employees - response -> {}", response);
        return response;
    }

    @GetMapping("/{id}")
    public EmployeeResponseDto employeeById(@PathVariable Long id) {
        log.info("GET - /employees/{} -> request", id);
        EmployeeResponseDto response = employeeService.findById(id);
        log.info("GET - /employees/{} - response -> {}", id, response);
        return response;
    }

    @PostMapping
    public ResponseDto insert(@RequestBody EmployeeRequestDto employeeRequestDto) {
        log.info("POST - /employees - request -> {}", employeeRequestDto);
        ResponseDto request =  employeeService.insert(employeeRequestDto);
        log.info("POST - /employees -> response none");
        return request;
    }

    @PutMapping
    public ResponseDto update(@RequestBody EmployeeRequestDtoId employeeRequestDto) {
        log.info("PUT - /employees - request -> {}", employeeRequestDto);
        ResponseDto response =  employeeService.update(employeeRequestDto);
        log.info("PUT - /employees -> response none");
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        log.info("DELETE - /employees/{} -> request", id);
        ResponseDto response =  employeeService.delete(id);
        log.info("DELETE - /employees -> response none");
        return response;
    }

}
