package com.example.rating.services.impl;

import com.example.rating.entities.Hotel;
import com.example.rating.entities.Rating;
import com.example.rating.repositories.RatingRepository;
import com.example.rating.services.RatingService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
    @CircuitBreaker(name = "ratingService1" , fallbackMethod = "getAvailableHotel")
    public Rating getRatingByHotelId(String hotelId) {

        Rating ratingObj = ratingRepository.findByHotelId(hotelId);

        Hotel hotelObject = restTemplate.getForObject("http://localhost:9093/hotels/" + hotelId, Hotel.class);

//        ClientHttpRequestFactory requestFactory = restTemplate.getRequestFactory();
        ratingObj.setHotel(hotelObject);

        return ratingObj;

    }

    public Rating getAvailableHotel(Exception e){

        Rating ratingObj = ratingRepository.findByHotelId("1");
        Hotel hotel = new Hotel("5", "Dummy Hotel", "India", "Indian Hotel Service");

        ratingObj.setHotel(hotel);

        return ratingObj;
    }
}
