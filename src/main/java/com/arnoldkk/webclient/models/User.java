package com.arnoldkk.webclient.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private short id;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

}
