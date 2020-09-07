package com.sample.cash.management.system.controller;

import com.sample.cash.management.system.entity.Users;
import com.sample.cash.management.system.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired

    private UsersService usersService;

    @GetMapping("/users")
    public List<Users> getallUsers() {
        return usersService.getAllUsers();

    }

    @GetMapping("/users/{id}")
    public Users getUsers(@PathVariable Long id) {
        return usersService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public Users addUsers(@RequestBody Users users) {
        return usersService.addUsers(users);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public Users updateUser(@RequestBody Users user, @PathVariable Long id) {
        user.setId(id);
        Users h = usersService.getUser(id);
        if (h != null) {
            user.setCreatedAt(h.getCreatedAt());
            return usersService.updateUsers(user);
        } else {
            return null;
        }
    }

    @RequestMapping("/hotelcollectors")
    public List<Users> listHotelCollectors() {
        return usersService.listHotelCollectors();
    }
}
