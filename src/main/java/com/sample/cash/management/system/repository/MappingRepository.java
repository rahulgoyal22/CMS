package com.sample.cash.management.system.repository;

import com.sample.cash.management.system.entity.Mapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingRepository extends JpaRepository<Mapping,Long> {

    public Mapping findByCollectorId(Long collectorId);
}
