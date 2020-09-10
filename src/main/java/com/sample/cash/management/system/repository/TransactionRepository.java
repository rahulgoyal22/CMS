package com.sample.cash.management.system.repository;

import com.sample.cash.management.system.entity.Hotel;
import com.sample.cash.management.system.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    public List<Transaction> findAllByHotelId(Long id);

    public List<Transaction> findAllByCreatedAtBetweenAndHotelId(LocalDate start, LocalDate end, Long id);

}