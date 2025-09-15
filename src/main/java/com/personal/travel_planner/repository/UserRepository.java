package com.personal.travel_planner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personal.travel_planner.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    
}
