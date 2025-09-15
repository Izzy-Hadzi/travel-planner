package com.personal.travel_planner.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime birthday;
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
        name = "user_trips",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "trip_id")
    )
    private ArrayList<Trip> loggedTrips;
    private TravellerType type;

    public User(){
        
    }
    public User(String first, String last, String email, String password, LocalDateTime birthday){
        this.firstName = first;
        this.lastName = last;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.createdAt = LocalDateTime.now();
        this.loggedTrips = new ArrayList<Trip>();
        this.type = TravellerType.BASIC;
    }

    public int getID(){
        return this.id;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }
    public LocalDateTime getBirthday(){
        return this.birthday;
    }
    public LocalDateTime getCreatedAt(){
        return this.createdAt;
    }
    public ArrayList<Trip> getTrips(){
        return this.loggedTrips;
    }
    public TravellerType getType(){
        return this.type;
    }
    //Setters
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setBirthday(LocalDateTime birthday){
        this.birthday = birthday;
    }
    public void setType(TravellerType type){
        this.type = type;
    }

    public void addTrip(Trip newTrip){
        this.loggedTrips.add(newTrip);
    }

    public void removeTrip(Trip newTrip){
        this.loggedTrips.remove(newTrip);
    }

    public enum TravellerType {
        LUXURY, COMFORT, BASIC, BACKPACKER
    }
}
