package com.sample.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class BikerEntity extends UserEntity {

    @Column(length = 20, nullable = false, columnDefinition = "varchar(20) default ' '")
    private String vehicleId;

    @OneToMany(mappedBy = "biker")
    private List<FeedbackEntity> feedbacks;
}

