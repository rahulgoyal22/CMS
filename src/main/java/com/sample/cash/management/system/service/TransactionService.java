package com.sample.cash.management.system.service;

import com.sample.cash.management.system.entity.Hotel;
import com.sample.cash.management.system.entity.Transaction;
import com.sample.cash.management.system.repository.HotelRepository;
import com.sample.cash.management.system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public Transaction addTransaction(Transaction transaction, Long hotelId) {

        Optional<Hotel> h = hotelRepository.findById(hotelId);

        if (h.isPresent()) {
            Hotel hotel = h.get();
            transaction.setHotel(hotel);
            double temp = transaction.getAmount();
            if (transaction.getTransaction() == Transaction.transactionTypes.debit) {
                temp = 0 - temp;
            }
            hotel.setBalance(hotel.getBalance() + temp);
            return transactionRepository.save(transaction);
        } else {
            return null;
        }
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