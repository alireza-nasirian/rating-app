package com.sample.common.model.general;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String firstName;
    private String lastName;
    private String idCode;
    private String phoneNumber;
    private String username;
    private String password;
    private Set<Role> roles;

}
