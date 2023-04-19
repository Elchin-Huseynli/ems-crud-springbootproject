package com.company.springproject2.query;

public class EmployeeQuery {
    public static final String EMPLOYEE_LIST = "select * from employee";

    public static final String EMPLOYEE_FIND_BY_ID = "select * from employee where id = :id";

    public static final String INSERT_EMPLOYEE = "insert into employee(name, surname, email, salary) values(:name, :surname, :email, :salary)";

    public static final String UPDATE_EMPLOYEE = "update employee set name = :name, surname = :surname, email = :email, salary = :salary where id = :id";

    public static final String DELETE_EMPLOYEE = "delete from employee where id = :id";
}
