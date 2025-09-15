package com.personal.travel_planner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.personal.travel_planner.entity.Trip;

@Repository
public interface TripRepository extends CrudRepository<Trip, ID>{

}
