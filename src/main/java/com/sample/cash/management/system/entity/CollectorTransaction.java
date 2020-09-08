package com.sample.cash.management.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//for transaction from hotel to oyo collector

@Data
@Entity
@Table(name = "collector_transaction")
@AllArgsConstructor
@NoArgsConstructor
public class CollectorTransaction extends AbstractEntity {

    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name = "users_id")
    private Users user;


    @ManyToOne(targetEntity = Hotel.class)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;


    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "approved", nullable = false)
    private Boolean approved;

}
