package com.sample.cash.management.system.service;

import com.sample.cash.management.system.entity.Transaction;
import com.sample.cash.management.system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }


    //public Transaction getTransactionById(Long hotel_id) {
    // return transactionRepository.findOne(hotel_id);

}