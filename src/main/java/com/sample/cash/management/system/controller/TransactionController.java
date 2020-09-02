package com.sample.cash.management.system.controller;

import com.sample.cash.management.system.entity.Transaction;
import com.sample.cash.management.system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transaction")
    public List<Transaction> getallTransaction(){
        return transactionService.getAllTransaction();
    }

    //@RequestMapping("/transaction/{hotel_id}")
   // public Transaction getTransaction(@PathVariable("hotel_id") Long hotel_id)
   // {
    //    return this.transactionService.getTransactionById(hotel_id);
   // }

    @RequestMapping(method = RequestMethod.POST,value = "/transaction")
    public Transaction addTransaction(@RequestBody Transaction transaction)
    {
        return transactionService.addTransaction(transaction);
    }

}
