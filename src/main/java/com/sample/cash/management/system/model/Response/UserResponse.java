package com.sample.cash.management.system.model.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sample.cash.management.system.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    protected Long id;
    private UserType typeOfUser;
    private String nameOfUser;
    private String email;
}
