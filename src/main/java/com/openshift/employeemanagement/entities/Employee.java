package com.openshift.employeemanagement.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
// Displays Developer record for only the first json record.
// Comment out to show Developer on every json record.
// Unwrap item one time.
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@JsonPropertyOrder({"id","name","supervisor","role","department","location"})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;
    private String department;
    private String location;
    private String supervisor;
    private Double salary;
    private Date dateHired;

//    @ManyToMany
//    @JoinTable(
//            name="employee_shift",
//            joinColumns = @JoinColumn(name = "employee_id"),
//            inverseJoinColumns = @JoinColumn(name = "shift_id")
//    )
//    @JsonIgnoreProperties({"employees"})
//    private Set<Shift> shifts = new HashSet<>();

    public Employee() {}


    public Employee(String name, String role, String department, String location, String supervisor, Double salary, Date dateHired) {
        this.name = name;
        this.role = role;
        this.department = department;
        this.location = location;
        this.supervisor = supervisor;
        this.salary = salary;
        this.dateHired = dateHired;

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

//    public Set<Shift> getShift() {
//        return shifts;
//    }
//
//    public void setShift(Set<Shift> shifts) {
//        this.shifts = shifts;
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
