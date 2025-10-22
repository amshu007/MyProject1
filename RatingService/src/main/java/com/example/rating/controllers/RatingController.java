package com.example.rating.controllers;


import com.example.rating.entities.Rating;
import com.example.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){

        String randomUserId = UUID.randomUUID().toString();
        rating.setRatingId(randomUserId);
        Rating rating1 = ratingService.create(rating);

        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);

    }

    @GetMapping()
    public ResponseEntity<List<Rating>> getAllRatings(){

        List<Rating> ratings = ratingService.getRatings();

        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){

        List<Rating> ratings = ratingService.getRatingByUserId(userId);

        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){

        List<Rating> ratings = ratingService.getRatingByUserId(hotelId);

        return ResponseEntity.ok(ratings);
    }


}
