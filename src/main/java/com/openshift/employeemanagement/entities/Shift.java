package com.openshift.employeemanagement.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="employee_id", referencedColumnName = "id")
    private Employee employee;
    private String shiftType;
    private String shiftStart;
    private String shiftEnd;
    private Double hours;




    public Shift() {}

    public Shift(Employee employee,String shiftType, String shiftStart, String shiftEnd, Double hours) {
        this.employee=employee;
        this.shiftType = shiftType;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        this.hours = hours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getShiftType() {
        return shiftType;
    }

    public void setShiftType(String shiftType) {
        this.shiftType = shiftType;
    }

    public String getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(String shiftStart) {
        this.shiftStart = shiftStart;
    }

    public String getShiftEnd() {
        return shiftEnd;
    }

    public void setShiftEnd(String shiftEnd) {
        this.shiftEnd = shiftEnd;
    }

//    public Double calculateHours(String shiftStart, String shiftEnd) {
//        return Double.parseDouble(shiftEnd) - Double.parseDouble(shiftStart);
//    }

//    public HashMap<Employee, Shift> assignShifts() {
//
//    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }
}
