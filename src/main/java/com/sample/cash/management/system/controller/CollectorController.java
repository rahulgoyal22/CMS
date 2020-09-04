package com.sample.cash.management.system.controller;

import com.sample.cash.management.system.service.CollectorService;
import com.sample.cash.management.system.entity.Collector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/user/{userId}")
public class CollectorController {

    @Autowired
    CollectorService collectorService;

    @PostMapping("/collector-transaction")
    public Collector collectorTransaction(@RequestBody Collector collector, @PathVariable Long userId)
    {
        return collectorService.collectorTransaction(collector,userId);
    }


    @PutMapping("/approveTransaction")
    public Collector approveTransaction (@PathVariable Long userId,
                                         @RequestParam(name = "collectorId") Long collectorId,
                                         @RequestParam(name = "amount") double amount ,
                                         @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                         @RequestParam("hotelId") Long hotelId)
    {
        return collectorService.approveTransaction(userId,collectorId,amount,date,hotelId);
    }

}
