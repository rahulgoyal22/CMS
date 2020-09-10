package com.sample.cash.management.system.repository;

import com.sample.cash.management.system.entity.CollectorTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;

@Repository
public interface CollectorTransactionRepository extends JpaRepository<CollectorTransaction, Long> {

    public CollectorTransaction findByCreatedAtBetweenAndUserIdAndHotelIdAndAmount(LocalDate date, LocalDate enddate, Long userId, Long hotelId, double amount);
}
