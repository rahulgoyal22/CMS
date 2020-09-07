package com.sample.cash.management.system.service;


import java.util.*;
import java.util.stream.Collectors;

import com.sample.cash.management.system.entity.Transaction;
import com.sample.cash.management.system.enums.Status;
import com.sample.cash.management.system.exception.UnprocessableEntity;
import com.sample.cash.management.system.model.Request.AddHotelRequest;
import com.sample.cash.management.system.model.Request.UpdateHotelRequest;
import com.sample.cash.management.system.model.Response.HotelResponse;
import com.sample.cash.management.system.model.Response.ServiceResponse;
import com.sample.cash.management.system.repository.TransactionRepository;
import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.cash.management.system.entity.Hotel;
import com.sample.cash.management.system.repository.HotelRepository;

import static com.sample.cash.management.system.constant.Constants.NO_SUCH_HOTEL;

@Service
public class HotelService {

	private ModelMapper modelMapper= new ModelMapper();
	@Autowired
	private  HotelRepository  hotelRepository;

	@Autowired
	private TransactionRepository transactionRepository;


	public List<HotelResponse> getAllHotels() {
		List<Hotel> hotels=hotelRepository.findAll();
		List<HotelResponse> hotelResponses = hotels.stream().map(hotel -> modelMapper.map(hotel,HotelResponse.class)).collect(Collectors.toList());

       return hotelResponses;
	}


	public ServiceResponse addHotel(AddHotelRequest addHotelRequest) {
		hotelRepository.save(Hotel.builder().managerId(addHotelRequest.getManagerId()).emailAddress(addHotelRequest.getEmailAddress()).password(addHotelRequest.getPassword()).balance(addHotelRequest.getBalance()).build());
		return ServiceResponse.builder().status(Status.Success).build();

	}



public HotelResponse getHotel(Long id) {
	        Optional<Hotel> hotel = hotelRepository.findById(id);
	        if (!hotel.isPresent()) {
			       throw new UnprocessableEntity(NO_SUCH_HOTEL);
	        }
	        else {
		         //  ModelMapper modelMapper= new ModelMapper();
		           HotelResponse hotelResponse=modelMapper.map(hotel.get(),HotelResponse.class);
		           return hotelResponse;

	         }

	}

	public ServiceResponse updateHotel(UpdateHotelRequest updateHotelRequest, Long id)
	{
		if(hotelRepository.findById(id).isPresent())
		{
			Hotel hotel =hotelRepository.findById(id).get();
			hotel.setEmailAddress(updateHotelRequest.getEmailAddress());
			hotel.setPassword(updateHotelRequest.getPassword());
			hotelRepository.save(hotel);
			return ServiceResponse.builder().status(Status.Success).build();
		}

		else
		{
			return null;
		}
	}

	public List<Transaction> getAllTransactions(Long id){
		return transactionRepository.findAllByHotelId(id);

	}
	public List<Transaction> getdailytransaction(Date start, Date end, Long id){
		return transactionRepository.findAllByCreatedAtBetweenAndHotelId(start,end,id);

	}


}

