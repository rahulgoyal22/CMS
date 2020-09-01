package com.sample.cash.management.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

//    @Override
//    public String toString() {
//        return "Hotel [id=" + id + ", managerId=" + managerId + ", emailAddress=" +
//    emailAddress + ", password=" + password
//       + "]";
//    }
}
