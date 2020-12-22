package com.awoniyitechnologies.exertrakapiserver.repositories;

import java.util.List;

import com.awoniyitechnologies.exertrakapiserver.models.Routine;
import com.awoniyitechnologies.exertrakapiserver.models.RoutineExercise;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineExerciseRepository extends JpaRepository<RoutineExercise, Long> {
    List<RoutineExercise> findByRoutine(Routine routine);
}
