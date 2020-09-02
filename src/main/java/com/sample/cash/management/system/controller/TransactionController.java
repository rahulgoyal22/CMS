package com.sample.cash.management.system.controller;

import com.sample.cash.management.system.entity.Transaction;

import com.sample.cash.management.system.service.HotelService;
import com.sample.cash.management.system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Transaction> getallTransaction(){
        return transactionService.getAllTransaction();
    }

    @RequestMapping("/transaction/{id}")
    public Transaction getTransactionById(@PathVariable Long id)
    {
        return this.transactionService.getTransactionById(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/hotel/{id}/addtransaction")
    public Transaction addTransaction(@RequestBody Transaction transaction,@PathVariable Long id)
    {
        transaction.setHotel(hotelService.getHotel(id));
        Long temp =  transaction.getAmount().longValue();
        if(transaction.getTransaction()== Transaction.transactionTypes.debit) {temp = 0- temp;}
        hotelService.getHotel(id).setBalance(hotelService.getHotel(id).getBalance()+temp);
        return transactionService.addTransaction(transaction);
    }


}
