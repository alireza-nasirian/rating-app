package com.sample.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UserEntity {
    @Id
    @SequenceGenerator(name = "user_seq",
            sequenceName = "user_sequence", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @Column(nullable = false)
    private Long id;

    @Column(length = 30)
    private String firstName;

    @Column(length = 30)
    private String lastName;

    @Column(length = 10)
    private String idCode;

    @Column(length = 11, nullable = false)
    private String phoneNumber;

    private String username;

    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<RoleEntity> roles = new HashSet<>();
}
