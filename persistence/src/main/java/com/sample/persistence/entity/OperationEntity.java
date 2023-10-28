package com.sample.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = OperationEntity.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OperationEntity {
    public static final String TABLE_NAME = "operation_table";

    @Id
    @SequenceGenerator(name = "operation_seq",
            sequenceName = "operation_sequence", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operation_seq")
    private Long id;

    private String name;
}
