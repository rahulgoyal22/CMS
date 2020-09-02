package com.sample.cash.management.system.service;

import com.sample.cash.management.system.entity.Hotel;
import com.sample.cash.management.system.entity.Transaction;
import com.sample.cash.management.system.entity.Users;
import com.sample.cash.management.system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    private HotelService hotelService;

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }


    public Transaction getTransactionById(Long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (transaction.isPresent()) {
            return transaction.get();
        } else {
            return null;
        }
    }

}