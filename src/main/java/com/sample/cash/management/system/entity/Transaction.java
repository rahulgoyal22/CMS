package com.sample.cash.management.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Builder
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor

public class Transaction extends AbstractEntity{

    @Column(name = "hotel_id",nullable = false)
    private String hotelId;

    @Column(name= "type_of_transaction",nullable = false)
    private String transaction;

    @Column(name = "amount",nullable = false)
    private Integer amount;

}
