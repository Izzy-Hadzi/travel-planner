package com.personal.travel_planner.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.travel_planner.entity.Trip;
import com.personal.travel_planner.entity.User;
import com.personal.travel_planner.service.TripService;
import com.personal.travel_planner.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TripService tripService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        Optional<User> triedUser = userService.getUser(id);
        return triedUser.orElseThrow();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/{userId}/trips")
    public List<Trip> getUserTrips(@PathVariable Integer userId) {
        return userService.getUserTrips(userId);
    }

    @PostMapping("/{userId}/trips")
    public Trip createTripForUser(@PathVariable Integer userId, @RequestBody Trip trip) {
        User user = userService.getUser(userId).orElseThrow();
        tripService.saveTrip(trip);
        trip.setCreatedBy(user);
        return tripService.saveTrip(trip);
    }

    @PostMapping("/{userId}/saved-trips/{tripId}")
    public User saveTrip(@PathVariable Integer userId, @PathVariable Integer tripId) {
        User user = userService.getUser(userId).orElseThrow();
        Trip trip = tripService.getTripById(tripId);
    
        user.getLoggedTrips().add(trip);
        return userService.saveUser(user);
}
}
