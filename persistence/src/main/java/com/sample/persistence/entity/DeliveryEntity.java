package com.sample.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class DeliveryEntity {

    @Id
    @SequenceGenerator(name = "delivery_seq",
            sequenceName = "delivery_sequence", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_seq")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;

    @Lob
    private String sourceAddress;

    @Lob
    private String destinationAddress;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @NotNull
    private BikerEntity biker;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private FeedbackEntity feedback;
}
