package com.practice.springrestdemo.payroll.repository;

import com.practice.springrestdemo.payroll.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}