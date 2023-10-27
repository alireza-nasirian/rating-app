package com.sample.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class FeedbackEntity {

    @Id
    @SequenceGenerator(name = "feedback_seq",
            sequenceName = "feedback_sequence",allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_seq")
    private Long id;

    @Enumerated
    @Column(nullable = false)
    private RateEntity rate;

    @Lob
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    private Date feedbackDate;

    @NotNull
    @OneToOne(mappedBy = "feedback", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DeliveryEntity delivery;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BikerEntity biker;
}
