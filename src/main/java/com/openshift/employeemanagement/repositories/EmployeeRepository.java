package com.openshift.employeemanagement.repositories;

import com.openshift.employeemanagement.entities.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    List<Employee> findAllByRole(String role, Sort sort);
    List<Employee> findAllByDepartment(String department, Sort sort);
    List<Employee> findAllByLocation(String location, Sort sort);
    List<Employee> findAllBySupervisor(String supervisor, Sort sort);
    List<Employee> findAllBySalary(Double salary, Sort sort);
    List<Employee> findAllByDateHired(Date dateHired, Sort sort);
    List<Employee> findAllByName(String name);

}
