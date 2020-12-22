package com.awoniyitechnologies.exertrakapiserver.media;

import java.util.ArrayList;
import java.util.List;

import com.awoniyitechnologies.exertrakapiserver.models.Routine;
import com.awoniyitechnologies.exertrakapiserver.services.RoutineExerciseService;

import org.springframework.stereotype.Component;

@Component
public class RoutineResourceBuilder {

    private RoutineExerciseService routineExerciseService;

    public RoutineResourceBuilder(RoutineExerciseService routineExerciseService) {
        this.routineExerciseService = routineExerciseService;
    }
    
    public RoutineResource toResource(Routine routine) {
        RoutineResource resource = new RoutineResource();

        resource.setUser_id(routine.getUser().getUser_id());
        resource.setRoutine_id(routine.getRoutine_id());
        resource.setIs_public(routine.getIs_public());
        resource.setName(routine.getName());
        resource.setDescription(routine.getDescription());
        resource.setCreated_at(routine.getCreated_at());
        resource.setNo_of_exercises(routineExerciseService.getAllExercisesForRoutine(routine).size());

        return resource;
    }

    public List<RoutineResource> toResource(List<Routine> routines) {
        List<RoutineResource> resource = new ArrayList<RoutineResource>();

        for (Routine routine : routines) {
            resource.add(this.toResource(routine));
        }

        return resource;
    }
}
