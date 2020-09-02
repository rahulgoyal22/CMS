package com.sample.cash.management.system.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.sample.cash.management.system.entity.Hotel;
import com.sample.cash.management.system.entity.Transaction;
import com.sample.cash.management.system.repository.UsersRepository;
import com.sample.cash.management.system.service.HotelService;
import com.sample.cash.management.system.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.List;

@RestController
//@RequestMapping(value="",produces="application/json")
public class HotelController {

	@Autowired
	
	private HotelService hotelService;

	@Autowired
	private UsersService usersService;
		
	@GetMapping("/hotels")
	public List<Hotel>  getallHotels() {
//		ObjectMapper objectMapper= new ObjectMapper();
//		List<Hotel> h=hotelService.getAllHotels();
//		String s=objectMapper.writeValueAsString(h);
		return hotelService.getAllHotels();
		
//	  return ResponseEntity.ok(hotelService.getAllHotels());
	}
	@RequestMapping("/hotels/{id}")
	public Hotel getHotel(@PathVariable Long id) {
		return  hotelService.getHotel(id);
	}

	@RequestMapping(method=RequestMethod.POST,value="/hotels")
	public Hotel addHotel(@RequestBody Hotel hotel)
	{
		hotel.setUser(usersService.getUser(hotel.getId()));
		return hotelService.addHotel(hotel);
	}

    @RequestMapping(method=RequestMethod.PUT,value="/hotels/{id}")
	public Hotel updateHotel (@RequestBody Hotel hotel, @PathVariable Long id)
	{
		hotel.setId(id);
		Hotel h = hotelService.getHotel(id);
		if( h!= null) {
			hotel.setCreatedAt(h.getCreatedAt());
			return hotelService.updateHotel(hotel);
		}else {
			return null;
		}
	}


	@RequestMapping("/hotel/{id}/transaction")
	public List<Transaction> getAllTransactions(@PathVariable Long id){
		return hotelService.getAllTransactions(id);
	}

	@GetMapping("/hotel/{id}/dailytransaction")
	public List<Transaction> getAllByDatetimeBetween(@PathVariable Long id,
			@RequestParam("startdate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startdate,
			@RequestParam("enddate") @DateTimeFormat(pattern="yyyy-MM-dd") Date enddate) {

		return hotelService.getdailytransaction(startdate, enddate, id);
	}


}