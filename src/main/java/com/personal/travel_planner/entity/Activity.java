package com.personal.travel_planner.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Activity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String location;
    private ActivityType type;

    public Activity(){
        
    }
    public Activity(String name, String location){
        this.name = name;
        this.location = location;
        this.type = ActivityType.OTHER;
    }

    public String getName(){
        return this.name;
    }
    public String getLocation(){
        return this.location;
    }
    public ActivityType getType(){
        return this.type;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public void setType(ActivityType type){
        this.type = type;
    }
    public enum ActivityType {
        EXERCISE, CULTURE, FOOD, OTHER
    }
}
