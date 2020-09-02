package com.sample.cash.management.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "closed")
@AllArgsConstructor
@NoArgsConstructor
public class Closed extends AbstractEntity{

    @Column(name = "collector_id", nullable = false)
    private String closeDay;

    @Column(name = "paid_amount", nullable = false)
    private Integer paidAmount;

    @Column(name = "remaining_amount", nullable = false)
    private Integer remainingAmount;

    @Column(name = "approver", nullable = false)
    private Boolean approved;


}
