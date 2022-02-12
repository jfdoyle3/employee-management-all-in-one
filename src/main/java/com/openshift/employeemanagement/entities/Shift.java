package com.openshift.employeemanagement.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date punchIn;
    private Date punchOut;
    private Double hours;

    @ManyToMany
    @JoinTable(
            name = "employee_shift",
            joinColumns = @JoinColumn(name = "shift_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    @JsonIgnoreProperties({"shift"})
    private Set<Employee> employee = new HashSet<>();


    public Shift() {
    }

    public Shift(Date punchIn, Date punchOut, Double hours) {
        this.punchIn = punchIn;
        this.punchOut = punchOut;
        this.hours = hours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPunchIn() {
        return punchIn;
    }

    public void setPunchIn(Date punchIn) {
        this.punchIn = punchIn;
    }

    public Date getPunchOut() {
        return punchOut;
    }

    public void setPunchOut(Date punchOut) {
        this.punchOut = punchOut;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }
}


