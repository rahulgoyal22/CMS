package com.sample.cash.management.system.controller;

import com.sample.cash.management.system.entity.CollectorTransaction;
import com.sample.cash.management.system.model.Response.ServiceResponse;
import com.sample.cash.management.system.service.CollectorTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/user/{userId}")
public class CollectorTransactionController {

    @Autowired
    CollectorTransactionService collectorTransactionService;

    @PostMapping("/collector-transaction")
    public ServiceResponse collectorTransaction(@RequestBody CollectorTransaction collector, @PathVariable Long userId) {
        return collectorTransactionService.collectorTransaction(collector, userId);
    }


    @PutMapping("/approveTransaction")
    public ServiceResponse approveTransaction(@PathVariable Long userId,
                                                   @RequestParam(name = "collectorId") Long collectorId,
                                                   @RequestParam(name = "amount") double amount,
                                                   @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                                   @RequestParam("hotelId") Long hotelId) {
        return collectorTransactionService.approveTransaction(userId, collectorId, amount, date, hotelId);
    }

}
