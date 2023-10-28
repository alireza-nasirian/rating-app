package com.sample.common.model.general;

import lombok.Data;

import java.util.Set;

@Data
public class Role {

    private String name;
    private Set<Operation> operations;
}
