package com.sample.cash.management.system.controller;

import com.sample.cash.management.system.enums.Status;
import com.sample.cash.management.system.model.Request.AddUserRequest;
import com.sample.cash.management.system.model.Response.ServiceResponse;
import com.sample.cash.management.system.model.Response.UserResponse;
import com.sample.cash.management.system.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/")
    public List<UserResponse> getUsers() {
        return usersService.getUsers();
    }

    @GetMapping(value = "/{id}")
    public UserResponse getUser(@PathVariable(name = "id") Long id) {
        return usersService.getUser(id);
    }


    @PostMapping(value = "/")
    public ServiceResponse addUsers(@Valid @RequestBody AddUserRequest addUserRequest, Errors errors) {
        if (errors.hasErrors()) {
            return ServiceResponse.builder().status(Status.Failure).message(errors.getFieldError().getField() + " " + errors.getFieldError().getDefaultMessage()).build();
        }
        return usersService.addUsers(addUserRequest);
    }

    @PutMapping(value = "/{id}")
    public ServiceResponse updateUser(@RequestBody AddUserRequest addUserRequest, @PathVariable(name = "id") Long id) {
        return usersService.updateUser(addUserRequest, id);
    }

    @GetMapping(value = "/auth-user")
    public UserResponse authUser(@RequestParam("email-id") String email, @RequestParam("password") String password) {
        return usersService.authUser(email, password);
    }
}
