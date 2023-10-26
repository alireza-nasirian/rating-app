package com.sample.common.model.general;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Biker extends User {

    private String vehicleId;
}
