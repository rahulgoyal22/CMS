package com.sample.cash.management.system.service;

import com.sample.cash.management.system.entity.Users;
import com.sample.cash.management.system.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users addUsers(Users user) {
        return usersRepository.save(user);
    }

    public Users getUser(Long id) {

        Optional<Users> user = usersRepository.findById(id);
        if (user.isPresent())
        {
            return user.get();
        }
        else
        {
            return null;
        }
    }

    public Users updateUsers(Users user)
    {
        return usersRepository.save(user);
    }

}
