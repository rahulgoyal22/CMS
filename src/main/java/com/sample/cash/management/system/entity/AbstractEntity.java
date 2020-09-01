package com.sample.cash.management.system.entity;


import lombok.Data;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
//import javax.persistence.PreUpdate;
//import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @Column(name = "id")
    protected String id;

//    @Column(name = "created_at")
//    private Date createdAt;
//
//    @Column(name = "updated_at")
//    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.id = UUID.randomUUID().toString();
//        this.createdAt = new Date();
//        this.updatedAt = new Date();

    }

//    @PreUpdate
//    protected void onUpdate(){this.updatedAt = new Date();}

}
