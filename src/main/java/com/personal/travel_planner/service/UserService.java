package com.personal.travel_planner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.travel_planner.entity.Trip;
import com.personal.travel_planner.entity.User;
import com.personal.travel_planner.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TripService tripService;
    
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUser(Integer id) {
        //if (userRepository.existsById(id)) {
            return userRepository.findById(id);
        //}
        //return null;
    }
    
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public List<Trip> getUserTrips(Integer userId) {
        return tripService.getTripsByUserId(userId);
    }
}
