package com.personal.travel_planner.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Step {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
    private String country;
    private int duration;
    private String hotel;
    @ManyToMany
    @JoinTable(
        name = "step_activities",
        joinColumns = @JoinColumn(name = "step_id"),
        inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private List<Activity> activities;

    public Step(){

    }
    public Step(String city, String country){
        this.city = city;
        this.country = country;
        this.duration = 1;
        this.hotel = "";
    }

    public String getCity(){
        return this.city;
    }

    public String getCountry(){
        return this.country;
    }

    public int getDuration(){
        return this.duration;
    }

    public String getHotel(){
        return this.hotel;
    }

    public List<Activity> getActivities(){
        return this.activities;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setDuration(int duration){
        this.duration = duration;
    }

    public void setHotel(String hotel){
        this.hotel = hotel;
    }

    public void addActivity(Activity activity){
        this.activities.add(activity);
    }
    public void removeActivity(Activity activity){
        this.activities.remove(activity);
    }
}
