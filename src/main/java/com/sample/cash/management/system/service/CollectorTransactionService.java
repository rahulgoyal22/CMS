package com.sample.cash.management.system.service;


import com.sample.cash.management.system.entity.CollectorTransaction;
import com.sample.cash.management.system.entity.Hotel;
import com.sample.cash.management.system.entity.Mapping;
import com.sample.cash.management.system.entity.Users;
import com.sample.cash.management.system.enums.UserType;
import com.sample.cash.management.system.repository.CollectorTransactionRepository;
import com.sample.cash.management.system.repository.HotelRepository;
import com.sample.cash.management.system.repository.MappingRepository;
import com.sample.cash.management.system.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.Date;
import java.util.Optional;

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


    public CollectorTransaction collectorTransaction(CollectorTransaction collector,Long userID){
        Optional<Users> user = usersRepository.findById(userID);
        if(user.isPresent() && user.get().getTypeOfUser()== UserType.collector){
            collector.setUser(user.get());
        }
        else{
            return null;
        }


        Long hotelId=collector.getId();

        Optional<Hotel> hotel= hotelRepository.findById(hotelId);

        if(hotel.isPresent() && hotel.get().getUser().getId()==userID && hotel.get().getBalance()>=collector.getAmount())
        {

            collector.setHotel(hotel.get());
        }
        else
        {
            return null;
        }

        collector.setApproved(false);

        return collectorTransactionRepository.save(collector);


    }

    public CollectorTransaction approveTransaction(Long approverId, Long collectorId, double amount, Date date,Long hotelId){
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
                return null;
            }
            return collector;
        }
        return null;
    }
}
