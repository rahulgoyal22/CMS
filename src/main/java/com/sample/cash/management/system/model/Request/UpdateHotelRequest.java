package com.sample.cash.management.system.model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdateHotelRequest {

    private String emailAddress;
    private String password;

}
