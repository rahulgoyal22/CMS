package com.sample.cash.management.system.repository;

import com.sample.cash.management.system.entity.Closed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClosedRepository extends JpaRepository<Closed,String> {
}
