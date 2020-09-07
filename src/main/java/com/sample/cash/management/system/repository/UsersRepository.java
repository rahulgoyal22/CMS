package com.sample.cash.management.system.repository;

import com.sample.cash.management.system.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    public List<Users> findAllByTypeOfUser(Users.userTypes userTypes);
}
