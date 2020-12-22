package com.awoniyitechnologies.exertrakapiserver.controllers;

import java.util.List;

import com.awoniyitechnologies.exertrakapiserver.media.ExerciseResource;
import com.awoniyitechnologies.exertrakapiserver.media.ExerciseResourceBuilder;
import com.awoniyitechnologies.exertrakapiserver.media.MuscleGroupResource;
import com.awoniyitechnologies.exertrakapiserver.media.MuscleGroupResourceBuilder;
import com.awoniyitechnologies.exertrakapiserver.models.Exercise;
import com.awoniyitechnologies.exertrakapiserver.models.MuscleGroup;
import com.awoniyitechnologies.exertrakapiserver.services.MuscleGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/muscle_groups")
public class MuscleGroupController {
    
    private MuscleGroupService muscleGroupService;
    private MuscleGroupResourceBuilder muscleGroupResourceBuilder;
    private ExerciseResourceBuilder exerciseResourceBuilder;

    @Autowired
    public MuscleGroupController(MuscleGroupService muscleGroupService,
            MuscleGroupResourceBuilder muscleGroupResourceBuilder, ExerciseResourceBuilder exerciseResourceBuilder){
        this.muscleGroupService = muscleGroupService;
        this.muscleGroupResourceBuilder = muscleGroupResourceBuilder;
        this.exerciseResourceBuilder = exerciseResourceBuilder;
    }

    @GetMapping
    public List<MuscleGroupResource> getAllMuscleGroup(){
        List<MuscleGroup> muscleGroups = muscleGroupService.getAllMuscleGroups();
        return muscleGroupResourceBuilder.toResource(muscleGroups);
    }

    @GetMapping
    @RequestMapping("{id}")
    public MuscleGroupResource getMuscleGroup(@PathVariable Long id){
        MuscleGroup muscleGroup = muscleGroupService.getMuscleGroup(id);
        return muscleGroupResourceBuilder.toResource(muscleGroup);
    }

    @GetMapping
    @RequestMapping("{id}/exercises")
    public List<ExerciseResource> getExercisesWithMuscleGroup(@PathVariable Long id){
        List<Exercise> exercises = muscleGroupService.getExercisesWithMuscleGroup(id);
        return exerciseResourceBuilder.toResource(exercises);
    } 
}
