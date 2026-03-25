package com.company.project.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.Normalized;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String uniqueIdentifier;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false,unique = true)
    private String emailId;

    @Column(nullable = false)
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeRole role;

    @OneToOne
    @JoinColumn(name="emp_address")
    private Address address;

    @ManyToOne
    @JoinColumn(name="emp_dept")
    private Department department;

    @ManyToMany
    @JoinTable(
        name="employee_mission",
        joinColumns=@JoinColumn(name = "employee_id"),
        inverseJoinColumns=@JoinColumn(name = "mission_id")
    )
    private List<Mission> missions;
}
