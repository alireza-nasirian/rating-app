package com.sample.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Delivery {

    @Id
    @SequenceGenerator(name = "delivery_seq",
            sequenceName = "delivery_sequence",allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_seq")
    @Column(nullable = false)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;

    @Lob
    private String sourceAddress;

    @Lob
    private String destinationAddress;

    @OneToOne
    @Column(nullable = false)
    private User customer;

    @OneToOne
    @Column(nullable = false)
    private User biker;

    @OneToOne
    private Feedback feedback;
}
