package com.sample.cash.management.system.controller;

import com.sample.cash.management.system.model.Response.ServiceResponse;
import com.sample.cash.management.system.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/mapping")
public class MappingController {

    @Autowired
    private MappingService mappingService;

    @GetMapping(value = "/")
    public List<Map<String, String>> getAllApprovers() {
        return mappingService.getAllApprovers();
    }

    @PostMapping(value = "")
    public ServiceResponse addMapping(@RequestParam(name = "collector-id") Long collectorId, @RequestParam(name = "approver-id") Long approverId) {
        return mappingService.addMapping(collectorId, approverId);
    }
}
