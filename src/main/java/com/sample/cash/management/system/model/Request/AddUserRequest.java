package com.sample.cash.management.system.model.Request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sample.cash.management.system.enums.UserType;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {


    private UserType typeOfUser;
    @NotBlank
    private String nameOfUser;
    @NotBlank
    private String email;
    @Size(min = 8,max = 14)
    private String password;

}
