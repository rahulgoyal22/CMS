package com.sample.cash.management.system.controller;

import com.sample.cash.management.system.entity.Transaction;

import com.sample.cash.management.system.model.Request.AddTransactionRequest;
import com.sample.cash.management.system.model.Response.HotelResponse;
import com.sample.cash.management.system.model.Response.ServiceResponse;
import com.sample.cash.management.system.model.Response.TransactionResponse;
import com.sample.cash.management.system.service.HotelService;
import com.sample.cash.management.system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController

public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private HotelService hotelService;

    @GetMapping("/transaction")
    private List<TransactionResponse> getTransactions() {
        return transactionService.getAllTransaction();

    }


    @GetMapping("/transaction/{id}")
    public TransactionResponse getTransactionById(@PathVariable(name = "id") Long id) {

        return transactionService.getTransactionById(id);
    }

    @PostMapping(value = "/hotel/{hotel-id}/transaction")
    public ServiceResponse addTransaction(@RequestBody AddTransactionRequest addTransactionRequest, @PathVariable(name = "hotel-id") Long hotelId) {

        return transactionService.addTransaction(addTransactionRequest, hotelId);
    }

    @GetMapping("/hotel/{hotel-id}/transaction")
    public List<TransactionResponse> getAllTransactionsofhotel(@PathVariable(name = "hotel-id") Long hotelId) {
        return transactionService.getAllTransactionsByHotelId(hotelId);
    }

    @GetMapping("/hotel/{hotel-id}/daily-transaction")
    public List<TransactionResponse> getAllByDatetimeBetween(@PathVariable(name = "hotel-id") Long hotelId,
                                                             @RequestParam("start-date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                                             @RequestParam("end-date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {

        return transactionService.getDailyTransaction(startDate, endDate, hotelId);
    }


}
