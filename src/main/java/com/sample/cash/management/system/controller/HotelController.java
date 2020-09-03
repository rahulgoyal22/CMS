package com.sample.cash.management.system.controller;

import com.sample.cash.management.system.entity.Hotel;
import com.sample.cash.management.system.entity.Transaction;
import com.sample.cash.management.system.model.HotelDto;
import com.sample.cash.management.system.model.HotelUpdateDto;
import com.sample.cash.management.system.service.HotelService;
import com.sample.cash.management.system.service.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/hotels")
public class HotelController {

    @Autowired

    private HotelService hotelService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/")
    public List<Hotel> getallHotels() {
//		ObjectMapper objectMapper= new ObjectMapper();
//		List<Hotel> h=hotelService.getAllHotels();
//		String s=objectMapper.writeValueAsString(h);
        return hotelService.getAllHotels();

//	  return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @RequestMapping("/{id}")
    public HotelDto getHotel(@PathVariable Long id) {

        return hotelService.getHotel(id);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public Hotel addHotel(@RequestBody Hotel hotel) {
        hotel.setUser(usersService.getUser(hotel.getId()));
        return hotelService.addHotel(hotel);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public HotelDto updateHotel(@RequestBody HotelUpdateDto hotelUpdateDto, @PathVariable Long id) {

        return hotelService.updateHotel(hotelUpdateDto,id);
    }





}