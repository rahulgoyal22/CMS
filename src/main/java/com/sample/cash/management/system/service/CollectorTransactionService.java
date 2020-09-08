package com.sample.cash.management.system.service;


import com.sample.cash.management.system.entity.CollectorTransaction;
import com.sample.cash.management.system.entity.Hotel;
import com.sample.cash.management.system.entity.Mapping;
import com.sample.cash.management.system.entity.Users;
import com.sample.cash.management.system.enums.Status;
import com.sample.cash.management.system.enums.UserType;
import com.sample.cash.management.system.exception.UnprocessableEntity;
import com.sample.cash.management.system.model.Response.ServiceResponse;
import com.sample.cash.management.system.repository.CollectorTransactionRepository;
import com.sample.cash.management.system.repository.HotelRepository;
import com.sample.cash.management.system.repository.MappingRepository;
import com.sample.cash.management.system.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.Date;
import java.util.Optional;

import static com.sample.cash.management.system.constant.Constants.*;

@Service

public class CollectorTransactionService {

    @Autowired
    CollectorTransactionRepository collectorTransactionRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    MappingRepository mappingRepository;


    public ServiceResponse collectorTransaction(CollectorTransaction collector, Long userID){
        Optional<Users> user = usersRepository.findById(userID);
        if(user.isPresent() && user.get().getTypeOfUser()== UserType.collector){
            collector.setUser(user.get());
        }
        else{
            throw new UnprocessableEntity(NO_SUCH_COLLECTOR);
        }

        Long hotelId=collector.getId();
        Optional<Hotel> hotel= hotelRepository.findById(hotelId);

        if(hotel.isPresent() && hotel.get().getUser().getId()==userID && hotel.get().getBalance()>=collector.getAmount())
        {

            collector.setHotel(hotel.get());
        }
        else
        {
            throw new UnprocessableEntity(NO_SUCH_HOTEL);
        }

        collector.setApproved(false);
        collectorTransactionRepository.save(collector);

       return ServiceResponse.builder().status(Status.Success).build();


    }

    public ServiceResponse approveTransaction(Long approverId, Long collectorId, double amount, Date date,Long hotelId){
        Mapping mapping =mappingRepository.findByCollectorId(collectorId);
        if(mapping != null && mapping.getApproverId()==approverId)
        {
            Date enddate= new Date();
            enddate.after(date);
            CollectorTransaction collector=collectorTransactionRepository.findByCreatedAtBetweenAndUserIdAndHotelIdAndAmount(date,enddate,collectorId,hotelId,amount);
            if(collector.getApproved() == false)
            {
                collector.setApproved(true);
                collector.getHotel().setBalance(collector.getHotel().getBalance()-amount);
                collectorTransactionRepository.save(collector);
            }
            else
            {
                throw new UnprocessableEntity(ALSO_COLLECTOR_APPROVED);
            }
            return ServiceResponse.builder().status(Status.Success).build();
        }
        throw new UnprocessableEntity(NO_SUCH_MAPPING_DATA);
    }
}
