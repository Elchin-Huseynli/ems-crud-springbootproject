package com.company.springproject2.repository.impl;

import com.company.springproject2.model.Employee;
import com.company.springproject2.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import static com.company.springproject2.query.EmployeeQuery.*;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query(EMPLOYEE_LIST,
                (rs, row) -> Employee.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .surname(rs.getString("surname"))
                        .email(rs.getString("email"))
                        .salary(rs.getInt("salary"))
                        .build());
    }

    @Override
    public Optional<Employee> findById(Long id) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", id);
        return jdbcTemplate.query(EMPLOYEE_FIND_BY_ID,
                mapSqlParameterSource,
                (rs, row) -> Employee.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .surname(rs.getString("surname"))
                        .email(rs.getString("email"))
                        .salary(rs.getInt("salary"))
                        .build())
                .stream()
                .findFirst();
    }

    @Override
    public int insert(Employee employee) {
        return jdbcTemplate.update(INSERT_EMPLOYEE,
                new BeanPropertySqlParameterSource(employee));
    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update(UPDATE_EMPLOYEE,
                new BeanPropertySqlParameterSource(employee));
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update(DELETE_EMPLOYEE,
                new MapSqlParameterSource("id", id));
    }
}
