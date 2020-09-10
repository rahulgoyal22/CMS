package com.sample.cash.management.system.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sample.cash.management.system.enums.UserType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Builder
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude
public class Users extends AbstractEntity {
    @Column(name = "type_of_user", nullable = false)
    private UserType typeOfUser;

    @Column(name = "name_of_user", nullable = false)
    private String nameOfUser;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

}
