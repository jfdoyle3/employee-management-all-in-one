package com.openshift.employeemanagement.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String role;
    private String department;
    private String location;
    //    private String skills;
    private String supervisor;
    private Double salary;
    private Date dateHired;

    @OneToOne
    @JoinColumn(name = "shift_id", referencedColumnName = "id")
    private Shift shift;

    public Employee() {}

    public Employee(String name, String role,Shift shift) {
        this.name = name;
        this.role = role;
        this.shift=shift;
    }

    public Employee(String name, String role, String department, String location, Double salary) {
        this.name = name;
        this.role = role;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
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
