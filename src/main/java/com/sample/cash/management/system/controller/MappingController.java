package com.sample.cash.management.system.controller;

import com.sample.cash.management.system.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    @Autowired
    MappingService mappingService;

    @RequestMapping(method = RequestMethod.POST, value = "/mapping")
    public String addMapping(@RequestParam(name= "collectorId") Long collectorId,@RequestParam(name= "approverId") Long approverId)
    {
       return mappingService.addMapping(collectorId,approverId);
    }
}
