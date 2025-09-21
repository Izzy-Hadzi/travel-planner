package com.personal.travel_planner.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Trip {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne 
    @JoinColumn(name = "created_by_id")
    private User createdBy;
    private LocalDateTime createdAt;
    //@ManyToMany
    //@JoinTable(
    //    name = "saved_users",
    //    joinColumns = @JoinColumn(name = "user_id"),
    //    inverseJoinColumns = @JoinColumn(name = "trip_id")
    //)
    //private ArrayList<User> savedBy;
    private int duration;
    @ManyToMany
    @JoinTable(
        name = "trip_steps",
        joinColumns = @JoinColumn(name = "trip_id"),
        inverseJoinColumns = @JoinColumn(name = "step_id")
    )
    private List<Step> steps;

    public Trip(){

    }
    public Trip(User user){
        this.createdBy = user;
        this.createdAt = LocalDateTime.now();
        //this.savedBy = new ArrayList<User>();
        this.duration = 1;
    }

    public User getCreatedBy(){
        return this.createdBy;
    }

    //public ArrayList<User> getSavedBy(){
    //    return this.savedBy;
    //}

    public int getDuration(){
        return this.duration;
    }

    public List<Step> getSteps(){
        return this.steps;
    }

    public void setDuration(int newduration){
        this.duration = newduration;
    }

    public void setCreatedBy(User user){
        this.createdBy = user;
    }

    //public void addSave(User user){
    //    this.savedBy.add(user);
    //}

    //public void removeSave(User user){
    //    this.savedBy.remove(user);
    //}

    public void addStep(Step step){
        this.steps.add(step);
    }
    public void removeStep(Step step){
        this.steps.remove(step);
    }
}
