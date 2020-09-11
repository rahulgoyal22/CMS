package com.sample.cash.management.system.repository;

import com.sample.cash.management.system.entity.Users;
import com.sample.cash.management.system.model.Response.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    public Users findByEmail(String email);

   public Users findByEmailAndPassword(String email, String password);
}
