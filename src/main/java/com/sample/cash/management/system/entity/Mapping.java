package com.sample.cash.management.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "mapping")
@NoArgsConstructor
@AllArgsConstructor

public class Mapping extends AbstractEntity {

    @Column(name = "collector_id",unique = true)
    private Long collectorId;

    @Column(name = "approver_id")
    private Long approverId;


}
