package com.sample.cash.management.system.service;


import java.lang.reflect.Array;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sample.cash.management.system.entity.Transaction;
import com.sample.cash.management.system.model.HotelDto;
import com.sample.cash.management.system.model.HotelUpdateDto;
import com.sample.cash.management.system.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import com.sample.cash.management.system.entity.Hotel;
import com.sample.cash.management.system.repository.HotelRepository;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public HotelDto getHotel(Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if (hotel.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            HotelDto hotelDto = modelMapper.map(hotel.get(), HotelDto.class);
            return hotelDto;

        } else {
            return null;
        }
    }

    public HotelDto updateHotel(HotelUpdateDto hotelUpdateDto, Long id) {


        Optional<Hotel> hotel = hotelRepository.findById(id);
        if (hotel.isPresent()) {
            Hotel h = hotel.get();
            if (!hotelUpdateDto.getEmailAddress().isEmpty()) {
                h.setEmailAddress(hotelUpdateDto.getEmailAddress());
            }
            if (!hotelUpdateDto.getPassword().isEmpty()) {
                h.setPassword(hotelUpdateDto.getPassword());
            }
            ModelMapper modelMapper = new ModelMapper();
            HotelDto hotelDto = modelMapper.map(h, HotelDto.class);
            hotelRepository.save(h);
            return hotelDto;
        } else {
            return null;
        }
//		return hotelRepository.save(hotel);
    }

    public List<Transaction> getAllTransactions(Long id) {
        return transactionRepository.findAllByHotelId(id);

    }

    public List<Transaction> getdailytransaction(Date start, Date end, Long id) {
        //    return transactionRepository.findAllByCreatedAtBetween(start, end);
        return transactionRepository.findAllByCreatedAtBetweenAndHotelId(start, end, id);

    }
}

