package com.sample.cash.management.system.controller;

import com.sample.cash.management.system.service.CollectorService;
import com.sample.cash.management.system.entity.Collector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
