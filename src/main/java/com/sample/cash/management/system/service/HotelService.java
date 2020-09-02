package com.sample.cash.management.system.service;


import java.lang.reflect.Array;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sample.cash.management.system.entity.Transaction;
import com.sample.cash.management.system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import com.sample.cash.management.system.entity.Hotel;
import com.sample.cash.management.system.repository.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	private  HotelRepository  hotelRepository;

	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<Hotel> getAllHotels() {
		  return hotelRepository.findAll(); 
	}
	
	public Hotel addHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	public Hotel getHotel(Long id) {
		Optional<Hotel> hotel = hotelRepository.findById(id);
		if (hotel.isPresent()) 
		{
		    return hotel.get();
		} 
		else
		{
		    return null;
		}	
	}

	public Hotel updateHotel(Hotel hotel)
	{
		return hotelRepository.save(hotel);
	}

	public List<Transaction> getAllTransactions(Long id){
		return transactionRepository.findAllByHotelId(id);

	}
	public List<Transaction> getdailytransaction(Date start, Date end, Long id){
    //    return transactionRepository.findAllByCreatedAtBetween(start, end);
		return transactionRepository.findAllByCreatedAtBetweenAndHotelId(start,end,id);

	}
}

