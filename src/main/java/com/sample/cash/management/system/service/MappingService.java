package com.sample.cash.management.system.service;

import com.sample.cash.management.system.entity.Mapping;
import com.sample.cash.management.system.entity.Users;
import com.sample.cash.management.system.enums.Status;
import com.sample.cash.management.system.enums.UserType;
import com.sample.cash.management.system.model.Response.ServiceResponse;
import com.sample.cash.management.system.repository.MappingRepository;
import com.sample.cash.management.system.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MappingService {

    @Autowired
    MappingRepository mappingRepository;

    @Autowired
    UsersRepository usersRepository;


    public ServiceResponse addMapping(Long collectorId, Long approverId) {
        Optional<Users> collector = usersRepository.findById(collectorId);
        Optional<Users> approver = usersRepository.findById(approverId);

        if (collector.isPresent() && approver.isPresent() && collector.get().getTypeOfUser() == UserType.collector && approver.get()
                .getTypeOfUser() == UserType.approver) {

            Mapping mapping = new Mapping();
            mapping.setApproverId(approverId);
            mapping.setCollectorId(collectorId);

            mappingRepository.save(mapping);
            return ServiceResponse.builder().status(Status.Success).build();
        }
        return ServiceResponse.builder().status(Status.Failure).build();
    }

    public List<Map<String, String>> getAllApprovers() {
        List<Map<String, String>> maps = new ArrayList<>();
        mappingRepository.findAll().forEach(mapping -> {
                    Optional<Users> approver = usersRepository.findById(mapping.getApproverId());
                    Optional<Users> collector = usersRepository.findById(mapping.getCollectorId());

                    if (approver.isPresent() && collector.isPresent()) {
                        Map<String, String> namesMap = new HashMap<>();
                        namesMap.put(collector.get().getNameOfUser(), approver.get().getNameOfUser());
                        maps.add(namesMap);


                    }

                }

        );
        return maps;
    }
}
