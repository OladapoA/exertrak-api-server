package com.awoniyitechnologies.exertrakapiserver.controllers;

import java.util.List;

import com.awoniyitechnologies.exertrakapiserver.media.RoutineExerciseResource;
import com.awoniyitechnologies.exertrakapiserver.media.RoutineExerciseResourceBuilder;
import com.awoniyitechnologies.exertrakapiserver.media.RoutineResource;
import com.awoniyitechnologies.exertrakapiserver.media.RoutineResourceBuilder;
import com.awoniyitechnologies.exertrakapiserver.models.Routine;
import com.awoniyitechnologies.exertrakapiserver.models.RoutineExercise;
import com.awoniyitechnologies.exertrakapiserver.services.RoutineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/routines")
public class RoutineController {
    
    private RoutineService routineService;
    private RoutineResourceBuilder routineResourceBuilder;
    private RoutineExerciseResourceBuilder routineExerciseResourceBuilder;

    @Autowired
    public RoutineController(RoutineService routineService, RoutineResourceBuilder routineResourceBuilder,
            RoutineExerciseResourceBuilder routineExerciseResourceBuilder) {
        this.routineService = routineService;
        this.routineResourceBuilder = routineResourceBuilder;
        this.routineExerciseResourceBuilder = routineExerciseResourceBuilder;
    }
    
    @GetMapping
    public List<RoutineResource> getAllRoutines() {
        List<Routine> routines = routineService.getAllRoutines();
        return routineResourceBuilder.toResource(routines);
    }

    @GetMapping
    @RequestMapping("{id}")
    public RoutineResource getRoutine(@PathVariable Long id) {
        Routine routine = routineService.getRoutine(id);
        return routineResourceBuilder.toResource(routine);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public RoutineResource updateRoutine(@PathVariable Long id, @RequestBody Routine routine) {
        Routine updatedRoutine = routineService.updateRoutine(id, routine);
        return routineResourceBuilder.toResource(updatedRoutine);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void deleteRoutine(@PathVariable Long id) {
        routineService.deleteRoutine(id);
    }

    @GetMapping
    @RequestMapping("{id}/routine_exercises")
    public List<RoutineExerciseResource> getAllExercisesForRoutine(@PathVariable Long id) {
        List<RoutineExercise> routineExercises = routineService.getAllExercisesForRoutine(id);
        return routineExerciseResourceBuilder.toResource(routineExercises);
    }

    @RequestMapping(path = "{routine_id}/exercise/{exercise_id}", method = RequestMethod.POST)
    public RoutineExerciseResource createRoutineExercise(@PathVariable Long routine_id, @PathVariable Long exercise_id,
            @RequestBody RoutineExercise routineExercise) {
        RoutineExercise newRoutineExercise = routineService.createRoutineExercise(routine_id, exercise_id, routineExercise);
        return routineExerciseResourceBuilder.toResource(newRoutineExercise);
    }
}
