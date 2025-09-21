package com.personal.travel_planner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.travel_planner.repository.TripRepository;
import com.personal.travel_planner.entity.Trip;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;
    
    public Trip saveTrip(Trip trip){
        return tripRepository.save(trip);
    }

    public Trip getTripById(Integer id){
        return tripRepository.findById(id).orElseThrow();
    }

    public Iterable<Trip> getAllTrips(){
        return tripRepository.findAll();
    }

    public List<Trip> getTripsByUserId(Integer userId){
        return tripRepository.findByCreatedBy_Id(userId);
    }
}
