package com.sample.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Feedback {

    @Id
    @SequenceGenerator(name = "feedback_seq",
            sequenceName = "feedback_sequence",allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_seq")
    @Column(nullable = false)
    private Long id;

    @Enumerated
    @Column(nullable = false)
    private Rate rate;

    @Lob
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    private Date feedbackDate;

    @Column(nullable = false)
    @OneToOne
    private Delivery delivery;

    //todo add cascade and fetch type
}
