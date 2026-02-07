package com.example.rating.services;

import com.example.rating.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating create(Rating rating);

    List<Rating> getRatings();

    List<Rating> getRatingByUserId(String userId);

    Rating getRatingByHotelId(String hotelId);


}
