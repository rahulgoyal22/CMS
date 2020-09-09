package com.sample.cash.management.system.service;

import com.sample.cash.management.system.entity.Hotel;
import com.sample.cash.management.system.entity.Transaction;
import com.sample.cash.management.system.entity.Users;
import com.sample.cash.management.system.enums.Status;
import com.sample.cash.management.system.enums.TransactionType;
import com.sample.cash.management.system.exception.UnprocessableEntity;
import com.sample.cash.management.system.model.Request.AddTransactionRequest;
import com.sample.cash.management.system.model.Response.HotelResponse;
import com.sample.cash.management.system.model.Response.ServiceResponse;
import com.sample.cash.management.system.model.Response.TransactionResponse;
import com.sample.cash.management.system.repository.HotelRepository;
import com.sample.cash.management.system.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static com.sample.cash.management.system.constant.Constants.NO_SUCH_HOTEL;
import static com.sample.cash.management.system.constant.Constants.NO_SUCH_TRANSACTION;

@Service
public class TransactionService {

    private ModelMapper modelMapper= new ModelMapper();
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private HotelRepository hotelRepository;

    public ServiceResponse addTransaction(AddTransactionRequest addTransactionRequest, Long hotelId) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(hotelId);
        if (hotelOptional.isPresent()) {
            Hotel hotel = hotelOptional.get();
            double amount = addTransactionRequest.getAmount();
            if (addTransactionRequest.getTransaction() == TransactionType.debit) {
                amount = 0 - amount;
            }
            hotel.setBalance(hotel.getBalance() + amount);
            hotelRepository.save(hotel);
            transactionRepository.save(Transaction.builder().transaction(addTransactionRequest.getTransaction()).amount(addTransactionRequest.getAmount()).hotel(hotel).build());
            return ServiceResponse.builder().status(Status.Success).build();
        } else {
            return ServiceResponse.builder().status(Status.Failure).build();
        }
    }

    public List<TransactionResponse> getAllTransaction(){
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionResponse> transactionResponses= new ArrayList<>();
        transactions.forEach(transaction ->{
            TransactionResponse mapping = new TransactionResponse();
            mapping.setTransaction(transaction.getTransaction());
            mapping.setAmount(transaction.getAmount());
            mapping.setManagerId(transaction.getHotel().getManagerId());
            transactionResponses.add(mapping);
        });
        return transactionResponses;
    }

    public TransactionResponse getTransactionById(Long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (!transaction.isPresent()) {
            throw new UnprocessableEntity(NO_SUCH_TRANSACTION);
        }
        else {
            TransactionResponse transactionResponse=modelMapper.map(transaction.get(),TransactionResponse.class);
            transactionResponse.setManagerId(transaction.get().getHotel().getManagerId());
            return transactionResponse;
        }
    }


    public List<TransactionResponse> getDailyTransaction(LocalDate start, LocalDate end, Long id){
        List<Transaction> transactions= transactionRepository.findAllByCreatedAtBetweenAndHotelId(start,end,id);
        List<TransactionResponse> transactionResponses= new ArrayList<>();

        transactions.forEach(transaction ->{
            TransactionResponse mapping = new TransactionResponse();
            mapping.setTransaction(transaction.getTransaction());
            mapping.setAmount(transaction.getAmount());
            mapping.setManagerId(transaction.getHotel().getManagerId());
            transactionResponses.add(mapping);
        });
        return transactionResponses;

    }

    public List<TransactionResponse> getAllTransactionsByHotelId(Long hotelId){
        List<Transaction> transactions=transactionRepository.findAllByHotelId(hotelId);
        List<TransactionResponse> transactionResponses= new ArrayList<>();

        transactions.forEach(transaction ->{
            TransactionResponse mapping = new TransactionResponse();
            mapping.setTransaction(transaction.getTransaction());
            mapping.setAmount(transaction.getAmount());
            mapping.setManagerId(transaction.getHotel().getManagerId());
            transactionResponses.add(mapping);
        });
        return transactionResponses;
    }
}