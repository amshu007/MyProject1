package com.example.rating.services.impl;

import com.example.rating.entities.Hotel;
import com.example.rating.entities.Rating;
import com.example.rating.repositories.RatingRepository;
import com.example.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Rating create(Rating rating) {

        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public Rating getRatingByHotelId(String hotelId) {

        Rating ratingObj = ratingRepository.findByHotelId(hotelId);

        Hotel hotelObject = restTemplate.getForObject("http://localhost:9093/hotels/" + hotelId, Hotel.class);

//        ClientHttpRequestFactory requestFactory = restTemplate.getRequestFactory();
        ratingObj.setHotel(hotelObject);

        return ratingObj;

    }
}
