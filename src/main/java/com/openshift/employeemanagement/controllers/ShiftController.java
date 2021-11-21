package com.openshift.employeemanagement.controllers;
import com.openshift.employeemanagement.entities.Employee;
import com.openshift.employeemanagement.entities.Shift;
import com.openshift.employeemanagement.repositories.EmployeeRepository;
import com.openshift.employeemanagement.repositories.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.openshift.employeemanagement.entities.Shift;
import com.openshift.employeemanagement.repositories.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/api/shifts")
public class ShiftController {

    @Autowired
    private ShiftRepository repository;
    private EmployeeRepository empRepo;

    @GetMapping
    @ResponseBody
    public List<Shift> getShifts() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Shift> addShift(@RequestBody Shift newShift) {
        return new ResponseEntity<>(repository.save(newShift), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Shift updateShift(@PathVariable Long id, @RequestBody Shift updates) {
        Shift shift = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getShiftType() != null) shift.setShiftType(updates.getShiftType());
        if (updates.getShiftStart()!= null) shift.setShiftStart(updates.getShiftStart());
        if (updates.getShiftEnd() != null) shift.setShiftEnd(updates.getShiftEnd());
        if (updates.getHours()!= null) shift.setHours(updates.getHours());

        return repository.save(shift);
    }


      // TODO: Assign Employee Shifts
      // TODO: REFACTOR/FIX THIS TO WORK
    @PostMapping("/{empId}")
    public @ResponseBody Shift newShift(@PathVariable Long empId, @RequestBody Shift newShift) {
        Employee employee = empRepo.findById(empId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Developer Not Found"));
        newShift.setEmployee((Set<Employee>) employee);
        return repository.save(newShift);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeShift(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Shift ID " + id + " removed", HttpStatus.OK);
    }
}
