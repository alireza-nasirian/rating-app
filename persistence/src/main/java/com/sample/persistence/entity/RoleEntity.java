package com.sample.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = RoleEntity.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleEntity {

    public static final String TABLE_NAME = "role_table";

    @Id
    @SequenceGenerator(name = "role_seq",
            sequenceName = "role_sequence", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<OperationEntity> operations = new HashSet<>();

}
