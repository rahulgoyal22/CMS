package com.sample.cash.management.system.service;

import com.sample.cash.management.system.entity.Collector;
import com.sample.cash.management.system.entity.Hotel;
import com.sample.cash.management.system.entity.Users;
import com.sample.cash.management.system.repository.HotelRepository;
import com.sample.cash.management.system.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.cash.management.system.repository.CollectorRepository;

import java.util.Optional;

@Service

public class CollectorService {

    @Autowired
    CollectorRepository collectorRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    HotelRepository hotelRepository;

    public Collector collectorTransaction(Collector collector,Long userID){
        Optional<Users> user = usersRepository.findById(userID);
        if(user.isPresent() && user.get().getTypeOfUser()== Users.userTypes.collector){
            collector.setUser(user.get());
        }
        else{
            return null;
        }

        Long hotelId=collector.getId();
        Optional<Hotel> hotel= hotelRepository.findById(hotelId);

        if(hotel.isPresent() && hotel.get().getUser().getId()==userID)
        {

            collector.setHotel(hotel.get());
        }
        else
        {
            return null;
        }

        collector.setApproved(false);

        return collectorRepository.save(collector);


    }
}
