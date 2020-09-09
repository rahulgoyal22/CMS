package com.sample.cash.management.system.model.Request;

import com.sample.cash.management.system.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddHotelRequest {

    private String managerId;
    private String emailAddress;
    private String password;
    private String collectorEmail;
    private double balance;
}
