package com.sample.cash.management.system.repository;

import com.sample.cash.management.system.entity.Collector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CollectorRepository extends JpaRepository<Collector,Long> {

    public Collector findByCreatedAtBetweenAndUserIdAndHotelId(Date date,Date enddate, Long userId,Long hotelId);
}
