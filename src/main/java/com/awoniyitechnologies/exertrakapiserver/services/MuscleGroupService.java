package com.awoniyitechnologies.exertrakapiserver.services;

import java.util.List;

import com.awoniyitechnologies.exertrakapiserver.models.Exercise;
import com.awoniyitechnologies.exertrakapiserver.models.MuscleGroup;
import com.awoniyitechnologies.exertrakapiserver.repositories.MuscleGroupRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MuscleGroupService {

    MuscleGroupRepository muscleGroupRepository;
    ExerciseService exerciseService;
    
    public MuscleGroupService(MuscleGroupRepository muscleGroupRepository, ExerciseService exerciseService) {
        this.muscleGroupRepository = muscleGroupRepository;
        this.exerciseService = exerciseService;
    }

    public List<MuscleGroup> getAllMuscleGroups(){
        return muscleGroupRepository.findAll();
    }

    public MuscleGroup getMuscleGroup(Long id){
        return muscleGroupRepository.getOne(id);
    }

    public List<Exercise> getExercisesWithMuscleGroup(Long id){
        MuscleGroup muscleGroup = getMuscleGroup(id);
        return muscleGroup.getExercises();
    } 
    
}
