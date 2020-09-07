package com.sample.cash.management.system.controller;

import com.sample.cash.management.system.entity.Transaction;

import com.sample.cash.management.system.service.HotelService;
import com.sample.cash.management.system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private HotelService hotelService;

    @GetMapping("/transaction")
    public List<Transaction> getallTransaction() {
        return transactionService.getAllTransaction();
    }

    @RequestMapping("/transaction/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return this.transactionService.getTransactionById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/hotels/{hotelId}/transaction")
    public Transaction addTransaction(@RequestBody Transaction transaction, @PathVariable Long hotelId) {

        return transactionService.addTransaction(transaction, hotelId);
    }

    @RequestMapping("/hotel/{hotelId}/transaction")
    public List<Transaction> getAllTransactions(@PathVariable Long hotelId) {
        return hotelService.getAllTransactions(hotelId);
    }

    @GetMapping("/hotel/{hotelId}/dailytransaction")
    public List<Transaction> getAllByDatetimeBetween(@PathVariable Long hotelId,
                                                     @RequestParam("start-date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                     @RequestParam("end-date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

        return hotelService.getdailytransaction(startDate, endDate, hotelId);
    }


}
