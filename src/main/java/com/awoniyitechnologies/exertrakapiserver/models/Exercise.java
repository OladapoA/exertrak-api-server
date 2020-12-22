package com.awoniyitechnologies.exertrakapiserver.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "exercises")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exercise_id;
    
    private String name;
    private String description;

    @OneToOne
    @JoinColumn(name = "variation_parent")
    private Exercise parent;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany
    @JoinTable(
        name = "exercise_muscle_groups",
        joinColumns = @JoinColumn(name = "exercise_id"),
        inverseJoinColumns = @JoinColumn(name = "muscle_group_id")
    )
    private List<MuscleGroup> muscle_groups;

    public Long getExercise_id() { return exercise_id; }
    public void setExercise_id(Long exercise_id) { this.exercise_id = exercise_id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Exercise getParent() { return parent; }
    public void setParent(Exercise parent) { this.parent = parent; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<MuscleGroup> getMuscle_groups() { return muscle_groups; }
    public void setMuscle_groups(List<MuscleGroup> muscle_groups) { this.muscle_groups = muscle_groups; }
}
