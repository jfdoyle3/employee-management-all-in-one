package com.openshift.employeemanagement.controllers;

import com.openshift.employeemanagement.entities.Employee;
import com.openshift.employeemanagement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    @ResponseBody
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable String name) {
        return new ResponseEntity<>(repository.findAllByName(name), HttpStatus.OK);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<Employee>> getEmployeesByRole(@PathVariable String role) {
        return new ResponseEntity<>(repository.findAllByRole(role, Sort.by("name")), HttpStatus.OK);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable String department) {
        return new ResponseEntity<>(repository.findAllByDepartment(department, Sort.by("name")), HttpStatus.OK);
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<Employee>> getEmployeesByLocation(@PathVariable String location) {
        return new ResponseEntity<>(repository.findAllByDepartment(location, Sort.by("name")), HttpStatus.OK);
    }

    @GetMapping("/supervisor/{supervisor}")
    public ResponseEntity<List<Employee>> getEmployeesBySupervisor(@PathVariable String supervisor) {
        return new ResponseEntity<>(repository.findAllBySupervisor(supervisor, Sort.by("name")), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Employee getEmployeeById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee newEmployee) {
        return new ResponseEntity<>(repository.save(newEmployee), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    @ResponseBody
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updates) {
        Employee Employee = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getName() != null) Employee.setName(updates.getName());
        if (updates.getRole() != null) Employee.setRole(updates.getRole());
        if (updates.getDepartment() != null) Employee.setDepartment(updates.getDepartment());
        if (updates.getLocation() != null) Employee.setLocation(updates.getLocation());
        if (updates.getSupervisor()!= null) Employee.setSupervisor(updates.getSupervisor());
//        if (updates.getSkills() != null) Employee.setSkills(updates.getSkills());
        if (updates.getSalary() != null) Employee.setSalary(updates.getSalary());
        if (updates.getShift()!=null) Employee.setShift(updates.getShift());
//        if (updates.getDateHired()!= null) Employee.setDateHired(updates.getDateHired());

        return repository.save(Employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Employee ID " + id + " removed", HttpStatus.OK);
    }
}
