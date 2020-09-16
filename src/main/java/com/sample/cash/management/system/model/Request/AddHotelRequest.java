package com.sample.cash.management.system.model.Request;

import com.sample.cash.management.system.entity.Users;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddHotelRequest {
    @NotBlank
    private String hotelName;
    @NotBlank
    private String emailAddress;
    @Size(min = 8,max = 14)
    private String password;
    @NotBlank
    private String collectorEmail;
    private double balance;
}
