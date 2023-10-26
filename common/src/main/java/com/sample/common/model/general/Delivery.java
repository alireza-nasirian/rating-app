package com.sample.common.model.general;

import lombok.Data;

import java.util.Date;

@Data
public class Delivery {

    private Date deliveryDate;
    private String sourceAddress;
    private String destinationAddress;
}
