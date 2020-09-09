package com.sample.cash.management.system.controller;

import com.sample.cash.management.system.entity.CollectorTransaction;
import com.sample.cash.management.system.model.Response.ServiceResponse;
import com.sample.cash.management.system.service.CollectorTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping(value = "/user/{user-id}")
public class CollectorTransactionController {

    @Autowired
    private CollectorTransactionService collectorTransactionService;

    @PostMapping(value = "/collector-transaction")
    public ServiceResponse collectorTransaction(@RequestBody CollectorTransaction collector, @PathVariable(name = "user-id") Long userId) {
        return collectorTransactionService.collectorTransaction(collector, userId);
    }


    @PutMapping(value = "/approve-transaction")
    public ServiceResponse approveTransaction(@PathVariable(name = "user-id") Long userId,
                                              @RequestParam(name = "collector-id") Long collectorId,
                                              @RequestParam(name = "amount") double amount,
                                              @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                              @RequestParam("hotel-id") Long hotelId) {
        return collectorTransactionService.approveTransaction(userId, collectorId, amount, date, hotelId);
    }

}
