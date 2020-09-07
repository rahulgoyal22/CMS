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
@Table(name = "mapping")
@NoArgsConstructor
@AllArgsConstructor

public class Mapping extends AbstractEntity {

    @Column(name = "collector_id")
    private String collectorId;

    @Column(name = "approver_id")
    private String approverId;


}
