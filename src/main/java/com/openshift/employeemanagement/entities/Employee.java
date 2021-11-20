package com.openshift.employeemanagement.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;
    private String department;
    private String location;
    //    private String skills;
    private String supervisor;
    private Double salary;
    private Date dateHired;

    @ManyToMany
    @JoinColumn(name="shift_id", referencedColumnName = "id")
    private Set<Shift> shifts = new HashSet<>();

    public Employee() {}

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Employee(String name, String role, String department, String location, Double salary) {
        this.name = name;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

//    public String getSkills() {
//        return skills;
//    }
//
//    public void setSkills(String skills) {
//        this.skills = skills;
//    }


    public Set<Shift> getShift() {
        return shifts;
    }

    public void setShift(Set<Shift> shifts) {
        this.shifts = shifts;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired (Date dateHired) {
        this.dateHired = dateHired;
    }
}
