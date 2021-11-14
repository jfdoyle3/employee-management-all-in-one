package com.openshift.employeemanagement.entities;

import javax.persistence.*;

@Entity
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String shiftType;
    private String shiftStart;
    private String shiftEnd;
    private Double hours;

    @ManyToOne
    @JoinColumn(name="employee_id", referencedColumnName = "id")
    public Employee employee;


    public Shift() {

    }

    public Shift(String shiftType, String shiftStart, String shiftEnd, Double hours) {
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
