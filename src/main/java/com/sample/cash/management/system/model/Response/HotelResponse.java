package com.sample.cash.management.system.model.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelResponse {
    protected Long id;
    private String managerId;
    private String emailAddress;
   // private String password;
    private Long balance;
}
