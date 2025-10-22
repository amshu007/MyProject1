package com.example.user.service.service.serviceImpl;

import com.example.user.service.entities.Hotel;
import com.example.user.service.entities.Rating;
import com.example.user.service.entities.User;
import com.example.user.service.exceptions.ResourceNotFoundException;
import com.example.user.service.repositories.UserRepository;
import com.example.user.service.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

//    private Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("Resource not found with id " + userId));

//        fetching rating of the above user from Rating Service
//        http://localhost:9092/ratings/users/0a630681-2df1-4b27-a833-06935840a1d7

        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);

//        ResponseEntity<Object> forEntity = restTemplate.getForEntity();
//        logger.info("" , forObject);

        System.out.println(ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {

//            ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity("http://localhost:9093/hotels/" + rating.getHotelId(), Hotel.class);
            ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
            rating.setHotel(hotelEntity.getBody());

            return rating;

        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;

    }


    @Override
    public User updateUser(String userId) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }
}
