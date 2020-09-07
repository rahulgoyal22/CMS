package com.sample.cash.management.system.controller;

import com.sample.cash.management.system.entity.Hotel;
import com.sample.cash.management.system.model.Request.AddHotelRequest;
import com.sample.cash.management.system.model.Request.UpdateHotelRequest;
import com.sample.cash.management.system.model.Response.HotelResponse;
import com.sample.cash.management.system.model.Response.ServiceResponse;
import com.sample.cash.management.system.service.HotelService;
import com.sample.cash.management.system.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/hotels")
public class HotelController {

    @Autowired

    private HotelService hotelService;

    @Autowired
    private UsersService usersService;



    @GetMapping("/")
    public List<HotelResponse> getHotels() {
        return hotelService.getAllHotels();
    }



    @RequestMapping("/{id}")
    public HotelResponse getHotel(@PathVariable Long id) {

        return hotelService.getHotel(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ServiceResponse addHotel(@RequestBody AddHotelRequest addHotelRequest) {
        return hotelService.addHotel(addHotelRequest);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ServiceResponse updateHotel(@RequestBody UpdateHotelRequest updateHotelRequest, @PathVariable Long id) {

        return hotelService.updateHotel(updateHotelRequest,id);
    }





}