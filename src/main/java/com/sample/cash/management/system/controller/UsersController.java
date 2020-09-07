package com.sample.cash.management.system.controller;

import com.sample.cash.management.system.entity.Users;
import com.sample.cash.management.system.model.Request.AddUserRequest;
import com.sample.cash.management.system.model.Response.HotelResponse;
import com.sample.cash.management.system.model.Response.ServiceResponse;
import com.sample.cash.management.system.model.Response.UserResponse;
import com.sample.cash.management.system.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired

    private UsersService usersService;

     @GetMapping("/")
     public List<UserResponse> getUsers(){
         return usersService.getUsers();
     }

@RequestMapping("/{id}")
public UserResponse getUser(@PathVariable Long id) {

    return usersService.getUser(id);
}


    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ServiceResponse addUsers(@RequestBody AddUserRequest addUserRequest) {
        return usersService.addUsers(addUserRequest);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ServiceResponse updateUser(@RequestBody AddUserRequest addUserRequest, @PathVariable Long id) {

        return usersService.updateUser(addUserRequest,id);

    }
}
