package com.sample.cash.management.system.controller;

import com.sample.cash.management.system.model.Response.ServiceResponse;
import com.sample.cash.management.system.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MappingController {

    @Autowired
    MappingService mappingService;

    @RequestMapping("/mapping")
    public List<Map<String, String>> getAllApprovers() {
        return mappingService.getAllApprovers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/mapping")
    public ServiceResponse addMapping(@RequestParam(name = "collectorId") Long collectorId, @RequestParam(name = "approverId") Long approverId) {
        return mappingService.addMapping(collectorId, approverId);
    }
}
