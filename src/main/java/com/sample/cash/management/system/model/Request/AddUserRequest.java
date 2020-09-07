package com.sample.cash.management.system.model.Request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sample.cash.management.system.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class AddUserRequest {
    private UserType typeOfUser;
    private String nameOfUser;
    private String email;
    private String password;
}
