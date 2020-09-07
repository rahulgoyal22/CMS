package com.sample.cash.management.system.service;

import com.sample.cash.management.system.entity.Users;
import com.sample.cash.management.system.enums.Status;
import com.sample.cash.management.system.exception.UnprocessableEntity;
import com.sample.cash.management.system.model.Request.AddUserRequest;
import com.sample.cash.management.system.model.Response.ServiceResponse;
import com.sample.cash.management.system.model.Response.UserResponse;
import com.sample.cash.management.system.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.sample.cash.management.system.constant.Constants.NO_SUCH_USER;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private ModelMapper modelMapper= new ModelMapper();

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public List<UserResponse> getUsers(){
        List<Users> users= usersRepository.findAll();
        List<UserResponse> userResponses = users.stream().map(users1 -> modelMapper.map(users1,UserResponse.class) ).collect(Collectors.toList());
        return userResponses;
    }

    public ServiceResponse addUsers(AddUserRequest addUserRequest) {
        //Handle exception of non unique email address
        usersRepository.save(Users.builder().typeOfUser(addUserRequest.getTypeOfUser()).nameOfUser(addUserRequest.getNameOfUser()).email(addUserRequest.getEmail()).password(addUserRequest.getPassword()).build());
        return ServiceResponse.builder().status(Status.Success).build();
    }


    public UserResponse getUser(Long id) {
        Optional<Users> users = usersRepository.findById(id);
        if (!users.isPresent()) {
            throw new UnprocessableEntity(NO_SUCH_USER);
        }
        else {
           // ModelMapper modelMapper= new ModelMapper();
            UserResponse userResponse=modelMapper.map(users.get(),UserResponse.class);
            return userResponse;

        }

    }

    public ServiceResponse updateUser(AddUserRequest addUserRequest,Long id)
    {
        if(usersRepository.findById(id).isPresent()) {
            Users users = usersRepository.findById(id).get();
            users.setEmail(addUserRequest.getEmail());
            users.setNameOfUser(addUserRequest.getNameOfUser());
            users.setPassword(addUserRequest.getPassword());
            users.setTypeOfUser(addUserRequest.getTypeOfUser());
            usersRepository.save(users);
            return ServiceResponse.builder().status(Status.Success).build();
        }
        else
        {
            return null;
        }
    }

}
