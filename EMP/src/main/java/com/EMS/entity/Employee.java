package com.EMS.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String project;
    private int age;
    private double salary;

    @ManyToOne //  many employees can report to one manager.

    //this tells JPA to create a foreign key column named manager_id in the employee table.
    //that column will point to the id of another employee — the manager

    @JoinColumn(name = "manager_id")
    private Employee manager;   //self-refrencing relationship

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
