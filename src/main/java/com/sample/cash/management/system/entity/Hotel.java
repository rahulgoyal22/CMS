package com.sample.cash.management.system.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@Table(name = "hotel")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude
public class Hotel extends AbstractEntity{



    @Column(name = "manager_id", nullable = false)
    private String managerId;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name = "users_id")
    private Users user;

    @Column( name = "balance", nullable = false)
    private double balance;

}
