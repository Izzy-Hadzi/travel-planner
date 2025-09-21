package com.personal.travel_planner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personal.travel_planner.entity.Trip;

@Repository
public interface TripRepository extends CrudRepository<Trip, Integer>{
    List<Trip> findByCreatedBy_Id(Integer userId);
}
