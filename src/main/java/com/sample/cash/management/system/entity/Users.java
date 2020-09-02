package com.sample.cash.management.system.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


enum userTypes {

    collector,approver;
}

@Getter
@Setter
@Entity
@Builder
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude
public class Users extends AbstractEntity{

    @Column(name = "type_of_user", nullable = false)
    private userTypes typeOfUser;

    @Column(name = "name_of_user", nullable = false)
    private String nameOfUser;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

}
