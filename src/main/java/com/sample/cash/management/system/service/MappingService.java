package com.sample.cash.management.system.service;

import com.sample.cash.management.system.entity.Mapping;
import com.sample.cash.management.system.entity.Users;
import com.sample.cash.management.system.repository.MappingRepository;
import com.sample.cash.management.system.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MappingService {

    @Autowired
    MappingRepository mappingRepository;

    @Autowired
    UsersRepository usersRepository;


    public String addMapping(Long collectorId, Long approverId) {
        Optional<Users> collector = usersRepository.findById(collectorId);
        Optional<Users> approver = usersRepository.findById(approverId);

        if(collector.isPresent() && approver.isPresent() && collector.get().getTypeOfUser()== Users.userTypes.collector && approver.get()
                .getTypeOfUser()== Users.userTypes.approver){

            Mapping mapping  = new Mapping();
            mapping.setApproverId(approverId);
            mapping.setCollectorId(collectorId);

            mappingRepository.save(mapping);
            return "Success";
        }
        return "sed";
    }
}
