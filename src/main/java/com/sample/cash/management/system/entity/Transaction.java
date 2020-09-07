package com.sample.cash.management.system.entity;

import com.sample.cash.management.system.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@Entity
@Builder
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor


public class Transaction extends AbstractEntity{


    @ManyToOne(targetEntity = Hotel.class)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Column(name= "type_of_transaction",nullable = false)
    private TransactionType transaction;

    @Column(name = "amount",nullable = false)
    private double amount;

}
