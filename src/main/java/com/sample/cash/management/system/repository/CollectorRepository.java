package com.sample.cash.management.system.repository;

import com.sample.cash.management.system.entity.Collector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectorRepository extends JpaRepository<Collector,Long> {
}
