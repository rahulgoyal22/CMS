package com.sample.cash.management.system.controller;

import com.sample.cash.management.system.entity.Hotel;
import com.sample.cash.management.system.enums.Status;
import com.sample.cash.management.system.model.Request.AddHotelRequest;
import com.sample.cash.management.system.model.Request.UpdateHotelRequest;
import com.sample.cash.management.system.model.Response.HotelResponse;
import com.sample.cash.management.system.model.Response.ServiceResponse;
import com.sample.cash.management.system.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/hotels")
public class HotelController {

    @Autowired

    private HotelService hotelService;


    @GetMapping(value = "/")
    public List<HotelResponse> getHotels() {
        return hotelService.getAllHotels();
    }


    @GetMapping(value = "/{id}")
    public HotelResponse getHotel(@PathVariable(name = "id") Long id) {

        return hotelService.getHotel(id);
    }

    @PostMapping(value = "/")
    public ServiceResponse addHotel(@Valid @RequestBody AddHotelRequest addHotelRequest, Errors errors) {
        if (errors.hasErrors()) {
            return ServiceResponse.builder().status(Status.Failure).message(errors.getFieldError().getField() + " " + errors.getFieldError().getDefaultMessage()).build();
        }
        return hotelService.addHotel(addHotelRequest);
    }

    @PutMapping(value = "/{id}")
    public ServiceResponse updateHotel(@RequestBody UpdateHotelRequest updateHotelRequest, @PathVariable(name = "id") Long id) {

        return hotelService.updateHotel(updateHotelRequest, id);
    }

    @GetMapping(value = "/auth-hotel")
    public HotelResponse authHotel(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        return hotelService.authHotel(email, password);
    }

}