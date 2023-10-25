package com.sample.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {

    @Id
    @SequenceGenerator(name = "user_seq",
            sequenceName = "user_sequence",allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @Column(nullable = false)
    private Long id;

    @Column(length = 20)
    private String firstName;

    @Column(length = 20)
    private String lastName;

    @Column(length = 10)
    private String idCode;

    @Column(length = 11, nullable = false)
    private String phoneNumber;

    @OneToMany
    private List<Delivery> deliveries;
}
