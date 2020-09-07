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

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.sample.cash.management.system.constant.Constants.NO_SUCH_HOTEL;
import static com.sample.cash.management.system.constant.Constants.NO_SUCH_TRANSACTION;

@Service
public class TransactionService {

    private ModelMapper modelMapper= new ModelMapper();
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private HotelRepository hotelRepository;

    public ServiceResponse addTransaction(AddTransactionRequest addTransactionRequest, Long hotelId) {

        Optional<Hotel> h = hotelRepository.findById(hotelId);

        if (h.isPresent()) {
            Hotel hotel = h.get();
          //  addTransactionRequest.setHotel(hotel);
            Long temp = addTransactionRequest.getAmount().longValue();
            if (addTransactionRequest.getTransaction() == TransactionType.debit) {
                temp = 0 - temp;
            }
            hotel.setBalance(hotel.getBalance() + temp);
            transactionRepository.save(Transaction.builder().transaction(addTransactionRequest.getTransaction()).amount(addTransactionRequest.getAmount()).build());
            return ServiceResponse.builder().status(Status.Success).build();
        } else {
            return null;
        }
    }

//    public List<Transaction> getAllTransaction() {
//        return transactionRepository.findAll();
//    }


    public List<TransactionResponse> getAllTransaction(){
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionResponse> transactionResponses= transactions.stream().map(transaction -> modelMapper.map(transaction,TransactionResponse.class)).collect(Collectors.toList());
        return transactionResponses;
    }



    public TransactionResponse getTransactionById(Long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (!transaction.isPresent()) {
            throw new UnprocessableEntity(NO_SUCH_TRANSACTION);
        }
        else {
           // ModelMapper modelMapper= new ModelMapper();
            TransactionResponse transactionResponse=modelMapper.map(transaction.get(),TransactionResponse.class);
            return transactionResponse;

        }

    }

}