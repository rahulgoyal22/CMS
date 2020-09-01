package com.sample.cash.management.system.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.cash.management.system.entity.Hotel;
import com.sample.cash.management.system.repository.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	private  HotelRepository  hotelRepository;
	
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
	
}

