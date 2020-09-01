package com.sample.cash.management.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


enum userTypes {

    manager,customer;
}

@Data
@Entity
@Builder
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class Users extends AbstractEntity{

    @Column(name = "type_of_user", nullable = false)
    private userTypes typeOfUser;

    @Column(name = "name_of_user", nullable = false)
    private String nameOfUser;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", unique = true)
    private String password;
}
