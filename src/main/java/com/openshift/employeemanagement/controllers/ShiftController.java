package com.openshift.employeemanagement.controllers;

import com.openshift.employeemanagement.entities.Shift;
import com.openshift.employeemanagement.repositories.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/shifts")
public class ShiftController {

    @Autowired
    private ShiftRepository repository;

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

//        if (updates.getName() != null) Shift.setName(updates.getName());
//        if (updates.getRole()!= null) Shift.setRole(updates.getRole());
//        if (updates.getDepartment() != null) Shift.setDepartment(updates.getDepartment());
//        if (updates.getLocation()!= null) Shift.setLocation(updates.getLocation());
//        if (updates.getSupervisor()!= null) Shift.setSupervisor(updates.getSupervisor());
////        if (updates.getSkills() != null) Shift.setSkills(updates.getSkills());
//        if (updates.getSalary()!= null) Shift.setSalary(updates.getSalary());
//        if (updates.getDateHired()!= null) Shift.setDateHired(updates.getDateHired());

        return repository.save(shift);
    }

    // TODO: Assign Employee Shifts
    public ResponseEntity<Shift> assignShift() {
        return null;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeShift(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Shift ID " + id + " removed", HttpStatus.OK);
    }
}
