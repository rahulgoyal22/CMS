package com.sample.cash.management.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//for transaction from hotel to oyo collector

@Data
@Entity
@Table(name = "collector")
@AllArgsConstructor
@NoArgsConstructor
public class Collector extends AbstractEntity{

    @Column(name = "collector_id", nullable = false)
    private Long collectorId;

    @Column(name = "hotel_id", nullable = false)
    private Long hotelId;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name = "approved", nullable = false)
    private Boolean approved;

    public Collector(Long collectorId, Long hotelId, Long amount) {
        this.collectorId = collectorId;
        this.hotelId = hotelId;
        this.amount = amount;
        this.approved = false;
    }
}
