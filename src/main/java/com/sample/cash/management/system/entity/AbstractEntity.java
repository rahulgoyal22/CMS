package com.sample.cash.management.system.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
//        this.id = UUID.randomUUID();
        this.createdAt = new Date();
        this.updatedAt = new Date();

    }

    @PreUpdate
    protected void onUpdate(){this.updatedAt = new Date();}

}
