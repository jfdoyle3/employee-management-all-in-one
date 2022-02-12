package com.openshift.employeemanagement.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
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

}


