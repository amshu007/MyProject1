package com.example.hotel.controllers;


import com.example.hotel.entities.Hotel;
import com.example.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){

        Hotel hotel1 = hotelService.createHotel(hotel);

        return new ResponseEntity<>(hotel1, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){

        List<Hotel> listHotels = hotelService.getAll();

        return ResponseEntity.ok(listHotels);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getAllHotels(@PathVariable String hotelId){

        Hotel hotel = hotelService.get(hotelId);

      return  ResponseEntity.status(HttpStatus.OK).body(hotel);
//        return ResponseEntity.ok(hotel);
    }





}
