package com.sample.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class BikerEntity extends UserEntity {

    @Column(length = 20, nullable = false)
    private String vehicleId;

    @OneToMany
    private List<FeedbackEntity> feedbacks;
}

