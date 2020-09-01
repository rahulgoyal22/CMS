package com.sample.cash.management.system.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.cash.management.system.entity.Hotel;
import com.sample.cash.management.system.service.HotelService;

@RestController
//@RequestMapping(value="",produces="application/json")
public class HotelController {

	@Autowired
	
	private HotelService hotelService;
		
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

}